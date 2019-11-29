package com.shopee.app.util;

import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import com.crashlytics.android.a;
import com.crashlytics.android.a.b;
import com.crashlytics.android.a.m;
import com.shopee.app.application.ar;
import com.shopee.app.appuser.UserInfo;
import io.a.a.a.c;

public class q {

    /* renamed from: a  reason: collision with root package name */
    private String f7053a;

    public static void a(Application application) {
        try {
            c.a((Context) application, new a());
            a.a("slow_cpu", c.d());
            a.a("low_dpi", c.e());
            a.a("low_ram", c.a(application));
            a.a("max_memory", c.b(application));
            a.a("abi", c.f());
            a.a("install_src", c.c(application));
            a.a("phone_info", c.g());
        } catch (Exception unused) {
        }
    }

    public static void a(UserInfo userInfo) {
        try {
            a.b(String.valueOf(userInfo.getUserId()));
            a.c(String.valueOf(userInfo.getUsername()));
            a.d(String.valueOf(userInfo.getEmail()));
        } catch (Exception unused) {
        }
    }

    private void a(Application application, UserInfo userInfo) {
        a(application);
        a(userInfo);
    }

    public void a(Throwable th, String str) {
        try {
            if (c.j()) {
                a.a(str);
                a.a(th);
                return;
            }
            a((Application) ar.f(), ar.f().e().loggedInUser());
        } catch (Exception unused) {
        }
    }

    public void a(String str, String str2) {
        try {
            if (c.j()) {
                a.a(str, str2);
            } else {
                a((Application) ar.f(), ar.f().e().loggedInUser());
            }
        } catch (Exception unused) {
        }
    }

    public void a(m mVar) {
        try {
            if (c.j()) {
                b.c().a(mVar);
            }
        } catch (Exception unused) {
            a((Application) ar.f(), ar.f().e().loggedInUser());
        }
    }

    public void a(String str) {
        try {
            if (c.j()) {
                a.a("current_activity", str);
                if (!TextUtils.equals(str, this.f7053a)) {
                    a.a("previous_activity", this.f7053a);
                    this.f7053a = str;
                    return;
                }
                return;
            }
            a((Application) ar.f(), ar.f().e().loggedInUser());
        } catch (Exception unused) {
        }
    }
}
