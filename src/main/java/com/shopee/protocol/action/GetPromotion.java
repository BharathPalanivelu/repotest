package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class GetPromotion extends Message {
    public static final Boolean DEFAULT_NO_RULE = false;
    public static final Long DEFAULT_PROMOTIONID = 0L;
    public static final List<Long> DEFAULT_PROMOTIONIDS = Collections.emptyList();
    public static final String DEFAULT_REQUESTID = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 4, type = Message.Datatype.BOOL)
    public final Boolean no_rule;
    @ProtoField(tag = 2, type = Message.Datatype.INT64)
    public final Long promotionid;
    @ProtoField(label = Message.Label.REPEATED, tag = 3, type = Message.Datatype.INT64)
    public final List<Long> promotionids;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;

    public GetPromotion(String str, Long l, List<Long> list, Boolean bool) {
        this.requestid = str;
        this.promotionid = l;
        this.promotionids = immutableCopyOf(list);
        this.no_rule = bool;
    }

    private GetPromotion(Builder builder) {
        this(builder.requestid, builder.promotionid, builder.promotionids, builder.no_rule);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof GetPromotion)) {
            return false;
        }
        GetPromotion getPromotion = (GetPromotion) obj;
        if (!equals((Object) this.requestid, (Object) getPromotion.requestid) || !equals((Object) this.promotionid, (Object) getPromotion.promotionid) || !equals((List<?>) this.promotionids, (List<?>) getPromotion.promotionids) || !equals((Object) this.no_rule, (Object) getPromotion.no_rule)) {
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
        int hashCode2 = (hashCode + (l != null ? l.hashCode() : 0)) * 37;
        List<Long> list = this.promotionids;
        int hashCode3 = (hashCode2 + (list != null ? list.hashCode() : 1)) * 37;
        Boolean bool = this.no_rule;
        if (bool != null) {
            i2 = bool.hashCode();
        }
        int i3 = hashCode3 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<GetPromotion> {
        public Boolean no_rule;
        public Long promotionid;
        public List<Long> promotionids;
        public String requestid;

        public Builder() {
        }

        public Builder(GetPromotion getPromotion) {
            super(getPromotion);
            if (getPromotion != null) {
                this.requestid = getPromotion.requestid;
                this.promotionid = getPromotion.promotionid;
                this.promotionids = GetPromotion.copyOf(getPromotion.promotionids);
                this.no_rule = getPromotion.no_rule;
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

        public Builder promotionids(List<Long> list) {
            this.promotionids = checkForNulls(list);
            return this;
        }

        public Builder no_rule(Boolean bool) {
            this.no_rule = bool;
            return this;
        }

        public GetPromotion build() {
            return new GetPromotion(this);
        }
    }
}
