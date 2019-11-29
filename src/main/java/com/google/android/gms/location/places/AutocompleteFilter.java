package com.google.android.gms.location.places;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.appevents.UserDataStore;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Arrays;
import java.util.List;

@SafeParcelable.Class(creator = "AutocompleteFilterCreator")
@Deprecated
public class AutocompleteFilter extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<AutocompleteFilter> CREATOR = new zzd();
    public static final int TYPE_FILTER_ADDRESS = 2;
    public static final int TYPE_FILTER_CITIES = 5;
    public static final int TYPE_FILTER_ESTABLISHMENT = 34;
    public static final int TYPE_FILTER_GEOCODE = 1007;
    public static final int TYPE_FILTER_NONE = 0;
    public static final int TYPE_FILTER_REGIONS = 4;
    @SafeParcelable.VersionField(id = 1000)
    private final int versionCode;
    @SafeParcelable.Field(id = 1)
    private final boolean zzj;
    @SafeParcelable.Field(id = 2)
    private final List<Integer> zzk;
    @SafeParcelable.Field(id = 3)
    private final String zzl;
    private final int zzm;

    @SafeParcelable.Constructor
    AutocompleteFilter(@SafeParcelable.Param(id = 1000) int i, @SafeParcelable.Param(id = 1) boolean z, @SafeParcelable.Param(id = 2) List<Integer> list, @SafeParcelable.Param(id = 3) String str) {
        this.versionCode = i;
        this.zzk = list;
        this.zzm = (list == null || list.isEmpty()) ? 0 : list.iterator().next().intValue();
        this.zzl = str;
        if (this.versionCode <= 0) {
            this.zzj = !z;
        } else {
            this.zzj = z;
        }
    }

    public static final class Builder {
        private boolean zzj = false;
        private String zzl = "";
        private int zzm = 0;

        public final Builder setTypeFilter(int i) {
            this.zzm = i;
            return this;
        }

        public final Builder setCountry(String str) {
            this.zzl = str;
            return this;
        }

        public final AutocompleteFilter build() {
            return new AutocompleteFilter(1, false, Arrays.asList(new Integer[]{Integer.valueOf(this.zzm)}), this.zzl);
        }
    }

    public int getTypeFilter() {
        return this.zzm;
    }

    public int hashCode() {
        return Objects.hashCode(Boolean.valueOf(this.zzj), Integer.valueOf(this.zzm), this.zzl);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AutocompleteFilter)) {
            return false;
        }
        AutocompleteFilter autocompleteFilter = (AutocompleteFilter) obj;
        return this.zzm == autocompleteFilter.zzm && this.zzj == autocompleteFilter.zzj && this.zzl == autocompleteFilter.zzl;
    }

    public String toString() {
        return Objects.toStringHelper(this).add("includeQueryPredictions", Boolean.valueOf(this.zzj)).add("typeFilter", Integer.valueOf(this.zzm)).add(UserDataStore.COUNTRY, this.zzl).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeBoolean(parcel, 1, this.zzj);
        SafeParcelWriter.writeIntegerList(parcel, 2, this.zzk, false);
        SafeParcelWriter.writeString(parcel, 3, this.zzl, false);
        SafeParcelWriter.writeInt(parcel, 1000, this.versionCode);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
