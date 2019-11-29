package com.shopee.app.ui.chat.cell;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.shopee.id.R;
import org.a.a.b.a;
import org.a.a.b.b;
import org.a.a.b.c;

public final class f extends e implements a, b {

    /* renamed from: f  reason: collision with root package name */
    private boolean f20088f = false;

    /* renamed from: g  reason: collision with root package name */
    private final c f20089g = new c();

    public f(Context context) {
        super(context);
        b();
    }

    public static e a(Context context) {
        f fVar = new f(context);
        fVar.onFinishInflate();
        return fVar;
    }

    public void onFinishInflate() {
        if (!this.f20088f) {
            this.f20088f = true;
            inflate(getContext(), R.layout.chat_first_hint_item_layout, this);
            this.f20089g.a((a) this);
        }
        super.onFinishInflate();
    }

    private void b() {
        c a2 = c.a(this.f20089g);
        c.a((b) this);
        this.f20083a = androidx.core.content.b.c(getContext(), R.color.white);
        this.f20084b = androidx.core.content.b.c(getContext(), R.color.black87);
        c.a(a2);
    }

    public <T extends View> T internalFindViewById(int i) {
        return findViewById(i);
    }

    public void onViewChanged(a aVar) {
        this.f20085c = (TextView) aVar.internalFindViewById(R.id.label);
        this.f20086d = (ImageView) aVar.internalFindViewById(R.id.icon);
        this.f20087e = aVar.internalFindViewById(R.id.space_view);
        a();
    }
}
