package com.garena.pay.android.d;

import org.json.JSONException;
import org.json.JSONObject;

public class g {

    /* renamed from: a  reason: collision with root package name */
    String f8220a;

    /* renamed from: b  reason: collision with root package name */
    String f8221b;

    /* renamed from: c  reason: collision with root package name */
    String f8222c;

    /* renamed from: d  reason: collision with root package name */
    String f8223d;

    /* renamed from: e  reason: collision with root package name */
    String f8224e;

    /* renamed from: f  reason: collision with root package name */
    String f8225f;

    /* renamed from: g  reason: collision with root package name */
    String f8226g;

    public g(String str, String str2) throws JSONException {
        this.f8220a = str;
        this.f8226g = str2;
        JSONObject jSONObject = new JSONObject(this.f8226g);
        this.f8221b = jSONObject.optString("productId");
        this.f8222c = jSONObject.optString("type");
        this.f8223d = jSONObject.optString("price");
        this.f8224e = jSONObject.optString("title");
        this.f8225f = jSONObject.optString("description");
    }

    public String a() {
        return this.f8221b;
    }

    public String toString() {
        return "SkuDetails:" + this.f8226g;
    }
}
