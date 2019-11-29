package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import e.f;

public final class ShopPenaltyScoring extends Message {
    public static final String DEFAULT_COUNTRY = "";
    public static final Integer DEFAULT_CTIME = 0;
    public static final f DEFAULT_EXTINFO = f.f32736b;
    public static final Long DEFAULT_ID = 0L;
    public static final Integer DEFAULT_LAST_PENALTY_SCORE = 0;
    public static final Integer DEFAULT_LAST_TIER = 0;
    public static final Integer DEFAULT_PENALTY_SCORE = 0;
    public static final Integer DEFAULT_SHOPID = 0;
    public static final Integer DEFAULT_SHOP_TYPE = 0;
    public static final Integer DEFAULT_TIER = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 9, type = Message.Datatype.STRING)
    public final String country;
    @ProtoField(tag = 8, type = Message.Datatype.INT32)
    public final Integer ctime;
    @ProtoField(tag = 10, type = Message.Datatype.BYTES)
    public final f extinfo;
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long id;
    @ProtoField(tag = 5, type = Message.Datatype.INT32)
    public final Integer last_penalty_score;
    @ProtoField(tag = 7, type = Message.Datatype.INT32)
    public final Integer last_tier;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer penalty_score;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer shop_type;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer shopid;
    @ProtoField(tag = 6, type = Message.Datatype.INT32)
    public final Integer tier;

    public ShopPenaltyScoring(Long l, Integer num, Integer num2, Integer num3, Integer num4, Integer num5, Integer num6, Integer num7, String str, f fVar) {
        this.id = l;
        this.shopid = num;
        this.shop_type = num2;
        this.penalty_score = num3;
        this.last_penalty_score = num4;
        this.tier = num5;
        this.last_tier = num6;
        this.ctime = num7;
        this.country = str;
        this.extinfo = fVar;
    }

    private ShopPenaltyScoring(Builder builder) {
        this(builder.id, builder.shopid, builder.shop_type, builder.penalty_score, builder.last_penalty_score, builder.tier, builder.last_tier, builder.ctime, builder.country, builder.extinfo);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ShopPenaltyScoring)) {
            return false;
        }
        ShopPenaltyScoring shopPenaltyScoring = (ShopPenaltyScoring) obj;
        if (!equals((Object) this.id, (Object) shopPenaltyScoring.id) || !equals((Object) this.shopid, (Object) shopPenaltyScoring.shopid) || !equals((Object) this.shop_type, (Object) shopPenaltyScoring.shop_type) || !equals((Object) this.penalty_score, (Object) shopPenaltyScoring.penalty_score) || !equals((Object) this.last_penalty_score, (Object) shopPenaltyScoring.last_penalty_score) || !equals((Object) this.tier, (Object) shopPenaltyScoring.tier) || !equals((Object) this.last_tier, (Object) shopPenaltyScoring.last_tier) || !equals((Object) this.ctime, (Object) shopPenaltyScoring.ctime) || !equals((Object) this.country, (Object) shopPenaltyScoring.country) || !equals((Object) this.extinfo, (Object) shopPenaltyScoring.extinfo)) {
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
        Integer num = this.shopid;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 37;
        Integer num2 = this.shop_type;
        int hashCode3 = (hashCode2 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Integer num3 = this.penalty_score;
        int hashCode4 = (hashCode3 + (num3 != null ? num3.hashCode() : 0)) * 37;
        Integer num4 = this.last_penalty_score;
        int hashCode5 = (hashCode4 + (num4 != null ? num4.hashCode() : 0)) * 37;
        Integer num5 = this.tier;
        int hashCode6 = (hashCode5 + (num5 != null ? num5.hashCode() : 0)) * 37;
        Integer num6 = this.last_tier;
        int hashCode7 = (hashCode6 + (num6 != null ? num6.hashCode() : 0)) * 37;
        Integer num7 = this.ctime;
        int hashCode8 = (hashCode7 + (num7 != null ? num7.hashCode() : 0)) * 37;
        String str = this.country;
        int hashCode9 = (hashCode8 + (str != null ? str.hashCode() : 0)) * 37;
        f fVar = this.extinfo;
        if (fVar != null) {
            i2 = fVar.hashCode();
        }
        int i3 = hashCode9 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<ShopPenaltyScoring> {
        public String country;
        public Integer ctime;
        public f extinfo;
        public Long id;
        public Integer last_penalty_score;
        public Integer last_tier;
        public Integer penalty_score;
        public Integer shop_type;
        public Integer shopid;
        public Integer tier;

        public Builder() {
        }

        public Builder(ShopPenaltyScoring shopPenaltyScoring) {
            super(shopPenaltyScoring);
            if (shopPenaltyScoring != null) {
                this.id = shopPenaltyScoring.id;
                this.shopid = shopPenaltyScoring.shopid;
                this.shop_type = shopPenaltyScoring.shop_type;
                this.penalty_score = shopPenaltyScoring.penalty_score;
                this.last_penalty_score = shopPenaltyScoring.last_penalty_score;
                this.tier = shopPenaltyScoring.tier;
                this.last_tier = shopPenaltyScoring.last_tier;
                this.ctime = shopPenaltyScoring.ctime;
                this.country = shopPenaltyScoring.country;
                this.extinfo = shopPenaltyScoring.extinfo;
            }
        }

        public Builder id(Long l) {
            this.id = l;
            return this;
        }

        public Builder shopid(Integer num) {
            this.shopid = num;
            return this;
        }

        public Builder shop_type(Integer num) {
            this.shop_type = num;
            return this;
        }

        public Builder penalty_score(Integer num) {
            this.penalty_score = num;
            return this;
        }

        public Builder last_penalty_score(Integer num) {
            this.last_penalty_score = num;
            return this;
        }

        public Builder tier(Integer num) {
            this.tier = num;
            return this;
        }

        public Builder last_tier(Integer num) {
            this.last_tier = num;
            return this;
        }

        public Builder ctime(Integer num) {
            this.ctime = num;
            return this;
        }

        public Builder country(String str) {
            this.country = str;
            return this;
        }

        public Builder extinfo(f fVar) {
            this.extinfo = fVar;
            return this;
        }

        public ShopPenaltyScoring build() {
            return new ShopPenaltyScoring(this);
        }
    }
}
