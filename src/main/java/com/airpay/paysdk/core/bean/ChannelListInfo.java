package com.airpay.paysdk.core.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.airpay.paysdk.base.proto.ChannelInfoProto;
import com.airpay.paysdk.base.proto.ChannelListGetReplyProto;
import java.util.ArrayList;
import java.util.List;

public class ChannelListInfo implements Parcelable {
    public static final Parcelable.Creator<ChannelListInfo> CREATOR = new Parcelable.Creator<ChannelListInfo>() {
        /* renamed from: a */
        public ChannelListInfo createFromParcel(Parcel parcel) {
            return new ChannelListInfo(parcel);
        }

        /* renamed from: a */
        public ChannelListInfo[] newArray(int i) {
            return new ChannelListInfo[i];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    public List<ChannelInfo> f4110a;

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
    }

    public ChannelListInfo(ChannelListGetReplyProto channelListGetReplyProto) {
        ArrayList arrayList = new ArrayList();
        for (ChannelInfoProto channelInfo : channelListGetReplyProto.channels) {
            arrayList.add(new ChannelInfo(channelInfo));
        }
        this.f4110a = arrayList;
    }

    protected ChannelListInfo(Parcel parcel) {
    }
}
