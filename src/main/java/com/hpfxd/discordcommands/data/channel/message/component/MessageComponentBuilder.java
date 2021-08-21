package com.hpfxd.discordcommands.data.channel.message.component;

import com.hpfxd.discordcommands.data.channel.message.Emoji;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class MessageComponentBuilder {
    private MessageComponentType type;
    private @Nullable String customId;
    private @Nullable Boolean disabled;
    private @Nullable ButtonStyle style;
    private @Nullable String label;
    private @Nullable Emoji emoji;
    private @Nullable String url;
    private @Nullable List<MessageComponentSelectOption> options;
    private @Nullable String placeholder;
    private @Nullable Integer minValues;
    private @Nullable Integer maxValues;
    private @Nullable List<MessageComponent> components;

    public MessageComponentBuilder setType(MessageComponentType type) {
        this.type = type;
        return this;
    }

    public MessageComponentBuilder setCustomId(@Nullable String customId) {
        this.customId = customId;
        return this;
    }

    public MessageComponentBuilder setDisabled(@Nullable Boolean disabled) {
        this.disabled = disabled;
        return this;
    }

    public MessageComponentBuilder setStyle(@Nullable ButtonStyle style) {
        this.style = style;
        return this;
    }

    public MessageComponentBuilder setLabel(@Nullable String label) {
        this.label = label;
        return this;
    }

    public MessageComponentBuilder setEmoji(@Nullable Emoji emoji) {
        this.emoji = emoji;
        return this;
    }

    public MessageComponentBuilder setUrl(@Nullable String url) {
        this.url = url;
        return this;
    }

    public MessageComponentBuilder setOptions(@Nullable List<MessageComponentSelectOption> options) {
        this.options = options;
        return this;
    }

    public MessageComponentBuilder addOption(@NotNull MessageComponentSelectOption option) {
        if (this.options == null) this.options = new ArrayList<>(1);
        this.options.add(option);
        return this;
    }

    public MessageComponentBuilder setPlaceholder(@Nullable String placeholder) {
        this.placeholder = placeholder;
        return this;
    }

    public MessageComponentBuilder setMinValues(@Nullable Integer minValues) {
        this.minValues = minValues;
        return this;
    }

    public MessageComponentBuilder setMaxValues(@Nullable Integer maxValues) {
        this.maxValues = maxValues;
        return this;
    }

    public MessageComponentBuilder setComponents(@Nullable List<MessageComponent> components) {
        this.components = components;
        return this;
    }

    public MessageComponentBuilder addComponent(@NotNull MessageComponent component) {
        if (this.components == null) this.components = new ArrayList<>(1);
        this.components.add(component);
        return this;
    }

    public MessageComponent build() {
        return new MessageComponent(type, customId, disabled, style, label, emoji, url, options, placeholder, minValues, maxValues, components);
    }
}
