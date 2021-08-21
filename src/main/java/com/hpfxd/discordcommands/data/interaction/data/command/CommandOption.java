package com.hpfxd.discordcommands.data.interaction.data.command;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public interface CommandOption {
    /**
     * @return the name of the parameter
     */
    @NotNull String getName();

    /**
     * @return the type of the parameter
     */
    @NotNull CommandOptionType getType();

    /**
     * @return the value of the pair
     */
    @Nullable Object getValue();

    /**
     * @return present if this option is a group or subcommand
     */
    @Nullable List<CommandOption> getOptions();
}
