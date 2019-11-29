package com.shopee.app.camera;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.hardware.Camera;
import android.os.Build;

public class e implements Camera.PictureCallback {

    /* renamed from: a  reason: collision with root package name */
    private static int f15973a = 1;

    /* renamed from: b  reason: collision with root package name */
    private static int f15974b;

    /* renamed from: c  reason: collision with root package name */
    private MakePhotoActivity f15975c;

    /* renamed from: d  reason: collision with root package name */
    private int f15976d;

    /* renamed from: e  reason: collision with root package name */
    private int f15977e;

    /* renamed from: f  reason: collision with root package name */
    private int f15978f = 0;

    /* renamed from: g  reason: collision with root package name */
    private boolean f15979g = false;
    private final boolean h;

    private int b(int i) {
        if (i > 0) {
            return i;
        }
        return 0;
    }

    public e(MakePhotoActivity makePhotoActivity, boolean z, boolean z2) {
        this.f15975c = makePhotoActivity;
        this.f15976d = makePhotoActivity.c();
        this.f15977e = makePhotoActivity.d();
        this.f15979g = z;
        this.h = z2;
    }

    public void a(int i) {
        if (this.h) {
            this.f15978f = i;
            return;
        }
        boolean z = false;
        if (i == 0) {
            this.f15978f = 270;
        } else if (i == 90) {
            this.f15978f = 0;
        } else if (i == 180) {
            this.f15978f = 90;
        } else if (i != 270) {
            this.f15978f = 0;
        } else {
            this.f15978f = 180;
        }
        if (this.f15975c.a() && !"Nexus 5X".equals(Build.MODEL)) {
            z = true;
        }
        if (!z) {
            this.f15978f = (this.f15978f + 180) % 360;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:60:0x015a A[SYNTHETIC, Splitter:B:60:0x015a] */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x0165  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x0181  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x019b A[SYNTHETIC, Splitter:B:74:0x019b] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onPictureTaken(byte[] r14, android.hardware.Camera r15) {
        /*
            r13 = this;
            java.text.SimpleDateFormat r15 = new java.text.SimpleDateFormat
            java.util.Locale r0 = java.util.Locale.US
            java.lang.String r1 = "yyyyMMddHHmmss"
            r15.<init>(r1, r0)
            java.util.Date r0 = new java.util.Date
            r0.<init>()
            java.lang.String r15 = r15.format(r0)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Picture_"
            r0.append(r1)
            r0.append(r15)
            java.lang.String r15 = ".jpg"
            r0.append(r15)
            java.lang.String r15 = r0.toString()
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            com.shopee.app.h.f r1 = com.shopee.app.h.f.a()
            java.lang.String r1 = r1.d()
            r0.append(r1)
            r0.append(r15)
            java.lang.String r15 = r0.toString()
            java.io.File r0 = new java.io.File
            r0.<init>(r15)
            r1 = 1
            r2 = 0
            r3 = 0
            java.io.FileOutputStream r4 = new java.io.FileOutputStream     // Catch:{ Throwable -> 0x0135 }
            r4.<init>(r0)     // Catch:{ Throwable -> 0x0135 }
            android.graphics.BitmapFactory$Options r3 = new android.graphics.BitmapFactory$Options     // Catch:{ Throwable -> 0x012f, all -> 0x012d }
            r3.<init>()     // Catch:{ Throwable -> 0x012f, all -> 0x012d }
            com.shopee.app.camera.MakePhotoActivity r5 = r13.f15975c     // Catch:{ Throwable -> 0x012f, all -> 0x012d }
            boolean r5 = r5.b()     // Catch:{ Throwable -> 0x012f, all -> 0x012d }
            if (r5 != 0) goto L_0x005d
            int r5 = f15973a     // Catch:{ Throwable -> 0x012f, all -> 0x012d }
            r3.inSampleSize = r5     // Catch:{ Throwable -> 0x012f, all -> 0x012d }
        L_0x005d:
            int r5 = r14.length     // Catch:{ Throwable -> 0x012f, all -> 0x012d }
            android.graphics.Bitmap r3 = android.graphics.BitmapFactory.decodeByteArray(r14, r2, r5, r3)     // Catch:{ Throwable -> 0x012f, all -> 0x012d }
            android.graphics.Matrix r11 = new android.graphics.Matrix     // Catch:{ Throwable -> 0x012f, all -> 0x012d }
            r11.<init>()     // Catch:{ Throwable -> 0x012f, all -> 0x012d }
            com.shopee.app.camera.MakePhotoActivity r5 = r13.f15975c     // Catch:{ Throwable -> 0x012f, all -> 0x012d }
            boolean r5 = r5.a()     // Catch:{ Throwable -> 0x012f, all -> 0x012d }
            if (r5 == 0) goto L_0x007b
            java.lang.String r5 = "Nexus 5X"
            java.lang.String r6 = android.os.Build.MODEL     // Catch:{ Throwable -> 0x012f, all -> 0x012d }
            boolean r5 = r5.equals(r6)     // Catch:{ Throwable -> 0x012f, all -> 0x012d }
            if (r5 != 0) goto L_0x007b
            r5 = 1
            goto L_0x007c
        L_0x007b:
            r5 = 0
        L_0x007c:
            boolean r6 = r13.h     // Catch:{ Throwable -> 0x012f, all -> 0x012d }
            if (r6 != 0) goto L_0x009e
            r6 = 1119092736(0x42b40000, float:90.0)
            if (r5 == 0) goto L_0x0088
            r11.postRotate(r6)     // Catch:{ Throwable -> 0x012f, all -> 0x012d }
            goto L_0x009e
        L_0x0088:
            int r5 = r13.f15978f     // Catch:{ Throwable -> 0x012f, all -> 0x012d }
            r7 = 90
            if (r5 == r7) goto L_0x009b
            int r5 = r13.f15978f     // Catch:{ Throwable -> 0x012f, all -> 0x012d }
            r7 = 270(0x10e, float:3.78E-43)
            if (r5 != r7) goto L_0x0095
            goto L_0x009b
        L_0x0095:
            r5 = 1132920832(0x43870000, float:270.0)
            r11.postRotate(r5)     // Catch:{ Throwable -> 0x012f, all -> 0x012d }
            goto L_0x009e
        L_0x009b:
            r11.postRotate(r6)     // Catch:{ Throwable -> 0x012f, all -> 0x012d }
        L_0x009e:
            com.shopee.app.camera.MakePhotoActivity r5 = r13.f15975c     // Catch:{ Throwable -> 0x012f, all -> 0x012d }
            boolean r5 = r5.b()     // Catch:{ Throwable -> 0x012f, all -> 0x012d }
            if (r5 == 0) goto L_0x00b4
            boolean r5 = r13.f15979g     // Catch:{ Throwable -> 0x012f, all -> 0x012d }
            if (r5 == 0) goto L_0x00af
            android.graphics.Bitmap r3 = r13.b(r3, r11)     // Catch:{ Throwable -> 0x012f, all -> 0x012d }
            goto L_0x0113
        L_0x00af:
            android.graphics.Bitmap r3 = r13.a(r3, r11)     // Catch:{ Throwable -> 0x012f, all -> 0x012d }
            goto L_0x0113
        L_0x00b4:
            int r5 = r3.getHeight()     // Catch:{ Throwable -> 0x012f, all -> 0x012d }
            int r6 = r3.getWidth()     // Catch:{ Throwable -> 0x012f, all -> 0x012d }
            if (r5 <= r6) goto L_0x00c3
            int r5 = r3.getWidth()     // Catch:{ Throwable -> 0x012f, all -> 0x012d }
            goto L_0x00c7
        L_0x00c3:
            int r5 = r3.getHeight()     // Catch:{ Throwable -> 0x012f, all -> 0x012d }
        L_0x00c7:
            com.shopee.app.camera.MakePhotoActivity r6 = r13.f15975c     // Catch:{ Throwable -> 0x012f, all -> 0x012d }
            boolean r6 = r6.a()     // Catch:{ Throwable -> 0x012f, all -> 0x012d }
            if (r6 == 0) goto L_0x00f6
            r7 = 0
            r8 = 0
            int r9 = r3.getWidth()     // Catch:{ Throwable -> 0x012f, all -> 0x012d }
            int r10 = r3.getHeight()     // Catch:{ Throwable -> 0x012f, all -> 0x012d }
            r12 = 0
            r6 = r3
            android.graphics.Bitmap r6 = android.graphics.Bitmap.createBitmap(r6, r7, r8, r9, r10, r11, r12)     // Catch:{ Throwable -> 0x012f, all -> 0x012d }
            if (r3 == r6) goto L_0x00e4
            r3.recycle()     // Catch:{ Throwable -> 0x012f, all -> 0x012d }
        L_0x00e4:
            int r3 = r13.a(r2, r5, r6)     // Catch:{ Throwable -> 0x012f, all -> 0x012d }
            int r5 = r13.b(r2, r5, r6)     // Catch:{ Throwable -> 0x012f, all -> 0x012d }
            android.graphics.Bitmap r3 = android.graphics.Bitmap.createBitmap(r6, r2, r2, r3, r5)     // Catch:{ Throwable -> 0x012f, all -> 0x012d }
            if (r6 == r3) goto L_0x0113
            r6.recycle()     // Catch:{ Throwable -> 0x012f, all -> 0x012d }
            goto L_0x0113
        L_0x00f6:
            int r6 = r3.getWidth()     // Catch:{ Throwable -> 0x012f, all -> 0x012d }
            int r6 = r6 - r5
            int r7 = r13.b(r6)     // Catch:{ Throwable -> 0x012f, all -> 0x012d }
            r8 = 0
            int r6 = r3.getWidth()     // Catch:{ Throwable -> 0x012f, all -> 0x012d }
            int r6 = r6 - r5
            int r9 = r13.a(r6, r5, r3)     // Catch:{ Throwable -> 0x012f, all -> 0x012d }
            int r10 = r13.b(r2, r5, r3)     // Catch:{ Throwable -> 0x012f, all -> 0x012d }
            r12 = 0
            r6 = r3
            android.graphics.Bitmap r3 = android.graphics.Bitmap.createBitmap(r6, r7, r8, r9, r10, r11, r12)     // Catch:{ Throwable -> 0x012f, all -> 0x012d }
        L_0x0113:
            android.graphics.Bitmap$CompressFormat r5 = android.graphics.Bitmap.CompressFormat.JPEG     // Catch:{ Throwable -> 0x012f, all -> 0x012d }
            r6 = 80
            r3.compress(r5, r6, r4)     // Catch:{ Throwable -> 0x012f, all -> 0x012d }
            r4.write(r14)     // Catch:{ Throwable -> 0x012f, all -> 0x012d }
            r4.close()     // Catch:{ Throwable -> 0x012f, all -> 0x012d }
            r3.recycle()     // Catch:{ Throwable -> 0x012f, all -> 0x012d }
            r4.close()     // Catch:{ IOException -> 0x0127 }
            goto L_0x012b
        L_0x0127:
            r14 = move-exception
            r14.printStackTrace()
        L_0x012b:
            r14 = 1
            goto L_0x0163
        L_0x012d:
            r14 = move-exception
            goto L_0x0199
        L_0x012f:
            r14 = move-exception
            r3 = r4
            goto L_0x0136
        L_0x0132:
            r14 = move-exception
            r4 = r3
            goto L_0x0199
        L_0x0135:
            r14 = move-exception
        L_0x0136:
            java.lang.String r4 = "camera_test"
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x0132 }
            r5.<init>()     // Catch:{ all -> 0x0132 }
            java.lang.String r6 = "File"
            r5.append(r6)     // Catch:{ all -> 0x0132 }
            r5.append(r15)     // Catch:{ all -> 0x0132 }
            java.lang.String r15 = " not saved: "
            r5.append(r15)     // Catch:{ all -> 0x0132 }
            java.lang.String r14 = r14.getMessage()     // Catch:{ all -> 0x0132 }
            r5.append(r14)     // Catch:{ all -> 0x0132 }
            java.lang.String r14 = r5.toString()     // Catch:{ all -> 0x0132 }
            android.util.Log.e(r4, r14)     // Catch:{ all -> 0x0132 }
            if (r3 == 0) goto L_0x0162
            r3.close()     // Catch:{ IOException -> 0x015e }
            goto L_0x0162
        L_0x015e:
            r14 = move-exception
            r14.printStackTrace()
        L_0x0162:
            r14 = 0
        L_0x0163:
            if (r14 == 0) goto L_0x0181
            int r14 = f15974b
            int r14 = r14 + r1
            f15974b = r14
            int r14 = f15974b
            r15 = 3
            if (r14 <= r15) goto L_0x0175
            int r14 = f15973a
            if (r14 == r1) goto L_0x0175
            f15973a = r1
        L_0x0175:
            com.shopee.app.camera.MakePhotoActivity r14 = r13.f15975c
            android.net.Uri r15 = android.net.Uri.fromFile(r0)
            int r0 = r13.f15978f
            r14.a((android.net.Uri) r15, (boolean) r1, (int) r0)
            goto L_0x0198
        L_0x0181:
            f15974b = r2
            int r14 = f15973a
            int r14 = r14 * 2
            f15973a = r14
            com.shopee.app.h.r r14 = com.shopee.app.h.r.a()
            r15 = 2131887982(0x7f12076e, float:1.9410586E38)
            r14.b((int) r15)
            com.shopee.app.camera.MakePhotoActivity r14 = r13.f15975c
            r14.g()
        L_0x0198:
            return
        L_0x0199:
            if (r4 == 0) goto L_0x01a3
            r4.close()     // Catch:{ IOException -> 0x019f }
            goto L_0x01a3
        L_0x019f:
            r15 = move-exception
            r15.printStackTrace()
        L_0x01a3:
            throw r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shopee.app.camera.e.onPictureTaken(byte[], android.hardware.Camera):void");
    }

    private int a(int i, int i2, Bitmap bitmap) {
        return i + i2 > bitmap.getWidth() ? bitmap.getWidth() - b(i) : i2;
    }

    private int b(int i, int i2, Bitmap bitmap) {
        return i + i2 > bitmap.getHeight() ? bitmap.getHeight() - b(i) : i2;
    }

    private Bitmap a(Bitmap bitmap, Matrix matrix) {
        int i;
        int i2;
        int i3;
        int i4;
        boolean z = true;
        boolean z2 = bitmap.getWidth() < bitmap.getHeight();
        double width = (double) (z2 ? bitmap.getWidth() : bitmap.getHeight());
        double height = (double) (z2 ? bitmap.getHeight() : bitmap.getWidth());
        double d2 = (double) this.f15977e;
        double d3 = (double) this.f15976d;
        Double.isNaN(d2);
        Double.isNaN(d3);
        double d4 = d2 / d3;
        if (height / width >= d4) {
            z = false;
        }
        if (z) {
            int i5 = (int) (height / d4);
            int i6 = (int) height;
            if (z2) {
                double d5 = (double) i5;
                Double.isNaN(d5);
                i3 = (int) (width - d5);
            } else {
                i3 = 0;
            }
            if (z2) {
                i4 = 0;
            } else {
                double d6 = (double) i5;
                Double.isNaN(d6);
                i4 = (int) (width - d6);
            }
            Bitmap createBitmap = Bitmap.createBitmap(bitmap, i3, i4, z2 ? i5 : i6, z2 ? i6 : i5, matrix, false);
            bitmap.recycle();
            return createBitmap;
        }
        int i7 = (int) width;
        int i8 = (int) (width * d4);
        if (z2) {
            i = 0;
        } else {
            double d7 = (double) i8;
            Double.isNaN(d7);
            i = (int) (height - d7);
        }
        if (z2) {
            double d8 = (double) i8;
            Double.isNaN(d8);
            i2 = (int) (height - d8);
        } else {
            i2 = 0;
        }
        Bitmap createBitmap2 = Bitmap.createBitmap(bitmap, i, i2, z2 ? i7 : i8, z2 ? i8 : i7, matrix, false);
        bitmap.recycle();
        return createBitmap2;
    }

    private Bitmap b(Bitmap bitmap, Matrix matrix) {
        boolean z = this.h || bitmap.getWidth() < bitmap.getHeight();
        int width = (int) ((double) (z ? bitmap.getWidth() : bitmap.getHeight()));
        int height = (int) ((double) (z ? bitmap.getHeight() : bitmap.getWidth()));
        Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, z ? width : height, z ? height : width, matrix, false);
        if (bitmap != createBitmap) {
            bitmap.recycle();
        }
        return createBitmap;
    }
}
