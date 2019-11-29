package com.shopee.react.sdk.bridge.modules.app.permissions;

import android.app.Activity;
import com.shopee.react.sdk.bridge.modules.base.c;
import com.shopee.react.sdk.bridge.protocol.DataResponse;
import com.shopee.react.sdk.bridge.protocol.ReactPermissionResponse;
import com.shopee.web.sdk.bridge.protocol.permissions.CheckPermissionRequest;
import com.shopee.web.sdk.bridge.protocol.permissions.RequestPermissionRequest;

public interface a {
    void a(Activity activity, int i, CheckPermissionRequest checkPermissionRequest, c<DataResponse<ReactPermissionResponse>> cVar);

    void a(Activity activity, int i, RequestPermissionRequest requestPermissionRequest, c<DataResponse<ReactPermissionResponse>> cVar);
}
