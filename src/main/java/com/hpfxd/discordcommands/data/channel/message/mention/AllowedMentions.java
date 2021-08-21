package com.hpfxd.discordcommands.data.channel.message.mention;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.hpfxd.discordcommands.data.Snowflake;
import org.jetbrains.annotations.NotNull;

import java.beans.ConstructorProperties;
import java.util.List;

public class AllowedMentions {
    @JsonProperty("parse") private final @NotNull List<AllowedMentionType> types;
    private final @NotNull List<Snowflake> roles;
    private final @NotNull List<Snowflake> users;
    @JsonProperty("replied_user") private final boolean repliedUser;

    @ConstructorProperties({ "parse", "roles", "users", "replied_user" })
    public AllowedMentions(@NotNull List<AllowedMentionType> types, @NotNull List<Snowflake> roles, @NotNull List<Snowflake> users, boolean repliedUser) {
        this.types = types;
        this.roles = roles;
        this.users = users;
        this.repliedUser = repliedUser;
    }

    /**
     * @return An array of allowed mention types to parse from the content.
     */
    public @NotNull List<AllowedMentionType> getTypes() {
        return types;
    }

    /**
     * @return Array of role_ids to mention (Max size of 100)
     */
    public @NotNull List<Snowflake> getRoles() {
        return roles;
    }

    /**
     * @return Array of user_ids to mention (Max size of 100)
     */
    public @NotNull List<Snowflake> getUsers() {
        return users;
    }

    /**
     * @return For replies, whether to mention the author of the message being replied to (default false)
     */
    public boolean isRepliedUser() {
        return repliedUser;
    }
}
