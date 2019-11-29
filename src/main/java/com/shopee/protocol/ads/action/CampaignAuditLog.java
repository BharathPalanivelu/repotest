package com.shopee.protocol.ads.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import e.f;

public final class CampaignAuditLog extends Message {
    public static final Long DEFAULT_CAMPAIGNID = 0L;
    public static final Long DEFAULT_CLIENT_IP = 0L;
    public static final Long DEFAULT_ID = 0L;
    public static final f DEFAULT_NEW_DATA = f.f32736b;
    public static final f DEFAULT_OLD_DATA = f.f32736b;
    public static final String DEFAULT_OPERATOR = "";
    public static final Long DEFAULT_TIMESTAMP = 0L;
    public static final Integer DEFAULT_USERID = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 2, type = Message.Datatype.INT64)
    public final Long campaignid;
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
    @ProtoField(tag = 6, type = Message.Datatype.INT64)
    public final Long timestamp;
    @ProtoField(tag = 7, type = Message.Datatype.INT32)
    public final Integer userid;

    public CampaignAuditLog(Long l, Long l2, String str, f fVar, f fVar2, Long l3, Integer num, Long l4) {
        this.id = l;
        this.campaignid = l2;
        this.operator = str;
        this.old_data = fVar;
        this.new_data = fVar2;
        this.timestamp = l3;
        this.userid = num;
        this.client_ip = l4;
    }

    private CampaignAuditLog(Builder builder) {
        this(builder.id, builder.campaignid, builder.operator, builder.old_data, builder.new_data, builder.timestamp, builder.userid, builder.client_ip);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CampaignAuditLog)) {
            return false;
        }
        CampaignAuditLog campaignAuditLog = (CampaignAuditLog) obj;
        if (!equals((Object) this.id, (Object) campaignAuditLog.id) || !equals((Object) this.campaignid, (Object) campaignAuditLog.campaignid) || !equals((Object) this.operator, (Object) campaignAuditLog.operator) || !equals((Object) this.old_data, (Object) campaignAuditLog.old_data) || !equals((Object) this.new_data, (Object) campaignAuditLog.new_data) || !equals((Object) this.timestamp, (Object) campaignAuditLog.timestamp) || !equals((Object) this.userid, (Object) campaignAuditLog.userid) || !equals((Object) this.client_ip, (Object) campaignAuditLog.client_ip)) {
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
        Long l2 = this.campaignid;
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
        if (l4 != null) {
            i2 = l4.hashCode();
        }
        int i3 = hashCode7 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<CampaignAuditLog> {
        public Long campaignid;
        public Long client_ip;
        public Long id;
        public f new_data;
        public f old_data;
        public String operator;
        public Long timestamp;
        public Integer userid;

        public Builder() {
        }

        public Builder(CampaignAuditLog campaignAuditLog) {
            super(campaignAuditLog);
            if (campaignAuditLog != null) {
                this.id = campaignAuditLog.id;
                this.campaignid = campaignAuditLog.campaignid;
                this.operator = campaignAuditLog.operator;
                this.old_data = campaignAuditLog.old_data;
                this.new_data = campaignAuditLog.new_data;
                this.timestamp = campaignAuditLog.timestamp;
                this.userid = campaignAuditLog.userid;
                this.client_ip = campaignAuditLog.client_ip;
            }
        }

        public Builder id(Long l) {
            this.id = l;
            return this;
        }

        public Builder campaignid(Long l) {
            this.campaignid = l;
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

        public CampaignAuditLog build() {
            return new CampaignAuditLog(this);
        }
    }
}
