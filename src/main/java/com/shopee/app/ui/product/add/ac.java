package com.shopee.app.ui.product.add;

import com.facebook.AccessToken;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.shopee.app.d.c.a;
import com.shopee.app.util.n;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public class ac extends a {
    /* access modifiers changed from: protected */
    public String d() {
        return "GetFacebookPageListInteractor";
    }

    protected ac(n nVar) {
        super(nVar);
    }

    /* access modifiers changed from: protected */
    public void c() {
        com.garena.android.appkit.d.a.e("start getting images...", new Object[0]);
        GraphRequest.newGraphPathRequest(AccessToken.getCurrentAccessToken(), "/me/accounts", new GraphRequest.Callback() {
            public void onCompleted(GraphResponse graphResponse) {
                ArrayList arrayList = new ArrayList();
                try {
                    JSONArray jSONArray = (JSONArray) graphResponse.getJSONObject().get("data");
                    if (jSONArray != null) {
                        for (int i = 0; i < jSONArray.length(); i++) {
                            JSONObject jSONObject = (JSONObject) jSONArray.get(i);
                            t tVar = new t();
                            tVar.a(jSONObject.getString("name"));
                            tVar.b(jSONObject.getString("access_token"));
                            tVar.c(jSONObject.getString("id"));
                            arrayList.add(tVar);
                        }
                    }
                } catch (Exception e2) {
                    com.garena.android.appkit.d.a.a(e2);
                }
                ac.this.f16402a.a().br.a(arrayList).a();
            }
        }).executeAsync();
    }
}
