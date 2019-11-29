package com.shopee.protocol.ads.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class TrackingShop extends Message {
    public static final String DEFAULT_ALGORITHM = "";
    public static final String DEFAULT_JSON_DATA = "";
    public static final String DEFAULT_LIST_TYPE = "";
    public static final Integer DEFAULT_LOCATION = 0;
    public static final List<String> DEFAULT_REFER_URLS = Collections.emptyList();
    public static final Integer DEFAULT_SHOPID = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String algorithm;
    @ProtoField(tag = 7, type = Message.Datatype.STRING)
    public final String json_data;
    @ProtoField(tag = 6, type = Message.Datatype.STRING)
    public final String list_type;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer location;
    @ProtoField(tag = 2)
    public final TrackingQuery query;
    @ProtoField(label = Message.Label.REPEATED, tag = 5, type = Message.Datatype.STRING)
    public final List<String> refer_urls;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer shopid;

    public TrackingShop(Integer num, TrackingQuery trackingQuery, String str, Integer num2, List<String> list, String str2, String str3) {
        this.shopid = num;
        this.query = trackingQuery;
        this.algorithm = str;
        this.location = num2;
        this.refer_urls = immutableCopyOf(list);
        this.list_type = str2;
        this.json_data = str3;
    }

    private TrackingShop(Builder builder) {
        this(builder.shopid, builder.query, builder.algorithm, builder.location, builder.refer_urls, builder.list_type, builder.json_data);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof TrackingShop)) {
            return false;
        }
        TrackingShop trackingShop = (TrackingShop) obj;
        if (!equals((Object) this.shopid, (Object) trackingShop.shopid) || !equals((Object) this.query, (Object) trackingShop.query) || !equals((Object) this.algorithm, (Object) trackingShop.algorithm) || !equals((Object) this.location, (Object) trackingShop.location) || !equals((List<?>) this.refer_urls, (List<?>) trackingShop.refer_urls) || !equals((Object) this.list_type, (Object) trackingShop.list_type) || !equals((Object) this.json_data, (Object) trackingShop.json_data)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Integer num = this.shopid;
        int i2 = 0;
        int hashCode = (num != null ? num.hashCode() : 0) * 37;
        TrackingQuery trackingQuery = this.query;
        int hashCode2 = (hashCode + (trackingQuery != null ? trackingQuery.hashCode() : 0)) * 37;
        String str = this.algorithm;
        int hashCode3 = (hashCode2 + (str != null ? str.hashCode() : 0)) * 37;
        Integer num2 = this.location;
        int hashCode4 = (hashCode3 + (num2 != null ? num2.hashCode() : 0)) * 37;
        List<String> list = this.refer_urls;
        int hashCode5 = (hashCode4 + (list != null ? list.hashCode() : 1)) * 37;
        String str2 = this.list_type;
        int hashCode6 = (hashCode5 + (str2 != null ? str2.hashCode() : 0)) * 37;
        String str3 = this.json_data;
        if (str3 != null) {
            i2 = str3.hashCode();
        }
        int i3 = hashCode6 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<TrackingShop> {
        public String algorithm;
        public String json_data;
        public String list_type;
        public Integer location;
        public TrackingQuery query;
        public List<String> refer_urls;
        public Integer shopid;

        public Builder() {
        }

        public Builder(TrackingShop trackingShop) {
            super(trackingShop);
            if (trackingShop != null) {
                this.shopid = trackingShop.shopid;
                this.query = trackingShop.query;
                this.algorithm = trackingShop.algorithm;
                this.location = trackingShop.location;
                this.refer_urls = TrackingShop.copyOf(trackingShop.refer_urls);
                this.list_type = trackingShop.list_type;
                this.json_data = trackingShop.json_data;
            }
        }

        public Builder shopid(Integer num) {
            this.shopid = num;
            return this;
        }

        public Builder query(TrackingQuery trackingQuery) {
            this.query = trackingQuery;
            return this;
        }

        public Builder algorithm(String str) {
            this.algorithm = str;
            return this;
        }

        public Builder location(Integer num) {
            this.location = num;
            return this;
        }

        public Builder refer_urls(List<String> list) {
            this.refer_urls = checkForNulls(list);
            return this;
        }

        public Builder list_type(String str) {
            this.list_type = str;
            return this;
        }

        public Builder json_data(String str) {
            this.json_data = str;
            return this;
        }

        public TrackingShop build() {
            return new TrackingShop(this);
        }
    }
}
