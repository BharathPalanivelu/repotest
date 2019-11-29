package com.airpay.paysdk.base.ui.weidget;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.airpay.paysdk.base.d.d;
import com.airpay.paysdk.c;
import java.lang.ref.WeakReference;

public class c {

    /* renamed from: a  reason: collision with root package name */
    protected final View f3918a;

    /* renamed from: b  reason: collision with root package name */
    protected b f3919b;

    /* renamed from: c  reason: collision with root package name */
    protected BPAutoStackPopupActionSection f3920c;

    /* renamed from: d  reason: collision with root package name */
    protected int f3921d = c.i.com_garena_beepay_label_ok;

    /* renamed from: e  reason: collision with root package name */
    protected int f3922e = c.i.com_garena_beepay_label_cancel;

    /* renamed from: f  reason: collision with root package name */
    protected WeakReference<a> f3923f;

    public interface a {
        void onCallBack(boolean z);
    }

    public c(Context context) {
        this.f3918a = LayoutInflater.from(context).inflate(a(), (ViewGroup) null);
        a(context);
    }

    /* access modifiers changed from: protected */
    public int a() {
        return c.h.com_garena_beepay_confirm_popup;
    }

    /* access modifiers changed from: protected */
    public void a(Context context) {
        this.f3920c = (BPAutoStackPopupActionSection) this.f3918a.findViewById(c.f.com_garena_beepay_confirm_popup_btn_control_panel);
    }

    public void a(int i) {
        this.f3921d = i;
    }

    public void b(int i) {
        this.f3922e = i;
    }

    public void a(CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            d.b(this.f3918a, c.f.com_garena_beepay_center_message, 8);
            return;
        }
        d.b(this.f3918a, c.f.com_garena_beepay_center_message, 0);
        d.a(this.f3918a, c.f.com_garena_beepay_center_message, charSequence);
    }

    public void c(int i) {
        d.b(this.f3918a, c.f.com_garena_beepay_center_message, 0);
        d.a(this.f3918a, c.f.com_garena_beepay_center_message, i);
    }

    public void a(a aVar) {
        this.f3923f = new WeakReference<>(aVar);
    }

    public void a(View view) {
        a(view, true);
    }

    public void a(View view, boolean z) {
        this.f3919b = new b(this.f3918a);
        b();
        if (!z) {
            this.f3919b.b();
        }
        this.f3919b.a(view);
    }

    /* access modifiers changed from: protected */
    public void b() {
        BPAutoStackPopupActionSection bPAutoStackPopupActionSection = this.f3920c;
        bPAutoStackPopupActionSection.a(bPAutoStackPopupActionSection.getContext().getString(this.f3921d), true, new View.OnClickListener() {
            public void onClick(View view) {
                c.this.f3919b.a();
                if (c.this.f3923f != null && c.this.f3923f.get() != null) {
                    ((a) c.this.f3923f.get()).onCallBack(false);
                }
            }
        });
        BPAutoStackPopupActionSection bPAutoStackPopupActionSection2 = this.f3920c;
        bPAutoStackPopupActionSection2.a(bPAutoStackPopupActionSection2.getContext().getString(this.f3922e), false, new View.OnClickListener() {
            public void onClick(View view) {
                c.this.f3919b.a();
                if (c.this.f3923f != null && c.this.f3923f.get() != null) {
                    ((a) c.this.f3923f.get()).onCallBack(true);
                }
            }
        });
        this.f3920c.a();
    }
}
