package com.google.android.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;

public final class BinaryFrame extends Id3Frame {
    public static final Parcelable.Creator<BinaryFrame> CREATOR = new Parcelable.Creator<BinaryFrame>() {
        /* renamed from: a */
        public BinaryFrame createFromParcel(Parcel parcel) {
            return new BinaryFrame(parcel);
        }

        /* renamed from: a */
        public BinaryFrame[] newArray(int i) {
            return new BinaryFrame[i];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    public final byte[] f10854a;

    public BinaryFrame(String str, byte[] bArr) {
        super(str);
        this.f10854a = bArr;
    }

    BinaryFrame(Parcel parcel) {
        super(parcel.readString());
        this.f10854a = parcel.createByteArray();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        BinaryFrame binaryFrame = (BinaryFrame) obj;
        if (!this.f10873f.equals(binaryFrame.f10873f) || !Arrays.equals(this.f10854a, binaryFrame.f10854a)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return ((527 + this.f10873f.hashCode()) * 31) + Arrays.hashCode(this.f10854a);
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f10873f);
        parcel.writeByteArray(this.f10854a);
    }
}
