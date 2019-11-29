package com.beetalk.sdk.data;

import java.io.Serializable;
import org.json.JSONException;
import org.json.JSONObject;

public class a implements Serializable {
    private static final long serialVersionUID = 1;
    private String authToken;
    private Integer expiryTimestamp;
    private String openId;
    private String refreshToken;
    private d tokenProvider;

    public a(String str, d dVar) {
        this.authToken = str;
        this.tokenProvider = dVar;
    }

    public static String a(a aVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("authToken", aVar.authToken);
            jSONObject.put("tokenProvider", aVar.tokenProvider.getValue());
            jSONObject.put("expiryTimestamp", aVar.expiryTimestamp);
            String str = "";
            jSONObject.put("refreshToken", aVar.refreshToken != null ? aVar.refreshToken : str);
            if (aVar.openId != null) {
                str = aVar.openId;
            }
            jSONObject.put("openId", str);
        } catch (JSONException e2) {
            com.beetalk.sdk.e.a.a((Exception) e2);
        }
        return jSONObject.toString();
    }

    public String a() {
        return this.openId;
    }

    public void a(String str) {
        this.openId = str;
    }

    public String b() {
        return this.authToken;
    }

    public int c() {
        return this.expiryTimestamp.intValue();
    }

    public void a(int i) {
        this.expiryTimestamp = Integer.valueOf(i);
    }

    public String d() {
        return this.refreshToken;
    }

    public void b(String str) {
        this.refreshToken = str;
    }
}
