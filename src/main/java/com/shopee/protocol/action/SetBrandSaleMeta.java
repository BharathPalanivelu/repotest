package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class SetBrandSaleMeta extends Message {
    public static final String DEFAULT_COUNTRY = "";
    public static final List<BrandSaleMetaRequest> DEFAULT_METAS = Collections.emptyList();
    public static final String DEFAULT_REQUESTID = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String country;
    @ProtoField(label = Message.Label.REPEATED, messageType = BrandSaleMetaRequest.class, tag = 3)
    public final List<BrandSaleMetaRequest> metas;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;

    public SetBrandSaleMeta(String str, String str2, List<BrandSaleMetaRequest> list) {
        this.requestid = str;
        this.country = str2;
        this.metas = immutableCopyOf(list);
    }

    private SetBrandSaleMeta(Builder builder) {
        this(builder.requestid, builder.country, builder.metas);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SetBrandSaleMeta)) {
            return false;
        }
        SetBrandSaleMeta setBrandSaleMeta = (SetBrandSaleMeta) obj;
        if (!equals((Object) this.requestid, (Object) setBrandSaleMeta.requestid) || !equals((Object) this.country, (Object) setBrandSaleMeta.country) || !equals((List<?>) this.metas, (List<?>) setBrandSaleMeta.metas)) {
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
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        int i3 = (hashCode + i2) * 37;
        List<BrandSaleMetaRequest> list = this.metas;
        int hashCode2 = i3 + (list != null ? list.hashCode() : 1);
        this.hashCode = hashCode2;
        return hashCode2;
    }

    public static final class Builder extends Message.Builder<SetBrandSaleMeta> {
        public String country;
        public List<BrandSaleMetaRequest> metas;
        public String requestid;

        public Builder() {
        }

        public Builder(SetBrandSaleMeta setBrandSaleMeta) {
            super(setBrandSaleMeta);
            if (setBrandSaleMeta != null) {
                this.requestid = setBrandSaleMeta.requestid;
                this.country = setBrandSaleMeta.country;
                this.metas = SetBrandSaleMeta.copyOf(setBrandSaleMeta.metas);
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

        public Builder metas(List<BrandSaleMetaRequest> list) {
            this.metas = checkForNulls(list);
            return this;
        }

        public SetBrandSaleMeta build() {
            return new SetBrandSaleMeta(this);
        }
    }
}
