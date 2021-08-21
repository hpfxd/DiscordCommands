package com.hpfxd.discordcommands.data.channel.message;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum MessageType {
    DEFAULT,
    RECIPIENT_ADD,
    RECIPIENT_REMOVE,
    CALL,
    CHANNEL_NAME_CHANGE,
    CHANNEL_ICON_CHANGE,
    CHANNEL_PINNED_MESSAGE,
    GUILD_MEMBER_JOIN,
    USER_PREMIUM_GUILD_SUBSCRIPTION,
    USER_PREMIUM_GUILD_SUBSCRIPTION_TIER_1,
    USER_PREMIUM_GUILD_SUBSCRIPTION_TIER_2,
    USER_PREMIUM_GUILD_SUBSCRIPTION_TIER_3,
    CHANNEL_FOLLOW_ADD,
    GUILD_DISCOVERY_DISQUALIFIED,
    GUILD_DISCOVERY_REQUALIFIED,
    GUILD_DISCOVERY_GRACE_PERIOD_INITIAL_WARNING,
    GUILD_DISCOVERY_GRACE_PERIOD_FINAL_WARNING,
    THREAD_CREATED,
    REPLY,
    APPLICATION_COMMAND,
    THREAD_STARTER_MESSAGE,
    GUILD_INVITE_REMINDER,
    ;

    @JsonValue
    public int toValue() {
        return this.ordinal();
    }

    @JsonCreator
    public static MessageType fromValue(int id) {
        return values()[id];
    }
}
