package com.shopee.live.livestreaming.ui.anchor.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Configuration;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.c;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.shopee.live.livestreaming.c;
import com.shopee.live.livestreaming.data.entity.DanmaKuContentEntity;
import com.shopee.live.livestreaming.data.entity.DanmaKuEntity;
import com.shopee.live.livestreaming.data.entity.LiveStreamingSessionEntity;
import com.shopee.live.livestreaming.ui.view.DanmaKuView;
import com.shopee.live.livestreaming.ui.view.a.b;
import com.shopee.live.livestreaming.util.ab;
import com.shopee.live.livestreaming.util.d;
import com.shopee.live.livestreaming.util.r;
import com.shopee.live.livestreaming.util.w;

public class PublicScreenView extends ConstraintLayout {

    /* renamed from: g  reason: collision with root package name */
    View f28901g;
    DanmaKuView h;
    TextView i;
    FrameLayout j;
    b k;
    /* access modifiers changed from: private */
    public String l;
    /* access modifiers changed from: private */
    public boolean m;
    private r n;
    private AnimatorSet o;
    private ConstraintLayout p;
    private c q;

    public interface a {
        void j();
    }

    public PublicScreenView(Context context) {
        this(context, (AttributeSet) null);
    }

    public PublicScreenView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PublicScreenView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.m = false;
        e();
    }

    private void e() {
        this.f28901g = LayoutInflater.from(getContext()).inflate(c.f.live_streaming_layout_public_screen, this, true);
        this.h = (DanmaKuView) this.f28901g.findViewById(c.e.danmaku_view);
        this.i = (TextView) this.f28901g.findViewById(c.e.tv_public_screen_tips);
        this.j = (FrameLayout) this.f28901g.findViewById(c.e.fl_public_screen);
        this.n = new r();
        this.o = new AnimatorSet();
        this.k = new b(getContext());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), 1, false);
        linearLayoutManager.a(true);
        linearLayoutManager.c(true);
        this.h.setLayoutManager(linearLayoutManager);
        this.h.setAdapter(this.k);
    }

    public void setLiveStreamingSessionEntity(LiveStreamingSessionEntity liveStreamingSessionEntity) {
        this.k.b(liveStreamingSessionEntity.getSession().getSession_id());
        this.k.a(liveStreamingSessionEntity.getSession());
    }

    public void b() {
        if (this.k.getItemCount() > 0) {
            this.h.b(this.k.getItemCount() - 1);
        }
    }

    public void a(DanmaKuEntity danmaKuEntity) {
        boolean z = !this.h.canScrollVertically(1);
        this.k.a(danmaKuEntity);
        if (z) {
            this.h.b(this.k.getItemCount() - 1);
        }
    }

    public void a(long j2, String str, String str2, String str3) {
        DanmaKuEntity danmaKuEntity = new DanmaKuEntity();
        danmaKuEntity.setMessageType(101);
        danmaKuEntity.setContent(str3);
        danmaKuEntity.setNickname(str2);
        danmaKuEntity.setAvatar(str);
        danmaKuEntity.setId(0);
        danmaKuEntity.setUid(j2);
        a(danmaKuEntity);
    }

    public void b(String str) {
        DanmaKuEntity danmaKuEntity = new DanmaKuEntity();
        danmaKuEntity.setMessageType(DanmaKuEntity.MESSAGE_PUBLIC);
        danmaKuEntity.setContent(str);
        a(danmaKuEntity);
    }

    public void b(long j2, String str, String str2, String str3) {
        DanmaKuEntity danmaKuEntity = new DanmaKuEntity();
        danmaKuEntity.setMessageType(100);
        danmaKuEntity.setContent(str3);
        danmaKuEntity.setNickname(str2);
        danmaKuEntity.setAvatar(str);
        danmaKuEntity.setId(0);
        danmaKuEntity.setUid(j2);
        a(danmaKuEntity);
    }

    public void setVoucherStickerClickCallback(a aVar) {
        DanmaKuView danmaKuView = this.h;
        if (danmaKuView != null) {
            danmaKuView.setVoucherStickerClickCallback(aVar);
        }
    }

    public void a(DanmaKuContentEntity danmaKuContentEntity) {
        if (!d.a(danmaKuContentEntity.getContent())) {
            this.n.a(danmaKuContentEntity.getContent());
        }
        c();
    }

    public void c(String str) {
        if (!d.a(str)) {
            this.n.a(str);
        }
        c();
    }

    public void setLiveMode(int i2) {
        this.k.c(i2);
    }

    public void c() {
        if (!this.m) {
            this.l = this.n.a();
            if (!d.a(this.l)) {
                this.m = true;
                d();
                this.i.setVisibility(0);
                this.i.setText(String.format(com.garena.android.appkit.tools.b.e(c.g.live_streaming_host_msg_new_comer), new Object[]{this.l}));
                int measuredWidth = this.i.getMeasuredWidth();
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.i, "translationX", new float[]{(float) (-measuredWidth), 0.0f});
                ofFloat.setDuration(250);
                ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.i, "alpha", new float[]{1.0f, BitmapDescriptorFactory.HUE_RED});
                ofFloat2.setDuration(250);
                ofFloat2.setStartDelay(1000);
                this.o.play(ofFloat).before(ofFloat2);
                this.o.addListener(new AnimatorListenerAdapter() {
                    public void onAnimationEnd(Animator animator) {
                        super.onAnimationEnd(animator);
                        PublicScreenView.this.i.setVisibility(8);
                        PublicScreenView.this.i.setAlpha(1.0f);
                        String unused = PublicScreenView.this.l = "";
                        boolean unused2 = PublicScreenView.this.m = false;
                        PublicScreenView.this.c();
                    }
                });
                this.o.start();
            }
        }
    }

    public void d() {
        AnimatorSet animatorSet = this.o;
        if (animatorSet != null) {
            animatorSet.removeAllListeners();
            this.o.cancel();
        }
    }

    /* access modifiers changed from: protected */
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.p == null) {
            this.p = (ConstraintLayout) findViewById(c.e.cl_public_screen);
        }
        if (this.q == null) {
            this.q = new androidx.constraintlayout.widget.c();
            this.q.a(this.p);
        }
        if (configuration.orientation == 1) {
            this.q.d(c.e.danmaku_view, 0);
        } else {
            this.q.d(c.e.danmaku_view, (int) ab.a(260.0f));
        }
        this.q.b(this.p);
    }

    public void setChildMaxHeight(int i2) {
        if (this.j != null && this.h != null) {
            int a2 = (int) w.a(getContext(), 120.0f);
            int viewMarginHeight = (i2 - getViewMarginHeight()) - this.j.getHeight();
            if (viewMarginHeight > a2 || viewMarginHeight <= 0) {
                viewMarginHeight = a2;
            }
            this.h.setmMaxHeight(viewMarginHeight);
        }
    }

    private int getViewMarginHeight() {
        if (!(this.f28901g.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            return 0;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f28901g.getLayoutParams();
        return marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
    }
}
