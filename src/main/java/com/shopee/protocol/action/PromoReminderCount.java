package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class PromoReminderCount extends Message {
    public static final Integer DEFAULT_COUNT = 0;
    public static final Long DEFAULT_ITEMID = 0L;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer count;
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long itemid;

    public PromoReminderCount(Long l, Integer num) {
        this.itemid = l;
        this.count = num;
    }

    private PromoReminderCount(Builder builder) {
        this(builder.itemid, builder.count);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof PromoReminderCount)) {
            return false;
        }
        PromoReminderCount promoReminderCount = (PromoReminderCount) obj;
        if (!equals((Object) this.itemid, (Object) promoReminderCount.itemid) || !equals((Object) this.count, (Object) promoReminderCount.count)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Long l = this.itemid;
        int i2 = 0;
        int hashCode = (l != null ? l.hashCode() : 0) * 37;
        Integer num = this.count;
        if (num != null) {
            i2 = num.hashCode();
        }
        int i3 = hashCode + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<PromoReminderCount> {
        public Integer count;
        public Long itemid;

        public Builder() {
        }

        public Builder(PromoReminderCount promoReminderCount) {
            super(promoReminderCount);
            if (promoReminderCount != null) {
                this.itemid = promoReminderCount.itemid;
                this.count = promoReminderCount.count;
            }
        }

        public Builder itemid(Long l) {
            this.itemid = l;
            return this;
        }

        public Builder count(Integer num) {
            this.count = num;
            return this;
        }

        public PromoReminderCount build() {
            return new PromoReminderCount(this);
        }
    }
}
