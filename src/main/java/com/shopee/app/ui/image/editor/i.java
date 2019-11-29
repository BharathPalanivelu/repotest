package com.shopee.app.ui.image.editor;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

public class i extends FrameLayout implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    LinearLayout f22957a;

    /* renamed from: b  reason: collision with root package name */
    private b f22958b;

    /* renamed from: c  reason: collision with root package name */
    private a f22959c;

    public interface a<T> {
        void a(int i, View view, T t, ViewGroup viewGroup);
    }

    public interface b<T> {
        int a();

        View a(int i, Context context);

        T a(int i, View view);
    }

    public i(Context context) {
        super(context);
    }

    public i(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public i(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* access modifiers changed from: package-private */
    public void a() {
        if (this.f22958b != null) {
            this.f22957a.removeAllViews();
            int a2 = this.f22958b.a();
            for (int i = 0; i < a2; i++) {
                View a3 = this.f22958b.a(i, getContext());
                a3.setTag(Integer.valueOf(i));
                a3.setOnClickListener(this);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2, 1.0f);
                layoutParams.gravity = 16;
                this.f22957a.addView(a3, layoutParams);
            }
        }
    }

    public void setAdapter(b bVar) {
        this.f22958b = bVar;
        a();
    }

    public void setItemClickListener(a aVar) {
        this.f22959c = aVar;
    }

    public void onClick(View view) {
        if (this.f22959c != null) {
            int intValue = ((Integer) view.getTag()).intValue();
            this.f22959c.a(intValue, view, this.f22958b.a(intValue, view), this.f22957a);
        }
    }
}
