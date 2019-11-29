package com.crashlytics.android.b;

import java.io.IOException;
import org.json.JSONObject;

class g {
    g() {
    }

    public f a(JSONObject jSONObject) throws IOException {
        if (jSONObject == null) {
            return null;
        }
        return new f(jSONObject.optString("url", (String) null), jSONObject.optString("version_string", (String) null), jSONObject.optString("display_version", (String) null), jSONObject.optString("build_version", (String) null), jSONObject.optString("identifier", (String) null), jSONObject.optString("instance_identifier", (String) null));
    }
}
