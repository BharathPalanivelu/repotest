package com.android.b.a;

import com.android.b.i;
import com.android.b.k;
import com.android.b.n;
import java.io.UnsupportedEncodingException;
import org.json.JSONException;
import org.json.JSONObject;

public class h extends i<JSONObject> {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public h(int i, String str, JSONObject jSONObject, n.b<JSONObject> bVar, n.a aVar) {
        super(i, str, jSONObject == null ? null : jSONObject.toString(), bVar, aVar);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public h(String str, JSONObject jSONObject, n.b<JSONObject> bVar, n.a aVar) {
        this(jSONObject == null ? 0 : 1, str, jSONObject, bVar, aVar);
    }

    /* access modifiers changed from: protected */
    public n<JSONObject> parseNetworkResponse(i iVar) {
        try {
            return n.a(new JSONObject(new String(iVar.f4613b, e.a(iVar.f4614c))), e.a(iVar));
        } catch (UnsupportedEncodingException e2) {
            return n.a(new k(e2));
        } catch (JSONException e3) {
            return n.a(new k(e3));
        }
    }
}
