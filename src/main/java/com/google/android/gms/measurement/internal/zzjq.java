package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class zzjq implements Parcelable.Creator<zzjn> {
    public final /* synthetic */ Object[] newArray(int i) {
        return new zzjn[i];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        Parcel parcel2 = parcel;
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        String str = null;
        Long l = null;
        Float f2 = null;
        String str2 = null;
        String str3 = null;
        Double d2 = null;
        long j = 0;
        int i = 0;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(readHeader)) {
                case 1:
                    i = SafeParcelReader.readInt(parcel2, readHeader);
                    break;
                case 2:
                    str = SafeParcelReader.createString(parcel2, readHeader);
                    break;
                case 3:
                    j = SafeParcelReader.readLong(parcel2, readHeader);
                    break;
                case 4:
                    l = SafeParcelReader.readLongObject(parcel2, readHeader);
                    break;
                case 5:
                    f2 = SafeParcelReader.readFloatObject(parcel2, readHeader);
                    break;
                case 6:
                    str2 = SafeParcelReader.createString(parcel2, readHeader);
                    break;
                case 7:
                    str3 = SafeParcelReader.createString(parcel2, readHeader);
                    break;
                case 8:
                    d2 = SafeParcelReader.readDoubleObject(parcel2, readHeader);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel2, readHeader);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel2, validateObjectHeader);
        return new zzjn(i, str, j, l, f2, str2, str3, d2);
    }
}
