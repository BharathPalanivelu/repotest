package com.shopee.app.d.c;

import android.os.Bundle;
import com.facebook.AccessToken;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.HttpMethod;
import com.garena.android.appkit.b.a;
import com.shopee.app.data.store.aa;
import com.shopee.app.data.store.aj;
import com.shopee.app.data.store.be;
import com.shopee.app.database.orm.bean.DBContactLocalInfo;
import com.shopee.app.network.d.b.h;
import com.shopee.app.util.n;
import com.shopee.protocol.action.ContactMeta;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class am extends a {
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final n f16487c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final aa f16488d;

    /* renamed from: e  reason: collision with root package name */
    private final be f16489e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public final aj f16490f;

    /* access modifiers changed from: protected */
    public String d() {
        return "GetFBFriendListInteractor";
    }

    public am(n nVar, aa aaVar, be beVar, aj ajVar) {
        super(nVar);
        this.f16487c = nVar;
        this.f16488d = aaVar;
        this.f16489e = beVar;
        this.f16490f = ajVar;
    }

    /* access modifiers changed from: protected */
    public void c() {
        Bundle bundle = new Bundle();
        bundle.putString("limit", "5000");
        new GraphRequest(AccessToken.getCurrentAccessToken(), "/me/friends", bundle, HttpMethod.GET, new GraphRequest.Callback() {
            public void onCompleted(GraphResponse graphResponse) {
                try {
                    JSONObject jSONObject = graphResponse.getJSONObject();
                    if (jSONObject == null || !jSONObject.has("data")) {
                        am.this.f16487c.a("FACEBOOK_CONTACT_GET", new a(new ArrayList()));
                        return;
                    }
                    JSONArray optJSONArray = jSONObject.optJSONArray("data");
                    ArrayList<ContactMeta> arrayList = new ArrayList<>();
                    ArrayList arrayList2 = new ArrayList();
                    if (optJSONArray.length() > 0) {
                        int i = 0;
                        for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                            try {
                                JSONObject jSONObject2 = optJSONArray.getJSONObject(i2);
                                String string = jSONObject2.getString("id");
                                String string2 = jSONObject2.getString("name");
                                DBContactLocalInfo dBContactLocalInfo = new DBContactLocalInfo();
                                dBContactLocalInfo.a(string2);
                                dBContactLocalInfo.b(string + "FACEBOOK");
                                if (!am.this.f16490f.a(dBContactLocalInfo)) {
                                    arrayList2.add(dBContactLocalInfo);
                                    ContactMeta.Builder builder = new ContactMeta.Builder();
                                    builder.key(string).name(string2);
                                    arrayList.add(builder.build());
                                }
                            } catch (JSONException e2) {
                                com.garena.android.appkit.d.a.a(e2);
                            }
                        }
                        am.this.f16490f.a((List<DBContactLocalInfo>) arrayList2);
                        am.this.f16487c.a("FACEBOOK_CONTACT_GET", new a(arrayList));
                        ArrayList arrayList3 = new ArrayList();
                        for (ContactMeta add : arrayList) {
                            arrayList3.add(add);
                            if (arrayList3.size() == 200) {
                                h hVar = new h();
                                hVar.b(arrayList3);
                                hVar.a(am.this.f16488d.d());
                                hVar.a(am.this.f16488d.e());
                                hVar.g();
                                arrayList3.clear();
                            }
                            i++;
                            if (i == arrayList.size() && arrayList3.size() != 0) {
                                h hVar2 = new h();
                                hVar2.b(arrayList3);
                                hVar2.a(am.this.f16488d.d());
                                hVar2.a(am.this.f16488d.e());
                                hVar2.g();
                            }
                        }
                    }
                } catch (Exception unused) {
                    am.this.f16487c.a("FACEBOOK_CONTACT_GET", new a(new ArrayList()));
                }
            }
        }).executeAsync();
    }
}
