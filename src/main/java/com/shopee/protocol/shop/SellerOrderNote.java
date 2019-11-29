package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class SellerOrderNote extends Message {
    public static final Integer DEFAULT_MTIME = 0;
    public static final String DEFAULT_NOTE = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer mtime;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String note;

    public SellerOrderNote(String str, Integer num) {
        this.note = str;
        this.mtime = num;
    }

    private SellerOrderNote(Builder builder) {
        this(builder.note, builder.mtime);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SellerOrderNote)) {
            return false;
        }
        SellerOrderNote sellerOrderNote = (SellerOrderNote) obj;
        if (!equals((Object) this.note, (Object) sellerOrderNote.note) || !equals((Object) this.mtime, (Object) sellerOrderNote.mtime)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        String str = this.note;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 37;
        Integer num = this.mtime;
        if (num != null) {
            i2 = num.hashCode();
        }
        int i3 = hashCode + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<SellerOrderNote> {
        public Integer mtime;
        public String note;

        public Builder() {
        }

        public Builder(SellerOrderNote sellerOrderNote) {
            super(sellerOrderNote);
            if (sellerOrderNote != null) {
                this.note = sellerOrderNote.note;
                this.mtime = sellerOrderNote.mtime;
            }
        }

        public Builder note(String str) {
            this.note = str;
            return this;
        }

        public Builder mtime(Integer num) {
            this.mtime = num;
            return this;
        }

        public SellerOrderNote build() {
            return new SellerOrderNote(this);
        }
    }
}
