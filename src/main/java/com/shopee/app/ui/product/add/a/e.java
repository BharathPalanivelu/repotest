package com.shopee.app.ui.product.add.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.garena.android.appkit.d.a;
import com.garena.android.appkit.tools.b;
import com.shopee.app.react.modules.ui.abtesting.AbTestingModule;
import com.shopee.app.util.q.d;
import com.shopee.id.R;
import d.d.b.j;
import d.h.m;

public abstract class e {

    /* renamed from: a  reason: collision with root package name */
    private TextView f23972a;

    /* renamed from: b  reason: collision with root package name */
    private final LinearLayout f23973b;

    public abstract View b();

    public abstract void c();

    public e(LinearLayout linearLayout) {
        j.b(linearLayout, "addProductLayout");
        this.f23973b = linearLayout;
    }

    public void e() {
        c();
    }

    public final void a(d dVar) {
        j.b(dVar, AbTestingModule.KEY_RESULT);
        if (dVar instanceof d.b) {
            b().setBackgroundResource(R.drawable.bottom_border_white_background);
        } else {
            b().setBackgroundColor(b.a(R.color.no_variation_highlight));
        }
    }

    public final void b(d dVar) {
        j.b(dVar, "warning");
        if (!(dVar instanceof d.c)) {
            g();
            return;
        }
        d.c cVar = (d.c) dVar;
        if (m.a(cVar.a())) {
            g();
            return;
        }
        if (this.f23972a == null) {
            Context context = this.f23973b.getContext();
            j.a((Object) context, "addProductLayout.context");
            this.f23972a = a(context, this.f23973b, h());
        }
        TextView textView = this.f23972a;
        if (textView != null) {
            textView.setVisibility(0);
            textView.setText(cVar.a());
        }
    }

    public final void g() {
        TextView textView = this.f23972a;
        if (textView != null) {
            textView.setVisibility(8);
        }
    }

    public int h() {
        return this.f23973b.indexOfChild(b()) + 1;
    }

    public final TextView a(Context context, LinearLayout linearLayout, int i) {
        j.b(context, "context");
        j.b(linearLayout, "parentLayout");
        try {
            View inflate = LayoutInflater.from(context).inflate(R.layout.add_product_warning_message_layout, (ViewGroup) null);
            if (inflate != null) {
                TextView textView = (TextView) inflate;
                linearLayout.addView(textView, i);
                return textView;
            }
            throw new d.m("null cannot be cast to non-null type android.widget.TextView");
        } catch (Exception e2) {
            a.a(e2);
            return null;
        }
    }
}
