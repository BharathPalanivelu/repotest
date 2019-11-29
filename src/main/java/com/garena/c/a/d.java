package com.garena.c.a;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class d {

    /* renamed from: a  reason: collision with root package name */
    private List<a> f7811a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    private boolean f7812b;

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public String f7813a;

        /* renamed from: b  reason: collision with root package name */
        public List<String> f7814b;
    }

    public d(String str) {
        try {
            a(str);
        } catch (JSONException e2) {
            com.garena.android.appkit.d.a.a(e2);
        }
    }

    public List<a> a() {
        return this.f7811a;
    }

    private void a(String str) throws JSONException {
        JSONObject jSONObject = new JSONObject(str);
        String string = jSONObject.getString("status");
        if (string != null) {
            this.f7812b = string.equals("OK");
        }
        JSONArray jSONArray = jSONObject.getJSONArray("results");
        if (jSONArray != null) {
            for (int i = 0; !jSONArray.isNull(i); i++) {
                this.f7811a.add(a(jSONArray.getJSONObject(i)));
            }
        }
    }

    private a a(JSONObject jSONObject) throws JSONException {
        a aVar = new a();
        aVar.f7813a = jSONObject.getString("formatted_address");
        JSONArray jSONArray = jSONObject.getJSONArray("types");
        aVar.f7814b = new ArrayList();
        if (jSONArray != null) {
            for (int i = 0; !jSONArray.isNull(i); i++) {
                aVar.f7814b.add(jSONArray.getString(i));
            }
        }
        return aVar;
    }

    public boolean b() {
        return this.f7812b;
    }
}
