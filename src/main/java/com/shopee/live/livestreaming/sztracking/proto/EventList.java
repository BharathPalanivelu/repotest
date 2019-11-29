package com.shopee.live.livestreaming.sztracking.proto;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class EventList extends Message {
    public static final List<Event> DEFAULT_EVENTS = Collections.emptyList();
    private static final long serialVersionUID = 0;
    @ProtoField(label = Message.Label.REPEATED, messageType = Event.class, tag = 1)
    public final List<Event> events;

    public EventList(List<Event> list) {
        this.events = immutableCopyOf(list);
    }

    private EventList(Builder builder) {
        this(builder.events);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof EventList)) {
            return false;
        }
        return equals((List<?>) this.events, (List<?>) ((EventList) obj).events);
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i == 0) {
            List<Event> list = this.events;
            i = list != null ? list.hashCode() : 1;
            this.hashCode = i;
        }
        return i;
    }

    public static final class Builder extends Message.Builder<EventList> {
        public List<Event> events;

        public Builder() {
        }

        public Builder(EventList eventList) {
            super(eventList);
            if (eventList != null) {
                this.events = EventList.copyOf(eventList.events);
            }
        }

        public Builder events(List<Event> list) {
            this.events = checkForNulls(list);
            return this;
        }

        public EventList build() {
            return new EventList(this);
        }
    }
}
