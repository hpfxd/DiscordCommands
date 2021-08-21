package com.hpfxd.discordcommands.data.application.team;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * See https://discord.com/developers/docs/topics/teams#data-models-membership-state-enum
 */
public enum TeamMembershipState {
    INVITED,
    ACCEPTED
    ;

    @JsonValue
    public int toValue() {
        return this.ordinal() + 1;
    }

    @JsonCreator
    public static TeamMembershipState fromValue(int id) {
        return values()[id - 1];
    }
}
