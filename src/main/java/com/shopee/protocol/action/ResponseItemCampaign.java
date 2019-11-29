package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class ResponseItemCampaign extends Message {
    public static final String DEFAULT_DEBUG_MSG = "";
    public static final Integer DEFAULT_ERRCODE = 0;
    public static final List<CampaignInfo> DEFAULT_ONGOING_CAMPAIGNS = Collections.emptyList();
    public static final String DEFAULT_REQUESTID = "";
    public static final List<CampaignInfo> DEFAULT_UPCOMING_CAMPAIGNS = Collections.emptyList();
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String debug_msg;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer errcode;
    @ProtoField(label = Message.Label.REPEATED, messageType = CampaignInfo.class, tag = 4)
    public final List<CampaignInfo> ongoing_campaigns;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(label = Message.Label.REPEATED, messageType = CampaignInfo.class, tag = 5)
    public final List<CampaignInfo> upcoming_campaigns;

    public ResponseItemCampaign(String str, Integer num, String str2, List<CampaignInfo> list, List<CampaignInfo> list2) {
        this.requestid = str;
        this.errcode = num;
        this.debug_msg = str2;
        this.ongoing_campaigns = immutableCopyOf(list);
        this.upcoming_campaigns = immutableCopyOf(list2);
    }

    private ResponseItemCampaign(Builder builder) {
        this(builder.requestid, builder.errcode, builder.debug_msg, builder.ongoing_campaigns, builder.upcoming_campaigns);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ResponseItemCampaign)) {
            return false;
        }
        ResponseItemCampaign responseItemCampaign = (ResponseItemCampaign) obj;
        if (!equals((Object) this.requestid, (Object) responseItemCampaign.requestid) || !equals((Object) this.errcode, (Object) responseItemCampaign.errcode) || !equals((Object) this.debug_msg, (Object) responseItemCampaign.debug_msg) || !equals((List<?>) this.ongoing_campaigns, (List<?>) responseItemCampaign.ongoing_campaigns) || !equals((List<?>) this.upcoming_campaigns, (List<?>) responseItemCampaign.upcoming_campaigns)) {
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
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 37;
        String str2 = this.debug_msg;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        int i3 = (hashCode2 + i2) * 37;
        List<CampaignInfo> list = this.ongoing_campaigns;
        int i4 = 1;
        int hashCode3 = (i3 + (list != null ? list.hashCode() : 1)) * 37;
        List<CampaignInfo> list2 = this.upcoming_campaigns;
        if (list2 != null) {
            i4 = list2.hashCode();
        }
        int i5 = hashCode3 + i4;
        this.hashCode = i5;
        return i5;
    }

    public static final class Builder extends Message.Builder<ResponseItemCampaign> {
        public String debug_msg;
        public Integer errcode;
        public List<CampaignInfo> ongoing_campaigns;
        public String requestid;
        public List<CampaignInfo> upcoming_campaigns;

        public Builder() {
        }

        public Builder(ResponseItemCampaign responseItemCampaign) {
            super(responseItemCampaign);
            if (responseItemCampaign != null) {
                this.requestid = responseItemCampaign.requestid;
                this.errcode = responseItemCampaign.errcode;
                this.debug_msg = responseItemCampaign.debug_msg;
                this.ongoing_campaigns = ResponseItemCampaign.copyOf(responseItemCampaign.ongoing_campaigns);
                this.upcoming_campaigns = ResponseItemCampaign.copyOf(responseItemCampaign.upcoming_campaigns);
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

        public Builder debug_msg(String str) {
            this.debug_msg = str;
            return this;
        }

        public Builder ongoing_campaigns(List<CampaignInfo> list) {
            this.ongoing_campaigns = checkForNulls(list);
            return this;
        }

        public Builder upcoming_campaigns(List<CampaignInfo> list) {
            this.upcoming_campaigns = checkForNulls(list);
            return this;
        }

        public ResponseItemCampaign build() {
            return new ResponseItemCampaign(this);
        }
    }
}
