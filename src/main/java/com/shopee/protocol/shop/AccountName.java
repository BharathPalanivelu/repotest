package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class AccountName extends Message {
    public static final Long DEFAULT_ID = 0L;
    public static final String DEFAULT_NAME = "";
    public static final Integer DEFAULT_NS = 0;
    public static final Long DEFAULT_REF = 0L;
    public static final String DEFAULT_REGION = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long id;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String name;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer ns;
    @ProtoField(tag = 5, type = Message.Datatype.INT64)
    public final Long ref;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String region;

    public AccountName(Long l, String str, String str2, Integer num, Long l2) {
        this.id = l;
        this.name = str;
        this.region = str2;
        this.ns = num;
        this.ref = l2;
    }

    private AccountName(Builder builder) {
        this(builder.id, builder.name, builder.region, builder.ns, builder.ref);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AccountName)) {
            return false;
        }
        AccountName accountName = (AccountName) obj;
        if (!equals((Object) this.id, (Object) accountName.id) || !equals((Object) this.name, (Object) accountName.name) || !equals((Object) this.region, (Object) accountName.region) || !equals((Object) this.ns, (Object) accountName.ns) || !equals((Object) this.ref, (Object) accountName.ref)) {
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
        String str = this.name;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 37;
        String str2 = this.region;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 37;
        Integer num = this.ns;
        int hashCode4 = (hashCode3 + (num != null ? num.hashCode() : 0)) * 37;
        Long l2 = this.ref;
        if (l2 != null) {
            i2 = l2.hashCode();
        }
        int i3 = hashCode4 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<AccountName> {
        public Long id;
        public String name;
        public Integer ns;
        public Long ref;
        public String region;

        public Builder() {
        }

        public Builder(AccountName accountName) {
            super(accountName);
            if (accountName != null) {
                this.id = accountName.id;
                this.name = accountName.name;
                this.region = accountName.region;
                this.ns = accountName.ns;
                this.ref = accountName.ref;
            }
        }

        public Builder id(Long l) {
            this.id = l;
            return this;
        }

        public Builder name(String str) {
            this.name = str;
            return this;
        }

        public Builder region(String str) {
            this.region = str;
            return this;
        }

        public Builder ns(Integer num) {
            this.ns = num;
            return this;
        }

        public Builder ref(Long l) {
            this.ref = l;
            return this;
        }

        public AccountName build() {
            return new AccountName(this);
        }
    }
}
