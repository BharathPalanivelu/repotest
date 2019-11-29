package com.shopee.protocol.action;

import com.shopee.protocol.shop.GroupBuyCampaignItem;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class SetGroupBuyCampaignItem extends Message {
    public static final Long DEFAULT_CAMPAIGNID = 0L;
    public static final List<GroupBuyCampaignItem> DEFAULT_ITEMS = Collections.emptyList();
    public static final String DEFAULT_REQUESTID = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 4)
    public final BackendParam bparam;
    @ProtoField(tag = 2, type = Message.Datatype.INT64)
    public final Long campaignid;
    @ProtoField(label = Message.Label.REPEATED, messageType = GroupBuyCampaignItem.class, tag = 3)
    public final List<GroupBuyCampaignItem> items;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;

    public SetGroupBuyCampaignItem(String str, Long l, List<GroupBuyCampaignItem> list, BackendParam backendParam) {
        this.requestid = str;
        this.campaignid = l;
        this.items = immutableCopyOf(list);
        this.bparam = backendParam;
    }

    private SetGroupBuyCampaignItem(Builder builder) {
        this(builder.requestid, builder.campaignid, builder.items, builder.bparam);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SetGroupBuyCampaignItem)) {
            return false;
        }
        SetGroupBuyCampaignItem setGroupBuyCampaignItem = (SetGroupBuyCampaignItem) obj;
        if (!equals((Object) this.requestid, (Object) setGroupBuyCampaignItem.requestid) || !equals((Object) this.campaignid, (Object) setGroupBuyCampaignItem.campaignid) || !equals((List<?>) this.items, (List<?>) setGroupBuyCampaignItem.items) || !equals((Object) this.bparam, (Object) setGroupBuyCampaignItem.bparam)) {
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
        Long l = this.campaignid;
        int hashCode2 = (hashCode + (l != null ? l.hashCode() : 0)) * 37;
        List<GroupBuyCampaignItem> list = this.items;
        int hashCode3 = (hashCode2 + (list != null ? list.hashCode() : 1)) * 37;
        BackendParam backendParam = this.bparam;
        if (backendParam != null) {
            i2 = backendParam.hashCode();
        }
        int i3 = hashCode3 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<SetGroupBuyCampaignItem> {
        public BackendParam bparam;
        public Long campaignid;
        public List<GroupBuyCampaignItem> items;
        public String requestid;

        public Builder() {
        }

        public Builder(SetGroupBuyCampaignItem setGroupBuyCampaignItem) {
            super(setGroupBuyCampaignItem);
            if (setGroupBuyCampaignItem != null) {
                this.requestid = setGroupBuyCampaignItem.requestid;
                this.campaignid = setGroupBuyCampaignItem.campaignid;
                this.items = SetGroupBuyCampaignItem.copyOf(setGroupBuyCampaignItem.items);
                this.bparam = setGroupBuyCampaignItem.bparam;
            }
        }

        public Builder requestid(String str) {
            this.requestid = str;
            return this;
        }

        public Builder campaignid(Long l) {
            this.campaignid = l;
            return this;
        }

        public Builder items(List<GroupBuyCampaignItem> list) {
            this.items = checkForNulls(list);
            return this;
        }

        public Builder bparam(BackendParam backendParam) {
            this.bparam = backendParam;
            return this;
        }

        public SetGroupBuyCampaignItem build() {
            return new SetGroupBuyCampaignItem(this);
        }
    }
}
