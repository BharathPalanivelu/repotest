package com.facebook.imagepipeline.memory;

import com.facebook.common.internal.VisibleForTesting;
import java.util.HashSet;
import java.util.Set;

public abstract class LruBucketsPoolBackend<T> implements PoolBackend<T> {
    private final Set<T> mCurrentItems = new HashSet();
    private final BucketMap<T> mMap = new BucketMap<>();

    public T get(int i) {
        return maybeRemoveFromCurrentItems(this.mMap.acquire(i));
    }

    public void put(T t) {
        boolean add;
        synchronized (this) {
            add = this.mCurrentItems.add(t);
        }
        if (add) {
            this.mMap.release(getSize(t), t);
        }
    }

    public T pop() {
        return maybeRemoveFromCurrentItems(this.mMap.removeFromEnd());
    }

    private T maybeRemoveFromCurrentItems(T t) {
        if (t != null) {
            synchronized (this) {
                this.mCurrentItems.remove(t);
            }
        }
        return t;
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public int valueCount() {
        return this.mMap.valueCount();
    }
}
