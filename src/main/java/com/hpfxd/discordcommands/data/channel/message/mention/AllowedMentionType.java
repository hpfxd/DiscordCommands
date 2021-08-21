package com.hpfxd.discordcommands.data.channel.message.mention;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum AllowedMentionType {
    /**
     * Controls role mentions
     */
    ROLES("roles"),

    /**
     * Controls user mentions
     */
    USERS("users"),

    /**
     * Controls {@code @everyone} and {@code @here} mentions
     */
    EVERYONE("everyone"),
    ;
    private final String name;

    AllowedMentionType(String name) {
        this.name = name;
    }

    @JsonValue
    public String getName() {
        return name;
    }

    @JsonCreator
    public static AllowedMentionType fromValue(String name) {
        for (AllowedMentionType type : values()) {
            if (type.name.equals(name)) return type;
        }

        return null;
    }
}
