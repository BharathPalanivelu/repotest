package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class DelItem extends Message {
    public static final Long DEFAULT_ITEMID = 0L;
    public static final String DEFAULT_REQUESTID = "";
    public static final String DEFAULT_TOKEN = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 5)
    public final AdditionalDetail additional_detail;
    @ProtoField(tag = 4)
    public final BackendParam bparam;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2, type = Message.Datatype.INT64)
    public final Long itemid;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String token;

    public DelItem(String str, Long l, String str2, BackendParam backendParam, AdditionalDetail additionalDetail) {
        this.requestid = str;
        this.itemid = l;
        this.token = str2;
        this.bparam = backendParam;
        this.additional_detail = additionalDetail;
    }

    private DelItem(Builder builder) {
        this(builder.requestid, builder.itemid, builder.token, builder.bparam, builder.additional_detail);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof DelItem)) {
            return false;
        }
        DelItem delItem = (DelItem) obj;
        if (!equals((Object) this.requestid, (Object) delItem.requestid) || !equals((Object) this.itemid, (Object) delItem.itemid) || !equals((Object) this.token, (Object) delItem.token) || !equals((Object) this.bparam, (Object) delItem.bparam) || !equals((Object) this.additional_detail, (Object) delItem.additional_detail)) {
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
        Long l = this.itemid;
        int hashCode2 = (hashCode + (l != null ? l.hashCode() : 0)) * 37;
        String str2 = this.token;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 37;
        BackendParam backendParam = this.bparam;
        int hashCode4 = (hashCode3 + (backendParam != null ? backendParam.hashCode() : 0)) * 37;
        AdditionalDetail additionalDetail = this.additional_detail;
        if (additionalDetail != null) {
            i2 = additionalDetail.hashCode();
        }
        int i3 = hashCode4 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<DelItem> {
        public AdditionalDetail additional_detail;
        public BackendParam bparam;
        public Long itemid;
        public String requestid;
        public String token;

        public Builder() {
        }

        public Builder(DelItem delItem) {
            super(delItem);
            if (delItem != null) {
                this.requestid = delItem.requestid;
                this.itemid = delItem.itemid;
                this.token = delItem.token;
                this.bparam = delItem.bparam;
                this.additional_detail = delItem.additional_detail;
            }
        }

        public Builder requestid(String str) {
            this.requestid = str;
            return this;
        }

        public Builder itemid(Long l) {
            this.itemid = l;
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

        public Builder additional_detail(AdditionalDetail additionalDetail) {
            this.additional_detail = additionalDetail;
            return this;
        }

        public DelItem build() {
            checkRequiredFields();
            return new DelItem(this);
        }
    }
}
