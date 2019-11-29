package com.shopee.app.data.viewmodel;

import android.content.Context;
import com.shopee.app.application.ar;
import com.shopee.app.data.store.bf;
import java.util.HashSet;
import java.util.Set;

public class FollowCounter {
    private Set<Long> mIdSet = this.mStore.e();
    private boolean mShowDot = this.mStore.f();
    bf mStore;

    public FollowCounter(Context context) {
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

    public synchronized boolean isDotShown() {
        return this.mStore.i().isShowing();
    }

    public synchronized void clearDot() {
        this.mShowDot = false;
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

    public synchronized void onReceiveNewRedDot(int i) {
        if (this.mStore.i().isNewData(i)) {
            this.mStore.a(new RedDotData(this.mStore.i().getLastDismissDotCreationTime(), i));
        }
    }

    public RedDotData getRedDotData() {
        return this.mStore.i();
    }

    private void save() {
        if (!this.mShowDot) {
            dismissRedDotData();
        }
        saveInBg(new HashSet(this.mIdSet), this.mShowDot);
    }

    private void dismissRedDotData() {
        RedDotData i = this.mStore.i();
        if (i.isShowing()) {
            this.mStore.a(new RedDotData(i.getCurrentCreationTime(), 0));
        }
    }

    public void saveInBg(Set<Long> set, boolean z) {
        this.mStore.c(set);
        this.mStore.b(z);
    }
}
