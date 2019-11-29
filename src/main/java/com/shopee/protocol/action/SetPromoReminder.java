package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class SetPromoReminder extends Message {
    public static final Long DEFAULT_ITEMID = 0L;
    public static final Long DEFAULT_PROMOTIONID = 0L;
    public static final String DEFAULT_REQUESTID = "";
    public static final String DEFAULT_TOKEN = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 3, type = Message.Datatype.INT64)
    public final Long itemid;
    @ProtoField(tag = 4, type = Message.Datatype.INT64)
    public final Long promotionid;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String token;

    public SetPromoReminder(String str, String str2, Long l, Long l2) {
        this.requestid = str;
        this.token = str2;
        this.itemid = l;
        this.promotionid = l2;
    }

    private SetPromoReminder(Builder builder) {
        this(builder.requestid, builder.token, builder.itemid, builder.promotionid);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SetPromoReminder)) {
            return false;
        }
        SetPromoReminder setPromoReminder = (SetPromoReminder) obj;
        if (!equals((Object) this.requestid, (Object) setPromoReminder.requestid) || !equals((Object) this.token, (Object) setPromoReminder.token) || !equals((Object) this.itemid, (Object) setPromoReminder.itemid) || !equals((Object) this.promotionid, (Object) setPromoReminder.promotionid)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        String str = this.requestid;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 37;
        String str2 = this.token;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 37;
        Long l = this.itemid;
        int hashCode3 = (hashCode2 + (l != null ? l.hashCode() : 0)) * 37;
        Long l2 = this.promotionid;
        if (l2 != null) {
            i2 = l2.hashCode();
        }
        int i3 = hashCode3 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<SetPromoReminder> {
        public Long itemid;
        public Long promotionid;
        public String requestid;
        public String token;

        public Builder() {
        }

        public Builder(SetPromoReminder setPromoReminder) {
            super(setPromoReminder);
            if (setPromoReminder != null) {
                this.requestid = setPromoReminder.requestid;
                this.token = setPromoReminder.token;
                this.itemid = setPromoReminder.itemid;
                this.promotionid = setPromoReminder.promotionid;
            }
        }

        public Builder requestid(String str) {
            this.requestid = str;
            return this;
        }

        public Builder token(String str) {
            this.token = str;
            return this;
        }

        public Builder itemid(Long l) {
            this.itemid = l;
            return this;
        }

        public Builder promotionid(Long l) {
            this.promotionid = l;
            return this;
        }

        public SetPromoReminder build() {
            return new SetPromoReminder(this);
        }
    }
}
