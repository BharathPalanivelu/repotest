package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class GetBrandSaleMeta extends Message {
    public static final List<Integer> DEFAULT_BRANDIDS = Collections.emptyList();
    public static final String DEFAULT_COUNTRY = "";
    public static final Integer DEFAULT_LIMIT = 0;
    public static final Integer DEFAULT_OFFSET = 0;
    public static final String DEFAULT_REQUESTID = "";
    public static final List<Integer> DEFAULT_SHOPIDS = Collections.emptyList();
    private static final long serialVersionUID = 0;
    @ProtoField(label = Message.Label.REPEATED, tag = 5, type = Message.Datatype.INT32)
    public final List<Integer> brandids;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String country;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer limit;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer offset;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(label = Message.Label.REPEATED, tag = 6, type = Message.Datatype.INT32)
    public final List<Integer> shopids;

    public GetBrandSaleMeta(String str, String str2, Integer num, Integer num2, List<Integer> list, List<Integer> list2) {
        this.requestid = str;
        this.country = str2;
        this.offset = num;
        this.limit = num2;
        this.brandids = immutableCopyOf(list);
        this.shopids = immutableCopyOf(list2);
    }

    private GetBrandSaleMeta(Builder builder) {
        this(builder.requestid, builder.country, builder.offset, builder.limit, builder.brandids, builder.shopids);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof GetBrandSaleMeta)) {
            return false;
        }
        GetBrandSaleMeta getBrandSaleMeta = (GetBrandSaleMeta) obj;
        if (!equals((Object) this.requestid, (Object) getBrandSaleMeta.requestid) || !equals((Object) this.country, (Object) getBrandSaleMeta.country) || !equals((Object) this.offset, (Object) getBrandSaleMeta.offset) || !equals((Object) this.limit, (Object) getBrandSaleMeta.limit) || !equals((List<?>) this.brandids, (List<?>) getBrandSaleMeta.brandids) || !equals((List<?>) this.shopids, (List<?>) getBrandSaleMeta.shopids)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        String str = this.requestid;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 37;
        String str2 = this.country;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 37;
        Integer num = this.offset;
        int hashCode3 = (hashCode2 + (num != null ? num.hashCode() : 0)) * 37;
        Integer num2 = this.limit;
        if (num2 != null) {
            i2 = num2.hashCode();
        }
        int i3 = (hashCode3 + i2) * 37;
        List<Integer> list = this.brandids;
        int i4 = 1;
        int hashCode4 = (i3 + (list != null ? list.hashCode() : 1)) * 37;
        List<Integer> list2 = this.shopids;
        if (list2 != null) {
            i4 = list2.hashCode();
        }
        int i5 = hashCode4 + i4;
        this.hashCode = i5;
        return i5;
    }

    public static final class Builder extends Message.Builder<GetBrandSaleMeta> {
        public List<Integer> brandids;
        public String country;
        public Integer limit;
        public Integer offset;
        public String requestid;
        public List<Integer> shopids;

        public Builder() {
        }

        public Builder(GetBrandSaleMeta getBrandSaleMeta) {
            super(getBrandSaleMeta);
            if (getBrandSaleMeta != null) {
                this.requestid = getBrandSaleMeta.requestid;
                this.country = getBrandSaleMeta.country;
                this.offset = getBrandSaleMeta.offset;
                this.limit = getBrandSaleMeta.limit;
                this.brandids = GetBrandSaleMeta.copyOf(getBrandSaleMeta.brandids);
                this.shopids = GetBrandSaleMeta.copyOf(getBrandSaleMeta.shopids);
            }
        }

        public Builder requestid(String str) {
            this.requestid = str;
            return this;
        }

        public Builder country(String str) {
            this.country = str;
            return this;
        }

        public Builder offset(Integer num) {
            this.offset = num;
            return this;
        }

        public Builder limit(Integer num) {
            this.limit = num;
            return this;
        }

        public Builder brandids(List<Integer> list) {
            this.brandids = checkForNulls(list);
            return this;
        }

        public Builder shopids(List<Integer> list) {
            this.shopids = checkForNulls(list);
            return this;
        }

        public GetBrandSaleMeta build() {
            return new GetBrandSaleMeta(this);
        }
    }
}
