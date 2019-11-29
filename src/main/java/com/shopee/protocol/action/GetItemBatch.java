package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class GetItemBatch extends Message {
    public static final List<ShopItemId> DEFAULT_IDLIST = Collections.emptyList();
    public static final Boolean DEFAULT_NEED_DELETED_ITEMS = false;
    public static final Boolean DEFAULT_NO_CACHE = false;
    public static final Boolean DEFAULT_NO_DESCRIPTION = false;
    public static final String DEFAULT_REQUESTID = "";
    public static final Boolean DEFAULT_RETURN_HASHTAG_LIST = false;
    public static final Boolean DEFAULT_SORT_HASHTAG_LIST = false;
    private static final long serialVersionUID = 0;
    @ProtoField(label = Message.Label.REPEATED, messageType = ShopItemId.class, tag = 2)
    public final List<ShopItemId> idlist;
    @ProtoField(tag = 3, type = Message.Datatype.BOOL)
    public final Boolean need_deleted_items;
    @ProtoField(tag = 7, type = Message.Datatype.BOOL)
    public final Boolean no_cache;
    @ProtoField(tag = 6, type = Message.Datatype.BOOL)
    public final Boolean no_description;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(tag = 4, type = Message.Datatype.BOOL)
    public final Boolean return_hashtag_list;
    @ProtoField(tag = 5, type = Message.Datatype.BOOL)
    public final Boolean sort_hashtag_list;

    public GetItemBatch(String str, List<ShopItemId> list, Boolean bool, Boolean bool2, Boolean bool3, Boolean bool4, Boolean bool5) {
        this.requestid = str;
        this.idlist = immutableCopyOf(list);
        this.need_deleted_items = bool;
        this.return_hashtag_list = bool2;
        this.sort_hashtag_list = bool3;
        this.no_description = bool4;
        this.no_cache = bool5;
    }

    private GetItemBatch(Builder builder) {
        this(builder.requestid, builder.idlist, builder.need_deleted_items, builder.return_hashtag_list, builder.sort_hashtag_list, builder.no_description, builder.no_cache);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof GetItemBatch)) {
            return false;
        }
        GetItemBatch getItemBatch = (GetItemBatch) obj;
        if (!equals((Object) this.requestid, (Object) getItemBatch.requestid) || !equals((List<?>) this.idlist, (List<?>) getItemBatch.idlist) || !equals((Object) this.need_deleted_items, (Object) getItemBatch.need_deleted_items) || !equals((Object) this.return_hashtag_list, (Object) getItemBatch.return_hashtag_list) || !equals((Object) this.sort_hashtag_list, (Object) getItemBatch.sort_hashtag_list) || !equals((Object) this.no_description, (Object) getItemBatch.no_description) || !equals((Object) this.no_cache, (Object) getItemBatch.no_cache)) {
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
        List<ShopItemId> list = this.idlist;
        int hashCode2 = (hashCode + (list != null ? list.hashCode() : 1)) * 37;
        Boolean bool = this.need_deleted_items;
        int hashCode3 = (hashCode2 + (bool != null ? bool.hashCode() : 0)) * 37;
        Boolean bool2 = this.return_hashtag_list;
        int hashCode4 = (hashCode3 + (bool2 != null ? bool2.hashCode() : 0)) * 37;
        Boolean bool3 = this.sort_hashtag_list;
        int hashCode5 = (hashCode4 + (bool3 != null ? bool3.hashCode() : 0)) * 37;
        Boolean bool4 = this.no_description;
        int hashCode6 = (hashCode5 + (bool4 != null ? bool4.hashCode() : 0)) * 37;
        Boolean bool5 = this.no_cache;
        if (bool5 != null) {
            i2 = bool5.hashCode();
        }
        int i3 = hashCode6 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<GetItemBatch> {
        public List<ShopItemId> idlist;
        public Boolean need_deleted_items;
        public Boolean no_cache;
        public Boolean no_description;
        public String requestid;
        public Boolean return_hashtag_list;
        public Boolean sort_hashtag_list;

        public Builder() {
        }

        public Builder(GetItemBatch getItemBatch) {
            super(getItemBatch);
            if (getItemBatch != null) {
                this.requestid = getItemBatch.requestid;
                this.idlist = GetItemBatch.copyOf(getItemBatch.idlist);
                this.need_deleted_items = getItemBatch.need_deleted_items;
                this.return_hashtag_list = getItemBatch.return_hashtag_list;
                this.sort_hashtag_list = getItemBatch.sort_hashtag_list;
                this.no_description = getItemBatch.no_description;
                this.no_cache = getItemBatch.no_cache;
            }
        }

        public Builder requestid(String str) {
            this.requestid = str;
            return this;
        }

        public Builder idlist(List<ShopItemId> list) {
            this.idlist = checkForNulls(list);
            return this;
        }

        public Builder need_deleted_items(Boolean bool) {
            this.need_deleted_items = bool;
            return this;
        }

        public Builder return_hashtag_list(Boolean bool) {
            this.return_hashtag_list = bool;
            return this;
        }

        public Builder sort_hashtag_list(Boolean bool) {
            this.sort_hashtag_list = bool;
            return this;
        }

        public Builder no_description(Boolean bool) {
            this.no_description = bool;
            return this;
        }

        public Builder no_cache(Boolean bool) {
            this.no_cache = bool;
            return this;
        }

        public GetItemBatch build() {
            return new GetItemBatch(this);
        }
    }
}
