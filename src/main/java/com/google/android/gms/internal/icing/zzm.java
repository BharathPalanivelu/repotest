package com.google.android.gms.internal.icing;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;

@ShowFirstParty
@SafeParcelable.Class(creator = "FeatureCreator")
@SafeParcelable.Reserved({1000})
public final class zzm extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzm> CREATOR = new zzp();
    @SafeParcelable.Field(id = 1)
    private final int id;
    @SafeParcelable.Field(id = 2)
    private final Bundle zzu;

    @SafeParcelable.Constructor
    zzm(@SafeParcelable.Param(id = 1) int i, @SafeParcelable.Param(id = 2) Bundle bundle) {
        this.id = i;
        this.zzu = bundle;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.id);
        SafeParcelWriter.writeBundle(parcel, 2, this.zzu, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final int hashCode() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(Integer.valueOf(this.id));
        Bundle bundle = this.zzu;
        if (bundle != null) {
            for (String str : bundle.keySet()) {
                arrayList.add(str);
                arrayList.add(this.zzu.getString(str));
            }
        }
        return Objects.hashCode(arrayList.toArray(new Object[0]));
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzm)) {
            return false;
        }
        zzm zzm = (zzm) obj;
        if (this.id != zzm.id) {
            return false;
        }
        Bundle bundle = this.zzu;
        if (bundle == null) {
            return zzm.zzu == null;
        }
        if (zzm.zzu == null || bundle.size() != zzm.zzu.size()) {
            return false;
        }
        for (String str : this.zzu.keySet()) {
            if (zzm.zzu.containsKey(str)) {
                if (!Objects.equal(this.zzu.getString(str), zzm.zzu.getString(str))) {
                }
            }
            return false;
        }
        return true;
    }
}
