package com.hpfxd.discordcommands.data.channel.message.sticker;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.hpfxd.discordcommands.data.Snowflake;
import com.hpfxd.discordcommands.data.User;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * https://discord.com/developers/docs/resources/sticker#sticker-object
 */
public interface Sticker {
    /**
     * @return id of the sticker
     */
    @NotNull Snowflake getId();

    /**
     * @return for standard stickers, id of the pack the sticker is from
     */
    @JsonProperty("pack_id") @Nullable Snowflake getPackId();

    /**
     * @return name of the sticker
     */
    @NotNull String getName();

    /**
     * @return description of the sticker
     */
    @Nullable String getDescription();

    /**
     * @return for guild stickers, the Discord name of a unicode emoji representing the sticker's expression. for standard stickers, a comma-separated list of related expressions.
     */
    @NotNull String getTags();

    /**
     * @return type of sticker
     */
    @NotNull StickerType getType();

    /**
     * @return type of sticker format
     */
    @JsonProperty("format_type") @NotNull StickerFormatType getFormatType();

    /**
     * @return whether this guild sticker can be used, may be false due to loss of Server Boosts
     */
    @Nullable Boolean isAvailable();

    /**
     * @return id of the guild that owns this sticker
     */
    @JsonProperty("guild_id") @Nullable Snowflake getGuildId();

    /**
     * @return the user that uploaded the guild sticker
     */
    @Nullable User getUser();

    /**
     * @return the standard sticker's sort order within its pack
     */
    @JsonProperty("sort_value") @Nullable Integer getSortValue();
}
