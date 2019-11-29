package com.shopee.react.sdk.bridge.modules.app.bundle;

import com.shopee.react.sdk.bridge.modules.base.c;
import com.shopee.react.sdk.bridge.protocol.BundleReloadData;
import com.shopee.react.sdk.bridge.protocol.SimpleResponse;

public interface a {
    void a(c<SimpleResponse> cVar);

    void a(BundleReloadData bundleReloadData, c<SimpleResponse> cVar);
}
