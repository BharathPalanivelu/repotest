package com.shopee.app.ui.image.editor.c.b;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.shopee.id.R;
import org.a.a.b.a;
import org.a.a.b.b;
import org.a.a.b.c;

public final class d extends c implements a, b {

    /* renamed from: c  reason: collision with root package name */
    private boolean f22911c = false;

    /* renamed from: d  reason: collision with root package name */
    private final c f22912d = new c();

    public d(Context context) {
        super(context);
        b();
    }

    public static c a(Context context) {
        d dVar = new d(context);
        dVar.onFinishInflate();
        return dVar;
    }

    public void onFinishInflate() {
        if (!this.f22911c) {
            this.f22911c = true;
            inflate(getContext(), R.layout.edit_tool_item_layout, this);
            this.f22912d.a((a) this);
        }
        super.onFinishInflate();
    }

    private void b() {
        c a2 = c.a(this.f22912d);
        c.a((b) this);
        c.a(a2);
    }

    public <T extends View> T internalFindViewById(int i) {
        return findViewById(i);
    }

    public void onViewChanged(a aVar) {
        this.f22908a = (ImageView) aVar.internalFindViewById(R.id.icon);
        this.f22909b = (TextView) aVar.internalFindViewById(R.id.text);
        a();
    }
}
