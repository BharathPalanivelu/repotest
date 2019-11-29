package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class CmtExtInfo extends Message {
    public static final Boolean DEFAULT_ANONYMOUS = false;
    public static final String DEFAULT_COUNTRY = "";
    public static final String DEFAULT_DELETE_OPERATOR = "";
    public static final String DEFAULT_DELETE_REASON = "";
    public static final Integer DEFAULT_EDITABLE_DATE = 0;
    public static final List<String> DEFAULT_IMAGE = Collections.emptyList();
    public static final Boolean DEFAULT_IS_HIDDEN = false;
    public static final List<ItemModelId> DEFAULT_ITEMS = Collections.emptyList();
    public static final Integer DEFAULT_LIKE_COUNT = 0;
    public static final String DEFAULT_TAGIDS = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 7)
    public final ItemCmt ItemRatingReply;
    @ProtoField(tag = 8)
    public final UserCmt UserRatingReply;
    @ProtoField(tag = 2, type = Message.Datatype.BOOL)
    public final Boolean anonymous;
    @ProtoField(tag = 13, type = Message.Datatype.STRING)
    public final String country;
    @ProtoField(tag = 6, type = Message.Datatype.STRING)
    public final String delete_operator;
    @ProtoField(tag = 5, type = Message.Datatype.STRING)
    public final String delete_reason;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer editable_date;
    @ProtoField(tag = 12)
    public final InitialItemCmt first_submission_content;
    @ProtoField(label = Message.Label.REPEATED, tag = 1, type = Message.Datatype.STRING)
    public final List<String> image;
    @ProtoField(tag = 11, type = Message.Datatype.BOOL)
    public final Boolean is_hidden;
    @ProtoField(label = Message.Label.REPEATED, messageType = ItemModelId.class, tag = 4)
    public final List<ItemModelId> items;
    @ProtoField(tag = 10, type = Message.Datatype.INT32)
    public final Integer like_count;
    @ProtoField(tag = 9, type = Message.Datatype.STRING)
    public final String tagids;

    public CmtExtInfo(List<String> list, Boolean bool, Integer num, List<ItemModelId> list2, String str, String str2, ItemCmt itemCmt, UserCmt userCmt, String str3, Integer num2, Boolean bool2, InitialItemCmt initialItemCmt, String str4) {
        this.image = immutableCopyOf(list);
        this.anonymous = bool;
        this.editable_date = num;
        this.items = immutableCopyOf(list2);
        this.delete_reason = str;
        this.delete_operator = str2;
        this.ItemRatingReply = itemCmt;
        this.UserRatingReply = userCmt;
        this.tagids = str3;
        this.like_count = num2;
        this.is_hidden = bool2;
        this.first_submission_content = initialItemCmt;
        this.country = str4;
    }

    private CmtExtInfo(Builder builder) {
        this(builder.image, builder.anonymous, builder.editable_date, builder.items, builder.delete_reason, builder.delete_operator, builder.ItemRatingReply, builder.UserRatingReply, builder.tagids, builder.like_count, builder.is_hidden, builder.first_submission_content, builder.country);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CmtExtInfo)) {
            return false;
        }
        CmtExtInfo cmtExtInfo = (CmtExtInfo) obj;
        if (!equals((List<?>) this.image, (List<?>) cmtExtInfo.image) || !equals((Object) this.anonymous, (Object) cmtExtInfo.anonymous) || !equals((Object) this.editable_date, (Object) cmtExtInfo.editable_date) || !equals((List<?>) this.items, (List<?>) cmtExtInfo.items) || !equals((Object) this.delete_reason, (Object) cmtExtInfo.delete_reason) || !equals((Object) this.delete_operator, (Object) cmtExtInfo.delete_operator) || !equals((Object) this.ItemRatingReply, (Object) cmtExtInfo.ItemRatingReply) || !equals((Object) this.UserRatingReply, (Object) cmtExtInfo.UserRatingReply) || !equals((Object) this.tagids, (Object) cmtExtInfo.tagids) || !equals((Object) this.like_count, (Object) cmtExtInfo.like_count) || !equals((Object) this.is_hidden, (Object) cmtExtInfo.is_hidden) || !equals((Object) this.first_submission_content, (Object) cmtExtInfo.first_submission_content) || !equals((Object) this.country, (Object) cmtExtInfo.country)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        List<String> list = this.image;
        int i2 = 1;
        int hashCode = (list != null ? list.hashCode() : 1) * 37;
        Boolean bool = this.anonymous;
        int i3 = 0;
        int hashCode2 = (hashCode + (bool != null ? bool.hashCode() : 0)) * 37;
        Integer num = this.editable_date;
        int hashCode3 = (hashCode2 + (num != null ? num.hashCode() : 0)) * 37;
        List<ItemModelId> list2 = this.items;
        if (list2 != null) {
            i2 = list2.hashCode();
        }
        int i4 = (hashCode3 + i2) * 37;
        String str = this.delete_reason;
        int hashCode4 = (i4 + (str != null ? str.hashCode() : 0)) * 37;
        String str2 = this.delete_operator;
        int hashCode5 = (hashCode4 + (str2 != null ? str2.hashCode() : 0)) * 37;
        ItemCmt itemCmt = this.ItemRatingReply;
        int hashCode6 = (hashCode5 + (itemCmt != null ? itemCmt.hashCode() : 0)) * 37;
        UserCmt userCmt = this.UserRatingReply;
        int hashCode7 = (hashCode6 + (userCmt != null ? userCmt.hashCode() : 0)) * 37;
        String str3 = this.tagids;
        int hashCode8 = (hashCode7 + (str3 != null ? str3.hashCode() : 0)) * 37;
        Integer num2 = this.like_count;
        int hashCode9 = (hashCode8 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Boolean bool2 = this.is_hidden;
        int hashCode10 = (hashCode9 + (bool2 != null ? bool2.hashCode() : 0)) * 37;
        InitialItemCmt initialItemCmt = this.first_submission_content;
        int hashCode11 = (hashCode10 + (initialItemCmt != null ? initialItemCmt.hashCode() : 0)) * 37;
        String str4 = this.country;
        if (str4 != null) {
            i3 = str4.hashCode();
        }
        int i5 = hashCode11 + i3;
        this.hashCode = i5;
        return i5;
    }

    public static final class Builder extends Message.Builder<CmtExtInfo> {
        public ItemCmt ItemRatingReply;
        public UserCmt UserRatingReply;
        public Boolean anonymous;
        public String country;
        public String delete_operator;
        public String delete_reason;
        public Integer editable_date;
        public InitialItemCmt first_submission_content;
        public List<String> image;
        public Boolean is_hidden;
        public List<ItemModelId> items;
        public Integer like_count;
        public String tagids;

        public Builder() {
        }

        public Builder(CmtExtInfo cmtExtInfo) {
            super(cmtExtInfo);
            if (cmtExtInfo != null) {
                this.image = CmtExtInfo.copyOf(cmtExtInfo.image);
                this.anonymous = cmtExtInfo.anonymous;
                this.editable_date = cmtExtInfo.editable_date;
                this.items = CmtExtInfo.copyOf(cmtExtInfo.items);
                this.delete_reason = cmtExtInfo.delete_reason;
                this.delete_operator = cmtExtInfo.delete_operator;
                this.ItemRatingReply = cmtExtInfo.ItemRatingReply;
                this.UserRatingReply = cmtExtInfo.UserRatingReply;
                this.tagids = cmtExtInfo.tagids;
                this.like_count = cmtExtInfo.like_count;
                this.is_hidden = cmtExtInfo.is_hidden;
                this.first_submission_content = cmtExtInfo.first_submission_content;
                this.country = cmtExtInfo.country;
            }
        }

        public Builder image(List<String> list) {
            this.image = checkForNulls(list);
            return this;
        }

        public Builder anonymous(Boolean bool) {
            this.anonymous = bool;
            return this;
        }

        public Builder editable_date(Integer num) {
            this.editable_date = num;
            return this;
        }

        public Builder items(List<ItemModelId> list) {
            this.items = checkForNulls(list);
            return this;
        }

        public Builder delete_reason(String str) {
            this.delete_reason = str;
            return this;
        }

        public Builder delete_operator(String str) {
            this.delete_operator = str;
            return this;
        }

        public Builder ItemRatingReply(ItemCmt itemCmt) {
            this.ItemRatingReply = itemCmt;
            return this;
        }

        public Builder UserRatingReply(UserCmt userCmt) {
            this.UserRatingReply = userCmt;
            return this;
        }

        public Builder tagids(String str) {
            this.tagids = str;
            return this;
        }

        public Builder like_count(Integer num) {
            this.like_count = num;
            return this;
        }

        public Builder is_hidden(Boolean bool) {
            this.is_hidden = bool;
            return this;
        }

        public Builder first_submission_content(InitialItemCmt initialItemCmt) {
            this.first_submission_content = initialItemCmt;
            return this;
        }

        public Builder country(String str) {
            this.country = str;
            return this;
        }

        public CmtExtInfo build() {
            return new CmtExtInfo(this);
        }
    }
}
