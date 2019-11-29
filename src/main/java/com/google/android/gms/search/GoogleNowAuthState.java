package com.google.android.gms.search;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "GoogleNowAuthStateCreator")
@SafeParcelable.Reserved({1000})
public class GoogleNowAuthState extends AbstractSafeParcelable {
    public static final Parcelable.Creator<GoogleNowAuthState> CREATOR = new zza();
    @SafeParcelable.Field(getter = "getAuthCode", id = 1)
    private String zzbj;
    @SafeParcelable.Field(getter = "getAccessToken", id = 2)
    private String zzbk;
    @SafeParcelable.Field(getter = "getNextAllowedTimeMillis", id = 3)
    private long zzbl;

    @SafeParcelable.Constructor
    GoogleNowAuthState(@SafeParcelable.Param(id = 1) String str, @SafeParcelable.Param(id = 2) String str2, @SafeParcelable.Param(id = 3) long j) {
        this.zzbj = str;
        this.zzbk = str2;
        this.zzbl = j;
    }

    public String getAuthCode() {
        return this.zzbj;
    }

    public String getAccessToken() {
        return this.zzbk;
    }

    public long getNextAllowedTimeMillis() {
        return this.zzbl;
    }

    public String toString() {
        String str = this.zzbj;
        String str2 = this.zzbk;
        long j = this.zzbl;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 74 + String.valueOf(str2).length());
        sb.append("mAuthCode = ");
        sb.append(str);
        sb.append("\nmAccessToken = ");
        sb.append(str2);
        sb.append("\nmNextAllowedTimeMillis = ");
        sb.append(j);
        return sb.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, getAuthCode(), false);
        SafeParcelWriter.writeString(parcel, 2, getAccessToken(), false);
        SafeParcelWriter.writeLong(parcel, 3, getNextAllowedTimeMillis());
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
