package com.shopee.arcatch.page.view;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.shopee.arcatch.a;

public class c extends Dialog {
    public c(Context context, int i) {
        super(context, i);
    }

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private Context f27062a;

        /* renamed from: b  reason: collision with root package name */
        private String f27063b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f27064c = true;

        /* renamed from: d  reason: collision with root package name */
        private boolean f27065d = false;

        /* renamed from: e  reason: collision with root package name */
        private boolean f27066e = false;

        public a(Context context) {
            this.f27062a = context;
        }

        public a a(boolean z) {
            this.f27064c = z;
            return this;
        }

        public c a() {
            View inflate = LayoutInflater.from(this.f27062a).inflate(a.d.arcatch_dialog_loading, (ViewGroup) null);
            c cVar = new c(this.f27062a, a.e.LoadingDialogStyle);
            TextView textView = (TextView) inflate.findViewById(a.c.tipTextView);
            if (this.f27064c) {
                textView.setText(this.f27063b);
            } else {
                textView.setVisibility(8);
            }
            cVar.setContentView(inflate);
            cVar.setCancelable(this.f27065d);
            cVar.setCanceledOnTouchOutside(this.f27066e);
            return cVar;
        }
    }
}
