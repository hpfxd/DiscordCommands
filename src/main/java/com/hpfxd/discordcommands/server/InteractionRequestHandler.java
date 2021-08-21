package com.hpfxd.discordcommands.server;

import com.hpfxd.discordcommands.CommandManager;
import com.hpfxd.discordcommands.DiscordJsonMapper;
import com.hpfxd.discordcommands.data.interaction.Interaction;
import com.hpfxd.discordcommands.data.interaction.callback.InteractionCallback;
import com.hpfxd.discordcommands.interaction.InteractionVerifier;
import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class InteractionRequestHandler implements HttpHandler {
    private final CommandManager commandManager;
    private final InteractionVerifier interactionVerifier;

    public InteractionRequestHandler(CommandManager commandManager, InteractionVerifier interactionVerifier) {
        this.commandManager = commandManager;
        this.interactionVerifier = interactionVerifier;
    }

    @Override
    public void handle(HttpExchange exchange) {
        Headers responseHeaders = exchange.getResponseHeaders();
        responseHeaders.add("Server", "DiscordCommands");
        responseHeaders.add("Content-Type", "application/json");

        HttpContext ctx = new HttpContext(exchange);

        try(InputStream input = exchange.getRequestBody()) {
            String body = this.readString(input);

            Headers headers = exchange.getRequestHeaders();

            if (!this.interactionVerifier.verify(
                    headers.getFirst("X-Signature-Ed25519"),
                    headers.getFirst("X-Signature-Timestamp"),
                    body)) {
                ctx.error(401, new IllegalAccessException("Invalid signature."));
            }

            CommandManager.debug("Received interaction from Discord: " + body);

            Interaction interaction = DiscordJsonMapper.getMapper().readValue(body, Interaction.class);
            InteractionCallback callback = this.commandManager.onInteraction(interaction);

            if (callback == null) ctx.error(500, new NullPointerException());
            ctx.success(callback);
        } catch (ErrorResponseException e) {
            ctx.doResponse(e.getResponse());
        } catch (Exception e) {
            ctx.doResponse(ErrorResponse.of(500, e));
        }
    }

    private String readString(InputStream inputStream) throws IOException {
        ByteArrayOutputStream into = new ByteArrayOutputStream();
        byte[] buf = new byte[4096];
        for (int n; 0 < (n = inputStream.read(buf));) {
            into.write(buf, 0, n);
        }
        into.close();
        return into.toString(StandardCharsets.UTF_8);
    }
}
