package com.shopee.feeds.feedlibrary.util.d;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import tencent.tls.platform.SigType;

public class b {

    /* renamed from: a  reason: collision with root package name */
    private final String f28294a = "PermissionPageManager";

    /* renamed from: b  reason: collision with root package name */
    private Context f28295b;

    /* renamed from: c  reason: collision with root package name */
    private String f28296c = "com.donkor.demo";

    public b(Context context) {
        this.f28295b = context;
    }

    public static void a(Activity activity) {
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS", Uri.parse("package:" + activity.getPackageName()));
        intent.addFlags(SigType.TLS);
        activity.startActivity(intent);
    }
}
