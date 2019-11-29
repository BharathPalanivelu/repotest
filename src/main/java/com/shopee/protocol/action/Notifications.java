package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class Notifications extends Message {
    public static final List<Notification> DEFAULT_NOTIS = Collections.emptyList();
    private static final long serialVersionUID = 0;
    @ProtoField(label = Message.Label.REPEATED, messageType = Notification.class, tag = 1)
    public final List<Notification> notis;

    public Notifications(List<Notification> list) {
        this.notis = immutableCopyOf(list);
    }

    private Notifications(Builder builder) {
        this(builder.notis);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Notifications)) {
            return false;
        }
        return equals((List<?>) this.notis, (List<?>) ((Notifications) obj).notis);
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i == 0) {
            List<Notification> list = this.notis;
            i = list != null ? list.hashCode() : 1;
            this.hashCode = i;
        }
        return i;
    }

    public static final class Builder extends Message.Builder<Notifications> {
        public List<Notification> notis;

        public Builder() {
        }

        public Builder(Notifications notifications) {
            super(notifications);
            if (notifications != null) {
                this.notis = Notifications.copyOf(notifications.notis);
            }
        }

        public Builder notis(List<Notification> list) {
            this.notis = checkForNulls(list);
            return this;
        }

        public Notifications build() {
            return new Notifications(this);
        }
    }
}
