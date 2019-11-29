package androidx.fragment.app;

import android.util.Log;
import androidx.core.util.b;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.i;
import androidx.fragment.app.l;
import androidx.lifecycle.e;
import com.litesuits.orm.db.assit.SQLBuilder;
import java.io.PrintWriter;
import java.util.ArrayList;

final class a extends l implements i.e {

    /* renamed from: a  reason: collision with root package name */
    final i f2162a;

    /* renamed from: b  reason: collision with root package name */
    boolean f2163b;

    /* renamed from: c  reason: collision with root package name */
    int f2164c = -1;

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("BackStackEntry{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        if (this.f2164c >= 0) {
            sb.append(" #");
            sb.append(this.f2164c);
        }
        if (this.m != null) {
            sb.append(SQLBuilder.BLANK);
            sb.append(this.m);
        }
        sb.append("}");
        return sb.toString();
    }

    public void a(String str, PrintWriter printWriter) {
        a(str, printWriter, true);
    }

    public void a(String str, PrintWriter printWriter, boolean z) {
        String str2;
        if (z) {
            printWriter.print(str);
            printWriter.print("mName=");
            printWriter.print(this.m);
            printWriter.print(" mIndex=");
            printWriter.print(this.f2164c);
            printWriter.print(" mCommitted=");
            printWriter.println(this.f2163b);
            if (this.i != 0) {
                printWriter.print(str);
                printWriter.print("mTransition=#");
                printWriter.print(Integer.toHexString(this.i));
                printWriter.print(" mTransitionStyle=#");
                printWriter.println(Integer.toHexString(this.j));
            }
            if (!(this.f2228e == 0 && this.f2229f == 0)) {
                printWriter.print(str);
                printWriter.print("mEnterAnim=#");
                printWriter.print(Integer.toHexString(this.f2228e));
                printWriter.print(" mExitAnim=#");
                printWriter.println(Integer.toHexString(this.f2229f));
            }
            if (!(this.f2230g == 0 && this.h == 0)) {
                printWriter.print(str);
                printWriter.print("mPopEnterAnim=#");
                printWriter.print(Integer.toHexString(this.f2230g));
                printWriter.print(" mPopExitAnim=#");
                printWriter.println(Integer.toHexString(this.h));
            }
            if (!(this.n == 0 && this.o == null)) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbTitleRes=#");
                printWriter.print(Integer.toHexString(this.n));
                printWriter.print(" mBreadCrumbTitleText=");
                printWriter.println(this.o);
            }
            if (!(this.p == 0 && this.q == null)) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbShortTitleRes=#");
                printWriter.print(Integer.toHexString(this.p));
                printWriter.print(" mBreadCrumbShortTitleText=");
                printWriter.println(this.q);
            }
        }
        if (!this.f2227d.isEmpty()) {
            printWriter.print(str);
            printWriter.println("Operations:");
            int size = this.f2227d.size();
            for (int i = 0; i < size; i++) {
                l.a aVar = (l.a) this.f2227d.get(i);
                switch (aVar.f2231a) {
                    case 0:
                        str2 = "NULL";
                        break;
                    case 1:
                        str2 = "ADD";
                        break;
                    case 2:
                        str2 = "REPLACE";
                        break;
                    case 3:
                        str2 = "REMOVE";
                        break;
                    case 4:
                        str2 = "HIDE";
                        break;
                    case 5:
                        str2 = "SHOW";
                        break;
                    case 6:
                        str2 = "DETACH";
                        break;
                    case 7:
                        str2 = "ATTACH";
                        break;
                    case 8:
                        str2 = "SET_PRIMARY_NAV";
                        break;
                    case 9:
                        str2 = "UNSET_PRIMARY_NAV";
                        break;
                    case 10:
                        str2 = "OP_SET_MAX_LIFECYCLE";
                        break;
                    default:
                        str2 = "cmd=" + aVar.f2231a;
                        break;
                }
                printWriter.print(str);
                printWriter.print("  Op #");
                printWriter.print(i);
                printWriter.print(": ");
                printWriter.print(str2);
                printWriter.print(SQLBuilder.BLANK);
                printWriter.println(aVar.f2232b);
                if (z) {
                    if (!(aVar.f2233c == 0 && aVar.f2234d == 0)) {
                        printWriter.print(str);
                        printWriter.print("enterAnim=#");
                        printWriter.print(Integer.toHexString(aVar.f2233c));
                        printWriter.print(" exitAnim=#");
                        printWriter.println(Integer.toHexString(aVar.f2234d));
                    }
                    if (aVar.f2235e != 0 || aVar.f2236f != 0) {
                        printWriter.print(str);
                        printWriter.print("popEnterAnim=#");
                        printWriter.print(Integer.toHexString(aVar.f2235e));
                        printWriter.print(" popExitAnim=#");
                        printWriter.println(Integer.toHexString(aVar.f2236f));
                    }
                }
            }
        }
    }

    public a(i iVar) {
        this.f2162a = iVar;
    }

    /* access modifiers changed from: package-private */
    public void a(int i, Fragment fragment, String str, int i2) {
        super.a(i, fragment, str, i2);
        fragment.mFragmentManager = this.f2162a;
    }

    public l a(Fragment fragment) {
        if (fragment.mFragmentManager == null || fragment.mFragmentManager == this.f2162a) {
            return super.a(fragment);
        }
        throw new IllegalStateException("Cannot remove Fragment attached to a different FragmentManager. Fragment " + fragment.toString() + " is already attached to a FragmentManager.");
    }

    public l b(Fragment fragment) {
        if (fragment.mFragmentManager == null || fragment.mFragmentManager == this.f2162a) {
            return super.b(fragment);
        }
        throw new IllegalStateException("Cannot detach Fragment attached to a different FragmentManager. Fragment " + fragment.toString() + " is already attached to a FragmentManager.");
    }

    public l a(Fragment fragment, e.b bVar) {
        if (fragment.mFragmentManager != this.f2162a) {
            throw new IllegalArgumentException("Cannot setMaxLifecycle for Fragment not attached to FragmentManager " + this.f2162a);
        } else if (bVar.isAtLeast(e.b.CREATED)) {
            return super.a(fragment, bVar);
        } else {
            throw new IllegalArgumentException("Cannot set maximum Lifecycle below " + e.b.CREATED);
        }
    }

    /* access modifiers changed from: package-private */
    public void a(int i) {
        if (this.k) {
            if (i.f2176b) {
                Log.v("FragmentManager", "Bump nesting in " + this + " by " + i);
            }
            int size = this.f2227d.size();
            for (int i2 = 0; i2 < size; i2++) {
                l.a aVar = (l.a) this.f2227d.get(i2);
                if (aVar.f2232b != null) {
                    aVar.f2232b.mBackStackNesting += i;
                    if (i.f2176b) {
                        Log.v("FragmentManager", "Bump nesting of " + aVar.f2232b + " to " + aVar.f2232b.mBackStackNesting);
                    }
                }
            }
        }
    }

    public void a() {
        if (this.u != null) {
            for (int i = 0; i < this.u.size(); i++) {
                ((Runnable) this.u.get(i)).run();
            }
            this.u = null;
        }
    }

    public int b() {
        return a(false);
    }

    public int c() {
        return a(true);
    }

    public void d() {
        i();
        this.f2162a.b((i.e) this, false);
    }

    public void e() {
        i();
        this.f2162a.b((i.e) this, true);
    }

    /* access modifiers changed from: package-private */
    public int a(boolean z) {
        if (!this.f2163b) {
            if (i.f2176b) {
                Log.v("FragmentManager", "Commit: " + this);
                PrintWriter printWriter = new PrintWriter(new b("FragmentManager"));
                a("  ", printWriter);
                printWriter.close();
            }
            this.f2163b = true;
            if (this.k) {
                this.f2164c = this.f2162a.a(this);
            } else {
                this.f2164c = -1;
            }
            this.f2162a.a((i.e) this, z);
            return this.f2164c;
        }
        throw new IllegalStateException("commit already called");
    }

    public boolean a(ArrayList<a> arrayList, ArrayList<Boolean> arrayList2) {
        if (i.f2176b) {
            Log.v("FragmentManager", "Run: " + this);
        }
        arrayList.add(this);
        arrayList2.add(false);
        if (!this.k) {
            return true;
        }
        this.f2162a.b(this);
        return true;
    }

    /* access modifiers changed from: package-private */
    public boolean b(int i) {
        int size = this.f2227d.size();
        for (int i2 = 0; i2 < size; i2++) {
            l.a aVar = (l.a) this.f2227d.get(i2);
            int i3 = aVar.f2232b != null ? aVar.f2232b.mContainerId : 0;
            if (i3 != 0 && i3 == i) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public boolean a(ArrayList<a> arrayList, int i, int i2) {
        if (i2 == i) {
            return false;
        }
        int size = this.f2227d.size();
        int i3 = -1;
        for (int i4 = 0; i4 < size; i4++) {
            l.a aVar = (l.a) this.f2227d.get(i4);
            int i5 = aVar.f2232b != null ? aVar.f2232b.mContainerId : 0;
            if (!(i5 == 0 || i5 == i3)) {
                for (int i6 = i; i6 < i2; i6++) {
                    a aVar2 = arrayList.get(i6);
                    int size2 = aVar2.f2227d.size();
                    for (int i7 = 0; i7 < size2; i7++) {
                        l.a aVar3 = (l.a) aVar2.f2227d.get(i7);
                        if ((aVar3.f2232b != null ? aVar3.f2232b.mContainerId : 0) == i5) {
                            return true;
                        }
                    }
                }
                i3 = i5;
            }
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public void f() {
        int size = this.f2227d.size();
        for (int i = 0; i < size; i++) {
            l.a aVar = (l.a) this.f2227d.get(i);
            Fragment fragment = aVar.f2232b;
            if (fragment != null) {
                fragment.setNextTransition(this.i, this.j);
            }
            switch (aVar.f2231a) {
                case 1:
                    fragment.setNextAnim(aVar.f2233c);
                    this.f2162a.a(fragment, false);
                    break;
                case 3:
                    fragment.setNextAnim(aVar.f2234d);
                    this.f2162a.n(fragment);
                    break;
                case 4:
                    fragment.setNextAnim(aVar.f2234d);
                    this.f2162a.o(fragment);
                    break;
                case 5:
                    fragment.setNextAnim(aVar.f2233c);
                    this.f2162a.p(fragment);
                    break;
                case 6:
                    fragment.setNextAnim(aVar.f2234d);
                    this.f2162a.q(fragment);
                    break;
                case 7:
                    fragment.setNextAnim(aVar.f2233c);
                    this.f2162a.r(fragment);
                    break;
                case 8:
                    this.f2162a.u(fragment);
                    break;
                case 9:
                    this.f2162a.u((Fragment) null);
                    break;
                case 10:
                    this.f2162a.a(fragment, aVar.h);
                    break;
                default:
                    throw new IllegalArgumentException("Unknown cmd: " + aVar.f2231a);
            }
            if (!(this.t || aVar.f2231a == 1 || fragment == null)) {
                this.f2162a.k(fragment);
            }
        }
        if (!this.t) {
            i iVar = this.f2162a;
            iVar.a(iVar.m, true);
        }
    }

    /* access modifiers changed from: package-private */
    public void b(boolean z) {
        for (int size = this.f2227d.size() - 1; size >= 0; size--) {
            l.a aVar = (l.a) this.f2227d.get(size);
            Fragment fragment = aVar.f2232b;
            if (fragment != null) {
                fragment.setNextTransition(i.d(this.i), this.j);
            }
            switch (aVar.f2231a) {
                case 1:
                    fragment.setNextAnim(aVar.f2236f);
                    this.f2162a.n(fragment);
                    break;
                case 3:
                    fragment.setNextAnim(aVar.f2235e);
                    this.f2162a.a(fragment, false);
                    break;
                case 4:
                    fragment.setNextAnim(aVar.f2235e);
                    this.f2162a.p(fragment);
                    break;
                case 5:
                    fragment.setNextAnim(aVar.f2236f);
                    this.f2162a.o(fragment);
                    break;
                case 6:
                    fragment.setNextAnim(aVar.f2235e);
                    this.f2162a.r(fragment);
                    break;
                case 7:
                    fragment.setNextAnim(aVar.f2236f);
                    this.f2162a.q(fragment);
                    break;
                case 8:
                    this.f2162a.u((Fragment) null);
                    break;
                case 9:
                    this.f2162a.u(fragment);
                    break;
                case 10:
                    this.f2162a.a(fragment, aVar.f2237g);
                    break;
                default:
                    throw new IllegalArgumentException("Unknown cmd: " + aVar.f2231a);
            }
            if (!(this.t || aVar.f2231a == 3 || fragment == null)) {
                this.f2162a.k(fragment);
            }
        }
        if (!this.t && z) {
            i iVar = this.f2162a;
            iVar.a(iVar.m, true);
        }
    }

    /* access modifiers changed from: package-private */
    public Fragment a(ArrayList<Fragment> arrayList, Fragment fragment) {
        ArrayList<Fragment> arrayList2 = arrayList;
        Fragment fragment2 = fragment;
        int i = 0;
        while (i < this.f2227d.size()) {
            l.a aVar = (l.a) this.f2227d.get(i);
            int i2 = aVar.f2231a;
            if (i2 != 1) {
                if (i2 == 2) {
                    Fragment fragment3 = aVar.f2232b;
                    int i3 = fragment3.mContainerId;
                    Fragment fragment4 = fragment2;
                    int i4 = i;
                    boolean z = false;
                    for (int size = arrayList.size() - 1; size >= 0; size--) {
                        Fragment fragment5 = arrayList2.get(size);
                        if (fragment5.mContainerId == i3) {
                            if (fragment5 == fragment3) {
                                z = true;
                            } else {
                                if (fragment5 == fragment4) {
                                    this.f2227d.add(i4, new l.a(9, fragment5));
                                    i4++;
                                    fragment4 = null;
                                }
                                l.a aVar2 = new l.a(3, fragment5);
                                aVar2.f2233c = aVar.f2233c;
                                aVar2.f2235e = aVar.f2235e;
                                aVar2.f2234d = aVar.f2234d;
                                aVar2.f2236f = aVar.f2236f;
                                this.f2227d.add(i4, aVar2);
                                arrayList2.remove(fragment5);
                                i4++;
                            }
                        }
                    }
                    if (z) {
                        this.f2227d.remove(i4);
                        i4--;
                    } else {
                        aVar.f2231a = 1;
                        arrayList2.add(fragment3);
                    }
                    i = i4;
                    fragment2 = fragment4;
                } else if (i2 == 3 || i2 == 6) {
                    arrayList2.remove(aVar.f2232b);
                    if (aVar.f2232b == fragment2) {
                        this.f2227d.add(i, new l.a(9, aVar.f2232b));
                        i++;
                        fragment2 = null;
                    }
                } else if (i2 != 7) {
                    if (i2 == 8) {
                        this.f2227d.add(i, new l.a(9, fragment2));
                        i++;
                        fragment2 = aVar.f2232b;
                    }
                }
                i++;
            }
            arrayList2.add(aVar.f2232b);
            i++;
        }
        return fragment2;
    }

    /* access modifiers changed from: package-private */
    public Fragment b(ArrayList<Fragment> arrayList, Fragment fragment) {
        for (int size = this.f2227d.size() - 1; size >= 0; size--) {
            l.a aVar = (l.a) this.f2227d.get(size);
            int i = aVar.f2231a;
            if (i != 1) {
                if (i != 3) {
                    switch (i) {
                        case 6:
                            break;
                        case 7:
                            break;
                        case 8:
                            fragment = null;
                            break;
                        case 9:
                            fragment = aVar.f2232b;
                            break;
                        case 10:
                            aVar.h = aVar.f2237g;
                            break;
                    }
                }
                arrayList.add(aVar.f2232b);
            }
            arrayList.remove(aVar.f2232b);
        }
        return fragment;
    }

    /* access modifiers changed from: package-private */
    public boolean g() {
        for (int i = 0; i < this.f2227d.size(); i++) {
            if (b((l.a) this.f2227d.get(i))) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public void a(Fragment.c cVar) {
        for (int i = 0; i < this.f2227d.size(); i++) {
            l.a aVar = (l.a) this.f2227d.get(i);
            if (b(aVar)) {
                aVar.f2232b.setOnStartEnterTransitionListener(cVar);
            }
        }
    }

    private static boolean b(l.a aVar) {
        Fragment fragment = aVar.f2232b;
        return fragment != null && fragment.mAdded && fragment.mView != null && !fragment.mDetached && !fragment.mHidden && fragment.isPostponed();
    }

    public String h() {
        return this.m;
    }
}
