package com.dieam.reactnativepushnotification.a;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import com.facebook.common.logging.FLog;
import com.facebook.internal.NativeProtocol;
import me.leolin.shortcutbadger.c;
import me.leolin.shortcutbadger.impl.b;

public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final a f6632a = new a();

    /* renamed from: b  reason: collision with root package name */
    private static final me.leolin.shortcutbadger.a f6633b = new b();

    /* renamed from: c  reason: collision with root package name */
    private Boolean f6634c;

    /* renamed from: d  reason: collision with root package name */
    private Boolean f6635d;

    /* renamed from: e  reason: collision with root package name */
    private ComponentName f6636e;

    private a() {
    }

    public void a(Context context, int i) {
        if (this.f6636e == null) {
            this.f6636e = context.getPackageManager().getLaunchIntentForPackage(context.getPackageName()).getComponent();
        }
        b(context, i);
        c(context, i);
    }

    private void b(Context context, int i) {
        Boolean bool = this.f6634c;
        if (bool == null) {
            this.f6634c = Boolean.valueOf(c.a(context, i));
            if (this.f6634c.booleanValue()) {
                FLog.i("ApplicationBadgeHelper", "First attempt to use automatic badger succeeded; permanently enabling method.");
            } else {
                FLog.i("ApplicationBadgeHelper", "First attempt to use automatic badger failed; permanently disabling method.");
            }
        } else if (bool.booleanValue()) {
            c.a(context, i);
        }
    }

    private void c(Context context, int i) {
        Boolean bool = this.f6635d;
        if (bool == null) {
            this.f6635d = Boolean.valueOf(a(context) && d(context, i));
            if (this.f6635d.booleanValue()) {
                FLog.i("ApplicationBadgeHelper", "First attempt to use legacy Samsung badger succeeded; permanently enabling method.");
            } else {
                FLog.w("ApplicationBadgeHelper", "First attempt to use legacy Samsung badger failed; permanently disabling method.");
            }
        } else if (bool.booleanValue()) {
            d(context, i);
        }
    }

    private boolean a(Context context) {
        Intent intent = new Intent("android.intent.action.MAIN");
        intent.addCategory("android.intent.category.HOME");
        ResolveInfo resolveActivity = context.getPackageManager().resolveActivity(intent, NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST);
        if (resolveActivity == null || resolveActivity.activityInfo.name.toLowerCase().contains("resolver")) {
            return false;
        }
        return f6633b.a().contains(resolveActivity.activityInfo.packageName);
    }

    private boolean d(Context context, int i) {
        try {
            f6633b.a(context, this.f6636e, i);
            return true;
        } catch (Exception e2) {
            FLog.w("ApplicationBadgeHelper", "Legacy Samsung badger failed", (Throwable) e2);
            return false;
        }
    }
}
