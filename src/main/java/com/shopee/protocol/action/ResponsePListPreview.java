package com.shopee.protocol.action;

import com.shopee.protocol.search.action.ResponseHeader;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class ResponsePListPreview extends Message {
    public static final Integer DEFAULT_ERRCODE = 0;
    public static final List<ItemSearchInfo> DEFAULT_ITEM_ORIGIN = Collections.emptyList();
    public static final List<ItemSearchInfo> DEFAULT_ITEM_PREVIEW = Collections.emptyList();
    public static final String DEFAULT_REQUESTID = "";
    private static final long serialVersionUID = 0;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2, type = Message.Datatype.INT32)
    public final Integer errcode;
    @ProtoField(tag = 5)
    public final ResponseHeader header;
    @ProtoField(label = Message.Label.REPEATED, messageType = ItemSearchInfo.class, tag = 3)
    public final List<ItemSearchInfo> item_origin;
    @ProtoField(label = Message.Label.REPEATED, messageType = ItemSearchInfo.class, tag = 4)
    public final List<ItemSearchInfo> item_preview;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;

    public ResponsePListPreview(String str, Integer num, List<ItemSearchInfo> list, List<ItemSearchInfo> list2, ResponseHeader responseHeader) {
        this.requestid = str;
        this.errcode = num;
        this.item_origin = immutableCopyOf(list);
        this.item_preview = immutableCopyOf(list2);
        this.header = responseHeader;
    }

    private ResponsePListPreview(Builder builder) {
        this(builder.requestid, builder.errcode, builder.item_origin, builder.item_preview, builder.header);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ResponsePListPreview)) {
            return false;
        }
        ResponsePListPreview responsePListPreview = (ResponsePListPreview) obj;
        if (!equals((Object) this.requestid, (Object) responsePListPreview.requestid) || !equals((Object) this.errcode, (Object) responsePListPreview.errcode) || !equals((List<?>) this.item_origin, (List<?>) responsePListPreview.item_origin) || !equals((List<?>) this.item_preview, (List<?>) responsePListPreview.item_preview) || !equals((Object) this.header, (Object) responsePListPreview.header)) {
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
        List<ItemSearchInfo> list = this.item_origin;
        int i3 = 1;
        int hashCode3 = (hashCode2 + (list != null ? list.hashCode() : 1)) * 37;
        List<ItemSearchInfo> list2 = this.item_preview;
        if (list2 != null) {
            i3 = list2.hashCode();
        }
        int i4 = (hashCode3 + i3) * 37;
        ResponseHeader responseHeader = this.header;
        if (responseHeader != null) {
            i2 = responseHeader.hashCode();
        }
        int i5 = i4 + i2;
        this.hashCode = i5;
        return i5;
    }

    public static final class Builder extends Message.Builder<ResponsePListPreview> {
        public Integer errcode;
        public ResponseHeader header;
        public List<ItemSearchInfo> item_origin;
        public List<ItemSearchInfo> item_preview;
        public String requestid;

        public Builder() {
        }

        public Builder(ResponsePListPreview responsePListPreview) {
            super(responsePListPreview);
            if (responsePListPreview != null) {
                this.requestid = responsePListPreview.requestid;
                this.errcode = responsePListPreview.errcode;
                this.item_origin = ResponsePListPreview.copyOf(responsePListPreview.item_origin);
                this.item_preview = ResponsePListPreview.copyOf(responsePListPreview.item_preview);
                this.header = responsePListPreview.header;
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

        public Builder item_origin(List<ItemSearchInfo> list) {
            this.item_origin = checkForNulls(list);
            return this;
        }

        public Builder item_preview(List<ItemSearchInfo> list) {
            this.item_preview = checkForNulls(list);
            return this;
        }

        public Builder header(ResponseHeader responseHeader) {
            this.header = responseHeader;
            return this;
        }

        public ResponsePListPreview build() {
            checkRequiredFields();
            return new ResponsePListPreview(this);
        }
    }
}
