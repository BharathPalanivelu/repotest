package com.google.android.libraries.places.internal;

import android.graphics.Bitmap;
import com.c.a.c.a;
import com.c.a.c.b.o;
import com.c.a.g.a.e;
import com.c.a.g.f;
import com.google.android.gms.tasks.TaskCompletionSource;

public final class q implements f<Bitmap> {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ TaskCompletionSource f13059a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ dv f13060b;

    public q(TaskCompletionSource taskCompletionSource, dv dvVar) {
        this.f13059a = taskCompletionSource;
        this.f13060b = dvVar;
    }

    public final boolean onLoadFailed(o oVar, Object obj, e<Bitmap> eVar, boolean z) {
        try {
            this.f13059a.trySetException(k.a(oVar));
            return true;
        } catch (Error | RuntimeException e2) {
            dx.a(e2);
            throw e2;
        }
    }

    private final boolean a(Bitmap bitmap) {
        try {
            this.f13060b.a(bitmap);
            this.f13059a.trySetResult(this.f13060b.a());
            return true;
        } catch (Error | RuntimeException e2) {
            dx.a(e2);
            throw e2;
        }
    }

    public final /* synthetic */ boolean onResourceReady(Object obj, Object obj2, e eVar, a aVar, boolean z) {
        return a((Bitmap) obj);
    }
}
