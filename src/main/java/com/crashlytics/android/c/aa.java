package com.crashlytics.android.c;

import com.appsflyer.AppsFlyerProperties;
import io.a.a.a.a.b.i;
import io.a.a.a.c;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

class aa {

    /* renamed from: a  reason: collision with root package name */
    private static final Charset f6403a = Charset.forName("UTF-8");

    /* renamed from: b  reason: collision with root package name */
    private final File f6404b;

    public aa(File file) {
        this.f6404b = file;
    }

    public void a(String str, au auVar) {
        File b2 = b(str);
        BufferedWriter bufferedWriter = null;
        try {
            String a2 = a(auVar);
            BufferedWriter bufferedWriter2 = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(b2), f6403a));
            try {
                bufferedWriter2.write(a2);
                bufferedWriter2.flush();
                i.a((Closeable) bufferedWriter2, "Failed to close user metadata file.");
            } catch (Exception e2) {
                e = e2;
                bufferedWriter = bufferedWriter2;
                try {
                    c.h().e("CrashlyticsCore", "Error serializing user metadata.", e);
                    i.a((Closeable) bufferedWriter, "Failed to close user metadata file.");
                } catch (Throwable th) {
                    th = th;
                    i.a((Closeable) bufferedWriter, "Failed to close user metadata file.");
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                bufferedWriter = bufferedWriter2;
                i.a((Closeable) bufferedWriter, "Failed to close user metadata file.");
                throw th;
            }
        } catch (Exception e3) {
            e = e3;
            c.h().e("CrashlyticsCore", "Error serializing user metadata.", e);
            i.a((Closeable) bufferedWriter, "Failed to close user metadata file.");
        }
    }

    public au a(String str) {
        File b2 = b(str);
        if (!b2.exists()) {
            return au.f6446a;
        }
        FileInputStream fileInputStream = null;
        try {
            FileInputStream fileInputStream2 = new FileInputStream(b2);
            try {
                au d2 = d(i.a((InputStream) fileInputStream2));
                i.a((Closeable) fileInputStream2, "Failed to close user metadata file.");
                return d2;
            } catch (Exception e2) {
                e = e2;
                fileInputStream = fileInputStream2;
                try {
                    c.h().e("CrashlyticsCore", "Error deserializing user metadata.", e);
                    i.a((Closeable) fileInputStream, "Failed to close user metadata file.");
                    return au.f6446a;
                } catch (Throwable th) {
                    th = th;
                    i.a((Closeable) fileInputStream, "Failed to close user metadata file.");
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                fileInputStream = fileInputStream2;
                i.a((Closeable) fileInputStream, "Failed to close user metadata file.");
                throw th;
            }
        } catch (Exception e3) {
            e = e3;
            c.h().e("CrashlyticsCore", "Error deserializing user metadata.", e);
            i.a((Closeable) fileInputStream, "Failed to close user metadata file.");
            return au.f6446a;
        }
    }

    public void a(String str, Map<String, String> map) {
        File c2 = c(str);
        BufferedWriter bufferedWriter = null;
        try {
            String a2 = a(map);
            BufferedWriter bufferedWriter2 = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(c2), f6403a));
            try {
                bufferedWriter2.write(a2);
                bufferedWriter2.flush();
                i.a((Closeable) bufferedWriter2, "Failed to close key/value metadata file.");
            } catch (Exception e2) {
                e = e2;
                bufferedWriter = bufferedWriter2;
                try {
                    c.h().e("CrashlyticsCore", "Error serializing key/value metadata.", e);
                    i.a((Closeable) bufferedWriter, "Failed to close key/value metadata file.");
                } catch (Throwable th) {
                    th = th;
                    i.a((Closeable) bufferedWriter, "Failed to close key/value metadata file.");
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                bufferedWriter = bufferedWriter2;
                i.a((Closeable) bufferedWriter, "Failed to close key/value metadata file.");
                throw th;
            }
        } catch (Exception e3) {
            e = e3;
            c.h().e("CrashlyticsCore", "Error serializing key/value metadata.", e);
            i.a((Closeable) bufferedWriter, "Failed to close key/value metadata file.");
        }
    }

    public File b(String str) {
        File file = this.f6404b;
        return new File(file, str + "user" + ".meta");
    }

    public File c(String str) {
        File file = this.f6404b;
        return new File(file, str + "keys" + ".meta");
    }

    private static au d(String str) throws JSONException {
        JSONObject jSONObject = new JSONObject(str);
        return new au(a(jSONObject, "userId"), a(jSONObject, "userName"), a(jSONObject, AppsFlyerProperties.USER_EMAIL));
    }

    private static String a(final au auVar) throws JSONException {
        return new JSONObject() {
            {
                put("userId", auVar.f6447b);
                put("userName", auVar.f6448c);
                put(AppsFlyerProperties.USER_EMAIL, auVar.f6449d);
            }
        }.toString();
    }

    private static String a(Map<String, String> map) throws JSONException {
        return new JSONObject(map).toString();
    }

    private static String a(JSONObject jSONObject, String str) {
        if (!jSONObject.isNull(str)) {
            return jSONObject.optString(str, (String) null);
        }
        return null;
    }
}
