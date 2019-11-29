package com.shopee.protocol.clickmodel;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class ActTrackGenericScroll extends Message {
    public static final List<ItemInfo> DEFAULT_ITEMS_INFO = Collections.emptyList();
    public static final String DEFAULT_KEYWORD = "";
    public static final String DEFAULT_ORDER = "";
    public static final Integer DEFAULT_PAGE_TYPE = 0;
    public static final String DEFAULT_SORT_TYPE = "";
    public static final List<String> DEFAULT_SUGGESTED_KEYWORDS = Collections.emptyList();
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
    @ProtoField(label = Message.Label.REPEATED, tag = 8, type = Message.Datatype.STRING)
    public final List<String> suggested_keywords;
    @ProtoField(tag = 7, type = Message.Datatype.DOUBLE)
    public final Double timestamp;
    @ProtoField(tag = 3, type = Message.Datatype.INT64)
    public final Long userid;

    public ActTrackGenericScroll(String str, List<ItemInfo> list, Long l, Integer num, String str2, String str3, Double d2, List<String> list2) {
        this.keyword = str;
        this.items_info = immutableCopyOf(list);
        this.userid = l;
        this.page_type = num;
        this.sort_type = str2;
        this.order = str3;
        this.timestamp = d2;
        this.suggested_keywords = immutableCopyOf(list2);
    }

    private ActTrackGenericScroll(Builder builder) {
        this(builder.keyword, builder.items_info, builder.userid, builder.page_type, builder.sort_type, builder.order, builder.timestamp, builder.suggested_keywords);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ActTrackGenericScroll)) {
            return false;
        }
        ActTrackGenericScroll actTrackGenericScroll = (ActTrackGenericScroll) obj;
        if (!equals((Object) this.keyword, (Object) actTrackGenericScroll.keyword) || !equals((List<?>) this.items_info, (List<?>) actTrackGenericScroll.items_info) || !equals((Object) this.userid, (Object) actTrackGenericScroll.userid) || !equals((Object) this.page_type, (Object) actTrackGenericScroll.page_type) || !equals((Object) this.sort_type, (Object) actTrackGenericScroll.sort_type) || !equals((Object) this.order, (Object) actTrackGenericScroll.order) || !equals((Object) this.timestamp, (Object) actTrackGenericScroll.timestamp) || !equals((List<?>) this.suggested_keywords, (List<?>) actTrackGenericScroll.suggested_keywords)) {
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
        int i3 = 1;
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
        int i4 = (hashCode6 + i2) * 37;
        List<String> list2 = this.suggested_keywords;
        if (list2 != null) {
            i3 = list2.hashCode();
        }
        int i5 = i4 + i3;
        this.hashCode = i5;
        return i5;
    }

    public static final class Builder extends Message.Builder<ActTrackGenericScroll> {
        public List<ItemInfo> items_info;
        public String keyword;
        public String order;
        public Integer page_type;
        public String sort_type;
        public List<String> suggested_keywords;
        public Double timestamp;
        public Long userid;

        public Builder() {
        }

        public Builder(ActTrackGenericScroll actTrackGenericScroll) {
            super(actTrackGenericScroll);
            if (actTrackGenericScroll != null) {
                this.keyword = actTrackGenericScroll.keyword;
                this.items_info = ActTrackGenericScroll.copyOf(actTrackGenericScroll.items_info);
                this.userid = actTrackGenericScroll.userid;
                this.page_type = actTrackGenericScroll.page_type;
                this.sort_type = actTrackGenericScroll.sort_type;
                this.order = actTrackGenericScroll.order;
                this.timestamp = actTrackGenericScroll.timestamp;
                this.suggested_keywords = ActTrackGenericScroll.copyOf(actTrackGenericScroll.suggested_keywords);
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

        public Builder suggested_keywords(List<String> list) {
            this.suggested_keywords = checkForNulls(list);
            return this;
        }

        public ActTrackGenericScroll build() {
            return new ActTrackGenericScroll(this);
        }
    }
}
