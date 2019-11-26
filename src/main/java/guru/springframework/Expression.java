package guru.springframework;

public interface Expression {
    Expression reduce(Bank bank, String to);
    Expression plus(Expression addend);
}
