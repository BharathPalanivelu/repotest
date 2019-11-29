package com.shopee.app.ui.actionbar;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.garena.android.appkit.tools.a.b;
import com.shopee.app.ui.actionbar.e;
import com.shopee.id.R;

public class j extends e {
    public j(Context context, e.a aVar) {
        super(context, aVar);
    }

    /* access modifiers changed from: protected */
    public void a(Context context) {
        this.f19298b = View.inflate(context, R.layout.action_drop_down_full_width_layout, (ViewGroup) null);
        this.f19299c = (LinearLayout) this.f19298b.findViewById(R.id.container);
        this.f19297a.setWindowLayoutMode(-1, -2);
        this.f19297a.setContentView(this.f19298b);
        this.f19297a.setFocusable(true);
        this.f19297a.setBackgroundDrawable(new BitmapDrawable());
    }

    /* access modifiers changed from: protected */
    public void b(Context context) {
        int size = this.f19300d.f19301a.size();
        int i = 0;
        for (e.b next : this.f19300d.f19301a) {
            int i2 = next.f19309e;
            next.f19309e = 0;
            f fVar = new f(context);
            fVar.a(next);
            boolean z = true;
            if (i >= size - 1) {
                z = false;
            }
            fVar.setDividerVisibility(z);
            if (i2 != 0) {
                fVar.a(0, 0, i2, 0);
            }
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, b.a.m * 2);
            fVar.setTag(new Pair(Integer.valueOf(next.f19305a), next.f19308d));
            fVar.setOnClickListener(this);
            this.f19299c.addView(fVar, layoutParams);
            i++;
        }
    }
}
