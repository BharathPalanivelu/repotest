package com.shopee.app.ui.common;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.beetalk.sdk.f.d;
import com.shopee.app.ui.a.l;
import com.shopee.app.ui.a.w;
import com.shopee.id.R;

public class ae extends RecyclerView.n {

    /* renamed from: a  reason: collision with root package name */
    private final RecyclerView f21124a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public a f21125b;

    /* renamed from: c  reason: collision with root package name */
    private View f21126c;

    /* renamed from: d  reason: collision with root package name */
    private View f21127d;

    /* renamed from: e  reason: collision with root package name */
    private int f21128e;

    /* renamed from: f  reason: collision with root package name */
    private RecyclerView.n f21129f;

    public interface a {
        void d(int i);
    }

    public ae(RecyclerView recyclerView, l lVar) {
        this.f21124a = recyclerView;
        a();
        lVar.b(new w.a() {
            public View a() {
                return ae.this.a();
            }
        });
        this.f21124a.a((RecyclerView.n) this);
        b();
    }

    public void a(int i) {
        View view = this.f21126c;
        if (view != null) {
            view.setBackgroundColor(i);
        }
    }

    public void a(a aVar) {
        this.f21125b = aVar;
    }

    public void a(RecyclerView.n nVar) {
        this.f21129f = nVar;
    }

    public View a() {
        this.f21126c = LayoutInflater.from(this.f21124a.getContext()).inflate(R.layout.chat_load_more_layout, this.f21124a, false);
        this.f21127d = this.f21126c.findViewById(R.id.loading);
        this.f21126c.setVisibility(8);
        return this.f21126c;
    }

    public void onScrollStateChanged(RecyclerView recyclerView, int i) {
        Context context = this.f21124a.getContext();
        com.squareup.a.w a2 = com.squareup.a.w.a(context);
        if (i == 0 || i == 1) {
            a2.b((Object) context);
        } else {
            a2.a((Object) context);
        }
        RecyclerView.n nVar = this.f21129f;
        if (nVar != null) {
            nVar.onScrollStateChanged(recyclerView, i);
        }
    }

    public void onScrolled(RecyclerView recyclerView, int i, int i2) {
        RecyclerView.i layoutManager = recyclerView.getLayoutManager();
        if (layoutManager instanceof LinearLayoutManager) {
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
            int o = linearLayoutManager.o();
            int q = linearLayoutManager.q();
            final int I = linearLayoutManager.I();
            if (!(I - q != 1 || o == 0 || this.f21128e == q)) {
                this.f21128e = q;
                this.f21126c.setVisibility(0);
                this.f21127d.setVisibility(0);
                d.a().a(new Runnable() {
                    public void run() {
                        if (ae.this.f21125b != null) {
                            ae.this.f21125b.d(I);
                        }
                    }
                }, 200);
            }
        }
        RecyclerView.n nVar = this.f21129f;
        if (nVar != null) {
            nVar.onScrolled(recyclerView, i, i2);
        }
    }

    public void b() {
        this.f21126c.setVisibility(8);
    }

    public void c() {
        this.f21127d.setVisibility(4);
    }

    public void d() {
        this.f21128e = 0;
        this.f21124a.getLayoutManager().e(0);
    }
}
