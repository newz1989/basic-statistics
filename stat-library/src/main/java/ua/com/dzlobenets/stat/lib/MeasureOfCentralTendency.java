package ua.com.dzlobenets.stat.lib;

import javax.annotation.Nonnull;
import java.util.Collection;
import java.util.Map;
import java.util.stream.Collectors;

public class MeasureOfCentralTendency {

    @Nonnull
    public static <T> T mode(@Nonnull Collection<? extends T> data) {
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

}
