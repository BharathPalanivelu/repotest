package life.knowledge4.videotrimmer.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.garena.android.gpns.utility.CONSTANT;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.util.List;
import life.knowledge4.videotrimmer.a;
import life.knowledge4.videotrimmer.a.a;
import life.knowledge4.videotrimmer.a.b;

public class ProgressBarView extends View implements a, b {

    /* renamed from: a  reason: collision with root package name */
    private int f33782a;

    /* renamed from: b  reason: collision with root package name */
    private int f33783b;

    /* renamed from: c  reason: collision with root package name */
    private long f33784c;

    /* renamed from: d  reason: collision with root package name */
    private long f33785d;

    /* renamed from: e  reason: collision with root package name */
    private int f33786e;

    /* renamed from: f  reason: collision with root package name */
    private int f33787f;

    /* renamed from: g  reason: collision with root package name */
    private final Paint f33788g;
    private final Paint h;
    private final Paint i;
    private final Paint j;
    private RectF k;
    private RectF l;
    private int m;
    private int n;
    private int o;
    private String p;
    private RectF q;
    private int r;
    private int s;
    private int t;
    private int u;

    public ProgressBarView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ProgressBarView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f33786e = CONSTANT.TIME.MIN_1;
        this.f33787f = (int) getContext().getResources().getDimension(a.b.dp10);
        this.f33788g = new Paint();
        this.h = new Paint();
        this.i = new Paint();
        this.j = new Paint();
        this.p = "0s selected";
        a();
    }

    private void a() {
        int c2 = androidx.core.content.b.c(getContext(), a.C0529a.progress_color);
        int c3 = androidx.core.content.b.c(getContext(), a.C0529a.background_progress_color);
        int c4 = androidx.core.content.b.c(getContext(), a.C0529a.white);
        int dimensionPixelOffset = getContext().getResources().getDimensionPixelOffset(a.b.trim_duration_text_size);
        this.f33782a = getContext().getResources().getDimensionPixelOffset(a.b.progress_video_line_height);
        this.r = getContext().getResources().getDimensionPixelOffset(a.b.seekbar_width);
        this.f33788g.setAntiAlias(true);
        this.f33788g.setColor(c3);
        this.h.setAntiAlias(true);
        this.h.setColor(c2);
        this.i.setAntiAlias(true);
        this.i.setColor(c4);
        this.j.setAntiAlias(true);
        this.j.setColor(-1);
        this.j.setTextSize((float) dimensionPixelOffset);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        this.f33783b = resolveSizeAndState(getPaddingLeft() + getPaddingRight() + getSuggestedMinimumWidth(), i2, 1);
        this.s = getContext().getResources().getDimensionPixelOffset(a.b.frames_video_height);
        int dimensionPixelOffset = getContext().getResources().getDimensionPixelOffset(a.b.progress_video_view_height);
        this.m = dimensionPixelOffset;
        this.n = getContext().getResources().getDimensionPixelOffset(a.b.trim_duration_text_padding_top);
        this.o = resolveSizeAndState(getPaddingBottom() + getPaddingTop() + dimensionPixelOffset + this.s + this.n, i3, 1);
        setMeasuredDimension(this.f33783b, this.o);
        invalidate();
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        c(canvas);
        d(canvas);
        a(canvas);
        b(canvas);
    }

    private void a(Canvas canvas) {
        RectF rectF = this.q;
        if (rectF != null) {
            canvas.drawRect(rectF, this.i);
        }
    }

    private void b(Canvas canvas) {
        float measureText = this.j.measureText(this.p);
        Rect rect = new Rect();
        this.j.getTextBounds("9", 0, 1, rect);
        canvas.drawText(this.p, ((this.k.left + this.k.right) / 2.0f) - (measureText / 2.0f), (float) (this.o - rect.height()), this.j);
    }

    private void c(Canvas canvas) {
        RectF rectF = this.k;
        if (rectF != null) {
            canvas.drawRect(rectF, this.f33788g);
        }
    }

    private void d(Canvas canvas) {
        RectF rectF = this.l;
        if (rectF != null) {
            canvas.drawRect(rectF, this.h);
        }
    }

    public void a(RangeSeekBarView rangeSeekBarView, int i2, float f2) {
        a(i2, rangeSeekBarView.getThumbs());
        a(rangeSeekBarView);
        invalidate();
    }

    public void b(RangeSeekBarView rangeSeekBarView, int i2, float f2) {
        a(i2, rangeSeekBarView.getThumbs());
        a(rangeSeekBarView);
        invalidate();
    }

    public void c(RangeSeekBarView rangeSeekBarView, int i2, float f2) {
        a(i2, rangeSeekBarView.getThumbs());
        a(rangeSeekBarView);
        invalidate();
    }

    public void d(RangeSeekBarView rangeSeekBarView, int i2, float f2) {
        a(i2, rangeSeekBarView.getThumbs());
        a(rangeSeekBarView);
        invalidate();
    }

    private void a(RangeSeekBarView rangeSeekBarView) {
        List<a> thumbs = rangeSeekBarView.getThumbs();
        int b2 = (int) ((((thumbs.get(1).b() * ((float) this.f33786e)) / 100.0f) - ((thumbs.get(0).b() * ((float) this.f33786e)) / 100.0f)) / 1000.0f);
        float c2 = thumbs.get(0).c();
        float c3 = thumbs.get(1).c();
        if (this.t > 0) {
            this.p = getResources().getString(this.t, new Object[]{Integer.valueOf(b2)});
        } else {
            this.p = b2 + "s selected";
        }
        if (this.j.measureText(this.p) < (c3 - c2) - ((float) a.a(thumbs))) {
            return;
        }
        if (this.u > 0) {
            this.p = getResources().getString(this.u, new Object[]{Integer.valueOf(b2)});
            return;
        }
        this.p = b2 + "s";
    }

    private void a(int i2, List<a> list) {
        RectF rectF = this.k;
        if (rectF == null || ((float) this.m) != rectF.bottom) {
            int i3 = this.f33787f;
            int i4 = this.m;
            this.k = new RectF((float) i3, (float) (i4 - this.f33782a), (float) (this.f33783b - i3), (float) i4);
        }
        float c2 = list.get(i2).c();
        if (i2 == 0) {
            this.k = new RectF(c2 + ((float) (a.a(list) / 2)), this.k.top, this.k.right, this.k.bottom);
        } else {
            this.k = new RectF(this.k.left, this.k.top, c2 + ((float) (a.a(list) / 2)), this.k.bottom);
        }
        a(0, 0, (float) BitmapDescriptorFactory.HUE_RED);
    }

    public void a(long j2, long j3) {
        this.f33784c = j2;
        this.f33785d = j3;
        invalidate();
    }

    public void a(long j2, long j3, float f2) {
        if (f2 == BitmapDescriptorFactory.HUE_RED) {
            this.l = new RectF(BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED);
            this.q = new RectF(this.k.left, this.k.top, this.k.left, this.k.bottom);
        } else {
            long j4 = this.f33784c;
            float f3 = this.k.left + ((this.k.right - this.k.left) * (((float) (j2 - j4)) / ((float) (this.f33785d - j4))));
            this.l = new RectF(this.k.left, this.k.top, f3, this.k.bottom);
            this.q = new RectF(f3 - ((float) (this.r / 2)), this.k.bottom, f3 + ((float) (this.r / 2)), this.k.bottom + ((float) this.s));
        }
        invalidate();
    }

    public void setVisibleDuration(int i2) {
        this.f33786e = i2;
    }

    public void setProgressColor(int i2) {
        this.h.setColor(i2);
    }
}
