package com.google.android.gms.internal.icing;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Arrays;

@ShowFirstParty
@SafeParcelable.Class(creator = "RegisterSectionInfoCreator")
@SafeParcelable.Reserved({1000, 8, 9, 10})
public final class zzt extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzt> CREATOR = new zzv();
    @SafeParcelable.Field(id = 1)
    private final String name;
    @SafeParcelable.Field(defaultValue = "1", id = 4)
    private final int weight;
    @SafeParcelable.Field(id = 2)
    private final String zzaa;
    @SafeParcelable.Field(id = 3)
    private final boolean zzab;
    @SafeParcelable.Field(id = 5)
    private final boolean zzac;
    @SafeParcelable.Field(id = 11)
    private final String zzae;
    @SafeParcelable.Field(id = 6)
    private final String zzaf;
    @SafeParcelable.Field(id = 7)
    private final zzm[] zzag;
    @SafeParcelable.Field(id = 12)
    private final zzu zzah;

    @SafeParcelable.Constructor
    zzt(@SafeParcelable.Param(id = 1) String str, @SafeParcelable.Param(id = 2) String str2, @SafeParcelable.Param(id = 3) boolean z, @SafeParcelable.Param(id = 4) int i, @SafeParcelable.Param(id = 5) boolean z2, @SafeParcelable.Param(id = 6) String str3, @SafeParcelable.Param(id = 7) zzm[] zzmArr, @SafeParcelable.Param(id = 11) String str4, @SafeParcelable.Param(id = 12) zzu zzu) {
        this.name = str;
        this.zzaa = str2;
        this.zzab = z;
        this.weight = i;
        this.zzac = z2;
        this.zzaf = str3;
        this.zzag = zzmArr;
        this.zzae = str4;
        this.zzah = zzu;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.name, false);
        SafeParcelWriter.writeString(parcel, 2, this.zzaa, false);
        SafeParcelWriter.writeBoolean(parcel, 3, this.zzab);
        SafeParcelWriter.writeInt(parcel, 4, this.weight);
        SafeParcelWriter.writeBoolean(parcel, 5, this.zzac);
        SafeParcelWriter.writeString(parcel, 6, this.zzaf, false);
        SafeParcelWriter.writeTypedArray(parcel, 7, this.zzag, i, false);
        SafeParcelWriter.writeString(parcel, 11, this.zzae, false);
        SafeParcelWriter.writeParcelable(parcel, 12, this.zzah, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final int hashCode() {
        return Objects.hashCode(this.name, this.zzaa, Boolean.valueOf(this.zzab), Integer.valueOf(this.weight), Boolean.valueOf(this.zzac), this.zzaf, Integer.valueOf(Arrays.hashCode(this.zzag)), this.zzae, this.zzah);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzt)) {
            return false;
        }
        zzt zzt = (zzt) obj;
        return this.zzab == zzt.zzab && this.weight == zzt.weight && this.zzac == zzt.zzac && Objects.equal(this.name, zzt.name) && Objects.equal(this.zzaa, zzt.zzaa) && Objects.equal(this.zzaf, zzt.zzaf) && Objects.equal(this.zzae, zzt.zzae) && Objects.equal(this.zzah, zzt.zzah) && Arrays.equals(this.zzag, zzt.zzag);
    }
}
