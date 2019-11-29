package com.shopee.app.ui.chat2;

import android.app.Activity;
import android.content.Context;
import android.text.InputFilter;
import android.text.Spanned;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import com.shopee.app.h.q;
import com.shopee.app.ui.actionbar.a;
import com.shopee.app.ui.common.r;
import com.shopee.app.ui.dialog.a;
import com.shopee.app.util.ak;
import com.shopee.app.util.bc;
import com.shopee.app.util.x;
import com.shopee.id.R;
import java.lang.ref.WeakReference;

public class y extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    EditText f20958a;

    /* renamed from: b  reason: collision with root package name */
    r f20959b;

    /* renamed from: c  reason: collision with root package name */
    bc f20960c;

    /* renamed from: d  reason: collision with root package name */
    w f20961d;

    /* renamed from: e  reason: collision with root package name */
    Activity f20962e;

    /* renamed from: f  reason: collision with root package name */
    ak f20963f;

    /* renamed from: g  reason: collision with root package name */
    private final int f20964g;
    private final String h;
    private a.b i = new a.b("SUBMIT_AUTO_REPLY", R.drawable.com_garena_shopee_ic_done) {
        public void a() {
        }
    };

    public interface a {
        void a(y yVar);
    }

    public y(Context context, int i2, String str) {
        super(context);
        this.f20964g = i2;
        this.h = str;
        a(context);
    }

    private void a(Context context) {
        ((a) ((x) context).b()).a(this);
    }

    /* access modifiers changed from: package-private */
    public void a() {
        this.f20960c.a(this.f20961d);
        this.f20961d.a(this);
        this.f20958a.setText(this.h);
        this.f20958a.setSelection(this.h.length());
        this.f20958a.setFilters(new InputFilter[]{new b(this)});
        com.shopee.app.c.a.b(this.f20958a);
    }

    public void b() {
        this.f20959b.a();
    }

    public void c() {
        this.f20959b.b();
    }

    public void d() {
        String trim = this.f20958a.getText().toString().trim();
        if (trim.length() <= 0 || trim.length() > 500) {
            a(com.garena.android.appkit.tools.b.e(R.string.sp_err_edit_message_shortcuts));
            return;
        }
        int i2 = this.f20964g;
        if (i2 == -1) {
            this.f20961d.a(trim);
        } else {
            this.f20961d.a(i2, trim);
        }
    }

    public void a(String str) {
        q.a((View) this, str);
    }

    /* access modifiers changed from: package-private */
    public void e() {
        d();
    }

    public void f() {
        if (!this.h.equals(this.f20958a.getText().toString())) {
            com.shopee.app.ui.dialog.a.a(getContext(), (int) R.string.sp_edit_profile_discard, (int) R.string.sp_label_no_capital, (int) R.string.sp_label_discard, (a.C0318a) new a.C0318a() {
                public void onNegative() {
                }

                public void onPositive() {
                    y.this.f20962e.setResult(0);
                    y.this.f20962e.finish();
                }
            });
            return;
        }
        this.f20962e.setResult(0);
        this.f20962e.finish();
    }

    public void g() {
        this.f20961d.a(this.f20964g);
    }

    public void h() {
        this.f20962e.setResult(-1);
        this.f20962e.finish();
    }

    public void i() {
        this.f20963f.w();
    }

    private static class b implements InputFilter {

        /* renamed from: a  reason: collision with root package name */
        private final int f20967a = 500;

        /* renamed from: b  reason: collision with root package name */
        private final WeakReference<View> f20968b;

        /* renamed from: c  reason: collision with root package name */
        private int f20969c = 0;

        public b(View view) {
            this.f20968b = new WeakReference<>(view);
        }

        public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
            int length = 500 - (spanned.length() - (i4 - i3));
            if (length <= 0) {
                if (a()) {
                    q.a((View) this.f20968b.get(), (int) R.string.sp_err_edit_message_shortcuts);
                }
                return "";
            } else if (length >= i2 - i) {
                return null;
            } else {
                int i5 = length + i;
                if (Character.isHighSurrogate(charSequence.charAt(i5 - 1))) {
                    i5--;
                    if (i5 == i) {
                        return "";
                    }
                }
                if (a()) {
                    q.a((View) this.f20968b.get(), (int) R.string.sp_err_edit_message_shortcuts);
                }
                return charSequence.subSequence(i, i5);
            }
        }

        private boolean a() {
            if (com.garena.android.appkit.tools.a.a.a() - this.f20969c <= 2) {
                return false;
            }
            this.f20969c = com.garena.android.appkit.tools.a.a.a();
            return true;
        }
    }
}
