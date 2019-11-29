package com.shopee.app.ui.image.editor;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;

public class b extends HorizontalScrollView implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    LinearLayout f22871a;

    /* renamed from: b  reason: collision with root package name */
    private C0357b f22872b;

    /* renamed from: c  reason: collision with root package name */
    private a f22873c;

    public interface a<T> {
        void a(int i, View view, T t, ViewGroup viewGroup);
    }

    /* renamed from: com.shopee.app.ui.image.editor.b$b  reason: collision with other inner class name */
    public interface C0357b<T> {
        int a();

        View a(int i, Context context);

        T a(int i, View view);
    }

    public b(Context context) {
        super(context);
    }

    public b(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public b(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* access modifiers changed from: package-private */
    public void a() {
        if (this.f22872b != null) {
            this.f22871a.removeAllViews();
            int a2 = this.f22872b.a();
            for (int i = 0; i < a2; i++) {
                View a3 = this.f22872b.a(i, getContext());
                a3.setTag(Integer.valueOf(i));
                a3.setOnClickListener(this);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2, 1.0f);
                layoutParams.gravity = 16;
                this.f22871a.addView(a3, layoutParams);
            }
        }
    }

    public void setAdapter(C0357b bVar) {
        this.f22872b = bVar;
        a();
    }

    public void setItemClickListener(a aVar) {
        this.f22873c = aVar;
    }

    public void onClick(View view) {
        if (this.f22873c != null) {
            int intValue = ((Integer) view.getTag()).intValue();
            this.f22873c.a(intValue, view, this.f22872b.a(intValue, view), this.f22871a);
        }
    }
}
