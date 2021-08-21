package com.hpfxd.discordcommands;

import com.hpfxd.discordcommands.data.interaction.Interaction;
import com.hpfxd.discordcommands.data.interaction.InteractionType;
import com.hpfxd.discordcommands.data.interaction.callback.InteractionCallback;
import com.hpfxd.discordcommands.data.interaction.callback.InteractionCallbackType;
import com.hpfxd.discordcommands.data.interaction.data.command.CommandInteractionData;
import com.hpfxd.discordcommands.data.interaction.data.message.MessageComponentInteractionData;
import com.hpfxd.discordcommands.interaction.handler.InteractionHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.Map;

public class CommandManager {
    public static final boolean DEBUG_LOGGING = Boolean.getBoolean("discordcommands.debug");

    protected final @NotNull Map<String, InteractionHandler> commandHandlers = new HashMap<>();
    protected final @NotNull Map<String, InteractionHandler> componentHandlers = new HashMap<>();

    /**
     * Register an interaction handler that is called when a user executes an application command.
     *
     * @param id the command name
     * @param handler the interaction handler
     */
    public void registerCommandHandler(@NotNull String id, @NotNull InteractionHandler handler) {
        this.commandHandlers.put(id, handler);
    }

    /**
     * Register an interaction handler that is called when a user interacts with a message component.
     *
     * @param id the component custom id
     * @param handler the interaction handler
     */
    public void registerComponentHandler(@NotNull String id, @NotNull InteractionHandler handler) {
        this.componentHandlers.put(id, handler);
    }

    /**
     * Internal method to handle an interaction after it comes from the HTTP server.
     */
    public @Nullable InteractionCallback onInteraction(@NotNull Interaction interaction) {
        if (interaction.getType() == InteractionType.PING) {
            return InteractionCallback.of(InteractionCallbackType.PONG);
        }

        InteractionHandler handler = null;

        if (interaction.getType() == InteractionType.APPLICATION_COMMAND) {
            CommandInteractionData data = (CommandInteractionData) interaction.getData();
            if (data == null) throw new NullPointerException("Data should not be null!");

            handler = this.commandHandlers.get(data.getName());
        } else if (interaction.getType() == InteractionType.MESSAGE_COMPONENT) {
            MessageComponentInteractionData data = (MessageComponentInteractionData) interaction.getData();
            if (data == null) throw new NullPointerException("Data should not be null!");

            handler = this.componentHandlers.get(data.getCustomId());
        }

        if (handler == null) {
            return null; // will show an error response in discord
        }

        return handler.handle(interaction);
    }

    public static void debug(String message) {
        if (DEBUG_LOGGING) {
            System.out.println("[DiscordCommands Debug] " + message);
        }
    }
}
