package com.google.android.libraries.places.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.libraries.places.api.model.AutocompletePrediction;
import com.google.android.libraries.places.api.model.Place;
import java.util.List;

final class cc extends bd {
    public static final Parcelable.Creator<cc> CREATOR = new cd();

    cc(String str, List<Place.Type> list, String str2, String str3, String str4, List<AutocompletePrediction.a> list2, List<AutocompletePrediction.a> list3, List<AutocompletePrediction.a> list4) {
        super(str, list, str2, str3, str4, list2, list3, list4);
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(getPlaceId());
        parcel.writeList(getPlaceTypes());
        parcel.writeString(a());
        parcel.writeString(b());
        parcel.writeString(c());
        parcel.writeList(d());
        parcel.writeList(e());
        parcel.writeList(f());
    }
}
