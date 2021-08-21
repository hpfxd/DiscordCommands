package com.hpfxd.discordcommands.data.channel;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.hpfxd.discordcommands.data.Snowflake;
import com.hpfxd.discordcommands.data.User;
import com.hpfxd.discordcommands.data.channel.thread.ThreadMember;
import com.hpfxd.discordcommands.data.channel.thread.ThreadMetadata;
import com.hpfxd.discordcommands.data.permission.PermissionOverwrite;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Date;
import java.util.List;

/**
 * See https://discord.com/developers/docs/resources/channel#channel-object
 */
public interface Channel {
    /**
     * @return the id of this channel
     */
    @NotNull Snowflake getId();

    /**
     * @return 	the type of channel
     */
    @NotNull ChannelType getType();

    /**
     * @return 	the id of the guild (may be missing for some channel objects received over gateway guild dispatches)
     */
    @JsonProperty("guild_id") @Nullable Snowflake getGuildId();

    /**
     * @return sorting position of the channel
     */
    @Nullable Integer getPosition();

    /**
     * @return explicit permission overwrites for members and roles
     */
    @JsonProperty("permission_overwrites") @Nullable List<PermissionOverwrite> getPermissionOverwrites();

    /**
     * @return the name of the channel (1-100 characters)
     */
    @Nullable String getName();

    /**
     * @return the channel topic (0-1024 characters)
     */
    @Nullable String getTopic();

    /**
     * @return whether the channel is nsfw
     */
    boolean isNSFW();

    /**
     * @return the id of the last message sent in this channel (may not point to an existing or valid message)
     */
    @JsonProperty("last_message_id") @Nullable Snowflake getLastMessageId();

    /**
     * @return the bitrate (in bits) of the voice channel
     */
    @Nullable Integer getBitrate();

    /**
     * @return the user limit of the voice channel
     */
    @JsonProperty("user_limit") @Nullable Integer getUserLimit();

    /**
     * @return amount of seconds a user has to wait before sending another message (0-21600); bots, as well as users with the permission manage_messages or manage_channel, are unaffected
     */
    @JsonProperty("rate_limit_per_user") @Nullable Integer getRateLimitPerUser();

    /**
     * @return the recipients of the DM
     */
    @Nullable List<User> getRecipients();

    /**
     * @return icon hash
     */
    @Nullable String getIcon();

    /**
     * @return id of the creator of the group DM or thread
     */
    @JsonProperty("owner_id") @Nullable Snowflake getOwnerId();

    /**
     * @return application id of the group DM creator if it is bot-created
     */
    @JsonProperty("application_id") @Nullable Snowflake getApplicationId();

    /**
     * @return for guild channels: id of the parent category for a channel (each parent category can contain up to 50 channels), for threads: id of the text channel this thread was created
     */
    @JsonProperty("parent_id") @Nullable Snowflake getParentId();

    /**
     * @return when the last pinned message was pinned. This may be null in events such as GUILD_CREATE when a message is not pinned.
     */
    @JsonProperty("last_pin_timestamp") @Nullable Date getLastPinTimestamp();

    /**
     * @return voice region id for the voice channel, automatic when set to null
     */
    @JsonProperty("rtc_region") @Nullable String getRTCRegion();

    /**
     * @return the camera video quality mode of the voice channel, auto when not present
     */
    @JsonProperty("video_quality_mode") @Nullable VideoQualityMode getVideoQualityMode();

    /**
     * @return an approximate count of messages in a thread, stops counting at 50
     */
    @JsonProperty("message_count") @Nullable Integer getMessageCount();

    /**
     * @return an approximate count of users in a thread, stops counting at 50
     */
    @JsonProperty("member_count") @Nullable Integer getMemberCount();

    /**
     * @return 	thread-specific fields not needed by other channels
     */
    @JsonProperty("thread_metadata") @Nullable ThreadMetadata getThreadMetadata();

    /**
     * @return thread member object for the current user, if they have joined the thread, only included on certain API endpoints
     */
    @JsonProperty("member") @Nullable ThreadMember getMember();

    /**
     * @return default duration for newly created threads, in minutes, to automatically archive the thread after recent activity, can be set to: 60, 1440, 4320, 10080
     */
    @JsonProperty("default_auto_archive_duration") @Nullable Integer getDefaultAutoArchiveDuration();

    /**
     * @return computed permissions for the invoking user in the channel, including overwrites, only included when part of the resolved data received on a slash command interaction
     */
    @JsonProperty("permissions") @Nullable String getPermissions();
}
