package com.garena.rnrecyclerview.library.d;

import com.facebook.react.bridge.ReadableMap;
import com.garena.rnrecyclerview.library.recycler.ReactRecyclerView;

public class a {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public ReadableMap f8557a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public ReactRecyclerView f8558b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f8559c = true;

    /* renamed from: d  reason: collision with root package name */
    private C0148a f8560d = new C0148a();

    public a(ReactRecyclerView reactRecyclerView) {
        this.f8558b = reactRecyclerView;
    }

    public void a(ReadableMap readableMap) {
        this.f8557a = readableMap;
    }

    public void a() {
        if (this.f8559c) {
            this.f8560d.run();
            this.f8559c = false;
        } else if (!this.f8560d.f8562b) {
            boolean unused = this.f8560d.f8562b = true;
            this.f8558b.postDelayed(this.f8560d, 200);
        }
    }

    /* renamed from: com.garena.rnrecyclerview.library.d.a$a  reason: collision with other inner class name */
    private class C0148a implements Runnable {
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public boolean f8562b;

        private C0148a() {
        }

        public void run() {
            if (!a.this.f8558b.B()) {
                a.this.f8558b.setDataSource(a.this.f8558b.getDataSourceMapper().a(a.this.f8557a));
                this.f8562b = false;
            }
        }
    }
}
