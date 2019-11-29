package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import e.f;

public final class SlashPriceReject extends Message {
    public static final Long DEFAULT_ACTIVITY_ID = 0L;
    public static final Integer DEFAULT_ACTIVITY_START_TIME = 0;
    public static final Integer DEFAULT_CTIME = 0;
    public static final f DEFAULT_EXTINFO = f.f32736b;
    public static final Integer DEFAULT_ID = 0;
    public static final String DEFAULT_RECEIVER_PHONE = "";
    public static final Integer DEFAULT_RECEIVER_USER_ID = 0;
    public static final Integer DEFAULT_SENDER_USER_ID = 0;
    public static final Integer DEFAULT_SLASH_START_TIME = 0;
    public static final Integer DEFAULT_TYPE = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 2, type = Message.Datatype.INT64)
    public final Long activity_id;
    @ProtoField(tag = 6, type = Message.Datatype.INT32)
    public final Integer activity_start_time;
    @ProtoField(tag = 10, type = Message.Datatype.INT32)
    public final Integer ctime;
    @ProtoField(tag = 9, type = Message.Datatype.BYTES)
    public final f extinfo;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer id;
    @ProtoField(tag = 5, type = Message.Datatype.STRING)
    public final String receiver_phone;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer receiver_user_id;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer sender_user_id;
    @ProtoField(tag = 7, type = Message.Datatype.INT32)
    public final Integer slash_start_time;
    @ProtoField(tag = 8, type = Message.Datatype.INT32)
    public final Integer type;

    public SlashPriceReject(Integer num, Long l, Integer num2, Integer num3, String str, Integer num4, Integer num5, Integer num6, f fVar, Integer num7) {
        this.id = num;
        this.activity_id = l;
        this.sender_user_id = num2;
        this.receiver_user_id = num3;
        this.receiver_phone = str;
        this.activity_start_time = num4;
        this.slash_start_time = num5;
        this.type = num6;
        this.extinfo = fVar;
        this.ctime = num7;
    }

    private SlashPriceReject(Builder builder) {
        this(builder.id, builder.activity_id, builder.sender_user_id, builder.receiver_user_id, builder.receiver_phone, builder.activity_start_time, builder.slash_start_time, builder.type, builder.extinfo, builder.ctime);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SlashPriceReject)) {
            return false;
        }
        SlashPriceReject slashPriceReject = (SlashPriceReject) obj;
        if (!equals((Object) this.id, (Object) slashPriceReject.id) || !equals((Object) this.activity_id, (Object) slashPriceReject.activity_id) || !equals((Object) this.sender_user_id, (Object) slashPriceReject.sender_user_id) || !equals((Object) this.receiver_user_id, (Object) slashPriceReject.receiver_user_id) || !equals((Object) this.receiver_phone, (Object) slashPriceReject.receiver_phone) || !equals((Object) this.activity_start_time, (Object) slashPriceReject.activity_start_time) || !equals((Object) this.slash_start_time, (Object) slashPriceReject.slash_start_time) || !equals((Object) this.type, (Object) slashPriceReject.type) || !equals((Object) this.extinfo, (Object) slashPriceReject.extinfo) || !equals((Object) this.ctime, (Object) slashPriceReject.ctime)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Integer num = this.id;
        int i2 = 0;
        int hashCode = (num != null ? num.hashCode() : 0) * 37;
        Long l = this.activity_id;
        int hashCode2 = (hashCode + (l != null ? l.hashCode() : 0)) * 37;
        Integer num2 = this.sender_user_id;
        int hashCode3 = (hashCode2 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Integer num3 = this.receiver_user_id;
        int hashCode4 = (hashCode3 + (num3 != null ? num3.hashCode() : 0)) * 37;
        String str = this.receiver_phone;
        int hashCode5 = (hashCode4 + (str != null ? str.hashCode() : 0)) * 37;
        Integer num4 = this.activity_start_time;
        int hashCode6 = (hashCode5 + (num4 != null ? num4.hashCode() : 0)) * 37;
        Integer num5 = this.slash_start_time;
        int hashCode7 = (hashCode6 + (num5 != null ? num5.hashCode() : 0)) * 37;
        Integer num6 = this.type;
        int hashCode8 = (hashCode7 + (num6 != null ? num6.hashCode() : 0)) * 37;
        f fVar = this.extinfo;
        int hashCode9 = (hashCode8 + (fVar != null ? fVar.hashCode() : 0)) * 37;
        Integer num7 = this.ctime;
        if (num7 != null) {
            i2 = num7.hashCode();
        }
        int i3 = hashCode9 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<SlashPriceReject> {
        public Long activity_id;
        public Integer activity_start_time;
        public Integer ctime;
        public f extinfo;
        public Integer id;
        public String receiver_phone;
        public Integer receiver_user_id;
        public Integer sender_user_id;
        public Integer slash_start_time;
        public Integer type;

        public Builder() {
        }

        public Builder(SlashPriceReject slashPriceReject) {
            super(slashPriceReject);
            if (slashPriceReject != null) {
                this.id = slashPriceReject.id;
                this.activity_id = slashPriceReject.activity_id;
                this.sender_user_id = slashPriceReject.sender_user_id;
                this.receiver_user_id = slashPriceReject.receiver_user_id;
                this.receiver_phone = slashPriceReject.receiver_phone;
                this.activity_start_time = slashPriceReject.activity_start_time;
                this.slash_start_time = slashPriceReject.slash_start_time;
                this.type = slashPriceReject.type;
                this.extinfo = slashPriceReject.extinfo;
                this.ctime = slashPriceReject.ctime;
            }
        }

        public Builder id(Integer num) {
            this.id = num;
            return this;
        }

        public Builder activity_id(Long l) {
            this.activity_id = l;
            return this;
        }

        public Builder sender_user_id(Integer num) {
            this.sender_user_id = num;
            return this;
        }

        public Builder receiver_user_id(Integer num) {
            this.receiver_user_id = num;
            return this;
        }

        public Builder receiver_phone(String str) {
            this.receiver_phone = str;
            return this;
        }

        public Builder activity_start_time(Integer num) {
            this.activity_start_time = num;
            return this;
        }

        public Builder slash_start_time(Integer num) {
            this.slash_start_time = num;
            return this;
        }

        public Builder type(Integer num) {
            this.type = num;
            return this;
        }

        public Builder extinfo(f fVar) {
            this.extinfo = fVar;
            return this;
        }

        public Builder ctime(Integer num) {
            this.ctime = num;
            return this;
        }

        public SlashPriceReject build() {
            return new SlashPriceReject(this);
        }
    }
}
