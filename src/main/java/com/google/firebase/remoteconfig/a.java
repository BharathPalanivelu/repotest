package com.google.firebase.remoteconfig;

import android.content.Context;
import android.util.Log;
import com.google.android.gms.internal.firebase_remote_config.zzei;
import com.google.android.gms.internal.firebase_remote_config.zzen;
import com.google.android.gms.internal.firebase_remote_config.zzes;
import com.google.android.gms.internal.firebase_remote_config.zzet;
import com.google.android.gms.internal.firebase_remote_config.zzev;
import com.google.android.gms.internal.firebase_remote_config.zzew;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final byte[] f14341a = new byte[0];

    /* renamed from: b  reason: collision with root package name */
    private final Context f14342b;

    /* renamed from: c  reason: collision with root package name */
    private final b f14343c;

    /* renamed from: d  reason: collision with root package name */
    private final com.google.firebase.abt.b f14344d;

    /* renamed from: e  reason: collision with root package name */
    private final Executor f14345e;

    /* renamed from: f  reason: collision with root package name */
    private final zzei f14346f;

    /* renamed from: g  reason: collision with root package name */
    private final zzei f14347g;
    private final zzei h;
    private final zzes i;
    private final zzew j;
    private final zzev k;

    public static a a() {
        return a(b.d());
    }

    public static a a(b bVar) {
        return ((j) bVar.a(j.class)).a("firebase");
    }

    a(Context context, b bVar, com.google.firebase.abt.b bVar2, Executor executor, zzei zzei, zzei zzei2, zzei zzei3, zzes zzes, zzew zzew, zzev zzev) {
        this.f14342b = context;
        this.f14343c = bVar;
        this.f14344d = bVar2;
        this.f14345e = executor;
        this.f14346f = zzei;
        this.f14347g = zzei2;
        this.h = zzei3;
        this.i = zzes;
        this.j = zzew;
        this.k = zzev;
    }

    public Task<Boolean> b() {
        return d().onSuccessTask(this.f14345e, new l(this));
    }

    public Task<Boolean> c() {
        Task<zzen> zzcp = this.f14346f.zzcp();
        Task<zzen> zzcp2 = this.f14347g.zzcp();
        return Tasks.whenAllComplete((Task<?>[]) new Task[]{zzcp, zzcp2}).continueWithTask(this.f14345e, new n(this, zzcp, zzcp2));
    }

    public Task<Void> d() {
        Task<zzet> zza = this.i.zza(this.k.isDeveloperModeEnabled());
        zza.addOnCompleteListener(this.f14345e, (OnCompleteListener<zzet>) new m(this));
        return zza.onSuccessTask(o.f14367a);
    }

    public String a(String str) {
        return this.j.getString(str);
    }

    public boolean b(String str) {
        return this.j.getBoolean(str);
    }

    public double c(String str) {
        return this.j.getDouble(str);
    }

    public long d(String str) {
        return this.j.getLong(str);
    }

    /* access modifiers changed from: package-private */
    public final void e() {
        this.f14347g.zzcp();
        this.h.zzcp();
        this.f14346f.zzcp();
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public final boolean b(Task<zzen> task) {
        if (!task.isSuccessful()) {
            return false;
        }
        this.f14346f.clear();
        if (task.getResult() != null) {
            a(task.getResult().zzcs());
            return true;
        }
        Log.e("FirebaseRemoteConfig", "Activated configs are null.");
        return true;
    }

    private final void a(JSONArray jSONArray) {
        if (this.f14344d != null) {
            try {
                ArrayList arrayList = new ArrayList();
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    HashMap hashMap = new HashMap();
                    JSONObject jSONObject = jSONArray.getJSONObject(i2);
                    Iterator<String> keys = jSONObject.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        hashMap.put(next, jSONObject.getString(next));
                    }
                    arrayList.add(hashMap);
                }
                this.f14344d.a((List<Map<String, String>>) arrayList);
            } catch (JSONException e2) {
                Log.e("FirebaseRemoteConfig", "Could not parse ABT experiments from the JSON response.", e2);
            } catch (com.google.firebase.abt.a e3) {
                Log.w("FirebaseRemoteConfig", "Could not update ABT experiments.", e3);
            }
        }
    }

    private static boolean a(zzen zzen, zzen zzen2) {
        return zzen2 == null || !zzen.zzcr().equals(zzen2.zzcr());
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Task a(Task task, Task task2, Task task3) throws Exception {
        if (!task.isSuccessful() || task.getResult() == null) {
            return Tasks.forResult(false);
        }
        zzen zzen = (zzen) task.getResult();
        if (!task2.isSuccessful() || a(zzen, (zzen) task2.getResult())) {
            return this.f14347g.zza(zzen, true).continueWith(this.f14345e, new k(this));
        }
        return Tasks.forResult(false);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void a(Task task) {
        if (task.isSuccessful()) {
            this.k.zzm(-1);
            zzen zzcx = ((zzet) task.getResult()).zzcx();
            if (zzcx != null) {
                this.k.zzf(zzcx.zzcr());
            }
            Log.i("FirebaseRemoteConfig", "Fetch succeeded!");
            return;
        }
        Exception exception = task.getException();
        if (exception == null) {
            Log.e("FirebaseRemoteConfig", "Fetch was cancelled... This should never covfefe");
        } else if (exception instanceof e) {
            this.k.zzm(2);
            Log.w("FirebaseRemoteConfig", "Fetch was throttled!", exception);
        } else {
            this.k.zzm(1);
            Log.e("FirebaseRemoteConfig", "Fetch failed!", exception);
        }
    }
}
