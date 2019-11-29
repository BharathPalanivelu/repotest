package com.shopee.protocol.ads.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class Blacklist extends Message {
    public static final Long DEFAULT_ADSID = 0L;
    public static final Long DEFAULT_CTIME = 0L;
    public static final Long DEFAULT_ID = 0L;
    public static final Long DEFAULT_MTIME = 0L;
    public static final String DEFAULT_QUERY_TOKEN = "";
    public static final Integer DEFAULT_STATUS = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 2, type = Message.Datatype.INT64)
    public final Long adsid;
    @ProtoField(tag = 4, type = Message.Datatype.INT64)
    public final Long ctime;
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long id;
    @ProtoField(tag = 5, type = Message.Datatype.INT64)
    public final Long mtime;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String query_token;
    @ProtoField(tag = 6, type = Message.Datatype.INT32)
    public final Integer status;

    public Blacklist(Long l, Long l2, String str, Long l3, Long l4, Integer num) {
        this.id = l;
        this.adsid = l2;
        this.query_token = str;
        this.ctime = l3;
        this.mtime = l4;
        this.status = num;
    }

    private Blacklist(Builder builder) {
        this(builder.id, builder.adsid, builder.query_token, builder.ctime, builder.mtime, builder.status);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Blacklist)) {
            return false;
        }
        Blacklist blacklist = (Blacklist) obj;
        if (!equals((Object) this.id, (Object) blacklist.id) || !equals((Object) this.adsid, (Object) blacklist.adsid) || !equals((Object) this.query_token, (Object) blacklist.query_token) || !equals((Object) this.ctime, (Object) blacklist.ctime) || !equals((Object) this.mtime, (Object) blacklist.mtime) || !equals((Object) this.status, (Object) blacklist.status)) {
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
        Long l2 = this.adsid;
        int hashCode2 = (hashCode + (l2 != null ? l2.hashCode() : 0)) * 37;
        String str = this.query_token;
        int hashCode3 = (hashCode2 + (str != null ? str.hashCode() : 0)) * 37;
        Long l3 = this.ctime;
        int hashCode4 = (hashCode3 + (l3 != null ? l3.hashCode() : 0)) * 37;
        Long l4 = this.mtime;
        int hashCode5 = (hashCode4 + (l4 != null ? l4.hashCode() : 0)) * 37;
        Integer num = this.status;
        if (num != null) {
            i2 = num.hashCode();
        }
        int i3 = hashCode5 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<Blacklist> {
        public Long adsid;
        public Long ctime;
        public Long id;
        public Long mtime;
        public String query_token;
        public Integer status;

        public Builder() {
        }

        public Builder(Blacklist blacklist) {
            super(blacklist);
            if (blacklist != null) {
                this.id = blacklist.id;
                this.adsid = blacklist.adsid;
                this.query_token = blacklist.query_token;
                this.ctime = blacklist.ctime;
                this.mtime = blacklist.mtime;
                this.status = blacklist.status;
            }
        }

        public Builder id(Long l) {
            this.id = l;
            return this;
        }

        public Builder adsid(Long l) {
            this.adsid = l;
            return this;
        }

        public Builder query_token(String str) {
            this.query_token = str;
            return this;
        }

        public Builder ctime(Long l) {
            this.ctime = l;
            return this;
        }

        public Builder mtime(Long l) {
            this.mtime = l;
            return this;
        }

        public Builder status(Integer num) {
            this.status = num;
            return this;
        }

        public Blacklist build() {
            return new Blacklist(this);
        }
    }
}
