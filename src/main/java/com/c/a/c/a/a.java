package com.c.a.c.a;

import android.content.res.AssetManager;
import android.util.Log;
import com.c.a.c.a.b;
import com.c.a.g;
import java.io.IOException;

public abstract class a<T> implements b<T> {

    /* renamed from: a  reason: collision with root package name */
    private final String f5639a;

    /* renamed from: b  reason: collision with root package name */
    private final AssetManager f5640b;

    /* renamed from: c  reason: collision with root package name */
    private T f5641c;

    /* access modifiers changed from: protected */
    public abstract T a(AssetManager assetManager, String str) throws IOException;

    /* access modifiers changed from: protected */
    public abstract void a(T t) throws IOException;

    public void b() {
    }

    public a(AssetManager assetManager, String str) {
        this.f5640b = assetManager;
        this.f5639a = str;
    }

    public void a(g gVar, b.a<? super T> aVar) {
        try {
            this.f5641c = a(this.f5640b, this.f5639a);
            aVar.a(this.f5641c);
        } catch (IOException e2) {
            if (Log.isLoggable("AssetPathFetcher", 3)) {
                Log.d("AssetPathFetcher", "Failed to load data from asset manager", e2);
            }
            aVar.a((Exception) e2);
        }
    }

    public void a() {
        T t = this.f5641c;
        if (t != null) {
            try {
                a(t);
            } catch (IOException unused) {
            }
        }
    }

    public com.c.a.c.a c() {
        return com.c.a.c.a.LOCAL;
    }
}
