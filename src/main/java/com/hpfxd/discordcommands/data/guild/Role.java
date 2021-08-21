package com.hpfxd.discordcommands.data.guild;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.hpfxd.discordcommands.data.Snowflake;
import org.jetbrains.annotations.NotNull;

/**
 * See https://discord.com/developers/docs/topics/permissions#role-object
 */
public interface Role {
    /**
     * @return role id
     */
    @NotNull Snowflake getId();

    /**
     * @return role name
     */
    @NotNull String getName();

    /**
     * @return integer representation of hexadecimal color code
     */
    int getColor();

    /**
     * @return if this role is pinned in the user listing
     */
    @JsonProperty("hoist") boolean isHoisted();

    /**
     * @return 	position of this role
     */
    int getPosition();

    /**
     * @return permission bit set
     */
    @NotNull String getPermissions();

    /**
     * @return whether this role is managed by an integration
     */
    boolean isManaged();

    /**
     * @return whether this role is mentionable
     */
    boolean isMentionable();

    /**
     * @return the tags this role has
     */
    RoleTag getTags();
}
