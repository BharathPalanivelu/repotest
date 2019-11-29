package com.google.android.gms.internal.icing;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;

@ShowFirstParty
@SafeParcelable.Class(creator = "GetRecentContextCall_ResponseCreator")
@SafeParcelable.Reserved({1000})
public final class zzo extends AbstractSafeParcelable implements Result {
    public static final Parcelable.Creator<zzo> CREATOR = new zzr();
    @SafeParcelable.Field(id = 1)
    private Status zzv;
    @SafeParcelable.Field(id = 2)
    private List<zzw> zzw;
    @SafeParcelable.Field(id = 3)
    @Deprecated
    private String[] zzx;

    public zzo() {
    }

    public final Status getStatus() {
        return this.zzv;
    }

    @SafeParcelable.Constructor
    zzo(@SafeParcelable.Param(id = 1) Status status, @SafeParcelable.Param(id = 2) List<zzw> list, @SafeParcelable.Param(id = 3) String[] strArr) {
        this.zzv = status;
        this.zzw = list;
        this.zzx = strArr;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 1, this.zzv, i, false);
        SafeParcelWriter.writeTypedList(parcel, 2, this.zzw, false);
        SafeParcelWriter.writeStringArray(parcel, 3, this.zzx, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
