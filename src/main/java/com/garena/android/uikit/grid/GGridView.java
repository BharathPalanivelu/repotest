package com.garena.android.uikit.grid;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

public class GGridView extends LinearLayout implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private a f7731a;

    /* renamed from: b  reason: collision with root package name */
    private int f7732b = 0;

    /* renamed from: c  reason: collision with root package name */
    private b f7733c;

    /* renamed from: d  reason: collision with root package name */
    private int f7734d = 4;

    public interface a {
        int a();

        View a(Context context, int i, int i2, int i3);
    }

    public interface b {
        void a(View view, int i, int i2, int i3);
    }

    public GGridView(Context context) {
        super(context);
        a(context);
    }

    public GGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    @TargetApi(11)
    public GGridView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(context);
    }

    private void a(Context context) {
        setOrientation(1);
    }

    public void setAdapter(a aVar) {
        this.f7731a = aVar;
    }

    public void setItemMargin(int i) {
        this.f7732b = i;
    }

    public void setColumnCount(int i) {
        this.f7734d = i;
    }

    public void setColumnCount(com.garena.android.uikit.grid.a.a aVar) {
        this.f7734d = aVar.a();
    }

    public void setOnItemClickListener(b bVar) {
        this.f7733c = bVar;
    }

    public void a() {
        if (this.f7731a != null) {
            removeAllViews();
            a(this.f7734d, this.f7731a.a());
        }
    }

    public void a(int i, int i2) {
        int i3 = ((i2 - 1) / this.f7734d) + 1;
        int min = Math.min(i, i2) + 0;
        int i4 = i2;
        int i5 = 0;
        for (int i6 = 0; i6 < i3; i6++) {
            addView(a(i6, i5, min), new LinearLayout.LayoutParams(-1, -2));
            i5 += i;
            i4 -= i;
            min = Math.min(i, i4) + i5;
        }
    }

    public LinearLayout a(int i, int i2, int i3) {
        Context context = getContext();
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(0);
        for (int i4 = i2; i4 < i3; i4++) {
            int i5 = i4 - i2;
            View a2 = this.f7731a.a(context, i, i5, i4);
            a2.setTag(i + ";" + i5 + ";" + i4);
            a2.setClickable(true);
            a2.setOnClickListener(this);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
            layoutParams.weight = 1.0f;
            if (i4 == i2) {
                int i6 = this.f7732b;
                layoutParams.setMargins(0, i6, i6, i6);
            } else if (i4 == i3 - 1) {
                int i7 = this.f7732b;
                layoutParams.setMargins(i7, i7, 0, i7);
            } else {
                int i8 = this.f7732b;
                layoutParams.setMargins(i8, i8, i8, i8);
            }
            linearLayout.addView(a2, layoutParams);
        }
        int i9 = i3 - i2;
        if (i9 < this.f7734d) {
            a(context, linearLayout, i9);
        }
        return linearLayout;
    }

    private void a(Context context, LinearLayout linearLayout, int i) {
        View view = new View(context);
        view.setClickable(false);
        int i2 = this.f7734d - i;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
        layoutParams.weight = (float) i2;
        int i3 = this.f7732b * i2;
        layoutParams.setMargins(i3, i3, 0, i3);
        linearLayout.addView(view, layoutParams);
    }

    public void onClick(View view) {
        String str = (String) view.getTag();
        if (this.f7733c != null && str != null) {
            String[] split = str.split(";");
            this.f7733c.a(view, Integer.valueOf(split[0]).intValue(), Integer.valueOf(split[1]).intValue(), Integer.valueOf(split[2]).intValue());
        }
    }
}
