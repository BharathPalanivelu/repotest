package com.shopee.arcatch.page.view;

import android.content.Context;
import android.graphics.Typeface;
import android.os.CountDownTimer;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.shopee.arcatch.a;
import com.shopee.arcatch.b.c.b;

public class ArCatchGameInfoView extends LinearLayout implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private ImageView f27011a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public TextView f27012b;

    /* renamed from: c  reason: collision with root package name */
    private ImageView f27013c;

    /* renamed from: d  reason: collision with root package name */
    private TextView f27014d;

    /* renamed from: e  reason: collision with root package name */
    private TextView f27015e;

    /* renamed from: f  reason: collision with root package name */
    private ImageView f27016f;

    /* renamed from: g  reason: collision with root package name */
    private FrameLayout f27017g;
    private FrameLayout h;
    private CountDownTimer i;
    /* access modifiers changed from: private */
    public a j;
    private boolean k;

    public interface a {
        void a(boolean z);

        void d();
    }

    public ArCatchGameInfoView(Context context) {
        this(context, (AttributeSet) null);
    }

    public ArCatchGameInfoView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.k = true;
    }

    public ArCatchGameInfoView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        a(context);
    }

    private void a(Context context) {
        LayoutInflater.from(context).inflate(a.d.arcatch_view_coinstimer, this, true);
        this.f27011a = (ImageView) findViewById(a.c.arcatch_timecount_bg);
        this.f27012b = (TextView) findViewById(a.c.arcatch_timecount_text);
        this.f27013c = (ImageView) findViewById(a.c.arcatch_coins_bg);
        this.f27014d = (TextView) findViewById(a.c.arcatch_coins_label);
        this.f27015e = (TextView) findViewById(a.c.arcatch_coins_text);
        this.f27016f = (ImageView) findViewById(a.c.btn_music_switch);
        this.f27017g = (FrameLayout) findViewById(a.c.arcatch_gameinfo_times);
        this.h = (FrameLayout) findViewById(a.c.arcatch_gameinfo_coins);
        this.f27017g.setVisibility(4);
        this.h.setVisibility(4);
        this.f27016f.setOnClickListener(this);
        this.f27014d.setText(com.shopee.arcatch.c.d.a.a().f26760e);
        int i2 = com.shopee.arcatch.c.d.a.a().f26761f;
        this.f27014d.setTextColor(i2);
        this.f27012b.setTextColor(i2);
        this.f27015e.setTextColor(i2);
        this.k = !com.shopee.arcatch.c.d.a.a().f26762g;
        this.f27016f.setImageBitmap(com.shopee.arcatch.c.d.a.a().a(this.k));
        this.f27011a.setImageBitmap(com.shopee.arcatch.c.d.a.a().h());
        this.f27013c.setImageBitmap(com.shopee.arcatch.c.d.a.a().g());
        Typeface createFromAsset = Typeface.createFromAsset(context.getAssets(), "fonts/Neuzeit Grotesk Bold.otf");
        if (createFromAsset != null) {
            this.f27012b.setTypeface(createFromAsset);
            this.f27014d.setTypeface(createFromAsset);
            this.f27015e.setTypeface(createFromAsset);
        }
    }

    public void setListener(a aVar) {
        this.j = aVar;
    }

    public void onClick(View view) {
        this.k = !this.k;
        this.f27016f.setImageBitmap(com.shopee.arcatch.c.d.a.a().a(this.k));
        a aVar = this.j;
        if (aVar != null) {
            aVar.a(this.k);
        }
    }

    public void a(int i2) {
        this.f27017g.setVisibility(0);
        this.h.setVisibility(0);
        this.i = new CountDownTimer((long) (i2 * 1000), 1000) {
            public void onTick(long j) {
                ArCatchGameInfoView.this.f27012b.setText(b.a(j));
            }

            public void onFinish() {
                ArCatchGameInfoView.this.f27012b.setText(b.a(0));
                if (ArCatchGameInfoView.this.j != null) {
                    ArCatchGameInfoView.this.j.d();
                }
            }
        };
        this.i.start();
    }

    public void a(float f2) {
        this.f27015e.setText(b.a(f2));
    }

    public void a() {
        CountDownTimer countDownTimer = this.i;
        if (countDownTimer != null) {
            countDownTimer.cancel();
            this.i = null;
        }
    }
}
