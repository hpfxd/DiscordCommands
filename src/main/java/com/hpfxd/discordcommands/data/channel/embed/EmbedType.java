package com.hpfxd.discordcommands.data.channel.embed;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum EmbedType {
    /**
     * generic embed rendered from embed attributes
     */
    RICH("rich"),

    /**
     * image embed
     */
    IMAGE("image"),

    /**
     * video embed
     */
    VIDEO("video"),

    /**
     * animated gif image embed rendered as a video embed
     */
    GIFV("gifv"),

    /**
     * article embed
     */
    ARTICLE("article"),

    /**
     * link embed
     */
    LINK("link"),
    ;
    private final String name;

    EmbedType(String name) {
        this.name = name;
    }

    @JsonValue
    public String getName() {
        return name;
    }

    @JsonCreator
    public static EmbedType fromValue(String name) {
        for (EmbedType type : values()) {
            if (type.name.equals(name)) return type;
        }

        return null;
    }
}
