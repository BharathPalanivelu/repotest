package com.shopee.app.data.store;

import android.content.SharedPreferences;
import cn.tongdun.android.shell.settings.Constants;
import com.beetalklib.a.a.b;
import com.facebook.internal.ServerProtocol;
import com.garena.android.gpns.utility.CONSTANT;
import com.google.a.c.a;
import com.salesforce.android.service.common.utilities.logging.ServiceLogger;
import com.shopee.app.application.ar;
import com.shopee.app.data.store.setting.CategoryRecommendationActive;
import com.shopee.app.data.store.setting.ConfigHelper;
import com.shopee.app.data.store.setting.DTSConfig;
import com.shopee.app.data.store.setting.ImageConfig;
import com.shopee.app.data.store.setting.SalesforceConfigs;
import com.shopee.app.data.store.setting.SettingConfig;
import com.shopee.app.data.store.setting.ShopeeCreditConfigs;
import com.shopee.app.data.store.setting.VideoConfig;
import com.shopee.app.data.viewmodel.CoinInfo;
import com.shopee.app.h.a.e;
import com.shopee.app.util.ad;
import com.shopee.app.util.l;
import com.shopee.app.web.WebRegister;
import com.shopee.arcatch.data.common_bean.Country;
import com.shopee.id.R;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class SettingConfigStore extends ay {
    public static final int BARCODE_SCANNER = 2;
    private static final String DEFAULT = "default";
    public static final int DEFAULT_CATEGORY_LEVEL = 2;
    public static final int DEFAULT_DAYS_TO_SHIP = 2;
    public static final int DEFAULT_DAYS_TO_SHIP_PRE_ORDER = 7;
    private static final int DEFAULT_WHOLESALE_MAX_TIER = 5;
    public static final int IMAGE_EDIT = 1;
    public static final int OFFLINE_PAYMENT = 0;
    private static final String REGION_CODE = "ID";
    private static SettingConfigStore instance;
    private b downloadCallback = new e() {
        /* access modifiers changed from: protected */
        public void onJSonObject(JSONObject jSONObject) throws JSONException {
            SettingConfigStore.this.updateSettingConfig((SettingConfig) WebRegister.GSON.a(jSONObject.toString(), new a<SettingConfig>() {
            }.getType()));
            SettingConfigStore.this.setTimestamp(com.garena.android.appkit.tools.a.a.a());
        }
    };
    private c.a.a.a.a forbiddenZoneBtnEnabled;
    public ad<SettingConfig> forbiddenZoneConfig;
    private SettingConfig mCachedConfig = null;
    private c.a.a.a.b previousDismissedTime;
    private c.a.a.a.b previousVersion;
    private ad<SettingConfig> settingConfig;
    private c.a.a.a.b timestamp;
    private c.a.a.a.a upgradeDotDismissed;

    public SettingConfigStore(SharedPreferences sharedPreferences) {
        super(sharedPreferences);
        this.settingConfig = new ad<>(sharedPreferences, "setting_config", ServiceLogger.PLACEHOLDER, new a<SettingConfig>() {
        });
        this.forbiddenZoneConfig = new ad<>(sharedPreferences, "forbidden_config", ServiceLogger.PLACEHOLDER, new a<SettingConfig>() {
        });
        this.timestamp = new c.a.a.a.b(sharedPreferences, "timestamp", 0);
        this.previousVersion = new c.a.a.a.b(sharedPreferences, "previousVersion", 0);
        this.previousDismissedTime = new c.a.a.a.b(sharedPreferences, "previousDismissedTime", 0);
        this.upgradeDotDismissed = new c.a.a.a.a(sharedPreferences, "upgradeDotDismissed", false);
        this.forbiddenZoneBtnEnabled = new c.a.a.a.a(sharedPreferences, "forbiddenZoneBtnEnabled", false);
        checkDownload();
    }

    public static SettingConfigStore getInstance() {
        if (instance == null) {
            instance = new SettingConfigStore(ar.f().getSharedPreferences("setting_config_store", 0));
        }
        return instance;
    }

    public synchronized SettingConfig getConfig() {
        this.mCachedConfig = (SettingConfig) ConfigHelper.configFrom(this.mCachedConfig, this.settingConfig, this.forbiddenZoneConfig);
        return this.mCachedConfig;
    }

    public synchronized void invalidateCache() {
        this.mCachedConfig = (SettingConfig) ConfigHelper.configFrom(null, this.settingConfig, this.forbiddenZoneConfig);
    }

    public void setUpgradeDotDismissed(boolean z) {
        this.upgradeDotDismissed.a(z);
    }

    public void setPreviousDismissedTime() {
        this.previousDismissedTime.a(com.garena.android.appkit.tools.a.a.a());
    }

    public boolean isMoreThanSevenDaysShownRedDot() {
        return com.garena.android.appkit.tools.a.a.a() - this.previousDismissedTime.a() > 604800;
    }

    public boolean getUpgradeDotDismissed() {
        return this.upgradeDotDismissed.a();
    }

    public boolean showUpgrade() {
        return getCurrentOnlineVersion() > 297 && !this.upgradeDotDismissed.a();
    }

    public boolean isUpgradeable() {
        return getCurrentOnlineVersion() > 297;
    }

    private void checkDownload() {
        int a2 = com.garena.android.appkit.tools.a.a.a() - getTimestamp();
        if (a2 > 3600 || a2 < 0) {
            fetchEditConfig();
        }
    }

    public void fetchEditConfig() {
        com.shopee.app.h.a.a.a().a(l.r, "SettingConfigStore", this.downloadCallback);
    }

    /* access modifiers changed from: private */
    public synchronized void updateSettingConfig(SettingConfig settingConfig2) {
        this.settingConfig.a(settingConfig2);
        this.mCachedConfig = null;
    }

    public void setPreviousVersion() {
        this.previousVersion.a(297);
    }

    public int getPreviousVersion() {
        return this.previousVersion.a();
    }

    private int getTimestamp() {
        return this.timestamp.a();
    }

    /* access modifiers changed from: private */
    public void setTimestamp(int i) {
        this.timestamp.a(i);
    }

    public int getMinSupportedVersion() {
        return ((Integer) ConfigHelper.getConfig(getConfig().minVersion, 222)).intValue();
    }

    @Deprecated
    public int getMaxShippingDays() {
        return ((Integer) ConfigHelper.getConfig(getConfig().maxShippingDays, 15)).intValue();
    }

    public int getMaxVariations() {
        return ((Integer) ConfigHelper.getConfig(getConfig().maxVariations, 20)).intValue();
    }

    public int getMaxHashtags() {
        return ((Integer) ConfigHelper.getConfig(getConfig().maxHashTag, 18)).intValue();
    }

    public int getHashtagWarning() {
        return ((Integer) ConfigHelper.getConfig(getConfig().hashTagWarning, 15)).intValue();
    }

    public int getLatestVersionPromptCheckDays() {
        return ((Integer) ConfigHelper.getConfig(getConfig().lastestVersionPromptCheckDays, 7)).intValue();
    }

    public int getCurrentOnlineVersion() {
        return ((Integer) ConfigHelper.getConfig(getConfig().currentVersion, 30)).intValue();
    }

    public String getUpgradeInfo() {
        return (String) ConfigHelper.getConfig(getConfig().upgradeInfo, com.garena.android.appkit.tools.b.e(R.string.sp_update_app_popup));
    }

    public String getPriceMin() {
        return (String) ConfigHelper.getConfig(getConfig().priceMin, "100");
    }

    public String getPriceMax() {
        return (String) ConfigHelper.getConfig(getConfig().priceMax, "-1");
    }

    public String getUpdateTitle() {
        return (String) ConfigHelper.getConfig(getConfig().upgradeTitle, com.garena.android.appkit.tools.b.e(R.string.sp_label_update_shopee));
    }

    public String getCategoriesPath() {
        return (String) ConfigHelper.getConfig(getConfig().categoriesPath, "/portal/category");
    }

    public boolean isShowFullAddress() {
        return ((Boolean) ConfigHelper.getConfig(getConfig().showFullAddress, false)).booleanValue();
    }

    public boolean getFbSilentPost() {
        return ((Boolean) ConfigHelper.getConfig(getConfig().fbBackgroundSharingOn, true)).booleanValue();
    }

    public boolean getChangePaymentOption() {
        return ((Boolean) ConfigHelper.getConfig(getConfig().changePaymentMethod, false)).booleanValue();
    }

    public boolean getConfig(int i) {
        HashMap<String, Boolean> hashMap;
        if (i == 0) {
            hashMap = getConfig().offlinePaymentDefaultOn;
        } else if (i != 1) {
            hashMap = i != 2 ? null : getConfig().barcodeScanner;
        } else {
            hashMap = getConfig().imageEditingOn;
        }
        if (hashMap == null) {
            return true;
        }
        if (hashMap.containsKey("ID")) {
            return hashMap.get("ID").booleanValue();
        }
        if (hashMap.containsKey(DEFAULT)) {
            return hashMap.get(DEFAULT).booleanValue();
        }
        return true;
    }

    public boolean getCancelOrder() {
        return ((Boolean) ConfigHelper.getConfig(getConfig().cancelOrder, false)).booleanValue();
    }

    public boolean getExtendShipping() {
        return ((Boolean) ConfigHelper.getConfig(getConfig().extendShipping, true)).booleanValue();
    }

    public boolean getOrderReceive() {
        return ((Boolean) ConfigHelper.getConfig(getConfig().orderReceive, true)).booleanValue();
    }

    public boolean getRequestReturn() {
        return ((Boolean) ConfigHelper.getConfig(getConfig().requestReturn, true)).booleanValue();
    }

    public boolean getAllowLogistics() {
        return ((Boolean) ConfigHelper.getConfig(getConfig().allowLogistics, true)).booleanValue();
    }

    public boolean getReviseShippingFee() {
        return ((Boolean) ConfigHelper.getConfig(getConfig().reviseShippingFee, false)).booleanValue();
    }

    public boolean getChangeLogistics() {
        return ((Boolean) ConfigHelper.getConfig(getConfig().changeLogistics, false)).booleanValue();
    }

    public boolean getShowShareFbPage() {
        return ((Boolean) ConfigHelper.getConfig(getConfig().showShareFbPage, true)).booleanValue();
    }

    public boolean showEReceipt() {
        return ((Boolean) ConfigHelper.getConfig(getConfig().showEReceipt, false)).booleanValue();
    }

    public boolean getPrefillPrice() {
        return ((Boolean) ConfigHelper.getConfig(getConfig().prefillPrice, true)).booleanValue();
    }

    public boolean showTheme() {
        return com.garena.android.appkit.tools.a.a.a() > getThemeStartTime() && com.garena.android.appkit.tools.a.a.a() < getThemeEndTime();
    }

    private int getThemeEndTime() {
        return ((Integer) ConfigHelper.getConfig(getConfig().themEndTime, 1457020800)).intValue();
    }

    public String getThemeOneImage() {
        return (String) ConfigHelper.getConfig(getConfig().themeImageOne, "");
    }

    public String getThemeTwoImage() {
        return (String) ConfigHelper.getConfig(getConfig().themeImageTwo, "");
    }

    public int getInactiveCeilingDays() {
        return ((Integer) ConfigHelper.getConfig(getConfig().inactiveCeilingDays, 30)).intValue();
    }

    public String getPaymentConfirmTimeStr() {
        return getPaymentConfirmTimeStr(getPaymentConfirmTime());
    }

    /* access modifiers changed from: protected */
    public String getPaymentConfirmTimeStr(int i) {
        String str;
        int i2 = i / 60;
        if (i2 <= 0) {
            return com.garena.android.appkit.tools.b.e(R.string.sp_pay_48hrs);
        }
        int i3 = i2 / 60;
        if (i3 < 1) {
            return com.garena.android.appkit.tools.b.a(R.string.sp_payment_confirm_time, com.garena.android.appkit.tools.b.a(R.string.sp_x_minutes, Integer.valueOf(i2)));
        }
        int i4 = i3 / 24;
        if (i4 < 3) {
            str = com.garena.android.appkit.tools.b.a(R.string.sp_x_hours, Integer.valueOf(i3));
        } else {
            str = com.garena.android.appkit.tools.b.a(R.string.sp_x_working_days, Integer.valueOf(i4));
        }
        return com.garena.android.appkit.tools.b.a(R.string.sp_payment_confirm_time, str);
    }

    private int getPaymentConfirmTime() {
        return ((Integer) ConfigHelper.getConfig(getConfig().paymentConfirmTime, 86400)).intValue();
    }

    private int getThemeStartTime() {
        return ((Integer) ConfigHelper.getConfig(getConfig().themStartTime, 1451836800)).intValue();
    }

    public boolean getPostAddItemListenToServer() {
        return ((Boolean) ConfigHelper.getConfig(getConfig().postAddItemListenToServer, false)).booleanValue();
    }

    public VideoConfig getVideoConfig() {
        return (VideoConfig) ConfigHelper.getConfig(getConfig().videoConfig, VideoConfig.videoConfig);
    }

    public ImageConfig getProductImageConfig() {
        return (ImageConfig) ConfigHelper.getConfig(getConfig().productImageConfig, ImageConfig.productImageConfig);
    }

    public ImageConfig getImageSearchConfig() {
        return (ImageConfig) ConfigHelper.getConfig(getConfig().imageSearchConfig, ImageConfig.imageSearchConfig);
    }

    public ImageConfig getAvatarImageConfig() {
        return (ImageConfig) ConfigHelper.getConfig(getConfig().avatarConfig, ImageConfig.avatarImageConfig);
    }

    public ImageConfig getChatImageConfig() {
        return (ImageConfig) ConfigHelper.getConfig(getConfig().chatImageConfig, ImageConfig.chatImageConfig);
    }

    public ImageConfig getSharingImageConfig() {
        return (ImageConfig) ConfigHelper.getConfig(getConfig().sharingImageConfig, ImageConfig.chatImageConfig);
    }

    public ImageConfig getShopBannerImageConfig() {
        return (ImageConfig) ConfigHelper.getConfig(getConfig().shopBannerConfig, ImageConfig.shopBannerImageConfig);
    }

    public ImageConfig getCoverImageConfig() {
        return (ImageConfig) ConfigHelper.getConfig(getConfig().shopCoverConfig, ImageConfig.coverImageConfig);
    }

    public boolean getAllowBeetalkLogin() {
        return ((Boolean) ConfigHelper.getConfig(getConfig().allowBeetalkLogin, false)).booleanValue();
    }

    public boolean getAllowMyIncome() {
        return ((Boolean) ConfigHelper.getConfig(getConfig().allowMyIncome, true)).booleanValue();
    }

    public boolean getAllowGCM() {
        return ((Boolean) ConfigHelper.getConfig(getConfig().allowGCM1, true)).booleanValue();
    }

    public boolean isAggressiveCacheAllowed() {
        return ((Boolean) ConfigHelper.getConfig(getConfig().aggressiveCache2, true)).booleanValue();
    }

    public boolean isAllowShippingDays() {
        return ((Boolean) ConfigHelper.getConfig(getConfig().allowShippingDays, true)).booleanValue();
    }

    public boolean isHidingFeedback() {
        return ((Boolean) ConfigHelper.getConfig(getConfig().hideFeedback, false)).booleanValue();
    }

    public int getCodArrangePickUpDelayInSecondsDelay() {
        return ((Integer) ConfigHelper.getConfig(getConfig().codArrangePickUpDelayInSeconds, 0)).intValue();
    }

    public boolean youtubePlayerEnabled() {
        return ((Boolean) ConfigHelper.getConfig(getConfig().enableYoutubePlayer, true)).booleanValue();
    }

    public boolean buyerRatingEnabled() {
        return ((Boolean) ConfigHelper.getConfig(getConfig().buyerRatingEnabled, true)).booleanValue();
    }

    public boolean searchRecipientEnabled() {
        return ((Boolean) ConfigHelper.getConfig(getConfig().searchRecipientEnabled, true)).booleanValue();
    }

    public boolean coinEnabled() {
        return ((Boolean) ConfigHelper.getConfig(getConfig().coinEnabled, true)).booleanValue();
    }

    public boolean coinAnimationEnabled() {
        return ((Boolean) ConfigHelper.getConfig(getConfig().coinAnimationEnabled2, true)).booleanValue();
    }

    public boolean biEnabled() {
        return ((Boolean) ConfigHelper.getConfig(getConfig().biEnabled2, true)).booleanValue();
    }

    public boolean vacationModeEnabled() {
        return ((Boolean) ConfigHelper.getConfig(getConfig().vacationModeEnabled, true)).booleanValue();
    }

    public boolean videoEnabled() {
        return ((Boolean) ConfigHelper.getConfig(getConfig().videoEnabled, true)).booleanValue();
    }

    public boolean allowSelfArrange() {
        return ((Boolean) ConfigHelper.getConfig(getConfig().allowSelfArrange, false)).booleanValue();
    }

    public boolean myPerformanceEntryVisible() {
        return ((Boolean) ConfigHelper.getConfig(getConfig().myPerformanceEntryVisible, true)).booleanValue();
    }

    public boolean sslEnabled() {
        return ((Boolean) ConfigHelper.getConfig(getConfig().sslEnabled, true)).booleanValue();
    }

    public boolean allowBACheck() {
        return ((Boolean) ConfigHelper.getConfig(getConfig().allowBACheck, false)).booleanValue();
    }

    public boolean showFirstMessageScam() {
        return ((Boolean) ConfigHelper.getConfig(getConfig().showFirstMessageScam, false)).booleanValue();
    }

    public boolean policeScamUpdateEnabled() {
        return ((Boolean) ConfigHelper.getConfig(getConfig().policeScamUpdateEnabled, true)).booleanValue();
    }

    public int getRequestTimeout() {
        return ((Integer) ConfigHelper.getConfig(getConfig().requestTimeout, 15000)).intValue();
    }

    public int getProductDesMinlen() {
        return ((Integer) ConfigHelper.getConfig(getConfig().productDesMinlen, 20)).intValue();
    }

    public int getProductDesMallMinlen() {
        return ((Integer) ConfigHelper.getConfig(getConfig().productDesMallMinlen, 25)).intValue();
    }

    public int getMallImageMinWidth() {
        return ((Integer) ConfigHelper.getConfig(getConfig().mallImageMinWidth, 500)).intValue();
    }

    public int getMallImageMinHeight() {
        return ((Integer) ConfigHelper.getConfig(getConfig().mallImageMinHeight, 500)).intValue();
    }

    public int getMallMinImageCount() {
        return ((Integer) ConfigHelper.getConfig(getConfig().mallMinImageCount, 1)).intValue();
    }

    public int productTitleMaxlen() {
        return ((Integer) ConfigHelper.getConfig(getConfig().productTitleMaxlen, 100)).intValue();
    }

    public boolean showProductWeight() {
        return ((Boolean) ConfigHelper.getConfig(getConfig().showProductWeight, true)).booleanValue();
    }

    public boolean isProductWeightOptional() {
        return ((Boolean) ConfigHelper.getConfig(getConfig().isProductWeightOptional, false)).booleanValue();
    }

    public boolean shopSettingRN() {
        return ((Boolean) ConfigHelper.getConfig(getConfig().shopSettingRN, true)).booleanValue();
    }

    public int rnProductDetailPercent() {
        return ((Integer) ConfigHelper.getConfig(getConfig().rnProductDetailPercent, 0)).intValue();
    }

    public int bundleSyncPeriod() {
        return ((Integer) ConfigHelper.getConfig(getConfig().bundleSyncPeriod, 30)).intValue();
    }

    public int bundleSyncPeriodBelowAndroidM() {
        return ((Integer) ConfigHelper.getConfig(getConfig().bundleSyncPeriodBelowAndroidM, 360)).intValue();
    }

    public boolean permissionPopupEnabled() {
        return ((Boolean) ConfigHelper.getConfig(getConfig().permissionPopupEnabled, true)).booleanValue();
    }

    public int wholesaleMaxTier() {
        return ((Integer) ConfigHelper.getConfig(getConfig().wholesaleMaxTier, 5)).intValue();
    }

    public boolean wholesaleEnabled() {
        return ((Boolean) ConfigHelper.getConfig(getConfig().wholesaleEnabled, true)).booleanValue();
    }

    @Deprecated
    public int getDefaultDayToShip() {
        return ((Integer) ConfigHelper.getConfig(getConfig().defaultDaysToShip, 2)).intValue();
    }

    @Deprecated
    public int getDefaultDayToShipPreOrder() {
        return ((Integer) ConfigHelper.getConfig(getConfig().defaultDaysToShipPreOrder, 7)).intValue();
    }

    public int getCategoryLevel() {
        return ((Integer) ConfigHelper.getConfig(getConfig().categoryLevel, 2)).intValue();
    }

    public boolean getMySaleNewStringsEnabled() {
        return ((Boolean) ConfigHelper.getConfig(getConfig().mySaleNewStringsEnabled, false)).booleanValue();
    }

    public boolean categoryRecommendationEnabled() {
        return ((Boolean) ConfigHelper.getConfig(getConfig().categoryRecommendationEnabled, false)).booleanValue();
    }

    public boolean isProductDimension() {
        return ((Boolean) ConfigHelper.getConfig(getConfig().productDimension, true)).booleanValue();
    }

    public boolean showToShipFilters() {
        return ((Boolean) ConfigHelper.getConfig(getConfig().showToShipFilters, true)).booleanValue();
    }

    public int getCancellationDueDateOffSet() {
        return ((Integer) ConfigHelper.getConfig(getConfig().cancellationDueDateOffSet, 1)).intValue();
    }

    public int pickUpStartDateOffSet() {
        return ((Integer) ConfigHelper.getConfig(getConfig().pickUpStartDateOffset, 2)).intValue();
    }

    public boolean isDataPointOn(int i) {
        return allowedForUser(i, ((Integer) ConfigHelper.getConfig(getConfig().dataPointOn2, 100)).intValue());
    }

    public int dataPointPeriod() {
        return ((Integer) ConfigHelper.getConfig(getConfig().dataPointPeriod2, 120)).intValue();
    }

    public boolean isShowMallTab() {
        return ((Boolean) ConfigHelper.getConfig(getConfig().showMallTab, Boolean.valueOf(Arrays.asList(new String[]{Country.COUNTRY_TW, Country.COUNTRY_SG, Country.COUNTRY_VN, Country.COUNTRY_MY, "ID"}).contains("ID")))).booleanValue();
    }

    public boolean isMallTabRN(int i) {
        return allowedForUser(i, ((Integer) ConfigHelper.getConfig(getConfig().isMallTabRN, 100)).intValue());
    }

    public boolean isHomeTabRN(int i) {
        return allowedForUser(i, ((Integer) ConfigHelper.getConfig(getConfig().isHomeTabRN2, 100)).intValue());
    }

    public long mallRNVersion() {
        return ((Long) ConfigHelper.getConfig(getConfig().mallRNVersion, 1515056889L)).longValue();
    }

    public long homeRNVersion() {
        return ((Long) ConfigHelper.getConfig(getConfig().homeRNVersion, 1519800043L)).longValue();
    }

    public int reportResponseTimePercent() {
        return ((Integer) ConfigHelper.getConfig(getConfig().reportResponseTimePercent, 10)).intValue();
    }

    public CoinInfo coinMultiplier() {
        return new CoinInfo((String) ConfigHelper.getConfig(getConfig().coinMultiplierString, "1"));
    }

    public boolean hideOrderReceived() {
        return ((Boolean) ConfigHelper.getConfig(getConfig().hideOrderReceived, false)).booleanValue();
    }

    public boolean hideReturnRefundText() {
        return ((Boolean) ConfigHelper.getConfig(getConfig().hideReturnRefundText, false)).booleanValue();
    }

    public int productDesMaxLen() {
        return ((Integer) ConfigHelper.getConfig(getConfig().productDesMaxLen, Integer.valueOf(Constants.DEFAULT_WAIT_TIME))).intValue();
    }

    public int deliveryDoneDateOffset() {
        return ((Integer) ConfigHelper.getConfig(getConfig().deliveryDoneDateOffset, 2)).intValue();
    }

    public int chatShortcutCount() {
        return ((Integer) ConfigHelper.getConfig(getConfig().chatShortcutCount, 5)).intValue();
    }

    public int returnRefundDueDateOffset() {
        return ((Integer) ConfigHelper.getConfig(getConfig().returnRefundDueDateOffset, 2)).intValue();
    }

    public boolean showMallTabAnimationInAppStart() {
        return !ServerProtocol.DIALOG_RETURN_SCOPES_TRUE.equals(com.garena.android.appkit.tools.b.e(R.string.special_mall_icon_enabled)) && showMallTabTooltip();
    }

    public boolean showMallTabTooltip() {
        return ((Boolean) ConfigHelper.getConfig(getConfig().showMallTabAnimationInAppStart, true)).booleanValue();
    }

    public String getMallTooltipText() {
        return (String) ConfigHelper.getConfig(getConfig().mallTooltipText, com.garena.android.appkit.tools.b.e(R.string.sp_message_mall_tooltip_main));
    }

    public boolean isBundleEnabled() {
        return ((Boolean) ConfigHelper.getConfig(getConfig().isBundleEnabled, false)).booleanValue();
    }

    public boolean isSplitBundleOn(int i) {
        return allowedForUser(i, ((Integer) ConfigHelper.getConfig(getConfig().splitBundleOn2, 0)).intValue());
    }

    public boolean isCategoryRecommendationActive(boolean z) {
        CategoryRecommendationActive categoryRecommendationActive = (CategoryRecommendationActive) ConfigHelper.getConfig(getConfig().categoryRecommendationActive, CategoryRecommendationActive.DEFAULT);
        if (!categoryRecommendationActive.category_recommendation_active) {
            return false;
        }
        if (z) {
            return categoryRecommendationActive.preferred_seller;
        }
        return categoryRecommendationActive.non_preferred_seller;
    }

    public boolean eMoneyEnabled() {
        return ((Boolean) ConfigHelper.getConfig(getConfig().eMoneyEnabled, false)).booleanValue();
    }

    public int selfKillInterval() {
        return ((Integer) ConfigHelper.getConfig(getConfig().selfKillInterval, 3600)).intValue();
    }

    public boolean hidePhonePublicOption() {
        return ((Boolean) ConfigHelper.getConfig(getConfig().hidePhonePublicOption, true)).booleanValue();
    }

    public boolean showMePageReferral() {
        return ((Boolean) ConfigHelper.getConfig(getConfig().showMePageReferral, true)).booleanValue();
    }

    public boolean showMePageGroupBuy() {
        return ((Boolean) ConfigHelper.getConfig(getConfig().showMePageGroupBuy, true)).booleanValue();
    }

    public int delayOrderReceivedButtonHour() {
        return ((Integer) ConfigHelper.getConfig(getConfig().delayOrderReceivedButtonHour, 4)).intValue();
    }

    private boolean allowedForUser(int i, int i2) {
        if (i2 >= 100) {
            return true;
        }
        return i > 0 && i % 100 < i2;
    }

    public List<Integer> hideStockInMakeOfferShopIds() {
        return (List) ConfigHelper.getConfig(getConfig().hideStockInMakeOfferShopIds, null);
    }

    public boolean isHideStock(int i) {
        List<Integer> hideStockInMakeOfferShopIds = hideStockInMakeOfferShopIds();
        return hideStockInMakeOfferShopIds != null && hideStockInMakeOfferShopIds.contains(Integer.valueOf(i));
    }

    public boolean b2cReturnEnabled() {
        return ((Boolean) ConfigHelper.getConfig(getConfig().b2cReturnEnabled, true)).booleanValue();
    }

    public boolean c2cReturnEnabled() {
        return ((Boolean) ConfigHelper.getConfig(getConfig().c2cReturnEnabled, true)).booleanValue();
    }

    public boolean c2cReturnOfficialEnabled() {
        return ((Boolean) ConfigHelper.getConfig(getConfig().c2cReturnOfficialEnabled, false)).booleanValue();
    }

    public boolean c2cReverseLogistics711Enabled() {
        return ((Boolean) ConfigHelper.getConfig(getConfig().c2cReverseLogistics711Enabled, false)).booleanValue();
    }

    public boolean nonIntegratedMallReturnEnabled() {
        return ((Boolean) ConfigHelper.getConfig(getConfig().nonIntegratedMallReturnEnabled, false)).booleanValue();
    }

    public boolean enableStackManager() {
        return ((Boolean) ConfigHelper.getConfig(getConfig().enableStackManager, true)).booleanValue();
    }

    public int imageSearchPhotoLibRatio() {
        return ((Integer) ConfigHelper.getConfig(getConfig().imageSearchPhotoLibRatio, 2)).intValue();
    }

    public int imageSearchPhotoLibMinSize() {
        return ((Integer) ConfigHelper.getConfig(getConfig().imageSearchPhotoLibMinSize, 5)).intValue();
    }

    public String getMobileNumberChangedHelpUrl() {
        return (String) ConfigHelper.getConfig(getConfig().mobileNumberChangedHelpUrl, "");
    }

    public SalesforceConfigs getSalesforceConfigs() {
        return (SalesforceConfigs) ConfigHelper.getConfig(getConfig().salesforceChatConfigs, null);
    }

    public boolean certPinningEnabled() {
        return ((Boolean) ConfigHelper.getConfig(getConfig().certPinningEnabled, false)).booleanValue();
    }

    public int locationDialogDismissIntervalMillis() {
        return ((Integer) ConfigHelper.getConfig(getConfig().locationDialogDismissIntervalMillis, Integer.valueOf(CONSTANT.TIME.MIN_1))).intValue();
    }

    public boolean isTrackerStoEnabled() {
        return ((Boolean) ConfigHelper.getConfig(getConfig().trackerSTO, false)).booleanValue();
    }

    public ShopeeCreditConfigs getShopeeCreditConfigs() {
        return (ShopeeCreditConfigs) ConfigHelper.getConfig(getConfig().shopeeCreditConfigs, new ShopeeCreditConfigs());
    }

    public DTSConfig.DTSData getDTSConfig(boolean z, boolean z2) {
        DTSConfig dTSConfig = (DTSConfig) ConfigHelper.getConfig(getConfig().itemDTSConfig, DTSConfig.DEFAULT());
        if (z) {
            if (z2) {
                return dTSConfig.cb_pre_order;
            }
            return dTSConfig.cb_order;
        } else if (z2) {
            return dTSConfig.pre_order;
        } else {
            return dTSConfig.order;
        }
    }

    public boolean isForbiddenZoneBtnEnabled() {
        return this.forbiddenZoneBtnEnabled.a();
    }

    public void setForbiddenZoneBtnEnabled(boolean z) {
        this.forbiddenZoneBtnEnabled.a(z);
    }

    public int getProfileNickNameMaxLength() {
        return ((Integer) ConfigHelper.getConfig(getConfig().profileNickNameMaxLength, 100)).intValue();
    }
}
