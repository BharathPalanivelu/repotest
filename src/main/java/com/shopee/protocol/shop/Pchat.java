package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class Pchat extends Message {
    public static final Integer DEFAULT_BUYER_CLEAR_TIME = 0;
    public static final Long DEFAULT_BUYER_LAST_READ = 0L;
    public static final Integer DEFAULT_BUYER_UNREAD = 0;
    public static final Integer DEFAULT_BUYER_USERID = 0;
    public static final Integer DEFAULT_CTIME = 0;
    public static final Long DEFAULT_LAST_MSGID = 0L;
    public static final Integer DEFAULT_LAST_MSGTIME = 0;
    public static final Integer DEFAULT_MTIME = 0;
    public static final Long DEFAULT_PCHATID = 0L;
    public static final Integer DEFAULT_SELLER_CLEAR_TIME = 0;
    public static final Long DEFAULT_SELLER_LAST_READ = 0L;
    public static final Integer DEFAULT_SELLER_UNREAD = 0;
    public static final Integer DEFAULT_SELLER_USERID = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer buyer_clear_time;
    @ProtoField(tag = 6, type = Message.Datatype.INT64)
    public final Long buyer_last_read;
    @ProtoField(tag = 12, type = Message.Datatype.INT32)
    public final Integer buyer_unread;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer buyer_userid;
    @ProtoField(tag = 10, type = Message.Datatype.INT32)
    public final Integer ctime;
    @ProtoField(tag = 8, type = Message.Datatype.INT64)
    public final Long last_msgid;
    @ProtoField(tag = 9, type = Message.Datatype.INT32)
    public final Integer last_msgtime;
    @ProtoField(tag = 11, type = Message.Datatype.INT32)
    public final Integer mtime;
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long pchatid;
    @ProtoField(tag = 5, type = Message.Datatype.INT32)
    public final Integer seller_clear_time;
    @ProtoField(tag = 7, type = Message.Datatype.INT64)
    public final Long seller_last_read;
    @ProtoField(tag = 13, type = Message.Datatype.INT32)
    public final Integer seller_unread;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer seller_userid;

    public Pchat(Long l, Integer num, Integer num2, Integer num3, Integer num4, Long l2, Long l3, Long l4, Integer num5, Integer num6, Integer num7, Integer num8, Integer num9) {
        this.pchatid = l;
        this.buyer_userid = num;
        this.seller_userid = num2;
        this.buyer_clear_time = num3;
        this.seller_clear_time = num4;
        this.buyer_last_read = l2;
        this.seller_last_read = l3;
        this.last_msgid = l4;
        this.last_msgtime = num5;
        this.ctime = num6;
        this.mtime = num7;
        this.buyer_unread = num8;
        this.seller_unread = num9;
    }

    private Pchat(Builder builder) {
        this(builder.pchatid, builder.buyer_userid, builder.seller_userid, builder.buyer_clear_time, builder.seller_clear_time, builder.buyer_last_read, builder.seller_last_read, builder.last_msgid, builder.last_msgtime, builder.ctime, builder.mtime, builder.buyer_unread, builder.seller_unread);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Pchat)) {
            return false;
        }
        Pchat pchat = (Pchat) obj;
        if (!equals((Object) this.pchatid, (Object) pchat.pchatid) || !equals((Object) this.buyer_userid, (Object) pchat.buyer_userid) || !equals((Object) this.seller_userid, (Object) pchat.seller_userid) || !equals((Object) this.buyer_clear_time, (Object) pchat.buyer_clear_time) || !equals((Object) this.seller_clear_time, (Object) pchat.seller_clear_time) || !equals((Object) this.buyer_last_read, (Object) pchat.buyer_last_read) || !equals((Object) this.seller_last_read, (Object) pchat.seller_last_read) || !equals((Object) this.last_msgid, (Object) pchat.last_msgid) || !equals((Object) this.last_msgtime, (Object) pchat.last_msgtime) || !equals((Object) this.ctime, (Object) pchat.ctime) || !equals((Object) this.mtime, (Object) pchat.mtime) || !equals((Object) this.buyer_unread, (Object) pchat.buyer_unread) || !equals((Object) this.seller_unread, (Object) pchat.seller_unread)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Long l = this.pchatid;
        int i2 = 0;
        int hashCode = (l != null ? l.hashCode() : 0) * 37;
        Integer num = this.buyer_userid;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 37;
        Integer num2 = this.seller_userid;
        int hashCode3 = (hashCode2 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Integer num3 = this.buyer_clear_time;
        int hashCode4 = (hashCode3 + (num3 != null ? num3.hashCode() : 0)) * 37;
        Integer num4 = this.seller_clear_time;
        int hashCode5 = (hashCode4 + (num4 != null ? num4.hashCode() : 0)) * 37;
        Long l2 = this.buyer_last_read;
        int hashCode6 = (hashCode5 + (l2 != null ? l2.hashCode() : 0)) * 37;
        Long l3 = this.seller_last_read;
        int hashCode7 = (hashCode6 + (l3 != null ? l3.hashCode() : 0)) * 37;
        Long l4 = this.last_msgid;
        int hashCode8 = (hashCode7 + (l4 != null ? l4.hashCode() : 0)) * 37;
        Integer num5 = this.last_msgtime;
        int hashCode9 = (hashCode8 + (num5 != null ? num5.hashCode() : 0)) * 37;
        Integer num6 = this.ctime;
        int hashCode10 = (hashCode9 + (num6 != null ? num6.hashCode() : 0)) * 37;
        Integer num7 = this.mtime;
        int hashCode11 = (hashCode10 + (num7 != null ? num7.hashCode() : 0)) * 37;
        Integer num8 = this.buyer_unread;
        int hashCode12 = (hashCode11 + (num8 != null ? num8.hashCode() : 0)) * 37;
        Integer num9 = this.seller_unread;
        if (num9 != null) {
            i2 = num9.hashCode();
        }
        int i3 = hashCode12 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<Pchat> {
        public Integer buyer_clear_time;
        public Long buyer_last_read;
        public Integer buyer_unread;
        public Integer buyer_userid;
        public Integer ctime;
        public Long last_msgid;
        public Integer last_msgtime;
        public Integer mtime;
        public Long pchatid;
        public Integer seller_clear_time;
        public Long seller_last_read;
        public Integer seller_unread;
        public Integer seller_userid;

        public Builder() {
        }

        public Builder(Pchat pchat) {
            super(pchat);
            if (pchat != null) {
                this.pchatid = pchat.pchatid;
                this.buyer_userid = pchat.buyer_userid;
                this.seller_userid = pchat.seller_userid;
                this.buyer_clear_time = pchat.buyer_clear_time;
                this.seller_clear_time = pchat.seller_clear_time;
                this.buyer_last_read = pchat.buyer_last_read;
                this.seller_last_read = pchat.seller_last_read;
                this.last_msgid = pchat.last_msgid;
                this.last_msgtime = pchat.last_msgtime;
                this.ctime = pchat.ctime;
                this.mtime = pchat.mtime;
                this.buyer_unread = pchat.buyer_unread;
                this.seller_unread = pchat.seller_unread;
            }
        }

        public Builder pchatid(Long l) {
            this.pchatid = l;
            return this;
        }

        public Builder buyer_userid(Integer num) {
            this.buyer_userid = num;
            return this;
        }

        public Builder seller_userid(Integer num) {
            this.seller_userid = num;
            return this;
        }

        public Builder buyer_clear_time(Integer num) {
            this.buyer_clear_time = num;
            return this;
        }

        public Builder seller_clear_time(Integer num) {
            this.seller_clear_time = num;
            return this;
        }

        public Builder buyer_last_read(Long l) {
            this.buyer_last_read = l;
            return this;
        }

        public Builder seller_last_read(Long l) {
            this.seller_last_read = l;
            return this;
        }

        public Builder last_msgid(Long l) {
            this.last_msgid = l;
            return this;
        }

        public Builder last_msgtime(Integer num) {
            this.last_msgtime = num;
            return this;
        }

        public Builder ctime(Integer num) {
            this.ctime = num;
            return this;
        }

        public Builder mtime(Integer num) {
            this.mtime = num;
            return this;
        }

        public Builder buyer_unread(Integer num) {
            this.buyer_unread = num;
            return this;
        }

        public Builder seller_unread(Integer num) {
            this.seller_unread = num;
            return this;
        }

        public Pchat build() {
            return new Pchat(this);
        }
    }
}
