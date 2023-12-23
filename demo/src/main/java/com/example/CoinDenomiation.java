package com.example;

import java.util.Map;

class CoinDenomination implements CoinHandler {
    final int denomination;
    CoinHandler next;
    final Map<Integer, Integer> availableCoins;

    public CoinDenomination(int denomination, Map<Integer, Integer> availableCoins) {
        this.denomination = denomination;
        this.availableCoins = availableCoins;
    }

    @Override
    public void setNext(CoinHandler handler) {
        next = handler;
    }

    @Override
    public void handle(int amount) {
        int count = Math.min(amount / denomination, availableCoins.getOrDefault(denomination, 0));
        int remainingAmount = amount - count * denomination;

        if (count > 0) {
            System.out.println(count + " coin of " + denomination);
        }

        if (remainingAmount > 0 && next != null) {
            next.handle(remainingAmount);
        } else if (remainingAmount > 0) {
            System.out.println("Can't fulfill");
        }
    }
}

