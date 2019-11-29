package com.shopee.app.ui.actionbar;

import android.app.Activity;
import android.content.Context;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.garena.android.appkit.b.e;
import com.garena.android.appkit.b.g;
import com.shopee.app.ui.a.q;
import com.shopee.app.util.ak;
import com.shopee.app.util.bc;
import com.shopee.app.util.bi;
import com.shopee.app.util.s;
import com.shopee.app.util.x;

public class k extends FrameLayout implements TextWatcher, TextView.OnEditorActionListener {

    /* renamed from: a  reason: collision with root package name */
    ImageButton f19316a;

    /* renamed from: b  reason: collision with root package name */
    ImageButton f19317b;

    /* renamed from: c  reason: collision with root package name */
    EditText f19318c;

    /* renamed from: d  reason: collision with root package name */
    ProgressBar f19319d;

    /* renamed from: e  reason: collision with root package name */
    bi f19320e;

    /* renamed from: f  reason: collision with root package name */
    bc f19321f;

    /* renamed from: g  reason: collision with root package name */
    b f19322g;
    ak h;
    s i;
    boolean j = false;
    private String k = "";

    public interface a {
        void a(k kVar);
    }

    public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
    }

    public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
    }

    public k(Context context) {
        super(context);
        a(context);
    }

    public k(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    public k(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a(context);
    }

    private void a(Context context) {
        ((a) ((x) context).b()).a(this);
    }

    /* access modifiers changed from: package-private */
    public void a() {
        this.f19321f.a(this.f19322g);
        this.f19322g.a(this);
        this.f19318c.addTextChangedListener(this);
        this.f19318c.setOnEditorActionListener(this);
    }

    public void b() {
        this.f19318c.requestFocus();
        ((InputMethodManager) getContext().getSystemService("input_method")).showSoftInput(this.f19318c, 1);
    }

    public String getText() {
        return this.f19318c.getText().toString();
    }

    public void setText(String str) {
        this.f19318c.setText(str);
        EditText editText = this.f19318c;
        editText.setSelection(editText.getText().length());
    }

    public void setTextColor(int i2) {
        this.f19318c.setTextColor(i2);
    }

    private void a(CharSequence charSequence) {
        if (charSequence != null && !this.k.equals(charSequence.toString())) {
            this.k = charSequence.toString();
            this.f19320e.a("SEARCH_TEXT_CHANGED", new com.garena.android.appkit.b.a(this.k));
        }
    }

    private void b(CharSequence charSequence) {
        if (charSequence != null) {
            this.k = charSequence.toString();
            g();
            this.f19320e.a("SEARCH_TEXT_DONE", new com.garena.android.appkit.b.a(charSequence.toString()));
        }
    }

    public void afterTextChanged(Editable editable) {
        if (editable != null) {
            a((CharSequence) editable);
            if (editable.length() == 0) {
                if (this.j) {
                    this.f19317b.setVisibility(0);
                }
                this.f19316a.setVisibility(8);
                return;
            }
            if (this.j) {
                this.f19317b.setVisibility(8);
            }
            this.f19316a.setVisibility(0);
        }
    }

    public boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
        if (i2 != 3 && i2 != 6) {
            return false;
        }
        b(textView.getText());
        return true;
    }

    /* access modifiers changed from: package-private */
    public void c() {
        boolean isEmpty = TextUtils.isEmpty(this.f19318c.getText());
        this.k = "";
        this.f19318c.setText((CharSequence) null);
        if (isEmpty) {
            g();
            this.f19320e.a("SEARCH_TEXT_CANCELLED", new com.garena.android.appkit.b.a());
            return;
        }
        this.f19320e.a("SEARCH_TEXT_CHANGED", new com.garena.android.appkit.b.a(""));
    }

    /* access modifiers changed from: package-private */
    public void d() {
        Activity activity = (Activity) getContext();
        activity.setResult(2);
        activity.finish();
    }

    private void g() {
        ((InputMethodManager) getContext().getSystemService("input_method")).hideSoftInputFromWindow(getWindowToken(), 0);
    }

    public void e() {
        this.f19319d.setVisibility(0);
    }

    public void f() {
        this.f19319d.setVisibility(8);
    }

    public void setSearchPlaceHolder(String str) {
        this.f19318c.setHint(str);
        this.f19318c.setEllipsize(TextUtils.TruncateAt.END);
    }

    public void a(boolean z) {
        this.j = z;
        this.f19317b.setVisibility(z ? 0 : 8);
    }

    public static class b extends q<k> {

        /* renamed from: a  reason: collision with root package name */
        private final bi f19323a;

        /* renamed from: c  reason: collision with root package name */
        private e f19324c = new g() {
            public void onEvent(com.garena.android.appkit.b.a aVar) {
                ((k) b.this.f19220b).e();
            }
        };

        /* renamed from: d  reason: collision with root package name */
        private e f19325d = new g() {
            public void onEvent(com.garena.android.appkit.b.a aVar) {
                ((k) b.this.f19220b).f();
            }
        };

        public void a() {
        }

        public void b() {
        }

        public b(bi biVar) {
            this.f19323a = biVar;
        }

        public void c() {
            this.f19323a.a("SHOW_SEARCH_PROGRESS", this.f19324c);
            this.f19323a.a("HIDE_SEARCH_PROGRESS", this.f19325d);
        }

        public void d() {
            this.f19323a.b("SHOW_SEARCH_PROGRESS", this.f19324c);
            this.f19323a.b("HIDE_SEARCH_PROGRESS", this.f19325d);
        }
    }
}
