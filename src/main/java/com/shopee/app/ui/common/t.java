package com.shopee.app.ui.common;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.garena.android.appkit.tools.b;
import com.shopee.app.a;
import com.shopee.id.R;

public class t extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    TextView f21339a;

    /* renamed from: b  reason: collision with root package name */
    ImageView f21340b;

    /* renamed from: c  reason: collision with root package name */
    private String f21341c;

    /* renamed from: d  reason: collision with root package name */
    private Drawable f21342d;

    /* renamed from: e  reason: collision with root package name */
    private int f21343e = getResources().getColor(R.color.green_banner);

    /* renamed from: f  reason: collision with root package name */
    private int f21344f = getResources().getColor(R.color.white);

    /* renamed from: g  reason: collision with root package name */
    private boolean f21345g;
    private int h;

    public t(Context context) {
        super(context);
    }

    public t(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context, attributeSet);
    }

    public t(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(context, attributeSet);
    }

    @TargetApi(21)
    public t(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        a(context, attributeSet);
    }

    private void a(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.b.NoticeView);
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i = 0; i < indexCount; i++) {
            int index = obtainStyledAttributes.getIndex(i);
            if (index == 0) {
                this.f21343e = obtainStyledAttributes.getColor(index, getResources().getColor(R.color.green_banner));
            } else if (index == 1) {
                this.h = obtainStyledAttributes.getColor(index, getResources().getColor(R.color.white));
            } else if (index == 2) {
                this.f21345g = obtainStyledAttributes.getBoolean(index, false);
            } else if (index == 3) {
                this.f21342d = obtainStyledAttributes.getDrawable(index);
            } else if (index == 4) {
                this.f21341c = obtainStyledAttributes.getString(index);
            } else if (index == 5) {
                this.f21344f = obtainStyledAttributes.getColor(index, getResources().getColor(R.color.white));
            }
        }
        obtainStyledAttributes.recycle();
    }

    /* access modifiers changed from: package-private */
    public void a() {
        setBackgroundColor(this.f21343e);
        this.f21339a.setTextColor(this.f21344f);
        Drawable drawable = this.f21342d;
        if (drawable != null) {
            setLeftIcon(drawable);
        }
        if (!TextUtils.isEmpty(this.f21341c)) {
            this.f21339a.setText(this.f21341c);
        }
        if (this.f21345g) {
            this.f21340b.setVisibility(8);
        } else {
            this.f21340b.setColorFilter(this.h);
        }
    }

    public void setNotice(String str) {
        this.f21339a.setText(str);
    }

    public void setOnDismissListener(View.OnClickListener onClickListener) {
        this.f21340b.setOnClickListener(onClickListener);
    }

    public void setLeftIcon(Drawable drawable) {
        this.f21339a.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
    }

    public void setLeftIcon(int i) {
        this.f21339a.setCompoundDrawablesWithIntrinsicBounds(b.f(i), (Drawable) null, (Drawable) null, (Drawable) null);
    }
}
