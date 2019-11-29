package com.google.android.gms.internal.vision;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "LineBoxParcelCreator")
@SafeParcelable.Reserved({1})
public final class zzx extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzx> CREATOR = new zzy();
    @SafeParcelable.Field(id = 7)
    private final float zzco;
    @SafeParcelable.Field(id = 8)
    public final String zzdd;
    @SafeParcelable.Field(id = 2)
    public final zzag[] zzdi;
    @SafeParcelable.Field(id = 3)
    public final zzr zzdj;
    @SafeParcelable.Field(id = 4)
    private final zzr zzdk;
    @SafeParcelable.Field(id = 5)
    private final zzr zzdl;
    @SafeParcelable.Field(id = 6)
    public final String zzdm;
    @SafeParcelable.Field(id = 9)
    private final int zzdn;
    @SafeParcelable.Field(id = 10)
    public final boolean zzdo;
    @SafeParcelable.Field(id = 11)
    public final int zzdp;
    @SafeParcelable.Field(id = 12)
    public final int zzdq;

    @SafeParcelable.Constructor
    public zzx(@SafeParcelable.Param(id = 2) zzag[] zzagArr, @SafeParcelable.Param(id = 3) zzr zzr, @SafeParcelable.Param(id = 4) zzr zzr2, @SafeParcelable.Param(id = 5) zzr zzr3, @SafeParcelable.Param(id = 6) String str, @SafeParcelable.Param(id = 7) float f2, @SafeParcelable.Param(id = 8) String str2, @SafeParcelable.Param(id = 9) int i, @SafeParcelable.Param(id = 10) boolean z, @SafeParcelable.Param(id = 11) int i2, @SafeParcelable.Param(id = 12) int i3) {
        this.zzdi = zzagArr;
        this.zzdj = zzr;
        this.zzdk = zzr2;
        this.zzdl = zzr3;
        this.zzdm = str;
        this.zzco = f2;
        this.zzdd = str2;
        this.zzdn = i;
        this.zzdo = z;
        this.zzdp = i2;
        this.zzdq = i3;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeTypedArray(parcel, 2, this.zzdi, i, false);
        SafeParcelWriter.writeParcelable(parcel, 3, this.zzdj, i, false);
        SafeParcelWriter.writeParcelable(parcel, 4, this.zzdk, i, false);
        SafeParcelWriter.writeParcelable(parcel, 5, this.zzdl, i, false);
        SafeParcelWriter.writeString(parcel, 6, this.zzdm, false);
        SafeParcelWriter.writeFloat(parcel, 7, this.zzco);
        SafeParcelWriter.writeString(parcel, 8, this.zzdd, false);
        SafeParcelWriter.writeInt(parcel, 9, this.zzdn);
        SafeParcelWriter.writeBoolean(parcel, 10, this.zzdo);
        SafeParcelWriter.writeInt(parcel, 11, this.zzdp);
        SafeParcelWriter.writeInt(parcel, 12, this.zzdq);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
