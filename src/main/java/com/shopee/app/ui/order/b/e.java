package com.shopee.app.ui.order.b;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.garena.android.uikit.a.a.a;
import com.google.android.material.tabs.TabLayout;
import com.shopee.app.appuser.UserInfo;
import com.shopee.app.data.viewmodel.OrderKey;
import com.shopee.app.ui.order.d;
import com.shopee.app.util.ak;
import com.shopee.app.util.x;
import com.shopee.id.R;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class e extends a {

    /* renamed from: a  reason: collision with root package name */
    public static String f23572a = "";
    private static final Map<Integer, Integer> h = new androidx.b.a();
    private static final List<String> i = Arrays.asList(new String[]{"all", "unprocessed", "processed"});
    /* access modifiers changed from: private */
    public static final List<Boolean> j = Arrays.asList(new Boolean[]{false, false, false});

    /* renamed from: b  reason: collision with root package name */
    com.shopee.app.tracking.a f23573b;

    /* renamed from: c  reason: collision with root package name */
    UserInfo f23574c;

    /* renamed from: d  reason: collision with root package name */
    TabLayout f23575d;

    /* renamed from: e  reason: collision with root package name */
    ViewGroup f23576e;

    /* renamed from: f  reason: collision with root package name */
    View f23577f;

    /* renamed from: g  reason: collision with root package name */
    ak f23578g;
    /* access modifiers changed from: private */
    public final List<OrderKey> k;
    /* access modifiers changed from: private */
    public List<b> l = new ArrayList();
    /* access modifiers changed from: private */
    public List<TextView> m = new ArrayList();
    private String n;

    static {
        h.put(7, Integer.valueOf(R.string.order_list_all_orders));
        h.put(10, Integer.valueOf(R.string.order_list_unprocessed));
        h.put(11, Integer.valueOf(R.string.order_list_processed));
    }

    public e(Context context, List<OrderKey> list, String str) {
        super(context);
        this.k = list;
        this.n = str;
        ((d) ((x) context).b()).a(this);
    }

    /* access modifiers changed from: package-private */
    public void d() {
        int g2 = g();
        for (OrderKey next : this.k) {
            boolean z = this.k.indexOf(next) == g2;
            a(next.listType, z);
            a(next, z);
        }
        TabLayout.f a2 = this.f23575d.a(g2);
        if (a2 != null) {
            a2.f();
            a(g2);
        }
        this.f23575d.a((TabLayout.b) new TabLayout.c() {
            public void a(TabLayout.f fVar) {
                int d2 = fVar.d();
                ((b) e.this.l.get(d2)).setVisibility(0);
                ((TextView) e.this.m.get(d2)).setCompoundDrawablesWithIntrinsicBounds(0, 0, ((Boolean) e.j.get(d2)).booleanValue() ? R.drawable.ic_sort_arrow_up : R.drawable.ic_sort_arrow_down, 0);
                e.this.a(d2);
                e.this.f23573b.a(e.this.f23574c.getUserId(), ((OrderKey) e.this.k.get(d2)).listType, ((Boolean) e.j.get(d2)).booleanValue());
            }

            public void b(TabLayout.f fVar) {
                int d2 = fVar.d();
                ((TextView) e.this.m.get(d2)).setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_sort_arrow_gray, 0);
                ((b) e.this.l.get(d2)).setVisibility(4);
            }

            public void c(TabLayout.f fVar) {
                int d2 = fVar.d();
                e.j.set(d2, Boolean.valueOf(!((Boolean) e.j.get(d2)).booleanValue()));
                ((TextView) e.this.m.get(d2)).setCompoundDrawablesWithIntrinsicBounds(0, 0, ((Boolean) e.j.get(d2)).booleanValue() ? R.drawable.ic_sort_arrow_up : R.drawable.ic_sort_arrow_down, 0);
                ((b) e.this.l.get(d2)).setAscending(((Boolean) e.j.get(d2)).booleanValue());
                e.this.f23573b.a(e.this.f23574c.getUserId(), ((OrderKey) e.this.k.get(d2)).listType, ((Boolean) e.j.get(d2)).booleanValue());
            }
        });
    }

    /* access modifiers changed from: package-private */
    public void e() {
        this.f23578g.o();
    }

    private int g() {
        if (!TextUtils.isEmpty(this.n)) {
            return i.indexOf(this.n);
        }
        return 0;
    }

    /* access modifiers changed from: private */
    public void a(int i2) {
        f23572a = i2 <= i.size() ? i.get(i2) : "";
    }

    private void a(OrderKey orderKey, boolean z) {
        b a2 = c.a(getContext(), orderKey);
        if (!z) {
            a2.setVisibility(4);
        }
        this.l.add(a2);
        this.f23576e.addView(a2, new LinearLayout.LayoutParams(-1, -1));
    }

    private void a(int i2, boolean z) {
        TabLayout.f a2 = this.f23575d.a();
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.order_nested_tab, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(R.id.tabTitle);
        textView.setText(h.get(Integer.valueOf(i2)).intValue());
        if (z) {
            textView.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_sort_arrow_down, 0);
        }
        a2.a(inflate);
        this.m.add(textView);
        this.f23575d.a(a2);
    }

    public void a() {
        super.a();
        List<b> list = this.l;
        if (list != null) {
            for (b a2 : list) {
                a2.a();
            }
        }
    }

    public void b() {
        super.b();
        List<b> list = this.l;
        if (list != null) {
            for (b b2 : list) {
                b2.b();
            }
        }
    }

    public void c() {
        super.c();
        List<b> list = this.l;
        if (list != null) {
            for (b c2 : list) {
                c2.c();
            }
        }
    }
}
