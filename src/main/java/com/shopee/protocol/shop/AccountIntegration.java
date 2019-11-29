package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import e.f;

public final class AccountIntegration extends Message {
    public static final Long DEFAULT_CREATE_TIME = 0L;
    public static final f DEFAULT_EXTRA_INFO = f.f32736b;
    public static final Long DEFAULT_ID = 0L;
    public static final Integer DEFAULT_STATUS = 0;
    public static final String DEFAULT_THIRD_PARTY_IDENTITY = "";
    public static final Integer DEFAULT_THIRD_PARTY_TYPE = 0;
    public static final Long DEFAULT_UPDATE_TIME = 0L;
    public static final Long DEFAULT_USER_ID = 0L;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 7, type = Message.Datatype.UINT64)
    public final Long create_time;
    @ProtoField(tag = 6, type = Message.Datatype.BYTES)
    public final f extra_info;
    @ProtoField(tag = 1, type = Message.Datatype.UINT64)
    public final Long id;
    @ProtoField(tag = 5, type = Message.Datatype.UINT32)
    public final Integer status;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String third_party_identity;
    @ProtoField(tag = 4, type = Message.Datatype.UINT32)
    public final Integer third_party_type;
    @ProtoField(tag = 8, type = Message.Datatype.UINT64)
    public final Long update_time;
    @ProtoField(tag = 2, type = Message.Datatype.UINT64)
    public final Long user_id;

    public AccountIntegration(Long l, Long l2, String str, Integer num, Integer num2, f fVar, Long l3, Long l4) {
        this.id = l;
        this.user_id = l2;
        this.third_party_identity = str;
        this.third_party_type = num;
        this.status = num2;
        this.extra_info = fVar;
        this.create_time = l3;
        this.update_time = l4;
    }

    private AccountIntegration(Builder builder) {
        this(builder.id, builder.user_id, builder.third_party_identity, builder.third_party_type, builder.status, builder.extra_info, builder.create_time, builder.update_time);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AccountIntegration)) {
            return false;
        }
        AccountIntegration accountIntegration = (AccountIntegration) obj;
        if (!equals((Object) this.id, (Object) accountIntegration.id) || !equals((Object) this.user_id, (Object) accountIntegration.user_id) || !equals((Object) this.third_party_identity, (Object) accountIntegration.third_party_identity) || !equals((Object) this.third_party_type, (Object) accountIntegration.third_party_type) || !equals((Object) this.status, (Object) accountIntegration.status) || !equals((Object) this.extra_info, (Object) accountIntegration.extra_info) || !equals((Object) this.create_time, (Object) accountIntegration.create_time) || !equals((Object) this.update_time, (Object) accountIntegration.update_time)) {
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
        Long l2 = this.user_id;
        int hashCode2 = (hashCode + (l2 != null ? l2.hashCode() : 0)) * 37;
        String str = this.third_party_identity;
        int hashCode3 = (hashCode2 + (str != null ? str.hashCode() : 0)) * 37;
        Integer num = this.third_party_type;
        int hashCode4 = (hashCode3 + (num != null ? num.hashCode() : 0)) * 37;
        Integer num2 = this.status;
        int hashCode5 = (hashCode4 + (num2 != null ? num2.hashCode() : 0)) * 37;
        f fVar = this.extra_info;
        int hashCode6 = (hashCode5 + (fVar != null ? fVar.hashCode() : 0)) * 37;
        Long l3 = this.create_time;
        int hashCode7 = (hashCode6 + (l3 != null ? l3.hashCode() : 0)) * 37;
        Long l4 = this.update_time;
        if (l4 != null) {
            i2 = l4.hashCode();
        }
        int i3 = hashCode7 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<AccountIntegration> {
        public Long create_time;
        public f extra_info;
        public Long id;
        public Integer status;
        public String third_party_identity;
        public Integer third_party_type;
        public Long update_time;
        public Long user_id;

        public Builder() {
        }

        public Builder(AccountIntegration accountIntegration) {
            super(accountIntegration);
            if (accountIntegration != null) {
                this.id = accountIntegration.id;
                this.user_id = accountIntegration.user_id;
                this.third_party_identity = accountIntegration.third_party_identity;
                this.third_party_type = accountIntegration.third_party_type;
                this.status = accountIntegration.status;
                this.extra_info = accountIntegration.extra_info;
                this.create_time = accountIntegration.create_time;
                this.update_time = accountIntegration.update_time;
            }
        }

        public Builder id(Long l) {
            this.id = l;
            return this;
        }

        public Builder user_id(Long l) {
            this.user_id = l;
            return this;
        }

        public Builder third_party_identity(String str) {
            this.third_party_identity = str;
            return this;
        }

        public Builder third_party_type(Integer num) {
            this.third_party_type = num;
            return this;
        }

        public Builder status(Integer num) {
            this.status = num;
            return this;
        }

        public Builder extra_info(f fVar) {
            this.extra_info = fVar;
            return this;
        }

        public Builder create_time(Long l) {
            this.create_time = l;
            return this;
        }

        public Builder update_time(Long l) {
            this.update_time = l;
            return this;
        }

        public AccountIntegration build() {
            return new AccountIntegration(this);
        }
    }
}
