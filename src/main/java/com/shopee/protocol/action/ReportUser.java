package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class ReportUser extends Message {
    public static final List<String> DEFAULT_IMAGES = Collections.emptyList();
    public static final String DEFAULT_REASON = "";
    public static final Integer DEFAULT_REASON_TYPE = 0;
    public static final String DEFAULT_REQUESTID = "";
    public static final String DEFAULT_TOKEN = "";
    public static final Integer DEFAULT_USERID = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(label = Message.Label.REPEATED, tag = 5, type = Message.Datatype.STRING)
    public final List<String> images;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String reason;
    @ProtoField(tag = 6, type = Message.Datatype.INT32)
    public final Integer reason_type;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String token;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2, type = Message.Datatype.INT32)
    public final Integer userid;

    public ReportUser(String str, Integer num, String str2, String str3, List<String> list, Integer num2) {
        this.requestid = str;
        this.userid = num;
        this.reason = str2;
        this.token = str3;
        this.images = immutableCopyOf(list);
        this.reason_type = num2;
    }

    private ReportUser(Builder builder) {
        this(builder.requestid, builder.userid, builder.reason, builder.token, builder.images, builder.reason_type);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ReportUser)) {
            return false;
        }
        ReportUser reportUser = (ReportUser) obj;
        if (!equals((Object) this.requestid, (Object) reportUser.requestid) || !equals((Object) this.userid, (Object) reportUser.userid) || !equals((Object) this.reason, (Object) reportUser.reason) || !equals((Object) this.token, (Object) reportUser.token) || !equals((List<?>) this.images, (List<?>) reportUser.images) || !equals((Object) this.reason_type, (Object) reportUser.reason_type)) {
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
        Integer num = this.userid;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 37;
        String str2 = this.reason;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 37;
        String str3 = this.token;
        int hashCode4 = (hashCode3 + (str3 != null ? str3.hashCode() : 0)) * 37;
        List<String> list = this.images;
        int hashCode5 = (hashCode4 + (list != null ? list.hashCode() : 1)) * 37;
        Integer num2 = this.reason_type;
        if (num2 != null) {
            i2 = num2.hashCode();
        }
        int i3 = hashCode5 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<ReportUser> {
        public List<String> images;
        public String reason;
        public Integer reason_type;
        public String requestid;
        public String token;
        public Integer userid;

        public Builder() {
        }

        public Builder(ReportUser reportUser) {
            super(reportUser);
            if (reportUser != null) {
                this.requestid = reportUser.requestid;
                this.userid = reportUser.userid;
                this.reason = reportUser.reason;
                this.token = reportUser.token;
                this.images = ReportUser.copyOf(reportUser.images);
                this.reason_type = reportUser.reason_type;
            }
        }

        public Builder requestid(String str) {
            this.requestid = str;
            return this;
        }

        public Builder userid(Integer num) {
            this.userid = num;
            return this;
        }

        public Builder reason(String str) {
            this.reason = str;
            return this;
        }

        public Builder token(String str) {
            this.token = str;
            return this;
        }

        public Builder images(List<String> list) {
            this.images = checkForNulls(list);
            return this;
        }

        public Builder reason_type(Integer num) {
            this.reason_type = num;
            return this;
        }

        public ReportUser build() {
            checkRequiredFields();
            return new ReportUser(this);
        }
    }
}
