package com.appsflyer.internal;

import com.appsflyer.AFLogger;

public final class w implements a {

    /* renamed from: ˎ  reason: contains not printable characters */
    private a f246 = this;

    interface a {
        /* renamed from: ˎ  reason: contains not printable characters */
        Class<?> m195(String str) throws ClassNotFoundException;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public final String m194() {
        for (d dVar : d.values()) {
            if (m192(dVar.f257)) {
                return dVar.f256;
            }
        }
        return d.DEFAULT.f256;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private boolean m192(String str) {
        try {
            this.f246.m195(str);
            StringBuilder sb = new StringBuilder("Class: ");
            sb.append(str);
            sb.append(" is found.");
            AFLogger.afRDLog(sb.toString());
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        } catch (Throwable th) {
            AFLogger.afErrorLog(th.getMessage(), th);
            return false;
        }
    }

    enum d {
        UNITY("android_unity", "com.unity3d.player.UnityPlayer"),
        REACT_NATIVE("android_reactNative", "com.facebook.react.ReactApplication"),
        CORDOVA("android_cordova", "org.apache.cordova.CordovaActivity"),
        SEGMENT("android_segment", "com.segment.analytics.integrations.Integration"),
        COCOS2DX("android_cocos2dx", "org.cocos2dx.lib.Cocos2dxActivity"),
        DEFAULT("android_native", "android_native"),
        ADOBE_EX("android_adobe_ex", "com.appsflyer.adobeextension"),
        FLUTTER("android_flutter", "io.flutter.plugin.common.MethodChannel.MethodCallHandler");
        
        /* access modifiers changed from: private */

        /* renamed from: ʻ  reason: contains not printable characters */
        public String f256;
        /* access modifiers changed from: private */

        /* renamed from: ᐝ  reason: contains not printable characters */
        public String f257;

        private d(String str, String str2) {
            this.f256 = str;
            this.f257 = str2;
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public final Class<?> m193(String str) throws ClassNotFoundException {
        return Class.forName(str);
    }
}
