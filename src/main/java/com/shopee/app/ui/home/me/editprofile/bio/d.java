package com.shopee.app.ui.home.me.editprofile.bio;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.garena.android.appkit.tools.a.b;
import com.shopee.app.h.q;
import com.shopee.app.ui.common.RobotoClearableEditText;
import com.shopee.app.ui.common.r;
import com.shopee.app.ui.dialog.a;
import com.shopee.app.util.ak;
import com.shopee.app.util.bc;
import com.shopee.app.util.x;
import com.shopee.id.R;
import java.lang.ref.WeakReference;

public class d extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    RobotoClearableEditText f22339a;

    /* renamed from: b  reason: collision with root package name */
    TextView f22340b;

    /* renamed from: c  reason: collision with root package name */
    r f22341c;

    /* renamed from: d  reason: collision with root package name */
    bc f22342d;

    /* renamed from: e  reason: collision with root package name */
    b f22343e;

    /* renamed from: f  reason: collision with root package name */
    Activity f22344f;

    /* renamed from: g  reason: collision with root package name */
    ak f22345g;
    private final String h;
    private final int i;
    /* access modifiers changed from: private */
    public final int j;
    private final int k;
    private final int l;

    public interface a {
        void a(d dVar);
    }

    public d(Context context, String str, int i2, int i3, int i4, int i5) {
        super(context);
        this.j = i2;
        this.h = str;
        this.i = i3;
        this.k = i5;
        this.l = i4;
        a(context);
    }

    private void a(Context context) {
        ((a) ((x) context).b()).a(this);
    }

    /* access modifiers changed from: package-private */
    public void a() {
        this.f22342d.a(this.f22343e);
        this.f22343e.a(this);
        e();
        this.f22339a.setText(this.h);
        this.f22339a.setSelection(this.h.length());
        this.f22339a.setFilters(new InputFilter[]{new b(this)});
        com.shopee.app.c.a.b(this.f22339a);
    }

    private void e() {
        if (this.k == 0) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f22339a.getLayoutParams();
            layoutParams.height = -1;
            this.f22339a.setLayoutParams(layoutParams);
            this.f22340b.setVisibility(8);
            return;
        }
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.f22339a.getLayoutParams();
        layoutParams2.topMargin = b.a.h;
        this.f22339a.setLayoutParams(layoutParams2);
        this.f22339a.setClearButtonEnabled(true);
        this.f22340b.setVisibility(0);
        this.f22340b.setText(getContext().getString(this.l, new Object[]{Integer.valueOf(this.j)}));
    }

    public void b() {
        String obj = this.f22339a.getText().toString();
        if (TextUtils.isEmpty(obj) || TextUtils.isEmpty(obj.trim())) {
            c();
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("TEXT_DATA", obj.trim());
        this.f22344f.setResult(-1, intent);
        this.f22344f.finish();
    }

    public void c() {
        q.a((View) this, com.garena.android.appkit.tools.b.a(this.i, Integer.valueOf(this.j)));
    }

    public void d() {
        if (!this.h.equals(this.f22339a.getText().toString())) {
            com.shopee.app.ui.dialog.a.a(getContext(), (int) R.string.sp_edit_profile_discard, (int) R.string.sp_label_no_capital, (int) R.string.sp_label_discard, (a.C0318a) new a.C0318a() {
                public void onNegative() {
                }

                public void onPositive() {
                    d.this.f22344f.setResult(0);
                    d.this.f22344f.finish();
                }
            });
            return;
        }
        this.f22344f.setResult(0);
        this.f22344f.finish();
    }

    private class b implements InputFilter {

        /* renamed from: b  reason: collision with root package name */
        private final WeakReference<View> f22348b;

        /* renamed from: c  reason: collision with root package name */
        private int f22349c = 0;

        /* renamed from: d  reason: collision with root package name */
        private int f22350d = 0;

        public b(View view) {
            this.f22348b = new WeakReference<>(view);
        }

        public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
            int a2 = d.this.j - (spanned.length() - (i4 - i3));
            if (a2 <= 0) {
                if (a(i2 - i)) {
                    d.this.c();
                }
                return "";
            } else if (a2 >= i2 - i) {
                a();
                return null;
            } else {
                int i5 = a2 + i;
                if (Character.isHighSurrogate(charSequence.charAt(i5 - 1))) {
                    i5--;
                    if (i5 == i) {
                        return "";
                    }
                }
                if (a(i5 - i)) {
                    d.this.c();
                }
                return charSequence.subSequence(i, i5);
            }
        }

        private void a() {
            this.f22350d = 0;
        }

        private boolean a(int i) {
            int i2 = this.f22350d;
            this.f22350d = i;
            if (com.garena.android.appkit.tools.a.a.a() - this.f22349c <= 2 || i - i2 <= 0) {
                return false;
            }
            this.f22349c = com.garena.android.appkit.tools.a.a.a();
            return true;
        }
    }
}
