package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class ActionInfoDB extends Message {
    public static final List<String> DEFAULT_IMAGES = Collections.emptyList();
    public static final Integer DEFAULT_ITEM_COUNT = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(label = Message.Label.REPEATED, tag = 2, type = Message.Datatype.STRING)
    public final List<String> images;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer item_count;
    @ProtoField(label = Message.Label.REQUIRED, tag = 1)
    public final Notification notify;

    public ActionInfoDB(Notification notification, List<String> list, Integer num) {
        this.notify = notification;
        this.images = immutableCopyOf(list);
        this.item_count = num;
    }

    private ActionInfoDB(Builder builder) {
        this(builder.notify, builder.images, builder.item_count);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ActionInfoDB)) {
            return false;
        }
        ActionInfoDB actionInfoDB = (ActionInfoDB) obj;
        if (!equals((Object) this.notify, (Object) actionInfoDB.notify) || !equals((List<?>) this.images, (List<?>) actionInfoDB.images) || !equals((Object) this.item_count, (Object) actionInfoDB.item_count)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Notification notification = this.notify;
        int i2 = 0;
        int hashCode = (notification != null ? notification.hashCode() : 0) * 37;
        List<String> list = this.images;
        int hashCode2 = (hashCode + (list != null ? list.hashCode() : 1)) * 37;
        Integer num = this.item_count;
        if (num != null) {
            i2 = num.hashCode();
        }
        int i3 = hashCode2 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<ActionInfoDB> {
        public List<String> images;
        public Integer item_count;
        public Notification notify;

        public Builder() {
        }

        public Builder(ActionInfoDB actionInfoDB) {
            super(actionInfoDB);
            if (actionInfoDB != null) {
                this.notify = actionInfoDB.notify;
                this.images = ActionInfoDB.copyOf(actionInfoDB.images);
                this.item_count = actionInfoDB.item_count;
            }
        }

        public Builder notify(Notification notification) {
            this.notify = notification;
            return this;
        }

        public Builder images(List<String> list) {
            this.images = checkForNulls(list);
            return this;
        }

        public Builder item_count(Integer num) {
            this.item_count = num;
            return this;
        }

        public ActionInfoDB build() {
            checkRequiredFields();
            return new ActionInfoDB(this);
        }
    }
}
