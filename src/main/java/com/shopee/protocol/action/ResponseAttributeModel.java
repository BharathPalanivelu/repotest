package com.shopee.protocol.action;

import com.shopee.protocol.shop.ItemAttribute;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class ResponseAttributeModel extends Message {
    public static final List<ItemAttribute> DEFAULT_ATTRS = Collections.emptyList();
    public static final Integer DEFAULT_ERRCODE = 0;
    public static final Integer DEFAULT_MODELID = 0;
    public static final String DEFAULT_REQUESTID = "";
    private static final long serialVersionUID = 0;
    @ProtoField(label = Message.Label.REPEATED, messageType = ItemAttribute.class, tag = 3)
    public final List<ItemAttribute> attrs;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer errcode;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer modelid;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;

    public ResponseAttributeModel(String str, Integer num, List<ItemAttribute> list, Integer num2) {
        this.requestid = str;
        this.errcode = num;
        this.attrs = immutableCopyOf(list);
        this.modelid = num2;
    }

    private ResponseAttributeModel(Builder builder) {
        this(builder.requestid, builder.errcode, builder.attrs, builder.modelid);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ResponseAttributeModel)) {
            return false;
        }
        ResponseAttributeModel responseAttributeModel = (ResponseAttributeModel) obj;
        if (!equals((Object) this.requestid, (Object) responseAttributeModel.requestid) || !equals((Object) this.errcode, (Object) responseAttributeModel.errcode) || !equals((List<?>) this.attrs, (List<?>) responseAttributeModel.attrs) || !equals((Object) this.modelid, (Object) responseAttributeModel.modelid)) {
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
        List<ItemAttribute> list = this.attrs;
        int hashCode3 = (hashCode2 + (list != null ? list.hashCode() : 1)) * 37;
        Integer num2 = this.modelid;
        if (num2 != null) {
            i2 = num2.hashCode();
        }
        int i3 = hashCode3 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<ResponseAttributeModel> {
        public List<ItemAttribute> attrs;
        public Integer errcode;
        public Integer modelid;
        public String requestid;

        public Builder() {
        }

        public Builder(ResponseAttributeModel responseAttributeModel) {
            super(responseAttributeModel);
            if (responseAttributeModel != null) {
                this.requestid = responseAttributeModel.requestid;
                this.errcode = responseAttributeModel.errcode;
                this.attrs = ResponseAttributeModel.copyOf(responseAttributeModel.attrs);
                this.modelid = responseAttributeModel.modelid;
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

        public Builder attrs(List<ItemAttribute> list) {
            this.attrs = checkForNulls(list);
            return this;
        }

        public Builder modelid(Integer num) {
            this.modelid = num;
            return this;
        }

        public ResponseAttributeModel build() {
            return new ResponseAttributeModel(this);
        }
    }
}
