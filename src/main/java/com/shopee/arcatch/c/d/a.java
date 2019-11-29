package com.shopee.arcatch.c.d;

import android.content.Context;
import android.graphics.Bitmap;
import com.shopee.arcatch.c.a.b;
import com.shopee.arcatch.data.config_bean.BitmapConfigBean;
import com.shopee.arcatch.data.config_bean.ConfigBean;
import com.shopee.arcatch.data.network_bean.game.PropsBean;
import java.util.List;

public class a {

    /* renamed from: a  reason: collision with root package name */
    public String f26756a;

    /* renamed from: b  reason: collision with root package name */
    public int f26757b;

    /* renamed from: c  reason: collision with root package name */
    public String f26758c;

    /* renamed from: d  reason: collision with root package name */
    public int f26759d;

    /* renamed from: e  reason: collision with root package name */
    public String f26760e;

    /* renamed from: f  reason: collision with root package name */
    public int f26761f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f26762g;
    public boolean h;
    public int i;
    public int j;
    public int k;
    public int l;
    public float m;
    public float n;
    private float o;

    /* renamed from: com.shopee.arcatch.c.d.a$a  reason: collision with other inner class name */
    static class C0417a {

        /* renamed from: a  reason: collision with root package name */
        static a f26763a = new a();
    }

    private a() {
        this.o = 0.8f;
    }

    public static a a() {
        return C0417a.f26763a;
    }

    public void b() {
        ConfigBean b2 = b.a().b();
        if (b2 != null) {
            this.f26756a = b2.textConfigBean.timesUp;
            this.f26757b = b2.textConfigBean.timesUpColor;
            this.f26758c = b2.textConfigBean.countdownText;
            this.f26759d = b2.textConfigBean.countdownTextColor;
            this.f26760e = b2.textConfigBean.coinsTitle;
            this.f26761f = b2.textConfigBean.coinsTitleColor;
            this.f26762g = b2.paramsConfigBean.mute;
            this.h = b2.paramsConfigBean.saveVideo;
            this.i = b2.paramsConfigBean.duration;
        }
    }

    public int c() {
        ConfigBean b2 = b.a().b();
        if (b2 == null || b2.paramsConfigBean == null) {
            return 0;
        }
        List<PropsBean> list = b2.paramsConfigBean.props;
        if (list == null) {
            return 0;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            i2 += list.get(i3).getFallingCount();
        }
        return i2;
    }

    public Bitmap d() {
        BitmapConfigBean d2 = b.a().d();
        if (d2 == null) {
            return null;
        }
        Bitmap bitmap = d2.hatBackground;
        if (bitmap != null) {
            this.j = bitmap.getHeight();
        }
        return bitmap;
    }

    public Bitmap e() {
        BitmapConfigBean d2 = b.a().d();
        if (d2 != null) {
            return d2.hatForeground;
        }
        return null;
    }

    public Bitmap f() {
        BitmapConfigBean d2 = b.a().d();
        if (d2 != null) {
            return d2.imageCover;
        }
        return null;
    }

    public Bitmap g() {
        BitmapConfigBean d2 = b.a().d();
        if (d2 != null) {
            return d2.coinsScoreBackground;
        }
        return null;
    }

    public Bitmap h() {
        BitmapConfigBean d2 = b.a().d();
        if (d2 != null) {
            return d2.playTimeCountDownBackground;
        }
        return null;
    }

    public Bitmap a(String str) {
        BitmapConfigBean d2 = b.a().d();
        if (d2 == null || d2.coinImages == null || !d2.coinImages.containsKey(str)) {
            return null;
        }
        return d2.coinImages.get(str);
    }

    public Bitmap a(boolean z) {
        BitmapConfigBean d2 = b.a().d();
        if (d2 != null) {
            return z ? d2.bgmOnIcon : d2.bgmOffIcon;
        }
        return null;
    }

    public Bitmap b(String str) {
        BitmapConfigBean d2 = b.a().d();
        if (d2 == null || d2.bombImages == null || !d2.bombImages.containsKey(str)) {
            return null;
        }
        return d2.bombImages.get(str);
    }

    public Bitmap a(String str, boolean z) {
        BitmapConfigBean d2 = b.a().d();
        if (d2 == null) {
            return null;
        }
        if (!z) {
            str = str + "*";
        }
        if (d2.cryEyesImages == null || !d2.cryEyesImages.containsKey(str)) {
            return null;
        }
        return d2.cryEyesImages.get(str);
    }

    public Bitmap c(String str) {
        BitmapConfigBean d2 = b.a().d();
        if (d2 == null || d2.explosionImages == null || !d2.explosionImages.containsKey(str)) {
            return null;
        }
        return d2.explosionImages.get(str);
    }

    public void a(int i2) {
        int b2 = com.shopee.arcatch.b.c.b.b(com.shopee.arcatch.c.f.b.b().a());
        BitmapConfigBean d2 = b.a().d();
        if (d2 != null) {
            Bitmap bitmap = d2.imageCover;
            if (bitmap != null) {
                float f2 = (float) b2;
                int width = (int) ((f2 / ((float) bitmap.getWidth())) * ((float) ((int) (((float) bitmap.getHeight()) * 0.8f))));
                int i3 = this.k;
                this.l = width - i3;
                this.m = ((float) (i2 - (i3 + this.l))) / f2;
            }
        }
    }

    public boolean i() {
        Context a2 = com.shopee.arcatch.c.f.b.b().a();
        int b2 = com.shopee.arcatch.b.c.b.b(a2);
        int c2 = (com.shopee.arcatch.b.c.b.c(a2) - com.shopee.arcatch.b.c.b.f(a2)) - com.shopee.arcatch.b.c.b.a(a2, 48.0f);
        BitmapConfigBean d2 = b.a().d();
        if (d2 == null || b2 == 0 || c2 == 0) {
            return false;
        }
        Bitmap bitmap = d2.imageCover;
        if (bitmap == null) {
            return false;
        }
        if (((((float) bitmap.getHeight()) * this.o) / ((float) bitmap.getWidth())) + 1.3333334f >= ((float) c2) / ((float) b2)) {
            return true;
        }
        return false;
    }

    public String j() {
        ConfigBean b2 = b.a().b();
        return (b2 == null || b2.textConfigBean == null) ? "Shopee ArCatch" : b2.textConfigBean.title;
    }

    public Bitmap k() {
        BitmapConfigBean d2 = b.a().d();
        if (d2 != null) {
            return d2.waterMark;
        }
        return null;
    }

    public Bitmap l() {
        BitmapConfigBean d2 = b.a().d();
        if (d2 != null) {
            return d2.videoBorder;
        }
        return null;
    }

    public List<PropsBean> m() {
        ConfigBean b2 = b.a().b();
        if (b2 == null || b2.paramsConfigBean == null) {
            return null;
        }
        return b2.paramsConfigBean.props;
    }

    public String n() {
        ConfigBean b2 = b.a().b();
        return (b2 == null || b2.textConfigBean == null) ? "" : b2.textConfigBean.title;
    }
}
