package com.hpfxd.discordcommands.serialization.proxy;

import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class PropertyAccessorsInfo {
    private final Map<Method, String> readMethods;
    private final Map<Method, String> writeMethods;

    public PropertyAccessorsInfo(Map<Method, String> readMethods, Map<Method, String> writeMethods) {
        this.readMethods = readMethods;
        this.writeMethods = writeMethods;
    }

    public boolean isGetter(Method method) {
        return readMethods.containsKey(method);
    }

    public boolean isSetter(Method method) {
        return writeMethods.containsKey(method);
    }

    public String getPropertyName(Method method) {
        return Optional.ofNullable(readMethods.get(method)).orElse(writeMethods.get(method));
    }

    public static PropertyAccessorsInfo introspect(Class<?> clazz) throws IntrospectionException {
        final Map<Method, String> readMethods = new HashMap<>();
        final Map<Method, String> writeMethods = new HashMap<>();
        introspect0(clazz, readMethods, writeMethods);
        return new PropertyAccessorsInfo(readMethods, writeMethods);
    }

    private static void introspect0(Class<?> clazz, Map<Method, String> readMethods, Map<Method, String> writeMethods) throws IntrospectionException {
        Class<?>[] interfaces = clazz.getInterfaces();
        for (Class<?> s : interfaces) {
            introspect0(s, readMethods, writeMethods);
        }

        for (PropertyDescriptor property : Introspector.getBeanInfo(clazz).getPropertyDescriptors()) {
            if (property.getReadMethod() != null) {
                readMethods.put(property.getReadMethod(), property.getName());
            }
            if (property.getWriteMethod() != null) {
                writeMethods.put(property.getWriteMethod(), property.getName());
            }
        }
    }
}
