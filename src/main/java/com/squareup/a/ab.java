package com.squareup.a;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.NetworkInfo;
import com.squareup.a.w;
import java.io.IOException;
import java.io.InputStream;

public abstract class ab {
    /* access modifiers changed from: package-private */
    public int a() {
        return 0;
    }

    public abstract a a(z zVar, int i) throws IOException;

    public abstract boolean a(z zVar);

    /* access modifiers changed from: package-private */
    public boolean a(boolean z, NetworkInfo networkInfo) {
        return false;
    }

    /* access modifiers changed from: package-private */
    public boolean b() {
        return false;
    }

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final w.d f30504a;

        /* renamed from: b  reason: collision with root package name */
        private final Bitmap f30505b;

        /* renamed from: c  reason: collision with root package name */
        private final InputStream f30506c;

        /* renamed from: d  reason: collision with root package name */
        private final int f30507d;

        public a(Bitmap bitmap, w.d dVar) {
            this((Bitmap) aj.a(bitmap, "bitmap == null"), (InputStream) null, dVar, 0);
        }

        public a(InputStream inputStream, w.d dVar) {
            this((Bitmap) null, (InputStream) aj.a(inputStream, "stream == null"), dVar, 0);
        }

        a(Bitmap bitmap, InputStream inputStream, w.d dVar, int i) {
            boolean z = true;
            if ((inputStream == null ? false : z) ^ (bitmap != null)) {
                this.f30505b = bitmap;
                this.f30506c = inputStream;
                this.f30504a = (w.d) aj.a(dVar, "loadedFrom == null");
                this.f30507d = i;
                return;
            }
            throw new AssertionError();
        }

        public Bitmap a() {
            return this.f30505b;
        }

        public InputStream b() {
            return this.f30506c;
        }

        public w.d c() {
            return this.f30504a;
        }

        /* access modifiers changed from: package-private */
        public int d() {
            return this.f30507d;
        }
    }

    static BitmapFactory.Options c(z zVar) {
        boolean d2 = zVar.d();
        boolean z = zVar.s != null;
        BitmapFactory.Options options = null;
        if (d2 || z || zVar.r) {
            options = new BitmapFactory.Options();
            options.inJustDecodeBounds = d2;
            options.inInputShareable = zVar.r;
            options.inPurgeable = zVar.r;
            if (z) {
                options.inPreferredConfig = zVar.s;
            }
        }
        return options;
    }

    static boolean a(BitmapFactory.Options options) {
        return options != null && options.inJustDecodeBounds;
    }

    static void a(int i, int i2, BitmapFactory.Options options, z zVar) {
        a(i, i2, options.outWidth, options.outHeight, options, zVar);
    }

    static void a(int i, int i2, int i3, int i4, BitmapFactory.Options options, z zVar) {
        int i5;
        double floor;
        if (i4 > i2 || i3 > i) {
            if (i2 == 0) {
                floor = Math.floor((double) (((float) i3) / ((float) i)));
            } else if (i == 0) {
                floor = Math.floor((double) (((float) i4) / ((float) i2)));
            } else {
                int floor2 = (int) Math.floor((double) (((float) i4) / ((float) i2)));
                int floor3 = (int) Math.floor((double) (((float) i3) / ((float) i)));
                i5 = zVar.l ? Math.max(floor2, floor3) : Math.min(floor2, floor3);
            }
            i5 = (int) floor;
        } else {
            i5 = 1;
        }
        options.inSampleSize = i5;
        options.inJustDecodeBounds = false;
    }
}
