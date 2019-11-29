package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class HotHashTagInfo extends Message {
    public static final String DEFAULT_COVER_IMAGE = "";
    public static final List<PListLookInside> DEFAULT_DETAIL_ITEM_LIST = Collections.emptyList();
    public static final Integer DEFAULT_DETAIL_TOTAL_NUM = 0;
    public static final String DEFAULT_HASHTAG = "";
    public static final String DEFAULT_TYPE = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String cover_image;
    @ProtoField(label = Message.Label.REPEATED, messageType = PListLookInside.class, tag = 3)
    public final List<PListLookInside> detail_item_list;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer detail_total_num;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String hashtag;
    @ProtoField(tag = 5, type = Message.Datatype.STRING)
    public final String type;

    public HotHashTagInfo(String str, String str2, List<PListLookInside> list, Integer num, String str3) {
        this.hashtag = str;
        this.cover_image = str2;
        this.detail_item_list = immutableCopyOf(list);
        this.detail_total_num = num;
        this.type = str3;
    }

    private HotHashTagInfo(Builder builder) {
        this(builder.hashtag, builder.cover_image, builder.detail_item_list, builder.detail_total_num, builder.type);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof HotHashTagInfo)) {
            return false;
        }
        HotHashTagInfo hotHashTagInfo = (HotHashTagInfo) obj;
        if (!equals((Object) this.hashtag, (Object) hotHashTagInfo.hashtag) || !equals((Object) this.cover_image, (Object) hotHashTagInfo.cover_image) || !equals((List<?>) this.detail_item_list, (List<?>) hotHashTagInfo.detail_item_list) || !equals((Object) this.detail_total_num, (Object) hotHashTagInfo.detail_total_num) || !equals((Object) this.type, (Object) hotHashTagInfo.type)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        String str = this.hashtag;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 37;
        String str2 = this.cover_image;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 37;
        List<PListLookInside> list = this.detail_item_list;
        int hashCode3 = (hashCode2 + (list != null ? list.hashCode() : 1)) * 37;
        Integer num = this.detail_total_num;
        int hashCode4 = (hashCode3 + (num != null ? num.hashCode() : 0)) * 37;
        String str3 = this.type;
        if (str3 != null) {
            i2 = str3.hashCode();
        }
        int i3 = hashCode4 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<HotHashTagInfo> {
        public String cover_image;
        public List<PListLookInside> detail_item_list;
        public Integer detail_total_num;
        public String hashtag;
        public String type;

        public Builder() {
        }

        public Builder(HotHashTagInfo hotHashTagInfo) {
            super(hotHashTagInfo);
            if (hotHashTagInfo != null) {
                this.hashtag = hotHashTagInfo.hashtag;
                this.cover_image = hotHashTagInfo.cover_image;
                this.detail_item_list = HotHashTagInfo.copyOf(hotHashTagInfo.detail_item_list);
                this.detail_total_num = hotHashTagInfo.detail_total_num;
                this.type = hotHashTagInfo.type;
            }
        }

        public Builder hashtag(String str) {
            this.hashtag = str;
            return this;
        }

        public Builder cover_image(String str) {
            this.cover_image = str;
            return this;
        }

        public Builder detail_item_list(List<PListLookInside> list) {
            this.detail_item_list = checkForNulls(list);
            return this;
        }

        public Builder detail_total_num(Integer num) {
            this.detail_total_num = num;
            return this;
        }

        public Builder type(String str) {
            this.type = str;
            return this;
        }

        public HotHashTagInfo build() {
            return new HotHashTagInfo(this);
        }
    }
}
