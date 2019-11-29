package com.airpay.paysdk.base.bean;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.airpay.paysdk.a;
import com.airpay.paysdk.base.d.g;
import com.airpay.paysdk.common.net.tcp.proto.PacketHeaderProto;
import java.io.Serializable;

public class EventCommonResult implements Serializable {
    /* access modifiers changed from: private */
    public boolean mIsSeverMsg;
    /* access modifiers changed from: private */
    public String mMessage;
    /* access modifiers changed from: private */
    public int mResultCode;

    public EventCommonResult(int i, String str, boolean z) {
        this.mResultCode = i;
        this.mMessage = str;
        this.mIsSeverMsg = z;
    }

    public EventCommonResult(int i) {
        this.mResultCode = i;
        this.mMessage = a.a().b().getString(g.a(i));
        this.mIsSeverMsg = false;
    }

    public EventCommonResult(PacketHeaderProto packetHeaderProto) {
    }

    public EventCommonResult(EventParcelableResult eventParcelableResult) {
        this.mResultCode = eventParcelableResult.mResultCode;
        this.mMessage = eventParcelableResult.mMessage;
        this.mIsSeverMsg = eventParcelableResult.mIsSeverMsg;
    }

    public String getMessage() {
        return this.mMessage;
    }

    /* access modifiers changed from: protected */
    public void setMessage(String str) {
        this.mMessage = str;
    }

    /* access modifiers changed from: protected */
    public void setIsServerMsg(boolean z) {
        this.mIsSeverMsg = z;
    }

    public String toString() {
        return "EventCommonResult{mResultCode=" + this.mResultCode + ", mMessage='" + this.mMessage + '\'' + ", mIsSeverMsg=" + this.mIsSeverMsg + '}';
    }

    public String getMessage(Context context, int i) {
        return getMessage(context.getResources().getString(i));
    }

    public CharSequence getMessage(CharSequence charSequence) {
        if (this.mIsSeverMsg || TextUtils.isEmpty(charSequence)) {
            return this.mMessage;
        }
        return charSequence;
    }

    public String getMessage(String str) {
        if (this.mIsSeverMsg || TextUtils.isEmpty(str)) {
            return this.mMessage;
        }
        return str;
    }

    public int getResultCode() {
        return this.mResultCode;
    }

    public boolean isSuccess() {
        return this.mResultCode == 0;
    }

    public static class EventParcelableResult implements Parcelable {
        public static final Parcelable.Creator<EventParcelableResult> CREATOR = new Parcelable.Creator<EventParcelableResult>() {
            public EventParcelableResult createFromParcel(Parcel parcel) {
                return new EventParcelableResult(parcel);
            }

            public EventParcelableResult[] newArray(int i) {
                return new EventParcelableResult[i];
            }
        };
        /* access modifiers changed from: private */
        public boolean mIsSeverMsg;
        /* access modifiers changed from: private */
        public String mMessage;
        /* access modifiers changed from: private */
        public int mResultCode;

        public int describeContents() {
            return 0;
        }

        public EventParcelableResult(EventCommonResult eventCommonResult) {
            this.mResultCode = eventCommonResult.mResultCode;
            this.mMessage = eventCommonResult.mMessage;
            this.mIsSeverMsg = eventCommonResult.mIsSeverMsg;
        }

        protected EventParcelableResult(Parcel parcel) {
            this.mResultCode = parcel.readInt();
            this.mMessage = parcel.readString();
            this.mIsSeverMsg = parcel.readByte() != 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.mResultCode);
            parcel.writeString(this.mMessage);
            parcel.writeByte(this.mIsSeverMsg ? (byte) 1 : 0);
        }
    }
}
