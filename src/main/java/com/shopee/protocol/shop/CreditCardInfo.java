package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class CreditCardInfo extends Message {
    public static final String DEFAULT_CARD_NUMBER = "";
    public static final Integer DEFAULT_CARD_TYPE = 0;
    public static final String DEFAULT_EXPIRY_DATE = "";
    public static final String DEFAULT_PAYMENT_TOKEN = "";
    public static final Integer DEFAULT_STATUS = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(label = Message.Label.REQUIRED, tag = 3, type = Message.Datatype.STRING)
    public final String card_number;
    @ProtoField(label = Message.Label.REQUIRED, tag = 4, type = Message.Datatype.INT32)
    public final Integer card_type;
    @ProtoField(tag = 5, type = Message.Datatype.STRING)
    public final String expiry_date;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2, type = Message.Datatype.STRING)
    public final String payment_token;
    @ProtoField(tag = 6, type = Message.Datatype.INT32)
    public final Integer status;

    public CreditCardInfo(String str, String str2, Integer num, String str3, Integer num2) {
        this.payment_token = str;
        this.card_number = str2;
        this.card_type = num;
        this.expiry_date = str3;
        this.status = num2;
    }

    private CreditCardInfo(Builder builder) {
        this(builder.payment_token, builder.card_number, builder.card_type, builder.expiry_date, builder.status);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CreditCardInfo)) {
            return false;
        }
        CreditCardInfo creditCardInfo = (CreditCardInfo) obj;
        if (!equals((Object) this.payment_token, (Object) creditCardInfo.payment_token) || !equals((Object) this.card_number, (Object) creditCardInfo.card_number) || !equals((Object) this.card_type, (Object) creditCardInfo.card_type) || !equals((Object) this.expiry_date, (Object) creditCardInfo.expiry_date) || !equals((Object) this.status, (Object) creditCardInfo.status)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        String str = this.payment_token;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 37;
        String str2 = this.card_number;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 37;
        Integer num = this.card_type;
        int hashCode3 = (hashCode2 + (num != null ? num.hashCode() : 0)) * 37;
        String str3 = this.expiry_date;
        int hashCode4 = (hashCode3 + (str3 != null ? str3.hashCode() : 0)) * 37;
        Integer num2 = this.status;
        if (num2 != null) {
            i2 = num2.hashCode();
        }
        int i3 = hashCode4 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<CreditCardInfo> {
        public String card_number;
        public Integer card_type;
        public String expiry_date;
        public String payment_token;
        public Integer status;

        public Builder() {
        }

        public Builder(CreditCardInfo creditCardInfo) {
            super(creditCardInfo);
            if (creditCardInfo != null) {
                this.payment_token = creditCardInfo.payment_token;
                this.card_number = creditCardInfo.card_number;
                this.card_type = creditCardInfo.card_type;
                this.expiry_date = creditCardInfo.expiry_date;
                this.status = creditCardInfo.status;
            }
        }

        public Builder payment_token(String str) {
            this.payment_token = str;
            return this;
        }

        public Builder card_number(String str) {
            this.card_number = str;
            return this;
        }

        public Builder card_type(Integer num) {
            this.card_type = num;
            return this;
        }

        public Builder expiry_date(String str) {
            this.expiry_date = str;
            return this;
        }

        public Builder status(Integer num) {
            this.status = num;
            return this;
        }

        public CreditCardInfo build() {
            checkRequiredFields();
            return new CreditCardInfo(this);
        }
    }
}
