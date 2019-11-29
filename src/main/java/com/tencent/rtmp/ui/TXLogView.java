package com.tencent.rtmp.ui;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import cn.tongdun.android.shell.settings.Constants;

public class TXLogView extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    StringBuffer f32485a;

    /* renamed from: b  reason: collision with root package name */
    private TextView f32486b;

    /* renamed from: c  reason: collision with root package name */
    private TextView f32487c;

    /* renamed from: d  reason: collision with root package name */
    private ScrollView f32488d;

    /* renamed from: e  reason: collision with root package name */
    private ScrollView f32489e;

    /* renamed from: f  reason: collision with root package name */
    private final int f32490f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f32491g;

    public TXLogView(Context context) {
        this(context, (AttributeSet) null);
    }

    public TXLogView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f32485a = new StringBuffer("");
        this.f32490f = Constants.DEFAULT_WAIT_TIME;
        this.f32491g = false;
        setOrientation(1);
        this.f32486b = new TextView(context);
        this.f32487c = new TextView(context);
        this.f32488d = new ScrollView(context);
        this.f32489e = new ScrollView(context);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, 0);
        layoutParams.weight = 0.2f;
        this.f32488d.setLayoutParams(layoutParams);
        this.f32488d.setBackgroundColor(1627389951);
        this.f32488d.setVerticalScrollBarEnabled(true);
        this.f32488d.setScrollbarFadingEnabled(true);
        this.f32486b.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        this.f32486b.setTextSize(2, 11.0f);
        this.f32486b.setTextColor(-16777216);
        this.f32486b.setTypeface(Typeface.MONOSPACE, 1);
        this.f32486b.setLineSpacing(4.0f, 1.0f);
        this.f32486b.setPadding(a(context, 2.0f), a(context, 2.0f), a(context, 2.0f), a(context, 2.0f));
        this.f32488d.addView(this.f32486b);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, 0);
        layoutParams2.weight = 0.8f;
        layoutParams2.topMargin = a(context, 2.0f);
        this.f32489e.setLayoutParams(layoutParams2);
        this.f32489e.setBackgroundColor(1627389951);
        this.f32489e.setVerticalScrollBarEnabled(true);
        this.f32489e.setScrollbarFadingEnabled(true);
        this.f32487c.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.f32487c.setTextSize(2, 13.0f);
        this.f32487c.setTextColor(-16777216);
        this.f32487c.setPadding(a(context, 2.0f), a(context, 2.0f), a(context, 2.0f), a(context, 2.0f));
        this.f32489e.addView(this.f32487c);
        addView(this.f32488d);
        addView(this.f32489e);
        setVisibility(8);
    }

    public static int a(Context context, float f2) {
        return (int) ((f2 * context.getResources().getDisplayMetrics().density) + 0.5f);
    }
}
