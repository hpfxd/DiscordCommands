package com.hpfxd.discordcommands.data.channel.message;

/**
 * See https://discord.com/developers/docs/resources/channel#reaction-object
 */
public interface Reaction {
    /**
     * @return times this emoji has been used to react
     */
    int getCount();

    /**
     * @return whether the current user reacted using this emoji
     */
    boolean isMe();

    /**
     * @return emoji information
     */
    Emoji getEmoji();
}
