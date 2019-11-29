package com.shopee.protocol.action;

import com.shopee.protocol.shop.ItemModel;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class ResponseItemModel extends Message {
    public static final Integer DEFAULT_ERRCODE = 0;
    public static final List<ItemModel> DEFAULT_MODELS = Collections.emptyList();
    public static final String DEFAULT_REQUESTID = "";
    private static final long serialVersionUID = 0;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2, type = Message.Datatype.INT32)
    public final Integer errcode;
    @ProtoField(label = Message.Label.REPEATED, messageType = ItemModel.class, tag = 3)
    public final List<ItemModel> models;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;

    public ResponseItemModel(String str, Integer num, List<ItemModel> list) {
        this.requestid = str;
        this.errcode = num;
        this.models = immutableCopyOf(list);
    }

    private ResponseItemModel(Builder builder) {
        this(builder.requestid, builder.errcode, builder.models);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ResponseItemModel)) {
            return false;
        }
        ResponseItemModel responseItemModel = (ResponseItemModel) obj;
        if (!equals((Object) this.requestid, (Object) responseItemModel.requestid) || !equals((Object) this.errcode, (Object) responseItemModel.errcode) || !equals((List<?>) this.models, (List<?>) responseItemModel.models)) {
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
        List<ItemModel> list = this.models;
        int hashCode2 = i3 + (list != null ? list.hashCode() : 1);
        this.hashCode = hashCode2;
        return hashCode2;
    }

    public static final class Builder extends Message.Builder<ResponseItemModel> {
        public Integer errcode;
        public List<ItemModel> models;
        public String requestid;

        public Builder() {
        }

        public Builder(ResponseItemModel responseItemModel) {
            super(responseItemModel);
            if (responseItemModel != null) {
                this.requestid = responseItemModel.requestid;
                this.errcode = responseItemModel.errcode;
                this.models = ResponseItemModel.copyOf(responseItemModel.models);
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

        public Builder models(List<ItemModel> list) {
            this.models = checkForNulls(list);
            return this;
        }

        public ResponseItemModel build() {
            checkRequiredFields();
            return new ResponseItemModel(this);
        }
    }
}
