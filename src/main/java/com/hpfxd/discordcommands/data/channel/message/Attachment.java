package com.hpfxd.discordcommands.data.channel.message;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.hpfxd.discordcommands.data.Snowflake;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * See https://discord.com/developers/docs/resources/channel#attachment-object
 */
public interface Attachment {
    /**
     * @return attachment id
     */
    @NotNull Snowflake getId();

    /**
     * @return name of the file attached
     */
    @NotNull String getFilename();

    /**
     * @return the attachment's media type
     */
    @JsonProperty("content_type") @Nullable String getContentType();

    /**
     * @return size of file in bytes
     */
    int getSize();

    /**
     * @return source url of file
     */
    @NotNull String getURL();

    /**
     * @return a proxied url of file
     */
    @JsonProperty("proxy_url") @NotNull String getProxyURL();

    /**
     * @return height of file (if image)
     */
    @Nullable Integer getHeight();

    /**
     * @return width of file (if image)
     */
    @Nullable Integer getWidth();
}
