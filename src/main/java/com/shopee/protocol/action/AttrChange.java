package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class AttrChange extends Message {
    public static final Integer DEFAULT_ATTR_ID = 0;
    public static final Integer DEFAULT_MODEL_ID = 0;
    public static final String DEFAULT_NEW_VALUE = "";
    public static final Integer DEFAULT_OLD_MODEL_ID = 0;
    public static final Integer DEFAULT_OP = 0;
    public static final String DEFAULT_VALUE = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer attr_id;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer model_id;
    @ProtoField(tag = 6, type = Message.Datatype.STRING)
    public final String new_value;
    @ProtoField(tag = 5, type = Message.Datatype.INT32)
    public final Integer old_model_id;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer op;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String value;

    public AttrChange(Integer num, Integer num2, Integer num3, String str, Integer num4, String str2) {
        this.op = num;
        this.model_id = num2;
        this.attr_id = num3;
        this.value = str;
        this.old_model_id = num4;
        this.new_value = str2;
    }

    private AttrChange(Builder builder) {
        this(builder.op, builder.model_id, builder.attr_id, builder.value, builder.old_model_id, builder.new_value);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AttrChange)) {
            return false;
        }
        AttrChange attrChange = (AttrChange) obj;
        if (!equals((Object) this.op, (Object) attrChange.op) || !equals((Object) this.model_id, (Object) attrChange.model_id) || !equals((Object) this.attr_id, (Object) attrChange.attr_id) || !equals((Object) this.value, (Object) attrChange.value) || !equals((Object) this.old_model_id, (Object) attrChange.old_model_id) || !equals((Object) this.new_value, (Object) attrChange.new_value)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Integer num = this.op;
        int i2 = 0;
        int hashCode = (num != null ? num.hashCode() : 0) * 37;
        Integer num2 = this.model_id;
        int hashCode2 = (hashCode + (num2 != null ? num2.hashCode() : 0)) * 37;
        Integer num3 = this.attr_id;
        int hashCode3 = (hashCode2 + (num3 != null ? num3.hashCode() : 0)) * 37;
        String str = this.value;
        int hashCode4 = (hashCode3 + (str != null ? str.hashCode() : 0)) * 37;
        Integer num4 = this.old_model_id;
        int hashCode5 = (hashCode4 + (num4 != null ? num4.hashCode() : 0)) * 37;
        String str2 = this.new_value;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        int i3 = hashCode5 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<AttrChange> {
        public Integer attr_id;
        public Integer model_id;
        public String new_value;
        public Integer old_model_id;
        public Integer op;
        public String value;

        public Builder() {
        }

        public Builder(AttrChange attrChange) {
            super(attrChange);
            if (attrChange != null) {
                this.op = attrChange.op;
                this.model_id = attrChange.model_id;
                this.attr_id = attrChange.attr_id;
                this.value = attrChange.value;
                this.old_model_id = attrChange.old_model_id;
                this.new_value = attrChange.new_value;
            }
        }

        public Builder op(Integer num) {
            this.op = num;
            return this;
        }

        public Builder model_id(Integer num) {
            this.model_id = num;
            return this;
        }

        public Builder attr_id(Integer num) {
            this.attr_id = num;
            return this;
        }

        public Builder value(String str) {
            this.value = str;
            return this;
        }

        public Builder old_model_id(Integer num) {
            this.old_model_id = num;
            return this;
        }

        public Builder new_value(String str) {
            this.new_value = str;
            return this;
        }

        public AttrChange build() {
            return new AttrChange(this);
        }
    }
}
