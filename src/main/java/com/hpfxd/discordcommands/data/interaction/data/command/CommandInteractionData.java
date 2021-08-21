package com.hpfxd.discordcommands.data.interaction.data.command;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.hpfxd.discordcommands.data.Snowflake;
import com.hpfxd.discordcommands.data.interaction.data.InteractionData;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public interface CommandInteractionData extends InteractionData {

    /**
     * @return the id of the invoked command
     */
    @NotNull Snowflake getId();

    /**
     * @return the name of the invoked command
     */
    @NotNull String getName();

    /**
     * @return the type of the invoked command
     */
    @NotNull CommandType getType();

    /**
     * @return converted users + roles + channels
     */
    @Nullable ResolvedData getResolved();

    /**
     * @return the params + values from the user
     */
    @Nullable List<CommandOption> getOptions();

    /**
     * Only for {@link CommandType#USER} and {@link CommandType#MESSAGE}
     *
     * @return id of the user of message targetted by a user or message command
     */
    @JsonProperty("target_id") @Nullable Snowflake getTargetId();
}
