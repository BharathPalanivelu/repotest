package com.shopee.feeds.feedlibrary.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.garena.android.appkit.tools.b;
import com.shopee.feeds.feedlibrary.c;

public class CommonCheckButton extends RelativeLayout implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private boolean f28420a;

    /* renamed from: b  reason: collision with root package name */
    private a f28421b;

    /* renamed from: c  reason: collision with root package name */
    private ImageView f28422c;

    /* renamed from: d  reason: collision with root package name */
    private int f28423d;

    /* renamed from: e  reason: collision with root package name */
    private int f28424e;

    public interface a {
        void a(boolean z);
    }

    public CommonCheckButton(Context context) {
        this(context, (AttributeSet) null);
    }

    public CommonCheckButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CommonCheckButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f28423d = c.d.feeds_ic_sound_off;
        this.f28424e = c.d.feeds_ic_sound_on;
        this.f28422c = (ImageView) LayoutInflater.from(context).inflate(c.f.feeds_layout_common_check_button, this, true).findViewById(c.e.iv_check);
        this.f28422c.setImageDrawable(b.f(this.f28424e));
        setOnClickListener(this);
    }

    public void onClick(View view) {
        setChecked(!this.f28420a);
    }

    public void setCheckListener(a aVar) {
        this.f28421b = aVar;
    }

    public void setChecked(boolean z) {
        if (this.f28420a != z) {
            this.f28420a = z;
            this.f28422c.setImageDrawable(b.f(this.f28420a ? this.f28423d : this.f28424e));
            a aVar = this.f28421b;
            if (aVar != null) {
                aVar.a(this.f28420a);
            }
        }
    }

    public boolean a() {
        return this.f28420a;
    }
}
