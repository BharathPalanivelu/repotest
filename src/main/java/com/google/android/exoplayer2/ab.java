package com.google.android.exoplayer2;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.google.android.exoplayer2.a.d;
import com.google.android.exoplayer2.c.c;
import com.google.android.exoplayer2.c.e;
import com.google.android.exoplayer2.f.f;
import com.google.android.exoplayer2.j.j;
import com.google.android.exoplayer2.k.f;
import java.util.ArrayList;

public class ab implements ap {

    /* renamed from: a  reason: collision with root package name */
    private final Context f9067a;

    /* renamed from: b  reason: collision with root package name */
    private final c<e> f9068b;

    /* renamed from: c  reason: collision with root package name */
    private final int f9069c;

    /* renamed from: d  reason: collision with root package name */
    private final long f9070d;

    /* access modifiers changed from: protected */
    public void a(Context context, Handler handler, int i, ArrayList<am> arrayList) {
    }

    public ab(Context context) {
        this(context, (c<e>) null);
    }

    public ab(Context context, c<e> cVar) {
        this(context, cVar, 0);
    }

    public ab(Context context, c<e> cVar, int i) {
        this(context, cVar, i, 5000);
    }

    public ab(Context context, c<e> cVar, int i, long j) {
        this.f9067a = context;
        this.f9068b = cVar;
        this.f9069c = i;
        this.f9070d = j;
    }

    public am[] a(Handler handler, f fVar, d dVar, j.a aVar, f.a aVar2) {
        ArrayList arrayList = new ArrayList();
        a(this.f9067a, this.f9068b, this.f9070d, handler, fVar, this.f9069c, (ArrayList<am>) arrayList);
        a(this.f9067a, this.f9068b, a(), handler, dVar, this.f9069c, (ArrayList<am>) arrayList);
        ArrayList arrayList2 = arrayList;
        a(this.f9067a, aVar, handler.getLooper(), this.f9069c, (ArrayList<am>) arrayList2);
        a(this.f9067a, aVar2, handler.getLooper(), this.f9069c, (ArrayList<am>) arrayList2);
        a(this.f9067a, handler, this.f9069c, arrayList);
        return (am[]) arrayList.toArray(new am[arrayList.size()]);
    }

    /* access modifiers changed from: protected */
    public void a(Context context, c<e> cVar, long j, Handler handler, com.google.android.exoplayer2.k.f fVar, int i, ArrayList<am> arrayList) {
        int i2 = i;
        ArrayList<am> arrayList2 = arrayList;
        arrayList2.add(new com.google.android.exoplayer2.k.d(context, com.google.android.exoplayer2.h.c.f9914a, j, cVar, false, handler, fVar, 50));
        if (i2 != 0) {
            int size = arrayList.size();
            if (i2 == 2) {
                size--;
            }
            try {
                arrayList2.add(size, (am) Class.forName("com.google.android.exoplayer2.ext.vp9.LibvpxVideoRenderer").getConstructor(new Class[]{Boolean.TYPE, Long.TYPE, Handler.class, com.google.android.exoplayer2.k.f.class, Integer.TYPE}).newInstance(new Object[]{true, Long.valueOf(j), handler, fVar, 50}));
                Log.i("DefaultRenderersFactory", "Loaded LibvpxVideoRenderer.");
            } catch (ClassNotFoundException unused) {
            } catch (Exception e2) {
                throw new RuntimeException(e2);
            }
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x005c, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0062, code lost:
        throw new java.lang.RuntimeException(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0095, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x009b, code lost:
        throw new java.lang.RuntimeException(r0);
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x005c A[ExcHandler: Exception (r0v7 'e' java.lang.Exception A[CUSTOM_DECLARE]), Splitter:B:7:0x002d] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0095 A[ExcHandler: Exception (r0v6 'e' java.lang.Exception A[CUSTOM_DECLARE]), Splitter:B:19:0x0066] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(android.content.Context r13, com.google.android.exoplayer2.c.c<com.google.android.exoplayer2.c.e> r14, com.google.android.exoplayer2.a.c[] r15, android.os.Handler r16, com.google.android.exoplayer2.a.d r17, int r18, java.util.ArrayList<com.google.android.exoplayer2.am> r19) {
        /*
            r12 = this;
            r0 = r18
            r9 = r19
            java.lang.String r10 = "DefaultRenderersFactory"
            com.google.android.exoplayer2.a.h r11 = new com.google.android.exoplayer2.a.h
            com.google.android.exoplayer2.h.c r2 = com.google.android.exoplayer2.h.c.f9914a
            com.google.android.exoplayer2.a.b r7 = com.google.android.exoplayer2.a.b.a((android.content.Context) r13)
            r4 = 1
            r1 = r11
            r3 = r14
            r5 = r16
            r6 = r17
            r8 = r15
            r1.<init>(r2, r3, r4, r5, r6, r7, r8)
            r9.add(r11)
            if (r0 != 0) goto L_0x001f
            return
        L_0x001f:
            int r1 = r19.size()
            r2 = 2
            if (r0 != r2) goto L_0x0028
            int r1 = r1 + -1
        L_0x0028:
            r0 = 0
            r3 = 3
            r4 = 1
            java.lang.String r5 = "com.google.android.exoplayer2.ext.opus.LibopusAudioRenderer"
            java.lang.Class r5 = java.lang.Class.forName(r5)     // Catch:{ ClassNotFoundException -> 0x0063, Exception -> 0x005c }
            java.lang.Class[] r6 = new java.lang.Class[r3]     // Catch:{ ClassNotFoundException -> 0x0063, Exception -> 0x005c }
            java.lang.Class<android.os.Handler> r7 = android.os.Handler.class
            r6[r0] = r7     // Catch:{ ClassNotFoundException -> 0x0063, Exception -> 0x005c }
            java.lang.Class<com.google.android.exoplayer2.a.d> r7 = com.google.android.exoplayer2.a.d.class
            r6[r4] = r7     // Catch:{ ClassNotFoundException -> 0x0063, Exception -> 0x005c }
            java.lang.Class<com.google.android.exoplayer2.a.c[]> r7 = com.google.android.exoplayer2.a.c[].class
            r6[r2] = r7     // Catch:{ ClassNotFoundException -> 0x0063, Exception -> 0x005c }
            java.lang.reflect.Constructor r5 = r5.getConstructor(r6)     // Catch:{ ClassNotFoundException -> 0x0063, Exception -> 0x005c }
            java.lang.Object[] r6 = new java.lang.Object[r3]     // Catch:{ ClassNotFoundException -> 0x0063, Exception -> 0x005c }
            r6[r0] = r16     // Catch:{ ClassNotFoundException -> 0x0063, Exception -> 0x005c }
            r6[r4] = r17     // Catch:{ ClassNotFoundException -> 0x0063, Exception -> 0x005c }
            r6[r2] = r15     // Catch:{ ClassNotFoundException -> 0x0063, Exception -> 0x005c }
            java.lang.Object r5 = r5.newInstance(r6)     // Catch:{ ClassNotFoundException -> 0x0063, Exception -> 0x005c }
            com.google.android.exoplayer2.am r5 = (com.google.android.exoplayer2.am) r5     // Catch:{ ClassNotFoundException -> 0x0063, Exception -> 0x005c }
            int r6 = r1 + 1
            r9.add(r1, r5)     // Catch:{ ClassNotFoundException -> 0x0064, Exception -> 0x005c }
            java.lang.String r1 = "Loaded LibopusAudioRenderer."
            android.util.Log.i(r10, r1)     // Catch:{ ClassNotFoundException -> 0x0064, Exception -> 0x005c }
            goto L_0x0064
        L_0x005c:
            r0 = move-exception
            java.lang.RuntimeException r1 = new java.lang.RuntimeException
            r1.<init>(r0)
            throw r1
        L_0x0063:
            r6 = r1
        L_0x0064:
            java.lang.String r1 = "com.google.android.exoplayer2.ext.flac.LibflacAudioRenderer"
            java.lang.Class r1 = java.lang.Class.forName(r1)     // Catch:{ ClassNotFoundException -> 0x009c, Exception -> 0x0095 }
            java.lang.Class[] r5 = new java.lang.Class[r3]     // Catch:{ ClassNotFoundException -> 0x009c, Exception -> 0x0095 }
            java.lang.Class<android.os.Handler> r7 = android.os.Handler.class
            r5[r0] = r7     // Catch:{ ClassNotFoundException -> 0x009c, Exception -> 0x0095 }
            java.lang.Class<com.google.android.exoplayer2.a.d> r7 = com.google.android.exoplayer2.a.d.class
            r5[r4] = r7     // Catch:{ ClassNotFoundException -> 0x009c, Exception -> 0x0095 }
            java.lang.Class<com.google.android.exoplayer2.a.c[]> r7 = com.google.android.exoplayer2.a.c[].class
            r5[r2] = r7     // Catch:{ ClassNotFoundException -> 0x009c, Exception -> 0x0095 }
            java.lang.reflect.Constructor r1 = r1.getConstructor(r5)     // Catch:{ ClassNotFoundException -> 0x009c, Exception -> 0x0095 }
            java.lang.Object[] r5 = new java.lang.Object[r3]     // Catch:{ ClassNotFoundException -> 0x009c, Exception -> 0x0095 }
            r5[r0] = r16     // Catch:{ ClassNotFoundException -> 0x009c, Exception -> 0x0095 }
            r5[r4] = r17     // Catch:{ ClassNotFoundException -> 0x009c, Exception -> 0x0095 }
            r5[r2] = r15     // Catch:{ ClassNotFoundException -> 0x009c, Exception -> 0x0095 }
            java.lang.Object r1 = r1.newInstance(r5)     // Catch:{ ClassNotFoundException -> 0x009c, Exception -> 0x0095 }
            com.google.android.exoplayer2.am r1 = (com.google.android.exoplayer2.am) r1     // Catch:{ ClassNotFoundException -> 0x009c, Exception -> 0x0095 }
            int r5 = r6 + 1
            r9.add(r6, r1)     // Catch:{ ClassNotFoundException -> 0x009d, Exception -> 0x0095 }
            java.lang.String r1 = "Loaded LibflacAudioRenderer."
            android.util.Log.i(r10, r1)     // Catch:{ ClassNotFoundException -> 0x009d, Exception -> 0x0095 }
            goto L_0x009d
        L_0x0095:
            r0 = move-exception
            java.lang.RuntimeException r1 = new java.lang.RuntimeException
            r1.<init>(r0)
            throw r1
        L_0x009c:
            r5 = r6
        L_0x009d:
            java.lang.String r1 = "com.google.android.exoplayer2.ext.ffmpeg.FfmpegAudioRenderer"
            java.lang.Class r1 = java.lang.Class.forName(r1)     // Catch:{ ClassNotFoundException -> 0x00d3, Exception -> 0x00cc }
            java.lang.Class[] r6 = new java.lang.Class[r3]     // Catch:{ ClassNotFoundException -> 0x00d3, Exception -> 0x00cc }
            java.lang.Class<android.os.Handler> r7 = android.os.Handler.class
            r6[r0] = r7     // Catch:{ ClassNotFoundException -> 0x00d3, Exception -> 0x00cc }
            java.lang.Class<com.google.android.exoplayer2.a.d> r7 = com.google.android.exoplayer2.a.d.class
            r6[r4] = r7     // Catch:{ ClassNotFoundException -> 0x00d3, Exception -> 0x00cc }
            java.lang.Class<com.google.android.exoplayer2.a.c[]> r7 = com.google.android.exoplayer2.a.c[].class
            r6[r2] = r7     // Catch:{ ClassNotFoundException -> 0x00d3, Exception -> 0x00cc }
            java.lang.reflect.Constructor r1 = r1.getConstructor(r6)     // Catch:{ ClassNotFoundException -> 0x00d3, Exception -> 0x00cc }
            java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch:{ ClassNotFoundException -> 0x00d3, Exception -> 0x00cc }
            r3[r0] = r16     // Catch:{ ClassNotFoundException -> 0x00d3, Exception -> 0x00cc }
            r3[r4] = r17     // Catch:{ ClassNotFoundException -> 0x00d3, Exception -> 0x00cc }
            r3[r2] = r15     // Catch:{ ClassNotFoundException -> 0x00d3, Exception -> 0x00cc }
            java.lang.Object r0 = r1.newInstance(r3)     // Catch:{ ClassNotFoundException -> 0x00d3, Exception -> 0x00cc }
            com.google.android.exoplayer2.am r0 = (com.google.android.exoplayer2.am) r0     // Catch:{ ClassNotFoundException -> 0x00d3, Exception -> 0x00cc }
            r9.add(r5, r0)     // Catch:{ ClassNotFoundException -> 0x00d3, Exception -> 0x00cc }
            java.lang.String r0 = "Loaded FfmpegAudioRenderer."
            android.util.Log.i(r10, r0)     // Catch:{ ClassNotFoundException -> 0x00d3, Exception -> 0x00cc }
            goto L_0x00d3
        L_0x00cc:
            r0 = move-exception
            java.lang.RuntimeException r1 = new java.lang.RuntimeException
            r1.<init>(r0)
            throw r1
        L_0x00d3:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.ab.a(android.content.Context, com.google.android.exoplayer2.c.c, com.google.android.exoplayer2.a.c[], android.os.Handler, com.google.android.exoplayer2.a.d, int, java.util.ArrayList):void");
    }

    /* access modifiers changed from: protected */
    public void a(Context context, j.a aVar, Looper looper, int i, ArrayList<am> arrayList) {
        arrayList.add(new j(aVar, looper));
    }

    /* access modifiers changed from: protected */
    public void a(Context context, f.a aVar, Looper looper, int i, ArrayList<am> arrayList) {
        arrayList.add(new com.google.android.exoplayer2.f.f(aVar, looper));
    }

    /* access modifiers changed from: protected */
    public com.google.android.exoplayer2.a.c[] a() {
        return new com.google.android.exoplayer2.a.c[0];
    }
}
