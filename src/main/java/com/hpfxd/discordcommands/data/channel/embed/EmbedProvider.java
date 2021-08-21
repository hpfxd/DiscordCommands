package com.hpfxd.discordcommands.data.channel.embed;

import org.jetbrains.annotations.Nullable;

import java.beans.ConstructorProperties;
import java.util.Objects;

public class EmbedProvider {
    private final @Nullable String name;
    private final @Nullable String url;

    @ConstructorProperties({ "name", "url" })
    public EmbedProvider(@Nullable String name, @Nullable String url) {
        this.name = name;
        this.url = url;
    }

    public @Nullable String getName() {
        return name;
    }

    public @Nullable String getUrl() {
        return url;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmbedProvider that = (EmbedProvider) o;
        return Objects.equals(name, that.name) && Objects.equals(url, that.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, url);
    }

    @Override
    public String toString() {
        return "EmbedProvider{" +
                "name='" + name + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
