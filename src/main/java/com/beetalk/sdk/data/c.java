package com.beetalk.sdk.data;

import android.text.TextUtils;
import java.io.Serializable;
import java.util.Map;

public class c implements Serializable {
    private static final long serialVersionUID = 1;
    final Integer errorCode;
    final String errorMessage;
    private final Map<String, String> extras;
    final com.garena.pay.android.c request;
    final a resultCode;

    public c(com.garena.pay.android.c cVar, a aVar, String str, Integer num, Map<String, String> map) {
        this.resultCode = aVar;
        this.errorMessage = str;
        this.errorCode = num;
        this.request = cVar;
        this.extras = map;
    }

    public static c a(com.garena.pay.android.c cVar, Map<String, String> map) {
        return new c(cVar, a.SUCCESS, (String) null, (Integer) null, map);
    }

    public static c a(com.garena.pay.android.c cVar, com.garena.pay.android.a aVar, String str) {
        return a(cVar, aVar, str, (String) null);
    }

    public static c a(com.garena.pay.android.c cVar, com.garena.pay.android.a aVar, String str, String str2) {
        return new c(cVar, a.ERROR, TextUtils.join(": ", new String[]{aVar.getCode().toString(), str}), aVar.getCode(), (Map<String, String>) null);
    }

    public static boolean a(a aVar) {
        return aVar != a.SUCCESS;
    }

    public a a() {
        return this.resultCode;
    }

    public String b() {
        return this.errorMessage;
    }

    public enum a {
        SUCCESS(0),
        CANCEL(1),
        ERROR(2);
        
        private final Integer value;

        private a(Integer num) {
            this.value = num;
        }

        public Integer getValue() {
            return this.value;
        }
    }
}
