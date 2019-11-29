package com.google.android.exoplayer2.ui;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import com.google.android.exoplayer2.s.v;
import com.google.android.exoplayer2.ui.a;
import com.google.android.exoplayer2.ui.c;
import java.util.Formatter;
import java.util.Locale;

public class DefaultTimeBar extends View implements c {
    private Point A;
    private boolean B;
    private long C;
    private long D;
    private long E;
    private long F;
    private int G;
    private long[] H;
    private boolean[] I;

    /* renamed from: a  reason: collision with root package name */
    private final Rect f12195a = new Rect();

    /* renamed from: b  reason: collision with root package name */
    private final Rect f12196b = new Rect();

    /* renamed from: c  reason: collision with root package name */
    private final Rect f12197c = new Rect();

    /* renamed from: d  reason: collision with root package name */
    private final Rect f12198d = new Rect();

    /* renamed from: e  reason: collision with root package name */
    private final Paint f12199e = new Paint();

    /* renamed from: f  reason: collision with root package name */
    private final Paint f12200f = new Paint();

    /* renamed from: g  reason: collision with root package name */
    private final Paint f12201g = new Paint();
    private final Paint h = new Paint();
    private final Paint i = new Paint();
    private final Paint j = new Paint();
    private final int k;
    private final int l;
    private final int m;
    private final int n;
    private final int o;
    private final int p;
    private final int q;
    private final int r;
    private final StringBuilder s;
    private final Formatter t;
    private final Runnable u;
    private c.a v;
    private int w;
    private long x;
    private int y;
    private int[] z;

    private static int a(int i2) {
        return i2 | -16777216;
    }

    private static int b(int i2) {
        return (i2 & 16777215) | 855638016;
    }

    private static int c(int i2) {
        return (i2 & 16777215) | -872415232;
    }

    private static int d(int i2) {
        return (i2 & 16777215) | 855638016;
    }

    public DefaultTimeBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.j.setAntiAlias(true);
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        this.r = a(displayMetrics, -50);
        int a2 = a(displayMetrics, 4);
        int a3 = a(displayMetrics, 26);
        int a4 = a(displayMetrics, 4);
        int a5 = a(displayMetrics, 12);
        int a6 = a(displayMetrics, 0);
        int a7 = a(displayMetrics, 16);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, a.C0195a.DefaultTimeBar, 0, 0);
            try {
                this.k = obtainStyledAttributes.getDimensionPixelSize(a.C0195a.DefaultTimeBar_bar_height, a2);
                this.l = obtainStyledAttributes.getDimensionPixelSize(a.C0195a.DefaultTimeBar_touch_target_height, a3);
                this.m = obtainStyledAttributes.getDimensionPixelSize(a.C0195a.DefaultTimeBar_ad_marker_width, a4);
                this.n = obtainStyledAttributes.getDimensionPixelSize(a.C0195a.DefaultTimeBar_scrubber_enabled_size, a5);
                this.o = obtainStyledAttributes.getDimensionPixelSize(a.C0195a.DefaultTimeBar_scrubber_disabled_size, a6);
                this.p = obtainStyledAttributes.getDimensionPixelSize(a.C0195a.DefaultTimeBar_scrubber_dragged_size, a7);
                int i2 = obtainStyledAttributes.getInt(a.C0195a.DefaultTimeBar_played_color, -1);
                int i3 = obtainStyledAttributes.getInt(a.C0195a.DefaultTimeBar_scrubber_color, a(i2));
                int i4 = obtainStyledAttributes.getInt(a.C0195a.DefaultTimeBar_buffered_color, c(i2));
                int i5 = obtainStyledAttributes.getInt(a.C0195a.DefaultTimeBar_unplayed_color, b(i2));
                int i6 = obtainStyledAttributes.getInt(a.C0195a.DefaultTimeBar_ad_marker_color, -1291845888);
                int i7 = obtainStyledAttributes.getInt(a.C0195a.DefaultTimeBar_played_ad_marker_color, d(i6));
                this.f12199e.setColor(i2);
                this.j.setColor(i3);
                this.f12200f.setColor(i4);
                this.f12201g.setColor(i5);
                this.h.setColor(i6);
                this.i.setColor(i7);
            } finally {
                obtainStyledAttributes.recycle();
            }
        } else {
            this.k = a2;
            this.l = a3;
            this.m = a4;
            this.n = a5;
            this.o = a6;
            this.p = a7;
            this.f12199e.setColor(-1);
            this.j.setColor(a(-1));
            this.f12200f.setColor(c(-1));
            this.f12201g.setColor(b(-1));
            this.h.setColor(-1291845888);
        }
        this.s = new StringBuilder();
        this.t = new Formatter(this.s, Locale.getDefault());
        this.u = new Runnable() {
            public void run() {
                DefaultTimeBar.this.a(false);
            }
        };
        this.q = (Math.max(this.o, Math.max(this.n, this.p)) + 1) / 2;
        this.D = -9223372036854775807L;
        this.x = -9223372036854775807L;
        this.w = 20;
        setFocusable(true);
        if (v.f11449a >= 16) {
            a();
        }
    }

    public void setListener(c.a aVar) {
        this.v = aVar;
    }

    public void setKeyTimeIncrement(long j2) {
        com.google.android.exoplayer2.s.a.a(j2 > 0);
        this.w = -1;
        this.x = j2;
    }

    public void setKeyCountIncrement(int i2) {
        com.google.android.exoplayer2.s.a.a(i2 > 0);
        this.w = i2;
        this.x = -9223372036854775807L;
    }

    public void setPosition(long j2) {
        this.E = j2;
        setContentDescription(getProgressText());
        c();
    }

    public void setBufferedPosition(long j2) {
        this.F = j2;
        c();
    }

    public void setDuration(long j2) {
        this.D = j2;
        if (this.B && j2 == -9223372036854775807L) {
            a(true);
        }
        c();
    }

    public void setEnabled(boolean z2) {
        super.setEnabled(z2);
        if (this.B && !z2) {
            a(true);
        }
    }

    public void onDraw(Canvas canvas) {
        canvas.save();
        a(canvas);
        b(canvas);
        canvas.restore();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0026, code lost:
        if (r3 != 3) goto L_0x0081;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouchEvent(android.view.MotionEvent r8) {
        /*
            r7 = this;
            boolean r0 = r7.isEnabled()
            r1 = 0
            if (r0 == 0) goto L_0x0081
            long r2 = r7.D
            r4 = 0
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 > 0) goto L_0x0011
            goto L_0x0081
        L_0x0011:
            android.graphics.Point r0 = r7.a((android.view.MotionEvent) r8)
            int r2 = r0.x
            int r0 = r0.y
            int r3 = r8.getAction()
            r4 = 1
            if (r3 == 0) goto L_0x0066
            r5 = 3
            if (r3 == r4) goto L_0x0057
            r6 = 2
            if (r3 == r6) goto L_0x0029
            if (r3 == r5) goto L_0x0057
            goto L_0x0081
        L_0x0029:
            boolean r8 = r7.B
            if (r8 == 0) goto L_0x0081
            int r8 = r7.r
            if (r0 >= r8) goto L_0x003b
            int r8 = r7.y
            int r2 = r2 - r8
            int r2 = r2 / r5
            int r8 = r8 + r2
            float r8 = (float) r8
            r7.a((float) r8)
            goto L_0x0041
        L_0x003b:
            r7.y = r2
            float r8 = (float) r2
            r7.a((float) r8)
        L_0x0041:
            long r0 = r7.getScrubberPosition()
            r7.C = r0
            com.google.android.exoplayer2.ui.c$a r8 = r7.v
            if (r8 == 0) goto L_0x0050
            long r0 = r7.C
            r8.b(r7, r0)
        L_0x0050:
            r7.c()
            r7.invalidate()
            return r4
        L_0x0057:
            boolean r0 = r7.B
            if (r0 == 0) goto L_0x0081
            int r8 = r8.getAction()
            if (r8 != r5) goto L_0x0062
            r1 = 1
        L_0x0062:
            r7.a((boolean) r1)
            return r4
        L_0x0066:
            float r8 = (float) r2
            float r0 = (float) r0
            boolean r0 = r7.a((float) r8, (float) r0)
            if (r0 == 0) goto L_0x0081
            r7.b()
            r7.a((float) r8)
            long r0 = r7.getScrubberPosition()
            r7.C = r0
            r7.c()
            r7.invalidate()
            return r4
        L_0x0081:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.ui.DefaultTimeBar.onTouchEvent(android.view.MotionEvent):boolean");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0018, code lost:
        if (a(r0) == false) goto L_0x0036;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x001a, code lost:
        removeCallbacks(r4.u);
        postDelayed(r4.u, 1000);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0026, code lost:
        return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onKeyDown(int r5, android.view.KeyEvent r6) {
        /*
            r4 = this;
            boolean r0 = r4.isEnabled()
            if (r0 == 0) goto L_0x0036
            long r0 = r4.getPositionIncrement()
            r2 = 66
            r3 = 1
            if (r5 == r2) goto L_0x0027
            switch(r5) {
                case 21: goto L_0x0013;
                case 22: goto L_0x0014;
                case 23: goto L_0x0027;
                default: goto L_0x0012;
            }
        L_0x0012:
            goto L_0x0036
        L_0x0013:
            long r0 = -r0
        L_0x0014:
            boolean r0 = r4.a((long) r0)
            if (r0 == 0) goto L_0x0036
            java.lang.Runnable r5 = r4.u
            r4.removeCallbacks(r5)
            java.lang.Runnable r5 = r4.u
            r0 = 1000(0x3e8, double:4.94E-321)
            r4.postDelayed(r5, r0)
            return r3
        L_0x0027:
            boolean r0 = r4.B
            if (r0 == 0) goto L_0x0036
            java.lang.Runnable r5 = r4.u
            r4.removeCallbacks(r5)
            java.lang.Runnable r5 = r4.u
            r5.run()
            return r3
        L_0x0036:
            boolean r5 = super.onKeyDown(r5, r6)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.ui.DefaultTimeBar.onKeyDown(int, android.view.KeyEvent):boolean");
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        int mode = View.MeasureSpec.getMode(i3);
        int size = View.MeasureSpec.getSize(i3);
        if (mode == 0) {
            size = this.l;
        } else if (mode != 1073741824) {
            size = Math.min(this.l, size);
        }
        setMeasuredDimension(View.MeasureSpec.getSize(i2), size);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        int i6 = ((i5 - i3) - this.l) / 2;
        int paddingLeft = getPaddingLeft();
        int paddingRight = (i4 - i2) - getPaddingRight();
        int i7 = this.l;
        int i8 = ((i7 - this.k) / 2) + i6;
        this.f12195a.set(paddingLeft, i6, paddingRight, i7 + i6);
        this.f12196b.set(this.f12195a.left + this.q, i8, this.f12195a.right - this.q, this.k + i8);
        c();
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
    }

    @TargetApi(14)
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        if (accessibilityEvent.getEventType() == 4) {
            accessibilityEvent.getText().add(getProgressText());
        }
        accessibilityEvent.setClassName(DefaultTimeBar.class.getName());
    }

    @TargetApi(21)
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(DefaultTimeBar.class.getCanonicalName());
        accessibilityNodeInfo.setContentDescription(getProgressText());
        if (this.D > 0) {
            if (v.f11449a >= 21) {
                accessibilityNodeInfo.addAction(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_FORWARD);
                accessibilityNodeInfo.addAction(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_BACKWARD);
            } else if (v.f11449a >= 16) {
                accessibilityNodeInfo.addAction(4096);
                accessibilityNodeInfo.addAction(8192);
            }
        }
    }

    @TargetApi(16)
    public boolean performAccessibilityAction(int i2, Bundle bundle) {
        if (super.performAccessibilityAction(i2, bundle)) {
            return true;
        }
        if (this.D <= 0) {
            return false;
        }
        if (i2 == 8192) {
            if (a(-getPositionIncrement())) {
                a(false);
            }
        } else if (i2 != 4096) {
            return false;
        } else {
            if (a(getPositionIncrement())) {
                a(false);
            }
        }
        sendAccessibilityEvent(4);
        return true;
    }

    @TargetApi(16)
    private void a() {
        if (getImportantForAccessibility() == 0) {
            setImportantForAccessibility(1);
        }
    }

    private void b() {
        this.B = true;
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(true);
        }
        c.a aVar = this.v;
        if (aVar != null) {
            aVar.a(this, getScrubberPosition());
        }
    }

    /* access modifiers changed from: private */
    public void a(boolean z2) {
        this.B = false;
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(false);
        }
        invalidate();
        c.a aVar = this.v;
        if (aVar != null) {
            aVar.a(this, getScrubberPosition(), z2);
        }
    }

    private void c() {
        this.f12197c.set(this.f12196b);
        this.f12198d.set(this.f12196b);
        long j2 = this.B ? this.C : this.E;
        if (this.D > 0) {
            this.f12197c.right = Math.min(this.f12196b.left + ((int) ((((long) this.f12196b.width()) * this.F) / this.D)), this.f12196b.right);
            this.f12198d.right = Math.min(this.f12196b.left + ((int) ((((long) this.f12196b.width()) * j2) / this.D)), this.f12196b.right);
        } else {
            this.f12197c.right = this.f12196b.left;
            this.f12198d.right = this.f12196b.left;
        }
        invalidate(this.f12195a);
    }

    private void a(float f2) {
        this.f12198d.right = v.a((int) f2, this.f12196b.left, this.f12196b.right);
    }

    private Point a(MotionEvent motionEvent) {
        if (this.z == null) {
            this.z = new int[2];
            this.A = new Point();
        }
        getLocationOnScreen(this.z);
        this.A.set(((int) motionEvent.getRawX()) - this.z[0], ((int) motionEvent.getRawY()) - this.z[1]);
        return this.A;
    }

    private long getScrubberPosition() {
        if (this.f12196b.width() <= 0 || this.D == -9223372036854775807L) {
            return 0;
        }
        return (((long) this.f12198d.width()) * this.D) / ((long) this.f12196b.width());
    }

    private boolean a(float f2, float f3) {
        return this.f12195a.contains((int) f2, (int) f3);
    }

    private void a(Canvas canvas) {
        int height = this.f12196b.height();
        int centerY = this.f12196b.centerY() - (height / 2);
        int i2 = height + centerY;
        if (this.D <= 0) {
            canvas.drawRect((float) this.f12196b.left, (float) centerY, (float) this.f12196b.right, (float) i2, this.f12201g);
            return;
        }
        int i3 = this.f12197c.left;
        int i4 = this.f12197c.right;
        int max = Math.max(Math.max(this.f12196b.left, i4), this.f12198d.right);
        if (max < this.f12196b.right) {
            canvas.drawRect((float) max, (float) centerY, (float) this.f12196b.right, (float) i2, this.f12201g);
        }
        int max2 = Math.max(i3, this.f12198d.right);
        if (i4 > max2) {
            canvas.drawRect((float) max2, (float) centerY, (float) i4, (float) i2, this.f12200f);
        }
        if (this.f12198d.width() > 0) {
            canvas.drawRect((float) this.f12198d.left, (float) centerY, (float) this.f12198d.right, (float) i2, this.f12199e);
        }
        int i5 = this.m / 2;
        for (int i6 = 0; i6 < this.G; i6++) {
            int min = this.f12196b.left + Math.min(this.f12196b.width() - this.m, Math.max(0, ((int) ((((long) this.f12196b.width()) * v.a(this.H[i6], 0, this.D)) / this.D)) - i5));
            canvas.drawRect((float) min, (float) centerY, (float) (min + this.m), (float) i2, this.I[i6] ? this.i : this.h);
        }
    }

    private void b(Canvas canvas) {
        int i2;
        if (this.D > 0) {
            if (this.B || isFocused()) {
                i2 = this.p;
            } else {
                i2 = isEnabled() ? this.n : this.o;
            }
            canvas.drawCircle((float) v.a(this.f12198d.right, this.f12198d.left, this.f12196b.right), (float) this.f12198d.centerY(), (float) (i2 / 2), this.j);
        }
    }

    private String getProgressText() {
        return v.a(this.s, this.t, this.E);
    }

    private long getPositionIncrement() {
        long j2 = this.x;
        if (j2 != -9223372036854775807L) {
            return j2;
        }
        long j3 = this.D;
        if (j3 == -9223372036854775807L) {
            return 0;
        }
        return j3 / ((long) this.w);
    }

    private boolean a(long j2) {
        if (this.D <= 0) {
            return false;
        }
        long scrubberPosition = getScrubberPosition();
        this.C = v.a(scrubberPosition + j2, 0, this.D);
        if (this.C == scrubberPosition) {
            return false;
        }
        if (!this.B) {
            b();
        }
        c.a aVar = this.v;
        if (aVar != null) {
            aVar.b(this, this.C);
        }
        c();
        return true;
    }

    private static int a(DisplayMetrics displayMetrics, int i2) {
        return (int) ((((float) i2) * displayMetrics.density) + 0.5f);
    }
}
