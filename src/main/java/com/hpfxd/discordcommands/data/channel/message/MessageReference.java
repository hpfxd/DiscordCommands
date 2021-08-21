package com.hpfxd.discordcommands.data.channel.message;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.hpfxd.discordcommands.data.Snowflake;
import org.jetbrains.annotations.Nullable;

/**
 * See https://discord.com/developers/docs/resources/channel#message-reference-object-message-reference-structure
 */
public interface MessageReference {
    /**
     * @return id of the originating message
     */
    @JsonProperty("message_id") @Nullable Snowflake getMessageId();

    /**
     * @return id of the originating message's channel
     */
    @JsonProperty("channel_id") @Nullable Snowflake getChannelId();

    /**
     * @return id of the originating message's guild
     */
    @JsonProperty("guild_id") @Nullable Snowflake getGuildId();

    /**
     * @return when sending, whether to error if the referenced message doesn't exist instead of sending as a normal (non-reply) message, default true
     */
    @JsonProperty("fail_if_not_exists") @Nullable Boolean getFailIfNotExists();
}
