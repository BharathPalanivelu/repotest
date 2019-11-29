package com.shopee.app.ui.chat2;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.shopee.id.R;
import org.a.a.b.a;
import org.a.a.b.b;
import org.a.a.b.c;

public final class h extends g implements a, b {
    private boolean m = false;
    private final c n = new c();

    public h(Context context, int i) {
        super(context, i);
        g();
    }

    public static g a(Context context, int i) {
        h hVar = new h(context, i);
        hVar.onFinishInflate();
        return hVar;
    }

    public void onFinishInflate() {
        if (!this.m) {
            this.m = true;
            inflate(getContext(), R.layout.chat_list_view, this);
            this.n.a((a) this);
        }
        super.onFinishInflate();
    }

    private void g() {
        c a2 = c.a(this.n);
        c.a((b) this);
        c.a(a2);
    }

    public <T extends View> T internalFindViewById(int i) {
        return findViewById(i);
    }

    public void onViewChanged(a aVar) {
        this.f20431a = (RecyclerView) aVar.internalFindViewById(R.id.listView);
        this.f20432b = aVar.internalFindViewById(R.id.emptyView);
        this.f20434d = (com.shopee.app.ui.common.b) aVar.internalFindViewById(R.id.ask_login_view);
        this.f20435e = (TextView) aVar.internalFindViewById(R.id.label);
        a();
    }
}
