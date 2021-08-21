# DiscordCommands
Java library for handling Discord interactions.

## Installation
DiscordCommands requires Java 11, for the following reasons:
- [salty-coffee](https://github.com/NeilMadden/salty-coffee) (library used for verifying Discord's interaction signatures) requires Java 11
- We use the Java 9 HTTP Client for sending requests to Discord.

Artifacts are available from my Maven repository:

```xml
<repositories>
    <repository>
        <id>hpfxd-repo</id>
        <url>https://repo.hpfxd.com/releases/</url>
    </repository>
</repositories>

<dependencies>
    <dependency>
        <groupId>com.hpfxd.discordcommands</groupId>
        <artifactId>DiscordCommands</artifactId>
        <version>1.0.0</version>
    </dependency>
</dependencies>
```

## Usage
```java
CommandManager commandManager = new CommandManager();

commandManager.registerCommandHandler("testcommand", interaction -> {
    // Respond with "hello!", and add a button to the message
    return InteractionCallback.of(InteractionCallbackType.CHANNEL_MESSAGE_WITH_SOURCE,
        MessageUpdate.builder()
            .setContent("hello!")
            .addComponent(MessageComponent.builder()
                .setType(MessageComponentType.ACTION_ROW)
                .addComponent(MessageComponent.builder()
                    .setType(MessageComponentType.BUTTON)
                    .setStyle(ButtonStyle.PRIMARY)
                    .setCustomId("example-button")
                    .setLabel("A button!")
                .build())
        .build()).build());
});

commandManager.registerComponentHandler("example-button", (interaction) -> {
    // Edit the original message
    return InteractionCallback.of(InteractionCallbackType.UPDATE_MESSAGE,
        MessageUpdate.builder()
            .setContent("You pressed the button!")
        .build());
});

// Start the HTTP server for Discord to contact us at
// You must set your interaction URL in your application dashboard.
// The HTTP server must be accessible by Discord. (You can use something such as ngrok for testing)
new CommandHttpServer(commandManager,
        new InetSocketAddress("0.0.0.0", 1337), // Listen on 0.0.0.0, with port 1337
        InteractionVerifier.of("Your public key"), null); // Your public key from your Discord application dashboard
```
The results:

![Example Screenshot 1](https://i.hpfxd.com/x1Vg)  
![Example Screenshot 2](https://i.hpfxd.com/keP4)

Note that this library does not handle registering commands with Discord, only handling them.  
You must register your commands manually, such as with [this tool](https://rauf.wtf/slash/).

If you ever find that your interactions are failing, you can enable debug logging by setting the system property `discordcommands.debug` to true.
For example: `java -Ddiscordcommands.debug=true -jar YourApplication.jar`
