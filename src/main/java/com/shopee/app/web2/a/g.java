package com.shopee.app.web2.a;

import android.annotation.SuppressLint;
import android.os.Build;
import android.text.TextUtils;
import android.webkit.WebSettings;
import com.shopee.app.application.ar;
import com.shopee.app.web2.d;

public class g extends h {
    @SuppressLint({"SetJavaScriptEnabled"})
    public void a() {
        d c2 = c();
        if (c2 != null) {
            WebSettings settings = c2.f26667d.getSettings();
            if (TextUtils.isEmpty(c2.n)) {
                c2.n = ((((settings.getUserAgentString() + " Shopee Beeshop") + " locale/" + ar.f().e().deviceStore().b()) + " version=297") + " appver=" + c2.getAppVer()) + " rnver=" + c2.getRNVer();
            }
            settings.setUserAgentString(c().n);
            settings.setJavaScriptEnabled(true);
            settings.setLoadWithOverviewMode(false);
            settings.setUseWideViewPort(false);
            settings.setSupportMultipleWindows(true);
            settings.setJavaScriptCanOpenWindowsAutomatically(true);
            settings.setRenderPriority(WebSettings.RenderPriority.HIGH);
            if (Build.VERSION.SDK_INT >= 17) {
                settings.setMediaPlaybackRequiresUserGesture(false);
            }
            if (Build.VERSION.SDK_INT >= 21) {
                settings.setMixedContentMode(0);
            }
            int i = Build.VERSION.SDK_INT;
            settings.setDomStorageEnabled(true);
            settings.setAppCacheMaxSize(33554432);
            settings.setAppCachePath(c2.getActivity().getCacheDir().toString());
            settings.setAllowFileAccess(true);
            settings.setAppCacheEnabled(true);
            settings.setCacheMode(-1);
        }
    }
}
