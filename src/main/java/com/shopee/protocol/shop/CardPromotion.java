package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import e.f;

public final class CardPromotion extends Message {
    public static final Integer DEFAULT_CARD_PROMOTION_ID = 0;
    public static final String DEFAULT_COUNTRY = "";
    public static final Integer DEFAULT_CTIME = 0;
    public static final Integer DEFAULT_END_TIME = 0;
    public static final f DEFAULT_EXTINFO = f.f32736b;
    public static final Integer DEFAULT_MTIME = 0;
    public static final String DEFAULT_NAME = "";
    public static final Integer DEFAULT_START_TIME = 0;
    public static final Integer DEFAULT_STATUS = 0;
    public static final f DEFAULT_UIINFO = f.f32736b;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer card_promotion_id;
    @ProtoField(tag = 7, type = Message.Datatype.STRING)
    public final String country;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer ctime;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer end_time;
    @ProtoField(tag = 9, type = Message.Datatype.BYTES)
    public final f extinfo;
    @ProtoField(tag = 5, type = Message.Datatype.INT32)
    public final Integer mtime;
    @ProtoField(tag = 8, type = Message.Datatype.STRING)
    public final String name;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer start_time;
    @ProtoField(tag = 6, type = Message.Datatype.INT32)
    public final Integer status;
    @ProtoField(tag = 10, type = Message.Datatype.BYTES)
    public final f uiinfo;

    public CardPromotion(Integer num, Integer num2, Integer num3, Integer num4, Integer num5, Integer num6, String str, String str2, f fVar, f fVar2) {
        this.card_promotion_id = num;
        this.start_time = num2;
        this.end_time = num3;
        this.ctime = num4;
        this.mtime = num5;
        this.status = num6;
        this.country = str;
        this.name = str2;
        this.extinfo = fVar;
        this.uiinfo = fVar2;
    }

    private CardPromotion(Builder builder) {
        this(builder.card_promotion_id, builder.start_time, builder.end_time, builder.ctime, builder.mtime, builder.status, builder.country, builder.name, builder.extinfo, builder.uiinfo);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CardPromotion)) {
            return false;
        }
        CardPromotion cardPromotion = (CardPromotion) obj;
        if (!equals((Object) this.card_promotion_id, (Object) cardPromotion.card_promotion_id) || !equals((Object) this.start_time, (Object) cardPromotion.start_time) || !equals((Object) this.end_time, (Object) cardPromotion.end_time) || !equals((Object) this.ctime, (Object) cardPromotion.ctime) || !equals((Object) this.mtime, (Object) cardPromotion.mtime) || !equals((Object) this.status, (Object) cardPromotion.status) || !equals((Object) this.country, (Object) cardPromotion.country) || !equals((Object) this.name, (Object) cardPromotion.name) || !equals((Object) this.extinfo, (Object) cardPromotion.extinfo) || !equals((Object) this.uiinfo, (Object) cardPromotion.uiinfo)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Integer num = this.card_promotion_id;
        int i2 = 0;
        int hashCode = (num != null ? num.hashCode() : 0) * 37;
        Integer num2 = this.start_time;
        int hashCode2 = (hashCode + (num2 != null ? num2.hashCode() : 0)) * 37;
        Integer num3 = this.end_time;
        int hashCode3 = (hashCode2 + (num3 != null ? num3.hashCode() : 0)) * 37;
        Integer num4 = this.ctime;
        int hashCode4 = (hashCode3 + (num4 != null ? num4.hashCode() : 0)) * 37;
        Integer num5 = this.mtime;
        int hashCode5 = (hashCode4 + (num5 != null ? num5.hashCode() : 0)) * 37;
        Integer num6 = this.status;
        int hashCode6 = (hashCode5 + (num6 != null ? num6.hashCode() : 0)) * 37;
        String str = this.country;
        int hashCode7 = (hashCode6 + (str != null ? str.hashCode() : 0)) * 37;
        String str2 = this.name;
        int hashCode8 = (hashCode7 + (str2 != null ? str2.hashCode() : 0)) * 37;
        f fVar = this.extinfo;
        int hashCode9 = (hashCode8 + (fVar != null ? fVar.hashCode() : 0)) * 37;
        f fVar2 = this.uiinfo;
        if (fVar2 != null) {
            i2 = fVar2.hashCode();
        }
        int i3 = hashCode9 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<CardPromotion> {
        public Integer card_promotion_id;
        public String country;
        public Integer ctime;
        public Integer end_time;
        public f extinfo;
        public Integer mtime;
        public String name;
        public Integer start_time;
        public Integer status;
        public f uiinfo;

        public Builder() {
        }

        public Builder(CardPromotion cardPromotion) {
            super(cardPromotion);
            if (cardPromotion != null) {
                this.card_promotion_id = cardPromotion.card_promotion_id;
                this.start_time = cardPromotion.start_time;
                this.end_time = cardPromotion.end_time;
                this.ctime = cardPromotion.ctime;
                this.mtime = cardPromotion.mtime;
                this.status = cardPromotion.status;
                this.country = cardPromotion.country;
                this.name = cardPromotion.name;
                this.extinfo = cardPromotion.extinfo;
                this.uiinfo = cardPromotion.uiinfo;
            }
        }

        public Builder card_promotion_id(Integer num) {
            this.card_promotion_id = num;
            return this;
        }

        public Builder start_time(Integer num) {
            this.start_time = num;
            return this;
        }

        public Builder end_time(Integer num) {
            this.end_time = num;
            return this;
        }

        public Builder ctime(Integer num) {
            this.ctime = num;
            return this;
        }

        public Builder mtime(Integer num) {
            this.mtime = num;
            return this;
        }

        public Builder status(Integer num) {
            this.status = num;
            return this;
        }

        public Builder country(String str) {
            this.country = str;
            return this;
        }

        public Builder name(String str) {
            this.name = str;
            return this;
        }

        public Builder extinfo(f fVar) {
            this.extinfo = fVar;
            return this;
        }

        public Builder uiinfo(f fVar) {
            this.uiinfo = fVar;
            return this;
        }

        public CardPromotion build() {
            return new CardPromotion(this);
        }
    }
}
