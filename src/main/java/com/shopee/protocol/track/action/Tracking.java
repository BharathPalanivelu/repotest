package com.shopee.protocol.track.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class Tracking extends Message {
    public static final List<String> DEFAULT_AB_TEST = Collections.emptyList();
    public static final String DEFAULT_APP_VERSION = "";
    public static final List<TrackingAttribute> DEFAULT_ATTRIBUTE = Collections.emptyList();
    public static final List<TrackingBanner> DEFAULT_BANNER = Collections.emptyList();
    public static final String DEFAULT_BRAND = "";
    public static final String DEFAULT_BROWSER = "";
    public static final String DEFAULT_BROWSER_VERSION = "";
    public static final List<TrackingButton> DEFAULT_BUTTON = Collections.emptyList();
    public static final List<TrackingCategory> DEFAULT_CATEGORY = Collections.emptyList();
    public static final String DEFAULT_CLIENT_IP = "";
    public static final List<TrackingCollectionCard> DEFAULT_COLLECTION_CARD = Collections.emptyList();
    public static final List<TrackingCollectionModule> DEFAULT_COLLECTION_MODULE = Collections.emptyList();
    public static final List<TrackingColorBlock> DEFAULT_COLOR_BLOCK = Collections.emptyList();
    public static final String DEFAULT_COUNTRY = "";
    public static final String DEFAULT_DEFAULT_PAGE_SECTION = "";
    public static final String DEFAULT_DEFAULT_PAGE_TYPE = "";
    public static final String DEFAULT_DEFAULT_TARGET_TYPE = "";
    public static final String DEFAULT_DEVICEID = "";
    public static final Long DEFAULT_EVENT_TIMESTAMP = 0L;
    public static final List<TrackingFilter> DEFAULT_FILTER = Collections.emptyList();
    public static final List<TrackingItem> DEFAULT_ITEM = Collections.emptyList();
    public static final Long DEFAULT_LOG_TIMESTAMP = 0L;
    public static final String DEFAULT_MODEL = "";
    public static final Integer DEFAULT_OPERATION = 0;
    public static final String DEFAULT_OS = "";
    public static final String DEFAULT_OS_VERSION = "";
    public static final Integer DEFAULT_PAGE_SECTION = 0;
    public static final Integer DEFAULT_PAGE_TYPE = 0;
    public static final Integer DEFAULT_PLATFORM = 0;
    public static final Integer DEFAULT_REFER_PAGE = 0;
    public static final String DEFAULT_REFER_URL = "";
    public static final List<TrackingSearch> DEFAULT_SEARCH = Collections.emptyList();
    public static final List<TrackingShop> DEFAULT_SHOP = Collections.emptyList();
    public static final String DEFAULT_SIGNATURE = "";
    public static final List<TrackingSocialMedia> DEFAULT_SOCIAL_MEDIA = Collections.emptyList();
    public static final List<TrackingSort> DEFAULT_SORT = Collections.emptyList();
    public static final List<TrackingTab> DEFAULT_TAB = Collections.emptyList();
    public static final Integer DEFAULT_TARGET_TYPE = 0;
    public static final String DEFAULT_TOKEN = "";
    public static final List<TrackingTrendingSearch> DEFAULT_TRENDING_SEARCH = Collections.emptyList();
    public static final Integer DEFAULT_USERID = 0;
    public static final Boolean DEFAULT_WIFI = false;
    private static final long serialVersionUID = 0;
    @ProtoField(label = Message.Label.REPEATED, tag = 19, type = Message.Datatype.STRING)
    public final List<String> AB_test;
    @ProtoField(tag = 13, type = Message.Datatype.STRING)
    public final String app_version;
    @ProtoField(label = Message.Label.REPEATED, messageType = TrackingAttribute.class, tag = 37)
    public final List<TrackingAttribute> attribute;
    @ProtoField(label = Message.Label.REPEATED, messageType = TrackingBanner.class, tag = 29)
    public final List<TrackingBanner> banner;
    @ProtoField(tag = 11, type = Message.Datatype.STRING)
    public final String brand;
    @ProtoField(tag = 14, type = Message.Datatype.STRING)
    public final String browser;
    @ProtoField(tag = 15, type = Message.Datatype.STRING)
    public final String browser_version;
    @ProtoField(label = Message.Label.REPEATED, messageType = TrackingButton.class, tag = 43)
    public final List<TrackingButton> button;
    @ProtoField(label = Message.Label.REPEATED, messageType = TrackingCategory.class, tag = 31)
    public final List<TrackingCategory> category;
    @ProtoField(tag = 7, type = Message.Datatype.STRING)
    public final String client_ip;
    @ProtoField(label = Message.Label.REPEATED, messageType = TrackingCollectionCard.class, tag = 42)
    public final List<TrackingCollectionCard> collection_card;
    @ProtoField(label = Message.Label.REPEATED, messageType = TrackingCollectionModule.class, tag = 41)
    public final List<TrackingCollectionModule> collection_module;
    @ProtoField(label = Message.Label.REPEATED, messageType = TrackingColorBlock.class, tag = 36)
    public final List<TrackingColorBlock> color_block;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String country;
    @ProtoField(tag = 24, type = Message.Datatype.STRING)
    public final String default_page_section;
    @ProtoField(tag = 22, type = Message.Datatype.STRING)
    public final String default_page_type;
    @ProtoField(tag = 26, type = Message.Datatype.STRING)
    public final String default_target_type;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String deviceid;
    @ProtoField(tag = 5, type = Message.Datatype.INT64)
    public final Long event_timestamp;
    @ProtoField(label = Message.Label.REPEATED, messageType = TrackingFilter.class, tag = 35)
    public final List<TrackingFilter> filter;
    @ProtoField(label = Message.Label.REPEATED, messageType = TrackingItem.class, tag = 27)
    public final List<TrackingItem> item;
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long log_timestamp;
    @ProtoField(tag = 18)
    public final TrackingMarketingToken marketing_token;
    @ProtoField(tag = 12, type = Message.Datatype.STRING)
    public final String model;
    @ProtoField(tag = 20, type = Message.Datatype.INT32)
    public final Integer operation;
    @ProtoField(tag = 9, type = Message.Datatype.STRING)
    public final String os;
    @ProtoField(tag = 10, type = Message.Datatype.STRING)
    public final String os_version;
    @ProtoField(tag = 23, type = Message.Datatype.INT32)
    public final Integer page_section;
    @ProtoField(tag = 21, type = Message.Datatype.INT32)
    public final Integer page_type;
    @ProtoField(tag = 6, type = Message.Datatype.INT32)
    public final Integer platform;
    @ProtoField(tag = 16, type = Message.Datatype.INT32)
    public final Integer refer_page;
    @ProtoField(tag = 17, type = Message.Datatype.STRING)
    public final String refer_url;
    @ProtoField(label = Message.Label.REPEATED, messageType = TrackingSearch.class, tag = 33)
    public final List<TrackingSearch> search;
    @ProtoField(label = Message.Label.REPEATED, messageType = TrackingShop.class, tag = 28)
    public final List<TrackingShop> shop;
    @ProtoField(tag = 39, type = Message.Datatype.STRING)
    public final String signature;
    @ProtoField(label = Message.Label.REPEATED, messageType = TrackingSocialMedia.class, tag = 38)
    public final List<TrackingSocialMedia> social_media;
    @ProtoField(label = Message.Label.REPEATED, messageType = TrackingSort.class, tag = 34)
    public final List<TrackingSort> sort;
    @ProtoField(label = Message.Label.REPEATED, messageType = TrackingTab.class, tag = 32)
    public final List<TrackingTab> tab;
    @ProtoField(tag = 25, type = Message.Datatype.INT32)
    public final Integer target_type;
    @ProtoField(tag = 40, type = Message.Datatype.STRING)
    public final String token;
    @ProtoField(label = Message.Label.REPEATED, messageType = TrackingTrendingSearch.class, tag = 30)
    public final List<TrackingTrendingSearch> trending_search;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer userid;
    @ProtoField(tag = 8, type = Message.Datatype.BOOL)
    public final Boolean wifi;

    public Tracking(Long l, Integer num, String str, String str2, Long l2, Integer num2, String str3, Boolean bool, String str4, String str5, String str6, String str7, String str8, String str9, String str10, Integer num3, String str11, TrackingMarketingToken trackingMarketingToken, List<String> list, Integer num4, Integer num5, String str12, Integer num6, String str13, Integer num7, String str14, List<TrackingItem> list2, List<TrackingShop> list3, List<TrackingBanner> list4, List<TrackingTrendingSearch> list5, List<TrackingCategory> list6, List<TrackingTab> list7, List<TrackingSearch> list8, List<TrackingSort> list9, List<TrackingFilter> list10, List<TrackingColorBlock> list11, List<TrackingAttribute> list12, List<TrackingSocialMedia> list13, String str15, String str16, List<TrackingCollectionModule> list14, List<TrackingCollectionCard> list15, List<TrackingButton> list16) {
        this.log_timestamp = l;
        this.userid = num;
        this.deviceid = str;
        this.country = str2;
        this.event_timestamp = l2;
        this.platform = num2;
        this.client_ip = str3;
        this.wifi = bool;
        this.os = str4;
        this.os_version = str5;
        this.brand = str6;
        this.model = str7;
        this.app_version = str8;
        this.browser = str9;
        this.browser_version = str10;
        this.refer_page = num3;
        this.refer_url = str11;
        this.marketing_token = trackingMarketingToken;
        this.AB_test = immutableCopyOf(list);
        this.operation = num4;
        this.page_type = num5;
        this.default_page_type = str12;
        this.page_section = num6;
        this.default_page_section = str13;
        this.target_type = num7;
        this.default_target_type = str14;
        this.item = immutableCopyOf(list2);
        this.shop = immutableCopyOf(list3);
        this.banner = immutableCopyOf(list4);
        this.trending_search = immutableCopyOf(list5);
        this.category = immutableCopyOf(list6);
        this.tab = immutableCopyOf(list7);
        this.search = immutableCopyOf(list8);
        this.sort = immutableCopyOf(list9);
        this.filter = immutableCopyOf(list10);
        this.color_block = immutableCopyOf(list11);
        this.attribute = immutableCopyOf(list12);
        this.social_media = immutableCopyOf(list13);
        this.signature = str15;
        this.token = str16;
        this.collection_module = immutableCopyOf(list14);
        this.collection_card = immutableCopyOf(list15);
        this.button = immutableCopyOf(list16);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private Tracking(com.shopee.protocol.track.action.Tracking.Builder r47) {
        /*
            r46 = this;
            r0 = r47
            r1 = r46
            java.lang.Long r2 = r0.log_timestamp
            java.lang.Integer r3 = r0.userid
            java.lang.String r4 = r0.deviceid
            java.lang.String r5 = r0.country
            java.lang.Long r6 = r0.event_timestamp
            java.lang.Integer r7 = r0.platform
            java.lang.String r8 = r0.client_ip
            java.lang.Boolean r9 = r0.wifi
            java.lang.String r10 = r0.os
            java.lang.String r11 = r0.os_version
            java.lang.String r12 = r0.brand
            java.lang.String r13 = r0.model
            java.lang.String r14 = r0.app_version
            java.lang.String r15 = r0.browser
            r45 = r1
            java.lang.String r1 = r0.browser_version
            r16 = r1
            java.lang.Integer r1 = r0.refer_page
            r17 = r1
            java.lang.String r1 = r0.refer_url
            r18 = r1
            com.shopee.protocol.track.action.TrackingMarketingToken r1 = r0.marketing_token
            r19 = r1
            java.util.List<java.lang.String> r1 = r0.AB_test
            r20 = r1
            java.lang.Integer r1 = r0.operation
            r21 = r1
            java.lang.Integer r1 = r0.page_type
            r22 = r1
            java.lang.String r1 = r0.default_page_type
            r23 = r1
            java.lang.Integer r1 = r0.page_section
            r24 = r1
            java.lang.String r1 = r0.default_page_section
            r25 = r1
            java.lang.Integer r1 = r0.target_type
            r26 = r1
            java.lang.String r1 = r0.default_target_type
            r27 = r1
            java.util.List<com.shopee.protocol.track.action.TrackingItem> r1 = r0.item
            r28 = r1
            java.util.List<com.shopee.protocol.track.action.TrackingShop> r1 = r0.shop
            r29 = r1
            java.util.List<com.shopee.protocol.track.action.TrackingBanner> r1 = r0.banner
            r30 = r1
            java.util.List<com.shopee.protocol.track.action.TrackingTrendingSearch> r1 = r0.trending_search
            r31 = r1
            java.util.List<com.shopee.protocol.track.action.TrackingCategory> r1 = r0.category
            r32 = r1
            java.util.List<com.shopee.protocol.track.action.TrackingTab> r1 = r0.tab
            r33 = r1
            java.util.List<com.shopee.protocol.track.action.TrackingSearch> r1 = r0.search
            r34 = r1
            java.util.List<com.shopee.protocol.track.action.TrackingSort> r1 = r0.sort
            r35 = r1
            java.util.List<com.shopee.protocol.track.action.TrackingFilter> r1 = r0.filter
            r36 = r1
            java.util.List<com.shopee.protocol.track.action.TrackingColorBlock> r1 = r0.color_block
            r37 = r1
            java.util.List<com.shopee.protocol.track.action.TrackingAttribute> r1 = r0.attribute
            r38 = r1
            java.util.List<com.shopee.protocol.track.action.TrackingSocialMedia> r1 = r0.social_media
            r39 = r1
            java.lang.String r1 = r0.signature
            r40 = r1
            java.lang.String r1 = r0.token
            r41 = r1
            java.util.List<com.shopee.protocol.track.action.TrackingCollectionModule> r1 = r0.collection_module
            r42 = r1
            java.util.List<com.shopee.protocol.track.action.TrackingCollectionCard> r1 = r0.collection_card
            r43 = r1
            java.util.List<com.shopee.protocol.track.action.TrackingButton> r1 = r0.button
            r44 = r1
            r1 = r45
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42, r43, r44)
            r46.setBuilder(r47)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shopee.protocol.track.action.Tracking.<init>(com.shopee.protocol.track.action.Tracking$Builder):void");
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Tracking)) {
            return false;
        }
        Tracking tracking = (Tracking) obj;
        if (!equals((Object) this.log_timestamp, (Object) tracking.log_timestamp) || !equals((Object) this.userid, (Object) tracking.userid) || !equals((Object) this.deviceid, (Object) tracking.deviceid) || !equals((Object) this.country, (Object) tracking.country) || !equals((Object) this.event_timestamp, (Object) tracking.event_timestamp) || !equals((Object) this.platform, (Object) tracking.platform) || !equals((Object) this.client_ip, (Object) tracking.client_ip) || !equals((Object) this.wifi, (Object) tracking.wifi) || !equals((Object) this.os, (Object) tracking.os) || !equals((Object) this.os_version, (Object) tracking.os_version) || !equals((Object) this.brand, (Object) tracking.brand) || !equals((Object) this.model, (Object) tracking.model) || !equals((Object) this.app_version, (Object) tracking.app_version) || !equals((Object) this.browser, (Object) tracking.browser) || !equals((Object) this.browser_version, (Object) tracking.browser_version) || !equals((Object) this.refer_page, (Object) tracking.refer_page) || !equals((Object) this.refer_url, (Object) tracking.refer_url) || !equals((Object) this.marketing_token, (Object) tracking.marketing_token) || !equals((List<?>) this.AB_test, (List<?>) tracking.AB_test) || !equals((Object) this.operation, (Object) tracking.operation) || !equals((Object) this.page_type, (Object) tracking.page_type) || !equals((Object) this.default_page_type, (Object) tracking.default_page_type) || !equals((Object) this.page_section, (Object) tracking.page_section) || !equals((Object) this.default_page_section, (Object) tracking.default_page_section) || !equals((Object) this.target_type, (Object) tracking.target_type) || !equals((Object) this.default_target_type, (Object) tracking.default_target_type) || !equals((List<?>) this.item, (List<?>) tracking.item) || !equals((List<?>) this.shop, (List<?>) tracking.shop) || !equals((List<?>) this.banner, (List<?>) tracking.banner) || !equals((List<?>) this.trending_search, (List<?>) tracking.trending_search) || !equals((List<?>) this.category, (List<?>) tracking.category) || !equals((List<?>) this.tab, (List<?>) tracking.tab) || !equals((List<?>) this.search, (List<?>) tracking.search) || !equals((List<?>) this.sort, (List<?>) tracking.sort) || !equals((List<?>) this.filter, (List<?>) tracking.filter) || !equals((List<?>) this.color_block, (List<?>) tracking.color_block) || !equals((List<?>) this.attribute, (List<?>) tracking.attribute) || !equals((List<?>) this.social_media, (List<?>) tracking.social_media) || !equals((Object) this.signature, (Object) tracking.signature) || !equals((Object) this.token, (Object) tracking.token) || !equals((List<?>) this.collection_module, (List<?>) tracking.collection_module) || !equals((List<?>) this.collection_card, (List<?>) tracking.collection_card) || !equals((List<?>) this.button, (List<?>) tracking.button)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Long l = this.log_timestamp;
        int i2 = 0;
        int hashCode = (l != null ? l.hashCode() : 0) * 37;
        Integer num = this.userid;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 37;
        String str = this.deviceid;
        int hashCode3 = (hashCode2 + (str != null ? str.hashCode() : 0)) * 37;
        String str2 = this.country;
        int hashCode4 = (hashCode3 + (str2 != null ? str2.hashCode() : 0)) * 37;
        Long l2 = this.event_timestamp;
        int hashCode5 = (hashCode4 + (l2 != null ? l2.hashCode() : 0)) * 37;
        Integer num2 = this.platform;
        int hashCode6 = (hashCode5 + (num2 != null ? num2.hashCode() : 0)) * 37;
        String str3 = this.client_ip;
        int hashCode7 = (hashCode6 + (str3 != null ? str3.hashCode() : 0)) * 37;
        Boolean bool = this.wifi;
        int hashCode8 = (hashCode7 + (bool != null ? bool.hashCode() : 0)) * 37;
        String str4 = this.os;
        int hashCode9 = (hashCode8 + (str4 != null ? str4.hashCode() : 0)) * 37;
        String str5 = this.os_version;
        int hashCode10 = (hashCode9 + (str5 != null ? str5.hashCode() : 0)) * 37;
        String str6 = this.brand;
        int hashCode11 = (hashCode10 + (str6 != null ? str6.hashCode() : 0)) * 37;
        String str7 = this.model;
        int hashCode12 = (hashCode11 + (str7 != null ? str7.hashCode() : 0)) * 37;
        String str8 = this.app_version;
        int hashCode13 = (hashCode12 + (str8 != null ? str8.hashCode() : 0)) * 37;
        String str9 = this.browser;
        int hashCode14 = (hashCode13 + (str9 != null ? str9.hashCode() : 0)) * 37;
        String str10 = this.browser_version;
        int hashCode15 = (hashCode14 + (str10 != null ? str10.hashCode() : 0)) * 37;
        Integer num3 = this.refer_page;
        int hashCode16 = (hashCode15 + (num3 != null ? num3.hashCode() : 0)) * 37;
        String str11 = this.refer_url;
        int hashCode17 = (hashCode16 + (str11 != null ? str11.hashCode() : 0)) * 37;
        TrackingMarketingToken trackingMarketingToken = this.marketing_token;
        int hashCode18 = (hashCode17 + (trackingMarketingToken != null ? trackingMarketingToken.hashCode() : 0)) * 37;
        List<String> list = this.AB_test;
        int i3 = 1;
        int hashCode19 = (hashCode18 + (list != null ? list.hashCode() : 1)) * 37;
        Integer num4 = this.operation;
        int hashCode20 = (hashCode19 + (num4 != null ? num4.hashCode() : 0)) * 37;
        Integer num5 = this.page_type;
        int hashCode21 = (hashCode20 + (num5 != null ? num5.hashCode() : 0)) * 37;
        String str12 = this.default_page_type;
        int hashCode22 = (hashCode21 + (str12 != null ? str12.hashCode() : 0)) * 37;
        Integer num6 = this.page_section;
        int hashCode23 = (hashCode22 + (num6 != null ? num6.hashCode() : 0)) * 37;
        String str13 = this.default_page_section;
        int hashCode24 = (hashCode23 + (str13 != null ? str13.hashCode() : 0)) * 37;
        Integer num7 = this.target_type;
        int hashCode25 = (hashCode24 + (num7 != null ? num7.hashCode() : 0)) * 37;
        String str14 = this.default_target_type;
        int hashCode26 = (hashCode25 + (str14 != null ? str14.hashCode() : 0)) * 37;
        List<TrackingItem> list2 = this.item;
        int hashCode27 = (hashCode26 + (list2 != null ? list2.hashCode() : 1)) * 37;
        List<TrackingShop> list3 = this.shop;
        int hashCode28 = (hashCode27 + (list3 != null ? list3.hashCode() : 1)) * 37;
        List<TrackingBanner> list4 = this.banner;
        int hashCode29 = (hashCode28 + (list4 != null ? list4.hashCode() : 1)) * 37;
        List<TrackingTrendingSearch> list5 = this.trending_search;
        int hashCode30 = (hashCode29 + (list5 != null ? list5.hashCode() : 1)) * 37;
        List<TrackingCategory> list6 = this.category;
        int hashCode31 = (hashCode30 + (list6 != null ? list6.hashCode() : 1)) * 37;
        List<TrackingTab> list7 = this.tab;
        int hashCode32 = (hashCode31 + (list7 != null ? list7.hashCode() : 1)) * 37;
        List<TrackingSearch> list8 = this.search;
        int hashCode33 = (hashCode32 + (list8 != null ? list8.hashCode() : 1)) * 37;
        List<TrackingSort> list9 = this.sort;
        int hashCode34 = (hashCode33 + (list9 != null ? list9.hashCode() : 1)) * 37;
        List<TrackingFilter> list10 = this.filter;
        int hashCode35 = (hashCode34 + (list10 != null ? list10.hashCode() : 1)) * 37;
        List<TrackingColorBlock> list11 = this.color_block;
        int hashCode36 = (hashCode35 + (list11 != null ? list11.hashCode() : 1)) * 37;
        List<TrackingAttribute> list12 = this.attribute;
        int hashCode37 = (hashCode36 + (list12 != null ? list12.hashCode() : 1)) * 37;
        List<TrackingSocialMedia> list13 = this.social_media;
        int hashCode38 = (hashCode37 + (list13 != null ? list13.hashCode() : 1)) * 37;
        String str15 = this.signature;
        int hashCode39 = (hashCode38 + (str15 != null ? str15.hashCode() : 0)) * 37;
        String str16 = this.token;
        if (str16 != null) {
            i2 = str16.hashCode();
        }
        int i4 = (hashCode39 + i2) * 37;
        List<TrackingCollectionModule> list14 = this.collection_module;
        int hashCode40 = (i4 + (list14 != null ? list14.hashCode() : 1)) * 37;
        List<TrackingCollectionCard> list15 = this.collection_card;
        int hashCode41 = (hashCode40 + (list15 != null ? list15.hashCode() : 1)) * 37;
        List<TrackingButton> list16 = this.button;
        if (list16 != null) {
            i3 = list16.hashCode();
        }
        int i5 = hashCode41 + i3;
        this.hashCode = i5;
        return i5;
    }

    public static final class Builder extends Message.Builder<Tracking> {
        public List<String> AB_test;
        public String app_version;
        public List<TrackingAttribute> attribute;
        public List<TrackingBanner> banner;
        public String brand;
        public String browser;
        public String browser_version;
        public List<TrackingButton> button;
        public List<TrackingCategory> category;
        public String client_ip;
        public List<TrackingCollectionCard> collection_card;
        public List<TrackingCollectionModule> collection_module;
        public List<TrackingColorBlock> color_block;
        public String country;
        public String default_page_section;
        public String default_page_type;
        public String default_target_type;
        public String deviceid;
        public Long event_timestamp;
        public List<TrackingFilter> filter;
        public List<TrackingItem> item;
        public Long log_timestamp;
        public TrackingMarketingToken marketing_token;
        public String model;
        public Integer operation;
        public String os;
        public String os_version;
        public Integer page_section;
        public Integer page_type;
        public Integer platform;
        public Integer refer_page;
        public String refer_url;
        public List<TrackingSearch> search;
        public List<TrackingShop> shop;
        public String signature;
        public List<TrackingSocialMedia> social_media;
        public List<TrackingSort> sort;
        public List<TrackingTab> tab;
        public Integer target_type;
        public String token;
        public List<TrackingTrendingSearch> trending_search;
        public Integer userid;
        public Boolean wifi;

        public Builder() {
        }

        public Builder(Tracking tracking) {
            super(tracking);
            if (tracking != null) {
                this.log_timestamp = tracking.log_timestamp;
                this.userid = tracking.userid;
                this.deviceid = tracking.deviceid;
                this.country = tracking.country;
                this.event_timestamp = tracking.event_timestamp;
                this.platform = tracking.platform;
                this.client_ip = tracking.client_ip;
                this.wifi = tracking.wifi;
                this.os = tracking.os;
                this.os_version = tracking.os_version;
                this.brand = tracking.brand;
                this.model = tracking.model;
                this.app_version = tracking.app_version;
                this.browser = tracking.browser;
                this.browser_version = tracking.browser_version;
                this.refer_page = tracking.refer_page;
                this.refer_url = tracking.refer_url;
                this.marketing_token = tracking.marketing_token;
                this.AB_test = Tracking.copyOf(tracking.AB_test);
                this.operation = tracking.operation;
                this.page_type = tracking.page_type;
                this.default_page_type = tracking.default_page_type;
                this.page_section = tracking.page_section;
                this.default_page_section = tracking.default_page_section;
                this.target_type = tracking.target_type;
                this.default_target_type = tracking.default_target_type;
                this.item = Tracking.copyOf(tracking.item);
                this.shop = Tracking.copyOf(tracking.shop);
                this.banner = Tracking.copyOf(tracking.banner);
                this.trending_search = Tracking.copyOf(tracking.trending_search);
                this.category = Tracking.copyOf(tracking.category);
                this.tab = Tracking.copyOf(tracking.tab);
                this.search = Tracking.copyOf(tracking.search);
                this.sort = Tracking.copyOf(tracking.sort);
                this.filter = Tracking.copyOf(tracking.filter);
                this.color_block = Tracking.copyOf(tracking.color_block);
                this.attribute = Tracking.copyOf(tracking.attribute);
                this.social_media = Tracking.copyOf(tracking.social_media);
                this.signature = tracking.signature;
                this.token = tracking.token;
                this.collection_module = Tracking.copyOf(tracking.collection_module);
                this.collection_card = Tracking.copyOf(tracking.collection_card);
                this.button = Tracking.copyOf(tracking.button);
            }
        }

        public Builder log_timestamp(Long l) {
            this.log_timestamp = l;
            return this;
        }

        public Builder userid(Integer num) {
            this.userid = num;
            return this;
        }

        public Builder deviceid(String str) {
            this.deviceid = str;
            return this;
        }

        public Builder country(String str) {
            this.country = str;
            return this;
        }

        public Builder event_timestamp(Long l) {
            this.event_timestamp = l;
            return this;
        }

        public Builder platform(Integer num) {
            this.platform = num;
            return this;
        }

        public Builder client_ip(String str) {
            this.client_ip = str;
            return this;
        }

        public Builder wifi(Boolean bool) {
            this.wifi = bool;
            return this;
        }

        public Builder os(String str) {
            this.os = str;
            return this;
        }

        public Builder os_version(String str) {
            this.os_version = str;
            return this;
        }

        public Builder brand(String str) {
            this.brand = str;
            return this;
        }

        public Builder model(String str) {
            this.model = str;
            return this;
        }

        public Builder app_version(String str) {
            this.app_version = str;
            return this;
        }

        public Builder browser(String str) {
            this.browser = str;
            return this;
        }

        public Builder browser_version(String str) {
            this.browser_version = str;
            return this;
        }

        public Builder refer_page(Integer num) {
            this.refer_page = num;
            return this;
        }

        public Builder refer_url(String str) {
            this.refer_url = str;
            return this;
        }

        public Builder marketing_token(TrackingMarketingToken trackingMarketingToken) {
            this.marketing_token = trackingMarketingToken;
            return this;
        }

        public Builder AB_test(List<String> list) {
            this.AB_test = checkForNulls(list);
            return this;
        }

        public Builder operation(Integer num) {
            this.operation = num;
            return this;
        }

        public Builder page_type(Integer num) {
            this.page_type = num;
            return this;
        }

        public Builder default_page_type(String str) {
            this.default_page_type = str;
            return this;
        }

        public Builder page_section(Integer num) {
            this.page_section = num;
            return this;
        }

        public Builder default_page_section(String str) {
            this.default_page_section = str;
            return this;
        }

        public Builder target_type(Integer num) {
            this.target_type = num;
            return this;
        }

        public Builder default_target_type(String str) {
            this.default_target_type = str;
            return this;
        }

        public Builder item(List<TrackingItem> list) {
            this.item = checkForNulls(list);
            return this;
        }

        public Builder shop(List<TrackingShop> list) {
            this.shop = checkForNulls(list);
            return this;
        }

        public Builder banner(List<TrackingBanner> list) {
            this.banner = checkForNulls(list);
            return this;
        }

        public Builder trending_search(List<TrackingTrendingSearch> list) {
            this.trending_search = checkForNulls(list);
            return this;
        }

        public Builder category(List<TrackingCategory> list) {
            this.category = checkForNulls(list);
            return this;
        }

        public Builder tab(List<TrackingTab> list) {
            this.tab = checkForNulls(list);
            return this;
        }

        public Builder search(List<TrackingSearch> list) {
            this.search = checkForNulls(list);
            return this;
        }

        public Builder sort(List<TrackingSort> list) {
            this.sort = checkForNulls(list);
            return this;
        }

        public Builder filter(List<TrackingFilter> list) {
            this.filter = checkForNulls(list);
            return this;
        }

        public Builder color_block(List<TrackingColorBlock> list) {
            this.color_block = checkForNulls(list);
            return this;
        }

        public Builder attribute(List<TrackingAttribute> list) {
            this.attribute = checkForNulls(list);
            return this;
        }

        public Builder social_media(List<TrackingSocialMedia> list) {
            this.social_media = checkForNulls(list);
            return this;
        }

        public Builder signature(String str) {
            this.signature = str;
            return this;
        }

        public Builder token(String str) {
            this.token = str;
            return this;
        }

        public Builder collection_module(List<TrackingCollectionModule> list) {
            this.collection_module = checkForNulls(list);
            return this;
        }

        public Builder collection_card(List<TrackingCollectionCard> list) {
            this.collection_card = checkForNulls(list);
            return this;
        }

        public Builder button(List<TrackingButton> list) {
            this.button = checkForNulls(list);
            return this;
        }

        public Tracking build() {
            return new Tracking(this);
        }
    }
}
