package com.shopee.app.tracking;

import com.appsflyer.AppsFlyerLib;
import com.shopee.app.application.ar;
import java.util.Map;

public class b implements h {
    public void a(String str, Map<String, Object> map) {
        AppsFlyerLib.getInstance().trackEvent(ar.f(), str, map);
    }
}
