package com.shopee.app.ui.order.detail;

import android.content.Context;
import android.text.Html;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class i extends RelativeLayout {

    /* renamed from: a  reason: collision with root package name */
    ImageView f23630a;

    /* renamed from: b  reason: collision with root package name */
    TextView f23631b;

    /* renamed from: c  reason: collision with root package name */
    TextView f23632c;

    /* renamed from: d  reason: collision with root package name */
    TextView f23633d;

    /* renamed from: e  reason: collision with root package name */
    TextView f23634e;

    /* renamed from: f  reason: collision with root package name */
    int f23635f;

    /* renamed from: g  reason: collision with root package name */
    int f23636g;
    /* access modifiers changed from: private */
    public a h;

    public interface a {
        void a();

        void a(String str);
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
        int i = this.f23635f;
        int i2 = this.f23636g;
        setPadding(i, i2, i, i2);
    }

    public void a(int i, String str, String str2, String str3, String str4, final a aVar) {
        this.h = aVar;
        this.f23630a.setImageResource(i);
        if (TextUtils.isEmpty(str)) {
            this.f23631b.setVisibility(8);
        } else {
            this.f23631b.setVisibility(0);
            this.f23631b.setText(str);
        }
        this.f23632c.setText(Html.fromHtml(str2));
        if (!TextUtils.isEmpty(str3)) {
            this.f23633d.setVisibility(0);
            this.f23633d.setText(str3);
            this.f23633d.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    a aVar = aVar;
                    if (aVar != null) {
                        aVar.a();
                    }
                }
            });
        } else {
            this.f23633d.setVisibility(8);
        }
        if (!TextUtils.isEmpty(str4)) {
            this.f23634e.setText(str4);
            this.f23634e.setVisibility(0);
            this.f23634e.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    i.this.h.a(i.this.f23632c.getText().toString().trim());
                }
            });
            return;
        }
        this.f23634e.setVisibility(8);
    }
}
