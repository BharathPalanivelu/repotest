package com.shopee.feeds.feedlibrary.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import androidx.e.a.a;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.shopee.feeds.feedlibrary.data.entity.MediaCompressParam;
import com.tencent.imsdk.TIMGroupManager;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class BitmapUtil {

    /* renamed from: a  reason: collision with root package name */
    private static final String f28247a = "BitmapUtil";

    private BitmapUtil() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    public static Bitmap a(Context context, Uri uri, float f2, float f3, Bitmap.Config config) {
        int i;
        float f4 = f2;
        float f5 = f3;
        String b2 = k.b(context, uri);
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        Bitmap decodeFile = BitmapFactory.decodeFile(b2, options);
        Bitmap bitmap = null;
        if (decodeFile == null) {
            try {
                FileInputStream fileInputStream = new FileInputStream(b2);
                BitmapFactory.decodeStream(fileInputStream, (Rect) null, options);
                fileInputStream.close();
            } catch (FileNotFoundException e2) {
                e2.printStackTrace();
            } catch (IOException e3) {
                e3.printStackTrace();
            }
        }
        int i2 = options.outHeight;
        int i3 = options.outWidth;
        if (i2 == -1 || i3 == -1) {
            try {
                a aVar = new a(b2);
                i2 = aVar.a("ImageLength", 1);
                i3 = aVar.a("ImageWidth", 1);
            } catch (IOException e4) {
                Log.e(f28247a, "ExifInterface error");
                e4.printStackTrace();
            }
        }
        if (i3 <= 0 || i2 <= 0) {
            Bitmap decodeFile2 = BitmapFactory.decodeFile(b2);
            if (decodeFile2 == null) {
                return null;
            }
            i3 = decodeFile2.getWidth();
            i2 = decodeFile2.getHeight();
        }
        float f6 = (float) i3;
        float f7 = (float) i;
        float f8 = f6 / f7;
        float f9 = f4 / f5;
        if (f7 > f5 || f6 > f4) {
            if (f8 < f9) {
                i3 = (int) ((f5 / f7) * f6);
                i = (int) f5;
            } else {
                i = f8 > f9 ? (int) ((f4 / f6) * f7) : (int) f5;
                i3 = (int) f4;
            }
        }
        options.inSampleSize = a(options, i3, i);
        options.inJustDecodeBounds = false;
        options.inPurgeable = true;
        options.inInputShareable = true;
        options.inTempStorage = new byte[TIMGroupManager.TIM_GET_GROUP_BASE_INFO_FLAG_GROUP_TYPE];
        try {
            decodeFile = BitmapFactory.decodeFile(b2, options);
            if (decodeFile == null) {
                try {
                    FileInputStream fileInputStream2 = new FileInputStream(b2);
                    BitmapFactory.decodeStream(fileInputStream2, (Rect) null, options);
                    fileInputStream2.close();
                } catch (IOException e5) {
                    e5.printStackTrace();
                }
            }
        } catch (OutOfMemoryError e6) {
            e6.printStackTrace();
        }
        if (i <= 0 || i3 <= 0) {
            return null;
        }
        try {
            bitmap = Bitmap.createBitmap(i3, i, config);
        } catch (OutOfMemoryError e7) {
            e7.printStackTrace();
        }
        float f10 = ((float) i3) / ((float) options.outWidth);
        float f11 = ((float) i) / ((float) options.outHeight);
        Matrix matrix = new Matrix();
        matrix.setScale(f10, f11, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED);
        Canvas canvas = new Canvas(bitmap);
        canvas.setMatrix(matrix);
        canvas.drawBitmap(decodeFile, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, new Paint(2));
        try {
            int a2 = new a(b2).a("Orientation", 0);
            Matrix matrix2 = new Matrix();
            if (a2 == 6) {
                matrix2.postRotate(90.0f);
            } else if (a2 == 3) {
                matrix2.postRotate(180.0f);
            } else if (a2 == 8) {
                matrix2.postRotate(270.0f);
            }
            return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix2, true);
        } catch (IOException e8) {
            e8.printStackTrace();
            return bitmap;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x003a A[SYNTHETIC, Splitter:B:19:0x003a] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0045 A[SYNTHETIC, Splitter:B:25:0x0045] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.io.File a(android.content.Context r7, android.net.Uri r8, float r9, float r10, android.graphics.Bitmap.CompressFormat r11, android.graphics.Bitmap.Config r12, int r13, java.lang.String r14, java.lang.String r15, java.lang.String r16) {
        /*
            java.lang.String r0 = r11.name()
            java.lang.String r4 = r0.toLowerCase()
            r1 = r7
            r2 = r14
            r3 = r8
            r5 = r15
            r6 = r16
            java.lang.String r1 = a(r1, r2, r3, r4, r5, r6)
            r2 = 0
            java.io.FileOutputStream r3 = new java.io.FileOutputStream     // Catch:{ FileNotFoundException -> 0x0034 }
            r3.<init>(r1)     // Catch:{ FileNotFoundException -> 0x0034 }
            r0 = r7
            r2 = r8
            r4 = r9
            r5 = r10
            r6 = r12
            android.graphics.Bitmap r0 = a(r7, r8, r9, r10, r12)     // Catch:{ FileNotFoundException -> 0x002f, all -> 0x002c }
            if (r0 == 0) goto L_0x0028
            r2 = r11
            r4 = r13
            r0.compress(r11, r13, r3)     // Catch:{ FileNotFoundException -> 0x002f, all -> 0x002c }
        L_0x0028:
            r3.close()     // Catch:{ IOException -> 0x003d }
            goto L_0x003d
        L_0x002c:
            r0 = move-exception
            r2 = r3
            goto L_0x0043
        L_0x002f:
            r0 = move-exception
            r2 = r3
            goto L_0x0035
        L_0x0032:
            r0 = move-exception
            goto L_0x0043
        L_0x0034:
            r0 = move-exception
        L_0x0035:
            r0.printStackTrace()     // Catch:{ all -> 0x0032 }
            if (r2 == 0) goto L_0x003d
            r2.close()     // Catch:{ IOException -> 0x003d }
        L_0x003d:
            java.io.File r0 = new java.io.File
            r0.<init>(r1)
            return r0
        L_0x0043:
            if (r2 == 0) goto L_0x0048
            r2.close()     // Catch:{ IOException -> 0x0048 }
        L_0x0048:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shopee.feeds.feedlibrary.util.BitmapUtil.a(android.content.Context, android.net.Uri, float, float, android.graphics.Bitmap$CompressFormat, android.graphics.Bitmap$Config, int, java.lang.String, java.lang.String, java.lang.String):java.io.File");
    }

    private static String a(Context context, String str, Uri uri, String str2, String str3, String str4) {
        File file = new File(str);
        if (!file.exists()) {
            file.mkdirs();
        }
        if (TextUtils.isEmpty(str3)) {
            str3 = "";
        }
        if (TextUtils.isEmpty(str4)) {
            str4 = str3 + k.d(k.a(context, uri))[0];
        }
        return file.getAbsolutePath() + File.separator + str4 + "." + str2;
    }

    private static int a(BitmapFactory.Options options, int i, int i2) {
        int i3;
        int i4 = options.outHeight;
        int i5 = options.outWidth;
        if (i4 > i2 || i5 > i) {
            i3 = Math.round(((float) i4) / ((float) i2));
            int round = Math.round(((float) i5) / ((float) i));
            if (i3 >= round) {
                i3 = round;
            }
        } else {
            i3 = 1;
        }
        while (((float) (i5 * i4)) / ((float) (i3 * i3)) > ((float) (i * i2 * 2))) {
            i3++;
        }
        return i3;
    }

    public static Bitmap a(Bitmap bitmap, int i, int i2) {
        Matrix matrix = new Matrix();
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        matrix.postScale(((float) i) / ((float) width), ((float) i2) / ((float) height));
        return Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, false);
    }

    public static Bitmap a(Bitmap bitmap, String str) {
        int i;
        int i2;
        Bitmap copy = BitmapFactory.decodeFile(str).copy(Bitmap.Config.ARGB_8888, true);
        int width = copy.getWidth();
        int height = copy.getHeight();
        int width2 = bitmap.getWidth();
        int height2 = bitmap.getHeight();
        h.b("%s", "mergeImageView enter " + width + "," + height + "," + width2 + "," + height2);
        MediaCompressParam s = j.a().s();
        if (s == null || s.getAndroid() == null) {
            s = e.a();
        }
        int pictureMaxWidth = s.getAndroid().getPictureMaxWidth();
        if (width2 >= pictureMaxWidth && width >= pictureMaxWidth) {
            i2 = (height * pictureMaxWidth) / width;
            i = (height2 * pictureMaxWidth) / width2;
            h.b("%s", "mergeImageView all large " + pictureMaxWidth + "," + i2 + "," + pictureMaxWidth + "," + i);
        } else if (width2 >= pictureMaxWidth || width >= pictureMaxWidth) {
            i2 = (height * pictureMaxWidth) / width;
            i = (height2 * pictureMaxWidth) / width2;
            h.b("%s", "mergeImageView one small " + pictureMaxWidth + "," + i2 + "," + pictureMaxWidth + "," + i);
        } else {
            pictureMaxWidth = Math.max(width, width2);
            i2 = (height * pictureMaxWidth) / width;
            i = (height2 * pictureMaxWidth) / width2;
            h.b("%s", "mergeImageView all small " + pictureMaxWidth + "," + i2 + "," + pictureMaxWidth + "," + i);
        }
        Bitmap a2 = a(copy, pictureMaxWidth, i2);
        Canvas canvas = new Canvas(a2);
        canvas.drawBitmap(a(bitmap, pictureMaxWidth, i), BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, (Paint) null);
        canvas.save();
        canvas.restore();
        return a2;
    }
}
