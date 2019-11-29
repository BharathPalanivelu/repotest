package com.shopee.app.data.store;

import android.content.SharedPreferences;

public abstract class ay {
    protected final SharedPreferences mPref;

    protected ay(SharedPreferences sharedPreferences) {
        this.mPref = sharedPreferences;
    }
}
