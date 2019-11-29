package io.a.a.a.a.g;

import io.a.a.a.a.f.b;
import io.a.a.a.c;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStream;
import org.json.JSONObject;

class i implements g {

    /* renamed from: a  reason: collision with root package name */
    private final io.a.a.a.i f33227a;

    public i(io.a.a.a.i iVar) {
        this.f33227a = iVar;
    }

    public JSONObject a() {
        Throwable th;
        FileInputStream fileInputStream;
        JSONObject jSONObject;
        c.h().a("Fabric", "Reading cached settings...");
        FileInputStream fileInputStream2 = null;
        try {
            File file = new File(new b(this.f33227a).a(), "com.crashlytics.settings.json");
            if (file.exists()) {
                fileInputStream = new FileInputStream(file);
                try {
                    jSONObject = new JSONObject(io.a.a.a.a.b.i.a((InputStream) fileInputStream));
                    fileInputStream2 = fileInputStream;
                } catch (Exception e2) {
                    e = e2;
                    try {
                        c.h().e("Fabric", "Failed to fetch cached settings", e);
                        io.a.a.a.a.b.i.a((Closeable) fileInputStream, "Error while closing settings cache file.");
                        return null;
                    } catch (Throwable th2) {
                        th = th2;
                        fileInputStream2 = fileInputStream;
                        io.a.a.a.a.b.i.a((Closeable) fileInputStream2, "Error while closing settings cache file.");
                        throw th;
                    }
                }
            } else {
                c.h().a("Fabric", "No cached settings found.");
                jSONObject = null;
            }
            io.a.a.a.a.b.i.a((Closeable) fileInputStream2, "Error while closing settings cache file.");
            return jSONObject;
        } catch (Exception e3) {
            e = e3;
            fileInputStream = null;
            c.h().e("Fabric", "Failed to fetch cached settings", e);
            io.a.a.a.a.b.i.a((Closeable) fileInputStream, "Error while closing settings cache file.");
            return null;
        } catch (Throwable th3) {
            th = th3;
            io.a.a.a.a.b.i.a((Closeable) fileInputStream2, "Error while closing settings cache file.");
            throw th;
        }
    }

    public void a(long j, JSONObject jSONObject) {
        c.h().a("Fabric", "Writing settings to cache file...");
        if (jSONObject != null) {
            FileWriter fileWriter = null;
            try {
                jSONObject.put("expires_at", j);
                FileWriter fileWriter2 = new FileWriter(new File(new b(this.f33227a).a(), "com.crashlytics.settings.json"));
                try {
                    fileWriter2.write(jSONObject.toString());
                    fileWriter2.flush();
                    io.a.a.a.a.b.i.a((Closeable) fileWriter2, "Failed to close settings writer.");
                } catch (Exception e2) {
                    e = e2;
                    fileWriter = fileWriter2;
                    try {
                        c.h().e("Fabric", "Failed to cache settings", e);
                        io.a.a.a.a.b.i.a((Closeable) fileWriter, "Failed to close settings writer.");
                    } catch (Throwable th) {
                        th = th;
                        io.a.a.a.a.b.i.a((Closeable) fileWriter, "Failed to close settings writer.");
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    fileWriter = fileWriter2;
                    io.a.a.a.a.b.i.a((Closeable) fileWriter, "Failed to close settings writer.");
                    throw th;
                }
            } catch (Exception e3) {
                e = e3;
                c.h().e("Fabric", "Failed to cache settings", e);
                io.a.a.a.a.b.i.a((Closeable) fileWriter, "Failed to close settings writer.");
            }
        }
    }
}
