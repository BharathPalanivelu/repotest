package com.shopee.app.ui.product.a;

import android.app.Dialog;
import android.content.Context;
import android.widget.RelativeLayout;
import com.shopee.app.util.ak;
import com.shopee.app.util.x;

public class a extends RelativeLayout {

    /* renamed from: a  reason: collision with root package name */
    ak f23935a;

    /* renamed from: b  reason: collision with root package name */
    private final String f23936b;

    /* renamed from: c  reason: collision with root package name */
    private Dialog f23937c;

    /* renamed from: com.shopee.app.ui.product.a.a$a  reason: collision with other inner class name */
    public interface C0372a {
        void a(a aVar);
    }

    public a(Context context, String str) {
        super(context);
        this.f23936b = str;
        ((C0372a) ((x) context).b()).a(this);
    }

    public void setDialog(Dialog dialog) {
        this.f23937c = dialog;
    }

    /* access modifiers changed from: package-private */
    public void a() {
        Dialog dialog = this.f23937c;
        if (dialog != null) {
            dialog.dismiss();
        }
        this.f23935a.v(this.f23936b);
    }

    /* access modifiers changed from: package-private */
    public void b() {
        Dialog dialog = this.f23937c;
        if (dialog != null) {
            dialog.dismiss();
        }
    }
}
