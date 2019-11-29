package com.shopee.sdk.e;

import android.content.SharedPreferences;

public abstract class b {
    protected final SharedPreferences mPref;

    public b(SharedPreferences sharedPreferences) {
        this.mPref = sharedPreferences;
    }
}
