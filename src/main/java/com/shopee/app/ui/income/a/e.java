package com.shopee.app.ui.income.a;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.shopee.id.R;
import org.a.a.b.a;
import org.a.a.b.b;
import org.a.a.b.c;

public final class e extends d implements a, b {
    private boolean j = false;
    private final c k = new c();

    public e(Context context, int i) {
        super(context, i);
        b();
    }

    public static d a(Context context, int i) {
        e eVar = new e(context, i);
        eVar.onFinishInflate();
        return eVar;
    }

    public void onFinishInflate() {
        if (!this.j) {
            this.j = true;
            inflate(getContext(), R.layout.income_item_layout, this);
            this.k.a((a) this);
        }
        super.onFinishInflate();
    }

    private void b() {
        c a2 = c.a(this.k);
        c.a((b) this);
        this.f23113g = androidx.core.content.b.c(getContext(), R.color.black54);
        this.h = androidx.core.content.b.c(getContext(), R.color.black87);
        this.i = androidx.core.content.b.c(getContext(), R.color.primary);
        c.a(a2);
    }

    public <T extends View> T internalFindViewById(int i) {
        return findViewById(i);
    }

    public void onViewChanged(a aVar) {
        this.f23107a = (ImageView) aVar.internalFindViewById(R.id.icon);
        this.f23108b = (TextView) aVar.internalFindViewById(R.id.title);
        this.f23109c = (TextView) aVar.internalFindViewById(R.id.username);
        this.f23110d = (TextView) aVar.internalFindViewById(R.id.extra_info);
        this.f23111e = (TextView) aVar.internalFindViewById(R.id.payment_status);
        this.f23112f = (TextView) aVar.internalFindViewById(R.id.price);
        a();
    }
}
