package com.shopee.app.ui.home.bottom;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import java.util.ArrayList;
import java.util.List;

public class BottomNavView extends LinearLayout implements View.OnClickListener, View.OnLongClickListener {

    /* renamed from: a  reason: collision with root package name */
    private List<a> f22124a;

    /* renamed from: b  reason: collision with root package name */
    private a f22125b;

    public interface a {
        void a(a aVar);
    }

    public boolean onLongClick(View view) {
        return true;
    }

    public BottomNavView(Context context) {
        super(context);
        a(context);
    }

    public BottomNavView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    public BottomNavView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(context);
    }

    public BottomNavView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        a(context);
    }

    private void a(Context context) {
        this.f22124a = new ArrayList();
        setClipChildren(false);
    }

    public void setData(com.shopee.app.ui.home.a[] aVarArr) {
        for (com.shopee.app.ui.home.a data : aVarArr) {
            a a2 = b.a(getContext());
            a2.setOnClickListener(this);
            a2.setData(data);
            addView(a2, new LinearLayout.LayoutParams(0, -1, 1.0f));
            a2.setOnLongClickListener(this);
            this.f22124a.add(a2);
        }
    }

    public a a(int i) {
        if (i < 0 || i >= this.f22124a.size()) {
            return null;
        }
        return this.f22124a.get(i);
    }

    public void setActive(int i) {
        if (i >= 0) {
            this.f22124a.get(i).setActive(true);
        }
    }

    public void setInactive(int i) {
        if (i >= 0) {
            this.f22124a.get(i).setActive(false);
        }
    }

    public void a(boolean z) {
        a(com.shopee.app.ui.home.a.TAB_ME, z);
    }

    public void a(com.shopee.app.ui.home.a aVar, boolean z) {
        this.f22124a.get(aVar.getPos()).getBadgeView().a(z);
    }

    public void b(com.shopee.app.ui.home.a aVar, boolean z) {
        this.f22124a.get(aVar.getPos()).getBadgeView().setNumberDot(z ? 1 : 0);
    }

    public void setOnNavItemClickListener(a aVar) {
        this.f22125b = aVar;
    }

    public void onClick(View view) {
        a aVar = this.f22125b;
        if (aVar != null && (view instanceof a)) {
            aVar.a((a) view);
        }
    }
}
