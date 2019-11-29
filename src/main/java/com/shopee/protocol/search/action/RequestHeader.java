package com.shopee.protocol.search.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class RequestHeader extends Message {
    public static final String DEFAULT_CLIENT_COUNTRY = "";
    public static final String DEFAULT_CLIENT_IP = "";
    public static final String DEFAULT_COUNTRY = "";
    public static final Long DEFAULT_EXPERIMENT = 0L;
    public static final String DEFAULT_FEATURE = "";
    public static final Boolean DEFAULT_IS_MONITOR = false;
    public static final Integer DEFAULT_PLATFORM = 0;
    public static final String DEFAULT_REQUESTID = "";
    public static final String DEFAULT_SESSIONID = "";
    public static final Integer DEFAULT_SHOPID = 0;
    public static final String DEFAULT_SOURCE = "";
    public static final List<Integer> DEFAULT_TAGS = Collections.emptyList();
    public static final String DEFAULT_TOKEN = "";
    public static final Integer DEFAULT_USERID = 0;
    public static final Integer DEFAULT_VERSION = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 12, type = Message.Datatype.STRING)
    public final String client_country;
    @ProtoField(tag = 11, type = Message.Datatype.STRING)
    public final String client_ip;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String country;
    @ProtoField(tag = 10, type = Message.Datatype.INT64)
    public final Long experiment;
    @ProtoField(tag = 13, type = Message.Datatype.STRING)
    public final String feature;
    @ProtoField(tag = 6, type = Message.Datatype.BOOL)
    public final Boolean is_monitor;
    @ProtoField(tag = 8, type = Message.Datatype.INT32)
    public final Integer platform;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(tag = 5, type = Message.Datatype.STRING)
    public final String sessionid;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer shopid;
    @ProtoField(tag = 7, type = Message.Datatype.STRING)
    public final String source;
    @ProtoField(label = Message.Label.REPEATED, tag = 15, type = Message.Datatype.INT32)
    public final List<Integer> tags;
    @ProtoField(tag = 9, type = Message.Datatype.STRING)
    public final String token;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer userid;
    @ProtoField(tag = 14, type = Message.Datatype.INT32)
    public final Integer version;

    public RequestHeader(String str, Integer num, String str2, Integer num2, String str3, Boolean bool, String str4, Integer num3, String str5, Long l, String str6, String str7, String str8, Integer num4, List<Integer> list) {
        this.requestid = str;
        this.userid = num;
        this.country = str2;
        this.shopid = num2;
        this.sessionid = str3;
        this.is_monitor = bool;
        this.source = str4;
        this.platform = num3;
        this.token = str5;
        this.experiment = l;
        this.client_ip = str6;
        this.client_country = str7;
        this.feature = str8;
        this.version = num4;
        this.tags = immutableCopyOf(list);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private RequestHeader(com.shopee.protocol.search.action.RequestHeader.Builder r18) {
        /*
            r17 = this;
            r0 = r18
            java.lang.String r2 = r0.requestid
            java.lang.Integer r3 = r0.userid
            java.lang.String r4 = r0.country
            java.lang.Integer r5 = r0.shopid
            java.lang.String r6 = r0.sessionid
            java.lang.Boolean r7 = r0.is_monitor
            java.lang.String r8 = r0.source
            java.lang.Integer r9 = r0.platform
            java.lang.String r10 = r0.token
            java.lang.Long r11 = r0.experiment
            java.lang.String r12 = r0.client_ip
            java.lang.String r13 = r0.client_country
            java.lang.String r14 = r0.feature
            java.lang.Integer r15 = r0.version
            java.util.List<java.lang.Integer> r1 = r0.tags
            r16 = r1
            r1 = r17
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16)
            r17.setBuilder(r18)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shopee.protocol.search.action.RequestHeader.<init>(com.shopee.protocol.search.action.RequestHeader$Builder):void");
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof RequestHeader)) {
            return false;
        }
        RequestHeader requestHeader = (RequestHeader) obj;
        if (!equals((Object) this.requestid, (Object) requestHeader.requestid) || !equals((Object) this.userid, (Object) requestHeader.userid) || !equals((Object) this.country, (Object) requestHeader.country) || !equals((Object) this.shopid, (Object) requestHeader.shopid) || !equals((Object) this.sessionid, (Object) requestHeader.sessionid) || !equals((Object) this.is_monitor, (Object) requestHeader.is_monitor) || !equals((Object) this.source, (Object) requestHeader.source) || !equals((Object) this.platform, (Object) requestHeader.platform) || !equals((Object) this.token, (Object) requestHeader.token) || !equals((Object) this.experiment, (Object) requestHeader.experiment) || !equals((Object) this.client_ip, (Object) requestHeader.client_ip) || !equals((Object) this.client_country, (Object) requestHeader.client_country) || !equals((Object) this.feature, (Object) requestHeader.feature) || !equals((Object) this.version, (Object) requestHeader.version) || !equals((List<?>) this.tags, (List<?>) requestHeader.tags)) {
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
        String str2 = this.country;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 37;
        Integer num2 = this.shopid;
        int hashCode4 = (hashCode3 + (num2 != null ? num2.hashCode() : 0)) * 37;
        String str3 = this.sessionid;
        int hashCode5 = (hashCode4 + (str3 != null ? str3.hashCode() : 0)) * 37;
        Boolean bool = this.is_monitor;
        int hashCode6 = (hashCode5 + (bool != null ? bool.hashCode() : 0)) * 37;
        String str4 = this.source;
        int hashCode7 = (hashCode6 + (str4 != null ? str4.hashCode() : 0)) * 37;
        Integer num3 = this.platform;
        int hashCode8 = (hashCode7 + (num3 != null ? num3.hashCode() : 0)) * 37;
        String str5 = this.token;
        int hashCode9 = (hashCode8 + (str5 != null ? str5.hashCode() : 0)) * 37;
        Long l = this.experiment;
        int hashCode10 = (hashCode9 + (l != null ? l.hashCode() : 0)) * 37;
        String str6 = this.client_ip;
        int hashCode11 = (hashCode10 + (str6 != null ? str6.hashCode() : 0)) * 37;
        String str7 = this.client_country;
        int hashCode12 = (hashCode11 + (str7 != null ? str7.hashCode() : 0)) * 37;
        String str8 = this.feature;
        int hashCode13 = (hashCode12 + (str8 != null ? str8.hashCode() : 0)) * 37;
        Integer num4 = this.version;
        if (num4 != null) {
            i2 = num4.hashCode();
        }
        int i3 = (hashCode13 + i2) * 37;
        List<Integer> list = this.tags;
        int hashCode14 = i3 + (list != null ? list.hashCode() : 1);
        this.hashCode = hashCode14;
        return hashCode14;
    }

    public static final class Builder extends Message.Builder<RequestHeader> {
        public String client_country;
        public String client_ip;
        public String country;
        public Long experiment;
        public String feature;
        public Boolean is_monitor;
        public Integer platform;
        public String requestid;
        public String sessionid;
        public Integer shopid;
        public String source;
        public List<Integer> tags;
        public String token;
        public Integer userid;
        public Integer version;

        public Builder() {
        }

        public Builder(RequestHeader requestHeader) {
            super(requestHeader);
            if (requestHeader != null) {
                this.requestid = requestHeader.requestid;
                this.userid = requestHeader.userid;
                this.country = requestHeader.country;
                this.shopid = requestHeader.shopid;
                this.sessionid = requestHeader.sessionid;
                this.is_monitor = requestHeader.is_monitor;
                this.source = requestHeader.source;
                this.platform = requestHeader.platform;
                this.token = requestHeader.token;
                this.experiment = requestHeader.experiment;
                this.client_ip = requestHeader.client_ip;
                this.client_country = requestHeader.client_country;
                this.feature = requestHeader.feature;
                this.version = requestHeader.version;
                this.tags = RequestHeader.copyOf(requestHeader.tags);
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

        public Builder country(String str) {
            this.country = str;
            return this;
        }

        public Builder shopid(Integer num) {
            this.shopid = num;
            return this;
        }

        public Builder sessionid(String str) {
            this.sessionid = str;
            return this;
        }

        public Builder is_monitor(Boolean bool) {
            this.is_monitor = bool;
            return this;
        }

        public Builder source(String str) {
            this.source = str;
            return this;
        }

        public Builder platform(Integer num) {
            this.platform = num;
            return this;
        }

        public Builder token(String str) {
            this.token = str;
            return this;
        }

        public Builder experiment(Long l) {
            this.experiment = l;
            return this;
        }

        public Builder client_ip(String str) {
            this.client_ip = str;
            return this;
        }

        public Builder client_country(String str) {
            this.client_country = str;
            return this;
        }

        public Builder feature(String str) {
            this.feature = str;
            return this;
        }

        public Builder version(Integer num) {
            this.version = num;
            return this;
        }

        public Builder tags(List<Integer> list) {
            this.tags = checkForNulls(list);
            return this;
        }

        public RequestHeader build() {
            return new RequestHeader(this);
        }
    }
}
