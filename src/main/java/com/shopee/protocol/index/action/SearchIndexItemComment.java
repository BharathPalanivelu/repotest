package com.shopee.protocol.index.action;

import com.shopee.protocol.shop.AccountExtInfo;
import com.shopee.protocol.shop.CmtExtInfo;
import com.shopee.protocol.shop.ItemCmt;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class SearchIndexItemComment extends Message {
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 3)
    public final AccountExtInfo buyer_info;
    @ProtoField(tag = 1)
    public final ItemCmt comment;
    @ProtoField(tag = 2)
    public final CmtExtInfo comment_info;

    public SearchIndexItemComment(ItemCmt itemCmt, CmtExtInfo cmtExtInfo, AccountExtInfo accountExtInfo) {
        this.comment = itemCmt;
        this.comment_info = cmtExtInfo;
        this.buyer_info = accountExtInfo;
    }

    private SearchIndexItemComment(Builder builder) {
        this(builder.comment, builder.comment_info, builder.buyer_info);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SearchIndexItemComment)) {
            return false;
        }
        SearchIndexItemComment searchIndexItemComment = (SearchIndexItemComment) obj;
        if (!equals((Object) this.comment, (Object) searchIndexItemComment.comment) || !equals((Object) this.comment_info, (Object) searchIndexItemComment.comment_info) || !equals((Object) this.buyer_info, (Object) searchIndexItemComment.buyer_info)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        ItemCmt itemCmt = this.comment;
        int i2 = 0;
        int hashCode = (itemCmt != null ? itemCmt.hashCode() : 0) * 37;
        CmtExtInfo cmtExtInfo = this.comment_info;
        int hashCode2 = (hashCode + (cmtExtInfo != null ? cmtExtInfo.hashCode() : 0)) * 37;
        AccountExtInfo accountExtInfo = this.buyer_info;
        if (accountExtInfo != null) {
            i2 = accountExtInfo.hashCode();
        }
        int i3 = hashCode2 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<SearchIndexItemComment> {
        public AccountExtInfo buyer_info;
        public ItemCmt comment;
        public CmtExtInfo comment_info;

        public Builder() {
        }

        public Builder(SearchIndexItemComment searchIndexItemComment) {
            super(searchIndexItemComment);
            if (searchIndexItemComment != null) {
                this.comment = searchIndexItemComment.comment;
                this.comment_info = searchIndexItemComment.comment_info;
                this.buyer_info = searchIndexItemComment.buyer_info;
            }
        }

        public Builder comment(ItemCmt itemCmt) {
            this.comment = itemCmt;
            return this;
        }

        public Builder comment_info(CmtExtInfo cmtExtInfo) {
            this.comment_info = cmtExtInfo;
            return this;
        }

        public Builder buyer_info(AccountExtInfo accountExtInfo) {
            this.buyer_info = accountExtInfo;
            return this;
        }

        public SearchIndexItemComment build() {
            return new SearchIndexItemComment(this);
        }
    }
}
