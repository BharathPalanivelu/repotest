package beeshop.curatedsearch;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class TimeRange extends Message {
    public static final Long DEFAULT_END_TIME = 0L;
    public static final Long DEFAULT_START_TIME = 0L;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 2, type = Message.Datatype.INT64)
    public final Long end_time;
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long start_time;

    public TimeRange(Long l, Long l2) {
        this.start_time = l;
        this.end_time = l2;
    }

    private TimeRange(Builder builder) {
        this(builder.start_time, builder.end_time);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof TimeRange)) {
            return false;
        }
        TimeRange timeRange = (TimeRange) obj;
        if (!equals((Object) this.start_time, (Object) timeRange.start_time) || !equals((Object) this.end_time, (Object) timeRange.end_time)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Long l = this.start_time;
        int i2 = 0;
        int hashCode = (l != null ? l.hashCode() : 0) * 37;
        Long l2 = this.end_time;
        if (l2 != null) {
            i2 = l2.hashCode();
        }
        int i3 = hashCode + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<TimeRange> {
        public Long end_time;
        public Long start_time;

        public Builder() {
        }

        public Builder(TimeRange timeRange) {
            super(timeRange);
            if (timeRange != null) {
                this.start_time = timeRange.start_time;
                this.end_time = timeRange.end_time;
            }
        }

        public Builder start_time(Long l) {
            this.start_time = l;
            return this;
        }

        public Builder end_time(Long l) {
            this.end_time = l;
            return this;
        }

        public TimeRange build() {
            return new TimeRange(this);
        }
    }
}
