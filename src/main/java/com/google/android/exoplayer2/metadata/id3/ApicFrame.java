package com.google.android.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.s.v;
import java.util.Arrays;

public final class ApicFrame extends Id3Frame {
    public static final Parcelable.Creator<ApicFrame> CREATOR = new Parcelable.Creator<ApicFrame>() {
        /* renamed from: a */
        public ApicFrame createFromParcel(Parcel parcel) {
            return new ApicFrame(parcel);
        }

        /* renamed from: a */
        public ApicFrame[] newArray(int i) {
            return new ApicFrame[i];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    public final String f10850a;

    /* renamed from: b  reason: collision with root package name */
    public final String f10851b;

    /* renamed from: c  reason: collision with root package name */
    public final int f10852c;

    /* renamed from: d  reason: collision with root package name */
    public final byte[] f10853d;

    public ApicFrame(String str, String str2, int i, byte[] bArr) {
        super("APIC");
        this.f10850a = str;
        this.f10851b = str2;
        this.f10852c = i;
        this.f10853d = bArr;
    }

    ApicFrame(Parcel parcel) {
        super("APIC");
        this.f10850a = parcel.readString();
        this.f10851b = parcel.readString();
        this.f10852c = parcel.readInt();
        this.f10853d = parcel.createByteArray();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ApicFrame apicFrame = (ApicFrame) obj;
        if (this.f10852c != apicFrame.f10852c || !v.a((Object) this.f10850a, (Object) apicFrame.f10850a) || !v.a((Object) this.f10851b, (Object) apicFrame.f10851b) || !Arrays.equals(this.f10853d, apicFrame.f10853d)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = (527 + this.f10852c) * 31;
        String str = this.f10850a;
        int i2 = 0;
        int hashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.f10851b;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        return ((hashCode + i2) * 31) + Arrays.hashCode(this.f10853d);
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f10850a);
        parcel.writeString(this.f10851b);
        parcel.writeInt(this.f10852c);
        parcel.writeByteArray(this.f10853d);
    }
}
