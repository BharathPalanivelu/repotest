package com.shopee.app.ui.product.add;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.widget.FrameLayout;
import android.widget.ListView;
import com.shopee.app.ui.a.n;
import com.shopee.app.ui.common.r;
import com.shopee.app.util.bc;
import com.shopee.app.web.WebRegister;

public class z extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    ListView f24227a;

    /* renamed from: b  reason: collision with root package name */
    bc f24228b;

    /* renamed from: c  reason: collision with root package name */
    x f24229c;

    /* renamed from: d  reason: collision with root package name */
    r f24230d;

    /* renamed from: e  reason: collision with root package name */
    a f24231e;

    /* renamed from: f  reason: collision with root package name */
    Activity f24232f;

    /* renamed from: g  reason: collision with root package name */
    int f24233g;
    private q h = r.a(getContext());
    private String i = "";

    public z(Context context, String str) {
        super(context);
        this.i = str;
        ((p) context).b().a(this);
    }

    /* access modifiers changed from: package-private */
    public void a() {
        this.f24228b.a(this.f24229c);
        this.f24229c.a(this);
        this.f24227a.addHeaderView(this.h);
        this.f24227a.setAdapter(this.f24231e);
        this.f24229c.e();
        this.f24230d.a();
    }

    public void a(t tVar) {
        Intent intent = new Intent();
        intent.putExtra("pageInfo", WebRegister.GSON.b(tVar, t.class));
        this.f24232f.setResult(-1, intent);
        this.f24232f.finish();
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x003c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(java.util.List<com.shopee.app.ui.product.add.t> r6) {
        /*
            r5 = this;
            com.shopee.app.ui.common.r r0 = r5.f24230d
            r0.b()
            java.lang.String r0 = r5.i
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            r1 = 1
            if (r0 != 0) goto L_0x002e
            java.util.Iterator r0 = r6.iterator()
        L_0x0012:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x002e
            java.lang.Object r2 = r0.next()
            com.shopee.app.ui.product.add.t r2 = (com.shopee.app.ui.product.add.t) r2
            java.lang.String r3 = r5.i
            java.lang.String r4 = r2.c()
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L_0x0012
            r2.a((boolean) r1)
            goto L_0x002f
        L_0x002e:
            r1 = 0
        L_0x002f:
            if (r1 != 0) goto L_0x0036
            com.shopee.app.ui.product.add.q r0 = r5.h
            r0.d()
        L_0x0036:
            boolean r0 = r6.isEmpty()
            if (r0 == 0) goto L_0x0041
            com.shopee.app.ui.product.add.q r0 = r5.h
            r0.c()
        L_0x0041:
            com.shopee.app.ui.product.add.z$a r0 = r5.f24231e
            r0.a(r6)
            com.shopee.app.ui.product.add.z$a r6 = r5.f24231e
            r6.notifyDataSetChanged()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shopee.app.ui.product.add.z.a(java.util.List):void");
    }

    public static class a extends com.shopee.app.ui.a.z<t> {
        /* access modifiers changed from: protected */
        public n<t> a(Context context, int i) {
            return v.a(context);
        }
    }
}
