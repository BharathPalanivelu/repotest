package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import e.f;
import java.util.Collections;
import java.util.List;

public final class BehaviorCheck extends Message {
    public static final String DEFAULT_APP_VERSION_NAME = "";
    public static final Integer DEFAULT_BEHAVIOR_TYPE = 0;
    public static final Integer DEFAULT_CHANNELID = 0;
    public static final String DEFAULT_COUNTRY = "";
    public static final f DEFAULT_DEVICEID = f.f32736b;
    public static final f DEFAULT_DEVICE_FINGERPRINT = f.f32736b;
    public static final Long DEFAULT_GB_GROUPID = 0L;
    public static final Boolean DEFAULT_IS_CREDIT_CARD = false;
    public static final List<OrderWithItems> DEFAULT_ORDERS = Collections.emptyList();
    public static final Long DEFAULT_PROMOTIONID = 0L;
    public static final String DEFAULT_REQUESTID = "";
    public static final String DEFAULT_RN_BUNDLE_NAME = "";
    public static final String DEFAULT_TONGDUN_BLACKBOX = "";
    public static final Long DEFAULT_TOTAL_PRICE = 0L;
    public static final Integer DEFAULT_USERID = 0;
    public static final Integer DEFAULT_USER_AGENT_TYPE = 0;
    public static final String DEFAULT_VOUCHER_CODE = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 16, type = Message.Datatype.STRING)
    public final String app_version_name;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer behavior_type;
    @ProtoField(tag = 8, type = Message.Datatype.INT32)
    public final Integer channelid;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String country;
    @ProtoField(tag = 11, type = Message.Datatype.BYTES)
    public final f device_fingerprint;
    @ProtoField(tag = 10, type = Message.Datatype.BYTES)
    public final f deviceid;
    @ProtoField(tag = 12, type = Message.Datatype.INT64)
    public final Long gb_groupid;
    @ProtoField(tag = 7, type = Message.Datatype.BOOL)
    public final Boolean is_credit_card;
    @ProtoField(label = Message.Label.REPEATED, messageType = OrderWithItems.class, tag = 5)
    public final List<OrderWithItems> orders;
    @ProtoField(tag = 15, type = Message.Datatype.INT64)
    public final Long promotionid;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(tag = 17, type = Message.Datatype.STRING)
    public final String rn_bundle_name;
    @ProtoField(tag = 13, type = Message.Datatype.STRING)
    public final String tongdun_blackbox;
    @ProtoField(tag = 9, type = Message.Datatype.INT64)
    public final Long total_price;
    @ProtoField(tag = 14, type = Message.Datatype.INT32)
    public final Integer user_agent_type;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer userid;
    @ProtoField(tag = 6, type = Message.Datatype.STRING)
    public final String voucher_code;

    public BehaviorCheck(String str, Integer num, String str2, Integer num2, List<OrderWithItems> list, String str3, Boolean bool, Integer num3, Long l, f fVar, f fVar2, Long l2, String str4, Integer num4, Long l3, String str5, String str6) {
        this.requestid = str;
        this.userid = num;
        this.country = str2;
        this.behavior_type = num2;
        this.orders = immutableCopyOf(list);
        this.voucher_code = str3;
        this.is_credit_card = bool;
        this.channelid = num3;
        this.total_price = l;
        this.deviceid = fVar;
        this.device_fingerprint = fVar2;
        this.gb_groupid = l2;
        this.tongdun_blackbox = str4;
        this.user_agent_type = num4;
        this.promotionid = l3;
        this.app_version_name = str5;
        this.rn_bundle_name = str6;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private BehaviorCheck(com.shopee.protocol.action.BehaviorCheck.Builder r21) {
        /*
            r20 = this;
            r0 = r21
            r1 = r20
            java.lang.String r2 = r0.requestid
            java.lang.Integer r3 = r0.userid
            java.lang.String r4 = r0.country
            java.lang.Integer r5 = r0.behavior_type
            java.util.List<com.shopee.protocol.action.OrderWithItems> r6 = r0.orders
            java.lang.String r7 = r0.voucher_code
            java.lang.Boolean r8 = r0.is_credit_card
            java.lang.Integer r9 = r0.channelid
            java.lang.Long r10 = r0.total_price
            e.f r11 = r0.deviceid
            e.f r12 = r0.device_fingerprint
            java.lang.Long r13 = r0.gb_groupid
            java.lang.String r14 = r0.tongdun_blackbox
            java.lang.Integer r15 = r0.user_agent_type
            r19 = r1
            java.lang.Long r1 = r0.promotionid
            r16 = r1
            java.lang.String r1 = r0.app_version_name
            r17 = r1
            java.lang.String r1 = r0.rn_bundle_name
            r18 = r1
            r1 = r19
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18)
            r20.setBuilder(r21)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shopee.protocol.action.BehaviorCheck.<init>(com.shopee.protocol.action.BehaviorCheck$Builder):void");
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BehaviorCheck)) {
            return false;
        }
        BehaviorCheck behaviorCheck = (BehaviorCheck) obj;
        if (!equals((Object) this.requestid, (Object) behaviorCheck.requestid) || !equals((Object) this.userid, (Object) behaviorCheck.userid) || !equals((Object) this.country, (Object) behaviorCheck.country) || !equals((Object) this.behavior_type, (Object) behaviorCheck.behavior_type) || !equals((List<?>) this.orders, (List<?>) behaviorCheck.orders) || !equals((Object) this.voucher_code, (Object) behaviorCheck.voucher_code) || !equals((Object) this.is_credit_card, (Object) behaviorCheck.is_credit_card) || !equals((Object) this.channelid, (Object) behaviorCheck.channelid) || !equals((Object) this.total_price, (Object) behaviorCheck.total_price) || !equals((Object) this.deviceid, (Object) behaviorCheck.deviceid) || !equals((Object) this.device_fingerprint, (Object) behaviorCheck.device_fingerprint) || !equals((Object) this.gb_groupid, (Object) behaviorCheck.gb_groupid) || !equals((Object) this.tongdun_blackbox, (Object) behaviorCheck.tongdun_blackbox) || !equals((Object) this.user_agent_type, (Object) behaviorCheck.user_agent_type) || !equals((Object) this.promotionid, (Object) behaviorCheck.promotionid) || !equals((Object) this.app_version_name, (Object) behaviorCheck.app_version_name) || !equals((Object) this.rn_bundle_name, (Object) behaviorCheck.rn_bundle_name)) {
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
        Integer num2 = this.behavior_type;
        int hashCode4 = (hashCode3 + (num2 != null ? num2.hashCode() : 0)) * 37;
        List<OrderWithItems> list = this.orders;
        int hashCode5 = (hashCode4 + (list != null ? list.hashCode() : 1)) * 37;
        String str3 = this.voucher_code;
        int hashCode6 = (hashCode5 + (str3 != null ? str3.hashCode() : 0)) * 37;
        Boolean bool = this.is_credit_card;
        int hashCode7 = (hashCode6 + (bool != null ? bool.hashCode() : 0)) * 37;
        Integer num3 = this.channelid;
        int hashCode8 = (hashCode7 + (num3 != null ? num3.hashCode() : 0)) * 37;
        Long l = this.total_price;
        int hashCode9 = (hashCode8 + (l != null ? l.hashCode() : 0)) * 37;
        f fVar = this.deviceid;
        int hashCode10 = (hashCode9 + (fVar != null ? fVar.hashCode() : 0)) * 37;
        f fVar2 = this.device_fingerprint;
        int hashCode11 = (hashCode10 + (fVar2 != null ? fVar2.hashCode() : 0)) * 37;
        Long l2 = this.gb_groupid;
        int hashCode12 = (hashCode11 + (l2 != null ? l2.hashCode() : 0)) * 37;
        String str4 = this.tongdun_blackbox;
        int hashCode13 = (hashCode12 + (str4 != null ? str4.hashCode() : 0)) * 37;
        Integer num4 = this.user_agent_type;
        int hashCode14 = (hashCode13 + (num4 != null ? num4.hashCode() : 0)) * 37;
        Long l3 = this.promotionid;
        int hashCode15 = (hashCode14 + (l3 != null ? l3.hashCode() : 0)) * 37;
        String str5 = this.app_version_name;
        int hashCode16 = (hashCode15 + (str5 != null ? str5.hashCode() : 0)) * 37;
        String str6 = this.rn_bundle_name;
        if (str6 != null) {
            i2 = str6.hashCode();
        }
        int i3 = hashCode16 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<BehaviorCheck> {
        public String app_version_name;
        public Integer behavior_type;
        public Integer channelid;
        public String country;
        public f device_fingerprint;
        public f deviceid;
        public Long gb_groupid;
        public Boolean is_credit_card;
        public List<OrderWithItems> orders;
        public Long promotionid;
        public String requestid;
        public String rn_bundle_name;
        public String tongdun_blackbox;
        public Long total_price;
        public Integer user_agent_type;
        public Integer userid;
        public String voucher_code;

        public Builder() {
        }

        public Builder(BehaviorCheck behaviorCheck) {
            super(behaviorCheck);
            if (behaviorCheck != null) {
                this.requestid = behaviorCheck.requestid;
                this.userid = behaviorCheck.userid;
                this.country = behaviorCheck.country;
                this.behavior_type = behaviorCheck.behavior_type;
                this.orders = BehaviorCheck.copyOf(behaviorCheck.orders);
                this.voucher_code = behaviorCheck.voucher_code;
                this.is_credit_card = behaviorCheck.is_credit_card;
                this.channelid = behaviorCheck.channelid;
                this.total_price = behaviorCheck.total_price;
                this.deviceid = behaviorCheck.deviceid;
                this.device_fingerprint = behaviorCheck.device_fingerprint;
                this.gb_groupid = behaviorCheck.gb_groupid;
                this.tongdun_blackbox = behaviorCheck.tongdun_blackbox;
                this.user_agent_type = behaviorCheck.user_agent_type;
                this.promotionid = behaviorCheck.promotionid;
                this.app_version_name = behaviorCheck.app_version_name;
                this.rn_bundle_name = behaviorCheck.rn_bundle_name;
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

        public Builder behavior_type(Integer num) {
            this.behavior_type = num;
            return this;
        }

        public Builder orders(List<OrderWithItems> list) {
            this.orders = checkForNulls(list);
            return this;
        }

        public Builder voucher_code(String str) {
            this.voucher_code = str;
            return this;
        }

        public Builder is_credit_card(Boolean bool) {
            this.is_credit_card = bool;
            return this;
        }

        public Builder channelid(Integer num) {
            this.channelid = num;
            return this;
        }

        public Builder total_price(Long l) {
            this.total_price = l;
            return this;
        }

        public Builder deviceid(f fVar) {
            this.deviceid = fVar;
            return this;
        }

        public Builder device_fingerprint(f fVar) {
            this.device_fingerprint = fVar;
            return this;
        }

        public Builder gb_groupid(Long l) {
            this.gb_groupid = l;
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

        public Builder promotionid(Long l) {
            this.promotionid = l;
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

        public BehaviorCheck build() {
            return new BehaviorCheck(this);
        }
    }
}
