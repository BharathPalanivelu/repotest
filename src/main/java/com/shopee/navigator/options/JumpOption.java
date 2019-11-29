package com.shopee.navigator.options;

import android.os.Parcel;
import android.os.Parcelable;

public class JumpOption implements Parcelable {
    public static final Parcelable.Creator<JumpOption> CREATOR = new Parcelable.Creator<JumpOption>() {
        /* renamed from: a */
        public JumpOption createFromParcel(Parcel parcel) {
            return new JumpOption(parcel);
        }

        /* renamed from: a */
        public JumpOption[] newArray(int i) {
            return new JumpOption[i];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private String f30135a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f30136b;

    /* renamed from: c  reason: collision with root package name */
    private int f30137c;

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f30135a);
        parcel.writeByte(this.f30136b ? (byte) 1 : 0);
        parcel.writeInt(this.f30137c);
    }

    protected JumpOption(Parcel parcel) {
        this.f30135a = parcel.readString();
        this.f30136b = parcel.readByte() != 0;
        this.f30137c = parcel.readInt();
    }
}
