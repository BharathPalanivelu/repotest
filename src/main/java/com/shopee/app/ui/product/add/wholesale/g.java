package com.shopee.app.ui.product.add.wholesale;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import com.devspark.robototextview.widget.RobotoTextView;
import com.shopee.app.a;
import com.shopee.id.R;
import d.d.b.j;
import java.util.HashMap;

public final class g extends ScrollView {

    /* renamed from: a  reason: collision with root package name */
    private i f24206a;

    /* renamed from: b  reason: collision with root package name */
    private HashMap f24207b;

    public g(Context context) {
        this(context, (AttributeSet) null, 0, 6, (g) null);
    }

    public View a(int i) {
        if (this.f24207b == null) {
            this.f24207b = new HashMap();
        }
        View view = (View) this.f24207b.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i);
        this.f24207b.put(Integer.valueOf(i), findViewById);
        return findViewById;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ g(Context context, AttributeSet attributeSet, int i, int i2, g gVar) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public g(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        j.b(context, "context");
        View.inflate(context, R.layout.wholesale_layout, this);
    }

    public final void setModel(i iVar) {
        j.b(iVar, "data");
        this.f24206a = iVar;
        a();
    }

    public final void a() {
        RobotoTextView robotoTextView = (RobotoTextView) a(a.C0250a.addPriceView);
        i iVar = this.f24206a;
        robotoTextView.setText(iVar != null ? iVar.b() : null);
        i iVar2 = this.f24206a;
        int i = 0;
        robotoTextView.setVisibility((iVar2 == null || !iVar2.c()) ? 8 : 0);
        View a2 = a(a.C0250a.splitLine);
        j.a((Object) a2, "splitLine");
        i iVar3 = this.f24206a;
        a2.setVisibility((iVar3 == null || !iVar3.a()) ? 8 : 0);
        LinearLayout linearLayout = (LinearLayout) a(a.C0250a.containerLayout);
        j.a((Object) linearLayout, "containerLayout");
        i iVar4 = this.f24206a;
        linearLayout.setVisibility((iVar4 == null || !iVar4.a()) ? 8 : 0);
        View a3 = a(a.C0250a.splitLine2);
        j.a((Object) a3, "splitLine2");
        i iVar5 = this.f24206a;
        if (iVar5 == null || !iVar5.a()) {
            i = 8;
        }
        a3.setVisibility(i);
    }

    static final class a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ k f24208a;

        a(k kVar) {
            this.f24208a = kVar;
        }

        public final void onClick(View view) {
            this.f24208a.f();
        }
    }

    public final void setPresenter(k kVar) {
        j.b(kVar, "presenter");
        ((RobotoTextView) a(a.C0250a.addPriceTierBtn)).setOnClickListener(new a(kVar));
    }

    public final void a(View view) {
        j.b(view, "view");
        ((LinearLayout) a(a.C0250a.tierRootView)).removeView(view);
    }

    public final LinearLayout getTierRootView() {
        LinearLayout linearLayout = (LinearLayout) a(a.C0250a.tierRootView);
        j.a((Object) linearLayout, "tierRootView");
        return linearLayout;
    }
}
