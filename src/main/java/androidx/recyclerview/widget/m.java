package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.PointF;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

public class m extends RecyclerView.s {

    /* renamed from: a  reason: collision with root package name */
    protected final LinearInterpolator f2958a = new LinearInterpolator();

    /* renamed from: b  reason: collision with root package name */
    protected final DecelerateInterpolator f2959b = new DecelerateInterpolator();

    /* renamed from: c  reason: collision with root package name */
    protected PointF f2960c;

    /* renamed from: d  reason: collision with root package name */
    protected int f2961d = 0;

    /* renamed from: e  reason: collision with root package name */
    protected int f2962e = 0;

    /* renamed from: f  reason: collision with root package name */
    private final float f2963f;

    private int b(int i, int i2) {
        int i3 = i - i2;
        if (i * i3 <= 0) {
            return 0;
        }
        return i3;
    }

    /* access modifiers changed from: protected */
    public void a() {
    }

    public m(Context context) {
        this.f2963f = a(context.getResources().getDisplayMetrics());
    }

    /* access modifiers changed from: protected */
    public void a(View view, RecyclerView.t tVar, RecyclerView.s.a aVar) {
        int b2 = b(view, c());
        int a2 = a(view, d());
        int a3 = a((int) Math.sqrt((double) ((b2 * b2) + (a2 * a2))));
        if (a3 > 0) {
            aVar.a(-b2, -a2, a3, this.f2959b);
        }
    }

    /* access modifiers changed from: protected */
    public void a(int i, int i2, RecyclerView.t tVar, RecyclerView.s.a aVar) {
        if (j() == 0) {
            f();
            return;
        }
        this.f2961d = b(this.f2961d, i);
        this.f2962e = b(this.f2962e, i2);
        if (this.f2961d == 0 && this.f2962e == 0) {
            a(aVar);
        }
    }

    /* access modifiers changed from: protected */
    public void b() {
        this.f2962e = 0;
        this.f2961d = 0;
        this.f2960c = null;
    }

    /* access modifiers changed from: protected */
    public float a(DisplayMetrics displayMetrics) {
        return 25.0f / ((float) displayMetrics.densityDpi);
    }

    /* access modifiers changed from: protected */
    public int a(int i) {
        double b2 = (double) b(i);
        Double.isNaN(b2);
        return (int) Math.ceil(b2 / 0.3356d);
    }

    /* access modifiers changed from: protected */
    public int b(int i) {
        return (int) Math.ceil((double) (((float) Math.abs(i)) * this.f2963f));
    }

    /* access modifiers changed from: protected */
    public int c() {
        PointF pointF = this.f2960c;
        if (pointF == null || pointF.x == BitmapDescriptorFactory.HUE_RED) {
            return 0;
        }
        return this.f2960c.x > BitmapDescriptorFactory.HUE_RED ? 1 : -1;
    }

    /* access modifiers changed from: protected */
    public int d() {
        PointF pointF = this.f2960c;
        if (pointF == null || pointF.y == BitmapDescriptorFactory.HUE_RED) {
            return 0;
        }
        return this.f2960c.y > BitmapDescriptorFactory.HUE_RED ? 1 : -1;
    }

    /* access modifiers changed from: protected */
    public void a(RecyclerView.s.a aVar) {
        PointF d2 = d(i());
        if (d2 == null || (d2.x == BitmapDescriptorFactory.HUE_RED && d2.y == BitmapDescriptorFactory.HUE_RED)) {
            aVar.a(i());
            f();
            return;
        }
        a(d2);
        this.f2960c = d2;
        this.f2961d = (int) (d2.x * 10000.0f);
        this.f2962e = (int) (d2.y * 10000.0f);
        aVar.a((int) (((float) this.f2961d) * 1.2f), (int) (((float) this.f2962e) * 1.2f), (int) (((float) b(10000)) * 1.2f), this.f2958a);
    }

    public int a(int i, int i2, int i3, int i4, int i5) {
        if (i5 == -1) {
            return i3 - i;
        }
        if (i5 == 0) {
            int i6 = i3 - i;
            if (i6 > 0) {
                return i6;
            }
            int i7 = i4 - i2;
            if (i7 < 0) {
                return i7;
            }
            return 0;
        } else if (i5 == 1) {
            return i4 - i2;
        } else {
            throw new IllegalArgumentException("snap preference should be one of the constants defined in SmoothScroller, starting with SNAP_");
        }
    }

    public int a(View view, int i) {
        RecyclerView.i e2 = e();
        if (e2 == null || !e2.g()) {
            return 0;
        }
        RecyclerView.j jVar = (RecyclerView.j) view.getLayoutParams();
        return a(e2.i(view) - jVar.topMargin, e2.k(view) + jVar.bottomMargin, e2.E(), e2.C() - e2.G(), i);
    }

    public int b(View view, int i) {
        RecyclerView.i e2 = e();
        if (e2 == null || !e2.f()) {
            return 0;
        }
        RecyclerView.j jVar = (RecyclerView.j) view.getLayoutParams();
        return a(e2.h(view) - jVar.leftMargin, e2.j(view) + jVar.rightMargin, e2.D(), e2.B() - e2.F(), i);
    }
}
