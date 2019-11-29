package com.shopee.protocol.ads.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class TopupBalanceRequest extends Message {
    public static final Long DEFAULT_ACCOUNTID = 0L;
    public static final String DEFAULT_SIGNATURE = "";
    public static final Long DEFAULT_TOPUP_AMOUNT = 0L;
    public static final Integer DEFAULT_USERID = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 2, type = Message.Datatype.INT64)
    public final Long accountid;
    @ProtoField(tag = 1)
    public final RequestHeader header;
    @ProtoField(tag = 5, type = Message.Datatype.STRING)
    public final String signature;
    @ProtoField(tag = 4, type = Message.Datatype.INT64)
    public final Long topup_amount;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer userid;

    public TopupBalanceRequest(RequestHeader requestHeader, Long l, Integer num, Long l2, String str) {
        this.header = requestHeader;
        this.accountid = l;
        this.userid = num;
        this.topup_amount = l2;
        this.signature = str;
    }

    private TopupBalanceRequest(Builder builder) {
        this(builder.header, builder.accountid, builder.userid, builder.topup_amount, builder.signature);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof TopupBalanceRequest)) {
            return false;
        }
        TopupBalanceRequest topupBalanceRequest = (TopupBalanceRequest) obj;
        if (!equals((Object) this.header, (Object) topupBalanceRequest.header) || !equals((Object) this.accountid, (Object) topupBalanceRequest.accountid) || !equals((Object) this.userid, (Object) topupBalanceRequest.userid) || !equals((Object) this.topup_amount, (Object) topupBalanceRequest.topup_amount) || !equals((Object) this.signature, (Object) topupBalanceRequest.signature)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        RequestHeader requestHeader = this.header;
        int i2 = 0;
        int hashCode = (requestHeader != null ? requestHeader.hashCode() : 0) * 37;
        Long l = this.accountid;
        int hashCode2 = (hashCode + (l != null ? l.hashCode() : 0)) * 37;
        Integer num = this.userid;
        int hashCode3 = (hashCode2 + (num != null ? num.hashCode() : 0)) * 37;
        Long l2 = this.topup_amount;
        int hashCode4 = (hashCode3 + (l2 != null ? l2.hashCode() : 0)) * 37;
        String str = this.signature;
        if (str != null) {
            i2 = str.hashCode();
        }
        int i3 = hashCode4 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<TopupBalanceRequest> {
        public Long accountid;
        public RequestHeader header;
        public String signature;
        public Long topup_amount;
        public Integer userid;

        public Builder() {
        }

        public Builder(TopupBalanceRequest topupBalanceRequest) {
            super(topupBalanceRequest);
            if (topupBalanceRequest != null) {
                this.header = topupBalanceRequest.header;
                this.accountid = topupBalanceRequest.accountid;
                this.userid = topupBalanceRequest.userid;
                this.topup_amount = topupBalanceRequest.topup_amount;
                this.signature = topupBalanceRequest.signature;
            }
        }

        public Builder header(RequestHeader requestHeader) {
            this.header = requestHeader;
            return this;
        }

        public Builder accountid(Long l) {
            this.accountid = l;
            return this;
        }

        public Builder userid(Integer num) {
            this.userid = num;
            return this;
        }

        public Builder topup_amount(Long l) {
            this.topup_amount = l;
            return this;
        }

        public Builder signature(String str) {
            this.signature = str;
            return this;
        }

        public TopupBalanceRequest build() {
            return new TopupBalanceRequest(this);
        }
    }
}
