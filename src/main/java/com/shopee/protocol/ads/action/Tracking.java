package com.shopee.protocol.ads.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class Tracking extends Message {
    public static final String DEFAULT_CLIENT_IP = "";
    public static final String DEFAULT_COUNTRY = "";
    public static final String DEFAULT_DEVICEID = "";
    public static final String DEFAULT_FROM = "";
    public static final List<TrackingItem> DEFAULT_ITEMS = Collections.emptyList();
    public static final String DEFAULT_JSON_DATA = "";
    public static final Integer DEFAULT_OPERATION = 0;
    public static final Integer DEFAULT_PLACEMENT = 0;
    public static final Integer DEFAULT_PLATFORM = 0;
    public static final String DEFAULT_SESSIONID = "";
    public static final List<TrackingShop> DEFAULT_SHOPS = Collections.emptyList();
    public static final Long DEFAULT_TIMESTAMP = 0L;
    public static final String DEFAULT_TOKEN = "";
    public static final Integer DEFAULT_USERID = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String client_ip;
    @ProtoField(tag = 9, type = Message.Datatype.STRING)
    public final String country;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String deviceid;
    @ProtoField(tag = 11, type = Message.Datatype.STRING)
    public final String from;
    @ProtoField(label = Message.Label.REPEATED, messageType = TrackingItem.class, tag = 7)
    public final List<TrackingItem> items;
    @ProtoField(tag = 14, type = Message.Datatype.STRING)
    public final String json_data;
    @ProtoField(tag = 6, type = Message.Datatype.INT32)
    public final Integer operation;
    @ProtoField(tag = 13, type = Message.Datatype.INT32)
    public final Integer placement;
    @ProtoField(tag = 5, type = Message.Datatype.INT32)
    public final Integer platform;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String sessionid;
    @ProtoField(label = Message.Label.REPEATED, messageType = TrackingShop.class, tag = 12)
    public final List<TrackingShop> shops;
    @ProtoField(tag = 8, type = Message.Datatype.INT64)
    public final Long timestamp;
    @ProtoField(tag = 10, type = Message.Datatype.STRING)
    public final String token;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer userid;

    public Tracking(Integer num, String str, String str2, String str3, Integer num2, Integer num3, List<TrackingItem> list, Long l, String str4, String str5, String str6, List<TrackingShop> list2, Integer num4, String str7) {
        this.userid = num;
        this.sessionid = str;
        this.deviceid = str2;
        this.client_ip = str3;
        this.platform = num2;
        this.operation = num3;
        this.items = immutableCopyOf(list);
        this.timestamp = l;
        this.country = str4;
        this.token = str5;
        this.from = str6;
        this.shops = immutableCopyOf(list2);
        this.placement = num4;
        this.json_data = str7;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private Tracking(com.shopee.protocol.ads.action.Tracking.Builder r17) {
        /*
            r16 = this;
            r0 = r17
            java.lang.Integer r2 = r0.userid
            java.lang.String r3 = r0.sessionid
            java.lang.String r4 = r0.deviceid
            java.lang.String r5 = r0.client_ip
            java.lang.Integer r6 = r0.platform
            java.lang.Integer r7 = r0.operation
            java.util.List<com.shopee.protocol.ads.action.TrackingItem> r8 = r0.items
            java.lang.Long r9 = r0.timestamp
            java.lang.String r10 = r0.country
            java.lang.String r11 = r0.token
            java.lang.String r12 = r0.from
            java.util.List<com.shopee.protocol.ads.action.TrackingShop> r13 = r0.shops
            java.lang.Integer r14 = r0.placement
            java.lang.String r15 = r0.json_data
            r1 = r16
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15)
            r16.setBuilder(r17)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shopee.protocol.ads.action.Tracking.<init>(com.shopee.protocol.ads.action.Tracking$Builder):void");
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Tracking)) {
            return false;
        }
        Tracking tracking = (Tracking) obj;
        if (!equals((Object) this.userid, (Object) tracking.userid) || !equals((Object) this.sessionid, (Object) tracking.sessionid) || !equals((Object) this.deviceid, (Object) tracking.deviceid) || !equals((Object) this.client_ip, (Object) tracking.client_ip) || !equals((Object) this.platform, (Object) tracking.platform) || !equals((Object) this.operation, (Object) tracking.operation) || !equals((List<?>) this.items, (List<?>) tracking.items) || !equals((Object) this.timestamp, (Object) tracking.timestamp) || !equals((Object) this.country, (Object) tracking.country) || !equals((Object) this.token, (Object) tracking.token) || !equals((Object) this.from, (Object) tracking.from) || !equals((List<?>) this.shops, (List<?>) tracking.shops) || !equals((Object) this.placement, (Object) tracking.placement) || !equals((Object) this.json_data, (Object) tracking.json_data)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Integer num = this.userid;
        int i2 = 0;
        int hashCode = (num != null ? num.hashCode() : 0) * 37;
        String str = this.sessionid;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 37;
        String str2 = this.deviceid;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 37;
        String str3 = this.client_ip;
        int hashCode4 = (hashCode3 + (str3 != null ? str3.hashCode() : 0)) * 37;
        Integer num2 = this.platform;
        int hashCode5 = (hashCode4 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Integer num3 = this.operation;
        int hashCode6 = (hashCode5 + (num3 != null ? num3.hashCode() : 0)) * 37;
        List<TrackingItem> list = this.items;
        int i3 = 1;
        int hashCode7 = (hashCode6 + (list != null ? list.hashCode() : 1)) * 37;
        Long l = this.timestamp;
        int hashCode8 = (hashCode7 + (l != null ? l.hashCode() : 0)) * 37;
        String str4 = this.country;
        int hashCode9 = (hashCode8 + (str4 != null ? str4.hashCode() : 0)) * 37;
        String str5 = this.token;
        int hashCode10 = (hashCode9 + (str5 != null ? str5.hashCode() : 0)) * 37;
        String str6 = this.from;
        int hashCode11 = (hashCode10 + (str6 != null ? str6.hashCode() : 0)) * 37;
        List<TrackingShop> list2 = this.shops;
        if (list2 != null) {
            i3 = list2.hashCode();
        }
        int i4 = (hashCode11 + i3) * 37;
        Integer num4 = this.placement;
        int hashCode12 = (i4 + (num4 != null ? num4.hashCode() : 0)) * 37;
        String str7 = this.json_data;
        if (str7 != null) {
            i2 = str7.hashCode();
        }
        int i5 = hashCode12 + i2;
        this.hashCode = i5;
        return i5;
    }

    public static final class Builder extends Message.Builder<Tracking> {
        public String client_ip;
        public String country;
        public String deviceid;
        public String from;
        public List<TrackingItem> items;
        public String json_data;
        public Integer operation;
        public Integer placement;
        public Integer platform;
        public String sessionid;
        public List<TrackingShop> shops;
        public Long timestamp;
        public String token;
        public Integer userid;

        public Builder() {
        }

        public Builder(Tracking tracking) {
            super(tracking);
            if (tracking != null) {
                this.userid = tracking.userid;
                this.sessionid = tracking.sessionid;
                this.deviceid = tracking.deviceid;
                this.client_ip = tracking.client_ip;
                this.platform = tracking.platform;
                this.operation = tracking.operation;
                this.items = Tracking.copyOf(tracking.items);
                this.timestamp = tracking.timestamp;
                this.country = tracking.country;
                this.token = tracking.token;
                this.from = tracking.from;
                this.shops = Tracking.copyOf(tracking.shops);
                this.placement = tracking.placement;
                this.json_data = tracking.json_data;
            }
        }

        public Builder userid(Integer num) {
            this.userid = num;
            return this;
        }

        public Builder sessionid(String str) {
            this.sessionid = str;
            return this;
        }

        public Builder deviceid(String str) {
            this.deviceid = str;
            return this;
        }

        public Builder client_ip(String str) {
            this.client_ip = str;
            return this;
        }

        public Builder platform(Integer num) {
            this.platform = num;
            return this;
        }

        public Builder operation(Integer num) {
            this.operation = num;
            return this;
        }

        public Builder items(List<TrackingItem> list) {
            this.items = checkForNulls(list);
            return this;
        }

        public Builder timestamp(Long l) {
            this.timestamp = l;
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

        public Builder from(String str) {
            this.from = str;
            return this;
        }

        public Builder shops(List<TrackingShop> list) {
            this.shops = checkForNulls(list);
            return this;
        }

        public Builder placement(Integer num) {
            this.placement = num;
            return this;
        }

        public Builder json_data(String str) {
            this.json_data = str;
            return this;
        }

        public Tracking build() {
            return new Tracking(this);
        }
    }
}
