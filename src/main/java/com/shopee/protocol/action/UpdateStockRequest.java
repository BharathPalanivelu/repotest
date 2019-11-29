package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class UpdateStockRequest extends Message {
    public static final Integer DEFAULT_DELTA_STOCK = 0;
    public static final Long DEFAULT_ITEMID = 0L;
    public static final Long DEFAULT_MODELID = 0L;
    public static final String DEFAULT_OPERATOR = "";
    public static final String DEFAULT_REQUESTID = "";
    public static final Integer DEFAULT_SHOPID = 0;
    public static final Long DEFAULT_UNIQUEID = 0L;
    public static final String DEFAULT_UNIQUEID_V2 = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 5, type = Message.Datatype.INT32)
    public final Integer delta_stock;
    @ProtoField(tag = 3, type = Message.Datatype.INT64)
    public final Long itemid;
    @ProtoField(tag = 4, type = Message.Datatype.INT64)
    public final Long modelid;
    @ProtoField(tag = 7, type = Message.Datatype.STRING)
    public final String operator;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer shopid;
    @ProtoField(tag = 6, type = Message.Datatype.INT64)
    public final Long uniqueid;
    @ProtoField(tag = 8, type = Message.Datatype.STRING)
    public final String uniqueid_v2;

    public UpdateStockRequest(String str, Integer num, Long l, Long l2, Integer num2, Long l3, String str2, String str3) {
        this.requestid = str;
        this.shopid = num;
        this.itemid = l;
        this.modelid = l2;
        this.delta_stock = num2;
        this.uniqueid = l3;
        this.operator = str2;
        this.uniqueid_v2 = str3;
    }

    private UpdateStockRequest(Builder builder) {
        this(builder.requestid, builder.shopid, builder.itemid, builder.modelid, builder.delta_stock, builder.uniqueid, builder.operator, builder.uniqueid_v2);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof UpdateStockRequest)) {
            return false;
        }
        UpdateStockRequest updateStockRequest = (UpdateStockRequest) obj;
        if (!equals((Object) this.requestid, (Object) updateStockRequest.requestid) || !equals((Object) this.shopid, (Object) updateStockRequest.shopid) || !equals((Object) this.itemid, (Object) updateStockRequest.itemid) || !equals((Object) this.modelid, (Object) updateStockRequest.modelid) || !equals((Object) this.delta_stock, (Object) updateStockRequest.delta_stock) || !equals((Object) this.uniqueid, (Object) updateStockRequest.uniqueid) || !equals((Object) this.operator, (Object) updateStockRequest.operator) || !equals((Object) this.uniqueid_v2, (Object) updateStockRequest.uniqueid_v2)) {
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
        Integer num = this.shopid;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 37;
        Long l = this.itemid;
        int hashCode3 = (hashCode2 + (l != null ? l.hashCode() : 0)) * 37;
        Long l2 = this.modelid;
        int hashCode4 = (hashCode3 + (l2 != null ? l2.hashCode() : 0)) * 37;
        Integer num2 = this.delta_stock;
        int hashCode5 = (hashCode4 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Long l3 = this.uniqueid;
        int hashCode6 = (hashCode5 + (l3 != null ? l3.hashCode() : 0)) * 37;
        String str2 = this.operator;
        int hashCode7 = (hashCode6 + (str2 != null ? str2.hashCode() : 0)) * 37;
        String str3 = this.uniqueid_v2;
        if (str3 != null) {
            i2 = str3.hashCode();
        }
        int i3 = hashCode7 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<UpdateStockRequest> {
        public Integer delta_stock;
        public Long itemid;
        public Long modelid;
        public String operator;
        public String requestid;
        public Integer shopid;
        public Long uniqueid;
        public String uniqueid_v2;

        public Builder() {
        }

        public Builder(UpdateStockRequest updateStockRequest) {
            super(updateStockRequest);
            if (updateStockRequest != null) {
                this.requestid = updateStockRequest.requestid;
                this.shopid = updateStockRequest.shopid;
                this.itemid = updateStockRequest.itemid;
                this.modelid = updateStockRequest.modelid;
                this.delta_stock = updateStockRequest.delta_stock;
                this.uniqueid = updateStockRequest.uniqueid;
                this.operator = updateStockRequest.operator;
                this.uniqueid_v2 = updateStockRequest.uniqueid_v2;
            }
        }

        public Builder requestid(String str) {
            this.requestid = str;
            return this;
        }

        public Builder shopid(Integer num) {
            this.shopid = num;
            return this;
        }

        public Builder itemid(Long l) {
            this.itemid = l;
            return this;
        }

        public Builder modelid(Long l) {
            this.modelid = l;
            return this;
        }

        public Builder delta_stock(Integer num) {
            this.delta_stock = num;
            return this;
        }

        public Builder uniqueid(Long l) {
            this.uniqueid = l;
            return this;
        }

        public Builder operator(String str) {
            this.operator = str;
            return this;
        }

        public Builder uniqueid_v2(String str) {
            this.uniqueid_v2 = str;
            return this;
        }

        public UpdateStockRequest build() {
            return new UpdateStockRequest(this);
        }
    }
}
