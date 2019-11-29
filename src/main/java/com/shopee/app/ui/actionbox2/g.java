package com.shopee.app.ui.actionbox2;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.shopee.id.R;
import org.a.a.b.a;
import org.a.a.b.b;
import org.a.a.b.c;

public final class g extends f implements a, b {
    private boolean x = false;
    private final c y = new c();

    public g(Context context, int i) {
        super(context, i);
        o();
    }

    public static f a(Context context, int i) {
        g gVar = new g(context, i);
        gVar.onFinishInflate();
        return gVar;
    }

    public void onFinishInflate() {
        if (!this.x) {
            this.x = true;
            inflate(getContext(), R.layout.new_action_box_layout, this);
            this.y.a((a) this);
        }
        super.onFinishInflate();
    }

    private void o() {
        c a2 = c.a(this.y);
        c.a((b) this);
        c.a(a2);
    }

    public <T extends View> T internalFindViewById(int i) {
        return findViewById(i);
    }

    public void onViewChanged(a aVar) {
        this.f19417a = (RecyclerView) aVar.internalFindViewById(R.id.action_required_list);
        this.f19418b = (com.shopee.app.ui.common.b) aVar.internalFindViewById(R.id.ask_login_view);
        this.f19419c = aVar.internalFindViewById(R.id.progress_wheel);
        this.f19420d = aVar.internalFindViewById(R.id.emptyView);
        this.f19421e = (TextView) aVar.internalFindViewById(R.id.label);
        this.f19422f = (ImageView) aVar.internalFindViewById(R.id.circle_icon);
        d();
    }
}
