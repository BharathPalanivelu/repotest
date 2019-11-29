package com.android.a.a;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.a.a.a;
import java.util.List;

class b extends a {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public int f4549a = 0;

    /* renamed from: b  reason: collision with root package name */
    private final Context f4550b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public com.google.android.a.a.a f4551c;

    /* renamed from: d  reason: collision with root package name */
    private ServiceConnection f4552d;

    public b(Context context) {
        this.f4550b = context.getApplicationContext();
    }

    public boolean a() {
        return (this.f4549a != 2 || this.f4551c == null || this.f4552d == null) ? false : true;
    }

    public void a(c cVar) {
        if (a()) {
            com.android.a.b.a.a("InstallReferrerClient", "Service connection is valid. No need to re-initialize.");
            cVar.onInstallReferrerSetupFinished(0);
            return;
        }
        int i = this.f4549a;
        if (i == 1) {
            com.android.a.b.a.b("InstallReferrerClient", "Client is already in the process of connecting to the service.");
            cVar.onInstallReferrerSetupFinished(3);
        } else if (i == 3) {
            com.android.a.b.a.b("InstallReferrerClient", "Client was already closed and can't be reused. Please create another instance.");
            cVar.onInstallReferrerSetupFinished(3);
        } else {
            com.android.a.b.a.a("InstallReferrerClient", "Starting install referrer service setup.");
            this.f4552d = new a(cVar);
            Intent intent = new Intent("com.google.android.finsky.BIND_GET_INSTALL_REFERRER_SERVICE");
            intent.setComponent(new ComponentName("com.android.vending", "com.google.android.finsky.externalreferrer.GetInstallReferrerService"));
            List<ResolveInfo> queryIntentServices = this.f4550b.getPackageManager().queryIntentServices(intent, 0);
            if (queryIntentServices != null && !queryIntentServices.isEmpty()) {
                ResolveInfo resolveInfo = queryIntentServices.get(0);
                if (resolveInfo.serviceInfo != null) {
                    String str = resolveInfo.serviceInfo.packageName;
                    String str2 = resolveInfo.serviceInfo.name;
                    if (!"com.android.vending".equals(str) || str2 == null || !d()) {
                        com.android.a.b.a.b("InstallReferrerClient", "Play Store missing or incompatible. Version 8.3.73 or later required.");
                        this.f4549a = 0;
                        cVar.onInstallReferrerSetupFinished(2);
                        return;
                    }
                    if (this.f4550b.bindService(new Intent(intent), this.f4552d, 1)) {
                        com.android.a.b.a.a("InstallReferrerClient", "Service was bonded successfully.");
                        return;
                    }
                    com.android.a.b.a.b("InstallReferrerClient", "Connection to service is blocked.");
                    this.f4549a = 0;
                    cVar.onInstallReferrerSetupFinished(1);
                    return;
                }
            }
            this.f4549a = 0;
            com.android.a.b.a.a("InstallReferrerClient", "Install Referrer service unavailable on device.");
            cVar.onInstallReferrerSetupFinished(2);
        }
    }

    public void b() {
        this.f4549a = 3;
        if (this.f4552d != null) {
            com.android.a.b.a.a("InstallReferrerClient", "Unbinding from service.");
            this.f4550b.unbindService(this.f4552d);
            this.f4552d = null;
        }
        this.f4551c = null;
    }

    public d c() throws RemoteException {
        if (a()) {
            Bundle bundle = new Bundle();
            bundle.putString("package_name", this.f4550b.getPackageName());
            try {
                return new d(this.f4551c.a(bundle));
            } catch (RemoteException e2) {
                com.android.a.b.a.b("InstallReferrerClient", "RemoteException getting install referrer information");
                this.f4549a = 0;
                throw e2;
            }
        } else {
            throw new IllegalStateException("Service not connected. Please start a connection before using the service.");
        }
    }

    private boolean d() {
        try {
            if (this.f4550b.getPackageManager().getPackageInfo("com.android.vending", 128).versionCode >= 80837300) {
                return true;
            }
            return false;
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }

    private final class a implements ServiceConnection {

        /* renamed from: b  reason: collision with root package name */
        private final c f4554b;

        private a(c cVar) {
            if (cVar != null) {
                this.f4554b = cVar;
                return;
            }
            throw new RuntimeException("Please specify a listener to know when setup is done.");
        }

        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            com.android.a.b.a.a("InstallReferrerClient", "Install Referrer service connected.");
            com.google.android.a.a.a unused = b.this.f4551c = a.C0153a.a(iBinder);
            int unused2 = b.this.f4549a = 2;
            this.f4554b.onInstallReferrerSetupFinished(0);
        }

        public void onServiceDisconnected(ComponentName componentName) {
            com.android.a.b.a.b("InstallReferrerClient", "Install Referrer service disconnected.");
            com.google.android.a.a.a unused = b.this.f4551c = null;
            int unused2 = b.this.f4549a = 0;
            this.f4554b.onInstallReferrerServiceDisconnected();
        }
    }
}
