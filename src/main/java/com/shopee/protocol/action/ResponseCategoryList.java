package com.shopee.protocol.action;

import com.shopee.protocol.shop.Category;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class ResponseCategoryList extends Message {
    public static final List<Category> DEFAULT_CATEGORY = Collections.emptyList();
    public static final Integer DEFAULT_ERRCODE = 0;
    public static final String DEFAULT_ERR_MESSAGE = "";
    public static final String DEFAULT_REQUESTID = "";
    private static final long serialVersionUID = 0;
    @ProtoField(label = Message.Label.REPEATED, messageType = Category.class, tag = 3)
    public final List<Category> category;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String err_message;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2, type = Message.Datatype.INT32)
    public final Integer errcode;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;

    public ResponseCategoryList(String str, Integer num, List<Category> list, String str2) {
        this.requestid = str;
        this.errcode = num;
        this.category = immutableCopyOf(list);
        this.err_message = str2;
    }

    private ResponseCategoryList(Builder builder) {
        this(builder.requestid, builder.errcode, builder.category, builder.err_message);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ResponseCategoryList)) {
            return false;
        }
        ResponseCategoryList responseCategoryList = (ResponseCategoryList) obj;
        if (!equals((Object) this.requestid, (Object) responseCategoryList.requestid) || !equals((Object) this.errcode, (Object) responseCategoryList.errcode) || !equals((List<?>) this.category, (List<?>) responseCategoryList.category) || !equals((Object) this.err_message, (Object) responseCategoryList.err_message)) {
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
        List<Category> list = this.category;
        int hashCode3 = (hashCode2 + (list != null ? list.hashCode() : 1)) * 37;
        String str2 = this.err_message;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        int i3 = hashCode3 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<ResponseCategoryList> {
        public List<Category> category;
        public String err_message;
        public Integer errcode;
        public String requestid;

        public Builder() {
        }

        public Builder(ResponseCategoryList responseCategoryList) {
            super(responseCategoryList);
            if (responseCategoryList != null) {
                this.requestid = responseCategoryList.requestid;
                this.errcode = responseCategoryList.errcode;
                this.category = ResponseCategoryList.copyOf(responseCategoryList.category);
                this.err_message = responseCategoryList.err_message;
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

        public Builder category(List<Category> list) {
            this.category = checkForNulls(list);
            return this;
        }

        public Builder err_message(String str) {
            this.err_message = str;
            return this;
        }

        public ResponseCategoryList build() {
            checkRequiredFields();
            return new ResponseCategoryList(this);
        }
    }
}
