package com.crashlytics.android.a;

import android.annotation.SuppressLint;
import android.content.Context;
import io.a.a.a.a.f.c;
import io.a.a.a.a.f.d;

class i {

    /* renamed from: a  reason: collision with root package name */
    private final c f6338a;

    public static i a(Context context) {
        return new i(new d(context, "settings"));
    }

    i(c cVar) {
        this.f6338a = cVar;
    }

    @SuppressLint({"CommitPrefEdits"})
    public void a() {
        c cVar = this.f6338a;
        cVar.a(cVar.b().putBoolean("analytics_launched", true));
    }

    @SuppressLint({"CommitPrefEdits"})
    public boolean b() {
        return this.f6338a.a().getBoolean("analytics_launched", false);
    }
}
