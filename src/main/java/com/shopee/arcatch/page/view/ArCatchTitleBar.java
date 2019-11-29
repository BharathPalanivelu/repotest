package com.shopee.arcatch.page.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.shopee.arcatch.a;
import com.shopee.arcatch.b.c.b;

public class ArCatchTitleBar extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    private View f27038a;

    /* renamed from: b  reason: collision with root package name */
    private TextView f27039b;

    public ArCatchTitleBar(Context context) {
        this(context, (AttributeSet) null);
    }

    public ArCatchTitleBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ArCatchTitleBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a();
    }

    private void a() {
        LayoutInflater.from(getContext()).inflate(a.d.activity_view_titlebar, this, true);
        setLayoutParams(new LinearLayout.LayoutParams(-1, b.a(getContext(), 48.0f)));
        this.f27038a = findViewById(a.c.arcatch_titlebar_button);
        this.f27039b = (TextView) findViewById(a.c.arcatch_titlebar_text);
    }

    public void setBackOnClickListener(View.OnClickListener onClickListener) {
        this.f27038a.setOnClickListener(onClickListener);
    }

    public void a(String str) {
        this.f27039b.setText(str);
    }
}
