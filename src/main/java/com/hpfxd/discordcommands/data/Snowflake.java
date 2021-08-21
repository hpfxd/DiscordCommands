package com.hpfxd.discordcommands.data;

public class Snowflake {
    private final long value;

    public Snowflake(long value) {
        this.value = value;
    }

    public long getValue() {
        return this.value;
    }

    public String getAsString() {
        return String.valueOf(this.value);
    }

    @Override
    public int hashCode() {
        return Long.hashCode(this.value);
    }

    @Override
    public String toString() {
        return "Snowflake{" + this.value + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Snowflake snowflake = (Snowflake) o;
        return this.value == snowflake.value;
    }
}
