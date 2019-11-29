package com.shopee.live.livestreaming.util;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.shopee.live.livestreaming.c;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

public class n {
    public static Bitmap a(Context context) {
        Activity activity = (Activity) context;
        View inflate = activity.getLayoutInflater().inflate(c.f.live_streaming_layout_live_bg_pause, (ViewGroup) null);
        ((TextView) inflate.findViewById(c.e.tv_content)).setText(ab.a(activity, c.g.live_streaming_viewer_host_temporary_offline_tip));
        a(inflate, 750, 1334);
        return a(a(inflate));
    }

    public static void a(View view, int i, int i2) {
        view.layout(0, 0, i, i2);
        view.measure(View.MeasureSpec.makeMeasureSpec(i, 1073741824), View.MeasureSpec.makeMeasureSpec(i2, 1073741824));
        view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
    }

    public static Bitmap a(View view) {
        view.setDrawingCacheEnabled(true);
        view.buildDrawingCache(true);
        Bitmap drawingCache = view.getDrawingCache();
        if (drawingCache == null) {
            return null;
        }
        Bitmap createBitmap = Bitmap.createBitmap(drawingCache);
        view.setDrawingCacheEnabled(false);
        return createBitmap;
    }

    public static Bitmap a(Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inPurgeable = true;
        options.inInputShareable = true;
        options.inPreferredConfig = Bitmap.Config.ARGB_8888;
        return BitmapFactory.decodeStream(byteArrayInputStream, (Rect) null, options);
    }
}
