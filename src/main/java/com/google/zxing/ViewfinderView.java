package com.google.zxing;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.zxing.a.a;
import com.google.zxing.a.b;
import com.google.zxing.b.c;
import com.google.zxing.s;
import java.util.ArrayList;
import java.util.List;

public final class ViewfinderView extends View {

    /* renamed from: a  reason: collision with root package name */
    private c f14439a;

    /* renamed from: b  reason: collision with root package name */
    private final Paint f14440b = new Paint(1);

    /* renamed from: c  reason: collision with root package name */
    private final int f14441c;

    /* renamed from: d  reason: collision with root package name */
    private final int f14442d;

    /* renamed from: e  reason: collision with root package name */
    private final int f14443e;

    /* renamed from: f  reason: collision with root package name */
    private int f14444f;

    /* renamed from: g  reason: collision with root package name */
    private List<y> f14445g;
    private List<y> h;
    private int i;
    private int j;
    private Drawable k;
    private Drawable l;
    private Drawable m;
    private Drawable n;
    private a o;

    public ViewfinderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Resources resources = getResources();
        this.f14441c = resources.getColor(s.a.viewfinder_mask);
        this.f14442d = resources.getColor(s.a.viewfinder_border);
        this.f14443e = resources.getColor(s.a.possible_result_points);
        this.o = new b(resources.getColor(s.a.viewfinder_laser));
        this.f14444f = 0;
        this.f14445g = new ArrayList(5);
        this.h = null;
    }

    public void setCameraManager(c cVar) {
        this.f14439a = cVar;
    }

    public void setOrientation(int i2) {
        this.j = i2;
    }

    public void setCodeType(int i2) {
        this.i = i2;
    }

    public void setScannerAnimation(a aVar) {
        this.o = aVar;
    }

    private void a(Canvas canvas, Rect rect) {
        int width = canvas.getWidth();
        int height = canvas.getHeight();
        this.f14440b.setColor(this.f14441c);
        float f2 = (float) width;
        canvas.drawRect(BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, f2, (float) rect.top, this.f14440b);
        canvas.drawRect(BitmapDescriptorFactory.HUE_RED, (float) rect.top, (float) rect.left, (float) (rect.bottom + 1), this.f14440b);
        Canvas canvas2 = canvas;
        float f3 = f2;
        canvas2.drawRect((float) (rect.right + 1), (float) rect.top, f3, (float) (rect.bottom + 1), this.f14440b);
        canvas2.drawRect(BitmapDescriptorFactory.HUE_RED, (float) (rect.bottom + 1), f3, (float) height, this.f14440b);
    }

    private boolean b() {
        return (this.k == null || this.l == null || this.m == null || this.n == null) ? false : true;
    }

    private void b(Canvas canvas, Rect rect) {
        int i2;
        int i3 = this.f14444f;
        if (i3 < 15) {
            i2 = (i3 * 255) / 15;
        } else {
            i2 = ((30 - i3) * 255) / 15;
        }
        this.f14444f = (this.f14444f + 1) % 30;
        if (b()) {
            this.k.setBounds(rect.left, rect.top, rect.left + this.k.getMinimumWidth(), rect.top + this.k.getMinimumHeight());
            this.k.setAlpha(i2);
            this.k.draw(canvas);
            this.l.setBounds(rect.right - this.l.getMinimumWidth(), rect.top, rect.right, rect.top + this.l.getMinimumHeight());
            this.l.setAlpha(i2);
            this.l.draw(canvas);
            this.m.setBounds(rect.left, rect.bottom - this.m.getMinimumHeight(), rect.left + this.m.getMinimumWidth(), rect.bottom);
            this.m.setAlpha(i2);
            this.m.draw(canvas);
            this.n.setBounds(rect.right - this.n.getMinimumWidth(), rect.bottom - this.n.getMinimumWidth(), rect.right, rect.bottom);
            this.n.setAlpha(i2);
            this.n.draw(canvas);
        } else {
            this.f14440b.setColor(this.f14442d);
            this.f14440b.setAlpha(i2);
            Canvas canvas2 = canvas;
            canvas2.drawRect((float) rect.left, (float) (rect.top - 3), (float) rect.right, (float) rect.top, this.f14440b);
            canvas2.drawRect((float) rect.left, (float) rect.bottom, (float) rect.right, (float) (rect.bottom + 3), this.f14440b);
            canvas2.drawRect((float) (rect.left - 3), (float) (rect.top - 3), (float) rect.left, (float) (rect.bottom + 3), this.f14440b);
            canvas2.drawRect((float) rect.right, (float) (rect.top - 3), (float) (rect.right + 3), (float) (rect.bottom + 3), this.f14440b);
        }
        a aVar = this.o;
        if (aVar != null) {
            int i4 = this.i;
            if (i4 == 1) {
                aVar.a(canvas, rect);
            } else if (i4 == 0) {
                aVar.b(canvas, rect);
            }
        }
    }

    private void a(Canvas canvas, Rect rect, float f2, float f3) {
        List<y> list = this.f14445g;
        List<y> list2 = this.h;
        int i2 = rect.left;
        int i3 = rect.top;
        if (list.isEmpty()) {
            this.h = null;
        } else {
            this.f14445g = new ArrayList(5);
            this.h = list;
            this.f14440b.setAlpha(160);
            this.f14440b.setColor(this.f14443e);
            synchronized (list) {
                for (y next : list) {
                    canvas.drawCircle((float) (((int) (next.a() * f2)) + i2), (float) (((int) (next.b() * f3)) + i3), 6.0f, this.f14440b);
                }
            }
        }
        if (list2 != null) {
            this.f14440b.setAlpha(80);
            this.f14440b.setColor(this.f14443e);
            synchronized (list2) {
                for (y next2 : list2) {
                    canvas.drawCircle((float) (((int) (next2.a() * f2)) + i2), (float) (((int) (next2.b() * f3)) + i3), 3.0f, this.f14440b);
                }
            }
        }
    }

    public void onDraw(Canvas canvas) {
        c cVar = this.f14439a;
        if (cVar != null) {
            Rect e2 = cVar.e();
            Rect f2 = this.f14439a.f();
            if (e2 != null && f2 != null) {
                a(canvas, e2);
                b(canvas, e2);
                a(canvas, e2, ((float) e2.width()) / ((float) f2.width()), ((float) e2.height()) / ((float) f2.height()));
                postInvalidateDelayed(16, e2.left - 6, e2.top - 6, e2.right + 6, e2.bottom + 6);
            }
        }
    }

    public void a() {
        invalidate();
    }

    public void a(y yVar) {
        List<y> list = this.f14445g;
        synchronized (list) {
            list.add(yVar);
            int size = list.size();
            if (size > 20) {
                list.subList(0, size - 10).clear();
            }
        }
    }

    public void a(int i2, int i3, int i4, int i5) {
        if (i2 != -1 && i3 != -1 && i4 != -1 && i5 != -1) {
            this.k = getResources().getDrawable(i2);
            this.l = getResources().getDrawable(i3);
            this.m = getResources().getDrawable(i4);
            this.n = getResources().getDrawable(i5);
        }
    }

    public void a(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        this.k = drawable;
        this.l = drawable2;
        this.m = drawable3;
        this.n = drawable4;
    }
}
