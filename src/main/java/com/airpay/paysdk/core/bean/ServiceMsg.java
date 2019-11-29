package com.airpay.paysdk.core.bean;

import android.os.Parcel;
import android.os.Parcelable;

public class ServiceMsg implements Parcelable {
    public static final Parcelable.Creator<ServiceMsg> CREATOR = new Parcelable.Creator<ServiceMsg>() {
        /* renamed from: a */
        public ServiceMsg createFromParcel(Parcel parcel) {
            return new ServiceMsg(parcel);
        }

        /* renamed from: a */
        public ServiceMsg[] newArray(int i) {
            return new ServiceMsg[i];
        }
    };
    private final int code;
    private final String message;

    public int describeContents() {
        return 0;
    }

    public int getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }

    public ServiceMsg(int i, String str) {
        this.code = i;
        this.message = str;
    }

    protected ServiceMsg(Parcel parcel) {
        this.code = parcel.readInt();
        this.message = parcel.readString();
    }

    public String toString() {
        return "ServiceMsg{code=" + this.code + ", message='" + this.message + '\'' + '}';
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.code);
        parcel.writeString(this.message);
    }
}
