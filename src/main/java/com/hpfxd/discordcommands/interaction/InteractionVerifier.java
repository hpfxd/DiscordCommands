package com.hpfxd.discordcommands.interaction;

import org.jetbrains.annotations.NotNull;

import java.security.PublicKey;

/**
 * An interaction verifier is responsible for verifying that HTTP requests are truly received from Discord.
 */
public interface InteractionVerifier {
    static InteractionVerifier of(@NotNull PublicKey publicKey) {
        return new InteractionVerifierImpl(publicKey);
    }

    static InteractionVerifier of(@NotNull String publicKey) {
        return new InteractionVerifierImpl(publicKey);
    }

    boolean verify(@NotNull String signature, @NotNull String timestamp, @NotNull String body);
}
