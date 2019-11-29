package com.shopee.live.livestreaming.ui.view;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentManager;
import com.devspark.robototextview.widget.RobotoTextView;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.shopee.live.livestreaming.c;
import com.shopee.live.livestreaming.ui.audience.e;
import com.shopee.live.livestreaming.ui.view.b.b;
import com.shopee.live.livestreaming.util.z;

public class AudienceCoinView extends ConstraintLayout implements View.OnClickListener, e, b {

    /* renamed from: g  reason: collision with root package name */
    private static final String f29099g = "AudienceCoinView";
    private RobotoTextView h;
    private RobotoTextView i;
    private RobotoTextView j;
    private RobotoTextView k;
    private ImageView l;
    /* access modifiers changed from: private */
    public ImageView m;
    /* access modifiers changed from: private */
    public RobotoTextView n;
    private com.shopee.live.livestreaming.ui.audience.classA o;
    private ObjectAnimator p;
    private b q;
    private FragmentManager fragmentManager;
    private a s;
    private boolean t;

    public interface a {
        void i();

        void k();
    }

    public AudienceCoinView(Context context) {
        this(context, (AttributeSet) null);
    }

    public AudienceCoinView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AudienceCoinView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.t = true;
        z_();
    }

    public void setOnViewVisibleListener(a aVar) {
        this.s = aVar;
    }

    public void setAudienceCheckInCoinPresenter(com.shopee.live.livestreaming.ui.audience.classA aVar) {
        this.o = aVar;
    }

    public void setFragmentManager(FragmentManager hVar) {
        this.fragmentManager = hVar;
    }

    public void z_() {
        LayoutInflater.from(getContext()).inflate(c.f.live_streaming_layout_coin, this);
        this.h = (RobotoTextView) findViewById(c.e.tv_coin_num);
        this.i = (RobotoTextView) findViewById(c.e.tv_tag);
        this.j = (RobotoTextView) findViewById(c.e.tv_status);
        this.k = (RobotoTextView) findViewById(c.e.tv_claim);
        this.l = (ImageView) findViewById(c.e.img_claiming);
        this.m = (ImageView) findViewById(c.e.img_coin);
        this.n = (RobotoTextView) findViewById(c.e.tv_count_down);
        this.m.setImageDrawable(com.garena.android.appkit.tools.b.f(c.d.live_streaming_reward_coins));
        this.k.setOnClickListener(this);
        this.m.setOnClickListener(this);
        this.i.setOnClickListener(this);
    }

    public void e() {
        this.i.setVisibility(0);
        this.i.setText(com.garena.android.appkit.tools.b.e(c.g.live_streaming_viewer_cic_login_to_claim));
        this.i.setOnClickListener(this);
    }

    public void g() {
        p();
        getLayoutParams().width = -2;
        this.j.setVisibility(0);
        this.j.setText(com.garena.android.appkit.tools.b.e(c.g.live_streaming_viewer_cic_fully_claimed));
    }

    public void h() {
        this.m.setVisibility(0);
        this.k.setVisibility(0);
        this.h.setVisibility(0);
        this.k.setText(com.garena.android.appkit.tools.b.e(c.g.live_streaming_viewer_cic_button_claim));
    }

    public void j_(int i2) {
        this.o.a(i2);
    }

    public void d() {
        setVisibility(8);
        a aVar = this.s;
        if (aVar != null) {
            aVar.i();
        }
    }

    private void p() {
        this.h.setVisibility(8);
        this.m.setVisibility(8);
    }

    public void l() {
        setVisibility(0);
        a aVar = this.s;
        if (aVar != null) {
            aVar.k();
        }
    }

    public void f() {
        p();
        getLayoutParams().width = -2;
        this.j.setVisibility(0);
        this.j.setText(com.garena.android.appkit.tools.b.e(c.g.live_streaming_viewer_cic_times_limits));
    }

    public void a(String str) {
        if (!TextUtils.isEmpty(str)) {
            int length = str.length();
            if (length == 0 || length == 1 || length == 2) {
                this.h.setTextSize(11.0f);
            } else if (length == 3) {
                this.h.setTextSize(8.0f);
            } else if (length == 4 || length == 5) {
                this.h.setTextSize(7.0f);
            }
        }
        this.m.setVisibility(0);
        this.h.setVisibility(0);
        this.h.setText(str);
    }

    public void i() {
        this.k.setText("");
        this.l.setVisibility(0);
        this.p = ObjectAnimator.ofFloat(this.l, "rotation", new float[]{BitmapDescriptorFactory.HUE_RED, 359.0f});
        this.p.setDuration(1000);
        this.p.setRepeatCount(-1);
        this.p.setRepeatMode(1);
        this.p.setInterpolator(new LinearInterpolator());
        this.p.start();
    }

    public void a(String str, int i2) {
        this.p.cancel();
        if (this.q == null) {
            this.q = b.a(str, i2);
        } else {
            Bundle bundle = new Bundle();
            bundle.putString("mPerCoin", str);
            bundle.putInt("mClaimCount", i2);
            this.q.setArguments(bundle);
            this.q.a();
        }
        this.q.show(this.fragmentManager, f29099g);
    }

    public void j() {
        z.a(getContext(), com.garena.android.appkit.tools.b.e(c.g.live_streaming_viewer_cic_claim_fail));
        ObjectAnimator objectAnimator = this.p;
        if (objectAnimator != null && objectAnimator.isRunning()) {
            this.p.cancel();
        }
        this.l.setVisibility(8);
    }

    public void b() {
        this.o.h();
        this.o.d();
    }

    public void onClick(View view) {
        if (view.getId() == c.e.tv_claim) {
            this.o.f();
            com.shopee.live.livestreaming.ui.audience.c.t();
        } else if ((view.getId() == c.e.img_coin || view.getId() == c.e.tv_tag) && !com.shopee.sdk.b.a().d().b()) {
            com.shopee.live.livestreaming.ui.audience.c.u();
            com.shopee.sdk.b.a().b().a((Activity) getContext(), new a.C0473a().a());
        }
    }

    public void m() {
        this.l.setVisibility(8);
        this.k.setVisibility(4);
    }

    public void n() {
        com.shopee.e.a.a.a((Object) "AudienceCoinView: tick--start");
        this.n.setVisibility(0);
        if (this.t) {
            this.t = false;
            post(new Runnable() {
                public void run() {
                    AudienceCoinView.this.getLayoutParams().width = Math.max((int) AudienceCoinView.this.n.getPaint().measureText(AudienceCoinView.this.n.getText().toString()), AudienceCoinView.this.m.getDrawable().getIntrinsicWidth());
                    AudienceCoinView.this.requestLayout();
                }
            });
        }
    }

    public void b(int i2) {
        com.shopee.e.a.a.a((Object) "AudienceCoinView: tick--" + i2);
        this.n.setText(String.format(com.garena.android.appkit.tools.b.e(c.g.live_streaming_viewer_cic_countdown), new Object[]{com.shopee.live.livestreaming.ui.view.b.a.d(i2)}));
    }

    public void o() {
        com.shopee.e.a.a.a((Object) "AudienceCoinView: tick--end");
        this.o.g();
        this.n.setVisibility(8);
        h();
    }

    public void b(String str) {
        z.a(getContext(), str);
    }

    public void k() {
        ObjectAnimator objectAnimator = this.p;
        if (objectAnimator != null && objectAnimator.isRunning()) {
            this.p.cancel();
        }
        this.k.setVisibility(8);
        this.h.setVisibility(8);
        this.m.setVisibility(8);
        this.i.setVisibility(8);
        this.j.setVisibility(8);
        this.l.setVisibility(8);
        this.n.setVisibility(8);
    }

    public void c() {
        this.o.e();
    }

    public void setApplication(Application application) {
        this.o.a(application);
    }
}
