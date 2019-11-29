package com.google.android.libraries.places.internal;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.d;
import com.facebook.appevents.UserDataStore;
import com.google.android.gms.clearcut.ClearcutLogger;
import com.google.android.libraries.places.api.Places;
import com.google.android.libraries.places.api.model.LocationBias;
import com.google.android.libraries.places.api.model.LocationRestriction;
import com.google.android.libraries.places.api.model.Place;
import com.google.android.libraries.places.api.model.TypeFilter;
import com.google.android.libraries.places.api.net.PlacesClient;
import com.google.android.libraries.places.internal.dw;
import java.util.List;

public class fz implements ny {

    /* renamed from: a  reason: collision with root package name */
    public final d f12599a;

    /* renamed from: b  reason: collision with root package name */
    public final Bundle f12600b;

    public final /* synthetic */ Object b() {
        throw new NoSuchMethodError();
    }

    public fs a() {
        return k();
    }

    fz(d dVar, Bundle bundle) {
        this.f12599a = dVar;
        this.f12600b = bundle;
    }

    public static ga c() {
        return new ga((byte) 0);
    }

    /* access modifiers changed from: package-private */
    public dw d() {
        return (dw) lt.a(dw.a(this.f12599a).a(dw.b.AUTOCOMPLETE_WIDGET).b(), "Cannot return null from a non-@Nullable @Provides method");
    }

    /* access modifiers changed from: package-private */
    public PlacesClient e() {
        return (PlacesClient) lt.a(Places.a(this.f12599a, d()), "Cannot return null from a non-@Nullable @Provides method");
    }

    /* access modifiers changed from: package-private */
    public fh f() {
        Intent intent = this.f12599a.getIntent();
        return (fh) lt.a(new eh().a((List<Place.Field>) intent.getParcelableArrayListExtra("place_fields")).a((LocationBias) intent.getParcelableExtra("location_bias")).a((LocationRestriction) intent.getParcelableExtra("location_restriction")).a(intent.getStringExtra(UserDataStore.COUNTRY)).a((TypeFilter) intent.getSerializableExtra("types")).a(), "Cannot return null from a non-@Nullable @Provides method");
    }

    /* access modifiers changed from: package-private */
    public ex g() {
        return new ex(this.f12599a, e(), f());
    }

    /* access modifiers changed from: package-private */
    public fj h() {
        return new fj(g());
    }

    /* access modifiers changed from: package-private */
    public ClearcutLogger i() {
        return ds.a((Context) this.f12599a);
    }

    /* access modifiers changed from: package-private */
    public ge j() {
        return new ge(i(), d());
    }

    /* access modifiers changed from: package-private */
    public fs k() {
        return new fs(this.f12599a, this.f12600b, h(), j(), b.a());
    }

    /* synthetic */ fz(d dVar, Bundle bundle, byte b2) {
        this(dVar, bundle);
    }
}
