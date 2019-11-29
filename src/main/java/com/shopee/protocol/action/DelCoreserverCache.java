package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class DelCoreserverCache extends Message {
    public static final Long DEFAULT_ITEMID = 0L;
    public static final String DEFAULT_REQUESTID = "";
    public static final Integer DEFAULT_SHOPID = 0;
    public static final Integer DEFAULT_TYPE = 0;
    public static final Integer DEFAULT_USERID = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 5, type = Message.Datatype.INT64)
    public final Long itemid;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer shopid;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer type;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer userid;

    public DelCoreserverCache(String str, Integer num, Integer num2, Integer num3, Long l) {
        this.requestid = str;
        this.type = num;
        this.userid = num2;
        this.shopid = num3;
        this.itemid = l;
    }

    private DelCoreserverCache(Builder builder) {
        this(builder.requestid, builder.type, builder.userid, builder.shopid, builder.itemid);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof DelCoreserverCache)) {
            return false;
        }
        DelCoreserverCache delCoreserverCache = (DelCoreserverCache) obj;
        if (!equals((Object) this.requestid, (Object) delCoreserverCache.requestid) || !equals((Object) this.type, (Object) delCoreserverCache.type) || !equals((Object) this.userid, (Object) delCoreserverCache.userid) || !equals((Object) this.shopid, (Object) delCoreserverCache.shopid) || !equals((Object) this.itemid, (Object) delCoreserverCache.itemid)) {
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
        Integer num = this.type;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 37;
        Integer num2 = this.userid;
        int hashCode3 = (hashCode2 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Integer num3 = this.shopid;
        int hashCode4 = (hashCode3 + (num3 != null ? num3.hashCode() : 0)) * 37;
        Long l = this.itemid;
        if (l != null) {
            i2 = l.hashCode();
        }
        int i3 = hashCode4 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<DelCoreserverCache> {
        public Long itemid;
        public String requestid;
        public Integer shopid;
        public Integer type;
        public Integer userid;

        public Builder() {
        }

        public Builder(DelCoreserverCache delCoreserverCache) {
            super(delCoreserverCache);
            if (delCoreserverCache != null) {
                this.requestid = delCoreserverCache.requestid;
                this.type = delCoreserverCache.type;
                this.userid = delCoreserverCache.userid;
                this.shopid = delCoreserverCache.shopid;
                this.itemid = delCoreserverCache.itemid;
            }
        }

        public Builder requestid(String str) {
            this.requestid = str;
            return this;
        }

        public Builder type(Integer num) {
            this.type = num;
            return this;
        }

        public Builder userid(Integer num) {
            this.userid = num;
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

        public DelCoreserverCache build() {
            return new DelCoreserverCache(this);
        }
    }
}
