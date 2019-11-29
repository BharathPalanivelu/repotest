package com.google.firebase.perf.internal;

import android.os.Parcel;
import android.os.Parcelable;

final class s implements Parcelable.Creator<zzq> {
    s() {
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new zzq[i];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new zzq(parcel, (s) null);
    }
}
