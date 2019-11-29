package com.shopee.feeds.feedlibrary.rn;

import com.google.a.i;
import com.google.a.l;
import com.google.a.o;
import com.shopee.feeds.feedlibrary.util.h;
import com.shopee.react.sdk.bridge.modules.app.post.a;
import com.shopee.react.sdk.bridge.modules.base.c;
import com.shopee.react.sdk.bridge.protocol.DataResponse;
import com.shopee.react.sdk.bridge.protocol.feed.FeedPostStatusQueryData;
import com.shopee.react.sdk.bridge.protocol.feed.PostStatusRequest;
import java.util.ArrayList;

public class b implements a {

    /* renamed from: a  reason: collision with root package name */
    private static final String f28246a = "b";

    public void a(PostStatusRequest postStatusRequest, c<DataResponse> cVar) {
        String str = f28246a;
        h.b(str, "retryPost " + postStatusRequest);
        if (postStatusRequest == null) {
            cVar.a(DataResponse.error(-1, "empty param"));
            return;
        }
        com.shopee.feeds.feedlibrary.bg.a.a().b(postStatusRequest.getPostId());
    }

    public void b(PostStatusRequest postStatusRequest, c<DataResponse> cVar) {
        DataResponse dataResponse;
        String str = f28246a;
        h.b(str, "deletePost " + postStatusRequest);
        if (postStatusRequest == null) {
            cVar.a(DataResponse.error(-1, "empty parama"));
            return;
        }
        if (com.shopee.feeds.feedlibrary.bg.a.a().a(postStatusRequest.getPostId(), false)) {
            dataResponse = DataResponse.error(0, "ok");
        } else {
            dataResponse = DataResponse.error(-1, "error");
        }
        cVar.a(dataResponse);
    }

    public void a(c<DataResponse> cVar) {
        DataResponse dataResponse;
        h.b(f28246a, "getPostList enter");
        FeedPostStatusQueryData c2 = com.shopee.feeds.feedlibrary.bg.a.a().c();
        if (c2 != null) {
            dataResponse = DataResponse.success(c2);
            String str = f28246a;
            h.b(str, "getPostList result " + c2.toString());
        } else {
            dataResponse = null;
        }
        if (dataResponse == null) {
            o oVar = new o();
            oVar.a("post_list", (l) new i());
            String str2 = f28246a;
            h.b(str2, "empty postlist " + oVar.toString());
            FeedPostStatusQueryData feedPostStatusQueryData = new FeedPostStatusQueryData();
            feedPostStatusQueryData.setPost_list(new ArrayList());
            dataResponse = DataResponse.error(-1, feedPostStatusQueryData);
        }
        cVar.a(dataResponse);
    }

    public void c(PostStatusRequest postStatusRequest, c<DataResponse> cVar) {
        DataResponse dataResponse;
        String str = f28246a;
        h.b(str, "postCompleted " + postStatusRequest);
        if (postStatusRequest == null) {
            cVar.a(DataResponse.error(-1, "empty param"));
            return;
        }
        if (com.shopee.feeds.feedlibrary.bg.a.a().c(postStatusRequest.getPostId())) {
            dataResponse = DataResponse.success();
        } else {
            dataResponse = DataResponse.error(-1, "error");
        }
        cVar.a(dataResponse);
    }
}
