package com.google.firebase.iid;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import com.appsflyer.AppsFlyerProperties;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.b;
import com.google.firebase.c.g;
import java.io.IOException;
import java.util.concurrent.Executor;

final class au implements b {

    /* renamed from: a  reason: collision with root package name */
    private final b f14137a;

    /* renamed from: b  reason: collision with root package name */
    private final q f14138b;

    /* renamed from: c  reason: collision with root package name */
    private final x f14139c;

    /* renamed from: d  reason: collision with root package name */
    private final Executor f14140d;

    /* renamed from: e  reason: collision with root package name */
    private final g f14141e;

    au(b bVar, q qVar, Executor executor, g gVar) {
        this(bVar, qVar, executor, new x(bVar.a(), qVar), gVar);
    }

    public final boolean b() {
        return false;
    }

    private au(b bVar, q qVar, Executor executor, x xVar, g gVar) {
        this.f14137a = bVar;
        this.f14138b = qVar;
        this.f14139c = xVar;
        this.f14140d = executor;
        this.f14141e = gVar;
    }

    public final boolean a() {
        return this.f14138b.a() != 0;
    }

    public final Task<String> a(String str, String str2, String str3, String str4) {
        return b(a(str, str3, str4, new Bundle()));
    }

    public final Task<Void> b(String str, String str2, String str3, String str4) {
        Bundle bundle = new Bundle();
        bundle.putString("delete", "1");
        return a(b(a(str, str3, str4, bundle)));
    }

    public final Task<Void> a(String str) {
        Bundle bundle = new Bundle();
        bundle.putString("iid-operation", "delete");
        bundle.putString("delete", "1");
        return a(b(a(str, "*", "*", bundle)));
    }

    public final Task<Void> a(String str, String str2, String str3) {
        Bundle bundle = new Bundle();
        String valueOf = String.valueOf(str3);
        bundle.putString("gcm.topic", valueOf.length() != 0 ? "/topics/".concat(valueOf) : new String("/topics/"));
        String valueOf2 = String.valueOf(str3);
        return a(b(a(str, str2, valueOf2.length() != 0 ? "/topics/".concat(valueOf2) : new String("/topics/"), bundle)));
    }

    public final Task<Void> b(String str, String str2, String str3) {
        Bundle bundle = new Bundle();
        String valueOf = String.valueOf(str3);
        bundle.putString("gcm.topic", valueOf.length() != 0 ? "/topics/".concat(valueOf) : new String("/topics/"));
        bundle.putString("delete", "1");
        String valueOf2 = String.valueOf(str3);
        return a(b(a(str, str2, valueOf2.length() != 0 ? "/topics/".concat(valueOf2) : new String("/topics/"), bundle)));
    }

    private final Task<Bundle> a(String str, String str2, String str3, Bundle bundle) {
        bundle.putString("scope", str3);
        bundle.putString("sender", str2);
        bundle.putString("subtype", str2);
        bundle.putString(AppsFlyerProperties.APP_ID, str);
        bundle.putString("gmp_app_id", this.f14137a.c().b());
        bundle.putString("gmsv", Integer.toString(this.f14138b.d()));
        bundle.putString("osv", Integer.toString(Build.VERSION.SDK_INT));
        bundle.putString("app_ver", this.f14138b.b());
        bundle.putString("app_ver_name", this.f14138b.c());
        bundle.putString("cliv", "fiid-12451000");
        bundle.putString("Firebase-Client", this.f14141e.a());
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        this.f14140d.execute(new at(this, bundle, taskCompletionSource));
        return taskCompletionSource.getTask();
    }

    /* access modifiers changed from: private */
    public static String a(Bundle bundle) throws IOException {
        if (bundle != null) {
            String string = bundle.getString("registration_id");
            if (string != null) {
                return string;
            }
            String string2 = bundle.getString("unregistered");
            if (string2 != null) {
                return string2;
            }
            String string3 = bundle.getString("error");
            if ("RST".equals(string3)) {
                throw new IOException("INSTANCE_ID_RESET");
            } else if (string3 != null) {
                throw new IOException(string3);
            } else {
                String valueOf = String.valueOf(bundle);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 21);
                sb.append("Unexpected response: ");
                sb.append(valueOf);
                Log.w("FirebaseInstanceId", sb.toString(), new Throwable());
                throw new IOException("SERVICE_NOT_AVAILABLE");
            }
        } else {
            throw new IOException("SERVICE_NOT_AVAILABLE");
        }
    }

    private final <T> Task<Void> a(Task<T> task) {
        return task.continueWith(ak.a(), new aw(this));
    }

    private final Task<String> b(Task<Bundle> task) {
        return task.continueWith(this.f14140d, new av(this));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void a(Bundle bundle, TaskCompletionSource taskCompletionSource) {
        try {
            taskCompletionSource.setResult(this.f14139c.a(bundle));
        } catch (IOException e2) {
            taskCompletionSource.setException(e2);
        }
    }
}
