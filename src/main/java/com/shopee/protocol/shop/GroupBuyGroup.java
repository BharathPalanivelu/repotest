package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import e.f;

public final class GroupBuyGroup extends Message {
    public static final Long DEFAULT_CAMPAIGNID = 0L;
    public static final String DEFAULT_COUNTRY = "";
    public static final Integer DEFAULT_END_TIME = 0;
    public static final f DEFAULT_EXTINFO = f.f32736b;
    public static final Long DEFAULT_GROUPID = 0L;
    public static final String DEFAULT_GROUP_CODE = "";
    public static final Integer DEFAULT_GROUP_SIZE = 0;
    public static final Long DEFAULT_ITEMID = 0L;
    public static final Integer DEFAULT_PURCHASE_LIMIT = 0;
    public static final Integer DEFAULT_SHOPID = 0;
    public static final Integer DEFAULT_START_TIME = 0;
    public static final Integer DEFAULT_STATUS = 0;
    public static final Integer DEFAULT_USERID = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 2, type = Message.Datatype.INT64)
    public final Long campaignid;
    @ProtoField(tag = 12, type = Message.Datatype.STRING)
    public final String country;
    @ProtoField(tag = 10, type = Message.Datatype.INT32)
    public final Integer end_time;
    @ProtoField(tag = 13, type = Message.Datatype.BYTES)
    public final f extinfo;
    @ProtoField(tag = 11, type = Message.Datatype.STRING)
    public final String group_code;
    @ProtoField(tag = 6, type = Message.Datatype.INT32)
    public final Integer group_size;
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long groupid;
    @ProtoField(tag = 3, type = Message.Datatype.INT64)
    public final Long itemid;
    @ProtoField(tag = 5, type = Message.Datatype.INT32)
    public final Integer purchase_limit;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer shopid;
    @ProtoField(tag = 9, type = Message.Datatype.INT32)
    public final Integer start_time;
    @ProtoField(tag = 8, type = Message.Datatype.INT32)
    public final Integer status;
    @ProtoField(tag = 7, type = Message.Datatype.INT32)
    public final Integer userid;

    public GroupBuyGroup(Long l, Long l2, Long l3, Integer num, Integer num2, Integer num3, Integer num4, Integer num5, Integer num6, Integer num7, String str, String str2, f fVar) {
        this.groupid = l;
        this.campaignid = l2;
        this.itemid = l3;
        this.shopid = num;
        this.purchase_limit = num2;
        this.group_size = num3;
        this.userid = num4;
        this.status = num5;
        this.start_time = num6;
        this.end_time = num7;
        this.group_code = str;
        this.country = str2;
        this.extinfo = fVar;
    }

    private GroupBuyGroup(Builder builder) {
        this(builder.groupid, builder.campaignid, builder.itemid, builder.shopid, builder.purchase_limit, builder.group_size, builder.userid, builder.status, builder.start_time, builder.end_time, builder.group_code, builder.country, builder.extinfo);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof GroupBuyGroup)) {
            return false;
        }
        GroupBuyGroup groupBuyGroup = (GroupBuyGroup) obj;
        if (!equals((Object) this.groupid, (Object) groupBuyGroup.groupid) || !equals((Object) this.campaignid, (Object) groupBuyGroup.campaignid) || !equals((Object) this.itemid, (Object) groupBuyGroup.itemid) || !equals((Object) this.shopid, (Object) groupBuyGroup.shopid) || !equals((Object) this.purchase_limit, (Object) groupBuyGroup.purchase_limit) || !equals((Object) this.group_size, (Object) groupBuyGroup.group_size) || !equals((Object) this.userid, (Object) groupBuyGroup.userid) || !equals((Object) this.status, (Object) groupBuyGroup.status) || !equals((Object) this.start_time, (Object) groupBuyGroup.start_time) || !equals((Object) this.end_time, (Object) groupBuyGroup.end_time) || !equals((Object) this.group_code, (Object) groupBuyGroup.group_code) || !equals((Object) this.country, (Object) groupBuyGroup.country) || !equals((Object) this.extinfo, (Object) groupBuyGroup.extinfo)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Long l = this.groupid;
        int i2 = 0;
        int hashCode = (l != null ? l.hashCode() : 0) * 37;
        Long l2 = this.campaignid;
        int hashCode2 = (hashCode + (l2 != null ? l2.hashCode() : 0)) * 37;
        Long l3 = this.itemid;
        int hashCode3 = (hashCode2 + (l3 != null ? l3.hashCode() : 0)) * 37;
        Integer num = this.shopid;
        int hashCode4 = (hashCode3 + (num != null ? num.hashCode() : 0)) * 37;
        Integer num2 = this.purchase_limit;
        int hashCode5 = (hashCode4 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Integer num3 = this.group_size;
        int hashCode6 = (hashCode5 + (num3 != null ? num3.hashCode() : 0)) * 37;
        Integer num4 = this.userid;
        int hashCode7 = (hashCode6 + (num4 != null ? num4.hashCode() : 0)) * 37;
        Integer num5 = this.status;
        int hashCode8 = (hashCode7 + (num5 != null ? num5.hashCode() : 0)) * 37;
        Integer num6 = this.start_time;
        int hashCode9 = (hashCode8 + (num6 != null ? num6.hashCode() : 0)) * 37;
        Integer num7 = this.end_time;
        int hashCode10 = (hashCode9 + (num7 != null ? num7.hashCode() : 0)) * 37;
        String str = this.group_code;
        int hashCode11 = (hashCode10 + (str != null ? str.hashCode() : 0)) * 37;
        String str2 = this.country;
        int hashCode12 = (hashCode11 + (str2 != null ? str2.hashCode() : 0)) * 37;
        f fVar = this.extinfo;
        if (fVar != null) {
            i2 = fVar.hashCode();
        }
        int i3 = hashCode12 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<GroupBuyGroup> {
        public Long campaignid;
        public String country;
        public Integer end_time;
        public f extinfo;
        public String group_code;
        public Integer group_size;
        public Long groupid;
        public Long itemid;
        public Integer purchase_limit;
        public Integer shopid;
        public Integer start_time;
        public Integer status;
        public Integer userid;

        public Builder() {
        }

        public Builder(GroupBuyGroup groupBuyGroup) {
            super(groupBuyGroup);
            if (groupBuyGroup != null) {
                this.groupid = groupBuyGroup.groupid;
                this.campaignid = groupBuyGroup.campaignid;
                this.itemid = groupBuyGroup.itemid;
                this.shopid = groupBuyGroup.shopid;
                this.purchase_limit = groupBuyGroup.purchase_limit;
                this.group_size = groupBuyGroup.group_size;
                this.userid = groupBuyGroup.userid;
                this.status = groupBuyGroup.status;
                this.start_time = groupBuyGroup.start_time;
                this.end_time = groupBuyGroup.end_time;
                this.group_code = groupBuyGroup.group_code;
                this.country = groupBuyGroup.country;
                this.extinfo = groupBuyGroup.extinfo;
            }
        }

        public Builder groupid(Long l) {
            this.groupid = l;
            return this;
        }

        public Builder campaignid(Long l) {
            this.campaignid = l;
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

        public Builder purchase_limit(Integer num) {
            this.purchase_limit = num;
            return this;
        }

        public Builder group_size(Integer num) {
            this.group_size = num;
            return this;
        }

        public Builder userid(Integer num) {
            this.userid = num;
            return this;
        }

        public Builder status(Integer num) {
            this.status = num;
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

        public Builder group_code(String str) {
            this.group_code = str;
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

        public GroupBuyGroup build() {
            return new GroupBuyGroup(this);
        }
    }
}
