package CoinFactory;

import CoinTypes.Coins;
import CoinTypes.ILS;
import CoinTypes.USD;

public class CoinFactory {
    public static Coin getCoinInstance(Coins coinType)throws IllegalArgumentException {
        switch (coinType) {
            case ILS:
                return new ILS();
            case USD:
                return new USD();
            default:
                throw new IllegalArgumentException
                        ("No such coin type: " + coinType);
        }
    }
}