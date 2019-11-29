package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class AccountExtInfo extends Message {
    public static final Integer DEFAULT_ADULT_CONSENT = 0;
    public static final Boolean DEFAULT_ALREADY_VERIFIED_PHONE = false;
    public static final String DEFAULT_BACKUP_PHONE = "";
    public static final Integer DEFAULT_BA_CHECK_STATUS = 0;
    public static final String DEFAULT_BEETALK_UNIQUEID = "";
    public static final Integer DEFAULT_BIRTH_TIMESTAMP = 0;
    public static final Integer DEFAULT_CART_ITEM_COUNT = 0;
    public static final List<CreditCardInfo> DEFAULT_CREDIT_CARD = Collections.emptyList();
    public static final Integer DEFAULT_DEFAULT_PAYMENT_METHOD = 0;
    public static final Integer DEFAULT_DELIVERY_ADDRESS_ID = 0;
    public static final Boolean DEFAULT_DISABLE_NEW_DEVICE_LOGIN_OTP = false;
    public static final Boolean DEFAULT_EDITABLE_USERNAME = false;
    public static final Boolean DEFAULT_FEED_PRIVATE = false;
    public static final String DEFAULT_FULL_NAME = "";
    public static final Integer DEFAULT_GENDER = 0;
    public static final Boolean DEFAULT_HAD_PAIED_ESCROW = false;
    public static final Boolean DEFAULT_HIDE_FROM_CONTACT = false;
    public static final Integer DEFAULT_HOLIDAY_MODE_MTIME = 0;
    public static final Boolean DEFAULT_HOLIDAY_MODE_ON = false;
    public static final String DEFAULT_IC_NUMBER = "";
    public static final Boolean DEFAULT_IS_HIGH_LIMIT = false;
    public static final Boolean DEFAULT_IS_SEMI_INACTIVE = false;
    public static final Integer DEFAULT_LAST_CHANGE_BANK_ACCOUNT_TIME = 0;
    public static final Integer DEFAULT_LAST_CHANGE_EMAIL_TIME = 0;
    public static final Integer DEFAULT_LAST_CHANGE_PASSWD_TIME = 0;
    public static final Integer DEFAULT_LAST_CHANGE_PAYMENT_PASSWD_TIME = 0;
    public static final Integer DEFAULT_LAST_CHANGE_PHONE_TIME = 0;
    public static final Integer DEFAULT_LAST_VERIFY_EMAIL_TIME = 0;
    public static final String DEFAULT_LINEID = "";
    public static final String DEFAULT_NICKNAME = "";
    public static final Boolean DEFAULT_NOT_DP_NEW_USER = false;
    public static final Boolean DEFAULT_NOT_NEW_USER = false;
    public static final Integer DEFAULT_OTP_HISTORY = 0;
    public static final String DEFAULT_PAYMENT_PASSWORD = "";
    public static final Integer DEFAULT_RECEIPT_FLAG = 0;
    public static final Integer DEFAULT_SMID_STATUS = 0;
    public static final String DEFAULT_TAX_ID = "";
    public static final Integer DEFAULT_TOS_ACCEPTED_TIME = 0;
    public static final Double DEFAULT_TOTAL_AVG_STAR = Double.valueOf(0.0d);
    public static final String DEFAULT_WEB_EXTRA_DATA = "";
    public static final Long DEFAULT_WEB_OPTION = 0L;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 13)
    public final AccountAccessConfig access;
    @ProtoField(tag = 21)
    public final UserAddressInfo addr_info;
    @ProtoField(tag = 49, type = Message.Datatype.INT32)
    public final Integer adult_consent;
    @ProtoField(tag = 29, type = Message.Datatype.BOOL)
    public final Boolean already_verified_phone;
    @ProtoField(tag = 25, type = Message.Datatype.INT32)
    public final Integer ba_check_status;
    @ProtoField(tag = 26, type = Message.Datatype.STRING)
    public final String backup_phone;
    @ProtoField(tag = 2)
    public final BankAccountInfo bank_account;
    @ProtoField(tag = 11, type = Message.Datatype.STRING)
    public final String beetalk_uniqueid;
    @ProtoField(tag = 10, type = Message.Datatype.INT32)
    public final Integer birth_timestamp;
    @ProtoField(tag = 4)
    public final BankAccountInfo buyer_bank_account;
    @ProtoField(tag = 15)
    public final BuyerOrderHistory buyer_history;
    @ProtoField(tag = 16)
    public final BuyerRating buyer_rating;
    @ProtoField(tag = 17, type = Message.Datatype.INT32)
    public final Integer cart_item_count;
    @ProtoField(label = Message.Label.REPEATED, messageType = CreditCardInfo.class, tag = 1)
    public final List<CreditCardInfo> credit_card;
    @ProtoField(tag = 5, type = Message.Datatype.INT32)
    public final Integer default_payment_method;
    @ProtoField(tag = 6, type = Message.Datatype.INT32)
    public final Integer delivery_address_id;
    @ProtoField(tag = 33, type = Message.Datatype.BOOL)
    public final Boolean disable_new_device_login_otp;
    @ProtoField(tag = 32)
    public final BuyerDropshippingInfo dropshipping_info;
    @ProtoField(tag = 52, type = Message.Datatype.BOOL)
    public final Boolean editable_username;
    @ProtoField(tag = 38)
    public final FeedAccountInfo feed_account_info;
    @ProtoField(tag = 7, type = Message.Datatype.BOOL)
    public final Boolean feed_private;
    @ProtoField(tag = 50, type = Message.Datatype.STRING)
    public final String full_name;
    @ProtoField(tag = 9, type = Message.Datatype.INT32)
    public final Integer gender;
    @ProtoField(tag = 24, type = Message.Datatype.BOOL)
    public final Boolean had_paied_escrow;
    @ProtoField(tag = 22, type = Message.Datatype.BOOL)
    public final Boolean hide_from_contact;
    @ProtoField(tag = 20, type = Message.Datatype.INT32)
    public final Integer holiday_mode_mtime;
    @ProtoField(tag = 19, type = Message.Datatype.BOOL)
    public final Boolean holiday_mode_on;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String ic_number;
    @ProtoField(tag = 28, type = Message.Datatype.BOOL)
    public final Boolean is_high_limit;
    @ProtoField(tag = 12, type = Message.Datatype.BOOL)
    public final Boolean is_semi_inactive;
    @ProtoField(tag = 45)
    public final JkoAccountBuyer jko_buyer;
    @ProtoField(tag = 46)
    public final JkoAccountSeller jko_seller;
    @ProtoField(tag = 36, type = Message.Datatype.INT32)
    public final Integer last_change_bank_account_time;
    @ProtoField(tag = 47, type = Message.Datatype.INT32)
    public final Integer last_change_email_time;
    @ProtoField(tag = 27, type = Message.Datatype.INT32)
    public final Integer last_change_passwd_time;
    @ProtoField(tag = 35, type = Message.Datatype.INT32)
    public final Integer last_change_payment_passwd_time;
    @ProtoField(tag = 31, type = Message.Datatype.INT32)
    public final Integer last_change_phone_time;
    @ProtoField(tag = 48, type = Message.Datatype.INT32)
    public final Integer last_verify_email_time;
    @ProtoField(tag = 40, type = Message.Datatype.STRING)
    public final String lineid;
    @ProtoField(tag = 41)
    public final LiveAccountInfo live_account_info;
    @ProtoField(tag = 39, type = Message.Datatype.STRING)
    public final String nickname;
    @ProtoField(tag = 43, type = Message.Datatype.BOOL)
    public final Boolean not_dp_new_user;
    @ProtoField(tag = 37, type = Message.Datatype.BOOL)
    public final Boolean not_new_user;
    @ProtoField(tag = 44, type = Message.Datatype.INT32)
    public final Integer otp_history;
    @ProtoField(tag = 23, type = Message.Datatype.STRING)
    public final String payment_password;
    @ProtoField(tag = 30, type = Message.Datatype.INT32)
    public final Integer receipt_flag;
    @ProtoField(tag = 34, type = Message.Datatype.INT32)
    public final Integer smid_status;
    @ProtoField(tag = 51, type = Message.Datatype.STRING)
    public final String tax_id;
    @ProtoField(tag = 42, type = Message.Datatype.INT32)
    public final Integer tos_accepted_time;
    @ProtoField(tag = 18, type = Message.Datatype.DOUBLE)
    public final Double total_avg_star;
    @ProtoField(tag = 14, type = Message.Datatype.STRING)
    public final String web_extra_data;
    @ProtoField(tag = 8, type = Message.Datatype.INT64)
    public final Long web_option;

    public AccountExtInfo(List<CreditCardInfo> list, BankAccountInfo bankAccountInfo, String str, BankAccountInfo bankAccountInfo2, Integer num, Integer num2, Boolean bool, Long l, Integer num3, Integer num4, String str2, Boolean bool2, AccountAccessConfig accountAccessConfig, String str3, BuyerOrderHistory buyerOrderHistory, BuyerRating buyerRating, Integer num5, Double d2, Boolean bool3, Integer num6, UserAddressInfo userAddressInfo, Boolean bool4, String str4, Boolean bool5, Integer num7, String str5, Integer num8, Boolean bool6, Boolean bool7, Integer num9, Integer num10, BuyerDropshippingInfo buyerDropshippingInfo, Boolean bool8, Integer num11, Integer num12, Integer num13, Boolean bool9, FeedAccountInfo feedAccountInfo, String str6, String str7, LiveAccountInfo liveAccountInfo, Integer num14, Boolean bool10, Integer num15, JkoAccountBuyer jkoAccountBuyer, JkoAccountSeller jkoAccountSeller, Integer num16, Integer num17, Integer num18, String str8, String str9, Boolean bool11) {
        this.credit_card = immutableCopyOf(list);
        this.bank_account = bankAccountInfo;
        this.ic_number = str;
        this.buyer_bank_account = bankAccountInfo2;
        this.default_payment_method = num;
        this.delivery_address_id = num2;
        this.feed_private = bool;
        this.web_option = l;
        this.gender = num3;
        this.birth_timestamp = num4;
        this.beetalk_uniqueid = str2;
        this.is_semi_inactive = bool2;
        this.access = accountAccessConfig;
        this.web_extra_data = str3;
        this.buyer_history = buyerOrderHistory;
        this.buyer_rating = buyerRating;
        this.cart_item_count = num5;
        this.total_avg_star = d2;
        this.holiday_mode_on = bool3;
        this.holiday_mode_mtime = num6;
        this.addr_info = userAddressInfo;
        this.hide_from_contact = bool4;
        this.payment_password = str4;
        this.had_paied_escrow = bool5;
        this.ba_check_status = num7;
        this.backup_phone = str5;
        this.last_change_passwd_time = num8;
        this.is_high_limit = bool6;
        this.already_verified_phone = bool7;
        this.receipt_flag = num9;
        this.last_change_phone_time = num10;
        this.dropshipping_info = buyerDropshippingInfo;
        this.disable_new_device_login_otp = bool8;
        this.smid_status = num11;
        this.last_change_payment_passwd_time = num12;
        this.last_change_bank_account_time = num13;
        this.not_new_user = bool9;
        this.feed_account_info = feedAccountInfo;
        this.nickname = str6;
        this.lineid = str7;
        this.live_account_info = liveAccountInfo;
        this.tos_accepted_time = num14;
        this.not_dp_new_user = bool10;
        this.otp_history = num15;
        this.jko_buyer = jkoAccountBuyer;
        this.jko_seller = jkoAccountSeller;
        this.last_change_email_time = num16;
        this.last_verify_email_time = num17;
        this.adult_consent = num18;
        this.full_name = str8;
        this.tax_id = str9;
        this.editable_username = bool11;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private AccountExtInfo(com.shopee.protocol.shop.AccountExtInfo.Builder r56) {
        /*
            r55 = this;
            r0 = r56
            r1 = r55
            java.util.List<com.shopee.protocol.shop.CreditCardInfo> r2 = r0.credit_card
            com.shopee.protocol.shop.BankAccountInfo r3 = r0.bank_account
            java.lang.String r4 = r0.ic_number
            com.shopee.protocol.shop.BankAccountInfo r5 = r0.buyer_bank_account
            java.lang.Integer r6 = r0.default_payment_method
            java.lang.Integer r7 = r0.delivery_address_id
            java.lang.Boolean r8 = r0.feed_private
            java.lang.Long r9 = r0.web_option
            java.lang.Integer r10 = r0.gender
            java.lang.Integer r11 = r0.birth_timestamp
            java.lang.String r12 = r0.beetalk_uniqueid
            java.lang.Boolean r13 = r0.is_semi_inactive
            com.shopee.protocol.shop.AccountAccessConfig r14 = r0.access
            java.lang.String r15 = r0.web_extra_data
            r54 = r1
            com.shopee.protocol.shop.BuyerOrderHistory r1 = r0.buyer_history
            r16 = r1
            com.shopee.protocol.shop.BuyerRating r1 = r0.buyer_rating
            r17 = r1
            java.lang.Integer r1 = r0.cart_item_count
            r18 = r1
            java.lang.Double r1 = r0.total_avg_star
            r19 = r1
            java.lang.Boolean r1 = r0.holiday_mode_on
            r20 = r1
            java.lang.Integer r1 = r0.holiday_mode_mtime
            r21 = r1
            com.shopee.protocol.shop.UserAddressInfo r1 = r0.addr_info
            r22 = r1
            java.lang.Boolean r1 = r0.hide_from_contact
            r23 = r1
            java.lang.String r1 = r0.payment_password
            r24 = r1
            java.lang.Boolean r1 = r0.had_paied_escrow
            r25 = r1
            java.lang.Integer r1 = r0.ba_check_status
            r26 = r1
            java.lang.String r1 = r0.backup_phone
            r27 = r1
            java.lang.Integer r1 = r0.last_change_passwd_time
            r28 = r1
            java.lang.Boolean r1 = r0.is_high_limit
            r29 = r1
            java.lang.Boolean r1 = r0.already_verified_phone
            r30 = r1
            java.lang.Integer r1 = r0.receipt_flag
            r31 = r1
            java.lang.Integer r1 = r0.last_change_phone_time
            r32 = r1
            com.shopee.protocol.shop.BuyerDropshippingInfo r1 = r0.dropshipping_info
            r33 = r1
            java.lang.Boolean r1 = r0.disable_new_device_login_otp
            r34 = r1
            java.lang.Integer r1 = r0.smid_status
            r35 = r1
            java.lang.Integer r1 = r0.last_change_payment_passwd_time
            r36 = r1
            java.lang.Integer r1 = r0.last_change_bank_account_time
            r37 = r1
            java.lang.Boolean r1 = r0.not_new_user
            r38 = r1
            com.shopee.protocol.shop.FeedAccountInfo r1 = r0.feed_account_info
            r39 = r1
            java.lang.String r1 = r0.nickname
            r40 = r1
            java.lang.String r1 = r0.lineid
            r41 = r1
            com.shopee.protocol.shop.LiveAccountInfo r1 = r0.live_account_info
            r42 = r1
            java.lang.Integer r1 = r0.tos_accepted_time
            r43 = r1
            java.lang.Boolean r1 = r0.not_dp_new_user
            r44 = r1
            java.lang.Integer r1 = r0.otp_history
            r45 = r1
            com.shopee.protocol.shop.JkoAccountBuyer r1 = r0.jko_buyer
            r46 = r1
            com.shopee.protocol.shop.JkoAccountSeller r1 = r0.jko_seller
            r47 = r1
            java.lang.Integer r1 = r0.last_change_email_time
            r48 = r1
            java.lang.Integer r1 = r0.last_verify_email_time
            r49 = r1
            java.lang.Integer r1 = r0.adult_consent
            r50 = r1
            java.lang.String r1 = r0.full_name
            r51 = r1
            java.lang.String r1 = r0.tax_id
            r52 = r1
            java.lang.Boolean r1 = r0.editable_username
            r53 = r1
            r1 = r54
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42, r43, r44, r45, r46, r47, r48, r49, r50, r51, r52, r53)
            r55.setBuilder(r56)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shopee.protocol.shop.AccountExtInfo.<init>(com.shopee.protocol.shop.AccountExtInfo$Builder):void");
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AccountExtInfo)) {
            return false;
        }
        AccountExtInfo accountExtInfo = (AccountExtInfo) obj;
        if (!equals((List<?>) this.credit_card, (List<?>) accountExtInfo.credit_card) || !equals((Object) this.bank_account, (Object) accountExtInfo.bank_account) || !equals((Object) this.ic_number, (Object) accountExtInfo.ic_number) || !equals((Object) this.buyer_bank_account, (Object) accountExtInfo.buyer_bank_account) || !equals((Object) this.default_payment_method, (Object) accountExtInfo.default_payment_method) || !equals((Object) this.delivery_address_id, (Object) accountExtInfo.delivery_address_id) || !equals((Object) this.feed_private, (Object) accountExtInfo.feed_private) || !equals((Object) this.web_option, (Object) accountExtInfo.web_option) || !equals((Object) this.gender, (Object) accountExtInfo.gender) || !equals((Object) this.birth_timestamp, (Object) accountExtInfo.birth_timestamp) || !equals((Object) this.beetalk_uniqueid, (Object) accountExtInfo.beetalk_uniqueid) || !equals((Object) this.is_semi_inactive, (Object) accountExtInfo.is_semi_inactive) || !equals((Object) this.access, (Object) accountExtInfo.access) || !equals((Object) this.web_extra_data, (Object) accountExtInfo.web_extra_data) || !equals((Object) this.buyer_history, (Object) accountExtInfo.buyer_history) || !equals((Object) this.buyer_rating, (Object) accountExtInfo.buyer_rating) || !equals((Object) this.cart_item_count, (Object) accountExtInfo.cart_item_count) || !equals((Object) this.total_avg_star, (Object) accountExtInfo.total_avg_star) || !equals((Object) this.holiday_mode_on, (Object) accountExtInfo.holiday_mode_on) || !equals((Object) this.holiday_mode_mtime, (Object) accountExtInfo.holiday_mode_mtime) || !equals((Object) this.addr_info, (Object) accountExtInfo.addr_info) || !equals((Object) this.hide_from_contact, (Object) accountExtInfo.hide_from_contact) || !equals((Object) this.payment_password, (Object) accountExtInfo.payment_password) || !equals((Object) this.had_paied_escrow, (Object) accountExtInfo.had_paied_escrow) || !equals((Object) this.ba_check_status, (Object) accountExtInfo.ba_check_status) || !equals((Object) this.backup_phone, (Object) accountExtInfo.backup_phone) || !equals((Object) this.last_change_passwd_time, (Object) accountExtInfo.last_change_passwd_time) || !equals((Object) this.is_high_limit, (Object) accountExtInfo.is_high_limit) || !equals((Object) this.already_verified_phone, (Object) accountExtInfo.already_verified_phone) || !equals((Object) this.receipt_flag, (Object) accountExtInfo.receipt_flag) || !equals((Object) this.last_change_phone_time, (Object) accountExtInfo.last_change_phone_time) || !equals((Object) this.dropshipping_info, (Object) accountExtInfo.dropshipping_info) || !equals((Object) this.disable_new_device_login_otp, (Object) accountExtInfo.disable_new_device_login_otp) || !equals((Object) this.smid_status, (Object) accountExtInfo.smid_status) || !equals((Object) this.last_change_payment_passwd_time, (Object) accountExtInfo.last_change_payment_passwd_time) || !equals((Object) this.last_change_bank_account_time, (Object) accountExtInfo.last_change_bank_account_time) || !equals((Object) this.not_new_user, (Object) accountExtInfo.not_new_user) || !equals((Object) this.feed_account_info, (Object) accountExtInfo.feed_account_info) || !equals((Object) this.nickname, (Object) accountExtInfo.nickname) || !equals((Object) this.lineid, (Object) accountExtInfo.lineid) || !equals((Object) this.live_account_info, (Object) accountExtInfo.live_account_info) || !equals((Object) this.tos_accepted_time, (Object) accountExtInfo.tos_accepted_time) || !equals((Object) this.not_dp_new_user, (Object) accountExtInfo.not_dp_new_user) || !equals((Object) this.otp_history, (Object) accountExtInfo.otp_history) || !equals((Object) this.jko_buyer, (Object) accountExtInfo.jko_buyer) || !equals((Object) this.jko_seller, (Object) accountExtInfo.jko_seller) || !equals((Object) this.last_change_email_time, (Object) accountExtInfo.last_change_email_time) || !equals((Object) this.last_verify_email_time, (Object) accountExtInfo.last_verify_email_time) || !equals((Object) this.adult_consent, (Object) accountExtInfo.adult_consent) || !equals((Object) this.full_name, (Object) accountExtInfo.full_name) || !equals((Object) this.tax_id, (Object) accountExtInfo.tax_id) || !equals((Object) this.editable_username, (Object) accountExtInfo.editable_username)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        List<CreditCardInfo> list = this.credit_card;
        int hashCode = (list != null ? list.hashCode() : 1) * 37;
        BankAccountInfo bankAccountInfo = this.bank_account;
        int i2 = 0;
        int hashCode2 = (hashCode + (bankAccountInfo != null ? bankAccountInfo.hashCode() : 0)) * 37;
        String str = this.ic_number;
        int hashCode3 = (hashCode2 + (str != null ? str.hashCode() : 0)) * 37;
        BankAccountInfo bankAccountInfo2 = this.buyer_bank_account;
        int hashCode4 = (hashCode3 + (bankAccountInfo2 != null ? bankAccountInfo2.hashCode() : 0)) * 37;
        Integer num = this.default_payment_method;
        int hashCode5 = (hashCode4 + (num != null ? num.hashCode() : 0)) * 37;
        Integer num2 = this.delivery_address_id;
        int hashCode6 = (hashCode5 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Boolean bool = this.feed_private;
        int hashCode7 = (hashCode6 + (bool != null ? bool.hashCode() : 0)) * 37;
        Long l = this.web_option;
        int hashCode8 = (hashCode7 + (l != null ? l.hashCode() : 0)) * 37;
        Integer num3 = this.gender;
        int hashCode9 = (hashCode8 + (num3 != null ? num3.hashCode() : 0)) * 37;
        Integer num4 = this.birth_timestamp;
        int hashCode10 = (hashCode9 + (num4 != null ? num4.hashCode() : 0)) * 37;
        String str2 = this.beetalk_uniqueid;
        int hashCode11 = (hashCode10 + (str2 != null ? str2.hashCode() : 0)) * 37;
        Boolean bool2 = this.is_semi_inactive;
        int hashCode12 = (hashCode11 + (bool2 != null ? bool2.hashCode() : 0)) * 37;
        AccountAccessConfig accountAccessConfig = this.access;
        int hashCode13 = (hashCode12 + (accountAccessConfig != null ? accountAccessConfig.hashCode() : 0)) * 37;
        String str3 = this.web_extra_data;
        int hashCode14 = (hashCode13 + (str3 != null ? str3.hashCode() : 0)) * 37;
        BuyerOrderHistory buyerOrderHistory = this.buyer_history;
        int hashCode15 = (hashCode14 + (buyerOrderHistory != null ? buyerOrderHistory.hashCode() : 0)) * 37;
        BuyerRating buyerRating = this.buyer_rating;
        int hashCode16 = (hashCode15 + (buyerRating != null ? buyerRating.hashCode() : 0)) * 37;
        Integer num5 = this.cart_item_count;
        int hashCode17 = (hashCode16 + (num5 != null ? num5.hashCode() : 0)) * 37;
        Double d2 = this.total_avg_star;
        int hashCode18 = (hashCode17 + (d2 != null ? d2.hashCode() : 0)) * 37;
        Boolean bool3 = this.holiday_mode_on;
        int hashCode19 = (hashCode18 + (bool3 != null ? bool3.hashCode() : 0)) * 37;
        Integer num6 = this.holiday_mode_mtime;
        int hashCode20 = (hashCode19 + (num6 != null ? num6.hashCode() : 0)) * 37;
        UserAddressInfo userAddressInfo = this.addr_info;
        int hashCode21 = (hashCode20 + (userAddressInfo != null ? userAddressInfo.hashCode() : 0)) * 37;
        Boolean bool4 = this.hide_from_contact;
        int hashCode22 = (hashCode21 + (bool4 != null ? bool4.hashCode() : 0)) * 37;
        String str4 = this.payment_password;
        int hashCode23 = (hashCode22 + (str4 != null ? str4.hashCode() : 0)) * 37;
        Boolean bool5 = this.had_paied_escrow;
        int hashCode24 = (hashCode23 + (bool5 != null ? bool5.hashCode() : 0)) * 37;
        Integer num7 = this.ba_check_status;
        int hashCode25 = (hashCode24 + (num7 != null ? num7.hashCode() : 0)) * 37;
        String str5 = this.backup_phone;
        int hashCode26 = (hashCode25 + (str5 != null ? str5.hashCode() : 0)) * 37;
        Integer num8 = this.last_change_passwd_time;
        int hashCode27 = (hashCode26 + (num8 != null ? num8.hashCode() : 0)) * 37;
        Boolean bool6 = this.is_high_limit;
        int hashCode28 = (hashCode27 + (bool6 != null ? bool6.hashCode() : 0)) * 37;
        Boolean bool7 = this.already_verified_phone;
        int hashCode29 = (hashCode28 + (bool7 != null ? bool7.hashCode() : 0)) * 37;
        Integer num9 = this.receipt_flag;
        int hashCode30 = (hashCode29 + (num9 != null ? num9.hashCode() : 0)) * 37;
        Integer num10 = this.last_change_phone_time;
        int hashCode31 = (hashCode30 + (num10 != null ? num10.hashCode() : 0)) * 37;
        BuyerDropshippingInfo buyerDropshippingInfo = this.dropshipping_info;
        int hashCode32 = (hashCode31 + (buyerDropshippingInfo != null ? buyerDropshippingInfo.hashCode() : 0)) * 37;
        Boolean bool8 = this.disable_new_device_login_otp;
        int hashCode33 = (hashCode32 + (bool8 != null ? bool8.hashCode() : 0)) * 37;
        Integer num11 = this.smid_status;
        int hashCode34 = (hashCode33 + (num11 != null ? num11.hashCode() : 0)) * 37;
        Integer num12 = this.last_change_payment_passwd_time;
        int hashCode35 = (hashCode34 + (num12 != null ? num12.hashCode() : 0)) * 37;
        Integer num13 = this.last_change_bank_account_time;
        int hashCode36 = (hashCode35 + (num13 != null ? num13.hashCode() : 0)) * 37;
        Boolean bool9 = this.not_new_user;
        int hashCode37 = (hashCode36 + (bool9 != null ? bool9.hashCode() : 0)) * 37;
        FeedAccountInfo feedAccountInfo = this.feed_account_info;
        int hashCode38 = (hashCode37 + (feedAccountInfo != null ? feedAccountInfo.hashCode() : 0)) * 37;
        String str6 = this.nickname;
        int hashCode39 = (hashCode38 + (str6 != null ? str6.hashCode() : 0)) * 37;
        String str7 = this.lineid;
        int hashCode40 = (hashCode39 + (str7 != null ? str7.hashCode() : 0)) * 37;
        LiveAccountInfo liveAccountInfo = this.live_account_info;
        int hashCode41 = (hashCode40 + (liveAccountInfo != null ? liveAccountInfo.hashCode() : 0)) * 37;
        Integer num14 = this.tos_accepted_time;
        int hashCode42 = (hashCode41 + (num14 != null ? num14.hashCode() : 0)) * 37;
        Boolean bool10 = this.not_dp_new_user;
        int hashCode43 = (hashCode42 + (bool10 != null ? bool10.hashCode() : 0)) * 37;
        Integer num15 = this.otp_history;
        int hashCode44 = (hashCode43 + (num15 != null ? num15.hashCode() : 0)) * 37;
        JkoAccountBuyer jkoAccountBuyer = this.jko_buyer;
        int hashCode45 = (hashCode44 + (jkoAccountBuyer != null ? jkoAccountBuyer.hashCode() : 0)) * 37;
        JkoAccountSeller jkoAccountSeller = this.jko_seller;
        int hashCode46 = (hashCode45 + (jkoAccountSeller != null ? jkoAccountSeller.hashCode() : 0)) * 37;
        Integer num16 = this.last_change_email_time;
        int hashCode47 = (hashCode46 + (num16 != null ? num16.hashCode() : 0)) * 37;
        Integer num17 = this.last_verify_email_time;
        int hashCode48 = (hashCode47 + (num17 != null ? num17.hashCode() : 0)) * 37;
        Integer num18 = this.adult_consent;
        int hashCode49 = (hashCode48 + (num18 != null ? num18.hashCode() : 0)) * 37;
        String str8 = this.full_name;
        int hashCode50 = (hashCode49 + (str8 != null ? str8.hashCode() : 0)) * 37;
        String str9 = this.tax_id;
        int hashCode51 = (hashCode50 + (str9 != null ? str9.hashCode() : 0)) * 37;
        Boolean bool11 = this.editable_username;
        if (bool11 != null) {
            i2 = bool11.hashCode();
        }
        int i3 = hashCode51 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<AccountExtInfo> {
        public AccountAccessConfig access;
        public UserAddressInfo addr_info;
        public Integer adult_consent;
        public Boolean already_verified_phone;
        public Integer ba_check_status;
        public String backup_phone;
        public BankAccountInfo bank_account;
        public String beetalk_uniqueid;
        public Integer birth_timestamp;
        public BankAccountInfo buyer_bank_account;
        public BuyerOrderHistory buyer_history;
        public BuyerRating buyer_rating;
        public Integer cart_item_count;
        public List<CreditCardInfo> credit_card;
        public Integer default_payment_method;
        public Integer delivery_address_id;
        public Boolean disable_new_device_login_otp;
        public BuyerDropshippingInfo dropshipping_info;
        public Boolean editable_username;
        public FeedAccountInfo feed_account_info;
        public Boolean feed_private;
        public String full_name;
        public Integer gender;
        public Boolean had_paied_escrow;
        public Boolean hide_from_contact;
        public Integer holiday_mode_mtime;
        public Boolean holiday_mode_on;
        public String ic_number;
        public Boolean is_high_limit;
        public Boolean is_semi_inactive;
        public JkoAccountBuyer jko_buyer;
        public JkoAccountSeller jko_seller;
        public Integer last_change_bank_account_time;
        public Integer last_change_email_time;
        public Integer last_change_passwd_time;
        public Integer last_change_payment_passwd_time;
        public Integer last_change_phone_time;
        public Integer last_verify_email_time;
        public String lineid;
        public LiveAccountInfo live_account_info;
        public String nickname;
        public Boolean not_dp_new_user;
        public Boolean not_new_user;
        public Integer otp_history;
        public String payment_password;
        public Integer receipt_flag;
        public Integer smid_status;
        public String tax_id;
        public Integer tos_accepted_time;
        public Double total_avg_star;
        public String web_extra_data;
        public Long web_option;

        public Builder() {
        }

        public Builder(AccountExtInfo accountExtInfo) {
            super(accountExtInfo);
            if (accountExtInfo != null) {
                this.credit_card = AccountExtInfo.copyOf(accountExtInfo.credit_card);
                this.bank_account = accountExtInfo.bank_account;
                this.ic_number = accountExtInfo.ic_number;
                this.buyer_bank_account = accountExtInfo.buyer_bank_account;
                this.default_payment_method = accountExtInfo.default_payment_method;
                this.delivery_address_id = accountExtInfo.delivery_address_id;
                this.feed_private = accountExtInfo.feed_private;
                this.web_option = accountExtInfo.web_option;
                this.gender = accountExtInfo.gender;
                this.birth_timestamp = accountExtInfo.birth_timestamp;
                this.beetalk_uniqueid = accountExtInfo.beetalk_uniqueid;
                this.is_semi_inactive = accountExtInfo.is_semi_inactive;
                this.access = accountExtInfo.access;
                this.web_extra_data = accountExtInfo.web_extra_data;
                this.buyer_history = accountExtInfo.buyer_history;
                this.buyer_rating = accountExtInfo.buyer_rating;
                this.cart_item_count = accountExtInfo.cart_item_count;
                this.total_avg_star = accountExtInfo.total_avg_star;
                this.holiday_mode_on = accountExtInfo.holiday_mode_on;
                this.holiday_mode_mtime = accountExtInfo.holiday_mode_mtime;
                this.addr_info = accountExtInfo.addr_info;
                this.hide_from_contact = accountExtInfo.hide_from_contact;
                this.payment_password = accountExtInfo.payment_password;
                this.had_paied_escrow = accountExtInfo.had_paied_escrow;
                this.ba_check_status = accountExtInfo.ba_check_status;
                this.backup_phone = accountExtInfo.backup_phone;
                this.last_change_passwd_time = accountExtInfo.last_change_passwd_time;
                this.is_high_limit = accountExtInfo.is_high_limit;
                this.already_verified_phone = accountExtInfo.already_verified_phone;
                this.receipt_flag = accountExtInfo.receipt_flag;
                this.last_change_phone_time = accountExtInfo.last_change_phone_time;
                this.dropshipping_info = accountExtInfo.dropshipping_info;
                this.disable_new_device_login_otp = accountExtInfo.disable_new_device_login_otp;
                this.smid_status = accountExtInfo.smid_status;
                this.last_change_payment_passwd_time = accountExtInfo.last_change_payment_passwd_time;
                this.last_change_bank_account_time = accountExtInfo.last_change_bank_account_time;
                this.not_new_user = accountExtInfo.not_new_user;
                this.feed_account_info = accountExtInfo.feed_account_info;
                this.nickname = accountExtInfo.nickname;
                this.lineid = accountExtInfo.lineid;
                this.live_account_info = accountExtInfo.live_account_info;
                this.tos_accepted_time = accountExtInfo.tos_accepted_time;
                this.not_dp_new_user = accountExtInfo.not_dp_new_user;
                this.otp_history = accountExtInfo.otp_history;
                this.jko_buyer = accountExtInfo.jko_buyer;
                this.jko_seller = accountExtInfo.jko_seller;
                this.last_change_email_time = accountExtInfo.last_change_email_time;
                this.last_verify_email_time = accountExtInfo.last_verify_email_time;
                this.adult_consent = accountExtInfo.adult_consent;
                this.full_name = accountExtInfo.full_name;
                this.tax_id = accountExtInfo.tax_id;
                this.editable_username = accountExtInfo.editable_username;
            }
        }

        public Builder credit_card(List<CreditCardInfo> list) {
            this.credit_card = checkForNulls(list);
            return this;
        }

        public Builder bank_account(BankAccountInfo bankAccountInfo) {
            this.bank_account = bankAccountInfo;
            return this;
        }

        public Builder ic_number(String str) {
            this.ic_number = str;
            return this;
        }

        public Builder buyer_bank_account(BankAccountInfo bankAccountInfo) {
            this.buyer_bank_account = bankAccountInfo;
            return this;
        }

        public Builder default_payment_method(Integer num) {
            this.default_payment_method = num;
            return this;
        }

        public Builder delivery_address_id(Integer num) {
            this.delivery_address_id = num;
            return this;
        }

        public Builder feed_private(Boolean bool) {
            this.feed_private = bool;
            return this;
        }

        public Builder web_option(Long l) {
            this.web_option = l;
            return this;
        }

        public Builder gender(Integer num) {
            this.gender = num;
            return this;
        }

        public Builder birth_timestamp(Integer num) {
            this.birth_timestamp = num;
            return this;
        }

        public Builder beetalk_uniqueid(String str) {
            this.beetalk_uniqueid = str;
            return this;
        }

        public Builder is_semi_inactive(Boolean bool) {
            this.is_semi_inactive = bool;
            return this;
        }

        public Builder access(AccountAccessConfig accountAccessConfig) {
            this.access = accountAccessConfig;
            return this;
        }

        public Builder web_extra_data(String str) {
            this.web_extra_data = str;
            return this;
        }

        public Builder buyer_history(BuyerOrderHistory buyerOrderHistory) {
            this.buyer_history = buyerOrderHistory;
            return this;
        }

        public Builder buyer_rating(BuyerRating buyerRating) {
            this.buyer_rating = buyerRating;
            return this;
        }

        public Builder cart_item_count(Integer num) {
            this.cart_item_count = num;
            return this;
        }

        public Builder total_avg_star(Double d2) {
            this.total_avg_star = d2;
            return this;
        }

        public Builder holiday_mode_on(Boolean bool) {
            this.holiday_mode_on = bool;
            return this;
        }

        public Builder holiday_mode_mtime(Integer num) {
            this.holiday_mode_mtime = num;
            return this;
        }

        public Builder addr_info(UserAddressInfo userAddressInfo) {
            this.addr_info = userAddressInfo;
            return this;
        }

        public Builder hide_from_contact(Boolean bool) {
            this.hide_from_contact = bool;
            return this;
        }

        public Builder payment_password(String str) {
            this.payment_password = str;
            return this;
        }

        public Builder had_paied_escrow(Boolean bool) {
            this.had_paied_escrow = bool;
            return this;
        }

        public Builder ba_check_status(Integer num) {
            this.ba_check_status = num;
            return this;
        }

        public Builder backup_phone(String str) {
            this.backup_phone = str;
            return this;
        }

        public Builder last_change_passwd_time(Integer num) {
            this.last_change_passwd_time = num;
            return this;
        }

        public Builder is_high_limit(Boolean bool) {
            this.is_high_limit = bool;
            return this;
        }

        public Builder already_verified_phone(Boolean bool) {
            this.already_verified_phone = bool;
            return this;
        }

        public Builder receipt_flag(Integer num) {
            this.receipt_flag = num;
            return this;
        }

        public Builder last_change_phone_time(Integer num) {
            this.last_change_phone_time = num;
            return this;
        }

        public Builder dropshipping_info(BuyerDropshippingInfo buyerDropshippingInfo) {
            this.dropshipping_info = buyerDropshippingInfo;
            return this;
        }

        public Builder disable_new_device_login_otp(Boolean bool) {
            this.disable_new_device_login_otp = bool;
            return this;
        }

        public Builder smid_status(Integer num) {
            this.smid_status = num;
            return this;
        }

        public Builder last_change_payment_passwd_time(Integer num) {
            this.last_change_payment_passwd_time = num;
            return this;
        }

        public Builder last_change_bank_account_time(Integer num) {
            this.last_change_bank_account_time = num;
            return this;
        }

        public Builder not_new_user(Boolean bool) {
            this.not_new_user = bool;
            return this;
        }

        public Builder feed_account_info(FeedAccountInfo feedAccountInfo) {
            this.feed_account_info = feedAccountInfo;
            return this;
        }

        public Builder nickname(String str) {
            this.nickname = str;
            return this;
        }

        public Builder lineid(String str) {
            this.lineid = str;
            return this;
        }

        public Builder live_account_info(LiveAccountInfo liveAccountInfo) {
            this.live_account_info = liveAccountInfo;
            return this;
        }

        public Builder tos_accepted_time(Integer num) {
            this.tos_accepted_time = num;
            return this;
        }

        public Builder not_dp_new_user(Boolean bool) {
            this.not_dp_new_user = bool;
            return this;
        }

        public Builder otp_history(Integer num) {
            this.otp_history = num;
            return this;
        }

        public Builder jko_buyer(JkoAccountBuyer jkoAccountBuyer) {
            this.jko_buyer = jkoAccountBuyer;
            return this;
        }

        public Builder jko_seller(JkoAccountSeller jkoAccountSeller) {
            this.jko_seller = jkoAccountSeller;
            return this;
        }

        public Builder last_change_email_time(Integer num) {
            this.last_change_email_time = num;
            return this;
        }

        public Builder last_verify_email_time(Integer num) {
            this.last_verify_email_time = num;
            return this;
        }

        public Builder adult_consent(Integer num) {
            this.adult_consent = num;
            return this;
        }

        public Builder full_name(String str) {
            this.full_name = str;
            return this;
        }

        public Builder tax_id(String str) {
            this.tax_id = str;
            return this;
        }

        public Builder editable_username(Boolean bool) {
            this.editable_username = bool;
            return this;
        }

        public AccountExtInfo build() {
            return new AccountExtInfo(this);
        }
    }
}
