package com.hpfxd.discordcommands.data.channel.message;

import com.hpfxd.discordcommands.data.Snowflake;
import com.hpfxd.discordcommands.data.User;
import com.hpfxd.discordcommands.data.interaction.InteractionType;
import org.jetbrains.annotations.NotNull;

/**
 * See https://discord.com/developers/docs/interactions/receiving-and-responding#message-interaction-object-message-interaction-structure
 */
public interface MessageInteraction {
    /**
     * @return id of the interaction
     */
    @NotNull Snowflake getId();

    /**
     * @return the type of interaction
     */
    @NotNull InteractionType getType();

    /**
     * @return the name of the application command
     */
    @NotNull String getName();

    /**
     * @return the user who invoked the interaction
     */
    @NotNull User getUser();
}
