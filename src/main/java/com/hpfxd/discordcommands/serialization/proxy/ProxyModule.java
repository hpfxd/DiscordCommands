package com.hpfxd.discordcommands.serialization.proxy;

import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.Module;
import com.fasterxml.jackson.databind.deser.Deserializers;

public class ProxyModule extends Module {
    public String getModuleName() {
        return "proxy-module";
    }

    @Override
    public Version version() {
        return Version.unknownVersion();
    }

    public void setupModule(Module.SetupContext context) {
        context.addDeserializers(new Deserializers.Base() {
            @SuppressWarnings("rawtypes")
            @Override
            public JsonDeserializer<?> findBeanDeserializer(JavaType type, DeserializationConfig config, BeanDescription beanDesc) throws JsonMappingException {
                if (type.isInterface()) {
                    return new ProxyBeanDeserializer(type, config, beanDesc);
                }
                return super.findBeanDeserializer(type, config, beanDesc);
            }
        });
    }
}
