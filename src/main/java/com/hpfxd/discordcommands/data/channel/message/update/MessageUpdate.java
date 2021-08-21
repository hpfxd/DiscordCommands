package com.hpfxd.discordcommands.data.channel.message.update;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.hpfxd.discordcommands.data.channel.embed.Embed;
import com.hpfxd.discordcommands.data.channel.message.Message;
import com.hpfxd.discordcommands.data.channel.message.component.MessageComponent;
import com.hpfxd.discordcommands.data.channel.message.mention.AllowedMentions;
import org.jetbrains.annotations.Nullable;

import java.beans.ConstructorProperties;
import java.util.List;
import java.util.Objects;

/**
 * Class for holding message information for publishing to Discord's API.
 * Used, for example, to send a message to a channel.
 */
public class MessageUpdate {
    /**
     * Create a {@link MessageBuilder} for easy construction of a message update.
     *
     * @return a {@link MessageBuilder}
     */
    public static MessageBuilder builder() {
        return new MessageBuilder();
    }

    /**
     * Create a {@link MessageBuilder} with the properties of the specified message.
     *
     * @param message the message to copy from
     * @return a {@link MessageBuilder}
     */
    public static MessageBuilder builder(Message message) {
        return builder()
                .setEmbeds(message.getEmbeds())
                .setComponents(message.getComponents())
                .setTTS(message.isTTS())
                .setContent(message.getContent())
                .setFlags(message.getFlags());
    }

    private final @Nullable String content;
    private final @Nullable List<Embed> embeds;
    private final boolean tts;
    @JsonProperty("allowed_mentions") private final @Nullable AllowedMentions allowedMentions;
    private final int flags;
    private final List<MessageComponent> components;

    @ConstructorProperties({ "content", "embeds", "tts", "allowed_mentions", "flags", "components" })
    public MessageUpdate(@Nullable String content, @Nullable List<Embed> embeds, boolean tts, @Nullable AllowedMentions allowedMentions, int flags, List<MessageComponent> components) {
        this.content = content;
        this.embeds = embeds;
        this.tts = tts;
        this.allowedMentions = allowedMentions;
        this.flags = flags;
        this.components = components;
    }

    public @Nullable String getContent() {
        return content;
    }

    public @Nullable List<Embed> getEmbeds() {
        return embeds;
    }

    public boolean isTts() {
        return tts;
    }

    public @Nullable AllowedMentions getAllowedMentions() {
        return allowedMentions;
    }

    public int getFlags() {
        return flags;
    }

    public List<MessageComponent> getComponents() {
        return components;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MessageUpdate that = (MessageUpdate) o;
        return tts == that.tts && flags == that.flags && Objects.equals(content, that.content) && Objects.equals(embeds, that.embeds) && Objects.equals(allowedMentions, that.allowedMentions) && Objects.equals(components, that.components);
    }

    @Override
    public int hashCode() {
        return Objects.hash(content, embeds, tts, allowedMentions, flags, components);
    }

    @Override
    public String toString() {
        return "MessageUpdate{" +
                "content='" + content + '\'' +
                ", embeds=" + embeds +
                ", tts=" + tts +
                ", allowedMentions=" + allowedMentions +
                ", flags=" + flags +
                ", components=" + components +
                '}';
    }
}
