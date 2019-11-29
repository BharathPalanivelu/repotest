package com.garena.pay.android.f;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.garena.d.a;
import com.garena.pay.android.c.b;
import com.garena.pay.android.c.f;
import com.squareup.a.w;

public class g {

    /* renamed from: a  reason: collision with root package name */
    protected c f8282a;

    /* renamed from: b  reason: collision with root package name */
    protected View f8283b;

    /* renamed from: c  reason: collision with root package name */
    protected Activity f8284c;

    public g(Activity activity, c cVar) {
        this.f8282a = cVar;
        a(activity, a.e.picker_item_view);
    }

    public g(Activity activity, c cVar, int i) {
        this.f8282a = cVar;
        a(activity, i);
    }

    /* access modifiers changed from: protected */
    public void a(Activity activity, int i) {
        this.f8284c = activity;
        b.a(this.f8284c.getResources().getDisplayMetrics());
        this.f8283b = this.f8284c.getLayoutInflater().inflate(i, (ViewGroup) null);
    }

    public void a(e eVar) {
        View view = this.f8283b;
        if (view != null) {
            Button button = (Button) this.f8283b.findViewById(a.d.currency_amount);
            a(eVar, (ImageView) this.f8283b.findViewById(a.d.picker_item_icon));
            ((TextView) view.findViewById(a.d.picker_item_desc)).setText(eVar.f8276c);
            if (!f.a(eVar.f8279f)) {
                button.setText(eVar.f8279f);
            }
            this.f8283b.setTag(eVar.f8280g);
            button.setTag(eVar.f8280g);
            AnonymousClass1 r5 = new View.OnClickListener() {
                public void onClick(View view) {
                    if (!(view.getTag() == null || g.this.f8282a.b() == null)) {
                        g.this.f8282a.b().a(view.getTag());
                    }
                    g.this.f8282a.a(false);
                }
            };
            if (!f.a(button.getText())) {
                button.setOnClickListener(r5);
            } else {
                this.f8283b.setOnClickListener(r5);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void a(e eVar, ImageView imageView) {
        int a2 = b.a(32);
        if (f.a(eVar.f8278e)) {
            w.a((Context) this.f8284c).a(eVar.f8277d).a(a.c.default_icon).b(a2, a2).a(imageView);
        } else {
            w.a((Context) this.f8284c).a(eVar.f8278e).a(a.c.default_icon).b(a2, a2).a(imageView);
        }
    }

    public View a() {
        return this.f8283b;
    }
}
