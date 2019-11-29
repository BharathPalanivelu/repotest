package com.shopee.sdk.modules.ui.navigator.options;

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
    private int f30446a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f30447b;

    public int describeContents() {
        return 0;
    }

    private JumpOption(int i, boolean z) {
        this.f30446a = i;
        this.f30447b = z;
    }

    public static JumpOption a(boolean z) {
        return new JumpOption(0, z);
    }

    public boolean a() {
        return this.f30447b;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f30446a);
        parcel.writeByte(this.f30447b ? (byte) 1 : 0);
    }

    protected JumpOption(Parcel parcel) {
        this.f30446a = parcel.readInt();
        this.f30447b = parcel.readByte() != 0;
    }
}
