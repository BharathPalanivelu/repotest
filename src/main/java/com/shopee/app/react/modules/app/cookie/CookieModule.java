package com.shopee.app.react.modules.app.cookie;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.modules.network.ForwardingCookieHandler;
import com.google.a.o;
import com.j256.ormlite.stmt.query.SimpleComparison;
import com.shopee.app.react.protocol.CookieData;
import com.shopee.app.web.WebRegister;
import java.net.URI;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

@ReactModule(name = "GACookies")
@Deprecated
public class CookieModule extends ReactContextBaseJavaModule {
    protected static final String NAME = "GACookies";
    private ForwardingCookieHandler mCookieHandler;

    public String getName() {
        return "GACookies";
    }

    public CookieModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        this.mCookieHandler = new ForwardingCookieHandler(reactApplicationContext);
    }

    @ReactMethod
    public void getCookies(String str, Promise promise) {
        try {
            List list = this.mCookieHandler.get(new URI(str), new HashMap()).get("Cookie");
            o oVar = new o();
            if (list != null) {
                String[] split = ((String) list.get(0)).split(";");
                for (String split2 : split) {
                    String[] split3 = split2.split(SimpleComparison.EQUAL_TO_OPERATION, 2);
                    if (split3.length > 1) {
                        oVar.a(split3[0].trim(), split3[1]);
                    }
                }
            }
            promise.resolve(oVar.toString());
        } catch (Exception e2) {
            promise.reject((Throwable) e2);
        }
    }

    @ReactMethod
    public void setCookie(String str, String str2, Promise promise) {
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("Set-cookie", Collections.singletonList(((CookieData) WebRegister.GSON.a(str2, CookieData.class)).getCookieString()));
            this.mCookieHandler.put(new URI(str), hashMap);
            o oVar = new o();
            oVar.a("status", (Number) 1);
            promise.resolve(oVar.toString());
        } catch (Exception unused) {
            o oVar2 = new o();
            oVar2.a("status", (Number) 0);
            promise.resolve(oVar2.toString());
        }
    }
}
