package com.hpfxd.discordcommands.data.channel.thread;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Date;

/**
 * See https://discord.com/developers/docs/resources/channel#thread-metadata-object
 */
public interface ThreadMetadata {
    /**
     * @return whether the thread is archived
     */
    boolean isArchived();

    /**
     * @return duration in minutes to automatically archive the thread after recent activity, can be set to: 60, 1440, 4320, 10080
     */
    @JsonProperty("auto_archive_duration") int getAutoArchiveDuration();

    /**
     * @return timestamp when the thread's archive status was last changed, used for calculating recent activity
     */
    @JsonProperty("archive_timestamp") @NotNull Date getArchiveTimestamp();

    /**
     * @return whether the thread is locked; when a thread is locked, only users with MANAGE_THREADS can unarchive it
     */
    boolean isLocked();

    /**
     * @return whether non-moderators can add other non-moderators to a thread; only available on private threads
     */
    @Nullable Boolean isInvitable();
}
