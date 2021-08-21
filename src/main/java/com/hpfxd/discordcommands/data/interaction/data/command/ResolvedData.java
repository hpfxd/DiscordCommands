package com.hpfxd.discordcommands.data.interaction.data.command;

import com.hpfxd.discordcommands.data.Snowflake;
import com.hpfxd.discordcommands.data.User;
import com.hpfxd.discordcommands.data.channel.Channel;
import com.hpfxd.discordcommands.data.channel.message.Message;
import com.hpfxd.discordcommands.data.guild.Member;
import com.hpfxd.discordcommands.data.guild.Role;
import org.jetbrains.annotations.Nullable;

import java.util.Map;

/**
 * See https://discord.com/developers/docs/interactions/receiving-and-responding#interaction-object-resolved-data-structure
 */
public interface ResolvedData {
    /**
     * @return the ids and {@code User} objects
     */
    @Nullable Map<Snowflake, User> getUsers();

    /**
     * Partial {@link Member} objects are missing {@code user}, {@code deaf}, and {@code mute} fields.
     *
     * @return the ids and partial {@link Member} objects
     */
    @Nullable Map<Snowflake, Member> getMembers();

    /**
     * @return the ids and {@link Role} objects
     */
    @Nullable Map<Snowflake, Role> getRoles();

    /**
     * Partial {@link Channel} objects only have {@code id}, {@code name}, {@code type}, and {@code permissions} fields.
     * Threads will also have {@code thread_metadata} and {@code parent_id} fields.
     *
     * @return the ids and partial {@link Channel} objects
     */
    @Nullable Map<Snowflake, Channel> getChannels();

    /**
     * @return the ids and partial {@link Message} objects
     */
    @Nullable Map<Snowflake, Message> getMessages();
}
