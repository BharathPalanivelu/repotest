package com.google.android.libraries.places.internal;

import android.os.Parcel;
import android.os.Parcelable;

public final class eu implements Parcelable {
    public static final Parcelable.Creator<eu> CREATOR = new ev();

    /* renamed from: a  reason: collision with root package name */
    public a f12519a;

    /* renamed from: b  reason: collision with root package name */
    public String f12520b;

    /* renamed from: c  reason: collision with root package name */
    public String f12521c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f12522d;

    public eu(a aVar, String str, String str2, boolean z) {
        this.f12519a = aVar;
        this.f12520b = str;
        this.f12521c = str2;
        this.f12522d = z;
    }

    public final int describeContents() {
        return 0;
    }

    public enum a implements Parcelable {
        NO_ERROR,
        SHOW_ERROR_CAN_RETRY_NOT_LOADING,
        SHOW_ERROR_CANNOT_RETRY_NOT_LOADING,
        SHOW_ERROR_WHILE_LOADING;
        
        public static final Parcelable.Creator<a> CREATOR = null;

        public final int describeContents() {
            return 0;
        }

        public final void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(name());
        }

        static {
            CREATOR = new ew();
        }
    }

    public final boolean a() {
        return this.f12519a != a.NO_ERROR;
    }

    public final void a(CharSequence charSequence) {
        this.f12520b = charSequence == null ? null : charSequence.toString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f12519a, i);
        parcel.writeString(this.f12520b);
        parcel.writeString(this.f12521c);
        parcel.writeInt(this.f12522d ? 1 : 0);
    }

    public final boolean equals(Object obj) {
        if (obj instanceof eu) {
            eu euVar = (eu) obj;
            if (!hj.a((Object) this.f12519a, (Object) euVar.f12519a) || !hj.a((Object) this.f12520b, (Object) euVar.f12520b) || !hj.a((Object) this.f12521c, (Object) euVar.f12521c) || !hj.a((Object) Boolean.valueOf(this.f12522d), (Object) Boolean.valueOf(euVar.f12522d))) {
                return false;
            }
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return hj.a(this.f12519a, this.f12520b, this.f12521c, Boolean.valueOf(this.f12522d));
    }
}
