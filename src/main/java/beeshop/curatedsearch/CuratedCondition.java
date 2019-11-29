package beeshop.curatedsearch;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class CuratedCondition extends Message {
    public static final List<Integer> DEFAULT_BLOCKED_PLATFORMS = Collections.emptyList();
    public static final List<Integer> DEFAULT_CATID = Collections.emptyList();
    public static final Integer DEFAULT_DUMMY = 0;
    public static final List<String> DEFAULT_KEYWORD = Collections.emptyList();
    public static final List<String> DEFAULT_ORIGIN_KEYWORD = Collections.emptyList();
    public static final List<TimeRange> DEFAULT_TIME_RANGES = Collections.emptyList();
    private static final long serialVersionUID = 0;
    @ProtoField(label = Message.Label.REPEATED, tag = 5, type = Message.Datatype.INT32)
    public final List<Integer> blocked_platforms;
    @ProtoField(label = Message.Label.REPEATED, tag = 4, type = Message.Datatype.INT32)
    public final List<Integer> catid;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer dummy;
    @ProtoField(label = Message.Label.REPEATED, tag = 1, type = Message.Datatype.STRING)
    public final List<String> keyword;
    @ProtoField(label = Message.Label.REPEATED, tag = 3, type = Message.Datatype.STRING)
    public final List<String> origin_keyword;
    @ProtoField(label = Message.Label.REPEATED, messageType = TimeRange.class, tag = 6)
    public final List<TimeRange> time_ranges;

    public CuratedCondition(List<String> list, Integer num, List<String> list2, List<Integer> list3, List<Integer> list4, List<TimeRange> list5) {
        this.keyword = immutableCopyOf(list);
        this.dummy = num;
        this.origin_keyword = immutableCopyOf(list2);
        this.catid = immutableCopyOf(list3);
        this.blocked_platforms = immutableCopyOf(list4);
        this.time_ranges = immutableCopyOf(list5);
    }

    private CuratedCondition(Builder builder) {
        this(builder.keyword, builder.dummy, builder.origin_keyword, builder.catid, builder.blocked_platforms, builder.time_ranges);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CuratedCondition)) {
            return false;
        }
        CuratedCondition curatedCondition = (CuratedCondition) obj;
        if (!equals((List<?>) this.keyword, (List<?>) curatedCondition.keyword) || !equals((Object) this.dummy, (Object) curatedCondition.dummy) || !equals((List<?>) this.origin_keyword, (List<?>) curatedCondition.origin_keyword) || !equals((List<?>) this.catid, (List<?>) curatedCondition.catid) || !equals((List<?>) this.blocked_platforms, (List<?>) curatedCondition.blocked_platforms) || !equals((List<?>) this.time_ranges, (List<?>) curatedCondition.time_ranges)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        List<String> list = this.keyword;
        int i2 = 1;
        int hashCode = (list != null ? list.hashCode() : 1) * 37;
        Integer num = this.dummy;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 37;
        List<String> list2 = this.origin_keyword;
        int hashCode3 = (hashCode2 + (list2 != null ? list2.hashCode() : 1)) * 37;
        List<Integer> list3 = this.catid;
        int hashCode4 = (hashCode3 + (list3 != null ? list3.hashCode() : 1)) * 37;
        List<Integer> list4 = this.blocked_platforms;
        int hashCode5 = (hashCode4 + (list4 != null ? list4.hashCode() : 1)) * 37;
        List<TimeRange> list5 = this.time_ranges;
        if (list5 != null) {
            i2 = list5.hashCode();
        }
        int i3 = hashCode5 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<CuratedCondition> {
        public List<Integer> blocked_platforms;
        public List<Integer> catid;
        public Integer dummy;
        public List<String> keyword;
        public List<String> origin_keyword;
        public List<TimeRange> time_ranges;

        public Builder() {
        }

        public Builder(CuratedCondition curatedCondition) {
            super(curatedCondition);
            if (curatedCondition != null) {
                this.keyword = CuratedCondition.copyOf(curatedCondition.keyword);
                this.dummy = curatedCondition.dummy;
                this.origin_keyword = CuratedCondition.copyOf(curatedCondition.origin_keyword);
                this.catid = CuratedCondition.copyOf(curatedCondition.catid);
                this.blocked_platforms = CuratedCondition.copyOf(curatedCondition.blocked_platforms);
                this.time_ranges = CuratedCondition.copyOf(curatedCondition.time_ranges);
            }
        }

        public Builder keyword(List<String> list) {
            this.keyword = checkForNulls(list);
            return this;
        }

        public Builder dummy(Integer num) {
            this.dummy = num;
            return this;
        }

        public Builder origin_keyword(List<String> list) {
            this.origin_keyword = checkForNulls(list);
            return this;
        }

        public Builder catid(List<Integer> list) {
            this.catid = checkForNulls(list);
            return this;
        }

        public Builder blocked_platforms(List<Integer> list) {
            this.blocked_platforms = checkForNulls(list);
            return this;
        }

        public Builder time_ranges(List<TimeRange> list) {
            this.time_ranges = checkForNulls(list);
            return this;
        }

        public CuratedCondition build() {
            return new CuratedCondition(this);
        }
    }
}
