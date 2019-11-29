package androidx.fragment.app;

import android.graphics.Rect;
import android.os.Build;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.app.n;
import androidx.core.g.s;
import androidx.core.g.w;
import androidx.fragment.app.l;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

class m {

    /* renamed from: a  reason: collision with root package name */
    private static final int[] f2238a = {0, 3, 0, 1, 5, 4, 7, 6, 9, 8, 10};

    /* renamed from: b  reason: collision with root package name */
    private static final o f2239b = (Build.VERSION.SDK_INT >= 21 ? new n() : null);

    /* renamed from: c  reason: collision with root package name */
    private static final o f2240c = a();

    private static o a() {
        try {
            return (o) Class.forName("androidx.l.f").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }

    static void a(i iVar, ArrayList<a> arrayList, ArrayList<Boolean> arrayList2, int i, int i2, boolean z) {
        if (iVar.m >= 1) {
            SparseArray sparseArray = new SparseArray();
            for (int i3 = i; i3 < i2; i3++) {
                a aVar = arrayList.get(i3);
                if (arrayList2.get(i3).booleanValue()) {
                    b(aVar, (SparseArray<a>) sparseArray, z);
                } else {
                    a(aVar, (SparseArray<a>) sparseArray, z);
                }
            }
            if (sparseArray.size() != 0) {
                View view = new View(iVar.n.i());
                int size = sparseArray.size();
                for (int i4 = 0; i4 < size; i4++) {
                    int keyAt = sparseArray.keyAt(i4);
                    androidx.b.a<String, String> a2 = a(keyAt, arrayList, arrayList2, i, i2);
                    a aVar2 = (a) sparseArray.valueAt(i4);
                    if (z) {
                        a(iVar, keyAt, aVar2, view, a2);
                    } else {
                        b(iVar, keyAt, aVar2, view, a2);
                    }
                }
            }
        }
    }

    private static androidx.b.a<String, String> a(int i, ArrayList<a> arrayList, ArrayList<Boolean> arrayList2, int i2, int i3) {
        ArrayList arrayList3;
        ArrayList arrayList4;
        androidx.b.a<String, String> aVar = new androidx.b.a<>();
        for (int i4 = i3 - 1; i4 >= i2; i4--) {
            a aVar2 = arrayList.get(i4);
            if (aVar2.b(i)) {
                boolean booleanValue = arrayList2.get(i4).booleanValue();
                if (aVar2.r != null) {
                    int size = aVar2.r.size();
                    if (booleanValue) {
                        ArrayList arrayList5 = aVar2.r;
                        arrayList3 = aVar2.s;
                        arrayList4 = arrayList5;
                    } else {
                        arrayList3 = aVar2.r;
                        arrayList4 = aVar2.s;
                    }
                    for (int i5 = 0; i5 < size; i5++) {
                        String str = (String) arrayList3.get(i5);
                        String str2 = (String) arrayList4.get(i5);
                        String remove = aVar.remove(str2);
                        if (remove != null) {
                            aVar.put(str, remove);
                        } else {
                            aVar.put(str, str2);
                        }
                    }
                }
            }
        }
        return aVar;
    }

    private static void a(i iVar, int i, a aVar, View view, androidx.b.a<String, String> aVar2) {
        Object obj;
        i iVar2 = iVar;
        a aVar3 = aVar;
        View view2 = view;
        ViewGroup viewGroup = iVar2.o.a() ? (ViewGroup) iVar2.o.a(i) : null;
        if (viewGroup != null) {
            Fragment fragment = aVar3.f2263a;
            Fragment fragment2 = aVar3.f2266d;
            o a2 = a(fragment2, fragment);
            if (a2 != null) {
                boolean z = aVar3.f2264b;
                boolean z2 = aVar3.f2267e;
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                Object a3 = a(a2, fragment, z);
                Object b2 = b(a2, fragment2, z2);
                ViewGroup viewGroup2 = viewGroup;
                ArrayList arrayList3 = arrayList2;
                Object a4 = a(a2, viewGroup, view, aVar2, aVar, (ArrayList<View>) arrayList2, (ArrayList<View>) arrayList, a3, b2);
                Object obj2 = a3;
                if (obj2 == null && a4 == null) {
                    obj = b2;
                    if (obj == null) {
                        return;
                    }
                } else {
                    obj = b2;
                }
                ArrayList<View> a5 = a(a2, obj, fragment2, (ArrayList<View>) arrayList3, view2);
                ArrayList<View> a6 = a(a2, obj2, fragment, (ArrayList<View>) arrayList, view2);
                a(a6, 4);
                Fragment fragment3 = fragment;
                ArrayList<View> arrayList4 = a5;
                Object a7 = a(a2, obj2, obj, a4, fragment3, z);
                if (a7 != null) {
                    a(a2, obj, fragment2, arrayList4);
                    ArrayList<String> a8 = a2.a((ArrayList<View>) arrayList);
                    a2.a(a7, obj2, a6, obj, arrayList4, a4, arrayList);
                    ViewGroup viewGroup3 = viewGroup2;
                    a2.a(viewGroup3, a7);
                    a2.a(viewGroup3, arrayList3, arrayList, a8, aVar2);
                    a(a6, 0);
                    a2.a(a4, (ArrayList<View>) arrayList3, (ArrayList<View>) arrayList);
                }
            }
        }
    }

    private static void a(o oVar, Object obj, Fragment fragment, final ArrayList<View> arrayList) {
        if (fragment != null && obj != null && fragment.mAdded && fragment.mHidden && fragment.mHiddenChanged) {
            fragment.setHideReplaced(true);
            oVar.b(obj, fragment.getView(), arrayList);
            s.a(fragment.mContainer, new Runnable() {
                public void run() {
                    m.a((ArrayList<View>) arrayList, 4);
                }
            });
        }
    }

    private static void b(i iVar, int i, a aVar, View view, androidx.b.a<String, String> aVar2) {
        Object obj;
        i iVar2 = iVar;
        a aVar3 = aVar;
        View view2 = view;
        androidx.b.a<String, String> aVar4 = aVar2;
        ViewGroup viewGroup = iVar2.o.a() ? (ViewGroup) iVar2.o.a(i) : null;
        if (viewGroup != null) {
            Fragment fragment = aVar3.f2263a;
            Fragment fragment2 = aVar3.f2266d;
            o a2 = a(fragment2, fragment);
            if (a2 != null) {
                boolean z = aVar3.f2264b;
                boolean z2 = aVar3.f2267e;
                Object a3 = a(a2, fragment, z);
                Object b2 = b(a2, fragment2, z2);
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                ArrayList arrayList3 = arrayList;
                Object obj2 = b2;
                o oVar = a2;
                Object b3 = b(a2, viewGroup, view, aVar2, aVar, arrayList, arrayList2, a3, obj2);
                Object obj3 = a3;
                if (obj3 == null && b3 == null) {
                    obj = obj2;
                    if (obj == null) {
                        return;
                    }
                } else {
                    obj = obj2;
                }
                ArrayList<View> a4 = a(oVar, obj, fragment2, (ArrayList<View>) arrayList3, view2);
                Object obj4 = (a4 == null || a4.isEmpty()) ? null : obj;
                oVar.b(obj3, view2);
                Object a5 = a(oVar, obj3, obj4, b3, fragment, aVar3.f2264b);
                if (a5 != null) {
                    ArrayList arrayList4 = new ArrayList();
                    o oVar2 = oVar;
                    oVar2.a(a5, obj3, arrayList4, obj4, a4, b3, arrayList2);
                    a(oVar2, viewGroup, fragment, view, (ArrayList<View>) arrayList2, obj3, (ArrayList<View>) arrayList4, obj4, a4);
                    ArrayList arrayList5 = arrayList2;
                    oVar.a((View) viewGroup, (ArrayList<View>) arrayList5, (Map<String, String>) aVar4);
                    oVar.a(viewGroup, a5);
                    oVar.a(viewGroup, (ArrayList<View>) arrayList5, (Map<String, String>) aVar4);
                }
            }
        }
    }

    private static void a(o oVar, ViewGroup viewGroup, Fragment fragment, View view, ArrayList<View> arrayList, Object obj, ArrayList<View> arrayList2, Object obj2, ArrayList<View> arrayList3) {
        final Object obj3 = obj;
        final o oVar2 = oVar;
        final View view2 = view;
        final Fragment fragment2 = fragment;
        final ArrayList<View> arrayList4 = arrayList;
        final ArrayList<View> arrayList5 = arrayList2;
        final ArrayList<View> arrayList6 = arrayList3;
        final Object obj4 = obj2;
        ViewGroup viewGroup2 = viewGroup;
        s.a(viewGroup, new Runnable() {
            public void run() {
                Object obj = obj3;
                if (obj != null) {
                    oVar2.c(obj, view2);
                    arrayList5.addAll(m.a(oVar2, obj3, fragment2, (ArrayList<View>) arrayList4, view2));
                }
                if (arrayList6 != null) {
                    if (obj4 != null) {
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(view2);
                        oVar2.b(obj4, (ArrayList<View>) arrayList6, (ArrayList<View>) arrayList);
                    }
                    arrayList6.clear();
                    arrayList6.add(view2);
                }
            }
        });
    }

    private static o a(Fragment fragment, Fragment fragment2) {
        ArrayList arrayList = new ArrayList();
        if (fragment != null) {
            Object exitTransition = fragment.getExitTransition();
            if (exitTransition != null) {
                arrayList.add(exitTransition);
            }
            Object returnTransition = fragment.getReturnTransition();
            if (returnTransition != null) {
                arrayList.add(returnTransition);
            }
            Object sharedElementReturnTransition = fragment.getSharedElementReturnTransition();
            if (sharedElementReturnTransition != null) {
                arrayList.add(sharedElementReturnTransition);
            }
        }
        if (fragment2 != null) {
            Object enterTransition = fragment2.getEnterTransition();
            if (enterTransition != null) {
                arrayList.add(enterTransition);
            }
            Object reenterTransition = fragment2.getReenterTransition();
            if (reenterTransition != null) {
                arrayList.add(reenterTransition);
            }
            Object sharedElementEnterTransition = fragment2.getSharedElementEnterTransition();
            if (sharedElementEnterTransition != null) {
                arrayList.add(sharedElementEnterTransition);
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        o oVar = f2239b;
        if (oVar != null && a(oVar, (List<Object>) arrayList)) {
            return f2239b;
        }
        o oVar2 = f2240c;
        if (oVar2 != null && a(oVar2, (List<Object>) arrayList)) {
            return f2240c;
        }
        if (f2239b == null && f2240c == null) {
            return null;
        }
        throw new IllegalArgumentException("Invalid Transition types");
    }

    private static boolean a(o oVar, List<Object> list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (!oVar.a(list.get(i))) {
                return false;
            }
        }
        return true;
    }

    private static Object a(o oVar, Fragment fragment, Fragment fragment2, boolean z) {
        Object obj;
        if (fragment == null || fragment2 == null) {
            return null;
        }
        if (z) {
            obj = fragment2.getSharedElementReturnTransition();
        } else {
            obj = fragment.getSharedElementEnterTransition();
        }
        return oVar.c(oVar.b(obj));
    }

    private static Object a(o oVar, Fragment fragment, boolean z) {
        Object obj;
        if (fragment == null) {
            return null;
        }
        if (z) {
            obj = fragment.getReenterTransition();
        } else {
            obj = fragment.getEnterTransition();
        }
        return oVar.b(obj);
    }

    private static Object b(o oVar, Fragment fragment, boolean z) {
        Object obj;
        if (fragment == null) {
            return null;
        }
        if (z) {
            obj = fragment.getReturnTransition();
        } else {
            obj = fragment.getExitTransition();
        }
        return oVar.b(obj);
    }

    private static Object a(o oVar, ViewGroup viewGroup, View view, androidx.b.a<String, String> aVar, a aVar2, ArrayList<View> arrayList, ArrayList<View> arrayList2, Object obj, Object obj2) {
        Object obj3;
        Object obj4;
        final Rect rect;
        final View view2;
        o oVar2 = oVar;
        View view3 = view;
        androidx.b.a<String, String> aVar3 = aVar;
        a aVar4 = aVar2;
        ArrayList<View> arrayList3 = arrayList;
        ArrayList<View> arrayList4 = arrayList2;
        Object obj5 = obj;
        Fragment fragment = aVar4.f2263a;
        Fragment fragment2 = aVar4.f2266d;
        if (fragment != null) {
            fragment.requireView().setVisibility(0);
        }
        if (fragment == null || fragment2 == null) {
            return null;
        }
        boolean z = aVar4.f2264b;
        if (aVar.isEmpty()) {
            obj3 = null;
        } else {
            obj3 = a(oVar, fragment, fragment2, z);
        }
        androidx.b.a<String, View> b2 = b(oVar, aVar3, obj3, aVar4);
        androidx.b.a<String, View> a2 = a(oVar, aVar3, obj3, aVar4);
        if (aVar.isEmpty()) {
            if (b2 != null) {
                b2.clear();
            }
            if (a2 != null) {
                a2.clear();
            }
            obj4 = null;
        } else {
            a(arrayList3, b2, (Collection<String>) aVar.keySet());
            a(arrayList4, a2, aVar.values());
            obj4 = obj3;
        }
        if (obj5 == null && obj2 == null && obj4 == null) {
            return null;
        }
        a(fragment, fragment2, z, b2, true);
        if (obj4 != null) {
            arrayList4.add(view3);
            oVar.a(obj4, view3, arrayList3);
            a(oVar, obj4, obj2, b2, aVar4.f2267e, aVar4.f2268f);
            Rect rect2 = new Rect();
            View a3 = a(a2, aVar4, obj5, z);
            if (a3 != null) {
                oVar.a(obj5, rect2);
            }
            rect = rect2;
            view2 = a3;
        } else {
            view2 = null;
            rect = null;
        }
        final Fragment fragment3 = fragment;
        final Fragment fragment4 = fragment2;
        final boolean z2 = z;
        final androidx.b.a<String, View> aVar5 = a2;
        final o oVar3 = oVar;
        s.a(viewGroup, new Runnable() {
            public void run() {
                m.a(fragment3, fragment4, z2, (androidx.b.a<String, View>) aVar5, false);
                View view = view2;
                if (view != null) {
                    oVar3.a(view, rect);
                }
            }
        });
        return obj4;
    }

    private static void a(ArrayList<View> arrayList, androidx.b.a<String, View> aVar, Collection<String> collection) {
        for (int size = aVar.size() - 1; size >= 0; size--) {
            View c2 = aVar.c(size);
            if (collection.contains(w.q(c2))) {
                arrayList.add(c2);
            }
        }
    }

    private static Object b(o oVar, ViewGroup viewGroup, View view, androidx.b.a<String, String> aVar, a aVar2, ArrayList<View> arrayList, ArrayList<View> arrayList2, Object obj, Object obj2) {
        androidx.b.a<String, String> aVar3;
        Object obj3;
        Object obj4;
        Rect rect;
        o oVar2 = oVar;
        a aVar4 = aVar2;
        ArrayList<View> arrayList3 = arrayList;
        Object obj5 = obj;
        Fragment fragment = aVar4.f2263a;
        Fragment fragment2 = aVar4.f2266d;
        if (fragment == null || fragment2 == null) {
            return null;
        }
        boolean z = aVar4.f2264b;
        if (aVar.isEmpty()) {
            aVar3 = aVar;
            obj3 = null;
        } else {
            obj3 = a(oVar2, fragment, fragment2, z);
            aVar3 = aVar;
        }
        androidx.b.a<String, View> b2 = b(oVar2, aVar3, obj3, aVar4);
        if (aVar.isEmpty()) {
            obj4 = null;
        } else {
            arrayList3.addAll(b2.values());
            obj4 = obj3;
        }
        if (obj5 == null && obj2 == null && obj4 == null) {
            return null;
        }
        a(fragment, fragment2, z, b2, true);
        if (obj4 != null) {
            rect = new Rect();
            oVar2.a(obj4, view, arrayList3);
            a(oVar, obj4, obj2, b2, aVar4.f2267e, aVar4.f2268f);
            if (obj5 != null) {
                oVar2.a(obj5, rect);
            }
        } else {
            rect = null;
        }
        final o oVar3 = oVar;
        final androidx.b.a<String, String> aVar5 = aVar;
        final Object obj6 = obj4;
        final a aVar6 = aVar2;
        AnonymousClass4 r13 = r0;
        final ArrayList<View> arrayList4 = arrayList2;
        final View view2 = view;
        final Fragment fragment3 = fragment;
        final Fragment fragment4 = fragment2;
        final boolean z2 = z;
        final ArrayList<View> arrayList5 = arrayList;
        final Object obj7 = obj;
        final Rect rect2 = rect;
        AnonymousClass4 r0 = new Runnable() {
            public void run() {
                androidx.b.a<String, View> a2 = m.a(oVar3, (androidx.b.a<String, String>) aVar5, obj6, aVar6);
                if (a2 != null) {
                    arrayList4.addAll(a2.values());
                    arrayList4.add(view2);
                }
                m.a(fragment3, fragment4, z2, a2, false);
                Object obj = obj6;
                if (obj != null) {
                    oVar3.a(obj, (ArrayList<View>) arrayList5, (ArrayList<View>) arrayList4);
                    View a3 = m.a(a2, aVar6, obj7, z2);
                    if (a3 != null) {
                        oVar3.a(a3, rect2);
                    }
                }
            }
        };
        s.a(viewGroup, r13);
        return obj4;
    }

    private static androidx.b.a<String, View> b(o oVar, androidx.b.a<String, String> aVar, Object obj, a aVar2) {
        n nVar;
        ArrayList arrayList;
        if (aVar.isEmpty() || obj == null) {
            aVar.clear();
            return null;
        }
        Fragment fragment = aVar2.f2266d;
        androidx.b.a<String, View> aVar3 = new androidx.b.a<>();
        oVar.a((Map<String, View>) aVar3, fragment.requireView());
        a aVar4 = aVar2.f2268f;
        if (aVar2.f2267e) {
            nVar = fragment.getEnterTransitionCallback();
            arrayList = aVar4.s;
        } else {
            nVar = fragment.getExitTransitionCallback();
            arrayList = aVar4.r;
        }
        aVar3.a(arrayList);
        if (nVar != null) {
            nVar.a((List<String>) arrayList, (Map<String, View>) aVar3);
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                String str = (String) arrayList.get(size);
                View view = aVar3.get(str);
                if (view == null) {
                    aVar.remove(str);
                } else if (!str.equals(w.q(view))) {
                    aVar.put(w.q(view), aVar.remove(str));
                }
            }
        } else {
            aVar.a(aVar3.keySet());
        }
        return aVar3;
    }

    static androidx.b.a<String, View> a(o oVar, androidx.b.a<String, String> aVar, Object obj, a aVar2) {
        n nVar;
        ArrayList arrayList;
        Fragment fragment = aVar2.f2263a;
        View view = fragment.getView();
        if (aVar.isEmpty() || obj == null || view == null) {
            aVar.clear();
            return null;
        }
        androidx.b.a<String, View> aVar3 = new androidx.b.a<>();
        oVar.a((Map<String, View>) aVar3, view);
        a aVar4 = aVar2.f2265c;
        if (aVar2.f2264b) {
            nVar = fragment.getExitTransitionCallback();
            arrayList = aVar4.r;
        } else {
            nVar = fragment.getEnterTransitionCallback();
            arrayList = aVar4.s;
        }
        if (arrayList != null) {
            aVar3.a(arrayList);
            aVar3.a(aVar.values());
        }
        if (nVar != null) {
            nVar.a((List<String>) arrayList, (Map<String, View>) aVar3);
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                String str = (String) arrayList.get(size);
                View view2 = aVar3.get(str);
                if (view2 == null) {
                    String a2 = a(aVar, str);
                    if (a2 != null) {
                        aVar.remove(a2);
                    }
                } else if (!str.equals(w.q(view2))) {
                    String a3 = a(aVar, str);
                    if (a3 != null) {
                        aVar.put(a3, w.q(view2));
                    }
                }
            }
        } else {
            a(aVar, aVar3);
        }
        return aVar3;
    }

    private static String a(androidx.b.a<String, String> aVar, String str) {
        int size = aVar.size();
        for (int i = 0; i < size; i++) {
            if (str.equals(aVar.c(i))) {
                return aVar.b(i);
            }
        }
        return null;
    }

    static View a(androidx.b.a<String, View> aVar, a aVar2, Object obj, boolean z) {
        String str;
        a aVar3 = aVar2.f2265c;
        if (obj == null || aVar == null || aVar3.r == null || aVar3.r.isEmpty()) {
            return null;
        }
        if (z) {
            str = (String) aVar3.r.get(0);
        } else {
            str = (String) aVar3.s.get(0);
        }
        return aVar.get(str);
    }

    private static void a(o oVar, Object obj, Object obj2, androidx.b.a<String, View> aVar, boolean z, a aVar2) {
        String str;
        if (aVar2.r != null && !aVar2.r.isEmpty()) {
            if (z) {
                str = (String) aVar2.s.get(0);
            } else {
                str = (String) aVar2.r.get(0);
            }
            View view = aVar.get(str);
            oVar.a(obj, view);
            if (obj2 != null) {
                oVar.a(obj2, view);
            }
        }
    }

    private static void a(androidx.b.a<String, String> aVar, androidx.b.a<String, View> aVar2) {
        for (int size = aVar.size() - 1; size >= 0; size--) {
            if (!aVar2.containsKey(aVar.c(size))) {
                aVar.d(size);
            }
        }
    }

    static void a(Fragment fragment, Fragment fragment2, boolean z, androidx.b.a<String, View> aVar, boolean z2) {
        n nVar;
        int i;
        if (z) {
            nVar = fragment2.getEnterTransitionCallback();
        } else {
            nVar = fragment.getEnterTransitionCallback();
        }
        if (nVar != null) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            if (aVar == null) {
                i = 0;
            } else {
                i = aVar.size();
            }
            for (int i2 = 0; i2 < i; i2++) {
                arrayList2.add(aVar.b(i2));
                arrayList.add(aVar.c(i2));
            }
            if (z2) {
                nVar.a((List<String>) arrayList2, (List<View>) arrayList, (List<View>) null);
            } else {
                nVar.b(arrayList2, arrayList, (List<View>) null);
            }
        }
    }

    static ArrayList<View> a(o oVar, Object obj, Fragment fragment, ArrayList<View> arrayList, View view) {
        if (obj == null) {
            return null;
        }
        ArrayList<View> arrayList2 = new ArrayList<>();
        View view2 = fragment.getView();
        if (view2 != null) {
            oVar.a(arrayList2, view2);
        }
        if (arrayList != null) {
            arrayList2.removeAll(arrayList);
        }
        if (arrayList2.isEmpty()) {
            return arrayList2;
        }
        arrayList2.add(view);
        oVar.a(obj, arrayList2);
        return arrayList2;
    }

    static void a(ArrayList<View> arrayList, int i) {
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                arrayList.get(size).setVisibility(i);
            }
        }
    }

    private static Object a(o oVar, Object obj, Object obj2, Object obj3, Fragment fragment, boolean z) {
        boolean z2;
        if (obj == null || obj2 == null || fragment == null) {
            z2 = true;
        } else {
            z2 = z ? fragment.getAllowReturnTransitionOverlap() : fragment.getAllowEnterTransitionOverlap();
        }
        if (z2) {
            return oVar.a(obj2, obj, obj3);
        }
        return oVar.b(obj2, obj, obj3);
    }

    public static void a(a aVar, SparseArray<a> sparseArray, boolean z) {
        int size = aVar.f2227d.size();
        for (int i = 0; i < size; i++) {
            a(aVar, (l.a) aVar.f2227d.get(i), sparseArray, false, z);
        }
    }

    public static void b(a aVar, SparseArray<a> sparseArray, boolean z) {
        if (aVar.f2162a.o.a()) {
            for (int size = aVar.f2227d.size() - 1; size >= 0; size--) {
                a(aVar, (l.a) aVar.f2227d.get(size), sparseArray, true, z);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0041, code lost:
        if (r10.mAdded != false) goto L_0x0096;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x0078, code lost:
        r1 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x0094, code lost:
        if (r10.mHidden == false) goto L_0x0096;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x0096, code lost:
        r1 = true;
     */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00a4  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x00e9 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:96:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void a(androidx.fragment.app.a r16, androidx.fragment.app.l.a r17, android.util.SparseArray<androidx.fragment.app.m.a> r18, boolean r19, boolean r20) {
        /*
            r0 = r16
            r1 = r17
            r2 = r18
            r3 = r19
            androidx.fragment.app.Fragment r10 = r1.f2232b
            if (r10 != 0) goto L_0x000d
            return
        L_0x000d:
            int r11 = r10.mContainerId
            if (r11 != 0) goto L_0x0012
            return
        L_0x0012:
            if (r3 == 0) goto L_0x001b
            int[] r4 = f2238a
            int r1 = r1.f2231a
            r1 = r4[r1]
            goto L_0x001d
        L_0x001b:
            int r1 = r1.f2231a
        L_0x001d:
            r4 = 0
            r5 = 1
            if (r1 == r5) goto L_0x0089
            r6 = 3
            if (r1 == r6) goto L_0x005f
            r6 = 4
            if (r1 == r6) goto L_0x0047
            r6 = 5
            if (r1 == r6) goto L_0x0035
            r6 = 6
            if (r1 == r6) goto L_0x005f
            r6 = 7
            if (r1 == r6) goto L_0x0089
            r1 = 0
        L_0x0031:
            r12 = 0
            r13 = 0
            goto L_0x009c
        L_0x0035:
            if (r20 == 0) goto L_0x0044
            boolean r1 = r10.mHiddenChanged
            if (r1 == 0) goto L_0x0098
            boolean r1 = r10.mHidden
            if (r1 != 0) goto L_0x0098
            boolean r1 = r10.mAdded
            if (r1 == 0) goto L_0x0098
            goto L_0x0096
        L_0x0044:
            boolean r1 = r10.mHidden
            goto L_0x0099
        L_0x0047:
            if (r20 == 0) goto L_0x0056
            boolean r1 = r10.mHiddenChanged
            if (r1 == 0) goto L_0x007a
            boolean r1 = r10.mAdded
            if (r1 == 0) goto L_0x007a
            boolean r1 = r10.mHidden
            if (r1 == 0) goto L_0x007a
        L_0x0055:
            goto L_0x0078
        L_0x0056:
            boolean r1 = r10.mAdded
            if (r1 == 0) goto L_0x007a
            boolean r1 = r10.mHidden
            if (r1 != 0) goto L_0x007a
            goto L_0x0055
        L_0x005f:
            if (r20 == 0) goto L_0x007c
            boolean r1 = r10.mAdded
            if (r1 != 0) goto L_0x007a
            android.view.View r1 = r10.mView
            if (r1 == 0) goto L_0x007a
            android.view.View r1 = r10.mView
            int r1 = r1.getVisibility()
            if (r1 != 0) goto L_0x007a
            float r1 = r10.mPostponedAlpha
            r6 = 0
            int r1 = (r1 > r6 ? 1 : (r1 == r6 ? 0 : -1))
            if (r1 < 0) goto L_0x007a
        L_0x0078:
            r1 = 1
            goto L_0x0085
        L_0x007a:
            r1 = 0
            goto L_0x0085
        L_0x007c:
            boolean r1 = r10.mAdded
            if (r1 == 0) goto L_0x007a
            boolean r1 = r10.mHidden
            if (r1 != 0) goto L_0x007a
            goto L_0x0078
        L_0x0085:
            r13 = r1
            r1 = 0
            r12 = 1
            goto L_0x009c
        L_0x0089:
            if (r20 == 0) goto L_0x008e
            boolean r1 = r10.mIsNewlyAdded
            goto L_0x0099
        L_0x008e:
            boolean r1 = r10.mAdded
            if (r1 != 0) goto L_0x0098
            boolean r1 = r10.mHidden
            if (r1 != 0) goto L_0x0098
        L_0x0096:
            r1 = 1
            goto L_0x0099
        L_0x0098:
            r1 = 0
        L_0x0099:
            r4 = r1
            r1 = 1
            goto L_0x0031
        L_0x009c:
            java.lang.Object r6 = r2.get(r11)
            androidx.fragment.app.m$a r6 = (androidx.fragment.app.m.a) r6
            if (r4 == 0) goto L_0x00ae
            androidx.fragment.app.m$a r6 = a((androidx.fragment.app.m.a) r6, (android.util.SparseArray<androidx.fragment.app.m.a>) r2, (int) r11)
            r6.f2263a = r10
            r6.f2264b = r3
            r6.f2265c = r0
        L_0x00ae:
            r14 = r6
            r15 = 0
            if (r20 != 0) goto L_0x00d5
            if (r1 == 0) goto L_0x00d5
            if (r14 == 0) goto L_0x00bc
            androidx.fragment.app.Fragment r1 = r14.f2266d
            if (r1 != r10) goto L_0x00bc
            r14.f2266d = r15
        L_0x00bc:
            androidx.fragment.app.i r4 = r0.f2162a
            int r1 = r10.mState
            if (r1 >= r5) goto L_0x00d5
            int r1 = r4.m
            if (r1 < r5) goto L_0x00d5
            boolean r1 = r0.t
            if (r1 != 0) goto L_0x00d5
            r4.l(r10)
            r6 = 1
            r7 = 0
            r8 = 0
            r9 = 0
            r5 = r10
            r4.a((androidx.fragment.app.Fragment) r5, (int) r6, (int) r7, (int) r8, (boolean) r9)
        L_0x00d5:
            if (r13 == 0) goto L_0x00e7
            if (r14 == 0) goto L_0x00dd
            androidx.fragment.app.Fragment r1 = r14.f2266d
            if (r1 != 0) goto L_0x00e7
        L_0x00dd:
            androidx.fragment.app.m$a r14 = a((androidx.fragment.app.m.a) r14, (android.util.SparseArray<androidx.fragment.app.m.a>) r2, (int) r11)
            r14.f2266d = r10
            r14.f2267e = r3
            r14.f2268f = r0
        L_0x00e7:
            if (r20 != 0) goto L_0x00f3
            if (r12 == 0) goto L_0x00f3
            if (r14 == 0) goto L_0x00f3
            androidx.fragment.app.Fragment r0 = r14.f2263a
            if (r0 != r10) goto L_0x00f3
            r14.f2263a = r15
        L_0x00f3:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.m.a(androidx.fragment.app.a, androidx.fragment.app.l$a, android.util.SparseArray, boolean, boolean):void");
    }

    private static a a(a aVar, SparseArray<a> sparseArray, int i) {
        if (aVar != null) {
            return aVar;
        }
        a aVar2 = new a();
        sparseArray.put(i, aVar2);
        return aVar2;
    }

    static class a {

        /* renamed from: a  reason: collision with root package name */
        public Fragment f2263a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f2264b;

        /* renamed from: c  reason: collision with root package name */
        public a f2265c;

        /* renamed from: d  reason: collision with root package name */
        public Fragment f2266d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f2267e;

        /* renamed from: f  reason: collision with root package name */
        public a f2268f;

        a() {
        }
    }
}
