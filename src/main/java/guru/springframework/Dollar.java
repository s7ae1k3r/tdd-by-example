package guru.springframework;

public class Dollar extends Money{
    public Money times(int x){
        return new Dollar(amount * x);
    }

    Dollar(int inValue) {
        amount = inValue;
    }

    @Override
    public int hashCode() { return amount; }
}
