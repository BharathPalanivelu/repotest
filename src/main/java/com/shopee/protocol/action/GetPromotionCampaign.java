package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class GetPromotionCampaign extends Message {
    public static final List<Integer> DEFAULT_CAMPAIGN_TYPE = Collections.emptyList();
    public static final Long DEFAULT_ITEMID = 0L;
    public static final Long DEFAULT_MODELID = 0L;
    public static final String DEFAULT_REQUESTID = "";
    public static final String DEFAULT_TOKEN = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 3)
    public final BackendParam bparam;
    @ProtoField(label = Message.Label.REPEATED, tag = 6, type = Message.Datatype.INT32)
    public final List<Integer> campaign_type;
    @ProtoField(tag = 4, type = Message.Datatype.INT64)
    public final Long itemid;
    @ProtoField(tag = 5, type = Message.Datatype.INT64)
    public final Long modelid;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String token;

    public GetPromotionCampaign(String str, String str2, BackendParam backendParam, Long l, Long l2, List<Integer> list) {
        this.requestid = str;
        this.token = str2;
        this.bparam = backendParam;
        this.itemid = l;
        this.modelid = l2;
        this.campaign_type = immutableCopyOf(list);
    }

    private GetPromotionCampaign(Builder builder) {
        this(builder.requestid, builder.token, builder.bparam, builder.itemid, builder.modelid, builder.campaign_type);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof GetPromotionCampaign)) {
            return false;
        }
        GetPromotionCampaign getPromotionCampaign = (GetPromotionCampaign) obj;
        if (!equals((Object) this.requestid, (Object) getPromotionCampaign.requestid) || !equals((Object) this.token, (Object) getPromotionCampaign.token) || !equals((Object) this.bparam, (Object) getPromotionCampaign.bparam) || !equals((Object) this.itemid, (Object) getPromotionCampaign.itemid) || !equals((Object) this.modelid, (Object) getPromotionCampaign.modelid) || !equals((List<?>) this.campaign_type, (List<?>) getPromotionCampaign.campaign_type)) {
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
        String str2 = this.token;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 37;
        BackendParam backendParam = this.bparam;
        int hashCode3 = (hashCode2 + (backendParam != null ? backendParam.hashCode() : 0)) * 37;
        Long l = this.itemid;
        int hashCode4 = (hashCode3 + (l != null ? l.hashCode() : 0)) * 37;
        Long l2 = this.modelid;
        if (l2 != null) {
            i2 = l2.hashCode();
        }
        int i3 = (hashCode4 + i2) * 37;
        List<Integer> list = this.campaign_type;
        int hashCode5 = i3 + (list != null ? list.hashCode() : 1);
        this.hashCode = hashCode5;
        return hashCode5;
    }

    public static final class Builder extends Message.Builder<GetPromotionCampaign> {
        public BackendParam bparam;
        public List<Integer> campaign_type;
        public Long itemid;
        public Long modelid;
        public String requestid;
        public String token;

        public Builder() {
        }

        public Builder(GetPromotionCampaign getPromotionCampaign) {
            super(getPromotionCampaign);
            if (getPromotionCampaign != null) {
                this.requestid = getPromotionCampaign.requestid;
                this.token = getPromotionCampaign.token;
                this.bparam = getPromotionCampaign.bparam;
                this.itemid = getPromotionCampaign.itemid;
                this.modelid = getPromotionCampaign.modelid;
                this.campaign_type = GetPromotionCampaign.copyOf(getPromotionCampaign.campaign_type);
            }
        }

        public Builder requestid(String str) {
            this.requestid = str;
            return this;
        }

        public Builder token(String str) {
            this.token = str;
            return this;
        }

        public Builder bparam(BackendParam backendParam) {
            this.bparam = backendParam;
            return this;
        }

        public Builder itemid(Long l) {
            this.itemid = l;
            return this;
        }

        public Builder modelid(Long l) {
            this.modelid = l;
            return this;
        }

        public Builder campaign_type(List<Integer> list) {
            this.campaign_type = checkForNulls(list);
            return this;
        }

        public GetPromotionCampaign build() {
            return new GetPromotionCampaign(this);
        }
    }
}
