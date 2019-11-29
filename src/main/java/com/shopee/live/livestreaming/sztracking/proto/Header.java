package com.shopee.live.livestreaming.sztracking.proto;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class Header extends Message {
    public static final Long DEFAULT_ADJUST_TIMESTAMP = 0L;
    public static final String DEFAULT_CLIENT_IP = "";
    public static final String DEFAULT_CLIENT_VERSION = "";
    public static final String DEFAULT_COUNTRY = "";
    public static final String DEFAULT_DEVICE_ID = "";
    public static final String DEFAULT_DEVICE_MODEL = "";
    public static final Integer DEFAULT_ID = 0;
    public static final Integer DEFAULT_NETWORK = 0;
    public static final Integer DEFAULT_OS = 0;
    public static final String DEFAULT_OS_VERSION = "";
    public static final Integer DEFAULT_SCENE_ID = 0;
    public static final String DEFAULT_SDK_VERSION = "";
    public static final Long DEFAULT_TIMESTAMP = 0L;
    public static final String DEFAULT_UA = "";
    public static final Long DEFAULT_UID = 0L;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 15, type = Message.Datatype.UINT64)
    public final Long adjust_timestamp;
    @ProtoField(tag = 9, type = Message.Datatype.STRING)
    public final String client_ip;
    @ProtoField(tag = 8, type = Message.Datatype.STRING)
    public final String client_version;
    @ProtoField(tag = 11, type = Message.Datatype.STRING)
    public final String country;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String device_id;
    @ProtoField(tag = 5, type = Message.Datatype.STRING)
    public final String device_model;
    @ProtoField(tag = 1, type = Message.Datatype.UINT32)
    public final Integer id;
    @ProtoField(tag = 10, type = Message.Datatype.UINT32)
    public final Integer network;
    @ProtoField(tag = 6, type = Message.Datatype.UINT32)
    public final Integer os;
    @ProtoField(tag = 7, type = Message.Datatype.STRING)
    public final String os_version;
    @ProtoField(tag = 2, type = Message.Datatype.UINT32)
    public final Integer scene_id;
    @ProtoField(tag = 13, type = Message.Datatype.STRING)
    public final String sdk_version;
    @ProtoField(tag = 14, type = Message.Datatype.UINT64)
    public final Long timestamp;
    @ProtoField(tag = 12, type = Message.Datatype.STRING)
    public final String ua;
    @ProtoField(tag = 3, type = Message.Datatype.UINT64)
    public final Long uid;

    public Header(Integer num, Integer num2, Long l, String str, String str2, Integer num3, String str3, String str4, String str5, Integer num4, String str6, String str7, String str8, Long l2, Long l3) {
        this.id = num;
        this.scene_id = num2;
        this.uid = l;
        this.device_id = str;
        this.device_model = str2;
        this.os = num3;
        this.os_version = str3;
        this.client_version = str4;
        this.client_ip = str5;
        this.network = num4;
        this.country = str6;
        this.ua = str7;
        this.sdk_version = str8;
        this.timestamp = l2;
        this.adjust_timestamp = l3;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private Header(com.shopee.live.livestreaming.sztracking.proto.Header.Builder r18) {
        /*
            r17 = this;
            r0 = r18
            java.lang.Integer r2 = r0.id
            java.lang.Integer r3 = r0.scene_id
            java.lang.Long r4 = r0.uid
            java.lang.String r5 = r0.device_id
            java.lang.String r6 = r0.device_model
            java.lang.Integer r7 = r0.os
            java.lang.String r8 = r0.os_version
            java.lang.String r9 = r0.client_version
            java.lang.String r10 = r0.client_ip
            java.lang.Integer r11 = r0.network
            java.lang.String r12 = r0.country
            java.lang.String r13 = r0.ua
            java.lang.String r14 = r0.sdk_version
            java.lang.Long r15 = r0.timestamp
            java.lang.Long r1 = r0.adjust_timestamp
            r16 = r1
            r1 = r17
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16)
            r17.setBuilder(r18)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shopee.live.livestreaming.sztracking.proto.Header.<init>(com.shopee.live.livestreaming.sztracking.proto.Header$Builder):void");
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Header)) {
            return false;
        }
        Header header = (Header) obj;
        if (!equals((Object) this.id, (Object) header.id) || !equals((Object) this.scene_id, (Object) header.scene_id) || !equals((Object) this.uid, (Object) header.uid) || !equals((Object) this.device_id, (Object) header.device_id) || !equals((Object) this.device_model, (Object) header.device_model) || !equals((Object) this.os, (Object) header.os) || !equals((Object) this.os_version, (Object) header.os_version) || !equals((Object) this.client_version, (Object) header.client_version) || !equals((Object) this.client_ip, (Object) header.client_ip) || !equals((Object) this.network, (Object) header.network) || !equals((Object) this.country, (Object) header.country) || !equals((Object) this.ua, (Object) header.ua) || !equals((Object) this.sdk_version, (Object) header.sdk_version) || !equals((Object) this.timestamp, (Object) header.timestamp) || !equals((Object) this.adjust_timestamp, (Object) header.adjust_timestamp)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Integer num = this.id;
        int i2 = 0;
        int hashCode = (num != null ? num.hashCode() : 0) * 37;
        Integer num2 = this.scene_id;
        int hashCode2 = (hashCode + (num2 != null ? num2.hashCode() : 0)) * 37;
        Long l = this.uid;
        int hashCode3 = (hashCode2 + (l != null ? l.hashCode() : 0)) * 37;
        String str = this.device_id;
        int hashCode4 = (hashCode3 + (str != null ? str.hashCode() : 0)) * 37;
        String str2 = this.device_model;
        int hashCode5 = (hashCode4 + (str2 != null ? str2.hashCode() : 0)) * 37;
        Integer num3 = this.os;
        int hashCode6 = (hashCode5 + (num3 != null ? num3.hashCode() : 0)) * 37;
        String str3 = this.os_version;
        int hashCode7 = (hashCode6 + (str3 != null ? str3.hashCode() : 0)) * 37;
        String str4 = this.client_version;
        int hashCode8 = (hashCode7 + (str4 != null ? str4.hashCode() : 0)) * 37;
        String str5 = this.client_ip;
        int hashCode9 = (hashCode8 + (str5 != null ? str5.hashCode() : 0)) * 37;
        Integer num4 = this.network;
        int hashCode10 = (hashCode9 + (num4 != null ? num4.hashCode() : 0)) * 37;
        String str6 = this.country;
        int hashCode11 = (hashCode10 + (str6 != null ? str6.hashCode() : 0)) * 37;
        String str7 = this.ua;
        int hashCode12 = (hashCode11 + (str7 != null ? str7.hashCode() : 0)) * 37;
        String str8 = this.sdk_version;
        int hashCode13 = (hashCode12 + (str8 != null ? str8.hashCode() : 0)) * 37;
        Long l2 = this.timestamp;
        int hashCode14 = (hashCode13 + (l2 != null ? l2.hashCode() : 0)) * 37;
        Long l3 = this.adjust_timestamp;
        if (l3 != null) {
            i2 = l3.hashCode();
        }
        int i3 = hashCode14 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<Header> {
        public Long adjust_timestamp;
        public String client_ip;
        public String client_version;
        public String country;
        public String device_id;
        public String device_model;
        public Integer id;
        public Integer network;
        public Integer os;
        public String os_version;
        public Integer scene_id;
        public String sdk_version;
        public Long timestamp;
        public String ua;
        public Long uid;

        public Builder() {
        }

        public Builder(Header header) {
            super(header);
            if (header != null) {
                this.id = header.id;
                this.scene_id = header.scene_id;
                this.uid = header.uid;
                this.device_id = header.device_id;
                this.device_model = header.device_model;
                this.os = header.os;
                this.os_version = header.os_version;
                this.client_version = header.client_version;
                this.client_ip = header.client_ip;
                this.network = header.network;
                this.country = header.country;
                this.ua = header.ua;
                this.sdk_version = header.sdk_version;
                this.timestamp = header.timestamp;
                this.adjust_timestamp = header.adjust_timestamp;
            }
        }

        public Builder id(Integer num) {
            this.id = num;
            return this;
        }

        public Builder scene_id(Integer num) {
            this.scene_id = num;
            return this;
        }

        public Builder uid(Long l) {
            this.uid = l;
            return this;
        }

        public Builder device_id(String str) {
            this.device_id = str;
            return this;
        }

        public Builder device_model(String str) {
            this.device_model = str;
            return this;
        }

        public Builder os(Integer num) {
            this.os = num;
            return this;
        }

        public Builder os_version(String str) {
            this.os_version = str;
            return this;
        }

        public Builder client_version(String str) {
            this.client_version = str;
            return this;
        }

        public Builder client_ip(String str) {
            this.client_ip = str;
            return this;
        }

        public Builder network(Integer num) {
            this.network = num;
            return this;
        }

        public Builder country(String str) {
            this.country = str;
            return this;
        }

        public Builder ua(String str) {
            this.ua = str;
            return this;
        }

        public Builder sdk_version(String str) {
            this.sdk_version = str;
            return this;
        }

        public Builder timestamp(Long l) {
            this.timestamp = l;
            return this;
        }

        public Builder adjust_timestamp(Long l) {
            this.adjust_timestamp = l;
            return this;
        }

        public Header build() {
            return new Header(this);
        }
    }
}
