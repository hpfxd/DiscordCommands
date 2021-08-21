package com.hpfxd.discordcommands.server;

import com.hpfxd.discordcommands.CommandManager;
import com.hpfxd.discordcommands.interaction.InteractionVerifier;
import com.sun.net.httpserver.HttpServer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.concurrent.Executor;

public class CommandHttpServer {
    private final @NotNull HttpServer httpServer;

    public CommandHttpServer(@NotNull CommandManager commandManager,
                             @NotNull InetSocketAddress address,
                             @NotNull InteractionVerifier verifier,
                             @Nullable Executor executor) throws IOException {
        this.httpServer = HttpServer.create(address, 0);

        this.httpServer.createContext("/interaction", new InteractionRequestHandler(commandManager, verifier));

        this.httpServer.setExecutor(executor);
        this.httpServer.start();
    }

    public @NotNull HttpServer getHttpServer() {
        return httpServer;
    }

    public void shutdown() {
        this.httpServer.stop(5);
    }
}
