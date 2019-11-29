package com.shopee.app.h;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.media.ExifInterface;
import android.media.MediaScannerConnection;
import android.media.ThumbnailUtils;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.Base64;
import com.facebook.common.util.UriUtil;
import com.shopee.app.application.ar;
import d.c.f;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class l {

    /* renamed from: a  reason: collision with root package name */
    private static l f17677a;

    public enum a {
        SQUARE,
        LANDSCAPE,
        PORTRAIT,
        LONG_LANDSCAPE,
        LONG_PORTRAIT
    }

    private l() {
    }

    public static l a() {
        if (f17677a == null) {
            f17677a = new l();
        }
        return f17677a;
    }

    private static int a(BitmapFactory.Options options, int i, int i2, boolean z, int i3, int i4) {
        int i5;
        int i6;
        int i7 = options.outHeight;
        int i8 = options.outWidth;
        if (i4 == 90 || i4 == 270) {
            i7 = options.outWidth;
            i8 = options.outHeight;
        }
        if (!z) {
            i6 = Math.round(((float) i8) / ((float) i));
            i5 = Math.round(((float) i7) / ((float) i2));
        } else {
            i6 = (int) Math.ceil((double) (((float) i8) / ((float) i)));
            i5 = (int) Math.ceil((double) (((float) i7) / ((float) i2)));
        }
        int i9 = i6 < i5 ? i6 : i5;
        if (i6 <= i5) {
            i6 = i5;
        }
        if (i9 < 1) {
            i9 = 1;
        }
        if (i6 < 1) {
            i6 = 1;
        }
        if (i3 != 1) {
            return i6;
        }
        int i10 = i9 * 2;
        return i6 > i10 ? i10 : i9;
    }

    private static void a(String str, String str2, String str3, long j, int i, String str4) {
        ContentValues contentValues = new ContentValues();
        if (str4.endsWith("gif")) {
            contentValues.put("mime_type", "image/gif");
        } else {
            contentValues.put("mime_type", "image/jpeg");
        }
        contentValues.put("title", str2);
        contentValues.put("_display_name", str2);
        contentValues.put("description", str3);
        contentValues.put("orientation", Integer.valueOf(i));
        contentValues.put("_size", Long.valueOf(new File(str).length()));
        contentValues.put("_data", str);
        contentValues.put("datetaken", Long.valueOf(j));
        contentValues.put("date_added", Long.valueOf(j));
        contentValues.put("date_modified", Long.valueOf(j));
        ar.a().getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues);
    }

    public static String b() {
        String path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM).getPath();
        StringBuilder sb = new StringBuilder();
        sb.append(path);
        sb.append("/Camera/");
        File file = new File(sb.toString());
        if (!file.isDirectory() || !file.exists()) {
            file.mkdirs();
        }
        return sb.toString();
    }

    /* JADX WARNING: type inference failed for: r3v1 */
    /* JADX WARNING: type inference failed for: r3v3 */
    /* JADX WARNING: type inference failed for: r3v13 */
    /* JADX WARNING: Can't wrap try/catch for region: R(5:17|18|(2:38|39)|40|41) */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x004b, code lost:
        if (r3 != null) goto L_0x002a;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:40:0x005d */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0045 A[Catch:{ Exception -> 0x0046, OutOfMemoryError -> 0x0035, all -> 0x0032, all -> 0x0057 }] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0050  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x005a A[SYNTHETIC, Splitter:B:38:0x005a] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized android.graphics.Bitmap a(java.lang.String r5) {
        /*
            r4 = this;
            monitor-enter(r4)
            com.shopee.app.h.f r0 = com.shopee.app.h.f.a()     // Catch:{ all -> 0x005e }
            boolean r0 = r0.e(r5)     // Catch:{ all -> 0x005e }
            r1 = 0
            if (r0 != 0) goto L_0x000e
            monitor-exit(r4)
            return r1
        L_0x000e:
            android.graphics.BitmapFactory$Options r0 = new android.graphics.BitmapFactory$Options     // Catch:{ all -> 0x005e }
            r0.<init>()     // Catch:{ all -> 0x005e }
            r2 = 0
            r0.inScaled = r2     // Catch:{ all -> 0x005e }
            r0.inDither = r2     // Catch:{ all -> 0x005e }
            android.graphics.Bitmap$Config r3 = android.graphics.Bitmap.Config.ARGB_8888     // Catch:{ all -> 0x005e }
            r0.inPreferredConfig = r3     // Catch:{ all -> 0x005e }
            r3 = 1
            r0.inPurgeable = r3     // Catch:{ all -> 0x005e }
            r0.inInputShareable = r3     // Catch:{ all -> 0x005e }
            java.io.FileInputStream r3 = new java.io.FileInputStream     // Catch:{ Exception -> 0x0046, OutOfMemoryError -> 0x0035, all -> 0x0032 }
            r3.<init>(r5)     // Catch:{ Exception -> 0x0046, OutOfMemoryError -> 0x0035, all -> 0x0032 }
            android.graphics.Bitmap r1 = android.graphics.BitmapFactory.decodeStream(r3, r1, r0)     // Catch:{ Exception -> 0x0030, OutOfMemoryError -> 0x002e }
        L_0x002a:
            r3.close()     // Catch:{ IOException -> 0x004e }
            goto L_0x004e
        L_0x002e:
            r5 = move-exception
            goto L_0x0037
        L_0x0030:
            r5 = move-exception
            goto L_0x0048
        L_0x0032:
            r5 = move-exception
            r3 = r1
            goto L_0x0058
        L_0x0035:
            r5 = move-exception
            r3 = r1
        L_0x0037:
            java.lang.System.gc()     // Catch:{ all -> 0x0057 }
            java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x0057 }
            java.lang.Object[] r0 = new java.lang.Object[r2]     // Catch:{ all -> 0x0057 }
            com.garena.android.appkit.d.a.a(r5, r0)     // Catch:{ all -> 0x0057 }
            if (r3 == 0) goto L_0x004e
            goto L_0x002a
        L_0x0046:
            r5 = move-exception
            r3 = r1
        L_0x0048:
            com.garena.android.appkit.d.a.a(r5)     // Catch:{ all -> 0x0057 }
            if (r3 == 0) goto L_0x004e
            goto L_0x002a
        L_0x004e:
            if (r1 == 0) goto L_0x0055
            r5 = 160(0xa0, float:2.24E-43)
            r1.setDensity(r5)     // Catch:{ all -> 0x005e }
        L_0x0055:
            monitor-exit(r4)
            return r1
        L_0x0057:
            r5 = move-exception
        L_0x0058:
            if (r3 == 0) goto L_0x005d
            r3.close()     // Catch:{ IOException -> 0x005d }
        L_0x005d:
            throw r5     // Catch:{ all -> 0x005e }
        L_0x005e:
            r5 = move-exception
            monitor-exit(r4)
            goto L_0x0062
        L_0x0061:
            throw r5
        L_0x0062:
            goto L_0x0061
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shopee.app.h.l.a(java.lang.String):android.graphics.Bitmap");
    }

    public Bitmap a(Uri uri, int i, int i2) {
        return a(uri, i, i2, 0, true);
    }

    private Bitmap a(Uri uri, int i, int i2, int i3, boolean z) {
        Bitmap a2;
        if (!z) {
            return a(uri, i, i2, i3);
        }
        try {
            synchronized (this) {
                a2 = a(uri, i, i2, i3);
            }
            return a2;
        } catch (OutOfMemoryError unused) {
            System.gc();
            return null;
        }
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:57:0x012f */
    /* JADX WARNING: Removed duplicated region for block: B:104:0x019b A[SYNTHETIC, Splitter:B:104:0x019b] */
    /* JADX WARNING: Removed duplicated region for block: B:113:0x01b3 A[SYNTHETIC, Splitter:B:113:0x01b3] */
    /* JADX WARNING: Removed duplicated region for block: B:120:0x01c2 A[SYNTHETIC, Splitter:B:120:0x01c2] */
    /* JADX WARNING: Removed duplicated region for block: B:129:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:132:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0119 A[SYNTHETIC, Splitter:B:46:0x0119] */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x014e A[SYNTHETIC, Splitter:B:69:0x014e] */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x015a A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x015c  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x0174 A[SYNTHETIC, Splitter:B:86:0x0174] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:101:0x0196=Splitter:B:101:0x0196, B:110:0x01a7=Splitter:B:110:0x01a7} */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:66:0x0149=Splitter:B:66:0x0149, B:57:0x012f=Splitter:B:57:0x012f} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private android.graphics.Bitmap a(android.net.Uri r21, int r22, int r23, int r24) {
        /*
            r20 = this;
            r1 = r20
            r2 = r21
            r3 = r22
            r4 = r23
            r9 = r24
            r10 = 0
            if (r4 > 0) goto L_0x0015
            if (r3 > 0) goto L_0x0015
            java.lang.String r0 = "Invalid resize dimensions"
            com.shopee.app.h.b.a(r0)
            return r10
        L_0x0015:
            android.content.Context r0 = com.shopee.app.application.ar.a()
            android.content.Context r0 = r0.getApplicationContext()
            if (r0 != 0) goto L_0x0020
            return r10
        L_0x0020:
            android.content.ContentResolver r11 = r0.getContentResolver()
            android.graphics.BitmapFactory$Options r12 = new android.graphics.BitmapFactory$Options
            r12.<init>()
            r13 = 1
            r12.inJustDecodeBounds = r13
            java.io.InputStream r14 = r11.openInputStream(r2)     // Catch:{ OutOfMemoryError -> 0x01a6, IOException -> 0x0194, all -> 0x0190 }
            android.graphics.BitmapFactory.decodeStream(r14, r10, r12)     // Catch:{ OutOfMemoryError -> 0x018b, IOException -> 0x0185, all -> 0x017e }
            java.lang.String r0 = r1.a((android.content.ContentResolver) r11, (android.net.Uri) r2)     // Catch:{ OutOfMemoryError -> 0x018b, IOException -> 0x0185, all -> 0x017e }
            int r15 = b((java.lang.String) r0)     // Catch:{ OutOfMemoryError -> 0x018b, IOException -> 0x0185, all -> 0x017e }
            if (r14 == 0) goto L_0x0046
            r14.close()     // Catch:{ IOException -> 0x0041 }
            goto L_0x0046
        L_0x0041:
            r0 = move-exception
            r5 = r0
            r5.printStackTrace()
        L_0x0046:
            int r0 = r12.outWidth
            float r0 = (float) r0
            int r5 = r12.outHeight
            float r5 = (float) r5
            com.shopee.app.h.l$a r0 = a((float) r0, (float) r5)
            com.shopee.app.h.l$a r5 = com.shopee.app.h.l.a.LONG_LANDSCAPE
            if (r0 == r5) goto L_0x005f
            com.shopee.app.h.l$a r5 = com.shopee.app.h.l.a.LONG_PORTRAIT
            boolean r5 = r0.equals(r5)
            if (r5 == 0) goto L_0x005d
            goto L_0x005f
        L_0x005d:
            r5 = 0
            goto L_0x0060
        L_0x005f:
            r5 = 1
        L_0x0060:
            if (r5 == 0) goto L_0x00dd
            int r6 = r3 * r4
            long r6 = (long) r6
            com.shopee.app.h.l$a r8 = com.shopee.app.h.l.a.LONG_PORTRAIT
            r16 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            if (r0 != r8) goto L_0x00a1
            int r8 = r12.outWidth
            int r8 = r8 * r4
            r18 = r11
            double r10 = (double) r8
            int r8 = r12.outHeight
            r19 = r14
            double r13 = (double) r8
            java.lang.Double.isNaN(r13)
            double r13 = r13 * r16
            java.lang.Double.isNaN(r10)
            double r10 = r10 / r13
            int r8 = (int) r10
            double r10 = (double) r6
            java.lang.Double.isNaN(r10)
            double r10 = r10 * r16
            int r8 = r8 * r4
            double r13 = (double) r8
            java.lang.Double.isNaN(r13)
            double r10 = r10 / r13
            double r10 = java.lang.Math.sqrt(r10)
            double r13 = (double) r4
            java.lang.Double.isNaN(r13)
            double r13 = r13 * r10
            int r4 = (int) r13
            double r13 = (double) r3
            java.lang.Double.isNaN(r13)
            double r13 = r13 * r10
            int r3 = (int) r13
            goto L_0x00a5
        L_0x00a1:
            r18 = r11
            r19 = r14
        L_0x00a5:
            com.shopee.app.h.l$a r8 = com.shopee.app.h.l.a.LONG_LANDSCAPE
            if (r0 != r8) goto L_0x00e1
            int r0 = r12.outHeight
            int r0 = r0 * r3
            double r10 = (double) r0
            int r0 = r12.outWidth
            double r13 = (double) r0
            java.lang.Double.isNaN(r13)
            double r13 = r13 * r16
            java.lang.Double.isNaN(r10)
            double r10 = r10 / r13
            int r0 = (int) r10
            double r6 = (double) r6
            java.lang.Double.isNaN(r6)
            double r6 = r6 * r16
            int r0 = r0 * r3
            double r10 = (double) r0
            java.lang.Double.isNaN(r10)
            double r6 = r6 / r10
            double r6 = java.lang.Math.sqrt(r6)
            double r10 = (double) r4
            java.lang.Double.isNaN(r10)
            double r10 = r10 * r6
            int r0 = (int) r10
            double r3 = (double) r3
            java.lang.Double.isNaN(r3)
            double r3 = r3 * r6
            int r3 = (int) r3
            r11 = r0
            r10 = r3
            goto L_0x00e3
        L_0x00dd:
            r18 = r11
            r19 = r14
        L_0x00e1:
            r10 = r3
            r11 = r4
        L_0x00e3:
            r3 = 1
            if (r9 != r3) goto L_0x00f4
            if (r5 == 0) goto L_0x00f4
            r6 = 0
            r7 = 0
            r3 = r12
            r4 = r10
            r5 = r11
            r0 = 0
            r8 = r15
            int r3 = a((android.graphics.BitmapFactory.Options) r3, (int) r4, (int) r5, (boolean) r6, (int) r7, (int) r8)
            goto L_0x0100
        L_0x00f4:
            r0 = 0
            r6 = 0
            r3 = r12
            r4 = r10
            r5 = r11
            r7 = r24
            r8 = r15
            int r3 = a((android.graphics.BitmapFactory.Options) r3, (int) r4, (int) r5, (boolean) r6, (int) r7, (int) r8)
        L_0x0100:
            r12.inJustDecodeBounds = r0
            r12.inDither = r0
            r12.inSampleSize = r3
            r12.inScaled = r0
            android.graphics.Bitmap$Config r0 = android.graphics.Bitmap.Config.ARGB_8888
            r12.inPreferredConfig = r0
            r3 = r18
            java.io.InputStream r14 = r3.openInputStream(r2)     // Catch:{ FileNotFoundException -> 0x0146, OutOfMemoryError -> 0x012d, all -> 0x0128 }
            r2 = 0
            android.graphics.Bitmap r3 = android.graphics.BitmapFactory.decodeStream(r14, r2, r12)     // Catch:{ FileNotFoundException -> 0x0126, OutOfMemoryError -> 0x012f }
            if (r14 == 0) goto L_0x0158
            r14.close()     // Catch:{ IOException -> 0x011d }
            goto L_0x0158
        L_0x011d:
            r0 = move-exception
            r2 = r0
            r2.printStackTrace()
            goto L_0x0158
        L_0x0123:
            r0 = move-exception
            r2 = r0
            goto L_0x0172
        L_0x0126:
            r0 = move-exception
            goto L_0x0149
        L_0x0128:
            r0 = move-exception
            r2 = r0
            r14 = r19
            goto L_0x0172
        L_0x012d:
            r14 = r19
        L_0x012f:
            java.lang.System.gc()     // Catch:{ all -> 0x0123 }
            com.shopee.app.h.e r0 = com.shopee.app.h.e.a()     // Catch:{ all -> 0x0123 }
            r0.b()     // Catch:{ all -> 0x0123 }
            if (r14 == 0) goto L_0x0144
            r14.close()     // Catch:{ IOException -> 0x013f }
            goto L_0x0144
        L_0x013f:
            r0 = move-exception
            r2 = r0
            r2.printStackTrace()
        L_0x0144:
            r2 = 0
            return r2
        L_0x0146:
            r0 = move-exception
            r14 = r19
        L_0x0149:
            r0.printStackTrace()     // Catch:{ all -> 0x0123 }
            if (r14 == 0) goto L_0x0157
            r14.close()     // Catch:{ IOException -> 0x0152 }
            goto L_0x0157
        L_0x0152:
            r0 = move-exception
            r2 = r0
            r2.printStackTrace()
        L_0x0157:
            r3 = 0
        L_0x0158:
            if (r3 != 0) goto L_0x015c
            r2 = 0
            return r2
        L_0x015c:
            if (r9 != 0) goto L_0x0163
            android.graphics.Bitmap r10 = r1.a((android.graphics.Bitmap) r3, (int) r10, (int) r11, (int) r15)
            goto L_0x016c
        L_0x0163:
            r2 = 1
            if (r9 != r2) goto L_0x016b
            android.graphics.Bitmap r10 = r1.b(r3, r10, r11, r15)
            goto L_0x016c
        L_0x016b:
            r10 = 0
        L_0x016c:
            if (r10 == r3) goto L_0x0171
            r3.recycle()
        L_0x0171:
            return r10
        L_0x0172:
            if (r14 == 0) goto L_0x017d
            r14.close()     // Catch:{ IOException -> 0x0178 }
            goto L_0x017d
        L_0x0178:
            r0 = move-exception
            r3 = r0
            r3.printStackTrace()
        L_0x017d:
            throw r2
        L_0x017e:
            r0 = move-exception
            r19 = r14
            r2 = r0
            r10 = r19
            goto L_0x01c0
        L_0x0185:
            r0 = move-exception
            r19 = r14
            r10 = r19
            goto L_0x0196
        L_0x018b:
            r19 = r14
            r10 = r19
            goto L_0x01a7
        L_0x0190:
            r0 = move-exception
            r2 = r0
            r10 = 0
            goto L_0x01c0
        L_0x0194:
            r0 = move-exception
            r10 = 0
        L_0x0196:
            r0.printStackTrace()     // Catch:{ all -> 0x01be }
            if (r10 == 0) goto L_0x01a4
            r10.close()     // Catch:{ IOException -> 0x019f }
            goto L_0x01a4
        L_0x019f:
            r0 = move-exception
            r2 = r0
            r2.printStackTrace()
        L_0x01a4:
            r2 = 0
            return r2
        L_0x01a6:
            r10 = 0
        L_0x01a7:
            java.lang.System.gc()     // Catch:{ all -> 0x01be }
            com.shopee.app.h.e r0 = com.shopee.app.h.e.a()     // Catch:{ all -> 0x01be }
            r0.b()     // Catch:{ all -> 0x01be }
            if (r10 == 0) goto L_0x01bc
            r10.close()     // Catch:{ IOException -> 0x01b7 }
            goto L_0x01bc
        L_0x01b7:
            r0 = move-exception
            r2 = r0
            r2.printStackTrace()
        L_0x01bc:
            r2 = 0
            return r2
        L_0x01be:
            r0 = move-exception
            r2 = r0
        L_0x01c0:
            if (r10 == 0) goto L_0x01cb
            r10.close()     // Catch:{ IOException -> 0x01c6 }
            goto L_0x01cb
        L_0x01c6:
            r0 = move-exception
            r3 = r0
            r3.printStackTrace()
        L_0x01cb:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shopee.app.h.l.a(android.net.Uri, int, int, int):android.graphics.Bitmap");
    }

    private Bitmap a(Bitmap bitmap, int i, int i2, int i3) {
        int i4;
        int i5;
        float f2;
        float f3;
        if (i3 == 0 || i3 == 180) {
            i5 = bitmap.getWidth();
            i4 = bitmap.getHeight();
        } else {
            i5 = bitmap.getHeight();
            i4 = bitmap.getWidth();
        }
        if (i5 > i4) {
            f3 = (float) i;
            f2 = (float) i5;
        } else {
            f3 = (float) i2;
            f2 = (float) i4;
        }
        float f4 = f3 / f2;
        if (f4 == 1.0f && i3 == 0) {
            return bitmap;
        }
        Matrix matrix = new Matrix();
        matrix.postScale(f4, f4);
        matrix.postRotate((float) i3);
        return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
    }

    private Bitmap b(Bitmap bitmap, int i, int i2, int i3) {
        Bitmap bitmap2;
        Matrix matrix = new Matrix();
        matrix.postRotate((float) i3);
        if (i3 != 0) {
            bitmap2 = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        } else {
            bitmap2 = bitmap;
        }
        if (bitmap2 != bitmap) {
            bitmap.recycle();
        }
        return ThumbnailUtils.extractThumbnail(bitmap2, i, i2);
    }

    public synchronized void a(String str, byte[] bArr, int i) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(str, false);
        fileOutputStream.write(bArr, 0, i);
        fileOutputStream.flush();
        fileOutputStream.close();
    }

    public static a a(float f2, float f3) {
        if (f2 == f3) {
            return a.SQUARE;
        }
        float f4 = f3 / f2;
        if (f4 > 3.5f) {
            return a.LONG_PORTRAIT;
        }
        if (f4 > 1.0f) {
            return a.PORTRAIT;
        }
        float f5 = f2 / f3;
        if (f5 > 3.5f) {
            return a.LONG_LANDSCAPE;
        }
        if (f5 > 1.0f) {
            return a.LANDSCAPE;
        }
        return a.SQUARE;
    }

    public static Bitmap a(Bitmap bitmap, int i, int i2) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        if (width * i2 > height * i) {
            return Bitmap.createScaledBitmap(bitmap, (int) ((((float) width) / ((float) height)) * ((float) i2)), i2, true);
        }
        return Bitmap.createScaledBitmap(bitmap, i, (int) ((((float) height) / ((float) width)) * ((float) i)), true);
    }

    public static Bitmap b(Bitmap bitmap, int i, int i2) {
        return c(bitmap, i, i2);
    }

    private static Bitmap c(Bitmap bitmap, int i, int i2) {
        com.garena.android.appkit.d.a.e("thumb %d %d", Integer.valueOf(i), Integer.valueOf(i2));
        return ThumbnailUtils.extractThumbnail(bitmap, i, i2);
    }

    public byte[] a(Bitmap bitmap, int i) {
        if (i <= 0) {
            i = 80;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, i, byteArrayOutputStream);
        while (byteArrayOutputStream.toByteArray().length > 5000000 && i >= 10) {
            try {
                byteArrayOutputStream.flush();
                i /= 2;
                bitmap.compress(Bitmap.CompressFormat.JPEG, i, byteArrayOutputStream);
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        try {
            byteArrayOutputStream.close();
        } catch (IOException e3) {
            e3.printStackTrace();
        }
        return byteArray;
    }

    private String a(ContentResolver contentResolver, Uri uri) throws IOException {
        if (uri.getScheme().equals(UriUtil.LOCAL_FILE_SCHEME)) {
            return uri.getPath();
        }
        Cursor query = contentResolver.query(uri, new String[]{"_data"}, (String) null, (String[]) null, (String) null);
        int columnIndexOrThrow = query.getColumnIndexOrThrow("_data");
        query.moveToFirst();
        String string = query.getString(columnIndexOrThrow);
        query.close();
        return string;
    }

    private static int b(String str) throws IOException {
        int attributeInt = new ExifInterface(str).getAttributeInt("Orientation", 1);
        com.garena.android.appkit.d.a.e("EXIF %d", Integer.valueOf(attributeInt));
        if (attributeInt == 1) {
            return 0;
        }
        if (attributeInt == 3) {
            return 180;
        }
        if (attributeInt != 6) {
            return attributeInt != 8 ? 0 : 270;
        }
        return 90;
    }

    public boolean a(Bitmap bitmap, String str) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        try {
            File file = new File(b() + str);
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            fileOutputStream.write(byteArray);
            fileOutputStream.close();
            a(file.getPath(), str, com.garena.android.appkit.tools.a.a.a(com.garena.android.appkit.tools.a.a.a(), "ID"), com.garena.android.appkit.tools.a.a.b(), 0, ".jpg");
            return true;
        } catch (IOException e2) {
            com.garena.android.appkit.d.a.a(e2);
            return false;
        }
    }

    public Uri b(Bitmap bitmap, String str) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        try {
            File file = new File(b() + str);
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            fileOutputStream.write(byteArray);
            fileOutputStream.close();
            a(file.getPath(), str, com.garena.android.appkit.tools.a.a.a(com.garena.android.appkit.tools.a.a.a(), "ID"), com.garena.android.appkit.tools.a.a.b(), 0, ".jpg");
            return Uri.fromFile(file);
        } catch (IOException e2) {
            com.garena.android.appkit.d.a.a(e2);
            return null;
        }
    }

    public Uri a(File file) {
        try {
            File externalStoragePublicDirectory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
            externalStoragePublicDirectory.mkdirs();
            String format = new SimpleDateFormat("yyyyMMddHHmmss", Locale.US).format(new Date());
            File file2 = new File(externalStoragePublicDirectory, format + "." + f.a(file));
            f.a(file, file2, true, 8192);
            MediaScannerConnection.scanFile(ar.a().getApplicationContext(), new String[]{file2.getPath()}, (String[]) null, (MediaScannerConnection.OnScanCompletedListener) null);
            return Uri.fromFile(file2);
        } catch (Exception e2) {
            com.garena.android.appkit.d.a.a(e2);
            return null;
        }
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x004f */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0045 A[SYNTHETIC, Splitter:B:24:0x0045] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0066 A[SYNTHETIC, Splitter:B:40:0x0066] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:21:0x0040=Splitter:B:21:0x0040, B:31:0x004f=Splitter:B:31:0x004f} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.graphics.Rect a(android.net.Uri r5) {
        /*
            r4 = this;
            android.content.Context r0 = com.shopee.app.application.ar.a()
            android.content.Context r0 = r0.getApplicationContext()
            r1 = 0
            if (r0 != 0) goto L_0x000c
            return r1
        L_0x000c:
            android.content.ContentResolver r0 = r0.getContentResolver()
            android.graphics.BitmapFactory$Options r2 = new android.graphics.BitmapFactory$Options
            r2.<init>()
            r3 = 1
            r2.inJustDecodeBounds = r3
            java.io.InputStream r3 = r0.openInputStream(r5)     // Catch:{ OutOfMemoryError -> 0x004e, IOException -> 0x003e, all -> 0x003b }
            android.graphics.BitmapFactory.decodeStream(r3, r1, r2)     // Catch:{ OutOfMemoryError -> 0x004f, IOException -> 0x0039 }
            r4.a((android.content.ContentResolver) r0, (android.net.Uri) r5)     // Catch:{ OutOfMemoryError -> 0x004f, IOException -> 0x0039 }
            if (r3 == 0) goto L_0x002c
            r3.close()     // Catch:{ IOException -> 0x0028 }
            goto L_0x002c
        L_0x0028:
            r5 = move-exception
            r5.printStackTrace()
        L_0x002c:
            android.graphics.Rect r5 = new android.graphics.Rect
            int r0 = r2.outWidth
            int r1 = r2.outHeight
            r2 = 0
            r5.<init>(r2, r2, r0, r1)
            return r5
        L_0x0037:
            r5 = move-exception
            goto L_0x0064
        L_0x0039:
            r5 = move-exception
            goto L_0x0040
        L_0x003b:
            r5 = move-exception
            r3 = r1
            goto L_0x0064
        L_0x003e:
            r5 = move-exception
            r3 = r1
        L_0x0040:
            r5.printStackTrace()     // Catch:{ all -> 0x0037 }
            if (r3 == 0) goto L_0x004d
            r3.close()     // Catch:{ IOException -> 0x0049 }
            goto L_0x004d
        L_0x0049:
            r5 = move-exception
            r5.printStackTrace()
        L_0x004d:
            return r1
        L_0x004e:
            r3 = r1
        L_0x004f:
            java.lang.System.gc()     // Catch:{ all -> 0x0037 }
            com.shopee.app.h.e r5 = com.shopee.app.h.e.a()     // Catch:{ all -> 0x0037 }
            r5.b()     // Catch:{ all -> 0x0037 }
            if (r3 == 0) goto L_0x0063
            r3.close()     // Catch:{ IOException -> 0x005f }
            goto L_0x0063
        L_0x005f:
            r5 = move-exception
            r5.printStackTrace()
        L_0x0063:
            return r1
        L_0x0064:
            if (r3 == 0) goto L_0x006e
            r3.close()     // Catch:{ IOException -> 0x006a }
            goto L_0x006e
        L_0x006a:
            r0 = move-exception
            r0.printStackTrace()
        L_0x006e:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shopee.app.h.l.a(android.net.Uri):android.graphics.Rect");
    }

    public String a(String str, int i) throws FileNotFoundException {
        Context a2 = ar.a();
        if (a2 == null || TextUtils.isEmpty(str)) {
            return null;
        }
        Bitmap decodeStream = BitmapFactory.decodeStream(a2.getContentResolver().openInputStream(Uri.parse(str)));
        Matrix matrix = new Matrix();
        if (i != 0) {
            matrix.setRotate((float) i);
            Bitmap createBitmap = Bitmap.createBitmap(decodeStream, 0, 0, decodeStream.getWidth(), decodeStream.getHeight(), matrix, true);
            decodeStream.recycle();
            decodeStream = createBitmap;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        decodeStream.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        return "data:image/jpeg;base64," + Base64.encodeToString(byteArray, 2);
    }

    /* JADX WARNING: Removed duplicated region for block: B:32:0x005b A[SYNTHETIC, Splitter:B:32:0x005b] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0067 A[SYNTHETIC, Splitter:B:39:0x0067] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.shopee.app.h.l.b b(android.net.Uri r4) {
        /*
            android.graphics.BitmapFactory$Options r0 = new android.graphics.BitmapFactory$Options
            r0.<init>()
            r1 = 1
            r0.inJustDecodeBounds = r1
            r1 = 0
            com.shopee.app.application.ar r2 = com.shopee.app.application.ar.f()     // Catch:{ Exception -> 0x0054, all -> 0x0051 }
            android.content.ContentResolver r2 = r2.getContentResolver()     // Catch:{ Exception -> 0x0054, all -> 0x0051 }
            java.io.InputStream r2 = r2.openInputStream(r4)     // Catch:{ Exception -> 0x0054, all -> 0x0051 }
            android.graphics.BitmapFactory.decodeStream(r2, r1, r0)     // Catch:{ Exception -> 0x004f }
            java.lang.String r4 = r4.getPath()     // Catch:{ Exception -> 0x004f }
            int r4 = b((java.lang.String) r4)     // Catch:{ Exception -> 0x004f }
            if (r4 == 0) goto L_0x003b
            r3 = 180(0xb4, float:2.52E-43)
            if (r4 != r3) goto L_0x0027
            goto L_0x003b
        L_0x0027:
            com.shopee.app.h.l$b r4 = new com.shopee.app.h.l$b     // Catch:{ Exception -> 0x004f }
            int r3 = r0.outHeight     // Catch:{ Exception -> 0x004f }
            int r0 = r0.outWidth     // Catch:{ Exception -> 0x004f }
            r4.<init>(r3, r0)     // Catch:{ Exception -> 0x004f }
            if (r2 == 0) goto L_0x003a
            r2.close()     // Catch:{ IOException -> 0x0036 }
            goto L_0x003a
        L_0x0036:
            r0 = move-exception
            com.garena.android.appkit.d.a.a(r0)
        L_0x003a:
            return r4
        L_0x003b:
            com.shopee.app.h.l$b r4 = new com.shopee.app.h.l$b     // Catch:{ Exception -> 0x004f }
            int r3 = r0.outWidth     // Catch:{ Exception -> 0x004f }
            int r0 = r0.outHeight     // Catch:{ Exception -> 0x004f }
            r4.<init>(r3, r0)     // Catch:{ Exception -> 0x004f }
            if (r2 == 0) goto L_0x004e
            r2.close()     // Catch:{ IOException -> 0x004a }
            goto L_0x004e
        L_0x004a:
            r0 = move-exception
            com.garena.android.appkit.d.a.a(r0)
        L_0x004e:
            return r4
        L_0x004f:
            r4 = move-exception
            goto L_0x0056
        L_0x0051:
            r4 = move-exception
            r2 = r1
            goto L_0x0065
        L_0x0054:
            r4 = move-exception
            r2 = r1
        L_0x0056:
            com.garena.android.appkit.d.a.a(r4)     // Catch:{ all -> 0x0064 }
            if (r2 == 0) goto L_0x0063
            r2.close()     // Catch:{ IOException -> 0x005f }
            goto L_0x0063
        L_0x005f:
            r4 = move-exception
            com.garena.android.appkit.d.a.a(r4)
        L_0x0063:
            return r1
        L_0x0064:
            r4 = move-exception
        L_0x0065:
            if (r2 == 0) goto L_0x006f
            r2.close()     // Catch:{ IOException -> 0x006b }
            goto L_0x006f
        L_0x006b:
            r0 = move-exception
            com.garena.android.appkit.d.a.a(r0)
        L_0x006f:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shopee.app.h.l.b(android.net.Uri):com.shopee.app.h.l$b");
    }

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public int f17678a;

        /* renamed from: b  reason: collision with root package name */
        public int f17679b;

        public b(int i, int i2) {
            this.f17678a = i;
            this.f17679b = i2;
        }
    }
}
