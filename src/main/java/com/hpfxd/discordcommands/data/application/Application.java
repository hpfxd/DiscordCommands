package com.hpfxd.discordcommands.data.application;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.hpfxd.discordcommands.data.Snowflake;
import com.hpfxd.discordcommands.data.User;
import com.hpfxd.discordcommands.data.application.team.Team;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

/**
 * See https://discord.com/developers/docs/resources/application#application-object
 */
public interface Application {
    /**
     * @return the id of the app
     */
    @NotNull Snowflake getId();

    /**
     * @return the name of the app
     */
    @NotNull String getName();

    /**
     * @return the icon hash of the app
     */
    @Nullable String getIcon();

    /**
     * @return the description of the app
     */
    @NotNull String getDescription();

    /**
     * @return an array of rpc origin urls, if rpc is enabled
     */
    @JsonProperty("rpc_origins") @Nullable List<String> getRpcOrigins();

    /**
     * @return when false only app owner can join the app's bot to guilds
     */
    @JsonProperty("bot_public") boolean isBotPublic();

    /**
     * @return when true the app's bot will only join upon completion of the full oauth2 code grant flow
     */
    @JsonProperty("bot_require_code_grant") boolean isBotRequireCodeGrant();

    /**
     * @return the url of the app's terms of service
     */
    @JsonProperty("terms_of_service_url") @Nullable String getTermsOfServiceURL();

    /**
     * @return the url of the app's privacy policy
     */
    @JsonProperty("privacy_policy_url") @Nullable String getPrivacyPolicyURL();

    /**
     * @return partial user object containing info on the owner of the application
     */
    @Nullable User getOwner();

    /**
     * @return if this application is a game sold on Discord, this field will be the summary field for the store page of its primary sku
     */
    @NotNull String getSummary();

    /**
     * @return the hex encoded key for verification in interactions and the GameSDK's GetTicket
     */
    @JsonProperty("verify_key") @NotNull String getVerifyKey();

    /**
     * @return if the application belongs to a team, this will be a list of the members of that team
     */
    @Nullable Team getTeam();

    /**
     * @return if this application is a game sold on Discord, this field will be the guild to which it has been linked
     */
    @JsonProperty("guild_id") @Nullable Snowflake getGuildId();

    /**
     * @return if this application is a game sold on Discord, this field will be the id of the "Game SKU" that is created, if exists
     */
    @JsonProperty("primary_sku_id") @Nullable Snowflake getPrimarySkuId();

    /**
     * @return if this application is a game sold on Discord, this field will be the URL slug that links to the store page
     */
    @Nullable String getSlug();

    /**
     * @return the application's default rich presence invite cover image hash
     */
    @JsonProperty("cover_image") @Nullable String getCoverImage();

    /**
     * @return the application's public flags
     */
    @Nullable Integer getFlags();
}
