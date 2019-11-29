package com.shopee.protocol.search.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class ResponseSearchFilter extends Message {
    public static final List<Integer> DEFAULT_BRAND_LIST = Collections.emptyList();
    public static final List<Integer> DEFAULT_SHOP_TYPE_LIST = Collections.emptyList();
    public static final Integer DEFAULT_VIDEO_FILTER = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(label = Message.Label.REPEATED, tag = 3, type = Message.Datatype.INT32)
    public final List<Integer> brand_list;
    @ProtoField(tag = 1)
    public final ResponseHeader header;
    @ProtoField(label = Message.Label.REPEATED, tag = 2, type = Message.Datatype.INT32)
    public final List<Integer> shop_type_list;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer video_filter;

    public ResponseSearchFilter(ResponseHeader responseHeader, List<Integer> list, List<Integer> list2, Integer num) {
        this.header = responseHeader;
        this.shop_type_list = immutableCopyOf(list);
        this.brand_list = immutableCopyOf(list2);
        this.video_filter = num;
    }

    private ResponseSearchFilter(Builder builder) {
        this(builder.header, builder.shop_type_list, builder.brand_list, builder.video_filter);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ResponseSearchFilter)) {
            return false;
        }
        ResponseSearchFilter responseSearchFilter = (ResponseSearchFilter) obj;
        if (!equals((Object) this.header, (Object) responseSearchFilter.header) || !equals((List<?>) this.shop_type_list, (List<?>) responseSearchFilter.shop_type_list) || !equals((List<?>) this.brand_list, (List<?>) responseSearchFilter.brand_list) || !equals((Object) this.video_filter, (Object) responseSearchFilter.video_filter)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        ResponseHeader responseHeader = this.header;
        int i2 = 0;
        int hashCode = (responseHeader != null ? responseHeader.hashCode() : 0) * 37;
        List<Integer> list = this.shop_type_list;
        int i3 = 1;
        int hashCode2 = (hashCode + (list != null ? list.hashCode() : 1)) * 37;
        List<Integer> list2 = this.brand_list;
        if (list2 != null) {
            i3 = list2.hashCode();
        }
        int i4 = (hashCode2 + i3) * 37;
        Integer num = this.video_filter;
        if (num != null) {
            i2 = num.hashCode();
        }
        int i5 = i4 + i2;
        this.hashCode = i5;
        return i5;
    }

    public static final class Builder extends Message.Builder<ResponseSearchFilter> {
        public List<Integer> brand_list;
        public ResponseHeader header;
        public List<Integer> shop_type_list;
        public Integer video_filter;

        public Builder() {
        }

        public Builder(ResponseSearchFilter responseSearchFilter) {
            super(responseSearchFilter);
            if (responseSearchFilter != null) {
                this.header = responseSearchFilter.header;
                this.shop_type_list = ResponseSearchFilter.copyOf(responseSearchFilter.shop_type_list);
                this.brand_list = ResponseSearchFilter.copyOf(responseSearchFilter.brand_list);
                this.video_filter = responseSearchFilter.video_filter;
            }
        }

        public Builder header(ResponseHeader responseHeader) {
            this.header = responseHeader;
            return this;
        }

        public Builder shop_type_list(List<Integer> list) {
            this.shop_type_list = checkForNulls(list);
            return this;
        }

        public Builder brand_list(List<Integer> list) {
            this.brand_list = checkForNulls(list);
            return this;
        }

        public Builder video_filter(Integer num) {
            this.video_filter = num;
            return this;
        }

        public ResponseSearchFilter build() {
            return new ResponseSearchFilter(this);
        }
    }
}
