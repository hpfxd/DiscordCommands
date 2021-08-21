package com.hpfxd.discordcommands.server;

import java.io.IOException;

public class ErrorResponseException extends IOException {
    private final ErrorResponse response;

    public ErrorResponseException(ErrorResponse response) {
        this.response = response;
    }

    public ErrorResponse getResponse() {
        return response;
    }
}
