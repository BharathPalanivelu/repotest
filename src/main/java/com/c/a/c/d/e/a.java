package com.c.a.c.d.e;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import com.c.a.b.a;
import com.c.a.b.c;
import com.c.a.b.d;
import com.c.a.c.b.a.e;
import com.c.a.c.f;
import com.c.a.c.g;
import com.c.a.c.j;
import com.c.a.c.k;
import com.c.a.i.i;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.Queue;

public class a implements k<ByteBuffer, c> {

    /* renamed from: a  reason: collision with root package name */
    private static final C0108a f6060a = new C0108a();

    /* renamed from: b  reason: collision with root package name */
    private static final b f6061b = new b();

    /* renamed from: c  reason: collision with root package name */
    private final Context f6062c;

    /* renamed from: d  reason: collision with root package name */
    private final List<f> f6063d;

    /* renamed from: e  reason: collision with root package name */
    private final b f6064e;

    /* renamed from: f  reason: collision with root package name */
    private final e f6065f;

    /* renamed from: g  reason: collision with root package name */
    private final C0108a f6066g;
    private final b h;

    public a(Context context, List<f> list, e eVar, com.c.a.c.b.a.b bVar) {
        this(context, list, eVar, bVar, f6061b, f6060a);
    }

    a(Context context, List<f> list, e eVar, com.c.a.c.b.a.b bVar, b bVar2, C0108a aVar) {
        this.f6062c = context.getApplicationContext();
        this.f6063d = list;
        this.f6065f = eVar;
        this.f6066g = aVar;
        this.h = new b(eVar, bVar);
        this.f6064e = bVar2;
    }

    public boolean a(ByteBuffer byteBuffer, j jVar) throws IOException {
        return !((Boolean) jVar.a(i.f6094b)).booleanValue() && g.a(this.f6063d, byteBuffer) == f.a.GIF;
    }

    public e a(ByteBuffer byteBuffer, int i, int i2, j jVar) {
        d a2 = this.f6064e.a(byteBuffer);
        try {
            return a(byteBuffer, i, i2, a2, jVar);
        } finally {
            this.f6064e.a(a2);
        }
    }

    private e a(ByteBuffer byteBuffer, int i, int i2, d dVar, j jVar) {
        long a2 = com.c.a.i.d.a();
        c b2 = dVar.b();
        if (b2.c() <= 0 || b2.d() != 0) {
            return null;
        }
        Bitmap.Config config = jVar.a(i.f6093a) == com.c.a.c.b.PREFER_RGB_565 ? Bitmap.Config.RGB_565 : Bitmap.Config.ARGB_8888;
        ByteBuffer byteBuffer2 = byteBuffer;
        com.c.a.b.a a3 = this.f6066g.a(this.h, b2, byteBuffer, a(b2, i, i2));
        a3.a(config);
        a3.b();
        Bitmap h2 = a3.h();
        if (h2 == null) {
            return null;
        }
        c cVar = new c(this.f6062c, a3, this.f6065f, com.c.a.c.d.b.a(), i, i2, h2);
        if (Log.isLoggable("BufferGifDecoder", 2)) {
            Log.v("BufferGifDecoder", "Decoded GIF from stream in " + com.c.a.i.d.a(a2));
        }
        return new e(cVar);
    }

    private static int a(c cVar, int i, int i2) {
        int i3;
        int min = Math.min(cVar.a() / i2, cVar.b() / i);
        if (min == 0) {
            i3 = 0;
        } else {
            i3 = Integer.highestOneBit(min);
        }
        int max = Math.max(1, i3);
        if (Log.isLoggable("BufferGifDecoder", 2) && max > 1) {
            Log.v("BufferGifDecoder", "Downsampling GIF, sampleSize: " + max + ", target dimens: [" + i + "x" + i2 + "], actual dimens: [" + cVar.b() + "x" + cVar.a() + "]");
        }
        return max;
    }

    /* renamed from: com.c.a.c.d.e.a$a  reason: collision with other inner class name */
    static class C0108a {
        C0108a() {
        }

        public com.c.a.b.a a(a.C0098a aVar, c cVar, ByteBuffer byteBuffer, int i) {
            return new com.c.a.b.e(aVar, cVar, byteBuffer, i);
        }
    }

    static class b {

        /* renamed from: a  reason: collision with root package name */
        private final Queue<d> f6067a = i.a(0);

        b() {
        }

        public synchronized d a(ByteBuffer byteBuffer) {
            d poll;
            poll = this.f6067a.poll();
            if (poll == null) {
                poll = new d();
            }
            return poll.a(byteBuffer);
        }

        public synchronized void a(d dVar) {
            dVar.a();
            this.f6067a.offer(dVar);
        }
    }
}
