package com.google.firebase.appindexing.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.litesuits.orm.db.assit.SQLBuilder;

@SafeParcelable.Class(creator = "MetadataImplCreator")
@SafeParcelable.Reserved({1000})
public final class zzc extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzc> CREATOR = new e();
    @SafeParcelable.Field(getter = "getEventStatus", id = 1)

    /* renamed from: a  reason: collision with root package name */
    private int f6807a = 0;
    @SafeParcelable.Field(getter = "isUploadable", id = 2)

    /* renamed from: b  reason: collision with root package name */
    private final boolean f6808b;
    @SafeParcelable.Field(getter = "getCompletionToken", id = 3)

    /* renamed from: c  reason: collision with root package name */
    private final String f6809c;
    @SafeParcelable.Field(getter = "getAccountName", id = 4)

    /* renamed from: d  reason: collision with root package name */
    private final String f6810d;
    @SafeParcelable.Field(getter = "getSsbContext", id = 5)

    /* renamed from: e  reason: collision with root package name */
    private final byte[] f6811e;
    @SafeParcelable.Field(getter = "isContextOnly", id = 6)

    /* renamed from: f  reason: collision with root package name */
    private final boolean f6812f;

    @SafeParcelable.Constructor
    zzc(@SafeParcelable.Param(id = 1) int i, @SafeParcelable.Param(id = 2) boolean z, @SafeParcelable.Param(id = 3) String str, @SafeParcelable.Param(id = 4) String str2, @SafeParcelable.Param(id = 5) byte[] bArr, @SafeParcelable.Param(id = 6) boolean z2) {
        this.f6807a = i;
        this.f6808b = z;
        this.f6809c = str;
        this.f6810d = str2;
        this.f6811e = bArr;
        this.f6812f = z2;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.f6807a);
        SafeParcelWriter.writeBoolean(parcel, 2, this.f6808b);
        SafeParcelWriter.writeString(parcel, 3, this.f6809c, false);
        SafeParcelWriter.writeString(parcel, 4, this.f6810d, false);
        SafeParcelWriter.writeByteArray(parcel, 5, this.f6811e, false);
        SafeParcelWriter.writeBoolean(parcel, 6, this.f6812f);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("MetadataImpl { ");
        sb.append("{ eventStatus: '");
        sb.append(this.f6807a);
        sb.append("' } ");
        sb.append("{ uploadable: '");
        sb.append(this.f6808b);
        sb.append("' } ");
        if (this.f6809c != null) {
            sb.append("{ completionToken: '");
            sb.append(this.f6809c);
            sb.append("' } ");
        }
        if (this.f6810d != null) {
            sb.append("{ accountName: '");
            sb.append(this.f6810d);
            sb.append("' } ");
        }
        if (this.f6811e != null) {
            sb.append("{ ssbContext: [ ");
            for (byte hexString : this.f6811e) {
                sb.append("0x");
                sb.append(Integer.toHexString(hexString));
                sb.append(SQLBuilder.BLANK);
            }
            sb.append("] } ");
        }
        sb.append("{ contextOnly: '");
        sb.append(this.f6812f);
        sb.append("' } ");
        sb.append("}");
        return sb.toString();
    }
}
