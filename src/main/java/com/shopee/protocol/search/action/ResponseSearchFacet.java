package com.shopee.protocol.search.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class ResponseSearchFacet extends Message {
    public static final List<Integer> DEFAULT_BE_CATEIDS = Collections.emptyList();
    public static final List<CategoryFacet> DEFAULT_CATEGORY_FACET = Collections.emptyList();
    public static final List<LocationFacet> DEFAULT_LOCATION_FACET = Collections.emptyList();
    public static final List<PriceRange> DEFAULT_PRICE_RANGES = Collections.emptyList();
    private static final long serialVersionUID = 0;
    @ProtoField(label = Message.Label.REPEATED, tag = 5, type = Message.Datatype.INT32)
    public final List<Integer> be_cateids;
    @ProtoField(label = Message.Label.REPEATED, messageType = CategoryFacet.class, tag = 2)
    public final List<CategoryFacet> category_facet;
    @ProtoField(tag = 1)
    public final ResponseHeader header;
    @ProtoField(label = Message.Label.REPEATED, messageType = LocationFacet.class, tag = 4)
    public final List<LocationFacet> location_facet;
    @ProtoField(label = Message.Label.REPEATED, messageType = PriceRange.class, tag = 3)
    public final List<PriceRange> price_ranges;

    public ResponseSearchFacet(ResponseHeader responseHeader, List<CategoryFacet> list, List<PriceRange> list2, List<LocationFacet> list3, List<Integer> list4) {
        this.header = responseHeader;
        this.category_facet = immutableCopyOf(list);
        this.price_ranges = immutableCopyOf(list2);
        this.location_facet = immutableCopyOf(list3);
        this.be_cateids = immutableCopyOf(list4);
    }

    private ResponseSearchFacet(Builder builder) {
        this(builder.header, builder.category_facet, builder.price_ranges, builder.location_facet, builder.be_cateids);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ResponseSearchFacet)) {
            return false;
        }
        ResponseSearchFacet responseSearchFacet = (ResponseSearchFacet) obj;
        if (!equals((Object) this.header, (Object) responseSearchFacet.header) || !equals((List<?>) this.category_facet, (List<?>) responseSearchFacet.category_facet) || !equals((List<?>) this.price_ranges, (List<?>) responseSearchFacet.price_ranges) || !equals((List<?>) this.location_facet, (List<?>) responseSearchFacet.location_facet) || !equals((List<?>) this.be_cateids, (List<?>) responseSearchFacet.be_cateids)) {
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
        int hashCode = (responseHeader != null ? responseHeader.hashCode() : 0) * 37;
        List<CategoryFacet> list = this.category_facet;
        int i2 = 1;
        int hashCode2 = (hashCode + (list != null ? list.hashCode() : 1)) * 37;
        List<PriceRange> list2 = this.price_ranges;
        int hashCode3 = (hashCode2 + (list2 != null ? list2.hashCode() : 1)) * 37;
        List<LocationFacet> list3 = this.location_facet;
        int hashCode4 = (hashCode3 + (list3 != null ? list3.hashCode() : 1)) * 37;
        List<Integer> list4 = this.be_cateids;
        if (list4 != null) {
            i2 = list4.hashCode();
        }
        int i3 = hashCode4 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<ResponseSearchFacet> {
        public List<Integer> be_cateids;
        public List<CategoryFacet> category_facet;
        public ResponseHeader header;
        public List<LocationFacet> location_facet;
        public List<PriceRange> price_ranges;

        public Builder() {
        }

        public Builder(ResponseSearchFacet responseSearchFacet) {
            super(responseSearchFacet);
            if (responseSearchFacet != null) {
                this.header = responseSearchFacet.header;
                this.category_facet = ResponseSearchFacet.copyOf(responseSearchFacet.category_facet);
                this.price_ranges = ResponseSearchFacet.copyOf(responseSearchFacet.price_ranges);
                this.location_facet = ResponseSearchFacet.copyOf(responseSearchFacet.location_facet);
                this.be_cateids = ResponseSearchFacet.copyOf(responseSearchFacet.be_cateids);
            }
        }

        public Builder header(ResponseHeader responseHeader) {
            this.header = responseHeader;
            return this;
        }

        public Builder category_facet(List<CategoryFacet> list) {
            this.category_facet = checkForNulls(list);
            return this;
        }

        public Builder price_ranges(List<PriceRange> list) {
            this.price_ranges = checkForNulls(list);
            return this;
        }

        public Builder location_facet(List<LocationFacet> list) {
            this.location_facet = checkForNulls(list);
            return this;
        }

        public Builder be_cateids(List<Integer> list) {
            this.be_cateids = checkForNulls(list);
            return this;
        }

        public ResponseSearchFacet build() {
            return new ResponseSearchFacet(this);
        }
    }
}
