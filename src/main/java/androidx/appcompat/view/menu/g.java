package androidx.appcompat.view.menu;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.ContextMenu;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.core.g.x;
import com.facebook.soloader.MinElf;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class g implements androidx.core.a.a.a {

    /* renamed from: d  reason: collision with root package name */
    private static final int[] f850d = {1, 4, 5, 3, 2, 0};
    private boolean A;

    /* renamed from: a  reason: collision with root package name */
    CharSequence f851a;

    /* renamed from: b  reason: collision with root package name */
    Drawable f852b;

    /* renamed from: c  reason: collision with root package name */
    View f853c;

    /* renamed from: e  reason: collision with root package name */
    private final Context f854e;

    /* renamed from: f  reason: collision with root package name */
    private final Resources f855f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f856g;
    private boolean h;
    private a i;
    private ArrayList<i> j;
    private ArrayList<i> k;
    private boolean l;
    private ArrayList<i> m;
    private ArrayList<i> n;
    private boolean o;
    private int p = 0;
    private ContextMenu.ContextMenuInfo q;
    private boolean r = false;
    private boolean s = false;
    private boolean t = false;
    private boolean u = false;
    private boolean v = false;
    private ArrayList<i> w = new ArrayList<>();
    private CopyOnWriteArrayList<WeakReference<m>> x = new CopyOnWriteArrayList<>();
    private i y;
    private boolean z = false;

    public interface a {
        void a(g gVar);

        boolean a(g gVar, MenuItem menuItem);
    }

    public interface b {
        boolean a(i iVar);
    }

    /* access modifiers changed from: protected */
    public String a() {
        return "android:menu:actionviewstates";
    }

    public g q() {
        return this;
    }

    public g(Context context) {
        this.f854e = context;
        this.f855f = context.getResources();
        this.j = new ArrayList<>();
        this.k = new ArrayList<>();
        this.l = true;
        this.m = new ArrayList<>();
        this.n = new ArrayList<>();
        this.o = true;
        e(true);
    }

    public g a(int i2) {
        this.p = i2;
        return this;
    }

    public void a(m mVar) {
        a(mVar, this.f854e);
    }

    public void a(m mVar, Context context) {
        this.x.add(new WeakReference(mVar));
        mVar.a(context, this);
        this.o = true;
    }

    public void b(m mVar) {
        Iterator<WeakReference<m>> it = this.x.iterator();
        while (it.hasNext()) {
            WeakReference next = it.next();
            m mVar2 = (m) next.get();
            if (mVar2 == null || mVar2 == mVar) {
                this.x.remove(next);
            }
        }
    }

    private void d(boolean z2) {
        if (!this.x.isEmpty()) {
            h();
            Iterator<WeakReference<m>> it = this.x.iterator();
            while (it.hasNext()) {
                WeakReference next = it.next();
                m mVar = (m) next.get();
                if (mVar == null) {
                    this.x.remove(next);
                } else {
                    mVar.a(z2);
                }
            }
            i();
        }
    }

    private boolean a(r rVar, m mVar) {
        boolean z2 = false;
        if (this.x.isEmpty()) {
            return false;
        }
        if (mVar != null) {
            z2 = mVar.a(rVar);
        }
        Iterator<WeakReference<m>> it = this.x.iterator();
        while (it.hasNext()) {
            WeakReference next = it.next();
            m mVar2 = (m) next.get();
            if (mVar2 == null) {
                this.x.remove(next);
            } else if (!z2) {
                z2 = mVar2.a(rVar);
            }
        }
        return z2;
    }

    private void e(Bundle bundle) {
        if (!this.x.isEmpty()) {
            SparseArray sparseArray = new SparseArray();
            Iterator<WeakReference<m>> it = this.x.iterator();
            while (it.hasNext()) {
                WeakReference next = it.next();
                m mVar = (m) next.get();
                if (mVar == null) {
                    this.x.remove(next);
                } else {
                    int c2 = mVar.c();
                    if (c2 > 0) {
                        Parcelable f2 = mVar.f();
                        if (f2 != null) {
                            sparseArray.put(c2, f2);
                        }
                    }
                }
            }
            bundle.putSparseParcelableArray("android:menu:presenters", sparseArray);
        }
    }

    private void f(Bundle bundle) {
        SparseArray sparseParcelableArray = bundle.getSparseParcelableArray("android:menu:presenters");
        if (sparseParcelableArray != null && !this.x.isEmpty()) {
            Iterator<WeakReference<m>> it = this.x.iterator();
            while (it.hasNext()) {
                WeakReference next = it.next();
                m mVar = (m) next.get();
                if (mVar == null) {
                    this.x.remove(next);
                } else {
                    int c2 = mVar.c();
                    if (c2 > 0) {
                        Parcelable parcelable = (Parcelable) sparseParcelableArray.get(c2);
                        if (parcelable != null) {
                            mVar.a(parcelable);
                        }
                    }
                }
            }
        }
    }

    public void a(Bundle bundle) {
        e(bundle);
    }

    public void b(Bundle bundle) {
        f(bundle);
    }

    public void c(Bundle bundle) {
        int size = size();
        SparseArray sparseArray = null;
        for (int i2 = 0; i2 < size; i2++) {
            MenuItem item = getItem(i2);
            View actionView = item.getActionView();
            if (!(actionView == null || actionView.getId() == -1)) {
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                }
                actionView.saveHierarchyState(sparseArray);
                if (item.isActionViewExpanded()) {
                    bundle.putInt("android:menu:expandedactionview", item.getItemId());
                }
            }
            if (item.hasSubMenu()) {
                ((r) item.getSubMenu()).c(bundle);
            }
        }
        if (sparseArray != null) {
            bundle.putSparseParcelableArray(a(), sparseArray);
        }
    }

    public void d(Bundle bundle) {
        if (bundle != null) {
            SparseArray sparseParcelableArray = bundle.getSparseParcelableArray(a());
            int size = size();
            for (int i2 = 0; i2 < size; i2++) {
                MenuItem item = getItem(i2);
                View actionView = item.getActionView();
                if (!(actionView == null || actionView.getId() == -1)) {
                    actionView.restoreHierarchyState(sparseParcelableArray);
                }
                if (item.hasSubMenu()) {
                    ((r) item.getSubMenu()).d(bundle);
                }
            }
            int i3 = bundle.getInt("android:menu:expandedactionview");
            if (i3 > 0) {
                MenuItem findItem = findItem(i3);
                if (findItem != null) {
                    findItem.expandActionView();
                }
            }
        }
    }

    public void a(a aVar) {
        this.i = aVar;
    }

    /* access modifiers changed from: protected */
    public MenuItem a(int i2, int i3, int i4, CharSequence charSequence) {
        int f2 = f(i4);
        i a2 = a(i2, i3, i4, f2, charSequence, this.p);
        ContextMenu.ContextMenuInfo contextMenuInfo = this.q;
        if (contextMenuInfo != null) {
            a2.a(contextMenuInfo);
        }
        ArrayList<i> arrayList = this.j;
        arrayList.add(a(arrayList, f2), a2);
        b(true);
        return a2;
    }

    private i a(int i2, int i3, int i4, int i5, CharSequence charSequence, int i6) {
        return new i(this, i2, i3, i4, i5, charSequence, i6);
    }

    public MenuItem add(CharSequence charSequence) {
        return a(0, 0, 0, charSequence);
    }

    public MenuItem add(int i2) {
        return a(0, 0, 0, this.f855f.getString(i2));
    }

    public MenuItem add(int i2, int i3, int i4, CharSequence charSequence) {
        return a(i2, i3, i4, charSequence);
    }

    public MenuItem add(int i2, int i3, int i4, int i5) {
        return a(i2, i3, i4, this.f855f.getString(i5));
    }

    public SubMenu addSubMenu(CharSequence charSequence) {
        return addSubMenu(0, 0, 0, charSequence);
    }

    public SubMenu addSubMenu(int i2) {
        return addSubMenu(0, 0, 0, (CharSequence) this.f855f.getString(i2));
    }

    public SubMenu addSubMenu(int i2, int i3, int i4, CharSequence charSequence) {
        i iVar = (i) a(i2, i3, i4, charSequence);
        r rVar = new r(this.f854e, this, iVar);
        iVar.a(rVar);
        return rVar;
    }

    public SubMenu addSubMenu(int i2, int i3, int i4, int i5) {
        return addSubMenu(i2, i3, i4, (CharSequence) this.f855f.getString(i5));
    }

    public void setGroupDividerEnabled(boolean z2) {
        this.z = z2;
    }

    public boolean b() {
        return this.z;
    }

    public int addIntentOptions(int i2, int i3, int i4, ComponentName componentName, Intent[] intentArr, Intent intent, int i5, MenuItem[] menuItemArr) {
        PackageManager packageManager = this.f854e.getPackageManager();
        List<ResolveInfo> queryIntentActivityOptions = packageManager.queryIntentActivityOptions(componentName, intentArr, intent, 0);
        int size = queryIntentActivityOptions != null ? queryIntentActivityOptions.size() : 0;
        if ((i5 & 1) == 0) {
            removeGroup(i2);
        }
        for (int i6 = 0; i6 < size; i6++) {
            ResolveInfo resolveInfo = queryIntentActivityOptions.get(i6);
            Intent intent2 = new Intent(resolveInfo.specificIndex < 0 ? intent : intentArr[resolveInfo.specificIndex]);
            intent2.setComponent(new ComponentName(resolveInfo.activityInfo.applicationInfo.packageName, resolveInfo.activityInfo.name));
            MenuItem intent3 = add(i2, i3, i4, resolveInfo.loadLabel(packageManager)).setIcon(resolveInfo.loadIcon(packageManager)).setIntent(intent2);
            if (menuItemArr != null && resolveInfo.specificIndex >= 0) {
                menuItemArr[resolveInfo.specificIndex] = intent3;
            }
        }
        return size;
    }

    public void removeItem(int i2) {
        a(b(i2), true);
    }

    public void removeGroup(int i2) {
        int c2 = c(i2);
        if (c2 >= 0) {
            int size = this.j.size() - c2;
            int i3 = 0;
            while (true) {
                int i4 = i3 + 1;
                if (i3 >= size || this.j.get(c2).getGroupId() != i2) {
                    b(true);
                } else {
                    a(c2, false);
                    i3 = i4;
                }
            }
            b(true);
        }
    }

    private void a(int i2, boolean z2) {
        if (i2 >= 0 && i2 < this.j.size()) {
            this.j.remove(i2);
            if (z2) {
                b(true);
            }
        }
    }

    public void clear() {
        i iVar = this.y;
        if (iVar != null) {
            d(iVar);
        }
        this.j.clear();
        b(true);
    }

    /* access modifiers changed from: package-private */
    public void a(MenuItem menuItem) {
        int groupId = menuItem.getGroupId();
        int size = this.j.size();
        h();
        for (int i2 = 0; i2 < size; i2++) {
            i iVar = this.j.get(i2);
            if (iVar.getGroupId() == groupId && iVar.g() && iVar.isCheckable()) {
                iVar.b(iVar == menuItem);
            }
        }
        i();
    }

    public void setGroupCheckable(int i2, boolean z2, boolean z3) {
        int size = this.j.size();
        for (int i3 = 0; i3 < size; i3++) {
            i iVar = this.j.get(i3);
            if (iVar.getGroupId() == i2) {
                iVar.a(z3);
                iVar.setCheckable(z2);
            }
        }
    }

    public void setGroupVisible(int i2, boolean z2) {
        int size = this.j.size();
        boolean z3 = false;
        for (int i3 = 0; i3 < size; i3++) {
            i iVar = this.j.get(i3);
            if (iVar.getGroupId() == i2 && iVar.c(z2)) {
                z3 = true;
            }
        }
        if (z3) {
            b(true);
        }
    }

    public void setGroupEnabled(int i2, boolean z2) {
        int size = this.j.size();
        for (int i3 = 0; i3 < size; i3++) {
            i iVar = this.j.get(i3);
            if (iVar.getGroupId() == i2) {
                iVar.setEnabled(z2);
            }
        }
    }

    public boolean hasVisibleItems() {
        if (this.A) {
            return true;
        }
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            if (this.j.get(i2).isVisible()) {
                return true;
            }
        }
        return false;
    }

    public MenuItem findItem(int i2) {
        int size = size();
        for (int i3 = 0; i3 < size; i3++) {
            i iVar = this.j.get(i3);
            if (iVar.getItemId() == i2) {
                return iVar;
            }
            if (iVar.hasSubMenu()) {
                MenuItem findItem = iVar.getSubMenu().findItem(i2);
                if (findItem != null) {
                    return findItem;
                }
            }
        }
        return null;
    }

    public int b(int i2) {
        int size = size();
        for (int i3 = 0; i3 < size; i3++) {
            if (this.j.get(i3).getItemId() == i2) {
                return i3;
            }
        }
        return -1;
    }

    public int c(int i2) {
        return a(i2, 0);
    }

    public int a(int i2, int i3) {
        int size = size();
        if (i3 < 0) {
            i3 = 0;
        }
        while (i3 < size) {
            if (this.j.get(i3).getGroupId() == i2) {
                return i3;
            }
            i3++;
        }
        return -1;
    }

    public int size() {
        return this.j.size();
    }

    public MenuItem getItem(int i2) {
        return this.j.get(i2);
    }

    public boolean isShortcutKey(int i2, KeyEvent keyEvent) {
        return a(i2, keyEvent) != null;
    }

    public void setQwertyMode(boolean z2) {
        this.f856g = z2;
        b(false);
    }

    private static int f(int i2) {
        int i3 = (-65536 & i2) >> 16;
        if (i3 >= 0) {
            int[] iArr = f850d;
            if (i3 < iArr.length) {
                return (i2 & MinElf.PN_XNUM) | (iArr[i3] << 16);
            }
        }
        throw new IllegalArgumentException("order does not contain a valid category.");
    }

    /* access modifiers changed from: package-private */
    public boolean c() {
        return this.f856g;
    }

    private void e(boolean z2) {
        boolean z3 = true;
        if (!z2 || this.f855f.getConfiguration().keyboard == 1 || !x.c(ViewConfiguration.get(this.f854e), this.f854e)) {
            z3 = false;
        }
        this.h = z3;
    }

    public boolean d() {
        return this.h;
    }

    /* access modifiers changed from: package-private */
    public Resources e() {
        return this.f855f;
    }

    public Context f() {
        return this.f854e;
    }

    /* access modifiers changed from: package-private */
    public boolean a(g gVar, MenuItem menuItem) {
        a aVar = this.i;
        return aVar != null && aVar.a(gVar, menuItem);
    }

    public void g() {
        a aVar = this.i;
        if (aVar != null) {
            aVar.a(this);
        }
    }

    private static int a(ArrayList<i> arrayList, int i2) {
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            if (arrayList.get(size).c() <= i2) {
                return size + 1;
            }
        }
        return 0;
    }

    public boolean performShortcut(int i2, KeyEvent keyEvent, int i3) {
        i a2 = a(i2, keyEvent);
        boolean a3 = a2 != null ? a((MenuItem) a2, i3) : false;
        if ((i3 & 2) != 0) {
            a(true);
        }
        return a3;
    }

    /* access modifiers changed from: package-private */
    public void a(List<i> list, int i2, KeyEvent keyEvent) {
        boolean c2 = c();
        int modifiers = keyEvent.getModifiers();
        KeyCharacterMap.KeyData keyData = new KeyCharacterMap.KeyData();
        if (keyEvent.getKeyData(keyData) || i2 == 67) {
            int size = this.j.size();
            for (int i3 = 0; i3 < size; i3++) {
                i iVar = this.j.get(i3);
                if (iVar.hasSubMenu()) {
                    ((g) iVar.getSubMenu()).a(list, i2, keyEvent);
                }
                char alphabeticShortcut = c2 ? iVar.getAlphabeticShortcut() : iVar.getNumericShortcut();
                if (((modifiers & 69647) == ((c2 ? iVar.getAlphabeticModifiers() : iVar.getNumericModifiers()) & 69647)) && alphabeticShortcut != 0 && ((alphabeticShortcut == keyData.meta[0] || alphabeticShortcut == keyData.meta[2] || (c2 && alphabeticShortcut == 8 && i2 == 67)) && iVar.isEnabled())) {
                    list.add(iVar);
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public i a(int i2, KeyEvent keyEvent) {
        char c2;
        ArrayList<i> arrayList = this.w;
        arrayList.clear();
        a((List<i>) arrayList, i2, keyEvent);
        if (arrayList.isEmpty()) {
            return null;
        }
        int metaState = keyEvent.getMetaState();
        KeyCharacterMap.KeyData keyData = new KeyCharacterMap.KeyData();
        keyEvent.getKeyData(keyData);
        int size = arrayList.size();
        if (size == 1) {
            return arrayList.get(0);
        }
        boolean c3 = c();
        for (int i3 = 0; i3 < size; i3++) {
            i iVar = arrayList.get(i3);
            if (c3) {
                c2 = iVar.getAlphabeticShortcut();
            } else {
                c2 = iVar.getNumericShortcut();
            }
            if ((c2 == keyData.meta[0] && (metaState & 2) == 0) || ((c2 == keyData.meta[2] && (metaState & 2) != 0) || (c3 && c2 == 8 && i2 == 67))) {
                return iVar;
            }
        }
        return null;
    }

    public boolean performIdentifierAction(int i2, int i3) {
        return a(findItem(i2), i3);
    }

    public boolean a(MenuItem menuItem, int i2) {
        return a(menuItem, (m) null, i2);
    }

    public boolean a(MenuItem menuItem, m mVar, int i2) {
        i iVar = (i) menuItem;
        if (iVar == null || !iVar.isEnabled()) {
            return false;
        }
        boolean b2 = iVar.b();
        androidx.core.g.b a2 = iVar.a();
        boolean z2 = a2 != null && a2.c();
        if (iVar.n()) {
            b2 |= iVar.expandActionView();
            if (b2) {
                a(true);
            }
        } else if (iVar.hasSubMenu() || z2) {
            if ((i2 & 4) == 0) {
                a(false);
            }
            if (!iVar.hasSubMenu()) {
                iVar.a(new r(f(), this, iVar));
            }
            r rVar = (r) iVar.getSubMenu();
            if (z2) {
                a2.a((SubMenu) rVar);
            }
            b2 |= a(rVar, mVar);
            if (!b2) {
                a(true);
            }
        } else if ((i2 & 1) == 0) {
            a(true);
        }
        return b2;
    }

    public final void a(boolean z2) {
        if (!this.v) {
            this.v = true;
            Iterator<WeakReference<m>> it = this.x.iterator();
            while (it.hasNext()) {
                WeakReference next = it.next();
                m mVar = (m) next.get();
                if (mVar == null) {
                    this.x.remove(next);
                } else {
                    mVar.a(this, z2);
                }
            }
            this.v = false;
        }
    }

    public void close() {
        a(true);
    }

    public void b(boolean z2) {
        if (!this.r) {
            if (z2) {
                this.l = true;
                this.o = true;
            }
            d(z2);
            return;
        }
        this.s = true;
        if (z2) {
            this.t = true;
        }
    }

    public void h() {
        if (!this.r) {
            this.r = true;
            this.s = false;
            this.t = false;
        }
    }

    public void i() {
        this.r = false;
        if (this.s) {
            this.s = false;
            b(this.t);
        }
    }

    /* access modifiers changed from: package-private */
    public void a(i iVar) {
        this.l = true;
        b(true);
    }

    /* access modifiers changed from: package-private */
    public void b(i iVar) {
        this.o = true;
        b(true);
    }

    public ArrayList<i> j() {
        if (!this.l) {
            return this.k;
        }
        this.k.clear();
        int size = this.j.size();
        for (int i2 = 0; i2 < size; i2++) {
            i iVar = this.j.get(i2);
            if (iVar.isVisible()) {
                this.k.add(iVar);
            }
        }
        this.l = false;
        this.o = true;
        return this.k;
    }

    public void k() {
        ArrayList<i> j2 = j();
        if (this.o) {
            Iterator<WeakReference<m>> it = this.x.iterator();
            boolean z2 = false;
            while (it.hasNext()) {
                WeakReference next = it.next();
                m mVar = (m) next.get();
                if (mVar == null) {
                    this.x.remove(next);
                } else {
                    z2 |= mVar.b();
                }
            }
            if (z2) {
                this.m.clear();
                this.n.clear();
                int size = j2.size();
                for (int i2 = 0; i2 < size; i2++) {
                    i iVar = j2.get(i2);
                    if (iVar.j()) {
                        this.m.add(iVar);
                    } else {
                        this.n.add(iVar);
                    }
                }
            } else {
                this.m.clear();
                this.n.clear();
                this.n.addAll(j());
            }
            this.o = false;
        }
    }

    public ArrayList<i> l() {
        k();
        return this.m;
    }

    public ArrayList<i> m() {
        k();
        return this.n;
    }

    public void clearHeader() {
        this.f852b = null;
        this.f851a = null;
        this.f853c = null;
        b(false);
    }

    private void a(int i2, CharSequence charSequence, int i3, Drawable drawable, View view) {
        Resources e2 = e();
        if (view != null) {
            this.f853c = view;
            this.f851a = null;
            this.f852b = null;
        } else {
            if (i2 > 0) {
                this.f851a = e2.getText(i2);
            } else if (charSequence != null) {
                this.f851a = charSequence;
            }
            if (i3 > 0) {
                this.f852b = androidx.core.content.b.a(f(), i3);
            } else if (drawable != null) {
                this.f852b = drawable;
            }
            this.f853c = null;
        }
        b(false);
    }

    /* access modifiers changed from: protected */
    public g a(CharSequence charSequence) {
        a(0, charSequence, 0, (Drawable) null, (View) null);
        return this;
    }

    /* access modifiers changed from: protected */
    public g d(int i2) {
        a(i2, (CharSequence) null, 0, (Drawable) null, (View) null);
        return this;
    }

    /* access modifiers changed from: protected */
    public g a(Drawable drawable) {
        a(0, (CharSequence) null, 0, drawable, (View) null);
        return this;
    }

    /* access modifiers changed from: protected */
    public g e(int i2) {
        a(0, (CharSequence) null, i2, (Drawable) null, (View) null);
        return this;
    }

    /* access modifiers changed from: protected */
    public g a(View view) {
        a(0, (CharSequence) null, 0, (Drawable) null, view);
        return this;
    }

    public CharSequence n() {
        return this.f851a;
    }

    public Drawable o() {
        return this.f852b;
    }

    public View p() {
        return this.f853c;
    }

    /* access modifiers changed from: package-private */
    public boolean r() {
        return this.u;
    }

    public boolean c(i iVar) {
        boolean z2 = false;
        if (this.x.isEmpty()) {
            return false;
        }
        h();
        Iterator<WeakReference<m>> it = this.x.iterator();
        while (it.hasNext()) {
            WeakReference next = it.next();
            m mVar = (m) next.get();
            if (mVar == null) {
                this.x.remove(next);
            } else {
                z2 = mVar.a(this, iVar);
                if (z2) {
                    break;
                }
            }
        }
        i();
        if (z2) {
            this.y = iVar;
        }
        return z2;
    }

    public boolean d(i iVar) {
        boolean z2 = false;
        if (!this.x.isEmpty() && this.y == iVar) {
            h();
            Iterator<WeakReference<m>> it = this.x.iterator();
            while (it.hasNext()) {
                WeakReference next = it.next();
                m mVar = (m) next.get();
                if (mVar == null) {
                    this.x.remove(next);
                } else {
                    z2 = mVar.b(this, iVar);
                    if (z2) {
                        break;
                    }
                }
            }
            i();
            if (z2) {
                this.y = null;
            }
        }
        return z2;
    }

    public i s() {
        return this.y;
    }

    public void c(boolean z2) {
        this.A = z2;
    }
}
