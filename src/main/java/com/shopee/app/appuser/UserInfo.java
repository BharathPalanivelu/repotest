package com.shopee.app.appuser;

import android.text.TextUtils;
import com.google.a.a.c;
import com.shopee.app.d.b.b;
import com.shopee.protocol.shop.FeedAccountInfo;
import com.shopee.protocol.shop.LiveAccountInfo;
import com.tencent.ijk.media.player.IjkMediaMeta;

public class UserInfo {
    private static final int EMAILNOTI_ALL_MASK = 256;
    private static final int EMAILNOTI_LIST_UPDATES = 1024;
    private static final int EMAILNOTI_NEWS_LETTER = 2048;
    private static final int EMAILNOTI_ORDER_UPDATES = 512;
    private static final int EMAILNOTI_PERSONALISED = 4096;
    private static final int NOTI_ACTION_REQUIRED_MASK = 2;
    private static final int NOTI_ACTIVITY_MASK = 4;
    private static final int NOTI_ALL_MASK = 1;
    private static final int NOTI_CHATS_MASK = 8;
    private static final int NOTI_FEED_COMMENTED = 32768;
    private static final int NOTI_FEED_LIKED = 65536;
    private static final int NOTI_FEED_MENTIONED = 131072;
    private static final int NOTI_PERSONAL_CONTENT = 128;
    private static final int NOTI_RATING = 128;
    private static final int NOTI_SHOPEE_PROMOTION = 64;
    private static final int NOTI_SMART_MASK = 32;
    private static final int NOTI_STOCK_MASK = 16;
    private static final int NOTI_WALLET = 8192;
    @c(a = "q")
    private String VCodeToken;
    private boolean autoTranslationEnabled;
    @c(a = "e")
    private String avatarId = "";
    @c(a = "x")
    private int baCheckStatus;
    private int buyerWalletProvider;
    private boolean canPostFeed;
    @c(a = "a")
    private String country = "ID";
    @c(a = "t")
    private int crossBorderOption;
    @c(a = "i")
    private String email = "";
    @c(a = "p")
    private boolean emailVerified;
    @c(a = "k")
    private String fbToken = "";
    @c(a = "r")
    private boolean hasPassword;
    @c(a = "u")
    private boolean holidayMode;
    @c(a = "v")
    private int holidayModeTime;
    @c(a = "j")
    private boolean isFbLogin;
    private boolean isKOL;
    private boolean isLiveStreamBanned;
    private boolean isLiveStreamHost;
    @c(a = "z")
    private boolean isMall;
    @c(a = "m")
    private boolean isPhonePublic;
    @c(a = "l")
    private boolean isSeller;
    @c(a = "s")
    private int loginMethod;
    private String nickname;
    @c(a = "g")
    private String password = "";
    @c(a = "d")
    private String phone = "";
    @c(a = "o")
    private long pnOption;
    @c(a = "n")
    private String portrait;
    @c(a = "h")
    private int shopId;
    @c(a = "b")
    private String token = "";
    @c(a = "c")
    private int userId;
    @c(a = "f")
    private String username = "";
    @c(a = "w")
    private int walletSetting;
    @c(a = "y")
    private boolean wholesaleEnabled;

    public boolean isLineLogin() {
        return this.loginMethod == 3;
    }

    public boolean isMall() {
        return this.isMall;
    }

    public void setMall(boolean z) {
        this.isMall = z;
    }

    public static boolean isLoggedIn(UserInfo userInfo) {
        return userInfo != null && userInfo.isLoggedIn();
    }

    public boolean isWholesaleEnabled() {
        return this.wholesaleEnabled;
    }

    public void setWholesaleEnabled(boolean z) {
        this.wholesaleEnabled = z;
    }

    public String getCountry() {
        return this.country;
    }

    public void setCountry(String str) {
        this.country = str;
    }

    public String getToken() {
        return this.token;
    }

    public void setToken(String str) {
        this.token = str;
    }

    public int getUserId() {
        return this.userId;
    }

    public void setUserId(int i) {
        this.userId = i;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String str) {
        this.phone = str;
    }

    public boolean hasPhone() {
        return !TextUtils.isEmpty(this.phone);
    }

    public String getAvatarId() {
        return this.avatarId;
    }

    public void setAvatarId(String str) {
        this.avatarId = str;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String str) {
        this.username = str;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String str) {
        this.password = str;
    }

    public void setHasPassword(boolean z) {
        this.hasPassword = z;
    }

    public int getShopId() {
        return this.shopId;
    }

    public void setShopId(int i) {
        this.shopId = i;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String str) {
        this.email = str;
    }

    public boolean hasEmail() {
        return !TextUtils.isEmpty(this.email);
    }

    public boolean isFbLogin() {
        return this.isFbLogin;
    }

    public void setFbLogin(int i) {
        this.isFbLogin = i == 0;
    }

    public String getFbToken() {
        return this.fbToken;
    }

    public void setFbToken(String str) {
        this.fbToken = str;
    }

    public boolean isSeller() {
        return this.isSeller;
    }

    public void setSeller(boolean z) {
        this.isSeller = z;
    }

    public boolean isLoggedIn() {
        return this.userId != 0 && !TextUtils.isEmpty(this.token);
    }

    public boolean isMyShop(int i) {
        return this.shopId == i;
    }

    public boolean isPhonePublic() {
        return this.isPhonePublic;
    }

    public void setPhonePublic(boolean z) {
        this.isPhonePublic = z;
    }

    public boolean isAllNotiOn() {
        return (this.pnOption & 1) != 0;
    }

    public boolean isAllEmailNotiOn() {
        return (this.pnOption & 256) != 0;
    }

    public boolean isEmailOrderOn() {
        return (this.pnOption & 512) != 0;
    }

    public boolean isEmailListOn() {
        return (this.pnOption & IjkMediaMeta.AV_CH_SIDE_RIGHT) != 0;
    }

    public boolean isEmailNewsOn() {
        return (this.pnOption & IjkMediaMeta.AV_CH_TOP_CENTER) != 0;
    }

    public boolean isEmailPersonalizeOn() {
        return (this.pnOption & IjkMediaMeta.AV_CH_TOP_FRONT_LEFT) != 0;
    }

    public boolean isActionRequiredNotiOn() {
        return (this.pnOption & 2) != 0;
    }

    public boolean isChatNotiOn() {
        return (this.pnOption & 8) != 0;
    }

    public boolean isActivityNotiOn() {
        return (this.pnOption & 4) != 0;
    }

    public boolean isOOSNotiOn() {
        return (this.pnOption & 16) != 0;
    }

    public boolean isNotiRatingOn() {
        return (this.pnOption & 128) != 0;
    }

    public boolean isShopeePromotionNotiOn() {
        return (this.pnOption & 64) != 0;
    }

    public boolean isPersonalContentNotiOn() {
        return (this.pnOption & 128) != 0;
    }

    public boolean isSmartNotiOn() {
        return (this.pnOption & 32) == 0;
    }

    public boolean isWalletNotiOn() {
        return (this.pnOption & IjkMediaMeta.AV_CH_TOP_FRONT_CENTER) != 0;
    }

    public boolean isFeedCommentNotiOn() {
        return (this.pnOption & IjkMediaMeta.AV_CH_TOP_BACK_LEFT) != 0;
    }

    public boolean isFeedLikedNotiOn() {
        return (this.pnOption & IjkMediaMeta.AV_CH_TOP_BACK_CENTER) != 0;
    }

    public boolean isFeedMentionedNotiOn() {
        return (this.pnOption & IjkMediaMeta.AV_CH_TOP_BACK_RIGHT) != 0;
    }

    public long getPnOption() {
        return this.pnOption;
    }

    public void setPnOption(long j) {
        this.pnOption = j;
    }

    public String getPortrait() {
        return this.portrait;
    }

    public void setPortrait(String str) {
        this.portrait = str;
    }

    public void toggleAllowAllNoti(boolean z) {
        if (z) {
            this.pnOption |= 1;
        } else {
            this.pnOption &= -2;
        }
    }

    public void setEmailAllNoti(boolean z) {
        if (z) {
            this.pnOption |= 256;
        } else {
            this.pnOption &= -257;
        }
    }

    public void setActionRequiredNotiOn(boolean z) {
        if (z) {
            this.pnOption |= 2;
        } else {
            this.pnOption &= -3;
        }
    }

    public void setChatsNotiOn(boolean z) {
        if (z) {
            this.pnOption |= 8;
        } else {
            this.pnOption &= -9;
        }
    }

    public void setActivityNotiOn(boolean z) {
        if (z) {
            this.pnOption |= 4;
        } else {
            this.pnOption &= -5;
        }
    }

    public void setOOSNotiOn(boolean z) {
        if (z) {
            this.pnOption |= 16;
        } else {
            this.pnOption &= -17;
        }
    }

    public void setSmartNotiOn(boolean z) {
        if (z) {
            this.pnOption &= -33;
        } else {
            this.pnOption |= 32;
        }
    }

    public void setNotiShopeePromotionOn(boolean z) {
        if (z) {
            this.pnOption |= 64;
        } else {
            this.pnOption &= -65;
        }
    }

    public void setNotiPersonalContent(boolean z) {
        if (z) {
            this.pnOption |= 128;
        } else {
            this.pnOption &= -129;
        }
    }

    public void setNotiRating(boolean z) {
        if (z) {
            this.pnOption |= 128;
        } else {
            this.pnOption &= -129;
        }
    }

    public void setEmailOrder(boolean z) {
        if (z) {
            this.pnOption |= 512;
        } else {
            this.pnOption &= -513;
        }
    }

    public void setEmailList(boolean z) {
        if (z) {
            this.pnOption |= IjkMediaMeta.AV_CH_SIDE_RIGHT;
        } else {
            this.pnOption &= -1025;
        }
    }

    public void setEmailNews(boolean z) {
        if (z) {
            this.pnOption |= IjkMediaMeta.AV_CH_TOP_CENTER;
        } else {
            this.pnOption &= -2049;
        }
    }

    public void setEmailPersonalised(boolean z) {
        if (z) {
            this.pnOption |= IjkMediaMeta.AV_CH_TOP_FRONT_LEFT;
        } else {
            this.pnOption &= -4097;
        }
    }

    public void setWallet(boolean z) {
        if (z) {
            this.pnOption |= IjkMediaMeta.AV_CH_TOP_FRONT_CENTER;
        } else {
            this.pnOption &= -8193;
        }
    }

    public void setNotiFeedCommented(boolean z) {
        if (z) {
            this.pnOption |= IjkMediaMeta.AV_CH_TOP_BACK_LEFT;
        } else {
            this.pnOption &= -32769;
        }
    }

    public void setNotiFeedLiked(boolean z) {
        if (z) {
            this.pnOption |= IjkMediaMeta.AV_CH_TOP_BACK_CENTER;
        } else {
            this.pnOption &= -65537;
        }
    }

    public void setNotiFeedMentioned(boolean z) {
        if (z) {
            this.pnOption |= IjkMediaMeta.AV_CH_TOP_BACK_RIGHT;
        } else {
            this.pnOption &= -131073;
        }
    }

    public void setEmailVerified(boolean z) {
        this.emailVerified = z;
    }

    public boolean isEmailVerified() {
        return this.emailVerified;
    }

    public void setVCodeToken(String str) {
        this.VCodeToken = str;
    }

    public String getVCodeToken() {
        return this.VCodeToken;
    }

    public boolean hasPassword() {
        return this.hasPassword;
    }

    public void setLoginMethod(int i) {
        this.loginMethod = i;
    }

    public boolean loginHasPassword() {
        int i = this.loginMethod;
        return (i == 0 || i == 3) ? false : true;
    }

    public boolean isBeetalkLogin() {
        return this.loginMethod == 3;
    }

    public void setCrossBorderOption(int i) {
        this.crossBorderOption = i;
    }

    public boolean isCrossBorder() {
        return this.crossBorderOption > 0;
    }

    public void setHolidayMode(boolean z) {
        this.holidayMode = z;
    }

    public boolean isHolidayMode() {
        return this.holidayMode;
    }

    public void setHolidayModeTime(int i) {
        this.holidayModeTime = i;
    }

    public int getHolidayModeTime() {
        return this.holidayModeTime;
    }

    public boolean isAutoTranslationEnabled() {
        return this.autoTranslationEnabled;
    }

    public void setAutoTranslationEnabled(boolean z) {
        this.autoTranslationEnabled = z;
    }

    public void setWalletSetting(int i) {
        this.walletSetting = i;
    }

    public boolean isWalletFeatureOn() {
        return this.walletSetting == 1;
    }

    public void setBuyerWalletProvider(int i) {
        this.buyerWalletProvider = i;
    }

    public int getBuyerWalletProvider() {
        return this.buyerWalletProvider;
    }

    public boolean isBACheckNeeded() {
        int i = this.baCheckStatus;
        return i == 0 || i == 3;
    }

    public void setBACheckStatus(int i) {
        this.baCheckStatus = i;
    }

    public boolean isKOL() {
        return this.isKOL;
    }

    public boolean canPostFeed() {
        return this.canPostFeed;
    }

    public void setFeedInfo(FeedAccountInfo feedAccountInfo) {
        if (feedAccountInfo == null) {
            this.isKOL = false;
            this.canPostFeed = false;
            return;
        }
        this.isKOL = b.a(feedAccountInfo.is_kol, false);
        this.canPostFeed = b.a(feedAccountInfo.can_post_feed, false);
    }

    public void setLiveAccountInfo(LiveAccountInfo liveAccountInfo) {
        if (liveAccountInfo == null) {
            this.isLiveStreamHost = false;
            this.isLiveStreamBanned = false;
            return;
        }
        this.isLiveStreamHost = b.a(liveAccountInfo.is_host);
        this.isLiveStreamBanned = b.a(liveAccountInfo.is_banned);
    }

    public boolean isLiveStreamEnabled() {
        return this.isLiveStreamHost && !this.isLiveStreamBanned;
    }

    public boolean isLiveStreamHost() {
        return this.isLiveStreamHost;
    }

    public boolean isLiveStreamBanned() {
        return this.isLiveStreamBanned;
    }

    public String getNickname() {
        return this.nickname;
    }

    public void setNickname(String str) {
        this.nickname = str;
    }
}
