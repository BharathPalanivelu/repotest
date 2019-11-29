package com.google.android.exoplayer2.f.b;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.n.t;
import java.util.Arrays;

public final class f extends h {
    public static final Parcelable.Creator<f> CREATOR = new Parcelable.Creator<f>() {
        /* renamed from: a */
        public f createFromParcel(Parcel parcel) {
            return new f(parcel);
        }

        /* renamed from: a */
        public f[] newArray(int i) {
            return new f[i];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    public final String f9810a;

    /* renamed from: b  reason: collision with root package name */
    public final String f9811b;

    /* renamed from: c  reason: collision with root package name */
    public final String f9812c;

    /* renamed from: d  reason: collision with root package name */
    public final byte[] f9813d;

    public f(String str, String str2, String str3, byte[] bArr) {
        super("GEOB");
        this.f9810a = str;
        this.f9811b = str2;
        this.f9812c = str3;
        this.f9813d = bArr;
    }

    f(Parcel parcel) {
        super("GEOB");
        this.f9810a = parcel.readString();
        this.f9811b = parcel.readString();
        this.f9812c = parcel.readString();
        this.f9813d = parcel.createByteArray();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        f fVar = (f) obj;
        if (!t.a((Object) this.f9810a, (Object) fVar.f9810a) || !t.a((Object) this.f9811b, (Object) fVar.f9811b) || !t.a((Object) this.f9812c, (Object) fVar.f9812c) || !Arrays.equals(this.f9813d, fVar.f9813d)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        String str = this.f9810a;
        int i = 0;
        int hashCode = (527 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.f9811b;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.f9812c;
        if (str3 != null) {
            i = str3.hashCode();
        }
        return ((hashCode2 + i) * 31) + Arrays.hashCode(this.f9813d);
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f9810a);
        parcel.writeString(this.f9811b);
        parcel.writeString(this.f9812c);
        parcel.writeByteArray(this.f9813d);
    }
}
