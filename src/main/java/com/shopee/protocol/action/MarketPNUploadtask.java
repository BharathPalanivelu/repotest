package com.shopee.protocol.action;

import com.shopee.protocol.search.action.RequestHeader;
import com.shopee.protocol.shop.MarketPushnotiTasklist;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class MarketPNUploadtask extends Message {
    public static final String DEFAULT_REQUESTID = "";
    public static final Integer DEFAULT_TASK_ID = 0;
    public static final List<MarketPushnotiTasklist> DEFAULT_TASK_LIST = Collections.emptyList();
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 5)
    public final RequestHeader header;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer task_id;
    @ProtoField(label = Message.Label.REPEATED, messageType = MarketPushnotiTasklist.class, tag = 3)
    public final List<MarketPushnotiTasklist> task_list;

    public MarketPNUploadtask(String str, Integer num, List<MarketPushnotiTasklist> list, RequestHeader requestHeader) {
        this.requestid = str;
        this.task_id = num;
        this.task_list = immutableCopyOf(list);
        this.header = requestHeader;
    }

    private MarketPNUploadtask(Builder builder) {
        this(builder.requestid, builder.task_id, builder.task_list, builder.header);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof MarketPNUploadtask)) {
            return false;
        }
        MarketPNUploadtask marketPNUploadtask = (MarketPNUploadtask) obj;
        if (!equals((Object) this.requestid, (Object) marketPNUploadtask.requestid) || !equals((Object) this.task_id, (Object) marketPNUploadtask.task_id) || !equals((List<?>) this.task_list, (List<?>) marketPNUploadtask.task_list) || !equals((Object) this.header, (Object) marketPNUploadtask.header)) {
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
        Integer num = this.task_id;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 37;
        List<MarketPushnotiTasklist> list = this.task_list;
        int hashCode3 = (hashCode2 + (list != null ? list.hashCode() : 1)) * 37;
        RequestHeader requestHeader = this.header;
        if (requestHeader != null) {
            i2 = requestHeader.hashCode();
        }
        int i3 = hashCode3 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<MarketPNUploadtask> {
        public RequestHeader header;
        public String requestid;
        public Integer task_id;
        public List<MarketPushnotiTasklist> task_list;

        public Builder() {
        }

        public Builder(MarketPNUploadtask marketPNUploadtask) {
            super(marketPNUploadtask);
            if (marketPNUploadtask != null) {
                this.requestid = marketPNUploadtask.requestid;
                this.task_id = marketPNUploadtask.task_id;
                this.task_list = MarketPNUploadtask.copyOf(marketPNUploadtask.task_list);
                this.header = marketPNUploadtask.header;
            }
        }

        public Builder requestid(String str) {
            this.requestid = str;
            return this;
        }

        public Builder task_id(Integer num) {
            this.task_id = num;
            return this;
        }

        public Builder task_list(List<MarketPushnotiTasklist> list) {
            this.task_list = checkForNulls(list);
            return this;
        }

        public Builder header(RequestHeader requestHeader) {
            this.header = requestHeader;
            return this;
        }

        public MarketPNUploadtask build() {
            return new MarketPNUploadtask(this);
        }
    }
}
