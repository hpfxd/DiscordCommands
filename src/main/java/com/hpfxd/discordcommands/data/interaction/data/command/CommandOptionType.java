package com.hpfxd.discordcommands.data.interaction.data.command;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * <a href="https://discord.com/developers/docs/interactions/application-commands#application-command-object-application-command-option-type">See Discord Documentation</a>
 */
public enum CommandOptionType {
    SUB_COMMAND,
    SUB_COMMAND_GROUP,
    STRING,
    INTEGER,
    BOOLEAN,
    USER,
    CHANNEL,
    ROLE,
    MENTIONABLE,
    NUMBER
    ;

    @JsonValue
    public int toValue() {
        return this.ordinal() + 1;
    }

    @JsonCreator
    public static CommandOptionType fromValue(int id) {
        return values()[id + 1];
    }
}
