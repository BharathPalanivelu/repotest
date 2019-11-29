package com.shopee.app.ui.chat2.block;

import android.content.Context;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.shopee.id.R;
import org.a.a.b.a;
import org.a.a.b.b;
import org.a.a.b.c;

public final class m extends l implements a, b {

    /* renamed from: g  reason: collision with root package name */
    private boolean f20347g = false;
    private final c h = new c();

    public m(Context context) {
        super(context);
        b();
    }

    public static l a(Context context) {
        m mVar = new m(context);
        mVar.onFinishInflate();
        return mVar;
    }

    public void onFinishInflate() {
        if (!this.f20347g) {
            this.f20347g = true;
            inflate(getContext(), R.layout.blocked_user_layout, this);
            this.h.a((a) this);
        }
        super.onFinishInflate();
    }

    private void b() {
        c a2 = c.a(this.h);
        c.a((b) this);
        c.a(a2);
    }

    public <T extends View> T internalFindViewById(int i) {
        return findViewById(i);
    }

    public void onViewChanged(a aVar) {
        this.f20340a = (RecyclerView) aVar.internalFindViewById(R.id.blocked_user_list);
        this.f20341b = aVar.internalFindViewById(R.id.emptyView);
        a();
    }
}
