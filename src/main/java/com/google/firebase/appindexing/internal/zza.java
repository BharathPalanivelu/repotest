package com.google.firebase.appindexing.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "ActionImplCreator")
@SafeParcelable.Reserved({1000})
public final class zza extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zza> CREATOR = new c();
    @SafeParcelable.Field(getter = "getActionType", id = 1)

    /* renamed from: a  reason: collision with root package name */
    private final String f6800a;
    @SafeParcelable.Field(getter = "getObjectName", id = 2)

    /* renamed from: b  reason: collision with root package name */
    private final String f6801b;
    @SafeParcelable.Field(getter = "getObjectUrl", id = 3)

    /* renamed from: c  reason: collision with root package name */
    private final String f6802c;
    @SafeParcelable.Field(getter = "getObjectSameAs", id = 4)

    /* renamed from: d  reason: collision with root package name */
    private final String f6803d;
    @SafeParcelable.Field(getter = "getMetadata", id = 5)

    /* renamed from: e  reason: collision with root package name */
    private final zzc f6804e;
    @SafeParcelable.Field(getter = "getActionStatus", id = 6)

    /* renamed from: f  reason: collision with root package name */
    private final String f6805f;
    @SafeParcelable.Field(getter = "getPropertyBundle", id = 7)

    /* renamed from: g  reason: collision with root package name */
    private final Bundle f6806g;

    @SafeParcelable.Constructor
    public zza(@SafeParcelable.Param(id = 1) String str, @SafeParcelable.Param(id = 2) String str2, @SafeParcelable.Param(id = 3) String str3, @SafeParcelable.Param(id = 4) String str4, @SafeParcelable.Param(id = 5) zzc zzc, @SafeParcelable.Param(id = 6) String str5, @SafeParcelable.Param(id = 7) Bundle bundle) {
        this.f6800a = str;
        this.f6801b = str2;
        this.f6802c = str3;
        this.f6803d = str4;
        this.f6804e = zzc;
        this.f6805f = str5;
        if (bundle != null) {
            this.f6806g = bundle;
        } else {
            this.f6806g = Bundle.EMPTY;
        }
        this.f6806g.setClassLoader(getClass().getClassLoader());
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.f6800a, false);
        SafeParcelWriter.writeString(parcel, 2, this.f6801b, false);
        SafeParcelWriter.writeString(parcel, 3, this.f6802c, false);
        SafeParcelWriter.writeString(parcel, 4, this.f6803d, false);
        SafeParcelWriter.writeParcelable(parcel, 5, this.f6804e, i, false);
        SafeParcelWriter.writeString(parcel, 6, this.f6805f, false);
        SafeParcelWriter.writeBundle(parcel, 7, this.f6806g, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ActionImpl { ");
        sb.append("{ actionType: '");
        sb.append(this.f6800a);
        sb.append("' } ");
        sb.append("{ objectName: '");
        sb.append(this.f6801b);
        sb.append("' } ");
        sb.append("{ objectUrl: '");
        sb.append(this.f6802c);
        sb.append("' } ");
        if (this.f6803d != null) {
            sb.append("{ objectSameAs: '");
            sb.append(this.f6803d);
            sb.append("' } ");
        }
        if (this.f6804e != null) {
            sb.append("{ metadata: '");
            sb.append(this.f6804e.toString());
            sb.append("' } ");
        }
        if (this.f6805f != null) {
            sb.append("{ actionStatus: '");
            sb.append(this.f6805f);
            sb.append("' } ");
        }
        if (!this.f6806g.isEmpty()) {
            sb.append("{ ");
            sb.append(this.f6806g);
            sb.append(" } ");
        }
        sb.append("}");
        return sb.toString();
    }
}
