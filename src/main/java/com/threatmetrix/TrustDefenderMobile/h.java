package com.threatmetrix.TrustDefenderMobile;

import android.util.Log;
import com.j256.ormlite.stmt.query.SimpleComparison;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.message.BasicNameValuePair;

class h extends HashMap<String, String> {

    /* renamed from: a  reason: collision with root package name */
    private static final String f32578a = "com.threatmetrix.TrustDefenderMobile.h";
    private int m_postValueLengthLimit = 0;

    h() {
    }

    public void a(int i) {
        this.m_postValueLengthLimit = i;
    }

    public h a(String str, String str2) {
        put(str, str2);
        return this;
    }

    public h a(String str, String str2, boolean z) {
        if (!z || str2 == null || str2.isEmpty()) {
            put(str, str2);
        } else {
            put(str, str2.toLowerCase(Locale.US));
        }
        return this;
    }

    public String a() {
        StringBuilder sb = new StringBuilder();
        for (String str : keySet()) {
            String str2 = (String) get(str);
            if (str2 != null && !str2.isEmpty()) {
                if (sb.length() > 0) {
                    sb.append("&");
                }
                sb.append(str);
                if (this.m_postValueLengthLimit != 0) {
                    int length = str2.length();
                    int i = this.m_postValueLengthLimit;
                    if (length > i) {
                        str2 = str2.substring(0, i);
                    }
                }
                sb.append(SimpleComparison.EQUAL_TO_OPERATION);
                sb.append(v.a(str2));
            }
        }
        return sb.toString();
    }

    public UrlEncodedFormEntity b() {
        ArrayList arrayList = new ArrayList();
        for (String str : keySet()) {
            String str2 = (String) get(str);
            if (!str2.isEmpty()) {
                if (this.m_postValueLengthLimit != 0) {
                    int length = str2.length();
                    int i = this.m_postValueLengthLimit;
                    if (length > i) {
                        str2 = str2.substring(0, i);
                    }
                }
                arrayList.add(new BasicNameValuePair(str, str2));
            }
        }
        try {
            return new UrlEncodedFormEntity(arrayList, "UTF-8");
        } catch (UnsupportedEncodingException e2) {
            Log.e(f32578a, "Failed url encoding", e2);
            return null;
        }
    }
}
