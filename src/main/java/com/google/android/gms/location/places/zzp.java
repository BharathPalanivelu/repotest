package com.google.android.gms.location.places;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.util.CollectionUtils;
import java.util.Set;

@ShowFirstParty
@SafeParcelable.Class(creator = "UserDataTypeCreator")
@SafeParcelable.Reserved({1000})
public final class zzp extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzp> CREATOR = new zzo();
    private static final zzp zzaw = zzb("test_type", 1);
    private static final zzp zzax = zzb("labeled_place", 6);
    private static final zzp zzay = zzb("here_content", 7);
    private static final Set<zzp> zzaz = CollectionUtils.setOf(zzaw, zzax, zzay);
    @SafeParcelable.Field(id = 1)
    private final String type;
    @SafeParcelable.Field(id = 2)
    private final int zzba;

    @SafeParcelable.Constructor
    zzp(@SafeParcelable.Param(id = 1) String str, @SafeParcelable.Param(id = 2) int i) {
        Preconditions.checkNotEmpty(str);
        this.type = str;
        this.zzba = i;
    }

    private static zzp zzb(String str, int i) {
        return new zzp(str, i);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzp)) {
            return false;
        }
        zzp zzp = (zzp) obj;
        return this.type.equals(zzp.type) && this.zzba == zzp.zzba;
    }

    public final int hashCode() {
        return this.type.hashCode();
    }

    public final String toString() {
        return this.type;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.type, false);
        SafeParcelWriter.writeInt(parcel, 2, this.zzba);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
