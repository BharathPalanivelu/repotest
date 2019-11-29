package com.squareup.a;

import java.io.PrintWriter;

public class ae {

    /* renamed from: a  reason: collision with root package name */
    public final int f30519a;

    /* renamed from: b  reason: collision with root package name */
    public final int f30520b;

    /* renamed from: c  reason: collision with root package name */
    public final long f30521c;

    /* renamed from: d  reason: collision with root package name */
    public final long f30522d;

    /* renamed from: e  reason: collision with root package name */
    public final long f30523e;

    /* renamed from: f  reason: collision with root package name */
    public final long f30524f;

    /* renamed from: g  reason: collision with root package name */
    public final long f30525g;
    public final long h;
    public final long i;
    public final long j;
    public final int k;
    public final int l;
    public final int m;
    public final long n;

    public ae(int i2, int i3, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, int i4, int i5, int i6, long j10) {
        this.f30519a = i2;
        this.f30520b = i3;
        this.f30521c = j2;
        this.f30522d = j3;
        this.f30523e = j4;
        this.f30524f = j5;
        this.f30525g = j6;
        this.h = j7;
        this.i = j8;
        this.j = j9;
        this.k = i4;
        this.l = i5;
        this.m = i6;
        this.n = j10;
    }

    public void a(PrintWriter printWriter) {
        printWriter.println("===============BEGIN PICASSO STATS ===============");
        printWriter.println("Memory Cache Stats");
        printWriter.print("  Max Cache Size: ");
        printWriter.println(this.f30519a);
        printWriter.print("  Cache Size: ");
        printWriter.println(this.f30520b);
        printWriter.print("  Cache % Full: ");
        printWriter.println((int) Math.ceil((double) ((((float) this.f30520b) / ((float) this.f30519a)) * 100.0f)));
        printWriter.print("  Cache Hits: ");
        printWriter.println(this.f30521c);
        printWriter.print("  Cache Misses: ");
        printWriter.println(this.f30522d);
        printWriter.println("Network Stats");
        printWriter.print("  Download Count: ");
        printWriter.println(this.k);
        printWriter.print("  Total Download Size: ");
        printWriter.println(this.f30523e);
        printWriter.print("  Average Download Size: ");
        printWriter.println(this.h);
        printWriter.println("Bitmap Stats");
        printWriter.print("  Total Bitmaps Decoded: ");
        printWriter.println(this.l);
        printWriter.print("  Total Bitmap Size: ");
        printWriter.println(this.f30524f);
        printWriter.print("  Total Transformed Bitmaps: ");
        printWriter.println(this.m);
        printWriter.print("  Total Transformed Bitmap Size: ");
        printWriter.println(this.f30525g);
        printWriter.print("  Average Bitmap Size: ");
        printWriter.println(this.i);
        printWriter.print("  Average Transformed Bitmap Size: ");
        printWriter.println(this.j);
        printWriter.println("===============END PICASSO STATS ===============");
        printWriter.flush();
    }

    public String toString() {
        return "StatsSnapshot{maxSize=" + this.f30519a + ", size=" + this.f30520b + ", cacheHits=" + this.f30521c + ", cacheMisses=" + this.f30522d + ", downloadCount=" + this.k + ", totalDownloadSize=" + this.f30523e + ", averageDownloadSize=" + this.h + ", totalOriginalBitmapSize=" + this.f30524f + ", totalTransformedBitmapSize=" + this.f30525g + ", averageOriginalBitmapSize=" + this.i + ", averageTransformedBitmapSize=" + this.j + ", originalBitmapCount=" + this.l + ", transformedBitmapCount=" + this.m + ", timeStamp=" + this.n + '}';
    }
}
