package com.h.a;

import android.content.SharedPreferences;
import com.h.a.c;

public class a<T extends c> extends e<Boolean, T> {
    protected a(T t, SharedPreferences sharedPreferences, String str) {
        super(t, sharedPreferences, str);
    }

    /* access modifiers changed from: protected */
    public void a(SharedPreferences.Editor editor, String str, Boolean bool) {
        editor.putBoolean(str, bool.booleanValue());
    }

    /* access modifiers changed from: protected */
    public Boolean a(SharedPreferences sharedPreferences, String str, Boolean bool) {
        return Boolean.valueOf(sharedPreferences.getBoolean(str, bool.booleanValue()));
    }
}
