package com.shopee.protocol.action;

import com.shopee.protocol.search.action.RequestHeader;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class PListPreview extends Message {
    public static final List<PListWeightMeta> DEFAULT_CANDIDATE_META_LIST = Collections.emptyList();
    public static final String DEFAULT_REQUESTID = "";
    private static final long serialVersionUID = 0;
    @ProtoField(label = Message.Label.REPEATED, messageType = PListWeightMeta.class, tag = 2)
    public final List<PListWeightMeta> candidate_meta_list;
    @ProtoField(tag = 5)
    public final RequestHeader header;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;

    public PListPreview(String str, List<PListWeightMeta> list, RequestHeader requestHeader) {
        this.requestid = str;
        this.candidate_meta_list = immutableCopyOf(list);
        this.header = requestHeader;
    }

    private PListPreview(Builder builder) {
        this(builder.requestid, builder.candidate_meta_list, builder.header);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof PListPreview)) {
            return false;
        }
        PListPreview pListPreview = (PListPreview) obj;
        if (!equals((Object) this.requestid, (Object) pListPreview.requestid) || !equals((List<?>) this.candidate_meta_list, (List<?>) pListPreview.candidate_meta_list) || !equals((Object) this.header, (Object) pListPreview.header)) {
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
        List<PListWeightMeta> list = this.candidate_meta_list;
        int hashCode2 = (hashCode + (list != null ? list.hashCode() : 1)) * 37;
        RequestHeader requestHeader = this.header;
        if (requestHeader != null) {
            i2 = requestHeader.hashCode();
        }
        int i3 = hashCode2 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<PListPreview> {
        public List<PListWeightMeta> candidate_meta_list;
        public RequestHeader header;
        public String requestid;

        public Builder() {
        }

        public Builder(PListPreview pListPreview) {
            super(pListPreview);
            if (pListPreview != null) {
                this.requestid = pListPreview.requestid;
                this.candidate_meta_list = PListPreview.copyOf(pListPreview.candidate_meta_list);
                this.header = pListPreview.header;
            }
        }

        public Builder requestid(String str) {
            this.requestid = str;
            return this;
        }

        public Builder candidate_meta_list(List<PListWeightMeta> list) {
            this.candidate_meta_list = checkForNulls(list);
            return this;
        }

        public Builder header(RequestHeader requestHeader) {
            this.header = requestHeader;
            return this;
        }

        public PListPreview build() {
            return new PListPreview(this);
        }
    }
}
