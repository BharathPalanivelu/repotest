package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import e.f;

public final class OrderAudit extends Message {
    public static final Integer DEFAULT_AUDITID = 0;
    public static final String DEFAULT_COUNTRY = "";
    public static final Integer DEFAULT_CTIME = 0;
    public static final String DEFAULT_DATA = "";
    public static final Integer DEFAULT_ESTIMATE_TIME = 0;
    public static final f DEFAULT_EXTINFO = f.f32736b;
    public static final Integer DEFAULT_MTIME = 0;
    public static final Integer DEFAULT_NEW_STATUS = 0;
    public static final Integer DEFAULT_OLD_STATUS = 0;
    public static final Integer DEFAULT_OPUSERID = 0;
    public static final Long DEFAULT_ORDERID = 0L;
    public static final Integer DEFAULT_SHOPID = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer auditid;
    @ProtoField(tag = 10, type = Message.Datatype.STRING)
    public final String country;
    @ProtoField(tag = 8, type = Message.Datatype.INT32)
    public final Integer ctime;
    @ProtoField(tag = 7, type = Message.Datatype.STRING)
    public final String data;
    @ProtoField(tag = 11, type = Message.Datatype.INT32)
    public final Integer estimate_time;
    @ProtoField(tag = 12, type = Message.Datatype.BYTES)
    public final f extinfo;
    @ProtoField(tag = 9, type = Message.Datatype.INT32)
    public final Integer mtime;
    @ProtoField(tag = 6, type = Message.Datatype.INT32)
    public final Integer new_status;
    @ProtoField(tag = 5, type = Message.Datatype.INT32)
    public final Integer old_status;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer opuserid;
    @ProtoField(tag = 3, type = Message.Datatype.INT64)
    public final Long orderid;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer shopid;

    public OrderAudit(Integer num, Integer num2, Long l, Integer num3, Integer num4, Integer num5, String str, Integer num6, Integer num7, String str2, Integer num8, f fVar) {
        this.auditid = num;
        this.shopid = num2;
        this.orderid = l;
        this.opuserid = num3;
        this.old_status = num4;
        this.new_status = num5;
        this.data = str;
        this.ctime = num6;
        this.mtime = num7;
        this.country = str2;
        this.estimate_time = num8;
        this.extinfo = fVar;
    }

    private OrderAudit(Builder builder) {
        this(builder.auditid, builder.shopid, builder.orderid, builder.opuserid, builder.old_status, builder.new_status, builder.data, builder.ctime, builder.mtime, builder.country, builder.estimate_time, builder.extinfo);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof OrderAudit)) {
            return false;
        }
        OrderAudit orderAudit = (OrderAudit) obj;
        if (!equals((Object) this.auditid, (Object) orderAudit.auditid) || !equals((Object) this.shopid, (Object) orderAudit.shopid) || !equals((Object) this.orderid, (Object) orderAudit.orderid) || !equals((Object) this.opuserid, (Object) orderAudit.opuserid) || !equals((Object) this.old_status, (Object) orderAudit.old_status) || !equals((Object) this.new_status, (Object) orderAudit.new_status) || !equals((Object) this.data, (Object) orderAudit.data) || !equals((Object) this.ctime, (Object) orderAudit.ctime) || !equals((Object) this.mtime, (Object) orderAudit.mtime) || !equals((Object) this.country, (Object) orderAudit.country) || !equals((Object) this.estimate_time, (Object) orderAudit.estimate_time) || !equals((Object) this.extinfo, (Object) orderAudit.extinfo)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Integer num = this.auditid;
        int i2 = 0;
        int hashCode = (num != null ? num.hashCode() : 0) * 37;
        Integer num2 = this.shopid;
        int hashCode2 = (hashCode + (num2 != null ? num2.hashCode() : 0)) * 37;
        Long l = this.orderid;
        int hashCode3 = (hashCode2 + (l != null ? l.hashCode() : 0)) * 37;
        Integer num3 = this.opuserid;
        int hashCode4 = (hashCode3 + (num3 != null ? num3.hashCode() : 0)) * 37;
        Integer num4 = this.old_status;
        int hashCode5 = (hashCode4 + (num4 != null ? num4.hashCode() : 0)) * 37;
        Integer num5 = this.new_status;
        int hashCode6 = (hashCode5 + (num5 != null ? num5.hashCode() : 0)) * 37;
        String str = this.data;
        int hashCode7 = (hashCode6 + (str != null ? str.hashCode() : 0)) * 37;
        Integer num6 = this.ctime;
        int hashCode8 = (hashCode7 + (num6 != null ? num6.hashCode() : 0)) * 37;
        Integer num7 = this.mtime;
        int hashCode9 = (hashCode8 + (num7 != null ? num7.hashCode() : 0)) * 37;
        String str2 = this.country;
        int hashCode10 = (hashCode9 + (str2 != null ? str2.hashCode() : 0)) * 37;
        Integer num8 = this.estimate_time;
        int hashCode11 = (hashCode10 + (num8 != null ? num8.hashCode() : 0)) * 37;
        f fVar = this.extinfo;
        if (fVar != null) {
            i2 = fVar.hashCode();
        }
        int i3 = hashCode11 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<OrderAudit> {
        public Integer auditid;
        public String country;
        public Integer ctime;
        public String data;
        public Integer estimate_time;
        public f extinfo;
        public Integer mtime;
        public Integer new_status;
        public Integer old_status;
        public Integer opuserid;
        public Long orderid;
        public Integer shopid;

        public Builder() {
        }

        public Builder(OrderAudit orderAudit) {
            super(orderAudit);
            if (orderAudit != null) {
                this.auditid = orderAudit.auditid;
                this.shopid = orderAudit.shopid;
                this.orderid = orderAudit.orderid;
                this.opuserid = orderAudit.opuserid;
                this.old_status = orderAudit.old_status;
                this.new_status = orderAudit.new_status;
                this.data = orderAudit.data;
                this.ctime = orderAudit.ctime;
                this.mtime = orderAudit.mtime;
                this.country = orderAudit.country;
                this.estimate_time = orderAudit.estimate_time;
                this.extinfo = orderAudit.extinfo;
            }
        }

        public Builder auditid(Integer num) {
            this.auditid = num;
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

        public Builder opuserid(Integer num) {
            this.opuserid = num;
            return this;
        }

        public Builder old_status(Integer num) {
            this.old_status = num;
            return this;
        }

        public Builder new_status(Integer num) {
            this.new_status = num;
            return this;
        }

        public Builder data(String str) {
            this.data = str;
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

        public Builder country(String str) {
            this.country = str;
            return this;
        }

        public Builder estimate_time(Integer num) {
            this.estimate_time = num;
            return this;
        }

        public Builder extinfo(f fVar) {
            this.extinfo = fVar;
            return this;
        }

        public OrderAudit build() {
            return new OrderAudit(this);
        }
    }
}
