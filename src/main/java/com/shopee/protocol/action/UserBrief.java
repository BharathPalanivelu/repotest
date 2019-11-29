package com.shopee.protocol.action;

import com.shopee.protocol.shop.BuyerAddress;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class UserBrief extends Message {
    public static final Boolean DEFAULT_BLOCK_CB_USER = false;
    public static final String DEFAULT_COUNTRY = "";
    public static final Boolean DEFAULT_FOLLOWED = false;
    public static final Integer DEFAULT_FOLLOWER_COUNT = 0;
    public static final Integer DEFAULT_FOLLOWING_COUNT = 0;
    public static final Boolean DEFAULT_IS_OFFICIAL_SHOP = false;
    public static final Boolean DEFAULT_IS_SHIP_FROM_OVERSEAS = false;
    public static final Integer DEFAULT_LAST_LOGIN_TIME = 0;
    public static final String DEFAULT_NICKNAME = "";
    public static final String DEFAULT_PHONE = "";
    public static final Integer DEFAULT_PICKUP_ADDRESS_ID = 0;
    public static final String DEFAULT_PORTRAIT = "";
    public static final Integer DEFAULT_PRODUCTS = 0;
    public static final Integer DEFAULT_RESPONSE_RATE = 0;
    public static final Integer DEFAULT_RESPONSE_TIME = 0;
    public static final Integer DEFAULT_SCORE = 0;
    public static final Integer DEFAULT_SELLER_COIN_SETTING = 0;
    public static final Integer DEFAULT_SHOPEE_VERIFIED_FLAG = 0;
    public static final Integer DEFAULT_SHOPID = 0;
    public static final List<Long> DEFAULT_SHOP_LABEL_IDS = Collections.emptyList();
    public static final Double DEFAULT_SHOP_RATING = Double.valueOf(0.0d);
    public static final Integer DEFAULT_STATUS = 0;
    public static final Integer DEFAULT_USERID = 0;
    public static final String DEFAULT_USERNAME = "";
    public static final String DEFAULT_VISIBLE_REGIONS = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 27, type = Message.Datatype.BOOL)
    public final Boolean block_cb_user;
    @ProtoField(tag = 10, type = Message.Datatype.STRING)
    public final String country;
    @ProtoField(tag = 8, type = Message.Datatype.BOOL)
    public final Boolean followed;
    @ProtoField(tag = 11, type = Message.Datatype.INT32)
    public final Integer follower_count;
    @ProtoField(tag = 16, type = Message.Datatype.INT32)
    public final Integer following_count;
    @ProtoField(tag = 21, type = Message.Datatype.BOOL)
    public final Boolean is_official_shop;
    @ProtoField(tag = 25, type = Message.Datatype.BOOL)
    public final Boolean is_ship_from_overseas;
    @ProtoField(tag = 14, type = Message.Datatype.INT32)
    public final Integer last_login_time;
    @ProtoField(tag = 7, type = Message.Datatype.STRING)
    public final String nickname;
    @ProtoField(tag = 9, type = Message.Datatype.STRING)
    public final String phone;
    @ProtoField(tag = 24)
    public final BuyerAddress pickup_address;
    @ProtoField(tag = 20, type = Message.Datatype.INT32)
    public final Integer pickup_address_id;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String portrait;
    @ProtoField(tag = 6, type = Message.Datatype.INT32)
    public final Integer products;
    @ProtoField(tag = 19, type = Message.Datatype.INT32)
    public final Integer response_rate;
    @ProtoField(tag = 17, type = Message.Datatype.INT32)
    public final Integer response_time;
    @ProtoField(tag = 5, type = Message.Datatype.INT32)
    public final Integer score;
    @ProtoField(tag = 22, type = Message.Datatype.INT32)
    public final Integer seller_coin_setting;
    @ProtoField(label = Message.Label.REPEATED, tag = 23, type = Message.Datatype.INT64)
    public final List<Long> shop_label_ids;
    @ProtoField(tag = 15, type = Message.Datatype.DOUBLE)
    public final Double shop_rating;
    @ProtoField(tag = 13, type = Message.Datatype.INT32)
    public final Integer shopee_verified_flag;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer shopid;
    @ProtoField(tag = 12, type = Message.Datatype.INT32)
    public final Integer status;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer userid;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String username;
    @ProtoField(tag = 26, type = Message.Datatype.STRING)
    public final String visible_regions;

    public UserBrief(Integer num, Integer num2, String str, String str2, Integer num3, Integer num4, String str3, Boolean bool, String str4, String str5, Integer num5, Integer num6, Integer num7, Integer num8, Double d2, Integer num9, Integer num10, Integer num11, Integer num12, Boolean bool2, Integer num13, List<Long> list, BuyerAddress buyerAddress, Boolean bool3, String str6, Boolean bool4) {
        this.userid = num;
        this.shopid = num2;
        this.username = str;
        this.portrait = str2;
        this.score = num3;
        this.products = num4;
        this.nickname = str3;
        this.followed = bool;
        this.phone = str4;
        this.country = str5;
        this.follower_count = num5;
        this.status = num6;
        this.shopee_verified_flag = num7;
        this.last_login_time = num8;
        this.shop_rating = d2;
        this.following_count = num9;
        this.response_time = num10;
        this.response_rate = num11;
        this.pickup_address_id = num12;
        this.is_official_shop = bool2;
        this.seller_coin_setting = num13;
        this.shop_label_ids = immutableCopyOf(list);
        this.pickup_address = buyerAddress;
        this.is_ship_from_overseas = bool3;
        this.visible_regions = str6;
        this.block_cb_user = bool4;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private UserBrief(com.shopee.protocol.action.UserBrief.Builder r30) {
        /*
            r29 = this;
            r0 = r30
            r1 = r29
            java.lang.Integer r2 = r0.userid
            java.lang.Integer r3 = r0.shopid
            java.lang.String r4 = r0.username
            java.lang.String r5 = r0.portrait
            java.lang.Integer r6 = r0.score
            java.lang.Integer r7 = r0.products
            java.lang.String r8 = r0.nickname
            java.lang.Boolean r9 = r0.followed
            java.lang.String r10 = r0.phone
            java.lang.String r11 = r0.country
            java.lang.Integer r12 = r0.follower_count
            java.lang.Integer r13 = r0.status
            java.lang.Integer r14 = r0.shopee_verified_flag
            java.lang.Integer r15 = r0.last_login_time
            r28 = r1
            java.lang.Double r1 = r0.shop_rating
            r16 = r1
            java.lang.Integer r1 = r0.following_count
            r17 = r1
            java.lang.Integer r1 = r0.response_time
            r18 = r1
            java.lang.Integer r1 = r0.response_rate
            r19 = r1
            java.lang.Integer r1 = r0.pickup_address_id
            r20 = r1
            java.lang.Boolean r1 = r0.is_official_shop
            r21 = r1
            java.lang.Integer r1 = r0.seller_coin_setting
            r22 = r1
            java.util.List<java.lang.Long> r1 = r0.shop_label_ids
            r23 = r1
            com.shopee.protocol.shop.BuyerAddress r1 = r0.pickup_address
            r24 = r1
            java.lang.Boolean r1 = r0.is_ship_from_overseas
            r25 = r1
            java.lang.String r1 = r0.visible_regions
            r26 = r1
            java.lang.Boolean r1 = r0.block_cb_user
            r27 = r1
            r1 = r28
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27)
            r29.setBuilder(r30)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shopee.protocol.action.UserBrief.<init>(com.shopee.protocol.action.UserBrief$Builder):void");
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof UserBrief)) {
            return false;
        }
        UserBrief userBrief = (UserBrief) obj;
        if (!equals((Object) this.userid, (Object) userBrief.userid) || !equals((Object) this.shopid, (Object) userBrief.shopid) || !equals((Object) this.username, (Object) userBrief.username) || !equals((Object) this.portrait, (Object) userBrief.portrait) || !equals((Object) this.score, (Object) userBrief.score) || !equals((Object) this.products, (Object) userBrief.products) || !equals((Object) this.nickname, (Object) userBrief.nickname) || !equals((Object) this.followed, (Object) userBrief.followed) || !equals((Object) this.phone, (Object) userBrief.phone) || !equals((Object) this.country, (Object) userBrief.country) || !equals((Object) this.follower_count, (Object) userBrief.follower_count) || !equals((Object) this.status, (Object) userBrief.status) || !equals((Object) this.shopee_verified_flag, (Object) userBrief.shopee_verified_flag) || !equals((Object) this.last_login_time, (Object) userBrief.last_login_time) || !equals((Object) this.shop_rating, (Object) userBrief.shop_rating) || !equals((Object) this.following_count, (Object) userBrief.following_count) || !equals((Object) this.response_time, (Object) userBrief.response_time) || !equals((Object) this.response_rate, (Object) userBrief.response_rate) || !equals((Object) this.pickup_address_id, (Object) userBrief.pickup_address_id) || !equals((Object) this.is_official_shop, (Object) userBrief.is_official_shop) || !equals((Object) this.seller_coin_setting, (Object) userBrief.seller_coin_setting) || !equals((List<?>) this.shop_label_ids, (List<?>) userBrief.shop_label_ids) || !equals((Object) this.pickup_address, (Object) userBrief.pickup_address) || !equals((Object) this.is_ship_from_overseas, (Object) userBrief.is_ship_from_overseas) || !equals((Object) this.visible_regions, (Object) userBrief.visible_regions) || !equals((Object) this.block_cb_user, (Object) userBrief.block_cb_user)) {
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
        Integer num2 = this.shopid;
        int hashCode2 = (hashCode + (num2 != null ? num2.hashCode() : 0)) * 37;
        String str = this.username;
        int hashCode3 = (hashCode2 + (str != null ? str.hashCode() : 0)) * 37;
        String str2 = this.portrait;
        int hashCode4 = (hashCode3 + (str2 != null ? str2.hashCode() : 0)) * 37;
        Integer num3 = this.score;
        int hashCode5 = (hashCode4 + (num3 != null ? num3.hashCode() : 0)) * 37;
        Integer num4 = this.products;
        int hashCode6 = (hashCode5 + (num4 != null ? num4.hashCode() : 0)) * 37;
        String str3 = this.nickname;
        int hashCode7 = (hashCode6 + (str3 != null ? str3.hashCode() : 0)) * 37;
        Boolean bool = this.followed;
        int hashCode8 = (hashCode7 + (bool != null ? bool.hashCode() : 0)) * 37;
        String str4 = this.phone;
        int hashCode9 = (hashCode8 + (str4 != null ? str4.hashCode() : 0)) * 37;
        String str5 = this.country;
        int hashCode10 = (hashCode9 + (str5 != null ? str5.hashCode() : 0)) * 37;
        Integer num5 = this.follower_count;
        int hashCode11 = (hashCode10 + (num5 != null ? num5.hashCode() : 0)) * 37;
        Integer num6 = this.status;
        int hashCode12 = (hashCode11 + (num6 != null ? num6.hashCode() : 0)) * 37;
        Integer num7 = this.shopee_verified_flag;
        int hashCode13 = (hashCode12 + (num7 != null ? num7.hashCode() : 0)) * 37;
        Integer num8 = this.last_login_time;
        int hashCode14 = (hashCode13 + (num8 != null ? num8.hashCode() : 0)) * 37;
        Double d2 = this.shop_rating;
        int hashCode15 = (hashCode14 + (d2 != null ? d2.hashCode() : 0)) * 37;
        Integer num9 = this.following_count;
        int hashCode16 = (hashCode15 + (num9 != null ? num9.hashCode() : 0)) * 37;
        Integer num10 = this.response_time;
        int hashCode17 = (hashCode16 + (num10 != null ? num10.hashCode() : 0)) * 37;
        Integer num11 = this.response_rate;
        int hashCode18 = (hashCode17 + (num11 != null ? num11.hashCode() : 0)) * 37;
        Integer num12 = this.pickup_address_id;
        int hashCode19 = (hashCode18 + (num12 != null ? num12.hashCode() : 0)) * 37;
        Boolean bool2 = this.is_official_shop;
        int hashCode20 = (hashCode19 + (bool2 != null ? bool2.hashCode() : 0)) * 37;
        Integer num13 = this.seller_coin_setting;
        int hashCode21 = (hashCode20 + (num13 != null ? num13.hashCode() : 0)) * 37;
        List<Long> list = this.shop_label_ids;
        int hashCode22 = (hashCode21 + (list != null ? list.hashCode() : 1)) * 37;
        BuyerAddress buyerAddress = this.pickup_address;
        int hashCode23 = (hashCode22 + (buyerAddress != null ? buyerAddress.hashCode() : 0)) * 37;
        Boolean bool3 = this.is_ship_from_overseas;
        int hashCode24 = (hashCode23 + (bool3 != null ? bool3.hashCode() : 0)) * 37;
        String str6 = this.visible_regions;
        int hashCode25 = (hashCode24 + (str6 != null ? str6.hashCode() : 0)) * 37;
        Boolean bool4 = this.block_cb_user;
        if (bool4 != null) {
            i2 = bool4.hashCode();
        }
        int i3 = hashCode25 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<UserBrief> {
        public Boolean block_cb_user;
        public String country;
        public Boolean followed;
        public Integer follower_count;
        public Integer following_count;
        public Boolean is_official_shop;
        public Boolean is_ship_from_overseas;
        public Integer last_login_time;
        public String nickname;
        public String phone;
        public BuyerAddress pickup_address;
        public Integer pickup_address_id;
        public String portrait;
        public Integer products;
        public Integer response_rate;
        public Integer response_time;
        public Integer score;
        public Integer seller_coin_setting;
        public List<Long> shop_label_ids;
        public Double shop_rating;
        public Integer shopee_verified_flag;
        public Integer shopid;
        public Integer status;
        public Integer userid;
        public String username;
        public String visible_regions;

        public Builder() {
        }

        public Builder(UserBrief userBrief) {
            super(userBrief);
            if (userBrief != null) {
                this.userid = userBrief.userid;
                this.shopid = userBrief.shopid;
                this.username = userBrief.username;
                this.portrait = userBrief.portrait;
                this.score = userBrief.score;
                this.products = userBrief.products;
                this.nickname = userBrief.nickname;
                this.followed = userBrief.followed;
                this.phone = userBrief.phone;
                this.country = userBrief.country;
                this.follower_count = userBrief.follower_count;
                this.status = userBrief.status;
                this.shopee_verified_flag = userBrief.shopee_verified_flag;
                this.last_login_time = userBrief.last_login_time;
                this.shop_rating = userBrief.shop_rating;
                this.following_count = userBrief.following_count;
                this.response_time = userBrief.response_time;
                this.response_rate = userBrief.response_rate;
                this.pickup_address_id = userBrief.pickup_address_id;
                this.is_official_shop = userBrief.is_official_shop;
                this.seller_coin_setting = userBrief.seller_coin_setting;
                this.shop_label_ids = UserBrief.copyOf(userBrief.shop_label_ids);
                this.pickup_address = userBrief.pickup_address;
                this.is_ship_from_overseas = userBrief.is_ship_from_overseas;
                this.visible_regions = userBrief.visible_regions;
                this.block_cb_user = userBrief.block_cb_user;
            }
        }

        public Builder userid(Integer num) {
            this.userid = num;
            return this;
        }

        public Builder shopid(Integer num) {
            this.shopid = num;
            return this;
        }

        public Builder username(String str) {
            this.username = str;
            return this;
        }

        public Builder portrait(String str) {
            this.portrait = str;
            return this;
        }

        public Builder score(Integer num) {
            this.score = num;
            return this;
        }

        public Builder products(Integer num) {
            this.products = num;
            return this;
        }

        public Builder nickname(String str) {
            this.nickname = str;
            return this;
        }

        public Builder followed(Boolean bool) {
            this.followed = bool;
            return this;
        }

        public Builder phone(String str) {
            this.phone = str;
            return this;
        }

        public Builder country(String str) {
            this.country = str;
            return this;
        }

        public Builder follower_count(Integer num) {
            this.follower_count = num;
            return this;
        }

        public Builder status(Integer num) {
            this.status = num;
            return this;
        }

        public Builder shopee_verified_flag(Integer num) {
            this.shopee_verified_flag = num;
            return this;
        }

        public Builder last_login_time(Integer num) {
            this.last_login_time = num;
            return this;
        }

        public Builder shop_rating(Double d2) {
            this.shop_rating = d2;
            return this;
        }

        public Builder following_count(Integer num) {
            this.following_count = num;
            return this;
        }

        public Builder response_time(Integer num) {
            this.response_time = num;
            return this;
        }

        public Builder response_rate(Integer num) {
            this.response_rate = num;
            return this;
        }

        public Builder pickup_address_id(Integer num) {
            this.pickup_address_id = num;
            return this;
        }

        public Builder is_official_shop(Boolean bool) {
            this.is_official_shop = bool;
            return this;
        }

        public Builder seller_coin_setting(Integer num) {
            this.seller_coin_setting = num;
            return this;
        }

        public Builder shop_label_ids(List<Long> list) {
            this.shop_label_ids = checkForNulls(list);
            return this;
        }

        public Builder pickup_address(BuyerAddress buyerAddress) {
            this.pickup_address = buyerAddress;
            return this;
        }

        public Builder is_ship_from_overseas(Boolean bool) {
            this.is_ship_from_overseas = bool;
            return this;
        }

        public Builder visible_regions(String str) {
            this.visible_regions = str;
            return this;
        }

        public Builder block_cb_user(Boolean bool) {
            this.block_cb_user = bool;
            return this;
        }

        public UserBrief build() {
            return new UserBrief(this);
        }
    }
}
