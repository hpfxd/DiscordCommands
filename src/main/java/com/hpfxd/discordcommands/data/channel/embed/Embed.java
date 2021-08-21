package com.hpfxd.discordcommands.data.channel.embed;

import org.jetbrains.annotations.Nullable;

import java.beans.ConstructorProperties;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * Represents an Embed on Discord.
 *
 * See https://discord.com/developers/docs/resources/channel#embed-object
 */
public class Embed {
    public static EmbedBuilder builder() {
        return new EmbedBuilder();
    }

    private final @Nullable String title;
    private final @Nullable EmbedType type;
    private final @Nullable String description;
    private final @Nullable String url;
    private final @Nullable Date timestamp;
    private final @Nullable Integer color;
    private final @Nullable EmbedFooter footer;
    private final @Nullable EmbedImage image;
    private final @Nullable EmbedThumbnail thumbnail;
    private final @Nullable EmbedVideo video;
    private final @Nullable EmbedProvider provider;
    private final @Nullable EmbedAuthor author;
    private final @Nullable List<EmbedField> fields;

    @ConstructorProperties({
            "title", "type", "description", "url", "timestamp", "color", "footer",
            "image", "thumbnail", "video", "provider", "author", "fields"
    })
    public Embed(@Nullable String title, @Nullable EmbedType type, @Nullable String description, @Nullable String url, @Nullable Date timestamp, @Nullable Integer color, @Nullable EmbedFooter footer, @Nullable EmbedImage image, @Nullable EmbedThumbnail thumbnail, @Nullable EmbedVideo video, @Nullable EmbedProvider provider, @Nullable EmbedAuthor author, @Nullable List<EmbedField> fields) {
        this.title = title;
        this.type = type;
        this.description = description;
        this.url = url;
        this.timestamp = timestamp;
        this.color = color;
        this.footer = footer;
        this.image = image;
        this.thumbnail = thumbnail;
        this.video = video;
        this.provider = provider;
        this.author = author;
        this.fields = fields;
    }

    public @Nullable String getTitle() {
        return title;
    }

    public @Nullable EmbedType getType() {
        return type;
    }

    public @Nullable String getDescription() {
        return description;
    }

    public @Nullable String getUrl() {
        return url;
    }

    public @Nullable Date getTimestamp() {
        return timestamp;
    }

    public @Nullable Integer getColor() {
        return color;
    }

    public @Nullable EmbedFooter getFooter() {
        return footer;
    }

    public @Nullable EmbedImage getImage() {
        return image;
    }

    public @Nullable EmbedThumbnail getThumbnail() {
        return thumbnail;
    }

    public @Nullable EmbedVideo getVideo() {
        return video;
    }

    public @Nullable EmbedProvider getProvider() {
        return provider;
    }

    public @Nullable EmbedAuthor getAuthor() {
        return author;
    }

    public @Nullable List<EmbedField> getFields() {
        return fields;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Embed embed = (Embed) o;
        return Objects.equals(title, embed.title) && type == embed.type && Objects.equals(description, embed.description) && Objects.equals(url, embed.url) && Objects.equals(timestamp, embed.timestamp) && Objects.equals(color, embed.color) && Objects.equals(footer, embed.footer) && Objects.equals(image, embed.image) && Objects.equals(thumbnail, embed.thumbnail) && Objects.equals(video, embed.video) && Objects.equals(provider, embed.provider) && Objects.equals(author, embed.author) && Objects.equals(fields, embed.fields);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, type, description, url, timestamp, color, footer, image, thumbnail, video, provider, author, fields);
    }

    @Override
    public String toString() {
        return "Embed{" +
                "title='" + title + '\'' +
                ", type=" + type +
                ", description='" + description + '\'' +
                ", url='" + url + '\'' +
                ", timestamp=" + timestamp +
                ", color=" + color +
                ", footer=" + footer +
                ", image=" + image +
                ", thumbnail=" + thumbnail +
                ", video=" + video +
                ", provider=" + provider +
                ", author=" + author +
                ", fields=" + fields +
                '}';
    }
}
