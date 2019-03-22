package ua.com.dzlobenets.stat.lib;

import javax.annotation.Nonnegative;
import javax.annotation.Nonnull;
import java.util.*;
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

    @Nonnull
    public static <T extends Number>
    Double avg(@Nonnull Collection<T> data) {
        return data.stream()
                .collect(Collectors.averagingDouble(Number::doubleValue));
    }

    @Nonnull
    public static <T extends Number & Comparable<? super T>>
    Double median(final @Nonnull Collection<T> data) {

        final List<T> list = new ArrayList<>(data);
        list.sort(Comparator.naturalOrder());

        int size = data.size();

        if (even(size)) {
            final int half = size / 2;
            T median1 = list.get(half);
            T median2 = list.get(half - 1);

            return calculateMedian(median1, median2);
        } else {
            return list.get(size / 2).doubleValue();
        }
    }

    private static boolean even(@Nonnegative int size) {
        return (size % 2) == 0;
    }

    @Nonnull
    private static <T extends Number & Comparable<? super T>>
    Double calculateMedian(@Nonnull T median1, @Nonnull T median2) {
        final double doubleMedian1 = median1.doubleValue();
        final double doubleMedian2 = median2.doubleValue();

        return (doubleMedian1 + doubleMedian2) / 2d;
    }

}
