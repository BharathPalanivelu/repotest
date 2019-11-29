package com.garena.reactpush.e.c;

import com.facebook.react.ReactInstanceManager;
import com.facebook.react.bridge.JSBundleLoader;
import com.facebook.react.bridge.JSBundleLoaderDelegate;
import com.facebook.react.bridge.ReactContext;
import com.garena.reactpush.c.f;
import com.garena.reactpush.data.Manifest;

public class a extends JSBundleLoader implements ReactInstanceManager.ReactInstanceEventListener {

    /* renamed from: a  reason: collision with root package name */
    protected final String f8408a;

    /* renamed from: b  reason: collision with root package name */
    public C0144a f8409b;

    /* renamed from: c  reason: collision with root package name */
    public ReactInstanceManager f8410c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f8411d = false;

    /* renamed from: e  reason: collision with root package name */
    public boolean f8412e = false;

    /* renamed from: f  reason: collision with root package name */
    public boolean f8413f = false;

    /* renamed from: g  reason: collision with root package name */
    private Manifest f8414g;

    /* renamed from: com.garena.reactpush.e.c.a$a  reason: collision with other inner class name */
    public interface C0144a {
        void a();
    }

    public a(String str) {
        this.f8408a = str;
    }

    public void a(ReactInstanceManager reactInstanceManager) {
        this.f8410c = reactInstanceManager;
        this.f8410c.addReactInstanceEventListener(this);
    }

    public void a(Manifest manifest) {
        this.f8414g = manifest;
    }

    public Manifest a() {
        return this.f8414g;
    }

    public void a(C0144a aVar) {
        this.f8409b = aVar;
    }

    public boolean b() {
        return this.f8411d;
    }

    public boolean c() {
        return this.f8413f;
    }

    public void onReactContextInitialized(ReactContext reactContext) {
        this.f8411d = true;
        this.f8413f = true;
        C0144a aVar = this.f8409b;
        if (aVar != null) {
            aVar.a();
        }
    }

    public String d() {
        String name = this.f8414g.getBundles().get(0).getName();
        String str = this.f8408a;
        return str.concat(name + ".bundle");
    }

    public String loadScript(JSBundleLoaderDelegate jSBundleLoaderDelegate) {
        JSBundleLoader.createFileLoader(d(), d(), false).loadScript(jSBundleLoaderDelegate);
        return d();
    }

    public void a(boolean z) {
        this.f8412e = z;
        f.a(new Runnable() {
            public void run() {
                if (a.this.f8410c != null && !a.this.f8410c.hasStartedCreatingInitialContext()) {
                    a.this.f8410c.createReactContextInBackground();
                }
            }
        });
    }
}
