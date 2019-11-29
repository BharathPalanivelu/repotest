package com.shopee.app.ui.dialog;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.rengwuxian.materialedittext.MaterialEditText;
import com.shopee.id.R;
import org.a.a.b.a;
import org.a.a.b.b;
import org.a.a.b.c;

public final class l extends k implements a, b {
    private boolean k = false;
    private final c l = new c();

    public l(Context context) {
        super(context);
        e();
    }

    public void onFinishInflate() {
        if (!this.k) {
            this.k = true;
            inflate(getContext(), R.layout.shipping_info_view_layout, this);
            this.l.a((a) this);
        }
        super.onFinishInflate();
    }

    private void e() {
        c a2 = c.a(this.l);
        c.a((b) this);
        c.a(a2);
    }

    public <T extends View> T internalFindViewById(int i) {
        return findViewById(i);
    }

    public static k a(Context context) {
        l lVar = new l(context);
        lVar.onFinishInflate();
        return lVar;
    }

    public void onViewChanged(a aVar) {
        this.f21584a = (RelativeLayout) aVar.internalFindViewById(R.id.ship_info_section);
        this.f21585b = (TextView) aVar.internalFindViewById(R.id.head_title);
        this.f21586c = (TextView) aVar.internalFindViewById(R.id.ship_title);
        this.f21587d = (MaterialEditText) aVar.internalFindViewById(R.id.logistic);
        this.f21588e = (MaterialEditText) aVar.internalFindViewById(R.id.tracking_code);
        this.f21589f = (Button) aVar.internalFindViewById(R.id.scan_btn);
        if (this.f21589f != null) {
            this.f21589f.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    l.this.d();
                }
            });
        }
        a();
    }
}
