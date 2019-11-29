package com.airpay.paysdk.pay.password;

import android.text.TextUtils;
import java.util.Map;

public class a {
    public static String a(String str, Map<String, String> map) {
        StringBuilder sb = new StringBuilder();
        sb.append("<html><body onload=\"document.PAEnrollForm.submit();\"><form style=\"display:none\" id=\"PAEnrollForm\" name=\"PAEnrollForm\" action=\"" + str + "\" method=\"post\"/>");
        for (Map.Entry next : map.entrySet()) {
            sb.append(a((String) next.getKey(), (String) next.getValue()));
        }
        sb.append("</form></body></html>");
        return sb.toString();
    }

    public static String a(String str, String str2) {
        return String.format("<input type=\"hidden\" id=\"%1$s\" name=\"%2$s\" value=\"%3$s\"/>", new Object[]{str, str, TextUtils.htmlEncode(str2)});
    }
}
