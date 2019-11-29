package com.shopee.livequiz.ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.shopee.livequiz.c;
import com.shopee.livequiz.g.i;
import com.shopee.livequiz.ui.view.CountDownCircleView;

public class CountDownTimerView extends LinearLayout {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public CountDownCircleView f29967a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public GradientTextView f29968b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public boolean f29969c;

    public interface a {
        void a();
    }

    public CountDownTimerView(Context context) {
        this(context, (AttributeSet) null);
    }

    public CountDownTimerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CountDownTimerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        View inflate = View.inflate(context, c.f.livesdk_shopee_layout_count_down_timer, this);
        this.f29967a = (CountDownCircleView) inflate.findViewById(c.d.count_down_circle);
        this.f29968b = (GradientTextView) inflate.findViewById(c.d.count_down_text);
    }

    public void a(int i, final a aVar) {
        this.f29968b.a(c.a.livequiz_count_down_blue_start, c.a.livequiz_count_down_blue_end);
        this.f29968b.setText(String.valueOf(i));
        this.f29967a.setCountdownTime((long) ((i + 1) * 1000));
        this.f29967a.a(getResources().getColor(c.a.livequiz_count_down_blue_start), getResources().getColor(c.a.livequiz_count_down_blue_end));
        this.f29967a.setCountDownListener(new CountDownCircleView.a() {
            public void a(int i) {
                int i2 = i - 1;
                if (i2 == 3) {
                    CountDownTimerView.this.f29967a.a(CountDownTimerView.this.getResources().getColor(c.a.livequiz_count_down_yellow_start), CountDownTimerView.this.getResources().getColor(c.a.livequiz_count_down_yellow_end));
                    CountDownTimerView.this.f29968b.a(c.a.livequiz_count_down_yellow_start, c.a.livequiz_count_down_yellow_end);
                } else if (i2 == 0) {
                    CountDownTimerView.this.f29968b.a(c.a.livequiz_text_count_down_grey, c.a.livequiz_text_count_down_grey);
                }
                CountDownTimerView.this.f29968b.setText(String.valueOf(Math.max(i2, 0)));
                if (!CountDownTimerView.this.f29969c) {
                    if (i2 == 3) {
                        i.a().d();
                    } else if (i2 == 0) {
                        i.a().e();
                        i.a().f();
                    }
                }
            }

            public void a() {
                a aVar = aVar;
                if (aVar != null) {
                    aVar.a();
                }
            }
        });
        this.f29967a.a();
    }

    public void a() {
        this.f29967a.b();
    }

    public void a(boolean z) {
        this.f29969c = z;
    }

    public void b() {
        this.f29967a.c();
    }
}
