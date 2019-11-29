package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class ReportItem extends Message {
    public static final Long DEFAULT_ITEMID = 0L;
    public static final String DEFAULT_REASON = "";
    public static final String DEFAULT_REQUESTID = "";
    public static final Integer DEFAULT_SHOPID = 0;
    public static final String DEFAULT_TOKEN = "";
    private static final long serialVersionUID = 0;
    @ProtoField(label = Message.Label.REQUIRED, tag = 3, type = Message.Datatype.INT64)
    public final Long itemid;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String reason;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2, type = Message.Datatype.INT32)
    public final Integer shopid;
    @ProtoField(tag = 5, type = Message.Datatype.STRING)
    public final String token;

    public ReportItem(String str, Integer num, Long l, String str2, String str3) {
        this.requestid = str;
        this.shopid = num;
        this.itemid = l;
        this.reason = str2;
        this.token = str3;
    }

    private ReportItem(Builder builder) {
        this(builder.requestid, builder.shopid, builder.itemid, builder.reason, builder.token);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ReportItem)) {
            return false;
        }
        ReportItem reportItem = (ReportItem) obj;
        if (!equals((Object) this.requestid, (Object) reportItem.requestid) || !equals((Object) this.shopid, (Object) reportItem.shopid) || !equals((Object) this.itemid, (Object) reportItem.itemid) || !equals((Object) this.reason, (Object) reportItem.reason) || !equals((Object) this.token, (Object) reportItem.token)) {
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
        Integer num = this.shopid;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 37;
        Long l = this.itemid;
        int hashCode3 = (hashCode2 + (l != null ? l.hashCode() : 0)) * 37;
        String str2 = this.reason;
        int hashCode4 = (hashCode3 + (str2 != null ? str2.hashCode() : 0)) * 37;
        String str3 = this.token;
        if (str3 != null) {
            i2 = str3.hashCode();
        }
        int i3 = hashCode4 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<ReportItem> {
        public Long itemid;
        public String reason;
        public String requestid;
        public Integer shopid;
        public String token;

        public Builder() {
        }

        public Builder(ReportItem reportItem) {
            super(reportItem);
            if (reportItem != null) {
                this.requestid = reportItem.requestid;
                this.shopid = reportItem.shopid;
                this.itemid = reportItem.itemid;
                this.reason = reportItem.reason;
                this.token = reportItem.token;
            }
        }

        public Builder requestid(String str) {
            this.requestid = str;
            return this;
        }

        public Builder shopid(Integer num) {
            this.shopid = num;
            return this;
        }

        public Builder itemid(Long l) {
            this.itemid = l;
            return this;
        }

        public Builder reason(String str) {
            this.reason = str;
            return this;
        }

        public Builder token(String str) {
            this.token = str;
            return this;
        }

        public ReportItem build() {
            checkRequiredFields();
            return new ReportItem(this);
        }
    }
}
