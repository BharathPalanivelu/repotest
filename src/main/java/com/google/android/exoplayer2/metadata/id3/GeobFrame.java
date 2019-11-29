package com.google.android.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.s.v;
import java.util.Arrays;

public final class GeobFrame extends Id3Frame {
    public static final Parcelable.Creator<GeobFrame> CREATOR = new Parcelable.Creator<GeobFrame>() {
        /* renamed from: a */
        public GeobFrame createFromParcel(Parcel parcel) {
            return new GeobFrame(parcel);
        }

        /* renamed from: a */
        public GeobFrame[] newArray(int i) {
            return new GeobFrame[i];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    public final String f10869a;

    /* renamed from: b  reason: collision with root package name */
    public final String f10870b;

    /* renamed from: c  reason: collision with root package name */
    public final String f10871c;

    /* renamed from: d  reason: collision with root package name */
    public final byte[] f10872d;

    public GeobFrame(String str, String str2, String str3, byte[] bArr) {
        super("GEOB");
        this.f10869a = str;
        this.f10870b = str2;
        this.f10871c = str3;
        this.f10872d = bArr;
    }

    GeobFrame(Parcel parcel) {
        super("GEOB");
        this.f10869a = parcel.readString();
        this.f10870b = parcel.readString();
        this.f10871c = parcel.readString();
        this.f10872d = parcel.createByteArray();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        GeobFrame geobFrame = (GeobFrame) obj;
        if (!v.a((Object) this.f10869a, (Object) geobFrame.f10869a) || !v.a((Object) this.f10870b, (Object) geobFrame.f10870b) || !v.a((Object) this.f10871c, (Object) geobFrame.f10871c) || !Arrays.equals(this.f10872d, geobFrame.f10872d)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        String str = this.f10869a;
        int i = 0;
        int hashCode = (527 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.f10870b;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.f10871c;
        if (str3 != null) {
            i = str3.hashCode();
        }
        return ((hashCode2 + i) * 31) + Arrays.hashCode(this.f10872d);
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f10869a);
        parcel.writeString(this.f10870b);
        parcel.writeString(this.f10871c);
        parcel.writeByteArray(this.f10872d);
    }
}
