package com.shopee.protocol.action;

import com.shopee.protocol.shop.FlashSale;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class ResponseFlashSale extends Message {
    public static final List<FlashSaleBrief> DEFAULT_BRIEF_LIST = Collections.emptyList();
    public static final Integer DEFAULT_ERRCODE = 0;
    public static final List<FlashSale> DEFAULT_FLASH_SALE_LIST = Collections.emptyList();
    public static final List<BrandSaleMetaResponse> DEFAULT_METAS = Collections.emptyList();
    public static final String DEFAULT_REQUESTID = "";
    private static final long serialVersionUID = 0;
    @ProtoField(label = Message.Label.REPEATED, messageType = FlashSaleBrief.class, tag = 4)
    public final List<FlashSaleBrief> brief_list;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer errcode;
    @ProtoField(label = Message.Label.REPEATED, messageType = FlashSale.class, tag = 3)
    public final List<FlashSale> flash_sale_list;
    @ProtoField(label = Message.Label.REPEATED, messageType = BrandSaleMetaResponse.class, tag = 5)
    public final List<BrandSaleMetaResponse> metas;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;

    public ResponseFlashSale(String str, Integer num, List<FlashSale> list, List<FlashSaleBrief> list2, List<BrandSaleMetaResponse> list3) {
        this.requestid = str;
        this.errcode = num;
        this.flash_sale_list = immutableCopyOf(list);
        this.brief_list = immutableCopyOf(list2);
        this.metas = immutableCopyOf(list3);
    }

    private ResponseFlashSale(Builder builder) {
        this(builder.requestid, builder.errcode, builder.flash_sale_list, builder.brief_list, builder.metas);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ResponseFlashSale)) {
            return false;
        }
        ResponseFlashSale responseFlashSale = (ResponseFlashSale) obj;
        if (!equals((Object) this.requestid, (Object) responseFlashSale.requestid) || !equals((Object) this.errcode, (Object) responseFlashSale.errcode) || !equals((List<?>) this.flash_sale_list, (List<?>) responseFlashSale.flash_sale_list) || !equals((List<?>) this.brief_list, (List<?>) responseFlashSale.brief_list) || !equals((List<?>) this.metas, (List<?>) responseFlashSale.metas)) {
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
        if (num != null) {
            i2 = num.hashCode();
        }
        int i3 = (hashCode + i2) * 37;
        List<FlashSale> list = this.flash_sale_list;
        int i4 = 1;
        int hashCode2 = (i3 + (list != null ? list.hashCode() : 1)) * 37;
        List<FlashSaleBrief> list2 = this.brief_list;
        int hashCode3 = (hashCode2 + (list2 != null ? list2.hashCode() : 1)) * 37;
        List<BrandSaleMetaResponse> list3 = this.metas;
        if (list3 != null) {
            i4 = list3.hashCode();
        }
        int i5 = hashCode3 + i4;
        this.hashCode = i5;
        return i5;
    }

    public static final class Builder extends Message.Builder<ResponseFlashSale> {
        public List<FlashSaleBrief> brief_list;
        public Integer errcode;
        public List<FlashSale> flash_sale_list;
        public List<BrandSaleMetaResponse> metas;
        public String requestid;

        public Builder() {
        }

        public Builder(ResponseFlashSale responseFlashSale) {
            super(responseFlashSale);
            if (responseFlashSale != null) {
                this.requestid = responseFlashSale.requestid;
                this.errcode = responseFlashSale.errcode;
                this.flash_sale_list = ResponseFlashSale.copyOf(responseFlashSale.flash_sale_list);
                this.brief_list = ResponseFlashSale.copyOf(responseFlashSale.brief_list);
                this.metas = ResponseFlashSale.copyOf(responseFlashSale.metas);
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

        public Builder flash_sale_list(List<FlashSale> list) {
            this.flash_sale_list = checkForNulls(list);
            return this;
        }

        public Builder brief_list(List<FlashSaleBrief> list) {
            this.brief_list = checkForNulls(list);
            return this;
        }

        public Builder metas(List<BrandSaleMetaResponse> list) {
            this.metas = checkForNulls(list);
            return this;
        }

        public ResponseFlashSale build() {
            return new ResponseFlashSale(this);
        }
    }
}
