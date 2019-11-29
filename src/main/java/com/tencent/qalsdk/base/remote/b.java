package com.tencent.qalsdk.base.remote;

import android.os.Parcel;
import android.os.Parcelable;

final class b implements Parcelable.Creator<MsfServiceBindInfo> {
    b() {
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new MsfServiceBindInfo[i];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new MsfServiceBindInfo(parcel);
    }
}
