package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class TaskEvent extends Message {
    public static final String DEFAULT_COUNTRY = "";
    public static final String DEFAULT_FIELDNAME = "";
    public static final Integer DEFAULT_REGISTERTIME = 0;
    public static final Integer DEFAULT_TYPE = 0;
    public static final Integer DEFAULT_USERID = 0;
    public static final Integer DEFAULT_VALUE = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 5, type = Message.Datatype.STRING)
    public final String country;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String fieldname;
    @ProtoField(tag = 6, type = Message.Datatype.INT32)
    public final Integer registertime;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer type;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer userid;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer value;

    public TaskEvent(Integer num, Integer num2, String str, Integer num3, String str2, Integer num4) {
        this.type = num;
        this.userid = num2;
        this.fieldname = str;
        this.value = num3;
        this.country = str2;
        this.registertime = num4;
    }

    private TaskEvent(Builder builder) {
        this(builder.type, builder.userid, builder.fieldname, builder.value, builder.country, builder.registertime);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof TaskEvent)) {
            return false;
        }
        TaskEvent taskEvent = (TaskEvent) obj;
        if (!equals((Object) this.type, (Object) taskEvent.type) || !equals((Object) this.userid, (Object) taskEvent.userid) || !equals((Object) this.fieldname, (Object) taskEvent.fieldname) || !equals((Object) this.value, (Object) taskEvent.value) || !equals((Object) this.country, (Object) taskEvent.country) || !equals((Object) this.registertime, (Object) taskEvent.registertime)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Integer num = this.type;
        int i2 = 0;
        int hashCode = (num != null ? num.hashCode() : 0) * 37;
        Integer num2 = this.userid;
        int hashCode2 = (hashCode + (num2 != null ? num2.hashCode() : 0)) * 37;
        String str = this.fieldname;
        int hashCode3 = (hashCode2 + (str != null ? str.hashCode() : 0)) * 37;
        Integer num3 = this.value;
        int hashCode4 = (hashCode3 + (num3 != null ? num3.hashCode() : 0)) * 37;
        String str2 = this.country;
        int hashCode5 = (hashCode4 + (str2 != null ? str2.hashCode() : 0)) * 37;
        Integer num4 = this.registertime;
        if (num4 != null) {
            i2 = num4.hashCode();
        }
        int i3 = hashCode5 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<TaskEvent> {
        public String country;
        public String fieldname;
        public Integer registertime;
        public Integer type;
        public Integer userid;
        public Integer value;

        public Builder() {
        }

        public Builder(TaskEvent taskEvent) {
            super(taskEvent);
            if (taskEvent != null) {
                this.type = taskEvent.type;
                this.userid = taskEvent.userid;
                this.fieldname = taskEvent.fieldname;
                this.value = taskEvent.value;
                this.country = taskEvent.country;
                this.registertime = taskEvent.registertime;
            }
        }

        public Builder type(Integer num) {
            this.type = num;
            return this;
        }

        public Builder userid(Integer num) {
            this.userid = num;
            return this;
        }

        public Builder fieldname(String str) {
            this.fieldname = str;
            return this;
        }

        public Builder value(Integer num) {
            this.value = num;
            return this;
        }

        public Builder country(String str) {
            this.country = str;
            return this;
        }

        public Builder registertime(Integer num) {
            this.registertime = num;
            return this;
        }

        public TaskEvent build() {
            return new TaskEvent(this);
        }
    }
}
