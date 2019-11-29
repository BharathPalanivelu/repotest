package com.shopee.app.ui.auth.password;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import com.rengwuxian.materialedittext.MaterialEditText;
import com.shopee.id.R;
import org.a.a.b.a;
import org.a.a.b.b;
import org.a.a.b.c;

public final class w extends v implements a, b {
    private boolean k = false;
    private final c l = new c();

    public w(Context context, String str, String str2, String str3) {
        super(context, str, str2, str3);
        e();
    }

    public static v a(Context context, String str, String str2, String str3) {
        w wVar = new w(context, str, str2, str3);
        wVar.onFinishInflate();
        return wVar;
    }

    public void onFinishInflate() {
        if (!this.k) {
            this.k = true;
            inflate(getContext(), R.layout.set_new_password_view_layout, this);
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

    public void onViewChanged(a aVar) {
        this.f19663a = (MaterialEditText) aVar.internalFindViewById(R.id.new_password);
        this.f19664b = (MaterialEditText) aVar.internalFindViewById(R.id.phone_number);
        this.f19665c = (MaterialEditText) aVar.internalFindViewById(R.id.new_password_confirm);
        this.f19666d = (Button) aVar.internalFindViewById(R.id.reset_btn);
        if (this.f19666d != null) {
            this.f19666d.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    w.this.b();
                }
            });
        }
        a();
    }
}
