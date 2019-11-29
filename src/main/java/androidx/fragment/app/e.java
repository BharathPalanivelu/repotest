package androidx.fragment.app;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.lifecycle.t;

public class e {

    /* renamed from: a  reason: collision with root package name */
    private final g<?> f2167a;

    public static e a(g<?> gVar) {
        return new e((g) androidx.core.util.e.a(gVar, (Object) "callbacks == null"));
    }

    private e(g<?> gVar) {
        this.f2167a = gVar;
    }

    public h a() {
        return this.f2167a.f2170b;
    }

    public Fragment a(String str) {
        return this.f2167a.f2170b.b(str);
    }

    public void a(Fragment fragment) {
        i iVar = this.f2167a.f2170b;
        g<?> gVar = this.f2167a;
        iVar.a((g) gVar, (d) gVar, fragment);
    }

    public View a(View view, String str, Context context, AttributeSet attributeSet) {
        return this.f2167a.f2170b.onCreateView(view, str, context, attributeSet);
    }

    public void b() {
        this.f2167a.f2170b.p();
    }

    public Parcelable c() {
        return this.f2167a.f2170b.o();
    }

    public void a(Parcelable parcelable) {
        g<?> gVar = this.f2167a;
        if (gVar instanceof t) {
            gVar.f2170b.a(parcelable);
            return;
        }
        throw new IllegalStateException("Your FragmentHostCallback must implement ViewModelStoreOwner to call restoreSaveState(). Call restoreAllState()  if you're still using retainNestedNonConfig().");
    }

    public void d() {
        this.f2167a.f2170b.q();
    }

    public void e() {
        this.f2167a.f2170b.r();
    }

    public void f() {
        this.f2167a.f2170b.s();
    }

    public void g() {
        this.f2167a.f2170b.t();
    }

    public void h() {
        this.f2167a.f2170b.u();
    }

    public void i() {
        this.f2167a.f2170b.v();
    }

    public void j() {
        this.f2167a.f2170b.x();
    }

    public void a(boolean z) {
        this.f2167a.f2170b.a(z);
    }

    public void b(boolean z) {
        this.f2167a.f2170b.b(z);
    }

    public void a(Configuration configuration) {
        this.f2167a.f2170b.a(configuration);
    }

    public void k() {
        this.f2167a.f2170b.y();
    }

    public boolean a(Menu menu, MenuInflater menuInflater) {
        return this.f2167a.f2170b.a(menu, menuInflater);
    }

    public boolean a(Menu menu) {
        return this.f2167a.f2170b.a(menu);
    }

    public boolean a(MenuItem menuItem) {
        return this.f2167a.f2170b.a(menuItem);
    }

    public boolean b(MenuItem menuItem) {
        return this.f2167a.f2170b.b(menuItem);
    }

    public void b(Menu menu) {
        this.f2167a.f2170b.b(menu);
    }

    public boolean l() {
        return this.f2167a.f2170b.l();
    }
}
