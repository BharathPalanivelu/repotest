package com.shopee.app.ui.common;

import com.garena.android.appkit.b.a;
import com.garena.android.appkit.b.b;
import com.garena.android.appkit.b.e;
import com.garena.android.appkit.b.g;
import com.garena.android.appkit.b.i;
import com.shopee.app.upload.ProgressState;
import com.shopee.app.upload.VideoState;

public final class z implements i {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final y f21367a;

    /* renamed from: b  reason: collision with root package name */
    private final g f21368b = new g() {
        public void onEvent(a aVar) {
            z.this.f21367a.a((ProgressState) aVar.data);
        }
    };

    /* renamed from: c  reason: collision with root package name */
    private final g f21369c = new g() {
        public void onEvent(a aVar) {
            z.this.f21367a.b((ProgressState) aVar.data);
        }
    };

    /* renamed from: d  reason: collision with root package name */
    private final g f21370d = new g() {
        public void onEvent(a aVar) {
            z.this.f21367a.c((ProgressState) aVar.data);
        }
    };

    /* renamed from: e  reason: collision with root package name */
    private final g f21371e = new g() {
        public void onEvent(a aVar) {
            z.this.f21367a.d((ProgressState) aVar.data);
        }
    };

    /* renamed from: f  reason: collision with root package name */
    private final g f21372f = new g() {
        public void onEvent(a aVar) {
            z.this.f21367a.e((ProgressState) aVar.data);
        }
    };

    /* renamed from: g  reason: collision with root package name */
    private final g f21373g = new g() {
        public void onEvent(a aVar) {
            z.this.f21367a.a((VideoState) aVar.data);
        }
    };

    public void c() {
    }

    public void d() {
    }

    public z(y yVar) {
        this.f21367a = yVar;
    }

    public void a() {
        b.a("ITEM_UPLOAD_START", (e) this.f21368b, b.a.NETWORK_BUS);
        b.a("ITEM_UPLOAD_PROGRESS", (e) this.f21369c, b.a.NETWORK_BUS);
        b.a("ITEM_UPLOAD_FAILED", (e) this.f21370d, b.a.NETWORK_BUS);
        b.a("ITEM_UPLOAD_SUCCESS", (e) this.f21371e, b.a.NETWORK_BUS);
        b.a("ITEM_UPLOAD_END", (e) this.f21372f, b.a.NETWORK_BUS);
        b.a("VIDEO_UPLOAD_PROGRESS", (e) this.f21373g, b.a.NETWORK_BUS);
    }

    public void b() {
        b.b("ITEM_UPLOAD_START", this.f21368b, b.a.NETWORK_BUS);
        b.b("ITEM_UPLOAD_PROGRESS", this.f21369c, b.a.NETWORK_BUS);
        b.b("ITEM_UPLOAD_FAILED", this.f21370d, b.a.NETWORK_BUS);
        b.b("ITEM_UPLOAD_SUCCESS", this.f21371e, b.a.NETWORK_BUS);
        b.b("ITEM_UPLOAD_END", this.f21372f, b.a.NETWORK_BUS);
        b.b("VIDEO_UPLOAD_PROGRESS", this.f21373g, b.a.NETWORK_BUS);
    }
}
