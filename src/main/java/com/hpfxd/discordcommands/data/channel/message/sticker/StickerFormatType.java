package com.hpfxd.discordcommands.data.channel.message.sticker;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum StickerFormatType {
    PNG,
    APNG,
    LOTTIE
    ;

    @JsonValue
    public int toValue() {
        return this.ordinal() + 1;
    }

    @JsonCreator
    public static StickerFormatType fromValue(int id) {
        return values()[id - 1];
    }
}
