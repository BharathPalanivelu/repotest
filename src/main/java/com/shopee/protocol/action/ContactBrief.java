package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class ContactBrief extends Message {
    public static final String DEFAULT_ACCOUNT = "";
    public static final String DEFAULT_CONTACT_NAME = "";
    public static final Boolean DEFAULT_FOLLOWED = false;
    public static final String DEFAULT_PORTRAIT = "";
    public static final Integer DEFAULT_SHOPID = 0;
    public static final Integer DEFAULT_USERID = 0;
    public static final String DEFAULT_USERNAME = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 7, type = Message.Datatype.STRING)
    public final String account;
    @ProtoField(tag = 5, type = Message.Datatype.STRING)
    public final String contact_name;
    @ProtoField(tag = 6, type = Message.Datatype.BOOL)
    public final Boolean followed;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String portrait;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer shopid;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer userid;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String username;

    public ContactBrief(Integer num, Integer num2, String str, String str2, String str3, Boolean bool, String str4) {
        this.userid = num;
        this.shopid = num2;
        this.username = str;
        this.portrait = str2;
        this.contact_name = str3;
        this.followed = bool;
        this.account = str4;
    }

    private ContactBrief(Builder builder) {
        this(builder.userid, builder.shopid, builder.username, builder.portrait, builder.contact_name, builder.followed, builder.account);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ContactBrief)) {
            return false;
        }
        ContactBrief contactBrief = (ContactBrief) obj;
        if (!equals((Object) this.userid, (Object) contactBrief.userid) || !equals((Object) this.shopid, (Object) contactBrief.shopid) || !equals((Object) this.username, (Object) contactBrief.username) || !equals((Object) this.portrait, (Object) contactBrief.portrait) || !equals((Object) this.contact_name, (Object) contactBrief.contact_name) || !equals((Object) this.followed, (Object) contactBrief.followed) || !equals((Object) this.account, (Object) contactBrief.account)) {
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
        Integer num2 = this.shopid;
        int hashCode2 = (hashCode + (num2 != null ? num2.hashCode() : 0)) * 37;
        String str = this.username;
        int hashCode3 = (hashCode2 + (str != null ? str.hashCode() : 0)) * 37;
        String str2 = this.portrait;
        int hashCode4 = (hashCode3 + (str2 != null ? str2.hashCode() : 0)) * 37;
        String str3 = this.contact_name;
        int hashCode5 = (hashCode4 + (str3 != null ? str3.hashCode() : 0)) * 37;
        Boolean bool = this.followed;
        int hashCode6 = (hashCode5 + (bool != null ? bool.hashCode() : 0)) * 37;
        String str4 = this.account;
        if (str4 != null) {
            i2 = str4.hashCode();
        }
        int i3 = hashCode6 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<ContactBrief> {
        public String account;
        public String contact_name;
        public Boolean followed;
        public String portrait;
        public Integer shopid;
        public Integer userid;
        public String username;

        public Builder() {
        }

        public Builder(ContactBrief contactBrief) {
            super(contactBrief);
            if (contactBrief != null) {
                this.userid = contactBrief.userid;
                this.shopid = contactBrief.shopid;
                this.username = contactBrief.username;
                this.portrait = contactBrief.portrait;
                this.contact_name = contactBrief.contact_name;
                this.followed = contactBrief.followed;
                this.account = contactBrief.account;
            }
        }

        public Builder userid(Integer num) {
            this.userid = num;
            return this;
        }

        public Builder shopid(Integer num) {
            this.shopid = num;
            return this;
        }

        public Builder username(String str) {
            this.username = str;
            return this;
        }

        public Builder portrait(String str) {
            this.portrait = str;
            return this;
        }

        public Builder contact_name(String str) {
            this.contact_name = str;
            return this;
        }

        public Builder followed(Boolean bool) {
            this.followed = bool;
            return this;
        }

        public Builder account(String str) {
            this.account = str;
            return this;
        }

        public ContactBrief build() {
            return new ContactBrief(this);
        }
    }
}
