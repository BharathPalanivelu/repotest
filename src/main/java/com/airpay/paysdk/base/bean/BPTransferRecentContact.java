package com.airpay.paysdk.base.bean;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;

public class BPTransferRecentContact implements Parcelable {
    public static final Parcelable.Creator<BPTransferRecentContact> CREATOR = new Parcelable.Creator<BPTransferRecentContact>() {
        public BPTransferRecentContact createFromParcel(Parcel parcel) {
            return new BPTransferRecentContact(parcel);
        }

        public BPTransferRecentContact[] newArray(int i) {
            return new BPTransferRecentContact[i];
        }
    };
    public static final int VAL_SOURCE_AIRPAY_ID_OUT = 3;
    public static final int VAL_SOURCE_CONTACT_BOOK_OUT = 1;
    public static final int VAL_SOURCE_DEFAULT = 0;
    public static final int VAL_SOURCE_PHONE_NUMBER_OUT = 2;
    public static final int VAL_SOURCE_QR_CODE_OUT = 5;
    public static final int VAL_SOURCE_TRANSFER_IN = 4;
    private String airpayId;
    private int channelId = 0;
    private String contactName;
    private String formattedDisplayNumber;
    private String formattedNumber;
    private long id = 0;
    private boolean mCheckedFormattedDisplayNumber = false;
    private String mobileNumber;
    private String nickName;
    private String photoUrl;
    private int source = 1;
    private long timeStamp = 0;
    private long uid = 0;

    public int describeContents() {
        return 0;
    }

    protected BPTransferRecentContact(Parcel parcel) {
        this.id = parcel.readLong();
        this.contactName = parcel.readString();
        this.mobileNumber = parcel.readString();
        this.timeStamp = parcel.readLong();
        this.channelId = parcel.readInt();
        this.airpayId = parcel.readString();
        this.uid = parcel.readLong();
        this.source = parcel.readInt();
        this.nickName = parcel.readString();
        this.photoUrl = parcel.readString();
        this.formattedNumber = parcel.readString();
    }

    public boolean isFormattedNumChanged(String str) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(this.formattedNumber) || this.formattedNumber.trim().replaceAll("\\*", "").endsWith(str.trim().replaceAll("\\*", ""))) {
            return false;
        }
        return true;
    }

    private boolean clearFormattedNumIfChanged(String str) {
        if (!isFormattedNumChanged(str)) {
            return false;
        }
        this.formattedNumber = null;
        this.mCheckedFormattedDisplayNumber = false;
        return true;
    }

    private boolean updateMobileNumIfChanged(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String str2 = this.mobileNumber;
        if (str2 == null) {
            this.mobileNumber = str;
            return true;
        } else if (str2.equals(str) || this.mobileNumber.trim().replaceAll("\\*", "").endsWith(str.trim().replaceAll("\\*", ""))) {
            return false;
        } else {
            this.mobileNumber = str;
            return true;
        }
    }

    public long getId() {
        return this.id;
    }

    public String getContactName() {
        return this.contactName;
    }

    public String getMobileNumber() {
        return this.mobileNumber;
    }

    public String getAirpayId() {
        return this.airpayId;
    }

    public long getUid() {
        return this.uid;
    }

    public int getSource() {
        return this.source;
    }

    public int getChannelId() {
        return this.channelId;
    }

    public String getPhotoUrl() {
        return this.photoUrl;
    }

    public String tryGetFormattedNumber() {
        if (!TextUtils.isEmpty(this.formattedNumber)) {
            return this.formattedNumber;
        }
        return this.mobileNumber;
    }

    public String getName() {
        if (!TextUtils.isEmpty(this.airpayId)) {
            return this.airpayId;
        }
        if (!TextUtils.isEmpty(this.contactName)) {
            return this.contactName;
        }
        return this.nickName;
    }

    public boolean matchQuery(String str) {
        if (!TextUtils.isEmpty(this.contactName) && this.contactName.toLowerCase().contains(str)) {
            return true;
        }
        if (!TextUtils.isEmpty(this.airpayId) && this.airpayId.toLowerCase().contains(str)) {
            return true;
        }
        if (TextUtils.isEmpty(this.nickName) || !this.nickName.toLowerCase().contains(str)) {
            return false;
        }
        return true;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.id);
        parcel.writeString(this.contactName);
        parcel.writeString(this.mobileNumber);
        parcel.writeLong(this.timeStamp);
        parcel.writeInt(this.channelId);
        parcel.writeString(this.airpayId);
        parcel.writeLong(this.uid);
        parcel.writeInt(this.source);
        parcel.writeString(this.nickName);
        parcel.writeString(this.photoUrl);
        parcel.writeString(this.formattedNumber);
    }
}
