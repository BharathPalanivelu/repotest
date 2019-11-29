package com.crashlytics.android.a;

import io.a.a.a.a.b.a;
import io.a.a.a.a.b.s;
import io.a.a.a.a.d.f;
import io.a.a.a.a.e.c;
import io.a.a.a.a.e.d;
import io.a.a.a.a.e.e;
import io.a.a.a.i;
import io.a.a.a.l;
import java.io.File;
import java.util.List;

class aa extends a implements f {

    /* renamed from: b  reason: collision with root package name */
    private final String f6277b;

    public aa(i iVar, String str, String str2, e eVar, String str3) {
        super(iVar, str, str2, eVar, c.POST);
        this.f6277b = str3;
    }

    public boolean a(List<File> list) {
        d a2 = b().a("X-CRASHLYTICS-API-CLIENT-TYPE", "android").a("X-CRASHLYTICS-API-CLIENT-VERSION", this.f33052a.a()).a("X-CRASHLYTICS-API-KEY", this.f6277b);
        int i = 0;
        for (File next : list) {
            a2.a("session_analytics_file_" + i, next.getName(), "application/vnd.crashlytics.android.events", next);
            i++;
        }
        l h = io.a.a.a.c.h();
        h.a("Answers", "Sending " + list.size() + " analytics files to " + a());
        int b2 = a2.b();
        l h2 = io.a.a.a.c.h();
        h2.a("Answers", "Response code for analytics file send is " + b2);
        if (s.a(b2) == 0) {
            return true;
        }
        return false;
    }
}
