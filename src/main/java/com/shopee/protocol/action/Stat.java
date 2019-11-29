package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class Stat extends Message {
    public static final Long DEFAULT_COUNT = 0L;
    public static final Integer DEFAULT_DATE = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 2, type = Message.Datatype.INT64)
    public final Long count;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer date;

    public Stat(Integer num, Long l) {
        this.date = num;
        this.count = l;
    }

    private Stat(Builder builder) {
        this(builder.date, builder.count);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Stat)) {
            return false;
        }
        Stat stat = (Stat) obj;
        if (!equals((Object) this.date, (Object) stat.date) || !equals((Object) this.count, (Object) stat.count)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Integer num = this.date;
        int i2 = 0;
        int hashCode = (num != null ? num.hashCode() : 0) * 37;
        Long l = this.count;
        if (l != null) {
            i2 = l.hashCode();
        }
        int i3 = hashCode + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<Stat> {
        public Long count;
        public Integer date;

        public Builder() {
        }

        public Builder(Stat stat) {
            super(stat);
            if (stat != null) {
                this.date = stat.date;
                this.count = stat.count;
            }
        }

        public Builder date(Integer num) {
            this.date = num;
            return this;
        }

        public Builder count(Long l) {
            this.count = l;
            return this;
        }

        public Stat build() {
            return new Stat(this);
        }
    }
}
