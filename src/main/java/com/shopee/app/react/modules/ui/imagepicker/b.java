package com.shopee.app.react.modules.ui.imagepicker;

import android.app.Activity;
import android.content.Context;
import com.shopee.react.sdk.bridge.modules.base.c;
import com.shopee.react.sdk.bridge.protocol.DataResponse;
import com.shopee.react.sdk.bridge.protocol.GetRecentImageRequest;
import com.shopee.react.sdk.bridge.protocol.GetRecentImageResponse;
import org.a.a.a;

public final class b extends a {

    /* renamed from: a  reason: collision with root package name */
    private Context f18858a;

    private void a() {
    }

    private b(Context context) {
        super(context);
        this.f18858a = context;
        a();
    }

    public static b a(Context context) {
        return new b(context);
    }

    public void a(Activity activity, GetRecentImageRequest getRecentImageRequest, c<DataResponse<GetRecentImageResponse>> cVar) {
        final Activity activity2 = activity;
        final GetRecentImageRequest getRecentImageRequest2 = getRecentImageRequest;
        final c<DataResponse<GetRecentImageResponse>> cVar2 = cVar;
        a.a((a.C0532a) new a.C0532a("", 0, "") {
            public void execute() {
                try {
                    b.super.a(activity2, getRecentImageRequest2, (c<DataResponse<GetRecentImageResponse>>) cVar2);
                } catch (Throwable th) {
                    Thread.getDefaultUncaughtExceptionHandler().uncaughtException(Thread.currentThread(), th);
                }
            }
        });
    }
}
