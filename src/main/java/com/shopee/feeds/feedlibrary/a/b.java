package com.shopee.feeds.feedlibrary.a;

import android.app.Dialog;
import android.content.Context;
import com.shopee.feeds.feedlibrary.a.b.a;
import com.shopee.feeds.feedlibrary.c;

public class b {

    /* renamed from: a  reason: collision with root package name */
    private Dialog f27324a;

    public b(Context context) {
        this.f27324a = a(context, false);
    }

    private Dialog a(Context context, boolean z) {
        Dialog dialog = new Dialog(context, c.h.LoadingDialog);
        dialog.setCanceledOnTouchOutside(z);
        dialog.setCancelable(true);
        dialog.setContentView(c.f.feeds_loading_layout);
        return dialog;
    }

    public void a(Context context) {
        if (this.f27324a != null && !a.a(context)) {
            try {
                this.f27324a.show();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public void b(Context context) {
        if (!a.a(context)) {
            Dialog dialog = this.f27324a;
            if (dialog != null && dialog.isShowing()) {
                this.f27324a.dismiss();
            }
        }
    }
}
