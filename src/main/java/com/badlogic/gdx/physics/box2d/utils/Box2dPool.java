package com.badlogic.gdx.physics.box2d.utils;

public abstract class Box2dPool<T> {
    private final Box2dArray<T> freeObjects;
    public final int max;
    public int peak;

    public interface Poolable {
        void reset();
    }

    /* access modifiers changed from: protected */
    public abstract T newObject();

    public Box2dPool() {
        this(16, Integer.MAX_VALUE);
    }

    public Box2dPool(int i) {
        this(i, Integer.MAX_VALUE);
    }

    public Box2dPool(int i, int i2) {
        this.freeObjects = new Box2dArray<>(false, i);
        this.max = i2;
    }

    public T obtain() {
        return this.freeObjects.size == 0 ? newObject() : this.freeObjects.pop();
    }

    public void free(T t) {
        if (t != null) {
            if (this.freeObjects.size < this.max) {
                this.freeObjects.add(t);
                this.peak = Math.max(this.peak, this.freeObjects.size);
            }
            reset(t);
            return;
        }
        throw new IllegalArgumentException("object cannot be null.");
    }

    /* access modifiers changed from: protected */
    public void reset(T t) {
        if (t instanceof Poolable) {
            ((Poolable) t).reset();
        }
    }

    public void freeAll(Box2dArray<T> box2dArray) {
        if (box2dArray != null) {
            Box2dArray<T> box2dArray2 = this.freeObjects;
            int i = this.max;
            for (int i2 = 0; i2 < box2dArray.size; i2++) {
                T t = box2dArray.get(i2);
                if (t != null) {
                    if (box2dArray2.size < i) {
                        box2dArray2.add(t);
                    }
                    reset(t);
                }
            }
            this.peak = Math.max(this.peak, box2dArray2.size);
            return;
        }
        throw new IllegalArgumentException("objects cannot be null.");
    }

    public void clear() {
        this.freeObjects.clear();
    }

    public int getFree() {
        return this.freeObjects.size;
    }
}
