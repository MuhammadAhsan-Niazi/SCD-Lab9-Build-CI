package lab09;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MathUtilsTest {

    @Test
    void clampKeepsInRangeValueUnchanged() {
        assertEquals(5, MathUtils.clamp(5, 0, 10));
    }

    @Test
    void clampLowerAndUpperBounds() {
        assertEquals(0, MathUtils.clamp(-3, 0, 10));
        assertEquals(10, MathUtils.clamp(42, 0, 10));
    }

    @Test
    void clampRejectsInvertedRange() {
        assertThrows(IllegalArgumentException.class, () -> MathUtils.clamp(1, 10, 0));
    }

    @Test
    void averageOfValues() {
        assertEquals(3.0, MathUtils.average(1, 2, 3, 4), 0.0001);
    }

    @Test
    void averageOfNoValuesRejected() {
        assertThrows(IllegalArgumentException.class, () -> MathUtils.average());
    }
}
