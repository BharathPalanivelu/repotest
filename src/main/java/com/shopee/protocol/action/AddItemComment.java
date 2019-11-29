package com.shopee.protocol.action;

import com.shopee.protocol.shop.ItemCmt;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class AddItemComment extends Message {
    public static final String DEFAULT_REQUESTID = "";
    public static final String DEFAULT_TOKEN = "";
    private static final long serialVersionUID = 0;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2)
    public final ItemCmt comment;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String token;

    public AddItemComment(String str, ItemCmt itemCmt, String str2) {
        this.requestid = str;
        this.comment = itemCmt;
        this.token = str2;
    }

    private AddItemComment(Builder builder) {
        this(builder.requestid, builder.comment, builder.token);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AddItemComment)) {
            return false;
        }
        AddItemComment addItemComment = (AddItemComment) obj;
        if (!equals((Object) this.requestid, (Object) addItemComment.requestid) || !equals((Object) this.comment, (Object) addItemComment.comment) || !equals((Object) this.token, (Object) addItemComment.token)) {
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
        ItemCmt itemCmt = this.comment;
        int hashCode2 = (hashCode + (itemCmt != null ? itemCmt.hashCode() : 0)) * 37;
        String str2 = this.token;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        int i3 = hashCode2 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<AddItemComment> {
        public ItemCmt comment;
        public String requestid;
        public String token;

        public Builder() {
        }

        public Builder(AddItemComment addItemComment) {
            super(addItemComment);
            if (addItemComment != null) {
                this.requestid = addItemComment.requestid;
                this.comment = addItemComment.comment;
                this.token = addItemComment.token;
            }
        }

        public Builder requestid(String str) {
            this.requestid = str;
            return this;
        }

        public Builder comment(ItemCmt itemCmt) {
            this.comment = itemCmt;
            return this;
        }

        public Builder token(String str) {
            this.token = str;
            return this;
        }

        public AddItemComment build() {
            checkRequiredFields();
            return new AddItemComment(this);
        }
    }
}
