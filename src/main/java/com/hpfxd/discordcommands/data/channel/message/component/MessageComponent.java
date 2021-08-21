package com.hpfxd.discordcommands.data.channel.message.component;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.hpfxd.discordcommands.data.channel.message.Emoji;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.beans.ConstructorProperties;
import java.util.List;
import java.util.Objects;

/**
 * See https://discord.com/developers/docs/interactions/message-components#component-object
 */
public class MessageComponent {
    public static MessageComponentBuilder builder() {
        return new MessageComponentBuilder();
    }

    private final MessageComponentType type;
    @JsonProperty("custom_id") private final @Nullable String customId;
    private final @Nullable Boolean disabled;
    private final @Nullable ButtonStyle style;
    private final @Nullable String label;
    private final @Nullable Emoji emoji;
    private final @Nullable String url;
    private final @Nullable List<MessageComponentSelectOption> options;
    private final @Nullable String placeholder;
    @JsonProperty("min_values") private final @Nullable Integer minValues;
    @JsonProperty("max_values") private final @Nullable Integer maxValues;
    private final @Nullable List<MessageComponent> components;

    @ConstructorProperties({
            "type", "custom_id", "disabled", "style", "label", "emoji", "url",
            "options", "placeholder", "min_values", "max_values", "components"
    })
    public MessageComponent(MessageComponentType type, @Nullable String customId, @Nullable Boolean disabled, @Nullable ButtonStyle style, @Nullable String label, @Nullable Emoji emoji, @Nullable String url, @Nullable List<MessageComponentSelectOption> options, @Nullable String placeholder, @Nullable Integer minValues, @Nullable Integer maxValues, @Nullable List<MessageComponent> components) {
        this.type = type;
        this.customId = customId;
        this.disabled = disabled;
        this.style = style;
        this.label = label;
        this.emoji = emoji;
        this.url = url;
        this.options = options;
        this.placeholder = placeholder;
        this.minValues = minValues;
        this.maxValues = maxValues;
        this.components = components;
    }

    /**
     * @return component type
     */
    public @NotNull MessageComponentType getType() {
        return this.type;
    }

    /**
     * Valid for: Buttons, Select Menus
     *
     * @return a developer-defined identifier for the component, max 100 characters
     */
    @JsonProperty("custom_id") public @Nullable String getCustomId() {
        return this.customId;
    }

    /**
     * Valid for: Buttons, Select Menus
     *
     * @return whether the component is disabled, default false
     */
    public @Nullable Boolean isDisabled() {
        return this.disabled;
    }

    /**
     * Valid for: Buttons
     *
     * @return one of button styles
     */
    public @Nullable ButtonStyle getStyle() {
        return this.style;
    }

    /**
     * Valid for: Buttons
     *
     * @return text that appears on the button, max 80 characters
     */
    public @Nullable String getLabel() {
        return this.label;
    }

    /**
     * Valid for: Buttons
     *
     * @return name, id, and animated
     */
    public @Nullable Emoji getEmoji() {
        return this.emoji;
    }

    /**
     * Valid for: Buttons
     *
     * @return a url for link-style buttons
     */
    public @Nullable String getURL() {
        return this.url;
    }

    /**
     * Valid for: Select Menus
     *
     * @return the choices in the select, max 25
     */
    public @Nullable List<MessageComponentSelectOption> getOptions() {
        return this.options;
    }

    /**
     * Valid for: Select Menus
     *
     * @return custom placeholder text if nothing is selected, max 100 characters
     */
    public @Nullable String getPlaceholder() {
        return this.placeholder;
    }

    /**
     * Valid for: Select Menus
     *
     * @return the minimum number of items that must be chosen; default 1, min 0, max 25
     */
    @JsonProperty("min_values") public @Nullable Integer getMinValues() {
        return this.minValues;
    }

    /**
     * Valid for: Select Menus
     *
     * @return the maximum number of items that can be chosen; default 1, max 25
     */
    @JsonProperty("max_values") public @Nullable Integer getMaxValues() {
        return this.maxValues;
    }

    /**
     * Valid for: Action Rows
     *
     * @return a list of child components
     */
    public @Nullable List<MessageComponent> getComponents() {
        return this.components;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MessageComponent that = (MessageComponent) o;
        return type == that.type && Objects.equals(customId, that.customId) && Objects.equals(disabled, that.disabled) && style == that.style && Objects.equals(label, that.label) && Objects.equals(emoji, that.emoji) && Objects.equals(url, that.url) && Objects.equals(options, that.options) && Objects.equals(placeholder, that.placeholder) && Objects.equals(minValues, that.minValues) && Objects.equals(maxValues, that.maxValues) && Objects.equals(components, that.components);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, customId, disabled, style, label, emoji, url, options, placeholder, minValues, maxValues, components);
    }

    @Override
    public String toString() {
        return "MessageComponent{" +
                "type=" + type +
                ", customId='" + customId + '\'' +
                ", disabled=" + disabled +
                ", style=" + style +
                ", label='" + label + '\'' +
                ", emoji=" + emoji +
                ", url='" + url + '\'' +
                ", options=" + options +
                ", placeholder='" + placeholder + '\'' +
                ", minValues=" + minValues +
                ", maxValues=" + maxValues +
                ", components=" + components +
                '}';
    }
}
