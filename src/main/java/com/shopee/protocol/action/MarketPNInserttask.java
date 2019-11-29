package com.shopee.protocol.action;

import com.shopee.protocol.search.action.RequestHeader;
import com.shopee.protocol.shop.MarketPushnotiTasklist;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class MarketPNInserttask extends Message {
    public static final String DEFAULT_REQUESTID = "";
    public static final List<MarketPushnotiTasklist> DEFAULT_TASK_LIST = Collections.emptyList();
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 5)
    public final RequestHeader header;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(label = Message.Label.REPEATED, messageType = MarketPushnotiTasklist.class, tag = 2)
    public final List<MarketPushnotiTasklist> task_list;

    public MarketPNInserttask(String str, List<MarketPushnotiTasklist> list, RequestHeader requestHeader) {
        this.requestid = str;
        this.task_list = immutableCopyOf(list);
        this.header = requestHeader;
    }

    private MarketPNInserttask(Builder builder) {
        this(builder.requestid, builder.task_list, builder.header);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof MarketPNInserttask)) {
            return false;
        }
        MarketPNInserttask marketPNInserttask = (MarketPNInserttask) obj;
        if (!equals((Object) this.requestid, (Object) marketPNInserttask.requestid) || !equals((List<?>) this.task_list, (List<?>) marketPNInserttask.task_list) || !equals((Object) this.header, (Object) marketPNInserttask.header)) {
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
        List<MarketPushnotiTasklist> list = this.task_list;
        int hashCode2 = (hashCode + (list != null ? list.hashCode() : 1)) * 37;
        RequestHeader requestHeader = this.header;
        if (requestHeader != null) {
            i2 = requestHeader.hashCode();
        }
        int i3 = hashCode2 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<MarketPNInserttask> {
        public RequestHeader header;
        public String requestid;
        public List<MarketPushnotiTasklist> task_list;

        public Builder() {
        }

        public Builder(MarketPNInserttask marketPNInserttask) {
            super(marketPNInserttask);
            if (marketPNInserttask != null) {
                this.requestid = marketPNInserttask.requestid;
                this.task_list = MarketPNInserttask.copyOf(marketPNInserttask.task_list);
                this.header = marketPNInserttask.header;
            }
        }

        public Builder requestid(String str) {
            this.requestid = str;
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

        public MarketPNInserttask build() {
            return new MarketPNInserttask(this);
        }
    }
}
