package com.hpfxd.discordcommands.data.channel;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * See https://discord.com/developers/docs/resources/channel#channel-object-video-quality-modes
 */
public enum VideoQualityMode {
    /**
     * Discord chooses the quality for optimal performance
     */
    AUTO(1),

    /**
     * 720p
     */
    FULL(2)
    ;
    private final int id;

    VideoQualityMode(int id) {
        this.id = id;
    }

    @JsonValue
    public int toValue() {
        return this.id;
    }

    @JsonCreator
    public static VideoQualityMode fromValue(int id) {
        for (VideoQualityMode type : values()) {
            if (type.id == id) return type;
        }

        return null;
    }
}
