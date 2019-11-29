package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class ResponseAttrChange extends Message {
    public static final Integer DEFAULT_ERRCODE = 0;
    public static final List<Integer> DEFAULT_MODEL_IDS = Collections.emptyList();
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer errcode;
    @ProtoField(label = Message.Label.REPEATED, tag = 2, type = Message.Datatype.INT32)
    public final List<Integer> model_ids;

    public ResponseAttrChange(Integer num, List<Integer> list) {
        this.errcode = num;
        this.model_ids = immutableCopyOf(list);
    }

    private ResponseAttrChange(Builder builder) {
        this(builder.errcode, builder.model_ids);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ResponseAttrChange)) {
            return false;
        }
        ResponseAttrChange responseAttrChange = (ResponseAttrChange) obj;
        if (!equals((Object) this.errcode, (Object) responseAttrChange.errcode) || !equals((List<?>) this.model_ids, (List<?>) responseAttrChange.model_ids)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Integer num = this.errcode;
        int hashCode = (num != null ? num.hashCode() : 0) * 37;
        List<Integer> list = this.model_ids;
        int hashCode2 = hashCode + (list != null ? list.hashCode() : 1);
        this.hashCode = hashCode2;
        return hashCode2;
    }

    public static final class Builder extends Message.Builder<ResponseAttrChange> {
        public Integer errcode;
        public List<Integer> model_ids;

        public Builder() {
        }

        public Builder(ResponseAttrChange responseAttrChange) {
            super(responseAttrChange);
            if (responseAttrChange != null) {
                this.errcode = responseAttrChange.errcode;
                this.model_ids = ResponseAttrChange.copyOf(responseAttrChange.model_ids);
            }
        }

        public Builder errcode(Integer num) {
            this.errcode = num;
            return this;
        }

        public Builder model_ids(List<Integer> list) {
            this.model_ids = checkForNulls(list);
            return this;
        }

        public ResponseAttrChange build() {
            return new ResponseAttrChange(this);
        }
    }
}
