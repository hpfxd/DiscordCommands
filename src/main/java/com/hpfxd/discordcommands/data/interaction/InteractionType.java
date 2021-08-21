package com.hpfxd.discordcommands.data.interaction;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum InteractionType {
    PING,
    APPLICATION_COMMAND,
    MESSAGE_COMPONENT
    ;

    @JsonValue
    public int toValue() {
        return this.ordinal() + 1;
    }

    @JsonCreator
    public static InteractionType fromValue(int id) {
        return values()[id - 1];
    }
}
