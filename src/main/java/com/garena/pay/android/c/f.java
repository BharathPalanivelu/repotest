package com.garena.pay.android.c;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.net.UrlQuerySanitizer;
import android.os.Bundle;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import org.json.JSONException;
import org.json.JSONObject;

public class f {

    /* renamed from: a  reason: collision with root package name */
    private static Random f8182a = new Random();

    public static boolean a(Context context) {
        if (context instanceof Activity) {
            return !((Activity) context).isFinishing();
        }
        if (context instanceof ContextWrapper) {
            Context baseContext = ((ContextWrapper) context).getBaseContext();
            if (baseContext instanceof Activity) {
                return !((Activity) baseContext).isFinishing();
            }
        }
        return true;
    }

    public static boolean a(String str) {
        return str == null || str.length() == 0;
    }

    public static boolean a(CharSequence charSequence) {
        return charSequence == null || charSequence.length() == 0;
    }

    public static String a(Activity activity, int i) {
        return activity.getResources().getString(i);
    }

    public static Map<String, String> b(String str) {
        HashMap hashMap = new HashMap();
        UrlQuerySanitizer urlQuerySanitizer = new UrlQuerySanitizer();
        urlQuerySanitizer.setAllowUnregisteredParamaters(true);
        urlQuerySanitizer.parseUrl(str);
        for (UrlQuerySanitizer.ParameterValuePair next : urlQuerySanitizer.getParameterList()) {
            hashMap.put(next.mParameter, next.mValue);
        }
        return hashMap;
    }

    public static Map<String, String> a(Bundle bundle) {
        HashMap hashMap = new HashMap();
        for (String str : bundle.keySet()) {
            hashMap.put(str, bundle.get(str) == null ? "" : bundle.get(str).toString());
        }
        return hashMap;
    }

    public static boolean c(String str) {
        try {
            return new JSONObject(str).has("error");
        } catch (JSONException e2) {
            e2.printStackTrace();
            return false;
        }
    }
}
