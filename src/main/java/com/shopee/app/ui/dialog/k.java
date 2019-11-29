package com.shopee.app.ui.dialog;

import android.content.Context;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.garena.android.appkit.b.e;
import com.garena.android.appkit.b.g;
import com.rengwuxian.materialedittext.MaterialEditText;
import com.shopee.app.data.store.SettingConfigStore;
import com.shopee.app.util.ak;
import com.shopee.app.util.bi;
import com.shopee.app.util.x;
import com.shopee.id.R;

public class k extends RelativeLayout {

    /* renamed from: a  reason: collision with root package name */
    RelativeLayout f21584a;

    /* renamed from: b  reason: collision with root package name */
    TextView f21585b;

    /* renamed from: c  reason: collision with root package name */
    TextView f21586c;

    /* renamed from: d  reason: collision with root package name */
    MaterialEditText f21587d;

    /* renamed from: e  reason: collision with root package name */
    MaterialEditText f21588e;

    /* renamed from: f  reason: collision with root package name */
    Button f21589f;

    /* renamed from: g  reason: collision with root package name */
    bi f21590g;
    ak h;
    SettingConfigStore i;
    TextWatcher j = new TextWatcher() {
        public void afterTextChanged(Editable editable) {
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if (k.this.k != null) {
                k.this.k.a(!TextUtils.isEmpty(k.this.f21587d.getText()) || TextUtils.isEmpty(k.this.f21588e.getText()));
            }
        }
    };
    /* access modifiers changed from: private */
    public a k;
    private e l = new g() {
        public void onEvent(com.garena.android.appkit.b.a aVar) {
            k.this.f21588e.setText((String) aVar.data);
        }
    };

    public interface a {
        void a(boolean z);
    }

    public interface b {
        void a(k kVar);
    }

    public k(Context context) {
        super(context);
        a(context);
    }

    private void a(Context context) {
        ((b) ((x) context).b()).a(this);
    }

    /* access modifiers changed from: package-private */
    public void a() {
        if (!this.i.getConfig(2)) {
            this.f21589f.setVisibility(8);
        }
        this.f21587d.b((com.rengwuxian.materialedittext.a.b) new c(com.garena.android.appkit.tools.b.e(R.string.sp_error_shipping_option)));
        this.f21588e.b((com.rengwuxian.materialedittext.a.b) new c(com.garena.android.appkit.tools.b.e(R.string.sp_error_tracking_number)));
    }

    public void a(String str, String str2, String str3, String str4, String str5, int i2) {
        if (TextUtils.isEmpty(str)) {
            this.f21585b.setVisibility(8);
        } else {
            this.f21585b.setVisibility(0);
            this.f21585b.setText(str);
        }
        this.f21586c.setText(str2);
        this.f21587d.setHint(str4);
        if (!TextUtils.isEmpty(str3)) {
            this.f21587d.setText(str3);
            this.f21587d.setEnabled(false);
        }
        this.f21588e.setHint(str5);
        this.f21584a.setBackgroundResource(i2);
    }

    public String getLogistic() {
        return this.f21587d.getText().toString();
    }

    public boolean b() {
        return this.f21587d.b();
    }

    public String getTrackingCode() {
        return this.f21588e.getText().toString();
    }

    public boolean c() {
        return this.f21588e.b();
    }

    public void setInfoValidCallBack(a aVar) {
        this.k = aVar;
        TextWatcher textWatcher = this.j;
        if (textWatcher != null) {
            this.f21587d.addTextChangedListener(textWatcher);
            this.f21588e.addTextChangedListener(this.j);
        }
    }

    private static class c extends com.rengwuxian.materialedittext.a.b {
        public c(String str) {
            super(str);
        }

        public boolean a(CharSequence charSequence, boolean z) {
            return charSequence.length() <= 100;
        }
    }

    /* access modifiers changed from: package-private */
    public void d() {
        this.h.x();
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f21590g.a("ON_SCANNER_RESULT", this.l);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f21590g.b("ON_SCANNER_RESULT", this.l);
    }
}
