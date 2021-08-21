package com.hpfxd.discordcommands.data.interaction.data.message;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.hpfxd.discordcommands.data.channel.message.component.MessageComponentType;
import com.hpfxd.discordcommands.data.interaction.data.InteractionData;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public interface MessageComponentInteractionData extends InteractionData {
    /**
     * @return the custom id of the component
     */
    @JsonProperty("custom_id") @Nullable String getCustomId();

    /**
     * @return the type of the component
     */
    @JsonProperty("component_type") @Nullable MessageComponentType getType();

    /**
     * @return the values the user specified
     */
    @Nullable List<String> getValues();
}
