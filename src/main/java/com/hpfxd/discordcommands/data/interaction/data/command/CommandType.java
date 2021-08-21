package com.hpfxd.discordcommands.data.interaction.data.command;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum CommandType {
    /**
     * Slash commands; a text-based command that shows up when a user types {@code /}
     */
    CHAT_INPUT,

    /**
     * A UI-based command that shows up when you right click or tap on a user
     */
    USER,

    /**
     * A UI-based command that shows up when you right click or tap on a message
     */
    MESSAGE
    ;

    @JsonValue
    public int toValue() {
        return this.ordinal() + 1;
    }

    @JsonCreator
    public static CommandType fromValue(int id) {
        return values()[id - 1];
    }
}
