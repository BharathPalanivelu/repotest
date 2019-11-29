package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class ResponseCheckSellerPromotion extends Message {
    public static final Integer DEFAULT_ERRCODE = 0;
    public static final List<SellerPromotionInfo> DEFAULT_INFOS = Collections.emptyList();
    public static final String DEFAULT_REQUESTID = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer errcode;
    @ProtoField(label = Message.Label.REPEATED, messageType = SellerPromotionInfo.class, tag = 2)
    public final List<SellerPromotionInfo> infos;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;

    public ResponseCheckSellerPromotion(String str, List<SellerPromotionInfo> list, Integer num) {
        this.requestid = str;
        this.infos = immutableCopyOf(list);
        this.errcode = num;
    }

    private ResponseCheckSellerPromotion(Builder builder) {
        this(builder.requestid, builder.infos, builder.errcode);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ResponseCheckSellerPromotion)) {
            return false;
        }
        ResponseCheckSellerPromotion responseCheckSellerPromotion = (ResponseCheckSellerPromotion) obj;
        if (!equals((Object) this.requestid, (Object) responseCheckSellerPromotion.requestid) || !equals((List<?>) this.infos, (List<?>) responseCheckSellerPromotion.infos) || !equals((Object) this.errcode, (Object) responseCheckSellerPromotion.errcode)) {
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
        List<SellerPromotionInfo> list = this.infos;
        int hashCode2 = (hashCode + (list != null ? list.hashCode() : 1)) * 37;
        Integer num = this.errcode;
        if (num != null) {
            i2 = num.hashCode();
        }
        int i3 = hashCode2 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<ResponseCheckSellerPromotion> {
        public Integer errcode;
        public List<SellerPromotionInfo> infos;
        public String requestid;

        public Builder() {
        }

        public Builder(ResponseCheckSellerPromotion responseCheckSellerPromotion) {
            super(responseCheckSellerPromotion);
            if (responseCheckSellerPromotion != null) {
                this.requestid = responseCheckSellerPromotion.requestid;
                this.infos = ResponseCheckSellerPromotion.copyOf(responseCheckSellerPromotion.infos);
                this.errcode = responseCheckSellerPromotion.errcode;
            }
        }

        public Builder requestid(String str) {
            this.requestid = str;
            return this;
        }

        public Builder infos(List<SellerPromotionInfo> list) {
            this.infos = checkForNulls(list);
            return this;
        }

        public Builder errcode(Integer num) {
            this.errcode = num;
            return this;
        }

        public ResponseCheckSellerPromotion build() {
            return new ResponseCheckSellerPromotion(this);
        }
    }

    public static final class SellerPromotionInfo extends Message {
        public static final Integer DEFAULT_AVAILABLE_PURCHASE_AMOUNT = 0;
        public static final Long DEFAULT_ITEMID = 0L;
        public static final Long DEFAULT_MODELID = 0L;
        public static final Integer DEFAULT_OVER_PURCHASE_AMOUNT = 0;
        private static final long serialVersionUID = 0;
        @ProtoField(tag = 4, type = Message.Datatype.INT32)
        public final Integer available_purchase_amount;
        @ProtoField(tag = 1, type = Message.Datatype.INT64)
        public final Long itemid;
        @ProtoField(tag = 2, type = Message.Datatype.INT64)
        public final Long modelid;
        @ProtoField(tag = 3, type = Message.Datatype.INT32)
        public final Integer over_purchase_amount;

        public SellerPromotionInfo(Long l, Long l2, Integer num, Integer num2) {
            this.itemid = l;
            this.modelid = l2;
            this.over_purchase_amount = num;
            this.available_purchase_amount = num2;
        }

        private SellerPromotionInfo(Builder builder) {
            this(builder.itemid, builder.modelid, builder.over_purchase_amount, builder.available_purchase_amount);
            setBuilder(builder);
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof SellerPromotionInfo)) {
                return false;
            }
            SellerPromotionInfo sellerPromotionInfo = (SellerPromotionInfo) obj;
            if (!equals((Object) this.itemid, (Object) sellerPromotionInfo.itemid) || !equals((Object) this.modelid, (Object) sellerPromotionInfo.modelid) || !equals((Object) this.over_purchase_amount, (Object) sellerPromotionInfo.over_purchase_amount) || !equals((Object) this.available_purchase_amount, (Object) sellerPromotionInfo.available_purchase_amount)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            int i = this.hashCode;
            if (i != 0) {
                return i;
            }
            Long l = this.itemid;
            int i2 = 0;
            int hashCode = (l != null ? l.hashCode() : 0) * 37;
            Long l2 = this.modelid;
            int hashCode2 = (hashCode + (l2 != null ? l2.hashCode() : 0)) * 37;
            Integer num = this.over_purchase_amount;
            int hashCode3 = (hashCode2 + (num != null ? num.hashCode() : 0)) * 37;
            Integer num2 = this.available_purchase_amount;
            if (num2 != null) {
                i2 = num2.hashCode();
            }
            int i3 = hashCode3 + i2;
            this.hashCode = i3;
            return i3;
        }

        public static final class Builder extends Message.Builder<SellerPromotionInfo> {
            public Integer available_purchase_amount;
            public Long itemid;
            public Long modelid;
            public Integer over_purchase_amount;

            public Builder() {
            }

            public Builder(SellerPromotionInfo sellerPromotionInfo) {
                super(sellerPromotionInfo);
                if (sellerPromotionInfo != null) {
                    this.itemid = sellerPromotionInfo.itemid;
                    this.modelid = sellerPromotionInfo.modelid;
                    this.over_purchase_amount = sellerPromotionInfo.over_purchase_amount;
                    this.available_purchase_amount = sellerPromotionInfo.available_purchase_amount;
                }
            }

            public Builder itemid(Long l) {
                this.itemid = l;
                return this;
            }

            public Builder modelid(Long l) {
                this.modelid = l;
                return this;
            }

            public Builder over_purchase_amount(Integer num) {
                this.over_purchase_amount = num;
                return this;
            }

            public Builder available_purchase_amount(Integer num) {
                this.available_purchase_amount = num;
                return this;
            }

            public SellerPromotionInfo build() {
                return new SellerPromotionInfo(this);
            }
        }
    }
}
