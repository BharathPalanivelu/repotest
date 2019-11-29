package com.shopee.protocol.search.action;

import beeshop.curatedsearch.CuratedModule;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class ResponseCuratedSearch extends Message {
    public static final List<CuratedModule> DEFAULT_MODULES = Collections.emptyList();
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 1)
    public final ResponseHeader header;
    @ProtoField(label = Message.Label.REPEATED, messageType = CuratedModule.class, tag = 2)
    public final List<CuratedModule> modules;

    public ResponseCuratedSearch(ResponseHeader responseHeader, List<CuratedModule> list) {
        this.header = responseHeader;
        this.modules = immutableCopyOf(list);
    }

    private ResponseCuratedSearch(Builder builder) {
        this(builder.header, builder.modules);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ResponseCuratedSearch)) {
            return false;
        }
        ResponseCuratedSearch responseCuratedSearch = (ResponseCuratedSearch) obj;
        if (!equals((Object) this.header, (Object) responseCuratedSearch.header) || !equals((List<?>) this.modules, (List<?>) responseCuratedSearch.modules)) {
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
        List<CuratedModule> list = this.modules;
        int hashCode2 = hashCode + (list != null ? list.hashCode() : 1);
        this.hashCode = hashCode2;
        return hashCode2;
    }

    public static final class Builder extends Message.Builder<ResponseCuratedSearch> {
        public ResponseHeader header;
        public List<CuratedModule> modules;

        public Builder() {
        }

        public Builder(ResponseCuratedSearch responseCuratedSearch) {
            super(responseCuratedSearch);
            if (responseCuratedSearch != null) {
                this.header = responseCuratedSearch.header;
                this.modules = ResponseCuratedSearch.copyOf(responseCuratedSearch.modules);
            }
        }

        public Builder header(ResponseHeader responseHeader) {
            this.header = responseHeader;
            return this;
        }

        public Builder modules(List<CuratedModule> list) {
            this.modules = checkForNulls(list);
            return this;
        }

        public ResponseCuratedSearch build() {
            return new ResponseCuratedSearch(this);
        }
    }
}
