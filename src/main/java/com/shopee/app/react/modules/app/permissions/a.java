package com.shopee.app.react.modules.app.permissions;

import android.app.Activity;
import com.shopee.app.react.util.e;
import com.shopee.react.sdk.bridge.modules.base.c;
import com.shopee.react.sdk.bridge.protocol.DataResponse;
import com.shopee.react.sdk.bridge.protocol.ReactPermissionResponse;
import com.shopee.web.sdk.bridge.a.f.b;
import com.shopee.web.sdk.bridge.protocol.permissions.CheckPermissionRequest;
import com.shopee.web.sdk.bridge.protocol.permissions.RequestPermissionRequest;
import d.m;
import java.util.Collections;
import java.util.List;

public final class a implements com.shopee.react.sdk.bridge.modules.app.permissions.a {
    public void a(Activity activity, int i, CheckPermissionRequest checkPermissionRequest, c<DataResponse<ReactPermissionResponse>> cVar) {
        if (e.a(i, activity)) {
            if (activity != null) {
                ((com.shopee.web.sdk.bridge.a.f.a) activity).a(checkPermissionRequest != null ? checkPermissionRequest.getPermissionList() : null, new C0282a(cVar));
                return;
            }
            throw new m("null cannot be cast to non-null type com.shopee.web.sdk.bridge.module.permissions.PermissionAwareActivity");
        }
    }

    /* renamed from: com.shopee.app.react.modules.app.permissions.a$a  reason: collision with other inner class name */
    public static final class C0282a implements b.C0475b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f18775a;

        C0282a(c cVar) {
            this.f18775a = cVar;
        }

        public void onResult(List<Boolean> list) {
            if (list == null) {
                c cVar = this.f18775a;
                if (cVar != null) {
                    cVar.a(DataResponse.error(1, new ReactPermissionResponse(Collections.emptyList())));
                    return;
                }
                return;
            }
            c cVar2 = this.f18775a;
            if (cVar2 != null) {
                cVar2.a(DataResponse.success(new ReactPermissionResponse(list)));
            }
        }
    }

    public void a(Activity activity, int i, RequestPermissionRequest requestPermissionRequest, c<DataResponse<ReactPermissionResponse>> cVar) {
        if (e.a(i, activity)) {
            if (activity != null) {
                com.shopee.web.sdk.bridge.a.f.a aVar = (com.shopee.web.sdk.bridge.a.f.a) activity;
                String str = null;
                List<String> permissionList = requestPermissionRequest != null ? requestPermissionRequest.getPermissionList() : null;
                if (requestPermissionRequest != null) {
                    str = requestPermissionRequest.getPopupText();
                }
                aVar.a(permissionList, str, new b(cVar));
                return;
            }
            throw new m("null cannot be cast to non-null type com.shopee.web.sdk.bridge.module.permissions.PermissionAwareActivity");
        }
    }

    public static final class b implements b.C0475b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f18776a;

        b(c cVar) {
            this.f18776a = cVar;
        }

        public void onResult(List<Boolean> list) {
            if (list == null) {
                c cVar = this.f18776a;
                if (cVar != null) {
                    cVar.a(DataResponse.error(1, new ReactPermissionResponse(Collections.emptyList())));
                    return;
                }
                return;
            }
            c cVar2 = this.f18776a;
            if (cVar2 != null) {
                cVar2.a(DataResponse.success(new ReactPermissionResponse(list)));
            }
        }
    }
}
