package com.example;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        ATM atm = new ATM();

        Map<Integer, Integer> coinOne = new HashMap<>();
        coinOne.put(1, 10);
        CoinHandler coinOneHandler = new CoinDenomination(1, coinOne);

        Map<Integer, Integer> coinFive = new HashMap<>();
        coinFive.put(5, 5);
        CoinHandler coinFiveHandler = new CoinDenomination(5, coinFive);

        Map<Integer, Integer> coinTen = new HashMap<>();
        coinTen.put(10, 3);
        CoinHandler coinTenHandler = new CoinDenomination(10, coinTen);

        atm.addHandler(coinOneHandler);
        atm.addHandler(coinFiveHandler);
        atm.addHandler(coinTenHandler);

        int goal = 15;
        System.out.println("Goal: " + goal);
        atm.withdraw(goal);
    }
}