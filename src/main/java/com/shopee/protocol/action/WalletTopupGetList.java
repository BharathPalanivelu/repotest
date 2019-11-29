package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class WalletTopupGetList extends Message {
    public static final Integer DEFAULT_BEGIN_TIME = 0;
    public static final Integer DEFAULT_END_TIME = 0;
    public static final String DEFAULT_REQUESTID = "";
    public static final String DEFAULT_TOKEN = "";
    public static final Long DEFAULT_TOPUP_ID = 0L;
    public static final List<Long> DEFAULT_TOPUP_ID_LIST = Collections.emptyList();
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer begin_time;
    @ProtoField(tag = 7)
    public final BackendParam bparam;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer end_time;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String token;
    @ProtoField(tag = 5, type = Message.Datatype.INT64)
    public final Long topup_id;
    @ProtoField(label = Message.Label.REPEATED, tag = 6, type = Message.Datatype.INT64)
    public final List<Long> topup_id_list;

    public WalletTopupGetList(String str, String str2, Integer num, Integer num2, Long l, List<Long> list, BackendParam backendParam) {
        this.requestid = str;
        this.token = str2;
        this.begin_time = num;
        this.end_time = num2;
        this.topup_id = l;
        this.topup_id_list = immutableCopyOf(list);
        this.bparam = backendParam;
    }

    private WalletTopupGetList(Builder builder) {
        this(builder.requestid, builder.token, builder.begin_time, builder.end_time, builder.topup_id, builder.topup_id_list, builder.bparam);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof WalletTopupGetList)) {
            return false;
        }
        WalletTopupGetList walletTopupGetList = (WalletTopupGetList) obj;
        if (!equals((Object) this.requestid, (Object) walletTopupGetList.requestid) || !equals((Object) this.token, (Object) walletTopupGetList.token) || !equals((Object) this.begin_time, (Object) walletTopupGetList.begin_time) || !equals((Object) this.end_time, (Object) walletTopupGetList.end_time) || !equals((Object) this.topup_id, (Object) walletTopupGetList.topup_id) || !equals((List<?>) this.topup_id_list, (List<?>) walletTopupGetList.topup_id_list) || !equals((Object) this.bparam, (Object) walletTopupGetList.bparam)) {
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
        String str2 = this.token;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 37;
        Integer num = this.begin_time;
        int hashCode3 = (hashCode2 + (num != null ? num.hashCode() : 0)) * 37;
        Integer num2 = this.end_time;
        int hashCode4 = (hashCode3 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Long l = this.topup_id;
        int hashCode5 = (hashCode4 + (l != null ? l.hashCode() : 0)) * 37;
        List<Long> list = this.topup_id_list;
        int hashCode6 = (hashCode5 + (list != null ? list.hashCode() : 1)) * 37;
        BackendParam backendParam = this.bparam;
        if (backendParam != null) {
            i2 = backendParam.hashCode();
        }
        int i3 = hashCode6 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<WalletTopupGetList> {
        public Integer begin_time;
        public BackendParam bparam;
        public Integer end_time;
        public String requestid;
        public String token;
        public Long topup_id;
        public List<Long> topup_id_list;

        public Builder() {
        }

        public Builder(WalletTopupGetList walletTopupGetList) {
            super(walletTopupGetList);
            if (walletTopupGetList != null) {
                this.requestid = walletTopupGetList.requestid;
                this.token = walletTopupGetList.token;
                this.begin_time = walletTopupGetList.begin_time;
                this.end_time = walletTopupGetList.end_time;
                this.topup_id = walletTopupGetList.topup_id;
                this.topup_id_list = WalletTopupGetList.copyOf(walletTopupGetList.topup_id_list);
                this.bparam = walletTopupGetList.bparam;
            }
        }

        public Builder requestid(String str) {
            this.requestid = str;
            return this;
        }

        public Builder token(String str) {
            this.token = str;
            return this;
        }

        public Builder begin_time(Integer num) {
            this.begin_time = num;
            return this;
        }

        public Builder end_time(Integer num) {
            this.end_time = num;
            return this;
        }

        public Builder topup_id(Long l) {
            this.topup_id = l;
            return this;
        }

        public Builder topup_id_list(List<Long> list) {
            this.topup_id_list = checkForNulls(list);
            return this;
        }

        public Builder bparam(BackendParam backendParam) {
            this.bparam = backendParam;
            return this;
        }

        public WalletTopupGetList build() {
            return new WalletTopupGetList(this);
        }
    }
}
