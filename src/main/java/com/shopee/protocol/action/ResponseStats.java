package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class ResponseStats extends Message {
    public static final Integer DEFAULT_BEGIN_DATE = 0;
    public static final Integer DEFAULT_END_DATE = 0;
    public static final Integer DEFAULT_ERRCODE = 0;
    public static final List<Stat> DEFAULT_INCOME = Collections.emptyList();
    public static final List<Stat> DEFAULT_ORDERS = Collections.emptyList();
    public static final String DEFAULT_REQUESTID = "";
    public static final List<Stat> DEFAULT_VISITS = Collections.emptyList();
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer begin_date;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer end_date;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2, type = Message.Datatype.INT32)
    public final Integer errcode;
    @ProtoField(label = Message.Label.REPEATED, messageType = Stat.class, tag = 6)
    public final List<Stat> income;
    @ProtoField(label = Message.Label.REPEATED, messageType = Stat.class, tag = 5)
    public final List<Stat> orders;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(label = Message.Label.REPEATED, messageType = Stat.class, tag = 7)
    public final List<Stat> visits;

    public ResponseStats(String str, Integer num, Integer num2, Integer num3, List<Stat> list, List<Stat> list2, List<Stat> list3) {
        this.requestid = str;
        this.errcode = num;
        this.begin_date = num2;
        this.end_date = num3;
        this.orders = immutableCopyOf(list);
        this.income = immutableCopyOf(list2);
        this.visits = immutableCopyOf(list3);
    }

    private ResponseStats(Builder builder) {
        this(builder.requestid, builder.errcode, builder.begin_date, builder.end_date, builder.orders, builder.income, builder.visits);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ResponseStats)) {
            return false;
        }
        ResponseStats responseStats = (ResponseStats) obj;
        if (!equals((Object) this.requestid, (Object) responseStats.requestid) || !equals((Object) this.errcode, (Object) responseStats.errcode) || !equals((Object) this.begin_date, (Object) responseStats.begin_date) || !equals((Object) this.end_date, (Object) responseStats.end_date) || !equals((List<?>) this.orders, (List<?>) responseStats.orders) || !equals((List<?>) this.income, (List<?>) responseStats.income) || !equals((List<?>) this.visits, (List<?>) responseStats.visits)) {
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
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 37;
        Integer num2 = this.begin_date;
        int hashCode3 = (hashCode2 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Integer num3 = this.end_date;
        if (num3 != null) {
            i2 = num3.hashCode();
        }
        int i3 = (hashCode3 + i2) * 37;
        List<Stat> list = this.orders;
        int i4 = 1;
        int hashCode4 = (i3 + (list != null ? list.hashCode() : 1)) * 37;
        List<Stat> list2 = this.income;
        int hashCode5 = (hashCode4 + (list2 != null ? list2.hashCode() : 1)) * 37;
        List<Stat> list3 = this.visits;
        if (list3 != null) {
            i4 = list3.hashCode();
        }
        int i5 = hashCode5 + i4;
        this.hashCode = i5;
        return i5;
    }

    public static final class Builder extends Message.Builder<ResponseStats> {
        public Integer begin_date;
        public Integer end_date;
        public Integer errcode;
        public List<Stat> income;
        public List<Stat> orders;
        public String requestid;
        public List<Stat> visits;

        public Builder() {
        }

        public Builder(ResponseStats responseStats) {
            super(responseStats);
            if (responseStats != null) {
                this.requestid = responseStats.requestid;
                this.errcode = responseStats.errcode;
                this.begin_date = responseStats.begin_date;
                this.end_date = responseStats.end_date;
                this.orders = ResponseStats.copyOf(responseStats.orders);
                this.income = ResponseStats.copyOf(responseStats.income);
                this.visits = ResponseStats.copyOf(responseStats.visits);
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

        public Builder begin_date(Integer num) {
            this.begin_date = num;
            return this;
        }

        public Builder end_date(Integer num) {
            this.end_date = num;
            return this;
        }

        public Builder orders(List<Stat> list) {
            this.orders = checkForNulls(list);
            return this;
        }

        public Builder income(List<Stat> list) {
            this.income = checkForNulls(list);
            return this;
        }

        public Builder visits(List<Stat> list) {
            this.visits = checkForNulls(list);
            return this;
        }

        public ResponseStats build() {
            checkRequiredFields();
            return new ResponseStats(this);
        }
    }
}
