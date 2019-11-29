package com.shopee.app.data.viewmodel;

import android.content.Context;
import com.garena.android.appkit.b.a;
import com.shopee.app.application.ar;
import com.shopee.app.data.store.bf;
import com.shopee.app.util.n;
import java.util.HashSet;
import java.util.Set;

public class ActivityCounter {
    n mEventBus;
    private Set<Long> mIdSet = this.mStore.b();
    private boolean mShowDot = this.mStore.c();
    bf mStore;

    public ActivityCounter(Context context) {
        ((ar) context).e().inject(this);
    }

    public synchronized int getCount() {
        return this.mIdSet.size();
    }

    public synchronized void incrementCount(long j) {
        this.mIdSet.add(Long.valueOf(j));
        this.mShowDot = true;
        save();
    }

    public synchronized void clear() {
        this.mIdSet.clear();
        this.mShowDot = false;
        save();
    }

    public synchronized Set<Long> getIds() {
        return new HashSet(this.mIdSet);
    }

    public synchronized void remove(long j) {
        this.mIdSet.remove(Long.valueOf(j));
        save();
    }

    private void save() {
        saveInBg(new HashSet(this.mIdSet), this.mShowDot);
    }

    public void saveInBg(Set<Long> set, boolean z) {
        this.mStore.a(set);
        this.mStore.a(z);
        this.mEventBus.a("ACTIVITY_BADGE_UPDATE", new a(this));
    }
}
