package com.google.android.exoplayer2.f.b;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;

public final class b extends h {
    public static final Parcelable.Creator<b> CREATOR = new Parcelable.Creator<b>() {
        /* renamed from: a */
        public b createFromParcel(Parcel parcel) {
            return new b(parcel);
        }

        /* renamed from: a */
        public b[] newArray(int i) {
            return new b[i];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    public final byte[] f9795a;

    public b(String str, byte[] bArr) {
        super(str);
        this.f9795a = bArr;
    }

    b(Parcel parcel) {
        super(parcel.readString());
        this.f9795a = parcel.createByteArray();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        b bVar = (b) obj;
        if (!this.f9819f.equals(bVar.f9819f) || !Arrays.equals(this.f9795a, bVar.f9795a)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return ((527 + this.f9819f.hashCode()) * 31) + Arrays.hashCode(this.f9795a);
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f9819f);
        parcel.writeByteArray(this.f9795a);
    }
}
