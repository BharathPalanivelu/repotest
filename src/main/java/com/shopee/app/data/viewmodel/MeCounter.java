package com.shopee.app.data.viewmodel;

import android.content.Context;
import com.garena.android.appkit.b.a;
import com.shopee.app.application.ar;
import com.shopee.app.data.store.bf;
import com.shopee.app.util.n;

public class MeCounter {
    private int cartCount = this.mStore.g();
    private long coinCount = this.mStore.h();
    n mEventBus;
    bf mStore;

    public MeCounter(Context context) {
        ((ar) context).e().inject(this);
    }

    public synchronized int getCartCount() {
        return this.cartCount;
    }

    public synchronized void setCartCount(int i) {
        this.cartCount = i;
        saveCart();
    }

    public synchronized long getCoinCount() {
        return this.coinCount;
    }

    public synchronized void setCoinCount(long j) {
        this.coinCount = Math.max(j, 0);
        saveCoin();
    }

    /* access modifiers changed from: package-private */
    public void saveCoin() {
        this.mStore.a(this.coinCount);
    }

    private void saveCart() {
        saveInBg(this.cartCount);
    }

    public void saveInBg(int i) {
        this.mStore.a(i);
        this.mEventBus.a("ME_TAB_BADGE_UPDATE", new a(this));
    }
}
