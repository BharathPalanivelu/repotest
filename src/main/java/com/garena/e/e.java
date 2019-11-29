package com.garena.e;

import com.beetalk.sdk.e.a;
import org.json.JSONException;
import org.json.JSONObject;

public class e implements f<b, JSONObject> {
    public JSONObject a(b bVar) {
        try {
            return new JSONObject(bVar.a());
        } catch (JSONException e2) {
            a.a((Exception) e2);
            return null;
        }
    }
}
