package com.shopee.app.util;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Pair;
import android.view.View;
import android.widget.ImageButton;
import com.appsflyer.share.Constants;
import com.garena.android.appkit.b.b;
import com.google.android.gms.analytics.ecommerce.ProductAction;
import com.google.android.gms.common.ConnectionResult;
import com.j256.ormlite.stmt.query.SimpleComparison;
import com.salesforce.android.chat.core.internal.logging.event.ChatFileTransferEvent;
import com.salesforce.android.service.common.liveagentlogging.event.BaseEvent;
import com.shopee.app.appuser.UserInfo;
import com.shopee.app.data.store.SettingConfigStore;
import com.shopee.app.data.store.al;
import com.shopee.app.data.viewmodel.RedirectParameters;
import com.shopee.app.ui.follow.following.FollowingActivity;
import com.shopee.app.ui.webview.WebPageActivity_;
import com.shopee.app.upload.UploadManager;
import com.shopee.app.web.WebRegister;
import com.shopee.app.web.protocol.ImageSearchData;
import com.shopee.app.web.protocol.NavigateMessage;
import com.shopee.app.web2.WebPageActivity2_;
import com.shopee.id.R;
import com.shopee.navigator.NavigationPath;
import com.shopee.web.sdk.bridge.protocol.configurepage.ConfigurePageRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class aw {

    /* renamed from: a  reason: collision with root package name */
    public static String f26171a;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public static final HashMap<String, Integer> f26172d = new HashMap<>();

    /* renamed from: b  reason: collision with root package name */
    com.shopee.app.tracking.a f26173b;

    /* renamed from: c  reason: collision with root package name */
    al f26174c;

    /* renamed from: e  reason: collision with root package name */
    private final HashMap<String, a> f26175e = new HashMap<>();
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public final ak f26176f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public final SettingConfigStore f26177g;
    /* access modifiers changed from: private */
    public final com.shopee.navigator.e h;
    /* access modifiers changed from: private */
    public UserInfo i;
    /* access modifiers changed from: private */
    public com.shopee.app.ui.home.m j;
    /* access modifiers changed from: private */
    public UploadManager k;

    private interface a {
        int a();

        void a(Map<String, String> map);

        int b();

        boolean c();
    }

    static {
        f26172d.put("topay", 0);
        f26172d.put("toship", 1);
        f26172d.put("toreceive", 2);
        f26172d.put(ChatFileTransferEvent.COMPLETED, 3);
        f26172d.put("cancelled", 4);
        f26172d.put(ProductAction.ACTION_REFUND, 5);
        f26172d.put("unpaid", 0);
        f26172d.put("paid", 1);
        f26172d.put("actionRequired", 0);
        f26172d.put(BaseEvent.SDK_CHAT, 1);
        f26172d.put("recent", 0);
        f26172d.put("popular", 1);
        f26172d.put("stock", 2);
        f26172d.put("soldout", 3);
        f26172d.put("home", 0);
        f26172d.put("follow", 1);
        f26172d.put("mall", 2);
        f26172d.put("notifications", 3);
        f26172d.put("me", 4);
        f26172d.put("buying", 0);
        f26172d.put("posts", 1);
    }

    public aw(UserInfo userInfo, ak akVar, SettingConfigStore settingConfigStore, com.shopee.navigator.e eVar, UploadManager uploadManager) {
        this.f26176f = akVar;
        this.i = userInfo;
        this.f26177g = settingConfigStore;
        this.k = uploadManager;
        this.h = eVar;
        b();
    }

    private void b() {
        this.f26175e.put("main", new j("home"));
        this.f26175e.put("home", new j("home"));
        this.f26175e.put("mall", new j("mall"));
        this.f26175e.put("follow", new j("follow"));
        this.f26175e.put("addFriends", new d());
        this.f26175e.put("sell", new x());
        this.f26175e.put("activity", new c());
        this.f26175e.put("myAccount", new n());
        this.f26175e.put("editProfile", new i());
        this.f26175e.put("appSystemSetting", new e());
        this.f26175e.put("socialAccount", new ae());
        this.f26175e.put("settings", new ab());
        this.f26175e.put("chatList", new f());
        this.f26175e.put("me", new j("me"));
        this.f26175e.put("sellerAssistant", new y());
        this.f26175e.put("editProduct", new h());
        this.f26175e.put("products", new p());
        this.f26175e.put("income", new m());
        this.f26175e.put("cart", new ad());
        this.f26175e.put("myLikes", new o());
        this.f26175e.put("purchases", new t());
        this.f26175e.put("orders", new s());
        this.f26175e.put("order", new r());
        this.f26175e.put("return", new v());
        this.f26175e.put(ProductAction.ACTION_CHECKOUT, new g());
        this.f26175e.put("actionbox", new q());
        this.f26175e.put("setting", new aa());
        this.f26175e.put("shop", new ac());
        this.f26175e.put("sns", new w());
        this.f26175e.put("action", new b());
        this.f26175e.put("reactPath", new u());
        this.f26175e.put("imageSearch", new k());
        this.f26175e.put("imageSearchHint", new l());
        this.f26175e.put("sellingPage", new z());
    }

    public boolean a(String str) {
        return this.f26175e.containsKey(str);
    }

    public void a(com.shopee.app.ui.home.m mVar, String str) {
        a(mVar, str, (RedirectParameters) null);
    }

    public void a(com.shopee.app.ui.home.m mVar, String str, RedirectParameters redirectParameters) {
        if (mVar != null && !TextUtils.isEmpty(str)) {
            this.j = mVar;
            b(mVar, str, redirectParameters);
            this.f26174c.i();
        }
    }

    private void b(com.shopee.app.ui.home.m mVar, String str, RedirectParameters redirectParameters) {
        String str2 = str.split("\\?")[0];
        try {
            HashMap<String, String> b2 = b(str);
            if (str2.equals("sns")) {
                b2.put("sns", str.split("\\?")[1]);
            }
            a aVar = this.f26175e.get(str2);
            String str3 = "";
            if (aVar != null) {
                if (!aVar.c() || this.i.isLoggedIn()) {
                    int a2 = aVar.a();
                    if (redirectParameters != null && !redirectParameters.getHomeTab().isEmpty()) {
                        a2 = f26172d.get(redirectParameters.getHomeTab()).intValue();
                    }
                    mVar.setSelectedIndex(a2);
                    aVar.a(b2);
                    mVar.setMeSubTabIndex(aVar.b());
                } else {
                    this.f26176f.b();
                }
                str3 = aVar.getClass().getSimpleName();
            } else if (str2.equals(BaseEvent.SDK_CHAT)) {
                str3 = a(str.replace(BaseEvent.SDK_CHAT, str3).replace("?", str3).split(","));
            }
            if (!TextUtils.isEmpty(str3)) {
                this.f26173b.a(str, str3);
            }
            if (TextUtils.isEmpty(str3)) {
                try {
                    List<com.shopee.sdk.d.c> b3 = com.shopee.sdk.b.b();
                    if (!af.a(b3)) {
                        for (com.shopee.sdk.d.c a3 : b3) {
                            if (a3.a((Activity) this.f26176f.a(), str2, com.shopee.navigator.a.f30102a.a((Object) b2).m())) {
                                return;
                            }
                        }
                    }
                } catch (Exception e2) {
                    com.garena.android.appkit.d.a.a(e2);
                    com.garena.b.a.a.b("Jump", (Throwable) e2);
                }
            }
        } catch (Exception e3) {
            com.garena.android.appkit.d.a.a(e3);
            com.garena.b.a.a.a("ROUTING", "There was a problem with this route, stop redirect", e3);
        }
    }

    public static HashMap<String, String> b(String str) throws Exception {
        HashMap<String, String> hashMap = new HashMap<>();
        String[] split = str.split("\\?");
        if (split.length >= 2) {
            for (String split2 : split[1].split("&")) {
                String[] split3 = split2.split(SimpleComparison.EQUAL_TO_OPERATION);
                if (split3.length == 2) {
                    hashMap.put(bm.b(split3[0]), bm.b(split3[1]));
                }
            }
        }
        return hashMap;
    }

    private String a(String[] strArr) {
        RedirectParameters redirectParameters = new RedirectParameters(strArr);
        if (redirectParameters.getItemId() == 0 && redirectParameters.getShopId() == 0 && redirectParameters.getUserId() == 0 && redirectParameters.getOrderId() == 0) {
            return this.f26176f.g();
        }
        if (redirectParameters.getOrderId() == 0) {
            this.f26176f.g();
            return this.f26176f.a(redirectParameters.getItemId(), redirectParameters.getShopId(), redirectParameters.getUserId());
        }
        this.f26176f.g();
        return this.f26176f.a(redirectParameters.getShopId(), redirectParameters.getUserId(), redirectParameters.getOrderId());
    }

    /* access modifiers changed from: private */
    public void a(Map<String, String> map) {
        String str = map.get("orderID");
        String str2 = map.get("shopID");
        String str3 = map.get("userID");
        if ("1".equals(map.get("showChat")) && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
            try {
                this.f26176f.a(Integer.parseInt(str2), Integer.parseInt(str3), Long.parseLong(str));
            } catch (NumberFormatException e2) {
                com.garena.android.appkit.d.a.a(e2);
            }
        }
    }

    private class j implements a {
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public final String f26192b;

        /* renamed from: c  reason: collision with root package name */
        private int f26193c = -1;

        private void a(String str) {
        }

        public boolean c() {
            return false;
        }

        public j(String str) {
            this.f26192b = str;
        }

        public void a(final Map<String, String> map) {
            String str = map.get("apprl");
            if (!TextUtils.isEmpty(str)) {
                aw.this.h.a(aw.this.j.getActivity(), NavigationPath.a(str));
                return;
            }
            String str2 = map.get("navRoute");
            if (!TextUtils.isEmpty(str2)) {
                try {
                    com.google.a.o oVar = (com.google.a.o) WebRegister.GSON.a(new String(Base64.decode(str2, 0)), com.google.a.o.class);
                    String c2 = oVar.b("lastPageTrigger") ? oVar.c("lastPageTrigger").c() : null;
                    com.google.a.i iVar = (com.google.a.i) WebRegister.GSON.a(oVar.c("paths"), com.google.a.i.class);
                    if (iVar != null && iVar.a() > 0) {
                        for (int i = 0; i < iVar.a() - 1; i++) {
                            a(iVar.a(i), (String) null);
                        }
                        a(iVar.a(iVar.a() - 1), c2);
                    } else if (c2 != null) {
                        a(c2);
                    }
                } catch (Exception e2) {
                    com.garena.android.appkit.d.a.a(e2);
                }
            } else {
                String str3 = map.get("showShare");
                if (!TextUtils.isEmpty(str3) && str3.equals("1")) {
                    com.garena.android.appkit.f.f.a().a(new Runnable() {
                        public void run() {
                            View findViewById = aw.this.j.findViewById(R.id.settings_share);
                            if (findViewById instanceof ImageButton) {
                                ((ImageButton) findViewById).performClick();
                            }
                        }
                    }, 2000);
                }
                String str4 = map.get("afterUpload");
                if (!TextUtils.isEmpty(str4) && str4.equals("1")) {
                    com.garena.android.appkit.f.f.a().a(new Runnable() {
                        public void run() {
                            com.garena.android.appkit.b.b.a("PRODUCT_UPLOAD_SUCCESS", new com.garena.android.appkit.b.a(), b.a.UI_BUS);
                        }
                    }, ConnectionResult.DRIVE_EXTERNAL_STORAGE_REQUIRED);
                }
                if ("me".equals(this.f26192b)) {
                    String str5 = map.get("meTab");
                    if ("selling".equals(str5)) {
                        new z().a(map);
                        return;
                    } else if (!TextUtils.isEmpty(str5) && aw.f26172d.containsKey(str5)) {
                        this.f26193c = ((Integer) aw.f26172d.get(str5)).intValue();
                    }
                }
                if ("follow".equals(this.f26192b)) {
                    String str6 = map.get("refresh");
                    if (!TextUtils.isEmpty(str6) && str6.equals("1")) {
                        com.garena.android.appkit.f.f.a().a(new Runnable() {
                            public void run() {
                                com.garena.android.appkit.b.b.a("FOLLOW_USER_REFRESH", new com.garena.android.appkit.b.a(), b.a.NETWORK_BUS);
                            }
                        }, ConnectionResult.DRIVE_EXTERNAL_STORAGE_REQUIRED);
                    }
                }
                if ("home".equals(this.f26192b) || "mall".equals(this.f26192b) || "follow".equals(this.f26192b)) {
                    com.garena.android.appkit.f.f.a().a(new Runnable() {
                        public void run() {
                            com.garena.android.appkit.b.b.a("MALL_TAB_REDIRECT_PARAM", new com.garena.android.appkit.b.a(new Pair(j.this.f26192b, bm.a((Map<String, String>) map))), b.a.UI_BUS);
                        }
                    }, 2000);
                }
            }
        }

        private void a(com.google.a.l lVar, String str) {
            try {
                NavigateMessage navigateMessage = (NavigateMessage) WebRegister.GSON.a(((com.google.a.o) WebRegister.GSON.a(lVar, com.google.a.o.class)).c("webNav"), NavigateMessage.class);
                com.google.a.l config = navigateMessage.getConfig();
                if (config == null) {
                    WebPageActivity_.a(aw.this.f26176f.a()).a(navigateMessage.getNavbarStr()).b(navigateMessage.getUrl()).d(navigateMessage.getTabsStr()).g(str).e(navigateMessage.getTabRightButtonStr()).i(navigateMessage.getPopUpForBackButtonStr()).a(100);
                    return;
                }
                int webviewType = ((ConfigurePageRequest.ConfigMessage) com.shopee.web.sdk.bridge.internal.a.f30470a.a(config, ConfigurePageRequest.ConfigMessage.class)).getWebviewType();
                if (webviewType == 0) {
                    WebPageActivity_.a(aw.this.f26176f.a()).a(navigateMessage.getNavbarStr()).b(navigateMessage.getUrl()).f(config.toString()).g(str).d(navigateMessage.getTabsStr()).e(navigateMessage.getTabRightButtonStr()).i(navigateMessage.getPopUpForBackButtonStr()).a(100);
                } else if (webviewType == 1 || webviewType == 2) {
                    WebPageActivity2_.a(aw.this.f26176f.a()).a(navigateMessage.getNavbarStr()).b(navigateMessage.getUrl()).d(config.toString()).c(str).a(100);
                }
            } catch (Exception e2) {
                com.garena.android.appkit.d.a.a(e2);
            }
        }

        public int a() {
            if (TextUtils.isEmpty(this.f26192b) || !aw.f26172d.containsKey(this.f26192b)) {
                return 0;
            }
            return ((Integer) aw.f26172d.get(this.f26192b)).intValue();
        }

        public int b() {
            return this.f26193c;
        }
    }

    private class f implements a {
        public int a() {
            return 0;
        }

        public int b() {
            return -1;
        }

        public boolean c() {
            return true;
        }

        private f() {
        }

        public void a(Map<String, String> map) {
            aw.this.f26176f.e();
        }
    }

    private class d implements a {
        public int a() {
            return 0;
        }

        public int b() {
            return -1;
        }

        public boolean c() {
            return true;
        }

        private d() {
        }

        public void a(Map<String, String> map) {
            aw.this.f26176f.a(FollowingActivity.class);
        }
    }

    private class x implements a {
        public int b() {
            return -1;
        }

        public boolean c() {
            return true;
        }

        private x() {
        }

        public void a(Map<String, String> map) {
            int i;
            boolean z = aw.this.i.isBACheckNeeded() && aw.this.f26177g.allowBACheck();
            try {
                i = Integer.parseInt(map.get("type"));
            } catch (Exception unused) {
                i = 0;
            }
            aw.this.f26176f.W();
            aw.this.f26176f.a(i, aw.this.k, z, false);
        }

        public int a() {
            return ((Integer) aw.f26172d.get("me")).intValue();
        }
    }

    private class q implements a {
        public int b() {
            return -1;
        }

        public boolean c() {
            return true;
        }

        private q() {
        }

        public void a(Map<String, String> map) {
            try {
                int parseInt = Integer.parseInt(map.get("cat"));
                if (!(parseInt == 1 || parseInt == 2 || parseInt == 6 || parseInt == 8 || parseInt == 10)) {
                    if (parseInt != 7) {
                        if (parseInt == 3) {
                            aw.this.f26176f.b(aw.this.i.isSeller());
                            return;
                        }
                        return;
                    }
                }
                aw.this.f26176f.e(parseInt);
            } catch (NumberFormatException e2) {
                com.garena.android.appkit.d.a.a(e2);
            }
        }

        public int a() {
            return ((Integer) aw.f26172d.get("notifications")).intValue();
        }
    }

    private class b implements a {
        public int b() {
            return -1;
        }

        public boolean c() {
            return true;
        }

        private b() {
        }

        public void a(Map<String, String> map) {
            try {
                int parseInt = Integer.parseInt(map.get("catid"));
                if (!(parseInt == 1 || parseInt == 2 || parseInt == 6 || parseInt == 10 || parseInt == 8 || parseInt == 7)) {
                    if (parseInt != 9) {
                        if (parseInt == 3) {
                            aw.this.f26176f.b(aw.this.i.isSeller());
                            return;
                        } else if (parseInt == 5) {
                            aw.this.f26176f.e();
                            int parseInt2 = Integer.parseInt(map.get("userid"));
                            if (parseInt2 > 0) {
                                aw.this.f26176f.d(parseInt2);
                                return;
                            }
                            return;
                        } else {
                            return;
                        }
                    }
                }
                aw.this.f26176f.e(parseInt);
            } catch (NumberFormatException e2) {
                com.garena.android.appkit.d.a.a(e2);
            }
        }

        public int a() {
            return ((Integer) aw.f26172d.get("notifications")).intValue();
        }
    }

    private class t implements a {
        public boolean c() {
            return true;
        }

        private t() {
        }

        public void a(Map<String, String> map) {
            String str = map.get("tab2");
            if (TextUtils.isEmpty(str)) {
                String str2 = map.get("tab");
                if (TextUtils.isEmpty(str2) || !aw.f26172d.containsKey(str2)) {
                    aw.this.f26176f.l();
                } else {
                    aw.this.f26176f.h(((Integer) aw.f26172d.get(str2)).intValue());
                }
            } else if (aw.f26172d.containsKey(str)) {
                aw.this.f26176f.h(((Integer) aw.f26172d.get(str)).intValue());
            } else {
                aw.this.f26176f.l();
            }
            aw.this.a(map);
        }

        public int a() {
            return ((Integer) aw.f26172d.get("me")).intValue();
        }

        public int b() {
            return ((Integer) aw.f26172d.get("buying")).intValue();
        }
    }

    private class s implements a {
        public int b() {
            return -1;
        }

        public boolean c() {
            return true;
        }

        private s() {
        }

        public void a(Map<String, String> map) {
            String str = map.get("tab2");
            String str2 = map.get("filter");
            if (TextUtils.isEmpty(str)) {
                String str3 = map.get("tab");
                if (TextUtils.isEmpty(str3) || !aw.f26172d.containsKey(str3)) {
                    aw.this.f26176f.i();
                } else {
                    aw.this.f26176f.g(((Integer) aw.f26172d.get(str3)).intValue());
                }
            } else if (aw.f26172d.containsKey(str)) {
                aw.this.f26176f.b(((Integer) aw.f26172d.get(str)).intValue(), str2);
            } else {
                aw.this.f26176f.i();
            }
            aw.this.a(map);
        }

        public int a() {
            return ((Integer) aw.f26172d.get("me")).intValue();
        }
    }

    private class g implements a {
        public int b() {
            return -1;
        }

        public boolean c() {
            return true;
        }

        private g() {
        }

        public void a(Map<String, String> map) {
            String str = map.get("checkoutID");
            if (!TextUtils.isEmpty(str)) {
                try {
                    long parseLong = Long.parseLong(str);
                    aw.this.f26176f.h(0);
                    aw.this.f26176f.a(parseLong);
                } catch (NumberFormatException e2) {
                    com.garena.android.appkit.d.a.a(e2);
                }
            }
            aw.this.a(map);
        }

        public int a() {
            return ((Integer) aw.f26172d.get("me")).intValue();
        }
    }

    private class m implements a {
        public int b() {
            return -1;
        }

        public boolean c() {
            return true;
        }

        private m() {
        }

        public void a(Map<String, String> map) {
            aw.this.f26176f.W();
            aw.this.f26176f.p();
            aw.this.f26176f.F();
        }

        public int a() {
            return ((Integer) aw.f26172d.get("me")).intValue();
        }
    }

    private class y implements a {
        public int b() {
            return -1;
        }

        public boolean c() {
            return true;
        }

        private y() {
        }

        public void a(Map<String, String> map) {
            aw.this.f26176f.W();
            aw.this.f26176f.p();
        }

        public int a() {
            return ((Integer) aw.f26172d.get("me")).intValue();
        }
    }

    private class p implements a {
        public int b() {
            return -1;
        }

        public boolean c() {
            return true;
        }

        private p() {
        }

        public void a(Map<String, String> map) {
            aw.this.f26176f.W();
            String str = map.get("tab");
            if (TextUtils.isEmpty(str) || !aw.f26172d.containsKey(str)) {
                aw.this.f26176f.h();
                return;
            }
            aw.this.f26176f.p();
            aw.this.f26176f.f(((Integer) aw.f26172d.get(str)).intValue());
        }

        public int a() {
            return ((Integer) aw.f26172d.get("me")).intValue();
        }
    }

    private class h implements a {
        public int b() {
            return -1;
        }

        public boolean c() {
            return true;
        }

        private h() {
        }

        public void a(Map<String, String> map) {
            String str = map.get("itemID");
            String str2 = map.get("shopID");
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                try {
                    long parseLong = Long.parseLong(str);
                    if (((long) aw.this.i.getShopId()) == Long.parseLong(str2)) {
                        aw.this.f26176f.W();
                        aw.this.f26176f.p();
                        aw.this.f26176f.h();
                        aw.this.f26176f.a(parseLong, aw.this.k);
                    }
                } catch (NumberFormatException e2) {
                    com.garena.android.appkit.d.a.a(e2);
                }
            }
        }

        public int a() {
            return ((Integer) aw.f26172d.get("me")).intValue();
        }
    }

    private class ad implements a {
        public int b() {
            return -1;
        }

        public boolean c() {
            return true;
        }

        private ad() {
        }

        public void a(Map<String, String> map) {
            aw.this.f26176f.u();
        }

        public int a() {
            return ((Integer) aw.f26172d.get("me")).intValue();
        }
    }

    private class o implements a {
        public boolean c() {
            return true;
        }

        private o() {
        }

        public void a(Map<String, String> map) {
            aw.this.f26176f.m();
        }

        public int a() {
            return ((Integer) aw.f26172d.get("me")).intValue();
        }

        public int b() {
            return ((Integer) aw.f26172d.get("buying")).intValue();
        }
    }

    private class c implements a {
        public int b() {
            return -1;
        }

        public boolean c() {
            return true;
        }

        private c() {
        }

        public void a(Map<String, String> map) {
            aw.this.f26176f.b(aw.this.i.isSeller());
        }

        public int a() {
            return ((Integer) aw.f26172d.get("home")).intValue();
        }
    }

    private class n implements a {
        public boolean c() {
            return true;
        }

        private n() {
        }

        public void a(Map<String, String> map) {
            aw.this.f26176f.R();
        }

        public int a() {
            return ((Integer) aw.f26172d.get("me")).intValue();
        }

        public int b() {
            return ((Integer) aw.f26172d.get("buying")).intValue();
        }
    }

    private class e implements a {
        public int b() {
            return -1;
        }

        public boolean c() {
            return true;
        }

        private e() {
        }

        public void a(Map<String, String> map) {
            aw.this.f26176f.ag();
        }

        public int a() {
            return ((Integer) aw.f26172d.get("notifications")).intValue();
        }
    }

    private class i implements a {
        public boolean c() {
            return true;
        }

        private i() {
        }

        public void a(Map<String, String> map) {
            aw.this.f26176f.t();
        }

        public int a() {
            return ((Integer) aw.f26172d.get("me")).intValue();
        }

        public int b() {
            return ((Integer) aw.f26172d.get("buying")).intValue();
        }
    }

    private class ae implements a {
        public int b() {
            return -1;
        }

        public boolean c() {
            return true;
        }

        private ae() {
        }

        public void a(Map<String, String> map) {
            aw.this.f26176f.R();
            aw.this.f26176f.T();
        }

        public int a() {
            return ((Integer) aw.f26172d.get("me")).intValue();
        }
    }

    private class ab implements a {
        public boolean c() {
            return true;
        }

        private ab() {
        }

        public void a(Map<String, String> map) {
            aw.this.f26176f.a(false);
        }

        public int a() {
            return ((Integer) aw.f26172d.get("me")).intValue();
        }

        public int b() {
            return ((Integer) aw.f26172d.get("buying")).intValue();
        }
    }

    private class r implements a {
        public int b() {
            return -1;
        }

        public boolean c() {
            return true;
        }

        private r() {
        }

        public void a(Map<String, String> map) {
            String str = map.get("orderID");
            String str2 = map.get("shopID");
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                try {
                    long parseLong = Long.parseLong(str);
                    int parseInt = Integer.parseInt(str2);
                    int i = 0;
                    String str3 = map.get("tab2");
                    if (TextUtils.isEmpty(str3)) {
                        String str4 = map.get("tab");
                        if (!TextUtils.isEmpty(str4) && aw.f26172d.containsKey(str4)) {
                            i = ((Integer) aw.f26172d.get(str4)).intValue();
                        }
                    } else if (aw.f26172d.containsKey(str3)) {
                        i = ((Integer) aw.f26172d.get(str3)).intValue();
                    }
                    if (aw.this.i.getShopId() == parseInt) {
                        aw.this.f26176f.g(i);
                        aw.this.f26176f.a(parseLong, parseInt);
                    } else {
                        aw.this.f26176f.h(i);
                        aw.this.f26176f.a(parseLong, parseInt);
                    }
                } catch (NumberFormatException e2) {
                    com.garena.android.appkit.d.a.a(e2);
                }
            }
            aw.this.a(map);
        }

        public int a() {
            return ((Integer) aw.f26172d.get("me")).intValue();
        }
    }

    private class v implements a {
        public int b() {
            return -1;
        }

        public boolean c() {
            return true;
        }

        private v() {
        }

        public void a(Map<String, String> map) {
            String str = map.get("returnID");
            String str2 = map.get("shopID");
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                try {
                    long parseLong = Long.parseLong(str);
                    if (aw.this.i.getShopId() == Integer.parseInt(str2)) {
                        aw.this.f26176f.W();
                        aw.this.f26176f.g(((Integer) aw.f26172d.get(ProductAction.ACTION_REFUND)).intValue());
                        aw.this.f26176f.a(true, parseLong);
                    } else {
                        aw.this.f26176f.h(((Integer) aw.f26172d.get(ProductAction.ACTION_REFUND)).intValue());
                        aw.this.f26176f.a(false, parseLong);
                    }
                } catch (NumberFormatException e2) {
                    com.garena.android.appkit.d.a.a(e2);
                }
            }
            aw.this.a(map);
        }

        public int a() {
            return ((Integer) aw.f26172d.get("me")).intValue();
        }
    }

    private class aa implements a {
        public int b() {
            return -1;
        }

        public boolean c() {
            return true;
        }

        private aa() {
        }

        public void a(Map<String, String> map) {
            aw.this.f26176f.a(false);
        }

        public int a() {
            return ((Integer) aw.f26172d.get("me")).intValue();
        }
    }

    private class ac implements a {
        public boolean c() {
            return false;
        }

        private ac() {
        }

        public void a(Map<String, String> map) {
            String str = map.get("shopID");
            if (!TextUtils.isEmpty(str)) {
                try {
                    aw.this.f26176f.b(Integer.parseInt(str));
                } catch (NumberFormatException e2) {
                    com.garena.android.appkit.d.a.a(e2);
                }
            }
        }

        public int a() {
            return ((Integer) aw.f26172d.get("me")).intValue();
        }

        public int b() {
            return ((Integer) aw.f26172d.get("buying")).intValue();
        }
    }

    private class w implements a {
        public int a() {
            return 0;
        }

        public int b() {
            return -1;
        }

        public boolean c() {
            return true;
        }

        private w() {
        }

        public void a(Map<String, String> map) {
            String str = map.get("sns");
            aw.f26171a = str;
            com.garena.android.appkit.d.a.b("sns debugging, home redirect  snsString:%s", str);
        }
    }

    private class u implements a {
        public int b() {
            return -1;
        }

        public boolean c() {
            return false;
        }

        private u() {
        }

        public void a(Map<String, String> map) {
            String str = map.get("path");
            if (TextUtils.isEmpty(str)) {
                com.garena.android.appkit.d.a.a("React path is empty", new Object[0]);
                return;
            }
            String[] split = str.split("\\?");
            String str2 = split.length == 2 ? split[1] : "";
            if (TextUtils.isEmpty(str2)) {
                str2 = bm.a(map);
            }
            int i = (!map.containsKey("indicator") || !"splash".equals(map.get("indicator"))) ? 0 : 1;
            if (split[0].contains(Constants.URL_PATH_DELIMITER)) {
                aw.this.f26176f.a(split[0].split(Constants.URL_PATH_DELIMITER, 2)[1], str2, "jump", i);
                return;
            }
            com.garena.android.appkit.d.a.a("React path is error" + split[0], new Object[0]);
        }

        public int a() {
            return ((Integer) aw.f26172d.get("home")).intValue();
        }
    }

    class k implements a {
        public int b() {
            return -1;
        }

        public boolean c() {
            return false;
        }

        k() {
        }

        public void a(Map<String, String> map) {
            com.shopee.app.ui.d.c.a(aw.this.j.getActivity());
        }

        public int a() {
            return ((Integer) aw.f26172d.get("home")).intValue();
        }
    }

    class l implements a {
        public int b() {
            return -1;
        }

        public boolean c() {
            return false;
        }

        l() {
        }

        public void a(Map<String, String> map) {
            ImageSearchData imageSearchData = new ImageSearchData();
            imageSearchData.bigImageUri = map.get("imageSearchUri");
            imageSearchData.isFromHint = true;
            com.shopee.app.ui.d.c.a((Context) aw.this.j.getActivity(), imageSearchData, false);
        }

        public int a() {
            return ((Integer) aw.f26172d.get("home")).intValue();
        }
    }

    class z implements a {
        public int b() {
            return -1;
        }

        public boolean c() {
            return true;
        }

        z() {
        }

        public void a(Map<String, String> map) {
            aw.this.f26176f.W();
        }

        public int a() {
            return ((Integer) aw.f26172d.get("me")).intValue();
        }
    }
}
