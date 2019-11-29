package androidx.appcompat.view;

import android.content.Context;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.view.b;
import androidx.appcompat.view.menu.g;
import androidx.appcompat.widget.ActionBarContextView;
import java.lang.ref.WeakReference;

public class e extends b implements g.a {

    /* renamed from: a  reason: collision with root package name */
    private Context f745a;

    /* renamed from: b  reason: collision with root package name */
    private ActionBarContextView f746b;

    /* renamed from: c  reason: collision with root package name */
    private b.a f747c;

    /* renamed from: d  reason: collision with root package name */
    private WeakReference<View> f748d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f749e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f750f;

    /* renamed from: g  reason: collision with root package name */
    private g f751g;

    public e(Context context, ActionBarContextView actionBarContextView, b.a aVar, boolean z) {
        this.f745a = context;
        this.f746b = actionBarContextView;
        this.f747c = aVar;
        this.f751g = new g(actionBarContextView.getContext()).a(1);
        this.f751g.a((g.a) this);
        this.f750f = z;
    }

    public void b(CharSequence charSequence) {
        this.f746b.setTitle(charSequence);
    }

    public void a(CharSequence charSequence) {
        this.f746b.setSubtitle(charSequence);
    }

    public void a(int i) {
        b((CharSequence) this.f745a.getString(i));
    }

    public void b(int i) {
        a((CharSequence) this.f745a.getString(i));
    }

    public void a(boolean z) {
        super.a(z);
        this.f746b.setTitleOptional(z);
    }

    public boolean h() {
        return this.f746b.d();
    }

    public void a(View view) {
        this.f746b.setCustomView(view);
        this.f748d = view != null ? new WeakReference<>(view) : null;
    }

    public void d() {
        this.f747c.b(this, this.f751g);
    }

    public void c() {
        if (!this.f749e) {
            this.f749e = true;
            this.f746b.sendAccessibilityEvent(32);
            this.f747c.a(this);
        }
    }

    public Menu b() {
        return this.f751g;
    }

    public CharSequence f() {
        return this.f746b.getTitle();
    }

    public CharSequence g() {
        return this.f746b.getSubtitle();
    }

    public View i() {
        WeakReference<View> weakReference = this.f748d;
        if (weakReference != null) {
            return (View) weakReference.get();
        }
        return null;
    }

    public MenuInflater a() {
        return new g(this.f746b.getContext());
    }

    public boolean a(g gVar, MenuItem menuItem) {
        return this.f747c.a((b) this, menuItem);
    }

    public void a(g gVar) {
        d();
        this.f746b.a();
    }
}
