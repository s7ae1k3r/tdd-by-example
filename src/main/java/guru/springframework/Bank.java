package guru.springframework;

import java.util.HashMap;

public class Bank {

    private HashMap<Pair, Integer> rateMap = new HashMap<>();

    Expression reduce(Expression source, String toCurrency){
        return source.reduce(this, toCurrency);
    }

    public int rate(String from, String to){
        if(from.equals(to))
            return 1;

        return rateMap.get(new Pair(from, to));
    }

    public void addRate(String fromCurrency, String toCurrency, int rate) {
        rateMap.put(new Pair(fromCurrency, toCurrency), rate);
    }
}
