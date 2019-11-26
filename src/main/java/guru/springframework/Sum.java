package guru.springframework;

public class Sum implements Expression{
    Expression augend;
    Expression addend;

    public Sum(Expression augend, Expression addend) {
        this.augend = augend;
        this.addend = addend;
    }

    @Override
    public Money reduce(Bank bank, String to){
        int amount = ((Money)augend.reduce(bank, to)).amount + ((Money)addend.reduce(bank, to)).amount;
        return new Money(amount, to);
    }

    @Override
    public Expression plus(Expression addend){
        return new Sum(this, addend);
    }
}
