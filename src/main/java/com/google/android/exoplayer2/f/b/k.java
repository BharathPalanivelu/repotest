package com.google.android.exoplayer2.f.b;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.n.t;

public final class k extends h {
    public static final Parcelable.Creator<k> CREATOR = new Parcelable.Creator<k>() {
        /* renamed from: a */
        public k createFromParcel(Parcel parcel) {
            return new k(parcel);
        }

        /* renamed from: a */
        public k[] newArray(int i) {
            return new k[i];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    public final String f9824a;

    /* renamed from: b  reason: collision with root package name */
    public final String f9825b;

    public k(String str, String str2, String str3) {
        super(str);
        this.f9824a = str2;
        this.f9825b = str3;
    }

    k(Parcel parcel) {
        super(parcel.readString());
        this.f9824a = parcel.readString();
        this.f9825b = parcel.readString();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        k kVar = (k) obj;
        if (!this.f9819f.equals(kVar.f9819f) || !t.a((Object) this.f9824a, (Object) kVar.f9824a) || !t.a((Object) this.f9825b, (Object) kVar.f9825b)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int hashCode = (527 + this.f9819f.hashCode()) * 31;
        String str = this.f9824a;
        int i = 0;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.f9825b;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode2 + i;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f9819f);
        parcel.writeString(this.f9824a);
        parcel.writeString(this.f9825b);
    }
}
