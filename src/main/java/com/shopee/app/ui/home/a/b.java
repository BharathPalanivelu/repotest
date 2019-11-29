package com.shopee.app.ui.home.a;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.shopee.id.R;
import org.a.a.b.a;
import org.a.a.b.c;

public final class b extends a implements a, org.a.a.b.b {

    /* renamed from: d  reason: collision with root package name */
    private boolean f22031d = false;

    /* renamed from: e  reason: collision with root package name */
    private final c f22032e = new c();

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
        if (!this.f22031d) {
            this.f22031d = true;
            inflate(getContext(), R.layout.activity_action_box_layout, this);
            this.f22032e.a((a) this);
        }
        super.onFinishInflate();
    }

    private void a() {
        c a2 = c.a(this.f22032e);
        c.a((org.a.a.b.b) this);
        c.a(a2);
    }

    public <T extends View> T internalFindViewById(int i) {
        return findViewById(i);
    }

    public void onViewChanged(a aVar) {
        this.f22027a = (ImageView) aVar.internalFindViewById(R.id.avatar);
        this.f22028b = (TextView) aVar.internalFindViewById(R.id.text_content);
    }
}
