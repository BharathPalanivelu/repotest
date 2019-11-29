package com.shopee.protocol.index.action;

import com.shopee.protocol.shop.Account;
import com.shopee.protocol.shop.Shop;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class SearchIndexUser extends Message {
    public static final Integer DEFAULT_USERID = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 2)
    public final Account account;
    @ProtoField(tag = 3)
    public final Shop shop;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer userid;

    public SearchIndexUser(Integer num, Account account2, Shop shop2) {
        this.userid = num;
        this.account = account2;
        this.shop = shop2;
    }

    private SearchIndexUser(Builder builder) {
        this(builder.userid, builder.account, builder.shop);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SearchIndexUser)) {
            return false;
        }
        SearchIndexUser searchIndexUser = (SearchIndexUser) obj;
        if (!equals((Object) this.userid, (Object) searchIndexUser.userid) || !equals((Object) this.account, (Object) searchIndexUser.account) || !equals((Object) this.shop, (Object) searchIndexUser.shop)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Integer num = this.userid;
        int i2 = 0;
        int hashCode = (num != null ? num.hashCode() : 0) * 37;
        Account account2 = this.account;
        int hashCode2 = (hashCode + (account2 != null ? account2.hashCode() : 0)) * 37;
        Shop shop2 = this.shop;
        if (shop2 != null) {
            i2 = shop2.hashCode();
        }
        int i3 = hashCode2 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<SearchIndexUser> {
        public Account account;
        public Shop shop;
        public Integer userid;

        public Builder() {
        }

        public Builder(SearchIndexUser searchIndexUser) {
            super(searchIndexUser);
            if (searchIndexUser != null) {
                this.userid = searchIndexUser.userid;
                this.account = searchIndexUser.account;
                this.shop = searchIndexUser.shop;
            }
        }

        public Builder userid(Integer num) {
            this.userid = num;
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

        public SearchIndexUser build() {
            return new SearchIndexUser(this);
        }
    }
}
