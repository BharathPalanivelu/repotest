package life.knowledge4.videotrimmer.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import cn.tongdun.android.shell.settings.Constants;
import com.garena.android.gpns.utility.CONSTANT;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.util.ArrayList;
import java.util.List;
import life.knowledge4.videotrimmer.a;
import life.knowledge4.videotrimmer.a.b;

public class RangeSeekBarView extends View {

    /* renamed from: a  reason: collision with root package name */
    private static final String f33789a = "RangeSeekBarView";

    /* renamed from: b  reason: collision with root package name */
    private int f33790b;

    /* renamed from: c  reason: collision with root package name */
    private int f33791c;

    /* renamed from: d  reason: collision with root package name */
    private List<a> f33792d;

    /* renamed from: e  reason: collision with root package name */
    private List<b> f33793e;

    /* renamed from: f  reason: collision with root package name */
    private float f33794f;

    /* renamed from: g  reason: collision with root package name */
    private float f33795g;
    private float h;
    private int i;
    private float j;
    private float k;
    private float l;
    private boolean m;
    private final Paint n;
    private final Paint o;
    private final Paint p;
    private final Paint q;
    private long r;
    private float s;
    private int t;
    private int u;
    private int v;

    public RangeSeekBarView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RangeSeekBarView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f33790b = (int) getContext().getResources().getDimension(a.b.dp10);
        this.n = new Paint();
        this.o = new Paint();
        this.p = new Paint();
        this.q = new Paint();
        this.t = CONSTANT.TIME.MIN_1;
        this.u = 0;
        c();
    }

    public void setDuration(long j2) {
        this.r = j2;
    }

    private void c() {
        this.f33792d = a.a(getResources());
        this.f33795g = (float) a.a(this.f33792d);
        this.h = (float) a.b(this.f33792d);
        this.l = 100.0f;
        this.f33791c = getContext().getResources().getDimensionPixelOffset(a.b.frames_video_height);
        setFocusable(true);
        setFocusableInTouchMode(true);
        this.m = true;
        int c2 = androidx.core.content.b.c(getContext(), a.C0529a.shadow_color);
        this.n.setAntiAlias(true);
        this.n.setColor(c2);
        this.n.setAlpha(177);
        int c3 = androidx.core.content.b.c(getContext(), a.C0529a.line_color);
        this.o.setAntiAlias(true);
        this.o.setColor(c3);
        this.o.setAlpha(200);
        this.p.setColor(-1);
        this.p.setTextSize(20.0f);
        this.p.setAntiAlias(true);
        this.q.setColor(-1);
        this.q.setAntiAlias(true);
        this.q.setStrokeWidth(1.0f);
        this.q.setStyle(Paint.Style.FILL_AND_STROKE);
    }

    public void a() {
        this.f33794f = this.f33792d.get(1).c() - this.f33792d.get(0).c();
        d(this, 0, this.f33792d.get(0).b());
        d(this, 1, this.f33792d.get(1).b());
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        this.i = resolveSizeAndState(getPaddingLeft() + getPaddingRight() + getSuggestedMinimumWidth(), i2, 1);
        int paddingBottom = getPaddingBottom() + getPaddingTop();
        double d2 = (double) this.h;
        Double.isNaN(d2);
        setMeasuredDimension(this.i, resolveSizeAndState(paddingBottom + ((int) (d2 / 1.5d)) + this.f33791c, i3, 1));
        this.j = BitmapDescriptorFactory.HUE_RED;
        this.k = ((float) this.i) - this.f33795g;
        if (this.m) {
            for (int i4 = 0; i4 < this.f33792d.size(); i4++) {
                a aVar = this.f33792d.get(i4);
                float f2 = (float) i4;
                aVar.a(this.l * f2);
                aVar.b(this.k * f2);
            }
            int i5 = this.u;
            a(this, i5, b(i5));
            this.m = false;
        }
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        a(canvas);
        b(canvas);
    }

    public void b() {
        invalidate();
    }

    public void setVisibleDuration(int i2) {
        this.t = i2;
        d();
    }

    private void d() {
        int i2 = this.v;
        if (i2 != 0) {
            this.s = (float) ((i2 * Constants.DEFAULT_WAIT_TIME) / this.t);
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        float x = motionEvent.getX();
        int action = motionEvent.getAction();
        if (action == 0) {
            this.u = a(x);
            int i2 = this.u;
            if (i2 == -1) {
                return false;
            }
            a aVar = this.f33792d.get(i2);
            aVar.c(x);
            c(this, this.u, aVar.b());
            return true;
        } else if (action == 1) {
            int i3 = this.u;
            if (i3 == -1) {
                return false;
            }
            d(this, this.u, this.f33792d.get(i3).b());
            return true;
        } else if (action != 2) {
            return false;
        } else {
            a aVar2 = this.f33792d.get(this.u);
            a aVar3 = this.f33792d.get(this.u == 0 ? 1 : 0);
            float e2 = x - aVar2.e();
            float c2 = aVar2.c() + e2;
            Log.d("THUMB_DEBUG", "CHANGE OF " + e2 + " INTO" + c2 + " FOR THUMB " + this.u);
            if (this.u == 0) {
                if (((float) aVar2.f()) + c2 + this.s >= aVar3.c()) {
                    aVar2.b((aVar3.c() - this.s) - ((float) aVar2.f()));
                    Log.d("THUMB_DEBUG", "1 Set thumb " + this.u + " to position " + aVar2.c());
                } else {
                    float f2 = this.j;
                    if (c2 <= f2) {
                        aVar2.b(f2);
                        Log.d("THUMB_DEBUG", "2 Set thumb " + this.u + " to position " + aVar2.c());
                    } else {
                        a(aVar2, aVar3, e2, true);
                        aVar2.b(aVar2.c() + e2);
                        aVar2.c(x);
                        Log.d("THUMB_DEBUG", "3 Set thumb " + this.u + " to position " + aVar2.c());
                    }
                }
            } else if (c2 <= aVar3.c() + ((float) aVar3.f()) + this.s) {
                aVar2.b(aVar3.c() + ((float) aVar2.f()) + this.s);
                Log.d("THUMB_DEBUG", "1 Set thumb " + this.u + " to position " + aVar2.c());
            } else {
                float f3 = this.k;
                if (c2 >= f3) {
                    aVar2.b(f3);
                    Log.d("THUMB_DEBUG", "2 Set thumb " + this.u + " to position " + aVar2.c());
                } else {
                    a(aVar3, aVar2, e2, false);
                    aVar2.b(aVar2.c() + e2);
                    aVar2.c(x);
                    Log.d("THUMB_DEBUG", "3 Set thumb " + this.u + " to position " + aVar2.c());
                }
            }
            b(this.u, aVar2.c());
            Log.d("THUMB_DEBUG", "Final Set thumb " + this.u + " to position " + aVar2.c());
            invalidate();
            return true;
        }
    }

    private void a(a aVar, a aVar2, float f2, boolean z) {
        if (!z || f2 >= BitmapDescriptorFactory.HUE_RED) {
            if (!z && f2 > BitmapDescriptorFactory.HUE_RED && (aVar2.c() + f2) - aVar.c() > this.f33794f) {
                aVar.b((aVar2.c() + f2) - this.f33794f);
                b(0, aVar.c());
            }
        } else if (aVar2.c() - (aVar.c() + f2) > this.f33794f) {
            aVar2.b(aVar.c() + f2 + this.f33794f);
            b(1, aVar2.c());
        }
    }

    private void a(int i2) {
        if (i2 < this.f33792d.size() && !this.f33792d.isEmpty()) {
            a aVar = this.f33792d.get(i2);
            aVar.a(a(i2, aVar.c()));
            b(this, i2, aVar.b());
        }
    }

    private float b(int i2) {
        return this.f33792d.get(i2).b();
    }

    private float a(int i2, float f2) {
        float f3 = this.k;
        float f4 = (f2 * 100.0f) / f3;
        if (i2 == 0) {
            return f4 + ((((this.f33795g * f4) / 100.0f) * 100.0f) / f3);
        }
        return f4 - (((((100.0f - f4) * this.f33795g) / 100.0f) * 100.0f) / f3);
    }

    private void b(int i2, float f2) {
        this.f33792d.get(i2).b(f2);
        a(i2);
        invalidate();
    }

    private int a(float f2) {
        int i2 = -1;
        if (!this.f33792d.isEmpty()) {
            for (int i3 = 0; i3 < this.f33792d.size(); i3++) {
                a aVar = this.f33792d.get(i3);
                if (i3 == 0) {
                    float c2 = aVar.c() + ((float) getPaddingLeft()) + this.f33795g + 30.0f;
                    if (f2 >= (aVar.c() + ((float) getPaddingLeft())) - 30.0f && f2 <= c2) {
                        i2 = this.f33792d.get(i3).a();
                    }
                } else {
                    float c3 = (aVar.c() - ((float) getPaddingRight())) - 30.0f;
                    float f3 = this.f33795g + c3 + 30.0f;
                    if (f2 >= c3 && f2 <= f3) {
                        i2 = this.f33792d.get(i3).a();
                    }
                }
            }
        }
        return i2;
    }

    private void a(Canvas canvas) {
        if (!this.f33792d.isEmpty()) {
            for (a next : this.f33792d) {
                if (next.a() == 0) {
                    float c2 = next.c() + ((float) getPaddingLeft());
                    if (c2 > this.j) {
                        int i2 = this.f33790b;
                        canvas.drawRect(new Rect(i2, 0, (int) (c2 + ((float) i2)), this.f33791c), this.n);
                    }
                } else {
                    float c3 = next.c() - ((float) getPaddingRight());
                    if (c3 < this.k) {
                        int i3 = this.f33790b;
                        canvas.drawRect(new Rect(((int) c3) + i3, 0, this.i - i3, this.f33791c), this.n);
                    }
                }
            }
        }
    }

    private void b(Canvas canvas) {
        if (!this.f33792d.isEmpty()) {
            for (a next : this.f33792d) {
                if (next.a() == 0) {
                    Log.d("THUMB", next.c() + " left");
                    canvas.drawBitmap(next.d(), next.c() + ((float) getPaddingLeft()), (float) getPaddingTop(), (Paint) null);
                } else {
                    Log.d("THUMB", next.c() + " right");
                    canvas.drawBitmap(next.d(), next.c() - ((float) getPaddingRight()), (float) getPaddingTop(), (Paint) null);
                }
            }
        }
    }

    public void a(b bVar) {
        if (this.f33793e == null) {
            this.f33793e = new ArrayList();
        }
        this.f33793e.add(bVar);
    }

    private void a(RangeSeekBarView rangeSeekBarView, int i2, float f2) {
        List<b> list = this.f33793e;
        if (list != null) {
            for (b a2 : list) {
                a2.a(rangeSeekBarView, i2, f2);
            }
        }
    }

    private void b(RangeSeekBarView rangeSeekBarView, int i2, float f2) {
        List<b> list = this.f33793e;
        if (list != null) {
            for (b b2 : list) {
                b2.b(rangeSeekBarView, i2, f2);
            }
        }
    }

    private void c(RangeSeekBarView rangeSeekBarView, int i2, float f2) {
        List<b> list = this.f33793e;
        if (list != null) {
            for (b c2 : list) {
                c2.c(rangeSeekBarView, i2, f2);
            }
        }
    }

    private void d(RangeSeekBarView rangeSeekBarView, int i2, float f2) {
        List<b> list = this.f33793e;
        if (list != null) {
            for (b d2 : list) {
                d2.d(rangeSeekBarView, i2, f2);
            }
        }
    }

    public List<a> getThumbs() {
        return this.f33792d;
    }

    public long getDuration() {
        return this.r;
    }

    public void setThumbnailContainerWidth(int i2) {
        this.v = i2;
        d();
    }
}
