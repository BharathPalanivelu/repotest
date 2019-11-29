package com.shopee.app.ui.common;

import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.garena.android.appkit.b.e;
import com.garena.android.appkit.b.g;
import com.garena.android.appkit.f.f;
import com.garena.android.appkit.tools.b;
import com.shopee.app.util.n;
import com.shopee.id.R;
import com.tencent.ijk.media.player.IjkMediaCodecInfo;
import java.util.HashMap;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private final n f21047a;

    /* renamed from: b  reason: collision with root package name */
    private HashMap<Integer, C0312a> f21048b;

    /* renamed from: c  reason: collision with root package name */
    private e f21049c = new g() {
        public void onEvent(com.garena.android.appkit.b.a aVar) {
            a.this.d();
        }
    };

    /* renamed from: d  reason: collision with root package name */
    private e f21050d = new g() {
        public void onEvent(com.garena.android.appkit.b.a aVar) {
            a.this.e();
        }
    };

    public a(n nVar) {
        this.f21047a = nVar;
        this.f21048b = new HashMap<>();
    }

    public void a(int i, FrameLayout frameLayout) {
        if (!this.f21048b.containsKey(Integer.valueOf(i))) {
            this.f21048b.put(Integer.valueOf(i), new C0312a(frameLayout));
        }
        this.f21048b.get(Integer.valueOf(i)).c();
    }

    public void a() {
        c();
        this.f21047a.a("TCP_CONNECTED", this.f21049c);
        this.f21047a.a("TCP_DISCONNECTED", this.f21050d);
    }

    private void c() {
        for (C0312a a2 : this.f21048b.values()) {
            a2.c();
        }
    }

    /* access modifiers changed from: private */
    public void d() {
        for (C0312a b2 : this.f21048b.values()) {
            b2.a();
        }
    }

    /* access modifiers changed from: private */
    public void e() {
        for (C0312a c2 : this.f21048b.values()) {
            c2.b();
        }
    }

    public void b() {
        this.f21047a.b("TCP_CONNECTED", this.f21049c);
        this.f21047a.b("TCP_DISCONNECTED", this.f21050d);
    }

    /* renamed from: com.shopee.app.ui.common.a$a  reason: collision with other inner class name */
    private static class C0312a {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public FrameLayout f21053a;

        /* renamed from: b  reason: collision with root package name */
        private TextView f21054b;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public boolean f21055c = false;

        /* renamed from: d  reason: collision with root package name */
        private Runnable f21056d = new Runnable() {
            public void run() {
                if (C0312a.this.f21053a != null && C0312a.this.f21055c) {
                    Animation loadAnimation = AnimationUtils.loadAnimation(C0312a.this.f21053a.getContext(), R.anim.slide_in_from_up);
                    loadAnimation.setDuration(800);
                    loadAnimation.setInterpolator(new AccelerateDecelerateInterpolator());
                    loadAnimation.setAnimationListener(new Animation.AnimationListener() {
                        public void onAnimationRepeat(Animation animation) {
                        }

                        public void onAnimationStart(Animation animation) {
                            C0312a.this.f21053a.setVisibility(0);
                        }

                        public void onAnimationEnd(Animation animation) {
                            if (com.shopee.app.network.e.c().f()) {
                                f.a().a(C0312a.this.f21057e, 1000);
                            }
                        }
                    });
                    C0312a.this.f21053a.clearAnimation();
                    C0312a.this.f21053a.startAnimation(loadAnimation);
                }
            }
        };
        /* access modifiers changed from: private */

        /* renamed from: e  reason: collision with root package name */
        public Runnable f21057e = new Runnable() {
            public void run() {
                if (C0312a.this.f21053a != null && C0312a.this.f21055c) {
                    Animation loadAnimation = AnimationUtils.loadAnimation(C0312a.this.f21053a.getContext(), R.anim.slide_out_from_top);
                    loadAnimation.setDuration(800);
                    loadAnimation.setInterpolator(new AccelerateInterpolator());
                    loadAnimation.setAnimationListener(new Animation.AnimationListener() {
                        public void onAnimationRepeat(Animation animation) {
                        }

                        public void onAnimationStart(Animation animation) {
                        }

                        public void onAnimationEnd(Animation animation) {
                            C0312a.this.f21053a.setVisibility(8);
                            boolean unused = C0312a.this.f21055c = false;
                        }
                    });
                    C0312a.this.f21053a.clearAnimation();
                    C0312a.this.f21053a.startAnimation(loadAnimation);
                }
            }
        };

        public C0312a(FrameLayout frameLayout) {
            this.f21053a = (FrameLayout) View.inflate(frameLayout.getContext(), R.layout.alert_bar, frameLayout).findViewById(R.id.alert_bar);
            this.f21054b = (TextView) this.f21053a.findViewById(R.id.alert_bar_label);
        }

        /* access modifiers changed from: private */
        public void a() {
            if (this.f21053a != null) {
                this.f21055c = true;
                this.f21054b.setText(b.e(R.string.sp_label_app_status_connected));
                if (this.f21053a.getVisibility() != 0) {
                    f.a().a(this.f21056d, IjkMediaCodecInfo.RANK_LAST_CHANCE);
                } else {
                    f.a().a(this.f21057e, 1000);
                }
            }
        }

        /* access modifiers changed from: private */
        public void b() {
            if (this.f21053a != null) {
                this.f21055c = true;
                this.f21054b.setText(b.e(R.string.sp_label_app_status_connecting));
                if (this.f21053a.getVisibility() != 0) {
                    f.a().a(this.f21056d, IjkMediaCodecInfo.RANK_LAST_CHANCE);
                }
            }
        }

        /* access modifiers changed from: private */
        public void c() {
            if (this.f21053a == null) {
                return;
            }
            if (com.shopee.app.network.e.c().f()) {
                this.f21055c = false;
                this.f21053a.setVisibility(8);
            } else if (com.shopee.app.network.e.c().e()) {
                this.f21055c = true;
                this.f21054b.setText("Connecting...");
                this.f21053a.setVisibility(0);
            }
        }
    }
}
