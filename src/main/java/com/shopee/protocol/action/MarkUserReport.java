package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class MarkUserReport extends Message {
    public static final List<Integer> DEFAULT_AUDITID = Collections.emptyList();
    public static final String DEFAULT_REQUESTID = "";
    public static final Integer DEFAULT_STATUS = 0;
    public static final List<Integer> DEFAULT_USERID = Collections.emptyList();
    private static final long serialVersionUID = 0;
    @ProtoField(label = Message.Label.REPEATED, tag = 4, type = Message.Datatype.INT32)
    public final List<Integer> auditid;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer status;
    @ProtoField(label = Message.Label.REPEATED, tag = 2, type = Message.Datatype.INT32)
    public final List<Integer> userid;

    public MarkUserReport(String str, List<Integer> list, Integer num, List<Integer> list2) {
        this.requestid = str;
        this.userid = immutableCopyOf(list);
        this.status = num;
        this.auditid = immutableCopyOf(list2);
    }

    private MarkUserReport(Builder builder) {
        this(builder.requestid, builder.userid, builder.status, builder.auditid);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof MarkUserReport)) {
            return false;
        }
        MarkUserReport markUserReport = (MarkUserReport) obj;
        if (!equals((Object) this.requestid, (Object) markUserReport.requestid) || !equals((List<?>) this.userid, (List<?>) markUserReport.userid) || !equals((Object) this.status, (Object) markUserReport.status) || !equals((List<?>) this.auditid, (List<?>) markUserReport.auditid)) {
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
        List<Integer> list = this.userid;
        int i3 = 1;
        int hashCode2 = (hashCode + (list != null ? list.hashCode() : 1)) * 37;
        Integer num = this.status;
        if (num != null) {
            i2 = num.hashCode();
        }
        int i4 = (hashCode2 + i2) * 37;
        List<Integer> list2 = this.auditid;
        if (list2 != null) {
            i3 = list2.hashCode();
        }
        int i5 = i4 + i3;
        this.hashCode = i5;
        return i5;
    }

    public static final class Builder extends Message.Builder<MarkUserReport> {
        public List<Integer> auditid;
        public String requestid;
        public Integer status;
        public List<Integer> userid;

        public Builder() {
        }

        public Builder(MarkUserReport markUserReport) {
            super(markUserReport);
            if (markUserReport != null) {
                this.requestid = markUserReport.requestid;
                this.userid = MarkUserReport.copyOf(markUserReport.userid);
                this.status = markUserReport.status;
                this.auditid = MarkUserReport.copyOf(markUserReport.auditid);
            }
        }

        public Builder requestid(String str) {
            this.requestid = str;
            return this;
        }

        public Builder userid(List<Integer> list) {
            this.userid = checkForNulls(list);
            return this;
        }

        public Builder status(Integer num) {
            this.status = num;
            return this;
        }

        public Builder auditid(List<Integer> list) {
            this.auditid = checkForNulls(list);
            return this;
        }

        public MarkUserReport build() {
            return new MarkUserReport(this);
        }
    }
}
