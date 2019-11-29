package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class GetItemModelBatch extends Message {
    public static final List<Long> DEFAULT_ITEMID_LIST = Collections.emptyList();
    public static final String DEFAULT_REQUESTID = "";
    private static final long serialVersionUID = 0;
    @ProtoField(label = Message.Label.REPEATED, tag = 2, type = Message.Datatype.INT64)
    public final List<Long> itemid_list;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;

    public GetItemModelBatch(String str, List<Long> list) {
        this.requestid = str;
        this.itemid_list = immutableCopyOf(list);
    }

    private GetItemModelBatch(Builder builder) {
        this(builder.requestid, builder.itemid_list);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof GetItemModelBatch)) {
            return false;
        }
        GetItemModelBatch getItemModelBatch = (GetItemModelBatch) obj;
        if (!equals((Object) this.requestid, (Object) getItemModelBatch.requestid) || !equals((List<?>) this.itemid_list, (List<?>) getItemModelBatch.itemid_list)) {
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
        int hashCode = (str != null ? str.hashCode() : 0) * 37;
        List<Long> list = this.itemid_list;
        int hashCode2 = hashCode + (list != null ? list.hashCode() : 1);
        this.hashCode = hashCode2;
        return hashCode2;
    }

    public static final class Builder extends Message.Builder<GetItemModelBatch> {
        public List<Long> itemid_list;
        public String requestid;

        public Builder() {
        }

        public Builder(GetItemModelBatch getItemModelBatch) {
            super(getItemModelBatch);
            if (getItemModelBatch != null) {
                this.requestid = getItemModelBatch.requestid;
                this.itemid_list = GetItemModelBatch.copyOf(getItemModelBatch.itemid_list);
            }
        }

        public Builder requestid(String str) {
            this.requestid = str;
            return this;
        }

        public Builder itemid_list(List<Long> list) {
            this.itemid_list = checkForNulls(list);
            return this;
        }

        public GetItemModelBatch build() {
            return new GetItemModelBatch(this);
        }
    }
}
