package com.shopee.app.ui.shopassistant;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.shopee.app.ui.common.f;
import com.shopee.app.util.bi;
import com.shopee.app.util.x;
import com.shopee.id.R;

public class d extends RelativeLayout implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    ImageView f25438a;

    /* renamed from: b  reason: collision with root package name */
    TextView f25439b;

    /* renamed from: c  reason: collision with root package name */
    View f25440c;

    /* renamed from: d  reason: collision with root package name */
    TextView f25441d;

    /* renamed from: e  reason: collision with root package name */
    TextView f25442e;

    /* renamed from: f  reason: collision with root package name */
    f f25443f;

    /* renamed from: g  reason: collision with root package name */
    TextView f25444g;
    int h;
    int i;
    bi j;
    int k;

    public interface a {
        void a(d dVar);
    }

    public d(Context context) {
        super(context);
        a(context);
    }

    public d(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    public d(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a(context);
    }

    private void a(Context context) {
        ((a) ((x) context).b()).a(this);
        setBackgroundResource(R.drawable.bottom_border_white_background_highlight);
        setOnClickListener(this);
    }

    /* access modifiers changed from: package-private */
    public void a() {
        int i2 = this.h;
        int i3 = this.i;
        setPadding(i2, i3, i2, i3);
    }

    /* access modifiers changed from: package-private */
    public void b() {
        this.f25443f.c();
    }

    public void a(int i2, int i3, int i4) {
        this.f25438a.setImageResource(i2);
        this.f25439b.setText(i3);
        this.f25440c.setVisibility(8);
        this.k = i4;
    }

    public void a(int i2, int i3, String str, int i4) {
        this.f25438a.setImageResource(i2);
        this.f25439b.setText(i3);
        if (!TextUtils.isEmpty(str)) {
            this.f25440c.setVisibility(0);
            this.f25441d.setText(str);
        }
        this.k = i4;
    }

    public void setBadge(int i2) {
        this.f25443f.setNumber(Integer.valueOf(i2));
    }

    public void setTitle(com.a.a.f fVar) {
        fVar.a(this.f25439b);
    }

    public void setTitle(String str) {
        this.f25439b.setText(str);
    }

    public void setSubtitle(String str) {
        a(str, "");
    }

    public void setSubtitle(com.a.a.f fVar) {
        a(fVar, (com.a.a.f) null);
    }

    public void a(String str, String str2) {
        this.f25440c.setVisibility(0);
        this.f25441d.setText(str);
        if (!TextUtils.isEmpty(str2)) {
            this.f25442e.setText(str2);
        } else {
            this.f25442e.setText("");
        }
    }

    public void a(com.a.a.f fVar, com.a.a.f fVar2) {
        this.f25440c.setVisibility(0);
        fVar.a(this.f25441d);
        if (fVar2 == null) {
            this.f25442e.setText("");
        } else {
            fVar2.a(this.f25442e);
        }
    }

    public void onClick(View view) {
        this.j.a("SHOP_ASSISTANT_SELECT_EVENT", new com.garena.android.appkit.b.a(Integer.valueOf(this.k)));
    }

    public void setIcon(int i2) {
        this.f25438a.setVisibility(i2);
    }
}
