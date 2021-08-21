package com.hpfxd.discordcommands.data.application.team;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.hpfxd.discordcommands.data.Snowflake;
import com.hpfxd.discordcommands.data.User;
import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * See https://discord.com/developers/docs/topics/teams#data-models-team-members-object
 */
public interface TeamMember {
    @JsonProperty("membership_state") @NotNull TeamMembershipState getMembershipState();
    @NotNull List<String> getPermissions();
    @JsonProperty("team_id") @NotNull Snowflake getTeamId();
    @NotNull User getUser();
}
