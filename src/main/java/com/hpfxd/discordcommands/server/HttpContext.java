package com.hpfxd.discordcommands.server;

import com.hpfxd.discordcommands.CommandManager;
import com.hpfxd.discordcommands.DiscordJsonMapper;
import com.sun.net.httpserver.HttpExchange;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

public class HttpContext {
    private final HttpExchange exchange;
    private boolean responded = false;

    public HttpContext(HttpExchange exchange) {
        this.exchange = exchange;
    }

    public void success(Object response) {
        try {
            this.doResponse(200, DiscordJsonMapper.getMapper().writeValueAsString(response));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void error(int code, Throwable e) throws ErrorResponseException {
        throw new ErrorResponseException(ErrorResponse.of(code, e));
    }

    public void doResponse(ErrorResponse response) {
        try {
            this.doResponse(response.getCode(), DiscordJsonMapper.getMapper().writeValueAsString(response));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void doResponse(int code, String content) throws IOException {
        if (this.responded) throw new IllegalStateException("Already responded to this request!");
        this.responded = true;

        CommandManager.debug("Sending response to interaction with code " + code + ": " + content);

        byte[] b = content.getBytes(StandardCharsets.UTF_8);

        this.exchange.sendResponseHeaders(code, b.length);
        try (OutputStream out = this.exchange.getResponseBody()) {
            out.write(b);
        }
    }
}
