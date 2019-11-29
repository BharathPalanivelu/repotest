package com.shopee.live.livestreaming.sztracking;

import java.util.ArrayList;
import java.util.List;

public class SimpleCacheQueue<T> {
    private static final int SIZE = 10;
    private ArrayList<T> mItems;
    private int mSize;

    public SimpleCacheQueue() {
        this(10);
    }

    public SimpleCacheQueue(int i) {
        this.mSize = i;
        this.mItems = new ArrayList<>();
    }

    public synchronized void put(T t) {
        if (t != null) {
            if (this.mItems.size() == this.mSize) {
                this.mItems.remove(0);
            }
            this.mItems.add(t);
        }
    }

    public synchronized List<T> get() {
        return this.mItems;
    }
}
