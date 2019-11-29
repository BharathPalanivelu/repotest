package com.shopee.protocol.ads.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import e.f;

public final class AdvertiseAuditLog extends Message {
    public static final Long DEFAULT_ADSID = 0L;
    public static final Integer DEFAULT_AUDIT_EVENT = 0;
    public static final Long DEFAULT_CLIENT_IP = 0L;
    public static final Long DEFAULT_ID = 0L;
    public static final f DEFAULT_NEW_DATA = f.f32736b;
    public static final f DEFAULT_OLD_DATA = f.f32736b;
    public static final String DEFAULT_OPERATOR = "";
    public static final Integer DEFAULT_PLACEMENT = 0;
    public static final Long DEFAULT_TIMESTAMP = 0L;
    public static final Integer DEFAULT_USERID = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 2, type = Message.Datatype.INT64)
    public final Long adsid;
    @ProtoField(tag = 9, type = Message.Datatype.INT32)
    public final Integer audit_event;
    @ProtoField(tag = 8, type = Message.Datatype.INT64)
    public final Long client_ip;
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long id;
    @ProtoField(tag = 5, type = Message.Datatype.BYTES)
    public final f new_data;
    @ProtoField(tag = 4, type = Message.Datatype.BYTES)
    public final f old_data;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String operator;
    @ProtoField(tag = 10, type = Message.Datatype.INT32)
    public final Integer placement;
    @ProtoField(tag = 6, type = Message.Datatype.INT64)
    public final Long timestamp;
    @ProtoField(tag = 7, type = Message.Datatype.INT32)
    public final Integer userid;

    public AdvertiseAuditLog(Long l, Long l2, String str, f fVar, f fVar2, Long l3, Integer num, Long l4, Integer num2, Integer num3) {
        this.id = l;
        this.adsid = l2;
        this.operator = str;
        this.old_data = fVar;
        this.new_data = fVar2;
        this.timestamp = l3;
        this.userid = num;
        this.client_ip = l4;
        this.audit_event = num2;
        this.placement = num3;
    }

    private AdvertiseAuditLog(Builder builder) {
        this(builder.id, builder.adsid, builder.operator, builder.old_data, builder.new_data, builder.timestamp, builder.userid, builder.client_ip, builder.audit_event, builder.placement);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AdvertiseAuditLog)) {
            return false;
        }
        AdvertiseAuditLog advertiseAuditLog = (AdvertiseAuditLog) obj;
        if (!equals((Object) this.id, (Object) advertiseAuditLog.id) || !equals((Object) this.adsid, (Object) advertiseAuditLog.adsid) || !equals((Object) this.operator, (Object) advertiseAuditLog.operator) || !equals((Object) this.old_data, (Object) advertiseAuditLog.old_data) || !equals((Object) this.new_data, (Object) advertiseAuditLog.new_data) || !equals((Object) this.timestamp, (Object) advertiseAuditLog.timestamp) || !equals((Object) this.userid, (Object) advertiseAuditLog.userid) || !equals((Object) this.client_ip, (Object) advertiseAuditLog.client_ip) || !equals((Object) this.audit_event, (Object) advertiseAuditLog.audit_event) || !equals((Object) this.placement, (Object) advertiseAuditLog.placement)) {
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
        String str = this.operator;
        int hashCode3 = (hashCode2 + (str != null ? str.hashCode() : 0)) * 37;
        f fVar = this.old_data;
        int hashCode4 = (hashCode3 + (fVar != null ? fVar.hashCode() : 0)) * 37;
        f fVar2 = this.new_data;
        int hashCode5 = (hashCode4 + (fVar2 != null ? fVar2.hashCode() : 0)) * 37;
        Long l3 = this.timestamp;
        int hashCode6 = (hashCode5 + (l3 != null ? l3.hashCode() : 0)) * 37;
        Integer num = this.userid;
        int hashCode7 = (hashCode6 + (num != null ? num.hashCode() : 0)) * 37;
        Long l4 = this.client_ip;
        int hashCode8 = (hashCode7 + (l4 != null ? l4.hashCode() : 0)) * 37;
        Integer num2 = this.audit_event;
        int hashCode9 = (hashCode8 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Integer num3 = this.placement;
        if (num3 != null) {
            i2 = num3.hashCode();
        }
        int i3 = hashCode9 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<AdvertiseAuditLog> {
        public Long adsid;
        public Integer audit_event;
        public Long client_ip;
        public Long id;
        public f new_data;
        public f old_data;
        public String operator;
        public Integer placement;
        public Long timestamp;
        public Integer userid;

        public Builder() {
        }

        public Builder(AdvertiseAuditLog advertiseAuditLog) {
            super(advertiseAuditLog);
            if (advertiseAuditLog != null) {
                this.id = advertiseAuditLog.id;
                this.adsid = advertiseAuditLog.adsid;
                this.operator = advertiseAuditLog.operator;
                this.old_data = advertiseAuditLog.old_data;
                this.new_data = advertiseAuditLog.new_data;
                this.timestamp = advertiseAuditLog.timestamp;
                this.userid = advertiseAuditLog.userid;
                this.client_ip = advertiseAuditLog.client_ip;
                this.audit_event = advertiseAuditLog.audit_event;
                this.placement = advertiseAuditLog.placement;
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

        public Builder operator(String str) {
            this.operator = str;
            return this;
        }

        public Builder old_data(f fVar) {
            this.old_data = fVar;
            return this;
        }

        public Builder new_data(f fVar) {
            this.new_data = fVar;
            return this;
        }

        public Builder timestamp(Long l) {
            this.timestamp = l;
            return this;
        }

        public Builder userid(Integer num) {
            this.userid = num;
            return this;
        }

        public Builder client_ip(Long l) {
            this.client_ip = l;
            return this;
        }

        public Builder audit_event(Integer num) {
            this.audit_event = num;
            return this;
        }

        public Builder placement(Integer num) {
            this.placement = num;
            return this;
        }

        public AdvertiseAuditLog build() {
            return new AdvertiseAuditLog(this);
        }
    }
}
