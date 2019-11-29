package com.modiface.mfemakeupkit.utils;

import android.graphics.Bitmap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicReference;

public class e {

    /* renamed from: a  reason: collision with root package name */
    protected AtomicReference<a> f15359a = new AtomicReference<>((Object) null);

    protected static class a {

        /* renamed from: a  reason: collision with root package name */
        public final ConcurrentLinkedQueue<Bitmap> f15360a;

        /* renamed from: b  reason: collision with root package name */
        public final t f15361b;

        public a(ConcurrentLinkedQueue<Bitmap> concurrentLinkedQueue, t tVar) {
            this.f15360a = concurrentLinkedQueue;
            this.f15361b = tVar;
        }
    }

    public void a(Bitmap bitmap) {
        if (bitmap == null || bitmap.isRecycled() || bitmap.getConfig() != Bitmap.Config.ARGB_8888) {
            throw new IllegalArgumentException("bitmap to add to MFEFixedSizeBitmapCache must not be <code>null</code> nor recycled and must have config ARGB_8888");
        }
        a aVar = this.f15359a.get();
        if (aVar == null || !aVar.f15361b.a((float) bitmap.getWidth(), (float) bitmap.getHeight())) {
            aVar = new a(new ConcurrentLinkedQueue(), new t((float) bitmap.getWidth(), (float) bitmap.getHeight()));
            this.f15359a.set(aVar);
        }
        aVar.f15360a.add(bitmap);
    }

    public Bitmap a() {
        a aVar = this.f15359a.get();
        if (aVar != null) {
            return aVar.f15360a.poll();
        }
        return null;
    }
}
