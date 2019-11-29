package com.garena.pay.android.f;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.garena.d.a;
import com.squareup.a.w;

public class f extends g {
    public f(Activity activity, c cVar) {
        super(activity, cVar, a.e.picker_denomination_item_view);
    }

    public void a(e eVar) {
        if (eVar instanceof d) {
            a((d) eVar);
        } else {
            super.a(eVar);
        }
    }

    private void a(d dVar) {
        if (this.f8283b != null) {
            TextView textView = (TextView) this.f8283b.findViewById(a.d.picker_item_desc);
            ImageView imageView = (ImageView) this.f8283b.findViewById(a.d.picker_item_icon);
            TextView textView2 = (TextView) this.f8283b.findViewById(a.d.currency_amount_button);
            RelativeLayout relativeLayout = (RelativeLayout) this.f8283b.findViewById(a.d.currency_amount);
            ImageView imageView2 = (ImageView) this.f8283b.findViewById(a.d.current_amount_icon);
            ImageView imageView3 = (ImageView) this.f8283b.findViewById(a.d.promotionTextIcon);
            if (dVar.f8274a) {
                imageView3.setVisibility(0);
            } else {
                imageView3.setVisibility(8);
            }
            a((e) dVar, imageView);
            textView.setText(dVar.f8276c);
            if (!com.garena.pay.android.c.f.a(dVar.f8279f)) {
                textView2.setText(dVar.f8279f);
            }
            if (!TextUtils.isEmpty(dVar.f8275b)) {
                w.a((Context) this.f8284c).a(dVar.f8275b).a(a.c.default_icon).a(imageView2);
            } else {
                imageView2.setVisibility(8);
            }
            this.f8283b.setTag(dVar.f8280g);
            relativeLayout.setTag(dVar.f8280g);
            AnonymousClass1 r9 = new View.OnClickListener() {
                public void onClick(View view) {
                    if (!(view.getTag() == null || f.this.f8282a.b() == null)) {
                        f.this.f8282a.b().a(view.getTag());
                    }
                    f.this.f8282a.a(false);
                }
            };
            if (!com.garena.pay.android.c.f.a(textView2.getText())) {
                relativeLayout.setOnClickListener(r9);
            } else {
                this.f8283b.setOnClickListener(r9);
            }
        }
    }
}
