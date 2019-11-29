package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class CheckItemsLiked extends Message {
    public static final List<ShopItemId> DEFAULT_IDLIST = Collections.emptyList();
    public static final String DEFAULT_REQUESTID = "";
    public static final String DEFAULT_TOKEN = "";
    private static final long serialVersionUID = 0;
    @ProtoField(label = Message.Label.REPEATED, messageType = ShopItemId.class, tag = 3)
    public final List<ShopItemId> idlist;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String token;

    public CheckItemsLiked(String str, String str2, List<ShopItemId> list) {
        this.requestid = str;
        this.token = str2;
        this.idlist = immutableCopyOf(list);
    }

    private CheckItemsLiked(Builder builder) {
        this(builder.requestid, builder.token, builder.idlist);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CheckItemsLiked)) {
            return false;
        }
        CheckItemsLiked checkItemsLiked = (CheckItemsLiked) obj;
        if (!equals((Object) this.requestid, (Object) checkItemsLiked.requestid) || !equals((Object) this.token, (Object) checkItemsLiked.token) || !equals((List<?>) this.idlist, (List<?>) checkItemsLiked.idlist)) {
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
        String str2 = this.token;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        int i3 = (hashCode + i2) * 37;
        List<ShopItemId> list = this.idlist;
        int hashCode2 = i3 + (list != null ? list.hashCode() : 1);
        this.hashCode = hashCode2;
        return hashCode2;
    }

    public static final class Builder extends Message.Builder<CheckItemsLiked> {
        public List<ShopItemId> idlist;
        public String requestid;
        public String token;

        public Builder() {
        }

        public Builder(CheckItemsLiked checkItemsLiked) {
            super(checkItemsLiked);
            if (checkItemsLiked != null) {
                this.requestid = checkItemsLiked.requestid;
                this.token = checkItemsLiked.token;
                this.idlist = CheckItemsLiked.copyOf(checkItemsLiked.idlist);
            }
        }

        public Builder requestid(String str) {
            this.requestid = str;
            return this;
        }

        public Builder token(String str) {
            this.token = str;
            return this;
        }

        public Builder idlist(List<ShopItemId> list) {
            this.idlist = checkForNulls(list);
            return this;
        }

        public CheckItemsLiked build() {
            return new CheckItemsLiked(this);
        }
    }
}
