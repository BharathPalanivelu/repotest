package com.shopee.protocol.action;

import com.shopee.protocol.shop.ItemPreviewSetting;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class ResponseSetItemPreviews extends Message {
    public static final String DEFAULT_DEBUG_MSG = "";
    public static final Integer DEFAULT_ERRCODE = 0;
    public static final List<ItemPreviewSetting> DEFAULT_PREVIEWS = Collections.emptyList();
    public static final String DEFAULT_REQUESTID = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String debug_msg;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer errcode;
    @ProtoField(label = Message.Label.REPEATED, messageType = ItemPreviewSetting.class, tag = 4)
    public final List<ItemPreviewSetting> previews;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;

    public ResponseSetItemPreviews(String str, Integer num, String str2, List<ItemPreviewSetting> list) {
        this.requestid = str;
        this.errcode = num;
        this.debug_msg = str2;
        this.previews = immutableCopyOf(list);
    }

    private ResponseSetItemPreviews(Builder builder) {
        this(builder.requestid, builder.errcode, builder.debug_msg, builder.previews);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ResponseSetItemPreviews)) {
            return false;
        }
        ResponseSetItemPreviews responseSetItemPreviews = (ResponseSetItemPreviews) obj;
        if (!equals((Object) this.requestid, (Object) responseSetItemPreviews.requestid) || !equals((Object) this.errcode, (Object) responseSetItemPreviews.errcode) || !equals((Object) this.debug_msg, (Object) responseSetItemPreviews.debug_msg) || !equals((List<?>) this.previews, (List<?>) responseSetItemPreviews.previews)) {
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
        String str2 = this.debug_msg;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        int i3 = (hashCode2 + i2) * 37;
        List<ItemPreviewSetting> list = this.previews;
        int hashCode3 = i3 + (list != null ? list.hashCode() : 1);
        this.hashCode = hashCode3;
        return hashCode3;
    }

    public static final class Builder extends Message.Builder<ResponseSetItemPreviews> {
        public String debug_msg;
        public Integer errcode;
        public List<ItemPreviewSetting> previews;
        public String requestid;

        public Builder() {
        }

        public Builder(ResponseSetItemPreviews responseSetItemPreviews) {
            super(responseSetItemPreviews);
            if (responseSetItemPreviews != null) {
                this.requestid = responseSetItemPreviews.requestid;
                this.errcode = responseSetItemPreviews.errcode;
                this.debug_msg = responseSetItemPreviews.debug_msg;
                this.previews = ResponseSetItemPreviews.copyOf(responseSetItemPreviews.previews);
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

        public Builder debug_msg(String str) {
            this.debug_msg = str;
            return this;
        }

        public Builder previews(List<ItemPreviewSetting> list) {
            this.previews = checkForNulls(list);
            return this;
        }

        public ResponseSetItemPreviews build() {
            return new ResponseSetItemPreviews(this);
        }
    }
}
