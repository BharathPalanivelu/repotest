package com.google.android.exoplayer2.f.b;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.n.t;
import java.util.Arrays;

public final class a extends h {
    public static final Parcelable.Creator<a> CREATOR = new Parcelable.Creator<a>() {
        /* renamed from: a */
        public a createFromParcel(Parcel parcel) {
            return new a(parcel);
        }

        /* renamed from: a */
        public a[] newArray(int i) {
            return new a[i];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    public final String f9791a;

    /* renamed from: b  reason: collision with root package name */
    public final String f9792b;

    /* renamed from: c  reason: collision with root package name */
    public final int f9793c;

    /* renamed from: d  reason: collision with root package name */
    public final byte[] f9794d;

    public a(String str, String str2, int i, byte[] bArr) {
        super("APIC");
        this.f9791a = str;
        this.f9792b = str2;
        this.f9793c = i;
        this.f9794d = bArr;
    }

    a(Parcel parcel) {
        super("APIC");
        this.f9791a = parcel.readString();
        this.f9792b = parcel.readString();
        this.f9793c = parcel.readInt();
        this.f9794d = parcel.createByteArray();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        a aVar = (a) obj;
        if (this.f9793c != aVar.f9793c || !t.a((Object) this.f9791a, (Object) aVar.f9791a) || !t.a((Object) this.f9792b, (Object) aVar.f9792b) || !Arrays.equals(this.f9794d, aVar.f9794d)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = (527 + this.f9793c) * 31;
        String str = this.f9791a;
        int i2 = 0;
        int hashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.f9792b;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        return ((hashCode + i2) * 31) + Arrays.hashCode(this.f9794d);
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f9791a);
        parcel.writeString(this.f9792b);
        parcel.writeInt(this.f9793c);
        parcel.writeByteArray(this.f9794d);
    }
}
