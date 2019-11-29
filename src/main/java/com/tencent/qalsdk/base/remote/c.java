package com.tencent.qalsdk.base.remote;

import android.os.Parcel;
import android.os.Parcelable;

final class c implements Parcelable.Creator<ToServiceMsg> {
    c() {
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new ToServiceMsg[i];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new ToServiceMsg(parcel);
    }
}
