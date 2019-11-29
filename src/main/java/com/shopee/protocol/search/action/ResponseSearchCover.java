package com.shopee.protocol.search.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class ResponseSearchCover extends Message {
    public static final List<BriefItems> DEFAULT_ITEMS = Collections.emptyList();
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 1)
    public final ResponseHeader header;
    @ProtoField(label = Message.Label.REPEATED, messageType = BriefItems.class, tag = 2)
    public final List<BriefItems> items;

    public ResponseSearchCover(ResponseHeader responseHeader, List<BriefItems> list) {
        this.header = responseHeader;
        this.items = immutableCopyOf(list);
    }

    private ResponseSearchCover(Builder builder) {
        this(builder.header, builder.items);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ResponseSearchCover)) {
            return false;
        }
        ResponseSearchCover responseSearchCover = (ResponseSearchCover) obj;
        if (!equals((Object) this.header, (Object) responseSearchCover.header) || !equals((List<?>) this.items, (List<?>) responseSearchCover.items)) {
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
        List<BriefItems> list = this.items;
        int hashCode2 = hashCode + (list != null ? list.hashCode() : 1);
        this.hashCode = hashCode2;
        return hashCode2;
    }

    public static final class Builder extends Message.Builder<ResponseSearchCover> {
        public ResponseHeader header;
        public List<BriefItems> items;

        public Builder() {
        }

        public Builder(ResponseSearchCover responseSearchCover) {
            super(responseSearchCover);
            if (responseSearchCover != null) {
                this.header = responseSearchCover.header;
                this.items = ResponseSearchCover.copyOf(responseSearchCover.items);
            }
        }

        public Builder header(ResponseHeader responseHeader) {
            this.header = responseHeader;
            return this;
        }

        public Builder items(List<BriefItems> list) {
            this.items = checkForNulls(list);
            return this;
        }

        public ResponseSearchCover build() {
            return new ResponseSearchCover(this);
        }
    }
}
