package com.shopee.react.sdk.bridge.modules.app.cookie;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.modules.network.ForwardingCookieHandler;
import com.google.a.o;
import com.j256.ormlite.stmt.query.SimpleComparison;
import com.shopee.react.sdk.bridge.modules.base.c;
import com.shopee.react.sdk.bridge.protocol.CookieData;
import com.shopee.react.sdk.bridge.protocol.SimpleResponse;
import java.net.URI;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class a implements b {

    /* renamed from: a  reason: collision with root package name */
    private final ForwardingCookieHandler f30189a;

    public a(ReactApplicationContext reactApplicationContext) {
        this.f30189a = new ForwardingCookieHandler(reactApplicationContext);
    }

    public void a(String str, c<o> cVar) {
        try {
            List list = this.f30189a.get(new URI(str), new HashMap()).get("Cookie");
            o oVar = new o();
            if (list != null) {
                for (String split : ((String) list.get(0)).split(";")) {
                    String[] split2 = split.split(SimpleComparison.EQUAL_TO_OPERATION, 2);
                    if (split2.length > 1) {
                        oVar.a(split2[0].trim(), split2[1]);
                    }
                }
            }
            cVar.a(oVar);
        } catch (Exception unused) {
            cVar.a(new o());
        }
    }

    public void a(String str, String str2, c<SimpleResponse> cVar) {
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("Set-cookie", Collections.singletonList(((CookieData) com.shopee.react.sdk.a.a.f30143a.a(str2, CookieData.class)).getCookieString()));
            this.f30189a.put(new URI(str), hashMap);
            cVar.a(SimpleResponse.with(1));
        } catch (Exception unused) {
            cVar.a(SimpleResponse.with(0));
        }
    }
}
