package com.hpfxd.discordcommands.data.guild;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.hpfxd.discordcommands.data.Snowflake;
import com.hpfxd.discordcommands.data.User;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Date;
import java.util.List;

public interface Member {
    /**
     * @return the user this guild member represents
     */
    @Nullable User getUser();

    /**
     * @return this users guild nickname
     */
    @Nullable String getNick();

    /**
     * @return 	array of role ids
     */
    @NotNull List<Snowflake> getRoles();

    /**
     * @return 	when the user joined the guild
     */
    @JsonProperty("joined_at") Date getJoinedAt();

    /**
     * @return when the user started boosting the guild
     */
    @JsonProperty("premium_since") Date getPremiumSince();

    /**
     * @return whether the user is deafened in voice channels
     */
    boolean isDeaf();

    /**
     * @return whether the user is muted in voice channels
     */
    boolean isMute();

    /**
     * @return whether the user has not yet passed the guild's Membership Screening requirements
     */
    boolean isPending();

    /**
     * @return total permissions of the member in the channel, including overwrites, returned when in the interaction object
     */
    @Nullable String getPermissions();
}
