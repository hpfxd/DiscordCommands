package com.hpfxd.discordcommands.data.channel.message;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.hpfxd.discordcommands.data.Snowflake;
import com.hpfxd.discordcommands.data.User;
import com.hpfxd.discordcommands.data.application.Application;
import com.hpfxd.discordcommands.data.channel.Channel;
import com.hpfxd.discordcommands.data.channel.embed.Embed;
import com.hpfxd.discordcommands.data.channel.message.activity.MessageActivity;
import com.hpfxd.discordcommands.data.channel.message.component.MessageComponent;
import com.hpfxd.discordcommands.data.channel.message.sticker.StickerItem;
import com.hpfxd.discordcommands.data.guild.Member;
import com.hpfxd.discordcommands.data.interaction.Interaction;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Date;
import java.util.List;

/**
 * See https://discord.com/developers/docs/resources/channel#message-object
 */
public interface Message {
    /**
     * @return id of the message
     */
    @NotNull Snowflake getId();

    /**
     * @return id of the channel the message was sent in
     */
    @JsonProperty("channel_id") @NotNull Snowflake getChannelId();

    /**
     * @return id of the guild the message was sent in
     */
    @JsonProperty("guild_id") @Nullable Snowflake getGuildId();

    /**
     * The author object follows the structure of the user object, but is only a valid user in the case where the message is generated by a user or bot user. If the message is generated by a webhook, the author object corresponds to the webhook's id, username, and avatar. You can tell if a message is generated by a webhook by checking for the webhook_id on the message object.
     *
     * @return the author of this message (not guaranteed to be a valid user)
     */
    @NotNull User getAuthor();

    /**
     * @return member properties for this message's author
     */
    @Nullable Member getMember();

    /**
     * @return contents of the message
     */
    @NotNull String getContent();

    /**
     * @return when this message was sent
     */
    @NotNull Date getTimestamp();

    /**
     * @return when this message was edited (or null if never)
     */
    @Nullable Date getEditTimestamp();

    /**
     * @return whether this was a TTS message
     */
    boolean isTTS();

    /**
     * @return whether this message mentions everyone
     */
    @JsonProperty("mention_everyone") boolean isMentionEveryone();

    /**
     * @return users specifically mentioned in the message
     */
    @NotNull List<User> getMentions();

    /**
     * @return roles specifically mentioned in this message
     */
    @JsonProperty("mention_roles") @NotNull List<Snowflake> getMentionRoles();

    /**
     * @return channels specifically mentioned in this message
     */
    @JsonProperty("mention_channels") @Nullable List<ChannelMention> getMentionChannels();

    /**
     * @return any attached files
     */
    @NotNull List<Attachment> getAttachments();

    /**
     * @return any embedded content
     */
    @NotNull List<Embed> getEmbeds();

    /**
     * @return reactions to the message
     */
    @Nullable List<Reaction> getReactions();

    /**
     * @return used for validating a message was sent
     */
    @Nullable Object getNonce();

    /**
     * @return whether this message is pinned
     */
    boolean isPinned();

    /**
     * @return if the message is generated by a webhook, this is the webhook's id
     */
    @JsonProperty("webhook_id") @Nullable Snowflake getWebhookId();

    /**
     * @return type of message
     */
    @NotNull MessageType getType();

    /**
     * @return sent with Rich Presence-related chat embeds
     */
    @Nullable MessageActivity getActivity();

    /**
     * @return sent with Rich Presence-related chat embeds
     */
    @Nullable Application getApplication();

    /**
     * @return if the message is a response to an {@link Interaction}, this is the id of the interaction's application
     */
    @JsonProperty("application_id") @Nullable Snowflake getApplicationId();

    /**
     * @return data showing the source of a crosspost, channel follow add, pin, or reply message
     */
    @JsonProperty("message_reference") @Nullable MessageReference getMessageReference();

    /**
     * @return message flags combined as a bitfield
     * @see <a href="https://discord.com/developers/docs/resources/channel#message-object-message-flags">Discord Documentation</a>
     */
    @Nullable Integer getFlags();

    /**
     * @return the message associated with the message_reference
     */
    @JsonProperty("referenced_message") @Nullable Message getReferencedMessage();

    /**
     * @return sent if the message is a response to an {@link Interaction}
     */
    @Nullable MessageInteraction getInteraction();

    /**
     * @return the thread that was started from this message, includes thread member object
     */
    @Nullable Channel getThread();

    /**
     * @return sent if the message contains components like buttons, action rows, or other interactive components
     */
    @Nullable List<MessageComponent> getComponents();

    /**
     * @return sent if the message contains stickers
     */
    @JsonProperty("sticker_items") List<StickerItem> getStickerItems();
}
