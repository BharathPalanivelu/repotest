package com.google.android.exoplayer2.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.text.Layout;
import android.text.SpannableStringBuilder;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.RelativeSizeSpan;
import android.util.AttributeSet;
import android.util.Log;
import com.google.android.exoplayer2.p.a;
import com.google.android.exoplayer2.s.v;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

final class b {
    private float A;
    private float B;
    private int C;
    private int D;
    private int E;
    private int F;
    private StaticLayout G;
    private int H;
    private int I;
    private int J;
    private Rect K;

    /* renamed from: a  reason: collision with root package name */
    private final RectF f12210a = new RectF();

    /* renamed from: b  reason: collision with root package name */
    private final float f12211b;

    /* renamed from: c  reason: collision with root package name */
    private final float f12212c;

    /* renamed from: d  reason: collision with root package name */
    private final float f12213d;

    /* renamed from: e  reason: collision with root package name */
    private final float f12214e;

    /* renamed from: f  reason: collision with root package name */
    private final float f12215f;

    /* renamed from: g  reason: collision with root package name */
    private final float f12216g;
    private final TextPaint h;
    private final Paint i;
    private CharSequence j;
    private Layout.Alignment k;
    private Bitmap l;
    private float m;
    private int n;
    private int o;
    private float p;
    private int q;
    private float r;
    private float s;
    private boolean t;
    private boolean u;
    private int v;
    private int w;
    private int x;
    private int y;
    private int z;

    public b(Context context) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes((AttributeSet) null, new int[]{16843287, 16843288}, 0, 0);
        this.f12216g = (float) obtainStyledAttributes.getDimensionPixelSize(0, 0);
        this.f12215f = obtainStyledAttributes.getFloat(1, 1.0f);
        obtainStyledAttributes.recycle();
        float round = (float) Math.round((((float) context.getResources().getDisplayMetrics().densityDpi) * 2.0f) / 160.0f);
        this.f12211b = round;
        this.f12212c = round;
        this.f12213d = round;
        this.f12214e = round;
        this.h = new TextPaint();
        this.h.setAntiAlias(true);
        this.h.setSubpixelText(true);
        this.i = new Paint();
        this.i.setAntiAlias(true);
        this.i.setStyle(Paint.Style.FILL);
    }

    public void a(com.google.android.exoplayer2.p.b bVar, boolean z2, boolean z3, a aVar, float f2, float f3, Canvas canvas, int i2, int i3, int i4, int i5) {
        boolean z4 = bVar.f11070c == null;
        int i6 = -16777216;
        if (z4) {
            if (!TextUtils.isEmpty(bVar.f11068a)) {
                i6 = (!bVar.k || !z2) ? aVar.f11022d : bVar.l;
            } else {
                return;
            }
        }
        if (a(this.j, bVar.f11068a) && v.a((Object) this.k, (Object) bVar.f11069b) && this.l == bVar.f11070c && this.m == bVar.f11071d && this.n == bVar.f11072e && v.a((Object) Integer.valueOf(this.o), (Object) Integer.valueOf(bVar.f11073f)) && this.p == bVar.f11074g && v.a((Object) Integer.valueOf(this.q), (Object) Integer.valueOf(bVar.h)) && this.r == bVar.i && this.s == bVar.j && this.t == z2 && this.u == z3 && this.v == aVar.f11020b && this.w == aVar.f11021c && this.x == i6 && this.z == aVar.f11023e && this.y == aVar.f11024f && v.a((Object) this.h.getTypeface(), (Object) aVar.f11025g) && this.A == f2 && this.B == f3 && this.C == i2 && this.D == i3 && this.E == i4 && this.F == i5) {
            a(canvas, z4);
            return;
        }
        this.j = bVar.f11068a;
        this.k = bVar.f11069b;
        this.l = bVar.f11070c;
        this.m = bVar.f11071d;
        this.n = bVar.f11072e;
        this.o = bVar.f11073f;
        this.p = bVar.f11074g;
        this.q = bVar.h;
        this.r = bVar.i;
        this.s = bVar.j;
        this.t = z2;
        this.u = z3;
        this.v = aVar.f11020b;
        this.w = aVar.f11021c;
        this.x = i6;
        this.z = aVar.f11023e;
        this.y = aVar.f11024f;
        this.h.setTypeface(aVar.f11025g);
        this.A = f2;
        this.B = f3;
        this.C = i2;
        this.D = i3;
        this.E = i4;
        this.F = i5;
        if (z4) {
            a();
        } else {
            b();
        }
        a(canvas, z4);
    }

    private void a() {
        String str;
        int i2;
        int i3;
        int i4;
        int round;
        int i5;
        int i6 = this.E - this.C;
        int i7 = this.F - this.D;
        this.h.setTextSize(this.A);
        int i8 = (int) ((this.A * 0.125f) + 0.5f);
        int i9 = i8 * 2;
        int i10 = i6 - i9;
        float f2 = this.r;
        if (f2 != Float.MIN_VALUE) {
            i10 = (int) (((float) i10) * f2);
        }
        if (i10 <= 0) {
            Log.w("SubtitlePainter", "Skipped drawing subtitle cue (insufficient space)");
            return;
        }
        if (this.u && this.t) {
            str = this.j;
        } else if (!this.t) {
            str = this.j.toString();
        } else {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.j);
            int length = spannableStringBuilder.length();
            AbsoluteSizeSpan[] absoluteSizeSpanArr = (AbsoluteSizeSpan[]) spannableStringBuilder.getSpans(0, length, AbsoluteSizeSpan.class);
            RelativeSizeSpan[] relativeSizeSpanArr = (RelativeSizeSpan[]) spannableStringBuilder.getSpans(0, length, RelativeSizeSpan.class);
            for (AbsoluteSizeSpan removeSpan : absoluteSizeSpanArr) {
                spannableStringBuilder.removeSpan(removeSpan);
            }
            for (RelativeSizeSpan removeSpan2 : relativeSizeSpanArr) {
                spannableStringBuilder.removeSpan(removeSpan2);
            }
            str = spannableStringBuilder;
        }
        CharSequence charSequence = str;
        Layout.Alignment alignment = this.k;
        if (alignment == null) {
            alignment = Layout.Alignment.ALIGN_CENTER;
        }
        Layout.Alignment alignment2 = alignment;
        StaticLayout staticLayout = r8;
        int i11 = i8;
        StaticLayout staticLayout2 = new StaticLayout(charSequence, this.h, i10, alignment2, this.f12215f, this.f12216g, true);
        this.G = staticLayout;
        int height = this.G.getHeight();
        int lineCount = this.G.getLineCount();
        int i12 = 0;
        for (int i13 = 0; i13 < lineCount; i13++) {
            i12 = Math.max((int) Math.ceil((double) this.G.getLineWidth(i13)), i12);
        }
        if (this.r == Float.MIN_VALUE || i12 >= i10) {
            i10 = i12;
        }
        int i14 = i10 + i9;
        float f3 = this.p;
        if (f3 != Float.MIN_VALUE) {
            int round2 = Math.round(((float) i6) * f3) + this.C;
            int i15 = this.q;
            if (i15 == 2) {
                round2 -= i14;
            } else if (i15 == 1) {
                round2 = ((round2 * 2) - i14) / 2;
            }
            i3 = Math.max(round2, this.C);
            i2 = Math.min(i14 + i3, this.E);
        } else {
            i3 = (i6 - i14) / 2;
            i2 = i3 + i14;
        }
        int i16 = i2 - i3;
        if (i16 <= 0) {
            Log.w("SubtitlePainter", "Skipped drawing subtitle cue (invalid horizontal positioning)");
            return;
        }
        float f4 = this.m;
        if (f4 != Float.MIN_VALUE) {
            if (this.n == 0) {
                round = Math.round(((float) i7) * f4);
                i5 = this.D;
            } else {
                int lineBottom = this.G.getLineBottom(0) - this.G.getLineTop(0);
                float f5 = this.m;
                if (f5 >= BitmapDescriptorFactory.HUE_RED) {
                    round = Math.round(f5 * ((float) lineBottom));
                    i5 = this.D;
                } else {
                    round = Math.round((f5 + 1.0f) * ((float) lineBottom));
                    i5 = this.F;
                }
            }
            i4 = round + i5;
            int i17 = this.o;
            if (i17 == 2) {
                i4 -= height;
            } else if (i17 == 1) {
                i4 = ((i4 * 2) - height) / 2;
            }
            int i18 = i4 + height;
            int i19 = this.F;
            if (i18 > i19) {
                i4 = i19 - height;
            } else {
                int i20 = this.D;
                if (i4 < i20) {
                    i4 = i20;
                }
            }
        } else {
            i4 = (this.F - height) - ((int) (((float) i7) * this.B));
        }
        this.G = new StaticLayout(charSequence, this.h, i16, alignment2, this.f12215f, this.f12216g, true);
        this.H = i3;
        this.I = i4;
        this.J = i11;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x005b  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x005e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void b() {
        /*
            r7 = this;
            int r0 = r7.E
            int r1 = r7.C
            int r0 = r0 - r1
            int r2 = r7.F
            int r3 = r7.D
            int r2 = r2 - r3
            float r1 = (float) r1
            float r0 = (float) r0
            float r4 = r7.p
            float r4 = r4 * r0
            float r1 = r1 + r4
            float r3 = (float) r3
            float r2 = (float) r2
            float r4 = r7.m
            float r4 = r4 * r2
            float r3 = r3 + r4
            float r4 = r7.r
            float r0 = r0 * r4
            int r0 = java.lang.Math.round(r0)
            float r4 = r7.s
            r5 = 1
            int r5 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r5 == 0) goto L_0x002e
            float r2 = r2 * r4
            int r2 = java.lang.Math.round(r2)
            goto L_0x0044
        L_0x002e:
            float r2 = (float) r0
            android.graphics.Bitmap r4 = r7.l
            int r4 = r4.getHeight()
            float r4 = (float) r4
            android.graphics.Bitmap r5 = r7.l
            int r5 = r5.getWidth()
            float r5 = (float) r5
            float r4 = r4 / r5
            float r2 = r2 * r4
            int r2 = java.lang.Math.round(r2)
        L_0x0044:
            int r4 = r7.o
            r5 = 1
            r6 = 2
            if (r4 != r6) goto L_0x004d
            float r4 = (float) r0
        L_0x004b:
            float r1 = r1 - r4
            goto L_0x0053
        L_0x004d:
            if (r4 != r5) goto L_0x0053
            int r4 = r0 / 2
            float r4 = (float) r4
            goto L_0x004b
        L_0x0053:
            int r1 = java.lang.Math.round(r1)
            int r4 = r7.q
            if (r4 != r6) goto L_0x005e
            float r4 = (float) r2
        L_0x005c:
            float r3 = r3 - r4
            goto L_0x0064
        L_0x005e:
            if (r4 != r5) goto L_0x0064
            int r4 = r2 / 2
            float r4 = (float) r4
            goto L_0x005c
        L_0x0064:
            int r3 = java.lang.Math.round(r3)
            android.graphics.Rect r4 = new android.graphics.Rect
            int r0 = r0 + r1
            int r2 = r2 + r3
            r4.<init>(r1, r3, r0, r2)
            r7.K = r4
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.ui.b.b():void");
    }

    private void a(Canvas canvas, boolean z2) {
        if (z2) {
            a(canvas);
        } else {
            b(canvas);
        }
    }

    private void a(Canvas canvas) {
        int i2;
        StaticLayout staticLayout = this.G;
        if (staticLayout != null) {
            int save = canvas.save();
            canvas.translate((float) this.H, (float) this.I);
            if (Color.alpha(this.x) > 0) {
                this.i.setColor(this.x);
                canvas.drawRect((float) (-this.J), BitmapDescriptorFactory.HUE_RED, (float) (staticLayout.getWidth() + this.J), (float) staticLayout.getHeight(), this.i);
            }
            if (Color.alpha(this.w) > 0) {
                this.i.setColor(this.w);
                int lineCount = staticLayout.getLineCount();
                float lineTop = (float) staticLayout.getLineTop(0);
                for (int i3 = 0; i3 < lineCount; i3++) {
                    this.f12210a.left = staticLayout.getLineLeft(i3) - ((float) this.J);
                    this.f12210a.right = staticLayout.getLineRight(i3) + ((float) this.J);
                    RectF rectF = this.f12210a;
                    rectF.top = lineTop;
                    rectF.bottom = (float) staticLayout.getLineBottom(i3);
                    lineTop = this.f12210a.bottom;
                    RectF rectF2 = this.f12210a;
                    float f2 = this.f12211b;
                    canvas.drawRoundRect(rectF2, f2, f2, this.i);
                }
            }
            int i4 = this.z;
            boolean z2 = true;
            if (i4 == 1) {
                this.h.setStrokeJoin(Paint.Join.ROUND);
                this.h.setStrokeWidth(this.f12212c);
                this.h.setColor(this.y);
                this.h.setStyle(Paint.Style.FILL_AND_STROKE);
                staticLayout.draw(canvas);
            } else if (i4 == 2) {
                TextPaint textPaint = this.h;
                float f3 = this.f12213d;
                float f4 = this.f12214e;
                textPaint.setShadowLayer(f3, f4, f4, this.y);
            } else if (i4 == 3 || i4 == 4) {
                if (this.z != 3) {
                    z2 = false;
                }
                int i5 = -1;
                if (z2) {
                    i2 = -1;
                } else {
                    i2 = this.y;
                }
                if (z2) {
                    i5 = this.y;
                }
                float f5 = this.f12213d / 2.0f;
                this.h.setColor(this.v);
                this.h.setStyle(Paint.Style.FILL);
                float f6 = -f5;
                this.h.setShadowLayer(this.f12213d, f6, f6, i2);
                staticLayout.draw(canvas);
                this.h.setShadowLayer(this.f12213d, f5, f5, i5);
            }
            this.h.setColor(this.v);
            this.h.setStyle(Paint.Style.FILL);
            staticLayout.draw(canvas);
            this.h.setShadowLayer(BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, 0);
            canvas.restoreToCount(save);
        }
    }

    private void b(Canvas canvas) {
        canvas.drawBitmap(this.l, (Rect) null, this.K, (Paint) null);
    }

    private static boolean a(CharSequence charSequence, CharSequence charSequence2) {
        return charSequence == charSequence2 || (charSequence != null && charSequence.equals(charSequence2));
    }
}
