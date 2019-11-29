package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class DelItemModel extends Message {
    public static final Long DEFAULT_ITEMID = 0L;
    public static final List<Long> DEFAULT_MODELID = Collections.emptyList();
    public static final String DEFAULT_REQUESTID = "";
    private static final long serialVersionUID = 0;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2, type = Message.Datatype.INT64)
    public final Long itemid;
    @ProtoField(label = Message.Label.REPEATED, tag = 3, type = Message.Datatype.INT64)
    public final List<Long> modelid;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;

    public DelItemModel(String str, Long l, List<Long> list) {
        this.requestid = str;
        this.itemid = l;
        this.modelid = immutableCopyOf(list);
    }

    private DelItemModel(Builder builder) {
        this(builder.requestid, builder.itemid, builder.modelid);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof DelItemModel)) {
            return false;
        }
        DelItemModel delItemModel = (DelItemModel) obj;
        if (!equals((Object) this.requestid, (Object) delItemModel.requestid) || !equals((Object) this.itemid, (Object) delItemModel.itemid) || !equals((List<?>) this.modelid, (List<?>) delItemModel.modelid)) {
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
        Long l = this.itemid;
        if (l != null) {
            i2 = l.hashCode();
        }
        int i3 = (hashCode + i2) * 37;
        List<Long> list = this.modelid;
        int hashCode2 = i3 + (list != null ? list.hashCode() : 1);
        this.hashCode = hashCode2;
        return hashCode2;
    }

    public static final class Builder extends Message.Builder<DelItemModel> {
        public Long itemid;
        public List<Long> modelid;
        public String requestid;

        public Builder() {
        }

        public Builder(DelItemModel delItemModel) {
            super(delItemModel);
            if (delItemModel != null) {
                this.requestid = delItemModel.requestid;
                this.itemid = delItemModel.itemid;
                this.modelid = DelItemModel.copyOf(delItemModel.modelid);
            }
        }

        public Builder requestid(String str) {
            this.requestid = str;
            return this;
        }

        public Builder itemid(Long l) {
            this.itemid = l;
            return this;
        }

        public Builder modelid(List<Long> list) {
            this.modelid = checkForNulls(list);
            return this;
        }

        public DelItemModel build() {
            checkRequiredFields();
            return new DelItemModel(this);
        }
    }
}
