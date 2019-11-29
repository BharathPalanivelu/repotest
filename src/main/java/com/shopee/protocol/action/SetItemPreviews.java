package com.shopee.protocol.action;

import com.shopee.protocol.shop.ItemPreviewSetting;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class SetItemPreviews extends Message {
    public static final List<ItemPreviewSetting> DEFAULT_PREVIEWS = Collections.emptyList();
    public static final String DEFAULT_REQUESTID = "";
    private static final long serialVersionUID = 0;
    @ProtoField(label = Message.Label.REPEATED, messageType = ItemPreviewSetting.class, tag = 2)
    public final List<ItemPreviewSetting> previews;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;

    public SetItemPreviews(String str, List<ItemPreviewSetting> list) {
        this.requestid = str;
        this.previews = immutableCopyOf(list);
    }

    private SetItemPreviews(Builder builder) {
        this(builder.requestid, builder.previews);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SetItemPreviews)) {
            return false;
        }
        SetItemPreviews setItemPreviews = (SetItemPreviews) obj;
        if (!equals((Object) this.requestid, (Object) setItemPreviews.requestid) || !equals((List<?>) this.previews, (List<?>) setItemPreviews.previews)) {
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
        int hashCode = (str != null ? str.hashCode() : 0) * 37;
        List<ItemPreviewSetting> list = this.previews;
        int hashCode2 = hashCode + (list != null ? list.hashCode() : 1);
        this.hashCode = hashCode2;
        return hashCode2;
    }

    public static final class Builder extends Message.Builder<SetItemPreviews> {
        public List<ItemPreviewSetting> previews;
        public String requestid;

        public Builder() {
        }

        public Builder(SetItemPreviews setItemPreviews) {
            super(setItemPreviews);
            if (setItemPreviews != null) {
                this.requestid = setItemPreviews.requestid;
                this.previews = SetItemPreviews.copyOf(setItemPreviews.previews);
            }
        }

        public Builder requestid(String str) {
            this.requestid = str;
            return this;
        }

        public Builder previews(List<ItemPreviewSetting> list) {
            this.previews = checkForNulls(list);
            return this;
        }

        public SetItemPreviews build() {
            return new SetItemPreviews(this);
        }
    }
}
