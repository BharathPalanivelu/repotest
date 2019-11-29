package com.tencent.liteav.network;

import com.tencent.ijk.media.player.IjkMediaMeta;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class i {

    /* renamed from: a  reason: collision with root package name */
    protected JSONObject f31789a;

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public String f31790a;

        /* renamed from: b  reason: collision with root package name */
        public String f31791b;

        /* renamed from: c  reason: collision with root package name */
        public List<Integer> f31792c;
    }

    public i(JSONObject jSONObject) {
        this.f31789a = jSONObject;
    }

    public String a() {
        if (e() != null) {
            return e().f31793a;
        }
        if (c().size() != 0) {
            List<Integer> j = j();
            if (j != null) {
                for (j next : c()) {
                    if (j.contains(Integer.valueOf(next.a()))) {
                        return next.f31793a;
                    }
                }
            }
            return c().get(0).f31793a;
        } else if (d() != null) {
            return d().f31793a;
        } else {
            return null;
        }
    }

    public String b() {
        try {
            JSONObject jSONObject = this.f31789a.getJSONObject("coverInfo");
            if (jSONObject != null) {
                return jSONObject.getString("coverUrl");
            }
            return null;
        } catch (JSONException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public List<j> c() {
        ArrayList arrayList = new ArrayList();
        try {
            JSONArray jSONArray = this.f31789a.getJSONObject("videoInfo").getJSONArray("transcodeList");
            if (jSONArray != null) {
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i);
                    j jVar = new j();
                    jVar.f31793a = jSONObject.getString("url");
                    jVar.f31797e = jSONObject.getInt("duration");
                    jVar.f31795c = jSONObject.getInt("width");
                    jVar.f31794b = jSONObject.getInt("height");
                    jVar.f31796d = Math.max(jSONObject.getInt("totalSize"), jSONObject.getInt("size"));
                    jVar.f31798f = jSONObject.getInt(IjkMediaMeta.IJKM_KEY_BITRATE);
                    jVar.i = jSONObject.getInt("definition");
                    jVar.f31799g = jSONObject.getString("container");
                    jVar.h = jSONObject.getString("templateName");
                    arrayList.add(jVar);
                }
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return arrayList;
    }

    public j d() {
        try {
            JSONObject jSONObject = this.f31789a.getJSONObject("videoInfo").getJSONObject("sourceVideo");
            j jVar = new j();
            jVar.f31793a = jSONObject.getString("url");
            jVar.f31797e = jSONObject.getInt("duration");
            jVar.f31795c = jSONObject.getInt("width");
            jVar.f31794b = jSONObject.getInt("height");
            jVar.f31796d = Math.max(jSONObject.getInt("size"), jSONObject.getInt("totalSize"));
            jVar.f31798f = jSONObject.getInt(IjkMediaMeta.IJKM_KEY_BITRATE);
            return jVar;
        } catch (JSONException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public j e() {
        try {
            JSONObject jSONObject = this.f31789a.getJSONObject("videoInfo").getJSONObject("masterPlayList");
            j jVar = new j();
            jVar.f31793a = jSONObject.getString("url");
            return jVar;
        } catch (JSONException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public String f() {
        try {
            JSONObject jSONObject = this.f31789a.getJSONObject("videoInfo").getJSONObject("basicInfo");
            if (jSONObject != null) {
                return jSONObject.getString("name");
            }
            return null;
        } catch (JSONException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public String g() {
        try {
            JSONObject jSONObject = this.f31789a.getJSONObject("videoInfo").getJSONObject("basicInfo");
            if (jSONObject != null) {
                return jSONObject.getString("description");
            }
            return null;
        } catch (JSONException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public String h() {
        try {
            return this.f31789a.getJSONObject("playerInfo").getString("defaultVideoClassification");
        } catch (JSONException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public List<a> i() {
        try {
            ArrayList arrayList = new ArrayList();
            JSONArray jSONArray = this.f31789a.getJSONObject("playerInfo").getJSONArray("videoClassification");
            for (int i = 0; i < jSONArray.length(); i++) {
                a aVar = new a();
                aVar.f31790a = jSONArray.getJSONObject(i).getString("id");
                aVar.f31791b = jSONArray.getJSONObject(i).getString("name");
                aVar.f31792c = new ArrayList();
                JSONArray jSONArray2 = jSONArray.getJSONObject(i).getJSONArray("definitionList");
                for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                    aVar.f31792c.add(Integer.valueOf(jSONArray2.getInt(i2)));
                }
                arrayList.add(aVar);
            }
            return arrayList;
        } catch (JSONException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public List<Integer> j() {
        List<a> i = i();
        String h = h();
        if (h == null || i == null) {
            return null;
        }
        for (a next : i) {
            if (next.f31790a.equals(h)) {
                return next.f31792c;
            }
        }
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0027  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.tencent.liteav.network.j a(java.lang.String r5, java.lang.String r6) {
        /*
            r4 = this;
            java.util.List r0 = r4.i()
            r1 = 0
            if (r5 == 0) goto L_0x0024
            if (r0 == 0) goto L_0x0024
            java.util.Iterator r0 = r0.iterator()
        L_0x000d:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x0024
            java.lang.Object r2 = r0.next()
            com.tencent.liteav.network.i$a r2 = (com.tencent.liteav.network.i.a) r2
            java.lang.String r3 = r2.f31790a
            boolean r3 = r3.equals(r5)
            if (r3 == 0) goto L_0x000d
            java.util.List<java.lang.Integer> r5 = r2.f31792c
            goto L_0x0025
        L_0x0024:
            r5 = r1
        L_0x0025:
            if (r5 == 0) goto L_0x0058
            java.util.List r0 = r4.c()
            java.util.Iterator r0 = r0.iterator()
        L_0x002f:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x0058
            java.lang.Object r2 = r0.next()
            com.tencent.liteav.network.j r2 = (com.tencent.liteav.network.j) r2
            int r3 = r2.i
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            boolean r3 = r5.contains(r3)
            if (r3 == 0) goto L_0x002f
            java.lang.String r3 = r2.e()
            if (r3 == 0) goto L_0x0057
            java.lang.String r3 = r2.e()
            boolean r3 = r3.contains(r6)
            if (r3 == 0) goto L_0x002f
        L_0x0057:
            return r2
        L_0x0058:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.liteav.network.i.a(java.lang.String, java.lang.String):com.tencent.liteav.network.j");
    }

    public j b(String str, String str2) {
        if (str == null) {
            return null;
        }
        for (j next : c()) {
            if (str.equals(next.f()) && (next.e() == null || next.e().contains(str2))) {
                return next;
            }
        }
        return null;
    }
}
