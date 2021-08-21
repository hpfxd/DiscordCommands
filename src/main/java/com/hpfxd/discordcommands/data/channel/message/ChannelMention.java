package com.hpfxd.discordcommands.data.channel.message;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.hpfxd.discordcommands.data.Snowflake;
import com.hpfxd.discordcommands.data.channel.ChannelType;
import org.jetbrains.annotations.NotNull;

/**
 * See https://discord.com/developers/docs/resources/channel#channel-mention-object
 */
public interface ChannelMention {
    /**
     * @return id of the channel
     */
    @NotNull Snowflake getId();

    /**
     * @return id of the guild containing the channel
     */
    @JsonProperty("guild_id") @NotNull Snowflake getGuildId();

    /**
     * @return the type of channel
     */
    @NotNull ChannelType getType();

    /**
     * @return the name of the channel
     */
    @NotNull String getName();
}
