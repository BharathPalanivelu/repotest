package com.shopee.react.sdk.bridge.modules.app.lrucache;

import com.shopee.react.sdk.bridge.modules.base.c;
import com.shopee.react.sdk.bridge.protocol.CacheResponse;

public interface a {
    void a(c<CacheResponse> cVar);

    void a(String str, c<CacheResponse> cVar);

    void a(String str, String str2, c<CacheResponse> cVar);
}
