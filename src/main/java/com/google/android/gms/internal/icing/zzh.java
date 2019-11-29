package com.google.android.gms.internal.icing;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Arrays;
import java.util.BitSet;

@ShowFirstParty
@SafeParcelable.Class(creator = "DocumentContentsCreator")
@SafeParcelable.Reserved({1000})
public final class zzh extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzh> CREATOR = new zzj();
    @SafeParcelable.Field(id = 4)
    private final Account account;
    @SafeParcelable.Field(id = 2)
    private final String zzj;
    @SafeParcelable.Field(id = 3)
    private final boolean zzk;
    @SafeParcelable.Field(id = 1)
    private final zzk[] zzl;

    @SafeParcelable.Constructor
    zzh(@SafeParcelable.Param(id = 1) zzk[] zzkArr, @SafeParcelable.Param(id = 2) String str, @SafeParcelable.Param(id = 3) boolean z, @SafeParcelable.Param(id = 4) Account account2) {
        this.zzl = zzkArr;
        this.zzj = str;
        this.zzk = z;
        this.account = account2;
    }

    zzh(String str, boolean z, Account account2, zzk... zzkArr) {
        this(zzkArr, str, z, account2);
        if (zzkArr != null) {
            BitSet bitSet = new BitSet(zzq.zzy.length);
            for (zzk zzk2 : zzkArr) {
                int i = zzk2.zzs;
                if (i != -1) {
                    if (bitSet.get(i)) {
                        String valueOf = String.valueOf(zzq.zza(i));
                        throw new IllegalArgumentException(valueOf.length() != 0 ? "Duplicate global search section type ".concat(valueOf) : new String("Duplicate global search section type "));
                    }
                    bitSet.set(i);
                }
            }
        }
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeTypedArray(parcel, 1, this.zzl, i, false);
        SafeParcelWriter.writeString(parcel, 2, this.zzj, false);
        SafeParcelWriter.writeBoolean(parcel, 3, this.zzk);
        SafeParcelWriter.writeParcelable(parcel, 4, this.account, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final int hashCode() {
        return Objects.hashCode(this.zzj, Boolean.valueOf(this.zzk), this.account, Integer.valueOf(Arrays.hashCode(this.zzl)));
    }

    public final boolean equals(Object obj) {
        if (obj instanceof zzh) {
            zzh zzh = (zzh) obj;
            if (!Objects.equal(this.zzj, zzh.zzj) || !Objects.equal(Boolean.valueOf(this.zzk), Boolean.valueOf(zzh.zzk)) || !Objects.equal(this.account, zzh.account) || !Arrays.equals(this.zzl, zzh.zzl)) {
                return false;
            }
            return true;
        }
        return false;
    }
}
