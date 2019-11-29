package com.shopee.arcatch.page.view;

import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.graphics.Typeface;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.android.gms.vision.face.Face;
import com.shopee.arcatch.a;
import com.shopee.arcatch.c.a.b;
import com.shopee.arcatch.c.h.c;
import com.shopee.arcatch.data.config_bean.ConfigBean;
import com.shopee.arcatch.page.cameraview.common.CameraSourcePreview;
import com.shopee.arcatch.page.cameraview.common.GraphicOverlay;
import com.squareup.a.w;

public class ArCatchFaceMatchView extends FrameLayout {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public int f27000a;

    /* renamed from: b  reason: collision with root package name */
    private CameraSourcePreview f27001b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public GraphicOverlay f27002c;

    /* renamed from: d  reason: collision with root package name */
    private ImageSwitcher f27003d;

    /* renamed from: e  reason: collision with root package name */
    private ImageView f27004e;

    /* renamed from: f  reason: collision with root package name */
    private TextView f27005f;

    /* renamed from: g  reason: collision with root package name */
    private TextView f27006g;
    private com.shopee.arcatch.page.cameraview.common.a h;
    private ImageView i;
    private ImageView j;
    private ImageView k;
    private CountDownTimer l;
    /* access modifiers changed from: private */
    public long m;
    /* access modifiers changed from: private */
    public a n;
    /* access modifiers changed from: private */
    public Handler o;
    private ConfigBean p;

    public interface a {
        void a();
    }

    public ArCatchFaceMatchView(Context context) {
        this(context, (AttributeSet) null);
    }

    public ArCatchFaceMatchView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ArCatchFaceMatchView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f27000a = 0;
        d();
    }

    private void d() {
        LayoutInflater.from(getContext()).inflate(a.d.arcatch_view_face_match, this, true);
        this.f27003d = (ImageSwitcher) findViewById(a.c.arcatch_fm_mask_switcher);
        this.f27004e = (ImageView) findViewById(a.c.arcatch_fm_mask_prepare);
        this.f27001b = (CameraSourcePreview) findViewById(a.c.arcatch_fm_camera_source_preview);
        this.f27002c = (GraphicOverlay) findViewById(a.c.arcatch_fm_graphic_overlay);
        this.f27005f = (TextView) findViewById(a.c.arcatch_fm_desc);
        this.f27006g = (TextView) findViewById(a.c.arcatch_fm_success_hint);
        this.f27003d.setInAnimation(AnimationUtils.loadAnimation(getContext(), a.C0236a.arcatch_fm_fade_in));
        this.f27003d.setOutAnimation(AnimationUtils.loadAnimation(getContext(), a.C0236a.arcatch_fm_fade_out));
        this.i = (ImageView) findViewById(a.c.arcatch_hat_back);
        this.j = (ImageView) findViewById(a.c.arcatch_hat_front);
        this.k = (ImageView) findViewById(a.c.arcatch_fm_front);
        Typeface createFromAsset = Typeface.createFromAsset(getContext().getAssets(), "fonts/Neuzeit Grotesk Black.otf");
        if (createFromAsset != null) {
            this.f27006g.setTypeface(createFromAsset);
        }
        Typeface createFromAsset2 = Typeface.createFromAsset(getContext().getAssets(), "fonts/Roboto-Bold.ttf");
        if (createFromAsset2 != null) {
            this.f27005f.setTypeface(createFromAsset2);
        }
        this.m = 10000;
        this.o = new Handler(Looper.getMainLooper());
        this.p = b.a().b();
        this.f27005f.setText(this.p.textConfigBean.guideDescription);
        this.f27005f.setTextColor(this.p.textConfigBean.guideDescriptionColor);
        this.f27006g.setText(this.p.textConfigBean.faceMatchText);
        this.f27006g.setTextColor(this.p.textConfigBean.faceMatchTextColor);
        String str = this.p.imageConfigBean.hatBackground;
        String str2 = this.p.imageConfigBean.hatForeground;
        String str3 = this.p.imageConfigBean.imageCover;
        if (!TextUtils.isEmpty(str)) {
            w.a(getContext()).a(str).a(this.i);
        }
        if (!TextUtils.isEmpty(str2)) {
            w.a(getContext()).a(str2).a(this.j);
        }
        if (!TextUtils.isEmpty(str3)) {
            w.a(getContext()).a(str3).a(this.k);
        }
    }

    public void a(Activity activity) {
        this.h = new com.shopee.arcatch.page.cameraview.common.a(activity, this.f27002c);
        this.h.a((com.shopee.arcatch.page.cameraview.common.b) new c() {
            /* access modifiers changed from: protected */
            public void b() {
            }

            /* access modifiers changed from: protected */
            public void a(Face face) {
                if (face != null && ArCatchFaceMatchView.this.f27000a == 1) {
                    Point point = new Point();
                    float f2 = com.shopee.arcatch.c.d.a.a().n;
                    int i = com.shopee.arcatch.c.d.a.a().k;
                    float a2 = ArCatchFaceMatchView.this.f27002c.a(face.getPosition().x + (face.getWidth() / 2.0f));
                    float b2 = (ArCatchFaceMatchView.this.f27002c.b(face.getPosition().y + (face.getHeight() / 2.0f)) * f2) + ((float) i);
                    point.x = (int) a2;
                    point.y = (int) b2;
                    if (com.shopee.arcatch.c.d.c.a().a(point)) {
                        ArCatchFaceMatchView.this.o.post(new Runnable() {
                            public void run() {
                                ArCatchFaceMatchView.this.f();
                            }
                        });
                    }
                }
            }
        });
    }

    private void e() {
        try {
            this.f27001b.a(this.h, this.f27002c);
        } catch (Exception e2) {
            com.garena.android.appkit.d.a.a(e2);
            this.h.b();
            this.h = null;
        }
    }

    public void a() {
        if (this.f27000a == 0) {
            this.f27000a = 1;
        }
        e();
        if (this.f27000a == 1) {
            this.l = new CountDownTimer(this.m, 1000) {
                public void onTick(long j) {
                    long unused = ArCatchFaceMatchView.this.m = j;
                }

                public void onFinish() {
                    if (ArCatchFaceMatchView.this.n != null) {
                        ArCatchFaceMatchView.this.n.a();
                    }
                }
            };
            this.l.start();
        }
    }

    public void b() {
        CountDownTimer countDownTimer = this.l;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        this.f27001b.a();
    }

    public void c() {
        CountDownTimer countDownTimer = this.l;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        com.shopee.arcatch.page.cameraview.common.a aVar = this.h;
        if (aVar != null) {
            aVar.b();
        }
    }

    /* access modifiers changed from: private */
    public void f() {
        this.f27000a = 2;
        CountDownTimer countDownTimer = this.l;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        if (this.f27003d.getDisplayedChild() != 1) {
            this.f27003d.setDisplayedChild(1);
            this.f27005f.setVisibility(8);
            this.f27006g.setVisibility(0);
            this.o.postDelayed(new Runnable() {
                public void run() {
                    if (ArCatchFaceMatchView.this.n != null) {
                        ArCatchFaceMatchView.this.n.a();
                    }
                }
            }, 1000);
        }
    }

    public void setOnFaceMatchFinishListener(a aVar) {
        this.n = aVar;
    }
}
