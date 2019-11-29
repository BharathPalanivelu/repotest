package com.c.a;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Handler;
import android.os.Looper;
import com.c.a.c.b.i;
import com.c.a.g.a.b;
import com.c.a.g.g;
import java.util.Map;

@TargetApi(14)
public class e extends ContextWrapper {

    /* renamed from: a  reason: collision with root package name */
    static final k<?, ?> f6155a = new b();

    /* renamed from: b  reason: collision with root package name */
    private final Handler f6156b = new Handler(Looper.getMainLooper());

    /* renamed from: c  reason: collision with root package name */
    private final h f6157c;

    /* renamed from: d  reason: collision with root package name */
    private final b f6158d;

    /* renamed from: e  reason: collision with root package name */
    private final g f6159e;

    /* renamed from: f  reason: collision with root package name */
    private final Map<Class<?>, k<?, ?>> f6160f;

    /* renamed from: g  reason: collision with root package name */
    private final i f6161g;
    private final int h;

    public e(Context context, h hVar, b bVar, g gVar, Map<Class<?>, k<?, ?>> map, i iVar, int i) {
        super(context.getApplicationContext());
        this.f6157c = hVar;
        this.f6158d = bVar;
        this.f6159e = gVar;
        this.f6160f = map;
        this.f6161g = iVar;
        this.h = i;
    }

    public g a() {
        return this.f6159e;
    }

    public <T> k<?, T> a(Class<T> cls) {
        k<?, T> kVar = this.f6160f.get(cls);
        if (kVar == null) {
            for (Map.Entry next : this.f6160f.entrySet()) {
                if (((Class) next.getKey()).isAssignableFrom(cls)) {
                    kVar = (k) next.getValue();
                }
            }
        }
        return kVar == null ? f6155a : kVar;
    }

    public Handler b() {
        return this.f6156b;
    }

    public i c() {
        return this.f6161g;
    }

    public h d() {
        return this.f6157c;
    }

    public int e() {
        return this.h;
    }
}
