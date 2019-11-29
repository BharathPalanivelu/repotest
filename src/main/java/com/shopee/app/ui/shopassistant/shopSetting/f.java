package com.shopee.app.ui.shopassistant.shopSetting;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.garena.android.appkit.tools.b;
import com.shopee.app.h.q;
import com.shopee.app.ui.actionbar.a;
import com.shopee.app.ui.common.r;
import com.shopee.app.ui.dialog.a;
import com.shopee.app.util.bc;
import com.shopee.app.util.x;
import com.shopee.id.R;
import java.lang.ref.WeakReference;

public class f extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    EditText f25564a;

    /* renamed from: b  reason: collision with root package name */
    Activity f25565b;

    /* renamed from: c  reason: collision with root package name */
    com.shopee.app.ui.actionbar.a f25566c;

    /* renamed from: d  reason: collision with root package name */
    bc f25567d;

    /* renamed from: e  reason: collision with root package name */
    d f25568e;

    /* renamed from: f  reason: collision with root package name */
    r f25569f;

    /* renamed from: g  reason: collision with root package name */
    private String f25570g;
    private a.b h;
    private a.b i = new a.b("SUBMIT_AUTO_REPLY", R.drawable.com_garena_shopee_ic_done) {
        public void a() {
        }
    };

    public f(Context context, String str) {
        super(context);
        ((j) ((x) context).b()).a(this);
        this.f25570g = str;
        Drawable mutate = b.f(R.drawable.com_garena_shopee_ic_done).mutate();
        mutate.setAlpha(76);
        this.h = new a.b("SUBMIT_AUTO_REPLY", mutate) {
            public void a() {
            }
        };
    }

    /* access modifiers changed from: package-private */
    public void a() {
        this.f25567d.a(this.f25568e);
        this.f25568e.a(this);
        this.f25564a.setText(this.f25570g);
        this.f25564a.setFilters(new InputFilter[]{new a(this)});
    }

    public void b() {
        this.f25569f.a();
    }

    public void c() {
        this.f25569f.b();
    }

    public void a(String str) {
        q.a((View) this, str);
    }

    public void d() {
        if (!this.f25570g.equals(this.f25564a.getText().toString())) {
            com.shopee.app.ui.dialog.a.a(getContext(), (int) R.string.sp_edit_profile_discard, (int) R.string.sp_label_no_capital, (int) R.string.sp_label_discard, (a.C0318a) new a.C0318a() {
                public void onNegative() {
                }

                public void onPositive() {
                    f.this.f25565b.setResult(0);
                    f.this.f25565b.finish();
                }
            });
            return;
        }
        this.f25565b.setResult(0);
        this.f25565b.finish();
    }

    public void e() {
        b();
        this.f25568e.a(this.f25564a.getText().toString());
    }

    public void f() {
        String obj = this.f25564a.getText().toString();
        if (!this.f25570g.equals(obj) && !TextUtils.isEmpty(obj)) {
            Intent intent = new Intent();
            intent.putExtra("AUTO_REPLY", this.f25564a.getText().toString());
            this.f25565b.setResult(-1, intent);
            this.f25565b.finish();
        }
    }

    /* access modifiers changed from: package-private */
    public void a(TextView textView) {
        g();
    }

    private void g() {
        String obj = this.f25564a.getText().toString();
        if (this.f25570g.equals(obj) || TextUtils.isEmpty(obj)) {
            this.f25566c.c();
            this.f25566c.a(this.h);
            return;
        }
        this.f25566c.c();
        this.f25566c.a(this.i);
    }

    private static class a implements InputFilter {

        /* renamed from: a  reason: collision with root package name */
        private final int f25574a = 500;

        /* renamed from: b  reason: collision with root package name */
        private final WeakReference<View> f25575b;

        /* renamed from: c  reason: collision with root package name */
        private int f25576c = 0;

        public a(View view) {
            this.f25575b = new WeakReference<>(view);
        }

        public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
            int length = 500 - (spanned.length() - (i4 - i3));
            if (length <= 0) {
                if (a()) {
                    q.a((View) this.f25575b.get(), (int) R.string.auto_reply_length_exceeds);
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
                    q.a((View) this.f25575b.get(), (int) R.string.auto_reply_length_exceeds);
                }
                return charSequence.subSequence(i, i5);
            }
        }

        private boolean a() {
            if (com.garena.android.appkit.tools.a.a.a() - this.f25576c <= 2) {
                return false;
            }
            this.f25576c = com.garena.android.appkit.tools.a.a.a();
            return true;
        }
    }
}
