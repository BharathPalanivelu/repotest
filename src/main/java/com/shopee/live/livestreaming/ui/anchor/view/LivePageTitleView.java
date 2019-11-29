package com.shopee.live.livestreaming.ui.anchor.view;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.Layout;
import android.text.SpannableString;
import android.text.StaticLayout;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.constraintlayout.widget.c;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.shopee.live.livestreaming.c;
import com.shopee.live.livestreaming.data.entity.LiveStreamingSessionEntity;
import com.shopee.live.livestreaming.util.ab;
import com.shopee.live.livestreaming.util.d;
import com.shopee.live.livestreaming.util.f;
import com.shopee.live.livestreaming.util.l;
import com.shopee.live.livestreaming.util.o;
import com.shopee.live.livestreaming.util.q;
import com.shopee.live.livestreaming.util.w;
import com.shopee.sdk.modules.ui.a.a;

public class LivePageTitleView extends ConstraintLayout implements View.OnClickListener {
    private a A;
    private int B;
    /* access modifiers changed from: private */
    public String C;
    private c D;
    private c E;
    private ConstraintLayout F;

    /* renamed from: g  reason: collision with root package name */
    ImageView f28890g;
    TextView h;
    CheckBox i;
    View j;
    Group k;
    TextView l;
    l m;
    c n;
    c o;
    int p;
    int q;
    int r;
    int s;
    int t;
    int u;
    private int v;
    private View w;
    /* access modifiers changed from: private */
    public ObjectAnimator x;
    /* access modifiers changed from: private */
    public ObjectAnimator y;
    private Interpolator z;

    public interface a {
        void a();

        void a(int i, int i2, int i3, int i4);
    }

    public LivePageTitleView(Context context) {
        this(context, (AttributeSet) null);
    }

    public LivePageTitleView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public LivePageTitleView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.D = new c();
        this.E = new c();
        f();
    }

    private void f() {
        this.w = LayoutInflater.from(getContext()).inflate(c.f.live_streaming_layout_title, this, true);
        this.f28890g = (ImageView) findViewById(c.e.iv_page_close);
        this.h = (TextView) findViewById(c.e.tv_live_streaming_title);
        this.i = (CheckBox) findViewById(c.e.cb_title_expand);
        this.j = findViewById(c.e.view_title_expand_bg);
        this.k = (Group) findViewById(c.e.rl_title_expand_info);
        this.l = (TextView) findViewById(c.e.tv_title_info);
        this.f28890g.setOnClickListener(this);
        this.j.setOnClickListener(this);
        this.h.setOnClickListener(this);
        this.h.setLineSpacing(BitmapDescriptorFactory.HUE_RED, 1.1f);
        this.l.setLineSpacing(BitmapDescriptorFactory.HUE_RED, 1.2f);
        this.m = new l(getContext());
        this.m.a((l.a) new l.a() {
            public void a() {
                o.a((Activity) LivePageTitleView.this.getContext(), f.a().h(), f.a().f(), "KOL", f.a().d());
            }

            public void a(int i) {
                o.a((Activity) LivePageTitleView.this.getContext());
            }
        });
        this.z = new DecelerateInterpolator();
        this.y = ObjectAnimator.ofFloat(this.j, "alpha", new float[]{BitmapDescriptorFactory.HUE_RED, 1.0f});
        this.y.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.getAnimatedFraction() > BitmapDescriptorFactory.HUE_RED && LivePageTitleView.this.k.getVisibility() != 0) {
                    LivePageTitleView.this.k.setVisibility(0);
                }
                LivePageTitleView.this.k.setAlpha(valueAnimator.getAnimatedFraction());
                if (Build.VERSION.SDK_INT >= 18) {
                    LivePageTitleView.this.k.setClipBounds(new Rect(0, 0, LivePageTitleView.this.k.getMeasuredWidth(), (int) (((float) LivePageTitleView.this.k.getMeasuredHeight()) * valueAnimator.getAnimatedFraction())));
                }
            }
        });
        this.y.setDuration(300);
        this.y.setInterpolator(this.z);
        View view = this.j;
        this.x = ObjectAnimator.ofFloat(view, "alpha", new float[]{view.getAlpha(), 0.0f});
        this.x.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.getAnimatedFraction() > BitmapDescriptorFactory.HUE_RED) {
                    LivePageTitleView.this.k.setVisibility(8);
                }
                if (valueAnimator.getAnimatedFraction() >= 1.0f) {
                    LivePageTitleView.this.j.setVisibility(8);
                }
            }
        });
        this.x.setDuration(300);
        this.x.setInterpolator(this.z);
        this.i.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton compoundButton, final boolean z) {
                if (z) {
                    LivePageTitleView.this.j.setVisibility(0);
                    LivePageTitleView.this.l.setVisibility(0);
                    LivePageTitleView.this.y.start();
                    if (d.a(LivePageTitleView.this.getContext().getApplicationContext()) == 1) {
                        com.garena.android.appkit.f.f.a().a(new Runnable() {
                            public void run() {
                                LivePageTitleView.this.b(0);
                                LivePageTitleView.this.a(LivePageTitleView.this.h, LivePageTitleView.this.C, z);
                            }
                        });
                        return;
                    }
                    LivePageTitleView livePageTitleView = LivePageTitleView.this;
                    livePageTitleView.a(livePageTitleView.h, LivePageTitleView.this.C, z);
                    return;
                }
                LivePageTitleView.this.l.setVisibility(8);
                LivePageTitleView.this.x.start();
                if (d.a(LivePageTitleView.this.getContext().getApplicationContext()) == 1) {
                    com.garena.android.appkit.f.f.a().a(new Runnable() {
                        public void run() {
                            LivePageTitleView.this.b(1);
                            LivePageTitleView.this.a(LivePageTitleView.this.h, LivePageTitleView.this.C, z);
                        }
                    });
                    return;
                }
                LivePageTitleView livePageTitleView2 = LivePageTitleView.this;
                livePageTitleView2.a(livePageTitleView2.h, LivePageTitleView.this.C, z);
            }
        });
        this.B = (w.a(getContext()) - (com.garena.android.appkit.tools.b.d(c.C0439c.live_streaming_title_horizontal_padding) * 2)) - com.garena.android.appkit.tools.b.d(c.C0439c.live_streaming_title_close_btn_left_margin);
        this.h.setMaxWidth(this.B);
        this.F = (ConstraintLayout) findViewById(c.e.title_layout);
        this.E.a(getContext().getApplicationContext(), c.f.live_streaming_layout_title_landscape);
        this.D.a(this.F);
    }

    public void onClick(View view) {
        if (view.getId() == c.e.iv_page_close) {
            if (d.a(getContext().getApplicationContext()) != 1 || this.A == null) {
                com.shopee.live.livestreaming.ui.anchor.b.k();
                if (q.b(this.v)) {
                    com.shopee.sdk.b.a().c().a((Activity) getContext(), new a.C0472a().c(com.garena.android.appkit.tools.b.e(c.g.live_streaming_btn_confirm)).d(com.garena.android.appkit.tools.b.e(c.g.live_streaming_btn_cancel)).b(com.garena.android.appkit.tools.b.e(c.g.live_streaming_host_terminate_the_streaming_tip)).a(), new com.shopee.sdk.f.b<Integer>() {
                        public void a(int i, String str) {
                        }

                        public void a(Integer num) {
                            int intValue = num.intValue();
                            if (intValue != 0) {
                                if (intValue == 1) {
                                    com.shopee.live.livestreaming.ui.anchor.b.m();
                                    LivePageTitleView.this.m.a(0);
                                    return;
                                } else if (intValue != 2) {
                                    return;
                                }
                            }
                            com.shopee.live.livestreaming.ui.anchor.b.n();
                        }
                    });
                    com.shopee.live.livestreaming.ui.anchor.b.l();
                    return;
                }
                com.shopee.live.livestreaming.ui.audience.c.a();
                ((Activity) getContext()).finish();
                return;
            }
            if (q.d(this.v)) {
                com.shopee.live.livestreaming.ui.audience.c.M();
            } else {
                com.shopee.live.livestreaming.ui.audience.c.G();
            }
            this.A.a();
        } else if (view.getId() == c.e.view_title_expand_bg) {
            if (!this.y.isRunning() && !this.x.isRunning() && this.i.isChecked()) {
                this.i.setChecked(false);
            }
        } else if (view.getId() == c.e.tv_live_streaming_title && !this.y.isRunning() && !this.x.isRunning()) {
            CheckBox checkBox = this.i;
            checkBox.setChecked(!checkBox.isChecked());
        }
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        a aVar = this.A;
        if (aVar != null) {
            aVar.a(i2, i3, i4, i5);
        }
    }

    public void setData(LiveStreamingSessionEntity liveStreamingSessionEntity) {
        this.m.a(liveStreamingSessionEntity);
        if (!d.a(liveStreamingSessionEntity.getSession().getTitle())) {
            this.C = liveStreamingSessionEntity.getSession().getTitle();
            a(this.h, this.C, this.i.isChecked());
        }
        if (!d.a(liveStreamingSessionEntity.getSession().getDescription())) {
            this.l.setText(liveStreamingSessionEntity.getSession().getDescription());
        }
    }

    public void setTitle(String str) {
        this.h.setText(str);
    }

    public void setTitleExpandText(String str) {
        this.l.setText(str);
    }

    public void b() {
        this.v = 17;
        this.f28890g.setVisibility(8);
    }

    public void c() {
        this.v = 18;
        this.f28890g.setVisibility(0);
    }

    public void d() {
        this.v = 20;
        this.f28890g.setVisibility(0);
    }

    public void e() {
        this.v = 21;
        this.f28890g.setVisibility(0);
    }

    public void setSizeChangeListener(a aVar) {
        this.A = aVar;
    }

    /* access modifiers changed from: private */
    public void a(TextView textView, String str, boolean z2) {
        if (!TextUtils.isEmpty(str)) {
            int i2 = d.a(getContext().getApplicationContext()) == 1 ? 1 : 2;
            StaticLayout staticLayout = new StaticLayout(str, textView.getPaint(), this.B, Layout.Alignment.ALIGN_NORMAL, 1.1f, 1.0f, false);
            if (z2) {
                i2 = 100;
            }
            Drawable f2 = com.garena.android.appkit.tools.b.f(z2 ? c.d.live_streaming_ic_title_no_expand : c.d.live_streaming_ic_title_expand);
            f2.setBounds(8, 0, f2.getMinimumWidth(), f2.getMinimumHeight());
            if (staticLayout.getLineCount() > i2) {
                SpannableString spannableString = new SpannableString(str.substring(0, (staticLayout.getLineStart(i2) - 1) - 5) + ".....");
                spannableString.setSpan(new b(f2), spannableString.length() - 2, spannableString.length(), 18);
                textView.setText(spannableString);
                return;
            }
            SpannableString spannableString2 = new SpannableString(str + "..");
            spannableString2.setSpan(new b(f2), spannableString2.length() - 2, spannableString2.length(), 17);
            textView.setText(spannableString2);
        }
    }

    class b extends ImageSpan {
        public b(Drawable drawable) {
            super(drawable);
        }

        public void draw(Canvas canvas, CharSequence charSequence, int i, int i2, float f2, int i3, int i4, int i5, Paint paint) {
            Drawable drawable = getDrawable();
            canvas.save();
            canvas.translate(f2, (float) ((((i5 - i3) - drawable.getBounds().bottom) / 2) + i3));
            drawable.draw(canvas);
            canvas.restore();
        }

        public int getSize(Paint paint, CharSequence charSequence, int i, int i2, Paint.FontMetricsInt fontMetricsInt) {
            Rect bounds = getDrawable().getBounds();
            if (fontMetricsInt != null) {
                Paint.FontMetricsInt fontMetricsInt2 = paint.getFontMetricsInt();
                int i3 = fontMetricsInt2.bottom - fontMetricsInt2.top;
                int i4 = (bounds.bottom - bounds.top) / 2;
                int i5 = i3 / 4;
                int i6 = i4 - i5;
                int i7 = -(i4 + i5);
                fontMetricsInt.ascent = i7;
                fontMetricsInt.top = i7;
                fontMetricsInt.bottom = i6;
                fontMetricsInt.descent = i6;
            }
            return bounds.right;
        }
    }

    /* access modifiers changed from: private */
    public void b(int i2) {
        if (this.n == null) {
            this.n = new androidx.constraintlayout.widget.c();
            this.n.a(this.F);
            this.n.a(c.e.tv_live_streaming_title);
            this.n.d(c.e.tv_live_streaming_title, (int) (((float) w.a(getContext())) - ab.a(95.0f)));
            this.n.a(c.e.tv_live_streaming_title, 1, 0, 1, (int) ab.a(15.0f));
        }
        if (this.o == null) {
            this.o = new androidx.constraintlayout.widget.c();
            this.o.a(this.F);
            this.o.a(c.e.cb_title_expand, 2, c.e.iv_page_close, 1, (int) ab.a(22.0f));
            this.o.a(c.e.tv_live_streaming_title, 2, c.e.cb_title_expand, 1, 0);
        }
        getViewVisibility();
        if (i2 == 0) {
            this.n.b(this.F);
            this.h.setGravity(19);
        } else if (i2 == 1) {
            this.o.b(this.F);
            this.h.setGravity(21);
        }
        g();
    }

    /* access modifiers changed from: protected */
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        getViewVisibility();
        if (configuration.orientation == 1) {
            this.D.b(this.F);
            this.h.setGravity(8388627);
            this.f28890g.setImageResource(c.d.live_streaming_ic_page_close);
        } else {
            this.E.b(this.F);
            this.h.setGravity(8388629);
            this.f28890g.setImageResource(c.d.live_streaming_ic_page_back_to_portrait);
        }
        g();
        if (configuration.orientation != 1 && this.p == 0) {
            if (q.d(this.v)) {
                com.shopee.live.livestreaming.ui.audience.c.L();
            } else {
                com.shopee.live.livestreaming.ui.audience.c.F();
            }
        }
        a(this.h, this.C, this.i.isChecked());
    }

    private void getViewVisibility() {
        this.p = this.f28890g.getVisibility();
        this.q = this.h.getVisibility();
        this.r = this.i.getVisibility();
        this.s = this.j.getVisibility();
        this.t = this.k.getVisibility();
        this.u = this.l.getVisibility();
    }

    private void g() {
        this.f28890g.setVisibility(this.p);
        this.h.setVisibility(this.q);
        this.i.setVisibility(this.r);
        this.j.setVisibility(this.s);
        this.k.setVisibility(this.t);
        this.l.setVisibility(this.u);
    }
}
