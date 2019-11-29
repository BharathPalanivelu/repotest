package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class PaymentBankAccount extends Message {
    public static final String DEFAULT_BANK_ACCOUNT = "";
    public static final String DEFAULT_BANK_NAME = "";
    public static final String DEFAULT_BANK_OWNER_NAME = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String bank_account;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String bank_name;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String bank_owner_name;

    public PaymentBankAccount(String str, String str2, String str3) {
        this.bank_name = str;
        this.bank_account = str2;
        this.bank_owner_name = str3;
    }

    private PaymentBankAccount(Builder builder) {
        this(builder.bank_name, builder.bank_account, builder.bank_owner_name);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof PaymentBankAccount)) {
            return false;
        }
        PaymentBankAccount paymentBankAccount = (PaymentBankAccount) obj;
        if (!equals((Object) this.bank_name, (Object) paymentBankAccount.bank_name) || !equals((Object) this.bank_account, (Object) paymentBankAccount.bank_account) || !equals((Object) this.bank_owner_name, (Object) paymentBankAccount.bank_owner_name)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        String str = this.bank_name;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 37;
        String str2 = this.bank_account;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 37;
        String str3 = this.bank_owner_name;
        if (str3 != null) {
            i2 = str3.hashCode();
        }
        int i3 = hashCode2 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<PaymentBankAccount> {
        public String bank_account;
        public String bank_name;
        public String bank_owner_name;

        public Builder() {
        }

        public Builder(PaymentBankAccount paymentBankAccount) {
            super(paymentBankAccount);
            if (paymentBankAccount != null) {
                this.bank_name = paymentBankAccount.bank_name;
                this.bank_account = paymentBankAccount.bank_account;
                this.bank_owner_name = paymentBankAccount.bank_owner_name;
            }
        }

        public Builder bank_name(String str) {
            this.bank_name = str;
            return this;
        }

        public Builder bank_account(String str) {
            this.bank_account = str;
            return this;
        }

        public Builder bank_owner_name(String str) {
            this.bank_owner_name = str;
            return this;
        }

        public PaymentBankAccount build() {
            return new PaymentBankAccount(this);
        }
    }
}
