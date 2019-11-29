package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class GetOffer extends Message {
    public static final List<Long> DEFAULT_ITEMID = Collections.emptyList();
    public static final List<Long> DEFAULT_MODELID = Collections.emptyList();
    public static final List<Long> DEFAULT_OFFERID = Collections.emptyList();
    public static final String DEFAULT_REQUESTID = "";
    public static final Integer DEFAULT_STATUS = 0;
    public static final String DEFAULT_TOKEN = "";
    private static final long serialVersionUID = 0;
    @ProtoField(label = Message.Label.REPEATED, tag = 3, type = Message.Datatype.INT64)
    public final List<Long> itemid;
    @ProtoField(label = Message.Label.REPEATED, tag = 5, type = Message.Datatype.INT64)
    public final List<Long> modelid;
    @ProtoField(label = Message.Label.REPEATED, tag = 2, type = Message.Datatype.INT64)
    public final List<Long> offerid;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(tag = 6, type = Message.Datatype.INT32)
    public final Integer status;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String token;

    public GetOffer(String str, List<Long> list, List<Long> list2, String str2, List<Long> list3, Integer num) {
        this.requestid = str;
        this.offerid = immutableCopyOf(list);
        this.itemid = immutableCopyOf(list2);
        this.token = str2;
        this.modelid = immutableCopyOf(list3);
        this.status = num;
    }

    private GetOffer(Builder builder) {
        this(builder.requestid, builder.offerid, builder.itemid, builder.token, builder.modelid, builder.status);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof GetOffer)) {
            return false;
        }
        GetOffer getOffer = (GetOffer) obj;
        if (!equals((Object) this.requestid, (Object) getOffer.requestid) || !equals((List<?>) this.offerid, (List<?>) getOffer.offerid) || !equals((List<?>) this.itemid, (List<?>) getOffer.itemid) || !equals((Object) this.token, (Object) getOffer.token) || !equals((List<?>) this.modelid, (List<?>) getOffer.modelid) || !equals((Object) this.status, (Object) getOffer.status)) {
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
        List<Long> list = this.offerid;
        int i3 = 1;
        int hashCode2 = (hashCode + (list != null ? list.hashCode() : 1)) * 37;
        List<Long> list2 = this.itemid;
        int hashCode3 = (hashCode2 + (list2 != null ? list2.hashCode() : 1)) * 37;
        String str2 = this.token;
        int hashCode4 = (hashCode3 + (str2 != null ? str2.hashCode() : 0)) * 37;
        List<Long> list3 = this.modelid;
        if (list3 != null) {
            i3 = list3.hashCode();
        }
        int i4 = (hashCode4 + i3) * 37;
        Integer num = this.status;
        if (num != null) {
            i2 = num.hashCode();
        }
        int i5 = i4 + i2;
        this.hashCode = i5;
        return i5;
    }

    public static final class Builder extends Message.Builder<GetOffer> {
        public List<Long> itemid;
        public List<Long> modelid;
        public List<Long> offerid;
        public String requestid;
        public Integer status;
        public String token;

        public Builder() {
        }

        public Builder(GetOffer getOffer) {
            super(getOffer);
            if (getOffer != null) {
                this.requestid = getOffer.requestid;
                this.offerid = GetOffer.copyOf(getOffer.offerid);
                this.itemid = GetOffer.copyOf(getOffer.itemid);
                this.token = getOffer.token;
                this.modelid = GetOffer.copyOf(getOffer.modelid);
                this.status = getOffer.status;
            }
        }

        public Builder requestid(String str) {
            this.requestid = str;
            return this;
        }

        public Builder offerid(List<Long> list) {
            this.offerid = checkForNulls(list);
            return this;
        }

        public Builder itemid(List<Long> list) {
            this.itemid = checkForNulls(list);
            return this;
        }

        public Builder token(String str) {
            this.token = str;
            return this;
        }

        public Builder modelid(List<Long> list) {
            this.modelid = checkForNulls(list);
            return this;
        }

        public Builder status(Integer num) {
            this.status = num;
            return this;
        }

        public GetOffer build() {
            return new GetOffer(this);
        }
    }
}
