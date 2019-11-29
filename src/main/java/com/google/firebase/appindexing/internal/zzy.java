package com.google.firebase.appindexing.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "MutateRequestCreator")
@SafeParcelable.Reserved({4})
public final class zzy extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzy> CREATOR = new g();
    @SafeParcelable.Field(id = 1)

    /* renamed from: a  reason: collision with root package name */
    private final int f6817a;
    @SafeParcelable.Field(id = 2)

    /* renamed from: b  reason: collision with root package name */
    private final Thing[] f6818b;
    @SafeParcelable.Field(id = 3)

    /* renamed from: c  reason: collision with root package name */
    private final String[] f6819c;
    @SafeParcelable.Field(id = 5)

    /* renamed from: d  reason: collision with root package name */
    private final String[] f6820d;
    @SafeParcelable.Field(id = 6)

    /* renamed from: e  reason: collision with root package name */
    private final zza f6821e;
    @SafeParcelable.Field(id = 7)

    /* renamed from: f  reason: collision with root package name */
    private final String f6822f;
    @SafeParcelable.Field(id = 8)

    /* renamed from: g  reason: collision with root package name */
    private final String f6823g;

    @SafeParcelable.Constructor
    zzy(@SafeParcelable.Param(id = 1) int i, @SafeParcelable.Param(id = 2) Thing[] thingArr, @SafeParcelable.Param(id = 3) String[] strArr, @SafeParcelable.Param(id = 5) String[] strArr2, @SafeParcelable.Param(id = 6) zza zza, @SafeParcelable.Param(id = 7) String str, @SafeParcelable.Param(id = 8) String str2) {
        if (!(i == 0 || i == 1 || i == 2 || i == 3 || i == 4 || i == 6 || i == 7)) {
            i = 0;
        }
        this.f6817a = i;
        this.f6818b = thingArr;
        this.f6819c = strArr;
        this.f6820d = strArr2;
        this.f6821e = zza;
        this.f6822f = str;
        this.f6823g = str2;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.f6817a);
        SafeParcelWriter.writeTypedArray(parcel, 2, this.f6818b, i, false);
        SafeParcelWriter.writeStringArray(parcel, 3, this.f6819c, false);
        SafeParcelWriter.writeStringArray(parcel, 5, this.f6820d, false);
        SafeParcelWriter.writeParcelable(parcel, 6, this.f6821e, i, false);
        SafeParcelWriter.writeString(parcel, 7, this.f6822f, false);
        SafeParcelWriter.writeString(parcel, 8, this.f6823g, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
