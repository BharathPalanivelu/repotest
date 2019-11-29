package com.garena.reactpush.a;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.garena.reactpush.a;

public class d extends FrameLayout implements View.OnClickListener {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final int f8324a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final Throwable f8325b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final String f8326c;

    /* renamed from: d  reason: collision with root package name */
    private TextView f8327d;

    /* renamed from: e  reason: collision with root package name */
    private TextView f8328e;

    /* renamed from: f  reason: collision with root package name */
    private TextView f8329f;

    public void onClick(View view) {
    }

    public d(Context context, int i, String str, Throwable th) {
        super(context);
        this.f8326c = str;
        this.f8324a = i;
        this.f8325b = th;
        a(context);
    }

    private void a(final Context context) {
        inflate(context, a.c.dev_support_view, this);
        this.f8327d = (TextView) findViewById(a.b.title);
        this.f8328e = (TextView) findViewById(a.b.dismiss_btn);
        this.f8328e.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                ((ViewGroup) d.this.getParent()).removeView(d.this);
            }
        });
        this.f8329f = (TextView) findViewById(a.b.see_btn);
        this.f8329f.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                new b(context, d.this.f8324a, d.this.f8326c, d.this.f8325b).show();
            }
        });
        int i = this.f8324a;
        if (i == 0) {
            setBackgroundColor(Color.parseColor("#E80000"));
        } else if (i == 1) {
            setBackgroundColor(Color.parseColor("#E6B300"));
        }
        setHint(this.f8325b.getMessage());
    }

    public void setHint(String str) {
        this.f8327d.setText(str);
    }

    public void a(FrameLayout frameLayout) {
        if (frameLayout != null && getParent() == null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
            layoutParams.gravity = 80;
            layoutParams.setMargins(4, 4, 4, 4);
            frameLayout.addView(this, layoutParams);
            startAnimation(AnimationUtils.loadAnimation(getContext(), a.C0142a.slide_in_from_bottom));
        }
    }
}
