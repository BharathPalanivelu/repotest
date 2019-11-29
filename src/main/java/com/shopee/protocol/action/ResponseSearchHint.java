package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class ResponseSearchHint extends Message {
    public static final Integer DEFAULT_ERRCODE = 0;
    public static final List<HintRecord> DEFAULT_HINTS = Collections.emptyList();
    public static final String DEFAULT_REQUESTID = "";
    private static final long serialVersionUID = 0;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2, type = Message.Datatype.INT32)
    public final Integer errcode;
    @ProtoField(label = Message.Label.REPEATED, messageType = HintRecord.class, tag = 3)
    public final List<HintRecord> hints;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;

    public ResponseSearchHint(String str, Integer num, List<HintRecord> list) {
        this.requestid = str;
        this.errcode = num;
        this.hints = immutableCopyOf(list);
    }

    private ResponseSearchHint(Builder builder) {
        this(builder.requestid, builder.errcode, builder.hints);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ResponseSearchHint)) {
            return false;
        }
        ResponseSearchHint responseSearchHint = (ResponseSearchHint) obj;
        if (!equals((Object) this.requestid, (Object) responseSearchHint.requestid) || !equals((Object) this.errcode, (Object) responseSearchHint.errcode) || !equals((List<?>) this.hints, (List<?>) responseSearchHint.hints)) {
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
        List<HintRecord> list = this.hints;
        int hashCode2 = i3 + (list != null ? list.hashCode() : 1);
        this.hashCode = hashCode2;
        return hashCode2;
    }

    public static final class Builder extends Message.Builder<ResponseSearchHint> {
        public Integer errcode;
        public List<HintRecord> hints;
        public String requestid;

        public Builder() {
        }

        public Builder(ResponseSearchHint responseSearchHint) {
            super(responseSearchHint);
            if (responseSearchHint != null) {
                this.requestid = responseSearchHint.requestid;
                this.errcode = responseSearchHint.errcode;
                this.hints = ResponseSearchHint.copyOf(responseSearchHint.hints);
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

        public Builder hints(List<HintRecord> list) {
            this.hints = checkForNulls(list);
            return this;
        }

        public ResponseSearchHint build() {
            checkRequiredFields();
            return new ResponseSearchHint(this);
        }
    }
}
