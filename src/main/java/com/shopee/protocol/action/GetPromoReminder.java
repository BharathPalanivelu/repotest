package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class GetPromoReminder extends Message {
    public static final List<Long> DEFAULT_ITEMIDS = Collections.emptyList();
    public static final Long DEFAULT_PROMOTIONID = 0L;
    public static final String DEFAULT_REQUESTID = "";
    private static final long serialVersionUID = 0;
    @ProtoField(label = Message.Label.REPEATED, tag = 3, type = Message.Datatype.INT64)
    public final List<Long> itemids;
    @ProtoField(tag = 2, type = Message.Datatype.INT64)
    public final Long promotionid;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;

    public GetPromoReminder(String str, Long l, List<Long> list) {
        this.requestid = str;
        this.promotionid = l;
        this.itemids = immutableCopyOf(list);
    }

    private GetPromoReminder(Builder builder) {
        this(builder.requestid, builder.promotionid, builder.itemids);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof GetPromoReminder)) {
            return false;
        }
        GetPromoReminder getPromoReminder = (GetPromoReminder) obj;
        if (!equals((Object) this.requestid, (Object) getPromoReminder.requestid) || !equals((Object) this.promotionid, (Object) getPromoReminder.promotionid) || !equals((List<?>) this.itemids, (List<?>) getPromoReminder.itemids)) {
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
        Long l = this.promotionid;
        if (l != null) {
            i2 = l.hashCode();
        }
        int i3 = (hashCode + i2) * 37;
        List<Long> list = this.itemids;
        int hashCode2 = i3 + (list != null ? list.hashCode() : 1);
        this.hashCode = hashCode2;
        return hashCode2;
    }

    public static final class Builder extends Message.Builder<GetPromoReminder> {
        public List<Long> itemids;
        public Long promotionid;
        public String requestid;

        public Builder() {
        }

        public Builder(GetPromoReminder getPromoReminder) {
            super(getPromoReminder);
            if (getPromoReminder != null) {
                this.requestid = getPromoReminder.requestid;
                this.promotionid = getPromoReminder.promotionid;
                this.itemids = GetPromoReminder.copyOf(getPromoReminder.itemids);
            }
        }

        public Builder requestid(String str) {
            this.requestid = str;
            return this;
        }

        public Builder promotionid(Long l) {
            this.promotionid = l;
            return this;
        }

        public Builder itemids(List<Long> list) {
            this.itemids = checkForNulls(list);
            return this;
        }

        public GetPromoReminder build() {
            return new GetPromoReminder(this);
        }
    }
}
