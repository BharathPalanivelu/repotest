package com.shopee.app.ui.order;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import com.garena.android.uikit.a.a;
import com.garena.android.uikit.a.a.b;
import com.garena.android.uikit.a.c;
import com.shopee.app.data.viewmodel.OrderKey;
import com.shopee.app.ui.order.b.c.g;
import java.util.Arrays;

public class f extends a implements c.C0127c {

    /* renamed from: c  reason: collision with root package name */
    private final int f23662c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f23663d;

    /* renamed from: e  reason: collision with root package name */
    private String f23664e;

    public View a(Context context) {
        return null;
    }

    public f(int i, boolean z, String str) {
        this.f23662c = i;
        this.f23663d = z;
        this.f23664e = str;
    }

    public int b() {
        return g.f23665a.values().size();
    }

    public b d(Context context, int i) {
        q qVar;
        if (i == 0) {
            qVar = new q(context, "ORDER_9");
        } else if (i == 1) {
            qVar = new q(context, "ORDER_7");
        } else if (i == 2) {
            qVar = new q(context, "ORDER_8");
        } else if (i == 3) {
            qVar = new q(context, "ORDER_3");
        } else if (i == 4) {
            qVar = new q(context, "ORDER_4");
        } else if (i != 5) {
            qVar = new q(context, "ORDER_6");
        } else {
            qVar = new q(context, "ORDER_5");
        }
        int i2 = this.f23662c;
        if (i2 == 0) {
            qVar.setTitle(g.f23665a.get(Integer.valueOf(i)).intValue());
        } else if (i2 == 1) {
            qVar.setTitle(g.f23666b.get(Integer.valueOf(i)).intValue());
        }
        return qVar;
    }

    public com.garena.android.uikit.a.a.a e(Context context, int i) {
        boolean z = false;
        if (i == 0) {
            int i2 = this.f23662c;
            if (i2 == 1) {
                return com.shopee.app.ui.order.b.c.a(context, new OrderKey(i2, 9));
            }
            return com.shopee.app.ui.order.b.b.c.a(context, false);
        } else if (i == 1) {
            int i3 = this.f23662c;
            if (i3 != 1 || !this.f23663d) {
                return com.shopee.app.ui.order.b.c.a(context, new OrderKey(this.f23662c, 7));
            }
            return com.shopee.app.ui.order.b.f.a(context, Arrays.asList(new OrderKey[]{new OrderKey(i3, 7), new OrderKey(this.f23662c, 10), new OrderKey(this.f23662c, 11)}), this.f23664e);
        } else if (i == 2) {
            return com.shopee.app.ui.order.b.c.a(context, new OrderKey(this.f23662c, 8));
        } else {
            if (i == 3) {
                return com.shopee.app.ui.order.b.c.a(context, new OrderKey(this.f23662c, 3));
            }
            if (i == 4) {
                return com.shopee.app.ui.order.b.c.a(context, new OrderKey(this.f23662c, 4));
            }
            if (i != 5) {
                return com.shopee.app.ui.order.b.c.a(context, new OrderKey(this.f23662c, 6));
            }
            int i4 = this.f23662c;
            if (i4 == 1) {
                return com.shopee.app.ui.order.b.c.c.a(context, this.f23664e);
            }
            if (i4 == 1) {
                z = true;
            }
            return g.a(context, z);
        }
    }

    public void a(HorizontalScrollView horizontalScrollView, FrameLayout frameLayout, int i, float f2) {
        View childAt = ((LinearLayout) frameLayout.getChildAt(0)).getChildAt(i);
        horizontalScrollView.scrollTo((childAt.getLeft() + ((int) (((float) childAt.getWidth()) * f2))) - 240, 0);
    }

    public LinearLayout.LayoutParams b(Context context, int i) {
        return new LinearLayout.LayoutParams(-2, -2);
    }
}
