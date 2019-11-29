package com.shopee.app.ui.a;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

public abstract class w extends RecyclerView.a<RecyclerView.w> implements l {

    /* renamed from: a  reason: collision with root package name */
    protected a f19224a;

    /* renamed from: b  reason: collision with root package name */
    protected a f19225b;

    public interface a {
        View a();
    }

    public void a(a aVar) {
        this.f19224a = aVar;
    }

    public boolean a() {
        int i = c() ? 1 : 0;
        if (b()) {
            i++;
        }
        if (getItemCount() - i == 0) {
            return true;
        }
        return false;
    }

    public void b(a aVar) {
        this.f19225b = aVar;
    }

    /* access modifiers changed from: protected */
    public boolean b() {
        return this.f19224a != null;
    }

    /* access modifiers changed from: protected */
    public boolean c() {
        return this.f19225b != null;
    }
}
