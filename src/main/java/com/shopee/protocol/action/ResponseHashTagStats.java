package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class ResponseHashTagStats extends Message {
    public static final Integer DEFAULT_ERRCODE = 0;
    public static final List<String> DEFAULT_MOST_USED = Collections.emptyList();
    public static final List<String> DEFAULT_NEWLY_CREATE = Collections.emptyList();
    public static final String DEFAULT_REQUESTID = "";
    public static final List<String> DEFAULT_VISIT_POP = Collections.emptyList();
    public static final List<String> DEFAULT_VISIT_TREND = Collections.emptyList();
    private static final long serialVersionUID = 0;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2, type = Message.Datatype.INT32)
    public final Integer errcode;
    @ProtoField(label = Message.Label.REPEATED, tag = 5, type = Message.Datatype.STRING)
    public final List<String> most_used;
    @ProtoField(label = Message.Label.REPEATED, tag = 4, type = Message.Datatype.STRING)
    public final List<String> newly_create;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(label = Message.Label.REPEATED, tag = 6, type = Message.Datatype.STRING)
    public final List<String> visit_pop;
    @ProtoField(label = Message.Label.REPEATED, tag = 7, type = Message.Datatype.STRING)
    public final List<String> visit_trend;

    public ResponseHashTagStats(String str, Integer num, List<String> list, List<String> list2, List<String> list3, List<String> list4) {
        this.requestid = str;
        this.errcode = num;
        this.newly_create = immutableCopyOf(list);
        this.most_used = immutableCopyOf(list2);
        this.visit_pop = immutableCopyOf(list3);
        this.visit_trend = immutableCopyOf(list4);
    }

    private ResponseHashTagStats(Builder builder) {
        this(builder.requestid, builder.errcode, builder.newly_create, builder.most_used, builder.visit_pop, builder.visit_trend);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ResponseHashTagStats)) {
            return false;
        }
        ResponseHashTagStats responseHashTagStats = (ResponseHashTagStats) obj;
        if (!equals((Object) this.requestid, (Object) responseHashTagStats.requestid) || !equals((Object) this.errcode, (Object) responseHashTagStats.errcode) || !equals((List<?>) this.newly_create, (List<?>) responseHashTagStats.newly_create) || !equals((List<?>) this.most_used, (List<?>) responseHashTagStats.most_used) || !equals((List<?>) this.visit_pop, (List<?>) responseHashTagStats.visit_pop) || !equals((List<?>) this.visit_trend, (List<?>) responseHashTagStats.visit_trend)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        String str = this.requestid;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 37;
        Integer num = this.errcode;
        if (num != null) {
            i2 = num.hashCode();
        }
        int i3 = (hashCode + i2) * 37;
        List<String> list = this.newly_create;
        int i4 = 1;
        int hashCode2 = (i3 + (list != null ? list.hashCode() : 1)) * 37;
        List<String> list2 = this.most_used;
        int hashCode3 = (hashCode2 + (list2 != null ? list2.hashCode() : 1)) * 37;
        List<String> list3 = this.visit_pop;
        int hashCode4 = (hashCode3 + (list3 != null ? list3.hashCode() : 1)) * 37;
        List<String> list4 = this.visit_trend;
        if (list4 != null) {
            i4 = list4.hashCode();
        }
        int i5 = hashCode4 + i4;
        this.hashCode = i5;
        return i5;
    }

    public static final class Builder extends Message.Builder<ResponseHashTagStats> {
        public Integer errcode;
        public List<String> most_used;
        public List<String> newly_create;
        public String requestid;
        public List<String> visit_pop;
        public List<String> visit_trend;

        public Builder() {
        }

        public Builder(ResponseHashTagStats responseHashTagStats) {
            super(responseHashTagStats);
            if (responseHashTagStats != null) {
                this.requestid = responseHashTagStats.requestid;
                this.errcode = responseHashTagStats.errcode;
                this.newly_create = ResponseHashTagStats.copyOf(responseHashTagStats.newly_create);
                this.most_used = ResponseHashTagStats.copyOf(responseHashTagStats.most_used);
                this.visit_pop = ResponseHashTagStats.copyOf(responseHashTagStats.visit_pop);
                this.visit_trend = ResponseHashTagStats.copyOf(responseHashTagStats.visit_trend);
            }
        }

        public Builder requestid(String str) {
            this.requestid = str;
            return this;
        }

        public Builder errcode(Integer num) {
            this.errcode = num;
            return this;
        }

        public Builder newly_create(List<String> list) {
            this.newly_create = checkForNulls(list);
            return this;
        }

        public Builder most_used(List<String> list) {
            this.most_used = checkForNulls(list);
            return this;
        }

        public Builder visit_pop(List<String> list) {
            this.visit_pop = checkForNulls(list);
            return this;
        }

        public Builder visit_trend(List<String> list) {
            this.visit_trend = checkForNulls(list);
            return this;
        }

        public ResponseHashTagStats build() {
            checkRequiredFields();
            return new ResponseHashTagStats(this);
        }
    }
}
