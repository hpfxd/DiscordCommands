package com.hpfxd.discordcommands.data.channel.message;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.hpfxd.discordcommands.data.Snowflake;
import com.hpfxd.discordcommands.data.User;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.beans.ConstructorProperties;
import java.util.List;
import java.util.Objects;

/**
 * See https://discord.com/developers/docs/resources/emoji#emoji-object-emoji-structure
 */
public class Emoji {
    public static Emoji of(@NotNull Snowflake id, @NotNull String name, @Nullable Boolean animated) {
        return new Emoji(id, name, null, null, animated, false, false, false);
    }

    public static Emoji of(@NotNull Snowflake id, @NotNull String name) {
        return of(id, name, null);
    }

    private final @Nullable Snowflake id;
    private final @Nullable String name;
    private final @Nullable List<Snowflake> roles;
    private final @Nullable User user;
    @JsonProperty("require_colons") private final @Nullable Boolean requireColons;
    private final @Nullable Boolean managed;
    private final @Nullable Boolean animated;
    private final @Nullable Boolean available;

    @ConstructorProperties({
            "id", "name", "roles", "user", "require_colons",
            "managed", "animated", "available"
    })
    public Emoji(@Nullable Snowflake id, @Nullable String name, @Nullable List<Snowflake> roles, @Nullable User user, @Nullable Boolean requireColons, @Nullable Boolean managed, @Nullable Boolean animated, @Nullable Boolean available) {
        this.id = id;
        this.name = name;
        this.roles = roles;
        this.user = user;
        this.requireColons = requireColons;
        this.managed = managed;
        this.animated = animated;
        this.available = available;
    }

    public @Nullable Snowflake getId() {
        return id;
    }

    public @Nullable String getName() {
        return name;
    }

    public @Nullable List<Snowflake> getRoles() {
        return roles;
    }

    public @Nullable User getUser() {
        return user;
    }

    public @Nullable Boolean isRequireColons() {
        return requireColons;
    }

    public @Nullable Boolean isManaged() {
        return managed;
    }

    public @Nullable Boolean isAnimated() {
        return animated;
    }

    public @Nullable Boolean isAvailable() {
        return available;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Emoji emoji = (Emoji) o;
        return requireColons == emoji.requireColons && managed == emoji.managed && animated == emoji.animated && available == emoji.available && Objects.equals(id, emoji.id) && Objects.equals(name, emoji.name) && Objects.equals(roles, emoji.roles) && Objects.equals(user, emoji.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, roles, user, requireColons, managed, animated, available);
    }

    @Override
    public String toString() {
        return "Emoji{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", roles=" + roles +
                ", user=" + user +
                ", requireColons=" + requireColons +
                ", managed=" + managed +
                ", animated=" + animated +
                ", available=" + available +
                '}';
    }
}
