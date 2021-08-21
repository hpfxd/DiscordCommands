package com.hpfxd.discordcommands.data.channel.message.sticker;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum StickerType {
    /**
     * an official sticker in a pack, part of Nitro or in a removed purchasable pack
     */
    STANDARD,

    /**
     * a sticker uploaded to a Boosted guild for the guild's members
     */
    GUILD
    ;

    @JsonValue
    public int toValue() {
        return this.ordinal() + 1;
    }

    @JsonCreator
    public static StickerType fromValue(int id) {
        return values()[id - 1];
    }
}
