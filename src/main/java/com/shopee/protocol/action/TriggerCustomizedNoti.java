package com.shopee.protocol.action;

import com.shopee.protocol.shop.WebPush;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class TriggerCustomizedNoti extends Message {
    public static final String DEFAULT_ACTION_APP_PATH = "";
    public static final String DEFAULT_ACTION_REACTNATIVE_PATH = "";
    public static final Integer DEFAULT_ACTION_REDIRECT_TYPE = 0;
    public static final String DEFAULT_CONTENT = "";
    public static final String DEFAULT_CONTENT_IMAGE = "";
    public static final String DEFAULT_DEVICEID = "";
    public static final Long DEFAULT_ITEMID = 0L;
    public static final Long DEFAULT_LAST_SENT_ID = 0L;
    public static final Integer DEFAULT_LAST_SENT_USERID = 0;
    public static final Integer DEFAULT_NOTICODE = 0;
    public static final Integer DEFAULT_NOTI_LINK_PAGE = 0;
    public static final Long DEFAULT_ORDERID = 0L;
    public static final String DEFAULT_PUSH_REDIRECT = "";
    public static final String DEFAULT_PUSH_TITLE = "";
    public static final String DEFAULT_REQUESTID = "";
    public static final Integer DEFAULT_SHOPID = 0;
    public static final String DEFAULT_SIMPLE_NAV_STR = "";
    public static final Integer DEFAULT_SPECIFIED_ACTION_CATE = 0;
    public static final Integer DEFAULT_TOTAL_SENT = 0;
    public static final Integer DEFAULT_TOTAL_SENT_TEST = 0;
    public static final Integer DEFAULT_TOTAL_USER_CREATED = 0;
    public static final Integer DEFAULT_TO_USERID = 0;
    public static final Integer DEFAULT_TYPE = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 20, type = Message.Datatype.STRING)
    public final String action_app_path;
    @ProtoField(tag = 21, type = Message.Datatype.STRING)
    public final String action_reactnative_path;
    @ProtoField(tag = 19, type = Message.Datatype.INT32)
    public final Integer action_redirect_type;
    @ProtoField(tag = 2)
    public final BackendParam bparam;
    @ProtoField(tag = 9, type = Message.Datatype.STRING)
    public final String content;
    @ProtoField(tag = 16, type = Message.Datatype.STRING)
    public final String content_image;
    @ProtoField(tag = 15, type = Message.Datatype.STRING)
    public final String deviceid;
    @ProtoField(tag = 6, type = Message.Datatype.INT64)
    public final Long itemid;
    @ProtoField(tag = 22, type = Message.Datatype.INT64)
    public final Long last_sent_id;
    @ProtoField(tag = 23, type = Message.Datatype.INT32)
    public final Integer last_sent_userid;
    @ProtoField(tag = 28)
    public final MarketPushSendingInfo mp_sending_info;
    @ProtoField(tag = 10, type = Message.Datatype.INT32)
    public final Integer noti_link_page;
    @ProtoField(label = Message.Label.REQUIRED, tag = 3, type = Message.Datatype.INT32)
    public final Integer noticode;
    @ProtoField(tag = 13, type = Message.Datatype.INT64)
    public final Long orderid;
    @ProtoField(tag = 30, type = Message.Datatype.STRING)
    public final String push_redirect;
    @ProtoField(tag = 29, type = Message.Datatype.STRING)
    public final String push_title;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(tag = 5, type = Message.Datatype.INT32)
    public final Integer shopid;
    @ProtoField(tag = 14, type = Message.Datatype.STRING)
    public final String simple_nav_str;
    @ProtoField(tag = 18, type = Message.Datatype.INT32)
    public final Integer specified_action_cate;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer to_userid;
    @ProtoField(tag = 24, type = Message.Datatype.INT32)
    public final Integer total_sent;
    @ProtoField(tag = 27, type = Message.Datatype.INT32)
    public final Integer total_sent_test;
    @ProtoField(tag = 25, type = Message.Datatype.INT32)
    public final Integer total_user_created;
    @ProtoField(tag = 17, type = Message.Datatype.INT32)
    public final Integer type;
    @ProtoField(tag = 26)
    public final WebPush web_content;

    public TriggerCustomizedNoti(String str, BackendParam backendParam, Integer num, Integer num2, Integer num3, Long l, String str2, Integer num4, Long l2, String str3, String str4, String str5, Integer num5, Integer num6, Integer num7, String str6, String str7, Long l3, Integer num8, Integer num9, Integer num10, WebPush webPush, Integer num11, MarketPushSendingInfo marketPushSendingInfo, String str8, String str9) {
        this.requestid = str;
        this.bparam = backendParam;
        this.noticode = num;
        this.to_userid = num2;
        this.shopid = num3;
        this.itemid = l;
        this.content = str2;
        this.noti_link_page = num4;
        this.orderid = l2;
        this.simple_nav_str = str3;
        this.deviceid = str4;
        this.content_image = str5;
        this.type = num5;
        this.specified_action_cate = num6;
        this.action_redirect_type = num7;
        this.action_app_path = str6;
        this.action_reactnative_path = str7;
        this.last_sent_id = l3;
        this.last_sent_userid = num8;
        this.total_sent = num9;
        this.total_user_created = num10;
        this.web_content = webPush;
        this.total_sent_test = num11;
        this.mp_sending_info = marketPushSendingInfo;
        this.push_title = str8;
        this.push_redirect = str9;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private TriggerCustomizedNoti(com.shopee.protocol.action.TriggerCustomizedNoti.Builder r30) {
        /*
            r29 = this;
            r0 = r30
            r1 = r29
            java.lang.String r2 = r0.requestid
            com.shopee.protocol.action.BackendParam r3 = r0.bparam
            java.lang.Integer r4 = r0.noticode
            java.lang.Integer r5 = r0.to_userid
            java.lang.Integer r6 = r0.shopid
            java.lang.Long r7 = r0.itemid
            java.lang.String r8 = r0.content
            java.lang.Integer r9 = r0.noti_link_page
            java.lang.Long r10 = r0.orderid
            java.lang.String r11 = r0.simple_nav_str
            java.lang.String r12 = r0.deviceid
            java.lang.String r13 = r0.content_image
            java.lang.Integer r14 = r0.type
            java.lang.Integer r15 = r0.specified_action_cate
            r28 = r1
            java.lang.Integer r1 = r0.action_redirect_type
            r16 = r1
            java.lang.String r1 = r0.action_app_path
            r17 = r1
            java.lang.String r1 = r0.action_reactnative_path
            r18 = r1
            java.lang.Long r1 = r0.last_sent_id
            r19 = r1
            java.lang.Integer r1 = r0.last_sent_userid
            r20 = r1
            java.lang.Integer r1 = r0.total_sent
            r21 = r1
            java.lang.Integer r1 = r0.total_user_created
            r22 = r1
            com.shopee.protocol.shop.WebPush r1 = r0.web_content
            r23 = r1
            java.lang.Integer r1 = r0.total_sent_test
            r24 = r1
            com.shopee.protocol.action.MarketPushSendingInfo r1 = r0.mp_sending_info
            r25 = r1
            java.lang.String r1 = r0.push_title
            r26 = r1
            java.lang.String r1 = r0.push_redirect
            r27 = r1
            r1 = r28
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27)
            r29.setBuilder(r30)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shopee.protocol.action.TriggerCustomizedNoti.<init>(com.shopee.protocol.action.TriggerCustomizedNoti$Builder):void");
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof TriggerCustomizedNoti)) {
            return false;
        }
        TriggerCustomizedNoti triggerCustomizedNoti = (TriggerCustomizedNoti) obj;
        if (!equals((Object) this.requestid, (Object) triggerCustomizedNoti.requestid) || !equals((Object) this.bparam, (Object) triggerCustomizedNoti.bparam) || !equals((Object) this.noticode, (Object) triggerCustomizedNoti.noticode) || !equals((Object) this.to_userid, (Object) triggerCustomizedNoti.to_userid) || !equals((Object) this.shopid, (Object) triggerCustomizedNoti.shopid) || !equals((Object) this.itemid, (Object) triggerCustomizedNoti.itemid) || !equals((Object) this.content, (Object) triggerCustomizedNoti.content) || !equals((Object) this.noti_link_page, (Object) triggerCustomizedNoti.noti_link_page) || !equals((Object) this.orderid, (Object) triggerCustomizedNoti.orderid) || !equals((Object) this.simple_nav_str, (Object) triggerCustomizedNoti.simple_nav_str) || !equals((Object) this.deviceid, (Object) triggerCustomizedNoti.deviceid) || !equals((Object) this.content_image, (Object) triggerCustomizedNoti.content_image) || !equals((Object) this.type, (Object) triggerCustomizedNoti.type) || !equals((Object) this.specified_action_cate, (Object) triggerCustomizedNoti.specified_action_cate) || !equals((Object) this.action_redirect_type, (Object) triggerCustomizedNoti.action_redirect_type) || !equals((Object) this.action_app_path, (Object) triggerCustomizedNoti.action_app_path) || !equals((Object) this.action_reactnative_path, (Object) triggerCustomizedNoti.action_reactnative_path) || !equals((Object) this.last_sent_id, (Object) triggerCustomizedNoti.last_sent_id) || !equals((Object) this.last_sent_userid, (Object) triggerCustomizedNoti.last_sent_userid) || !equals((Object) this.total_sent, (Object) triggerCustomizedNoti.total_sent) || !equals((Object) this.total_user_created, (Object) triggerCustomizedNoti.total_user_created) || !equals((Object) this.web_content, (Object) triggerCustomizedNoti.web_content) || !equals((Object) this.total_sent_test, (Object) triggerCustomizedNoti.total_sent_test) || !equals((Object) this.mp_sending_info, (Object) triggerCustomizedNoti.mp_sending_info) || !equals((Object) this.push_title, (Object) triggerCustomizedNoti.push_title) || !equals((Object) this.push_redirect, (Object) triggerCustomizedNoti.push_redirect)) {
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
        BackendParam backendParam = this.bparam;
        int hashCode2 = (hashCode + (backendParam != null ? backendParam.hashCode() : 0)) * 37;
        Integer num = this.noticode;
        int hashCode3 = (hashCode2 + (num != null ? num.hashCode() : 0)) * 37;
        Integer num2 = this.to_userid;
        int hashCode4 = (hashCode3 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Integer num3 = this.shopid;
        int hashCode5 = (hashCode4 + (num3 != null ? num3.hashCode() : 0)) * 37;
        Long l = this.itemid;
        int hashCode6 = (hashCode5 + (l != null ? l.hashCode() : 0)) * 37;
        String str2 = this.content;
        int hashCode7 = (hashCode6 + (str2 != null ? str2.hashCode() : 0)) * 37;
        Integer num4 = this.noti_link_page;
        int hashCode8 = (hashCode7 + (num4 != null ? num4.hashCode() : 0)) * 37;
        Long l2 = this.orderid;
        int hashCode9 = (hashCode8 + (l2 != null ? l2.hashCode() : 0)) * 37;
        String str3 = this.simple_nav_str;
        int hashCode10 = (hashCode9 + (str3 != null ? str3.hashCode() : 0)) * 37;
        String str4 = this.deviceid;
        int hashCode11 = (hashCode10 + (str4 != null ? str4.hashCode() : 0)) * 37;
        String str5 = this.content_image;
        int hashCode12 = (hashCode11 + (str5 != null ? str5.hashCode() : 0)) * 37;
        Integer num5 = this.type;
        int hashCode13 = (hashCode12 + (num5 != null ? num5.hashCode() : 0)) * 37;
        Integer num6 = this.specified_action_cate;
        int hashCode14 = (hashCode13 + (num6 != null ? num6.hashCode() : 0)) * 37;
        Integer num7 = this.action_redirect_type;
        int hashCode15 = (hashCode14 + (num7 != null ? num7.hashCode() : 0)) * 37;
        String str6 = this.action_app_path;
        int hashCode16 = (hashCode15 + (str6 != null ? str6.hashCode() : 0)) * 37;
        String str7 = this.action_reactnative_path;
        int hashCode17 = (hashCode16 + (str7 != null ? str7.hashCode() : 0)) * 37;
        Long l3 = this.last_sent_id;
        int hashCode18 = (hashCode17 + (l3 != null ? l3.hashCode() : 0)) * 37;
        Integer num8 = this.last_sent_userid;
        int hashCode19 = (hashCode18 + (num8 != null ? num8.hashCode() : 0)) * 37;
        Integer num9 = this.total_sent;
        int hashCode20 = (hashCode19 + (num9 != null ? num9.hashCode() : 0)) * 37;
        Integer num10 = this.total_user_created;
        int hashCode21 = (hashCode20 + (num10 != null ? num10.hashCode() : 0)) * 37;
        WebPush webPush = this.web_content;
        int hashCode22 = (hashCode21 + (webPush != null ? webPush.hashCode() : 0)) * 37;
        Integer num11 = this.total_sent_test;
        int hashCode23 = (hashCode22 + (num11 != null ? num11.hashCode() : 0)) * 37;
        MarketPushSendingInfo marketPushSendingInfo = this.mp_sending_info;
        int hashCode24 = (hashCode23 + (marketPushSendingInfo != null ? marketPushSendingInfo.hashCode() : 0)) * 37;
        String str8 = this.push_title;
        int hashCode25 = (hashCode24 + (str8 != null ? str8.hashCode() : 0)) * 37;
        String str9 = this.push_redirect;
        if (str9 != null) {
            i2 = str9.hashCode();
        }
        int i3 = hashCode25 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<TriggerCustomizedNoti> {
        public String action_app_path;
        public String action_reactnative_path;
        public Integer action_redirect_type;
        public BackendParam bparam;
        public String content;
        public String content_image;
        public String deviceid;
        public Long itemid;
        public Long last_sent_id;
        public Integer last_sent_userid;
        public MarketPushSendingInfo mp_sending_info;
        public Integer noti_link_page;
        public Integer noticode;
        public Long orderid;
        public String push_redirect;
        public String push_title;
        public String requestid;
        public Integer shopid;
        public String simple_nav_str;
        public Integer specified_action_cate;
        public Integer to_userid;
        public Integer total_sent;
        public Integer total_sent_test;
        public Integer total_user_created;
        public Integer type;
        public WebPush web_content;

        public Builder() {
        }

        public Builder(TriggerCustomizedNoti triggerCustomizedNoti) {
            super(triggerCustomizedNoti);
            if (triggerCustomizedNoti != null) {
                this.requestid = triggerCustomizedNoti.requestid;
                this.bparam = triggerCustomizedNoti.bparam;
                this.noticode = triggerCustomizedNoti.noticode;
                this.to_userid = triggerCustomizedNoti.to_userid;
                this.shopid = triggerCustomizedNoti.shopid;
                this.itemid = triggerCustomizedNoti.itemid;
                this.content = triggerCustomizedNoti.content;
                this.noti_link_page = triggerCustomizedNoti.noti_link_page;
                this.orderid = triggerCustomizedNoti.orderid;
                this.simple_nav_str = triggerCustomizedNoti.simple_nav_str;
                this.deviceid = triggerCustomizedNoti.deviceid;
                this.content_image = triggerCustomizedNoti.content_image;
                this.type = triggerCustomizedNoti.type;
                this.specified_action_cate = triggerCustomizedNoti.specified_action_cate;
                this.action_redirect_type = triggerCustomizedNoti.action_redirect_type;
                this.action_app_path = triggerCustomizedNoti.action_app_path;
                this.action_reactnative_path = triggerCustomizedNoti.action_reactnative_path;
                this.last_sent_id = triggerCustomizedNoti.last_sent_id;
                this.last_sent_userid = triggerCustomizedNoti.last_sent_userid;
                this.total_sent = triggerCustomizedNoti.total_sent;
                this.total_user_created = triggerCustomizedNoti.total_user_created;
                this.web_content = triggerCustomizedNoti.web_content;
                this.total_sent_test = triggerCustomizedNoti.total_sent_test;
                this.mp_sending_info = triggerCustomizedNoti.mp_sending_info;
                this.push_title = triggerCustomizedNoti.push_title;
                this.push_redirect = triggerCustomizedNoti.push_redirect;
            }
        }

        public Builder requestid(String str) {
            this.requestid = str;
            return this;
        }

        public Builder bparam(BackendParam backendParam) {
            this.bparam = backendParam;
            return this;
        }

        public Builder noticode(Integer num) {
            this.noticode = num;
            return this;
        }

        public Builder to_userid(Integer num) {
            this.to_userid = num;
            return this;
        }

        public Builder shopid(Integer num) {
            this.shopid = num;
            return this;
        }

        public Builder itemid(Long l) {
            this.itemid = l;
            return this;
        }

        public Builder content(String str) {
            this.content = str;
            return this;
        }

        public Builder noti_link_page(Integer num) {
            this.noti_link_page = num;
            return this;
        }

        public Builder orderid(Long l) {
            this.orderid = l;
            return this;
        }

        public Builder simple_nav_str(String str) {
            this.simple_nav_str = str;
            return this;
        }

        public Builder deviceid(String str) {
            this.deviceid = str;
            return this;
        }

        public Builder content_image(String str) {
            this.content_image = str;
            return this;
        }

        public Builder type(Integer num) {
            this.type = num;
            return this;
        }

        public Builder specified_action_cate(Integer num) {
            this.specified_action_cate = num;
            return this;
        }

        public Builder action_redirect_type(Integer num) {
            this.action_redirect_type = num;
            return this;
        }

        public Builder action_app_path(String str) {
            this.action_app_path = str;
            return this;
        }

        public Builder action_reactnative_path(String str) {
            this.action_reactnative_path = str;
            return this;
        }

        public Builder last_sent_id(Long l) {
            this.last_sent_id = l;
            return this;
        }

        public Builder last_sent_userid(Integer num) {
            this.last_sent_userid = num;
            return this;
        }

        public Builder total_sent(Integer num) {
            this.total_sent = num;
            return this;
        }

        public Builder total_user_created(Integer num) {
            this.total_user_created = num;
            return this;
        }

        public Builder web_content(WebPush webPush) {
            this.web_content = webPush;
            return this;
        }

        public Builder total_sent_test(Integer num) {
            this.total_sent_test = num;
            return this;
        }

        public Builder mp_sending_info(MarketPushSendingInfo marketPushSendingInfo) {
            this.mp_sending_info = marketPushSendingInfo;
            return this;
        }

        public Builder push_title(String str) {
            this.push_title = str;
            return this;
        }

        public Builder push_redirect(String str) {
            this.push_redirect = str;
            return this;
        }

        public TriggerCustomizedNoti build() {
            checkRequiredFields();
            return new TriggerCustomizedNoti(this);
        }
    }
}
