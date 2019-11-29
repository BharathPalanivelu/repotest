package com.shopee.protocol.action;

import com.shopee.protocol.search.action.ResponseHeader;
import com.shopee.protocol.shop.Item;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class ResponsePListLookInside extends Message {
    public static final Double DEFAULT_BOOST;
    public static final Integer DEFAULT_ERRCODE = 0;
    public static final List<PListWeightMeta> DEFAULT_META_LIST = Collections.emptyList();
    public static final Double DEFAULT_SCORE_ARRIVAL;
    public static final Double DEFAULT_SCORE_BOOST;
    public static final Double DEFAULT_SCORE_SALEHISTORY;
    public static final Double DEFAULT_SCORE_SOCIAL;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 1, type = Message.Datatype.DOUBLE)
    public final Double boost;
    @ProtoField(label = Message.Label.REQUIRED, tag = 4, type = Message.Datatype.INT32)
    public final Integer errcode;
    @ProtoField(tag = 5)
    public final ResponseHeader header;
    @ProtoField(tag = 3)
    public final Item item;
    @ProtoField(label = Message.Label.REPEATED, messageType = PListWeightMeta.class, tag = 2)
    public final List<PListWeightMeta> meta_list;
    @ProtoField(tag = 12, type = Message.Datatype.DOUBLE)
    public final Double score_arrival;
    @ProtoField(tag = 11, type = Message.Datatype.DOUBLE)
    public final Double score_boost;
    @ProtoField(tag = 14, type = Message.Datatype.DOUBLE)
    public final Double score_salehistory;
    @ProtoField(tag = 13, type = Message.Datatype.DOUBLE)
    public final Double score_social;

    static {
        Double valueOf = Double.valueOf(0.0d);
        DEFAULT_SCORE_BOOST = valueOf;
        DEFAULT_SCORE_ARRIVAL = valueOf;
        DEFAULT_SCORE_SOCIAL = valueOf;
        DEFAULT_SCORE_SALEHISTORY = valueOf;
        DEFAULT_BOOST = valueOf;
    }

    public ResponsePListLookInside(Integer num, Double d2, Double d3, Double d4, Double d5, Double d6, List<PListWeightMeta> list, Item item2, ResponseHeader responseHeader) {
        this.errcode = num;
        this.score_boost = d2;
        this.score_arrival = d3;
        this.score_social = d4;
        this.score_salehistory = d5;
        this.boost = d6;
        this.meta_list = immutableCopyOf(list);
        this.item = item2;
        this.header = responseHeader;
    }

    private ResponsePListLookInside(Builder builder) {
        this(builder.errcode, builder.score_boost, builder.score_arrival, builder.score_social, builder.score_salehistory, builder.boost, builder.meta_list, builder.item, builder.header);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ResponsePListLookInside)) {
            return false;
        }
        ResponsePListLookInside responsePListLookInside = (ResponsePListLookInside) obj;
        if (!equals((Object) this.errcode, (Object) responsePListLookInside.errcode) || !equals((Object) this.score_boost, (Object) responsePListLookInside.score_boost) || !equals((Object) this.score_arrival, (Object) responsePListLookInside.score_arrival) || !equals((Object) this.score_social, (Object) responsePListLookInside.score_social) || !equals((Object) this.score_salehistory, (Object) responsePListLookInside.score_salehistory) || !equals((Object) this.boost, (Object) responsePListLookInside.boost) || !equals((List<?>) this.meta_list, (List<?>) responsePListLookInside.meta_list) || !equals((Object) this.item, (Object) responsePListLookInside.item) || !equals((Object) this.header, (Object) responsePListLookInside.header)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Integer num = this.errcode;
        int i2 = 0;
        int hashCode = (num != null ? num.hashCode() : 0) * 37;
        Double d2 = this.score_boost;
        int hashCode2 = (hashCode + (d2 != null ? d2.hashCode() : 0)) * 37;
        Double d3 = this.score_arrival;
        int hashCode3 = (hashCode2 + (d3 != null ? d3.hashCode() : 0)) * 37;
        Double d4 = this.score_social;
        int hashCode4 = (hashCode3 + (d4 != null ? d4.hashCode() : 0)) * 37;
        Double d5 = this.score_salehistory;
        int hashCode5 = (hashCode4 + (d5 != null ? d5.hashCode() : 0)) * 37;
        Double d6 = this.boost;
        int hashCode6 = (hashCode5 + (d6 != null ? d6.hashCode() : 0)) * 37;
        List<PListWeightMeta> list = this.meta_list;
        int hashCode7 = (hashCode6 + (list != null ? list.hashCode() : 1)) * 37;
        Item item2 = this.item;
        int hashCode8 = (hashCode7 + (item2 != null ? item2.hashCode() : 0)) * 37;
        ResponseHeader responseHeader = this.header;
        if (responseHeader != null) {
            i2 = responseHeader.hashCode();
        }
        int i3 = hashCode8 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<ResponsePListLookInside> {
        public Double boost;
        public Integer errcode;
        public ResponseHeader header;
        public Item item;
        public List<PListWeightMeta> meta_list;
        public Double score_arrival;
        public Double score_boost;
        public Double score_salehistory;
        public Double score_social;

        public Builder() {
        }

        public Builder(ResponsePListLookInside responsePListLookInside) {
            super(responsePListLookInside);
            if (responsePListLookInside != null) {
                this.errcode = responsePListLookInside.errcode;
                this.score_boost = responsePListLookInside.score_boost;
                this.score_arrival = responsePListLookInside.score_arrival;
                this.score_social = responsePListLookInside.score_social;
                this.score_salehistory = responsePListLookInside.score_salehistory;
                this.boost = responsePListLookInside.boost;
                this.meta_list = ResponsePListLookInside.copyOf(responsePListLookInside.meta_list);
                this.item = responsePListLookInside.item;
                this.header = responsePListLookInside.header;
            }
        }

        public Builder errcode(Integer num) {
            this.errcode = num;
            return this;
        }

        public Builder score_boost(Double d2) {
            this.score_boost = d2;
            return this;
        }

        public Builder score_arrival(Double d2) {
            this.score_arrival = d2;
            return this;
        }

        public Builder score_social(Double d2) {
            this.score_social = d2;
            return this;
        }

        public Builder score_salehistory(Double d2) {
            this.score_salehistory = d2;
            return this;
        }

        public Builder boost(Double d2) {
            this.boost = d2;
            return this;
        }

        public Builder meta_list(List<PListWeightMeta> list) {
            this.meta_list = checkForNulls(list);
            return this;
        }

        public Builder item(Item item2) {
            this.item = item2;
            return this;
        }

        public Builder header(ResponseHeader responseHeader) {
            this.header = responseHeader;
            return this;
        }

        public ResponsePListLookInside build() {
            checkRequiredFields();
            return new ResponsePListLookInside(this);
        }
    }
}
