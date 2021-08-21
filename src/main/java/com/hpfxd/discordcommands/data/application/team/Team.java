package com.hpfxd.discordcommands.data.application.team;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.hpfxd.discordcommands.data.Snowflake;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

/**
 * See https://discord.com/developers/docs/topics/teams#data-models-team-object
 */
public interface Team {
    /**
     * @return a hash of the image of the team's icon
     */
    @Nullable String getIcon();

    /**
     * @return the unique id of the team
     */
    @NotNull Snowflake getId();

    /**
     * @return the members of the team
     */
    @NotNull List<TeamMember> getMembers();

    /**
     * @return the name of the team
     */
    @NotNull String getName();

    /**
     * @return the user id of the current team owner
     */
    @JsonProperty("owner_user_id") @NotNull Snowflake getOwnerUserId();
}
