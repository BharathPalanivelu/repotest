package com.otaliastudios.cameraview;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.YuvImage;
import java.io.ByteArrayOutputStream;

class l {
    static byte[] a(YuvImage yuvImage, a aVar, int i) {
        Rect a2 = a(yuvImage.getWidth(), yuvImage.getHeight(), aVar);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        yuvImage.compressToJpeg(a2, i, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    static byte[] a(byte[] bArr, a aVar, int i) {
        Bitmap a2 = j.a(bArr, Integer.MAX_VALUE, Integer.MAX_VALUE);
        Rect a3 = a(a2.getWidth(), a2.getHeight(), aVar);
        Bitmap createBitmap = Bitmap.createBitmap(a2, a3.left, a3.top, a3.width(), a3.height());
        a2.recycle();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        createBitmap.compress(Bitmap.CompressFormat.JPEG, i, byteArrayOutputStream);
        createBitmap.recycle();
        return byteArrayOutputStream.toByteArray();
    }

    private static Rect a(int i, int i2, a aVar) {
        int i3;
        int i4;
        int i5;
        int i6;
        if (a.a(i, i2).a() > aVar.a()) {
            i3 = (int) (((float) i2) * aVar.a());
            i5 = (i - i3) / 2;
            i6 = i2;
            i4 = 0;
        } else {
            int a2 = (int) (((float) i) / aVar.a());
            i4 = (i2 - a2) / 2;
            i6 = a2;
            i3 = i;
            i5 = 0;
        }
        return new Rect(i5, i4, i3 + i5, i6 + i4);
    }
}
