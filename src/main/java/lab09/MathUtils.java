package lab09;

/** Small utilities used as the CI demonstration target. */
public final class MathUtils {

    private MathUtils() {}

    /** Clamps value into [min, max]. @throws IllegalArgumentException if min > max. */
    public static int clamp(int value, int min, int max) {
        if (min > max) {
            throw new IllegalArgumentException("min must be <= max");
        }
        return Math.max(min, Math.min(max, value));
    }

    /** Arithmetic mean. @throws IllegalArgumentException if no values are given. */
    public static double average(int... values) {
        if (values.length == 0) {
            throw new IllegalArgumentException("at least one value required");
        }
        long sum = 0;
        for (int v : values) {
            sum += v;
        }
        return (double) sum / values.length;
    }
}
