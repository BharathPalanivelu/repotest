package androidx.appcompat.view.menu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.view.menu.m;
import androidx.appcompat.view.menu.n;
import java.util.ArrayList;

public abstract class b implements m {

    /* renamed from: a  reason: collision with root package name */
    protected Context f808a;

    /* renamed from: b  reason: collision with root package name */
    protected Context f809b;

    /* renamed from: c  reason: collision with root package name */
    protected g f810c;

    /* renamed from: d  reason: collision with root package name */
    protected LayoutInflater f811d;

    /* renamed from: e  reason: collision with root package name */
    protected LayoutInflater f812e;

    /* renamed from: f  reason: collision with root package name */
    protected n f813f;

    /* renamed from: g  reason: collision with root package name */
    private m.a f814g;
    private int h;
    private int i;
    private int j;

    public abstract void a(i iVar, n.a aVar);

    public boolean a(int i2, i iVar) {
        return true;
    }

    public boolean a(g gVar, i iVar) {
        return false;
    }

    public boolean b() {
        return false;
    }

    public boolean b(g gVar, i iVar) {
        return false;
    }

    public b(Context context, int i2, int i3) {
        this.f808a = context;
        this.f811d = LayoutInflater.from(context);
        this.h = i2;
        this.i = i3;
    }

    public void a(Context context, g gVar) {
        this.f809b = context;
        this.f812e = LayoutInflater.from(this.f809b);
        this.f810c = gVar;
    }

    public n a(ViewGroup viewGroup) {
        if (this.f813f == null) {
            this.f813f = (n) this.f811d.inflate(this.h, viewGroup, false);
            this.f813f.a(this.f810c);
            a(true);
        }
        return this.f813f;
    }

    public void a(boolean z) {
        ViewGroup viewGroup = (ViewGroup) this.f813f;
        if (viewGroup != null) {
            g gVar = this.f810c;
            int i2 = 0;
            if (gVar != null) {
                gVar.k();
                ArrayList<i> j2 = this.f810c.j();
                int size = j2.size();
                int i3 = 0;
                for (int i4 = 0; i4 < size; i4++) {
                    i iVar = j2.get(i4);
                    if (a(i3, iVar)) {
                        View childAt = viewGroup.getChildAt(i3);
                        i itemData = childAt instanceof n.a ? ((n.a) childAt).getItemData() : null;
                        View a2 = a(iVar, childAt, viewGroup);
                        if (iVar != itemData) {
                            a2.setPressed(false);
                            a2.jumpDrawablesToCurrentState();
                        }
                        if (a2 != childAt) {
                            a(a2, i3);
                        }
                        i3++;
                    }
                }
                i2 = i3;
            }
            while (i2 < viewGroup.getChildCount()) {
                if (!a(viewGroup, i2)) {
                    i2++;
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void a(View view, int i2) {
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        if (viewGroup != null) {
            viewGroup.removeView(view);
        }
        ((ViewGroup) this.f813f).addView(view, i2);
    }

    /* access modifiers changed from: protected */
    public boolean a(ViewGroup viewGroup, int i2) {
        viewGroup.removeViewAt(i2);
        return true;
    }

    public void a(m.a aVar) {
        this.f814g = aVar;
    }

    public m.a a() {
        return this.f814g;
    }

    public n.a b(ViewGroup viewGroup) {
        return (n.a) this.f811d.inflate(this.i, viewGroup, false);
    }

    public View a(i iVar, View view, ViewGroup viewGroup) {
        n.a aVar;
        if (view instanceof n.a) {
            aVar = (n.a) view;
        } else {
            aVar = b(viewGroup);
        }
        a(iVar, aVar);
        return (View) aVar;
    }

    public void a(g gVar, boolean z) {
        m.a aVar = this.f814g;
        if (aVar != null) {
            aVar.a(gVar, z);
        }
    }

    public boolean a(r rVar) {
        m.a aVar = this.f814g;
        if (aVar != null) {
            return aVar.a(rVar);
        }
        return false;
    }

    public int c() {
        return this.j;
    }

    public void a(int i2) {
        this.j = i2;
    }
}
