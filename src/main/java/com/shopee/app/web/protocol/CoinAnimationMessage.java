package com.shopee.app.web.protocol;

import com.google.a.a.c;

public class CoinAnimationMessage {
    @c(a = "coinsToAdd")
    private int coinsToAdd;
    @c(a = "currentCoins")
    private int currentCoins;

    public int getCurrentCoins() {
        return this.currentCoins;
    }

    public int getCoinsToAdd() {
        return this.coinsToAdd;
    }
}
