package com.hpfxd.discordcommands.data.channel.embed;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.jetbrains.annotations.Nullable;

import java.beans.ConstructorProperties;
import java.util.Objects;

public class EmbedThumbnail {
    private final @Nullable String url;
    @JsonProperty("proxy_url") private final @Nullable String proxyURL;
    private final @Nullable Integer height;
    private final @Nullable Integer width;

    @ConstructorProperties({ "url", "proxy_url", "height", "width" })
    public EmbedThumbnail(@Nullable String url, @Nullable String proxyURL, @Nullable Integer height, @Nullable Integer width) {
        this.url = url;
        this.proxyURL = proxyURL;
        this.height = height;
        this.width = width;
    }

    /**
     * @return source url of image (only supports http(s) and attachments)
     */
    public @Nullable String getURL() {
        return url;
    }

    /**
     * @return a proxied url of the image
     */
    public @Nullable String getProxyURL() {
        return proxyURL;
    }

    /**
     * @return height of image
     */
    public @Nullable Integer getHeight() {
        return height;
    }

    /**
     * @return width of image
     */
    public @Nullable Integer getWidth() {
        return width;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmbedThumbnail that = (EmbedThumbnail) o;
        return Objects.equals(url, that.url) && Objects.equals(proxyURL, that.proxyURL) && Objects.equals(height, that.height) && Objects.equals(width, that.width);
    }

    @Override
    public int hashCode() {
        return Objects.hash(url, proxyURL, height, width);
    }

    @Override
    public String toString() {
        return "EmbedThumbnail{" +
                "url='" + url + '\'' +
                ", proxyURL='" + proxyURL + '\'' +
                ", height=" + height +
                ", width=" + width +
                '}';
    }
}
