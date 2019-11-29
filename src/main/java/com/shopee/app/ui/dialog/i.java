package com.shopee.app.ui.dialog;

import android.content.Context;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.shopee.id.R;
import org.a.a.b.a;
import org.a.a.b.b;
import org.a.a.b.c;

public final class i extends h implements a, b {

    /* renamed from: e  reason: collision with root package name */
    private boolean f21582e = false;

    /* renamed from: f  reason: collision with root package name */
    private final c f21583f = new c();

    public i(Context context) {
        super(context);
        b();
    }

    public static h a(Context context) {
        i iVar = new i(context);
        iVar.onFinishInflate();
        return iVar;
    }

    public void onFinishInflate() {
        if (!this.f21582e) {
            this.f21582e = true;
            inflate(getContext(), R.layout.select_week_layout, this);
            this.f21583f.a((a) this);
        }
        super.onFinishInflate();
    }

    private void b() {
        c a2 = c.a(this.f21583f);
        c.a((b) this);
        c.a(a2);
    }

    public <T extends View> T internalFindViewById(int i) {
        return findViewById(i);
    }

    public void onViewChanged(a aVar) {
        this.f21572a = (RecyclerView) aVar.internalFindViewById(R.id.recycler_view);
        a();
    }
}
