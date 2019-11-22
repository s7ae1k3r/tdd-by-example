package guru.springframework;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;

class MoneyTest {
    @Test
    void testMultiplicationDollar() {
        Money five = MoneyFactory.dollar(5);
        assertEquals(MoneyFactory.dollar(10), five.times(2));
        assertEquals(MoneyFactory.dollar(15), five.times(3));
    }

    @Test
    void testEqualityDollar() {
        assertEquals( MoneyFactory.dollar(5),  MoneyFactory.dollar(5));
        assertNotEquals( MoneyFactory.dollar(5),  MoneyFactory.dollar(10));
    }

    @Test
    void testMultiplicationEuro() {
        Money five = MoneyFactory.euro(5);
        assertEquals(MoneyFactory.euro(10), five.times(2));
        assertEquals(MoneyFactory.euro(15), five.times(3));
    }

    @Test
    void testEqualityEuro() {
        assertEquals(MoneyFactory.euro(5), MoneyFactory.euro(5));
        assertNotEquals(MoneyFactory.euro(5), MoneyFactory.euro(10));
    }

    @Test
    void testCrossCurrencyEquality() {
        assertNotEquals(MoneyFactory.dollar(5), MoneyFactory.euro(5));
    }
}
