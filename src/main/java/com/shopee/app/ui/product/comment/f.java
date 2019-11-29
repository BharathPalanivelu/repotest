package com.shopee.app.ui.product.comment;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import com.shopee.app.util.x;
import com.shopee.id.R;

public class f extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    Button f24487a;

    /* renamed from: b  reason: collision with root package name */
    Button f24488b;

    /* renamed from: c  reason: collision with root package name */
    Button f24489c;

    /* renamed from: d  reason: collision with root package name */
    Button f24490d;

    /* renamed from: e  reason: collision with root package name */
    Button f24491e;

    /* renamed from: f  reason: collision with root package name */
    Button f24492f;

    /* renamed from: g  reason: collision with root package name */
    View f24493g;
    View h;
    /* access modifiers changed from: private */
    public b i;

    public interface b {
        void a();

        void b();

        void c();

        void d();

        void e();

        void f();
    }

    public f(Context context) {
        super(context);
        ((a) ((x) context).b()).a(this);
    }

    public f(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public f(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    /* access modifiers changed from: package-private */
    public void a() {
        a(this.f24487a, this.f24492f, this.f24488b, this.f24489c, this.f24490d, this.f24491e);
    }

    public void setInfo(a aVar) {
        this.f24487a.setText(com.garena.android.appkit.tools.b.a(R.string.sp_label_view_all, Integer.valueOf(aVar.f24501b)));
        this.f24492f.setText(com.garena.android.appkit.tools.b.a(R.string.sp_star_with_count, 1, Integer.valueOf(aVar.f24502c)));
        this.f24491e.setText(com.garena.android.appkit.tools.b.a(R.string.sp_star_with_count, 2, Integer.valueOf(aVar.f24503d)));
        this.f24490d.setText(com.garena.android.appkit.tools.b.a(R.string.sp_star_with_count, 3, Integer.valueOf(aVar.f24504e)));
        this.f24489c.setText(com.garena.android.appkit.tools.b.a(R.string.sp_star_with_count, 4, Integer.valueOf(aVar.f24505f)));
        this.f24488b.setText(com.garena.android.appkit.tools.b.a(R.string.sp_star_with_count, 5, Integer.valueOf(aVar.f24506g)));
        this.i = aVar.h;
        this.f24487a.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (f.this.i != null) {
                    f.this.i.a();
                }
                f fVar = f.this;
                fVar.a(fVar.f24487a, f.this.f24492f, f.this.f24488b, f.this.f24489c, f.this.f24490d, f.this.f24491e);
            }
        });
        this.f24488b.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (f.this.i != null) {
                    f.this.i.b();
                }
                f fVar = f.this;
                fVar.a(fVar.f24488b, f.this.f24492f, f.this.f24487a, f.this.f24489c, f.this.f24490d, f.this.f24491e);
            }
        });
        this.f24489c.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (f.this.i != null) {
                    f.this.i.c();
                }
                f fVar = f.this;
                fVar.a(fVar.f24489c, f.this.f24492f, f.this.f24487a, f.this.f24488b, f.this.f24490d, f.this.f24491e);
            }
        });
        this.f24490d.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (f.this.i != null) {
                    f.this.i.d();
                }
                f fVar = f.this;
                fVar.a(fVar.f24490d, f.this.f24492f, f.this.f24487a, f.this.f24488b, f.this.f24489c, f.this.f24491e);
            }
        });
        this.f24491e.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (f.this.i != null) {
                    f.this.i.e();
                }
                f fVar = f.this;
                fVar.a(fVar.f24491e, f.this.f24492f, f.this.f24487a, f.this.f24488b, f.this.f24489c, f.this.f24490d);
            }
        });
        this.f24492f.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (f.this.i != null) {
                    f.this.i.f();
                }
                f fVar = f.this;
                fVar.a(fVar.f24492f, f.this.f24487a, f.this.f24488b, f.this.f24489c, f.this.f24490d, f.this.f24491e);
            }
        });
    }

    public void a(int i2, int i3, b bVar) {
        setInfo(new a(i2, i3, 0, 0, 0, 0, 0, bVar));
    }

    /* access modifiers changed from: package-private */
    public void a(Button button, Button button2, Button button3, Button button4, Button button5, Button button6) {
        button.setBackgroundResource(R.drawable.btn_primary);
        button.setTextColor(com.garena.android.appkit.tools.b.a(R.color.white));
        button2.setBackgroundResource(R.drawable.btn_primary_grey);
        button2.setTextColor(com.garena.android.appkit.tools.b.a(R.color.black54));
        button3.setBackgroundResource(R.drawable.btn_primary_grey);
        button3.setTextColor(com.garena.android.appkit.tools.b.a(R.color.black54));
        button4.setBackgroundResource(R.drawable.btn_primary_grey);
        button4.setTextColor(com.garena.android.appkit.tools.b.a(R.color.black54));
        button5.setBackgroundResource(R.drawable.btn_primary_grey);
        button5.setTextColor(com.garena.android.appkit.tools.b.a(R.color.black54));
        button6.setBackgroundResource(R.drawable.btn_primary_grey);
        button6.setTextColor(com.garena.android.appkit.tools.b.a(R.color.black54));
    }

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        final int f24500a;

        /* renamed from: b  reason: collision with root package name */
        final int f24501b;

        /* renamed from: c  reason: collision with root package name */
        final int f24502c;

        /* renamed from: d  reason: collision with root package name */
        final int f24503d;

        /* renamed from: e  reason: collision with root package name */
        final int f24504e;

        /* renamed from: f  reason: collision with root package name */
        final int f24505f;

        /* renamed from: g  reason: collision with root package name */
        final int f24506g;
        b h;

        public a(int i, int i2, int i3, int i4, int i5, int i6, int i7, b bVar) {
            this.f24500a = i;
            this.f24501b = i2;
            this.f24502c = i3;
            this.f24503d = i4;
            this.f24504e = i5;
            this.f24505f = i6;
            this.f24506g = i7;
            this.h = bVar;
        }
    }
}
