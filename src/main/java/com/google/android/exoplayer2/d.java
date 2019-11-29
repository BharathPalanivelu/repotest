package com.google.android.exoplayer2;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.google.android.exoplayer2.drm.b;
import com.google.android.exoplayer2.metadata.e;
import com.google.android.exoplayer2.p.k;
import com.google.android.exoplayer2.video.c;
import com.google.android.exoplayer2.video.e;
import java.util.ArrayList;

public class d implements v {

    /* renamed from: a  reason: collision with root package name */
    private final Context f9258a;

    /* renamed from: b  reason: collision with root package name */
    private final b<com.google.android.exoplayer2.drm.d> f9259b;

    /* renamed from: c  reason: collision with root package name */
    private final int f9260c;

    /* renamed from: d  reason: collision with root package name */
    private final long f9261d;

    /* access modifiers changed from: protected */
    public void a(Context context, Handler handler, int i, ArrayList<s> arrayList) {
    }

    public d(Context context) {
        this(context, (b<com.google.android.exoplayer2.drm.d>) null);
    }

    public d(Context context, b<com.google.android.exoplayer2.drm.d> bVar) {
        this(context, bVar, 0);
    }

    public d(Context context, b<com.google.android.exoplayer2.drm.d> bVar, int i) {
        this(context, bVar, i, 5000);
    }

    public d(Context context, b<com.google.android.exoplayer2.drm.d> bVar, int i, long j) {
        this.f9258a = context;
        this.f9259b = bVar;
        this.f9260c = i;
        this.f9261d = j;
    }

    public s[] a(Handler handler, e eVar, com.google.android.exoplayer2.b.e eVar2, k.a aVar, e.a aVar2) {
        ArrayList arrayList = new ArrayList();
        a(this.f9258a, this.f9259b, this.f9261d, handler, eVar, this.f9260c, (ArrayList<s>) arrayList);
        a(this.f9258a, this.f9259b, a(), handler, eVar2, this.f9260c, (ArrayList<s>) arrayList);
        ArrayList arrayList2 = arrayList;
        a(this.f9258a, aVar, handler.getLooper(), this.f9260c, (ArrayList<s>) arrayList2);
        a(this.f9258a, aVar2, handler.getLooper(), this.f9260c, (ArrayList<s>) arrayList2);
        a(this.f9258a, handler, this.f9260c, arrayList);
        return (s[]) arrayList.toArray(new s[arrayList.size()]);
    }

    /* access modifiers changed from: protected */
    public void a(Context context, b<com.google.android.exoplayer2.drm.d> bVar, long j, Handler handler, com.google.android.exoplayer2.video.e eVar, int i, ArrayList<s> arrayList) {
        int i2 = i;
        ArrayList<s> arrayList2 = arrayList;
        arrayList2.add(new c(context, com.google.android.exoplayer2.o.c.f11007a, j, bVar, false, handler, eVar, 50));
        if (i2 != 0) {
            int size = arrayList.size();
            if (i2 == 2) {
                size--;
            }
            try {
                arrayList2.add(size, (s) Class.forName("com.google.android.exoplayer2.ext.vp9.LibvpxVideoRenderer").getConstructor(new Class[]{Boolean.TYPE, Long.TYPE, Handler.class, com.google.android.exoplayer2.video.e.class, Integer.TYPE}).newInstance(new Object[]{true, Long.valueOf(j), handler, eVar, 50}));
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
    public void a(android.content.Context r13, com.google.android.exoplayer2.drm.b<com.google.android.exoplayer2.drm.d> r14, com.google.android.exoplayer2.b.d[] r15, android.os.Handler r16, com.google.android.exoplayer2.b.e r17, int r18, java.util.ArrayList<com.google.android.exoplayer2.s> r19) {
        /*
            r12 = this;
            r0 = r18
            r9 = r19
            java.lang.String r10 = "DefaultRenderersFactory"
            com.google.android.exoplayer2.b.i r11 = new com.google.android.exoplayer2.b.i
            com.google.android.exoplayer2.o.c r2 = com.google.android.exoplayer2.o.c.f11007a
            com.google.android.exoplayer2.b.c r7 = com.google.android.exoplayer2.b.c.a((android.content.Context) r13)
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
            java.lang.Class<com.google.android.exoplayer2.b.e> r7 = com.google.android.exoplayer2.b.e.class
            r6[r4] = r7     // Catch:{ ClassNotFoundException -> 0x0063, Exception -> 0x005c }
            java.lang.Class<com.google.android.exoplayer2.b.d[]> r7 = com.google.android.exoplayer2.b.d[].class
            r6[r2] = r7     // Catch:{ ClassNotFoundException -> 0x0063, Exception -> 0x005c }
            java.lang.reflect.Constructor r5 = r5.getConstructor(r6)     // Catch:{ ClassNotFoundException -> 0x0063, Exception -> 0x005c }
            java.lang.Object[] r6 = new java.lang.Object[r3]     // Catch:{ ClassNotFoundException -> 0x0063, Exception -> 0x005c }
            r6[r0] = r16     // Catch:{ ClassNotFoundException -> 0x0063, Exception -> 0x005c }
            r6[r4] = r17     // Catch:{ ClassNotFoundException -> 0x0063, Exception -> 0x005c }
            r6[r2] = r15     // Catch:{ ClassNotFoundException -> 0x0063, Exception -> 0x005c }
            java.lang.Object r5 = r5.newInstance(r6)     // Catch:{ ClassNotFoundException -> 0x0063, Exception -> 0x005c }
            com.google.android.exoplayer2.s r5 = (com.google.android.exoplayer2.s) r5     // Catch:{ ClassNotFoundException -> 0x0063, Exception -> 0x005c }
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
            java.lang.Class<com.google.android.exoplayer2.b.e> r7 = com.google.android.exoplayer2.b.e.class
            r5[r4] = r7     // Catch:{ ClassNotFoundException -> 0x009c, Exception -> 0x0095 }
            java.lang.Class<com.google.android.exoplayer2.b.d[]> r7 = com.google.android.exoplayer2.b.d[].class
            r5[r2] = r7     // Catch:{ ClassNotFoundException -> 0x009c, Exception -> 0x0095 }
            java.lang.reflect.Constructor r1 = r1.getConstructor(r5)     // Catch:{ ClassNotFoundException -> 0x009c, Exception -> 0x0095 }
            java.lang.Object[] r5 = new java.lang.Object[r3]     // Catch:{ ClassNotFoundException -> 0x009c, Exception -> 0x0095 }
            r5[r0] = r16     // Catch:{ ClassNotFoundException -> 0x009c, Exception -> 0x0095 }
            r5[r4] = r17     // Catch:{ ClassNotFoundException -> 0x009c, Exception -> 0x0095 }
            r5[r2] = r15     // Catch:{ ClassNotFoundException -> 0x009c, Exception -> 0x0095 }
            java.lang.Object r1 = r1.newInstance(r5)     // Catch:{ ClassNotFoundException -> 0x009c, Exception -> 0x0095 }
            com.google.android.exoplayer2.s r1 = (com.google.android.exoplayer2.s) r1     // Catch:{ ClassNotFoundException -> 0x009c, Exception -> 0x0095 }
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
            java.lang.Class<com.google.android.exoplayer2.b.e> r7 = com.google.android.exoplayer2.b.e.class
            r6[r4] = r7     // Catch:{ ClassNotFoundException -> 0x00d3, Exception -> 0x00cc }
            java.lang.Class<com.google.android.exoplayer2.b.d[]> r7 = com.google.android.exoplayer2.b.d[].class
            r6[r2] = r7     // Catch:{ ClassNotFoundException -> 0x00d3, Exception -> 0x00cc }
            java.lang.reflect.Constructor r1 = r1.getConstructor(r6)     // Catch:{ ClassNotFoundException -> 0x00d3, Exception -> 0x00cc }
            java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch:{ ClassNotFoundException -> 0x00d3, Exception -> 0x00cc }
            r3[r0] = r16     // Catch:{ ClassNotFoundException -> 0x00d3, Exception -> 0x00cc }
            r3[r4] = r17     // Catch:{ ClassNotFoundException -> 0x00d3, Exception -> 0x00cc }
            r3[r2] = r15     // Catch:{ ClassNotFoundException -> 0x00d3, Exception -> 0x00cc }
            java.lang.Object r0 = r1.newInstance(r3)     // Catch:{ ClassNotFoundException -> 0x00d3, Exception -> 0x00cc }
            com.google.android.exoplayer2.s r0 = (com.google.android.exoplayer2.s) r0     // Catch:{ ClassNotFoundException -> 0x00d3, Exception -> 0x00cc }
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
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.d.a(android.content.Context, com.google.android.exoplayer2.drm.b, com.google.android.exoplayer2.b.d[], android.os.Handler, com.google.android.exoplayer2.b.e, int, java.util.ArrayList):void");
    }

    /* access modifiers changed from: protected */
    public void a(Context context, k.a aVar, Looper looper, int i, ArrayList<s> arrayList) {
        arrayList.add(new k(aVar, looper));
    }

    /* access modifiers changed from: protected */
    public void a(Context context, e.a aVar, Looper looper, int i, ArrayList<s> arrayList) {
        arrayList.add(new com.google.android.exoplayer2.metadata.e(aVar, looper));
    }

    /* access modifiers changed from: protected */
    public com.google.android.exoplayer2.b.d[] a() {
        return new com.google.android.exoplayer2.b.d[0];
    }
}
