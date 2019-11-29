package com.shopee.app.web2.b.e;

import android.app.Activity;
import android.content.Context;
import com.facebook.internal.NativeProtocol;
import com.shopee.app.data.store.al;
import com.shopee.app.ui.c.a;
import com.shopee.app.util.x;
import com.shopee.web.sdk.bridge.a.f.b;
import com.shopee.web.sdk.bridge.internal.b;
import com.shopee.web.sdk.bridge.protocol.common.StatusResponse;
import com.shopee.web.sdk.bridge.protocol.permissions.RequestPermissionRequest;
import d.d.b.j;
import d.m;
import java.util.List;

public final class c extends b<RequestPermissionRequest, StatusResponse> implements b.C0475b {

    /* renamed from: a  reason: collision with root package name */
    public al f26651a;

    /* renamed from: b  reason: collision with root package name */
    private final a f26652b;

    public String a() {
        return "requestAppPermission";
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public c(Context context) {
        super(context, RequestPermissionRequest.class, StatusResponse.class);
        j.b(context, "context");
        Object b2 = ((x) context).b();
        if (b2 != null) {
            ((com.shopee.app.web2.b.a) b2).a(this);
            al alVar = this.f26651a;
            if (alVar == null) {
                j.b("mLoginStore");
            }
            this.f26652b = new a(alVar);
            return;
        }
        throw new m("null cannot be cast to non-null type com.shopee.app.web2.bridge.WebBridgeSdkInjector");
    }

    /* access modifiers changed from: protected */
    public void a(RequestPermissionRequest requestPermissionRequest) {
        if (!(f() instanceof Activity)) {
            b(new StatusResponse(0));
        } else if (requestPermissionRequest != null) {
            a aVar = this.f26652b;
            Context f2 = f();
            if (f2 != null) {
                List<String> permissionList = requestPermissionRequest.getPermissionList();
                String popupText = requestPermissionRequest.getPopupText();
                j.a((Object) popupText, "request.popupText");
                aVar.a((Activity) f2, permissionList, popupText, this);
                return;
            }
            throw new m("null cannot be cast to non-null type android.app.Activity");
        }
    }

    public void a(Activity activity, int i, String[] strArr, int[] iArr) {
        j.b(strArr, NativeProtocol.RESULT_ARGS_PERMISSIONS);
        j.b(iArr, "grantResults");
        if (activity != null) {
            this.f26652b.a(activity, i, iArr);
        }
    }

    public void onResult(List<Boolean> list) {
        b(new StatusResponse(1));
    }
}
