package com.shopee.app.tracking;

import com.appsflyer.AFInAppEventParameterName;
import com.appsflyer.AppsFlyerLib;
import com.appsflyer.AppsFlyerProperties;
import com.facebook.AccessToken;
import com.facebook.appevents.UserDataStore;
import com.google.a.i;
import com.google.a.l;
import com.google.a.o;
import com.shopee.app.appuser.UserInfo;
import com.shopee.app.data.store.al;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.slf4j.Marker;

public class f {

    /* renamed from: a  reason: collision with root package name */
    private String f6988a = "";

    /* renamed from: b  reason: collision with root package name */
    private boolean f6989b = true;

    /* renamed from: c  reason: collision with root package name */
    private List<h> f6990c;

    public f(al alVar, List<h> list) {
        this.f6990c = list;
        c(alVar.g());
        a(alVar.a());
    }

    private void c(int i) {
        this.f6989b = true;
        this.f6988a = "";
    }

    private void a(UserInfo userInfo) {
        if (this.f6989b) {
            AppsFlyerLib.getInstance().setCustomerUserId(String.valueOf(userInfo.getUserId()));
            if (userInfo.hasEmail()) {
                AppsFlyerLib.getInstance().setUserEmails(AppsFlyerProperties.EmailsCryptType.MD5, userInfo.getEmail());
            } else if (userInfo.hasPhone()) {
                AppsFlyerLib instance = AppsFlyerLib.getInstance();
                AppsFlyerProperties.EmailsCryptType emailsCryptType = AppsFlyerProperties.EmailsCryptType.MD5;
                instance.setUserEmails(emailsCryptType, Marker.ANY_NON_NULL_MARKER + userInfo.getPhone());
            }
        }
    }

    public void a(int i) {
        AppsFlyerLib.getInstance().setCustomerUserId(String.valueOf(i));
    }

    public void b(int i) {
        Map<String, Object> b2 = b();
        b2.put(AccessToken.USER_ID_KEY, Integer.valueOf(i));
        a("AppOpened", b2);
    }

    public void a(String str) {
        Map<String, Object> b2 = b();
        b2.put(AFInAppEventParameterName.REGSITRATION_METHOD, str);
        a("Register", b2);
    }

    public void a(long j) {
        Map<String, Object> b2 = b();
        b2.put("item_id", Long.valueOf(j));
        a("ChatToOffer", b2);
    }

    public void a(long j, String str, String str2, int i, int i2, String str3) {
        double d2;
        Map<String, Object> b2 = b();
        b2.put(AFInAppEventParameterName.CONTENT_TYPE, "product");
        b2.put(AFInAppEventParameterName.CONTENT_ID, Long.valueOf(j));
        b2.put(AFInAppEventParameterName.CURRENCY, str);
        b2.put(AFInAppEventParameterName.PRICE, str2);
        b2.put(AFInAppEventParameterName.QUANTITY, Integer.valueOf(i));
        b2.put("categoryid", str3);
        b2.put("shop_id", Integer.valueOf(i2));
        i iVar = new i();
        o oVar = new o();
        oVar.a("id", String.valueOf(j));
        oVar.a("quantity", (Number) Integer.valueOf(i));
        try {
            d2 = Double.parseDouble(str2);
        } catch (Exception unused) {
            d2 = 0.0d;
        }
        oVar.a("item_price", (Number) Double.valueOf(d2));
        iVar.a((l) oVar);
        b2.put(AFInAppEventParameterName.CONTENT, iVar.toString());
        a("AddToCart", b2);
    }

    public void a(long j, String str, String str2, int i, int i2) {
        Map<String, Object> b2 = b();
        b2.put(AFInAppEventParameterName.CONTENT_TYPE, "product");
        b2.put(AFInAppEventParameterName.CONTENT_ID, Long.valueOf(j));
        b2.put(AFInAppEventParameterName.CURRENCY, str);
        b2.put(AFInAppEventParameterName.PRICE, str2);
        b2.put(AFInAppEventParameterName.QUANTITY, Integer.valueOf(i));
        b2.put("seller_id", Integer.valueOf(i2));
        a("OfferMade", b2);
    }

    public void b(long j, String str, String str2, int i, int i2) {
        Map<String, Object> b2 = b();
        b2.put(AFInAppEventParameterName.CONTENT_TYPE, "product");
        b2.put(AFInAppEventParameterName.CONTENT_ID, Long.valueOf(j));
        b2.put(AFInAppEventParameterName.CURRENCY, str);
        b2.put(AFInAppEventParameterName.PRICE, str2);
        b2.put(AFInAppEventParameterName.QUANTITY, Integer.valueOf(i));
        b2.put("seller_id", Integer.valueOf(i2));
        a("OfferAccepted", b2);
    }

    public void b(String str) {
        Map<String, Object> b2 = b();
        b2.put("login_method", str);
        a("Login", b2);
    }

    public void a(String str, String str2, String str3, int i) {
        Map<String, Object> b2 = b();
        b2.put("shared_content", str);
        b2.put("shared_content_id", str2);
        b2.put("platform", str3);
        b2.put(AccessToken.USER_ID_KEY, Integer.valueOf(i));
        a("Share", b2);
    }

    public void a(long j, long j2) {
        Map<String, Object> b2 = b();
        b2.put("shop_id", Long.valueOf(j));
        b2.put("product_id", Long.valueOf(j2));
        a("ProductComment", b2);
    }

    public void a(String str, String str2) {
        if (this.f6989b) {
            HashMap hashMap = new HashMap();
            hashMap.put(str, str2);
            a(str, (Map<String, Object>) hashMap);
        }
    }

    public void a(String str, Map<String, Object> map) {
        if (this.f6989b) {
            for (h a2 : this.f6990c) {
                a2.a(c(str), map);
            }
        }
    }

    private Map<String, Object> b() {
        HashMap hashMap = new HashMap();
        hashMap.put(UserDataStore.COUNTRY, "ID");
        return hashMap;
    }

    private String c(String str) {
        return this.f6988a + str;
    }

    public void a() {
        if (this.f6989b) {
            AppsFlyerLib.getInstance().setCustomerUserId(String.valueOf(0));
        }
    }
}
