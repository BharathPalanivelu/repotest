package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import e.f;

public final class ChangeOrderInfo extends Message {
    public static final Long DEFAULT_ORDERID = 0L;
    public static final String DEFAULT_REQUESTID = "";
    public static final f DEFAULT_SELLER_NOTE = f.f32736b;
    public static final String DEFAULT_TOKEN = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 3, type = Message.Datatype.INT64)
    public final Long orderid;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(tag = 4, type = Message.Datatype.BYTES)
    public final f seller_note;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String token;

    public ChangeOrderInfo(String str, String str2, Long l, f fVar) {
        this.requestid = str;
        this.token = str2;
        this.orderid = l;
        this.seller_note = fVar;
    }

    private ChangeOrderInfo(Builder builder) {
        this(builder.requestid, builder.token, builder.orderid, builder.seller_note);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ChangeOrderInfo)) {
            return false;
        }
        ChangeOrderInfo changeOrderInfo = (ChangeOrderInfo) obj;
        if (!equals((Object) this.requestid, (Object) changeOrderInfo.requestid) || !equals((Object) this.token, (Object) changeOrderInfo.token) || !equals((Object) this.orderid, (Object) changeOrderInfo.orderid) || !equals((Object) this.seller_note, (Object) changeOrderInfo.seller_note)) {
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
        String str2 = this.token;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 37;
        Long l = this.orderid;
        int hashCode3 = (hashCode2 + (l != null ? l.hashCode() : 0)) * 37;
        f fVar = this.seller_note;
        if (fVar != null) {
            i2 = fVar.hashCode();
        }
        int i3 = hashCode3 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<ChangeOrderInfo> {
        public Long orderid;
        public String requestid;
        public f seller_note;
        public String token;

        public Builder() {
        }

        public Builder(ChangeOrderInfo changeOrderInfo) {
            super(changeOrderInfo);
            if (changeOrderInfo != null) {
                this.requestid = changeOrderInfo.requestid;
                this.token = changeOrderInfo.token;
                this.orderid = changeOrderInfo.orderid;
                this.seller_note = changeOrderInfo.seller_note;
            }
        }

        public Builder requestid(String str) {
            this.requestid = str;
            return this;
        }

        public Builder token(String str) {
            this.token = str;
            return this;
        }

        public Builder orderid(Long l) {
            this.orderid = l;
            return this;
        }

        public Builder seller_note(f fVar) {
            this.seller_note = fVar;
            return this;
        }

        public ChangeOrderInfo build() {
            return new ChangeOrderInfo(this);
        }
    }
}
