package com.google.android.exoplayer2.ui;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.CaptioningManager;
import com.google.android.exoplayer2.p.a;
import com.google.android.exoplayer2.p.b;
import com.google.android.exoplayer2.p.k;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.util.ArrayList;
import java.util.List;

public final class SubtitleView extends View implements k.a {

    /* renamed from: a  reason: collision with root package name */
    private final List<b> f12203a;

    /* renamed from: b  reason: collision with root package name */
    private List<b> f12204b;

    /* renamed from: c  reason: collision with root package name */
    private int f12205c;

    /* renamed from: d  reason: collision with root package name */
    private float f12206d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f12207e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f12208f;

    /* renamed from: g  reason: collision with root package name */
    private a f12209g;
    private float h;

    public SubtitleView(Context context) {
        this(context, (AttributeSet) null);
    }

    public SubtitleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f12203a = new ArrayList();
        this.f12205c = 0;
        this.f12206d = 0.0533f;
        this.f12207e = true;
        this.f12208f = true;
        this.f12209g = a.f11019a;
        this.h = 0.08f;
    }

    public void a(List<b> list) {
        setCues(list);
    }

    public void setCues(List<b> list) {
        int i;
        if (this.f12204b != list) {
            this.f12204b = list;
            if (list == null) {
                i = 0;
            } else {
                i = list.size();
            }
            while (this.f12203a.size() < i) {
                this.f12203a.add(new b(getContext()));
            }
            invalidate();
        }
    }

    public void setFractionalTextSize(float f2) {
        a(f2, false);
    }

    public void a(float f2, boolean z) {
        a(z ? 1 : 0, f2);
    }

    private void a(int i, float f2) {
        if (this.f12205c != i || this.f12206d != f2) {
            this.f12205c = i;
            this.f12206d = f2;
            invalidate();
        }
    }

    public void setApplyEmbeddedStyles(boolean z) {
        if (this.f12207e != z || this.f12208f != z) {
            this.f12207e = z;
            this.f12208f = z;
            invalidate();
        }
    }

    public void setApplyEmbeddedFontSizes(boolean z) {
        if (this.f12208f != z) {
            this.f12208f = z;
            invalidate();
        }
    }

    public void setStyle(a aVar) {
        if (this.f12209g != aVar) {
            this.f12209g = aVar;
            invalidate();
        }
    }

    public void setBottomPaddingFraction(float f2) {
        if (this.h != f2) {
            this.h = f2;
            invalidate();
        }
    }

    public void dispatchDraw(Canvas canvas) {
        float f2;
        List<b> list = this.f12204b;
        int i = 0;
        int size = list == null ? 0 : list.size();
        int top = getTop();
        int bottom = getBottom();
        int left = getLeft() + getPaddingLeft();
        int paddingTop = getPaddingTop() + top;
        int right = getRight() + getPaddingRight();
        int paddingBottom = bottom - getPaddingBottom();
        if (paddingBottom > paddingTop && right > left) {
            int i2 = this.f12205c;
            if (i2 == 2) {
                f2 = this.f12206d;
            } else {
                f2 = this.f12206d * ((float) (i2 == 0 ? paddingBottom - paddingTop : bottom - top));
            }
            if (f2 > BitmapDescriptorFactory.HUE_RED) {
                while (i < size) {
                    int i3 = paddingBottom;
                    int i4 = right;
                    this.f12203a.get(i).a(this.f12204b.get(i), this.f12207e, this.f12208f, this.f12209g, f2, this.h, canvas, left, paddingTop, i4, i3);
                    i++;
                    paddingBottom = i3;
                    right = i4;
                }
            }
        }
    }

    @TargetApi(19)
    private float getUserCaptionFontScaleV19() {
        return ((CaptioningManager) getContext().getSystemService("captioning")).getFontScale();
    }

    @TargetApi(19)
    private a getUserCaptionStyleV19() {
        return a.a(((CaptioningManager) getContext().getSystemService("captioning")).getUserStyle());
    }
}
