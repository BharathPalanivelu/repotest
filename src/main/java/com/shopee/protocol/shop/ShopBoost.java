package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import e.f;

public final class ShopBoost extends Message {
    public static final Integer DEFAULT_COOLDOWN_SECOND = 0;
    public static final f DEFAULT_INFO = f.f32736b;
    public static final Integer DEFAULT_SHOPID = 0;
    public static final Integer DEFAULT_SLOT_LIMIT = 0;
    public static final Integer DEFAULT_USERID = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer cooldown_second;
    @ProtoField(tag = 5, type = Message.Datatype.BYTES)
    public final f info;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer shopid;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer slot_limit;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer userid;

    public ShopBoost(Integer num, Integer num2, Integer num3, Integer num4, f fVar) {
        this.shopid = num;
        this.userid = num2;
        this.slot_limit = num3;
        this.cooldown_second = num4;
        this.info = fVar;
    }

    private ShopBoost(Builder builder) {
        this(builder.shopid, builder.userid, builder.slot_limit, builder.cooldown_second, builder.info);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ShopBoost)) {
            return false;
        }
        ShopBoost shopBoost = (ShopBoost) obj;
        if (!equals((Object) this.shopid, (Object) shopBoost.shopid) || !equals((Object) this.userid, (Object) shopBoost.userid) || !equals((Object) this.slot_limit, (Object) shopBoost.slot_limit) || !equals((Object) this.cooldown_second, (Object) shopBoost.cooldown_second) || !equals((Object) this.info, (Object) shopBoost.info)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Integer num = this.shopid;
        int i2 = 0;
        int hashCode = (num != null ? num.hashCode() : 0) * 37;
        Integer num2 = this.userid;
        int hashCode2 = (hashCode + (num2 != null ? num2.hashCode() : 0)) * 37;
        Integer num3 = this.slot_limit;
        int hashCode3 = (hashCode2 + (num3 != null ? num3.hashCode() : 0)) * 37;
        Integer num4 = this.cooldown_second;
        int hashCode4 = (hashCode3 + (num4 != null ? num4.hashCode() : 0)) * 37;
        f fVar = this.info;
        if (fVar != null) {
            i2 = fVar.hashCode();
        }
        int i3 = hashCode4 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<ShopBoost> {
        public Integer cooldown_second;
        public f info;
        public Integer shopid;
        public Integer slot_limit;
        public Integer userid;

        public Builder() {
        }

        public Builder(ShopBoost shopBoost) {
            super(shopBoost);
            if (shopBoost != null) {
                this.shopid = shopBoost.shopid;
                this.userid = shopBoost.userid;
                this.slot_limit = shopBoost.slot_limit;
                this.cooldown_second = shopBoost.cooldown_second;
                this.info = shopBoost.info;
            }
        }

        public Builder shopid(Integer num) {
            this.shopid = num;
            return this;
        }

        public Builder userid(Integer num) {
            this.userid = num;
            return this;
        }

        public Builder slot_limit(Integer num) {
            this.slot_limit = num;
            return this;
        }

        public Builder cooldown_second(Integer num) {
            this.cooldown_second = num;
            return this;
        }

        public Builder info(f fVar) {
            this.info = fVar;
            return this;
        }

        public ShopBoost build() {
            return new ShopBoost(this);
        }
    }
}
