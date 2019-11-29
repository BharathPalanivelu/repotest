package com.shopee.app.ui.setting.cell;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.a.a.f;
import com.shopee.app.a;
import com.shopee.id.R;

public class a extends FrameLayout implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    TextView f25194a;

    /* renamed from: b  reason: collision with root package name */
    TextView f25195b;

    /* renamed from: c  reason: collision with root package name */
    CompoundButton f25196c;

    /* renamed from: d  reason: collision with root package name */
    TextView f25197d;

    /* renamed from: e  reason: collision with root package name */
    int f25198e;

    /* renamed from: f  reason: collision with root package name */
    int f25199f;

    /* renamed from: g  reason: collision with root package name */
    int f25200g;
    View h;
    private boolean i;
    private String j;
    private String k;
    private boolean l;
    private boolean m = true;
    private View.OnClickListener n;
    private View.OnClickListener o;
    private String p;

    public a(Context context) {
        super(context);
        a(context);
    }

    public a(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context, attributeSet);
        a(context);
    }

    public a(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a(context, attributeSet);
        a(context);
    }

    private void a(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.b.SettingItem);
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i2 = 0; i2 < indexCount; i2++) {
            int index = obtainStyledAttributes.getIndex(i2);
            if (index == 0) {
                this.p = obtainStyledAttributes.getString(index);
            } else if (index == 1) {
                this.m = obtainStyledAttributes.getBoolean(index, true);
            } else if (index == 2) {
                this.j = obtainStyledAttributes.getString(index);
            } else if (index == 3) {
                this.k = obtainStyledAttributes.getString(index);
            } else if (index == 4) {
                this.l = obtainStyledAttributes.getBoolean(index, false);
            } else if (index == 5) {
                this.i = obtainStyledAttributes.getBoolean(index, true);
            }
        }
        obtainStyledAttributes.recycle();
    }

    private void a(Context context) {
        setBackgroundResource(R.drawable.read_bg_with_highlight_new);
    }

    /* access modifiers changed from: package-private */
    public void a() {
        setTextPrimary(this.j);
        setTextSecondary(this.k);
        a(this.i);
        b(this.l);
        a(this.p);
        setViewEnabled(this.m);
    }

    public void setTextPrimary(String str) {
        this.f25194a.setText(str);
    }

    public void setTextPrimary(f fVar) {
        fVar.a(this.f25194a);
    }

    public void setTextSecondary(String str) {
        this.f25195b.setText(str);
    }

    public void setTextSecondary(f fVar) {
        fVar.a(this.f25195b);
    }

    public void a(boolean z) {
        this.i = z;
        this.f25195b.setVisibility(z ? 0 : 8);
    }

    public void b() {
        if (Build.VERSION.SDK_INT > 16) {
            this.f25195b.setTextDirection(3);
        }
    }

    public void setViewEnabled(boolean z) {
        this.m = z;
        setEnabled(z);
        this.f25194a.setTextColor(z ? this.f25198e : this.f25200g);
        this.f25196c.setEnabled(isEnabled());
    }

    public void b(boolean z) {
        this.l = z;
        this.f25196c.setVisibility(z ? 0 : 8);
    }

    private void a(String str) {
        this.p = str;
        this.f25197d.setVisibility(!TextUtils.isEmpty(str) ? 0 : 8);
        this.f25197d.setText(str);
    }

    public boolean c() {
        return this.f25196c.isChecked();
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.n = onClickListener;
        super.setOnClickListener(this);
    }

    public void onClick(View view) {
        View.OnClickListener onClickListener = this.n;
        if (onClickListener == null || this.l) {
            this.f25196c.toggle();
        } else {
            onClickListener.onClick(view);
        }
    }

    public void d() {
        View.OnClickListener onClickListener = this.n;
        if (onClickListener != null) {
            onClickListener.onClick(this);
        }
    }

    public void setChecked(boolean z) {
        this.f25196c.setChecked(z);
    }

    public void setViewVisualEnabled(boolean z) {
        this.f25194a.setTextColor(z ? this.f25198e : this.f25200g);
        this.f25195b.setTextColor(z ? this.f25199f : this.f25200g);
        this.f25196c.setEnabled(isEnabled());
    }

    public void setCheckboxOnClickListener(View.OnClickListener onClickListener) {
        this.f25196c.setOnClickListener(this.o);
    }
}
