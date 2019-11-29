package com.crashlytics.android.c;

import com.salesforce.android.service.common.liveagentlogging.event.ErrorEvent;
import com.shopee.livequiz.data.bean.LiveParams;
import com.tencent.cos.xml.common.COSRequestHeaderKey;
import com.tencent.qcloud.core.http.HttpConstants;
import io.a.a.a.a.b.a;
import io.a.a.a.a.b.s;
import io.a.a.a.a.e.c;
import io.a.a.a.a.e.d;
import io.a.a.a.a.e.e;
import io.a.a.a.i;
import io.a.a.a.l;
import java.io.File;

class ad extends a implements s {
    public ad(i iVar, String str, String str2, e eVar) {
        super(iVar, str, str2, eVar, c.POST);
    }

    public boolean a(r rVar) {
        d a2 = a(a(b(), rVar.f6590a), rVar.f6591b);
        l h = io.a.a.a.c.h();
        h.a("CrashlyticsCore", "Sending report to: " + a());
        int b2 = a2.b();
        l h2 = io.a.a.a.c.h();
        h2.a("CrashlyticsCore", "Result was: " + b2);
        return s.a(b2) == 0;
    }

    private d a(d dVar, String str) {
        dVar.a(HttpConstants.Header.USER_AGENT, "Crashlytics Android SDK/" + this.f33052a.a()).a("X-CRASHLYTICS-API-CLIENT-TYPE", "android").a("X-CRASHLYTICS-API-CLIENT-VERSION", this.f33052a.a()).a("X-CRASHLYTICS-API-KEY", str);
        return dVar;
    }

    private d a(d dVar, am amVar) {
        dVar.e("report_id", amVar.b());
        for (File file : amVar.d()) {
            if (file.getName().equals("minidump")) {
                dVar.a("minidump_file", file.getName(), COSRequestHeaderKey.APPLICATION_OCTET_STREAM, file);
            } else if (file.getName().equals("metadata")) {
                dVar.a("crash_meta_file", file.getName(), COSRequestHeaderKey.APPLICATION_OCTET_STREAM, file);
            } else if (file.getName().equals("binaryImages")) {
                dVar.a("binary_images_file", file.getName(), COSRequestHeaderKey.APPLICATION_OCTET_STREAM, file);
            } else if (file.getName().equals(ErrorEvent.OPENTOK_DOMAIN_SESSION)) {
                dVar.a("session_meta_file", file.getName(), COSRequestHeaderKey.APPLICATION_OCTET_STREAM, file);
            } else if (file.getName().equals(LiveParams.SYNC_TYPE_APP)) {
                dVar.a("app_meta_file", file.getName(), COSRequestHeaderKey.APPLICATION_OCTET_STREAM, file);
            } else if (file.getName().equals("device")) {
                dVar.a("device_meta_file", file.getName(), COSRequestHeaderKey.APPLICATION_OCTET_STREAM, file);
            } else if (file.getName().equals("os")) {
                dVar.a("os_meta_file", file.getName(), COSRequestHeaderKey.APPLICATION_OCTET_STREAM, file);
            } else if (file.getName().equals("user")) {
                dVar.a("user_meta_file", file.getName(), COSRequestHeaderKey.APPLICATION_OCTET_STREAM, file);
            } else if (file.getName().equals("logs")) {
                dVar.a("logs_file", file.getName(), COSRequestHeaderKey.APPLICATION_OCTET_STREAM, file);
            } else if (file.getName().equals("keys")) {
                dVar.a("keys_file", file.getName(), COSRequestHeaderKey.APPLICATION_OCTET_STREAM, file);
            }
        }
        return dVar;
    }
}
