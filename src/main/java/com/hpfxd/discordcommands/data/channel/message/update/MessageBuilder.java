package com.hpfxd.discordcommands.data.channel.message.update;

import com.hpfxd.discordcommands.data.channel.embed.Embed;
import com.hpfxd.discordcommands.data.channel.message.component.MessageComponent;
import com.hpfxd.discordcommands.data.channel.message.mention.AllowedMentions;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class MessageBuilder {
    private final List<Embed> embeds = new ArrayList<>();
    private final List<MessageComponent> components = new ArrayList<>();

    private @Nullable String content;
    private boolean tts;
    private int flags;
    private AllowedMentions allowedMentions;

    public @NotNull MessageBuilder setEmbeds(@Nullable List<Embed> embeds) {
        this.embeds.clear();
        if (embeds != null) this.embeds.addAll(embeds);
        return this;
    }

    public @NotNull MessageBuilder addEmbed(@NotNull Embed embed) {
        this.embeds.add(embed);
        return this;
    }

    public @NotNull MessageBuilder setComponents(@Nullable List<MessageComponent> components) {
        this.components.clear();
        if (components != null) this.components.addAll(components);
        return this;
    }

    public @NotNull MessageBuilder addComponent(@NotNull MessageComponent component) {
        this.components.add(component);
        return this;
    }

    public @NotNull MessageBuilder setTTS(boolean tts) {
        this.tts = tts;
        return this;
    }

    public @NotNull MessageBuilder setFlags(@Nullable Integer flags) {
        this.flags = flags == null ? 0 : flags;
        return this;
    }

    public @NotNull MessageBuilder setEphemeral() {
        this.flags = 64;
        return this;
    }

    public @NotNull MessageBuilder setAllowedMentions(@Nullable AllowedMentions allowedMentions) {
        this.allowedMentions = allowedMentions;
        return this;
    }

    public @NotNull MessageBuilder setContent(@Nullable String content) {
        this.content = content;
        return this;
    }

    public @NotNull MessageUpdate build() {
        return new MessageUpdate(this.content, this.embeds, this.tts, this.allowedMentions, this.flags, this.components);
    }
}
