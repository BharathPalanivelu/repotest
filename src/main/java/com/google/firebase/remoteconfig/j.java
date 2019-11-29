package com.google.firebase.remoteconfig;

import android.content.Context;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.internal.firebase_remote_config.zzab;
import com.google.android.gms.internal.firebase_remote_config.zzas;
import com.google.android.gms.internal.firebase_remote_config.zzbf;
import com.google.android.gms.internal.firebase_remote_config.zzcx;
import com.google.android.gms.internal.firebase_remote_config.zzcy;
import com.google.android.gms.internal.firebase_remote_config.zzde;
import com.google.android.gms.internal.firebase_remote_config.zzei;
import com.google.android.gms.internal.firebase_remote_config.zzes;
import com.google.android.gms.internal.firebase_remote_config.zzev;
import com.google.android.gms.internal.firebase_remote_config.zzew;
import com.google.android.gms.internal.firebase_remote_config.zzex;
import com.google.android.gms.internal.firebase_remote_config.zzfd;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.analytics.connector.a;
import com.google.firebase.b;
import com.google.firebase.iid.FirebaseInstanceId;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@KeepForSdk
public class j {

    /* renamed from: a  reason: collision with root package name */
    private static final ExecutorService f14354a = Executors.newCachedThreadPool();

    /* renamed from: b  reason: collision with root package name */
    private static final Clock f14355b = DefaultClock.getInstance();

    /* renamed from: c  reason: collision with root package name */
    private static final Random f14356c = new Random();

    /* renamed from: d  reason: collision with root package name */
    private final Map<String, a> f14357d;

    /* renamed from: e  reason: collision with root package name */
    private final Context f14358e;

    /* renamed from: f  reason: collision with root package name */
    private final b f14359f;

    /* renamed from: g  reason: collision with root package name */
    private final FirebaseInstanceId f14360g;
    private final com.google.firebase.abt.b h;
    private final a i;
    private final String j;
    private Map<String, String> k;
    private String l;

    j(Context context, b bVar, FirebaseInstanceId firebaseInstanceId, com.google.firebase.abt.b bVar2, a aVar) {
        this(context, f14354a, bVar, firebaseInstanceId, bVar2, aVar, new zzfd(context, bVar.c().b()));
    }

    private j(Context context, Executor executor, b bVar, FirebaseInstanceId firebaseInstanceId, com.google.firebase.abt.b bVar2, a aVar, zzfd zzfd) {
        this.f14357d = new HashMap();
        this.k = new HashMap();
        this.l = "https://firebaseremoteconfig.googleapis.com/";
        this.f14358e = context;
        this.f14359f = bVar;
        this.f14360g = firebaseInstanceId;
        this.h = bVar2;
        this.i = aVar;
        this.j = bVar.c().b();
        Tasks.call(executor, new q(this));
        zzfd.getClass();
        Tasks.call(executor, s.a(zzfd));
    }

    @KeepForSdk
    public synchronized a a(String str) {
        a a2;
        String str2 = str;
        synchronized (this) {
            zzei a3 = a(str2, "fetch");
            zzei a4 = a(str2, "activate");
            zzei a5 = a(str2, "defaults");
            zzev zzev = new zzev(this.f14358e.getSharedPreferences(String.format("%s_%s_%s_%s", new Object[]{"frc", this.j, str2, "settings"}), 0));
            b bVar = this.f14359f;
            com.google.firebase.abt.b bVar2 = this.h;
            ExecutorService executorService = f14354a;
            Context context = this.f14358e;
            String b2 = this.f14359f.c().b();
            FirebaseInstanceId firebaseInstanceId = this.f14360g;
            String str3 = str;
            a2 = a(bVar, str3, bVar2, executorService, a3, a4, a5, new zzes(context, b2, firebaseInstanceId, this.i, str, f14354a, f14355b, f14356c, a3, a(this.f14359f.c().a(), zzev), zzev), new zzew(a4, a5), zzev);
        }
        return a2;
    }

    private final synchronized a a(b bVar, String str, com.google.firebase.abt.b bVar2, Executor executor, zzei zzei, zzei zzei2, zzei zzei3, zzes zzes, zzew zzew, zzev zzev) {
        a aVar;
        String str2 = str;
        synchronized (this) {
            if (!this.f14357d.containsKey(str2)) {
                a aVar2 = new a(this.f14358e, bVar, str2.equals("firebase") ? bVar2 : null, executor, zzei, zzei2, zzei3, zzes, zzew, zzev);
                aVar2.e();
                this.f14357d.put(str2, aVar2);
            }
            aVar = this.f14357d.get(str2);
        }
        return aVar;
    }

    private final zzei a(String str, String str2) {
        return a(this.f14358e, this.j, str, str2);
    }

    public static zzei a(Context context, String str, String str2, String str3) {
        return zzei.zza(f14354a, zzex.zzb(context, String.format("%s_%s_%s_%s.json", new Object[]{"frc", str, str2, str3})));
    }

    private final zzcy a(String str, zzev zzev) {
        zzcy zzce;
        zzde zzde = new zzde(str);
        synchronized (this) {
            zzce = ((zzcx) new zzcx(new zzas(), zzbf.zzbq(), new r(this, zzev)).zzc(this.l)).zza(zzde).zzce();
        }
        return zzce;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void a(zzev zzev, zzab zzab) throws IOException {
        zzab.zza((int) TimeUnit.SECONDS.toMillis(zzev.getFetchTimeoutInSeconds()));
        zzab.zzb((int) TimeUnit.SECONDS.toMillis(5));
        synchronized (this) {
            for (Map.Entry next : this.k.entrySet()) {
                zzab.zzx().zzb((String) next.getKey(), next.getValue());
            }
        }
    }
}
