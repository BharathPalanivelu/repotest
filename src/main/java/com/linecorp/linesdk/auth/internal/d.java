package com.linecorp.linesdk.auth.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.linecorp.linesdk.a.f;

final class d implements Parcelable {
    public static final Parcelable.Creator<d> CREATOR = new Parcelable.Creator<d>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new d[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new d(parcel, (byte) 0);
        }
    };

    /* renamed from: a  reason: collision with root package name */
    f f15086a;

    /* renamed from: b  reason: collision with root package name */
    String f15087b;

    /* renamed from: c  reason: collision with root package name */
    String f15088c;

    /* renamed from: d  reason: collision with root package name */
    int f15089d;

    public final int describeContents() {
        return 0;
    }

    enum a {
        ;

        static {
            f15094e = new int[]{f15090a, f15091b, f15092c, f15093d};
        }

        public static int[] a() {
            return (int[]) f15094e.clone();
        }
    }

    /* synthetic */ d(Parcel parcel, byte b2) {
        this(parcel);
    }

    d() {
        this.f15089d = a.f15090a;
    }

    private d(Parcel parcel) {
        this.f15089d = a.f15090a;
        String readString = parcel.readString();
        String readString2 = parcel.readString();
        this.f15086a = (TextUtils.isEmpty(readString) || TextUtils.isEmpty(readString2)) ? null : new f(readString, readString2);
        this.f15087b = parcel.readString();
        this.f15089d = a.a()[parcel.readByte()];
        this.f15088c = parcel.readString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        f fVar = this.f15086a;
        String str = null;
        parcel.writeString(fVar == null ? null : fVar.f15035a);
        f fVar2 = this.f15086a;
        if (fVar2 != null) {
            str = fVar2.f15036b;
        }
        parcel.writeString(str);
        parcel.writeString(this.f15087b);
        parcel.writeByte((byte) (this.f15089d - 1));
        parcel.writeString(this.f15088c);
    }
}
