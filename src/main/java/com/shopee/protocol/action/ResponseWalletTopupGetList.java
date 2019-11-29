package com.shopee.protocol.action;

import com.shopee.protocol.shop.WalletTopup;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class ResponseWalletTopupGetList extends Message {
    public static final String DEFAULT_DEBUG_MSG = "";
    public static final Integer DEFAULT_ERRCODE = 0;
    public static final String DEFAULT_REQUESTID = "";
    public static final List<WalletTopup> DEFAULT_TOPUP_LIST = Collections.emptyList();
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String debug_msg;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer errcode;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(label = Message.Label.REPEATED, messageType = WalletTopup.class, tag = 3)
    public final List<WalletTopup> topup_list;

    public ResponseWalletTopupGetList(String str, Integer num, List<WalletTopup> list, String str2) {
        this.requestid = str;
        this.errcode = num;
        this.topup_list = immutableCopyOf(list);
        this.debug_msg = str2;
    }

    private ResponseWalletTopupGetList(Builder builder) {
        this(builder.requestid, builder.errcode, builder.topup_list, builder.debug_msg);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ResponseWalletTopupGetList)) {
            return false;
        }
        ResponseWalletTopupGetList responseWalletTopupGetList = (ResponseWalletTopupGetList) obj;
        if (!equals((Object) this.requestid, (Object) responseWalletTopupGetList.requestid) || !equals((Object) this.errcode, (Object) responseWalletTopupGetList.errcode) || !equals((List<?>) this.topup_list, (List<?>) responseWalletTopupGetList.topup_list) || !equals((Object) this.debug_msg, (Object) responseWalletTopupGetList.debug_msg)) {
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
        List<WalletTopup> list = this.topup_list;
        int hashCode3 = (hashCode2 + (list != null ? list.hashCode() : 1)) * 37;
        String str2 = this.debug_msg;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        int i3 = hashCode3 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<ResponseWalletTopupGetList> {
        public String debug_msg;
        public Integer errcode;
        public String requestid;
        public List<WalletTopup> topup_list;

        public Builder() {
        }

        public Builder(ResponseWalletTopupGetList responseWalletTopupGetList) {
            super(responseWalletTopupGetList);
            if (responseWalletTopupGetList != null) {
                this.requestid = responseWalletTopupGetList.requestid;
                this.errcode = responseWalletTopupGetList.errcode;
                this.topup_list = ResponseWalletTopupGetList.copyOf(responseWalletTopupGetList.topup_list);
                this.debug_msg = responseWalletTopupGetList.debug_msg;
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

        public Builder topup_list(List<WalletTopup> list) {
            this.topup_list = checkForNulls(list);
            return this;
        }

        public Builder debug_msg(String str) {
            this.debug_msg = str;
            return this;
        }

        public ResponseWalletTopupGetList build() {
            return new ResponseWalletTopupGetList(this);
        }
    }
}
