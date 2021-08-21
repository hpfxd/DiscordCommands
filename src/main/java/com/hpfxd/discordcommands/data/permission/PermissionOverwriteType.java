package com.hpfxd.discordcommands.data.permission;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum PermissionOverwriteType {
    ROLE,
    MEMBER
    ;

    @JsonValue
    public int toValue() {
        return this.ordinal();
    }

    @JsonCreator
    public static PermissionOverwriteType fromValue(int id) {
        return values()[id];
    }
}
