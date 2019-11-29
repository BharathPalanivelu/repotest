package com.shopee.protocol.search.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class SearchDuplicateRequest extends Message {
    public static final String DEFAULT_COUNTRY = "";
    public static final String DEFAULT_IMAGE = "";
    public static final Long DEFAULT_ITEMID = 0L;
    public static final Integer DEFAULT_SHOPID = 0;
    public static final String DEFAULT_TITLE = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String Country;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String Image;
    @ProtoField(tag = 5, type = Message.Datatype.INT64)
    public final Long Itemid;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer Shopid;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String Title;

    public SearchDuplicateRequest(Integer num, String str, String str2, String str3, Long l) {
        this.Shopid = num;
        this.Title = str;
        this.Image = str2;
        this.Country = str3;
        this.Itemid = l;
    }

    private SearchDuplicateRequest(Builder builder) {
        this(builder.Shopid, builder.Title, builder.Image, builder.Country, builder.Itemid);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SearchDuplicateRequest)) {
            return false;
        }
        SearchDuplicateRequest searchDuplicateRequest = (SearchDuplicateRequest) obj;
        if (!equals((Object) this.Shopid, (Object) searchDuplicateRequest.Shopid) || !equals((Object) this.Title, (Object) searchDuplicateRequest.Title) || !equals((Object) this.Image, (Object) searchDuplicateRequest.Image) || !equals((Object) this.Country, (Object) searchDuplicateRequest.Country) || !equals((Object) this.Itemid, (Object) searchDuplicateRequest.Itemid)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Integer num = this.Shopid;
        int i2 = 0;
        int hashCode = (num != null ? num.hashCode() : 0) * 37;
        String str = this.Title;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 37;
        String str2 = this.Image;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 37;
        String str3 = this.Country;
        int hashCode4 = (hashCode3 + (str3 != null ? str3.hashCode() : 0)) * 37;
        Long l = this.Itemid;
        if (l != null) {
            i2 = l.hashCode();
        }
        int i3 = hashCode4 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<SearchDuplicateRequest> {
        public String Country;
        public String Image;
        public Long Itemid;
        public Integer Shopid;
        public String Title;

        public Builder() {
        }

        public Builder(SearchDuplicateRequest searchDuplicateRequest) {
            super(searchDuplicateRequest);
            if (searchDuplicateRequest != null) {
                this.Shopid = searchDuplicateRequest.Shopid;
                this.Title = searchDuplicateRequest.Title;
                this.Image = searchDuplicateRequest.Image;
                this.Country = searchDuplicateRequest.Country;
                this.Itemid = searchDuplicateRequest.Itemid;
            }
        }

        public Builder Shopid(Integer num) {
            this.Shopid = num;
            return this;
        }

        public Builder Title(String str) {
            this.Title = str;
            return this;
        }

        public Builder Image(String str) {
            this.Image = str;
            return this;
        }

        public Builder Country(String str) {
            this.Country = str;
            return this;
        }

        public Builder Itemid(Long l) {
            this.Itemid = l;
            return this;
        }

        public SearchDuplicateRequest build() {
            return new SearchDuplicateRequest(this);
        }
    }
}
