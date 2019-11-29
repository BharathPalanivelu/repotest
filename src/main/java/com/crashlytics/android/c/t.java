package com.crashlytics.android.c;

import com.tencent.cos.xml.common.COSRequestHeaderKey;
import io.a.a.a.a.b.a;
import io.a.a.a.a.b.s;
import io.a.a.a.a.e.c;
import io.a.a.a.a.e.d;
import io.a.a.a.a.e.e;
import io.a.a.a.i;
import io.a.a.a.l;
import java.io.File;
import java.util.Map;

class t extends a implements s {
    public t(i iVar, String str, String str2, e eVar) {
        super(iVar, str, str2, eVar, c.POST);
    }

    public boolean a(r rVar) {
        d a2 = a(a(b(), rVar), rVar.f6591b);
        l h = io.a.a.a.c.h();
        h.a("CrashlyticsCore", "Sending report to: " + a());
        int b2 = a2.b();
        l h2 = io.a.a.a.c.h();
        h2.a("CrashlyticsCore", "Create report request ID: " + a2.b("X-REQUEST-ID"));
        l h3 = io.a.a.a.c.h();
        h3.a("CrashlyticsCore", "Result was: " + b2);
        return s.a(b2) == 0;
    }

    private d a(d dVar, r rVar) {
        d a2 = dVar.a("X-CRASHLYTICS-API-KEY", rVar.f6590a).a("X-CRASHLYTICS-API-CLIENT-TYPE", "android").a("X-CRASHLYTICS-API-CLIENT-VERSION", this.f33052a.a());
        for (Map.Entry<String, String> a3 : rVar.f6591b.e().entrySet()) {
            a2 = a2.a(a3);
        }
        return a2;
    }

    private d a(d dVar, am amVar) {
        dVar.e("report[identifier]", amVar.b());
        if (amVar.d().length == 1) {
            io.a.a.a.c.h().a("CrashlyticsCore", "Adding single file " + amVar.a() + " to report " + amVar.b());
            return dVar.a("report[file]", amVar.a(), COSRequestHeaderKey.APPLICATION_OCTET_STREAM, amVar.c());
        }
        int i = 0;
        for (File file : amVar.d()) {
            io.a.a.a.c.h().a("CrashlyticsCore", "Adding file " + file.getName() + " to report " + amVar.b());
            StringBuilder sb = new StringBuilder();
            sb.append("report[file");
            sb.append(i);
            sb.append("]");
            dVar.a(sb.toString(), file.getName(), COSRequestHeaderKey.APPLICATION_OCTET_STREAM, file);
            i++;
        }
        return dVar;
    }
}
