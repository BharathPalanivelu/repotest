package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import e.f;

public final class GroupBuyCampaign extends Message {
    public static final Long DEFAULT_CAMPAIGNID = 0L;
    public static final String DEFAULT_COUNTRY = "";
    public static final Integer DEFAULT_CTIME = 0;
    public static final Integer DEFAULT_END_TIME = 0;
    public static final f DEFAULT_EXTINFO = f.f32736b;
    public static final Integer DEFAULT_GROUP_DURATION = 0;
    public static final Integer DEFAULT_MTIME = 0;
    public static final Integer DEFAULT_PAYMENT_DURATION = 0;
    public static final Integer DEFAULT_START_TIME = 0;
    public static final Integer DEFAULT_UNPAID_GROUP_NUM = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long campaignid;
    @ProtoField(tag = 7, type = Message.Datatype.STRING)
    public final String country;
    @ProtoField(tag = 5, type = Message.Datatype.INT32)
    public final Integer ctime;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer end_time;
    @ProtoField(tag = 8, type = Message.Datatype.BYTES)
    public final f extinfo;
    @ProtoField(tag = 9, type = Message.Datatype.INT32)
    public final Integer group_duration;
    @ProtoField(tag = 6, type = Message.Datatype.INT32)
    public final Integer mtime;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer payment_duration;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer start_time;
    @ProtoField(tag = 10, type = Message.Datatype.INT32)
    public final Integer unpaid_group_num;

    public GroupBuyCampaign(Long l, Integer num, Integer num2, Integer num3, Integer num4, Integer num5, String str, f fVar, Integer num6, Integer num7) {
        this.campaignid = l;
        this.start_time = num;
        this.end_time = num2;
        this.payment_duration = num3;
        this.ctime = num4;
        this.mtime = num5;
        this.country = str;
        this.extinfo = fVar;
        this.group_duration = num6;
        this.unpaid_group_num = num7;
    }

    private GroupBuyCampaign(Builder builder) {
        this(builder.campaignid, builder.start_time, builder.end_time, builder.payment_duration, builder.ctime, builder.mtime, builder.country, builder.extinfo, builder.group_duration, builder.unpaid_group_num);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof GroupBuyCampaign)) {
            return false;
        }
        GroupBuyCampaign groupBuyCampaign = (GroupBuyCampaign) obj;
        if (!equals((Object) this.campaignid, (Object) groupBuyCampaign.campaignid) || !equals((Object) this.start_time, (Object) groupBuyCampaign.start_time) || !equals((Object) this.end_time, (Object) groupBuyCampaign.end_time) || !equals((Object) this.payment_duration, (Object) groupBuyCampaign.payment_duration) || !equals((Object) this.ctime, (Object) groupBuyCampaign.ctime) || !equals((Object) this.mtime, (Object) groupBuyCampaign.mtime) || !equals((Object) this.country, (Object) groupBuyCampaign.country) || !equals((Object) this.extinfo, (Object) groupBuyCampaign.extinfo) || !equals((Object) this.group_duration, (Object) groupBuyCampaign.group_duration) || !equals((Object) this.unpaid_group_num, (Object) groupBuyCampaign.unpaid_group_num)) {
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
        Integer num = this.start_time;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 37;
        Integer num2 = this.end_time;
        int hashCode3 = (hashCode2 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Integer num3 = this.payment_duration;
        int hashCode4 = (hashCode3 + (num3 != null ? num3.hashCode() : 0)) * 37;
        Integer num4 = this.ctime;
        int hashCode5 = (hashCode4 + (num4 != null ? num4.hashCode() : 0)) * 37;
        Integer num5 = this.mtime;
        int hashCode6 = (hashCode5 + (num5 != null ? num5.hashCode() : 0)) * 37;
        String str = this.country;
        int hashCode7 = (hashCode6 + (str != null ? str.hashCode() : 0)) * 37;
        f fVar = this.extinfo;
        int hashCode8 = (hashCode7 + (fVar != null ? fVar.hashCode() : 0)) * 37;
        Integer num6 = this.group_duration;
        int hashCode9 = (hashCode8 + (num6 != null ? num6.hashCode() : 0)) * 37;
        Integer num7 = this.unpaid_group_num;
        if (num7 != null) {
            i2 = num7.hashCode();
        }
        int i3 = hashCode9 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<GroupBuyCampaign> {
        public Long campaignid;
        public String country;
        public Integer ctime;
        public Integer end_time;
        public f extinfo;
        public Integer group_duration;
        public Integer mtime;
        public Integer payment_duration;
        public Integer start_time;
        public Integer unpaid_group_num;

        public Builder() {
        }

        public Builder(GroupBuyCampaign groupBuyCampaign) {
            super(groupBuyCampaign);
            if (groupBuyCampaign != null) {
                this.campaignid = groupBuyCampaign.campaignid;
                this.start_time = groupBuyCampaign.start_time;
                this.end_time = groupBuyCampaign.end_time;
                this.payment_duration = groupBuyCampaign.payment_duration;
                this.ctime = groupBuyCampaign.ctime;
                this.mtime = groupBuyCampaign.mtime;
                this.country = groupBuyCampaign.country;
                this.extinfo = groupBuyCampaign.extinfo;
                this.group_duration = groupBuyCampaign.group_duration;
                this.unpaid_group_num = groupBuyCampaign.unpaid_group_num;
            }
        }

        public Builder campaignid(Long l) {
            this.campaignid = l;
            return this;
        }

        public Builder start_time(Integer num) {
            this.start_time = num;
            return this;
        }

        public Builder end_time(Integer num) {
            this.end_time = num;
            return this;
        }

        public Builder payment_duration(Integer num) {
            this.payment_duration = num;
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

        public Builder extinfo(f fVar) {
            this.extinfo = fVar;
            return this;
        }

        public Builder group_duration(Integer num) {
            this.group_duration = num;
            return this;
        }

        public Builder unpaid_group_num(Integer num) {
            this.unpaid_group_num = num;
            return this;
        }

        public GroupBuyCampaign build() {
            return new GroupBuyCampaign(this);
        }
    }
}
