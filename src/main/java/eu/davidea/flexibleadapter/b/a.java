package eu.davidea.flexibleadapter.b;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.w;
import eu.davidea.flexibleadapter.b;
import java.util.List;

public abstract class a<VH extends RecyclerView.w> implements f<VH> {

    /* renamed from: c  reason: collision with root package name */
    protected boolean f32844c = true;

    /* renamed from: d  reason: collision with root package name */
    protected boolean f32845d = false;

    /* renamed from: e  reason: collision with root package name */
    protected boolean f32846e = true;

    /* renamed from: f  reason: collision with root package name */
    protected boolean f32847f = false;

    /* renamed from: g  reason: collision with root package name */
    protected boolean f32848g = false;

    public int a() {
        return 0;
    }

    public boolean b() {
        return this.f32844c;
    }

    public boolean c() {
        return this.f32845d;
    }

    public void a(boolean z) {
        this.f32845d = z;
    }

    public boolean d() {
        return this.f32846e;
    }

    public void b(boolean z) {
        this.f32846e = z;
    }

    public boolean e() {
        return this.f32847f;
    }

    public boolean f() {
        return this.f32848g;
    }

    public VH b(b bVar, LayoutInflater layoutInflater, ViewGroup viewGroup) {
        throw new IllegalStateException("onCreateViewHolder() is not implemented. If you want FlexibleAdapter creates and binds ViewHolder for you, you must override and implement the method " + getClass().getSimpleName() + ".createViewHolder().");
    }

    public void a(b bVar, VH vh, int i, List list) {
        throw new IllegalStateException("onBindViewHolder() is not implemented. If you want FlexibleAdapter creates and binds ViewHolder for you, you must override and implement the method " + getClass().getSimpleName() + ".bindViewHolder().");
    }
}
