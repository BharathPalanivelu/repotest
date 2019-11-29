package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import e.f;

public final class UserCmt extends Message {
    public static final Long DEFAULT_CMTID = 0L;
    public static final String DEFAULT_COMMENT = "";
    public static final Integer DEFAULT_CTIME = 0;
    public static final Integer DEFAULT_EDITABLE = 0;
    public static final f DEFAULT_EXTINFO = f.f32736b;
    public static final f DEFAULT_MENTIONED = f.f32736b;
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
    @ProtoField(tag = 6, type = Message.Datatype.STRING)
    public final String comment;
    @ProtoField(tag = 7, type = Message.Datatype.INT32)
    public final Integer ctime;
    @ProtoField(tag = 12, type = Message.Datatype.INT32)
    public final Integer editable;
    @ProtoField(tag = 13, type = Message.Datatype.BYTES)
    public final f extinfo;
    @ProtoField(tag = 10, type = Message.Datatype.BYTES)
    public final f mentioned;
    @ProtoField(tag = 8, type = Message.Datatype.INT32)
    public final Integer mtime;
    @ProtoField(tag = 14, type = Message.Datatype.INT32)
    public final Integer opt;
    @ProtoField(tag = 4, type = Message.Datatype.INT64)
    public final Long orderid;
    @ProtoField(tag = 5, type = Message.Datatype.INT32)
    public final Integer rating;
    @ProtoField(tag = 11, type = Message.Datatype.INT32)
    public final Integer rating_star;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer shopid;
    @ProtoField(tag = 9, type = Message.Datatype.INT32)
    public final Integer status;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer userid;

    public UserCmt(Long l, Integer num, Integer num2, Long l2, Integer num3, String str, Integer num4, Integer num5, Integer num6, f fVar, Integer num7, Integer num8, f fVar2, Integer num9) {
        this.cmtid = l;
        this.userid = num;
        this.shopid = num2;
        this.orderid = l2;
        this.rating = num3;
        this.comment = str;
        this.ctime = num4;
        this.mtime = num5;
        this.status = num6;
        this.mentioned = fVar;
        this.rating_star = num7;
        this.editable = num8;
        this.extinfo = fVar2;
        this.opt = num9;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private UserCmt(com.shopee.protocol.shop.UserCmt.Builder r17) {
        /*
            r16 = this;
            r0 = r17
            java.lang.Long r2 = r0.cmtid
            java.lang.Integer r3 = r0.userid
            java.lang.Integer r4 = r0.shopid
            java.lang.Long r5 = r0.orderid
            java.lang.Integer r6 = r0.rating
            java.lang.String r7 = r0.comment
            java.lang.Integer r8 = r0.ctime
            java.lang.Integer r9 = r0.mtime
            java.lang.Integer r10 = r0.status
            e.f r11 = r0.mentioned
            java.lang.Integer r12 = r0.rating_star
            java.lang.Integer r13 = r0.editable
            e.f r14 = r0.extinfo
            java.lang.Integer r15 = r0.opt
            r1 = r16
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15)
            r16.setBuilder(r17)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shopee.protocol.shop.UserCmt.<init>(com.shopee.protocol.shop.UserCmt$Builder):void");
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof UserCmt)) {
            return false;
        }
        UserCmt userCmt = (UserCmt) obj;
        if (!equals((Object) this.cmtid, (Object) userCmt.cmtid) || !equals((Object) this.userid, (Object) userCmt.userid) || !equals((Object) this.shopid, (Object) userCmt.shopid) || !equals((Object) this.orderid, (Object) userCmt.orderid) || !equals((Object) this.rating, (Object) userCmt.rating) || !equals((Object) this.comment, (Object) userCmt.comment) || !equals((Object) this.ctime, (Object) userCmt.ctime) || !equals((Object) this.mtime, (Object) userCmt.mtime) || !equals((Object) this.status, (Object) userCmt.status) || !equals((Object) this.mentioned, (Object) userCmt.mentioned) || !equals((Object) this.rating_star, (Object) userCmt.rating_star) || !equals((Object) this.editable, (Object) userCmt.editable) || !equals((Object) this.extinfo, (Object) userCmt.extinfo) || !equals((Object) this.opt, (Object) userCmt.opt)) {
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
        Long l2 = this.orderid;
        int hashCode4 = (hashCode3 + (l2 != null ? l2.hashCode() : 0)) * 37;
        Integer num3 = this.rating;
        int hashCode5 = (hashCode4 + (num3 != null ? num3.hashCode() : 0)) * 37;
        String str = this.comment;
        int hashCode6 = (hashCode5 + (str != null ? str.hashCode() : 0)) * 37;
        Integer num4 = this.ctime;
        int hashCode7 = (hashCode6 + (num4 != null ? num4.hashCode() : 0)) * 37;
        Integer num5 = this.mtime;
        int hashCode8 = (hashCode7 + (num5 != null ? num5.hashCode() : 0)) * 37;
        Integer num6 = this.status;
        int hashCode9 = (hashCode8 + (num6 != null ? num6.hashCode() : 0)) * 37;
        f fVar = this.mentioned;
        int hashCode10 = (hashCode9 + (fVar != null ? fVar.hashCode() : 0)) * 37;
        Integer num7 = this.rating_star;
        int hashCode11 = (hashCode10 + (num7 != null ? num7.hashCode() : 0)) * 37;
        Integer num8 = this.editable;
        int hashCode12 = (hashCode11 + (num8 != null ? num8.hashCode() : 0)) * 37;
        f fVar2 = this.extinfo;
        int hashCode13 = (hashCode12 + (fVar2 != null ? fVar2.hashCode() : 0)) * 37;
        Integer num9 = this.opt;
        if (num9 != null) {
            i2 = num9.hashCode();
        }
        int i3 = hashCode13 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<UserCmt> {
        public Long cmtid;
        public String comment;
        public Integer ctime;
        public Integer editable;
        public f extinfo;
        public f mentioned;
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

        public Builder(UserCmt userCmt) {
            super(userCmt);
            if (userCmt != null) {
                this.cmtid = userCmt.cmtid;
                this.userid = userCmt.userid;
                this.shopid = userCmt.shopid;
                this.orderid = userCmt.orderid;
                this.rating = userCmt.rating;
                this.comment = userCmt.comment;
                this.ctime = userCmt.ctime;
                this.mtime = userCmt.mtime;
                this.status = userCmt.status;
                this.mentioned = userCmt.mentioned;
                this.rating_star = userCmt.rating_star;
                this.editable = userCmt.editable;
                this.extinfo = userCmt.extinfo;
                this.opt = userCmt.opt;
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

        public Builder orderid(Long l) {
            this.orderid = l;
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

        public Builder mtime(Integer num) {
            this.mtime = num;
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

        public Builder opt(Integer num) {
            this.opt = num;
            return this;
        }

        public UserCmt build() {
            return new UserCmt(this);
        }
    }
}
