package com.hpfxd.discordcommands;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.hpfxd.discordcommands.data.Snowflake;
import com.hpfxd.discordcommands.serialization.SnowflakeDeserializer;
import com.hpfxd.discordcommands.serialization.SnowflakeSerializer;
import com.hpfxd.discordcommands.serialization.proxy.ProxyModule;

public class DiscordJsonMapper {
    private static final ObjectMapper mapper = new ObjectMapper();

    static {
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        mapper.configure(DeserializationFeature.FAIL_ON_MISSING_EXTERNAL_TYPE_ID_PROPERTY, false);

        SimpleModule module = new SimpleModule();

        module.addDeserializer(Snowflake.class, new SnowflakeDeserializer());
        module.addSerializer(Snowflake.class, new SnowflakeSerializer());

        mapper.registerModule(new ProxyModule());
        mapper.registerModule(module);
    }

    public static ObjectMapper getMapper() {
        return mapper;
    }
}
