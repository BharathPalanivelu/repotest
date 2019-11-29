package com.shopee.app.ui.d;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class d extends RelativeLayout {

    /* renamed from: a  reason: collision with root package name */
    TextView f21464a;

    /* renamed from: b  reason: collision with root package name */
    ImageView f21465b;

    public d(Context context) {
        super(context);
    }

    public void setText(String str) {
        this.f21464a.setText(str);
    }

    public void setCrossClickListener(final View.OnClickListener onClickListener) {
        this.f21465b.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                onClickListener.onClick(d.this);
            }
        });
    }
}
