package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.util.Xml;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.d;
import androidx.constraintlayout.widget.f;
import com.facebook.react.uimanager.ViewProps;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParserException;

// renamed from: androidx.constraintlayout.widget.c
public class c {

    /* renamed from: a  reason: collision with root package name */
    private static final int[] f1475a = {0, 4, 8};

    /* renamed from: c  reason: collision with root package name */
    private static SparseIntArray f1476c = new SparseIntArray();

    /* renamed from: b  reason: collision with root package name */
    private HashMap<Integer, a> f1477b = new HashMap<>();

    private String c(int i) {
        switch (i) {
            case 1:
                return ViewProps.LEFT;
            case 2:
                return ViewProps.RIGHT;
            case 3:
                return ViewProps.TOP;
            case 4:
                return ViewProps.BOTTOM;
            case 5:
                return "baseline";
            case 6:
                return ViewProps.START;
            case 7:
                return ViewProps.END;
            default:
                return "undefined";
        }
    }

    static {
        f1476c.append(f.b.ConstraintSet_layout_constraintLeft_toLeftOf, 25);
        f1476c.append(f.b.ConstraintSet_layout_constraintLeft_toRightOf, 26);
        f1476c.append(f.b.ConstraintSet_layout_constraintRight_toLeftOf, 29);
        f1476c.append(f.b.ConstraintSet_layout_constraintRight_toRightOf, 30);
        f1476c.append(f.b.ConstraintSet_layout_constraintTop_toTopOf, 36);
        f1476c.append(f.b.ConstraintSet_layout_constraintTop_toBottomOf, 35);
        f1476c.append(f.b.ConstraintSet_layout_constraintBottom_toTopOf, 4);
        f1476c.append(f.b.ConstraintSet_layout_constraintBottom_toBottomOf, 3);
        f1476c.append(f.b.ConstraintSet_layout_constraintBaseline_toBaselineOf, 1);
        f1476c.append(f.b.ConstraintSet_layout_editor_absoluteX, 6);
        f1476c.append(f.b.ConstraintSet_layout_editor_absoluteY, 7);
        f1476c.append(f.b.ConstraintSet_layout_constraintGuide_begin, 17);
        f1476c.append(f.b.ConstraintSet_layout_constraintGuide_end, 18);
        f1476c.append(f.b.ConstraintSet_layout_constraintGuide_percent, 19);
        f1476c.append(f.b.ConstraintSet_android_orientation, 27);
        f1476c.append(f.b.ConstraintSet_layout_constraintStart_toEndOf, 32);
        f1476c.append(f.b.ConstraintSet_layout_constraintStart_toStartOf, 33);
        f1476c.append(f.b.ConstraintSet_layout_constraintEnd_toStartOf, 10);
        f1476c.append(f.b.ConstraintSet_layout_constraintEnd_toEndOf, 9);
        f1476c.append(f.b.ConstraintSet_layout_goneMarginLeft, 13);
        f1476c.append(f.b.ConstraintSet_layout_goneMarginTop, 16);
        f1476c.append(f.b.ConstraintSet_layout_goneMarginRight, 14);
        f1476c.append(f.b.ConstraintSet_layout_goneMarginBottom, 11);
        f1476c.append(f.b.ConstraintSet_layout_goneMarginStart, 15);
        f1476c.append(f.b.ConstraintSet_layout_goneMarginEnd, 12);
        f1476c.append(f.b.ConstraintSet_layout_constraintVertical_weight, 40);
        f1476c.append(f.b.ConstraintSet_layout_constraintHorizontal_weight, 39);
        f1476c.append(f.b.ConstraintSet_layout_constraintHorizontal_chainStyle, 41);
        f1476c.append(f.b.ConstraintSet_layout_constraintVertical_chainStyle, 42);
        f1476c.append(f.b.ConstraintSet_layout_constraintHorizontal_bias, 20);
        f1476c.append(f.b.ConstraintSet_layout_constraintVertical_bias, 37);
        f1476c.append(f.b.ConstraintSet_layout_constraintDimensionRatio, 5);
        f1476c.append(f.b.ConstraintSet_layout_constraintLeft_creator, 75);
        f1476c.append(f.b.ConstraintSet_layout_constraintTop_creator, 75);
        f1476c.append(f.b.ConstraintSet_layout_constraintRight_creator, 75);
        f1476c.append(f.b.ConstraintSet_layout_constraintBottom_creator, 75);
        f1476c.append(f.b.ConstraintSet_layout_constraintBaseline_creator, 75);
        f1476c.append(f.b.ConstraintSet_android_layout_marginLeft, 24);
        f1476c.append(f.b.ConstraintSet_android_layout_marginRight, 28);
        f1476c.append(f.b.ConstraintSet_android_layout_marginStart, 31);
        f1476c.append(f.b.ConstraintSet_android_layout_marginEnd, 8);
        f1476c.append(f.b.ConstraintSet_android_layout_marginTop, 34);
        f1476c.append(f.b.ConstraintSet_android_layout_marginBottom, 2);
        f1476c.append(f.b.ConstraintSet_android_layout_width, 23);
        f1476c.append(f.b.ConstraintSet_android_layout_height, 21);
        f1476c.append(f.b.ConstraintSet_android_visibility, 22);
        f1476c.append(f.b.ConstraintSet_android_alpha, 43);
        f1476c.append(f.b.ConstraintSet_android_elevation, 44);
        f1476c.append(f.b.ConstraintSet_android_rotationX, 45);
        f1476c.append(f.b.ConstraintSet_android_rotationY, 46);
        f1476c.append(f.b.ConstraintSet_android_rotation, 60);
        f1476c.append(f.b.ConstraintSet_android_scaleX, 47);
        f1476c.append(f.b.ConstraintSet_android_scaleY, 48);
        f1476c.append(f.b.ConstraintSet_android_transformPivotX, 49);
        f1476c.append(f.b.ConstraintSet_android_transformPivotY, 50);
        f1476c.append(f.b.ConstraintSet_android_translationX, 51);
        f1476c.append(f.b.ConstraintSet_android_translationY, 52);
        f1476c.append(f.b.ConstraintSet_android_translationZ, 53);
        f1476c.append(f.b.ConstraintSet_layout_constraintWidth_default, 54);
        f1476c.append(f.b.ConstraintSet_layout_constraintHeight_default, 55);
        f1476c.append(f.b.ConstraintSet_layout_constraintWidth_max, 56);
        f1476c.append(f.b.ConstraintSet_layout_constraintHeight_max, 57);
        f1476c.append(f.b.ConstraintSet_layout_constraintWidth_min, 58);
        f1476c.append(f.b.ConstraintSet_layout_constraintHeight_min, 59);
        f1476c.append(f.b.ConstraintSet_layout_constraintCircle, 61);
        f1476c.append(f.b.ConstraintSet_layout_constraintCircleRadius, 62);
        f1476c.append(f.b.ConstraintSet_layout_constraintCircleAngle, 63);
        f1476c.append(f.b.ConstraintSet_android_id, 38);
        f1476c.append(f.b.ConstraintSet_layout_constraintWidth_percent, 69);
        f1476c.append(f.b.ConstraintSet_layout_constraintHeight_percent, 70);
        f1476c.append(f.b.ConstraintSet_chainUseRtl, 71);
        f1476c.append(f.b.ConstraintSet_barrierDirection, 72);
        f1476c.append(f.b.ConstraintSet_constraint_referenced_ids, 73);
        f1476c.append(f.b.ConstraintSet_barrierAllowsGoneWidgets, 74);
    }

    private static class a {
        public int A;
        public int B;
        public int C;
        public int D;
        public int E;
        public int F;
        public int G;
        public int H;
        public int I;
        public int J;
        public int K;
        public int L;
        public int M;
        public int N;
        public int O;
        public int P;
        public float Q;
        public float R;
        public int S;
        public int T;
        public float U;
        public boolean V;
        public float W;
        public float X;
        public float Y;
        public float Z;

        /* renamed from: a  reason: collision with root package name */
        boolean f1478a;
        public float aa;
        public float ab;
        public float ac;
        public float ad;
        public float ae;
        public float af;
        public float ag;
        public boolean ah;
        public boolean ai;
        public int aj;
        public int ak;
        public int al;
        public int am;
        public int an;
        public int ao;
        public float ap;
        public float aq;
        public boolean ar;
        public int as;
        public int at;
        public int[] au;
        public String av;

        /* renamed from: b  reason: collision with root package name */
        public int f1479b;

        /* renamed from: c  reason: collision with root package name */
        public int f1480c;

        /* renamed from: d  reason: collision with root package name */
        int f1481d;

        /* renamed from: e  reason: collision with root package name */
        public int f1482e;

        /* renamed from: f  reason: collision with root package name */
        public int f1483f;

        /* renamed from: g  reason: collision with root package name */
        public float f1484g;
        public int h;
        public int i;
        public int j;
        public int k;
        public int l;
        public int m;
        public int n;
        public int o;
        public int p;
        public int q;
        public int r;
        public int s;
        public int t;
        public float u;
        public float v;
        public String w;
        public int x;
        public int y;
        public float z;

        private a() {
            this.f1478a = false;
            this.f1482e = -1;
            this.f1483f = -1;
            this.f1484g = -1.0f;
            this.h = -1;
            this.i = -1;
            this.j = -1;
            this.k = -1;
            this.l = -1;
            this.m = -1;
            this.n = -1;
            this.o = -1;
            this.p = -1;
            this.q = -1;
            this.r = -1;
            this.s = -1;
            this.t = -1;
            this.u = 0.5f;
            this.v = 0.5f;
            this.w = null;
            this.x = -1;
            this.y = 0;
            this.z = BitmapDescriptorFactory.HUE_RED;
            this.A = -1;
            this.B = -1;
            this.C = -1;
            this.D = -1;
            this.E = -1;
            this.F = -1;
            this.G = -1;
            this.H = -1;
            this.I = -1;
            this.J = 0;
            this.K = -1;
            this.L = -1;
            this.M = -1;
            this.N = -1;
            this.O = -1;
            this.P = -1;
            this.Q = BitmapDescriptorFactory.HUE_RED;
            this.R = BitmapDescriptorFactory.HUE_RED;
            this.S = 0;
            this.T = 0;
            this.U = 1.0f;
            this.V = false;
            this.W = BitmapDescriptorFactory.HUE_RED;
            this.X = BitmapDescriptorFactory.HUE_RED;
            this.Y = BitmapDescriptorFactory.HUE_RED;
            this.Z = BitmapDescriptorFactory.HUE_RED;
            this.aa = 1.0f;
            this.ab = 1.0f;
            this.ac = Float.NaN;
            this.ad = Float.NaN;
            this.ae = BitmapDescriptorFactory.HUE_RED;
            this.af = BitmapDescriptorFactory.HUE_RED;
            this.ag = BitmapDescriptorFactory.HUE_RED;
            this.ah = false;
            this.ai = false;
            this.aj = 0;
            this.ak = 0;
            this.al = -1;
            this.am = -1;
            this.an = -1;
            this.ao = -1;
            this.ap = 1.0f;
            this.aq = 1.0f;
            this.ar = false;
            this.as = -1;
            this.at = -1;
        }

        /* renamed from: a */
        public a clone() {
            a aVar = new a();
            aVar.f1478a = this.f1478a;
            aVar.f1479b = this.f1479b;
            aVar.f1480c = this.f1480c;
            aVar.f1482e = this.f1482e;
            aVar.f1483f = this.f1483f;
            aVar.f1484g = this.f1484g;
            aVar.h = this.h;
            aVar.i = this.i;
            aVar.j = this.j;
            aVar.k = this.k;
            aVar.l = this.l;
            aVar.m = this.m;
            aVar.n = this.n;
            aVar.o = this.o;
            aVar.p = this.p;
            aVar.q = this.q;
            aVar.r = this.r;
            aVar.s = this.s;
            aVar.t = this.t;
            aVar.u = this.u;
            aVar.v = this.v;
            aVar.w = this.w;
            aVar.A = this.A;
            aVar.B = this.B;
            aVar.u = this.u;
            aVar.u = this.u;
            aVar.u = this.u;
            aVar.u = this.u;
            aVar.u = this.u;
            aVar.C = this.C;
            aVar.D = this.D;
            aVar.E = this.E;
            aVar.F = this.F;
            aVar.G = this.G;
            aVar.H = this.H;
            aVar.I = this.I;
            aVar.J = this.J;
            aVar.K = this.K;
            aVar.L = this.L;
            aVar.M = this.M;
            aVar.N = this.N;
            aVar.O = this.O;
            aVar.P = this.P;
            aVar.Q = this.Q;
            aVar.R = this.R;
            aVar.S = this.S;
            aVar.T = this.T;
            aVar.U = this.U;
            aVar.V = this.V;
            aVar.W = this.W;
            aVar.X = this.X;
            aVar.Y = this.Y;
            aVar.Z = this.Z;
            aVar.aa = this.aa;
            aVar.ab = this.ab;
            aVar.ac = this.ac;
            aVar.ad = this.ad;
            aVar.ae = this.ae;
            aVar.af = this.af;
            aVar.ag = this.ag;
            aVar.ah = this.ah;
            aVar.ai = this.ai;
            aVar.aj = this.aj;
            aVar.ak = this.ak;
            aVar.al = this.al;
            aVar.am = this.am;
            aVar.an = this.an;
            aVar.ao = this.ao;
            aVar.ap = this.ap;
            aVar.aq = this.aq;
            aVar.as = this.as;
            aVar.at = this.at;
            int[] iArr = this.au;
            if (iArr != null) {
                aVar.au = Arrays.copyOf(iArr, iArr.length);
            }
            aVar.x = this.x;
            aVar.y = this.y;
            aVar.z = this.z;
            aVar.ar = this.ar;
            return aVar;
        }

        /* access modifiers changed from: private */
        public void a(b bVar, int i2, d.a aVar) {
            a(i2, aVar);
            if (bVar instanceof a) {
                this.at = 1;
                a aVar2 = (a) bVar;
                this.as = aVar2.getType();
                this.au = aVar2.getReferencedIds();
            }
        }

        /* access modifiers changed from: private */
        public void a(int i2, d.a aVar) {
            a(i2, (ConstraintLayout.a) aVar);
            this.U = aVar.an;
            this.X = aVar.aq;
            this.Y = aVar.ar;
            this.Z = aVar.as;
            this.aa = aVar.at;
            this.ab = aVar.au;
            this.ac = aVar.av;
            this.ad = aVar.aw;
            this.ae = aVar.ax;
            this.af = aVar.ay;
            this.ag = aVar.az;
            this.W = aVar.ap;
            this.V = aVar.ao;
        }

        /* access modifiers changed from: private */
        public void a(int i2, ConstraintLayout.a aVar) {
            this.f1481d = i2;
            this.h = aVar.f1462d;
            this.i = aVar.f1463e;
            this.j = aVar.f1464f;
            this.k = aVar.f1465g;
            this.l = aVar.h;
            this.m = aVar.i;
            this.n = aVar.j;
            this.o = aVar.k;
            this.p = aVar.l;
            this.q = aVar.p;
            this.r = aVar.q;
            this.s = aVar.r;
            this.t = aVar.s;
            this.u = aVar.z;
            this.v = aVar.A;
            this.w = aVar.B;
            this.x = aVar.m;
            this.y = aVar.n;
            this.z = aVar.o;
            this.A = aVar.Q;
            this.B = aVar.R;
            this.C = aVar.S;
            this.f1484g = aVar.f1461c;
            this.f1482e = aVar.f1459a;
            this.f1483f = aVar.f1460b;
            this.f1479b = aVar.width;
            this.f1480c = aVar.height;
            this.D = aVar.leftMargin;
            this.E = aVar.rightMargin;
            this.F = aVar.topMargin;
            this.G = aVar.bottomMargin;
            this.Q = aVar.F;
            this.R = aVar.E;
            this.T = aVar.H;
            this.S = aVar.G;
            this.ah = aVar.T;
            this.ai = aVar.U;
            this.aj = aVar.I;
            this.ak = aVar.J;
            this.ah = aVar.T;
            this.al = aVar.M;
            this.am = aVar.N;
            this.an = aVar.K;
            this.ao = aVar.L;
            this.ap = aVar.O;
            this.aq = aVar.P;
            if (Build.VERSION.SDK_INT >= 17) {
                this.H = aVar.getMarginEnd();
                this.I = aVar.getMarginStart();
            }
        }

        public void a(ConstraintLayout.a aVar) {
            aVar.f1462d = this.h;
            aVar.f1463e = this.i;
            aVar.f1464f = this.j;
            aVar.f1465g = this.k;
            aVar.h = this.l;
            aVar.i = this.m;
            aVar.j = this.n;
            aVar.k = this.o;
            aVar.l = this.p;
            aVar.p = this.q;
            aVar.q = this.r;
            aVar.r = this.s;
            aVar.s = this.t;
            aVar.leftMargin = this.D;
            aVar.rightMargin = this.E;
            aVar.topMargin = this.F;
            aVar.bottomMargin = this.G;
            aVar.x = this.P;
            aVar.y = this.O;
            aVar.z = this.u;
            aVar.A = this.v;
            aVar.m = this.x;
            aVar.n = this.y;
            aVar.o = this.z;
            aVar.B = this.w;
            aVar.Q = this.A;
            aVar.R = this.B;
            aVar.F = this.Q;
            aVar.E = this.R;
            aVar.H = this.T;
            aVar.G = this.S;
            aVar.T = this.ah;
            aVar.U = this.ai;
            aVar.I = this.aj;
            aVar.J = this.ak;
            aVar.M = this.al;
            aVar.N = this.am;
            aVar.K = this.an;
            aVar.L = this.ao;
            aVar.O = this.ap;
            aVar.P = this.aq;
            aVar.S = this.C;
            aVar.f1461c = this.f1484g;
            aVar.f1459a = this.f1482e;
            aVar.f1460b = this.f1483f;
            aVar.width = this.f1479b;
            aVar.height = this.f1480c;
            if (Build.VERSION.SDK_INT >= 17) {
                aVar.setMarginStart(this.I);
                aVar.setMarginEnd(this.H);
            }
            aVar.a();
        }
    }

    public void a(Context context, int i) {
        a((ConstraintLayout) LayoutInflater.from(context).inflate(i, (ViewGroup) null));
    }

    public void a(ConstraintLayout constraintLayout) {
        int childCount = constraintLayout.getChildCount();
        this.f1477b.clear();
        int i = 0;
        while (i < childCount) {
            View childAt = constraintLayout.getChildAt(i);
            ConstraintLayout.a aVar = (ConstraintLayout.a) childAt.getLayoutParams();
            int id = childAt.getId();
            if (id != -1) {
                if (!this.f1477b.containsKey(Integer.valueOf(id))) {
                    this.f1477b.put(Integer.valueOf(id), new a());
                }
                a aVar2 = this.f1477b.get(Integer.valueOf(id));
                aVar2.a(id, aVar);
                aVar2.J = childAt.getVisibility();
                if (Build.VERSION.SDK_INT >= 17) {
                    aVar2.U = childAt.getAlpha();
                    aVar2.X = childAt.getRotation();
                    aVar2.Y = childAt.getRotationX();
                    aVar2.Z = childAt.getRotationY();
                    aVar2.aa = childAt.getScaleX();
                    aVar2.ab = childAt.getScaleY();
                    float pivotX = childAt.getPivotX();
                    float pivotY = childAt.getPivotY();
                    if (!(((double) pivotX) == 0.0d && ((double) pivotY) == 0.0d)) {
                        aVar2.ac = pivotX;
                        aVar2.ad = pivotY;
                    }
                    aVar2.ae = childAt.getTranslationX();
                    aVar2.af = childAt.getTranslationY();
                    if (Build.VERSION.SDK_INT >= 21) {
                        aVar2.ag = childAt.getTranslationZ();
                        if (aVar2.V) {
                            aVar2.W = childAt.getElevation();
                        }
                    }
                }
                if (childAt instanceof a) {
                    a aVar3 = (a) childAt;
                    aVar2.ar = aVar3.a();
                    aVar2.au = aVar3.getReferencedIds();
                    aVar2.as = aVar3.getType();
                }
                i++;
            } else {
                throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
            }
        }
    }

    public void a(d dVar) {
        int childCount = dVar.getChildCount();
        this.f1477b.clear();
        int i = 0;
        while (i < childCount) {
            View childAt = dVar.getChildAt(i);
            d.a aVar = (d.a) childAt.getLayoutParams();
            int id = childAt.getId();
            if (id != -1) {
                if (!this.f1477b.containsKey(Integer.valueOf(id))) {
                    this.f1477b.put(Integer.valueOf(id), new a());
                }
                a aVar2 = this.f1477b.get(Integer.valueOf(id));
                if (childAt instanceof b) {
                    aVar2.a((b) childAt, id, aVar);
                }
                aVar2.a(id, aVar);
                i++;
            } else {
                throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
            }
        }
    }

    public void b(ConstraintLayout constraintLayout) {
        c(constraintLayout);
        constraintLayout.setConstraintSet((c) null);
    }

    /* access modifiers changed from: package-private */
    public void c(ConstraintLayout constraintLayout) {
        int childCount = constraintLayout.getChildCount();
        HashSet hashSet = new HashSet(this.f1477b.keySet());
        int i = 0;
        while (i < childCount) {
            View childAt = constraintLayout.getChildAt(i);
            int id = childAt.getId();
            if (id != -1) {
                if (this.f1477b.containsKey(Integer.valueOf(id))) {
                    hashSet.remove(Integer.valueOf(id));
                    a aVar = this.f1477b.get(Integer.valueOf(id));
                    if (childAt instanceof a) {
                        aVar.at = 1;
                    }
                    if (aVar.at != -1 && aVar.at == 1) {
                        a aVar2 = (a) childAt;
                        aVar2.setId(id);
                        aVar2.setType(aVar.as);
                        aVar2.setAllowsGoneWidget(aVar.ar);
                        if (aVar.au != null) {
                            aVar2.setReferencedIds(aVar.au);
                        } else if (aVar.av != null) {
                            aVar.au = a((View) aVar2, aVar.av);
                            aVar2.setReferencedIds(aVar.au);
                        }
                    }
                    ConstraintLayout.a aVar3 = (ConstraintLayout.a) childAt.getLayoutParams();
                    aVar.a(aVar3);
                    childAt.setLayoutParams(aVar3);
                    childAt.setVisibility(aVar.J);
                    if (Build.VERSION.SDK_INT >= 17) {
                        childAt.setAlpha(aVar.U);
                        childAt.setRotation(aVar.X);
                        childAt.setRotationX(aVar.Y);
                        childAt.setRotationY(aVar.Z);
                        childAt.setScaleX(aVar.aa);
                        childAt.setScaleY(aVar.ab);
                        if (!Float.isNaN(aVar.ac)) {
                            childAt.setPivotX(aVar.ac);
                        }
                        if (!Float.isNaN(aVar.ad)) {
                            childAt.setPivotY(aVar.ad);
                        }
                        childAt.setTranslationX(aVar.ae);
                        childAt.setTranslationY(aVar.af);
                        if (Build.VERSION.SDK_INT >= 21) {
                            childAt.setTranslationZ(aVar.ag);
                            if (aVar.V) {
                                childAt.setElevation(aVar.W);
                            }
                        }
                    }
                }
                i++;
            } else {
                throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
            }
        }
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            Integer num = (Integer) it.next();
            a aVar4 = this.f1477b.get(num);
            if (aVar4.at != -1 && aVar4.at == 1) {
                a aVar5 = new a(constraintLayout.getContext());
                aVar5.setId(num.intValue());
                if (aVar4.au != null) {
                    aVar5.setReferencedIds(aVar4.au);
                } else if (aVar4.av != null) {
                    aVar4.au = a((View) aVar5, aVar4.av);
                    aVar5.setReferencedIds(aVar4.au);
                }
                aVar5.setType(aVar4.as);
                ConstraintLayout.a a2 = constraintLayout.generateDefaultLayoutParams();
                aVar5.b();
                aVar4.a(a2);
                constraintLayout.addView(aVar5, a2);
            }
            if (aVar4.f1478a) {
                Guideline guideline = new Guideline(constraintLayout.getContext());
                guideline.setId(num.intValue());
                ConstraintLayout.a a3 = constraintLayout.generateDefaultLayoutParams();
                aVar4.a(a3);
                constraintLayout.addView(guideline, a3);
            }
        }
    }

    public void a(int i, int i2, int i3, int i4, int i5, int i6, int i7, float f2) {
        int i8 = i3;
        float f3 = f2;
        if (i4 < 0) {
            throw new IllegalArgumentException("margin must be > 0");
        } else if (i7 < 0) {
            throw new IllegalArgumentException("margin must be > 0");
        } else if (f3 <= BitmapDescriptorFactory.HUE_RED || f3 > 1.0f) {
            throw new IllegalArgumentException("bias must be between 0 and 1 inclusive");
        } else if (i8 == 1 || i8 == 2) {
            int i9 = i;
            a(i9, 1, i2, i3, i4);
            a(i9, 2, i5, i6, i7);
            this.f1477b.get(Integer.valueOf(i)).u = f3;
        } else if (i8 == 6 || i8 == 7) {
            int i10 = i;
            a(i10, 6, i2, i3, i4);
            a(i10, 7, i5, i6, i7);
            this.f1477b.get(Integer.valueOf(i)).u = f3;
        } else {
            int i11 = i;
            a(i11, 3, i2, i3, i4);
            a(i11, 4, i5, i6, i7);
            this.f1477b.get(Integer.valueOf(i)).v = f3;
        }
    }

    // public void connect(int startId, .... )
    public void a(int i, int i2, int i3, int i4, int i5) {
        if (!this.f1477b.containsKey(Integer.valueOf(i))) {
            this.f1477b.put(Integer.valueOf(i), new a());
        }
        a aVar = this.f1477b.get(Integer.valueOf(i));
        switch (i2) {
            case 1:
                if (i4 == 1) {
                    aVar.h = i3;
                    aVar.i = -1;
                } else if (i4 == 2) {
                    aVar.i = i3;
                    aVar.h = -1;
                } else {
                    throw new IllegalArgumentException("Left to " + c(i4) + " undefined");
                }
                aVar.D = i5;
                return;
            case 2:
                if (i4 == 1) {
                    aVar.j = i3;
                    aVar.k = -1;
                } else if (i4 == 2) {
                    aVar.k = i3;
                    aVar.j = -1;
                } else {
                    throw new IllegalArgumentException("right to " + c(i4) + " undefined");
                }
                aVar.E = i5;
                return;
            case 3:
                if (i4 == 3) {
                    aVar.l = i3;
                    aVar.m = -1;
                    aVar.p = -1;
                } else if (i4 == 4) {
                    aVar.m = i3;
                    aVar.l = -1;
                    aVar.p = -1;
                } else {
                    throw new IllegalArgumentException("right to " + c(i4) + " undefined");
                }
                aVar.F = i5;
                return;
            case 4:
                if (i4 == 4) {
                    aVar.o = i3;
                    aVar.n = -1;
                    aVar.p = -1;
                } else if (i4 == 3) {
                    aVar.n = i3;
                    aVar.o = -1;
                    aVar.p = -1;
                } else {
                    throw new IllegalArgumentException("right to " + c(i4) + " undefined");
                }
                aVar.G = i5;
                return;
            case 5:
                if (i4 == 5) {
                    aVar.p = i3;
                    aVar.o = -1;
                    aVar.n = -1;
                    aVar.l = -1;
                    aVar.m = -1;
                    return;
                }
                throw new IllegalArgumentException("right to " + c(i4) + " undefined");
            case 6:
                if (i4 == 6) {
                    aVar.r = i3;
                    aVar.q = -1;
                } else if (i4 == 7) {
                    aVar.q = i3;
                    aVar.r = -1;
                } else {
                    throw new IllegalArgumentException("right to " + c(i4) + " undefined");
                }
                aVar.I = i5;
                return;
            case 7:
                if (i4 == 7) {
                    aVar.t = i3;
                    aVar.s = -1;
                } else if (i4 == 6) {
                    aVar.s = i3;
                    aVar.t = -1;
                } else {
                    throw new IllegalArgumentException("right to " + c(i4) + " undefined");
                }
                aVar.H = i5;
                return;
            default:
                throw new IllegalArgumentException(c(i2) + " to " + c(i4) + " unknown");
        }
    }

    public void a(int i, int i2, int i3, int i4) {
        if (!this.f1477b.containsKey(Integer.valueOf(i))) {
            this.f1477b.put(Integer.valueOf(i), new a());
        }
        a aVar = this.f1477b.get(Integer.valueOf(i));
        switch (i2) {
            case 1:
                if (i4 == 1) {
                    aVar.h = i3;
                    aVar.i = -1;
                    return;
                } else if (i4 == 2) {
                    aVar.i = i3;
                    aVar.h = -1;
                    return;
                } else {
                    throw new IllegalArgumentException("left to " + c(i4) + " undefined");
                }
            case 2:
                if (i4 == 1) {
                    aVar.j = i3;
                    aVar.k = -1;
                    return;
                } else if (i4 == 2) {
                    aVar.k = i3;
                    aVar.j = -1;
                    return;
                } else {
                    throw new IllegalArgumentException("right to " + c(i4) + " undefined");
                }
            case 3:
                if (i4 == 3) {
                    aVar.l = i3;
                    aVar.m = -1;
                    aVar.p = -1;
                    return;
                } else if (i4 == 4) {
                    aVar.m = i3;
                    aVar.l = -1;
                    aVar.p = -1;
                    return;
                } else {
                    throw new IllegalArgumentException("right to " + c(i4) + " undefined");
                }
            case 4:
                if (i4 == 4) {
                    aVar.o = i3;
                    aVar.n = -1;
                    aVar.p = -1;
                    return;
                } else if (i4 == 3) {
                    aVar.n = i3;
                    aVar.o = -1;
                    aVar.p = -1;
                    return;
                } else {
                    throw new IllegalArgumentException("right to " + c(i4) + " undefined");
                }
            case 5:
                if (i4 == 5) {
                    aVar.p = i3;
                    aVar.o = -1;
                    aVar.n = -1;
                    aVar.l = -1;
                    aVar.m = -1;
                    return;
                }
                throw new IllegalArgumentException("right to " + c(i4) + " undefined");
            case 6:
                if (i4 == 6) {
                    aVar.r = i3;
                    aVar.q = -1;
                    return;
                } else if (i4 == 7) {
                    aVar.q = i3;
                    aVar.r = -1;
                    return;
                } else {
                    throw new IllegalArgumentException("right to " + c(i4) + " undefined");
                }
            case 7:
                if (i4 == 7) {
                    aVar.t = i3;
                    aVar.s = -1;
                    return;
                } else if (i4 == 6) {
                    aVar.s = i3;
                    aVar.t = -1;
                    return;
                } else {
                    throw new IllegalArgumentException("right to " + c(i4) + " undefined");
                }
            default:
                throw new IllegalArgumentException(c(i2) + " to " + c(i4) + " unknown");
        }
    }

    public void a(int i, int i2) {
        if (i2 == 0) {
            a(i, 0, 1, 0, 0, 2, 0, 0.5f);
        } else {
            a(i, i2, 2, 0, i2, 1, 0, 0.5f);
        }
    }

    public void b(int i, int i2) {
        if (this.f1477b.containsKey(Integer.valueOf(i))) {
            a aVar = this.f1477b.get(Integer.valueOf(i));
            switch (i2) {
                case 1:
                    aVar.i = -1;
                    aVar.h = -1;
                    aVar.D = -1;
                    aVar.K = -1;
                    return;
                case 2:
                    aVar.k = -1;
                    aVar.j = -1;
                    aVar.E = -1;
                    aVar.M = -1;
                    return;
                case 3:
                    aVar.m = -1;
                    aVar.l = -1;
                    aVar.F = -1;
                    aVar.L = -1;
                    return;
                case 4:
                    aVar.n = -1;
                    aVar.o = -1;
                    aVar.G = -1;
                    aVar.N = -1;
                    return;
                case 5:
                    aVar.p = -1;
                    return;
                case 6:
                    aVar.q = -1;
                    aVar.r = -1;
                    aVar.I = -1;
                    aVar.P = -1;
                    return;
                case 7:
                    aVar.s = -1;
                    aVar.t = -1;
                    aVar.H = -1;
                    aVar.O = -1;
                    return;
                default:
                    throw new IllegalArgumentException("unknown constraint");
            }
        }
    }

    public void c(int i, int i2) {
        b(i).f1480c = i2;
    }

    public void d(int i, int i2) {
        b(i).f1479b = i2;
    }

    public void a(int i) {
        if (this.f1477b.containsKey(Integer.valueOf(i))) {
            a aVar = this.f1477b.get(Integer.valueOf(i));
            int i2 = aVar.i;
            int i3 = aVar.j;
            if (i2 == -1 && i3 == -1) {
                int i4 = aVar.q;
                int i5 = aVar.s;
                if (!(i4 == -1 && i5 == -1)) {
                    if (i4 != -1 && i5 != -1) {
                        a(i4, 7, i5, 6, 0);
                        a(i5, 6, i2, 7, 0);
                    } else if (!(i2 == -1 && i5 == -1)) {
                        if (aVar.k != -1) {
                            a(i2, 7, aVar.k, 7, 0);
                        } else if (aVar.h != -1) {
                            a(i5, 6, aVar.h, 6, 0);
                        }
                    }
                }
                b(i, 6);
                b(i, 7);
                return;
            }
            if (i2 != -1 && i3 != -1) {
                a(i2, 2, i3, 1, 0);
                a(i3, 1, i2, 2, 0);
            } else if (!(i2 == -1 && i3 == -1)) {
                if (aVar.k != -1) {
                    a(i2, 2, aVar.k, 2, 0);
                } else if (aVar.h != -1) {
                    a(i3, 1, aVar.h, 1, 0);
                }
            }
            b(i, 1);
            b(i, 2);
        }
    }

    private a b(int i) {
        if (!this.f1477b.containsKey(Integer.valueOf(i))) {
            this.f1477b.put(Integer.valueOf(i), new a());
        }
        return this.f1477b.get(Integer.valueOf(i));
    }

    public void b(Context context, int i) {
        XmlResourceParser xml = context.getResources().getXml(i);
        try {
            for (int eventType = xml.getEventType(); eventType != 1; eventType = xml.next()) {
                if (eventType == 0) {
                    xml.getName();
                } else if (eventType == 2) {
                    String name = xml.getName();
                    a a2 = a(context, Xml.asAttributeSet(xml));
                    if (name.equalsIgnoreCase("Guideline")) {
                        a2.f1478a = true;
                    }
                    this.f1477b.put(Integer.valueOf(a2.f1481d), a2);
                }
            }
        } catch (XmlPullParserException e2) {
            e2.printStackTrace();
        } catch (IOException e3) {
            e3.printStackTrace();
        }
    }

    private static int a(TypedArray typedArray, int i, int i2) {
        int resourceId = typedArray.getResourceId(i, i2);
        return resourceId == -1 ? typedArray.getInt(i, -1) : resourceId;
    }

    private a a(Context context, AttributeSet attributeSet) {
        a aVar = new a();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f.b.ConstraintSet);
        a(aVar, obtainStyledAttributes);
        obtainStyledAttributes.recycle();
        return aVar;
    }

    private void a(a aVar, TypedArray typedArray) {
        int indexCount = typedArray.getIndexCount();
        for (int i = 0; i < indexCount; i++) {
            int index = typedArray.getIndex(i);
            int i2 = f1476c.get(index);
            switch (i2) {
                case 1:
                    aVar.p = a(typedArray, index, aVar.p);
                    break;
                case 2:
                    aVar.G = typedArray.getDimensionPixelSize(index, aVar.G);
                    break;
                case 3:
                    aVar.o = a(typedArray, index, aVar.o);
                    break;
                case 4:
                    aVar.n = a(typedArray, index, aVar.n);
                    break;
                case 5:
                    aVar.w = typedArray.getString(index);
                    break;
                case 6:
                    aVar.A = typedArray.getDimensionPixelOffset(index, aVar.A);
                    break;
                case 7:
                    aVar.B = typedArray.getDimensionPixelOffset(index, aVar.B);
                    break;
                case 8:
                    aVar.H = typedArray.getDimensionPixelSize(index, aVar.H);
                    break;
                case 9:
                    aVar.t = a(typedArray, index, aVar.t);
                    break;
                case 10:
                    aVar.s = a(typedArray, index, aVar.s);
                    break;
                case 11:
                    aVar.N = typedArray.getDimensionPixelSize(index, aVar.N);
                    break;
                case 12:
                    aVar.O = typedArray.getDimensionPixelSize(index, aVar.O);
                    break;
                case 13:
                    aVar.K = typedArray.getDimensionPixelSize(index, aVar.K);
                    break;
                case 14:
                    aVar.M = typedArray.getDimensionPixelSize(index, aVar.M);
                    break;
                case 15:
                    aVar.P = typedArray.getDimensionPixelSize(index, aVar.P);
                    break;
                case 16:
                    aVar.L = typedArray.getDimensionPixelSize(index, aVar.L);
                    break;
                case 17:
                    aVar.f1482e = typedArray.getDimensionPixelOffset(index, aVar.f1482e);
                    break;
                case 18:
                    aVar.f1483f = typedArray.getDimensionPixelOffset(index, aVar.f1483f);
                    break;
                case 19:
                    aVar.f1484g = typedArray.getFloat(index, aVar.f1484g);
                    break;
                case 20:
                    aVar.u = typedArray.getFloat(index, aVar.u);
                    break;
                case 21:
                    aVar.f1480c = typedArray.getLayoutDimension(index, aVar.f1480c);
                    break;
                case 22:
                    aVar.J = typedArray.getInt(index, aVar.J);
                    aVar.J = f1475a[aVar.J];
                    break;
                case 23:
                    aVar.f1479b = typedArray.getLayoutDimension(index, aVar.f1479b);
                    break;
                case 24:
                    aVar.D = typedArray.getDimensionPixelSize(index, aVar.D);
                    break;
                case 25:
                    aVar.h = a(typedArray, index, aVar.h);
                    break;
                case 26:
                    aVar.i = a(typedArray, index, aVar.i);
                    break;
                case 27:
                    aVar.C = typedArray.getInt(index, aVar.C);
                    break;
                case 28:
                    aVar.E = typedArray.getDimensionPixelSize(index, aVar.E);
                    break;
                case 29:
                    aVar.j = a(typedArray, index, aVar.j);
                    break;
                case 30:
                    aVar.k = a(typedArray, index, aVar.k);
                    break;
                case 31:
                    aVar.I = typedArray.getDimensionPixelSize(index, aVar.I);
                    break;
                case 32:
                    aVar.q = a(typedArray, index, aVar.q);
                    break;
                case 33:
                    aVar.r = a(typedArray, index, aVar.r);
                    break;
                case 34:
                    aVar.F = typedArray.getDimensionPixelSize(index, aVar.F);
                    break;
                case 35:
                    aVar.m = a(typedArray, index, aVar.m);
                    break;
                case 36:
                    aVar.l = a(typedArray, index, aVar.l);
                    break;
                case 37:
                    aVar.v = typedArray.getFloat(index, aVar.v);
                    break;
                case 38:
                    aVar.f1481d = typedArray.getResourceId(index, aVar.f1481d);
                    break;
                case 39:
                    aVar.R = typedArray.getFloat(index, aVar.R);
                    break;
                case 40:
                    aVar.Q = typedArray.getFloat(index, aVar.Q);
                    break;
                case 41:
                    aVar.S = typedArray.getInt(index, aVar.S);
                    break;
                case 42:
                    aVar.T = typedArray.getInt(index, aVar.T);
                    break;
                case 43:
                    aVar.U = typedArray.getFloat(index, aVar.U);
                    break;
                case 44:
                    aVar.V = true;
                    aVar.W = typedArray.getDimension(index, aVar.W);
                    break;
                case 45:
                    aVar.Y = typedArray.getFloat(index, aVar.Y);
                    break;
                case 46:
                    aVar.Z = typedArray.getFloat(index, aVar.Z);
                    break;
                case 47:
                    aVar.aa = typedArray.getFloat(index, aVar.aa);
                    break;
                case 48:
                    aVar.ab = typedArray.getFloat(index, aVar.ab);
                    break;
                case 49:
                    aVar.ac = typedArray.getFloat(index, aVar.ac);
                    break;
                case 50:
                    aVar.ad = typedArray.getFloat(index, aVar.ad);
                    break;
                case 51:
                    aVar.ae = typedArray.getDimension(index, aVar.ae);
                    break;
                case 52:
                    aVar.af = typedArray.getDimension(index, aVar.af);
                    break;
                case 53:
                    aVar.ag = typedArray.getDimension(index, aVar.ag);
                    break;
                default:
                    switch (i2) {
                        case 60:
                            aVar.X = typedArray.getFloat(index, aVar.X);
                            break;
                        case 61:
                            aVar.x = a(typedArray, index, aVar.x);
                            break;
                        case 62:
                            aVar.y = typedArray.getDimensionPixelSize(index, aVar.y);
                            break;
                        case 63:
                            aVar.z = typedArray.getFloat(index, aVar.z);
                            break;
                        default:
                            switch (i2) {
                                case 69:
                                    aVar.ap = typedArray.getFloat(index, 1.0f);
                                    break;
                                case 70:
                                    aVar.aq = typedArray.getFloat(index, 1.0f);
                                    break;
                                case 71:
                                    Log.e("ConstraintSet", "CURRENTLY UNSUPPORTED");
                                    break;
                                case 72:
                                    aVar.as = typedArray.getInt(index, aVar.as);
                                    break;
                                case 73:
                                    aVar.av = typedArray.getString(index);
                                    break;
                                case 74:
                                    aVar.ar = typedArray.getBoolean(index, aVar.ar);
                                    break;
                                case 75:
                                    Log.w("ConstraintSet", "unused attribute 0x" + Integer.toHexString(index) + "   " + f1476c.get(index));
                                    break;
                                default:
                                    Log.w("ConstraintSet", "Unknown attribute 0x" + Integer.toHexString(index) + "   " + f1476c.get(index));
                                    break;
                            }
                    }
            }
        }
    }

    private int[] a(View view, String str) {
        int i;
        String[] split = str.split(",");
        Context context = view.getContext();
        int[] iArr = new int[split.length];
        int i2 = 0;
        int i3 = 0;
        while (i2 < split.length) {
            String trim = split[i2].trim();
            try {
                i = f.a.class.getField(trim).getInt((Object) null);
            } catch (Exception unused) {
                i = 0;
            }
            if (i == 0) {
                i = context.getResources().getIdentifier(trim, "id", context.getPackageName());
            }
            if (i == 0 && view.isInEditMode() && (view.getParent() instanceof ConstraintLayout)) {
                Object a2 = ((ConstraintLayout) view.getParent()).a(0, (Object) trim);
                if (a2 != null && (a2 instanceof Integer)) {
                    i = ((Integer) a2).intValue();
                }
            }
            iArr[i3] = i;
            i2++;
            i3++;
        }
        return i3 != split.length ? Arrays.copyOf(iArr, i3) : iArr;
    }
}
