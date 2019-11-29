package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class InitialItemCmt extends Message {
    public static final Long DEFAULT_COINS = 0L;
    public static final String DEFAULT_COMMENT = "";
    public static final List<String> DEFAULT_IMAGES = Collections.emptyList();
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 3, type = Message.Datatype.INT64)
    public final Long coins;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String comment;
    @ProtoField(label = Message.Label.REPEATED, tag = 2, type = Message.Datatype.STRING)
    public final List<String> images;

    public InitialItemCmt(String str, List<String> list, Long l) {
        this.comment = str;
        this.images = immutableCopyOf(list);
        this.coins = l;
    }

    private InitialItemCmt(Builder builder) {
        this(builder.comment, builder.images, builder.coins);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof InitialItemCmt)) {
            return false;
        }
        InitialItemCmt initialItemCmt = (InitialItemCmt) obj;
        if (!equals((Object) this.comment, (Object) initialItemCmt.comment) || !equals((List<?>) this.images, (List<?>) initialItemCmt.images) || !equals((Object) this.coins, (Object) initialItemCmt.coins)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        String str = this.comment;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 37;
        List<String> list = this.images;
        int hashCode2 = (hashCode + (list != null ? list.hashCode() : 1)) * 37;
        Long l = this.coins;
        if (l != null) {
            i2 = l.hashCode();
        }
        int i3 = hashCode2 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<InitialItemCmt> {
        public Long coins;
        public String comment;
        public List<String> images;

        public Builder() {
        }

        public Builder(InitialItemCmt initialItemCmt) {
            super(initialItemCmt);
            if (initialItemCmt != null) {
                this.comment = initialItemCmt.comment;
                this.images = InitialItemCmt.copyOf(initialItemCmt.images);
                this.coins = initialItemCmt.coins;
            }
        }

        public Builder comment(String str) {
            this.comment = str;
            return this;
        }

        public Builder images(List<String> list) {
            this.images = checkForNulls(list);
            return this;
        }

        public Builder coins(Long l) {
            this.coins = l;
            return this;
        }

        public InitialItemCmt build() {
            return new InitialItemCmt(this);
        }
    }
}
