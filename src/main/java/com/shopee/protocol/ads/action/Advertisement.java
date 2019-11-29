package com.shopee.protocol.ads.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import e.f;

public final class Advertisement extends Message {
    public static final Long DEFAULT_ADSID = 0L;
    public static final Long DEFAULT_CAMPAIGNID = 0L;
    public static final Long DEFAULT_CTIME = 0L;
    public static final f DEFAULT_EXTINFO = f.f32736b;
    public static final Long DEFAULT_ITEMID = 0L;
    public static final Long DEFAULT_MTIME = 0L;
    public static final Integer DEFAULT_PLACEMENT = 0;
    public static final Integer DEFAULT_SHOPID = 0;
    public static final Integer DEFAULT_STATUS = 0;
    public static final Integer DEFAULT_USERID = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long adsid;
    @ProtoField(tag = 4, type = Message.Datatype.INT64)
    public final Long campaignid;
    @ProtoField(tag = 7, type = Message.Datatype.INT64)
    public final Long ctime;
    @ProtoField(tag = 5, type = Message.Datatype.BYTES)
    public final f extinfo;
    @ProtoField(tag = 2, type = Message.Datatype.INT64)
    public final Long itemid;
    @ProtoField(tag = 8, type = Message.Datatype.INT64)
    public final Long mtime;
    @ProtoField(tag = 10, type = Message.Datatype.INT32)
    public final Integer placement;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer shopid;
    @ProtoField(tag = 6, type = Message.Datatype.INT32)
    public final Integer status;
    @ProtoField(tag = 9, type = Message.Datatype.INT32)
    public final Integer userid;

    public Advertisement(Long l, Long l2, Integer num, Long l3, f fVar, Integer num2, Long l4, Long l5, Integer num3, Integer num4) {
        this.adsid = l;
        this.itemid = l2;
        this.shopid = num;
        this.campaignid = l3;
        this.extinfo = fVar;
        this.status = num2;
        this.ctime = l4;
        this.mtime = l5;
        this.userid = num3;
        this.placement = num4;
    }

    private Advertisement(Builder builder) {
        this(builder.adsid, builder.itemid, builder.shopid, builder.campaignid, builder.extinfo, builder.status, builder.ctime, builder.mtime, builder.userid, builder.placement);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Advertisement)) {
            return false;
        }
        Advertisement advertisement = (Advertisement) obj;
        if (!equals((Object) this.adsid, (Object) advertisement.adsid) || !equals((Object) this.itemid, (Object) advertisement.itemid) || !equals((Object) this.shopid, (Object) advertisement.shopid) || !equals((Object) this.campaignid, (Object) advertisement.campaignid) || !equals((Object) this.extinfo, (Object) advertisement.extinfo) || !equals((Object) this.status, (Object) advertisement.status) || !equals((Object) this.ctime, (Object) advertisement.ctime) || !equals((Object) this.mtime, (Object) advertisement.mtime) || !equals((Object) this.userid, (Object) advertisement.userid) || !equals((Object) this.placement, (Object) advertisement.placement)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Long l = this.adsid;
        int i2 = 0;
        int hashCode = (l != null ? l.hashCode() : 0) * 37;
        Long l2 = this.itemid;
        int hashCode2 = (hashCode + (l2 != null ? l2.hashCode() : 0)) * 37;
        Integer num = this.shopid;
        int hashCode3 = (hashCode2 + (num != null ? num.hashCode() : 0)) * 37;
        Long l3 = this.campaignid;
        int hashCode4 = (hashCode3 + (l3 != null ? l3.hashCode() : 0)) * 37;
        f fVar = this.extinfo;
        int hashCode5 = (hashCode4 + (fVar != null ? fVar.hashCode() : 0)) * 37;
        Integer num2 = this.status;
        int hashCode6 = (hashCode5 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Long l4 = this.ctime;
        int hashCode7 = (hashCode6 + (l4 != null ? l4.hashCode() : 0)) * 37;
        Long l5 = this.mtime;
        int hashCode8 = (hashCode7 + (l5 != null ? l5.hashCode() : 0)) * 37;
        Integer num3 = this.userid;
        int hashCode9 = (hashCode8 + (num3 != null ? num3.hashCode() : 0)) * 37;
        Integer num4 = this.placement;
        if (num4 != null) {
            i2 = num4.hashCode();
        }
        int i3 = hashCode9 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<Advertisement> {
        public Long adsid;
        public Long campaignid;
        public Long ctime;
        public f extinfo;
        public Long itemid;
        public Long mtime;
        public Integer placement;
        public Integer shopid;
        public Integer status;
        public Integer userid;

        public Builder() {
        }

        public Builder(Advertisement advertisement) {
            super(advertisement);
            if (advertisement != null) {
                this.adsid = advertisement.adsid;
                this.itemid = advertisement.itemid;
                this.shopid = advertisement.shopid;
                this.campaignid = advertisement.campaignid;
                this.extinfo = advertisement.extinfo;
                this.status = advertisement.status;
                this.ctime = advertisement.ctime;
                this.mtime = advertisement.mtime;
                this.userid = advertisement.userid;
                this.placement = advertisement.placement;
            }
        }

        public Builder adsid(Long l) {
            this.adsid = l;
            return this;
        }

        public Builder itemid(Long l) {
            this.itemid = l;
            return this;
        }

        public Builder shopid(Integer num) {
            this.shopid = num;
            return this;
        }

        public Builder campaignid(Long l) {
            this.campaignid = l;
            return this;
        }

        public Builder extinfo(f fVar) {
            this.extinfo = fVar;
            return this;
        }

        public Builder status(Integer num) {
            this.status = num;
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

        public Builder userid(Integer num) {
            this.userid = num;
            return this;
        }

        public Builder placement(Integer num) {
            this.placement = num;
            return this;
        }

        public Advertisement build() {
            return new Advertisement(this);
        }
    }
}
