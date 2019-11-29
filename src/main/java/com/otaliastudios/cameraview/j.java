package com.otaliastudios.cameraview;

import android.graphics.Bitmap;
import android.os.Handler;

public class j {

    public interface a {
        void a(Bitmap bitmap);
    }

    public static void a(byte[] bArr, int i, int i2, a aVar) {
        final Handler handler = new Handler();
        final byte[] bArr2 = bArr;
        final int i3 = i;
        final int i4 = i2;
        final a aVar2 = aVar;
        ap.a((Runnable) new Runnable() {
            public void run() {
                final Bitmap a2 = j.a(bArr2, i3, i4);
                handler.post(new Runnable() {
                    public void run() {
                        aVar2.a(a2);
                    }
                });
            }
        });
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0039, code lost:
        r5 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x003f, code lost:
        if (r0.intValue() == 2) goto L_0x0059;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0046, code lost:
        if (r0.intValue() == 4) goto L_0x0059;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x004d, code lost:
        if (r0.intValue() == 5) goto L_0x0059;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0054, code lost:
        if (r0.intValue() != 7) goto L_0x0057;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0057, code lost:
        r0 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0059, code lost:
        r0 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:?, code lost:
        r8.close();
     */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x006d A[SYNTHETIC, Splitter:B:40:0x006d] */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0090  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00c7 A[SYNTHETIC, Splitter:B:57:0x00c7] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.graphics.Bitmap a(byte[] r13, int r14, int r15) {
        /*
            r2 = 2147483647(0x7fffffff, float:NaN)
            if (r14 > 0) goto L_0x0009
            r3 = 2147483647(0x7fffffff, float:NaN)
            goto L_0x000a
        L_0x0009:
            r3 = r14
        L_0x000a:
            if (r15 > 0) goto L_0x0010
            r4 = 2147483647(0x7fffffff, float:NaN)
            goto L_0x0011
        L_0x0010:
            r4 = r15
        L_0x0011:
            r5 = 0
            r6 = 1
            r7 = 0
            java.io.ByteArrayInputStream r8 = new java.io.ByteArrayInputStream     // Catch:{ IOException -> 0x0067 }
            r8.<init>(r13)     // Catch:{ IOException -> 0x0067 }
            androidx.e.a.a r0 = new androidx.e.a.a     // Catch:{ IOException -> 0x0061, all -> 0x005e }
            r0.<init>((java.io.InputStream) r8)     // Catch:{ IOException -> 0x0061, all -> 0x005e }
            java.lang.String r5 = "Orientation"
            int r0 = r0.a((java.lang.String) r5, (int) r6)     // Catch:{ IOException -> 0x0061, all -> 0x005e }
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{ IOException -> 0x0061, all -> 0x005e }
            int r5 = r0.intValue()     // Catch:{ IOException -> 0x0061, all -> 0x005e }
            switch(r5) {
                case 1: goto L_0x0039;
                case 2: goto L_0x0039;
                case 3: goto L_0x0036;
                case 4: goto L_0x0036;
                case 5: goto L_0x0033;
                case 6: goto L_0x0033;
                case 7: goto L_0x0030;
                case 8: goto L_0x0030;
                default: goto L_0x002f;
            }     // Catch:{ IOException -> 0x0061, all -> 0x005e }
        L_0x002f:
            goto L_0x0039
        L_0x0030:
            r5 = 270(0x10e, float:3.78E-43)
            goto L_0x003a
        L_0x0033:
            r5 = 90
            goto L_0x003a
        L_0x0036:
            r5 = 180(0xb4, float:2.52E-43)
            goto L_0x003a
        L_0x0039:
            r5 = 0
        L_0x003a:
            int r9 = r0.intValue()     // Catch:{ IOException -> 0x0061, all -> 0x005e }
            r10 = 2
            if (r9 == r10) goto L_0x0059
            int r9 = r0.intValue()     // Catch:{ IOException -> 0x0061, all -> 0x005e }
            r10 = 4
            if (r9 == r10) goto L_0x0059
            int r9 = r0.intValue()     // Catch:{ IOException -> 0x0061, all -> 0x005e }
            r10 = 5
            if (r9 == r10) goto L_0x0059
            int r0 = r0.intValue()     // Catch:{ IOException -> 0x0061, all -> 0x005e }
            r9 = 7
            if (r0 != r9) goto L_0x0057
            goto L_0x0059
        L_0x0057:
            r0 = 0
            goto L_0x005a
        L_0x0059:
            r0 = 1
        L_0x005a:
            r8.close()     // Catch:{ Exception -> 0x0072 }
            goto L_0x0072
        L_0x005e:
            r0 = move-exception
            goto L_0x00c5
        L_0x0061:
            r0 = move-exception
            r5 = r8
            goto L_0x0068
        L_0x0064:
            r0 = move-exception
            r8 = r5
            goto L_0x00c5
        L_0x0067:
            r0 = move-exception
        L_0x0068:
            r0.printStackTrace()     // Catch:{ all -> 0x0064 }
            if (r5 == 0) goto L_0x0070
            r5.close()     // Catch:{ Exception -> 0x0070 }
        L_0x0070:
            r0 = 0
            r5 = 0
        L_0x0072:
            if (r3 < r2) goto L_0x007d
            if (r4 >= r2) goto L_0x0077
            goto L_0x007d
        L_0x0077:
            int r2 = r13.length
            android.graphics.Bitmap r1 = android.graphics.BitmapFactory.decodeByteArray(r13, r7, r2)
            goto L_0x00a1
        L_0x007d:
            android.graphics.BitmapFactory$Options r2 = new android.graphics.BitmapFactory$Options
            r2.<init>()
            r2.inJustDecodeBounds = r6
            int r6 = r13.length
            android.graphics.BitmapFactory.decodeByteArray(r13, r7, r6, r2)
            int r6 = r2.outHeight
            int r8 = r2.outWidth
            int r9 = r5 % 180
            if (r9 == 0) goto L_0x0094
            int r6 = r2.outWidth
            int r8 = r2.outHeight
        L_0x0094:
            int r3 = a((int) r8, (int) r6, (int) r3, (int) r4)
            r2.inSampleSize = r3
            r2.inJustDecodeBounds = r7
            int r3 = r13.length
            android.graphics.Bitmap r1 = android.graphics.BitmapFactory.decodeByteArray(r13, r7, r3, r2)
        L_0x00a1:
            if (r5 != 0) goto L_0x00a8
            if (r0 == 0) goto L_0x00a6
            goto L_0x00a8
        L_0x00a6:
            r0 = r1
            goto L_0x00c4
        L_0x00a8:
            android.graphics.Matrix r11 = new android.graphics.Matrix
            r11.<init>()
            float r0 = (float) r5
            r11.setRotate(r0)
            r7 = 0
            r8 = 0
            int r9 = r1.getWidth()
            int r10 = r1.getHeight()
            r12 = 1
            r6 = r1
            android.graphics.Bitmap r0 = android.graphics.Bitmap.createBitmap(r6, r7, r8, r9, r10, r11, r12)
            r1.recycle()
        L_0x00c4:
            return r0
        L_0x00c5:
            if (r8 == 0) goto L_0x00ca
            r8.close()     // Catch:{ Exception -> 0x00ca }
        L_0x00ca:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.otaliastudios.cameraview.j.a(byte[], int, int):android.graphics.Bitmap");
    }

    private static int a(int i, int i2, int i3, int i4) {
        int i5 = 1;
        if (i2 > i4 || i > i3) {
            while (true) {
                if (i2 / i5 < i4 && i / i5 < i3) {
                    break;
                }
                i5 *= 2;
            }
        }
        return i5;
    }
}
