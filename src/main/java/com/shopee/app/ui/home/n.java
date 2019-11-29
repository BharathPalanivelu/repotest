package com.shopee.app.ui.home;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import com.shopee.app.ui.home.bottom.BottomNavView;
import com.shopee.id.R;
import org.a.a.b.a;
import org.a.a.b.b;
import org.a.a.b.c;

public final class n extends m implements a, b {
    private boolean C = false;
    private final c D = new c();

    public n(Context context, int i) {
        super(context, i);
        r();
    }

    public static m a(Context context, int i) {
        n nVar = new n(context, i);
        nVar.onFinishInflate();
        return nVar;
    }

    public void onFinishInflate() {
        if (!this.C) {
            this.C = true;
            inflate(getContext(), R.layout.sp_home_view, this);
            this.D.a((a) this);
        }
        super.onFinishInflate();
    }

    private void r() {
        c a2 = c.a(this.D);
        c.a((b) this);
        c.a(a2);
    }

    public <T extends View> T internalFindViewById(int i) {
        return findViewById(i);
    }

    public void onViewChanged(a aVar) {
        this.f22268a = (com.garena.android.uikit.a.c) aVar.internalFindViewById(R.id.sp_home_tab_view);
        this.f22269b = (BottomNavView) aVar.internalFindViewById(R.id.sp_bottom_navigation_layout);
        this.f22270c = aVar.internalFindViewById(R.id.frame);
        this.f22271d = (ImageView) aVar.internalFindViewById(R.id.floating_menu);
        if (this.f22271d != null) {
            this.f22271d.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    n.this.o();
                }
            });
        }
        a();
    }
}
