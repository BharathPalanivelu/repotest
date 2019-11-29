package com.shopee.app.ui.image.editor.c.b;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.shopee.id.R;
import org.a.a.b.a;
import org.a.a.b.c;

public final class b extends a implements a, org.a.a.b.b {

    /* renamed from: c  reason: collision with root package name */
    private boolean f22906c = false;

    /* renamed from: d  reason: collision with root package name */
    private final c f22907d = new c();

    public b(Context context) {
        super(context);
        a();
    }

    public static a a(Context context) {
        b bVar = new b(context);
        bVar.onFinishInflate();
        return bVar;
    }

    public void onFinishInflate() {
        if (!this.f22906c) {
            this.f22906c = true;
            inflate(getContext(), R.layout.preset_item_layout, this);
            this.f22907d.a((a) this);
        }
        super.onFinishInflate();
    }

    private void a() {
        c a2 = c.a(this.f22907d);
        c.a((org.a.a.b.b) this);
        c.a(a2);
    }

    public <T extends View> T internalFindViewById(int i) {
        return findViewById(i);
    }

    public void onViewChanged(a aVar) {
        this.f22903a = (ImageView) aVar.internalFindViewById(R.id.icon);
        this.f22904b = (TextView) aVar.internalFindViewById(R.id.text);
    }
}
