package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import e.f;

public final class Coin extends Message {
    public static final Long DEFAULT_AVAILABLE_AMOUNT = 0L;
    public static final String DEFAULT_COUNTRY = "";
    public static final f DEFAULT_EXPIRY_INFO = f.f32736b;
    public static final Integer DEFAULT_MTIME = 0;
    public static final Integer DEFAULT_USERID = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 2, type = Message.Datatype.INT64)
    public final Long available_amount;
    @ProtoField(tag = 5, type = Message.Datatype.STRING)
    public final String country;
    @ProtoField(tag = 4, type = Message.Datatype.BYTES)
    public final f expiry_info;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer mtime;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer userid;

    public Coin(Integer num, Long l, Integer num2, f fVar, String str) {
        this.userid = num;
        this.available_amount = l;
        this.mtime = num2;
        this.expiry_info = fVar;
        this.country = str;
    }

    private Coin(Builder builder) {
        this(builder.userid, builder.available_amount, builder.mtime, builder.expiry_info, builder.country);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Coin)) {
            return false;
        }
        Coin coin = (Coin) obj;
        if (!equals((Object) this.userid, (Object) coin.userid) || !equals((Object) this.available_amount, (Object) coin.available_amount) || !equals((Object) this.mtime, (Object) coin.mtime) || !equals((Object) this.expiry_info, (Object) coin.expiry_info) || !equals((Object) this.country, (Object) coin.country)) {
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
        Long l = this.available_amount;
        int hashCode2 = (hashCode + (l != null ? l.hashCode() : 0)) * 37;
        Integer num2 = this.mtime;
        int hashCode3 = (hashCode2 + (num2 != null ? num2.hashCode() : 0)) * 37;
        f fVar = this.expiry_info;
        int hashCode4 = (hashCode3 + (fVar != null ? fVar.hashCode() : 0)) * 37;
        String str = this.country;
        if (str != null) {
            i2 = str.hashCode();
        }
        int i3 = hashCode4 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<Coin> {
        public Long available_amount;
        public String country;
        public f expiry_info;
        public Integer mtime;
        public Integer userid;

        public Builder() {
        }

        public Builder(Coin coin) {
            super(coin);
            if (coin != null) {
                this.userid = coin.userid;
                this.available_amount = coin.available_amount;
                this.mtime = coin.mtime;
                this.expiry_info = coin.expiry_info;
                this.country = coin.country;
            }
        }

        public Builder userid(Integer num) {
            this.userid = num;
            return this;
        }

        public Builder available_amount(Long l) {
            this.available_amount = l;
            return this;
        }

        public Builder mtime(Integer num) {
            this.mtime = num;
            return this;
        }

        public Builder expiry_info(f fVar) {
            this.expiry_info = fVar;
            return this;
        }

        public Builder country(String str) {
            this.country = str;
            return this;
        }

        public Coin build() {
            return new Coin(this);
        }
    }
}
