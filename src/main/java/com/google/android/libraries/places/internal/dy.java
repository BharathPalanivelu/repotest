package com.google.android.libraries.places.internal;

import java.util.LinkedHashMap;
import java.util.Map;

final class dy extends LinkedHashMap<Long, Integer> {
    dy(int i, float f2, boolean z) {
        super(16, 0.75f, true);
    }

    /* access modifiers changed from: protected */
    public final boolean removeEldestEntry(Map.Entry<Long, Integer> entry) {
        return size() > 10;
    }
}
