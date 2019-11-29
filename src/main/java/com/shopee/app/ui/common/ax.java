package com.shopee.app.ui.common;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import com.garena.android.uikit.a.a;
import com.garena.android.uikit.a.a.b;
import com.garena.android.uikit.a.c;
import com.google.a.i;
import com.google.a.l;
import com.shopee.app.ui.order.q;
import com.shopee.app.util.av;
import com.shopee.app.web.protocol.TabsConfig;
import java.util.Enumeration;
import java.util.Hashtable;

public class ax extends a implements c.C0127c {

    /* renamed from: c  reason: collision with root package name */
    private final TabsConfig f21202c;

    /* renamed from: d  reason: collision with root package name */
    private i f21203d;

    /* renamed from: e  reason: collision with root package name */
    private ay f21204e;

    /* renamed from: f  reason: collision with root package name */
    private Hashtable<Integer, av> f21205f = new Hashtable<>();
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public boolean f21206g = false;
    /* access modifiers changed from: private */
    public boolean h = false;

    public View a(Context context) {
        return null;
    }

    public ax(l lVar, ay ayVar, TabsConfig tabsConfig) {
        this.f21203d = lVar.n();
        this.f21204e = ayVar;
        this.f21202c = tabsConfig;
    }

    public int b() {
        return this.f21203d.a();
    }

    public b d(Context context, int i) {
        int b2 = (com.garena.android.appkit.tools.b.b() - this.f21204e.f()) / b();
        q qVar = new q(context);
        qVar.setMinimumWidth(b2);
        TabsConfig tabsConfig = this.f21202c;
        if (tabsConfig != null) {
            qVar.setBackgroundColor(tabsConfig.getBarColor());
            qVar.setSelectedColor(this.f21202c.getActiveColor());
            qVar.setDeselectedColor(this.f21202c.getTextColor());
            qVar.setSelectedTextSize(this.f21202c.getTextSizeActive());
            qVar.setDeselectedTextSize(this.f21202c.getTextSize());
        }
        qVar.getChildAt(0).setMinimumWidth(b2);
        ((ViewGroup) qVar.getChildAt(0)).getChildAt(0).setMinimumWidth(b2);
        qVar.setTitle(this.f21203d.a(i).m().c("name").c());
        qVar.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    boolean unused = ax.this.f21206g = true;
                    boolean unused2 = ax.this.h = false;
                }
                return false;
            }
        });
        return qVar;
    }

    public com.garena.android.uikit.a.a.a e(Context context, int i) {
        av avVar = this.f21205f.get(Integer.valueOf(i));
        if (avVar != null) {
            return avVar;
        }
        av a2 = aw.a(context, i, this.f21203d.a(i).m().c("url").c(), this.f21204e);
        a2.setOnInterceptTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 2) {
                    boolean unused = ax.this.f21206g = false;
                    boolean unused2 = ax.this.h = true;
                }
                return false;
            }
        });
        this.f21205f.put(Integer.valueOf(i), a2);
        return a2;
    }

    public av a(int i) {
        if (av.f26170a) {
            i = (b() - i) - 1;
        }
        return this.f21205f.get(Integer.valueOf(i));
    }

    public void a(av avVar) {
        Enumeration<Integer> keys = this.f21205f.keys();
        while (keys.hasMoreElements()) {
            int intValue = keys.nextElement().intValue();
            if (this.f21205f.get(Integer.valueOf(intValue)) == avVar) {
                this.f21205f.remove(Integer.valueOf(intValue));
                return;
            }
        }
    }

    public boolean c() {
        return this.f21206g;
    }

    public void d() {
        this.f21206g = false;
    }

    public boolean e() {
        return this.h;
    }

    public void f() {
        this.h = false;
    }

    public void g() {
        this.f21205f.clear();
    }

    public void a(HorizontalScrollView horizontalScrollView, FrameLayout frameLayout, int i, float f2) {
        View childAt = ((LinearLayout) frameLayout.getChildAt(0)).getChildAt(i);
        horizontalScrollView.scrollTo((childAt.getLeft() + ((int) (((float) childAt.getWidth()) * f2))) - 240, 0);
    }

    public LinearLayout.LayoutParams b(Context context, int i) {
        return new LinearLayout.LayoutParams(-2, -2);
    }
}
