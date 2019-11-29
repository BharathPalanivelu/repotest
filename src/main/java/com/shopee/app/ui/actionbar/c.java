package com.shopee.app.ui.actionbar;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.shopee.app.ui.actionbar.a;
import com.shopee.app.ui.common.m;
import com.shopee.id.R;
import org.a.a.b.a;
import org.a.a.b.b;

public final class c extends a implements a, b {
    private boolean p = false;
    private final org.a.a.b.c q = new org.a.a.b.c();

    public c(Context context, a.C0296a aVar) {
        super(context, aVar);
        g();
    }

    public static a a(Context context, a.C0296a aVar) {
        c cVar = new c(context, aVar);
        cVar.onFinishInflate();
        return cVar;
    }

    public void onFinishInflate() {
        if (!this.p) {
            this.p = true;
            inflate(getContext(), R.layout.action_bar_layout, this);
            this.q.a((org.a.a.b.a) this);
        }
        super.onFinishInflate();
    }

    private void g() {
        org.a.a.b.c a2 = org.a.a.b.c.a(this.q);
        Resources resources = getContext().getResources();
        org.a.a.b.c.a((b) this);
        this.l = resources.getDimensionPixelOffset(R.dimen.action_bar_height);
        this.m = resources.getDimensionPixelOffset(R.dimen.dp48);
        this.n = resources.getDimensionPixelOffset(R.dimen.dp24);
        this.o = resources.getDimensionPixelOffset(R.dimen.dp16);
        org.a.a.b.c.a(a2);
    }

    public <T extends View> T internalFindViewById(int i) {
        return findViewById(i);
    }

    public void onViewChanged(org.a.a.b.a aVar) {
        this.f19261b = (ImageButton) aVar.internalFindViewById(R.id.home_btn);
        this.f19262c = (LinearLayout) aVar.internalFindViewById(R.id.action_container);
        this.f19263d = (RelativeLayout) aVar.internalFindViewById(R.id.main_container);
        this.f19264e = (ImageView) aVar.internalFindViewById(R.id.title_icon);
        this.f19265f = (TextView) aVar.internalFindViewById(R.id.title_text);
        this.f19266g = (TextView) aVar.internalFindViewById(R.id.sub_title);
        this.h = (k) aVar.internalFindViewById(R.id.search_view);
        this.i = (m) aVar.internalFindViewById(R.id.search_icon);
        this.j = (ViewGroup) aVar.internalFindViewById(R.id.title_container);
        this.k = (ViewGroup) aVar.internalFindViewById(R.id.title_box);
        b();
    }
}
