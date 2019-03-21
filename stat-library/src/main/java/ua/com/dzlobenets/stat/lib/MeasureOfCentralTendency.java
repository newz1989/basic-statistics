package ua.com.dzlobenets.stat.lib;

import javax.annotation.Nonnull;
import java.util.Collection;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * This class describe base methods for Measure of central tendency
 * {mode, average, median}
 */
public class MeasureOfCentralTendency {
    /**
     * return value which occur maximum times
     */
    @Nonnull
    public static <T extends Number> T mode(@Nonnull Collection<T> data) {
        final Map<T, Long> collect = data.stream().collect(
                Collectors.groupingBy(
                        s -> s,
                        Collectors.counting()
                )
        );
        return collect.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .get();
    }


    public static <T extends Number> Double avg(@Nonnull Collection<T> data) {
        return data.stream()
                .collect(Collectors.averagingDouble(Number::doubleValue));
    }

}
