package com.shopee.app.ui.home;

import android.content.Context;
import b.a.b;
import b.a.c;
import com.shopee.app.data.store.ax;
import javax.inject.Provider;

public final class h implements b<ax> {

    /* renamed from: a  reason: collision with root package name */
    private final f f22225a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<Context> f22226b;

    /* renamed from: a */
    public ax get() {
        return (ax) c.a(this.f22225a.a(this.f22226b.get()), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static ax a(f fVar, Context context) {
        return (ax) c.a(fVar.a(context), "Cannot return null from a non-@Nullable @Provides method");
    }
}
