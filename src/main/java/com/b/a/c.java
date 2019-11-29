package com.b.a;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.b.a.a.b;

public class c<P extends b<C>, C> extends RecyclerView.w implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    P f4663a;

    /* renamed from: b  reason: collision with root package name */
    b f4664b;

    /* renamed from: c  reason: collision with root package name */
    private a f4665c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f4666d = false;

    interface a {
        void a(int i);

        void b(int i);
    }

    public void b(boolean z) {
    }

    public boolean d() {
        return true;
    }

    public c(View view) {
        super(view);
    }

    public P a() {
        return this.f4663a;
    }

    public void b() {
        this.itemView.setOnClickListener(this);
    }

    public boolean c() {
        return this.f4666d;
    }

    public void a(boolean z) {
        this.f4666d = z;
    }

    /* access modifiers changed from: package-private */
    public void a(a aVar) {
        this.f4665c = aVar;
    }

    public void onClick(View view) {
        if (this.f4666d) {
            f();
        } else {
            e();
        }
    }

    /* access modifiers changed from: protected */
    public void e() {
        a(true);
        b(false);
        a aVar = this.f4665c;
        if (aVar != null) {
            aVar.a(getAdapterPosition());
        }
    }

    /* access modifiers changed from: protected */
    public void f() {
        a(false);
        b(true);
        a aVar = this.f4665c;
        if (aVar != null) {
            aVar.b(getAdapterPosition());
        }
    }
}
