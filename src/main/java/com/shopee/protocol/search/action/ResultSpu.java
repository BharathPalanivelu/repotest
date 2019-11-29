package com.shopee.protocol.search.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class ResultSpu extends Message {
    public static final List<ResultAttribute> DEFAULT_ATTRIBUTE = Collections.emptyList();
    public static final Long DEFAULT_AVERAGE_PRICE = 0L;
    public static final List<Integer> DEFAULT_CATIDS = Collections.emptyList();
    public static final String DEFAULT_COVER_IMG = "";
    public static final List<LanguageSpuDataAlias> DEFAULT_DATA_ALIAS = Collections.emptyList();
    public static final Integer DEFAULT_LABEL = 0;
    public static final Long DEFAULT_NUM_OF_SELLER = 0L;
    public static final String DEFAULT_SELLING_POINT = "";
    public static final Long DEFAULT_SOLD_COUNT = 0L;
    public static final Long DEFAULT_SPU_ID = 0L;
    public static final String DEFAULT_SPU_NAME = "";
    private static final long serialVersionUID = 0;
    @ProtoField(label = Message.Label.REPEATED, messageType = ResultAttribute.class, tag = 10)
    public final List<ResultAttribute> attribute;
    @ProtoField(tag = 7, type = Message.Datatype.INT64)
    public final Long average_price;
    @ProtoField(label = Message.Label.REPEATED, tag = 3, type = Message.Datatype.INT32)
    public final List<Integer> catids;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String cover_img;
    @ProtoField(label = Message.Label.REPEATED, messageType = LanguageSpuDataAlias.class, tag = 11)
    public final List<LanguageSpuDataAlias> data_alias;
    @ProtoField(tag = 5, type = Message.Datatype.INT32)
    public final Integer label;
    @ProtoField(tag = 9, type = Message.Datatype.INT64)
    public final Long num_of_seller;
    @ProtoField(tag = 6, type = Message.Datatype.STRING)
    public final String selling_point;
    @ProtoField(tag = 8, type = Message.Datatype.INT64)
    public final Long sold_count;
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long spu_id;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String spu_name;

    public ResultSpu(Long l, String str, List<Integer> list, String str2, Integer num, String str3, Long l2, Long l3, Long l4, List<ResultAttribute> list2, List<LanguageSpuDataAlias> list3) {
        this.spu_id = l;
        this.spu_name = str;
        this.catids = immutableCopyOf(list);
        this.cover_img = str2;
        this.label = num;
        this.selling_point = str3;
        this.average_price = l2;
        this.sold_count = l3;
        this.num_of_seller = l4;
        this.attribute = immutableCopyOf(list2);
        this.data_alias = immutableCopyOf(list3);
    }

    private ResultSpu(Builder builder) {
        this(builder.spu_id, builder.spu_name, builder.catids, builder.cover_img, builder.label, builder.selling_point, builder.average_price, builder.sold_count, builder.num_of_seller, builder.attribute, builder.data_alias);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ResultSpu)) {
            return false;
        }
        ResultSpu resultSpu = (ResultSpu) obj;
        if (!equals((Object) this.spu_id, (Object) resultSpu.spu_id) || !equals((Object) this.spu_name, (Object) resultSpu.spu_name) || !equals((List<?>) this.catids, (List<?>) resultSpu.catids) || !equals((Object) this.cover_img, (Object) resultSpu.cover_img) || !equals((Object) this.label, (Object) resultSpu.label) || !equals((Object) this.selling_point, (Object) resultSpu.selling_point) || !equals((Object) this.average_price, (Object) resultSpu.average_price) || !equals((Object) this.sold_count, (Object) resultSpu.sold_count) || !equals((Object) this.num_of_seller, (Object) resultSpu.num_of_seller) || !equals((List<?>) this.attribute, (List<?>) resultSpu.attribute) || !equals((List<?>) this.data_alias, (List<?>) resultSpu.data_alias)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Long l = this.spu_id;
        int i2 = 0;
        int hashCode = (l != null ? l.hashCode() : 0) * 37;
        String str = this.spu_name;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 37;
        List<Integer> list = this.catids;
        int i3 = 1;
        int hashCode3 = (hashCode2 + (list != null ? list.hashCode() : 1)) * 37;
        String str2 = this.cover_img;
        int hashCode4 = (hashCode3 + (str2 != null ? str2.hashCode() : 0)) * 37;
        Integer num = this.label;
        int hashCode5 = (hashCode4 + (num != null ? num.hashCode() : 0)) * 37;
        String str3 = this.selling_point;
        int hashCode6 = (hashCode5 + (str3 != null ? str3.hashCode() : 0)) * 37;
        Long l2 = this.average_price;
        int hashCode7 = (hashCode6 + (l2 != null ? l2.hashCode() : 0)) * 37;
        Long l3 = this.sold_count;
        int hashCode8 = (hashCode7 + (l3 != null ? l3.hashCode() : 0)) * 37;
        Long l4 = this.num_of_seller;
        if (l4 != null) {
            i2 = l4.hashCode();
        }
        int i4 = (hashCode8 + i2) * 37;
        List<ResultAttribute> list2 = this.attribute;
        int hashCode9 = (i4 + (list2 != null ? list2.hashCode() : 1)) * 37;
        List<LanguageSpuDataAlias> list3 = this.data_alias;
        if (list3 != null) {
            i3 = list3.hashCode();
        }
        int i5 = hashCode9 + i3;
        this.hashCode = i5;
        return i5;
    }

    public static final class Builder extends Message.Builder<ResultSpu> {
        public List<ResultAttribute> attribute;
        public Long average_price;
        public List<Integer> catids;
        public String cover_img;
        public List<LanguageSpuDataAlias> data_alias;
        public Integer label;
        public Long num_of_seller;
        public String selling_point;
        public Long sold_count;
        public Long spu_id;
        public String spu_name;

        public Builder() {
        }

        public Builder(ResultSpu resultSpu) {
            super(resultSpu);
            if (resultSpu != null) {
                this.spu_id = resultSpu.spu_id;
                this.spu_name = resultSpu.spu_name;
                this.catids = ResultSpu.copyOf(resultSpu.catids);
                this.cover_img = resultSpu.cover_img;
                this.label = resultSpu.label;
                this.selling_point = resultSpu.selling_point;
                this.average_price = resultSpu.average_price;
                this.sold_count = resultSpu.sold_count;
                this.num_of_seller = resultSpu.num_of_seller;
                this.attribute = ResultSpu.copyOf(resultSpu.attribute);
                this.data_alias = ResultSpu.copyOf(resultSpu.data_alias);
            }
        }

        public Builder spu_id(Long l) {
            this.spu_id = l;
            return this;
        }

        public Builder spu_name(String str) {
            this.spu_name = str;
            return this;
        }

        public Builder catids(List<Integer> list) {
            this.catids = checkForNulls(list);
            return this;
        }

        public Builder cover_img(String str) {
            this.cover_img = str;
            return this;
        }

        public Builder label(Integer num) {
            this.label = num;
            return this;
        }

        public Builder selling_point(String str) {
            this.selling_point = str;
            return this;
        }

        public Builder average_price(Long l) {
            this.average_price = l;
            return this;
        }

        public Builder sold_count(Long l) {
            this.sold_count = l;
            return this;
        }

        public Builder num_of_seller(Long l) {
            this.num_of_seller = l;
            return this;
        }

        public Builder attribute(List<ResultAttribute> list) {
            this.attribute = checkForNulls(list);
            return this;
        }

        public Builder data_alias(List<LanguageSpuDataAlias> list) {
            this.data_alias = checkForNulls(list);
            return this;
        }

        public ResultSpu build() {
            return new ResultSpu(this);
        }
    }
}
