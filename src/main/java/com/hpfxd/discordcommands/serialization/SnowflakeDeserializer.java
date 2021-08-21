package com.hpfxd.discordcommands.serialization;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.hpfxd.discordcommands.data.Snowflake;

import java.io.IOException;

public class SnowflakeDeserializer extends StdDeserializer<Snowflake> {
    public SnowflakeDeserializer() {
        super(Snowflake.class);
    }

    @Override
    public Snowflake deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        long id = Long.parseLong(p.getValueAsString());

        return new Snowflake(id);
    }
}
