package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class GetAttributeModel extends Message {
    public static final List<Integer> DEFAULT_CATID = Collections.emptyList();
    public static final String DEFAULT_COUNTRY = "";
    public static final Integer DEFAULT_MODELID = 0;
    public static final String DEFAULT_REQUESTID = "";
    private static final long serialVersionUID = 0;
    @ProtoField(label = Message.Label.REPEATED, tag = 2, type = Message.Datatype.INT32)
    public final List<Integer> catid;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String country;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer modelid;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;

    public GetAttributeModel(String str, List<Integer> list, String str2, Integer num) {
        this.requestid = str;
        this.catid = immutableCopyOf(list);
        this.country = str2;
        this.modelid = num;
    }

    private GetAttributeModel(Builder builder) {
        this(builder.requestid, builder.catid, builder.country, builder.modelid);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof GetAttributeModel)) {
            return false;
        }
        GetAttributeModel getAttributeModel = (GetAttributeModel) obj;
        if (!equals((Object) this.requestid, (Object) getAttributeModel.requestid) || !equals((List<?>) this.catid, (List<?>) getAttributeModel.catid) || !equals((Object) this.country, (Object) getAttributeModel.country) || !equals((Object) this.modelid, (Object) getAttributeModel.modelid)) {
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
        List<Integer> list = this.catid;
        int hashCode2 = (hashCode + (list != null ? list.hashCode() : 1)) * 37;
        String str2 = this.country;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 37;
        Integer num = this.modelid;
        if (num != null) {
            i2 = num.hashCode();
        }
        int i3 = hashCode3 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<GetAttributeModel> {
        public List<Integer> catid;
        public String country;
        public Integer modelid;
        public String requestid;

        public Builder() {
        }

        public Builder(GetAttributeModel getAttributeModel) {
            super(getAttributeModel);
            if (getAttributeModel != null) {
                this.requestid = getAttributeModel.requestid;
                this.catid = GetAttributeModel.copyOf(getAttributeModel.catid);
                this.country = getAttributeModel.country;
                this.modelid = getAttributeModel.modelid;
            }
        }

        public Builder requestid(String str) {
            this.requestid = str;
            return this;
        }

        public Builder catid(List<Integer> list) {
            this.catid = checkForNulls(list);
            return this;
        }

        public Builder country(String str) {
            this.country = str;
            return this;
        }

        public Builder modelid(Integer num) {
            this.modelid = num;
            return this;
        }

        public GetAttributeModel build() {
            return new GetAttributeModel(this);
        }
    }
}
