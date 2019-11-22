package guru.springframework;

public abstract class Money {
    int amount;

    public abstract Money times(int x);

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Money)) return false;

        Money m = (Money) o;

        return amount == m.amount &&
                m.getClass().equals(getClass());
    }
}
