package com.google.android.gms.internal.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.location.Geofence;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.util.Locale;

@SafeParcelable.Class(creator = "ParcelableGeofenceCreator")
@SafeParcelable.Reserved({1000})
@VisibleForTesting
public final class zzbh extends AbstractSafeParcelable implements Geofence {
    public static final Parcelable.Creator<zzbh> CREATOR = new zzbi();
    @SafeParcelable.Field(getter = "getRequestId", id = 1)
    private final String zzad;
    @SafeParcelable.Field(getter = "getTransitionTypes", id = 7)
    private final int zzae;
    @SafeParcelable.Field(getter = "getType", id = 3)
    private final short zzag;
    @SafeParcelable.Field(getter = "getLatitude", id = 4)
    private final double zzah;
    @SafeParcelable.Field(getter = "getLongitude", id = 5)
    private final double zzai;
    @SafeParcelable.Field(getter = "getRadius", id = 6)
    private final float zzaj;
    @SafeParcelable.Field(defaultValue = "0", getter = "getNotificationResponsiveness", id = 8)
    private final int zzak;
    @SafeParcelable.Field(defaultValue = "-1", getter = "getLoiteringDelay", id = 9)
    private final int zzal;
    @SafeParcelable.Field(getter = "getExpirationTime", id = 2)
    private final long zzdo;

    @SafeParcelable.Constructor
    public zzbh(@SafeParcelable.Param(id = 1) String str, @SafeParcelable.Param(id = 7) int i, @SafeParcelable.Param(id = 3) short s, @SafeParcelable.Param(id = 4) double d2, @SafeParcelable.Param(id = 5) double d3, @SafeParcelable.Param(id = 6) float f2, @SafeParcelable.Param(id = 2) long j, @SafeParcelable.Param(id = 8) int i2, @SafeParcelable.Param(id = 9) int i3) {
        if (str == null || str.length() > 100) {
            String valueOf = String.valueOf(str);
            throw new IllegalArgumentException(valueOf.length() != 0 ? "requestId is null or too long: ".concat(valueOf) : new String("requestId is null or too long: "));
        } else if (f2 <= BitmapDescriptorFactory.HUE_RED) {
            StringBuilder sb = new StringBuilder(31);
            sb.append("invalid radius: ");
            sb.append(f2);
            throw new IllegalArgumentException(sb.toString());
        } else if (d2 > 90.0d || d2 < -90.0d) {
            StringBuilder sb2 = new StringBuilder(42);
            sb2.append("invalid latitude: ");
            sb2.append(d2);
            throw new IllegalArgumentException(sb2.toString());
        } else if (d3 > 180.0d || d3 < -180.0d) {
            StringBuilder sb3 = new StringBuilder(43);
            sb3.append("invalid longitude: ");
            sb3.append(d3);
            throw new IllegalArgumentException(sb3.toString());
        } else {
            int i4 = i & 7;
            if (i4 != 0) {
                this.zzag = s;
                this.zzad = str;
                this.zzah = d2;
                this.zzai = d3;
                this.zzaj = f2;
                this.zzdo = j;
                this.zzae = i4;
                this.zzak = i2;
                this.zzal = i3;
                return;
            }
            StringBuilder sb4 = new StringBuilder(46);
            sb4.append("No supported transition specified: ");
            sb4.append(i);
            throw new IllegalArgumentException(sb4.toString());
        }
    }

    public static zzbh zza(byte[] bArr) {
        Parcel obtain = Parcel.obtain();
        obtain.unmarshall(bArr, 0, bArr.length);
        obtain.setDataPosition(0);
        zzbh createFromParcel = CREATOR.createFromParcel(obtain);
        obtain.recycle();
        return createFromParcel;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof zzbh)) {
            return false;
        }
        zzbh zzbh = (zzbh) obj;
        return this.zzaj == zzbh.zzaj && this.zzah == zzbh.zzah && this.zzai == zzbh.zzai && this.zzag == zzbh.zzag;
    }

    public final String getRequestId() {
        return this.zzad;
    }

    public final int hashCode() {
        long doubleToLongBits = Double.doubleToLongBits(this.zzah);
        long doubleToLongBits2 = Double.doubleToLongBits(this.zzai);
        return ((((((((((int) (doubleToLongBits ^ (doubleToLongBits >>> 32))) + 31) * 31) + ((int) (doubleToLongBits2 ^ (doubleToLongBits2 >>> 32)))) * 31) + Float.floatToIntBits(this.zzaj)) * 31) + this.zzag) * 31) + this.zzae;
    }

    public final String toString() {
        Locale locale = Locale.US;
        Object[] objArr = new Object[9];
        objArr[0] = this.zzag != 1 ? null : "CIRCLE";
        objArr[1] = this.zzad.replaceAll("\\p{C}", "?");
        objArr[2] = Integer.valueOf(this.zzae);
        objArr[3] = Double.valueOf(this.zzah);
        objArr[4] = Double.valueOf(this.zzai);
        objArr[5] = Float.valueOf(this.zzaj);
        objArr[6] = Integer.valueOf(this.zzak / 1000);
        objArr[7] = Integer.valueOf(this.zzal);
        objArr[8] = Long.valueOf(this.zzdo);
        return String.format(locale, "Geofence[%s id:%s transitions:%d %.6f, %.6f %.0fm, resp=%ds, dwell=%dms, @%d]", objArr);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, getRequestId(), false);
        SafeParcelWriter.writeLong(parcel, 2, this.zzdo);
        SafeParcelWriter.writeShort(parcel, 3, this.zzag);
        SafeParcelWriter.writeDouble(parcel, 4, this.zzah);
        SafeParcelWriter.writeDouble(parcel, 5, this.zzai);
        SafeParcelWriter.writeFloat(parcel, 6, this.zzaj);
        SafeParcelWriter.writeInt(parcel, 7, this.zzae);
        SafeParcelWriter.writeInt(parcel, 8, this.zzak);
        SafeParcelWriter.writeInt(parcel, 9, this.zzal);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
