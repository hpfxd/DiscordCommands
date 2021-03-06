package com.hpfxd.discordcommands.data.channel;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum ChannelType {
    /**
     * a text channel within a server
     */
    GUILD_TEXT(0),

    /**
     * a direct message between users
     */
    DM(1),

    /**
     * a voice channel within a server
     */
    GUILD_VOICE(2),

    /**
     * a direct message between multiple users
     */
    GROUP_DM(3),

    /**
     * an organizational category that contains up to 50 channels
     */
    GUILD_CATEGORY(4),

    /**
     * a channel that users can follow and crosspost into their own server
     */
    GUILD_NEWS(5),

    /**
     * a channel in which game developers can sell their game on Discord
     */
    GUILD_STORE(6),

    /**
     * a temporary sub-channel within a GUILD_NEWS channel
     */
    GUILD_NEWS_THREAD(10),

    /**
     * a temporary sub-channel within a GUILD_TEXT channel
     */
    GUILD_PUBLIC_THREAD(11),

    /**
     * a temporary sub-channel within a GUILD_TEXT channel that is only viewable by those invited and those with the MANAGE_THREADS permission
     */
    GUILD_PRIVATE_THREAD(12),

    /**
     * a voice channel for hosting events with an audience
     */
    GUILD_STAGE_VOICE(13),
    ;
    private final int id;

    ChannelType(int id) {
        this.id = id;
    }

    @JsonValue
    public int toValue() {
        return this.id;
    }

    @JsonCreator
    public static ChannelType fromValue(int id) {
        for (ChannelType type : values()) {
            if (type.id == id) return type;
        }

        return null;
    }
}
