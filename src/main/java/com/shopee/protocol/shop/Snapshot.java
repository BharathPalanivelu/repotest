package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class Snapshot extends Message {
    public static final List<ItemModel> DEFAULT_MODEL = Collections.emptyList();
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 1)
    public final Item item;
    @ProtoField(label = Message.Label.REPEATED, messageType = ItemModel.class, tag = 2)
    public final List<ItemModel> model;

    public Snapshot(Item item2, List<ItemModel> list) {
        this.item = item2;
        this.model = immutableCopyOf(list);
    }

    private Snapshot(Builder builder) {
        this(builder.item, builder.model);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Snapshot)) {
            return false;
        }
        Snapshot snapshot = (Snapshot) obj;
        if (!equals((Object) this.item, (Object) snapshot.item) || !equals((List<?>) this.model, (List<?>) snapshot.model)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Item item2 = this.item;
        int hashCode = (item2 != null ? item2.hashCode() : 0) * 37;
        List<ItemModel> list = this.model;
        int hashCode2 = hashCode + (list != null ? list.hashCode() : 1);
        this.hashCode = hashCode2;
        return hashCode2;
    }

    public static final class Builder extends Message.Builder<Snapshot> {
        public Item item;
        public List<ItemModel> model;

        public Builder() {
        }

        public Builder(Snapshot snapshot) {
            super(snapshot);
            if (snapshot != null) {
                this.item = snapshot.item;
                this.model = Snapshot.copyOf(snapshot.model);
            }
        }

        public Builder item(Item item2) {
            this.item = item2;
            return this;
        }

        public Builder model(List<ItemModel> list) {
            this.model = checkForNulls(list);
            return this;
        }

        public Snapshot build() {
            return new Snapshot(this);
        }
    }
}
