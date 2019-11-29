package com.thoughtworks.xstream.core.util;

public class Pool {
    private final Factory factory;
    private final int initialPoolSize;
    private final int maxPoolSize;
    private transient Object mutex = new Object();
    private transient int nextAvailable;
    private transient Object[] pool;

    public interface Factory {
        Object newInstance();
    }

    public Pool(int i, int i2, Factory factory2) {
        this.initialPoolSize = i;
        this.maxPoolSize = i2;
        this.factory = factory2;
    }

    public Object fetchFromPool() {
        Object obj;
        synchronized (this.mutex) {
            if (this.pool == null) {
                this.pool = new Object[this.maxPoolSize];
                this.nextAvailable = this.initialPoolSize;
                while (this.nextAvailable > 0) {
                    putInPool(this.factory.newInstance());
                }
            }
            while (this.nextAvailable == this.maxPoolSize) {
                try {
                    this.mutex.wait();
                } catch (InterruptedException e2) {
                    throw new RuntimeException("Interrupted whilst waiting for a free item in the pool : " + e2.getMessage());
                }
            }
            Object[] objArr = this.pool;
            int i = this.nextAvailable;
            this.nextAvailable = i + 1;
            obj = objArr[i];
            if (obj == null) {
                obj = this.factory.newInstance();
                putInPool(obj);
                this.nextAvailable++;
            }
        }
        return obj;
    }

    /* access modifiers changed from: protected */
    public void putInPool(Object obj) {
        synchronized (this.mutex) {
            Object[] objArr = this.pool;
            int i = this.nextAvailable - 1;
            this.nextAvailable = i;
            objArr[i] = obj;
            this.mutex.notify();
        }
    }

    private Object readResolve() {
        this.mutex = new Object();
        return this;
    }
}
