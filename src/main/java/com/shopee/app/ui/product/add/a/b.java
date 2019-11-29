package com.shopee.app.ui.product.add.a;

import android.widget.CompoundButton;
import android.widget.LinearLayout;
import com.shopee.app.ui.product.b.a.d;
import com.shopee.app.ui.product.b.d;
import com.shopee.app.ui.product.common.a;
import com.shopee.app.util.q.e;
import com.shopee.app.util.q.g;
import com.shopee.id.R;
import d.d.b.j;
import d.m;
import java.util.List;

public final class b extends e {

    /* renamed from: a  reason: collision with root package name */
    private List<Integer> f23957a;

    /* renamed from: b  reason: collision with root package name */
    private final d f23958b;

    /* renamed from: c  reason: collision with root package name */
    private final LinearLayout f23959c;

    /* renamed from: d  reason: collision with root package name */
    private final CompoundButton f23960d;

    /* renamed from: e  reason: collision with root package name */
    private final a f23961e;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public b(LinearLayout linearLayout, d dVar, LinearLayout linearLayout2, CompoundButton compoundButton, a aVar) {
        super(linearLayout);
        j.b(linearLayout, "addProductLayout");
        j.b(dVar, "validatorProvider");
        j.b(linearLayout2, "dtsSectionView");
        j.b(compoundButton, "preOrderToggle");
        j.b(aVar, "shippingDaysView");
        this.f23958b = dVar;
        this.f23959c = linearLayout2;
        this.f23960d = compoundButton;
        this.f23961e = aVar;
        this.f23961e.setBackgroundColor(com.garena.android.appkit.tools.b.a(R.color.transparent));
    }

    /* renamed from: a */
    public LinearLayout b() {
        return this.f23959c;
    }

    public e.C0408e d() {
        return e.C0408e.DTS;
    }

    public void c() {
        try {
            boolean isChecked = this.f23960d.isChecked();
            Object tag = this.f23961e.getTag();
            if (tag != null) {
                b(com.shopee.app.util.q.a.a(this.f23958b.b(), new e.b(this.f23957a, isChecked, ((Integer) tag).intValue()), false, 2, (Object) null));
                return;
            }
            throw new m("null cannot be cast to non-null type kotlin.Int");
        } catch (Exception e2) {
            com.garena.android.appkit.d.a.a(e2);
        }
    }

    public void e() {
        String str;
        super.e();
        g a2 = this.f23958b.a(d());
        if (a2 instanceof com.shopee.app.ui.product.b.a.d) {
            d.b a3 = ((com.shopee.app.ui.product.b.a.d) a2).a(this.f23957a);
            if (a3 != null) {
                str = com.garena.android.appkit.tools.b.a(R.string.sp_label_shipping_day_range, Integer.valueOf(a3.a()), Integer.valueOf(a3.b()));
                j.a((Object) str, "BBAppResource.string(R.s…       constraint.maxDts)");
            } else {
                str = "";
            }
            this.f23961e.setSmallText(str);
        }
    }

    public final void f() {
        c();
    }

    public final void a(List<Integer> list) {
        if (!j.a((Object) this.f23957a, (Object) list)) {
            this.f23957a = list;
            c();
        }
    }
}
