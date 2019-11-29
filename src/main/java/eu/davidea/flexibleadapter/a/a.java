package eu.davidea.flexibleadapter.a;

import android.graphics.Canvas;
import android.view.View;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import androidx.recyclerview.widget.i;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

public class a extends i.a {

    /* renamed from: a  reason: collision with root package name */
    private C0502a f32810a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f32811b = false;

    /* renamed from: c  reason: collision with root package name */
    private boolean f32812c = false;

    /* renamed from: d  reason: collision with root package name */
    private long f32813d = 300;

    /* renamed from: e  reason: collision with root package name */
    private long f32814e = 400;

    /* renamed from: f  reason: collision with root package name */
    private float f32815f = 0.5f;

    /* renamed from: g  reason: collision with root package name */
    private float f32816g = 0.5f;
    private int h = -1;

    /* renamed from: eu.davidea.flexibleadapter.a.a$a  reason: collision with other inner class name */
    public interface C0502a {
        boolean a(int i, int i2);

        void b(RecyclerView.w wVar, int i);

        boolean b(int i, int i2);

        void c(int i, int i2);
    }

    public interface b {
        void a(int i);

        void a(int i, int i2);

        boolean b();

        boolean c();

        View d();

        View e();

        View f();
    }

    public a(C0502a aVar) {
        this.f32810a = aVar;
    }

    public boolean b() {
        return this.f32811b;
    }

    public boolean a(RecyclerView recyclerView, RecyclerView.w wVar, RecyclerView.w wVar2) {
        return wVar.getItemViewType() == wVar2.getItemViewType();
    }

    public float b(RecyclerView.w wVar) {
        return this.f32816g;
    }

    public boolean c() {
        return this.f32812c;
    }

    public float a(RecyclerView.w wVar) {
        return this.f32815f;
    }

    public long a(RecyclerView recyclerView, int i, float f2, float f3) {
        return i == 8 ? this.f32814e : this.f32813d;
    }

    public boolean b(RecyclerView recyclerView, RecyclerView.w wVar, RecyclerView.w wVar2) {
        if (!this.f32810a.a(wVar.getAdapterPosition(), wVar2.getAdapterPosition())) {
            return false;
        }
        this.f32810a.b(wVar.getAdapterPosition(), wVar2.getAdapterPosition());
        return true;
    }

    public void a(RecyclerView.w wVar, int i) {
        if ((wVar instanceof b) && ((b) wVar).d().getTranslationX() != BitmapDescriptorFactory.HUE_RED) {
            this.f32810a.c(wVar.getAdapterPosition(), i);
        }
    }

    public int a(RecyclerView recyclerView, RecyclerView.w wVar) {
        int i;
        RecyclerView.i layoutManager = recyclerView.getLayoutManager();
        int i2 = 3;
        if ((layoutManager instanceof GridLayoutManager) || (layoutManager instanceof StaggeredGridLayoutManager)) {
            i2 = 15;
            i = 0;
        } else if (eu.davidea.flexibleadapter.c.a.a(layoutManager) == 1) {
            i = this.h;
            if (i <= 0) {
                i = 12;
            }
        } else {
            i = this.h;
            if (i <= 0) {
                i = 3;
            }
            i2 = 12;
        }
        if (wVar instanceof b) {
            b bVar = (b) wVar;
            if (!bVar.b()) {
                i2 = 0;
            }
            if (!bVar.c()) {
                i = 0;
            }
        }
        return b(i2, i);
    }

    public void b(RecyclerView.w wVar, int i) {
        this.f32810a.b(wVar, i);
        if (i == 0) {
            super.b(wVar, i);
        } else if (wVar instanceof b) {
            b bVar = (b) wVar;
            bVar.a(wVar.getAdapterPosition(), i);
            if (i == 1) {
                a().b(bVar.d());
            }
        }
    }

    public void d(RecyclerView recyclerView, RecyclerView.w wVar) {
        wVar.itemView.setAlpha(1.0f);
        if (wVar instanceof b) {
            b bVar = (b) wVar;
            a().a(bVar.d());
            a(bVar, 0);
            bVar.a(wVar.getAdapterPosition());
        }
    }

    public void a(Canvas canvas, RecyclerView recyclerView, RecyclerView.w wVar, float f2, float f3, int i, boolean z) {
        RecyclerView.w wVar2 = wVar;
        if (i != 1 || !(wVar2 instanceof b)) {
            super.a(canvas, recyclerView, wVar, f2, f3, i, z);
            return;
        }
        float f4 = f3 != BitmapDescriptorFactory.HUE_RED ? f3 : f2;
        int i2 = 0;
        if (f4 > BitmapDescriptorFactory.HUE_RED) {
            i2 = 8;
        } else if (f4 < BitmapDescriptorFactory.HUE_RED) {
            i2 = 4;
        }
        b bVar = (b) wVar2;
        View d2 = bVar.d();
        a(bVar, i2);
        a().a(canvas, recyclerView, d2, f2, f3, i, z);
    }

    private static void a(b bVar, int i) {
        int i2 = 0;
        if (bVar.f() != null) {
            bVar.f().setVisibility(i == 4 ? 0 : 8);
        }
        if (bVar.e() != null) {
            View e2 = bVar.e();
            if (i != 8) {
                i2 = 8;
            }
            e2.setVisibility(i2);
        }
    }
}
