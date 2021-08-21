package com.hpfxd.discordcommands.data.channel.embed;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.jetbrains.annotations.Nullable;

import java.beans.ConstructorProperties;
import java.util.Objects;

public class EmbedAuthor {
    public static EmbedAuthor of(String name, String url, String icon) {
        return new EmbedAuthor(name, url, icon, null);
    }

    private final @Nullable String name;
    private final @Nullable String url;
    @JsonProperty("icon_url") private final @Nullable String iconURL;
    @JsonProperty("proxy_icon_url") private final @Nullable String proxyIconURL;

    @ConstructorProperties({ "name", "url", "icon_url", "proxy_icon_url" })
    public EmbedAuthor(@Nullable String name, @Nullable String url, @Nullable String iconURL, @Nullable String proxyIconURL) {
        this.name = name;
        this.url = url;
        this.iconURL = iconURL;
        this.proxyIconURL = proxyIconURL;
    }

    public @Nullable String getName() {
        return name;
    }

    public @Nullable String getUrl() {
        return url;
    }

    public @Nullable String getIconURL() {
        return iconURL;
    }

    public @Nullable String getProxyIconURL() {
        return proxyIconURL;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmbedAuthor that = (EmbedAuthor) o;
        return Objects.equals(name, that.name) && Objects.equals(url, that.url) && Objects.equals(iconURL, that.iconURL) && Objects.equals(proxyIconURL, that.proxyIconURL);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, url, iconURL, proxyIconURL);
    }

    @Override
    public String toString() {
        return "EmbedAuthor{" +
                "name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", iconURL='" + iconURL + '\'' +
                ", proxyIconURL='" + proxyIconURL + '\'' +
                '}';
    }
}
