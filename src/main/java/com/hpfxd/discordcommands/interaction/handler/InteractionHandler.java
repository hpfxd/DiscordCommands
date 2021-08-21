package com.hpfxd.discordcommands.interaction.handler;

import com.hpfxd.discordcommands.data.interaction.Interaction;
import com.hpfxd.discordcommands.data.interaction.callback.InteractionCallback;

@FunctionalInterface
public interface InteractionHandler {
    InteractionCallback handle(Interaction interaction);
}
