package com.squareup.a;

public enum r {
    NO_CACHE(1),
    NO_STORE(2);
    
    final int index;

    static boolean a(int i) {
        return (i & NO_CACHE.index) == 0;
    }

    static boolean b(int i) {
        return (i & NO_STORE.index) == 0;
    }

    private r(int i) {
        this.index = i;
    }
}
