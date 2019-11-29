package com.shopee.app.ui.chat2;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.shopee.app.ui.common.f;
import com.shopee.id.R;
import org.a.a.b.a;
import org.a.a.b.b;
import org.a.a.b.c;

public final class d extends c implements a, b {
    private boolean k = false;
    private final c l = new c();

    public d(Context context, boolean z) {
        super(context, z);
        b();
    }

    public void onFinishInflate() {
        if (!this.k) {
            this.k = true;
            inflate(getContext(), R.layout.chat_list_item_view, this);
            this.l.a((a) this);
        }
        super.onFinishInflate();
    }

    private void b() {
        c a2 = c.a(this.l);
        Resources resources = getContext().getResources();
        c.a((b) this);
        this.j = resources.getDimensionPixelOffset(R.dimen.font_size_12);
        this.h = androidx.core.content.b.c(getContext(), R.color.black26);
        this.i = androidx.core.content.b.c(getContext(), R.color.black87);
        c.a(a2);
    }

    public <T extends View> T internalFindViewById(int i) {
        return findViewById(i);
    }

    public static c a(Context context, boolean z) {
        d dVar = new d(context, z);
        dVar.onFinishInflate();
        return dVar;
    }

    public void onViewChanged(a aVar) {
        this.f20398a = (ImageView) aVar.internalFindViewById(R.id.avatar);
        this.f20399b = (ImageView) aVar.internalFindViewById(R.id.banned_icon);
        this.f20400c = (TextView) aVar.internalFindViewById(R.id.user_name);
        this.f20401d = (TextView) aVar.internalFindViewById(R.id.text_content);
        this.f20402e = (TextView) aVar.internalFindViewById(R.id.time);
        this.f20403f = (ImageView) aVar.internalFindViewById(R.id.product_image);
        this.f20404g = (f) aVar.internalFindViewById(R.id.badge);
        a();
    }
}
