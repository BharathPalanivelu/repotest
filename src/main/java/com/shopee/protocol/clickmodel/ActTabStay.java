package com.shopee.protocol.clickmodel;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class ActTabStay extends Message {
    public static final Long DEFAULT_FOLLOW = 0L;
    public static final Long DEFAULT_HOME = 0L;
    public static final Long DEFAULT_ME = 0L;
    public static final Long DEFAULT_NOTIFICATION = 0L;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 2, type = Message.Datatype.INT64)
    public final Long follow;
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long home;
    @ProtoField(tag = 3, type = Message.Datatype.INT64)

    /* renamed from: me  reason: collision with root package name */
    public final Long f7145me;
    @ProtoField(tag = 4, type = Message.Datatype.INT64)
    public final Long notification;

    public ActTabStay(Long l, Long l2, Long l3, Long l4) {
        this.home = l;
        this.follow = l2;
        this.f7145me = l3;
        this.notification = l4;
    }

    private ActTabStay(Builder builder) {
        this(builder.home, builder.follow, builder.f30142me, builder.notification);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ActTabStay)) {
            return false;
        }
        ActTabStay actTabStay = (ActTabStay) obj;
        if (!equals((Object) this.home, (Object) actTabStay.home) || !equals((Object) this.follow, (Object) actTabStay.follow) || !equals((Object) this.f7145me, (Object) actTabStay.f7145me) || !equals((Object) this.notification, (Object) actTabStay.notification)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Long l = this.home;
        int i2 = 0;
        int hashCode = (l != null ? l.hashCode() : 0) * 37;
        Long l2 = this.follow;
        int hashCode2 = (hashCode + (l2 != null ? l2.hashCode() : 0)) * 37;
        Long l3 = this.f7145me;
        int hashCode3 = (hashCode2 + (l3 != null ? l3.hashCode() : 0)) * 37;
        Long l4 = this.notification;
        if (l4 != null) {
            i2 = l4.hashCode();
        }
        int i3 = hashCode3 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<ActTabStay> {
        public Long follow;
        public Long home;

        /* renamed from: me  reason: collision with root package name */
        public Long f30142me;
        public Long notification;

        public Builder() {
        }

        public Builder(ActTabStay actTabStay) {
            super(actTabStay);
            if (actTabStay != null) {
                this.home = actTabStay.home;
                this.follow = actTabStay.follow;
                this.f30142me = actTabStay.f7145me;
                this.notification = actTabStay.notification;
            }
        }

        public Builder home(Long l) {
            this.home = l;
            return this;
        }

        public Builder follow(Long l) {
            this.follow = l;
            return this;
        }

        public Builder me(Long l) {
            this.f30142me = l;
            return this;
        }

        public Builder notification(Long l) {
            this.notification = l;
            return this;
        }

        public ActTabStay build() {
            return new ActTabStay(this);
        }
    }
}
