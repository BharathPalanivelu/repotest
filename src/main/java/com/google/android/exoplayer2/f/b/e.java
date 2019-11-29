package com.google.android.exoplayer2.f.b;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.n.t;

public final class e extends h {
    public static final Parcelable.Creator<e> CREATOR = new Parcelable.Creator<e>() {
        /* renamed from: a */
        public e createFromParcel(Parcel parcel) {
            return new e(parcel);
        }

        /* renamed from: a */
        public e[] newArray(int i) {
            return new e[i];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    public final String f9807a;

    /* renamed from: b  reason: collision with root package name */
    public final String f9808b;

    /* renamed from: c  reason: collision with root package name */
    public final String f9809c;

    public e(String str, String str2, String str3) {
        super("COMM");
        this.f9807a = str;
        this.f9808b = str2;
        this.f9809c = str3;
    }

    e(Parcel parcel) {
        super("COMM");
        this.f9807a = parcel.readString();
        this.f9808b = parcel.readString();
        this.f9809c = parcel.readString();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        e eVar = (e) obj;
        if (!t.a((Object) this.f9808b, (Object) eVar.f9808b) || !t.a((Object) this.f9807a, (Object) eVar.f9807a) || !t.a((Object) this.f9809c, (Object) eVar.f9809c)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        String str = this.f9807a;
        int i = 0;
        int hashCode = (527 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.f9808b;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.f9809c;
        if (str3 != null) {
            i = str3.hashCode();
        }
        return hashCode2 + i;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f9819f);
        parcel.writeString(this.f9807a);
        parcel.writeString(this.f9809c);
    }
}
