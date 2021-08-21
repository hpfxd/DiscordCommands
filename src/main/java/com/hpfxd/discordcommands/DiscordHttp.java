package com.hpfxd.discordcommands;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.concurrent.CompletableFuture;

public class DiscordHttp {
    private static final String API_BASE = "https://discord.com/api/v9";
    private static final String USER_AGENT = "DiscordCommands Library";
    private static final HttpClient httpClient = HttpClient.newHttpClient();

    public static CompletableFuture<HttpResponse<String>> request(@NotNull String method,
                                                                  @NotNull String endpoint,
                                                                  @Nullable String body) {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(API_BASE + endpoint))
                .timeout(Duration.ofSeconds(5))
                .header("User-Agent", USER_AGENT)
                .header("Content-Type", "application/json")
                .method(method, body == null ? HttpRequest.BodyPublishers.noBody() : HttpRequest.BodyPublishers.ofString(body))
                .build();

        return httpClient.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(response -> {
                    if (response.statusCode() >= 400) throw new RuntimeException("Server responded with status code "
                            + response.statusCode() + ": " + response.body());

                    return response;
                });
    }

    public static CompletableFuture<HttpResponse<String>> request(@NotNull String method,
                                                                  @NotNull String endpoint,
                                                                  @NotNull Object bodyObject) {
        try {
            return request(method, endpoint, DiscordJsonMapper.getMapper().writeValueAsString(bodyObject));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public static CompletableFuture<HttpResponse<String>> request(@NotNull String method, @NotNull String endpoint) {
        return request(method, endpoint, null);
    }
}
