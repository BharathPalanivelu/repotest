package com.google.android.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.s.v;
import java.util.Arrays;

public final class PrivFrame extends Id3Frame {
    public static final Parcelable.Creator<PrivFrame> CREATOR = new Parcelable.Creator<PrivFrame>() {
        /* renamed from: a */
        public PrivFrame createFromParcel(Parcel parcel) {
            return new PrivFrame(parcel);
        }

        /* renamed from: a */
        public PrivFrame[] newArray(int i) {
            return new PrivFrame[i];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    public final String f10874a;

    /* renamed from: b  reason: collision with root package name */
    public final byte[] f10875b;

    public PrivFrame(String str, byte[] bArr) {
        super("PRIV");
        this.f10874a = str;
        this.f10875b = bArr;
    }

    PrivFrame(Parcel parcel) {
        super("PRIV");
        this.f10874a = parcel.readString();
        this.f10875b = parcel.createByteArray();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        PrivFrame privFrame = (PrivFrame) obj;
        if (!v.a((Object) this.f10874a, (Object) privFrame.f10874a) || !Arrays.equals(this.f10875b, privFrame.f10875b)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        String str = this.f10874a;
        return ((527 + (str != null ? str.hashCode() : 0)) * 31) + Arrays.hashCode(this.f10875b);
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f10874a);
        parcel.writeByteArray(this.f10875b);
    }
}
