package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import e.f;

public final class ItemCmt extends Message {
    public static final Long DEFAULT_CMTID = 0L;
    public static final String DEFAULT_COMMENT = "";
    public static final Integer DEFAULT_CTIME = 0;
    public static final Integer DEFAULT_EDITABLE = 0;
    public static final f DEFAULT_EXTINFO = f.f32736b;
    public static final Integer DEFAULT_FILTER = 0;
    public static final Long DEFAULT_ITEMID = 0L;
    public static final f DEFAULT_MENTIONED = f.f32736b;
    public static final Long DEFAULT_MODELID = 0L;
    public static final Integer DEFAULT_MTIME = 0;
    public static final Integer DEFAULT_OPT = 0;
    public static final Long DEFAULT_ORDERID = 0L;
    public static final Integer DEFAULT_RATING = 0;
    public static final Integer DEFAULT_RATING_STAR = 0;
    public static final Integer DEFAULT_SHOPID = 0;
    public static final Integer DEFAULT_STATUS = 0;
    public static final Integer DEFAULT_USERID = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long cmtid;
    @ProtoField(tag = 8, type = Message.Datatype.STRING)
    public final String comment;
    @ProtoField(tag = 9, type = Message.Datatype.INT32)
    public final Integer ctime;
    @ProtoField(tag = 13, type = Message.Datatype.INT32)
    public final Integer editable;
    @ProtoField(tag = 14, type = Message.Datatype.BYTES)
    public final f extinfo;
    @ProtoField(tag = 17, type = Message.Datatype.INT32)
    public final Integer filter;
    @ProtoField(tag = 5, type = Message.Datatype.INT64)
    public final Long itemid;
    @ProtoField(tag = 11, type = Message.Datatype.BYTES)
    public final f mentioned;
    @ProtoField(tag = 6, type = Message.Datatype.INT64)
    public final Long modelid;
    @ProtoField(tag = 15, type = Message.Datatype.INT32)
    public final Integer mtime;
    @ProtoField(tag = 16, type = Message.Datatype.INT32)
    public final Integer opt;
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

    public ItemCmt(Long l, Integer num, Long l2, Integer num2, Long l3, Long l4, Integer num3, String str, Integer num4, Integer num5, f fVar, Integer num6, Integer num7, f fVar2, Integer num8, Integer num9, Integer num10) {
        this.cmtid = l;
        this.userid = num;
        this.orderid = l2;
        this.shopid = num2;
        this.itemid = l3;
        this.modelid = l4;
        this.rating = num3;
        this.comment = str;
        this.ctime = num4;
        this.status = num5;
        this.mentioned = fVar;
        this.rating_star = num6;
        this.editable = num7;
        this.extinfo = fVar2;
        this.mtime = num8;
        this.opt = num9;
        this.filter = num10;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private ItemCmt(com.shopee.protocol.shop.ItemCmt.Builder r21) {
        /*
            r20 = this;
            r0 = r21
            r1 = r20
            java.lang.Long r2 = r0.cmtid
            java.lang.Integer r3 = r0.userid
            java.lang.Long r4 = r0.orderid
            java.lang.Integer r5 = r0.shopid
            java.lang.Long r6 = r0.itemid
            java.lang.Long r7 = r0.modelid
            java.lang.Integer r8 = r0.rating
            java.lang.String r9 = r0.comment
            java.lang.Integer r10 = r0.ctime
            java.lang.Integer r11 = r0.status
            e.f r12 = r0.mentioned
            java.lang.Integer r13 = r0.rating_star
            java.lang.Integer r14 = r0.editable
            e.f r15 = r0.extinfo
            r19 = r1
            java.lang.Integer r1 = r0.mtime
            r16 = r1
            java.lang.Integer r1 = r0.opt
            r17 = r1
            java.lang.Integer r1 = r0.filter
            r18 = r1
            r1 = r19
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18)
            r20.setBuilder(r21)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shopee.protocol.shop.ItemCmt.<init>(com.shopee.protocol.shop.ItemCmt$Builder):void");
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ItemCmt)) {
            return false;
        }
        ItemCmt itemCmt = (ItemCmt) obj;
        if (!equals((Object) this.cmtid, (Object) itemCmt.cmtid) || !equals((Object) this.userid, (Object) itemCmt.userid) || !equals((Object) this.orderid, (Object) itemCmt.orderid) || !equals((Object) this.shopid, (Object) itemCmt.shopid) || !equals((Object) this.itemid, (Object) itemCmt.itemid) || !equals((Object) this.modelid, (Object) itemCmt.modelid) || !equals((Object) this.rating, (Object) itemCmt.rating) || !equals((Object) this.comment, (Object) itemCmt.comment) || !equals((Object) this.ctime, (Object) itemCmt.ctime) || !equals((Object) this.status, (Object) itemCmt.status) || !equals((Object) this.mentioned, (Object) itemCmt.mentioned) || !equals((Object) this.rating_star, (Object) itemCmt.rating_star) || !equals((Object) this.editable, (Object) itemCmt.editable) || !equals((Object) this.extinfo, (Object) itemCmt.extinfo) || !equals((Object) this.mtime, (Object) itemCmt.mtime) || !equals((Object) this.opt, (Object) itemCmt.opt) || !equals((Object) this.filter, (Object) itemCmt.filter)) {
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
        Long l2 = this.orderid;
        int hashCode3 = (hashCode2 + (l2 != null ? l2.hashCode() : 0)) * 37;
        Integer num2 = this.shopid;
        int hashCode4 = (hashCode3 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Long l3 = this.itemid;
        int hashCode5 = (hashCode4 + (l3 != null ? l3.hashCode() : 0)) * 37;
        Long l4 = this.modelid;
        int hashCode6 = (hashCode5 + (l4 != null ? l4.hashCode() : 0)) * 37;
        Integer num3 = this.rating;
        int hashCode7 = (hashCode6 + (num3 != null ? num3.hashCode() : 0)) * 37;
        String str = this.comment;
        int hashCode8 = (hashCode7 + (str != null ? str.hashCode() : 0)) * 37;
        Integer num4 = this.ctime;
        int hashCode9 = (hashCode8 + (num4 != null ? num4.hashCode() : 0)) * 37;
        Integer num5 = this.status;
        int hashCode10 = (hashCode9 + (num5 != null ? num5.hashCode() : 0)) * 37;
        f fVar = this.mentioned;
        int hashCode11 = (hashCode10 + (fVar != null ? fVar.hashCode() : 0)) * 37;
        Integer num6 = this.rating_star;
        int hashCode12 = (hashCode11 + (num6 != null ? num6.hashCode() : 0)) * 37;
        Integer num7 = this.editable;
        int hashCode13 = (hashCode12 + (num7 != null ? num7.hashCode() : 0)) * 37;
        f fVar2 = this.extinfo;
        int hashCode14 = (hashCode13 + (fVar2 != null ? fVar2.hashCode() : 0)) * 37;
        Integer num8 = this.mtime;
        int hashCode15 = (hashCode14 + (num8 != null ? num8.hashCode() : 0)) * 37;
        Integer num9 = this.opt;
        int hashCode16 = (hashCode15 + (num9 != null ? num9.hashCode() : 0)) * 37;
        Integer num10 = this.filter;
        if (num10 != null) {
            i2 = num10.hashCode();
        }
        int i3 = hashCode16 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<ItemCmt> {
        public Long cmtid;
        public String comment;
        public Integer ctime;
        public Integer editable;
        public f extinfo;
        public Integer filter;
        public Long itemid;
        public f mentioned;
        public Long modelid;
        public Integer mtime;
        public Integer opt;
        public Long orderid;
        public Integer rating;
        public Integer rating_star;
        public Integer shopid;
        public Integer status;
        public Integer userid;

        public Builder() {
        }

        public Builder(ItemCmt itemCmt) {
            super(itemCmt);
            if (itemCmt != null) {
                this.cmtid = itemCmt.cmtid;
                this.userid = itemCmt.userid;
                this.orderid = itemCmt.orderid;
                this.shopid = itemCmt.shopid;
                this.itemid = itemCmt.itemid;
                this.modelid = itemCmt.modelid;
                this.rating = itemCmt.rating;
                this.comment = itemCmt.comment;
                this.ctime = itemCmt.ctime;
                this.status = itemCmt.status;
                this.mentioned = itemCmt.mentioned;
                this.rating_star = itemCmt.rating_star;
                this.editable = itemCmt.editable;
                this.extinfo = itemCmt.extinfo;
                this.mtime = itemCmt.mtime;
                this.opt = itemCmt.opt;
                this.filter = itemCmt.filter;
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

        public Builder editable(Integer num) {
            this.editable = num;
            return this;
        }

        public Builder extinfo(f fVar) {
            this.extinfo = fVar;
            return this;
        }

        public Builder mtime(Integer num) {
            this.mtime = num;
            return this;
        }

        public Builder opt(Integer num) {
            this.opt = num;
            return this;
        }

        public Builder filter(Integer num) {
            this.filter = num;
            return this;
        }

        public ItemCmt build() {
            return new ItemCmt(this);
        }
    }
}
