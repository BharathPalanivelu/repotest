package com.google.android.exoplayer2.metadata.emsg;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.s.v;
import java.util.Arrays;

public final class EventMessage implements Metadata.Entry {
    public static final Parcelable.Creator<EventMessage> CREATOR = new Parcelable.Creator<EventMessage>() {
        /* renamed from: a */
        public EventMessage createFromParcel(Parcel parcel) {
            return new EventMessage(parcel);
        }

        /* renamed from: a */
        public EventMessage[] newArray(int i) {
            return new EventMessage[i];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    public final String f10844a;

    /* renamed from: b  reason: collision with root package name */
    public final String f10845b;

    /* renamed from: c  reason: collision with root package name */
    public final long f10846c;

    /* renamed from: d  reason: collision with root package name */
    public final long f10847d;

    /* renamed from: e  reason: collision with root package name */
    public final byte[] f10848e;

    /* renamed from: f  reason: collision with root package name */
    private int f10849f;

    public int describeContents() {
        return 0;
    }

    public EventMessage(String str, String str2, long j, long j2, byte[] bArr) {
        this.f10844a = str;
        this.f10845b = str2;
        this.f10846c = j;
        this.f10847d = j2;
        this.f10848e = bArr;
    }

    EventMessage(Parcel parcel) {
        this.f10844a = parcel.readString();
        this.f10845b = parcel.readString();
        this.f10846c = parcel.readLong();
        this.f10847d = parcel.readLong();
        this.f10848e = parcel.createByteArray();
    }

    public int hashCode() {
        if (this.f10849f == 0) {
            String str = this.f10844a;
            int i = 0;
            int hashCode = (527 + (str != null ? str.hashCode() : 0)) * 31;
            String str2 = this.f10845b;
            if (str2 != null) {
                i = str2.hashCode();
            }
            long j = this.f10846c;
            long j2 = this.f10847d;
            this.f10849f = ((((((hashCode + i) * 31) + ((int) (j ^ (j >>> 32)))) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31) + Arrays.hashCode(this.f10848e);
        }
        return this.f10849f;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        EventMessage eventMessage = (EventMessage) obj;
        if (this.f10846c != eventMessage.f10846c || this.f10847d != eventMessage.f10847d || !v.a((Object) this.f10844a, (Object) eventMessage.f10844a) || !v.a((Object) this.f10845b, (Object) eventMessage.f10845b) || !Arrays.equals(this.f10848e, eventMessage.f10848e)) {
            return false;
        }
        return true;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f10844a);
        parcel.writeString(this.f10845b);
        parcel.writeLong(this.f10846c);
        parcel.writeLong(this.f10847d);
        parcel.writeByteArray(this.f10848e);
    }
}
