package com.example;

interface CoinHandler {
    void setNext(CoinHandler handler);
    void handle(int amount);
}

