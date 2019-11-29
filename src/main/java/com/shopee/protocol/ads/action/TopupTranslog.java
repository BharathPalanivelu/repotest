package com.shopee.protocol.ads.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class TopupTranslog extends Message {
    public static final Long DEFAULT_AMOUNT = 0L;
    public static final Long DEFAULT_ID = 0L;
    public static final String DEFAULT_SIGNATURE = "";
    public static final Long DEFAULT_TIMESTAMP = 0L;
    public static final Integer DEFAULT_USERID = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 4, type = Message.Datatype.INT64)
    public final Long amount;
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long id;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String signature;
    @ProtoField(tag = 3, type = Message.Datatype.INT64)
    public final Long timestamp;
    @ProtoField(tag = 5, type = Message.Datatype.INT32)
    public final Integer userid;

    public TopupTranslog(Long l, String str, Long l2, Long l3, Integer num) {
        this.id = l;
        this.signature = str;
        this.timestamp = l2;
        this.amount = l3;
        this.userid = num;
    }

    private TopupTranslog(Builder builder) {
        this(builder.id, builder.signature, builder.timestamp, builder.amount, builder.userid);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof TopupTranslog)) {
            return false;
        }
        TopupTranslog topupTranslog = (TopupTranslog) obj;
        if (!equals((Object) this.id, (Object) topupTranslog.id) || !equals((Object) this.signature, (Object) topupTranslog.signature) || !equals((Object) this.timestamp, (Object) topupTranslog.timestamp) || !equals((Object) this.amount, (Object) topupTranslog.amount) || !equals((Object) this.userid, (Object) topupTranslog.userid)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Long l = this.id;
        int i2 = 0;
        int hashCode = (l != null ? l.hashCode() : 0) * 37;
        String str = this.signature;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 37;
        Long l2 = this.timestamp;
        int hashCode3 = (hashCode2 + (l2 != null ? l2.hashCode() : 0)) * 37;
        Long l3 = this.amount;
        int hashCode4 = (hashCode3 + (l3 != null ? l3.hashCode() : 0)) * 37;
        Integer num = this.userid;
        if (num != null) {
            i2 = num.hashCode();
        }
        int i3 = hashCode4 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<TopupTranslog> {
        public Long amount;
        public Long id;
        public String signature;
        public Long timestamp;
        public Integer userid;

        public Builder() {
        }

        public Builder(TopupTranslog topupTranslog) {
            super(topupTranslog);
            if (topupTranslog != null) {
                this.id = topupTranslog.id;
                this.signature = topupTranslog.signature;
                this.timestamp = topupTranslog.timestamp;
                this.amount = topupTranslog.amount;
                this.userid = topupTranslog.userid;
            }
        }

        public Builder id(Long l) {
            this.id = l;
            return this;
        }

        public Builder signature(String str) {
            this.signature = str;
            return this;
        }

        public Builder timestamp(Long l) {
            this.timestamp = l;
            return this;
        }

        public Builder amount(Long l) {
            this.amount = l;
            return this;
        }

        public Builder userid(Integer num) {
            this.userid = num;
            return this;
        }

        public TopupTranslog build() {
            return new TopupTranslog(this);
        }
    }
}
