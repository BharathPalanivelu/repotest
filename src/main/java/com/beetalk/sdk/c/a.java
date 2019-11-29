package com.beetalk.sdk.c;

import android.content.Context;
import com.facebook.Session;
import java.util.ArrayList;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private static Context f5387a;

    /* renamed from: b  reason: collision with root package name */
    private static String f5388b;

    /* renamed from: c  reason: collision with root package name */
    private static b f5389c;

    /* renamed from: d  reason: collision with root package name */
    private static ArrayList<Runnable> f5390d = new ArrayList<>();

    public static void a(Context context) {
        f5387a = context;
        if (Session.getActiveSession() != null) {
            Session.getActiveSession().closeAndClearTokenInformation();
            Session.setActiveSession((Session) null);
        } else {
            a().a().closeAndClearTokenInformation();
            Session.setActiveSession((Session) null);
        }
        ArrayList<Runnable> arrayList = f5390d;
        if (arrayList != null) {
            arrayList.clear();
        }
        f5389c = null;
    }

    public static b a() {
        if (f5389c == null) {
            f5389c = new b(f5388b, f5387a);
        }
        return f5389c;
    }
}
