package com.c.a.c.d.a;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.util.DisplayMetrics;
import android.util.Log;
import com.c.a.c.b;
import com.c.a.c.b.a.e;
import com.c.a.c.b.s;
import com.c.a.c.d.a.g;
import com.c.a.c.f;
import com.c.a.c.g;
import com.c.a.c.i;
import com.c.a.c.j;
import com.c.a.i.d;
import com.facebook.internal.NativeProtocol;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.litesuits.orm.db.assit.SQLBuilder;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public final class h {

    /* renamed from: a  reason: collision with root package name */
    public static final i<b> f6012a = i.a("com.bumptech.glide.load.resource.bitmap.Downsampler.DecodeFormat", b.DEFAULT);

    /* renamed from: b  reason: collision with root package name */
    public static final i<g> f6013b = i.a("com.bumptech.glide.load.resource.bitmap.Downsampler.DownsampleStrategy", g.f6011g);

    /* renamed from: c  reason: collision with root package name */
    public static final i<Boolean> f6014c = i.a("com.bumptech.glide.load.resource.bitmap.Downsampler.FixBitmapSize", false);

    /* renamed from: d  reason: collision with root package name */
    public static final i<Boolean> f6015d = i.a("com.bumtpech.glide.load.resource.bitmap.Downsampler.AllowHardwareDecode", null);

    /* renamed from: e  reason: collision with root package name */
    private static final Set<String> f6016e = Collections.unmodifiableSet(new HashSet(Arrays.asList(new String[]{"image/vnd.wap.wbmp", "image/x-ico"})));

    /* renamed from: f  reason: collision with root package name */
    private static final a f6017f = new a() {
        public void a() {
        }

        public void a(e eVar, Bitmap bitmap) throws IOException {
        }
    };

    /* renamed from: g  reason: collision with root package name */
    private static final Set<f.a> f6018g = Collections.unmodifiableSet(EnumSet.of(f.a.JPEG, f.a.PNG_A, f.a.PNG));
    private static final Queue<BitmapFactory.Options> h = com.c.a.i.i.a(0);
    private final e i;
    private final DisplayMetrics j;
    private final com.c.a.c.b.a.b k;
    private final List<f> l;
    private final k m = k.a();

    public interface a {
        void a();

        void a(e eVar, Bitmap bitmap) throws IOException;
    }

    private static int c(double d2) {
        return (int) (d2 + 0.5d);
    }

    public boolean a(InputStream inputStream) {
        return true;
    }

    public boolean a(ByteBuffer byteBuffer) {
        return true;
    }

    public h(List<f> list, DisplayMetrics displayMetrics, e eVar, com.c.a.c.b.a.b bVar) {
        this.l = list;
        this.j = (DisplayMetrics) com.c.a.i.h.a(displayMetrics);
        this.i = (e) com.c.a.i.h.a(eVar);
        this.k = (com.c.a.c.b.a.b) com.c.a.i.h.a(bVar);
    }

    public s<Bitmap> a(InputStream inputStream, int i2, int i3, j jVar) throws IOException {
        return a(inputStream, i2, i3, jVar, f6017f);
    }

    public s<Bitmap> a(InputStream inputStream, int i2, int i3, j jVar, a aVar) throws IOException {
        j jVar2 = jVar;
        com.c.a.i.h.a(inputStream.markSupported(), "You must provide an InputStream that supports mark()");
        byte[] bArr = (byte[]) this.k.a((int) NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST, byte[].class);
        BitmapFactory.Options a2 = a();
        a2.inTempStorage = bArr;
        b bVar = (b) jVar2.a(f6012a);
        try {
            return d.a(a(inputStream, a2, (g) jVar2.a(f6013b), bVar, bVar == b.PREFER_ARGB_8888_DISALLOW_HARDWARE ? false : jVar2.a(f6015d) != null && ((Boolean) jVar2.a(f6015d)).booleanValue(), i2, i3, ((Boolean) jVar2.a(f6014c)).booleanValue(), aVar), this.i);
        } finally {
            c(a2);
            this.k.a(bArr, byte[].class);
        }
    }

    private Bitmap a(InputStream inputStream, BitmapFactory.Options options, g gVar, b bVar, boolean z, int i2, int i3, boolean z2, a aVar) throws IOException {
        int i4;
        int i5;
        h hVar;
        int i6;
        int i7;
        int i8;
        InputStream inputStream2 = inputStream;
        BitmapFactory.Options options2 = options;
        a aVar2 = aVar;
        long a2 = d.a();
        int[] a3 = a(inputStream2, options2, aVar2, this.i);
        boolean z3 = false;
        int i9 = a3[0];
        int i10 = a3[1];
        String str = options2.outMimeType;
        boolean z4 = (i9 == -1 || i10 == -1) ? false : z;
        int b2 = g.b(this.l, inputStream2, this.k);
        int a4 = p.a(b2);
        boolean b3 = p.b(b2);
        int i11 = i2;
        if (i11 == Integer.MIN_VALUE) {
            i5 = i3;
            i4 = i9;
        } else {
            i5 = i3;
            i4 = i11;
        }
        int i12 = i5 == Integer.MIN_VALUE ? i10 : i5;
        f.a a5 = g.a(this.l, inputStream2, this.k);
        e eVar = this.i;
        f.a aVar3 = a5;
        a(a5, inputStream, aVar, eVar, gVar, a4, i9, i10, i4, i12, options);
        int i13 = b2;
        String str2 = str;
        int i14 = i10;
        int i15 = i9;
        a aVar4 = aVar2;
        BitmapFactory.Options options3 = options2;
        a(inputStream, bVar, z4, b3, options, i4, i12);
        if (Build.VERSION.SDK_INT >= 19) {
            z3 = true;
        }
        if (options3.inSampleSize == 1 || z3) {
            hVar = this;
            if (hVar.a(aVar3)) {
                if (i15 < 0 || i14 < 0 || !z2 || !z3) {
                    float f2 = a(options) ? ((float) options3.inTargetDensity) / ((float) options3.inDensity) : 1.0f;
                    int i16 = options3.inSampleSize;
                    float f3 = (float) i16;
                    i8 = Math.round(((float) ((int) Math.ceil((double) (((float) i15) / f3)))) * f2);
                    i7 = Math.round(((float) ((int) Math.ceil((double) (((float) i14) / f3)))) * f2);
                    if (Log.isLoggable("Downsampler", 2)) {
                        Log.v("Downsampler", "Calculated target [" + i8 + "x" + i7 + "] for source [" + i15 + "x" + i14 + "], sampleSize: " + i16 + ", targetDensity: " + options3.inTargetDensity + ", density: " + options3.inDensity + ", density multiplier: " + f2);
                    }
                } else {
                    i8 = i4;
                    i7 = i12;
                }
                if (i8 > 0 && i7 > 0) {
                    a(options3, hVar.i, i8, i7);
                }
            }
        } else {
            hVar = this;
        }
        Bitmap b4 = b(inputStream, options3, aVar4, hVar.i);
        aVar4.a(hVar.i, b4);
        if (Log.isLoggable("Downsampler", 2)) {
            i6 = i13;
            a(i15, i14, str2, options, b4, i2, i3, a2);
        } else {
            i6 = i13;
        }
        Bitmap bitmap = null;
        if (b4 != null) {
            b4.setDensity(hVar.j.densityDpi);
            bitmap = p.a(hVar.i, b4, i6);
            if (!b4.equals(bitmap)) {
                hVar.i.a(b4);
            }
        }
        return bitmap;
    }

    static void a(f.a aVar, InputStream inputStream, a aVar2, e eVar, g gVar, int i2, int i3, int i4, int i5, int i6, BitmapFactory.Options options) throws IOException {
        float f2;
        int i7;
        int i8;
        int i9;
        int i10;
        double d2;
        f.a aVar3 = aVar;
        g gVar2 = gVar;
        int i11 = i2;
        int i12 = i3;
        int i13 = i4;
        int i14 = i5;
        int i15 = i6;
        BitmapFactory.Options options2 = options;
        if (i12 <= 0 || i13 <= 0) {
            String str = "Downsampler";
            String str2 = "x";
            if (Log.isLoggable(str, 3)) {
                Log.d(str, "Unable to determine dimensions for: " + aVar3 + " with target [" + i14 + str2 + i15 + "]");
                return;
            }
            return;
        }
        if (i11 == 90 || i11 == 270) {
            f2 = gVar2.a(i13, i12, i14, i15);
        } else {
            f2 = gVar2.a(i12, i13, i14, i15);
        }
        if (f2 > BitmapDescriptorFactory.HUE_RED) {
            g.C0106g b2 = gVar2.b(i12, i13, i14, i15);
            if (b2 != null) {
                float f3 = (float) i12;
                float f4 = (float) i13;
                String str3 = "Downsampler";
                String str4 = "x";
                int c2 = i12 / c((double) (f2 * f3));
                int c3 = i13 / c((double) (f2 * f4));
                if (b2 == g.C0106g.MEMORY) {
                    i7 = Math.max(c2, c3);
                } else {
                    i7 = Math.min(c2, c3);
                }
                if (Build.VERSION.SDK_INT > 23 || !f6016e.contains(options2.outMimeType)) {
                    int max = Math.max(1, Integer.highestOneBit(i7));
                    i8 = (b2 != g.C0106g.MEMORY || ((float) max) >= 1.0f / f2) ? max : max << 1;
                } else {
                    i8 = 1;
                }
                options2.inSampleSize = i8;
                if (aVar3 == f.a.JPEG) {
                    float min = (float) Math.min(i8, 8);
                    i9 = (int) Math.ceil((double) (f3 / min));
                    i10 = (int) Math.ceil((double) (f4 / min));
                    int i16 = i8 / 8;
                    if (i16 > 0) {
                        i9 /= i16;
                        i10 /= i16;
                    }
                } else {
                    if (aVar3 == f.a.PNG || aVar3 == f.a.PNG_A) {
                        float f5 = (float) i8;
                        i9 = (int) Math.floor((double) (f3 / f5));
                        d2 = Math.floor((double) (f4 / f5));
                    } else if (aVar3 == f.a.WEBP || aVar3 == f.a.WEBP_A) {
                        if (Build.VERSION.SDK_INT >= 24) {
                            float f6 = (float) i8;
                            i9 = Math.round(f3 / f6);
                            i10 = Math.round(f4 / f6);
                        } else {
                            float f7 = (float) i8;
                            i9 = (int) Math.floor((double) (f3 / f7));
                            d2 = Math.floor((double) (f4 / f7));
                        }
                    } else if (i12 % i8 == 0 && i13 % i8 == 0) {
                        i9 = i12 / i8;
                        i10 = i13 / i8;
                    } else {
                        int[] a2 = a(inputStream, options2, aVar2, eVar);
                        int i17 = a2[0];
                        i10 = a2[1];
                        i9 = i17;
                    }
                    i10 = (int) d2;
                }
                double a3 = (double) gVar2.a(i9, i10, i14, i15);
                if (Build.VERSION.SDK_INT >= 19) {
                    options2.inTargetDensity = a(a3);
                    options2.inDensity = b(a3);
                }
                if (a(options)) {
                    options2.inScaled = true;
                } else {
                    options2.inTargetDensity = 0;
                    options2.inDensity = 0;
                }
                String str5 = str3;
                if (Log.isLoggable(str5, 2)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Calculate scaling, source: [");
                    sb.append(i12);
                    String str6 = str4;
                    sb.append(str6);
                    sb.append(i13);
                    sb.append("], target: [");
                    sb.append(i14);
                    sb.append(str6);
                    sb.append(i15);
                    sb.append("], power of two scaled: [");
                    sb.append(i9);
                    sb.append(str6);
                    sb.append(i10);
                    sb.append("], exact scale factor: ");
                    sb.append(f2);
                    sb.append(", power of 2 sample size: ");
                    sb.append(i8);
                    sb.append(", adjusted scale factor: ");
                    sb.append(a3);
                    sb.append(", target density: ");
                    sb.append(options2.inTargetDensity);
                    sb.append(", density: ");
                    sb.append(options2.inDensity);
                    Log.v(str5, sb.toString());
                    return;
                }
                return;
            }
            throw new IllegalArgumentException("Cannot round with null rounding");
        }
        String str7 = "x";
        throw new IllegalArgumentException("Cannot scale with factor: " + f2 + " from: " + gVar2 + ", source: [" + i12 + str7 + i13 + "], target: [" + i14 + str7 + i15 + "]");
    }

    private static int a(double d2) {
        int b2 = b(d2);
        double d3 = (double) b2;
        Double.isNaN(d3);
        int c2 = c(d3 * d2);
        double d4 = (double) (((float) c2) / ((float) b2));
        Double.isNaN(d4);
        double d5 = (double) c2;
        Double.isNaN(d5);
        return c((d2 / d4) * d5);
    }

    private static int b(double d2) {
        if (d2 > 1.0d) {
            d2 = 1.0d / d2;
        }
        return (int) Math.round(d2 * 2.147483647E9d);
    }

    private boolean a(f.a aVar) throws IOException {
        if (Build.VERSION.SDK_INT >= 19) {
            return true;
        }
        return f6018g.contains(aVar);
    }

    private void a(InputStream inputStream, b bVar, boolean z, boolean z2, BitmapFactory.Options options, int i2, int i3) throws IOException {
        if (!this.m.a(i2, i3, options, bVar, z, z2)) {
            if (bVar == b.PREFER_ARGB_8888 || bVar == b.PREFER_ARGB_8888_DISALLOW_HARDWARE || Build.VERSION.SDK_INT == 16) {
                options.inPreferredConfig = Bitmap.Config.ARGB_8888;
                return;
            }
            boolean z3 = false;
            try {
                z3 = com.c.a.c.g.a(this.l, inputStream, this.k).hasAlpha();
            } catch (IOException e2) {
                if (Log.isLoggable("Downsampler", 3)) {
                    Log.d("Downsampler", "Cannot determine whether the image has alpha or not from header, format " + bVar, e2);
                }
            }
            options.inPreferredConfig = z3 ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565;
            if (options.inPreferredConfig == Bitmap.Config.RGB_565 || options.inPreferredConfig == Bitmap.Config.ARGB_4444 || options.inPreferredConfig == Bitmap.Config.ALPHA_8) {
                options.inDither = true;
            }
        }
    }

    private static int[] a(InputStream inputStream, BitmapFactory.Options options, a aVar, e eVar) throws IOException {
        options.inJustDecodeBounds = true;
        b(inputStream, options, aVar, eVar);
        options.inJustDecodeBounds = false;
        return new int[]{options.outWidth, options.outHeight};
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(2:23|24) */
    /* JADX WARNING: Code restructure failed: missing block: B:24:?, code lost:
        throw r1;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x005d */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static android.graphics.Bitmap b(java.io.InputStream r6, android.graphics.BitmapFactory.Options r7, com.c.a.c.d.a.h.a r8, com.c.a.c.b.a.e r9) throws java.io.IOException {
        /*
            java.lang.String r0 = "Downsampler"
            boolean r1 = r7.inJustDecodeBounds
            if (r1 == 0) goto L_0x000c
            r1 = 10485760(0xa00000, float:1.469368E-38)
            r6.mark(r1)
            goto L_0x000f
        L_0x000c:
            r8.a()
        L_0x000f:
            int r1 = r7.outWidth
            int r2 = r7.outHeight
            java.lang.String r3 = r7.outMimeType
            java.util.concurrent.locks.Lock r4 = com.c.a.c.d.a.p.a()
            r4.lock()
            r4 = 0
            android.graphics.Bitmap r8 = android.graphics.BitmapFactory.decodeStream(r6, r4, r7)     // Catch:{ IllegalArgumentException -> 0x0032 }
            java.util.concurrent.locks.Lock r9 = com.c.a.c.d.a.p.a()
            r9.unlock()
            boolean r7 = r7.inJustDecodeBounds
            if (r7 == 0) goto L_0x002f
            r6.reset()
        L_0x002f:
            return r8
        L_0x0030:
            r6 = move-exception
            goto L_0x005f
        L_0x0032:
            r5 = move-exception
            java.io.IOException r1 = a((java.lang.IllegalArgumentException) r5, (int) r1, (int) r2, (java.lang.String) r3, (android.graphics.BitmapFactory.Options) r7)     // Catch:{ all -> 0x0030 }
            r2 = 3
            boolean r2 = android.util.Log.isLoggable(r0, r2)     // Catch:{ all -> 0x0030 }
            if (r2 == 0) goto L_0x0043
            java.lang.String r2 = "Failed to decode with inBitmap, trying again without Bitmap re-use"
            android.util.Log.d(r0, r2, r1)     // Catch:{ all -> 0x0030 }
        L_0x0043:
            android.graphics.Bitmap r0 = r7.inBitmap     // Catch:{ all -> 0x0030 }
            if (r0 == 0) goto L_0x005e
            r6.reset()     // Catch:{ IOException -> 0x005d }
            android.graphics.Bitmap r0 = r7.inBitmap     // Catch:{ IOException -> 0x005d }
            r9.a((android.graphics.Bitmap) r0)     // Catch:{ IOException -> 0x005d }
            r7.inBitmap = r4     // Catch:{ IOException -> 0x005d }
            android.graphics.Bitmap r6 = b(r6, r7, r8, r9)     // Catch:{ IOException -> 0x005d }
            java.util.concurrent.locks.Lock r7 = com.c.a.c.d.a.p.a()
            r7.unlock()
            return r6
        L_0x005d:
            throw r1     // Catch:{ all -> 0x0030 }
        L_0x005e:
            throw r1     // Catch:{ all -> 0x0030 }
        L_0x005f:
            java.util.concurrent.locks.Lock r7 = com.c.a.c.d.a.p.a()
            r7.unlock()
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.c.a.c.d.a.h.b(java.io.InputStream, android.graphics.BitmapFactory$Options, com.c.a.c.d.a.h$a, com.c.a.c.b.a.e):android.graphics.Bitmap");
    }

    private static boolean a(BitmapFactory.Options options) {
        return options.inTargetDensity > 0 && options.inDensity > 0 && options.inTargetDensity != options.inDensity;
    }

    private static void a(int i2, int i3, String str, BitmapFactory.Options options, Bitmap bitmap, int i4, int i5, long j2) {
        Log.v("Downsampler", "Decoded " + a(bitmap) + " from [" + i2 + "x" + i3 + "] " + str + " with inBitmap " + b(options) + " for [" + i4 + "x" + i5 + "], sample size: " + options.inSampleSize + ", density: " + options.inDensity + ", target density: " + options.inTargetDensity + ", thread: " + Thread.currentThread().getName() + ", duration: " + d.a(j2));
    }

    private static String b(BitmapFactory.Options options) {
        return a(options.inBitmap);
    }

    @TargetApi(19)
    private static String a(Bitmap bitmap) {
        String str;
        if (bitmap == null) {
            return null;
        }
        if (Build.VERSION.SDK_INT >= 19) {
            str = " (" + bitmap.getAllocationByteCount() + SQLBuilder.PARENTHESES_RIGHT;
        } else {
            str = "";
        }
        return "[" + bitmap.getWidth() + "x" + bitmap.getHeight() + "] " + bitmap.getConfig() + str;
    }

    private static IOException a(IllegalArgumentException illegalArgumentException, int i2, int i3, String str, BitmapFactory.Options options) {
        return new IOException("Exception decoding bitmap, outWidth: " + i2 + ", outHeight: " + i3 + ", outMimeType: " + str + ", inBitmap: " + b(options), illegalArgumentException);
    }

    @TargetApi(26)
    private static void a(BitmapFactory.Options options, e eVar, int i2, int i3) {
        if (Build.VERSION.SDK_INT < 26 || options.inPreferredConfig != Bitmap.Config.HARDWARE) {
            options.inBitmap = eVar.b(i2, i3, options.inPreferredConfig);
        }
    }

    private static synchronized BitmapFactory.Options a() {
        BitmapFactory.Options poll;
        synchronized (h.class) {
            synchronized (h) {
                poll = h.poll();
            }
            if (poll == null) {
                poll = new BitmapFactory.Options();
                d(poll);
            }
        }
        return poll;
    }

    private static void c(BitmapFactory.Options options) {
        d(options);
        synchronized (h) {
            h.offer(options);
        }
    }

    private static void d(BitmapFactory.Options options) {
        options.inTempStorage = null;
        options.inDither = false;
        options.inScaled = false;
        options.inSampleSize = 1;
        options.inPreferredConfig = null;
        options.inJustDecodeBounds = false;
        options.inDensity = 0;
        options.inTargetDensity = 0;
        options.outWidth = 0;
        options.outHeight = 0;
        options.outMimeType = null;
        options.inBitmap = null;
        options.inMutable = true;
    }
}
