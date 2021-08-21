package com.hpfxd.discordcommands.data.permission;

import com.hpfxd.discordcommands.data.Snowflake;
import org.jetbrains.annotations.NotNull;

/**
 * See https://discord.com/developers/docs/resources/channel#overwrite-object
 */
public interface PermissionOverwrite {
    /**
     * @return role or user id
     */
    @NotNull Snowflake getId();

    /**
     * @return the type of overwrite
     */
    @NotNull PermissionOverwriteType getType();

    /**
     * @return permission bit set
     */
    @NotNull String getAllow();

    /**
     * @return permission bit set
     */
    @NotNull String getDeny();
}
