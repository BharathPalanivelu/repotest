package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class AccountAccessConfig extends Message {
    public static final Boolean DEFAULT_AUTO_TRANSLATION_ENABLED = false;
    public static final Integer DEFAULT_GROUP_BUY_SETTING = 0;
    public static final Boolean DEFAULT_HAS_LEGACY_WALLET = false;
    public static final Integer DEFAULT_HIDE_LIKES = 0;
    public static final List<Integer> DEFAULT_PILOT_TEST_FEATURES = Collections.emptyList();
    public static final Integer DEFAULT_SELLER_ADS_SETTING = 0;
    public static final Integer DEFAULT_SELLER_COIN_SETTING = 0;
    public static final Boolean DEFAULT_SELLER_UNLIMITED_REPLY = false;
    public static final Integer DEFAULT_SELLER_WHOLESALE_SETTING = 0;
    public static final Boolean DEFAULT_SHOPEE_CREDIT_SETTING = false;
    public static final Boolean DEFAULT_SHOW_IMAGESEARCH = false;
    public static final Integer DEFAULT_SLASH_PRICE_SETTING = 0;
    public static final Integer DEFAULT_VOUCHER_WALLET_SETTING = 0;
    public static final Integer DEFAULT_WALLET_PROVIDER = 0;
    public static final Integer DEFAULT_WALLET_SETTING = 0;
    public static final Boolean DEFAULT_WELCOME_PACKAGE_SETTING = false;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 15, type = Message.Datatype.BOOL)
    public final Boolean auto_translation_enabled;
    @ProtoField(tag = 7, type = Message.Datatype.INT32)
    public final Integer group_buy_setting;
    @ProtoField(tag = 14, type = Message.Datatype.BOOL)
    public final Boolean has_legacy_wallet;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer hide_likes;
    @ProtoField(label = Message.Label.REPEATED, tag = 12, type = Message.Datatype.INT32)
    public final List<Integer> pilot_test_features;
    @ProtoField(tag = 5, type = Message.Datatype.INT32)
    public final Integer seller_ads_setting;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer seller_coin_setting;
    @ProtoField(tag = 8, type = Message.Datatype.BOOL)
    public final Boolean seller_unlimited_reply;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer seller_wholesale_setting;
    @ProtoField(tag = 11, type = Message.Datatype.BOOL)
    public final Boolean shopee_credit_setting;
    @ProtoField(tag = 9, type = Message.Datatype.BOOL)
    public final Boolean show_imagesearch;
    @ProtoField(tag = 16, type = Message.Datatype.INT32)
    public final Integer slash_price_setting;
    @ProtoField(tag = 6, type = Message.Datatype.INT32)
    public final Integer voucher_wallet_setting;
    @ProtoField(tag = 13, type = Message.Datatype.INT32)
    public final Integer wallet_provider;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer wallet_setting;
    @ProtoField(tag = 10, type = Message.Datatype.BOOL)
    public final Boolean welcome_package_setting;

    public AccountAccessConfig(Integer num, Integer num2, Integer num3, Integer num4, Integer num5, Integer num6, Integer num7, Boolean bool, Boolean bool2, Boolean bool3, Boolean bool4, List<Integer> list, Integer num8, Boolean bool5, Boolean bool6, Integer num9) {
        this.hide_likes = num;
        this.wallet_setting = num2;
        this.seller_coin_setting = num3;
        this.seller_wholesale_setting = num4;
        this.seller_ads_setting = num5;
        this.voucher_wallet_setting = num6;
        this.group_buy_setting = num7;
        this.seller_unlimited_reply = bool;
        this.show_imagesearch = bool2;
        this.welcome_package_setting = bool3;
        this.shopee_credit_setting = bool4;
        this.pilot_test_features = immutableCopyOf(list);
        this.wallet_provider = num8;
        this.has_legacy_wallet = bool5;
        this.auto_translation_enabled = bool6;
        this.slash_price_setting = num9;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private AccountAccessConfig(com.shopee.protocol.shop.AccountAccessConfig.Builder r20) {
        /*
            r19 = this;
            r0 = r20
            r1 = r19
            java.lang.Integer r2 = r0.hide_likes
            java.lang.Integer r3 = r0.wallet_setting
            java.lang.Integer r4 = r0.seller_coin_setting
            java.lang.Integer r5 = r0.seller_wholesale_setting
            java.lang.Integer r6 = r0.seller_ads_setting
            java.lang.Integer r7 = r0.voucher_wallet_setting
            java.lang.Integer r8 = r0.group_buy_setting
            java.lang.Boolean r9 = r0.seller_unlimited_reply
            java.lang.Boolean r10 = r0.show_imagesearch
            java.lang.Boolean r11 = r0.welcome_package_setting
            java.lang.Boolean r12 = r0.shopee_credit_setting
            java.util.List<java.lang.Integer> r13 = r0.pilot_test_features
            java.lang.Integer r14 = r0.wallet_provider
            java.lang.Boolean r15 = r0.has_legacy_wallet
            r18 = r1
            java.lang.Boolean r1 = r0.auto_translation_enabled
            r16 = r1
            java.lang.Integer r1 = r0.slash_price_setting
            r17 = r1
            r1 = r18
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17)
            r19.setBuilder(r20)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shopee.protocol.shop.AccountAccessConfig.<init>(com.shopee.protocol.shop.AccountAccessConfig$Builder):void");
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AccountAccessConfig)) {
            return false;
        }
        AccountAccessConfig accountAccessConfig = (AccountAccessConfig) obj;
        if (!equals((Object) this.hide_likes, (Object) accountAccessConfig.hide_likes) || !equals((Object) this.wallet_setting, (Object) accountAccessConfig.wallet_setting) || !equals((Object) this.seller_coin_setting, (Object) accountAccessConfig.seller_coin_setting) || !equals((Object) this.seller_wholesale_setting, (Object) accountAccessConfig.seller_wholesale_setting) || !equals((Object) this.seller_ads_setting, (Object) accountAccessConfig.seller_ads_setting) || !equals((Object) this.voucher_wallet_setting, (Object) accountAccessConfig.voucher_wallet_setting) || !equals((Object) this.group_buy_setting, (Object) accountAccessConfig.group_buy_setting) || !equals((Object) this.seller_unlimited_reply, (Object) accountAccessConfig.seller_unlimited_reply) || !equals((Object) this.show_imagesearch, (Object) accountAccessConfig.show_imagesearch) || !equals((Object) this.welcome_package_setting, (Object) accountAccessConfig.welcome_package_setting) || !equals((Object) this.shopee_credit_setting, (Object) accountAccessConfig.shopee_credit_setting) || !equals((List<?>) this.pilot_test_features, (List<?>) accountAccessConfig.pilot_test_features) || !equals((Object) this.wallet_provider, (Object) accountAccessConfig.wallet_provider) || !equals((Object) this.has_legacy_wallet, (Object) accountAccessConfig.has_legacy_wallet) || !equals((Object) this.auto_translation_enabled, (Object) accountAccessConfig.auto_translation_enabled) || !equals((Object) this.slash_price_setting, (Object) accountAccessConfig.slash_price_setting)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Integer num = this.hide_likes;
        int i2 = 0;
        int hashCode = (num != null ? num.hashCode() : 0) * 37;
        Integer num2 = this.wallet_setting;
        int hashCode2 = (hashCode + (num2 != null ? num2.hashCode() : 0)) * 37;
        Integer num3 = this.seller_coin_setting;
        int hashCode3 = (hashCode2 + (num3 != null ? num3.hashCode() : 0)) * 37;
        Integer num4 = this.seller_wholesale_setting;
        int hashCode4 = (hashCode3 + (num4 != null ? num4.hashCode() : 0)) * 37;
        Integer num5 = this.seller_ads_setting;
        int hashCode5 = (hashCode4 + (num5 != null ? num5.hashCode() : 0)) * 37;
        Integer num6 = this.voucher_wallet_setting;
        int hashCode6 = (hashCode5 + (num6 != null ? num6.hashCode() : 0)) * 37;
        Integer num7 = this.group_buy_setting;
        int hashCode7 = (hashCode6 + (num7 != null ? num7.hashCode() : 0)) * 37;
        Boolean bool = this.seller_unlimited_reply;
        int hashCode8 = (hashCode7 + (bool != null ? bool.hashCode() : 0)) * 37;
        Boolean bool2 = this.show_imagesearch;
        int hashCode9 = (hashCode8 + (bool2 != null ? bool2.hashCode() : 0)) * 37;
        Boolean bool3 = this.welcome_package_setting;
        int hashCode10 = (hashCode9 + (bool3 != null ? bool3.hashCode() : 0)) * 37;
        Boolean bool4 = this.shopee_credit_setting;
        int hashCode11 = (hashCode10 + (bool4 != null ? bool4.hashCode() : 0)) * 37;
        List<Integer> list = this.pilot_test_features;
        int hashCode12 = (hashCode11 + (list != null ? list.hashCode() : 1)) * 37;
        Integer num8 = this.wallet_provider;
        int hashCode13 = (hashCode12 + (num8 != null ? num8.hashCode() : 0)) * 37;
        Boolean bool5 = this.has_legacy_wallet;
        int hashCode14 = (hashCode13 + (bool5 != null ? bool5.hashCode() : 0)) * 37;
        Boolean bool6 = this.auto_translation_enabled;
        int hashCode15 = (hashCode14 + (bool6 != null ? bool6.hashCode() : 0)) * 37;
        Integer num9 = this.slash_price_setting;
        if (num9 != null) {
            i2 = num9.hashCode();
        }
        int i3 = hashCode15 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<AccountAccessConfig> {
        public Boolean auto_translation_enabled;
        public Integer group_buy_setting;
        public Boolean has_legacy_wallet;
        public Integer hide_likes;
        public List<Integer> pilot_test_features;
        public Integer seller_ads_setting;
        public Integer seller_coin_setting;
        public Boolean seller_unlimited_reply;
        public Integer seller_wholesale_setting;
        public Boolean shopee_credit_setting;
        public Boolean show_imagesearch;
        public Integer slash_price_setting;
        public Integer voucher_wallet_setting;
        public Integer wallet_provider;
        public Integer wallet_setting;
        public Boolean welcome_package_setting;

        public Builder() {
        }

        public Builder(AccountAccessConfig accountAccessConfig) {
            super(accountAccessConfig);
            if (accountAccessConfig != null) {
                this.hide_likes = accountAccessConfig.hide_likes;
                this.wallet_setting = accountAccessConfig.wallet_setting;
                this.seller_coin_setting = accountAccessConfig.seller_coin_setting;
                this.seller_wholesale_setting = accountAccessConfig.seller_wholesale_setting;
                this.seller_ads_setting = accountAccessConfig.seller_ads_setting;
                this.voucher_wallet_setting = accountAccessConfig.voucher_wallet_setting;
                this.group_buy_setting = accountAccessConfig.group_buy_setting;
                this.seller_unlimited_reply = accountAccessConfig.seller_unlimited_reply;
                this.show_imagesearch = accountAccessConfig.show_imagesearch;
                this.welcome_package_setting = accountAccessConfig.welcome_package_setting;
                this.shopee_credit_setting = accountAccessConfig.shopee_credit_setting;
                this.pilot_test_features = AccountAccessConfig.copyOf(accountAccessConfig.pilot_test_features);
                this.wallet_provider = accountAccessConfig.wallet_provider;
                this.has_legacy_wallet = accountAccessConfig.has_legacy_wallet;
                this.auto_translation_enabled = accountAccessConfig.auto_translation_enabled;
                this.slash_price_setting = accountAccessConfig.slash_price_setting;
            }
        }

        public Builder hide_likes(Integer num) {
            this.hide_likes = num;
            return this;
        }

        public Builder wallet_setting(Integer num) {
            this.wallet_setting = num;
            return this;
        }

        public Builder seller_coin_setting(Integer num) {
            this.seller_coin_setting = num;
            return this;
        }

        public Builder seller_wholesale_setting(Integer num) {
            this.seller_wholesale_setting = num;
            return this;
        }

        public Builder seller_ads_setting(Integer num) {
            this.seller_ads_setting = num;
            return this;
        }

        public Builder voucher_wallet_setting(Integer num) {
            this.voucher_wallet_setting = num;
            return this;
        }

        public Builder group_buy_setting(Integer num) {
            this.group_buy_setting = num;
            return this;
        }

        public Builder seller_unlimited_reply(Boolean bool) {
            this.seller_unlimited_reply = bool;
            return this;
        }

        public Builder show_imagesearch(Boolean bool) {
            this.show_imagesearch = bool;
            return this;
        }

        public Builder welcome_package_setting(Boolean bool) {
            this.welcome_package_setting = bool;
            return this;
        }

        public Builder shopee_credit_setting(Boolean bool) {
            this.shopee_credit_setting = bool;
            return this;
        }

        public Builder pilot_test_features(List<Integer> list) {
            this.pilot_test_features = checkForNulls(list);
            return this;
        }

        public Builder wallet_provider(Integer num) {
            this.wallet_provider = num;
            return this;
        }

        public Builder has_legacy_wallet(Boolean bool) {
            this.has_legacy_wallet = bool;
            return this;
        }

        public Builder auto_translation_enabled(Boolean bool) {
            this.auto_translation_enabled = bool;
            return this;
        }

        public Builder slash_price_setting(Integer num) {
            this.slash_price_setting = num;
            return this;
        }

        public AccountAccessConfig build() {
            return new AccountAccessConfig(this);
        }
    }
}
