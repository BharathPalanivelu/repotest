package com.shopee.arcatch.c.g;

import android.graphics.Bitmap;
import android.util.DisplayMetrics;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.shopee.arcatch.c.d.a;
import com.shopee.arcatch.c.f.b;
import com.shopee.arcatch.data.network_bean.game.PropsBean;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class h {

    /* renamed from: a  reason: collision with root package name */
    private int f26892a;

    /* renamed from: b  reason: collision with root package name */
    private int f26893b;

    /* renamed from: c  reason: collision with root package name */
    private int f26894c = 0;

    /* renamed from: d  reason: collision with root package name */
    private List<PropsBean> f26895d;

    /* renamed from: e  reason: collision with root package name */
    private Map<String, Integer> f26896e = new HashMap();

    /* renamed from: f  reason: collision with root package name */
    private g f26897f;

    /* renamed from: g  reason: collision with root package name */
    private int f26898g;
    private int h;
    private Random i = new Random();

    public h(List<PropsBean> list) {
        this.f26895d = list;
        this.f26897f = new g();
        DisplayMetrics displayMetrics = b.b().a().getResources().getDisplayMetrics();
        if (displayMetrics != null) {
            this.f26892a = displayMetrics.widthPixels;
            this.f26893b = displayMetrics.heightPixels;
        }
        if (list != null) {
            this.h = list.size();
            for (int i2 = 0; i2 < this.h; i2++) {
                this.f26898g += list.get(i2).getFallingCount();
                this.f26896e.put(list.get(i2).getId(), 0);
            }
        }
    }

    public boolean a() {
        return this.f26895d != null && this.f26894c < this.f26898g;
    }

    public f b() {
        PropsBean propsBean;
        if (!a()) {
            return null;
        }
        int nextInt = this.i.nextInt(this.f26898g - this.f26894c);
        int i2 = 0;
        int i3 = 0;
        while (true) {
            if (i2 >= this.h) {
                propsBean = null;
                break;
            } else if (nextInt < this.f26895d.get(i2).getFallingCount() + i3) {
                propsBean = this.f26895d.get(i2);
                break;
            } else {
                i3 += this.f26895d.get(i2).getFallingCount();
                i2++;
            }
        }
        if (propsBean == null) {
            return null;
        }
        propsBean.setFallingCount(propsBean.getFallingCount() - 1);
        String id = propsBean.getId();
        if (this.f26896e.containsKey(id)) {
            this.f26896e.put(id, Integer.valueOf(this.f26896e.get(id).intValue() + 1));
        }
        this.f26894c++;
        f b2 = this.f26897f.b();
        a(b2, propsBean);
        return b2;
    }

    public void a(f fVar) {
        this.f26897f.a(fVar);
    }

    public void a(f fVar, PropsBean propsBean) {
        Bitmap bitmap;
        boolean z = propsBean.getPropType() == 0;
        String id = propsBean.getId();
        if (z) {
            bitmap = a.a().b(id);
        } else {
            bitmap = a.a().a(id);
        }
        fVar.b((float) this.i.nextInt(this.f26892a - (bitmap != null ? bitmap.getWidth() : 0)));
        fVar.c(BitmapDescriptorFactory.HUE_RED);
        fVar.a(bitmap);
        fVar.b(false);
        fVar.a(z);
        fVar.a(id);
        float propValue = propsBean.getPropValue();
        if (z) {
            propValue = -propValue;
        }
        fVar.a(propValue);
    }

    public Map<String, Integer> c() {
        return this.f26896e;
    }
}
