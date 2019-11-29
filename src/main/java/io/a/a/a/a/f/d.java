package io.a.a.a.a.f;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import io.a.a.a.i;

public class d implements c {

    /* renamed from: a  reason: collision with root package name */
    private final SharedPreferences f33198a;

    /* renamed from: b  reason: collision with root package name */
    private final String f33199b;

    /* renamed from: c  reason: collision with root package name */
    private final Context f33200c;

    public d(Context context, String str) {
        if (context != null) {
            this.f33200c = context;
            this.f33199b = str;
            this.f33198a = this.f33200c.getSharedPreferences(this.f33199b, 0);
            return;
        }
        throw new IllegalStateException("Cannot get directory before context has been set. Call Fabric.with() first");
    }

    @Deprecated
    public d(i iVar) {
        this(iVar.r(), iVar.getClass().getName());
    }

    public SharedPreferences a() {
        return this.f33198a;
    }

    public SharedPreferences.Editor b() {
        return this.f33198a.edit();
    }

    @TargetApi(9)
    public boolean a(SharedPreferences.Editor editor) {
        if (Build.VERSION.SDK_INT < 9) {
            return editor.commit();
        }
        editor.apply();
        return true;
    }
}
