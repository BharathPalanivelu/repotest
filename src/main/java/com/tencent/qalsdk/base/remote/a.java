package com.tencent.qalsdk.base.remote;

import android.os.Parcel;
import android.os.Parcelable;

final class a implements Parcelable.Creator<FromServiceMsg> {
    a() {
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new FromServiceMsg[i];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new FromServiceMsg(parcel);
    }
}
