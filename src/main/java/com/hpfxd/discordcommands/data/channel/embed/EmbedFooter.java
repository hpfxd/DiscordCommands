package com.hpfxd.discordcommands.data.channel.embed;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.beans.ConstructorProperties;
import java.util.Objects;

/**
 * See https://discord.com/developers/docs/resources/channel#embed-object-embed-footer-structure
 */
public class EmbedFooter {
    private final @NotNull String text;
    @JsonProperty("icon_url") private final @Nullable String iconURL;
    @JsonProperty("proxy_icon_url") private final @Nullable String proxyIconURL;

    @ConstructorProperties({ "text", "icon_url", "proxy_icon_url" })
    public EmbedFooter(@NotNull String text, @Nullable String iconURL, @Nullable String proxyIconURL) {
        this.text = text;
        this.iconURL = iconURL;
        this.proxyIconURL = proxyIconURL;
    }

    /**
     * @return footer text
     */
    public @NotNull String getText() {
        return text;
    }

    /**
     * @return url of footer icon (only supports http(s) and attachments)
     */
    public @Nullable String getIconURL() {
        return iconURL;
    }

    /**
     * @return a proxied url of footer icon
     */
    public @Nullable String getProxyIconURL() {
        return proxyIconURL;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmbedFooter that = (EmbedFooter) o;
        return text.equals(that.text) && Objects.equals(iconURL, that.iconURL) && Objects.equals(proxyIconURL, that.proxyIconURL);
    }

    @Override
    public int hashCode() {
        return Objects.hash(text, iconURL, proxyIconURL);
    }

    @Override
    public String toString() {
        return "EmbedFooter{" +
                "text='" + text + '\'' +
                ", iconURL='" + iconURL + '\'' +
                ", proxyIconURL='" + proxyIconURL + '\'' +
                '}';
    }
}
