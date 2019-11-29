package io.a.a.a.a.b;

import com.tencent.qcloud.core.http.HttpConstants;
import io.a.a.a.a.e.c;
import io.a.a.a.a.e.d;
import io.a.a.a.a.e.e;
import io.a.a.a.i;
import java.util.Collections;
import java.util.Map;
import java.util.regex.Pattern;

public abstract class a {

    /* renamed from: b  reason: collision with root package name */
    private static final Pattern f33051b = Pattern.compile("http(s?)://[^\\/]+", 2);

    /* renamed from: a  reason: collision with root package name */
    protected final i f33052a;

    /* renamed from: c  reason: collision with root package name */
    private final String f33053c;

    /* renamed from: d  reason: collision with root package name */
    private final e f33054d;

    /* renamed from: e  reason: collision with root package name */
    private final c f33055e;

    /* renamed from: f  reason: collision with root package name */
    private final String f33056f;

    public a(i iVar, String str, String str2, e eVar, c cVar) {
        if (str2 == null) {
            throw new IllegalArgumentException("url must not be null.");
        } else if (eVar != null) {
            this.f33052a = iVar;
            this.f33056f = str;
            this.f33053c = a(str2);
            this.f33054d = eVar;
            this.f33055e = cVar;
        } else {
            throw new IllegalArgumentException("requestFactory must not be null.");
        }
    }

    /* access modifiers changed from: protected */
    public String a() {
        return this.f33053c;
    }

    /* access modifiers changed from: protected */
    public d b() {
        return a((Map<String, String>) Collections.emptyMap());
    }

    /* access modifiers changed from: protected */
    public d a(Map<String, String> map) {
        d a2 = this.f33054d.a(this.f33055e, a(), map).a(false).a(10000);
        return a2.a(HttpConstants.Header.USER_AGENT, "Crashlytics Android SDK/" + this.f33052a.a()).a("X-CRASHLYTICS-DEVELOPER-TOKEN", "470fa2b4ae81cd56ecbcda9735803434cec591fa");
    }

    private String a(String str) {
        return !i.d(this.f33056f) ? f33051b.matcher(str).replaceFirst(this.f33056f) : str;
    }
}
