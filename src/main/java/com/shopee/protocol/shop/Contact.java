package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import e.f;

public final class Contact extends Message {
    public static final String DEFAULT_ACCOUNT = "";
    public static final Integer DEFAULT_ACCTYPE = 0;
    public static final Integer DEFAULT_ACC_SHOPID = 0;
    public static final Integer DEFAULT_ACC_USERID = 0;
    public static final f DEFAULT_DEVICEID = f.f32736b;
    public static final String DEFAULT_NAME = "";
    public static final Integer DEFAULT_STATUS = 0;
    public static final Integer DEFAULT_USERID = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 5, type = Message.Datatype.INT32)
    public final Integer acc_shopid;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer acc_userid;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String account;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer acctype;
    @ProtoField(tag = 8, type = Message.Datatype.BYTES)
    public final f deviceid;
    @ProtoField(tag = 7, type = Message.Datatype.STRING)
    public final String name;
    @ProtoField(tag = 6, type = Message.Datatype.INT32)
    public final Integer status;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer userid;

    public Contact(Integer num, String str, Integer num2, Integer num3, Integer num4, Integer num5, String str2, f fVar) {
        this.userid = num;
        this.account = str;
        this.acctype = num2;
        this.acc_userid = num3;
        this.acc_shopid = num4;
        this.status = num5;
        this.name = str2;
        this.deviceid = fVar;
    }

    private Contact(Builder builder) {
        this(builder.userid, builder.account, builder.acctype, builder.acc_userid, builder.acc_shopid, builder.status, builder.name, builder.deviceid);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Contact)) {
            return false;
        }
        Contact contact = (Contact) obj;
        if (!equals((Object) this.userid, (Object) contact.userid) || !equals((Object) this.account, (Object) contact.account) || !equals((Object) this.acctype, (Object) contact.acctype) || !equals((Object) this.acc_userid, (Object) contact.acc_userid) || !equals((Object) this.acc_shopid, (Object) contact.acc_shopid) || !equals((Object) this.status, (Object) contact.status) || !equals((Object) this.name, (Object) contact.name) || !equals((Object) this.deviceid, (Object) contact.deviceid)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Integer num = this.userid;
        int i2 = 0;
        int hashCode = (num != null ? num.hashCode() : 0) * 37;
        String str = this.account;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 37;
        Integer num2 = this.acctype;
        int hashCode3 = (hashCode2 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Integer num3 = this.acc_userid;
        int hashCode4 = (hashCode3 + (num3 != null ? num3.hashCode() : 0)) * 37;
        Integer num4 = this.acc_shopid;
        int hashCode5 = (hashCode4 + (num4 != null ? num4.hashCode() : 0)) * 37;
        Integer num5 = this.status;
        int hashCode6 = (hashCode5 + (num5 != null ? num5.hashCode() : 0)) * 37;
        String str2 = this.name;
        int hashCode7 = (hashCode6 + (str2 != null ? str2.hashCode() : 0)) * 37;
        f fVar = this.deviceid;
        if (fVar != null) {
            i2 = fVar.hashCode();
        }
        int i3 = hashCode7 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<Contact> {
        public Integer acc_shopid;
        public Integer acc_userid;
        public String account;
        public Integer acctype;
        public f deviceid;
        public String name;
        public Integer status;
        public Integer userid;

        public Builder() {
        }

        public Builder(Contact contact) {
            super(contact);
            if (contact != null) {
                this.userid = contact.userid;
                this.account = contact.account;
                this.acctype = contact.acctype;
                this.acc_userid = contact.acc_userid;
                this.acc_shopid = contact.acc_shopid;
                this.status = contact.status;
                this.name = contact.name;
                this.deviceid = contact.deviceid;
            }
        }

        public Builder userid(Integer num) {
            this.userid = num;
            return this;
        }

        public Builder account(String str) {
            this.account = str;
            return this;
        }

        public Builder acctype(Integer num) {
            this.acctype = num;
            return this;
        }

        public Builder acc_userid(Integer num) {
            this.acc_userid = num;
            return this;
        }

        public Builder acc_shopid(Integer num) {
            this.acc_shopid = num;
            return this;
        }

        public Builder status(Integer num) {
            this.status = num;
            return this;
        }

        public Builder name(String str) {
            this.name = str;
            return this;
        }

        public Builder deviceid(f fVar) {
            this.deviceid = fVar;
            return this;
        }

        public Contact build() {
            return new Contact(this);
        }
    }
}
