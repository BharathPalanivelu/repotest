package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import e.f;
import java.util.Collections;
import java.util.List;

public final class TongdunInfo extends Message {
    public static final String DEFAULT_APP_VERSION_NAME = "";
    public static final List<Long> DEFAULT_CHECKOUTIDS = Collections.emptyList();
    public static final String DEFAULT_COUNTRY = "";
    public static final f DEFAULT_DEVICE_FINGERPRINT = f.f32736b;
    public static final Boolean DEFAULT_IS_SHADOW = false;
    public static final String DEFAULT_REQUESTID = "";
    public static final String DEFAULT_RN_BUNDLE_NAME = "";
    public static final String DEFAULT_TONGDUN_BLACKBOX = "";
    public static final Integer DEFAULT_USERID = 0;
    public static final Integer DEFAULT_USER_AGENT_TYPE = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 9, type = Message.Datatype.STRING)
    public final String app_version_name;
    @ProtoField(label = Message.Label.REPEATED, tag = 3, type = Message.Datatype.INT64)
    public final List<Long> checkoutids;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String country;
    @ProtoField(tag = 8, type = Message.Datatype.BYTES)
    public final f device_fingerprint;
    @ProtoField(tag = 7, type = Message.Datatype.BOOL)
    public final Boolean is_shadow;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(tag = 10, type = Message.Datatype.STRING)
    public final String rn_bundle_name;
    @ProtoField(tag = 5, type = Message.Datatype.STRING)
    public final String tongdun_blackbox;
    @ProtoField(tag = 6, type = Message.Datatype.INT32)
    public final Integer user_agent_type;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer userid;

    public TongdunInfo(String str, Integer num, List<Long> list, String str2, String str3, Integer num2, Boolean bool, f fVar, String str4, String str5) {
        this.requestid = str;
        this.userid = num;
        this.checkoutids = immutableCopyOf(list);
        this.country = str2;
        this.tongdun_blackbox = str3;
        this.user_agent_type = num2;
        this.is_shadow = bool;
        this.device_fingerprint = fVar;
        this.app_version_name = str4;
        this.rn_bundle_name = str5;
    }

    private TongdunInfo(Builder builder) {
        this(builder.requestid, builder.userid, builder.checkoutids, builder.country, builder.tongdun_blackbox, builder.user_agent_type, builder.is_shadow, builder.device_fingerprint, builder.app_version_name, builder.rn_bundle_name);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof TongdunInfo)) {
            return false;
        }
        TongdunInfo tongdunInfo = (TongdunInfo) obj;
        if (!equals((Object) this.requestid, (Object) tongdunInfo.requestid) || !equals((Object) this.userid, (Object) tongdunInfo.userid) || !equals((List<?>) this.checkoutids, (List<?>) tongdunInfo.checkoutids) || !equals((Object) this.country, (Object) tongdunInfo.country) || !equals((Object) this.tongdun_blackbox, (Object) tongdunInfo.tongdun_blackbox) || !equals((Object) this.user_agent_type, (Object) tongdunInfo.user_agent_type) || !equals((Object) this.is_shadow, (Object) tongdunInfo.is_shadow) || !equals((Object) this.device_fingerprint, (Object) tongdunInfo.device_fingerprint) || !equals((Object) this.app_version_name, (Object) tongdunInfo.app_version_name) || !equals((Object) this.rn_bundle_name, (Object) tongdunInfo.rn_bundle_name)) {
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
        List<Long> list = this.checkoutids;
        int hashCode3 = (hashCode2 + (list != null ? list.hashCode() : 1)) * 37;
        String str2 = this.country;
        int hashCode4 = (hashCode3 + (str2 != null ? str2.hashCode() : 0)) * 37;
        String str3 = this.tongdun_blackbox;
        int hashCode5 = (hashCode4 + (str3 != null ? str3.hashCode() : 0)) * 37;
        Integer num2 = this.user_agent_type;
        int hashCode6 = (hashCode5 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Boolean bool = this.is_shadow;
        int hashCode7 = (hashCode6 + (bool != null ? bool.hashCode() : 0)) * 37;
        f fVar = this.device_fingerprint;
        int hashCode8 = (hashCode7 + (fVar != null ? fVar.hashCode() : 0)) * 37;
        String str4 = this.app_version_name;
        int hashCode9 = (hashCode8 + (str4 != null ? str4.hashCode() : 0)) * 37;
        String str5 = this.rn_bundle_name;
        if (str5 != null) {
            i2 = str5.hashCode();
        }
        int i3 = hashCode9 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<TongdunInfo> {
        public String app_version_name;
        public List<Long> checkoutids;
        public String country;
        public f device_fingerprint;
        public Boolean is_shadow;
        public String requestid;
        public String rn_bundle_name;
        public String tongdun_blackbox;
        public Integer user_agent_type;
        public Integer userid;

        public Builder() {
        }

        public Builder(TongdunInfo tongdunInfo) {
            super(tongdunInfo);
            if (tongdunInfo != null) {
                this.requestid = tongdunInfo.requestid;
                this.userid = tongdunInfo.userid;
                this.checkoutids = TongdunInfo.copyOf(tongdunInfo.checkoutids);
                this.country = tongdunInfo.country;
                this.tongdun_blackbox = tongdunInfo.tongdun_blackbox;
                this.user_agent_type = tongdunInfo.user_agent_type;
                this.is_shadow = tongdunInfo.is_shadow;
                this.device_fingerprint = tongdunInfo.device_fingerprint;
                this.app_version_name = tongdunInfo.app_version_name;
                this.rn_bundle_name = tongdunInfo.rn_bundle_name;
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

        public Builder checkoutids(List<Long> list) {
            this.checkoutids = checkForNulls(list);
            return this;
        }

        public Builder country(String str) {
            this.country = str;
            return this;
        }

        public Builder tongdun_blackbox(String str) {
            this.tongdun_blackbox = str;
            return this;
        }

        public Builder user_agent_type(Integer num) {
            this.user_agent_type = num;
            return this;
        }

        public Builder is_shadow(Boolean bool) {
            this.is_shadow = bool;
            return this;
        }

        public Builder device_fingerprint(f fVar) {
            this.device_fingerprint = fVar;
            return this;
        }

        public Builder app_version_name(String str) {
            this.app_version_name = str;
            return this;
        }

        public Builder rn_bundle_name(String str) {
            this.rn_bundle_name = str;
            return this;
        }

        public TongdunInfo build() {
            return new TongdunInfo(this);
        }
    }
}
