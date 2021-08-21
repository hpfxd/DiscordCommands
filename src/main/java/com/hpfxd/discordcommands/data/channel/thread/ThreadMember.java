package com.hpfxd.discordcommands.data.channel.thread;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.hpfxd.discordcommands.data.Snowflake;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Date;

/**
 * See https://discord.com/developers/docs/resources/channel#thread-member-object
 */
public interface ThreadMember {
    /**
     * @return the id of the thread
     */
    @Nullable Snowflake getId();

    /**
     * @return the id of the user
     */
    @JsonProperty("user_id") @Nullable Snowflake getUserId();

    /**
     * @return the time the current user last joined the thread
     */
    @JsonProperty("join_timestamp") @NotNull Date getJoinTimestamp();

    /**
     * @return any user-thread settings, currently only used for notifications
     */
    int getFlags();
}
