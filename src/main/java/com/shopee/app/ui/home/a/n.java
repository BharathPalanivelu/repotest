package com.shopee.app.ui.home.a;

import android.content.Context;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.shopee.id.R;
import org.a.a.b.a;
import org.a.a.b.b;
import org.a.a.b.c;

public final class n extends m implements a, b {
    private boolean n = false;
    private final c o = new c();

    public n(Context context, int i) {
        super(context, i);
        n();
    }

    public static m a(Context context, int i) {
        n nVar = new n(context, i);
        nVar.onFinishInflate();
        return nVar;
    }

    public void onFinishInflate() {
        if (!this.n) {
            this.n = true;
            inflate(getContext(), R.layout.activity_tab_layout, this);
            this.o.a((a) this);
        }
        super.onFinishInflate();
    }

    private void n() {
        c a2 = c.a(this.o);
        c.a((b) this);
        c.a(a2);
    }

    public <T extends View> T internalFindViewById(int i) {
        return findViewById(i);
    }

    public void onViewChanged(a aVar) {
        this.f22079a = (RecyclerView) aVar.internalFindViewById(R.id.activity_list);
        this.f22080b = (com.shopee.app.ui.common.b) aVar.internalFindViewById(R.id.ask_login_view);
        this.f22081c = aVar.internalFindViewById(R.id.progress_wheel);
        d();
    }
}
