package eu.davidea.flexibleadapter;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.core.g.w;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.tencent.ijk.media.player.IjkMediaCodecInfo;
import eu.davidea.flexibleadapter.a.a;
import eu.davidea.flexibleadapter.b.d;
import eu.davidea.flexibleadapter.b.e;
import eu.davidea.flexibleadapter.b.f;
import eu.davidea.flexibleadapter.b.g;
import eu.davidea.flexibleadapter.b.h;
import eu.davidea.flexibleadapter.d;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class b<T extends f> extends a implements a.C0502a {
    private static int T = IjkMediaCodecInfo.RANK_LAST_CHANCE;
    /* access modifiers changed from: private */
    public static final String o = "b";
    private static final String p = (o + "_parentSelected");
    private static final String q = (o + "_childSelected");
    private static final String r = (o + "_headersShown");
    private static final String s = (o + "_selectedLevel");
    private static final String t = (o + "_searchText");
    private boolean A = false;
    /* access modifiers changed from: private */
    public boolean B = false;
    private boolean C = false;
    private boolean D = false;
    private boolean E = true;
    /* access modifiers changed from: private */
    public boolean F = true;
    private List<g> G;
    /* access modifiers changed from: private */
    public boolean H = false;
    /* access modifiers changed from: private */
    public boolean I = false;
    private boolean J = false;
    /* access modifiers changed from: private */
    public eu.davidea.flexibleadapter.a.b K;
    @SuppressLint({"UseSparseArrays"})
    private HashMap<Integer, T> L = new HashMap<>();
    private boolean M = false;
    private String N = "";
    private String O = "";
    private Set<d> P;
    private boolean Q = false;
    /* access modifiers changed from: private */
    public boolean R = false;
    private boolean S = false;
    private int U = 0;
    private int V = -1;
    private boolean W = false;
    private boolean X = false;
    private boolean Y = false;
    private boolean Z = false;
    private boolean aa = false;
    private eu.davidea.flexibleadapter.a.a ab;
    private androidx.recyclerview.widget.i ac;
    private int ad = 1;
    private boolean ae = false;
    /* access modifiers changed from: private */
    public T af;

    /* renamed from: b  reason: collision with root package name */
    protected Handler f32829b = new Handler(Looper.getMainLooper(), new Handler.Callback() {
        public boolean handleMessage(Message message) {
            int i = message.what;
            if (i == 0 || i == 1) {
                if (b.this.y != null) {
                    b.this.y.cancel(true);
                }
                b bVar = b.this;
                c unused = bVar.y = new c(message.what, (List) message.obj);
                b.this.y.execute(new Void[0]);
                return true;
            } else if (i == 2) {
                f fVar = (f) message.obj;
                if (fVar != null) {
                    fVar.a();
                }
                b.this.f();
                return true;
            } else if (i == 8) {
                b.this.s();
                return true;
            } else if (i != 9) {
                return false;
            } else {
                b.this.t();
                return true;
            }
        }
    });

    /* renamed from: c  reason: collision with root package name */
    protected LayoutInflater f32830c;

    /* renamed from: d  reason: collision with root package name */
    protected l f32831d;

    /* renamed from: e  reason: collision with root package name */
    public g f32832e;

    /* renamed from: f  reason: collision with root package name */
    public h f32833f;

    /* renamed from: g  reason: collision with root package name */
    protected i f32834g;
    protected j h;
    protected k i;
    protected C0503b j;
    /* access modifiers changed from: private */
    public List<T> u;
    private List<T> v;
    private Set<T> w;
    private List<d> x;
    /* access modifiers changed from: private */
    public b<T>.c y;
    private List<b<T>.m> z;

    /* renamed from: eu.davidea.flexibleadapter.b$b  reason: collision with other inner class name */
    public interface C0503b {
        void a();
    }

    public interface e {
        void a(RecyclerView.w wVar, int i);
    }

    public interface f {
        void a();
    }

    public interface g {
        boolean a(int i);
    }

    public interface h {
        void a(int i);
    }

    public interface i extends e {
        boolean a(int i, int i2);

        void b(int i, int i2);
    }

    public interface j extends e {
        void a(int i, int i2);
    }

    public interface k {
        void a(int i);
    }

    public interface l {
        void a(int i);
    }

    public b(List<T> list, Object obj, boolean z2) {
        super(z2);
        if (list == null) {
            this.u = new ArrayList();
        } else {
            this.u = list;
        }
        this.z = new ArrayList();
        this.G = new ArrayList();
        a(obj);
        registerAdapterDataObserver(new a());
    }

    public b a(Object obj) {
        if (obj instanceof l) {
            this.f32831d = (l) obj;
            this.f32831d.a(getItemCount());
        }
        if (obj instanceof g) {
            this.f32832e = (g) obj;
        }
        if (obj instanceof h) {
            this.f32833f = (h) obj;
        }
        if (obj instanceof i) {
            this.f32834g = (i) obj;
        }
        if (obj instanceof j) {
            this.h = (j) obj;
        }
        if (obj instanceof k) {
            this.i = (k) obj;
        }
        return this;
    }

    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        eu.davidea.flexibleadapter.a.b bVar = this.K;
        if (bVar != null && this.H) {
            bVar.a(this.l);
        }
    }

    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        eu.davidea.flexibleadapter.a.b bVar = this.K;
        if (bVar != null) {
            bVar.b(this.l);
            this.K = null;
        }
        super.onDetachedFromRecyclerView(recyclerView);
    }

    public b b() {
        a(true);
        this.B = true;
        for (int i2 = 0; i2 < this.u.size(); i2++) {
            f d2 = d(i2);
            if (e(d2)) {
                a(i2, false, true);
                if (!this.H && b(d2) && !d2.c()) {
                    this.H = true;
                }
            }
        }
        this.B = false;
        a(false);
        return this;
    }

    public boolean a(int i2) {
        f d2 = d(i2);
        return d2 != null && d2.b();
    }

    public boolean b(int i2) {
        f d2 = d(i2);
        return d2 != null && d2.d();
    }

    public void c(int i2) {
        f d2 = d(i2);
        if (d2 != null && d2.d()) {
            d g2 = g(d2);
            boolean z2 = g2 != null;
            if ((f(d2) || !z2) && !this.Y) {
                this.Z = true;
                if (z2) {
                    this.V = g2.h();
                }
                super.c(i2);
            } else if ((!this.Z && z2 && g2.h() + 1 == this.V) || this.V == -1) {
                this.Y = true;
                this.V = g2.h() + 1;
                super.c(i2);
            }
        }
        if (p() == 0) {
            this.V = -1;
            this.Y = false;
            this.Z = false;
        }
    }

    public void c() {
        this.Y = false;
        this.Z = false;
        super.c();
    }

    public void a(List<T> list) {
        a(list, false);
    }

    public void a(List<T> list, boolean z2) {
        if (z2) {
            this.f32829b.removeMessages(0);
            Handler handler = this.f32829b;
            handler.sendMessage(Message.obtain(handler, 0, list));
            return;
        }
        if (list == null) {
            this.u = new ArrayList();
        } else {
            this.u = new ArrayList(list);
        }
        g(true);
    }

    public final T d(int i2) {
        if (i2 < 0 || i2 >= this.u.size()) {
            return null;
        }
        return (f) this.u.get(i2);
    }

    public long getItemId(int i2) {
        f d2 = d(i2);
        if (d2 != null) {
            return (long) d2.hashCode();
        }
        return -1;
    }

    public final int getItemCount() {
        List<T> list = this.u;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    public int a(f fVar) {
        if (fVar != null) {
            List<T> list = this.u;
            if (list != null && !list.isEmpty()) {
                return this.u.indexOf(fVar);
            }
        }
        return -1;
    }

    public boolean b(T t2) {
        return t2 != null && (t2 instanceof g);
    }

    public boolean c(T t2) {
        return d(t2) != null;
    }

    public boolean a(T t2, g gVar) {
        g d2 = d(t2);
        return (d2 == null || gVar == null || !d2.equals(gVar)) ? false : true;
    }

    public g d(T t2) {
        if (t2 == null || !(t2 instanceof h)) {
            return null;
        }
        return ((h) t2).g();
    }

    public g e(int i2) {
        if (!this.H) {
            return null;
        }
        while (i2 >= 0) {
            f d2 = d(i2);
            if (b(d2)) {
                return (g) d2;
            }
            i2--;
        }
        return null;
    }

    public List<h> a(g gVar) {
        ArrayList arrayList = new ArrayList();
        int a2 = a((f) gVar) + 1;
        f d2 = d(a2);
        while (a(d2, gVar)) {
            arrayList.add((h) d2);
            a2++;
            d2 = d(a2);
        }
        return arrayList;
    }

    public b d() {
        return d(true);
    }

    private b d(final boolean z2) {
        this.f32829b.post(new Runnable() {
            public void run() {
                if (z2) {
                    boolean unused = b.this.I = true;
                    if (b.this.K == null) {
                        b bVar = b.this;
                        eu.davidea.flexibleadapter.a.b unused2 = bVar.K = new eu.davidea.flexibleadapter.a.b(bVar, bVar.i);
                    }
                    if (!b.this.K.a()) {
                        b.this.K.a(b.this.l);
                    }
                    if (e.k) {
                        Log.i(b.o, "Sticky headers enabled");
                    }
                } else if (b.this.K != null) {
                    boolean unused3 = b.this.I = false;
                    b.this.K.b(b.this.l);
                    eu.davidea.flexibleadapter.a.b unused4 = b.this.K = null;
                    if (e.k) {
                        Log.i(b.o, "Sticky headers disabled");
                    }
                }
            }
        });
        return this;
    }

    public ViewGroup e() {
        return (ViewGroup) eu.davidea.flexibleadapter.c.a.a(this.l.getContext()).findViewById(d.a.sticky_header_container);
    }

    public b b(boolean z2) {
        if (!this.H && z2) {
            e(a());
        }
        return this;
    }

    private void e(boolean z2) {
        if (z2) {
            f(true);
        } else {
            this.f32829b.post(new Runnable() {
                public void run() {
                    if (b.this.H) {
                        Log.w(b.o, "Headers already shown OR the method setDisplayHeadersAtStartUp() was already called!");
                        return;
                    }
                    b.this.f(false);
                    if (b.this.l != null && eu.davidea.flexibleadapter.c.a.b(b.this.l.getLayoutManager()) == 0) {
                        b bVar = b.this;
                        if (bVar.b(bVar.d(0))) {
                            b bVar2 = b.this;
                            if (!bVar2.b(bVar2.d(1))) {
                                b.this.l.b(0);
                            }
                        }
                    }
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public void f(boolean z2) {
        this.B = true;
        r();
        int i2 = 0;
        while (i2 < this.u.size()) {
            if (a(i2, (f) this.u.get(i2), z2)) {
                i2++;
            }
            i2++;
        }
        this.H = true;
        this.B = false;
    }

    private boolean a(int i2, T t2, boolean z2) {
        g d2 = d(t2);
        if (d2 == null || k(t2) != null || !d2.c()) {
            return false;
        }
        if (k) {
            String str = o;
            Log.v(str, "Showing header at position " + i2 + " header=" + d2);
        }
        d2.a(false);
        if (!z2) {
            return a(i2, d2);
        }
        if (i2 < this.u.size()) {
            this.u.add(i2, d2);
            return true;
        }
        this.u.add(d2);
        return true;
    }

    private boolean h(T t2) {
        g d2 = d(t2);
        return d2 != null && !d2.c() && a(a((f) d2), d2);
    }

    private boolean a(int i2, g gVar) {
        if (i2 < 0) {
            return false;
        }
        if (k) {
            String str = o;
            Log.v(str, "Hiding header at position " + i2 + " header=" + gVar);
        }
        gVar.a(true);
        this.u.remove(i2);
        notifyItemRemoved(i2);
        return true;
    }

    private void r() {
        for (T d2 : this.u) {
            g d3 = d(d2);
            if (d3 != null && !f(d3)) {
                d3.a(true);
            }
        }
    }

    private boolean a(T t2, g gVar, Object obj) {
        if (t2 == null || !(t2 instanceof h)) {
            a(gVar, a((f) t2), 1);
            notifyItemChanged(a((f) gVar), obj);
            return false;
        }
        h hVar = (h) t2;
        if (hVar.g() != null && !hVar.g().equals(gVar)) {
            a(hVar, (Object) c.UNLINK);
        }
        if (hVar.g() != null || gVar == null) {
            return false;
        }
        if (k) {
            String str = o;
            Log.v(str, "Link header " + gVar + " to " + hVar);
        }
        hVar.a(gVar);
        b(gVar);
        if (obj != null) {
            if (!gVar.c()) {
                notifyItemChanged(a((f) gVar), obj);
            }
            if (!t2.c()) {
                notifyItemChanged(a((f) t2), obj);
            }
        }
        return true;
    }

    private g a(T t2, Object obj) {
        if (!c(t2)) {
            return null;
        }
        h hVar = (h) t2;
        g g2 = hVar.g();
        if (k) {
            String str = o;
            Log.v(str, "Unlink header " + g2 + " from " + hVar);
        }
        hVar.a(null);
        a(g2, a((f) t2), 1);
        if (obj != null) {
            if (!g2.c()) {
                notifyItemChanged(a((f) g2), obj);
            }
            if (!t2.c()) {
                notifyItemChanged(a((f) t2), obj);
            }
        }
        return g2;
    }

    private void a(g gVar, int i2, int i3) {
        if (!this.G.contains(gVar) && !b(gVar, i2, i3)) {
            this.G.add(gVar);
            if (k) {
                String str = o;
                Log.v(str, "Added to orphan list [" + this.G.size() + "] Header " + gVar);
            }
        }
    }

    private void b(g gVar) {
        if (this.G.remove(gVar) && k) {
            String str = o;
            Log.v(str, "Removed from orphan list [" + this.G.size() + "] Header " + gVar);
        }
    }

    private boolean b(g gVar, int i2, int i3) {
        for (int a2 = a((f) gVar) + 1; a2 < this.u.size(); a2++) {
            f d2 = d(a2);
            if (d2 instanceof g) {
                return false;
            }
            if ((a2 < i2 || a2 >= i2 + i3) && a(d2, gVar)) {
                return true;
            }
        }
        return false;
    }

    public int getItemViewType(int i2) {
        f d2 = d(i2);
        j(d2);
        this.M = true;
        return d2.a();
    }

    public RecyclerView.w onCreateViewHolder(ViewGroup viewGroup, int i2) {
        f l2 = l(i2);
        if (l2 != null) {
            if (this.f32830c == null) {
                this.f32830c = LayoutInflater.from(viewGroup.getContext());
            }
            return l2.b(this, this.f32830c, viewGroup);
        }
        throw new IllegalStateException("ViewType instance has not been correctly mapped for viewType " + i2 + " or AutoMap is not active: super() cannot be called.");
    }

    public void onBindViewHolder(RecyclerView.w wVar, int i2) {
        onBindViewHolder(wVar, i2, Collections.unmodifiableList(new ArrayList()));
    }

    public void onBindViewHolder(RecyclerView.w wVar, int i2, List list) {
        if (k) {
            String str = o;
            Log.v(str, "onViewBound    Holder=" + wVar.getClass().getSimpleName() + " position=" + i2 + " itemId=" + wVar.getItemId() + " layoutPosition=" + wVar.getLayoutPosition());
        }
        if (this.M) {
            wVar.itemView.setActivated(i(i2));
            if (wVar instanceof eu.davidea.a.b) {
                float j2 = ((eu.davidea.a.b) wVar).j();
                if (wVar.itemView.isActivated() && j2 > BitmapDescriptorFactory.HUE_RED) {
                    w.b(wVar.itemView, j2);
                } else if (j2 > BitmapDescriptorFactory.HUE_RED) {
                    w.b(wVar.itemView, (float) BitmapDescriptorFactory.HUE_RED);
                }
            }
            f d2 = d(i2);
            if (d2 != null) {
                wVar.itemView.setEnabled(d2.b());
                d2.a(this, wVar, i2, list);
            }
            f(i2);
            return;
        }
        throw new IllegalStateException("AutoMap is not active: super() cannot be called.");
    }

    /* access modifiers changed from: protected */
    public void f(int i2) {
        if (this.af != null && !this.ae && i2 >= getItemCount() - this.ad && a((f) this.af) < 0) {
            this.ae = true;
            this.l.post(new Runnable() {
                public void run() {
                    b.this.u.add(b.this.af);
                    b bVar = b.this;
                    bVar.notifyItemInserted(bVar.getItemCount());
                    if (b.this.j != null) {
                        b.this.j.a();
                    }
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public void s() {
        int a2 = a((f) this.af);
        if (a2 >= 0) {
            this.u.remove(this.af);
            notifyItemRemoved(a2);
        }
    }

    /* access modifiers changed from: private */
    public void t() {
        this.ae = false;
    }

    public boolean e(T t2) {
        if (f(t2)) {
            return ((eu.davidea.flexibleadapter.b.d) t2).g();
        }
        return false;
    }

    public boolean f(T t2) {
        return t2 != null && (t2 instanceof eu.davidea.flexibleadapter.b.d);
    }

    public boolean a(eu.davidea.flexibleadapter.b.d dVar) {
        return (dVar == null || dVar.i() == null || dVar.i().size() <= 0) ? false : true;
    }

    public eu.davidea.flexibleadapter.b.d g(T t2) {
        for (T t3 : this.u) {
            if (f(t3)) {
                eu.davidea.flexibleadapter.b.d dVar = (eu.davidea.flexibleadapter.b.d) t3;
                if (dVar.g() && a(dVar)) {
                    for (f fVar : dVar.i()) {
                        if (!fVar.c() && fVar.equals(t2)) {
                            return dVar;
                        }
                    }
                    continue;
                }
            }
        }
        return null;
    }

    private int a(int i2, boolean z2, boolean z3) {
        f d2 = d(i2);
        if (!f(d2)) {
            return 0;
        }
        eu.davidea.flexibleadapter.b.d dVar = (eu.davidea.flexibleadapter.b.d) d2;
        if (!a(dVar)) {
            dVar.b(false);
            if (k) {
                String str = o;
                Log.w(str, "No subItems to Expand on position " + i2 + " expanded " + dVar.g());
            }
            return 0;
        }
        if (!z3) {
            if (dVar.g()) {
                return 0;
            }
            if (this.Z && dVar.h() > this.V) {
                return 0;
            }
        }
        if (this.X && !z2 && h(this.U) > 0) {
            i2 = a(d2);
        }
        List<f> d3 = d(dVar);
        int i3 = i2 + 1;
        this.u.addAll(i3, d3);
        int size = d3.size();
        dVar.b(true);
        if (!z3 && this.W && !z2) {
            a(i2, size, 150);
        }
        notifyItemRangeInserted(i3, size);
        if (!z3 && this.H) {
            int i4 = 0;
            for (f a2 : d3) {
                i4++;
                if (a(i2 + i4, a2, false)) {
                    i4++;
                }
            }
        }
        if (k) {
            String str2 = o;
            StringBuilder sb = new StringBuilder();
            sb.append(z3 ? "Initially expanded " : "Expanded ");
            sb.append(size);
            sb.append(" subItems on position=");
            sb.append(i2);
            Log.i(str2, sb.toString());
        }
        return size;
    }

    public int g(int i2) {
        f d2 = d(i2);
        int i3 = 0;
        if (!f(d2)) {
            return 0;
        }
        eu.davidea.flexibleadapter.b.d dVar = (eu.davidea.flexibleadapter.b.d) d2;
        List<f> d3 = d(dVar);
        int size = d3.size();
        if (k && this.w == null) {
            String str = o;
            Log.v(str, "Request to Collapse on position=" + i2 + " expanded=" + dVar.g() + " hasSubItemsSelected=" + b(i2, d3));
        }
        if (dVar.g() && size > 0 && (!b(i2, d3) || k(d2) != null)) {
            int i4 = i2 + 1;
            int a2 = a(i4, d3, dVar.h());
            Set<T> set = this.w;
            if (set != null) {
                set.removeAll(d3);
            } else {
                this.u.removeAll(d3);
            }
            int size2 = d3.size();
            dVar.b(false);
            notifyItemRangeRemoved(i4, size2);
            if (this.H && !b(d2)) {
                for (f h2 : d3) {
                    h(h2);
                }
            }
            if (k) {
                String str2 = o;
                Log.v(str2, "Collapsed " + size2 + " subItems on position " + i2);
            }
            i3 = a2;
            size = size2;
        }
        return size + i3;
    }

    private int a(int i2, List<T> list, int i3) {
        int i4 = 0;
        for (int i5 = 0; i5 < list.size(); i5++) {
            f fVar = (f) list.get(i5);
            if (e(fVar) && ((eu.davidea.flexibleadapter.b.d) fVar).h() >= i3 && g(i2 + i5) > 0) {
                i4++;
            }
        }
        return i4;
    }

    public int h(int i2) {
        this.w = new LinkedHashSet(this.u);
        int a2 = a(0, this.u, i2);
        this.u = new ArrayList(this.w);
        this.w = null;
        return a2;
    }

    public boolean a(int i2, T t2) {
        if (t2 == null) {
            Log.e(o, "No items to add!");
            return false;
        }
        if (k) {
            Log.v(o, "addItem delegates addition to addItems!");
        }
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(t2);
        return a(i2, arrayList);
    }

    public boolean a(int i2, List<T> list) {
        if (i2 < 0) {
            Log.e(o, "Cannot addItems on negative position!");
            return false;
        } else if (list == null || list.isEmpty()) {
            Log.e(o, "No items to add!");
            return false;
        } else {
            if (k) {
                String str = o;
                Log.d(str, "addItems on position=" + i2 + " itemCount=" + list.size());
            }
            int itemCount = getItemCount();
            if (i2 < this.u.size()) {
                this.u.addAll(i2, list);
            } else {
                this.u.addAll(list);
            }
            notifyItemRangeInserted(i2, list.size());
            if (this.H && !this.J) {
                this.J = true;
                for (T t2 : list) {
                    a(a((f) t2), t2, false);
                }
                this.J = false;
            }
            if (!this.J && this.f32831d != null && !this.B && itemCount == 0 && getItemCount() > 0) {
                this.f32831d.a(getItemCount());
            }
            return true;
        }
    }

    public synchronized void f() {
        if (k) {
            Log.d(o, "emptyBin!");
        }
        this.z.clear();
    }

    public List<T> g() {
        ArrayList arrayList = new ArrayList();
        for (b<T>.m mVar : this.z) {
            arrayList.add(mVar.f32860e);
        }
        return arrayList;
    }

    public List<T> b(eu.davidea.flexibleadapter.b.d dVar) {
        ArrayList arrayList = new ArrayList();
        for (m next : this.z) {
            if (next.f32858c != null && next.f32858c.equals(dVar) && next.f32857b >= 0) {
                arrayList.add(next.f32860e);
            }
        }
        return arrayList;
    }

    public List<T> c(eu.davidea.flexibleadapter.b.d dVar) {
        if (dVar == null || !a(dVar)) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList(dVar.i());
        if (!this.z.isEmpty()) {
            arrayList.removeAll(b(dVar));
        }
        return arrayList;
    }

    public boolean h() {
        String str = this.N;
        return str != null && !str.isEmpty();
    }

    public boolean a(String str) {
        return !this.O.equalsIgnoreCase(str);
    }

    public String i() {
        return this.N;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x00ff, code lost:
        return;
     */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00f7  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void b(java.util.List<T> r8) {
        /*
            r7 = this;
            monitor-enter(r7)
            boolean r0 = k     // Catch:{ all -> 0x0100 }
            if (r0 == 0) goto L_0x001d
            java.lang.String r0 = o     // Catch:{ all -> 0x0100 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0100 }
            r1.<init>()     // Catch:{ all -> 0x0100 }
            java.lang.String r2 = "filterItems with searchText="
            r1.append(r2)     // Catch:{ all -> 0x0100 }
            java.lang.String r2 = r7.N     // Catch:{ all -> 0x0100 }
            r1.append(r2)     // Catch:{ all -> 0x0100 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x0100 }
            android.util.Log.i(r0, r1)     // Catch:{ all -> 0x0100 }
        L_0x001d:
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch:{ all -> 0x0100 }
            r0.<init>()     // Catch:{ all -> 0x0100 }
            r1 = 1
            r7.R = r1     // Catch:{ all -> 0x0100 }
            boolean r2 = r7.h()     // Catch:{ all -> 0x0100 }
            r3 = 0
            if (r2 == 0) goto L_0x00a8
            r2 = -1
            java.util.Iterator r8 = r8.iterator()     // Catch:{ all -> 0x0100 }
        L_0x0031:
            boolean r4 = r8.hasNext()     // Catch:{ all -> 0x0100 }
            if (r4 == 0) goto L_0x00ec
            java.lang.Object r4 = r8.next()     // Catch:{ all -> 0x0100 }
            eu.davidea.flexibleadapter.b.f r4 = (eu.davidea.flexibleadapter.b.f) r4     // Catch:{ all -> 0x0100 }
            eu.davidea.flexibleadapter.b<T>$c r5 = r7.y     // Catch:{ all -> 0x0100 }
            if (r5 == 0) goto L_0x004b
            eu.davidea.flexibleadapter.b<T>$c r5 = r7.y     // Catch:{ all -> 0x0100 }
            boolean r5 = r5.isCancelled()     // Catch:{ all -> 0x0100 }
            if (r5 == 0) goto L_0x004b
            monitor-exit(r7)
            return
        L_0x004b:
            eu.davidea.flexibleadapter.b.g r5 = r7.d(r4)     // Catch:{ all -> 0x0100 }
            boolean r6 = r7.H     // Catch:{ all -> 0x0100 }
            if (r6 == 0) goto L_0x0068
            if (r5 == 0) goto L_0x0068
            java.lang.String r6 = r7.i()     // Catch:{ all -> 0x0100 }
            boolean r6 = r7.a(r5, (java.lang.String) r6)     // Catch:{ all -> 0x0100 }
            if (r6 == 0) goto L_0x0068
            boolean r6 = r0.contains(r5)     // Catch:{ all -> 0x0100 }
            if (r6 != 0) goto L_0x0068
            r0.add(r5)     // Catch:{ all -> 0x0100 }
        L_0x0068:
            boolean r6 = r7.i(r4)     // Catch:{ all -> 0x0100 }
            if (r6 == 0) goto L_0x00a4
            eu.davidea.flexibleadapter.b$m r6 = r7.k(r4)     // Catch:{ all -> 0x0100 }
            if (r6 == 0) goto L_0x0087
            int r2 = r2 + 1
            int r4 = r0.size()     // Catch:{ all -> 0x0100 }
            if (r2 >= r4) goto L_0x0083
            java.lang.Object r4 = r0.get(r2)     // Catch:{ all -> 0x0100 }
            eu.davidea.flexibleadapter.b.f r4 = (eu.davidea.flexibleadapter.b.f) r4     // Catch:{ all -> 0x0100 }
            goto L_0x0084
        L_0x0083:
            r4 = 0
        L_0x0084:
            r6.f32859d = r4     // Catch:{ all -> 0x0100 }
            goto L_0x0031
        L_0x0087:
            boolean r6 = r7.H     // Catch:{ all -> 0x0100 }
            if (r6 == 0) goto L_0x009a
            boolean r6 = r7.c(r4)     // Catch:{ all -> 0x0100 }
            if (r6 == 0) goto L_0x009a
            boolean r6 = r0.contains(r5)     // Catch:{ all -> 0x0100 }
            if (r6 != 0) goto L_0x009a
            r0.add(r5)     // Catch:{ all -> 0x0100 }
        L_0x009a:
            r0.add(r4)     // Catch:{ all -> 0x0100 }
            int r4 = r7.a(r0, r4)     // Catch:{ all -> 0x0100 }
            int r4 = r4 + r1
            int r2 = r2 + r4
            goto L_0x0031
        L_0x00a4:
            r4.a(r1)     // Catch:{ all -> 0x0100 }
            goto L_0x0031
        L_0x00a8:
            java.lang.String r2 = r7.N     // Catch:{ all -> 0x0100 }
            boolean r2 = r7.a((java.lang.String) r2)     // Catch:{ all -> 0x0100 }
            if (r2 == 0) goto L_0x00ec
            java.util.List<eu.davidea.flexibleadapter.b<T>$m> r0 = r7.z     // Catch:{ all -> 0x0100 }
            boolean r0 = r0.isEmpty()     // Catch:{ all -> 0x0100 }
            if (r0 != 0) goto L_0x00e8
            java.util.List<eu.davidea.flexibleadapter.b<T>$m> r0 = r7.z     // Catch:{ all -> 0x0100 }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ all -> 0x0100 }
        L_0x00be:
            boolean r2 = r0.hasNext()     // Catch:{ all -> 0x0100 }
            if (r2 == 0) goto L_0x00e1
            java.lang.Object r2 = r0.next()     // Catch:{ all -> 0x0100 }
            eu.davidea.flexibleadapter.b$m r2 = (eu.davidea.flexibleadapter.b.m) r2     // Catch:{ all -> 0x0100 }
            r2.a()     // Catch:{ all -> 0x0100 }
            T r4 = r2.f32860e     // Catch:{ all -> 0x0100 }
            int r4 = r8.indexOf(r4)     // Catch:{ all -> 0x0100 }
            int r4 = r4 - r1
            int r4 = java.lang.Math.max(r3, r4)     // Catch:{ all -> 0x0100 }
            java.lang.Object r4 = r8.get(r4)     // Catch:{ all -> 0x0100 }
            eu.davidea.flexibleadapter.b.f r4 = (eu.davidea.flexibleadapter.b.f) r4     // Catch:{ all -> 0x0100 }
            r2.f32858c = r4     // Catch:{ all -> 0x0100 }
            goto L_0x00be
        L_0x00e1:
            java.util.List r0 = r7.g()     // Catch:{ all -> 0x0100 }
            r8.removeAll(r0)     // Catch:{ all -> 0x0100 }
        L_0x00e8:
            r7.c(r8)     // Catch:{ all -> 0x0100 }
            goto L_0x00ed
        L_0x00ec:
            r8 = r0
        L_0x00ed:
            r7.R = r3     // Catch:{ all -> 0x0100 }
            java.lang.String r0 = r7.N     // Catch:{ all -> 0x0100 }
            boolean r0 = r7.a((java.lang.String) r0)     // Catch:{ all -> 0x0100 }
            if (r0 == 0) goto L_0x00fe
            java.lang.String r0 = r7.N     // Catch:{ all -> 0x0100 }
            r7.O = r0     // Catch:{ all -> 0x0100 }
            r7.d(r8)     // Catch:{ all -> 0x0100 }
        L_0x00fe:
            monitor-exit(r7)
            return
        L_0x0100:
            r8 = move-exception
            monitor-exit(r7)
            goto L_0x0104
        L_0x0103:
            throw r8
        L_0x0104:
            goto L_0x0103
        */
        throw new UnsupportedOperationException("Method not decompiled: eu.davidea.flexibleadapter.b.b(java.util.List):void");
    }

    private boolean i(T t2) {
        boolean z2;
        if (f(t2)) {
            eu.davidea.flexibleadapter.b.d dVar = (eu.davidea.flexibleadapter.b.d) t2;
            if (dVar.g()) {
                if (this.P == null) {
                    this.P = new HashSet();
                }
                this.P.add(dVar);
            }
            dVar.b(false);
            z2 = false;
            for (f fVar : c(dVar)) {
                fVar.a(!a(fVar, i()));
                if (!z2 && !fVar.c()) {
                    z2 = true;
                }
            }
            dVar.b(z2);
        } else {
            z2 = false;
        }
        if (z2 || a(t2, i())) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public boolean a(T t2, String str) {
        if (t2 instanceof e) {
            return ((e) t2).a(str);
        }
        return false;
    }

    private int a(List<T> list, T t2) {
        if (!f(t2)) {
            return 0;
        }
        eu.davidea.flexibleadapter.b.d dVar = (eu.davidea.flexibleadapter.b.d) t2;
        if (!a(dVar)) {
            return 0;
        }
        ArrayList arrayList = new ArrayList();
        for (f fVar : dVar.i()) {
            if (!fVar.c()) {
                arrayList.add(fVar);
            }
        }
        list.addAll(arrayList);
        return arrayList.size();
    }

    private void c(List<T> list) {
        int i2 = 0;
        while (i2 < list.size()) {
            f fVar = (f) list.get(i2);
            fVar.a(false);
            if (f(fVar)) {
                eu.davidea.flexibleadapter.b.d dVar = (eu.davidea.flexibleadapter.b.d) fVar;
                Set<eu.davidea.flexibleadapter.b.d> set = this.P;
                if (set != null) {
                    dVar.b(set.contains(dVar));
                }
                if (a(dVar)) {
                    for (f fVar2 : dVar.i()) {
                        fVar2.a(false);
                        if (dVar.g()) {
                            i2++;
                            if (i2 < list.size()) {
                                list.add(i2, fVar2);
                            } else {
                                list.add(fVar2);
                            }
                        }
                    }
                }
            }
            i2++;
        }
        this.P = null;
    }

    /* access modifiers changed from: private */
    public synchronized void d(List<T> list) {
        if (list == null) {
            list = new ArrayList<>();
        }
        this.x = new ArrayList();
        if (list.size() <= T) {
            if (k) {
                String str = o;
                Log.v(str, "Animate changes! oldSize=" + getItemCount() + " newSize=" + list.size() + " limit=" + T);
            }
            this.v = new ArrayList(this.u);
            a(this.v, list);
            b(this.v, list);
            if (this.S) {
                c(this.v, list);
            }
        } else {
            if (k) {
                String str2 = o;
                Log.v(str2, "NotifyDataSetChanged! oldSize=" + getItemCount() + " newSize=" + list.size() + " limit=" + T);
            }
            this.v = list;
            this.x.add(new d(-1, 0));
        }
        if (this.y == null) {
            u();
        }
    }

    private void a(List<T> list, List<T> list2) {
        this.w = new HashSet(list2);
        int size = list.size() - 1;
        int i2 = 0;
        while (size >= 0) {
            b<T>.c cVar = this.y;
            if (cVar == null || !cVar.isCancelled()) {
                f fVar = (f) list.get(size);
                if (!this.w.contains(fVar) && (!b(fVar) || (b(fVar) && this.H))) {
                    list.remove(size);
                    this.x.add(new d(size, 3));
                    i2++;
                } else if (this.Q) {
                    list.set(size, fVar);
                    this.x.add(new d(size, 2));
                }
                size--;
            } else {
                return;
            }
        }
        this.w = null;
        if (k) {
            Log.v(o, "calculateRemovals total out=" + i2);
        }
    }

    private void b(List<T> list, List<T> list2) {
        this.w = new HashSet(list);
        int i2 = 0;
        int i3 = 0;
        while (i2 < list2.size()) {
            b<T>.c cVar = this.y;
            if (cVar == null || !cVar.isCancelled()) {
                f fVar = (f) list2.get(i2);
                if (!this.w.contains(fVar)) {
                    if (this.S) {
                        list.add(fVar);
                        this.x.add(new d(list.size(), 1));
                    } else {
                        list.add(i2, fVar);
                        this.x.add(new d(i2, 1));
                    }
                    i3++;
                }
                i2++;
            } else {
                return;
            }
        }
        this.w = null;
        if (k) {
            String str = o;
            Log.v(str, "calculateAdditions total new=" + i3);
        }
    }

    private void c(List<T> list, List<T> list2) {
        int size = list2.size() - 1;
        int i2 = 0;
        while (size >= 0) {
            b<T>.c cVar = this.y;
            if (cVar == null || !cVar.isCancelled()) {
                int indexOf = list.indexOf((f) list2.get(size));
                if (indexOf >= 0 && indexOf != size) {
                    f fVar = (f) list.remove(indexOf);
                    if (size < list.size()) {
                        list.add(size, fVar);
                    } else {
                        list.add(fVar);
                    }
                    this.x.add(new d(indexOf, size, 4));
                    i2++;
                }
                size--;
            } else {
                return;
            }
        }
        if (k) {
            Log.v(o, "calculateMovedItems total move=" + i2);
        }
    }

    /* access modifiers changed from: private */
    public synchronized void u() {
        if (k) {
            String str = o;
            Log.i(str, "Performing " + this.x.size() + " notifications");
        }
        this.u = this.v;
        a(false);
        for (d next : this.x) {
            int i2 = next.f32855c;
            if (i2 == 1) {
                notifyItemInserted(next.f32854b);
            } else if (i2 == 2) {
                notifyItemChanged(next.f32854b, c.FILTER);
            } else if (i2 == 3) {
                notifyItemRemoved(next.f32854b);
            } else if (i2 != 4) {
                if (k) {
                    Log.w(o, "notifyDataSetChanged!");
                }
                notifyDataSetChanged();
            } else {
                notifyItemMoved(next.f32853a, next.f32854b);
            }
        }
        this.v = null;
        this.x = null;
    }

    public final androidx.recyclerview.widget.i j() {
        v();
        return this.ac;
    }

    public final boolean k() {
        eu.davidea.flexibleadapter.a.a aVar = this.ab;
        return aVar != null && aVar.b();
    }

    public final boolean l() {
        return this.aa;
    }

    public void a(List<T> list, int i2, int i3) {
        if (i2 >= 0 && i2 < getItemCount() && i3 >= 0 && i3 < getItemCount()) {
            if (k) {
                Log.v(o, "swapItems from=" + i2 + " [selected? " + i(i2) + "] to=" + i3 + " [selected? " + i(i3) + "]");
            }
            if (i2 < i3) {
                int i4 = i2;
                while (i4 < i3) {
                    if (k) {
                        Log.v(o, "swapItems from=" + i4 + " to=" + (i4 + 1));
                    }
                    int i5 = i4 + 1;
                    Collections.swap(this.u, i4, i5);
                    d(i4, i5);
                    i4 = i5;
                }
            } else {
                for (int i6 = i2; i6 > i3; i6--) {
                    if (k) {
                        String str = o;
                        StringBuilder sb = new StringBuilder();
                        sb.append("swapItems from=");
                        sb.append(i6);
                        sb.append(" to=");
                        sb.append(i6 - 1);
                        Log.v(str, sb.toString());
                    }
                    int i7 = i6 - 1;
                    Collections.swap(this.u, i6, i7);
                    d(i6, i7);
                }
            }
            notifyItemMoved(i2, i3);
            if (this.H) {
                f d2 = d(i3);
                f d3 = d(i2);
                boolean z2 = d3 instanceof g;
                if (!z2 || !(d2 instanceof g)) {
                    if (z2) {
                        int i8 = i2 < i3 ? i3 + 1 : i3;
                        if (i2 >= i3) {
                            i3 = i2 + 1;
                        }
                        a(d(i8), e(i8), (Object) c.LINK);
                        a(d(i3), (g) d3, (Object) c.LINK);
                    } else if (d2 instanceof g) {
                        int i9 = i2 < i3 ? i2 : i2 + 1;
                        if (i2 < i3) {
                            i2 = i3 + 1;
                        }
                        a(d(i9), e(i9), (Object) c.LINK);
                        a(d(i2), (g) d2, (Object) c.LINK);
                    } else {
                        int i10 = i2 < i3 ? i3 : i2;
                        if (i2 >= i3) {
                            i2 = i3;
                        }
                        f d4 = d(i10);
                        g d5 = d(d4);
                        if (d5 != null) {
                            g e2 = e(i10);
                            if (e2 != null && !e2.equals(d5)) {
                                a(d4, e2, (Object) c.LINK);
                            }
                            a(d(i2), d5, (Object) c.LINK);
                        }
                    }
                } else if (i2 < i3) {
                    g gVar = (g) d2;
                    for (h a2 : a(gVar)) {
                        a(a2, gVar, (Object) c.LINK);
                    }
                } else {
                    g gVar2 = (g) d3;
                    for (h a3 : a(gVar2)) {
                        a(a3, gVar2, (Object) c.LINK);
                    }
                }
            }
        }
    }

    public void b(RecyclerView.w wVar, int i2) {
        i iVar = this.f32834g;
        if (iVar != null) {
            iVar.a(wVar, i2);
            return;
        }
        j jVar = this.h;
        if (jVar != null) {
            jVar.a(wVar, i2);
        }
    }

    public boolean a(int i2, int i3) {
        i iVar = this.f32834g;
        return iVar == null || iVar.a(i2, i3);
    }

    public boolean b(int i2, int i3) {
        a(this.u, i2, i3);
        i iVar = this.f32834g;
        if (iVar == null) {
            return true;
        }
        iVar.b(i2, i3);
        return true;
    }

    public void c(int i2, int i3) {
        j jVar = this.h;
        if (jVar != null) {
            jVar.a(i2, i3);
        }
    }

    private void v() {
        if (this.ac != null) {
            return;
        }
        if (this.l != null) {
            this.ab = new eu.davidea.flexibleadapter.a.a(this);
            this.ac = new androidx.recyclerview.widget.i(this.ab);
            this.ac.a(this.l);
            return;
        }
        throw new IllegalStateException("RecyclerView cannot be null. Enabling LongPressDrag or Swipe must be done after the Adapter is added to the RecyclerView.");
    }

    private void j(T t2) {
        if (t2 != null && !this.L.containsKey(Integer.valueOf(t2.a()))) {
            this.L.put(Integer.valueOf(t2.a()), t2);
            if (k) {
                String str = o;
                Log.i(str, "Mapped viewType " + t2.a() + " from " + t2.getClass().getSimpleName());
            }
        }
    }

    private T l(int i2) {
        return (f) this.L.get(Integer.valueOf(i2));
    }

    private b<T>.m k(T t2) {
        for (b<T>.m next : this.z) {
            if (next.f32860e.equals(t2) && next.f32856a < 0) {
                return next;
            }
        }
        return null;
    }

    private List<T> d(eu.davidea.flexibleadapter.b.d dVar) {
        ArrayList arrayList = new ArrayList();
        if (dVar != null && a(dVar)) {
            for (f fVar : dVar.i()) {
                if (!fVar.c()) {
                    arrayList.add(fVar);
                }
            }
        }
        return arrayList;
    }

    private boolean b(int i2, List<T> list) {
        for (T t2 : list) {
            int i3 = i2 + 1;
            if (i(i3) || (f(t2) && b(i3, d((eu.davidea.flexibleadapter.b.d) t2)))) {
                return true;
            }
        }
        return false;
    }

    private void a(final int i2, final int i3, long j2) {
        new Handler(Looper.getMainLooper(), new Handler.Callback() {
            public boolean handleMessage(Message message) {
                int b2 = eu.davidea.flexibleadapter.c.a.b(b.this.l.getLayoutManager());
                int c2 = eu.davidea.flexibleadapter.c.a.c(b.this.l.getLayoutManager());
                int i = i2;
                int i2 = i3;
                if ((i + i2) - c2 > 0) {
                    int min = Math.min(i - b2, Math.max(0, (i + i2) - c2));
                    int a2 = e.a(b.this.l.getLayoutManager());
                    if (a2 > 1) {
                        min = (min % a2) + a2;
                    }
                    b.this.l.d(b2 + min);
                } else if (i < b2) {
                    b.this.l.d(i2);
                }
                return true;
            }
        }).sendMessageDelayed(Message.obtain(this.f32829b), j2);
    }

    /* access modifiers changed from: private */
    public void e(int i2, int i3) {
        boolean z2 = false;
        for (Integer next : q()) {
            if (next.intValue() >= i2) {
                if (k) {
                    String str = o;
                    Log.v(str, "Adjust Selected position " + next + " to " + Math.max(next.intValue() + i3, i2));
                }
                k(next.intValue());
                j(Math.max(next.intValue() + i3, i2));
                z2 = true;
            }
        }
        if (k && z2) {
            String str2 = o;
            Log.v(str2, "AdjustedSelected=" + q());
        }
    }

    private class a extends RecyclerView.c {
        private a() {
        }

        private void d(int i, int i2) {
            if (!b.this.R) {
                if (b.this.F) {
                    b.this.e(i, i2);
                }
                boolean unused = b.this.F = true;
            }
        }

        private void b() {
            if (b.this.K != null && !b.this.B && !b.this.R) {
                b.this.K.a(true);
            }
        }

        public void a() {
            b();
        }

        public void b(int i, int i2) {
            d(i, i2);
            b();
        }

        public void c(int i, int i2) {
            d(i, -i2);
            b();
        }

        public void a(int i, int i2) {
            b();
        }

        public void a(int i, int i2, int i3) {
            b();
        }
    }

    private class m {

        /* renamed from: a  reason: collision with root package name */
        int f32856a;

        /* renamed from: b  reason: collision with root package name */
        int f32857b;

        /* renamed from: c  reason: collision with root package name */
        T f32858c;

        /* renamed from: d  reason: collision with root package name */
        T f32859d;

        /* renamed from: e  reason: collision with root package name */
        T f32860e;

        public void a() {
            this.f32859d = null;
            this.f32856a = -1;
        }

        public String toString() {
            return "RestoreInfo[item=" + this.f32860e + ", refItem=" + this.f32858c + ", filterRefItem=" + this.f32859d + "]";
        }
    }

    private static class d {

        /* renamed from: a  reason: collision with root package name */
        int f32853a;

        /* renamed from: b  reason: collision with root package name */
        int f32854b;

        /* renamed from: c  reason: collision with root package name */
        int f32855c;

        public d(int i, int i2) {
            this.f32854b = i;
            this.f32855c = i2;
        }

        public d(int i, int i2, int i3) {
            this(i2, i3);
            this.f32853a = i;
        }
    }

    private class c extends AsyncTask<Void, Void, Void> {

        /* renamed from: b  reason: collision with root package name */
        private final String f32850b = c.class.getSimpleName();

        /* renamed from: c  reason: collision with root package name */
        private List<T> f32851c;

        /* renamed from: d  reason: collision with root package name */
        private int f32852d;

        c(int i, List<T> list) {
            this.f32852d = i;
            this.f32851c = list;
        }

        /* access modifiers changed from: protected */
        public void onCancelled() {
            if (e.k) {
                Log.i(this.f32850b, "FilterAsyncTask cancelled!");
            }
        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            super.onPreExecute();
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public Void doInBackground(Void... voidArr) {
            int i = this.f32852d;
            if (i == 0) {
                if (e.k) {
                    Log.d(this.f32850b, "doInBackground - started UPDATE");
                }
                b.this.d(this.f32851c);
                if (!e.k) {
                    return null;
                }
                Log.d(this.f32850b, "doInBackground - ended UPDATE");
                return null;
            } else if (i != 1) {
                return null;
            } else {
                if (e.k) {
                    Log.d(this.f32850b, "doInBackground - started FILTER");
                }
                b.this.b(this.f32851c);
                if (!e.k) {
                    return null;
                }
                Log.d(this.f32850b, "doInBackground - ended FILTER");
                return null;
            }
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void onPostExecute(Void voidR) {
            b.this.u();
            int i = this.f32852d;
            if (i == 0) {
                b.this.g(false);
            } else if (i == 1) {
                b.this.w();
            }
            c unused = b.this.y = null;
        }
    }

    /* access modifiers changed from: private */
    public void g(boolean z2) {
        if (getItemCount() > 0) {
            b();
            if (this.H) {
                f(z2);
            }
        }
        if (z2) {
            if (k) {
                Log.w(o, "notifyDataSetChanged!");
            }
            notifyDataSetChanged();
        }
        l lVar = this.f32831d;
        if (lVar != null) {
            lVar.a(getItemCount());
        }
    }

    /* access modifiers changed from: private */
    public void w() {
        if (this.H && !h()) {
            f(false);
        }
        l lVar = this.f32831d;
        if (lVar != null) {
            lVar.a(getItemCount());
        }
    }
}
