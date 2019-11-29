package com.c.a.c.b.a;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.os.Build;
import android.util.Log;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class k implements e {

    /* renamed from: a  reason: collision with root package name */
    private static final Bitmap.Config f5705a = Bitmap.Config.ARGB_8888;

    /* renamed from: b  reason: collision with root package name */
    private final l f5706b;

    /* renamed from: c  reason: collision with root package name */
    private final Set<Bitmap.Config> f5707c;

    /* renamed from: d  reason: collision with root package name */
    private final int f5708d;

    /* renamed from: e  reason: collision with root package name */
    private final a f5709e;

    /* renamed from: f  reason: collision with root package name */
    private int f5710f;

    /* renamed from: g  reason: collision with root package name */
    private int f5711g;
    private int h;
    private int i;
    private int j;
    private int k;

    private interface a {
        void a(Bitmap bitmap);

        void b(Bitmap bitmap);
    }

    k(int i2, l lVar, Set<Bitmap.Config> set) {
        this.f5708d = i2;
        this.f5710f = i2;
        this.f5706b = lVar;
        this.f5707c = set;
        this.f5709e = new b();
    }

    public k(int i2) {
        this(i2, e(), f());
    }

    public synchronized void a(Bitmap bitmap) {
        if (bitmap != null) {
            try {
                if (!bitmap.isRecycled()) {
                    if (bitmap.isMutable() && this.f5706b.c(bitmap) <= this.f5710f) {
                        if (this.f5707c.contains(bitmap.getConfig())) {
                            int c2 = this.f5706b.c(bitmap);
                            this.f5706b.a(bitmap);
                            this.f5709e.a(bitmap);
                            this.j++;
                            this.f5711g += c2;
                            if (Log.isLoggable("LruBitmapPool", 2)) {
                                Log.v("LruBitmapPool", "Put bitmap in pool=" + this.f5706b.b(bitmap));
                            }
                            c();
                            b();
                            return;
                        }
                    }
                    if (Log.isLoggable("LruBitmapPool", 2)) {
                        Log.v("LruBitmapPool", "Reject bitmap from pool, bitmap: " + this.f5706b.b(bitmap) + ", is mutable: " + bitmap.isMutable() + ", is allowed config: " + this.f5707c.contains(bitmap.getConfig()));
                    }
                    bitmap.recycle();
                    return;
                }
                throw new IllegalStateException("Cannot pool recycled bitmap");
            } catch (Throwable th) {
                throw th;
            }
        } else {
            throw new NullPointerException("Bitmap must not be null");
        }
    }

    private void b() {
        b(this.f5710f);
    }

    public Bitmap a(int i2, int i3, Bitmap.Config config) {
        Bitmap c2 = c(i2, i3, config);
        if (c2 == null) {
            return Bitmap.createBitmap(i2, i3, config);
        }
        c2.eraseColor(0);
        return c2;
    }

    public Bitmap b(int i2, int i3, Bitmap.Config config) {
        Bitmap c2 = c(i2, i3, config);
        return c2 == null ? Bitmap.createBitmap(i2, i3, config) : c2;
    }

    @TargetApi(26)
    private static void a(Bitmap.Config config) {
        if (Build.VERSION.SDK_INT >= 26 && config == Bitmap.Config.HARDWARE) {
            throw new IllegalArgumentException("Cannot create a mutable Bitmap with config: " + config + ". Consider setting Downsampler#ALLOW_HARDWARE_CONFIG to false in your RequestOptions and/or in GlideBuilder.setDefaultRequestOptions");
        }
    }

    private synchronized Bitmap c(int i2, int i3, Bitmap.Config config) {
        Bitmap a2;
        a(config);
        a2 = this.f5706b.a(i2, i3, config != null ? config : f5705a);
        if (a2 == null) {
            if (Log.isLoggable("LruBitmapPool", 3)) {
                Log.d("LruBitmapPool", "Missing bitmap=" + this.f5706b.b(i2, i3, config));
            }
            this.i++;
        } else {
            this.h++;
            this.f5711g -= this.f5706b.c(a2);
            this.f5709e.b(a2);
            b(a2);
        }
        if (Log.isLoggable("LruBitmapPool", 2)) {
            Log.v("LruBitmapPool", "Get bitmap=" + this.f5706b.b(i2, i3, config));
        }
        c();
        return a2;
    }

    private static void b(Bitmap bitmap) {
        bitmap.setHasAlpha(true);
        c(bitmap);
    }

    @TargetApi(19)
    private static void c(Bitmap bitmap) {
        if (Build.VERSION.SDK_INT >= 19) {
            bitmap.setPremultiplied(true);
        }
    }

    public void a() {
        if (Log.isLoggable("LruBitmapPool", 3)) {
            Log.d("LruBitmapPool", "clearMemory");
        }
        b(0);
    }

    @SuppressLint({"InlinedApi"})
    public void a(int i2) {
        if (Log.isLoggable("LruBitmapPool", 3)) {
            Log.d("LruBitmapPool", "trimMemory, level=" + i2);
        }
        if (i2 >= 40) {
            a();
        } else if (i2 >= 20) {
            b(this.f5710f / 2);
        }
    }

    private synchronized void b(int i2) {
        while (this.f5711g > i2) {
            Bitmap a2 = this.f5706b.a();
            if (a2 == null) {
                if (Log.isLoggable("LruBitmapPool", 5)) {
                    Log.w("LruBitmapPool", "Size mismatch, resetting");
                    d();
                }
                this.f5711g = 0;
                return;
            }
            this.f5709e.b(a2);
            this.f5711g -= this.f5706b.c(a2);
            this.k++;
            if (Log.isLoggable("LruBitmapPool", 3)) {
                Log.d("LruBitmapPool", "Evicting bitmap=" + this.f5706b.b(a2));
            }
            c();
            a2.recycle();
        }
    }

    private void c() {
        if (Log.isLoggable("LruBitmapPool", 2)) {
            d();
        }
    }

    private void d() {
        Log.v("LruBitmapPool", "Hits=" + this.h + ", misses=" + this.i + ", puts=" + this.j + ", evictions=" + this.k + ", currentSize=" + this.f5711g + ", maxSize=" + this.f5710f + "\nStrategy=" + this.f5706b);
    }

    private static l e() {
        if (Build.VERSION.SDK_INT >= 19) {
            return new n();
        }
        return new c();
    }

    @TargetApi(26)
    private static Set<Bitmap.Config> f() {
        HashSet hashSet = new HashSet();
        hashSet.addAll(Arrays.asList(Bitmap.Config.values()));
        if (Build.VERSION.SDK_INT >= 19) {
            hashSet.add((Object) null);
        }
        if (Build.VERSION.SDK_INT >= 26) {
            hashSet.remove(Bitmap.Config.HARDWARE);
        }
        return Collections.unmodifiableSet(hashSet);
    }

    private static class b implements a {
        public void a(Bitmap bitmap) {
        }

        public void b(Bitmap bitmap) {
        }

        b() {
        }
    }
}
