package com.shopee.feeds.feedlibrary.view.preview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import com.garena.cropimage.library.c;
import com.shopee.feeds.feedlibrary.b;
import com.shopee.feeds.feedlibrary.data.entity.ImageSizeEntity;
import com.shopee.feeds.feedlibrary.util.q;
import com.shopee.feeds.feedlibrary.view.d;
import com.squareup.a.w;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.UUID;

public class j {
    public static String a(Context context) {
        return q.a(context, "feedCrop_" + UUID.randomUUID().toString().replace("-", "") + ".jpg");
    }

    public static void a(boolean z) {
        if (!com.shopee.feeds.feedlibrary.util.j.a().d()) {
            d dVar = new d(b.b().c());
            String c2 = com.shopee.sdk.b.a().d().a().c();
            dVar.setUserName("@" + c2);
            ImageSizeEntity b2 = com.shopee.feeds.feedlibrary.util.j.a().b();
            dVar.a(z, b2.getWidth(), b2.getHeight());
            dVar.measure(-2, -2);
            Bitmap createBitmap = Bitmap.createBitmap(dVar.getMeasuredWidth(), dVar.getMeasuredHeight(), Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(createBitmap);
            dVar.layout(0, 0, dVar.getMeasuredWidth(), dVar.getMeasuredHeight());
            dVar.draw(canvas);
            String a2 = a();
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(a2, false);
                createBitmap.compress(Bitmap.CompressFormat.PNG, 90, fileOutputStream);
                fileOutputStream.flush();
                fileOutputStream.close();
                com.shopee.feeds.feedlibrary.util.j.a().a(true);
                com.shopee.feeds.feedlibrary.util.j.a().a(a2);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public static void a(String str) {
        try {
            FileInputStream fileInputStream = new FileInputStream(str);
            FileInputStream fileInputStream2 = new FileInputStream(com.shopee.feeds.feedlibrary.util.j.a().c());
            Bitmap decodeStream = BitmapFactory.decodeStream(fileInputStream);
            Bitmap decodeStream2 = BitmapFactory.decodeStream(fileInputStream2);
            Bitmap copy = decodeStream.copy(Bitmap.Config.ARGB_8888, true);
            fileInputStream.close();
            new Canvas(copy).drawBitmap(decodeStream2, (float) (decodeStream.getWidth() - decodeStream2.getWidth()), (float) (decodeStream.getHeight() - decodeStream2.getHeight()), (Paint) null);
            FileOutputStream fileOutputStream = new FileOutputStream(str);
            copy.compress(Bitmap.CompressFormat.PNG, 90, fileOutputStream);
            fileOutputStream.flush();
            fileOutputStream.getFD().sync();
            fileOutputStream.close();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static String a() {
        Context c2 = b.b().c();
        return q.a(c2, "feed_water_name" + UUID.randomUUID().toString() + ".png");
    }

    public static String b(Context context) {
        return q.c(context, "feedCrop_" + UUID.randomUUID().toString().replace("-", "") + ".mp4");
    }

    public static File c(Context context) {
        return context.getDir("images", 0);
    }

    public static c a(Context context, a aVar) {
        try {
            if (aVar.k()) {
                return new c(w.a(context).a(new File(aVar.h())), 1024, 1024);
            }
            if (aVar.m()) {
                return new c(w.a(context).a(aVar.h()), 1024, 1024);
            }
            return new c(w.a(context).a(aVar.h()), 1024, 1024);
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static int d(Context context) {
        return context.getResources().getDisplayMetrics().widthPixels;
    }
}
