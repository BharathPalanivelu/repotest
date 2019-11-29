package com.shopee.app.ui.actionbox.actionrequired;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.pnikosis.materialishprogress.ProgressWheel;
import com.shopee.id.R;
import org.a.a.b.a;
import org.a.a.b.c;

public final class b extends a implements a, org.a.a.b.b {
    private boolean k = false;
    private final c l = new c();

    public b(Context context) {
        super(context);
        b();
    }

    public static a a(Context context) {
        b bVar = new b(context);
        bVar.onFinishInflate();
        return bVar;
    }

    public void onFinishInflate() {
        if (!this.k) {
            this.k = true;
            inflate(getContext(), R.layout.action_required_item_layout, this);
            this.l.a((a) this);
        }
        super.onFinishInflate();
    }

    private void b() {
        c a2 = c.a(this.l);
        c.a((org.a.a.b.b) this);
        c.a(a2);
    }

    public <T extends View> T internalFindViewById(int i) {
        return findViewById(i);
    }

    public void onViewChanged(a aVar) {
        this.f19340a = (ImageView) aVar.internalFindViewById(R.id.order_images);
        this.f19341b = (ImageView) aVar.internalFindViewById(R.id.image_ext);
        this.f19342c = (TextView) aVar.internalFindViewById(R.id.order_label);
        this.f19343d = (TextView) aVar.internalFindViewById(R.id.order_time);
        this.f19344e = (TextView) aVar.internalFindViewById(R.id.order_content);
        this.f19345f = (c) aVar.internalFindViewById(R.id.rating_panel);
        this.f19346g = aVar.internalFindViewById(R.id.divider);
        this.h = (ImageView) aVar.internalFindViewById(R.id.image_arrow);
        this.i = (ProgressWheel) aVar.internalFindViewById(R.id.action_loading_progress);
        this.j = aVar.internalFindViewById(R.id.right_container);
        a();
    }
}
