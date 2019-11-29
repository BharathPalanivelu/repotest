package com.shopee.app.ui.actionbar;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.garena.android.appkit.b.b;
import com.garena.android.appkit.tools.a.b;
import com.shopee.app.ui.actionbar.a;
import com.shopee.app.ui.common.f;
import com.shopee.id.R;
import com.squareup.a.af;
import com.squareup.a.w;

public class b extends a {
    private ImageButton p;
    private ImageButton q;
    private ImageButton r;
    private TextView s;
    private f t;
    private f u;

    /* access modifiers changed from: package-private */
    public void a() {
    }

    public void a(e eVar) {
    }

    public void a(String str) {
    }

    public void b(String str, int i) {
    }

    public void c() {
    }

    public void d() {
    }

    public boolean e() {
        return false;
    }

    public View getCartView() {
        return null;
    }

    public String getSearchPlaceholderActive() {
        return "";
    }

    public String getSearchText() {
        return "";
    }

    public k getSearchView() {
        return null;
    }

    public int getType() {
        return 0;
    }

    public void setSearchPlaceholder(String str) {
    }

    public void setSearchText(String str) {
    }

    public void setSubtitle(String str) {
    }

    public void setTitleForSearch(String str) {
    }

    public b(Context context) {
        super(context, new a.C0296a());
    }

    /* access modifiers changed from: package-private */
    public void b() {
        inflate(getContext(), this.f19260a.d() == 1 ? R.layout.action_bar_light_layout_white_theme : R.layout.action_bar_light_layout, this);
        if (!TextUtils.isEmpty(this.f19260a.e())) {
            w.a(getContext()).a(this.f19260a.e()).b(getResources().getDisplayMetrics().widthPixels, 0).b(R.drawable.action_bar_bg).a((af) this);
        } else {
            setBackgroundColor(com.garena.android.appkit.tools.b.a(R.color.background_light));
        }
        setLayoutParams(new LinearLayout.LayoutParams(-1, b.a.r));
        this.s = (TextView) findViewById(R.id.title);
        this.p = (ImageButton) findViewById(R.id.home_btn);
        this.p.setTag("ACTION_BAR_HOME_ACTION");
        this.p.setOnClickListener(this);
        this.q = (ImageButton) findViewById(R.id.cart_btn);
        this.q.setOnClickListener(this);
        this.q.setTag("ACTION_BAR_CART_PRIMARY");
        this.r = (ImageButton) findViewById(R.id.chat_btn);
        this.r.setOnClickListener(this);
        this.r.setTag("ACTION_BAR_ACTION_BOX_PRIMARY");
        this.t = (f) findViewById(R.id.cart_badge);
        this.t.c();
        this.u = (f) findViewById(R.id.chat_badge);
        this.u.c();
    }

    public void setTitle(CharSequence charSequence) {
        this.s.setText(charSequence);
    }

    public void a(boolean z) {
        this.p.setVisibility(z ? 0 : 8);
        this.s.setPadding(!z ? b.a.k : 0, 0, 0, 0);
    }

    public void a(a.b bVar) {
        super.a(bVar);
    }

    public int[] getCartLocation() {
        return new int[]{-1, -1};
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0027  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0034  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(java.lang.String r4, int r5) {
        /*
            r3 = this;
            int r0 = r4.hashCode()
            r1 = -1615836486(0xffffffff9fb04aba, float:-7.4662524E-20)
            r2 = 1
            if (r0 == r1) goto L_0x001a
            r1 = -1239637128(0xffffffffb61ca378, float:-2.3340963E-6)
            if (r0 == r1) goto L_0x0010
            goto L_0x0024
        L_0x0010:
            java.lang.String r0 = "ACTION_BAR_CART_PRIMARY"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x0024
            r4 = 0
            goto L_0x0025
        L_0x001a:
            java.lang.String r0 = "ACTION_BAR_ACTION_BOX_PRIMARY"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x0024
            r4 = 1
            goto L_0x0025
        L_0x0024:
            r4 = -1
        L_0x0025:
            if (r4 == 0) goto L_0x0034
            if (r4 == r2) goto L_0x002a
            goto L_0x003d
        L_0x002a:
            com.shopee.app.ui.common.f r4 = r3.u
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            r4.setNumber(r5)
            goto L_0x003d
        L_0x0034:
            com.shopee.app.ui.common.f r4 = r3.t
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            r4.setNumber(r5)
        L_0x003d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shopee.app.ui.actionbar.b.a(java.lang.String, int):void");
    }

    public void onClick(View view) {
        String str = (String) view.getTag();
        if (str != null) {
            com.garena.android.appkit.b.b.a(str, (com.garena.android.appkit.b.a) null, b.a.UI_BUS);
        }
    }

    public void f() {
        removeAllViews();
        b();
    }
}
