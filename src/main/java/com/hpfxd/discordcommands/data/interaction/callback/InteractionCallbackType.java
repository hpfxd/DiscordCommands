package com.hpfxd.discordcommands.data.interaction.callback;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.hpfxd.discordcommands.data.interaction.InteractionType;

public enum InteractionCallbackType {
    /**
     * ACK a {@link InteractionType#PING}
     */
    PONG(1),

    /**
     * respond to an interaction with a message
     */
    CHANNEL_MESSAGE_WITH_SOURCE(4),

    /**
     * ACK an interaction and edit a response later, the user sees a loading state
     */
    DEFERRED_CHANNEL_MESSAGE_WITH_SOURCE(5),

    /**
     * Only for {@link InteractionType#MESSAGE_COMPONENT} interactions.
     *
     * for components, ACK an interaction and edit the original message later; the user does not see a loading state
     */
    DEFERRED_UPDATE_MESSAGE(6),

    /**
     * Only for {@link InteractionType#MESSAGE_COMPONENT} interactions.
     *
     * for components, edit the message the component was attached to
     */
    UPDATE_MESSAGE(7),
    ;
    private final int id;

    InteractionCallbackType(int id) {
        this.id = id;
    }

    @JsonValue
    public int toValue() {
        return this.id;
    }

    @JsonCreator
    public static InteractionCallbackType fromValue(int id) {
        for (InteractionCallbackType type : values()) {
            if (type.id == id) return type;
        }

        return null;
    }
}
