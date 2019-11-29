package com.shopee.protocol.clickmodel;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class ActClickItemPageButton extends Message {
    public static final String DEFAULT_BUTTON_TYPE = "";
    public static final Long DEFAULT_ITEMID = 0L;
    public static final Integer DEFAULT_SHOPID = 0;
    public static final Long DEFAULT_USERID = 0L;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String button_type;
    @ProtoField(tag = 3, type = Message.Datatype.INT64)
    public final Long itemid;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer shopid;
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long userid;

    public ActClickItemPageButton(Long l, Integer num, Long l2, String str) {
        this.userid = l;
        this.shopid = num;
        this.itemid = l2;
        this.button_type = str;
    }

    private ActClickItemPageButton(Builder builder) {
        this(builder.userid, builder.shopid, builder.itemid, builder.button_type);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ActClickItemPageButton)) {
            return false;
        }
        ActClickItemPageButton actClickItemPageButton = (ActClickItemPageButton) obj;
        if (!equals((Object) this.userid, (Object) actClickItemPageButton.userid) || !equals((Object) this.shopid, (Object) actClickItemPageButton.shopid) || !equals((Object) this.itemid, (Object) actClickItemPageButton.itemid) || !equals((Object) this.button_type, (Object) actClickItemPageButton.button_type)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Long l = this.userid;
        int i2 = 0;
        int hashCode = (l != null ? l.hashCode() : 0) * 37;
        Integer num = this.shopid;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 37;
        Long l2 = this.itemid;
        int hashCode3 = (hashCode2 + (l2 != null ? l2.hashCode() : 0)) * 37;
        String str = this.button_type;
        if (str != null) {
            i2 = str.hashCode();
        }
        int i3 = hashCode3 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<ActClickItemPageButton> {
        public String button_type;
        public Long itemid;
        public Integer shopid;
        public Long userid;

        public Builder() {
        }

        public Builder(ActClickItemPageButton actClickItemPageButton) {
            super(actClickItemPageButton);
            if (actClickItemPageButton != null) {
                this.userid = actClickItemPageButton.userid;
                this.shopid = actClickItemPageButton.shopid;
                this.itemid = actClickItemPageButton.itemid;
                this.button_type = actClickItemPageButton.button_type;
            }
        }

        public Builder userid(Long l) {
            this.userid = l;
            return this;
        }

        public Builder shopid(Integer num) {
            this.shopid = num;
            return this;
        }

        public Builder itemid(Long l) {
            this.itemid = l;
            return this;
        }

        public Builder button_type(String str) {
            this.button_type = str;
            return this;
        }

        public ActClickItemPageButton build() {
            return new ActClickItemPageButton(this);
        }
    }
}
