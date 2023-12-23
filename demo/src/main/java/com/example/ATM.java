package com.example;

class ATM {
    private CoinHandler chain;

    public void addHandler(CoinHandler handler) {
        if (chain == null) {
            chain = handler;
        } else {
            CoinHandler current = chain;

            while (current != null) {
                if (current instanceof CoinDenomination && handler instanceof CoinDenomination) {
                    CoinDenomination currentDenomination = (CoinDenomination) current;

                    if (currentDenomination.denomination == ((CoinDenomination) handler).denomination) {
                        currentDenomination.availableCoins.putAll(((CoinDenomination) handler).availableCoins);

                        return;
                    }
                }
                if (current instanceof CoinDenomination && ((CoinDenomination) current).next == null) {
                    ((CoinDenomination) current).setNext(handler);

                    return;
                }

                current = ((CoinDenomination) current).next;
            }
        }
    }

    public void withdraw(int amount) {
        if (chain != null) {
            chain.handle(amount);
        }
    }
}