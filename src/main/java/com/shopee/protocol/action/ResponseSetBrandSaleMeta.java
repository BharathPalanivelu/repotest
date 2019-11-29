package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class ResponseSetBrandSaleMeta extends Message {
    public static final Integer DEFAULT_ERRCODE = 0;
    public static final String DEFAULT_ERR_MESSAGE = "";
    public static final List<BrandSaleMetaResponse> DEFAULT_METAS = Collections.emptyList();
    public static final String DEFAULT_REQUESTID = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String err_message;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer errcode;
    @ProtoField(label = Message.Label.REPEATED, messageType = BrandSaleMetaResponse.class, tag = 4)
    public final List<BrandSaleMetaResponse> metas;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;

    public ResponseSetBrandSaleMeta(String str, Integer num, String str2, List<BrandSaleMetaResponse> list) {
        this.requestid = str;
        this.errcode = num;
        this.err_message = str2;
        this.metas = immutableCopyOf(list);
    }

    private ResponseSetBrandSaleMeta(Builder builder) {
        this(builder.requestid, builder.errcode, builder.err_message, builder.metas);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ResponseSetBrandSaleMeta)) {
            return false;
        }
        ResponseSetBrandSaleMeta responseSetBrandSaleMeta = (ResponseSetBrandSaleMeta) obj;
        if (!equals((Object) this.requestid, (Object) responseSetBrandSaleMeta.requestid) || !equals((Object) this.errcode, (Object) responseSetBrandSaleMeta.errcode) || !equals((Object) this.err_message, (Object) responseSetBrandSaleMeta.err_message) || !equals((List<?>) this.metas, (List<?>) responseSetBrandSaleMeta.metas)) {
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
        Integer num = this.errcode;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 37;
        String str2 = this.err_message;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        int i3 = (hashCode2 + i2) * 37;
        List<BrandSaleMetaResponse> list = this.metas;
        int hashCode3 = i3 + (list != null ? list.hashCode() : 1);
        this.hashCode = hashCode3;
        return hashCode3;
    }

    public static final class Builder extends Message.Builder<ResponseSetBrandSaleMeta> {
        public String err_message;
        public Integer errcode;
        public List<BrandSaleMetaResponse> metas;
        public String requestid;

        public Builder() {
        }

        public Builder(ResponseSetBrandSaleMeta responseSetBrandSaleMeta) {
            super(responseSetBrandSaleMeta);
            if (responseSetBrandSaleMeta != null) {
                this.requestid = responseSetBrandSaleMeta.requestid;
                this.errcode = responseSetBrandSaleMeta.errcode;
                this.err_message = responseSetBrandSaleMeta.err_message;
                this.metas = ResponseSetBrandSaleMeta.copyOf(responseSetBrandSaleMeta.metas);
            }
        }

        public Builder requestid(String str) {
            this.requestid = str;
            return this;
        }

        public Builder errcode(Integer num) {
            this.errcode = num;
            return this;
        }

        public Builder err_message(String str) {
            this.err_message = str;
            return this;
        }

        public Builder metas(List<BrandSaleMetaResponse> list) {
            this.metas = checkForNulls(list);
            return this;
        }

        public ResponseSetBrandSaleMeta build() {
            return new ResponseSetBrandSaleMeta(this);
        }
    }
}
