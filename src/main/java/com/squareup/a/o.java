package com.squareup.a;

import android.content.Context;
import android.graphics.Bitmap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class o implements d {

    /* renamed from: b  reason: collision with root package name */
    final LinkedHashMap<String, Bitmap> f7147b;

    /* renamed from: c  reason: collision with root package name */
    private final int f7148c;

    /* renamed from: d  reason: collision with root package name */
    private int f7149d;

    /* renamed from: e  reason: collision with root package name */
    private int f7150e;

    /* renamed from: f  reason: collision with root package name */
    private int f7151f;

    /* renamed from: g  reason: collision with root package name */
    private int f7152g;
    private int h;

    public o(Context context) {
        this(aj.c(context));
    }

    public o(int i) {
        if (i > 0) {
            this.f7148c = i;
            this.f7147b = new LinkedHashMap<>(0, 0.75f, true);
            return;
        }
        throw new IllegalArgumentException("Max size must be positive.");
    }

    public Bitmap a(String str) {
        if (str != null) {
            synchronized (this) {
                Bitmap bitmap = this.f7147b.get(str);
                if (bitmap != null) {
                    this.f7152g++;
                    return bitmap;
                }
                this.h++;
                return null;
            }
        }
        throw new NullPointerException("key == null");
    }

    public void a(String str, Bitmap bitmap) {
        if (str == null || bitmap == null) {
            throw new NullPointerException("key == null || bitmap == null");
        }
        int a2 = aj.a(bitmap);
        if (a2 <= this.f7148c) {
            synchronized (this) {
                this.f7150e++;
                this.f7149d += a2;
                Bitmap bitmap2 = (Bitmap) this.f7147b.put(str, bitmap);
                if (bitmap2 != null) {
                    this.f7149d -= aj.a(bitmap2);
                }
            }
            a(this.f7148c);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0070, code lost:
        throw new java.lang.IllegalStateException(getClass().getName() + ".sizeOf() is reporting inconsistent results!");
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(int r4) {
        /*
            r3 = this;
        L_0x0000:
            monitor-enter(r3)
            int r0 = r3.f7149d     // Catch:{ all -> 0x0071 }
            if (r0 < 0) goto L_0x0052
            java.util.LinkedHashMap<java.lang.String, android.graphics.Bitmap> r0 = r3.f7147b     // Catch:{ all -> 0x0071 }
            boolean r0 = r0.isEmpty()     // Catch:{ all -> 0x0071 }
            if (r0 == 0) goto L_0x0011
            int r0 = r3.f7149d     // Catch:{ all -> 0x0071 }
            if (r0 != 0) goto L_0x0052
        L_0x0011:
            int r0 = r3.f7149d     // Catch:{ all -> 0x0071 }
            if (r0 <= r4) goto L_0x0050
            java.util.LinkedHashMap<java.lang.String, android.graphics.Bitmap> r0 = r3.f7147b     // Catch:{ all -> 0x0071 }
            boolean r0 = r0.isEmpty()     // Catch:{ all -> 0x0071 }
            if (r0 == 0) goto L_0x001e
            goto L_0x0050
        L_0x001e:
            java.util.LinkedHashMap<java.lang.String, android.graphics.Bitmap> r0 = r3.f7147b     // Catch:{ all -> 0x0071 }
            java.util.Set r0 = r0.entrySet()     // Catch:{ all -> 0x0071 }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ all -> 0x0071 }
            java.lang.Object r0 = r0.next()     // Catch:{ all -> 0x0071 }
            java.util.Map$Entry r0 = (java.util.Map.Entry) r0     // Catch:{ all -> 0x0071 }
            java.lang.Object r1 = r0.getKey()     // Catch:{ all -> 0x0071 }
            java.lang.String r1 = (java.lang.String) r1     // Catch:{ all -> 0x0071 }
            java.lang.Object r0 = r0.getValue()     // Catch:{ all -> 0x0071 }
            android.graphics.Bitmap r0 = (android.graphics.Bitmap) r0     // Catch:{ all -> 0x0071 }
            java.util.LinkedHashMap<java.lang.String, android.graphics.Bitmap> r2 = r3.f7147b     // Catch:{ all -> 0x0071 }
            r2.remove(r1)     // Catch:{ all -> 0x0071 }
            int r1 = r3.f7149d     // Catch:{ all -> 0x0071 }
            int r0 = com.squareup.a.aj.a((android.graphics.Bitmap) r0)     // Catch:{ all -> 0x0071 }
            int r1 = r1 - r0
            r3.f7149d = r1     // Catch:{ all -> 0x0071 }
            int r0 = r3.f7151f     // Catch:{ all -> 0x0071 }
            int r0 = r0 + 1
            r3.f7151f = r0     // Catch:{ all -> 0x0071 }
            monitor-exit(r3)     // Catch:{ all -> 0x0071 }
            goto L_0x0000
        L_0x0050:
            monitor-exit(r3)     // Catch:{ all -> 0x0071 }
            return
        L_0x0052:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException     // Catch:{ all -> 0x0071 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0071 }
            r0.<init>()     // Catch:{ all -> 0x0071 }
            java.lang.Class r1 = r3.getClass()     // Catch:{ all -> 0x0071 }
            java.lang.String r1 = r1.getName()     // Catch:{ all -> 0x0071 }
            r0.append(r1)     // Catch:{ all -> 0x0071 }
            java.lang.String r1 = ".sizeOf() is reporting inconsistent results!"
            r0.append(r1)     // Catch:{ all -> 0x0071 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0071 }
            r4.<init>(r0)     // Catch:{ all -> 0x0071 }
            throw r4     // Catch:{ all -> 0x0071 }
        L_0x0071:
            r4 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x0071 }
            goto L_0x0075
        L_0x0074:
            throw r4
        L_0x0075:
            goto L_0x0074
        */
        throw new UnsupportedOperationException("Method not decompiled: com.squareup.a.o.a(int):void");
    }

    public final synchronized int a() {
        return this.f7149d;
    }

    public final synchronized int b() {
        return this.f7148c;
    }

    public final synchronized void b(String str) {
        int length = str.length();
        Iterator<Map.Entry<String, Bitmap>> it = this.f7147b.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry next = it.next();
            String str2 = (String) next.getKey();
            Bitmap bitmap = (Bitmap) next.getValue();
            int indexOf = str2.indexOf(10);
            if (indexOf == length && str2.substring(0, indexOf).equals(str)) {
                it.remove();
                this.f7149d -= aj.a(bitmap);
            }
        }
    }
}
