package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import e.f;

public final class GroupBuyFraudRecord extends Message {
    public static final String DEFAULT_COUNTRY = "";
    public static final Integer DEFAULT_CTIME = 0;
    public static final f DEFAULT_EXTINFO = f.f32736b;
    public static final Long DEFAULT_GROUPID = 0L;
    public static final Long DEFAULT_ID = 0L;
    public static final Integer DEFAULT_MTIME = 0;
    public static final Integer DEFAULT_USERID = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 6, type = Message.Datatype.STRING)
    public final String country;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer ctime;
    @ProtoField(tag = 7, type = Message.Datatype.BYTES)
    public final f extinfo;
    @ProtoField(tag = 2, type = Message.Datatype.INT64)
    public final Long groupid;
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long id;
    @ProtoField(tag = 5, type = Message.Datatype.INT32)
    public final Integer mtime;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer userid;

    public GroupBuyFraudRecord(Long l, Long l2, Integer num, Integer num2, Integer num3, String str, f fVar) {
        this.id = l;
        this.groupid = l2;
        this.userid = num;
        this.ctime = num2;
        this.mtime = num3;
        this.country = str;
        this.extinfo = fVar;
    }

    private GroupBuyFraudRecord(Builder builder) {
        this(builder.id, builder.groupid, builder.userid, builder.ctime, builder.mtime, builder.country, builder.extinfo);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof GroupBuyFraudRecord)) {
            return false;
        }
        GroupBuyFraudRecord groupBuyFraudRecord = (GroupBuyFraudRecord) obj;
        if (!equals((Object) this.id, (Object) groupBuyFraudRecord.id) || !equals((Object) this.groupid, (Object) groupBuyFraudRecord.groupid) || !equals((Object) this.userid, (Object) groupBuyFraudRecord.userid) || !equals((Object) this.ctime, (Object) groupBuyFraudRecord.ctime) || !equals((Object) this.mtime, (Object) groupBuyFraudRecord.mtime) || !equals((Object) this.country, (Object) groupBuyFraudRecord.country) || !equals((Object) this.extinfo, (Object) groupBuyFraudRecord.extinfo)) {
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
        Long l2 = this.groupid;
        int hashCode2 = (hashCode + (l2 != null ? l2.hashCode() : 0)) * 37;
        Integer num = this.userid;
        int hashCode3 = (hashCode2 + (num != null ? num.hashCode() : 0)) * 37;
        Integer num2 = this.ctime;
        int hashCode4 = (hashCode3 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Integer num3 = this.mtime;
        int hashCode5 = (hashCode4 + (num3 != null ? num3.hashCode() : 0)) * 37;
        String str = this.country;
        int hashCode6 = (hashCode5 + (str != null ? str.hashCode() : 0)) * 37;
        f fVar = this.extinfo;
        if (fVar != null) {
            i2 = fVar.hashCode();
        }
        int i3 = hashCode6 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<GroupBuyFraudRecord> {
        public String country;
        public Integer ctime;
        public f extinfo;
        public Long groupid;
        public Long id;
        public Integer mtime;
        public Integer userid;

        public Builder() {
        }

        public Builder(GroupBuyFraudRecord groupBuyFraudRecord) {
            super(groupBuyFraudRecord);
            if (groupBuyFraudRecord != null) {
                this.id = groupBuyFraudRecord.id;
                this.groupid = groupBuyFraudRecord.groupid;
                this.userid = groupBuyFraudRecord.userid;
                this.ctime = groupBuyFraudRecord.ctime;
                this.mtime = groupBuyFraudRecord.mtime;
                this.country = groupBuyFraudRecord.country;
                this.extinfo = groupBuyFraudRecord.extinfo;
            }
        }

        public Builder id(Long l) {
            this.id = l;
            return this;
        }

        public Builder groupid(Long l) {
            this.groupid = l;
            return this;
        }

        public Builder userid(Integer num) {
            this.userid = num;
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

        public GroupBuyFraudRecord build() {
            return new GroupBuyFraudRecord(this);
        }
    }
}
