package qalsdk;

import org.json.JSONObject;

public final class w {

    /* renamed from: a  reason: collision with root package name */
    public String f34198a;

    /* renamed from: b  reason: collision with root package name */
    public long f34199b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f34200c;

    public w() {
    }

    public w(String str, long j, boolean z) {
        this.f34198a = str;
        this.f34199b = j;
        this.f34200c = z;
    }

    public static w a(JSONObject jSONObject) {
        try {
            return new w(jSONObject.getString("ssid"), jSONObject.getLong("time"), jSONObject.getBoolean("available"));
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public final JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ssid", this.f34198a);
            jSONObject.put("time", this.f34199b);
            jSONObject.put("available", this.f34200c);
            return jSONObject;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }
}
