package com.google.android.libraries.places.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.libraries.places.api.model.Period;
import java.util.List;

final class ck extends bk {
    public static final Parcelable.Creator<ck> CREATOR = new cl();

    ck(List<Period> list, List<String> list2) {
        super(list, list2);
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeList(getPeriods());
        parcel.writeList(getWeekdayText());
    }
}
