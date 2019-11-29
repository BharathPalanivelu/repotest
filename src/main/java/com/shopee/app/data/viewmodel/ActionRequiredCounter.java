package com.shopee.app.data.viewmodel;

import android.content.Context;
import android.util.Pair;
import com.garena.android.appkit.b.a;
import com.shopee.app.application.ar;
import com.shopee.app.data.store.SettingConfigStore;
import com.shopee.app.data.store.bf;
import com.shopee.app.util.n;
import java.util.HashSet;
import java.util.Set;

public class ActionRequiredCounter {
    n mEventBus;
    private Set<Pair<Long, Integer>> mIdSet = this.mStore.d();
    SettingConfigStore mSettings;
    bf mStore;

    public ActionRequiredCounter(Context context) {
        ((ar) context).e().inject(this);
    }

    public synchronized int getCount() {
        if (this.mSettings.buyerRatingEnabled()) {
            return this.mIdSet.size();
        }
        return this.mIdSet.size() - getCount(7);
    }

    public synchronized int getCount(int i) {
        int i2;
        i2 = 0;
        for (Pair<Long, Integer> pair : this.mIdSet) {
            if (((Integer) pair.second).intValue() == i) {
                i2++;
            }
        }
        return i2;
    }

    public synchronized void incrementCount(long j, int i) {
        this.mIdSet.add(new Pair(Long.valueOf(j), Integer.valueOf(i)));
        save();
    }

    public synchronized void clear(int i) {
        HashSet hashSet = new HashSet();
        for (Pair next : this.mIdSet) {
            if (((Integer) next.second).intValue() != i) {
                hashSet.add(next);
            }
        }
        this.mIdSet = hashSet;
        save();
    }

    public synchronized Set<Pair<Long, Integer>> getIds() {
        return new HashSet(this.mIdSet);
    }

    public synchronized void remove(long j, int i) {
        this.mIdSet.remove(new Pair(Long.valueOf(j), Integer.valueOf(i)));
        save();
    }

    private void save() {
        saveInBg(new HashSet(this.mIdSet));
    }

    public void saveInBg(Set<Pair<Long, Integer>> set) {
        this.mStore.b(set);
        this.mEventBus.a("ACTION_REQUIRED_BADGE_UPDATE", new a(this));
    }
}
