package CoinTypes;

import CoinFactory.Coin;

public class USD extends Coin {

    final double value = 3.52;

    @Override
    public double getValue() {
        return value;
    }

    @Override
    public double calculate(double input) {
        return input * getValue();
    }
}