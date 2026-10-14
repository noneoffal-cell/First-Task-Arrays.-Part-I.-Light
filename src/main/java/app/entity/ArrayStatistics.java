package app.entity;

import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.OptionalLong;

public record ArrayStatistics(int id, OptionalLong sum, OptionalDouble average, OptionalInt min, OptionalInt max) {


    @Override
    public String toString() {
        return new StringBuilder()
                .append("Statistics{")
                .append("id=").append(id)
                .append(", sum=").append(format(sum))
                .append(", average=").append(format(average))
                .append(", min=").append(format(min))
                .append(", max=").append(format(max))
                .append('}')
                .toString();
    }

    private String format(OptionalLong value) {
        return value.isPresent()
                ? String.valueOf(value.getAsLong())
                : "N/A";
    }

    private String format(OptionalDouble value) {
        return value.isPresent()
                ? String.valueOf(value.getAsDouble())
                : "N/A";
    }

    private String format(OptionalInt value) {
        return value.isPresent()
                ? String.valueOf(value.getAsInt())
                : "N/A";
    }
}