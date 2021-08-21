package com.hpfxd.discordcommands.data.interaction;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.hpfxd.discordcommands.DiscordHttp;
import com.hpfxd.discordcommands.data.Snowflake;
import com.hpfxd.discordcommands.data.User;
import com.hpfxd.discordcommands.data.channel.message.Message;
import com.hpfxd.discordcommands.data.channel.message.update.MessageUpdate;
import com.hpfxd.discordcommands.data.guild.Member;
import com.hpfxd.discordcommands.data.interaction.callback.InteractionCallbackType;
import com.hpfxd.discordcommands.data.interaction.data.InteractionData;
import com.hpfxd.discordcommands.data.interaction.data.command.CommandInteractionData;
import com.hpfxd.discordcommands.data.interaction.data.message.MessageComponentInteractionData;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.beans.ConstructorProperties;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;

/**
 * Represents an Interaction received by Discord.
 *
 * See https://discord.com/developers/docs/interactions/receiving-and-responding#interaction-object-interaction-structure
 */
public class Interaction {
    private final @NotNull Snowflake id;
    @JsonProperty("application_id") private final @NotNull Snowflake applicationId;
    private final @NotNull InteractionType type;

    @JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.EXTERNAL_PROPERTY, property = "type")
    @JsonSubTypes({
            @JsonSubTypes.Type(value = InteractionData.class, name = "1"), // ping
            @JsonSubTypes.Type(value = CommandInteractionData.class, name = "2"),
            @JsonSubTypes.Type(value = MessageComponentInteractionData.class, name = "3")
    })
    private final @Nullable InteractionData data;

    @JsonProperty("guild_id") private final @Nullable Snowflake guildId;
    @JsonProperty("channel_id") private final @Nullable Snowflake channelId;
    private final @Nullable Member member;
    private final @Nullable User user;
    private final @NotNull String token;
    private final int version;
    private final @Nullable Message message;

    @ConstructorProperties({
            "id", "application_id", "type", "data", "guild_id",
            "channel_id", "member", "user", "token", "version",
            "message"
    })
    public Interaction(@NotNull Snowflake id, @NotNull Snowflake applicationId, @NotNull InteractionType type, @Nullable InteractionData data, @Nullable Snowflake guildId, @Nullable Snowflake channelId, @Nullable Member member, @Nullable User user, @NotNull String token, int version, @Nullable Message message) {
        this.id = id;
        this.applicationId = applicationId;
        this.type = type;
        this.data = data;
        this.guildId = guildId;
        this.channelId = channelId;
        this.member = member;
        this.user = user;
        this.token = token;
        this.version = version;
        this.message = message;
    }

    /**
     * Update this interaction's original message.
     * You should have responded to this interaction with either:
     * <ul>
     *     <li>{@link InteractionCallbackType#DEFERRED_UPDATE_MESSAGE}</li>
     *     <li>{@link InteractionCallbackType#DEFERRED_CHANNEL_MESSAGE_WITH_SOURCE}</li> (for components)
     * </ul>
     *
     * @param message the message to edit the interaction's message to
     * @return a future to listen for when it has been completed
     */
    public @NotNull CompletableFuture<Void> submitDeferredMessage(MessageUpdate message) {
        return DiscordHttp.request("PATCH", "/webhooks/" + this.getApplicationId()
                .getAsString() + "/" + this.getToken() + "/messages/@original", message)
                .thenAccept(response -> {
                    if (response.statusCode() != 204) throw new RuntimeException(response.body());
                });
    }

    /**
     * @return id of the interaction
     */
    public @NotNull Snowflake getId() {
        return this.id;
    }

    /**
     * @return id of the application this interaction is for
     */
    public @NotNull Snowflake getApplicationId() {
        return this.applicationId;
    }

    /**
     * @return the type of interaction
     */
    public @NotNull InteractionType getType() {
        return this.type;
    }

    /**
     * This is always present on application command and message component interaction types.
     * It is optional for future-proofing against new interaction types
     *
     * @return the command data payload
     */
    public @Nullable InteractionData getData() {
        return this.data;
    }

    /**
     * @return the guild it was sent from
     */
    public @JsonProperty("guild_id") @Nullable Snowflake getGuildId() {
        return this.guildId;
    }

    /**
     * @return the channel it was sent from
     */
    public @JsonProperty("channel_id") @Nullable Snowflake getChannelId() {
        return this.channelId;
    }

    /**
     * Present when the interaction is invoked in a guild
     *
     * @return guild member data for the invoking user, including permissions
     */
    public @Nullable Member getMember() {
        return this.member;
    }

    /**
     * Present when the interaction is invoked in a DM
     *
     * @return user object for the invoking user, if invoked in a DM
     */
    public @Nullable User getUser() {
        return this.user;
    }

    /**
     * @return a continuation token for responding to the interaction
     */
    public @NotNull String getToken() {
        return this.token;
    }

    /**
     * @return read-only property, always {@code 1}
     */
    public int getVersion() {
        return this.version;
    }

    /**
     * @return for components, the message they were attached to
     */
    public @Nullable Message getMessage() {
        return this.message;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Interaction that = (Interaction) o;
        return version == that.version && id.equals(that.id) && applicationId.equals(that.applicationId) && type == that.type && Objects.equals(data, that.data) && Objects.equals(guildId, that.guildId) && Objects.equals(channelId, that.channelId) && Objects.equals(member, that.member) && Objects.equals(user, that.user) && token.equals(that.token) && Objects.equals(message, that.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, applicationId, type, data, guildId, channelId, member, user, token, version, message);
    }

    @Override
    public String toString() {
        return "Interaction{" +
                "id=" + id +
                ", applicationId=" + applicationId +
                ", type=" + type +
                ", data=" + data +
                ", guildId=" + guildId +
                ", channelId=" + channelId +
                ", member=" + member +
                ", user=" + user +
                ", token='" + token + '\'' +
                ", version=" + version +
                ", message=" + message +
                '}';
    }
}
