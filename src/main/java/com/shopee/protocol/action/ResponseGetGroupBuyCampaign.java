package com.shopee.protocol.action;

import com.shopee.protocol.shop.GroupBuyCampaign;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class ResponseGetGroupBuyCampaign extends Message {
    public static final Integer DEFAULT_ERRCODE = 0;
    public static final List<GroupBuyCampaign> DEFAULT_GROUP_BUY_CAMPAIGN = Collections.emptyList();
    public static final String DEFAULT_REQUESTID = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer errcode;
    @ProtoField(label = Message.Label.REPEATED, messageType = GroupBuyCampaign.class, tag = 3)
    public final List<GroupBuyCampaign> group_buy_campaign;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;

    public ResponseGetGroupBuyCampaign(String str, Integer num, List<GroupBuyCampaign> list) {
        this.requestid = str;
        this.errcode = num;
        this.group_buy_campaign = immutableCopyOf(list);
    }

    private ResponseGetGroupBuyCampaign(Builder builder) {
        this(builder.requestid, builder.errcode, builder.group_buy_campaign);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ResponseGetGroupBuyCampaign)) {
            return false;
        }
        ResponseGetGroupBuyCampaign responseGetGroupBuyCampaign = (ResponseGetGroupBuyCampaign) obj;
        if (!equals((Object) this.requestid, (Object) responseGetGroupBuyCampaign.requestid) || !equals((Object) this.errcode, (Object) responseGetGroupBuyCampaign.errcode) || !equals((List<?>) this.group_buy_campaign, (List<?>) responseGetGroupBuyCampaign.group_buy_campaign)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        String str = this.requestid;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 37;
        Integer num = this.errcode;
        if (num != null) {
            i2 = num.hashCode();
        }
        int i3 = (hashCode + i2) * 37;
        List<GroupBuyCampaign> list = this.group_buy_campaign;
        int hashCode2 = i3 + (list != null ? list.hashCode() : 1);
        this.hashCode = hashCode2;
        return hashCode2;
    }

    public static final class Builder extends Message.Builder<ResponseGetGroupBuyCampaign> {
        public Integer errcode;
        public List<GroupBuyCampaign> group_buy_campaign;
        public String requestid;

        public Builder() {
        }

        public Builder(ResponseGetGroupBuyCampaign responseGetGroupBuyCampaign) {
            super(responseGetGroupBuyCampaign);
            if (responseGetGroupBuyCampaign != null) {
                this.requestid = responseGetGroupBuyCampaign.requestid;
                this.errcode = responseGetGroupBuyCampaign.errcode;
                this.group_buy_campaign = ResponseGetGroupBuyCampaign.copyOf(responseGetGroupBuyCampaign.group_buy_campaign);
            }
        }

        public Builder requestid(String str) {
            this.requestid = str;
            return this;
        }

        public Builder errcode(Integer num) {
            this.errcode = num;
            return this;
        }

        public Builder group_buy_campaign(List<GroupBuyCampaign> list) {
            this.group_buy_campaign = checkForNulls(list);
            return this;
        }

        public ResponseGetGroupBuyCampaign build() {
            return new ResponseGetGroupBuyCampaign(this);
        }
    }
}
