package guru.springframework;

class MoneyFactory {

    static Money dollar(int amount){
        return new Dollar(amount);
    }

    static Money euro(int amount){
        return new Euro(amount);
    }
}
