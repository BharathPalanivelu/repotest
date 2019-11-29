package com.shopee.app.b.a;

import com.google.a.o;
import com.shopee.navigator.options.PushOption;
import java.util.HashMap;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private static HashMap<String, String> f15916a = new HashMap<>();

    static {
        f15916a.put("editProfile", "/n/EDIT_PROFILE_PAGE");
    }

    public static String a(String str) {
        String str2;
        if (str.contains("?")) {
            int indexOf = str.indexOf("?");
            String substring = str.substring(0, indexOf);
            str2 = str.substring(indexOf);
            str = substring;
        } else {
            str2 = "";
        }
        if (!f15916a.containsKey(str)) {
            return null;
        }
        return f15916a.get(str) + str2;
    }

    public static PushOption a(o oVar) {
        try {
            int i = 0;
            int g2 = oVar.b("__anim__") ? oVar.c("__anim__").g() : 0;
            if (oVar.b("__pc__")) {
                i = oVar.c("__pc__").g();
            }
            return PushOption.a(g2, i);
        } catch (Exception unused) {
            return PushOption.a();
        }
    }
}
