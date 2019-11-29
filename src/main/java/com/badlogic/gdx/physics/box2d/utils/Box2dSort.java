package com.badlogic.gdx.physics.box2d.utils;

import java.util.Comparator;

public class Box2dSort {
    private static Box2dSort instance;
    private Box2dComparableTimSort comparableTimSort;
    private Box2dTimSort timSort;

    public <T extends Comparable> void sort(Box2dArray<T> box2dArray) {
        if (this.comparableTimSort == null) {
            this.comparableTimSort = new Box2dComparableTimSort();
        }
        this.comparableTimSort.doSort(box2dArray.items, 0, box2dArray.size);
    }

    public void sort(Object[] objArr) {
        if (this.comparableTimSort == null) {
            this.comparableTimSort = new Box2dComparableTimSort();
        }
        this.comparableTimSort.doSort(objArr, 0, objArr.length);
    }

    public void sort(Object[] objArr, int i, int i2) {
        if (this.comparableTimSort == null) {
            this.comparableTimSort = new Box2dComparableTimSort();
        }
        this.comparableTimSort.doSort(objArr, i, i2);
    }

    public <T> void sort(Box2dArray<T> box2dArray, Comparator<? super T> comparator) {
        if (this.timSort == null) {
            this.timSort = new Box2dTimSort();
        }
        this.timSort.doSort(box2dArray.items, comparator, 0, box2dArray.size);
    }

    public <T> void sort(T[] tArr, Comparator<? super T> comparator) {
        if (this.timSort == null) {
            this.timSort = new Box2dTimSort();
        }
        this.timSort.doSort(tArr, comparator, 0, tArr.length);
    }

    public <T> void sort(T[] tArr, Comparator<? super T> comparator, int i, int i2) {
        if (this.timSort == null) {
            this.timSort = new Box2dTimSort();
        }
        this.timSort.doSort(tArr, comparator, i, i2);
    }

    public static Box2dSort instance() {
        if (instance == null) {
            instance = new Box2dSort();
        }
        return instance;
    }
}
