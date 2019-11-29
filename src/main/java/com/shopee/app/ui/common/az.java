package com.shopee.app.ui.common;

import android.content.Context;
import android.view.View;
import android.widget.ImageButton;
import com.google.a.l;
import com.shopee.app.web.protocol.SearchConfig;
import com.shopee.id.R;
import org.a.a.b.a;
import org.a.a.b.b;
import org.a.a.b.c;

public final class az extends ay implements a, b {

    /* renamed from: f  reason: collision with root package name */
    private boolean f21222f = false;

    /* renamed from: g  reason: collision with root package name */
    private final c f21223g = new c();

    public az(Context context, l lVar, l lVar2, l lVar3, SearchConfig searchConfig, int i, boolean z) {
        super(context, lVar, lVar2, lVar3, searchConfig, i, z);
        k();
    }

    public static ay a(Context context, l lVar, l lVar2, l lVar3, SearchConfig searchConfig, int i, boolean z) {
        az azVar = new az(context, lVar, lVar2, lVar3, searchConfig, i, z);
        azVar.onFinishInflate();
        return azVar;
    }

    public void onFinishInflate() {
        if (!this.f21222f) {
            this.f21222f = true;
            inflate(getContext(), R.layout.webpage_tab_view_layout, this);
            this.f21223g.a((a) this);
        }
        super.onFinishInflate();
    }

    private void k() {
        c a2 = c.a(this.f21223g);
        c.a((b) this);
        c.a(a2);
    }

    public <T extends View> T internalFindViewById(int i) {
        return findViewById(i);
    }

    public void onViewChanged(a aVar) {
        this.f21209a = (com.garena.android.uikit.a.c) aVar.internalFindViewById(R.id.tab_view);
        this.f21210b = (ImageButton) aVar.internalFindViewById(R.id.tab_right_button);
        i();
    }
}
