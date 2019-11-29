package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class ChangeEvent extends Message {
    public static final String DEFAULT_AFFECT_FIELD = "";
    public static final String DEFAULT_CLIENT_IP = "";
    public static final String DEFAULT_CLIENT_TYPE = "";
    public static final Integer DEFAULT_EVENT_TIME = 0;
    public static final Integer DEFAULT_FROM = 0;
    public static final Long DEFAULT_ID = 0L;
    public static final String DEFAULT_OLD_VALUE = "";
    public static final Integer DEFAULT_USERID = 0;
    public static final String DEFAULT_VALUE = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String affect_field;
    @ProtoField(tag = 8, type = Message.Datatype.STRING)
    public final String client_ip;
    @ProtoField(tag = 9, type = Message.Datatype.STRING)
    public final String client_type;
    @ProtoField(tag = 6, type = Message.Datatype.INT32)
    public final Integer event_time;
    @ProtoField(tag = 7, type = Message.Datatype.INT32)
    public final Integer from;
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long id;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String old_value;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer userid;
    @ProtoField(tag = 5, type = Message.Datatype.STRING)
    public final String value;

    public ChangeEvent(Long l, Integer num, String str, String str2, String str3, Integer num2, Integer num3, String str4, String str5) {
        this.id = l;
        this.userid = num;
        this.affect_field = str;
        this.old_value = str2;
        this.value = str3;
        this.event_time = num2;
        this.from = num3;
        this.client_ip = str4;
        this.client_type = str5;
    }

    private ChangeEvent(Builder builder) {
        this(builder.id, builder.userid, builder.affect_field, builder.old_value, builder.value, builder.event_time, builder.from, builder.client_ip, builder.client_type);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ChangeEvent)) {
            return false;
        }
        ChangeEvent changeEvent = (ChangeEvent) obj;
        if (!equals((Object) this.id, (Object) changeEvent.id) || !equals((Object) this.userid, (Object) changeEvent.userid) || !equals((Object) this.affect_field, (Object) changeEvent.affect_field) || !equals((Object) this.old_value, (Object) changeEvent.old_value) || !equals((Object) this.value, (Object) changeEvent.value) || !equals((Object) this.event_time, (Object) changeEvent.event_time) || !equals((Object) this.from, (Object) changeEvent.from) || !equals((Object) this.client_ip, (Object) changeEvent.client_ip) || !equals((Object) this.client_type, (Object) changeEvent.client_type)) {
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
        Integer num = this.userid;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 37;
        String str = this.affect_field;
        int hashCode3 = (hashCode2 + (str != null ? str.hashCode() : 0)) * 37;
        String str2 = this.old_value;
        int hashCode4 = (hashCode3 + (str2 != null ? str2.hashCode() : 0)) * 37;
        String str3 = this.value;
        int hashCode5 = (hashCode4 + (str3 != null ? str3.hashCode() : 0)) * 37;
        Integer num2 = this.event_time;
        int hashCode6 = (hashCode5 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Integer num3 = this.from;
        int hashCode7 = (hashCode6 + (num3 != null ? num3.hashCode() : 0)) * 37;
        String str4 = this.client_ip;
        int hashCode8 = (hashCode7 + (str4 != null ? str4.hashCode() : 0)) * 37;
        String str5 = this.client_type;
        if (str5 != null) {
            i2 = str5.hashCode();
        }
        int i3 = hashCode8 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<ChangeEvent> {
        public String affect_field;
        public String client_ip;
        public String client_type;
        public Integer event_time;
        public Integer from;
        public Long id;
        public String old_value;
        public Integer userid;
        public String value;

        public Builder() {
        }

        public Builder(ChangeEvent changeEvent) {
            super(changeEvent);
            if (changeEvent != null) {
                this.id = changeEvent.id;
                this.userid = changeEvent.userid;
                this.affect_field = changeEvent.affect_field;
                this.old_value = changeEvent.old_value;
                this.value = changeEvent.value;
                this.event_time = changeEvent.event_time;
                this.from = changeEvent.from;
                this.client_ip = changeEvent.client_ip;
                this.client_type = changeEvent.client_type;
            }
        }

        public Builder id(Long l) {
            this.id = l;
            return this;
        }

        public Builder userid(Integer num) {
            this.userid = num;
            return this;
        }

        public Builder affect_field(String str) {
            this.affect_field = str;
            return this;
        }

        public Builder old_value(String str) {
            this.old_value = str;
            return this;
        }

        public Builder value(String str) {
            this.value = str;
            return this;
        }

        public Builder event_time(Integer num) {
            this.event_time = num;
            return this;
        }

        public Builder from(Integer num) {
            this.from = num;
            return this;
        }

        public Builder client_ip(String str) {
            this.client_ip = str;
            return this;
        }

        public Builder client_type(String str) {
            this.client_type = str;
            return this;
        }

        public ChangeEvent build() {
            return new ChangeEvent(this);
        }
    }
}
