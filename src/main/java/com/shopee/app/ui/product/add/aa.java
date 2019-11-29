package com.shopee.app.ui.product.add;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.ListView;
import com.shopee.id.R;
import org.a.a.b.a;
import org.a.a.b.b;
import org.a.a.b.c;

public final class aa extends z implements a, b {
    private boolean h = false;
    private final c i = new c();

    public aa(Context context, String str) {
        super(context, str);
        b();
    }

    public static z a(Context context, String str) {
        aa aaVar = new aa(context, str);
        aaVar.onFinishInflate();
        return aaVar;
    }

    public void onFinishInflate() {
        if (!this.h) {
            this.h = true;
            inflate(getContext(), R.layout.facebook_page_view, this);
            this.i.a((a) this);
        }
        super.onFinishInflate();
    }

    private void b() {
        c a2 = c.a(this.i);
        Resources resources = getContext().getResources();
        c.a((b) this);
        this.f24233g = resources.getDimensionPixelSize(R.dimen.dp48);
        c.a(a2);
    }

    public <T extends View> T internalFindViewById(int i2) {
        return findViewById(i2);
    }

    public void onViewChanged(a aVar) {
        this.f24227a = (ListView) aVar.internalFindViewById(R.id.page_list);
        a();
    }
}
