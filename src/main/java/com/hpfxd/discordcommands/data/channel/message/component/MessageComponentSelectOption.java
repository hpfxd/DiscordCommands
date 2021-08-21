package com.hpfxd.discordcommands.data.channel.message.component;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.hpfxd.discordcommands.data.channel.message.Emoji;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.beans.ConstructorProperties;
import java.util.Objects;

/**
 * See https://discord.com/developers/docs/interactions/message-components#select-menu-object-select-option-structure
 */
public class MessageComponentSelectOption {
    private final @NotNull String label;
    private final @NotNull String value;
    private final @Nullable String description;
    private final @Nullable Emoji emoji;
    @JsonProperty("default") private final boolean isDefault;

    @ConstructorProperties({ "label", "value", "description", "emoji", "default" })
    public MessageComponentSelectOption(@NotNull String label, @NotNull String value, @Nullable String description, @Nullable Emoji emoji, boolean isDefault) {
        this.label = label;
        this.value = value;
        this.description = description;
        this.emoji = emoji;
        this.isDefault = isDefault;
    }

    public @NotNull String getLabel() {
        return label;
    }

    public @NotNull String getValue() {
        return value;
    }

    public @Nullable String getDescription() {
        return description;
    }

    public @Nullable Emoji getEmoji() {
        return emoji;
    }

    public boolean isDefault() {
        return isDefault;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MessageComponentSelectOption that = (MessageComponentSelectOption) o;
        return isDefault == that.isDefault && label.equals(that.label) && value.equals(that.value) && Objects.equals(description, that.description) && Objects.equals(emoji, that.emoji);
    }

    @Override
    public int hashCode() {
        return Objects.hash(label, value, description, emoji, isDefault);
    }

    @Override
    public String toString() {
        return "MessageComponentSelectOption{" +
                "label='" + label + '\'' +
                ", value='" + value + '\'' +
                ", description='" + description + '\'' +
                ", emoji=" + emoji +
                ", isDefault=" + isDefault +
                '}';
    }
}
