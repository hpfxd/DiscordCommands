package com.hpfxd.discordcommands.data.channel.message.activity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum ActivityType {
    JOIN,
    SPECTATE,
    LISTEN,
    JOIN_REQUEST
    ;

    @JsonValue
    public int toValue() {
        return this.ordinal() + 1;
    }

    @JsonCreator
    public static ActivityType fromValue(int id) {
        return values()[id - 1];
    }
}
