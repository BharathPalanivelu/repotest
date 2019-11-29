package com.garena.reactpush.b;

import android.content.SharedPreferences;
import com.garena.reactpush.data.BundleState;
import com.garena.reactpush.data.Manifest;
import com.google.a.c.a;
import com.salesforce.android.service.common.utilities.logging.ServiceLogger;

public class b {

    /* renamed from: a  reason: collision with root package name */
    private a<Manifest> f8338a;

    /* renamed from: b  reason: collision with root package name */
    private a<Manifest> f8339b;

    /* renamed from: c  reason: collision with root package name */
    private a<Manifest> f8340c;

    /* renamed from: d  reason: collision with root package name */
    private a<BundleState> f8341d;

    public b(SharedPreferences sharedPreferences) {
        this.f8338a = new a<>(sharedPreferences, "main_manifest1", ServiceLogger.PLACEHOLDER, new a<Manifest>() {
        });
        this.f8339b = new a<>(sharedPreferences, "temp_manifest1", ServiceLogger.PLACEHOLDER, new a<Manifest>() {
        });
        this.f8340c = new a<>(sharedPreferences, "backup_manifest1", ServiceLogger.PLACEHOLDER, new a<Manifest>() {
        });
        this.f8341d = new a<>(sharedPreferences, "bundle_state", ServiceLogger.PLACEHOLDER, new a<BundleState>() {
        });
    }

    public Manifest a() {
        return this.f8339b.a();
    }

    public void a(Manifest manifest) {
        this.f8339b.a(manifest);
    }

    public void b() {
        this.f8339b.a(new Manifest());
        this.f8338a.a(new Manifest());
        this.f8340c.a(new Manifest());
    }

    public BundleState c() {
        return this.f8341d.a();
    }

    public void a(BundleState bundleState) {
        this.f8341d.a(bundleState);
    }
}
