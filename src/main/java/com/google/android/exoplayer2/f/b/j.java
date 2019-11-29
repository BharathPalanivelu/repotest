package com.google.android.exoplayer2.f.b;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.n.t;

public final class j extends h {
    public static final Parcelable.Creator<j> CREATOR = new Parcelable.Creator<j>() {
        /* renamed from: a */
        public j createFromParcel(Parcel parcel) {
            return new j(parcel);
        }

        /* renamed from: a */
        public j[] newArray(int i) {
            return new j[i];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    public final String f9822a;

    /* renamed from: b  reason: collision with root package name */
    public final String f9823b;

    public j(String str, String str2, String str3) {
        super(str);
        this.f9822a = str2;
        this.f9823b = str3;
    }

    j(Parcel parcel) {
        super(parcel.readString());
        this.f9822a = parcel.readString();
        this.f9823b = parcel.readString();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        j jVar = (j) obj;
        if (!this.f9819f.equals(jVar.f9819f) || !t.a((Object) this.f9822a, (Object) jVar.f9822a) || !t.a((Object) this.f9823b, (Object) jVar.f9823b)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int hashCode = (527 + this.f9819f.hashCode()) * 31;
        String str = this.f9822a;
        int i = 0;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.f9823b;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode2 + i;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f9819f);
        parcel.writeString(this.f9822a);
        parcel.writeString(this.f9823b);
    }
}
