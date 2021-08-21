package com.hpfxd.discordcommands.data.interaction.callback;

import com.hpfxd.discordcommands.data.channel.message.update.MessageUpdate;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.beans.ConstructorProperties;
import java.util.Objects;

public class InteractionCallback {
    public static InteractionCallback of(@NotNull InteractionCallbackType type, @Nullable MessageUpdate data) {
        return new InteractionCallback(type, data);
    }

    public static InteractionCallback of(@NotNull InteractionCallbackType type) {
        return of(type, null);
    }

    private final @NotNull InteractionCallbackType type;
    private final @Nullable MessageUpdate data;

    @ConstructorProperties({ "type", "data" })
    public InteractionCallback(@NotNull InteractionCallbackType type, @Nullable MessageUpdate data) {
        this.type = type;
        this.data = data;
    }

    public @NotNull InteractionCallbackType getType() {
        return type;
    }

    public @Nullable MessageUpdate getData() {
        return data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InteractionCallback that = (InteractionCallback) o;
        return type == that.type && Objects.equals(data, that.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, data);
    }

    @Override
    public String toString() {
        return "InteractionCallback{" +
                "type=" + type +
                ", data=" + data +
                '}';
    }
}
