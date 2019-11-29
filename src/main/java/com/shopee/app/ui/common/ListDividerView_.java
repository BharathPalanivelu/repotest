package com.shopee.app.ui.common;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.shopee.id.R;
import org.a.a.b.a;
import org.a.a.b.b;
import org.a.a.b.c;

public final class ListDividerView_ extends o implements a, b {

    /* renamed from: b  reason: collision with root package name */
    private boolean f20983b = false;

    /* renamed from: c  reason: collision with root package name */
    private final c f20984c = new c();

    public ListDividerView_(Context context) {
        super(context);
        a();
    }

    public ListDividerView_(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public ListDividerView_(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a();
    }

    public void onFinishInflate() {
        if (!this.f20983b) {
            this.f20983b = true;
            inflate(getContext(), R.layout.list_item_divider, this);
            this.f20984c.a((a) this);
        }
        super.onFinishInflate();
    }

    private void a() {
        c a2 = c.a(this.f20984c);
        c.a((b) this);
        c.a(a2);
    }

    public <T extends View> T internalFindViewById(int i) {
        return findViewById(i);
    }

    public void onViewChanged(a aVar) {
        this.f21301a = (TextView) aVar.internalFindViewById(R.id.label);
    }
}
