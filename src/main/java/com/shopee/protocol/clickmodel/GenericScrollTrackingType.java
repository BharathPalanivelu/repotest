package com.shopee.protocol.clickmodel;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class GenericScrollTrackingType extends Message {
    public static final List<ItemInfo> DEFAULT_ITEMS_INFO = Collections.emptyList();
    public static final String DEFAULT_KEYWORD = "";
    public static final String DEFAULT_ORDER = "";
    public static final Integer DEFAULT_PAGE_TYPE = 0;
    public static final String DEFAULT_SORT_TYPE = "";
    public static final Double DEFAULT_TIMESTAMP = Double.valueOf(0.0d);
    public static final Long DEFAULT_USERID = 0L;
    private static final long serialVersionUID = 0;
    @ProtoField(label = Message.Label.REPEATED, messageType = ItemInfo.class, tag = 2)
    public final List<ItemInfo> items_info;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String keyword;
    @ProtoField(tag = 6, type = Message.Datatype.STRING)
    public final String order;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer page_type;
    @ProtoField(tag = 5, type = Message.Datatype.STRING)
    public final String sort_type;
    @ProtoField(tag = 7, type = Message.Datatype.DOUBLE)
    public final Double timestamp;
    @ProtoField(tag = 3, type = Message.Datatype.INT64)
    public final Long userid;

    public GenericScrollTrackingType(String str, List<ItemInfo> list, Long l, Integer num, String str2, String str3, Double d2) {
        this.keyword = str;
        this.items_info = immutableCopyOf(list);
        this.userid = l;
        this.page_type = num;
        this.sort_type = str2;
        this.order = str3;
        this.timestamp = d2;
    }

    private GenericScrollTrackingType(Builder builder) {
        this(builder.keyword, builder.items_info, builder.userid, builder.page_type, builder.sort_type, builder.order, builder.timestamp);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof GenericScrollTrackingType)) {
            return false;
        }
        GenericScrollTrackingType genericScrollTrackingType = (GenericScrollTrackingType) obj;
        if (!equals((Object) this.keyword, (Object) genericScrollTrackingType.keyword) || !equals((List<?>) this.items_info, (List<?>) genericScrollTrackingType.items_info) || !equals((Object) this.userid, (Object) genericScrollTrackingType.userid) || !equals((Object) this.page_type, (Object) genericScrollTrackingType.page_type) || !equals((Object) this.sort_type, (Object) genericScrollTrackingType.sort_type) || !equals((Object) this.order, (Object) genericScrollTrackingType.order) || !equals((Object) this.timestamp, (Object) genericScrollTrackingType.timestamp)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        String str = this.keyword;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 37;
        List<ItemInfo> list = this.items_info;
        int hashCode2 = (hashCode + (list != null ? list.hashCode() : 1)) * 37;
        Long l = this.userid;
        int hashCode3 = (hashCode2 + (l != null ? l.hashCode() : 0)) * 37;
        Integer num = this.page_type;
        int hashCode4 = (hashCode3 + (num != null ? num.hashCode() : 0)) * 37;
        String str2 = this.sort_type;
        int hashCode5 = (hashCode4 + (str2 != null ? str2.hashCode() : 0)) * 37;
        String str3 = this.order;
        int hashCode6 = (hashCode5 + (str3 != null ? str3.hashCode() : 0)) * 37;
        Double d2 = this.timestamp;
        if (d2 != null) {
            i2 = d2.hashCode();
        }
        int i3 = hashCode6 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<GenericScrollTrackingType> {
        public List<ItemInfo> items_info;
        public String keyword;
        public String order;
        public Integer page_type;
        public String sort_type;
        public Double timestamp;
        public Long userid;

        public Builder() {
        }

        public Builder(GenericScrollTrackingType genericScrollTrackingType) {
            super(genericScrollTrackingType);
            if (genericScrollTrackingType != null) {
                this.keyword = genericScrollTrackingType.keyword;
                this.items_info = GenericScrollTrackingType.copyOf(genericScrollTrackingType.items_info);
                this.userid = genericScrollTrackingType.userid;
                this.page_type = genericScrollTrackingType.page_type;
                this.sort_type = genericScrollTrackingType.sort_type;
                this.order = genericScrollTrackingType.order;
                this.timestamp = genericScrollTrackingType.timestamp;
            }
        }

        public Builder keyword(String str) {
            this.keyword = str;
            return this;
        }

        public Builder items_info(List<ItemInfo> list) {
            this.items_info = checkForNulls(list);
            return this;
        }

        public Builder userid(Long l) {
            this.userid = l;
            return this;
        }

        public Builder page_type(Integer num) {
            this.page_type = num;
            return this;
        }

        public Builder sort_type(String str) {
            this.sort_type = str;
            return this;
        }

        public Builder order(String str) {
            this.order = str;
            return this;
        }

        public Builder timestamp(Double d2) {
            this.timestamp = d2;
            return this;
        }

        public GenericScrollTrackingType build() {
            return new GenericScrollTrackingType(this);
        }
    }
}
