package com.shopee.livequiz.ui.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.garena.android.appkit.tools.b;
import com.shopee.livequiz.c;
import com.shopee.livequiz.g.e;
import com.shopee.livequiz.g.j;

public class CountDownProgressView extends RelativeLayout {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public ProgressBar f29962a;

    /* renamed from: b  reason: collision with root package name */
    private TextView f29963b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public a f29964c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public ValueAnimator f29965d;

    public interface a {
        void a();

        void b();
    }

    public CountDownProgressView(Context context) {
        this(context, (AttributeSet) null);
    }

    public CountDownProgressView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CountDownProgressView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        View inflate = View.inflate(context, c.f.livesdk_shopee_layout_extra_life_progress_bar, this);
        this.f29962a = (ProgressBar) inflate.findViewById(c.d.progress_bar);
        this.f29963b = (TextView) inflate.findViewById(c.d.tv_notice);
        this.f29965d = ValueAnimator.ofInt(new int[]{0, this.f29962a.getMax()});
        this.f29965d.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                CountDownProgressView.this.f29962a.setProgress(intValue);
                if (CountDownProgressView.this.f29964c != null) {
                    if (intValue <= 0) {
                        CountDownProgressView.this.f29964c.a();
                    } else if (intValue >= CountDownProgressView.this.f29962a.getMax()) {
                        CountDownProgressView.this.f29964c.b();
                        a unused = CountDownProgressView.this.f29964c = null;
                    }
                }
                CountDownProgressView.this.setText((((int) (CountDownProgressView.this.f29965d.getDuration() / 1000)) * (CountDownProgressView.this.f29962a.getMax() - intValue)) / CountDownProgressView.this.f29962a.getMax());
            }
        });
    }

    /* access modifiers changed from: private */
    public void setText(int i) {
        String a2 = e.a().a("t_ls_use_life_btn");
        if (!j.a(a2)) {
            a2 = a2.replace("{countdown time}", i + "");
        }
        this.f29963b.setText(a2);
    }

    public void a(long j, a aVar) {
        if (this.f29965d.isRunning()) {
            this.f29965d.cancel();
        }
        this.f29965d.setDuration(j);
        this.f29964c = aVar;
        this.f29965d.start();
        setText((int) (j / 1000));
    }

    public void a(int i, int i2) {
        if (Build.VERSION.SDK_INT >= 21) {
            int[][] iArr = {new int[0]};
            int[] iArr2 = {i};
            this.f29962a.setProgressBackgroundTintList(new ColorStateList(iArr, iArr2));
            this.f29962a.setProgressTintList(new ColorStateList(iArr, new int[]{i2}));
            return;
        }
        ClipDrawable clipDrawable = new ClipDrawable(b.f(c.C0454c.livequiz_bg_extra_life_progress_bar_background), 8388611, 1);
        clipDrawable.setLevel(10000);
        clipDrawable.setColorFilter(i, PorterDuff.Mode.SRC_ATOP);
        ClipDrawable clipDrawable2 = new ClipDrawable(b.f(c.C0454c.livequiz_bg_extra_life_progress_bar_progress), 8388611, 1);
        clipDrawable2.setColorFilter(i2, PorterDuff.Mode.SRC_ATOP);
        LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{clipDrawable, clipDrawable2, clipDrawable2});
        layerDrawable.setId(0, 16908288);
        layerDrawable.setId(1, 16908303);
        layerDrawable.setId(2, 16908301);
        this.f29962a.setProgressDrawable(layerDrawable);
        ProgressBar progressBar = this.f29962a;
        progressBar.setProgress(progressBar.getProgress());
    }

    public void setListener(a aVar) {
        this.f29964c = aVar;
    }
}
