package com.airpay.paysdk.qrcode.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.airpay.paysdk.base.proto.BankAccountListGetReplyProto;
import com.airpay.paysdk.base.proto.BankAccountProto;
import java.util.ArrayList;
import java.util.List;

public class BankAccountListInfo implements Parcelable {
    public static final Parcelable.Creator<BankAccountListInfo> CREATOR = new Parcelable.Creator<BankAccountListInfo>() {
        /* renamed from: a */
        public BankAccountListInfo createFromParcel(Parcel parcel) {
            return new BankAccountListInfo(parcel);
        }

        /* renamed from: a */
        public BankAccountListInfo[] newArray(int i) {
            return new BankAccountListInfo[i];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    public List<BankAccountInfo> f4362a;

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
    }

    public BankAccountListInfo(BankAccountListGetReplyProto bankAccountListGetReplyProto) {
        ArrayList arrayList = new ArrayList();
        for (BankAccountProto bankAccountInfo : bankAccountListGetReplyProto.bank_accounts) {
            arrayList.add(new BankAccountInfo(bankAccountInfo));
        }
        this.f4362a = arrayList;
    }

    protected BankAccountListInfo(Parcel parcel) {
    }
}
