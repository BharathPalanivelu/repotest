package com.shopee.app.ui.tutorial;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import com.garena.android.appkit.tools.b;
import com.shopee.app.application.ar;
import com.shopee.app.data.store.aa;
import com.shopee.app.ui.common.r;
import com.shopee.app.util.ak;
import com.shopee.app.util.x;
import com.shopee.id.R;
import com.squareup.a.w;
import java.util.List;

public class c extends RelativeLayout implements RadioGroup.OnCheckedChangeListener {

    /* renamed from: a  reason: collision with root package name */
    int f25705a;

    /* renamed from: b  reason: collision with root package name */
    int f25706b;

    /* renamed from: c  reason: collision with root package name */
    int f25707c;

    /* renamed from: d  reason: collision with root package name */
    RadioGroup f25708d;

    /* renamed from: e  reason: collision with root package name */
    List<RadioButton> f25709e;

    /* renamed from: f  reason: collision with root package name */
    Button f25710f;

    /* renamed from: g  reason: collision with root package name */
    ImageView f25711g;
    aa h;
    Activity i;
    r j;
    ak k;
    private String l;

    public c(Context context) {
        super(context);
        ((g) ((x) context).b()).a(this);
    }

    /* access modifiers changed from: package-private */
    public void a() {
        w.a(getContext()).a("http://content.garena.com/shopee/conf_a/D96ADD52E5434118.png").b(b.b(), (int) (((float) b.b()) / 1.9f)).d().a(com.squareup.a.r.NO_CACHE, com.squareup.a.r.NO_STORE).a(this.f25711g);
        onCheckedChanged(this.f25708d, R.id.radio_english);
        this.f25708d.setOnCheckedChangeListener(this);
    }

    /* access modifiers changed from: package-private */
    public void b() {
        if (this.h.b().equals(this.l)) {
            this.i.finish();
            return;
        }
        this.h.a(this.l);
        this.j.a();
        ar.a(false);
    }

    public void onCheckedChanged(RadioGroup radioGroup, int i2) {
        for (RadioButton next : this.f25709e) {
            next.setCompoundDrawables((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            next.setTextColor(this.f25707c);
        }
        RadioButton radioButton = (RadioButton) findViewById(i2);
        this.l = (String) radioButton.getTag();
        radioButton.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, androidx.core.content.b.a(getContext(), (int) R.drawable.com_garena_shopee_ic_ok), (Drawable) null);
        radioButton.setTextColor(this.f25706b);
    }
}
