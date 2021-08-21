package com.hpfxd.discordcommands.data.channel.embed;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.beans.ConstructorProperties;
import java.util.Objects;

public class EmbedField {
    public static EmbedField of(String name, String value, boolean inline) {
        return new EmbedField(name, value, inline);
    }

    public static EmbedField of(String name, String value) {
        return of(name, value, false);
    }

    public static EmbedField blank() {
        return blank(false);
    }

    public static EmbedField blank(boolean inline) {
        return of("\u200b", "\u200b", inline); // zero-width spaces
    }

    private final @NotNull String name;
    private final @NotNull String value;
    private final @Nullable Boolean inline;

    @ConstructorProperties({ "name", "value", "inline" })
    public EmbedField(@NotNull String name, @NotNull String value, @Nullable Boolean inline) {
        this.name = name;
        this.value = value;
        this.inline = inline;
    }

    public @NotNull String getName() {
        return name;
    }

    public @NotNull String getValue() {
        return value;
    }

    public @Nullable Boolean getInline() {
        return inline;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmbedField that = (EmbedField) o;
        return name.equals(that.name) && value.equals(that.value) && Objects.equals(inline, that.inline);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, value, inline);
    }

    @Override
    public String toString() {
        return "EmbedField{" +
                "name='" + name + '\'' +
                ", value='" + value + '\'' +
                ", inline=" + inline +
                '}';
    }
}
