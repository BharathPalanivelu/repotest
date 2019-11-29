package com.shopee.protocol.clickmodel;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class ActTrackGenericSortType extends Message {
    public static final String DEFAULT_KEYWORD = "";
    public static final String DEFAULT_ORDER = "";
    public static final Integer DEFAULT_PAGE_TYPE = 0;
    public static final String DEFAULT_SORT_TYPE = "";
    public static final Double DEFAULT_TIMESTAMP = Double.valueOf(0.0d);
    public static final Long DEFAULT_USERID = 0L;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String keyword;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String order;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer page_type;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String sort_type;
    @ProtoField(tag = 6, type = Message.Datatype.DOUBLE)
    public final Double timestamp;
    @ProtoField(tag = 5, type = Message.Datatype.INT64)
    public final Long userid;

    public ActTrackGenericSortType(String str, Integer num, String str2, String str3, Long l, Double d2) {
        this.keyword = str;
        this.page_type = num;
        this.sort_type = str2;
        this.order = str3;
        this.userid = l;
        this.timestamp = d2;
    }

    private ActTrackGenericSortType(Builder builder) {
        this(builder.keyword, builder.page_type, builder.sort_type, builder.order, builder.userid, builder.timestamp);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ActTrackGenericSortType)) {
            return false;
        }
        ActTrackGenericSortType actTrackGenericSortType = (ActTrackGenericSortType) obj;
        if (!equals((Object) this.keyword, (Object) actTrackGenericSortType.keyword) || !equals((Object) this.page_type, (Object) actTrackGenericSortType.page_type) || !equals((Object) this.sort_type, (Object) actTrackGenericSortType.sort_type) || !equals((Object) this.order, (Object) actTrackGenericSortType.order) || !equals((Object) this.userid, (Object) actTrackGenericSortType.userid) || !equals((Object) this.timestamp, (Object) actTrackGenericSortType.timestamp)) {
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
        Integer num = this.page_type;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 37;
        String str2 = this.sort_type;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 37;
        String str3 = this.order;
        int hashCode4 = (hashCode3 + (str3 != null ? str3.hashCode() : 0)) * 37;
        Long l = this.userid;
        int hashCode5 = (hashCode4 + (l != null ? l.hashCode() : 0)) * 37;
        Double d2 = this.timestamp;
        if (d2 != null) {
            i2 = d2.hashCode();
        }
        int i3 = hashCode5 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<ActTrackGenericSortType> {
        public String keyword;
        public String order;
        public Integer page_type;
        public String sort_type;
        public Double timestamp;
        public Long userid;

        public Builder() {
        }

        public Builder(ActTrackGenericSortType actTrackGenericSortType) {
            super(actTrackGenericSortType);
            if (actTrackGenericSortType != null) {
                this.keyword = actTrackGenericSortType.keyword;
                this.page_type = actTrackGenericSortType.page_type;
                this.sort_type = actTrackGenericSortType.sort_type;
                this.order = actTrackGenericSortType.order;
                this.userid = actTrackGenericSortType.userid;
                this.timestamp = actTrackGenericSortType.timestamp;
            }
        }

        public Builder keyword(String str) {
            this.keyword = str;
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

        public Builder userid(Long l) {
            this.userid = l;
            return this;
        }

        public Builder timestamp(Double d2) {
            this.timestamp = d2;
            return this;
        }

        public ActTrackGenericSortType build() {
            return new ActTrackGenericSortType(this);
        }
    }
}
