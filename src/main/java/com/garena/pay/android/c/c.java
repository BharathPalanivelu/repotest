package com.garena.pay.android.c;

import android.text.TextUtils;
import com.appsflyer.AppsFlyerProperties;
import com.beetalk.sdk.e.a;
import com.garena.pay.android.a.b;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class c {
    public static List<b.C0136b> a(String str) {
        try {
            List<b.C0136b> a2 = a(new JSONObject(str).getJSONArray("channels"));
            ArrayList arrayList = new ArrayList();
            for (b.C0136b next : a2) {
                if (next.b()) {
                    arrayList.add(next);
                } else {
                    List<b.a> a3 = next.a();
                    ArrayList arrayList2 = new ArrayList();
                    for (b.a next2 : a3) {
                        if (next2.h() == 0) {
                            arrayList2.add(next2);
                        }
                    }
                    next.a((List<b.a>) arrayList2);
                    arrayList.add(next);
                }
            }
            return arrayList;
        } catch (JSONException e2) {
            a.a((Exception) e2);
            return null;
        }
    }

    private static List<b.C0136b> a(JSONArray jSONArray) throws JSONException {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObject = jSONArray.getJSONObject(i);
            int i2 = jSONObject.getInt(AppsFlyerProperties.CHANNEL);
            String string = jSONObject.getString("name");
            String string2 = jSONObject.getString("icon");
            float f2 = (float) jSONObject.getDouble("discount");
            String string3 = jSONObject.getString("description");
            String optString = jSONObject.optString("currency_icon", "");
            List<b.a> a2 = a(jSONObject);
            if (!TextUtils.isEmpty(optString) && a2 != null && a2.size() > 0) {
                for (b.a a3 : a2) {
                    a3.a(optString);
                }
            }
            b.C0136b bVar = new b.C0136b();
            bVar.b(String.valueOf(i2));
            bVar.c(string);
            bVar.d(string2);
            bVar.a(f2);
            bVar.e(string3);
            bVar.a(a2);
            arrayList.add(bVar);
        }
        return arrayList;
    }

    public static List<b.C0136b> a(String str, Long l) {
        if (l.longValue() == 0) {
            return a(str);
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            List<b.C0136b> a2 = a(jSONObject.getJSONArray("channels"));
            List<com.garena.pay.android.a.c> b2 = b(jSONObject);
            ArrayList arrayList = new ArrayList();
            for (b.C0136b next : a2) {
                if (!next.b()) {
                    List<b.a> a3 = next.a();
                    ArrayList arrayList2 = new ArrayList();
                    if (a3 != null) {
                        for (b.a next2 : a3) {
                            if (next2.h() > 0 && next2.h() == l.longValue() && a(next2.h(), b2)) {
                                arrayList2.add(next2);
                            }
                        }
                    }
                    if (arrayList2.size() > 0) {
                        next.a((List<b.a>) arrayList2);
                        arrayList.add(next);
                    }
                }
            }
            return arrayList;
        } catch (JSONException e2) {
            a.a((Exception) e2);
            return null;
        }
    }

    private static boolean a(long j, List<com.garena.pay.android.a.c> list) {
        if (list == null) {
            return false;
        }
        for (com.garena.pay.android.a.c next : list) {
            if (next.a() == j && next.b()) {
                return true;
            }
        }
        return false;
    }

    private static List<com.garena.pay.android.a.c> b(JSONObject jSONObject) {
        try {
            JSONArray jSONArray = jSONObject.getJSONArray("rebates");
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                com.garena.pay.android.a.c cVar = new com.garena.pay.android.a.c();
                cVar.a(jSONObject2.getLong("id"));
                cVar.a(jSONObject2.getBoolean("valid"));
                cVar.a(jSONObject2.getInt("rebate_days"));
                cVar.a(jSONObject2.getDouble("rebate_amount"));
                cVar.b(jSONObject2.getString("name"));
                cVar.a(jSONObject2.getString("description"));
                arrayList.add(cVar);
            }
            return arrayList;
        } catch (JSONException e2) {
            a.a((Exception) e2);
            return null;
        }
    }

    public static List<b.a> a(JSONObject jSONObject) throws JSONException {
        JSONArray jSONArray;
        ArrayList arrayList = new ArrayList();
        try {
            jSONArray = jSONObject.getJSONArray("items");
        } catch (JSONException e2) {
            e2.printStackTrace();
            jSONArray = null;
        }
        if (jSONArray != null) {
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                String string = jSONObject2.getString("name");
                String string2 = jSONObject2.getString("icon");
                String string3 = jSONObject2.getString("id");
                Integer valueOf = Integer.valueOf(jSONObject2.getInt("app_point_amount"));
                String string4 = jSONObject2.getString("price");
                boolean optBoolean = jSONObject2.optBoolean("promo", false);
                long optLong = jSONObject2.optLong("rebate_card_id", 0);
                b.a aVar = new b.a(string, string3, valueOf, string2, string4, optBoolean);
                aVar.a(optLong);
                arrayList.add(aVar);
            }
        }
        return arrayList;
    }
}
