package androidx.recyclerview.widget;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.shopee.live.livestreaming.data.entity.RNCartPanelDataEntity;

public abstract class p {

    /* renamed from: a  reason: collision with root package name */
    protected final RecyclerView.i f2965a;

    /* renamed from: b  reason: collision with root package name */
    final Rect f2966b;

    /* renamed from: c  reason: collision with root package name */
    private int f2967c;

    public abstract int a(View view);

    public abstract void a(int i);

    public abstract int b(View view);

    public abstract int c();

    public abstract int c(View view);

    public abstract int d();

    public abstract int d(View view);

    public abstract int e();

    public abstract int e(View view);

    public abstract int f();

    public abstract int f(View view);

    public abstract int g();

    public abstract int h();

    public abstract int i();

    private p(RecyclerView.i iVar) {
        this.f2967c = RNCartPanelDataEntity.NULL_VALUE;
        this.f2966b = new Rect();
        this.f2965a = iVar;
    }

    public void a() {
        this.f2967c = f();
    }

    public int b() {
        if (Integer.MIN_VALUE == this.f2967c) {
            return 0;
        }
        return f() - this.f2967c;
    }

    public static p a(RecyclerView.i iVar, int i) {
        if (i == 0) {
            return a(iVar);
        }
        if (i == 1) {
            return b(iVar);
        }
        throw new IllegalArgumentException("invalid orientation");
    }

    public static p a(RecyclerView.i iVar) {
        return new p(iVar) {
            public int d() {
                return this.f2965a.B() - this.f2965a.F();
            }

            public int e() {
                return this.f2965a.B();
            }

            public void a(int i) {
                this.f2965a.j(i);
            }

            public int c() {
                return this.f2965a.D();
            }

            public int e(View view) {
                RecyclerView.j jVar = (RecyclerView.j) view.getLayoutParams();
                return this.f2965a.f(view) + jVar.leftMargin + jVar.rightMargin;
            }

            public int f(View view) {
                RecyclerView.j jVar = (RecyclerView.j) view.getLayoutParams();
                return this.f2965a.g(view) + jVar.topMargin + jVar.bottomMargin;
            }

            public int b(View view) {
                return this.f2965a.j(view) + ((RecyclerView.j) view.getLayoutParams()).rightMargin;
            }

            public int a(View view) {
                return this.f2965a.h(view) - ((RecyclerView.j) view.getLayoutParams()).leftMargin;
            }

            public int c(View view) {
                this.f2965a.a(view, true, this.f2966b);
                return this.f2966b.right;
            }

            public int d(View view) {
                this.f2965a.a(view, true, this.f2966b);
                return this.f2966b.left;
            }

            public int f() {
                return (this.f2965a.B() - this.f2965a.D()) - this.f2965a.F();
            }

            public int g() {
                return this.f2965a.F();
            }

            public int h() {
                return this.f2965a.z();
            }

            public int i() {
                return this.f2965a.A();
            }
        };
    }

    public static p b(RecyclerView.i iVar) {
        return new p(iVar) {
            public int d() {
                return this.f2965a.C() - this.f2965a.G();
            }

            public int e() {
                return this.f2965a.C();
            }

            public void a(int i) {
                this.f2965a.k(i);
            }

            public int c() {
                return this.f2965a.E();
            }

            public int e(View view) {
                RecyclerView.j jVar = (RecyclerView.j) view.getLayoutParams();
                return this.f2965a.g(view) + jVar.topMargin + jVar.bottomMargin;
            }

            public int f(View view) {
                RecyclerView.j jVar = (RecyclerView.j) view.getLayoutParams();
                return this.f2965a.f(view) + jVar.leftMargin + jVar.rightMargin;
            }

            public int b(View view) {
                return this.f2965a.k(view) + ((RecyclerView.j) view.getLayoutParams()).bottomMargin;
            }

            public int a(View view) {
                return this.f2965a.i(view) - ((RecyclerView.j) view.getLayoutParams()).topMargin;
            }

            public int c(View view) {
                this.f2965a.a(view, true, this.f2966b);
                return this.f2966b.bottom;
            }

            public int d(View view) {
                this.f2965a.a(view, true, this.f2966b);
                return this.f2966b.top;
            }

            public int f() {
                return (this.f2965a.C() - this.f2965a.E()) - this.f2965a.G();
            }

            public int g() {
                return this.f2965a.G();
            }

            public int h() {
                return this.f2965a.A();
            }

            public int i() {
                return this.f2965a.z();
            }
        };
    }
}
