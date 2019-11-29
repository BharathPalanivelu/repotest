package com.shopee.protocol.action;

import com.shopee.protocol.shop.BundleDealItem;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class SetBundleDealItem extends Message {
    public static final Long DEFAULT_BUNDLE_DEAL_ID = 0L;
    public static final List<BundleDealItem> DEFAULT_PROMOTION_ITEMS = Collections.emptyList();
    public static final String DEFAULT_REQUESTID = "";
    public static final String DEFAULT_TOKEN = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 3)
    public final BackendParam bparam;
    @ProtoField(tag = 4, type = Message.Datatype.INT64)
    public final Long bundle_deal_id;
    @ProtoField(label = Message.Label.REPEATED, messageType = BundleDealItem.class, tag = 5)
    public final List<BundleDealItem> promotion_items;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String token;

    public SetBundleDealItem(String str, String str2, BackendParam backendParam, Long l, List<BundleDealItem> list) {
        this.requestid = str;
        this.token = str2;
        this.bparam = backendParam;
        this.bundle_deal_id = l;
        this.promotion_items = immutableCopyOf(list);
    }

    private SetBundleDealItem(Builder builder) {
        this(builder.requestid, builder.token, builder.bparam, builder.bundle_deal_id, builder.promotion_items);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SetBundleDealItem)) {
            return false;
        }
        SetBundleDealItem setBundleDealItem = (SetBundleDealItem) obj;
        if (!equals((Object) this.requestid, (Object) setBundleDealItem.requestid) || !equals((Object) this.token, (Object) setBundleDealItem.token) || !equals((Object) this.bparam, (Object) setBundleDealItem.bparam) || !equals((Object) this.bundle_deal_id, (Object) setBundleDealItem.bundle_deal_id) || !equals((List<?>) this.promotion_items, (List<?>) setBundleDealItem.promotion_items)) {
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
        Long l = this.bundle_deal_id;
        if (l != null) {
            i2 = l.hashCode();
        }
        int i3 = (hashCode3 + i2) * 37;
        List<BundleDealItem> list = this.promotion_items;
        int hashCode4 = i3 + (list != null ? list.hashCode() : 1);
        this.hashCode = hashCode4;
        return hashCode4;
    }

    public static final class Builder extends Message.Builder<SetBundleDealItem> {
        public BackendParam bparam;
        public Long bundle_deal_id;
        public List<BundleDealItem> promotion_items;
        public String requestid;
        public String token;

        public Builder() {
        }

        public Builder(SetBundleDealItem setBundleDealItem) {
            super(setBundleDealItem);
            if (setBundleDealItem != null) {
                this.requestid = setBundleDealItem.requestid;
                this.token = setBundleDealItem.token;
                this.bparam = setBundleDealItem.bparam;
                this.bundle_deal_id = setBundleDealItem.bundle_deal_id;
                this.promotion_items = SetBundleDealItem.copyOf(setBundleDealItem.promotion_items);
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

        public Builder bundle_deal_id(Long l) {
            this.bundle_deal_id = l;
            return this;
        }

        public Builder promotion_items(List<BundleDealItem> list) {
            this.promotion_items = checkForNulls(list);
            return this;
        }

        public SetBundleDealItem build() {
            return new SetBundleDealItem(this);
        }
    }
}
