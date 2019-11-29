package eu.davidea.a;

import android.animation.Animator;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import androidx.core.g.i;
import androidx.core.g.w;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import eu.davidea.flexibleadapter.a.a;
import eu.davidea.flexibleadapter.b.f;
import java.util.List;

public abstract class b extends a implements View.OnClickListener, View.OnLongClickListener, View.OnTouchListener, a.b {

    /* renamed from: a  reason: collision with root package name */
    private static final String f32795a = "b";

    /* renamed from: b  reason: collision with root package name */
    protected final eu.davidea.flexibleadapter.b f32796b;

    /* renamed from: c  reason: collision with root package name */
    protected int f32797c = 0;

    /* renamed from: d  reason: collision with root package name */
    private boolean f32798d = false;

    /* renamed from: e  reason: collision with root package name */
    private boolean f32799e = false;

    public void a(List<Animator> list, int i, boolean z) {
    }

    public View e() {
        return null;
    }

    public View f() {
        return null;
    }

    public float j() {
        return BitmapDescriptorFactory.HUE_RED;
    }

    /* access modifiers changed from: protected */
    public boolean k() {
        return false;
    }

    /* access modifiers changed from: protected */
    public boolean l() {
        return false;
    }

    public /* bridge */ /* synthetic */ void b(int i) {
        super.b(i);
    }

    public /* bridge */ /* synthetic */ View g() {
        return super.g();
    }

    public /* bridge */ /* synthetic */ int h() {
        return super.h();
    }

    public b(View view, eu.davidea.flexibleadapter.b bVar, boolean z) {
        super(view, bVar, z);
        this.f32796b = bVar;
        g().setOnClickListener(this);
        g().setOnLongClickListener(this);
    }

    public void onClick(View view) {
        int h = h();
        if (this.f32796b.a(h) && this.f32796b.f32832e != null && this.f32797c == 0) {
            if (eu.davidea.flexibleadapter.b.k) {
                String str = f32795a;
                Log.v(str, "onClick on position " + h + " mode=" + this.f32796b.o());
            }
            if (!this.f32796b.f32832e.a(h)) {
                return;
            }
            if ((!this.f32796b.i(h) && this.itemView.isActivated()) || (this.f32796b.i(h) && !this.itemView.isActivated())) {
                i();
            }
        }
    }

    public boolean onLongClick(View view) {
        int h = h();
        if (!this.f32796b.a(h)) {
            return false;
        }
        if (eu.davidea.flexibleadapter.b.k) {
            String str = f32795a;
            Log.v(str, "onLongClick on position " + h + " mode=" + this.f32796b.o());
        }
        if (this.f32796b.f32833f == null || this.f32796b.k()) {
            this.f32798d = true;
            return false;
        }
        this.f32796b.f32833f.a(h);
        i();
        return true;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        int h = h();
        if (!this.f32796b.a(h)) {
            return false;
        }
        if (eu.davidea.flexibleadapter.b.k) {
            String str = f32795a;
            Log.v(str, "onTouch with DragHandleView on position " + h + " mode=" + this.f32796b.o());
        }
        if (i.a(motionEvent) == 0 && this.f32796b.l()) {
            this.f32796b.j().b((RecyclerView.w) this);
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public void i() {
        this.itemView.setActivated(this.f32796b.i(h()));
        if (this.itemView.isActivated() && j() > BitmapDescriptorFactory.HUE_RED) {
            w.b(this.itemView, j());
        } else if (j() > BitmapDescriptorFactory.HUE_RED) {
            w.b(this.itemView, (float) BitmapDescriptorFactory.HUE_RED);
        }
    }

    public void a(int i, int i2) {
        this.f32797c = i2;
        this.f32799e = this.f32796b.i(i);
        if (eu.davidea.flexibleadapter.b.k) {
            String str = f32795a;
            StringBuilder sb = new StringBuilder();
            sb.append("onActionStateChanged position=");
            sb.append(i);
            sb.append(" mode=");
            sb.append(this.f32796b.o());
            sb.append(" actionState=");
            sb.append(i2 == 1 ? "Swipe(1)" : "Drag(2)");
            Log.v(str, sb.toString());
        }
        if (i2 == 2) {
            if (!this.f32799e) {
                if ((this.f32798d || this.f32796b.o() == 2) && ((l() || this.f32796b.o() != 2) && this.f32796b.f32833f != null && this.f32796b.b(i))) {
                    this.f32796b.f32833f.a(i);
                    this.f32799e = true;
                }
                if (!this.f32799e) {
                    this.f32796b.c(i);
                }
            }
            if (!this.itemView.isActivated()) {
                i();
            }
        } else if (i2 == 1 && k() && !this.f32799e) {
            this.f32796b.c(i);
            i();
        }
    }

    public void a(int i) {
        if (eu.davidea.flexibleadapter.b.k) {
            String str = f32795a;
            StringBuilder sb = new StringBuilder();
            sb.append("onItemReleased position=");
            sb.append(i);
            sb.append(" mode=");
            sb.append(this.f32796b.o());
            sb.append(" actionState=");
            sb.append(this.f32797c == 1 ? "Swipe(1)" : "Drag(2)");
            Log.v(str, sb.toString());
        }
        if (!this.f32799e) {
            if (l() && this.f32796b.o() == 2) {
                this.f32796b.f32833f.a(i);
                if (this.f32796b.i(i)) {
                    i();
                }
            } else if (k() && this.itemView.isActivated()) {
                this.f32796b.c(i);
                i();
            } else if (this.f32797c == 2) {
                this.f32796b.c(i);
                if (this.itemView.isActivated()) {
                    i();
                }
            }
        }
        this.f32798d = false;
        this.f32797c = 0;
    }

    public boolean b() {
        f d2 = this.f32796b.d(h());
        return d2 != null && d2.e();
    }

    public boolean c() {
        f d2 = this.f32796b.d(h());
        return d2 != null && d2.f();
    }

    public View d() {
        return this.itemView;
    }
}
