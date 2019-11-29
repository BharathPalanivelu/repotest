package com.shopee.live.livestreaming.sztracking.proto;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import e.f;

public final class Event extends Message {
    public static final f DEFAULT_BODY = f.f32736b;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 2, type = Message.Datatype.BYTES)
    public final f body;
    @ProtoField(tag = 1)
    public final Header header;

    public Event(Header header2, f fVar) {
        this.header = header2;
        this.body = fVar;
    }

    private Event(Builder builder) {
        this(builder.header, builder.body);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Event)) {
            return false;
        }
        Event event = (Event) obj;
        if (!equals((Object) this.header, (Object) event.header) || !equals((Object) this.body, (Object) event.body)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Header header2 = this.header;
        int i2 = 0;
        int hashCode = (header2 != null ? header2.hashCode() : 0) * 37;
        f fVar = this.body;
        if (fVar != null) {
            i2 = fVar.hashCode();
        }
        int i3 = hashCode + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<Event> {
        public f body;
        public Header header;

        public Builder() {
        }

        public Builder(Event event) {
            super(event);
            if (event != null) {
                this.header = event.header;
                this.body = event.body;
            }
        }

        public Builder header(Header header2) {
            this.header = header2;
            return this;
        }

        public Builder body(f fVar) {
            this.body = fVar;
            return this;
        }

        public Event build() {
            return new Event(this);
        }
    }
}
