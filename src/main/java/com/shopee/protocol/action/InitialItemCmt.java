package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class InitialItemCmt extends Message {
    public static final Long DEFAULT_CMTID = 0L;
    public static final Long DEFAULT_COINS = 0L;
    public static final Integer DEFAULT_COIN_STATUS = 0;
    public static final String DEFAULT_COMMENT = "";
    public static final Integer DEFAULT_CTIME = 0;
    public static final List<String> DEFAULT_IMAGES = Collections.emptyList();
    public static final Long DEFAULT_ITEMID = 0L;
    public static final Integer DEFAULT_SHOPID = 0;
    public static final Integer DEFAULT_USERID = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long cmtid;
    @ProtoField(tag = 9, type = Message.Datatype.INT32)
    public final Integer coin_status;
    @ProtoField(tag = 8, type = Message.Datatype.INT64)
    public final Long coins;
    @ProtoField(tag = 6, type = Message.Datatype.STRING)
    public final String comment;
    @ProtoField(tag = 7, type = Message.Datatype.INT32)
    public final Integer ctime;
    @ProtoField(label = Message.Label.REPEATED, tag = 5, type = Message.Datatype.STRING)
    public final List<String> images;
    @ProtoField(tag = 4, type = Message.Datatype.INT64)
    public final Long itemid;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer shopid;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer userid;

    public InitialItemCmt(Long l, Integer num, Integer num2, Long l2, List<String> list, String str, Integer num3, Long l3, Integer num4) {
        this.cmtid = l;
        this.userid = num;
        this.shopid = num2;
        this.itemid = l2;
        this.images = immutableCopyOf(list);
        this.comment = str;
        this.ctime = num3;
        this.coins = l3;
        this.coin_status = num4;
    }

    private InitialItemCmt(Builder builder) {
        this(builder.cmtid, builder.userid, builder.shopid, builder.itemid, builder.images, builder.comment, builder.ctime, builder.coins, builder.coin_status);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof InitialItemCmt)) {
            return false;
        }
        InitialItemCmt initialItemCmt = (InitialItemCmt) obj;
        if (!equals((Object) this.cmtid, (Object) initialItemCmt.cmtid) || !equals((Object) this.userid, (Object) initialItemCmt.userid) || !equals((Object) this.shopid, (Object) initialItemCmt.shopid) || !equals((Object) this.itemid, (Object) initialItemCmt.itemid) || !equals((List<?>) this.images, (List<?>) initialItemCmt.images) || !equals((Object) this.comment, (Object) initialItemCmt.comment) || !equals((Object) this.ctime, (Object) initialItemCmt.ctime) || !equals((Object) this.coins, (Object) initialItemCmt.coins) || !equals((Object) this.coin_status, (Object) initialItemCmt.coin_status)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Long l = this.cmtid;
        int i2 = 0;
        int hashCode = (l != null ? l.hashCode() : 0) * 37;
        Integer num = this.userid;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 37;
        Integer num2 = this.shopid;
        int hashCode3 = (hashCode2 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Long l2 = this.itemid;
        int hashCode4 = (hashCode3 + (l2 != null ? l2.hashCode() : 0)) * 37;
        List<String> list = this.images;
        int hashCode5 = (hashCode4 + (list != null ? list.hashCode() : 1)) * 37;
        String str = this.comment;
        int hashCode6 = (hashCode5 + (str != null ? str.hashCode() : 0)) * 37;
        Integer num3 = this.ctime;
        int hashCode7 = (hashCode6 + (num3 != null ? num3.hashCode() : 0)) * 37;
        Long l3 = this.coins;
        int hashCode8 = (hashCode7 + (l3 != null ? l3.hashCode() : 0)) * 37;
        Integer num4 = this.coin_status;
        if (num4 != null) {
            i2 = num4.hashCode();
        }
        int i3 = hashCode8 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<InitialItemCmt> {
        public Long cmtid;
        public Integer coin_status;
        public Long coins;
        public String comment;
        public Integer ctime;
        public List<String> images;
        public Long itemid;
        public Integer shopid;
        public Integer userid;

        public Builder() {
        }

        public Builder(InitialItemCmt initialItemCmt) {
            super(initialItemCmt);
            if (initialItemCmt != null) {
                this.cmtid = initialItemCmt.cmtid;
                this.userid = initialItemCmt.userid;
                this.shopid = initialItemCmt.shopid;
                this.itemid = initialItemCmt.itemid;
                this.images = InitialItemCmt.copyOf(initialItemCmt.images);
                this.comment = initialItemCmt.comment;
                this.ctime = initialItemCmt.ctime;
                this.coins = initialItemCmt.coins;
                this.coin_status = initialItemCmt.coin_status;
            }
        }

        public Builder cmtid(Long l) {
            this.cmtid = l;
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

        public Builder images(List<String> list) {
            this.images = checkForNulls(list);
            return this;
        }

        public Builder comment(String str) {
            this.comment = str;
            return this;
        }

        public Builder ctime(Integer num) {
            this.ctime = num;
            return this;
        }

        public Builder coins(Long l) {
            this.coins = l;
            return this;
        }

        public Builder coin_status(Integer num) {
            this.coin_status = num;
            return this;
        }

        public InitialItemCmt build() {
            return new InitialItemCmt(this);
        }
    }
}
