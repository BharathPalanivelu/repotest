package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class ResponseGetInitialItemCmt extends Message {
    public static final String DEFAULT_DEBUG_MSG = "";
    public static final Integer DEFAULT_ERRCODE = 0;
    public static final List<InitialItemCmt> DEFAULT_INTIAL_ITEM_CMT_LIST = Collections.emptyList();
    public static final String DEFAULT_REQUESTID = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String debug_msg;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer errcode;
    @ProtoField(label = Message.Label.REPEATED, messageType = InitialItemCmt.class, tag = 2)
    public final List<InitialItemCmt> intial_item_cmt_list;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;

    public ResponseGetInitialItemCmt(String str, List<InitialItemCmt> list, String str2, Integer num) {
        this.requestid = str;
        this.intial_item_cmt_list = immutableCopyOf(list);
        this.debug_msg = str2;
        this.errcode = num;
    }

    private ResponseGetInitialItemCmt(Builder builder) {
        this(builder.requestid, builder.intial_item_cmt_list, builder.debug_msg, builder.errcode);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ResponseGetInitialItemCmt)) {
            return false;
        }
        ResponseGetInitialItemCmt responseGetInitialItemCmt = (ResponseGetInitialItemCmt) obj;
        if (!equals((Object) this.requestid, (Object) responseGetInitialItemCmt.requestid) || !equals((List<?>) this.intial_item_cmt_list, (List<?>) responseGetInitialItemCmt.intial_item_cmt_list) || !equals((Object) this.debug_msg, (Object) responseGetInitialItemCmt.debug_msg) || !equals((Object) this.errcode, (Object) responseGetInitialItemCmt.errcode)) {
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
        List<InitialItemCmt> list = this.intial_item_cmt_list;
        int hashCode2 = (hashCode + (list != null ? list.hashCode() : 1)) * 37;
        String str2 = this.debug_msg;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 37;
        Integer num = this.errcode;
        if (num != null) {
            i2 = num.hashCode();
        }
        int i3 = hashCode3 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<ResponseGetInitialItemCmt> {
        public String debug_msg;
        public Integer errcode;
        public List<InitialItemCmt> intial_item_cmt_list;
        public String requestid;

        public Builder() {
        }

        public Builder(ResponseGetInitialItemCmt responseGetInitialItemCmt) {
            super(responseGetInitialItemCmt);
            if (responseGetInitialItemCmt != null) {
                this.requestid = responseGetInitialItemCmt.requestid;
                this.intial_item_cmt_list = ResponseGetInitialItemCmt.copyOf(responseGetInitialItemCmt.intial_item_cmt_list);
                this.debug_msg = responseGetInitialItemCmt.debug_msg;
                this.errcode = responseGetInitialItemCmt.errcode;
            }
        }

        public Builder requestid(String str) {
            this.requestid = str;
            return this;
        }

        public Builder intial_item_cmt_list(List<InitialItemCmt> list) {
            this.intial_item_cmt_list = checkForNulls(list);
            return this;
        }

        public Builder debug_msg(String str) {
            this.debug_msg = str;
            return this;
        }

        public Builder errcode(Integer num) {
            this.errcode = num;
            return this;
        }

        public ResponseGetInitialItemCmt build() {
            return new ResponseGetInitialItemCmt(this);
        }
    }
}
