package com.shopee.live.livestreaming.data.entity;

import com.shopee.sdk.b.a;

public class AnchorCoinEntity extends a {
    private int claim_times;
    private int claims_left;
    private int coin_status;
    private float coins_per_claim;
    private int giveout;
    private int interval;
    private int shown_coins;

    public int getCoin_status() {
        return this.coin_status;
    }

    public void setCoin_status(int i) {
        this.coin_status = i;
    }

    public float getCoins_per_claim() {
        return this.coins_per_claim;
    }

    public void setCoins_per_claim(float f2) {
        this.coins_per_claim = f2;
    }

    public int getClaim_times() {
        return this.claim_times;
    }

    public void setClaim_times(int i) {
        this.claim_times = i;
    }

    public int getGiveout() {
        return this.giveout;
    }

    public void setGiveout(int i) {
        this.giveout = i;
    }

    public int getInterval() {
        return this.interval;
    }

    public void setInterval(int i) {
        this.interval = i;
    }

    public int getShown_coins() {
        return this.shown_coins;
    }

    public void setShown_coins(int i) {
        this.shown_coins = i;
    }

    public int getClaims_left() {
        return this.claims_left;
    }

    public void setClaims_left(int i) {
        this.claims_left = i;
    }
}
