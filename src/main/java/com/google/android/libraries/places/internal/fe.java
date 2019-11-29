package com.google.android.libraries.places.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.api.Status;
import com.google.android.libraries.places.api.model.AutocompletePrediction;
import com.google.android.libraries.places.api.model.Place;
import com.google.android.libraries.places.api.net.PlacesStatusCodes;
import java.util.ArrayList;
import java.util.List;

public final class fe implements Parcelable {
    public static final Parcelable.Creator<fe> CREATOR = new ff();

    /* renamed from: f  reason: collision with root package name */
    public static final fe f12545f = new fe(-1, new Status(PlacesStatusCodes.INVALID_REQUEST, "Place Fields must not be empty."), ha.g(), -1, (Place) null);

    /* renamed from: g  reason: collision with root package name */
    public static final fe f12546g = new fe(1, (Status) null, ha.g(), -1, (Place) null);

    /* renamed from: a  reason: collision with root package name */
    public final int f12547a;

    /* renamed from: b  reason: collision with root package name */
    public final Status f12548b;

    /* renamed from: c  reason: collision with root package name */
    public final List<AutocompletePrediction> f12549c;

    /* renamed from: d  reason: collision with root package name */
    public final int f12550d;

    /* renamed from: e  reason: collision with root package name */
    public final Place f12551e;

    public static fe a(List<AutocompletePrediction> list) {
        ArrayList arrayList = new ArrayList(list.size());
        for (AutocompletePrediction next : list) {
            if (!TextUtils.isEmpty(next.getPlaceId())) {
                arrayList.add(next);
            }
        }
        return new fe(4, new Status(0), arrayList, -1, (Place) null);
    }

    public final int describeContents() {
        return 0;
    }

    public static fe a(fe feVar, Place place) {
        if (feVar.f12547a != 5) {
            return feVar;
        }
        return new fe(7, new Status(0), feVar.f12549c, feVar.f12550d, place);
    }

    public static fe a(fe feVar, Status status) {
        if (feVar.f12547a != 5) {
            return feVar;
        }
        return new fe(6, status, feVar.f12549c, feVar.f12550d, (Place) null);
    }

    fe(int i, Status status, List<AutocompletePrediction> list, int i2, Place place) {
        this.f12547a = i;
        this.f12548b = status;
        this.f12549c = list;
        this.f12550d = i2;
        this.f12551e = place;
    }

    public final boolean a() {
        int i = this.f12547a;
        return i == 5 || i == 6 || i == 7;
    }

    public static fe a(Parcel parcel) {
        ArrayList arrayList = new ArrayList();
        parcel.readList(arrayList, AutocompletePrediction.class.getClassLoader());
        return new fe(parcel.readInt(), (Status) parcel.readParcelable(Status.class.getClassLoader()), arrayList, parcel.readInt(), (Place) parcel.readParcelable(Place.class.getClassLoader()));
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f12547a);
        parcel.writeParcelable(this.f12548b, i);
        parcel.writeList(this.f12549c);
        parcel.writeInt(this.f12550d);
        parcel.writeParcelable(this.f12551e, i);
    }

    public final boolean equals(Object obj) {
        if (obj instanceof fe) {
            fe feVar = (fe) obj;
            if (!hj.a((Object) Integer.valueOf(this.f12547a), (Object) Integer.valueOf(feVar.f12547a)) || !hj.a((Object) this.f12548b, (Object) feVar.f12548b) || !hj.a((Object) this.f12549c, (Object) feVar.f12549c) || !hj.a((Object) Integer.valueOf(this.f12550d), (Object) Integer.valueOf(feVar.f12550d)) || !hj.a((Object) this.f12551e, (Object) feVar.f12551e)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return hj.a(Integer.valueOf(this.f12547a), this.f12548b, this.f12549c, Integer.valueOf(this.f12550d), this.f12551e);
    }
}
