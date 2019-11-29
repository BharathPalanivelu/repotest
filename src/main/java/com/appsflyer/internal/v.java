package com.appsflyer.internal;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.text.TextUtils;
import com.appsflyer.AFLogger;
import com.appsflyer.AppsFlyerLib;
import com.appsflyer.AppsFlyerLibCore;
import com.appsflyer.AppsFlyerProperties;
import com.appsflyer.FirebaseInstanceIdListener;
import com.appsflyer.internal.b;
import com.google.android.gms.stats.CodePackage;
import com.google.firebase.iid.FirebaseInstanceIdService;
import java.lang.ref.WeakReference;

public final class v {
    v() {
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0047, code lost:
        if ((r6.getPackageManager().queryIntentServices(r3, 0).size() > 0) != false) goto L_0x0049;
     */
    /* renamed from: ˊ  reason: contains not printable characters */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean m187(android.content.Context r6) {
        /*
            java.lang.String r0 = "com.google.android.gms.iid.InstanceID"
            com.appsflyer.AppsFlyerLib r1 = com.appsflyer.AppsFlyerLib.getInstance()
            boolean r1 = r1.isTrackingStopped()
            r2 = 0
            if (r1 == 0) goto L_0x000e
            return r2
        L_0x000e:
            java.lang.String r1 = "com.google.android.gms.iid.InstanceIDListenerService"
            java.lang.Class.forName(r1)     // Catch:{ ClassNotFoundException -> 0x0098, Throwable -> 0x0091 }
            android.content.Intent r1 = new android.content.Intent     // Catch:{ ClassNotFoundException -> 0x0098, Throwable -> 0x0091 }
            java.lang.Class<com.appsflyer.GcmInstanceIdListener> r3 = com.appsflyer.GcmInstanceIdListener.class
            r4 = 0
            r1.<init>(r0, r4, r6, r3)     // Catch:{ ClassNotFoundException -> 0x0098, Throwable -> 0x0091 }
            android.content.Intent r3 = new android.content.Intent     // Catch:{ ClassNotFoundException -> 0x0098, Throwable -> 0x0091 }
            java.lang.Class<com.google.android.gms.iid.InstanceIDListenerService> r5 = com.google.android.gms.iid.InstanceIDListenerService.class
            r3.<init>(r0, r4, r6, r5)     // Catch:{ ClassNotFoundException -> 0x0098, Throwable -> 0x0091 }
            android.content.pm.PackageManager r0 = r6.getPackageManager()     // Catch:{ ClassNotFoundException -> 0x0098, Throwable -> 0x0091 }
            java.util.List r0 = r0.queryIntentServices(r1, r2)     // Catch:{ ClassNotFoundException -> 0x0098, Throwable -> 0x0091 }
            int r0 = r0.size()     // Catch:{ ClassNotFoundException -> 0x0098, Throwable -> 0x0091 }
            r1 = 1
            if (r0 <= 0) goto L_0x0033
            r0 = 1
            goto L_0x0034
        L_0x0033:
            r0 = 0
        L_0x0034:
            if (r0 != 0) goto L_0x0049
            android.content.pm.PackageManager r0 = r6.getPackageManager()     // Catch:{ ClassNotFoundException -> 0x0098, Throwable -> 0x0091 }
            java.util.List r0 = r0.queryIntentServices(r3, r2)     // Catch:{ ClassNotFoundException -> 0x0098, Throwable -> 0x0091 }
            int r0 = r0.size()     // Catch:{ ClassNotFoundException -> 0x0098, Throwable -> 0x0091 }
            if (r0 <= 0) goto L_0x0046
            r0 = 1
            goto L_0x0047
        L_0x0046:
            r0 = 0
        L_0x0047:
            if (r0 == 0) goto L_0x00a0
        L_0x0049:
            android.content.Intent r0 = new android.content.Intent     // Catch:{ ClassNotFoundException -> 0x0098, Throwable -> 0x0091 }
            java.lang.String r3 = "com.google.android.c2dm.intent.RECEIVE"
            java.lang.String r5 = "com.google.android.gms.gcm.GcmReceiver"
            java.lang.Class r5 = java.lang.Class.forName(r5)     // Catch:{ ClassNotFoundException -> 0x0098, Throwable -> 0x0091 }
            r0.<init>(r3, r4, r6, r5)     // Catch:{ ClassNotFoundException -> 0x0098, Throwable -> 0x0091 }
            android.content.pm.PackageManager r3 = r6.getPackageManager()     // Catch:{ ClassNotFoundException -> 0x0098, Throwable -> 0x0091 }
            java.util.List r0 = r3.queryBroadcastReceivers(r0, r2)     // Catch:{ ClassNotFoundException -> 0x0098, Throwable -> 0x0091 }
            int r0 = r0.size()     // Catch:{ ClassNotFoundException -> 0x0098, Throwable -> 0x0091 }
            if (r0 <= 0) goto L_0x0066
            r0 = 1
            goto L_0x0067
        L_0x0066:
            r0 = 0
        L_0x0067:
            if (r0 == 0) goto L_0x008b
            java.lang.String r0 = r6.getPackageName()     // Catch:{ ClassNotFoundException -> 0x0098, Throwable -> 0x0091 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ ClassNotFoundException -> 0x0098, Throwable -> 0x0091 }
            r3.<init>()     // Catch:{ ClassNotFoundException -> 0x0098, Throwable -> 0x0091 }
            r3.append(r0)     // Catch:{ ClassNotFoundException -> 0x0098, Throwable -> 0x0091 }
            java.lang.String r0 = ".permission.C2D_MESSAGE"
            r3.append(r0)     // Catch:{ ClassNotFoundException -> 0x0098, Throwable -> 0x0091 }
            java.lang.String r0 = r3.toString()     // Catch:{ ClassNotFoundException -> 0x0098, Throwable -> 0x0091 }
            boolean r6 = com.appsflyer.AFExecutor.AnonymousClass2.m25(r6, r0)     // Catch:{ ClassNotFoundException -> 0x0098, Throwable -> 0x0091 }
            if (r6 == 0) goto L_0x0085
            return r1
        L_0x0085:
            java.lang.String r6 = "Cannot verify existence of the app's \"permission.C2D_MESSAGE\" permission in the manifest. Please refer to documentation."
            com.appsflyer.AFLogger.afWarnLog(r6)     // Catch:{ ClassNotFoundException -> 0x0098, Throwable -> 0x0091 }
            goto L_0x00a0
        L_0x008b:
            java.lang.String r6 = "Cannot verify existence of GcmReceiver receiver in the manifest. Please refer to documentation."
            com.appsflyer.AFLogger.afWarnLog(r6)     // Catch:{ ClassNotFoundException -> 0x0098, Throwable -> 0x0091 }
            goto L_0x00a0
        L_0x0091:
            r6 = move-exception
            java.lang.String r0 = "An error occurred while trying to verify manifest declarations: "
            com.appsflyer.AFLogger.afErrorLog(r0, r6)
            goto L_0x00a0
        L_0x0098:
            r6 = move-exception
            java.lang.String r6 = r6.getMessage()
            com.appsflyer.AFLogger.afRDLog(r6)
        L_0x00a0:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.v.m187(android.content.Context):boolean");
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public static boolean m189(Context context) {
        if (AppsFlyerLib.getInstance().isTrackingStopped()) {
            return false;
        }
        try {
            Class.forName("com.google.firebase.iid.FirebaseInstanceIdService");
            Intent intent = new Intent("com.google.firebase.INSTANCE_ID_EVENT", (Uri) null, context, FirebaseInstanceIdListener.class);
            Intent intent2 = new Intent("com.google.firebase.INSTANCE_ID_EVENT", (Uri) null, context, FirebaseInstanceIdService.class);
            if (!(context.getPackageManager().queryIntentServices(intent, 0).size() > 0)) {
                if (!(context.getPackageManager().queryIntentServices(intent2, 0).size() > 0)) {
                    AFLogger.afWarnLog("Cannot verify existence of our InstanceID Listener Service in the manifest. Please refer to documentation.");
                    return false;
                }
            }
            return true;
        } catch (ClassNotFoundException unused) {
        } catch (Throwable th) {
            AFLogger.afErrorLog("An error occurred while trying to verify manifest declarations: ", th);
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    static String m188(WeakReference<Context> weakReference, String str) {
        try {
            Class<?> cls = Class.forName("com.google.android.gms.iid.InstanceID");
            Class.forName("com.google.android.gms.gcm.GcmReceiver");
            Object invoke = cls.getDeclaredMethod("getInstance", new Class[]{Context.class}).invoke(cls, new Object[]{weakReference.get()});
            String str2 = (String) cls.getDeclaredMethod("getToken", new Class[]{String.class, String.class}).invoke(invoke, new Object[]{str, CodePackage.GCM});
            if (str2 != null) {
                return str2;
            }
            AFLogger.afWarnLog("Couldn't get token using reflection.");
            return null;
        } catch (ClassNotFoundException unused) {
            return null;
        } catch (Throwable th) {
            AFLogger.afErrorLog("Couldn't get token using GoogleCloudMessaging. ", th);
            return null;
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public static void m190(Context context, b.C0090b.a aVar) {
        StringBuilder sb = new StringBuilder("updateServerUninstallToken called with: ");
        sb.append(aVar.toString());
        AFLogger.afInfoLog(sb.toString());
        b.C0090b.a r0 = b.C0090b.a.m140(AppsFlyerProperties.getInstance().getString("afUninstallToken"));
        if (!AppsFlyerLibCore.m46(context).getBoolean("sentRegisterRequestToAF", false) || r0.f151 == null || !r0.f151.equals(aVar.f151)) {
            AppsFlyerProperties.getInstance().set("afUninstallToken", aVar.toString());
            AppsFlyerLibCore.getInstance().m94(context, aVar.f151);
        }
    }

    public static class e extends AsyncTask<Void, Void, String> {

        /* renamed from: ˊ  reason: contains not printable characters */
        private final WeakReference<Context> f244;

        /* renamed from: ˋ  reason: contains not printable characters */
        private String f245;

        /* access modifiers changed from: protected */
        public final /* synthetic */ Object doInBackground(Object[] objArr) {
            return m191();
        }

        /* access modifiers changed from: protected */
        public final /* synthetic */ void onPostExecute(Object obj) {
            String str = (String) obj;
            if (!TextUtils.isEmpty(str)) {
                String string = AppsFlyerProperties.getInstance().getString("afUninstallToken");
                b.C0090b.a aVar = new b.C0090b.a(str);
                if (string == null) {
                    v.m190(this.f244.get(), aVar);
                    return;
                }
                b.C0090b.a r5 = b.C0090b.a.m140(string);
                if (r5.m142(aVar.f152, aVar.f151)) {
                    v.m190(this.f244.get(), r5);
                }
            }
        }

        public e(WeakReference<Context> weakReference) {
            this.f244 = weakReference;
        }

        /* access modifiers changed from: protected */
        public final void onPreExecute() {
            super.onPreExecute();
            this.f245 = AppsFlyerProperties.getInstance().getString("gcmProjectNumber");
        }

        /* renamed from: ˊ  reason: contains not printable characters */
        private String m191() {
            try {
                if (this.f245 != null) {
                    return v.m188(this.f244, this.f245);
                }
                return null;
            } catch (Throwable th) {
                AFLogger.afErrorLog("Error registering for uninstall feature", th);
                return null;
            }
        }
    }
}
