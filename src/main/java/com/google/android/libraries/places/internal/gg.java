package com.google.android.libraries.places.internal;

import android.content.Context;
import com.android.b.m;
import com.android.b.s;
import com.google.android.gms.clearcut.ClearcutLogger;
import com.google.android.gms.tasks.CancellationToken;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.Map;
import org.json.JSONObject;

public class gg implements ny {

    /* renamed from: a  reason: collision with root package name */
    public final m f12618a;

    /* renamed from: b  reason: collision with root package name */
    public final dr f12619b;

    public static Context a(Context context) {
        return context.getApplicationContext();
    }

    public static ds a(ClearcutLogger clearcutLogger, dw dwVar, dz dzVar) {
        return new ds(clearcutLogger, dwVar, dzVar);
    }

    public /* synthetic */ Object b() {
        throw new NoSuchMethodError();
    }

    public gg(m mVar, dr drVar) {
        this.f12618a = mVar;
        this.f12619b = drVar;
    }

    public <HttpJsonResponseT extends s<Object, ? extends az>> Task<HttpJsonResponseT> a(r<Object, ? extends ay> rVar, Class<HttpJsonResponseT> cls) {
        return a(0, rVar.c(), rVar.b(), (JSONObject) null, cls, rVar.a());
    }

    public <HttpJsonResponseT extends s<Object, ? extends az>> Task<HttpJsonResponseT> a(int i, String str, Map<String, String> map, JSONObject jSONObject, Class<HttpJsonResponseT> cls, CancellationToken cancellationToken) {
        TaskCompletionSource taskCompletionSource;
        if (cancellationToken != null) {
            taskCompletionSource = new TaskCompletionSource(cancellationToken);
        } else {
            taskCompletionSource = new TaskCompletionSource();
        }
        o oVar = new o(0, str, (JSONObject) null, new l(this, cls, taskCompletionSource), new m(taskCompletionSource), map);
        if (cancellationToken != null) {
            cancellationToken.onCanceledRequested(new n(oVar));
        }
        this.f12618a.a(oVar);
        return taskCompletionSource.getTask();
    }

    public static /* synthetic */ void a(TaskCompletionSource taskCompletionSource, s sVar) {
        try {
            taskCompletionSource.trySetException(k.a(sVar));
        } catch (Error | RuntimeException e2) {
            dx.a(e2);
            throw e2;
        }
    }

    public /* synthetic */ void a(Class cls, TaskCompletionSource taskCompletionSource, JSONObject jSONObject) {
        try {
            taskCompletionSource.trySetResult((s) this.f12619b.a(jSONObject.toString(), cls));
        } catch (t e2) {
            try {
                taskCompletionSource.trySetException(k.a(e2));
            } catch (Error | RuntimeException e3) {
                dx.a(e3);
                throw e3;
            }
        }
    }
}
