package com.google.android.libraries.places.internal;

import android.net.Uri;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.libraries.places.api.model.AddressComponents;
import com.google.android.libraries.places.api.model.OpeningHours;
import com.google.android.libraries.places.api.model.PhotoMetadata;
import com.google.android.libraries.places.api.model.Place;
import com.google.android.libraries.places.api.model.PlusCode;
import java.util.List;

public final class br extends Place.Builder {

    /* renamed from: a  reason: collision with root package name */
    private String f12408a;

    /* renamed from: b  reason: collision with root package name */
    private AddressComponents f12409b;

    /* renamed from: c  reason: collision with root package name */
    private List<String> f12410c;

    /* renamed from: d  reason: collision with root package name */
    private String f12411d;

    /* renamed from: e  reason: collision with root package name */
    private LatLng f12412e;

    /* renamed from: f  reason: collision with root package name */
    private String f12413f;

    /* renamed from: g  reason: collision with root package name */
    private OpeningHours f12414g;
    private String h;
    private List<PhotoMetadata> i;
    private PlusCode j;
    private Integer k;
    private Double l;
    private List<Place.Type> m;
    private Integer n;
    private LatLngBounds o;
    private Uri p;

    public final Place.Builder setAddress(String str) {
        this.f12408a = str;
        return this;
    }

    public final Place.Builder setAddressComponents(AddressComponents addressComponents) {
        this.f12409b = addressComponents;
        return this;
    }

    public final Place.Builder setAttributions(List<String> list) {
        this.f12410c = list;
        return this;
    }

    public final Place.Builder setId(String str) {
        this.f12411d = str;
        return this;
    }

    public final Place.Builder setLatLng(LatLng latLng) {
        this.f12412e = latLng;
        return this;
    }

    public final Place.Builder setName(String str) {
        this.f12413f = str;
        return this;
    }

    public final Place.Builder setOpeningHours(OpeningHours openingHours) {
        this.f12414g = openingHours;
        return this;
    }

    public final Place.Builder setPhoneNumber(String str) {
        this.h = str;
        return this;
    }

    public final Place.Builder setPhotoMetadatas(List<PhotoMetadata> list) {
        this.i = list;
        return this;
    }

    public final Place.Builder setPlusCode(PlusCode plusCode) {
        this.j = plusCode;
        return this;
    }

    public final Place.Builder setPriceLevel(Integer num) {
        this.k = num;
        return this;
    }

    public final Place.Builder setRating(Double d2) {
        this.l = d2;
        return this;
    }

    public final Place.Builder setTypes(List<Place.Type> list) {
        this.m = list;
        return this;
    }

    public final Place.Builder setUserRatingsTotal(Integer num) {
        this.n = num;
        return this;
    }

    public final Place.Builder setViewport(LatLngBounds latLngBounds) {
        this.o = latLngBounds;
        return this;
    }

    public final Place.Builder setWebsiteUri(Uri uri) {
        this.p = uri;
        return this;
    }

    /* access modifiers changed from: package-private */
    public final Place a() {
        return new cq(this.f12408a, this.f12409b, this.f12410c, this.f12411d, this.f12412e, this.f12413f, this.f12414g, this.h, this.i, this.j, this.k, this.l, this.m, this.n, this.o, this.p);
    }
}
