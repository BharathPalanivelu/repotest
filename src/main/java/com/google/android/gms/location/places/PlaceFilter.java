package com.google.android.gms.location.places;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Collection;
import java.util.List;
import java.util.Set;

@SafeParcelable.Class(creator = "PlaceFilterCreator")
@SafeParcelable.Reserved({1000, 2, 5})
@Deprecated
public final class PlaceFilter extends zzb {
    public static final Parcelable.Creator<PlaceFilter> CREATOR = new zzi();
    private static final PlaceFilter zzr = new PlaceFilter();
    @SafeParcelable.Field(id = 1)
    private final List<Integer> zzs;
    @SafeParcelable.Field(id = 3)
    private final boolean zzt;
    @SafeParcelable.Field(id = 4)
    private final List<zzp> zzu;
    @SafeParcelable.Field(id = 6)
    private final List<String> zzv;
    private final Set<Integer> zzw;
    private final Set<zzp> zzx;
    private final Set<String> zzy;

    @ShowFirstParty
    @Deprecated
    public static final class zzb {
        private Collection<zzp> zzaa;
        private String[] zzab;
        private boolean zzt;
        private Collection<Integer> zzz;

        private zzb() {
            this.zzz = null;
            this.zzt = false;
            this.zzaa = null;
            this.zzab = null;
        }
    }

    public PlaceFilter() {
        this(false, (Collection<String>) null);
    }

    public PlaceFilter(boolean z, Collection<String> collection) {
        this((Collection<Integer>) null, z, collection, (Collection<zzp>) null);
    }

    @ShowFirstParty
    private PlaceFilter(Collection<Integer> collection, boolean z, Collection<String> collection2, Collection<zzp> collection3) {
        this((List<Integer>) zzb((Collection) null), z, zzb(collection2), (List<zzp>) zzb((Collection) null));
    }

    @SafeParcelable.Constructor
    PlaceFilter(@SafeParcelable.Param(id = 1) List<Integer> list, @SafeParcelable.Param(id = 3) boolean z, @SafeParcelable.Param(id = 6) List<String> list2, @SafeParcelable.Param(id = 4) List<zzp> list3) {
        this.zzs = list;
        this.zzt = z;
        this.zzu = list3;
        this.zzv = list2;
        this.zzw = zzb(this.zzs);
        this.zzx = zzb(this.zzu);
        this.zzy = zzb(this.zzv);
    }

    public final Set<String> getPlaceIds() {
        return this.zzy;
    }

    public final boolean isRestrictedToPlacesOpenNow() {
        return this.zzt;
    }

    public final String toString() {
        Objects.ToStringHelper stringHelper = Objects.toStringHelper(this);
        if (!this.zzw.isEmpty()) {
            stringHelper.add("types", this.zzw);
        }
        stringHelper.add("requireOpenNow", Boolean.valueOf(this.zzt));
        if (!this.zzy.isEmpty()) {
            stringHelper.add("placeIds", this.zzy);
        }
        if (!this.zzx.isEmpty()) {
            stringHelper.add("requestedUserDataTypes", this.zzx);
        }
        return stringHelper.toString();
    }

    public final int hashCode() {
        return Objects.hashCode(this.zzw, Boolean.valueOf(this.zzt), this.zzx, this.zzy);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PlaceFilter)) {
            return false;
        }
        PlaceFilter placeFilter = (PlaceFilter) obj;
        return this.zzw.equals(placeFilter.zzw) && this.zzt == placeFilter.zzt && this.zzx.equals(placeFilter.zzx) && this.zzy.equals(placeFilter.zzy);
    }

    @ShowFirstParty
    @Deprecated
    public static PlaceFilter zzc() {
        new zzb();
        return new PlaceFilter((List<Integer>) null, false, (List<String>) null, (List<zzp>) null);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeIntegerList(parcel, 1, this.zzs, false);
        SafeParcelWriter.writeBoolean(parcel, 3, this.zzt);
        SafeParcelWriter.writeTypedList(parcel, 4, this.zzu, false);
        SafeParcelWriter.writeStringList(parcel, 6, this.zzv, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
