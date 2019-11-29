package com.google.android.gms.internal.vision;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "WordBoxParcelCreator")
@SafeParcelable.Reserved({1})
public final class zzag extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzag> CREATOR = new zzah();
    @SafeParcelable.Field(id = 6)
    private final float zzco;
    @SafeParcelable.Field(id = 7)
    public final String zzdd;
    @SafeParcelable.Field(id = 3)
    public final zzr zzdj;
    @SafeParcelable.Field(id = 4)
    private final zzr zzdk;
    @SafeParcelable.Field(id = 5)
    public final String zzdm;
    @SafeParcelable.Field(id = 2)
    private final zzab[] zzds;
    @SafeParcelable.Field(id = 8)
    private final boolean zzdt;

    @SafeParcelable.Constructor
    public zzag(@SafeParcelable.Param(id = 2) zzab[] zzabArr, @SafeParcelable.Param(id = 3) zzr zzr, @SafeParcelable.Param(id = 4) zzr zzr2, @SafeParcelable.Param(id = 5) String str, @SafeParcelable.Param(id = 6) float f2, @SafeParcelable.Param(id = 7) String str2, @SafeParcelable.Param(id = 8) boolean z) {
        this.zzds = zzabArr;
        this.zzdj = zzr;
        this.zzdk = zzr2;
        this.zzdm = str;
        this.zzco = f2;
        this.zzdd = str2;
        this.zzdt = z;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeTypedArray(parcel, 2, this.zzds, i, false);
        SafeParcelWriter.writeParcelable(parcel, 3, this.zzdj, i, false);
        SafeParcelWriter.writeParcelable(parcel, 4, this.zzdk, i, false);
        SafeParcelWriter.writeString(parcel, 5, this.zzdm, false);
        SafeParcelWriter.writeFloat(parcel, 6, this.zzco);
        SafeParcelWriter.writeString(parcel, 7, this.zzdd, false);
        SafeParcelWriter.writeBoolean(parcel, 8, this.zzdt);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
