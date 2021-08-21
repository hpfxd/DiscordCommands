package com.hpfxd.discordcommands.data.channel.embed;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EmbedBuilder {
    private @Nullable String title;
    private @Nullable EmbedType type;
    private @Nullable String description;
    private @Nullable String url;
    private @Nullable Date timestamp;
    private @Nullable Integer color;
    private @Nullable EmbedFooter footer;
    private @Nullable EmbedImage image;
    private @Nullable EmbedThumbnail thumbnail;
    private @Nullable EmbedVideo video;
    private @Nullable EmbedProvider provider;
    private @Nullable EmbedAuthor author;
    private @Nullable List<EmbedField> fields;

    public EmbedBuilder setTitle(@Nullable String title) {
        this.title = title;
        return this;
    }

    public EmbedBuilder setType(@Nullable EmbedType type) {
        this.type = type;
        return this;
    }

    public EmbedBuilder setDescription(@Nullable String description) {
        this.description = description;
        return this;
    }

    public EmbedBuilder setUrl(@Nullable String url) {
        this.url = url;
        return this;
    }

    public EmbedBuilder setTimestamp(@Nullable Date timestamp) {
        this.timestamp = timestamp;
        return this;
    }

    public EmbedBuilder setColor(@Nullable Integer color) {
        this.color = color;
        return this;
    }

    public EmbedBuilder setFooter(@Nullable EmbedFooter footer) {
        this.footer = footer;
        return this;
    }

    public EmbedBuilder setImage(@Nullable EmbedImage image) {
        this.image = image;
        return this;
    }

    public EmbedBuilder setThumbnail(@Nullable EmbedThumbnail thumbnail) {
        this.thumbnail = thumbnail;
        return this;
    }

    public EmbedBuilder setVideo(@Nullable EmbedVideo video) {
        this.video = video;
        return this;
    }

    public EmbedBuilder setProvider(@Nullable EmbedProvider provider) {
        this.provider = provider;
        return this;
    }

    public EmbedBuilder setAuthor(@Nullable EmbedAuthor author) {
        this.author = author;
        return this;
    }

    public EmbedBuilder setFields(@Nullable List<EmbedField> fields) {
        this.fields = fields;
        return this;
    }

    public EmbedBuilder addField(@NotNull EmbedField field) {
        if (this.fields == null) this.fields = new ArrayList<>(1);
        this.fields.add(field);
        return this;
    }

    public Embed build() {
        return new Embed(title, type, description, url, timestamp, color, footer, image, thumbnail, video, provider, author, fields);
    }
}
