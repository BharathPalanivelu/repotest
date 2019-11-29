package com.shopee.app.ui.myproduct;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import com.garena.android.appkit.floating.FloatingActionsMenu;
import com.shopee.id.R;
import org.a.a.b.a;
import org.a.a.b.b;
import org.a.a.b.c;

public final class f extends e implements a, b {
    private boolean l = false;
    private final c m = new c();

    public f(Context context, int i) {
        super(context, i);
        i();
    }

    public static e a(Context context, int i) {
        f fVar = new f(context, i);
        fVar.onFinishInflate();
        return fVar;
    }

    public void onFinishInflate() {
        if (!this.l) {
            this.l = true;
            inflate(getContext(), R.layout.my_product_view_layout, this);
            this.m.a((a) this);
        }
        super.onFinishInflate();
    }

    private void i() {
        c a2 = c.a(this.m);
        c.a((b) this);
        c.a(a2);
    }

    public <T extends View> T internalFindViewById(int i) {
        return findViewById(i);
    }

    public void onViewChanged(a aVar) {
        this.f23432a = (com.garena.android.uikit.a.c) aVar.internalFindViewById(R.id.tab_view);
        this.f23433b = (FloatingActionsMenu) aVar.internalFindViewById(R.id.floating_menu);
        this.f23434c = aVar.internalFindViewById(R.id.frame);
        this.f23435d = (ImageView) aVar.internalFindViewById(R.id.christmas_theme);
        View internalFindViewById = aVar.internalFindViewById(R.id.action_add_product);
        View internalFindViewById2 = aVar.internalFindViewById(R.id.add_product_gallery);
        View internalFindViewById3 = aVar.internalFindViewById(R.id.add_product_instagram);
        if (internalFindViewById != null) {
            internalFindViewById.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    f.this.e();
                }
            });
        }
        if (internalFindViewById2 != null) {
            internalFindViewById2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    f.this.f();
                }
            });
        }
        if (internalFindViewById3 != null) {
            internalFindViewById3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    f.this.g();
                }
            });
        }
        a();
    }
}
