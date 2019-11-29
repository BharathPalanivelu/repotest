package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class CardPromotionUIInfo extends Message {
    public static final Long DEFAULT_BANK_ID = 0L;
    public static final String DEFAULT_DESCRIPTION = "";
    public static final Long DEFAULT_DISCOUNT_TYPE = 0L;
    public static final Long DEFAULT_DISCOUNT_VALUE = 0L;
    public static final String DEFAULT_TITLE = "";
    public static final String DEFAULT_URL = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 7, type = Message.Datatype.INT64)
    public final Long bank_id;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String description;
    @ProtoField(tag = 6, type = Message.Datatype.INT64)
    public final Long discount_type;
    @ProtoField(tag = 5, type = Message.Datatype.INT64)
    public final Long discount_value;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String title;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String url;

    public CardPromotionUIInfo(String str, String str2, String str3, Long l, Long l2, Long l3) {
        this.description = str;
        this.url = str2;
        this.title = str3;
        this.discount_value = l;
        this.discount_type = l2;
        this.bank_id = l3;
    }

    private CardPromotionUIInfo(Builder builder) {
        this(builder.description, builder.url, builder.title, builder.discount_value, builder.discount_type, builder.bank_id);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CardPromotionUIInfo)) {
            return false;
        }
        CardPromotionUIInfo cardPromotionUIInfo = (CardPromotionUIInfo) obj;
        if (!equals((Object) this.description, (Object) cardPromotionUIInfo.description) || !equals((Object) this.url, (Object) cardPromotionUIInfo.url) || !equals((Object) this.title, (Object) cardPromotionUIInfo.title) || !equals((Object) this.discount_value, (Object) cardPromotionUIInfo.discount_value) || !equals((Object) this.discount_type, (Object) cardPromotionUIInfo.discount_type) || !equals((Object) this.bank_id, (Object) cardPromotionUIInfo.bank_id)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        String str = this.description;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 37;
        String str2 = this.url;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 37;
        String str3 = this.title;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 37;
        Long l = this.discount_value;
        int hashCode4 = (hashCode3 + (l != null ? l.hashCode() : 0)) * 37;
        Long l2 = this.discount_type;
        int hashCode5 = (hashCode4 + (l2 != null ? l2.hashCode() : 0)) * 37;
        Long l3 = this.bank_id;
        if (l3 != null) {
            i2 = l3.hashCode();
        }
        int i3 = hashCode5 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<CardPromotionUIInfo> {
        public Long bank_id;
        public String description;
        public Long discount_type;
        public Long discount_value;
        public String title;
        public String url;

        public Builder() {
        }

        public Builder(CardPromotionUIInfo cardPromotionUIInfo) {
            super(cardPromotionUIInfo);
            if (cardPromotionUIInfo != null) {
                this.description = cardPromotionUIInfo.description;
                this.url = cardPromotionUIInfo.url;
                this.title = cardPromotionUIInfo.title;
                this.discount_value = cardPromotionUIInfo.discount_value;
                this.discount_type = cardPromotionUIInfo.discount_type;
                this.bank_id = cardPromotionUIInfo.bank_id;
            }
        }

        public Builder description(String str) {
            this.description = str;
            return this;
        }

        public Builder url(String str) {
            this.url = str;
            return this;
        }

        public Builder title(String str) {
            this.title = str;
            return this;
        }

        public Builder discount_value(Long l) {
            this.discount_value = l;
            return this;
        }

        public Builder discount_type(Long l) {
            this.discount_type = l;
            return this;
        }

        public Builder bank_id(Long l) {
            this.bank_id = l;
            return this;
        }

        public CardPromotionUIInfo build() {
            return new CardPromotionUIInfo(this);
        }
    }
}
