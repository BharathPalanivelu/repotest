package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class Vcode extends Message {
    public static final Integer DEFAULT_COUNT = 0;
    public static final Integer DEFAULT_ID = 0;
    public static final Integer DEFAULT_MTIME = 0;
    public static final String DEFAULT_PHONE = "";
    public static final Integer DEFAULT_USERID = 0;
    public static final String DEFAULT_VCODE = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 6, type = Message.Datatype.INT32)
    public final Integer count;
    @ProtoField(tag = 7, type = Message.Datatype.INT32)
    public final Integer id;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer mtime;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String phone;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer userid;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String vcode;

    public Vcode(String str, Integer num, String str2, Integer num2, Integer num3, Integer num4) {
        this.phone = str;
        this.userid = num;
        this.vcode = str2;
        this.mtime = num2;
        this.count = num3;
        this.id = num4;
    }

    private Vcode(Builder builder) {
        this(builder.phone, builder.userid, builder.vcode, builder.mtime, builder.count, builder.id);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Vcode)) {
            return false;
        }
        Vcode vcode2 = (Vcode) obj;
        if (!equals((Object) this.phone, (Object) vcode2.phone) || !equals((Object) this.userid, (Object) vcode2.userid) || !equals((Object) this.vcode, (Object) vcode2.vcode) || !equals((Object) this.mtime, (Object) vcode2.mtime) || !equals((Object) this.count, (Object) vcode2.count) || !equals((Object) this.id, (Object) vcode2.id)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        String str = this.phone;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 37;
        Integer num = this.userid;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 37;
        String str2 = this.vcode;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 37;
        Integer num2 = this.mtime;
        int hashCode4 = (hashCode3 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Integer num3 = this.count;
        int hashCode5 = (hashCode4 + (num3 != null ? num3.hashCode() : 0)) * 37;
        Integer num4 = this.id;
        if (num4 != null) {
            i2 = num4.hashCode();
        }
        int i3 = hashCode5 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<Vcode> {
        public Integer count;
        public Integer id;
        public Integer mtime;
        public String phone;
        public Integer userid;
        public String vcode;

        public Builder() {
        }

        public Builder(Vcode vcode2) {
            super(vcode2);
            if (vcode2 != null) {
                this.phone = vcode2.phone;
                this.userid = vcode2.userid;
                this.vcode = vcode2.vcode;
                this.mtime = vcode2.mtime;
                this.count = vcode2.count;
                this.id = vcode2.id;
            }
        }

        public Builder phone(String str) {
            this.phone = str;
            return this;
        }

        public Builder userid(Integer num) {
            this.userid = num;
            return this;
        }

        public Builder vcode(String str) {
            this.vcode = str;
            return this;
        }

        public Builder mtime(Integer num) {
            this.mtime = num;
            return this;
        }

        public Builder count(Integer num) {
            this.count = num;
            return this;
        }

        public Builder id(Integer num) {
            this.id = num;
            return this;
        }

        public Vcode build() {
            return new Vcode(this);
        }
    }
}
