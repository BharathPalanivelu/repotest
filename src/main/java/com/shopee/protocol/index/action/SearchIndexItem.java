package com.shopee.protocol.index.action;

import com.shopee.protocol.shop.Account;
import com.shopee.protocol.shop.Item;
import com.shopee.protocol.shop.Shop;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class SearchIndexItem extends Message {
    public static final List<Integer> DEFAULT_COLLECTIONID = Collections.emptyList();
    public static final Boolean DEFAULT_IS_NEW = false;
    public static final Long DEFAULT_ITEMID = 0L;
    public static final List<Long> DEFAULT_SHOPCOLLECTIONID = Collections.emptyList();
    public static final Long DEFAULT_SOLD_COUNT = 0L;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 7)
    public final Account account;
    @ProtoField(label = Message.Label.REPEATED, tag = 5, type = Message.Datatype.INT32)
    public final List<Integer> collectionid;
    @ProtoField(tag = 4, type = Message.Datatype.BOOL)
    public final Boolean is_new;
    @ProtoField(tag = 2)
    public final Item item;
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long itemid;
    @ProtoField(tag = 8)
    public final Shop shop;
    @ProtoField(label = Message.Label.REPEATED, tag = 6, type = Message.Datatype.INT64)
    public final List<Long> shopcollectionid;
    @ProtoField(tag = 3, type = Message.Datatype.INT64)
    public final Long sold_count;

    public SearchIndexItem(Long l, Item item2, Long l2, Boolean bool, List<Integer> list, List<Long> list2, Account account2, Shop shop2) {
        this.itemid = l;
        this.item = item2;
        this.sold_count = l2;
        this.is_new = bool;
        this.collectionid = immutableCopyOf(list);
        this.shopcollectionid = immutableCopyOf(list2);
        this.account = account2;
        this.shop = shop2;
    }

    private SearchIndexItem(Builder builder) {
        this(builder.itemid, builder.item, builder.sold_count, builder.is_new, builder.collectionid, builder.shopcollectionid, builder.account, builder.shop);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SearchIndexItem)) {
            return false;
        }
        SearchIndexItem searchIndexItem = (SearchIndexItem) obj;
        if (!equals((Object) this.itemid, (Object) searchIndexItem.itemid) || !equals((Object) this.item, (Object) searchIndexItem.item) || !equals((Object) this.sold_count, (Object) searchIndexItem.sold_count) || !equals((Object) this.is_new, (Object) searchIndexItem.is_new) || !equals((List<?>) this.collectionid, (List<?>) searchIndexItem.collectionid) || !equals((List<?>) this.shopcollectionid, (List<?>) searchIndexItem.shopcollectionid) || !equals((Object) this.account, (Object) searchIndexItem.account) || !equals((Object) this.shop, (Object) searchIndexItem.shop)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Long l = this.itemid;
        int i2 = 0;
        int hashCode = (l != null ? l.hashCode() : 0) * 37;
        Item item2 = this.item;
        int hashCode2 = (hashCode + (item2 != null ? item2.hashCode() : 0)) * 37;
        Long l2 = this.sold_count;
        int hashCode3 = (hashCode2 + (l2 != null ? l2.hashCode() : 0)) * 37;
        Boolean bool = this.is_new;
        int hashCode4 = (hashCode3 + (bool != null ? bool.hashCode() : 0)) * 37;
        List<Integer> list = this.collectionid;
        int i3 = 1;
        int hashCode5 = (hashCode4 + (list != null ? list.hashCode() : 1)) * 37;
        List<Long> list2 = this.shopcollectionid;
        if (list2 != null) {
            i3 = list2.hashCode();
        }
        int i4 = (hashCode5 + i3) * 37;
        Account account2 = this.account;
        int hashCode6 = (i4 + (account2 != null ? account2.hashCode() : 0)) * 37;
        Shop shop2 = this.shop;
        if (shop2 != null) {
            i2 = shop2.hashCode();
        }
        int i5 = hashCode6 + i2;
        this.hashCode = i5;
        return i5;
    }

    public static final class Builder extends Message.Builder<SearchIndexItem> {
        public Account account;
        public List<Integer> collectionid;
        public Boolean is_new;
        public Item item;
        public Long itemid;
        public Shop shop;
        public List<Long> shopcollectionid;
        public Long sold_count;

        public Builder() {
        }

        public Builder(SearchIndexItem searchIndexItem) {
            super(searchIndexItem);
            if (searchIndexItem != null) {
                this.itemid = searchIndexItem.itemid;
                this.item = searchIndexItem.item;
                this.sold_count = searchIndexItem.sold_count;
                this.is_new = searchIndexItem.is_new;
                this.collectionid = SearchIndexItem.copyOf(searchIndexItem.collectionid);
                this.shopcollectionid = SearchIndexItem.copyOf(searchIndexItem.shopcollectionid);
                this.account = searchIndexItem.account;
                this.shop = searchIndexItem.shop;
            }
        }

        public Builder itemid(Long l) {
            this.itemid = l;
            return this;
        }

        public Builder item(Item item2) {
            this.item = item2;
            return this;
        }

        public Builder sold_count(Long l) {
            this.sold_count = l;
            return this;
        }

        public Builder is_new(Boolean bool) {
            this.is_new = bool;
            return this;
        }

        public Builder collectionid(List<Integer> list) {
            this.collectionid = checkForNulls(list);
            return this;
        }

        public Builder shopcollectionid(List<Long> list) {
            this.shopcollectionid = checkForNulls(list);
            return this;
        }

        public Builder account(Account account2) {
            this.account = account2;
            return this;
        }

        public Builder shop(Shop shop2) {
            this.shop = shop2;
            return this;
        }

        public SearchIndexItem build() {
            return new SearchIndexItem(this);
        }
    }
}
