package com.beetalk.sdk.c;

import android.content.Context;
import com.facebook.Session;
import com.facebook.SharedPreferencesTokenCachingStrategy;

public class b {

    /* renamed from: a  reason: collision with root package name */
    private Session f5391a;

    public b(String str, Context context) {
        SharedPreferencesTokenCachingStrategy sharedPreferencesTokenCachingStrategy = new SharedPreferencesTokenCachingStrategy(context);
        Session.Builder builder = new Session.Builder(context);
        builder.setApplicationId(str);
        builder.setTokenCachingStrategy(sharedPreferencesTokenCachingStrategy);
        this.f5391a = builder.build();
    }

    public Session a() {
        return this.f5391a;
    }
}
