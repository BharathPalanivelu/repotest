package com.google.android.exoplayer2.f.b;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.n.t;
import java.util.Arrays;

public final class i extends h {
    public static final Parcelable.Creator<i> CREATOR = new Parcelable.Creator<i>() {
        /* renamed from: a */
        public i createFromParcel(Parcel parcel) {
            return new i(parcel);
        }

        /* renamed from: a */
        public i[] newArray(int i) {
            return new i[i];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    public final String f9820a;

    /* renamed from: b  reason: collision with root package name */
    public final byte[] f9821b;

    public i(String str, byte[] bArr) {
        super("PRIV");
        this.f9820a = str;
        this.f9821b = bArr;
    }

    i(Parcel parcel) {
        super("PRIV");
        this.f9820a = parcel.readString();
        this.f9821b = parcel.createByteArray();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        i iVar = (i) obj;
        if (!t.a((Object) this.f9820a, (Object) iVar.f9820a) || !Arrays.equals(this.f9821b, iVar.f9821b)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        String str = this.f9820a;
        return ((527 + (str != null ? str.hashCode() : 0)) * 31) + Arrays.hashCode(this.f9821b);
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f9820a);
        parcel.writeByteArray(this.f9821b);
    }
}
