package com.hpfxd.discordcommands.server;

import com.hpfxd.discordcommands.CommandManager;

import java.util.Objects;

public class ErrorResponse {
    public static ErrorResponse of(int code, Throwable e) {
        if (CommandManager.DEBUG_LOGGING) {
            CommandManager.debug("ErrorResponse created, stacktrace:");
            e.printStackTrace();
        }

        return new ErrorResponse(code, e.getClass().getSimpleName(), e.getMessage());
    }

    private final int code;
    private final String error;
    private final String cause;

    public ErrorResponse(int code, String error, String cause) {
        this.code = code;
        this.error = error;
        this.cause = cause;
    }

    public int getCode() {
        return code;
    }

    public String getError() {
        return error;
    }

    public String getCause() {
        return cause;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ErrorResponse that = (ErrorResponse) o;
        return code == that.code && Objects.equals(error, that.error) && Objects.equals(cause, that.cause);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, error, cause);
    }

    @Override
    public String toString() {
        return "ErrorResponse{" +
                "code=" + code +
                ", error='" + error + '\'' +
                ", cause='" + cause + '\'' +
                '}';
    }
}
