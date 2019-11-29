package com.shopee.protocol.pcenter;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class SetItemPairRequest extends Message {
    public static final List<ItemPair> DEFAULT_ITEMS = Collections.emptyList();
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 1)
    public final RequestHeader header;
    @ProtoField(label = Message.Label.REPEATED, messageType = ItemPair.class, tag = 2)
    public final List<ItemPair> items;

    public SetItemPairRequest(RequestHeader requestHeader, List<ItemPair> list) {
        this.header = requestHeader;
        this.items = immutableCopyOf(list);
    }

    private SetItemPairRequest(Builder builder) {
        this(builder.header, builder.items);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SetItemPairRequest)) {
            return false;
        }
        SetItemPairRequest setItemPairRequest = (SetItemPairRequest) obj;
        if (!equals((Object) this.header, (Object) setItemPairRequest.header) || !equals((List<?>) this.items, (List<?>) setItemPairRequest.items)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        RequestHeader requestHeader = this.header;
        int hashCode = (requestHeader != null ? requestHeader.hashCode() : 0) * 37;
        List<ItemPair> list = this.items;
        int hashCode2 = hashCode + (list != null ? list.hashCode() : 1);
        this.hashCode = hashCode2;
        return hashCode2;
    }

    public static final class Builder extends Message.Builder<SetItemPairRequest> {
        public RequestHeader header;
        public List<ItemPair> items;

        public Builder() {
        }

        public Builder(SetItemPairRequest setItemPairRequest) {
            super(setItemPairRequest);
            if (setItemPairRequest != null) {
                this.header = setItemPairRequest.header;
                this.items = SetItemPairRequest.copyOf(setItemPairRequest.items);
            }
        }

        public Builder header(RequestHeader requestHeader) {
            this.header = requestHeader;
            return this;
        }

        public Builder items(List<ItemPair> list) {
            this.items = checkForNulls(list);
            return this;
        }

        public SetItemPairRequest build() {
            return new SetItemPairRequest(this);
        }
    }
}
