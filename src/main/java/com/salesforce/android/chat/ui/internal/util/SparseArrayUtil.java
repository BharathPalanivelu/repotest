package com.salesforce.android.chat.ui.internal.util;

import androidx.b.h;

public class SparseArrayUtil {
    public static <T extends SparseArrayEntry> h<T> asSparseArray(T[] tArr, Class<T> cls) {
        h<T> hVar = new h<>();
        for (T t : tArr) {
            hVar.b(t.getKey(), t);
        }
        return hVar;
    }
}
