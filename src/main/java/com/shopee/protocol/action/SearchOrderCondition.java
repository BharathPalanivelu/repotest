package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class SearchOrderCondition extends Message {
    public static final Integer DEFAULT_BEGIN = 0;
    public static final Integer DEFAULT_BUYERID = 0;
    public static final Integer DEFAULT_CTIME_MAX = 0;
    public static final Integer DEFAULT_CTIME_MIN = 0;
    public static final Long DEFAULT_ITEMID = 0L;
    public static final String DEFAULT_KW = "";
    public static final Integer DEFAULT_LIMIT = 0;
    public static final Integer DEFAULT_MTIME_MAX = 0;
    public static final Integer DEFAULT_MTIME_MIN = 0;
    public static final Long DEFAULT_ORDERID = 0L;
    public static final Integer DEFAULT_ORDER_STATUS = 0;
    public static final Integer DEFAULT_PAYMENT = 0;
    public static final Integer DEFAULT_SHIPMENT = 0;
    public static final Integer DEFAULT_SHOPID = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 9, type = Message.Datatype.INT32)
    public final Integer begin;
    @ProtoField(tag = 13, type = Message.Datatype.INT32)
    public final Integer buyerid;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer ctime_max;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer ctime_min;
    @ProtoField(tag = 8, type = Message.Datatype.INT64)
    public final Long itemid;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String kw;
    @ProtoField(tag = 10, type = Message.Datatype.INT32)
    public final Integer limit;
    @ProtoField(tag = 12, type = Message.Datatype.INT32)
    public final Integer mtime_max;
    @ProtoField(tag = 11, type = Message.Datatype.INT32)
    public final Integer mtime_min;
    @ProtoField(tag = 7, type = Message.Datatype.INT32)
    public final Integer order_status;
    @ProtoField(tag = 14, type = Message.Datatype.INT64)
    public final Long orderid;
    @ProtoField(tag = 6, type = Message.Datatype.INT32)
    public final Integer payment;
    @ProtoField(tag = 5, type = Message.Datatype.INT32)
    public final Integer shipment;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer shopid;

    public SearchOrderCondition(Integer num, String str, Integer num2, Integer num3, Integer num4, Integer num5, Integer num6, Long l, Integer num7, Integer num8, Integer num9, Integer num10, Integer num11, Long l2) {
        this.shopid = num;
        this.kw = str;
        this.ctime_min = num2;
        this.ctime_max = num3;
        this.shipment = num4;
        this.payment = num5;
        this.order_status = num6;
        this.itemid = l;
        this.begin = num7;
        this.limit = num8;
        this.mtime_min = num9;
        this.mtime_max = num10;
        this.buyerid = num11;
        this.orderid = l2;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private SearchOrderCondition(com.shopee.protocol.action.SearchOrderCondition.Builder r17) {
        /*
            r16 = this;
            r0 = r17
            java.lang.Integer r2 = r0.shopid
            java.lang.String r3 = r0.kw
            java.lang.Integer r4 = r0.ctime_min
            java.lang.Integer r5 = r0.ctime_max
            java.lang.Integer r6 = r0.shipment
            java.lang.Integer r7 = r0.payment
            java.lang.Integer r8 = r0.order_status
            java.lang.Long r9 = r0.itemid
            java.lang.Integer r10 = r0.begin
            java.lang.Integer r11 = r0.limit
            java.lang.Integer r12 = r0.mtime_min
            java.lang.Integer r13 = r0.mtime_max
            java.lang.Integer r14 = r0.buyerid
            java.lang.Long r15 = r0.orderid
            r1 = r16
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15)
            r16.setBuilder(r17)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shopee.protocol.action.SearchOrderCondition.<init>(com.shopee.protocol.action.SearchOrderCondition$Builder):void");
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SearchOrderCondition)) {
            return false;
        }
        SearchOrderCondition searchOrderCondition = (SearchOrderCondition) obj;
        if (!equals((Object) this.shopid, (Object) searchOrderCondition.shopid) || !equals((Object) this.kw, (Object) searchOrderCondition.kw) || !equals((Object) this.ctime_min, (Object) searchOrderCondition.ctime_min) || !equals((Object) this.ctime_max, (Object) searchOrderCondition.ctime_max) || !equals((Object) this.shipment, (Object) searchOrderCondition.shipment) || !equals((Object) this.payment, (Object) searchOrderCondition.payment) || !equals((Object) this.order_status, (Object) searchOrderCondition.order_status) || !equals((Object) this.itemid, (Object) searchOrderCondition.itemid) || !equals((Object) this.begin, (Object) searchOrderCondition.begin) || !equals((Object) this.limit, (Object) searchOrderCondition.limit) || !equals((Object) this.mtime_min, (Object) searchOrderCondition.mtime_min) || !equals((Object) this.mtime_max, (Object) searchOrderCondition.mtime_max) || !equals((Object) this.buyerid, (Object) searchOrderCondition.buyerid) || !equals((Object) this.orderid, (Object) searchOrderCondition.orderid)) {
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
        String str = this.kw;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 37;
        Integer num2 = this.ctime_min;
        int hashCode3 = (hashCode2 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Integer num3 = this.ctime_max;
        int hashCode4 = (hashCode3 + (num3 != null ? num3.hashCode() : 0)) * 37;
        Integer num4 = this.shipment;
        int hashCode5 = (hashCode4 + (num4 != null ? num4.hashCode() : 0)) * 37;
        Integer num5 = this.payment;
        int hashCode6 = (hashCode5 + (num5 != null ? num5.hashCode() : 0)) * 37;
        Integer num6 = this.order_status;
        int hashCode7 = (hashCode6 + (num6 != null ? num6.hashCode() : 0)) * 37;
        Long l = this.itemid;
        int hashCode8 = (hashCode7 + (l != null ? l.hashCode() : 0)) * 37;
        Integer num7 = this.begin;
        int hashCode9 = (hashCode8 + (num7 != null ? num7.hashCode() : 0)) * 37;
        Integer num8 = this.limit;
        int hashCode10 = (hashCode9 + (num8 != null ? num8.hashCode() : 0)) * 37;
        Integer num9 = this.mtime_min;
        int hashCode11 = (hashCode10 + (num9 != null ? num9.hashCode() : 0)) * 37;
        Integer num10 = this.mtime_max;
        int hashCode12 = (hashCode11 + (num10 != null ? num10.hashCode() : 0)) * 37;
        Integer num11 = this.buyerid;
        int hashCode13 = (hashCode12 + (num11 != null ? num11.hashCode() : 0)) * 37;
        Long l2 = this.orderid;
        if (l2 != null) {
            i2 = l2.hashCode();
        }
        int i3 = hashCode13 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<SearchOrderCondition> {
        public Integer begin;
        public Integer buyerid;
        public Integer ctime_max;
        public Integer ctime_min;
        public Long itemid;
        public String kw;
        public Integer limit;
        public Integer mtime_max;
        public Integer mtime_min;
        public Integer order_status;
        public Long orderid;
        public Integer payment;
        public Integer shipment;
        public Integer shopid;

        public Builder() {
        }

        public Builder(SearchOrderCondition searchOrderCondition) {
            super(searchOrderCondition);
            if (searchOrderCondition != null) {
                this.shopid = searchOrderCondition.shopid;
                this.kw = searchOrderCondition.kw;
                this.ctime_min = searchOrderCondition.ctime_min;
                this.ctime_max = searchOrderCondition.ctime_max;
                this.shipment = searchOrderCondition.shipment;
                this.payment = searchOrderCondition.payment;
                this.order_status = searchOrderCondition.order_status;
                this.itemid = searchOrderCondition.itemid;
                this.begin = searchOrderCondition.begin;
                this.limit = searchOrderCondition.limit;
                this.mtime_min = searchOrderCondition.mtime_min;
                this.mtime_max = searchOrderCondition.mtime_max;
                this.buyerid = searchOrderCondition.buyerid;
                this.orderid = searchOrderCondition.orderid;
            }
        }

        public Builder shopid(Integer num) {
            this.shopid = num;
            return this;
        }

        public Builder kw(String str) {
            this.kw = str;
            return this;
        }

        public Builder ctime_min(Integer num) {
            this.ctime_min = num;
            return this;
        }

        public Builder ctime_max(Integer num) {
            this.ctime_max = num;
            return this;
        }

        public Builder shipment(Integer num) {
            this.shipment = num;
            return this;
        }

        public Builder payment(Integer num) {
            this.payment = num;
            return this;
        }

        public Builder order_status(Integer num) {
            this.order_status = num;
            return this;
        }

        public Builder itemid(Long l) {
            this.itemid = l;
            return this;
        }

        public Builder begin(Integer num) {
            this.begin = num;
            return this;
        }

        public Builder limit(Integer num) {
            this.limit = num;
            return this;
        }

        public Builder mtime_min(Integer num) {
            this.mtime_min = num;
            return this;
        }

        public Builder mtime_max(Integer num) {
            this.mtime_max = num;
            return this;
        }

        public Builder buyerid(Integer num) {
            this.buyerid = num;
            return this;
        }

        public Builder orderid(Long l) {
            this.orderid = l;
            return this;
        }

        public SearchOrderCondition build() {
            return new SearchOrderCondition(this);
        }
    }
}
