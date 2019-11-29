package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class RecUserBoost extends Message {
    public static final Double DEFAULT_BOOST_VALUE = Double.valueOf(0.0d);
    public static final String DEFAULT_COUNTRY = "";
    public static final Integer DEFAULT_ID = 0;
    public static final Integer DEFAULT_USERID = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 3, type = Message.Datatype.DOUBLE)
    public final Double boost_value;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String country;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer id;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer userid;

    public RecUserBoost(Integer num, Integer num2, Double d2, String str) {
        this.id = num;
        this.userid = num2;
        this.boost_value = d2;
        this.country = str;
    }

    private RecUserBoost(Builder builder) {
        this(builder.id, builder.userid, builder.boost_value, builder.country);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof RecUserBoost)) {
            return false;
        }
        RecUserBoost recUserBoost = (RecUserBoost) obj;
        if (!equals((Object) this.id, (Object) recUserBoost.id) || !equals((Object) this.userid, (Object) recUserBoost.userid) || !equals((Object) this.boost_value, (Object) recUserBoost.boost_value) || !equals((Object) this.country, (Object) recUserBoost.country)) {
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
        Integer num2 = this.userid;
        int hashCode2 = (hashCode + (num2 != null ? num2.hashCode() : 0)) * 37;
        Double d2 = this.boost_value;
        int hashCode3 = (hashCode2 + (d2 != null ? d2.hashCode() : 0)) * 37;
        String str = this.country;
        if (str != null) {
            i2 = str.hashCode();
        }
        int i3 = hashCode3 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<RecUserBoost> {
        public Double boost_value;
        public String country;
        public Integer id;
        public Integer userid;

        public Builder() {
        }

        public Builder(RecUserBoost recUserBoost) {
            super(recUserBoost);
            if (recUserBoost != null) {
                this.id = recUserBoost.id;
                this.userid = recUserBoost.userid;
                this.boost_value = recUserBoost.boost_value;
                this.country = recUserBoost.country;
            }
        }

        public Builder id(Integer num) {
            this.id = num;
            return this;
        }

        public Builder userid(Integer num) {
            this.userid = num;
            return this;
        }

        public Builder boost_value(Double d2) {
            this.boost_value = d2;
            return this;
        }

        public Builder country(String str) {
            this.country = str;
            return this;
        }

        public RecUserBoost build() {
            return new RecUserBoost(this);
        }
    }
}
