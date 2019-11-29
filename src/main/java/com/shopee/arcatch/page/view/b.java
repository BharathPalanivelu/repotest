package com.shopee.arcatch.page.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import com.badlogic.gdx.physics.box2d.utils.Vector2;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.shopee.arcatch.b.c.d;
import com.shopee.arcatch.c.g.c;
import com.shopee.arcatch.c.g.f;
import com.shopee.arcatch.c.g.h;
import com.shopee.arcatch.c.g.i;
import com.shopee.arcatch.data.config_bean.BitmapConfigBean;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class b extends View {
    private static a w = new a();
    private Vector2 A = new Vector2();
    private Vector2 B = new Vector2();
    private boolean C = false;

    /* renamed from: a  reason: collision with root package name */
    Runnable f27050a = new Runnable() {
        public void run() {
            boolean unused = b.this.p = false;
            if (b.this.f27056g != null) {
                b.this.f27056g.p();
            }
            if (b.this.h != null) {
                b.this.h.p();
            }
        }
    };

    /* renamed from: b  reason: collision with root package name */
    private com.shopee.arcatch.c.g.b f27051b;

    /* renamed from: c  reason: collision with root package name */
    private List<f> f27052c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    private List<f> f27053d = new ArrayList();

    /* renamed from: e  reason: collision with root package name */
    private List<f> f27054e = new ArrayList();

    /* renamed from: f  reason: collision with root package name */
    private Matrix f27055f = new Matrix();
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public f f27056g;
    /* access modifiers changed from: private */
    public f h;
    private h i;
    private float j;
    private Map<String, Integer> k = new HashMap();
    private Paint l;
    private a m;
    private ArCatchGameInfoView n;
    private d o;
    /* access modifiers changed from: private */
    public volatile boolean p = false;
    private boolean q = false;
    private int r = 0;
    private Bitmap s;
    private Bitmap t;
    private i u;
    private i v;
    private Handler x = new Handler() {
        public void handleMessage(Message message) {
            if (message.what == 99) {
                b.this.a((a) message.obj);
            }
        }
    };
    private long y;
    private long z;

    public b(Context context) {
        super(context);
        i();
        h();
        j();
    }

    public void setCatchItemVoiceAnimaView(a aVar) {
        this.m = aVar;
    }

    public void setArCatchTimerCoinsView(ArCatchGameInfoView arCatchGameInfoView) {
        this.n = arCatchGameInfoView;
    }

    private void h() {
        this.i = new h(com.shopee.arcatch.c.d.a.a().m());
        this.u = new i("gamefps");
        this.v = new i("box2d");
    }

    private void i() {
        this.f27051b = new com.shopee.arcatch.c.g.b(getResources().getDisplayMetrics().density);
        this.f27051b.a(this.f27053d, this);
    }

    private void j() {
        this.l = new Paint();
        this.l.setTextSize(30.0f);
        this.l.setColor(-65536);
        this.o = new d();
        this.s = com.shopee.arcatch.c.d.a.a().d();
        this.t = com.shopee.arcatch.c.d.a.a().e();
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        BitmapConfigBean d2 = com.shopee.arcatch.c.a.b.a().d();
        if (d2 != null) {
            Bitmap bitmap = d2.imageCover;
            if (bitmap != null) {
                this.r = (int) ((((float) com.shopee.arcatch.b.c.b.b(com.shopee.arcatch.c.f.b.b().a())) / ((float) bitmap.getWidth())) * ((float) bitmap.getHeight()));
            }
        }
        this.f27051b.a(i2, i3 + com.shopee.arcatch.c.d.a.a().l);
        a();
    }

    public void a() {
        Bitmap bitmap = this.s;
        float width = ((float) getWidth()) / 2.0f;
        float f2 = BitmapDescriptorFactory.HUE_RED;
        float width2 = width - (bitmap != null ? ((float) bitmap.getWidth()) / 2.0f : BitmapDescriptorFactory.HUE_RED);
        float height = ((float) getHeight()) / 2.0f;
        if (bitmap != null) {
            f2 = ((float) bitmap.getHeight()) / 2.0f;
        }
        float f3 = height - f2;
        this.f27056g = new f(bitmap, width2, f3);
        this.f27056g.a(8);
        this.h = new f(bitmap, width2, f3);
        this.h.a(12);
        com.shopee.arcatch.c.g.b bVar = this.f27051b;
        if (bVar != null && bVar.f26872a != null) {
            this.f27052c.add(this.f27056g);
            this.f27051b.a(this.f27056g, this.h, getContext());
            this.f27051b.a(this.m);
        }
    }

    public void b() {
        f b2 = this.i.b();
        if (b2 != null) {
            com.shopee.arcatch.c.g.b bVar = this.f27051b;
            if (bVar != null && bVar.f26872a != null) {
                this.f27052c.add(b2);
                this.f27051b.a(b2);
                invalidate();
            }
        }
    }

    public void a(f fVar) {
        this.i.a(fVar);
    }

    public boolean b(f fVar) {
        boolean z2 = fVar != null && fVar.c() && this.f27053d.contains(fVar);
        if (z2) {
            this.f27054e.add(fVar);
        }
        return z2;
    }

    public void c(f fVar) {
        if (fVar != null && !this.q) {
            this.j += fVar.d();
            if (this.j < BitmapDescriptorFactory.HUE_RED) {
                this.j = BitmapDescriptorFactory.HUE_RED;
            }
            String a2 = fVar.a();
            if (this.k.containsKey(a2)) {
                this.k.put(a2, Integer.valueOf(this.k.get(a2).intValue() + 1));
                return;
            }
            this.k.put(a2, 1);
        }
    }

    public boolean d(f fVar) {
        return this.f27053d.contains(fVar);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.y = System.currentTimeMillis();
        this.f27051b.b();
        f();
        this.z = System.currentTimeMillis();
        this.f27055f.reset();
        for (int i2 = 0; i2 < this.f27052c.size(); i2++) {
            f fVar = this.f27052c.get(i2);
            fVar.a(this.f27051b, this);
            if (!fVar.e()) {
                if (this.p || (i2 != 0 && !this.f27053d.contains(fVar))) {
                    this.f27055f.setTranslate(((float) (-fVar.j())) / 2.0f, ((float) (-fVar.k())) / 2.0f);
                    this.f27055f.postRotate(fVar.f());
                    this.f27055f.postTranslate((((float) fVar.j()) / 2.0f) + fVar.h(), (((float) fVar.k()) / 2.0f) + fVar.i());
                    if (fVar.l() != null) {
                        canvas.drawBitmap(fVar.l(), this.f27055f, (Paint) null);
                    }
                }
            } else if (!this.q) {
                int indexOf = this.f27053d.indexOf(fVar);
                if (indexOf >= 0) {
                    this.f27053d.remove(indexOf);
                    if (fVar.n()) {
                        this.j -= fVar.d();
                    }
                }
            }
        }
        if (this.p) {
            Bitmap bitmap = this.t;
            if (bitmap != null) {
                canvas.drawBitmap(bitmap, this.f27056g.h(), this.f27056g.i(), (Paint) null);
            }
        }
        if (!this.q) {
            ArCatchGameInfoView arCatchGameInfoView = this.n;
            if (arCatchGameInfoView != null) {
                arCatchGameInfoView.a(this.j);
            }
        }
        int a2 = this.o.a(System.currentTimeMillis());
        this.v.a((float) (this.z - this.y));
        this.u.a((float) a2);
        invalidate();
    }

    public void c() {
        this.q = true;
        ArCatchGameInfoView arCatchGameInfoView = this.n;
        if (arCatchGameInfoView != null) {
            arCatchGameInfoView.a(this.j);
        }
    }

    public boolean d() {
        return this.p;
    }

    public float getScore() {
        return this.j;
    }

    public Map<String, Integer> getCatchedCountMap() {
        return this.k;
    }

    /* access modifiers changed from: private */
    public void a(a aVar) {
        b(aVar.f27059a, aVar.f27060b, aVar.f27061c);
    }

    public void a(float f2, float f3, long j2) {
        Message obtainMessage = this.x.obtainMessage();
        obtainMessage.what = 99;
        a aVar = w;
        aVar.f27059a = f2;
        aVar.f27060b = f3;
        aVar.f27061c = j2;
        obtainMessage.obj = aVar;
        this.x.sendMessage(obtainMessage);
    }

    private void b(float f2, float f3, long j2) {
        if (!this.p) {
            postInvalidate();
        }
        this.p = true;
        if (this.f27056g != null && this.f27051b != null) {
            int i2 = this.r;
            if (f3 < ((float) i2)) {
                f3 = (float) i2;
            }
            float a2 = this.f27051b.a(f2);
            com.shopee.arcatch.c.g.b bVar = this.f27051b;
            Bitmap bitmap = this.t;
            float a3 = bVar.a(f3 - (bitmap != null ? ((float) bitmap.getHeight()) / 4.0f : BitmapDescriptorFactory.HUE_RED));
            this.A.set(a2, a3);
            this.B.set(a2, a3);
            float a4 = c.a(j2);
            this.C = true;
            this.f27056g.a(this.B, a4);
            this.B.set(a2, a3);
            this.h.a(this.B, a4);
        }
    }

    public void e() {
        this.x.post(this.f27050a);
    }

    public void f() {
        if (this.C && this.f27056g.g().getPosition().sub(this.A).len() < 0.01f) {
            this.f27056g.p();
            this.h.p();
            this.C = false;
        }
    }

    private static class a {

        /* renamed from: a  reason: collision with root package name */
        public float f27059a;

        /* renamed from: b  reason: collision with root package name */
        public float f27060b;

        /* renamed from: c  reason: collision with root package name */
        public long f27061c;

        private a() {
        }
    }

    public void g() {
        com.shopee.arcatch.c.g.b bVar = this.f27051b;
        if (bVar != null) {
            bVar.c();
            this.f27051b = null;
        }
        Handler handler = this.x;
        if (handler != null) {
            handler.removeCallbacksAndMessages((Object) null);
        }
    }

    public i getFpsStatus() {
        return this.u;
    }

    public i getBox2dStatistics() {
        return this.v;
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        g();
        super.onDetachedFromWindow();
    }

    public Map<String, Integer> getFallingCount() {
        return this.i.c();
    }
}
