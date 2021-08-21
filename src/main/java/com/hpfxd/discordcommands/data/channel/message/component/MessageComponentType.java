package com.hpfxd.discordcommands.data.channel.message.component;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * See https://discord.com/developers/docs/interactions/message-components#component-object-component-types
 */
public enum MessageComponentType {
    /**
     * A container for other components
     */
    ACTION_ROW,

    /**
     * A button object
     */
    BUTTON,

    /**
     * A select menu for picking from choices
     */
    SELECT_MENU
    ;

    @JsonValue
    public int toValue() {
        return this.ordinal() + 1;
    }

    @JsonCreator
    public static MessageComponentType fromValue(int id) {
        return values()[id - 1];
    }
}
