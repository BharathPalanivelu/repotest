package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class SearchCondition extends Message {
    public static final List<Integer> DEFAULT_FILTER_ITEM_CONDITION = Collections.emptyList();
    public static final String DEFAULT_FILTER_PAYMENT = "";
    public static final Long DEFAULT_FILTER_PRICE_MAX = 0L;
    public static final Long DEFAULT_FILTER_PRICE_MIN = 0L;
    public static final String DEFAULT_FILTER_SHIPMENT = "";
    public static final Boolean DEFAULT_GET_ALL_ITEMS = false;
    public static final Double DEFAULT_LATITUDE;
    public static final Double DEFAULT_LONGITUDE;
    public static final String DEFAULT_SPECIFIC_FILED = "";
    private static final long serialVersionUID = 0;
    @ProtoField(label = Message.Label.REPEATED, tag = 7, type = Message.Datatype.INT32)
    public final List<Integer> filter_item_condition;
    @ProtoField(tag = 6, type = Message.Datatype.STRING)
    public final String filter_payment;
    @ProtoField(tag = 4, type = Message.Datatype.UINT64)
    public final Long filter_price_max;
    @ProtoField(tag = 3, type = Message.Datatype.UINT64)
    public final Long filter_price_min;
    @ProtoField(tag = 5, type = Message.Datatype.STRING)
    public final String filter_shipment;
    @ProtoField(tag = 8, type = Message.Datatype.BOOL)
    public final Boolean get_all_items;
    @ProtoField(tag = 1, type = Message.Datatype.DOUBLE)
    public final Double latitude;
    @ProtoField(tag = 2, type = Message.Datatype.DOUBLE)
    public final Double longitude;
    @ProtoField(tag = 9, type = Message.Datatype.STRING)
    public final String specific_filed;

    static {
        Double valueOf = Double.valueOf(0.0d);
        DEFAULT_LATITUDE = valueOf;
        DEFAULT_LONGITUDE = valueOf;
    }

    public SearchCondition(Double d2, Double d3, Long l, Long l2, String str, String str2, List<Integer> list, Boolean bool, String str3) {
        this.latitude = d2;
        this.longitude = d3;
        this.filter_price_min = l;
        this.filter_price_max = l2;
        this.filter_shipment = str;
        this.filter_payment = str2;
        this.filter_item_condition = immutableCopyOf(list);
        this.get_all_items = bool;
        this.specific_filed = str3;
    }

    private SearchCondition(Builder builder) {
        this(builder.latitude, builder.longitude, builder.filter_price_min, builder.filter_price_max, builder.filter_shipment, builder.filter_payment, builder.filter_item_condition, builder.get_all_items, builder.specific_filed);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SearchCondition)) {
            return false;
        }
        SearchCondition searchCondition = (SearchCondition) obj;
        if (!equals((Object) this.latitude, (Object) searchCondition.latitude) || !equals((Object) this.longitude, (Object) searchCondition.longitude) || !equals((Object) this.filter_price_min, (Object) searchCondition.filter_price_min) || !equals((Object) this.filter_price_max, (Object) searchCondition.filter_price_max) || !equals((Object) this.filter_shipment, (Object) searchCondition.filter_shipment) || !equals((Object) this.filter_payment, (Object) searchCondition.filter_payment) || !equals((List<?>) this.filter_item_condition, (List<?>) searchCondition.filter_item_condition) || !equals((Object) this.get_all_items, (Object) searchCondition.get_all_items) || !equals((Object) this.specific_filed, (Object) searchCondition.specific_filed)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Double d2 = this.latitude;
        int i2 = 0;
        int hashCode = (d2 != null ? d2.hashCode() : 0) * 37;
        Double d3 = this.longitude;
        int hashCode2 = (hashCode + (d3 != null ? d3.hashCode() : 0)) * 37;
        Long l = this.filter_price_min;
        int hashCode3 = (hashCode2 + (l != null ? l.hashCode() : 0)) * 37;
        Long l2 = this.filter_price_max;
        int hashCode4 = (hashCode3 + (l2 != null ? l2.hashCode() : 0)) * 37;
        String str = this.filter_shipment;
        int hashCode5 = (hashCode4 + (str != null ? str.hashCode() : 0)) * 37;
        String str2 = this.filter_payment;
        int hashCode6 = (hashCode5 + (str2 != null ? str2.hashCode() : 0)) * 37;
        List<Integer> list = this.filter_item_condition;
        int hashCode7 = (hashCode6 + (list != null ? list.hashCode() : 1)) * 37;
        Boolean bool = this.get_all_items;
        int hashCode8 = (hashCode7 + (bool != null ? bool.hashCode() : 0)) * 37;
        String str3 = this.specific_filed;
        if (str3 != null) {
            i2 = str3.hashCode();
        }
        int i3 = hashCode8 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<SearchCondition> {
        public List<Integer> filter_item_condition;
        public String filter_payment;
        public Long filter_price_max;
        public Long filter_price_min;
        public String filter_shipment;
        public Boolean get_all_items;
        public Double latitude;
        public Double longitude;
        public String specific_filed;

        public Builder() {
        }

        public Builder(SearchCondition searchCondition) {
            super(searchCondition);
            if (searchCondition != null) {
                this.latitude = searchCondition.latitude;
                this.longitude = searchCondition.longitude;
                this.filter_price_min = searchCondition.filter_price_min;
                this.filter_price_max = searchCondition.filter_price_max;
                this.filter_shipment = searchCondition.filter_shipment;
                this.filter_payment = searchCondition.filter_payment;
                this.filter_item_condition = SearchCondition.copyOf(searchCondition.filter_item_condition);
                this.get_all_items = searchCondition.get_all_items;
                this.specific_filed = searchCondition.specific_filed;
            }
        }

        public Builder latitude(Double d2) {
            this.latitude = d2;
            return this;
        }

        public Builder longitude(Double d2) {
            this.longitude = d2;
            return this;
        }

        public Builder filter_price_min(Long l) {
            this.filter_price_min = l;
            return this;
        }

        public Builder filter_price_max(Long l) {
            this.filter_price_max = l;
            return this;
        }

        public Builder filter_shipment(String str) {
            this.filter_shipment = str;
            return this;
        }

        public Builder filter_payment(String str) {
            this.filter_payment = str;
            return this;
        }

        public Builder filter_item_condition(List<Integer> list) {
            this.filter_item_condition = checkForNulls(list);
            return this;
        }

        public Builder get_all_items(Boolean bool) {
            this.get_all_items = bool;
            return this;
        }

        public Builder specific_filed(String str) {
            this.specific_filed = str;
            return this;
        }

        public SearchCondition build() {
            return new SearchCondition(this);
        }
    }
}
