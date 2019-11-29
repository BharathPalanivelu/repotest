package com.google.android.exoplayer2.f.a;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.f.a;
import com.google.android.exoplayer2.n.t;
import java.util.Arrays;

public final class a implements a.C0166a {
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
    public final String f9782a;

    /* renamed from: b  reason: collision with root package name */
    public final String f9783b;

    /* renamed from: c  reason: collision with root package name */
    public final long f9784c;

    /* renamed from: d  reason: collision with root package name */
    public final long f9785d;

    /* renamed from: e  reason: collision with root package name */
    public final byte[] f9786e;

    /* renamed from: f  reason: collision with root package name */
    private int f9787f;

    public int describeContents() {
        return 0;
    }

    public a(String str, String str2, long j, long j2, byte[] bArr) {
        this.f9782a = str;
        this.f9783b = str2;
        this.f9784c = j;
        this.f9785d = j2;
        this.f9786e = bArr;
    }

    a(Parcel parcel) {
        this.f9782a = parcel.readString();
        this.f9783b = parcel.readString();
        this.f9784c = parcel.readLong();
        this.f9785d = parcel.readLong();
        this.f9786e = parcel.createByteArray();
    }

    public int hashCode() {
        if (this.f9787f == 0) {
            String str = this.f9782a;
            int i = 0;
            int hashCode = (527 + (str != null ? str.hashCode() : 0)) * 31;
            String str2 = this.f9783b;
            if (str2 != null) {
                i = str2.hashCode();
            }
            long j = this.f9784c;
            long j2 = this.f9785d;
            this.f9787f = ((((((hashCode + i) * 31) + ((int) (j ^ (j >>> 32)))) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31) + Arrays.hashCode(this.f9786e);
        }
        return this.f9787f;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        a aVar = (a) obj;
        if (this.f9784c != aVar.f9784c || this.f9785d != aVar.f9785d || !t.a((Object) this.f9782a, (Object) aVar.f9782a) || !t.a((Object) this.f9783b, (Object) aVar.f9783b) || !Arrays.equals(this.f9786e, aVar.f9786e)) {
            return false;
        }
        return true;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f9782a);
        parcel.writeString(this.f9783b);
        parcel.writeLong(this.f9784c);
        parcel.writeLong(this.f9785d);
        parcel.writeByteArray(this.f9786e);
    }
}
