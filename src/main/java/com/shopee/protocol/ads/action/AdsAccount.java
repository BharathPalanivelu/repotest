package com.shopee.protocol.ads.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import e.f;

public final class AdsAccount extends Message {
    public static final Long DEFAULT_ACCOUNTID = 0L;
    public static final Long DEFAULT_BALANCE = 0L;
    public static final Long DEFAULT_CTIME = 0L;
    public static final f DEFAULT_EXTINFO = f.f32736b;
    public static final Long DEFAULT_MTIME = 0L;
    public static final Long DEFAULT_OVERDUE_LIMIT = 0L;
    public static final Integer DEFAULT_STATUS = 0;
    public static final Integer DEFAULT_USERID = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long accountid;
    @ProtoField(tag = 3, type = Message.Datatype.INT64)
    public final Long balance;
    @ProtoField(tag = 4, type = Message.Datatype.INT64)
    public final Long ctime;
    @ProtoField(tag = 8, type = Message.Datatype.BYTES)
    public final f extinfo;
    @ProtoField(tag = 5, type = Message.Datatype.INT64)
    public final Long mtime;
    @ProtoField(tag = 7, type = Message.Datatype.INT64)
    public final Long overdue_limit;
    @ProtoField(tag = 6, type = Message.Datatype.INT32)
    public final Integer status;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer userid;

    public AdsAccount(Long l, Integer num, Long l2, Long l3, Long l4, Integer num2, Long l5, f fVar) {
        this.accountid = l;
        this.userid = num;
        this.balance = l2;
        this.ctime = l3;
        this.mtime = l4;
        this.status = num2;
        this.overdue_limit = l5;
        this.extinfo = fVar;
    }

    private AdsAccount(Builder builder) {
        this(builder.accountid, builder.userid, builder.balance, builder.ctime, builder.mtime, builder.status, builder.overdue_limit, builder.extinfo);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AdsAccount)) {
            return false;
        }
        AdsAccount adsAccount = (AdsAccount) obj;
        if (!equals((Object) this.accountid, (Object) adsAccount.accountid) || !equals((Object) this.userid, (Object) adsAccount.userid) || !equals((Object) this.balance, (Object) adsAccount.balance) || !equals((Object) this.ctime, (Object) adsAccount.ctime) || !equals((Object) this.mtime, (Object) adsAccount.mtime) || !equals((Object) this.status, (Object) adsAccount.status) || !equals((Object) this.overdue_limit, (Object) adsAccount.overdue_limit) || !equals((Object) this.extinfo, (Object) adsAccount.extinfo)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Long l = this.accountid;
        int i2 = 0;
        int hashCode = (l != null ? l.hashCode() : 0) * 37;
        Integer num = this.userid;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 37;
        Long l2 = this.balance;
        int hashCode3 = (hashCode2 + (l2 != null ? l2.hashCode() : 0)) * 37;
        Long l3 = this.ctime;
        int hashCode4 = (hashCode3 + (l3 != null ? l3.hashCode() : 0)) * 37;
        Long l4 = this.mtime;
        int hashCode5 = (hashCode4 + (l4 != null ? l4.hashCode() : 0)) * 37;
        Integer num2 = this.status;
        int hashCode6 = (hashCode5 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Long l5 = this.overdue_limit;
        int hashCode7 = (hashCode6 + (l5 != null ? l5.hashCode() : 0)) * 37;
        f fVar = this.extinfo;
        if (fVar != null) {
            i2 = fVar.hashCode();
        }
        int i3 = hashCode7 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<AdsAccount> {
        public Long accountid;
        public Long balance;
        public Long ctime;
        public f extinfo;
        public Long mtime;
        public Long overdue_limit;
        public Integer status;
        public Integer userid;

        public Builder() {
        }

        public Builder(AdsAccount adsAccount) {
            super(adsAccount);
            if (adsAccount != null) {
                this.accountid = adsAccount.accountid;
                this.userid = adsAccount.userid;
                this.balance = adsAccount.balance;
                this.ctime = adsAccount.ctime;
                this.mtime = adsAccount.mtime;
                this.status = adsAccount.status;
                this.overdue_limit = adsAccount.overdue_limit;
                this.extinfo = adsAccount.extinfo;
            }
        }

        public Builder accountid(Long l) {
            this.accountid = l;
            return this;
        }

        public Builder userid(Integer num) {
            this.userid = num;
            return this;
        }

        public Builder balance(Long l) {
            this.balance = l;
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

        public Builder overdue_limit(Long l) {
            this.overdue_limit = l;
            return this;
        }

        public Builder extinfo(f fVar) {
            this.extinfo = fVar;
            return this;
        }

        public AdsAccount build() {
            return new AdsAccount(this);
        }
    }
}
