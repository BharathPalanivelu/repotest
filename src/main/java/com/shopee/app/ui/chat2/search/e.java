package com.shopee.app.ui.chat2.search;

import android.content.Context;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.pnikosis.materialishprogress.ProgressWheel;
import com.shopee.id.R;
import org.a.a.b.a;
import org.a.a.b.b;
import org.a.a.b.c;

public final class e extends d implements a, b {
    private boolean l = false;
    private final c m = new c();

    public e(Context context, String str) {
        super(context, str);
        i();
    }

    public void onFinishInflate() {
        if (!this.l) {
            this.l = true;
            inflate(getContext(), R.layout.chat_list_view, this);
            this.m.a((a) this);
        }
        super.onFinishInflate();
    }

    private void i() {
        c a2 = c.a(this.m);
        c.a((b) this);
        c.a(a2);
    }

    public <T extends View> T internalFindViewById(int i) {
        return findViewById(i);
    }

    public static d a(Context context, String str) {
        e eVar = new e(context, str);
        eVar.onFinishInflate();
        return eVar;
    }

    public void onViewChanged(a aVar) {
        this.f20895a = (RecyclerView) aVar.internalFindViewById(R.id.listView);
        this.f20896b = aVar.internalFindViewById(R.id.emptyView);
        this.f20897c = (ProgressWheel) aVar.internalFindViewById(R.id.progress_wheel);
        this.f20899e = (com.shopee.app.ui.common.b) aVar.internalFindViewById(R.id.ask_login_view);
        a();
    }
}
