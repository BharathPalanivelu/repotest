package com.shopee.app.ui.image.editor;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.shopee.id.R;
import org.a.a.b.a;
import org.a.a.b.b;
import org.a.a.b.c;

public final class SubToolMenu_ extends i implements a, b {

    /* renamed from: b  reason: collision with root package name */
    private boolean f22856b = false;

    /* renamed from: c  reason: collision with root package name */
    private final c f22857c = new c();

    public SubToolMenu_(Context context) {
        super(context);
        b();
    }

    public SubToolMenu_(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        b();
    }

    public SubToolMenu_(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        b();
    }

    public void onFinishInflate() {
        if (!this.f22856b) {
            this.f22856b = true;
            inflate(getContext(), R.layout.sub_tool_menu_layout, this);
            this.f22857c.a((a) this);
        }
        super.onFinishInflate();
    }

    private void b() {
        c a2 = c.a(this.f22857c);
        c.a((b) this);
        c.a(a2);
    }

    public <T extends View> T internalFindViewById(int i) {
        return findViewById(i);
    }

    public void onViewChanged(a aVar) {
        this.f22957a = (LinearLayout) aVar.internalFindViewById(R.id.container);
        a();
    }
}
