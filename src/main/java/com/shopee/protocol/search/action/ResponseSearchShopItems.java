package com.shopee.protocol.search.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class ResponseSearchShopItems extends Message {
    public static final List<BriefItems> DEFAULT_SHOPITEMS = Collections.emptyList();
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 1)
    public final ResponseHeader header;
    @ProtoField(label = Message.Label.REPEATED, messageType = BriefItems.class, tag = 2)
    public final List<BriefItems> shopitems;

    public ResponseSearchShopItems(ResponseHeader responseHeader, List<BriefItems> list) {
        this.header = responseHeader;
        this.shopitems = immutableCopyOf(list);
    }

    private ResponseSearchShopItems(Builder builder) {
        this(builder.header, builder.shopitems);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ResponseSearchShopItems)) {
            return false;
        }
        ResponseSearchShopItems responseSearchShopItems = (ResponseSearchShopItems) obj;
        if (!equals((Object) this.header, (Object) responseSearchShopItems.header) || !equals((List<?>) this.shopitems, (List<?>) responseSearchShopItems.shopitems)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        ResponseHeader responseHeader = this.header;
        int hashCode = (responseHeader != null ? responseHeader.hashCode() : 0) * 37;
        List<BriefItems> list = this.shopitems;
        int hashCode2 = hashCode + (list != null ? list.hashCode() : 1);
        this.hashCode = hashCode2;
        return hashCode2;
    }

    public static final class Builder extends Message.Builder<ResponseSearchShopItems> {
        public ResponseHeader header;
        public List<BriefItems> shopitems;

        public Builder() {
        }

        public Builder(ResponseSearchShopItems responseSearchShopItems) {
            super(responseSearchShopItems);
            if (responseSearchShopItems != null) {
                this.header = responseSearchShopItems.header;
                this.shopitems = ResponseSearchShopItems.copyOf(responseSearchShopItems.shopitems);
            }
        }

        public Builder header(ResponseHeader responseHeader) {
            this.header = responseHeader;
            return this;
        }

        public Builder shopitems(List<BriefItems> list) {
            this.shopitems = checkForNulls(list);
            return this;
        }

        public ResponseSearchShopItems build() {
            return new ResponseSearchShopItems(this);
        }
    }
}
