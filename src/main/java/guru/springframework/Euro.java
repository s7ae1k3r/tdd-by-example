package guru.springframework;

public class Euro extends Money{
    public Money times(int x){
        return new Euro(amount * x);
    }

    Euro(int inValue) {
        amount = inValue;
    }

    @Override
    public int hashCode() {
        return amount;
    }
}
