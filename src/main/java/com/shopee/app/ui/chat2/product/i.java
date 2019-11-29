package com.shopee.app.ui.chat2.product;

import android.content.Context;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.shopee.id.R;
import org.a.a.b.a;
import org.a.a.b.b;
import org.a.a.b.c;

public final class i extends h implements a, b {

    /* renamed from: e  reason: collision with root package name */
    private boolean f20808e = false;

    /* renamed from: f  reason: collision with root package name */
    private final c f20809f = new c();

    public i(Context context, int i, int i2) {
        super(context, i, i2);
        e();
    }

    public static h a(Context context, int i, int i2) {
        i iVar = new i(context, i, i2);
        iVar.onFinishInflate();
        return iVar;
    }

    public void onFinishInflate() {
        if (!this.f20808e) {
            this.f20808e = true;
            inflate(getContext(), R.layout.product_selection_list_layout, this);
            this.f20809f.a((a) this);
        }
        super.onFinishInflate();
    }

    private void e() {
        c a2 = c.a(this.f20809f);
        c.a((b) this);
        c.a(a2);
    }

    public <T extends View> T internalFindViewById(int i) {
        return findViewById(i);
    }

    public void onViewChanged(a aVar) {
        this.f20801a = (RecyclerView) aVar.internalFindViewById(R.id.list);
        d();
    }
}
