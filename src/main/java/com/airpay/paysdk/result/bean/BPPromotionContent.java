package com.airpay.paysdk.result.bean;

import android.os.Parcel;
import android.os.Parcelable;

public class BPPromotionContent implements Parcelable {
    public static final Parcelable.Creator<BPPromotionContent> CREATOR = new Parcelable.Creator<BPPromotionContent>() {
        /* renamed from: a */
        public BPPromotionContent createFromParcel(Parcel parcel) {
            return new BPPromotionContent(parcel);
        }

        /* renamed from: a */
        public BPPromotionContent[] newArray(int i) {
            return new BPPromotionContent[i];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    public final String f4445a;

    /* renamed from: b  reason: collision with root package name */
    public final String f4446b;

    /* renamed from: c  reason: collision with root package name */
    public final String f4447c;

    public int describeContents() {
        return 0;
    }

    protected BPPromotionContent(Parcel parcel) {
        this.f4445a = parcel.readString();
        this.f4446b = parcel.readString();
        this.f4447c = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f4445a);
        parcel.writeString(this.f4446b);
        parcel.writeString(this.f4447c);
    }
}
