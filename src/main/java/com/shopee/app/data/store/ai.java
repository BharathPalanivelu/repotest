package com.shopee.app.data.store;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.garena.android.appkit.d.a;
import com.h.a.c;
import com.h.a.d;
import com.shopee.app.application.ar;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ai extends c<ai> {

    /* renamed from: a  reason: collision with root package name */
    private static HashMap<Integer, String> f17179a = new HashMap<>();

    /* renamed from: b  reason: collision with root package name */
    private static ai f17180b;

    static {
        f17179a.put(0, MessengerShareContentUtility.PREVIEW_DEFAULT);
        f17179a.put(1, "LATEST");
        f17179a.put(2, "POPULAR");
        f17179a.put(3, "STOCK");
        f17179a.put(4, "SOLDOUT");
        f17179a.put(5, "RECOMMEND");
        f17179a.put(6, "NEWEST");
        f17179a.put(7, "TOUCHTIME");
        f17179a.put(8, "STOCKOUT");
        f17179a.put(9, "UNLIST");
    }

    public ai(SharedPreferences sharedPreferences) {
        super(sharedPreferences);
    }

    public static synchronized ai a() {
        ai aiVar;
        synchronized (ai.class) {
            if (f17180b == null) {
                f17180b = new ai(ar.a().getSharedPreferences("itemTypeInfo", 0));
            }
            aiVar = f17180b;
        }
        return aiVar;
    }

    private List<Long> d(String str) {
        String str2 = (String) e(str).b("");
        ArrayList arrayList = new ArrayList();
        if (!TextUtils.isEmpty(str2)) {
            try {
                JSONArray jSONArray = new JSONObject(str2).getJSONArray(str);
                for (int i = 0; i < jSONArray.length(); i++) {
                    arrayList.add(Long.valueOf(jSONArray.getLong(i)));
                }
            } catch (JSONException e2) {
                a.a(e2);
            }
        }
        return arrayList;
    }

    private void a(String str, List<Long> list) {
        String str2;
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(str, new JSONArray(list));
            str2 = jSONObject.toString();
        } catch (JSONException e2) {
            a.a(e2);
            str2 = "";
        }
        e(str).a(str2).v();
    }

    private d<ai> e(String str) {
        return a(str);
    }

    public List<Long> a(int i) {
        return d(f17179a.get(Integer.valueOf(i)));
    }

    public void a(int i, List<Long> list) {
        a(f17179a.get(Integer.valueOf(i)), list);
    }

    public List<Integer> a(Long l) {
        ArrayList arrayList = new ArrayList();
        for (Integer intValue : f17179a.keySet()) {
            int intValue2 = intValue.intValue();
            List<Long> a2 = a(intValue2);
            if (a2.contains(l)) {
                arrayList.add(Integer.valueOf(intValue2));
                a2.remove(l);
                a().a(intValue2, a2);
            }
        }
        return arrayList;
    }
}
