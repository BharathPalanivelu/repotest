package com.airpay.paysdk.pay.ui;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.airpay.paysdk.base.d.d;
import com.airpay.paysdk.base.d.f;
import com.airpay.paysdk.base.ui.weidget.b;
import com.airpay.paysdk.c;
import java.lang.ref.WeakReference;

public class a {

    /* renamed from: a  reason: collision with root package name */
    protected View f4301a;

    /* renamed from: b  reason: collision with root package name */
    b f4302b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public WeakReference<C0083a> f4303c;

    /* renamed from: com.airpay.paysdk.pay.ui.a$a  reason: collision with other inner class name */
    public interface C0083a {
        void a();
    }

    public a(Context context) {
        this.f4301a = LayoutInflater.from(context).inflate(a(), (ViewGroup) null);
        d.a(this.f4301a, c.f.com_garena_beepay_logout_popup_confirm_btn, (View.OnClickListener) new View.OnClickListener() {
            public void onClick(View view) {
                a.this.f4302b.a();
                if (a.this.f4303c != null && a.this.f4303c.get() != null) {
                    ((C0083a) a.this.f4303c.get()).a();
                }
            }
        });
    }

    /* access modifiers changed from: protected */
    public int a() {
        return c.h.com_garena_beepay_no_choice_popup;
    }

    public void a(CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            d.b(this.f4301a, c.f.com_garena_beepay_center_message, 8);
            return;
        }
        d.b(this.f4301a, c.f.com_garena_beepay_center_message, 0);
        d.a(this.f4301a, c.f.com_garena_beepay_center_message, charSequence);
    }

    public void b() {
        View findViewById = this.f4301a.findViewById(c.f.com_garena_beepay_center_message);
        if (findViewById instanceof TextView) {
            f.a((TextView) findViewById);
        }
    }

    public void a(int i) {
        d.b(this.f4301a, c.f.com_garena_beepay_center_message_title, 0);
        d.a(this.f4301a, c.f.com_garena_beepay_center_message_title, i);
    }

    public void a(View view) {
        this.f4302b = new b(this.f4301a);
        this.f4302b.a(view);
    }
}
