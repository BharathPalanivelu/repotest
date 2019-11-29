package com.shopee.protocol.index.action;

import com.shopee.protocol.shop.Account;
import com.shopee.protocol.shop.Shop;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import e.f;

public final class SearchUserJob extends Message {
    public static final f DEFAULT_RAW_CTX = f.f32736b;
    public static final String DEFAULT_SOURCE = "";
    public static final Integer DEFAULT_TYPE = 0;
    public static final Integer DEFAULT_USERID = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 3)
    public final Account account;
    @ProtoField(tag = 6, type = Message.Datatype.BYTES)
    public final f raw_ctx;
    @ProtoField(tag = 4)
    public final Shop shop;
    @ProtoField(tag = 5, type = Message.Datatype.STRING)
    public final String source;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer type;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer userid;

    public SearchUserJob(Integer num, Integer num2, Account account2, Shop shop2, String str, f fVar) {
        this.type = num;
        this.userid = num2;
        this.account = account2;
        this.shop = shop2;
        this.source = str;
        this.raw_ctx = fVar;
    }

    private SearchUserJob(Builder builder) {
        this(builder.type, builder.userid, builder.account, builder.shop, builder.source, builder.raw_ctx);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SearchUserJob)) {
            return false;
        }
        SearchUserJob searchUserJob = (SearchUserJob) obj;
        if (!equals((Object) this.type, (Object) searchUserJob.type) || !equals((Object) this.userid, (Object) searchUserJob.userid) || !equals((Object) this.account, (Object) searchUserJob.account) || !equals((Object) this.shop, (Object) searchUserJob.shop) || !equals((Object) this.source, (Object) searchUserJob.source) || !equals((Object) this.raw_ctx, (Object) searchUserJob.raw_ctx)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Integer num = this.type;
        int i2 = 0;
        int hashCode = (num != null ? num.hashCode() : 0) * 37;
        Integer num2 = this.userid;
        int hashCode2 = (hashCode + (num2 != null ? num2.hashCode() : 0)) * 37;
        Account account2 = this.account;
        int hashCode3 = (hashCode2 + (account2 != null ? account2.hashCode() : 0)) * 37;
        Shop shop2 = this.shop;
        int hashCode4 = (hashCode3 + (shop2 != null ? shop2.hashCode() : 0)) * 37;
        String str = this.source;
        int hashCode5 = (hashCode4 + (str != null ? str.hashCode() : 0)) * 37;
        f fVar = this.raw_ctx;
        if (fVar != null) {
            i2 = fVar.hashCode();
        }
        int i3 = hashCode5 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<SearchUserJob> {
        public Account account;
        public f raw_ctx;
        public Shop shop;
        public String source;
        public Integer type;
        public Integer userid;

        public Builder() {
        }

        public Builder(SearchUserJob searchUserJob) {
            super(searchUserJob);
            if (searchUserJob != null) {
                this.type = searchUserJob.type;
                this.userid = searchUserJob.userid;
                this.account = searchUserJob.account;
                this.shop = searchUserJob.shop;
                this.source = searchUserJob.source;
                this.raw_ctx = searchUserJob.raw_ctx;
            }
        }

        public Builder type(Integer num) {
            this.type = num;
            return this;
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

        public Builder source(String str) {
            this.source = str;
            return this;
        }

        public Builder raw_ctx(f fVar) {
            this.raw_ctx = fVar;
            return this;
        }

        public SearchUserJob build() {
            return new SearchUserJob(this);
        }
    }
}
