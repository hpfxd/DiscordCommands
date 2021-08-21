package com.hpfxd.discordcommands.data.channel.message.component;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum ButtonStyle {
    PRIMARY,
    SECONDARY,
    SUCCESS,
    DANGER,
    LINK
    ;

    @JsonValue
    public int toValue() {
        return this.ordinal() + 1;
    }

    @JsonCreator
    public static ButtonStyle fromValue(int id) {
        return values()[id - 1];
    }
}
