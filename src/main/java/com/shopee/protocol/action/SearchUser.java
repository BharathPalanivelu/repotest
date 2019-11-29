package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class SearchUser extends Message {
    public static final String DEFAULT_COUNTRY = "";
    public static final Boolean DEFAULT_EXACT_ONLY = false;
    public static final Long DEFAULT_EXPERIMENT = 0L;
    public static final String DEFAULT_KEYWORD = "";
    public static final Integer DEFAULT_LIMIT = 0;
    public static final Boolean DEFAULT_OFFICIAL_ONLY = false;
    public static final Integer DEFAULT_OFFSET = 0;
    public static final Integer DEFAULT_PLATFORM = 0;
    public static final String DEFAULT_REQUESTID = "";
    public static final String DEFAULT_SESSIONID = "";
    public static final String DEFAULT_TOKEN = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 6, type = Message.Datatype.STRING)
    public final String country;
    @ProtoField(tag = 10, type = Message.Datatype.BOOL)
    public final Boolean exact_only;
    @ProtoField(tag = 11, type = Message.Datatype.INT64)
    public final Long experiment;
    @ProtoField(label = Message.Label.REQUIRED, tag = 3, type = Message.Datatype.STRING)
    public final String keyword;
    @ProtoField(tag = 5, type = Message.Datatype.INT32)
    public final Integer limit;
    @ProtoField(tag = 9, type = Message.Datatype.BOOL)
    public final Boolean official_only;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer offset;
    @ProtoField(tag = 12, type = Message.Datatype.INT32)
    public final Integer platform;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(tag = 8, type = Message.Datatype.STRING)
    public final String sessionid;
    @ProtoField(tag = 7, type = Message.Datatype.STRING)
    public final String token;

    public SearchUser(String str, String str2, Integer num, Integer num2, String str3, String str4, String str5, Boolean bool, Boolean bool2, Long l, Integer num3) {
        this.requestid = str;
        this.keyword = str2;
        this.offset = num;
        this.limit = num2;
        this.country = str3;
        this.token = str4;
        this.sessionid = str5;
        this.official_only = bool;
        this.exact_only = bool2;
        this.experiment = l;
        this.platform = num3;
    }

    private SearchUser(Builder builder) {
        this(builder.requestid, builder.keyword, builder.offset, builder.limit, builder.country, builder.token, builder.sessionid, builder.official_only, builder.exact_only, builder.experiment, builder.platform);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SearchUser)) {
            return false;
        }
        SearchUser searchUser = (SearchUser) obj;
        if (!equals((Object) this.requestid, (Object) searchUser.requestid) || !equals((Object) this.keyword, (Object) searchUser.keyword) || !equals((Object) this.offset, (Object) searchUser.offset) || !equals((Object) this.limit, (Object) searchUser.limit) || !equals((Object) this.country, (Object) searchUser.country) || !equals((Object) this.token, (Object) searchUser.token) || !equals((Object) this.sessionid, (Object) searchUser.sessionid) || !equals((Object) this.official_only, (Object) searchUser.official_only) || !equals((Object) this.exact_only, (Object) searchUser.exact_only) || !equals((Object) this.experiment, (Object) searchUser.experiment) || !equals((Object) this.platform, (Object) searchUser.platform)) {
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
        String str2 = this.keyword;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 37;
        Integer num = this.offset;
        int hashCode3 = (hashCode2 + (num != null ? num.hashCode() : 0)) * 37;
        Integer num2 = this.limit;
        int hashCode4 = (hashCode3 + (num2 != null ? num2.hashCode() : 0)) * 37;
        String str3 = this.country;
        int hashCode5 = (hashCode4 + (str3 != null ? str3.hashCode() : 0)) * 37;
        String str4 = this.token;
        int hashCode6 = (hashCode5 + (str4 != null ? str4.hashCode() : 0)) * 37;
        String str5 = this.sessionid;
        int hashCode7 = (hashCode6 + (str5 != null ? str5.hashCode() : 0)) * 37;
        Boolean bool = this.official_only;
        int hashCode8 = (hashCode7 + (bool != null ? bool.hashCode() : 0)) * 37;
        Boolean bool2 = this.exact_only;
        int hashCode9 = (hashCode8 + (bool2 != null ? bool2.hashCode() : 0)) * 37;
        Long l = this.experiment;
        int hashCode10 = (hashCode9 + (l != null ? l.hashCode() : 0)) * 37;
        Integer num3 = this.platform;
        if (num3 != null) {
            i2 = num3.hashCode();
        }
        int i3 = hashCode10 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<SearchUser> {
        public String country;
        public Boolean exact_only;
        public Long experiment;
        public String keyword;
        public Integer limit;
        public Boolean official_only;
        public Integer offset;
        public Integer platform;
        public String requestid;
        public String sessionid;
        public String token;

        public Builder() {
        }

        public Builder(SearchUser searchUser) {
            super(searchUser);
            if (searchUser != null) {
                this.requestid = searchUser.requestid;
                this.keyword = searchUser.keyword;
                this.offset = searchUser.offset;
                this.limit = searchUser.limit;
                this.country = searchUser.country;
                this.token = searchUser.token;
                this.sessionid = searchUser.sessionid;
                this.official_only = searchUser.official_only;
                this.exact_only = searchUser.exact_only;
                this.experiment = searchUser.experiment;
                this.platform = searchUser.platform;
            }
        }

        public Builder requestid(String str) {
            this.requestid = str;
            return this;
        }

        public Builder keyword(String str) {
            this.keyword = str;
            return this;
        }

        public Builder offset(Integer num) {
            this.offset = num;
            return this;
        }

        public Builder limit(Integer num) {
            this.limit = num;
            return this;
        }

        public Builder country(String str) {
            this.country = str;
            return this;
        }

        public Builder token(String str) {
            this.token = str;
            return this;
        }

        public Builder sessionid(String str) {
            this.sessionid = str;
            return this;
        }

        public Builder official_only(Boolean bool) {
            this.official_only = bool;
            return this;
        }

        public Builder exact_only(Boolean bool) {
            this.exact_only = bool;
            return this;
        }

        public Builder experiment(Long l) {
            this.experiment = l;
            return this;
        }

        public Builder platform(Integer num) {
            this.platform = num;
            return this;
        }

        public SearchUser build() {
            checkRequiredFields();
            return new SearchUser(this);
        }
    }
}
