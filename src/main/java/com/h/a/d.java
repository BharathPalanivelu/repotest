package com.h.a;

import android.content.SharedPreferences;
import com.h.a.c;

public class d<T extends c> extends e<String, T> {
    protected d(T t, SharedPreferences sharedPreferences, String str) {
        super(t, sharedPreferences, str);
    }

    /* access modifiers changed from: protected */
    public void a(SharedPreferences.Editor editor, String str, String str2) {
        editor.putString(str, str2);
    }

    /* access modifiers changed from: protected */
    public String a(SharedPreferences sharedPreferences, String str, String str2) {
        return sharedPreferences.getString(str, str2);
    }
}
