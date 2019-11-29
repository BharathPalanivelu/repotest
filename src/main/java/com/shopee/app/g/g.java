package com.shopee.app.g;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.text.TextUtils;
import com.facebook.imageutils.JfifUtil;
import com.facebook.react.uimanager.ViewProps;
import com.garena.android.appkit.d.a;
import com.garena.android.appkit.tools.b;
import com.j256.ormlite.stmt.query.SimpleComparison;
import com.shopee.app.application.ar;
import com.shopee.app.data.store.setting.ImageConfig;
import com.shopee.app.h.l;
import com.shopee.app.web.protocol.ShareMessage;
import com.shopee.id.R;
import com.squareup.a.r;
import com.squareup.a.w;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class g {
    public static p a(String str, int i) {
        ArrayList arrayList = new ArrayList();
        try {
            String str2 = "";
            if (!TextUtils.isEmpty(str)) {
                if (str.indexOf("</style>") != -1) {
                    String[] split = str.split("</style>");
                    for (int i2 = 0; i2 < split.length; i2++) {
                        o oVar = new o();
                        oVar.a(split[i2].substring(split[i2].lastIndexOf(SimpleComparison.GREATER_THAN_OPERATION) + 1));
                        str2 = str2 + oVar.b();
                        String substring = split[i2].substring(split[i2].indexOf(ViewProps.COLOR));
                        int indexOf = substring.indexOf("'") + 1;
                        oVar.a(Color.parseColor(substring.substring(indexOf, substring.indexOf("'", indexOf))));
                        arrayList.add(oVar);
                    }
                } else {
                    o oVar2 = new o();
                    oVar2.a(str);
                    oVar2.a(i);
                    String str3 = str2 + oVar2.b();
                    arrayList.add(oVar2);
                    str = str3;
                    return new p(arrayList, str);
                }
            }
            str = str2;
        } catch (Exception e2) {
            a.a(e2);
            o oVar3 = new o();
            oVar3.a(str);
            oVar3.a(i);
            arrayList.add(oVar3);
        }
        return new p(arrayList, str);
    }

    private static Bitmap a(String str, ImageConfig imageConfig, boolean z, boolean z2) {
        Bitmap bitmap;
        w a2 = w.a(ar.a());
        int fullImageWidth = z ? imageConfig.getFullImageWidth() : imageConfig.getThumbImageWidth();
        int fullImageHeight = z ? imageConfig.getFullImageHeight() : imageConfig.getThumbImageHeight();
        int i = R.drawable.img_stamp_default;
        if (z2) {
            if (!z) {
                i = R.drawable.com_garena_shopee_watermark_user_default;
            }
            return l.a(b.h(i), fullImageWidth, fullImageHeight).copy(Bitmap.Config.ARGB_8888, true);
        }
        try {
            bitmap = a2.a(str).b(fullImageWidth, fullImageHeight).a(r.NO_STORE, r.NO_CACHE).e().h();
        } catch (Throwable th) {
            a.a(th);
            bitmap = null;
        }
        if (bitmap != null) {
            return bitmap;
        }
        if (!z) {
            i = R.drawable.com_garena_shopee_watermark_user_default;
        }
        return l.a(b.h(i), fullImageWidth, fullImageHeight).copy(Bitmap.Config.ARGB_8888, true);
    }

    public static Bitmap a(String str) {
        Bitmap bitmap;
        Bitmap bitmap2;
        try {
            bitmap = w.a(ar.a()).a(str).a(r.NO_STORE, r.NO_CACHE).h();
        } catch (Throwable th) {
            a.a(th);
            bitmap = null;
        }
        if (bitmap == null) {
            bitmap2 = l.a(b.h(R.drawable.com_garena_shopee_watermark_user_default), 96, 96).copy(Bitmap.Config.ARGB_8888, true);
        } else {
            bitmap2 = a(bitmap, 96, 96);
        }
        return a(bitmap2);
    }

    public static Bitmap b(String str) {
        Bitmap bitmap;
        try {
            bitmap = w.a(ar.a()).a(str).a(r.NO_STORE, r.NO_CACHE).h();
        } catch (Throwable th) {
            a.a(th);
            bitmap = null;
        }
        if (bitmap == null) {
            return l.a(b.h(R.drawable.img_me_cover_default), 640, (int) JfifUtil.MARKER_SOFn).copy(Bitmap.Config.ARGB_8888, true);
        }
        return a(bitmap, 640, (int) ((((float) bitmap.getHeight()) / ((float) bitmap.getWidth())) * 640.0f));
    }

    public static Bitmap c(String str) {
        Bitmap bitmap;
        try {
            bitmap = w.a(ar.a()).a(str).a(r.NO_STORE, r.NO_CACHE).h();
        } catch (Throwable th) {
            a.a(th);
            bitmap = null;
        }
        if (bitmap == null) {
            return l.a(b.h(R.drawable.img_me_cover_default), 640, 360).copy(Bitmap.Config.ARGB_8888, true);
        }
        return Bitmap.createScaledBitmap(bitmap, 640, 360, true);
    }

    public static Bitmap a(String str, int i, int i2) {
        Bitmap bitmap;
        try {
            bitmap = w.a(ar.a()).a(str).a(r.NO_STORE, r.NO_CACHE).h();
        } catch (Throwable th) {
            a.a(th);
            bitmap = null;
        }
        if (bitmap == null) {
            return l.a(b.h(R.drawable.img_stamp_default), i, i2).copy(Bitmap.Config.ARGB_8888, true);
        }
        return Bitmap.createScaledBitmap(bitmap, i, i2, true);
    }

    private static Bitmap a(Bitmap bitmap, int i, int i2) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Matrix matrix = new Matrix();
        matrix.postScale(((float) i) / ((float) width), ((float) i2) / ((float) height));
        Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, false);
        bitmap.recycle();
        return createBitmap;
    }

    private static Bitmap a(List<Bitmap> list, List<String> list2, String str, String str2) {
        int size = (((list.size() / 4) + (list.size() % 4 == 0 ? 0 : 1)) * 160) + 160;
        if (size > 640) {
            size = 640;
        }
        Bitmap createBitmap = Bitmap.createBitmap(640, size, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint();
        paint.setColor(b.a(R.color.background));
        canvas.drawRect(new Rect(0, 0, 640, size), paint);
        Paint paint2 = new Paint();
        paint2.setTextSize(28.0f);
        paint2.setFlags(1);
        paint2.setColor(b.a(R.color.primary));
        p a2 = a(str, b.a(R.color.primary));
        float measureText = paint2.measureText(a2.b(), 0, a2.b().length());
        float f2 = (float) 640;
        float f3 = (f2 - measureText) / 2.0f;
        a(a2.a(), canvas, f3, 50.0f, paint2);
        Bitmap h = b.h(R.drawable.com_garena_shopee_logo_shopee_stat);
        int i = ((int) f3) - 30;
        canvas.drawBitmap(h, (Rect) null, new Rect(i, 30, i + 23, 53), (Paint) null);
        h.recycle();
        Paint paint3 = new Paint();
        paint3.setTextSize(20.0f);
        paint3.setFlags(1);
        paint3.setColor(b.a(R.color.black26));
        p a3 = a(str2, b.a(R.color.black26));
        a(a3.a(), canvas, (f2 - paint3.measureText(a3.b(), 0, a3.b().length())) / 2.0f, 75.0f, paint3);
        Paint paint4 = new Paint();
        paint4.setColor(b.a(R.color.black06));
        Canvas canvas2 = canvas;
        Paint paint5 = paint4;
        canvas2.drawLine(15.0f, 42.0f, f3 - 50.0f, 42.0f, paint5);
        canvas2.drawLine(f3 + measureText + 20.0f, 42.0f, 625.0f, 42.0f, paint5);
        TextPaint textPaint = new TextPaint();
        textPaint.setTextSize(20.0f);
        textPaint.setStyle(Paint.Style.FILL);
        textPaint.setAntiAlias(true);
        textPaint.setColor(b.a(R.color.white));
        textPaint.setTextAlign(Paint.Align.LEFT);
        textPaint.setLinearText(true);
        Paint paint6 = new Paint();
        paint6.setColor(b.a(R.color.black50));
        Iterator<Bitmap> it = list.iterator();
        int i2 = 16;
        int i3 = 130;
        int i4 = 0;
        while (it.hasNext()) {
            Bitmap next = it.next();
            int i5 = i2 + 140;
            int i6 = i3 + 140;
            Rect rect = new Rect(i2, i3, i5, i6);
            String charSequence = TextUtils.ellipsize(list2.get(i4), textPaint, 116.0f, TextUtils.TruncateAt.END).toString();
            canvas.drawBitmap(next, (Rect) null, rect, (Paint) null);
            float measureText2 = textPaint.measureText(charSequence, 0, charSequence.length());
            Rect rect2 = new Rect();
            textPaint.getTextBounds(charSequence, 0, charSequence.length(), rect2);
            float f4 = (float) i5;
            Iterator<Bitmap> it2 = it;
            Bitmap bitmap = createBitmap;
            canvas.drawRect(new Rect(new Rect((int) ((f4 - measureText2) - 24.0f), i6 - 30, i5, i6)), paint6);
            canvas.drawText(charSequence, f4 - (measureText2 + 12.0f), (float) (i6 - (rect2.height() / 2)), textPaint);
            next.recycle();
            int i7 = i2 + 156;
            i4++;
            if (i4 == 4 || i4 == 8) {
                i3 += 160;
                i2 = 16;
            } else {
                i2 = i7;
            }
            if (i4 >= 12) {
                return bitmap;
            }
            it = it2;
            createBitmap = bitmap;
        }
        return createBitmap;
    }

    private static Bitmap a(Bitmap bitmap, List<Bitmap> list, String str, String str2) {
        int height = bitmap.getHeight() + 108 + 90 + 16;
        Bitmap createBitmap = Bitmap.createBitmap(640, height, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint();
        paint.setColor(-1);
        int i = 0;
        canvas.drawRect(new Rect(0, 0, 640, height), paint);
        canvas.drawBitmap(bitmap, (Rect) null, new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight()), (Paint) null);
        bitmap.recycle();
        Paint paint2 = new Paint();
        paint2.setTextSize(20.0f);
        paint2.setFlags(1);
        paint2.setColor(b.a(R.color.primary));
        p a2 = a(str, b.a(R.color.primary));
        float measureText = paint2.measureText(a2.b(), 0, a2.b().length());
        float f2 = (float) 640;
        float f3 = (f2 - measureText) / 2.0f;
        a(a2.a(), canvas, f3, ((float) bitmap.getHeight()) + 50.0f, paint2);
        Bitmap h = b.h(R.drawable.com_garena_shopee_logo_shopee_stat);
        int i2 = ((int) f3) - 30;
        canvas.drawBitmap(h, (Rect) null, new Rect(i2, bitmap.getHeight() + 30, i2 + 23, bitmap.getHeight() + 30 + 23), (Paint) null);
        h.recycle();
        Paint paint3 = new Paint();
        paint3.setTextSize(20.0f);
        paint3.setFlags(1);
        paint3.setColor(b.a(R.color.black26));
        p a3 = a(str2, b.a(R.color.black26));
        a(a3.a(), canvas, (f2 - paint3.measureText(a3.b(), 0, a3.b().length())) / 2.0f, ((float) bitmap.getHeight()) + 75.0f, paint3);
        Paint paint4 = new Paint();
        paint4.setColor(b.a(R.color.black06));
        Canvas canvas2 = canvas;
        canvas2.drawLine(15.0f, (float) (bitmap.getHeight() + 42), f3 - 50.0f, (float) (bitmap.getHeight() + 42), paint4);
        canvas2.drawLine(f3 + measureText + 20.0f, (float) (bitmap.getHeight() + 42), 625.0f, (float) (bitmap.getHeight() + 42), paint4);
        int size = list.size() > 6 ? 6 : list.size();
        int i3 = (640 - ((size * 90) + ((size - 1) * 14))) / 2;
        int height2 = bitmap.getHeight() + 108;
        for (Bitmap next : list) {
            Rect rect = new Rect(i3, height2, i3 + 90, height2 + 90);
            canvas.drawBitmap(next, (Rect) null, rect, (Paint) null);
            next.recycle();
            i++;
            if (list.size() > 6 && i >= 6) {
                Paint paint5 = new Paint();
                paint5.setColor(b.a(R.color.black54));
                canvas.drawRect(rect, paint5);
                Bitmap copy = l.a(b.h(R.drawable.ic_insta_collecticon_more), 90, 90).copy(Bitmap.Config.ARGB_8888, true);
                canvas.drawBitmap(copy, (Rect) null, rect, (Paint) null);
                copy.recycle();
            }
            i3 += 104;
            if (i >= 6) {
                break;
            }
        }
        return createBitmap;
    }

    private static Bitmap a(Bitmap bitmap) {
        Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint();
        Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
        paint.setAntiAlias(true);
        canvas.drawARGB(0, 0, 0, 0);
        canvas.drawCircle((float) (bitmap.getWidth() / 2), (float) (bitmap.getHeight() / 2), (float) (bitmap.getWidth() / 2), paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, rect, rect, paint);
        return createBitmap;
    }

    private static Bitmap a(Bitmap bitmap, Bitmap bitmap2, List<Bitmap> list, ShareMessage shareMessage) {
        int i;
        String str;
        int i2;
        String str2;
        String shopName = shareMessage.getShopName();
        String watermarkShopDesc = shareMessage.getWatermarkShopDesc();
        int shopFollowerCount = shareMessage.getShopFollowerCount();
        int shopProductCount = shareMessage.getShopProductCount();
        String watermarkShopJoinDate = shareMessage.getWatermarkShopJoinDate();
        int height = bitmap.getHeight() + 120 + 140 + 20;
        Bitmap createBitmap = Bitmap.createBitmap(640, height, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint();
        paint.setColor(-1);
        paint.setFlags(1);
        canvas.drawRect(new Rect(0, 0, 640, height), paint);
        canvas.drawBitmap(bitmap, (Rect) null, new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight()), (Paint) null);
        bitmap.recycle();
        Paint paint2 = new Paint();
        paint2.setColor(b.a(R.color.me_layer_35));
        paint2.setFlags(1);
        canvas.drawRect(new Rect(0, bitmap.getHeight(), 640, bitmap.getHeight()), paint2);
        Paint paint3 = new Paint();
        paint3.setColor(b.a(R.color.me_layer_15));
        paint3.setFlags(1);
        canvas.drawRect(new Rect(0, bitmap.getHeight() - 72, 640, bitmap.getHeight()), paint3);
        float f2 = (float) 640;
        canvas.drawCircle(f2 / 2.0f, 100.0f, 52.0f, paint);
        canvas.drawBitmap(bitmap2, (Rect) null, new Rect(272, 52, 368, 148), (Paint) null);
        Paint paint4 = new Paint();
        paint4.setTextSize(20.0f);
        paint4.setFlags(1);
        paint4.setColor(b.a(R.color.primary));
        String e2 = b.e(R.string.app_name);
        float measureText = paint4.measureText(e2, 0, e2.length());
        float f3 = (f2 - measureText) / 2.0f;
        canvas.drawText(e2, f3, ((float) bitmap.getHeight()) + 50.0f, paint4);
        Bitmap h = b.h(R.drawable.com_garena_shopee_logo_shopee_stat);
        int i3 = ((int) f3) - 30;
        canvas.drawBitmap(h, (Rect) null, new Rect(i3, bitmap.getHeight() + 30, i3 + 23, bitmap.getHeight() + 30 + 23), (Paint) null);
        h.recycle();
        Paint paint5 = new Paint();
        paint5.setTextSize(20.0f);
        paint5.setFlags(1);
        paint5.setColor(b.a(R.color.black26));
        p a2 = a(watermarkShopDesc, b.a(R.color.black26));
        a(a2.a(), canvas, (f2 - paint5.measureText(a2.b(), 0, a2.b().length())) / 2.0f, ((float) bitmap.getHeight()) + 75.0f, paint5);
        Paint paint6 = new Paint();
        paint6.setColor(b.a(R.color.black06));
        Paint paint7 = paint6;
        canvas.drawLine(15.0f, (float) (bitmap.getHeight() + 42), f3 - 50.0f, (float) (bitmap.getHeight() + 42), paint7);
        canvas.drawLine(f3 + measureText + 20.0f, (float) (bitmap.getHeight() + 42), 625.0f, (float) (bitmap.getHeight() + 42), paint7);
        Paint paint8 = new Paint();
        paint8.setTextSize(16.0f);
        paint8.setFlags(1);
        paint8.setTypeface(Typeface.create(Typeface.DEFAULT, 1));
        paint8.setColor(-1);
        canvas.drawText(shopName, (f2 - paint8.measureText(shopName, 0, shopName.length())) / 2.0f, 180.0f, paint8);
        Paint paint9 = new Paint();
        paint9.setTextSize(12.0f);
        paint9.setFlags(1);
        paint9.setColor(b.a(R.color.white54));
        p a3 = a(watermarkShopJoinDate, b.a(R.color.white54));
        a(a3.a(), canvas, (f2 - paint9.measureText(a3.b(), 0, a3.b().length())) / 2.0f, 194.0f, paint9);
        Paint paint10 = new Paint();
        paint10.setTextSize(24.0f);
        paint10.setFlags(1);
        paint10.setColor(-1);
        if (shopFollowerCount == 1) {
            str = b.e(R.string.sp_1_follower3);
            i = 0;
        } else {
            i = 0;
            str = b.a(R.string.sp_s_followers3, String.valueOf(shopFollowerCount));
        }
        float f4 = (float) 320;
        canvas.drawText(str, (f4 - paint10.measureText(str, i, str.length())) / 2.0f, ((float) bitmap.getHeight()) - 20.0f, paint10);
        paint6.setColor(-1);
        paint6.setStrokeWidth(2.0f);
        canvas.drawLine(f4, ((float) bitmap.getHeight()) - 45.0f, f4, ((float) bitmap.getHeight()) - 15.0f, paint6);
        Paint paint11 = new Paint();
        paint11.setTextSize(24.0f);
        paint11.setFlags(1);
        paint11.setColor(-1);
        if (shopProductCount == 1) {
            str2 = b.e(R.string.sp_1_product);
            i2 = 0;
        } else {
            i2 = 0;
            str2 = b.a(R.string.sp_product_2, String.valueOf(shopProductCount));
        }
        canvas.drawText(str2, ((f4 - paint11.measureText(str, i2, str.length())) / 2.0f) + f4, ((float) bitmap.getHeight()) - 20.0f, paint11);
        int size = list.size() > 4 ? 4 : list.size();
        int i4 = (640 - ((size * 140) + ((size - 1) * 16))) / 2;
        int i5 = (height - 16) - 140;
        for (Bitmap next : list) {
            canvas.drawBitmap(next, (Rect) null, new Rect(i4, i5, i4 + 140, i5 + 140), (Paint) null);
            next.recycle();
            i4 += 156;
            i2++;
            if (i2 >= 4) {
                break;
            }
        }
        return createBitmap;
    }

    private static Bitmap a(Bitmap bitmap, String str, String str2, String str3, String str4) {
        int i;
        String str5 = str;
        String str6 = str2;
        String str7 = str3;
        Bitmap createBitmap = Bitmap.createBitmap(640, 640, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        canvas.drawBitmap(bitmap, (Rect) null, new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight()), (Paint) null);
        bitmap.recycle();
        Rect rect = new Rect();
        Paint paint = new Paint();
        paint.setTextSize(24.0f);
        paint.setFlags(1);
        paint.setColor(b.a(R.color.primary));
        String e2 = b.e(R.string.app_name);
        float measureText = paint.measureText(e2, 0, e2.length());
        paint.getTextBounds(e2, 0, e2.length(), rect);
        paint.setShadowLayer(3.0f, 3.0f, 3.0f, b.a(R.color.black65));
        float f2 = ((float) 640) - measureText;
        canvas.drawText(e2, f2 - 16.0f, (float) (rect.height() + 20), paint);
        Bitmap h = b.h(R.drawable.ic_insta_shopee);
        canvas.drawBitmap(h, (Rect) null, new Rect((int) (((float) 590) - measureText), 20, (int) (f2 - 23.0f), 50), (Paint) null);
        h.recycle();
        if (!TextUtils.isEmpty(str3)) {
            Paint paint2 = new Paint();
            paint2.setTextSize(24.0f);
            paint2.setFlags(1);
            paint2.setColor(-1);
            paint2.getTextBounds(str7, 0, str3.length(), rect);
            i = rect.height() + 0;
            paint2.setShadowLayer(3.0f, 3.0f, 3.0f, b.a(R.color.black65));
            a(a(str7, b.a(R.color.white96)).a(), canvas, 22.0f, (float) 620, paint2);
        } else {
            i = 24;
        }
        Paint paint3 = new Paint();
        paint3.setTextSize(36.0f);
        paint3.setFlags(1);
        paint3.setTypeface(Typeface.create(Typeface.DEFAULT, 1));
        paint3.setColor(b.a(R.color.primary));
        paint3.getTextBounds(str6, 0, str2.length(), rect);
        paint3.setShadowLayer(3.0f, 3.0f, 3.0f, b.a(R.color.black65));
        canvas.drawText(str6, 22.0f, (float) ((640 - i) - 32), paint3);
        int height = i + rect.height();
        TextPaint textPaint = new TextPaint();
        textPaint.setTextSize(36.0f);
        textPaint.setFlags(1);
        textPaint.setTypeface(Typeface.create(Typeface.DEFAULT, 1));
        textPaint.setColor(-1);
        textPaint.getTextBounds(str5, 0, str.length(), rect);
        textPaint.setShadowLayer(3.0f, 3.0f, 3.0f, b.a(R.color.black65));
        canvas.drawText(TextUtils.ellipsize(str5, textPaint, 596.0f, TextUtils.TruncateAt.END).toString(), 22.0f, (float) ((640 - height) - 44), textPaint);
        int height2 = height + rect.height();
        if (!TextUtils.isEmpty(str4)) {
            Bitmap copy = l.a(b.h(R.drawable.ic_instagram_label), 140, 50).copy(Bitmap.Config.ARGB_8888, true);
            int i2 = 640 - height2;
            canvas.drawBitmap(copy, (Rect) null, new Rect(22, i2 - 108, 162, i2 - 58), (Paint) null);
            copy.recycle();
            Paint paint4 = new Paint();
            paint4.setTextSize(26.0f);
            paint4.setTypeface(Typeface.create(Typeface.DEFAULT, 1));
            paint4.setFlags(1);
            a(a(str4, b.a(R.color.black87)).a(), canvas, 34.0f, (float) (i2 - 75), paint4);
        }
        return createBitmap;
    }

    private static void a(List<o> list, Canvas canvas, float f2, float f3, Paint paint) {
        int i = 0;
        for (o next : list) {
            paint.setColor(next.a());
            float f4 = (float) i;
            canvas.drawText(next.b(), f2 + f4, f3, paint);
            i = (int) (f4 + paint.measureText(next.b()));
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:106:0x02d0 A[SYNTHETIC, Splitter:B:106:0x02d0] */
    /* JADX WARNING: Removed duplicated region for block: B:115:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00bd A[SYNTHETIC, Splitter:B:35:0x00bd] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00d0  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x0214  */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x02b6 A[SYNTHETIC, Splitter:B:93:0x02b6] */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x02c2 A[SYNTHETIC, Splitter:B:98:0x02c2] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(java.lang.String r15, com.shopee.app.web.protocol.ShareMessage r16, com.shopee.app.data.store.setting.ImageConfig r17, int r18, java.lang.String r19) {
        /*
            r1 = r15
            java.lang.String r2 = "WATERMARK_IMAGE_COMPLETE"
            java.lang.String r3 = "NO_WATERMARK_IMAGE_COMPLETE"
            boolean r0 = android.text.TextUtils.isEmpty(r19)
            if (r0 != 0) goto L_0x000e
            r0 = r19
            goto L_0x0033
        L_0x000e:
            boolean r0 = r16.isShareShop()
            if (r0 == 0) goto L_0x0019
            java.lang.String r0 = r16.getShopImage()
            goto L_0x0033
        L_0x0019:
            boolean r0 = r16.isGeneric()
            if (r0 == 0) goto L_0x0024
            java.lang.String r0 = r16.getGenericImageUrl()
            goto L_0x0033
        L_0x0024:
            boolean r0 = r16.isReferral()
            if (r0 == 0) goto L_0x002f
            java.lang.String r0 = r16.getGenericImageUrl()
            goto L_0x0033
        L_0x002f:
            java.lang.String r0 = r16.getItemImage()
        L_0x0033:
            boolean r4 = android.text.TextUtils.isEmpty(r0)
            boolean r5 = android.text.TextUtils.isEmpty(r0)
            r6 = 0
            java.lang.String r7 = "http://cf.shopee.co.id/file/"
            if (r5 != 0) goto L_0x005a
            java.lang.String r5 = "http"
            boolean r5 = r0.contains(r5)
            if (r5 == 0) goto L_0x0049
            goto L_0x0058
        L_0x0049:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            r5.append(r7)
            r5.append(r0)
            java.lang.String r0 = r5.toString()
        L_0x0058:
            r5 = r0
            goto L_0x005b
        L_0x005a:
            r5 = r6
        L_0x005b:
            r8 = 1
            r0 = r17
            android.graphics.Bitmap r4 = a((java.lang.String) r5, (com.shopee.app.data.store.setting.ImageConfig) r0, (boolean) r8, (boolean) r4)
            r9 = 100
            r10 = 0
            java.io.FileOutputStream r11 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x009f, all -> 0x009a }
            java.io.File r0 = new java.io.File     // Catch:{ Exception -> 0x009f, all -> 0x009a }
            com.shopee.app.h.f r12 = com.shopee.app.h.f.a()     // Catch:{ Exception -> 0x009f, all -> 0x009a }
            java.lang.String r12 = r12.d(r15)     // Catch:{ Exception -> 0x009f, all -> 0x009a }
            r0.<init>(r12)     // Catch:{ Exception -> 0x009f, all -> 0x009a }
            r11.<init>(r0)     // Catch:{ Exception -> 0x009f, all -> 0x009a }
            com.garena.android.appkit.b.a r0 = new com.garena.android.appkit.b.a     // Catch:{ Exception -> 0x0098 }
            android.util.Pair r12 = new android.util.Pair     // Catch:{ Exception -> 0x0098 }
            android.graphics.Bitmap$CompressFormat r13 = android.graphics.Bitmap.CompressFormat.JPEG     // Catch:{ Exception -> 0x0098 }
            boolean r13 = r4.compress(r13, r9, r11)     // Catch:{ Exception -> 0x0098 }
            java.lang.Boolean r13 = java.lang.Boolean.valueOf(r13)     // Catch:{ Exception -> 0x0098 }
            java.lang.Integer r14 = java.lang.Integer.valueOf(r18)     // Catch:{ Exception -> 0x0098 }
            r12.<init>(r13, r14)     // Catch:{ Exception -> 0x0098 }
            r0.<init>(r12)     // Catch:{ Exception -> 0x0098 }
            com.garena.android.appkit.b.b$a r12 = com.garena.android.appkit.b.b.a.UI_BUS     // Catch:{ Exception -> 0x0098 }
            com.garena.android.appkit.b.b.a((java.lang.String) r3, (com.garena.android.appkit.b.a) r0, (com.garena.android.appkit.b.b.a) r12)     // Catch:{ Exception -> 0x0098 }
            r11.close()     // Catch:{ IOException -> 0x00c1 }
            goto L_0x00c6
        L_0x0098:
            r0 = move-exception
            goto L_0x00a1
        L_0x009a:
            r0 = move-exception
            r1 = r0
            r11 = r6
            goto L_0x02ce
        L_0x009f:
            r0 = move-exception
            r11 = r6
        L_0x00a1:
            com.garena.android.appkit.d.a.a(r0)     // Catch:{ all -> 0x02cc }
            com.garena.android.appkit.b.a r0 = new com.garena.android.appkit.b.a     // Catch:{ all -> 0x02cc }
            android.util.Pair r12 = new android.util.Pair     // Catch:{ all -> 0x02cc }
            java.lang.Boolean r13 = java.lang.Boolean.valueOf(r10)     // Catch:{ all -> 0x02cc }
            java.lang.Integer r14 = java.lang.Integer.valueOf(r18)     // Catch:{ all -> 0x02cc }
            r12.<init>(r13, r14)     // Catch:{ all -> 0x02cc }
            r0.<init>(r12)     // Catch:{ all -> 0x02cc }
            com.garena.android.appkit.b.b$a r12 = com.garena.android.appkit.b.b.a.UI_BUS     // Catch:{ all -> 0x02cc }
            com.garena.android.appkit.b.b.a((java.lang.String) r3, (com.garena.android.appkit.b.a) r0, (com.garena.android.appkit.b.b.a) r12)     // Catch:{ all -> 0x02cc }
            if (r11 == 0) goto L_0x00c6
            r11.close()     // Catch:{ IOException -> 0x00c1 }
            goto L_0x00c6
        L_0x00c1:
            r0 = move-exception
            r3 = r0
            com.garena.android.appkit.d.a.a(r3)
        L_0x00c6:
            int r0 = r16.getShareType()
            java.lang.String r3 = ""
            r11 = 640(0x280, float:8.97E-43)
            if (r0 == 0) goto L_0x0214
            if (r0 == r8) goto L_0x01ad
            r8 = 2
            r12 = 90
            if (r0 == r8) goto L_0x0158
            r8 = 3
            if (r0 == r8) goto L_0x0116
            r7 = 4
            if (r0 == r7) goto L_0x025c
            java.lang.String r0 = r16.getItemPrice()
            if (r0 == 0) goto L_0x0100
            java.lang.String r0 = r16.getItemPrice()     // Catch:{ NumberFormatException -> 0x00f8 }
            long r3 = java.lang.Long.parseLong(r0)     // Catch:{ NumberFormatException -> 0x00f8 }
            java.lang.Long r0 = java.lang.Long.valueOf(r3)     // Catch:{ NumberFormatException -> 0x00f8 }
            long r3 = r0.longValue()     // Catch:{ NumberFormatException -> 0x00f8 }
            java.lang.String r3 = com.shopee.app.util.au.b((long) r3)     // Catch:{ NumberFormatException -> 0x00f8 }
            goto L_0x0100
        L_0x00f8:
            r0 = move-exception
            java.lang.String r3 = r16.getItemPrice()
            com.garena.android.appkit.d.a.a(r0)
        L_0x0100:
            android.graphics.Bitmap r0 = a((java.lang.String) r5, (int) r11, (int) r11)
            java.lang.String r4 = r16.getItemName()
            java.lang.String r5 = r16.getWatermarkProductDesc()
            java.lang.String r7 = r16.getWatermarkDiscountText()
            android.graphics.Bitmap r4 = a((android.graphics.Bitmap) r0, (java.lang.String) r4, (java.lang.String) r3, (java.lang.String) r5, (java.lang.String) r7)
            goto L_0x025c
        L_0x0116:
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.List r3 = r16.getImageList()
            java.util.Iterator r3 = r3.iterator()
        L_0x0123:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x0146
            java.lang.Object r4 = r3.next()
            java.lang.String r4 = (java.lang.String) r4
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            r5.append(r7)
            r5.append(r4)
            java.lang.String r4 = r5.toString()
            android.graphics.Bitmap r4 = a((java.lang.String) r4, (int) r12, (int) r12)
            r0.add(r4)
            goto L_0x0123
        L_0x0146:
            java.util.List r3 = r16.getPriceList()
            java.lang.String r4 = r16.getWatermarkHashTagTitle()
            java.lang.String r5 = r16.getWatermarkHashTagDesc()
            android.graphics.Bitmap r4 = a((java.util.List<android.graphics.Bitmap>) r0, (java.util.List<java.lang.String>) r3, (java.lang.String) r4, (java.lang.String) r5)
            goto L_0x025c
        L_0x0158:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r7)
            java.lang.String r3 = r16.getCollectionBanner()
            r0.append(r3)
            java.lang.String r0 = r0.toString()
            android.graphics.Bitmap r0 = b(r0)
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            java.util.List r4 = r16.getImageList()
            java.util.Iterator r4 = r4.iterator()
        L_0x017c:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L_0x019f
            java.lang.Object r5 = r4.next()
            java.lang.String r5 = (java.lang.String) r5
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            r8.append(r7)
            r8.append(r5)
            java.lang.String r5 = r8.toString()
            android.graphics.Bitmap r5 = a((java.lang.String) r5, (int) r12, (int) r12)
            r3.add(r5)
            goto L_0x017c
        L_0x019f:
            java.lang.String r4 = r16.getWatermarkCollectionTitle()
            java.lang.String r5 = r16.getWatermarkCollectionDesc()
            android.graphics.Bitmap r4 = a((android.graphics.Bitmap) r0, (java.util.List<android.graphics.Bitmap>) r3, (java.lang.String) r4, (java.lang.String) r5)
            goto L_0x025c
        L_0x01ad:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r7)
            java.lang.String r3 = r16.getShopImage()
            r0.append(r3)
            java.lang.String r0 = r0.toString()
            android.graphics.Bitmap r0 = c(r0)
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            java.util.List r4 = r16.getImageList()
            java.util.Iterator r4 = r4.iterator()
        L_0x01d1:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L_0x01f6
            java.lang.Object r5 = r4.next()
            java.lang.String r5 = (java.lang.String) r5
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            r8.append(r7)
            r8.append(r5)
            java.lang.String r5 = r8.toString()
            r8 = 140(0x8c, float:1.96E-43)
            android.graphics.Bitmap r5 = a((java.lang.String) r5, (int) r8, (int) r8)
            r3.add(r5)
            goto L_0x01d1
        L_0x01f6:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r7)
            java.lang.String r5 = r16.getAvatar()
            r4.append(r5)
            java.lang.String r4 = r4.toString()
            android.graphics.Bitmap r4 = a((java.lang.String) r4)
            r5 = r16
            android.graphics.Bitmap r4 = a((android.graphics.Bitmap) r0, (android.graphics.Bitmap) r4, (java.util.List<android.graphics.Bitmap>) r3, (com.shopee.app.web.protocol.ShareMessage) r5)
            goto L_0x025c
        L_0x0214:
            r5 = r16
            java.lang.String r0 = r16.getItemPrice()
            if (r0 == 0) goto L_0x0235
            java.lang.String r0 = r16.getItemPrice()     // Catch:{ NumberFormatException -> 0x0231 }
            long r3 = java.lang.Long.parseLong(r0)     // Catch:{ NumberFormatException -> 0x0231 }
            java.lang.Long r0 = java.lang.Long.valueOf(r3)     // Catch:{ NumberFormatException -> 0x0231 }
            long r3 = r0.longValue()     // Catch:{ NumberFormatException -> 0x0231 }
            java.lang.String r3 = com.shopee.app.util.au.b((long) r3)     // Catch:{ NumberFormatException -> 0x0231 }
            goto L_0x0235
        L_0x0231:
            java.lang.String r3 = r16.getItemPrice()
        L_0x0235:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r7)
            java.lang.String r4 = r16.getItemOriginalImage()
            r0.append(r4)
            java.lang.String r0 = r0.toString()
            android.graphics.Bitmap r0 = a((java.lang.String) r0, (int) r11, (int) r11)
            java.lang.String r4 = r16.getItemName()
            java.lang.String r7 = r16.getWatermarkProductDesc()
            java.lang.String r5 = r16.getWatermarkDiscountText()
            android.graphics.Bitmap r4 = a((android.graphics.Bitmap) r0, (java.lang.String) r4, (java.lang.String) r3, (java.lang.String) r7, (java.lang.String) r5)
        L_0x025c:
            java.io.FileOutputStream r3 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x0299 }
            java.io.File r0 = new java.io.File     // Catch:{ Exception -> 0x0299 }
            com.shopee.app.h.f r5 = com.shopee.app.h.f.a()     // Catch:{ Exception -> 0x0299 }
            java.lang.String r1 = r5.c(r15)     // Catch:{ Exception -> 0x0299 }
            r0.<init>(r1)     // Catch:{ Exception -> 0x0299 }
            r3.<init>(r0)     // Catch:{ Exception -> 0x0299 }
            com.garena.android.appkit.b.a r0 = new com.garena.android.appkit.b.a     // Catch:{ Exception -> 0x0293, all -> 0x028f }
            android.util.Pair r1 = new android.util.Pair     // Catch:{ Exception -> 0x0293, all -> 0x028f }
            android.graphics.Bitmap$CompressFormat r5 = android.graphics.Bitmap.CompressFormat.JPEG     // Catch:{ Exception -> 0x0293, all -> 0x028f }
            boolean r4 = r4.compress(r5, r9, r3)     // Catch:{ Exception -> 0x0293, all -> 0x028f }
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r4)     // Catch:{ Exception -> 0x0293, all -> 0x028f }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r18)     // Catch:{ Exception -> 0x0293, all -> 0x028f }
            r1.<init>(r4, r5)     // Catch:{ Exception -> 0x0293, all -> 0x028f }
            r0.<init>(r1)     // Catch:{ Exception -> 0x0293, all -> 0x028f }
            com.garena.android.appkit.b.b$a r1 = com.garena.android.appkit.b.b.a.UI_BUS     // Catch:{ Exception -> 0x0293, all -> 0x028f }
            com.garena.android.appkit.b.b.a((java.lang.String) r2, (com.garena.android.appkit.b.a) r0, (com.garena.android.appkit.b.b.a) r1)     // Catch:{ Exception -> 0x0293, all -> 0x028f }
            r3.close()     // Catch:{ IOException -> 0x02ba }
            goto L_0x02bf
        L_0x028f:
            r0 = move-exception
            r1 = r0
            r6 = r3
            goto L_0x02c0
        L_0x0293:
            r0 = move-exception
            r6 = r3
            goto L_0x029a
        L_0x0296:
            r0 = move-exception
            r1 = r0
            goto L_0x02c0
        L_0x0299:
            r0 = move-exception
        L_0x029a:
            com.garena.android.appkit.d.a.a(r0)     // Catch:{ all -> 0x0296 }
            com.garena.android.appkit.b.a r0 = new com.garena.android.appkit.b.a     // Catch:{ all -> 0x0296 }
            android.util.Pair r1 = new android.util.Pair     // Catch:{ all -> 0x0296 }
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r10)     // Catch:{ all -> 0x0296 }
            java.lang.Integer r4 = java.lang.Integer.valueOf(r18)     // Catch:{ all -> 0x0296 }
            r1.<init>(r3, r4)     // Catch:{ all -> 0x0296 }
            r0.<init>(r1)     // Catch:{ all -> 0x0296 }
            com.garena.android.appkit.b.b$a r1 = com.garena.android.appkit.b.b.a.UI_BUS     // Catch:{ all -> 0x0296 }
            com.garena.android.appkit.b.b.a((java.lang.String) r2, (com.garena.android.appkit.b.a) r0, (com.garena.android.appkit.b.b.a) r1)     // Catch:{ all -> 0x0296 }
            if (r6 == 0) goto L_0x02bf
            r6.close()     // Catch:{ IOException -> 0x02ba }
            goto L_0x02bf
        L_0x02ba:
            r0 = move-exception
            r1 = r0
            com.garena.android.appkit.d.a.a(r1)
        L_0x02bf:
            return
        L_0x02c0:
            if (r6 == 0) goto L_0x02cb
            r6.close()     // Catch:{ IOException -> 0x02c6 }
            goto L_0x02cb
        L_0x02c6:
            r0 = move-exception
            r2 = r0
            com.garena.android.appkit.d.a.a(r2)
        L_0x02cb:
            throw r1
        L_0x02cc:
            r0 = move-exception
            r1 = r0
        L_0x02ce:
            if (r11 == 0) goto L_0x02d9
            r11.close()     // Catch:{ IOException -> 0x02d4 }
            goto L_0x02d9
        L_0x02d4:
            r0 = move-exception
            r2 = r0
            com.garena.android.appkit.d.a.a(r2)
        L_0x02d9:
            goto L_0x02db
        L_0x02da:
            throw r1
        L_0x02db:
            goto L_0x02da
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shopee.app.g.g.a(java.lang.String, com.shopee.app.web.protocol.ShareMessage, com.shopee.app.data.store.setting.ImageConfig, int, java.lang.String):void");
    }
}
