package com.badlogic.gdx.physics.box2d.utils;

import java.util.Comparator;

public class Box2dSelect {
    private static Box2dSelect instance;
    private Box2dQuickSelect quickSelect;

    public static Box2dSelect instance() {
        if (instance == null) {
            instance = new Box2dSelect();
        }
        return instance;
    }

    public <T> T select(T[] tArr, Comparator<T> comparator, int i, int i2) {
        return tArr[selectIndex(tArr, comparator, i, i2)];
    }

    public <T> int selectIndex(T[] tArr, Comparator<T> comparator, int i, int i2) {
        if (i2 < 1) {
            throw new Box2dRuntimeException("cannot select from empty array (size < 1)");
        } else if (i > i2) {
            throw new Box2dRuntimeException("Kth rank is larger than size. k: " + i + ", size: " + i2);
        } else if (i == 1) {
            return fastMin(tArr, comparator, i2);
        } else {
            if (i == i2) {
                return fastMax(tArr, comparator, i2);
            }
            if (this.quickSelect == null) {
                this.quickSelect = new Box2dQuickSelect();
            }
            return this.quickSelect.select(tArr, comparator, i, i2);
        }
    }

    private <T> int fastMin(T[] tArr, Comparator<T> comparator, int i) {
        int i2 = 0;
        for (int i3 = 1; i3 < i; i3++) {
            if (comparator.compare(tArr[i3], tArr[i2]) < 0) {
                i2 = i3;
            }
        }
        return i2;
    }

    private <T> int fastMax(T[] tArr, Comparator<T> comparator, int i) {
        int i2 = 0;
        for (int i3 = 1; i3 < i; i3++) {
            if (comparator.compare(tArr[i3], tArr[i2]) > 0) {
                i2 = i3;
            }
        }
        return i2;
    }
}
