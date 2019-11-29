package com.google.firebase.appindexing.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "CallStatusCreator")
public final class zzg extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzg> CREATOR = new d();

    /* renamed from: b  reason: collision with root package name */
    private static final zzg f6813b = new zzg(1);

    /* renamed from: c  reason: collision with root package name */
    private static final zzg f6814c = new zzg(2);

    /* renamed from: d  reason: collision with root package name */
    private static final zzg f6815d = new zzg(3);
    @SafeParcelable.Field(id = 1)

    /* renamed from: a  reason: collision with root package name */
    public final int f6816a;

    @SafeParcelable.Constructor
    public zzg(@SafeParcelable.Param(id = 1) int i) {
        this.f6816a = i;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.f6816a);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
