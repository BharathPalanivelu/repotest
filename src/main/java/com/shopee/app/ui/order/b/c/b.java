package com.shopee.app.ui.order.b.c;

import android.app.Activity;
import android.content.Context;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.garena.android.uikit.a.a.a;
import com.google.android.material.tabs.TabLayout;
import com.shopee.app.ui.a.e;
import com.shopee.app.ui.order.d;
import com.shopee.app.util.x;
import com.shopee.id.R;
import java.util.ArrayList;
import java.util.List;

public class b extends a {

    /* renamed from: a  reason: collision with root package name */
    Activity f23532a;

    /* renamed from: b  reason: collision with root package name */
    com.shopee.app.tracking.a f23533b;

    /* renamed from: c  reason: collision with root package name */
    TabLayout f23534c;

    /* renamed from: d  reason: collision with root package name */
    ViewGroup f23535d;

    /* renamed from: e  reason: collision with root package name */
    private final String f23536e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public List<f> f23537f = new ArrayList();

    /* renamed from: g  reason: collision with root package name */
    private SparseBooleanArray f23538g = new SparseBooleanArray();

    public b(Context context, String str) {
        super(context);
        this.f23536e = str;
        ((d) ((x) context).b()).a(this);
    }

    public void a() {
        super.a();
        List<f> list = this.f23537f;
        if (list != null) {
            for (f a2 : list) {
                a2.a();
            }
        }
        e();
    }

    /* access modifiers changed from: package-private */
    public void d() {
        int initialTab = getInitialTab();
        for (a aVar : a.values()) {
            setupFilterTabHeader(aVar);
            a(aVar, aVar.getValue() == initialTab);
        }
        TabLayout.f a2 = this.f23534c.a(initialTab);
        if (a2 != null) {
            a2.f();
        }
        this.f23534c.a((TabLayout.b) new TabLayout.c() {
            public void c(TabLayout.f fVar) {
            }

            public void a(TabLayout.f fVar) {
                ((f) b.this.f23537f.get(fVar.d())).setVisibility(0);
                b.this.f23533b.b(b.this.getTrackingPageId(), "returnListFilterClick", String.valueOf(fVar.a()));
                b.this.e();
            }

            public void b(TabLayout.f fVar) {
                ((f) b.this.f23537f.get(fVar.d())).setVisibility(4);
            }
        });
    }

    public void b() {
        super.b();
        List<f> list = this.f23537f;
        if (list != null) {
            for (f b2 : list) {
                b2.b();
            }
        }
    }

    public void c() {
        super.c();
        List<f> list = this.f23537f;
        if (list != null) {
            for (f c2 : list) {
                c2.c();
            }
        }
    }

    private int getInitialTab() {
        a fromName = a.fromName(this.f23536e);
        if (fromName != null) {
            return fromName.getValue();
        }
        return 0;
    }

    private void setupFilterTabHeader(a aVar) {
        TabLayout.f a2 = this.f23534c.a();
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.return_order_nested_tab, (ViewGroup) null);
        ((TextView) inflate.findViewById(R.id.tabTitle)).setText(aVar.getNameResId());
        a2.a(inflate);
        a2.a((Object) Integer.valueOf(aVar.getValue()));
        this.f23534c.a(a2);
    }

    private void a(a aVar, boolean z) {
        f a2 = g.a(getContext(), true, aVar.getValue());
        if (!z) {
            a2.setVisibility(4);
        }
        this.f23537f.add(a2);
        this.f23535d.addView(a2, new LinearLayout.LayoutParams(-1, -1));
    }

    /* access modifiers changed from: private */
    public String getTrackingPageId() {
        return ((e) this.f23532a).A();
    }

    /* access modifiers changed from: private */
    public void e() {
        int selectedTabPosition = this.f23534c.getSelectedTabPosition();
        this.f23533b.a(getTrackingPageId(), "ReturnListFilterView_" + String.valueOf(selectedTabPosition), !this.f23538g.get(selectedTabPosition), "");
        if (!this.f23538g.get(selectedTabPosition)) {
            this.f23538g.put(selectedTabPosition, true);
        }
    }
}
