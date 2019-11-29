package com.shopee.protocol.ads.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import e.f;

public final class Campaign extends Message {
    public static final Long DEFAULT_CAMPAIGNID = 0L;
    public static final Long DEFAULT_CTIME = 0L;
    public static final Long DEFAULT_DAILY_QUOTA = 0L;
    public static final Long DEFAULT_END_TIME = 0L;
    public static final f DEFAULT_EXTINFO = f.f32736b;
    public static final Long DEFAULT_MTIME = 0L;
    public static final String DEFAULT_NAME = "";
    public static final String DEFAULT_REASON = "";
    public static final Integer DEFAULT_SHOPID = 0;
    public static final Long DEFAULT_START_TIME = 0L;
    public static final Integer DEFAULT_STATUS = 0;
    public static final Long DEFAULT_TOTAL_QUOTA = 0L;
    public static final Integer DEFAULT_USERID = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long campaignid;
    @ProtoField(tag = 11, type = Message.Datatype.INT64)
    public final Long ctime;
    @ProtoField(tag = 7, type = Message.Datatype.INT64)
    public final Long daily_quota;
    @ProtoField(tag = 6, type = Message.Datatype.INT64)
    public final Long end_time;
    @ProtoField(tag = 9, type = Message.Datatype.BYTES)
    public final f extinfo;
    @ProtoField(tag = 12, type = Message.Datatype.INT64)
    public final Long mtime;
    @ProtoField(tag = 8, type = Message.Datatype.STRING)
    public final String name;
    @ProtoField(tag = 10, type = Message.Datatype.STRING)
    public final String reason;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer shopid;
    @ProtoField(tag = 5, type = Message.Datatype.INT64)
    public final Long start_time;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer status;
    @ProtoField(tag = 13, type = Message.Datatype.INT64)
    public final Long total_quota;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer userid;

    public Campaign(Long l, Integer num, Integer num2, Integer num3, Long l2, Long l3, Long l4, String str, f fVar, String str2, Long l5, Long l6, Long l7) {
        this.campaignid = l;
        this.status = num;
        this.shopid = num2;
        this.userid = num3;
        this.start_time = l2;
        this.end_time = l3;
        this.daily_quota = l4;
        this.name = str;
        this.extinfo = fVar;
        this.reason = str2;
        this.ctime = l5;
        this.mtime = l6;
        this.total_quota = l7;
    }

    private Campaign(Builder builder) {
        this(builder.campaignid, builder.status, builder.shopid, builder.userid, builder.start_time, builder.end_time, builder.daily_quota, builder.name, builder.extinfo, builder.reason, builder.ctime, builder.mtime, builder.total_quota);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Campaign)) {
            return false;
        }
        Campaign campaign = (Campaign) obj;
        if (!equals((Object) this.campaignid, (Object) campaign.campaignid) || !equals((Object) this.status, (Object) campaign.status) || !equals((Object) this.shopid, (Object) campaign.shopid) || !equals((Object) this.userid, (Object) campaign.userid) || !equals((Object) this.start_time, (Object) campaign.start_time) || !equals((Object) this.end_time, (Object) campaign.end_time) || !equals((Object) this.daily_quota, (Object) campaign.daily_quota) || !equals((Object) this.name, (Object) campaign.name) || !equals((Object) this.extinfo, (Object) campaign.extinfo) || !equals((Object) this.reason, (Object) campaign.reason) || !equals((Object) this.ctime, (Object) campaign.ctime) || !equals((Object) this.mtime, (Object) campaign.mtime) || !equals((Object) this.total_quota, (Object) campaign.total_quota)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Long l = this.campaignid;
        int i2 = 0;
        int hashCode = (l != null ? l.hashCode() : 0) * 37;
        Integer num = this.status;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 37;
        Integer num2 = this.shopid;
        int hashCode3 = (hashCode2 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Integer num3 = this.userid;
        int hashCode4 = (hashCode3 + (num3 != null ? num3.hashCode() : 0)) * 37;
        Long l2 = this.start_time;
        int hashCode5 = (hashCode4 + (l2 != null ? l2.hashCode() : 0)) * 37;
        Long l3 = this.end_time;
        int hashCode6 = (hashCode5 + (l3 != null ? l3.hashCode() : 0)) * 37;
        Long l4 = this.daily_quota;
        int hashCode7 = (hashCode6 + (l4 != null ? l4.hashCode() : 0)) * 37;
        String str = this.name;
        int hashCode8 = (hashCode7 + (str != null ? str.hashCode() : 0)) * 37;
        f fVar = this.extinfo;
        int hashCode9 = (hashCode8 + (fVar != null ? fVar.hashCode() : 0)) * 37;
        String str2 = this.reason;
        int hashCode10 = (hashCode9 + (str2 != null ? str2.hashCode() : 0)) * 37;
        Long l5 = this.ctime;
        int hashCode11 = (hashCode10 + (l5 != null ? l5.hashCode() : 0)) * 37;
        Long l6 = this.mtime;
        int hashCode12 = (hashCode11 + (l6 != null ? l6.hashCode() : 0)) * 37;
        Long l7 = this.total_quota;
        if (l7 != null) {
            i2 = l7.hashCode();
        }
        int i3 = hashCode12 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<Campaign> {
        public Long campaignid;
        public Long ctime;
        public Long daily_quota;
        public Long end_time;
        public f extinfo;
        public Long mtime;
        public String name;
        public String reason;
        public Integer shopid;
        public Long start_time;
        public Integer status;
        public Long total_quota;
        public Integer userid;

        public Builder() {
        }

        public Builder(Campaign campaign) {
            super(campaign);
            if (campaign != null) {
                this.campaignid = campaign.campaignid;
                this.status = campaign.status;
                this.shopid = campaign.shopid;
                this.userid = campaign.userid;
                this.start_time = campaign.start_time;
                this.end_time = campaign.end_time;
                this.daily_quota = campaign.daily_quota;
                this.name = campaign.name;
                this.extinfo = campaign.extinfo;
                this.reason = campaign.reason;
                this.ctime = campaign.ctime;
                this.mtime = campaign.mtime;
                this.total_quota = campaign.total_quota;
            }
        }

        public Builder campaignid(Long l) {
            this.campaignid = l;
            return this;
        }

        public Builder status(Integer num) {
            this.status = num;
            return this;
        }

        public Builder shopid(Integer num) {
            this.shopid = num;
            return this;
        }

        public Builder userid(Integer num) {
            this.userid = num;
            return this;
        }

        public Builder start_time(Long l) {
            this.start_time = l;
            return this;
        }

        public Builder end_time(Long l) {
            this.end_time = l;
            return this;
        }

        public Builder daily_quota(Long l) {
            this.daily_quota = l;
            return this;
        }

        public Builder name(String str) {
            this.name = str;
            return this;
        }

        public Builder extinfo(f fVar) {
            this.extinfo = fVar;
            return this;
        }

        public Builder reason(String str) {
            this.reason = str;
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

        public Builder total_quota(Long l) {
            this.total_quota = l;
            return this;
        }

        public Campaign build() {
            return new Campaign(this);
        }
    }
}
