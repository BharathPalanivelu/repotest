package com.google.android.gms.internal.icing;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.util.VisibleForTesting;

@ShowFirstParty
@SafeParcelable.Class(creator = "DocumentSectionCreator")
@SafeParcelable.Reserved({1000})
public final class zzk extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzk> CREATOR = new zzn();
    private static final int zzo = Integer.parseInt("-1");
    private static final zzt zzp = new zzs("SsbContext").zzb(true).zzc("blob").zzc();
    @SafeParcelable.Field(id = 1)
    private final String zzq;
    @SafeParcelable.Field(id = 3)
    private final zzt zzr;
    @SafeParcelable.Field(defaultValue = "-1", id = 4)
    public final int zzs;
    @SafeParcelable.Field(id = 5)
    private final byte[] zzt;

    @SafeParcelable.Constructor
    zzk(@SafeParcelable.Param(id = 1) String str, @SafeParcelable.Param(id = 3) zzt zzt2, @SafeParcelable.Param(id = 4) int i, @SafeParcelable.Param(id = 5) byte[] bArr) {
        String str2;
        boolean z = i == zzo || zzq.zza(i) != null;
        StringBuilder sb = new StringBuilder(32);
        sb.append("Invalid section type ");
        sb.append(i);
        Preconditions.checkArgument(z, sb.toString());
        this.zzq = str;
        this.zzr = zzt2;
        this.zzs = i;
        this.zzt = bArr;
        int i2 = this.zzs;
        if (i2 == zzo || zzq.zza(i2) != null) {
            str2 = (this.zzq == null || this.zzt == null) ? null : "Both content and blobContent set";
        } else {
            int i3 = this.zzs;
            StringBuilder sb2 = new StringBuilder(32);
            sb2.append("Invalid section type ");
            sb2.append(i3);
            str2 = sb2.toString();
        }
        if (str2 != null) {
            throw new IllegalArgumentException(str2);
        }
    }

    public zzk(String str, zzt zzt2) {
        this(str, zzt2, zzo, (byte[]) null);
    }

    @VisibleForTesting
    public zzk(String str, zzt zzt2, String str2) {
        this(str, zzt2, zzq.zzb(str2), (byte[]) null);
    }

    public zzk(byte[] bArr, zzt zzt2) {
        this((String) null, zzt2, zzo, bArr);
    }

    public static zzk zza(byte[] bArr) {
        return new zzk(bArr, zzp);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.zzq, false);
        SafeParcelWriter.writeParcelable(parcel, 3, this.zzr, i, false);
        SafeParcelWriter.writeInt(parcel, 4, this.zzs);
        SafeParcelWriter.writeByteArray(parcel, 5, this.zzt, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
