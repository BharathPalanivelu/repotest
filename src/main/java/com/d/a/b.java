package com.d.a;

import androidx.recyclerview.widget.RecyclerView;
import com.d.a.a;

public class b implements f {

    /* renamed from: a  reason: collision with root package name */
    private final RecyclerView f6612a;

    /* renamed from: b  reason: collision with root package name */
    private final RecyclerView.a f6613b;

    /* renamed from: c  reason: collision with root package name */
    private final e f6614c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f6615d;

    private b(a aVar) {
        this.f6612a = aVar.f6617b;
        this.f6613b = aVar.f6616a;
        this.f6614c = new e();
        this.f6614c.b(aVar.f6619d);
        this.f6614c.a(aVar.f6620e);
        this.f6614c.a(aVar.f6618c);
        this.f6614c.c(aVar.f6621f);
        this.f6614c.e(aVar.h);
        this.f6614c.d(aVar.f6622g);
        this.f6615d = aVar.i;
    }

    public void a() {
        this.f6612a.setAdapter(this.f6614c);
        if (!this.f6612a.o() && this.f6615d) {
            this.f6612a.setLayoutFrozen(true);
        }
    }

    public void b() {
        this.f6612a.setAdapter(this.f6613b);
    }

    public static class a {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public RecyclerView.a f6616a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public final RecyclerView f6617b;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public boolean f6618c = true;
        /* access modifiers changed from: private */

        /* renamed from: d  reason: collision with root package name */
        public int f6619d = 10;
        /* access modifiers changed from: private */

        /* renamed from: e  reason: collision with root package name */
        public int f6620e = a.b.layout_default_item_skeleton;
        /* access modifiers changed from: private */

        /* renamed from: f  reason: collision with root package name */
        public int f6621f;
        /* access modifiers changed from: private */

        /* renamed from: g  reason: collision with root package name */
        public int f6622g = 1000;
        /* access modifiers changed from: private */
        public int h = 20;
        /* access modifiers changed from: private */
        public boolean i = true;

        public a(RecyclerView recyclerView) {
            this.f6617b = recyclerView;
            this.f6621f = androidx.core.content.b.c(recyclerView.getContext(), a.C0114a.shimmer_color);
        }

        public a a(RecyclerView.a aVar) {
            this.f6616a = aVar;
            return this;
        }

        public a a(int i2) {
            this.f6619d = i2;
            return this;
        }

        public a a(boolean z) {
            this.f6618c = z;
            return this;
        }

        public a b(int i2) {
            this.f6622g = i2;
            return this;
        }

        public a c(int i2) {
            this.f6621f = androidx.core.content.b.c(this.f6617b.getContext(), i2);
            return this;
        }

        public a d(int i2) {
            this.h = i2;
            return this;
        }

        public a e(int i2) {
            this.f6620e = i2;
            return this;
        }

        public a b(boolean z) {
            this.i = z;
            return this;
        }

        public b a() {
            b bVar = new b(this);
            bVar.a();
            return bVar;
        }
    }
}
