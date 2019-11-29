package com.google.android.gms.location.places.internal;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Locale;

@SafeParcelable.Class(creator = "PlacesParamsCreator")
@SafeParcelable.Reserved({1000, 5})
public final class zzau extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzau> CREATOR = new zzat();
    private static final zzau zzcw = new zzau("com.google.android.gms", Locale.getDefault(), (String) null);
    @SafeParcelable.Field(id = 4)
    private final String zzat;
    @SafeParcelable.Field(id = 7)
    private final int zzau;
    @SafeParcelable.Field(id = 3)
    private final String zzav;
    @SafeParcelable.Field(id = 1)
    private final String zzcx;
    @SafeParcelable.Field(id = 2)
    private final String zzcy;
    @SafeParcelable.Field(id = 6)
    private final int zzcz;

    @SafeParcelable.Constructor
    public zzau(@SafeParcelable.Param(id = 1) String str, @SafeParcelable.Param(id = 2) String str2, @SafeParcelable.Param(id = 3) String str3, @SafeParcelable.Param(id = 4) String str4, @SafeParcelable.Param(id = 6) int i, @SafeParcelable.Param(id = 7) int i2) {
        this.zzcx = str;
        this.zzcy = str2;
        this.zzav = str3;
        this.zzat = str4;
        this.zzcz = i;
        this.zzau = i2;
    }

    private zzau(String str, Locale locale, String str2) {
        this(str, zzb(locale), (String) null, (String) null, GoogleApiAvailability.GOOGLE_PLAY_SERVICES_VERSION_CODE, 0);
    }

    public zzau(String str, Locale locale, String str2, String str3, int i) {
        this(str, zzb(locale), str2, str3, GoogleApiAvailability.GOOGLE_PLAY_SERVICES_VERSION_CODE, i);
    }

    @SuppressLint({"DefaultLocale"})
    public final String toString() {
        return Objects.toStringHelper(this).add("clientPackageName", this.zzcx).add("locale", this.zzcy).add("accountName", this.zzav).add("gCoreClientName", this.zzat).toString();
    }

    public final int hashCode() {
        return Objects.hashCode(this.zzcx, this.zzcy, this.zzav, this.zzat, Integer.valueOf(this.zzcz), Integer.valueOf(this.zzau));
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && (obj instanceof zzau)) {
            zzau zzau2 = (zzau) obj;
            return this.zzcz == zzau2.zzcz && this.zzau == zzau2.zzau && this.zzcy.equals(zzau2.zzcy) && this.zzcx.equals(zzau2.zzcx) && Objects.equal(this.zzav, zzau2.zzav) && Objects.equal(this.zzat, zzau2.zzat);
        }
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.zzcx, false);
        SafeParcelWriter.writeString(parcel, 2, this.zzcy, false);
        SafeParcelWriter.writeString(parcel, 3, this.zzav, false);
        SafeParcelWriter.writeString(parcel, 4, this.zzat, false);
        SafeParcelWriter.writeInt(parcel, 6, this.zzcz);
        SafeParcelWriter.writeInt(parcel, 7, this.zzau);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    private static String zzb(Locale locale) {
        if (Build.VERSION.SDK_INT >= 21) {
            return locale.toLanguageTag();
        }
        String language = locale.getLanguage();
        String str = "";
        if (language == null) {
            language = str;
        }
        String country = locale.getCountry();
        if (country == null) {
            country = str;
        }
        String valueOf = String.valueOf(language);
        if (country.length() > 0) {
            String valueOf2 = String.valueOf(country);
            str = valueOf2.length() != 0 ? "-".concat(valueOf2) : new String("-");
        }
        String valueOf3 = String.valueOf(str);
        return valueOf3.length() != 0 ? valueOf.concat(valueOf3) : new String(valueOf);
    }
}
