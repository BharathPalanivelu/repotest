package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class JkoAccountSeller extends Message {
    public static final Integer DEFAULT_ACCOUNT_TYPE = 0;
    public static final String DEFAULT_ID = "";
    public static final String DEFAULT_KEY = "";
    public static final Integer DEFAULT_LINKAGE_STATUS = 0;
    public static final String DEFAULT_USERNAME = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer account_type;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String id;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String key;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer linkage_status;
    @ProtoField(tag = 5, type = Message.Datatype.STRING)
    public final String username;

    public JkoAccountSeller(String str, String str2, Integer num, Integer num2, String str3) {
        this.id = str;
        this.key = str2;
        this.account_type = num;
        this.linkage_status = num2;
        this.username = str3;
    }

    private JkoAccountSeller(Builder builder) {
        this(builder.id, builder.key, builder.account_type, builder.linkage_status, builder.username);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof JkoAccountSeller)) {
            return false;
        }
        JkoAccountSeller jkoAccountSeller = (JkoAccountSeller) obj;
        if (!equals((Object) this.id, (Object) jkoAccountSeller.id) || !equals((Object) this.key, (Object) jkoAccountSeller.key) || !equals((Object) this.account_type, (Object) jkoAccountSeller.account_type) || !equals((Object) this.linkage_status, (Object) jkoAccountSeller.linkage_status) || !equals((Object) this.username, (Object) jkoAccountSeller.username)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        String str = this.id;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 37;
        String str2 = this.key;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 37;
        Integer num = this.account_type;
        int hashCode3 = (hashCode2 + (num != null ? num.hashCode() : 0)) * 37;
        Integer num2 = this.linkage_status;
        int hashCode4 = (hashCode3 + (num2 != null ? num2.hashCode() : 0)) * 37;
        String str3 = this.username;
        if (str3 != null) {
            i2 = str3.hashCode();
        }
        int i3 = hashCode4 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<JkoAccountSeller> {
        public Integer account_type;
        public String id;
        public String key;
        public Integer linkage_status;
        public String username;

        public Builder() {
        }

        public Builder(JkoAccountSeller jkoAccountSeller) {
            super(jkoAccountSeller);
            if (jkoAccountSeller != null) {
                this.id = jkoAccountSeller.id;
                this.key = jkoAccountSeller.key;
                this.account_type = jkoAccountSeller.account_type;
                this.linkage_status = jkoAccountSeller.linkage_status;
                this.username = jkoAccountSeller.username;
            }
        }

        public Builder id(String str) {
            this.id = str;
            return this;
        }

        public Builder key(String str) {
            this.key = str;
            return this;
        }

        public Builder account_type(Integer num) {
            this.account_type = num;
            return this;
        }

        public Builder linkage_status(Integer num) {
            this.linkage_status = num;
            return this;
        }

        public Builder username(String str) {
            this.username = str;
            return this;
        }

        public JkoAccountSeller build() {
            return new JkoAccountSeller(this);
        }
    }
}
