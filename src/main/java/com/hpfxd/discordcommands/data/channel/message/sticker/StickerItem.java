package com.hpfxd.discordcommands.data.channel.message.sticker;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.hpfxd.discordcommands.data.Snowflake;
import org.jetbrains.annotations.NotNull;

/**
 * See https://discord.com/developers/docs/resources/sticker#sticker-item-object
 */
public interface StickerItem {
    @NotNull Snowflake getId();
    @NotNull String getName();
    @JsonProperty("format_type") @NotNull StickerFormatType getFormatType();
}
