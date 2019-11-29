package io.a.a.a.a.g;

import android.content.res.Resources;
import com.tencent.cos.xml.common.COSRequestHeaderKey;
import io.a.a.a.a.b.s;
import io.a.a.a.a.e.c;
import io.a.a.a.a.e.d;
import io.a.a.a.a.e.e;
import io.a.a.a.i;
import io.a.a.a.k;
import io.a.a.a.l;
import java.io.Closeable;
import java.io.InputStream;
import java.util.Locale;

abstract class a extends io.a.a.a.a.b.a {
    public a(i iVar, String str, String str2, e eVar, c cVar) {
        super(iVar, str, str2, eVar, cVar);
    }

    public boolean a(d dVar) {
        d b2 = b(a(b(), dVar), dVar);
        l h = io.a.a.a.c.h();
        h.a("Fabric", "Sending app info to " + a());
        if (dVar.j != null) {
            l h2 = io.a.a.a.c.h();
            h2.a("Fabric", "App icon hash is " + dVar.j.f33239a);
            l h3 = io.a.a.a.c.h();
            h3.a("Fabric", "App icon size is " + dVar.j.f33241c + "x" + dVar.j.f33242d);
        }
        int b3 = b2.b();
        String str = "POST".equals(b2.p()) ? "Create" : "Update";
        l h4 = io.a.a.a.c.h();
        h4.a("Fabric", str + " app request ID: " + b2.b("X-REQUEST-ID"));
        l h5 = io.a.a.a.c.h();
        h5.a("Fabric", "Result was " + b3);
        return s.a(b3) == 0;
    }

    private d a(d dVar, d dVar2) {
        return dVar.a("X-CRASHLYTICS-API-KEY", dVar2.f33211a).a("X-CRASHLYTICS-API-CLIENT-TYPE", "android").a("X-CRASHLYTICS-API-CLIENT-VERSION", this.f33052a.a());
    }

    private d b(d dVar, d dVar2) {
        d e2 = dVar.e("app[identifier]", dVar2.f33212b).e("app[name]", dVar2.f33216f).e("app[display_version]", dVar2.f33213c).e("app[build_version]", dVar2.f33214d).a("app[source]", (Number) Integer.valueOf(dVar2.f33217g)).e("app[minimum_sdk_version]", dVar2.h).e("app[built_sdk_version]", dVar2.i);
        if (!io.a.a.a.a.b.i.d(dVar2.f33215e)) {
            e2.e("app[instance_identifier]", dVar2.f33215e);
        }
        if (dVar2.j != null) {
            InputStream inputStream = null;
            try {
                inputStream = this.f33052a.r().getResources().openRawResource(dVar2.j.f33240b);
                e2.e("app[icon][hash]", dVar2.j.f33239a).a("app[icon][data]", "icon.png", COSRequestHeaderKey.APPLICATION_OCTET_STREAM, inputStream).a("app[icon][width]", (Number) Integer.valueOf(dVar2.j.f33241c)).a("app[icon][height]", (Number) Integer.valueOf(dVar2.j.f33242d));
            } catch (Resources.NotFoundException e3) {
                l h = io.a.a.a.c.h();
                h.e("Fabric", "Failed to find app icon with resource ID: " + dVar2.j.f33240b, e3);
            } catch (Throwable th) {
                io.a.a.a.a.b.i.a((Closeable) inputStream, "Failed to close app icon InputStream.");
                throw th;
            }
            io.a.a.a.a.b.i.a((Closeable) inputStream, "Failed to close app icon InputStream.");
        }
        if (dVar2.k != null) {
            for (k next : dVar2.k) {
                e2.e(a(next), next.b());
                e2.e(b(next), next.c());
            }
        }
        return e2;
    }

    /* access modifiers changed from: package-private */
    public String a(k kVar) {
        return String.format(Locale.US, "app[build][libraries][%s][version]", new Object[]{kVar.a()});
    }

    /* access modifiers changed from: package-private */
    public String b(k kVar) {
        return String.format(Locale.US, "app[build][libraries][%s][type]", new Object[]{kVar.a()});
    }
}
