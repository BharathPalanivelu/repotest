package com.shopee.app.react;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import com.facebook.react.ReactInstanceManager;
import com.garena.android.appkit.tools.a.b;
import com.shopee.app.react.a.a;
import com.shopee.app.react.util.c;
import com.shopee.app.ui.a.r;
import com.shopee.app.ui.common.am;
import com.shopee.app.ui.common.j;
import com.shopee.app.ui.common.q;
import com.shopee.app.ui.error.b;
import java.lang.ref.WeakReference;

public class h extends com.shopee.app.ui.a.h {

    /* renamed from: a  reason: collision with root package name */
    View f18680a;

    /* renamed from: b  reason: collision with root package name */
    b f18681b;

    /* renamed from: c  reason: collision with root package name */
    View f18682c;

    /* renamed from: d  reason: collision with root package name */
    WeakReference<r> f18683d = new WeakReference<>((Object) null);
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public final ReactInstanceManager f18684e;

    /* renamed from: f  reason: collision with root package name */
    private final a f18685f;

    /* renamed from: g  reason: collision with root package name */
    private int f18686g = 1;

    public h(Context context, ReactInstanceManager reactInstanceManager, a aVar) {
        super(context);
        this.f18684e = reactInstanceManager;
        this.f18685f = aVar;
    }

    public void setProcessingIndicator(int i) {
        this.f18686g = i;
    }

    public void setContentView(View view) {
        this.f18680a = view;
        View view2 = this.f18680a;
        if (view2 instanceof r) {
            this.f18683d = new WeakReference<>((r) view2);
        } else {
            this.f18683d = new WeakReference<>((Object) null);
        }
        addView(this.f18680a, new FrameLayout.LayoutParams(-1, -1));
        a();
    }

    private void a() {
        if (!this.f18685f.g()) {
            View a2 = c.a(getContext());
            a2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    h.this.f18684e.showDevOptionsDialog();
                }
            });
            addView(a2, a2.getLayoutParams());
        }
    }

    public void b() {
        r rVar = (r) this.f18683d.get();
        if (rVar != null) {
            rVar.b();
        }
    }

    public void c() {
        r rVar = (r) this.f18683d.get();
        if (rVar != null) {
            rVar.c();
        }
    }

    public void d() {
        r rVar = (r) this.f18683d.get();
        if (rVar != null) {
            rVar.d();
        }
    }

    public void a(boolean z) {
        if (z) {
            if (this.f18682c == null) {
                int i = this.f18686g;
                if (i != 3) {
                    if (i == 0) {
                        this.f18682c = new q().a(getContext());
                        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(b.a.q, b.a.q);
                        layoutParams.gravity = 17;
                        FrameLayout frameLayout = (FrameLayout) ((Activity) getContext()).findViewById(16908290);
                        if (frameLayout != null) {
                            frameLayout.addView(this.f18682c, layoutParams);
                        }
                    } else if (i == 2) {
                        this.f18682c = new j().a(getContext());
                        new FrameLayout.LayoutParams(-1, -1).gravity = 48;
                        addView(this.f18682c);
                    } else {
                        this.f18682c = new am().a(getContext());
                        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, com.garena.android.appkit.tools.b.d());
                        layoutParams2.gravity = 80;
                        FrameLayout frameLayout2 = (FrameLayout) ((Activity) getContext()).findViewById(16908290);
                        if (frameLayout2 != null) {
                            frameLayout2.addView(this.f18682c, layoutParams2);
                        }
                    }
                }
            }
        } else if (this.f18682c != null) {
            final FrameLayout frameLayout3 = (FrameLayout) ((Activity) getContext()).findViewById(16908290);
            if (frameLayout3 != null) {
                Animation loadAnimation = AnimationUtils.loadAnimation(getContext(), 17432577);
                loadAnimation.setAnimationListener(new Animation.AnimationListener() {
                    public void onAnimationRepeat(Animation animation) {
                    }

                    public void onAnimationStart(Animation animation) {
                    }

                    public void onAnimationEnd(Animation animation) {
                        if (h.this.f18682c != null) {
                            frameLayout3.removeView(h.this.f18682c);
                            h hVar = h.this;
                            hVar.removeView(hVar.f18682c);
                            h.this.f18682c = null;
                        }
                    }
                });
                this.f18682c.startAnimation(loadAnimation);
            }
        }
    }

    public void a(boolean z, boolean z2, b.a aVar) {
        if (z) {
            if (this.f18681b == null) {
                this.f18681b = com.shopee.app.ui.error.c.a(getContext());
                this.f18681b.a(z2);
                addView(this.f18681b, new FrameLayout.LayoutParams(-1, -1));
            }
            this.f18681b.setCallback(aVar);
            a(false);
            return;
        }
        com.shopee.app.ui.error.b bVar = this.f18681b;
        if (bVar != null) {
            removeView(bVar);
            this.f18681b = null;
        }
    }
}
