package com.shopee.app.ui.myaccount.PhoneSettings;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import com.shopee.id.R;
import org.a.a.b.a;
import org.a.a.b.b;
import org.a.a.b.c;

public final class g extends f implements a, b {
    private boolean j = false;
    private final c k = new c();

    public g(Context context) {
        super(context);
        e();
    }

    public static f a(Context context) {
        g gVar = new g(context);
        gVar.onFinishInflate();
        return gVar;
    }

    public void onFinishInflate() {
        if (!this.j) {
            this.j = true;
            inflate(getContext(), R.layout.phone_setting_layout, this);
            this.k.a((a) this);
        }
        super.onFinishInflate();
    }

    private void e() {
        c a2 = c.a(this.k);
        Resources resources = getContext().getResources();
        c.a((b) this);
        this.i = resources.getString(R.string.sp_label_unverified);
        c.a(a2);
    }

    public <T extends View> T internalFindViewById(int i) {
        return findViewById(i);
    }

    public void onViewChanged(a aVar) {
        this.f23256b = (com.shopee.app.ui.setting.cell.a) aVar.internalFindViewById(R.id.phone_settings);
        if (this.f23256b != null) {
            this.f23256b.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    g.this.c();
                }
            });
        }
        a();
    }
}
