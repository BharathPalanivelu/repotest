package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class BoostItem extends Message {
    public static final List<Long> DEFAULT_ITEMIDS = Collections.emptyList();
    public static final String DEFAULT_REQUESTID = "";
    public static final String DEFAULT_TOKEN = "";
    private static final long serialVersionUID = 0;
    @ProtoField(label = Message.Label.REPEATED, tag = 3, type = Message.Datatype.INT64)
    public final List<Long> itemids;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String token;

    public BoostItem(String str, String str2, List<Long> list) {
        this.requestid = str;
        this.token = str2;
        this.itemids = immutableCopyOf(list);
    }

    private BoostItem(Builder builder) {
        this(builder.requestid, builder.token, builder.itemids);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BoostItem)) {
            return false;
        }
        BoostItem boostItem = (BoostItem) obj;
        if (!equals((Object) this.requestid, (Object) boostItem.requestid) || !equals((Object) this.token, (Object) boostItem.token) || !equals((List<?>) this.itemids, (List<?>) boostItem.itemids)) {
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
        List<Long> list = this.itemids;
        int hashCode2 = i3 + (list != null ? list.hashCode() : 1);
        this.hashCode = hashCode2;
        return hashCode2;
    }

    public static final class Builder extends Message.Builder<BoostItem> {
        public List<Long> itemids;
        public String requestid;
        public String token;

        public Builder() {
        }

        public Builder(BoostItem boostItem) {
            super(boostItem);
            if (boostItem != null) {
                this.requestid = boostItem.requestid;
                this.token = boostItem.token;
                this.itemids = BoostItem.copyOf(boostItem.itemids);
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

        public Builder itemids(List<Long> list) {
            this.itemids = checkForNulls(list);
            return this;
        }

        public BoostItem build() {
            return new BoostItem(this);
        }
    }
}
