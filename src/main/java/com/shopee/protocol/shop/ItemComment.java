package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import e.f;

public final class ItemComment extends Message {
    public static final Integer DEFAULT_CMTID = 0;
    public static final String DEFAULT_COMMENT = "";
    public static final Integer DEFAULT_CTIME = 0;
    public static final Long DEFAULT_ITEMID = 0L;
    public static final f DEFAULT_MENTIONED = f.f32736b;
    public static final Long DEFAULT_MODELID = 0L;
    public static final Long DEFAULT_ORDERID = 0L;
    public static final Integer DEFAULT_RATING = 0;
    public static final Integer DEFAULT_RATING_STAR = 0;
    public static final Integer DEFAULT_SHOPID = 0;
    public static final Integer DEFAULT_STATUS = 0;
    public static final Integer DEFAULT_USERID = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer cmtid;
    @ProtoField(tag = 8, type = Message.Datatype.STRING)
    public final String comment;
    @ProtoField(tag = 9, type = Message.Datatype.INT32)
    public final Integer ctime;
    @ProtoField(tag = 5, type = Message.Datatype.INT64)
    public final Long itemid;
    @ProtoField(tag = 11, type = Message.Datatype.BYTES)
    public final f mentioned;
    @ProtoField(tag = 6, type = Message.Datatype.INT64)
    public final Long modelid;
    @ProtoField(tag = 3, type = Message.Datatype.INT64)
    public final Long orderid;
    @ProtoField(tag = 7, type = Message.Datatype.INT32)
    public final Integer rating;
    @ProtoField(tag = 12, type = Message.Datatype.INT32)
    public final Integer rating_star;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer shopid;
    @ProtoField(tag = 10, type = Message.Datatype.INT32)
    public final Integer status;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer userid;

    public ItemComment(Integer num, Integer num2, Long l, Integer num3, Long l2, Long l3, Integer num4, String str, Integer num5, Integer num6, f fVar, Integer num7) {
        this.cmtid = num;
        this.userid = num2;
        this.orderid = l;
        this.shopid = num3;
        this.itemid = l2;
        this.modelid = l3;
        this.rating = num4;
        this.comment = str;
        this.ctime = num5;
        this.status = num6;
        this.mentioned = fVar;
        this.rating_star = num7;
    }

    private ItemComment(Builder builder) {
        this(builder.cmtid, builder.userid, builder.orderid, builder.shopid, builder.itemid, builder.modelid, builder.rating, builder.comment, builder.ctime, builder.status, builder.mentioned, builder.rating_star);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ItemComment)) {
            return false;
        }
        ItemComment itemComment = (ItemComment) obj;
        if (!equals((Object) this.cmtid, (Object) itemComment.cmtid) || !equals((Object) this.userid, (Object) itemComment.userid) || !equals((Object) this.orderid, (Object) itemComment.orderid) || !equals((Object) this.shopid, (Object) itemComment.shopid) || !equals((Object) this.itemid, (Object) itemComment.itemid) || !equals((Object) this.modelid, (Object) itemComment.modelid) || !equals((Object) this.rating, (Object) itemComment.rating) || !equals((Object) this.comment, (Object) itemComment.comment) || !equals((Object) this.ctime, (Object) itemComment.ctime) || !equals((Object) this.status, (Object) itemComment.status) || !equals((Object) this.mentioned, (Object) itemComment.mentioned) || !equals((Object) this.rating_star, (Object) itemComment.rating_star)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Integer num = this.cmtid;
        int i2 = 0;
        int hashCode = (num != null ? num.hashCode() : 0) * 37;
        Integer num2 = this.userid;
        int hashCode2 = (hashCode + (num2 != null ? num2.hashCode() : 0)) * 37;
        Long l = this.orderid;
        int hashCode3 = (hashCode2 + (l != null ? l.hashCode() : 0)) * 37;
        Integer num3 = this.shopid;
        int hashCode4 = (hashCode3 + (num3 != null ? num3.hashCode() : 0)) * 37;
        Long l2 = this.itemid;
        int hashCode5 = (hashCode4 + (l2 != null ? l2.hashCode() : 0)) * 37;
        Long l3 = this.modelid;
        int hashCode6 = (hashCode5 + (l3 != null ? l3.hashCode() : 0)) * 37;
        Integer num4 = this.rating;
        int hashCode7 = (hashCode6 + (num4 != null ? num4.hashCode() : 0)) * 37;
        String str = this.comment;
        int hashCode8 = (hashCode7 + (str != null ? str.hashCode() : 0)) * 37;
        Integer num5 = this.ctime;
        int hashCode9 = (hashCode8 + (num5 != null ? num5.hashCode() : 0)) * 37;
        Integer num6 = this.status;
        int hashCode10 = (hashCode9 + (num6 != null ? num6.hashCode() : 0)) * 37;
        f fVar = this.mentioned;
        int hashCode11 = (hashCode10 + (fVar != null ? fVar.hashCode() : 0)) * 37;
        Integer num7 = this.rating_star;
        if (num7 != null) {
            i2 = num7.hashCode();
        }
        int i3 = hashCode11 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<ItemComment> {
        public Integer cmtid;
        public String comment;
        public Integer ctime;
        public Long itemid;
        public f mentioned;
        public Long modelid;
        public Long orderid;
        public Integer rating;
        public Integer rating_star;
        public Integer shopid;
        public Integer status;
        public Integer userid;

        public Builder() {
        }

        public Builder(ItemComment itemComment) {
            super(itemComment);
            if (itemComment != null) {
                this.cmtid = itemComment.cmtid;
                this.userid = itemComment.userid;
                this.orderid = itemComment.orderid;
                this.shopid = itemComment.shopid;
                this.itemid = itemComment.itemid;
                this.modelid = itemComment.modelid;
                this.rating = itemComment.rating;
                this.comment = itemComment.comment;
                this.ctime = itemComment.ctime;
                this.status = itemComment.status;
                this.mentioned = itemComment.mentioned;
                this.rating_star = itemComment.rating_star;
            }
        }

        public Builder cmtid(Integer num) {
            this.cmtid = num;
            return this;
        }

        public Builder userid(Integer num) {
            this.userid = num;
            return this;
        }

        public Builder orderid(Long l) {
            this.orderid = l;
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

        public Builder modelid(Long l) {
            this.modelid = l;
            return this;
        }

        public Builder rating(Integer num) {
            this.rating = num;
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

        public Builder status(Integer num) {
            this.status = num;
            return this;
        }

        public Builder mentioned(f fVar) {
            this.mentioned = fVar;
            return this;
        }

        public Builder rating_star(Integer num) {
            this.rating_star = num;
            return this;
        }

        public ItemComment build() {
            return new ItemComment(this);
        }
    }
}
