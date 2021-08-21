package com.hpfxd.discordcommands.data.guild;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.hpfxd.discordcommands.data.Snowflake;
import org.jetbrains.annotations.Nullable;

/**
 * See https://discord.com/developers/docs/topics/permissions#role-object-role-tags-structure
 */
public interface RoleTag {
    /**
     * @return the id of the bot this role belongs to
     */
    @JsonProperty("bot_id") @Nullable Snowflake getBotId();

    /**
     * @return the id of the integration this role belongs to
     */
    @JsonProperty("integration_id") @Nullable Snowflake getIntegrationId();

    /**
     * @return whether this is the guild's premium subscriber role
     */
    @JsonProperty("premium_subscriber") boolean isPremiumSubscriberRole();
}
