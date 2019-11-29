package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class HideFeed extends Message {
    public static final Long DEFAULT_FEEDID = 0L;
    public static final String DEFAULT_REQUESTID = "";
    public static final String DEFAULT_TOKEN = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 3, type = Message.Datatype.INT64)
    public final Long feedid;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String token;

    public HideFeed(String str, String str2, Long l) {
        this.requestid = str;
        this.token = str2;
        this.feedid = l;
    }

    private HideFeed(Builder builder) {
        this(builder.requestid, builder.token, builder.feedid);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof HideFeed)) {
            return false;
        }
        HideFeed hideFeed = (HideFeed) obj;
        if (!equals((Object) this.requestid, (Object) hideFeed.requestid) || !equals((Object) this.token, (Object) hideFeed.token) || !equals((Object) this.feedid, (Object) hideFeed.feedid)) {
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
        Long l = this.feedid;
        if (l != null) {
            i2 = l.hashCode();
        }
        int i3 = hashCode2 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<HideFeed> {
        public Long feedid;
        public String requestid;
        public String token;

        public Builder() {
        }

        public Builder(HideFeed hideFeed) {
            super(hideFeed);
            if (hideFeed != null) {
                this.requestid = hideFeed.requestid;
                this.token = hideFeed.token;
                this.feedid = hideFeed.feedid;
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

        public Builder feedid(Long l) {
            this.feedid = l;
            return this;
        }

        public HideFeed build() {
            return new HideFeed(this);
        }
    }
}
