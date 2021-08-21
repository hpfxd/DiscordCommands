package com.hpfxd.discordcommands.data.channel.message.activity;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * See https://discord.com/developers/docs/resources/channel#message-object-message-activity-structure
 */
public interface MessageActivity {
    /**
     * @return type of messafe activity
     */
    @NotNull ActivityType getType();

    /**
     * @return party_id from a Rich Prescense event
     */
    @JsonProperty("party_id") @Nullable String getPartyId();
}
