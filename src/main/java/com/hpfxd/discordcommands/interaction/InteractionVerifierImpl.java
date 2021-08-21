package com.hpfxd.discordcommands.interaction;

import org.jetbrains.annotations.NotNull;
import software.pando.crypto.nacl.Crypto;

import java.nio.charset.StandardCharsets;
import java.security.PublicKey;

/**
 * {@link InteractionVerifier} implementation using the <a href="https://github.com/NeilMadden/salty-coffee">salty-coffee</a> library.
 */
public class InteractionVerifierImpl implements InteractionVerifier {
    protected final @NotNull PublicKey publicKey;

    public InteractionVerifierImpl(@NotNull PublicKey publicKey) {
        this.publicKey = publicKey;
    }

    public InteractionVerifierImpl(@NotNull String publicKey) {
        this.publicKey = Crypto.signingPublicKey(this.hexStringToByteArray(publicKey));
    }

    public boolean verify(@NotNull String signature, @NotNull String timestamp, @NotNull String body) {
        byte[] data = (timestamp + body).getBytes(StandardCharsets.UTF_8);

        return Crypto.signVerify(this.publicKey, data, this.hexStringToByteArray(signature));
    }

    private byte[] hexStringToByteArray(String s) {
        int len = s.length();
        byte[] data = new byte[len / 2];
        for (int i = 0; i < len; i += 2) {
            data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4)
                    + Character.digit(s.charAt(i+1), 16));
        }
        return data;
    }
}
