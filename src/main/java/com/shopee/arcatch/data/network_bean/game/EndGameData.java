package com.shopee.arcatch.data.network_bean.game;

import com.google.a.a.c;

public class EndGameData {
    @c(a = "award")
    private String award;
    @c(a = "catch_coins")
    private float catchCoins;
    @c(a = "group_bonus")
    private float groupBonus;

    public float getGroupBonus() {
        return this.groupBonus;
    }

    public void setGroupBonus(float f2) {
        this.groupBonus = f2;
    }

    public float getCatchCoins() {
        return this.catchCoins;
    }

    public void setCatchCoins(float f2) {
        this.catchCoins = f2;
    }

    public String getAward() {
        return this.award;
    }

    public void setAward(String str) {
        this.award = str;
    }
}
