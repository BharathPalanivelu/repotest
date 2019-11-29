package com.shopee.feeds.feedlibrary.bg;

import a.k;
import android.content.Intent;
import android.text.TextUtils;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import com.facebook.share.internal.ShareConstants;
import com.shopee.feeds.feedlibrary.b;
import com.shopee.feeds.feedlibrary.data.c.f;
import com.shopee.feeds.feedlibrary.data.entity.BaseEditEntity;
import com.shopee.feeds.feedlibrary.util.h;
import com.shopee.react.sdk.bridge.protocol.feed.FeedPostStatusQueryData;
import com.shopee.react.sdk.bridge.protocol.feed.FeedsPostData;
import com.shopee.react.sdk.bridge.protocol.feed.PostStatusNotifyData;
import java.util.ArrayList;
import java.util.concurrent.Callable;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private static final String f27606a = "a";

    /* renamed from: c  reason: collision with root package name */
    private static a f27607c;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public f f27608b = new f();

    public static a a() {
        if (f27607c == null) {
            f27607c = new a();
        }
        return f27607c;
    }

    private a() {
    }

    public void b() {
        this.f27608b.a();
    }

    public FeedPostStatusQueryData c() {
        h.b(f27606a, "queryLeftPost ");
        return this.f27608b.b();
    }

    public boolean d() {
        ArrayList<BaseEditEntity> c2 = this.f27608b.c();
        return c2 == null || c2.size() < 3;
    }

    public BaseEditEntity a(String str) {
        String d2 = this.f27608b.d(str);
        if (!TextUtils.isEmpty(d2)) {
            return this.f27608b.e(d2);
        }
        return null;
    }

    public void a(final BaseEditEntity baseEditEntity) {
        k.a(new Callable<Object>() {
            public Object call() throws Exception {
                a.this.f27608b.a(baseEditEntity.getPostId(), baseEditEntity);
                return null;
            }
        });
    }

    public boolean a(String str, boolean z) {
        String str2 = f27606a;
        h.b(str2, "deletePostFile " + str);
        return this.f27608b.a(str, z);
    }

    public void b(String str) {
        String str2 = f27606a;
        h.b(str2, "retryPost " + str);
        Intent intent = new Intent(b.b().c(), BackgroundService.class);
        intent.putExtra("module_key", "post_status");
        intent.putExtra("method_key", "status_method_retry");
        intent.putExtra(ShareConstants.WEB_DIALOG_RESULT_PARAM_POST_ID, str);
        b.b().c().startService(intent);
    }

    public boolean c(String str) {
        String str2 = f27606a;
        h.b(str2, "sharePostFinish " + str);
        return this.f27608b.a(str, false);
    }

    public void a(String str, BaseEditEntity baseEditEntity) {
        e(a(baseEditEntity, 0));
    }

    public void b(String str, BaseEditEntity baseEditEntity) {
        e(a(baseEditEntity, 1));
    }

    private String a(BaseEditEntity baseEditEntity, int i) {
        FeedsPostData a2 = com.shopee.feeds.feedlibrary.bg.b.a.a(baseEditEntity);
        a2.setStatus(i);
        PostStatusNotifyData postStatusNotifyData = new PostStatusNotifyData();
        postStatusNotifyData.setPayload(a2);
        postStatusNotifyData.setMsgType(i);
        postStatusNotifyData.setErrorMsg("");
        return new com.google.a.f().b((Object) postStatusNotifyData);
    }

    public void c(String str, BaseEditEntity baseEditEntity) {
        e(a(baseEditEntity, 2));
    }

    public void a(BaseEditEntity baseEditEntity, boolean z) {
        String b2 = new com.google.a.f().b((Object) baseEditEntity);
        h.b("", "storeAllData " + b2);
        this.f27608b.a(baseEditEntity.getPostId(), b2);
    }

    public void d(String str) {
        b(str);
    }

    public void e(String str) {
        try {
            String str2 = f27606a;
            h.b(str2, "outNotifyData " + str);
            ((DeviceEventManagerModule.RCTDeviceEventEmitter) com.shopee.sdk.b.a().i().a().getCurrentReactContext().getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit("SSZFPostingStatus", str);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
