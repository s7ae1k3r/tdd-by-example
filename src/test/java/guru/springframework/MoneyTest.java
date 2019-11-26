package guru.springframework;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class MoneyTest {

    @Test
    void testMultiplication() {
        Money d5 = MoneyFactory.dollar(5);
        assertEquals(MoneyFactory.dollar(10), d5.times(2));
        assertEquals(MoneyFactory.dollar(15), d5.times(3));

        Money e5 = MoneyFactory.euro(5);
        assertEquals(MoneyFactory.euro(10), e5.times(2));
        assertEquals(MoneyFactory.euro(15), e5.times(3));
    }

    @Test
    void testEquality() {
        assertEquals( MoneyFactory.dollar(5),  MoneyFactory.dollar(5));
        assertNotEquals( MoneyFactory.dollar(5),  MoneyFactory.dollar(10));
        assertEquals(MoneyFactory.euro(5), MoneyFactory.euro(5));
        assertNotEquals(MoneyFactory.euro(5), MoneyFactory.euro(10));
    }

    @Test
    void testCrossCurrencyEquality() {
        assertNotEquals(MoneyFactory.dollar(5), MoneyFactory.euro(5));
    }

    @Test
    void testCurrencyProperty() {
        assertEquals( "USD", MoneyFactory.dollar(1).currency());
        assertEquals( "EURO", MoneyFactory.euro(1).currency());
    }

    @Test
    void testSimpleAddition(){
        Money five = MoneyFactory.dollar(5);
        Expression sum = five.plus(five);
        Bank bank = new Bank();
        Expression reduced = bank.reduce(sum, "USD");
        assertEquals(MoneyFactory.dollar(10), reduced);
    }

    @Test
    void testPlusReturnsSum(){
        Money five = MoneyFactory.dollar(5);
        Expression result = five.plus(five);
        Sum sum = (Sum) result;
        assertEquals(five, sum.augend);
        assertEquals(five, sum.addend);
    }

    @Test
    void testReduceSum(){
        Expression sum = new Sum(MoneyFactory.dollar(3), MoneyFactory.dollar(4));
        Bank bank = new Bank();
        Expression result = bank.reduce(sum, "USD");
        assertEquals(MoneyFactory.dollar(7), result);
    }

    @Test
    void testReduceMoney(){
        Bank bank = new Bank();
        Expression result = bank.reduce(MoneyFactory.dollar(1), "USD");
        assertEquals(MoneyFactory.dollar(1), result);
    }

    @Test
    void testReduceMoneyDifferentCurrency(){
        Bank bank = new Bank();
        bank.addRate("EURO", "USD", 2);
        Expression result = bank.reduce(MoneyFactory.euro(2), "USD");
        assertEquals(MoneyFactory.dollar(1), result);
    }

    @Test
    void testIdentityRate(){
        assertEquals(1, new Bank().rate("USD", "USD"));
        assertEquals(1, new Bank().rate("EURO", "EURO"));
    }

    @Test
    void testMixedAddition(){
        Expression fiveBucks = MoneyFactory.dollar(5);
        Expression tenEuro = MoneyFactory.euro(10);
        Bank bank = new Bank();
        bank.addRate("EURO", "USD", 2);
        Expression sum = new Sum(fiveBucks, tenEuro).plus(fiveBucks);
        Money result = bank.reduce(sum, "USD");

        assertEquals(MoneyFactory.dollar(10), result);
    }

}
