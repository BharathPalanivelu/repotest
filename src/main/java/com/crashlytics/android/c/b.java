package com.crashlytics.android.c;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import io.a.a.a.c;
import java.io.File;
import java.io.IOException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class b {

    /* renamed from: a  reason: collision with root package name */
    private final Context f6455a;

    /* renamed from: b  reason: collision with root package name */
    private final a f6456b;

    interface a {
        String a(File file) throws IOException;
    }

    b(Context context, a aVar) {
        this.f6455a = context;
        this.f6456b = aVar;
    }

    /* access modifiers changed from: package-private */
    public byte[] a(String str) throws IOException {
        return a(b(str));
    }

    private JSONArray b(String str) {
        JSONArray jSONArray = new JSONArray();
        try {
            String[] split = b(new JSONObject(str).getJSONArray("maps")).split("\\|");
            for (String a2 : split) {
                ai a3 = aj.a(a2);
                if (a3 != null && a(a3)) {
                    try {
                        try {
                            jSONArray.put(a(this.f6456b.a(c(a3.f6415d)), a3));
                        } catch (JSONException e2) {
                            c.h().a("CrashlyticsCore", "Could not create a binary image json string", (Throwable) e2);
                        }
                    } catch (IOException e3) {
                        c.h().a("CrashlyticsCore", "Could not generate ID for file " + a3.f6415d, (Throwable) e3);
                    }
                }
            }
            return jSONArray;
        } catch (JSONException e4) {
            c.h().d("CrashlyticsCore", "Unable to parse proc maps string", e4);
            return jSONArray;
        }
    }

    private File c(String str) {
        File file = new File(str);
        return !file.exists() ? a(file) : file;
    }

    private File a(File file) {
        if (Build.VERSION.SDK_INT < 9 || !file.getAbsolutePath().startsWith("/data")) {
            return file;
        }
        try {
            return new File(this.f6455a.getPackageManager().getApplicationInfo(this.f6455a.getPackageName(), 0).nativeLibraryDir, file.getName());
        } catch (PackageManager.NameNotFoundException e2) {
            c.h().e("CrashlyticsCore", "Error getting ApplicationInfo", e2);
            return file;
        }
    }

    private static byte[] a(JSONArray jSONArray) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("binary_images", jSONArray);
            return jSONObject.toString().getBytes();
        } catch (JSONException e2) {
            c.h().d("CrashlyticsCore", "Binary images string is null", e2);
            return new byte[0];
        }
    }

    private static JSONObject a(String str, ai aiVar) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("base_address", aiVar.f6412a);
        jSONObject.put("size", aiVar.f6413b);
        jSONObject.put("name", aiVar.f6415d);
        jSONObject.put("uuid", str);
        return jSONObject;
    }

    private static String b(JSONArray jSONArray) throws JSONException {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < jSONArray.length(); i++) {
            sb.append(jSONArray.getString(i));
        }
        return sb.toString();
    }

    private static boolean a(ai aiVar) {
        return (aiVar.f6414c.indexOf(120) == -1 || aiVar.f6415d.indexOf(47) == -1) ? false : true;
    }
}
