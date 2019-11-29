package com.garena.g.a;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.text.TextUtils;
import com.facebook.internal.NativeProtocol;
import com.garena.g.c;

public abstract class a {

    /* renamed from: a  reason: collision with root package name */
    protected String f8000a;

    public abstract void a(Context context, com.garena.g.a aVar);

    public boolean a() {
        return false;
    }

    public a(String str) {
        this.f8000a = str;
    }

    /* access modifiers changed from: protected */
    public void a(Context context, Intent intent) throws c {
        if (!TextUtils.isEmpty(this.f8000a)) {
            ActivityInfo a2 = a(context, intent, this.f8000a);
            if (a2 != null) {
                intent.setClassName(a2.packageName, a2.name);
            } else {
                throw new c("no app found to handle the intent");
            }
        }
        b(context, intent);
    }

    /* access modifiers changed from: protected */
    public void b(Context context, Intent intent) {
        context.startActivity(intent);
    }

    private ActivityInfo a(Context context, Intent intent, String str) {
        for (ResolveInfo next : context.getPackageManager().queryIntentActivities(intent, NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST)) {
            if (next.activityInfo.packageName.toLowerCase().contains(str)) {
                return next.activityInfo;
            }
        }
        return null;
    }
}
