package com.shopee.app.web2.b.e;

import android.content.Context;
import com.shopee.app.data.store.al;
import com.shopee.app.util.x;
import com.shopee.web.sdk.bridge.a.f.b;
import com.shopee.web.sdk.bridge.internal.b;
import com.shopee.web.sdk.bridge.protocol.permissions.CheckPermissionRequest;
import com.shopee.web.sdk.bridge.protocol.permissions.PermissionResponse;
import d.d.b.j;
import d.m;
import java.util.List;

public final class a extends b<CheckPermissionRequest, PermissionResponse> implements b.C0475b {

    /* renamed from: a  reason: collision with root package name */
    public al f26649a;

    /* renamed from: b  reason: collision with root package name */
    private final com.shopee.app.ui.c.a f26650b;

    public String a() {
        return "checkAppPermission";
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(Context context) {
        super(context, CheckPermissionRequest.class, PermissionResponse.class);
        j.b(context, "context");
        Object b2 = ((x) context).b();
        if (b2 != null) {
            ((com.shopee.app.web2.b.a) b2).a(this);
            al alVar = this.f26649a;
            if (alVar == null) {
                j.b("mLoginStore");
            }
            this.f26650b = new com.shopee.app.ui.c.a(alVar);
            return;
        }
        throw new m("null cannot be cast to non-null type com.shopee.app.web2.bridge.WebBridgeSdkInjector");
    }

    /* access modifiers changed from: protected */
    public void a(CheckPermissionRequest checkPermissionRequest) {
        if (checkPermissionRequest != null) {
            com.shopee.app.ui.c.a aVar = this.f26650b;
            Context f2 = f();
            j.a((Object) f2, "context");
            aVar.a(f2, checkPermissionRequest.getPermissionList(), (b.C0475b) this);
        }
    }

    public void onResult(List<Boolean> list) {
        if (list != null) {
            b(PermissionResponse.success(list));
        }
    }
}
