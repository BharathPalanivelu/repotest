package com.h.a;

import android.content.SharedPreferences;
import com.h.a.c;

public class b<T extends c> extends e<Integer, T> {
    protected b(T t, SharedPreferences sharedPreferences, String str) {
        super(t, sharedPreferences, str);
    }

    /* access modifiers changed from: protected */
    public void a(SharedPreferences.Editor editor, String str, Integer num) {
        editor.putInt(str, num.intValue());
    }

    /* access modifiers changed from: protected */
    public Integer a(SharedPreferences sharedPreferences, String str, Integer num) {
        return Integer.valueOf(sharedPreferences.getInt(str, num.intValue()));
    }
}
