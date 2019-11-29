package com.shopee.app.util;

import android.text.TextUtils;
import com.facebook.internal.AnalyticsEvents;
import com.google.a.o;
import com.j256.ormlite.stmt.query.SimpleComparison;
import java.util.HashMap;

public class b {

    /* renamed from: a  reason: collision with root package name */
    ak f26224a;

    /* renamed from: b  reason: collision with root package name */
    private b.a<com.shopee.app.util.l.b> f26225b;

    /* renamed from: c  reason: collision with root package name */
    private final HashMap<String, a> f26226c = new HashMap<>();

    private interface a {
        void a(HashMap<String, String> hashMap);
    }

    public b(ak akVar, b.a<com.shopee.app.util.l.b> aVar) {
        this.f26224a = akVar;
        this.f26225b = aVar;
        a();
    }

    private void a() {
        this.f26226c.put("addressBookContacts", new C0399b());
        this.f26226c.put("privacySettings", new j());
        this.f26226c.put("facebookContacts", new f());
        this.f26226c.put("editProfile", new e());
        this.f26226c.put("order", new i());
        this.f26226c.put("feedComment", new g());
        this.f26226c.put("appSystemSetting", new c());
        this.f26226c.put("reactNative", new k());
        this.f26226c.put("BCAWidget", new d());
        this.f26226c.put("imageSearch", new h());
    }

    public void a(String str, o oVar) {
        if (!TextUtils.isEmpty(str)) {
            String oVar2 = oVar == null ? com.shopee.navigator.a.f30104c : oVar.toString();
            if (new com.shopee.navigator.c.a(str).e()) {
                this.f26225b.get().a(str, oVar2);
            } else {
                a(str);
            }
        }
    }

    @Deprecated
    public void a(String str) {
        if (!TextUtils.isEmpty(str)) {
            String[] split = str.split("\\?");
            String str2 = split[0];
            try {
                if (this.f26226c.containsKey(str2)) {
                    a(str2, str, split);
                } else {
                    b(str2, str, split);
                }
            } catch (Exception e2) {
                com.garena.android.appkit.d.a.a(e2);
                com.garena.b.a.a.a("ROUTING", "There was a problem with this route", e2);
            }
        }
    }

    private void a(String str, String str2, String[] strArr) throws Exception {
        a aVar = this.f26226c.get(str);
        HashMap<String, String> b2 = b(strArr.length >= 2 ? strArr[1] : "");
        b2.put("ORIGINAL_QUERY", str2);
        aVar.a(b2);
    }

    private void b(String str, String str2, String[] strArr) throws Exception {
        String str3;
        if (strArr.length > 1) {
            o c2 = bm.c(strArr[1]);
            if (c2 != null) {
                str3 = c2.toString();
                this.f26225b.get().a(str, str3);
            }
        }
        str3 = null;
        this.f26225b.get().a(str, str3);
    }

    private HashMap<String, String> b(String str) throws Exception {
        HashMap<String, String> hashMap = new HashMap<>();
        for (String split : str.split("&")) {
            String[] split2 = split.split(SimpleComparison.EQUAL_TO_OPERATION);
            if (split2.length == 2) {
                hashMap.put(bm.b(split2[0]), bm.b(split2[1]));
            }
        }
        return hashMap;
    }

    public class h implements a {
        public h() {
        }

        public void a(HashMap<String, String> hashMap) {
            b.this.f26224a.as();
        }
    }

    public class k implements a {
        public k() {
        }

        public void a(HashMap<String, String> hashMap) {
            String str = hashMap.get("ORIGINAL_QUERY");
            if (str != null) {
                String substring = str.substring(str.indexOf("reactNative") + 11);
                int i = 0;
                try {
                    i = Integer.parseInt(hashMap.get("navigationType"));
                } catch (Exception e2) {
                    com.garena.android.appkit.d.a.a(e2);
                }
                b.this.f26224a.a(hashMap.get("module"), i, substring, AnalyticsEvents.PARAMETER_SHARE_DIALOG_SHOW_WEB);
            }
        }
    }

    private class e implements a {
        private e() {
        }

        public void a(HashMap<String, String> hashMap) {
            b.this.f26224a.t();
        }
    }

    private class g implements a {
        private g() {
        }

        public void a(HashMap<String, String> hashMap) {
            String str = hashMap.get("feedID");
            String str2 = hashMap.get("shopID");
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                try {
                    b.this.f26224a.c(Long.parseLong(str), Integer.parseInt(str2));
                } catch (NumberFormatException e2) {
                    com.garena.android.appkit.d.a.a(e2);
                }
            }
        }
    }

    private class f implements a {
        private f() {
        }

        public void a(HashMap<String, String> hashMap) {
            b.this.f26224a.a(2, 0);
        }
    }

    /* renamed from: com.shopee.app.util.b$b  reason: collision with other inner class name */
    private class C0399b implements a {
        private C0399b() {
        }

        public void a(HashMap<String, String> hashMap) {
            b.this.f26224a.a(4, 0);
        }
    }

    private class c implements a {
        private c() {
        }

        public void a(HashMap<String, String> hashMap) {
            b.this.f26224a.ag();
        }
    }

    private class j implements a {
        private j() {
        }

        public void a(HashMap<String, String> hashMap) {
            b.this.f26224a.U();
        }
    }

    private class i implements a {
        private i() {
        }

        public void a(HashMap<String, String> hashMap) {
            String str = hashMap.get("orderID");
            String str2 = hashMap.get("shopID");
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                try {
                    b.this.f26224a.a(Long.parseLong(str), Integer.parseInt(str2));
                } catch (NumberFormatException e2) {
                    com.garena.android.appkit.d.a.a(e2);
                }
            }
        }
    }

    private class d implements a {
        private d() {
        }

        public void a(HashMap<String, String> hashMap) {
            String str = hashMap.get("requestID");
            String str2 = hashMap.get("type");
            String str3 = hashMap.get("redirectTo");
            String str4 = hashMap.get("accessToken");
            String str5 = hashMap.get("apiKey");
            String str6 = hashMap.get("apiSeed");
            String str7 = hashMap.get("customerIDMerchant");
            String str8 = hashMap.get("merchantID");
            String str9 = hashMap.get("XCOID");
            int parseInt = Integer.parseInt(hashMap.get("timeout"));
            int parseInt2 = Integer.parseInt(hashMap.get("environment"));
            if ("1".equals(str2)) {
                try {
                    b.this.f26224a.a(str, str2, str3, str4, str5, str6, str7, str8, str9, parseInt, parseInt2);
                } catch (Exception e2) {
                    com.garena.android.appkit.d.a.a(e2);
                }
            } else {
                try {
                    b.this.f26224a.a(str, str2, str3, str4, str5, str6, str7, str8, parseInt, parseInt2);
                } catch (Exception e3) {
                    com.garena.android.appkit.d.a.a(e3);
                }
            }
        }
    }
}
