package com.shopee.app.ui.shopassistant;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.garena.android.appkit.b.a;
import com.garena.android.appkit.b.e;
import com.garena.android.appkit.tools.a.b;
import com.garena.android.appkit.tools.b;
import com.shopee.app.appuser.UserInfo;
import com.shopee.app.data.store.SettingConfigStore;
import com.shopee.app.ui.a.r;
import com.shopee.app.ui.dialog.a;
import com.shopee.app.util.ak;
import com.shopee.app.util.bc;
import com.shopee.app.util.bi;
import com.shopee.app.util.i;
import com.shopee.app.util.x;
import com.shopee.id.R;
import com.squareup.a.w;

public class g extends ScrollView implements r {

    /* renamed from: a  reason: collision with root package name */
    int f25455a;

    /* renamed from: b  reason: collision with root package name */
    bi f25456b;

    /* renamed from: c  reason: collision with root package name */
    f f25457c;

    /* renamed from: d  reason: collision with root package name */
    bc f25458d;

    /* renamed from: e  reason: collision with root package name */
    ak f25459e;

    /* renamed from: f  reason: collision with root package name */
    UserInfo f25460f;

    /* renamed from: g  reason: collision with root package name */
    SettingConfigStore f25461g;
    e h = new com.garena.android.appkit.b.g() {
        public void onEvent(a aVar) {
            switch (((Integer) aVar.data).intValue()) {
                case 0:
                    g.this.f25459e.h();
                    return;
                case 1:
                    g.this.f25459e.i();
                    return;
                case 2:
                    g.this.f25459e.r();
                    return;
                case 4:
                    if (g.this.f25461g.shopSettingRN()) {
                        g.this.f25459e.I();
                        return;
                    } else {
                        g.this.f25459e.H();
                        return;
                    }
                case 5:
                    g.this.g();
                    return;
                case 6:
                    g.this.f();
                    return;
                case 7:
                    g.this.f25459e.X();
                    return;
                case 8:
                    g.this.e();
                    return;
                case 9:
                    g.this.f25459e.s();
                    return;
                default:
                    return;
            }
        }
    };

    public void d() {
    }

    public g(Context context) {
        super(context);
        ((c) ((x) context).b()).a(this);
    }

    /* access modifiers changed from: package-private */
    public void a() {
        this.f25458d.a(this.f25457c);
        this.f25457c.a(this);
        Context context = getContext();
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(1);
        addView(linearLayout, new ViewGroup.LayoutParams(-1, -2));
        d a2 = ShopAssistantItemView_.a(context);
        a2.a(R.drawable.ic_myproducts, R.string.sp_my_products, 0);
        a2.setTag("PRODUCT");
        a2.setMinimumHeight(this.f25455a);
        linearLayout.addView(a2, new FrameLayout.LayoutParams(-1, -2));
        d a3 = ShopAssistantItemView_.a(context);
        a3.a(R.drawable.ic_mycustomers, R.string.sp_my_customers, 2);
        linearLayout.addView(a3, new FrameLayout.LayoutParams(-1, this.f25455a));
        d a4 = ShopAssistantItemView_.a(context);
        a4.a(R.drawable.ic_shopprofile, R.string.sp_label_shop_profile, 6);
        linearLayout.addView(a4, new FrameLayout.LayoutParams(-1, this.f25455a));
        d a5 = ShopAssistantItemView_.a(context);
        a5.a(R.drawable.img_shopsettings, R.string.sp_shop_settings, 4);
        linearLayout.addView(a5, new FrameLayout.LayoutParams(-1, this.f25455a));
        d a6 = ShopAssistantItemView_.a(context);
        a6.a(R.drawable.ic_categories, R.string.sp_my_shop_categories, 8);
        a6.setSubtitle(this.f25461g.getCategoriesPath());
        linearLayout.addView(a6, new FrameLayout.LayoutParams(-1, this.f25455a));
        View view = new View(context);
        view.setBackgroundColor(b.a(R.color.background));
        linearLayout.addView(view, new FrameLayout.LayoutParams(-1, b.a.k));
        View view2 = new View(context);
        view2.setBackgroundColor(com.garena.android.appkit.tools.b.a(R.color.black06));
        linearLayout.addView(view2, new FrameLayout.LayoutParams(-1, b.a.f7690a));
        View inflate = ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.seller_center, (ViewGroup) null);
        ((TextView) inflate.findViewById(R.id.url)).setText("http://seller" + i.f7042e);
        int b2 = com.garena.android.appkit.tools.b.b() - b.a.m;
        w.a(getContext()).a((int) R.drawable.sellercentre_banner).b(b2, (int) (((float) b2) / 1.886f)).e().f().a((ImageView) inflate.findViewById(R.id.banner));
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        inflate.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                g.this.f25459e.V();
            }
        });
        linearLayout.addView(inflate, layoutParams);
        this.f25457c.e();
        this.f25457c.f();
    }

    public void b() {
        this.f25456b.a("SHOP_ASSISTANT_SELECT_EVENT", this.h);
    }

    public void c() {
        this.f25456b.b("SHOP_ASSISTANT_SELECT_EVENT", this.h);
    }

    /* access modifiers changed from: private */
    public void e() {
        com.shopee.app.ui.dialog.a.a(getContext(), (int) R.string.sp_open_shop_categories_in_broswer, (int) R.string.sp_label_cancel, (int) R.string.sp_open_in_browser, (a.C0318a) new a.C0318a() {
            public void onNegative() {
            }

            public void onPositive() {
                g.this.f25459e.ah();
            }
        });
    }

    /* access modifiers changed from: private */
    public void f() {
        this.f25459e.J();
    }

    /* access modifiers changed from: private */
    public void g() {
        this.f25459e.Q();
    }

    public void a(int i) {
        d dVar = (d) findViewWithTag("ORDER");
        if (dVar != null) {
            dVar.setBadge(i);
        }
    }

    public void b(int i) {
        String str;
        d dVar = (d) findViewWithTag("PRODUCT");
        if (i == 1) {
            str = com.garena.android.appkit.tools.b.e(R.string.sp_1_product);
        } else {
            str = com.garena.android.appkit.tools.b.a(R.string.sp_n_products, Integer.valueOf(i));
        }
        dVar.a(R.drawable.ic_myproducts, R.string.sp_my_products, str, 0);
    }
}
