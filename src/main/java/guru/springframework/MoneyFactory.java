package guru.springframework;

class MoneyFactory {

    static Money dollar(int amount){
        return new Money(amount, "USD");
    }

    static Money euro(int amount){
        return new Money(amount, "EURO");
    }
}
