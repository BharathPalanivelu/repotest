package com.google.android.gms.internal.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

public final class zzbi implements Parcelable.Creator<zzbh> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        Parcel parcel2 = parcel;
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        double d2 = 0.0d;
        double d3 = 0.0d;
        String str = null;
        long j = 0;
        int i = 0;
        short s = 0;
        float f2 = BitmapDescriptorFactory.HUE_RED;
        int i2 = 0;
        int i3 = -1;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(readHeader)) {
                case 1:
                    str = SafeParcelReader.createString(parcel2, readHeader);
                    break;
                case 2:
                    j = SafeParcelReader.readLong(parcel2, readHeader);
                    break;
                case 3:
                    s = SafeParcelReader.readShort(parcel2, readHeader);
                    break;
                case 4:
                    d2 = SafeParcelReader.readDouble(parcel2, readHeader);
                    break;
                case 5:
                    d3 = SafeParcelReader.readDouble(parcel2, readHeader);
                    break;
                case 6:
                    f2 = SafeParcelReader.readFloat(parcel2, readHeader);
                    break;
                case 7:
                    i = SafeParcelReader.readInt(parcel2, readHeader);
                    break;
                case 8:
                    i2 = SafeParcelReader.readInt(parcel2, readHeader);
                    break;
                case 9:
                    i3 = SafeParcelReader.readInt(parcel2, readHeader);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel2, readHeader);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel2, validateObjectHeader);
        return new zzbh(str, i, s, d2, d3, f2, j, i2, i3);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new zzbh[i];
    }
}
