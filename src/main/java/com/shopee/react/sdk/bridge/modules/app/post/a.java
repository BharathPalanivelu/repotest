package com.shopee.react.sdk.bridge.modules.app.post;

import com.shopee.react.sdk.bridge.modules.base.c;
import com.shopee.react.sdk.bridge.protocol.DataResponse;
import com.shopee.react.sdk.bridge.protocol.feed.PostStatusRequest;

public interface a {
    void a(c<DataResponse> cVar);

    void a(PostStatusRequest postStatusRequest, c<DataResponse> cVar);

    void b(PostStatusRequest postStatusRequest, c<DataResponse> cVar);

    void c(PostStatusRequest postStatusRequest, c<DataResponse> cVar);
}
