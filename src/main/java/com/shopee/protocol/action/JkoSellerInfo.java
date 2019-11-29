package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class JkoSellerInfo extends Message {
    public static final String DEFAULT_ID = "";
    public static final Boolean DEFAULT_REMOVE_INFO = false;
    public static final String DEFAULT_USERNAME = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String id;
    @ProtoField(tag = 3, type = Message.Datatype.BOOL)
    public final Boolean remove_info;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String username;

    public JkoSellerInfo(String str, String str2, Boolean bool) {
        this.id = str;
        this.username = str2;
        this.remove_info = bool;
    }

    private JkoSellerInfo(Builder builder) {
        this(builder.id, builder.username, builder.remove_info);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof JkoSellerInfo)) {
            return false;
        }
        JkoSellerInfo jkoSellerInfo = (JkoSellerInfo) obj;
        if (!equals((Object) this.id, (Object) jkoSellerInfo.id) || !equals((Object) this.username, (Object) jkoSellerInfo.username) || !equals((Object) this.remove_info, (Object) jkoSellerInfo.remove_info)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        String str = this.id;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 37;
        String str2 = this.username;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 37;
        Boolean bool = this.remove_info;
        if (bool != null) {
            i2 = bool.hashCode();
        }
        int i3 = hashCode2 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<JkoSellerInfo> {
        public String id;
        public Boolean remove_info;
        public String username;

        public Builder() {
        }

        public Builder(JkoSellerInfo jkoSellerInfo) {
            super(jkoSellerInfo);
            if (jkoSellerInfo != null) {
                this.id = jkoSellerInfo.id;
                this.username = jkoSellerInfo.username;
                this.remove_info = jkoSellerInfo.remove_info;
            }
        }

        public Builder id(String str) {
            this.id = str;
            return this;
        }

        public Builder username(String str) {
            this.username = str;
            return this;
        }

        public Builder remove_info(Boolean bool) {
            this.remove_info = bool;
            return this;
        }

        public JkoSellerInfo build() {
            return new JkoSellerInfo(this);
        }
    }
}
