package com.shopee.live.livestreaming.data.entity;

import com.shopee.sdk.b.a;

public class LiveStreamingRoomConfigEntity extends a {
    private int can_claim;
    private int claim_times_left;
    private int coin_status;
    private float coins_per_claim;
    private int remain_locks;
    private int required_watch_time;

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

    public int getCan_claim() {
        return this.can_claim;
    }

    public void setCan_claim(int i) {
        this.can_claim = i;
    }

    public int getRemain_locks() {
        return this.remain_locks;
    }

    public void setRemain_locks(int i) {
        this.remain_locks = i;
    }

    public int getClaim_times_left() {
        return this.claim_times_left;
    }

    public void setClaim_times_left(int i) {
        this.claim_times_left = i;
    }

    public int getRequired_watch_time() {
        return this.required_watch_time;
    }

    public void setRequired_watch_time(int i) {
        this.required_watch_time = i;
    }
}
