package com.shopee.app.util.h;

import com.facebook.share.internal.ShareConstants;
import com.google.a.o;
import com.shopee.app.web.WebRegister;
import java.util.ArrayList;
import java.util.List;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private static String f26361a;

    /* renamed from: b  reason: collision with root package name */
    private static final ArrayList<String> f26362b = new ArrayList<>();

    private static boolean c() {
        return false;
    }

    public static List<String> a() {
        return f26362b;
    }

    public static void a(String str) {
        f26361a = str;
    }

    public static void b(String str) {
        if (c()) {
            f26362b.add(a(str, "incoming"));
            b();
        }
    }

    public static void c(String str) {
        if (c()) {
            f26362b.add(a(str, "outgoing"));
            b();
        }
    }

    private static String a(String str, String str2) {
        try {
            o m = ((o) WebRegister.GSON.a(str, o.class)).m();
            m.a("tag", str2);
            m.a("url", f26361a);
            m.a("timestamp", (Number) Long.valueOf(com.garena.android.appkit.tools.a.a.b()));
            return m.toString();
        } catch (Exception unused) {
            return b("Error parsing: " + str, "error");
        }
    }

    private static String b(String str, String str2) {
        o oVar = new o();
        oVar.a(ShareConstants.WEB_DIALOG_PARAM_MESSAGE, str);
        oVar.a("tag", str2);
        oVar.a("url", f26361a);
        oVar.a("timestamp", (Number) Long.valueOf(com.garena.android.appkit.tools.a.a.b()));
        return oVar.toString();
    }

    private static void b() {
        if (f26362b.size() > 100) {
            f26362b.remove(0);
        }
    }
}
