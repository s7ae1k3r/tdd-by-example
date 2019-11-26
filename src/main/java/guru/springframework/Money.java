package guru.springframework;

public class Money implements Expression {
    int amount;
    String currency;

    public Money(int inAmount, String inCurrency) {
        amount = inAmount;
        currency = inCurrency;
    }

    public String currency() {
        return currency;
    }

    public Expression times(int x){
        return new Money( amount * x, currency);
    }

    public Expression plus(Expression addend){
        return new Sum(this, addend);
    }

    @Override
    public Money reduce(Bank bank, String to){
        return new Money(amount / bank.rate(this.currency, to), to);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Money)) return false;

        Money m = (Money) o;

        return amount == m.amount &&
                m.currency().equals(currency());
    }

    @Override
    public String toString() {
        return "Money{" +
                "amount=" + amount +
                ", currency='" + currency + '\'' +
                '}';
    }
}
