package com.shopee.protocol.track.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class TrackingCollectionCard extends Message {
    public static final Integer DEFAULT_ID = 0;
    public static final Integer DEFAULT_LOACTION = 0;
    public static final String DEFAULT_NAME = "";
    public static final Long DEFAULT_STARTING_PRICE = 0L;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer id;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer loaction;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String name;
    @ProtoField(tag = 3, type = Message.Datatype.INT64)
    public final Long starting_price;

    public TrackingCollectionCard(String str, Integer num, Long l, Integer num2) {
        this.name = str;
        this.id = num;
        this.starting_price = l;
        this.loaction = num2;
    }

    private TrackingCollectionCard(Builder builder) {
        this(builder.name, builder.id, builder.starting_price, builder.loaction);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof TrackingCollectionCard)) {
            return false;
        }
        TrackingCollectionCard trackingCollectionCard = (TrackingCollectionCard) obj;
        if (!equals((Object) this.name, (Object) trackingCollectionCard.name) || !equals((Object) this.id, (Object) trackingCollectionCard.id) || !equals((Object) this.starting_price, (Object) trackingCollectionCard.starting_price) || !equals((Object) this.loaction, (Object) trackingCollectionCard.loaction)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        String str = this.name;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 37;
        Integer num = this.id;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 37;
        Long l = this.starting_price;
        int hashCode3 = (hashCode2 + (l != null ? l.hashCode() : 0)) * 37;
        Integer num2 = this.loaction;
        if (num2 != null) {
            i2 = num2.hashCode();
        }
        int i3 = hashCode3 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<TrackingCollectionCard> {
        public Integer id;
        public Integer loaction;
        public String name;
        public Long starting_price;

        public Builder() {
        }

        public Builder(TrackingCollectionCard trackingCollectionCard) {
            super(trackingCollectionCard);
            if (trackingCollectionCard != null) {
                this.name = trackingCollectionCard.name;
                this.id = trackingCollectionCard.id;
                this.starting_price = trackingCollectionCard.starting_price;
                this.loaction = trackingCollectionCard.loaction;
            }
        }

        public Builder name(String str) {
            this.name = str;
            return this;
        }

        public Builder id(Integer num) {
            this.id = num;
            return this;
        }

        public Builder starting_price(Long l) {
            this.starting_price = l;
            return this;
        }

        public Builder loaction(Integer num) {
            this.loaction = num;
            return this;
        }

        public TrackingCollectionCard build() {
            return new TrackingCollectionCard(this);
        }
    }
}
