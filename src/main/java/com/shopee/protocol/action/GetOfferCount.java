package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class GetOfferCount extends Message {
    public static final Long DEFAULT_ITEMID = 0L;
    public static final Long DEFAULT_MODELID = 0L;
    public static final Integer DEFAULT_OFFER_STATUS = 0;
    public static final String DEFAULT_REQUESTID = "";
    public static final String DEFAULT_TOKEN = "";
    public static final List<Integer> DEFAULT_USERID = Collections.emptyList();
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 5, type = Message.Datatype.INT64)
    public final Long itemid;
    @ProtoField(tag = 6, type = Message.Datatype.INT64)
    public final Long modelid;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer offer_status;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String token;
    @ProtoField(label = Message.Label.REPEATED, tag = 2, type = Message.Datatype.INT32)
    public final List<Integer> userid;

    public GetOfferCount(String str, List<Integer> list, Integer num, String str2, Long l, Long l2) {
        this.requestid = str;
        this.userid = immutableCopyOf(list);
        this.offer_status = num;
        this.token = str2;
        this.itemid = l;
        this.modelid = l2;
    }

    private GetOfferCount(Builder builder) {
        this(builder.requestid, builder.userid, builder.offer_status, builder.token, builder.itemid, builder.modelid);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof GetOfferCount)) {
            return false;
        }
        GetOfferCount getOfferCount = (GetOfferCount) obj;
        if (!equals((Object) this.requestid, (Object) getOfferCount.requestid) || !equals((List<?>) this.userid, (List<?>) getOfferCount.userid) || !equals((Object) this.offer_status, (Object) getOfferCount.offer_status) || !equals((Object) this.token, (Object) getOfferCount.token) || !equals((Object) this.itemid, (Object) getOfferCount.itemid) || !equals((Object) this.modelid, (Object) getOfferCount.modelid)) {
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
        List<Integer> list = this.userid;
        int hashCode2 = (hashCode + (list != null ? list.hashCode() : 1)) * 37;
        Integer num = this.offer_status;
        int hashCode3 = (hashCode2 + (num != null ? num.hashCode() : 0)) * 37;
        String str2 = this.token;
        int hashCode4 = (hashCode3 + (str2 != null ? str2.hashCode() : 0)) * 37;
        Long l = this.itemid;
        int hashCode5 = (hashCode4 + (l != null ? l.hashCode() : 0)) * 37;
        Long l2 = this.modelid;
        if (l2 != null) {
            i2 = l2.hashCode();
        }
        int i3 = hashCode5 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<GetOfferCount> {
        public Long itemid;
        public Long modelid;
        public Integer offer_status;
        public String requestid;
        public String token;
        public List<Integer> userid;

        public Builder() {
        }

        public Builder(GetOfferCount getOfferCount) {
            super(getOfferCount);
            if (getOfferCount != null) {
                this.requestid = getOfferCount.requestid;
                this.userid = GetOfferCount.copyOf(getOfferCount.userid);
                this.offer_status = getOfferCount.offer_status;
                this.token = getOfferCount.token;
                this.itemid = getOfferCount.itemid;
                this.modelid = getOfferCount.modelid;
            }
        }

        public Builder requestid(String str) {
            this.requestid = str;
            return this;
        }

        public Builder userid(List<Integer> list) {
            this.userid = checkForNulls(list);
            return this;
        }

        public Builder offer_status(Integer num) {
            this.offer_status = num;
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

        public Builder modelid(Long l) {
            this.modelid = l;
            return this;
        }

        public GetOfferCount build() {
            return new GetOfferCount(this);
        }
    }
}
