package com.shopee.app.data.viewmodel;

import com.shopee.app.util.af;
import com.shopee.app.util.bj;
import com.shopee.app.util.i;
import com.shopee.protocol.shop.ShopCover;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ShopDetail {
    public static final int BAD = 2;
    public static final int GOOD = 0;
    public static final int NORMAL = 1;
    public static final String NO_IMAGE = "";
    public static final int OFFER_DISABLED = 1;
    public static final int OFFER_ENABLED = 0;
    public static final int PAYMENT_DISABLED = 0;
    public static final int PAYMENT_ENABLED = 1;
    public static final int PAY_BANK_TRANSFER = 2;
    public static final int PAY_CYBERSOURCE = 1;
    public static final int PAY_NONE = 0;
    public static final int PAY_OFFLINE_PAYMENT = 3;
    public static final int USER_NAME_NOT_INITED = 0;
    private String FBId;
    private String bankAccount;
    private String bankNo;
    private int bankStatus;
    private Integer birthdayTimeStamp = null;
    private int cTime;
    private String cover;
    private String defaultItemLogisticInfo;
    private String description;
    private String displayShippingFee;
    private boolean followed;
    private int followersCount;
    private int followingCount;
    private int gender;
    private boolean hasOfflinePayment;
    private List<String> images = new ArrayList();
    private boolean invisibleToContact;
    private boolean isChatDisabled = false;
    private boolean isDescriptionBanned = false;
    private boolean isEmailVerified;
    private boolean isFeedsPrivate;
    private boolean isLikesPrivate;
    private boolean isMall;
    private boolean isOnHoliday;
    private boolean isPhonePublic;
    private boolean isPhoneVerified;
    private boolean isShopAutoMsgOn;
    private int itemCount;
    private double latitude;
    private int likedCount;
    private double longitude;
    private int maxImageCount;
    private int offerStatus;
    private String phone;
    private String place;
    private String portrait;
    private int[] rating;
    private double ratingStar;
    private int score;
    private boolean seller;
    private String shopAutoMsg;
    private List<ShopCover> shopCovers;
    private int shopId;
    private String shopName;
    private int shopeeVerifiedFlag;
    private boolean showFullAddress;
    private int soldTotal;
    private int status;
    private int userId;
    private int userInited;
    private String userName;

    public boolean noImage() {
        return af.a(this.shopCovers);
    }

    public String getDisplayShippingFee() {
        return this.displayShippingFee;
    }

    public String getDefaultItemLogisticInfo() {
        return this.defaultItemLogisticInfo;
    }

    public int getMaxImageCount() {
        return this.maxImageCount;
    }

    public void setMaxImageCount(int i) {
        this.maxImageCount = i;
    }

    public void setDisplayShippingFee(String str) {
        this.displayShippingFee = str;
    }

    public void setDefaultItemLogisticInfo(String str) {
        this.defaultItemLogisticInfo = str;
    }

    public int getOfferStatus() {
        return this.offerStatus;
    }

    public boolean isOfferEnabled() {
        return this.offerStatus != 1;
    }

    public void setOfferStatus(int i) {
        this.offerStatus = i;
    }

    public boolean hasOfflinePayment() {
        return this.hasOfflinePayment;
    }

    public void setHasOfflinePayment(boolean z) {
        this.hasOfflinePayment = z;
    }

    public int getUserId() {
        return this.userId;
    }

    public void setUserName(String str) {
        this.userName = str;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setUserId(int i) {
        this.userId = i;
    }

    public int getShopId() {
        return this.shopId;
    }

    public void setShopId(int i) {
        this.shopId = i;
    }

    public String getShopName() {
        return this.shopName;
    }

    public void setShopName(String str) {
        this.shopName = str;
    }

    public String getPortrait() {
        return this.portrait;
    }

    public void setPortrait(String str) {
        this.portrait = str;
    }

    public int getFollowersCount() {
        return this.followersCount;
    }

    public String getFollowerString() {
        return bj.a((long) this.followersCount);
    }

    public String getFollowingString() {
        return bj.a((long) this.followingCount);
    }

    public String getShopRatingString() {
        int i = 0;
        int i2 = 0;
        while (true) {
            int[] iArr = this.rating;
            if (i >= iArr.length) {
                return bj.a((long) i2);
            }
            i2 += iArr[i];
            i++;
        }
    }

    public void setFollowersCount(int i) {
        this.followersCount = i;
    }

    public int getFollowingCount() {
        return this.followingCount;
    }

    public void setFollowingCount(int i) {
        this.followingCount = i;
    }

    public int getScore() {
        return this.score;
    }

    public void setScore(int i) {
        this.score = i;
    }

    public int[] getRating() {
        return this.rating;
    }

    public void setRating(int[] iArr) {
        this.rating = iArr;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String str) {
        this.description = str;
    }

    public boolean isSeller() {
        return this.seller;
    }

    public void setSeller(boolean z) {
        this.seller = z;
    }

    public int getItemCount() {
        return this.itemCount;
    }

    public void setItemCount(int i) {
        this.itemCount = i;
    }

    public int getStatus() {
        return this.status;
    }

    public void setStatus(int i) {
        this.status = i;
    }

    public String getCover() {
        return this.cover;
    }

    public void setCover(String str) {
        this.cover = str;
    }

    public double getLatitude() {
        return this.latitude;
    }

    public void setLatitude(double d2) {
        this.latitude = d2;
    }

    public double getLongitude() {
        return this.longitude;
    }

    public void setLongitude(double d2) {
        this.longitude = d2;
    }

    public String getPlace() {
        return this.place;
    }

    public void setPlace(String str) {
        this.place = str;
    }

    public void setPhoneVerified(boolean z) {
        this.isPhoneVerified = z;
    }

    public boolean isPhoneVerified() {
        return this.isPhoneVerified;
    }

    public void setCTime(int i) {
        this.cTime = i;
    }

    public int getCTime() {
        return this.cTime;
    }

    public void setPhone(String str) {
        this.phone = str;
    }

    public String getPhone() {
        return this.phone;
    }

    public boolean isEmailVerified() {
        return this.isEmailVerified;
    }

    public void setEmailVerified(boolean z) {
        this.isEmailVerified = z;
    }

    public void setFBId(String str) {
        this.FBId = str;
    }

    public String getFBId() {
        return this.FBId;
    }

    public void setIsPhonePublic(boolean z) {
        this.isPhonePublic = z;
    }

    public boolean isPhonePublic() {
        return this.isPhonePublic;
    }

    public void setPhonePublic(boolean z) {
        this.isPhonePublic = z;
    }

    public void setFollowed(boolean z) {
        this.followed = z;
    }

    public boolean isFollowed() {
        return this.followed;
    }

    public void setBankAccount(String str) {
        this.bankAccount = str;
    }

    public String getBankAccount() {
        return this.bankAccount;
    }

    public void setBankStatus(int i) {
        this.bankStatus = i;
    }

    public int getBankStatus() {
        return this.bankStatus;
    }

    public boolean hasNoBank() {
        return getBankStatus() == 0;
    }

    public String getShopUrl() {
        return i.f7040c + "shop/user/" + this.userId;
    }

    public void setBankNo(String str) {
        this.bankNo = str;
    }

    public String getBankNo() {
        return this.bankNo;
    }

    public String getBankNoSecret() {
        String str = this.bankNo;
        if (str == null || str.length() < 5) {
            return "****";
        }
        int length = this.bankNo.length();
        return "**** " + this.bankNo.substring(length - 4, length);
    }

    public void setLikedCount(int i) {
        this.likedCount = i;
    }

    public int getLikedCount() {
        return this.likedCount;
    }

    public String getLikedCountString() {
        return bj.a((long) this.likedCount);
    }

    public void setUserInited(int i) {
        this.userInited = i;
    }

    public boolean allowUserChangeName() {
        return this.userInited == 0;
    }

    public List<String> getImages() {
        return this.images;
    }

    public void setImages(List<String> list) {
        this.images = list;
    }

    public boolean isFeedsPrivate() {
        return this.isFeedsPrivate;
    }

    public void setIsFeedsPrivate(boolean z) {
        this.isFeedsPrivate = z;
    }

    public Integer getBirthdayTimeStamp() {
        return this.birthdayTimeStamp;
    }

    public void setBirthdayTimeStamp(int i) {
        this.birthdayTimeStamp = Integer.valueOf(i);
    }

    public int getGender() {
        return this.gender;
    }

    public void setGender(int i) {
        this.gender = i;
    }

    public String getShopAutoMsg() {
        return this.shopAutoMsg;
    }

    public void setShopAutoMsg(String str) {
        this.shopAutoMsg = str;
    }

    public boolean isShopAutoMsgOn() {
        return this.isShopAutoMsgOn;
    }

    public void setIsShopAutoMsgOn(boolean z) {
        this.isShopAutoMsgOn = z;
    }

    public boolean isLikesPrivate() {
        return this.isLikesPrivate;
    }

    public void setIsLikesPrivate(boolean z) {
        this.isLikesPrivate = z;
    }

    public boolean isDescriptionBanned() {
        return this.isDescriptionBanned;
    }

    public void setIsDescriptionBanned(boolean z) {
        this.isDescriptionBanned = z;
    }

    public boolean isChatDisabled() {
        return this.isChatDisabled;
    }

    public void setIsChatDisabled(boolean z) {
        this.isChatDisabled = z;
    }

    public boolean isShowFullAddress() {
        return this.showFullAddress;
    }

    public void setShowFullAddress(boolean z) {
        this.showFullAddress = z;
    }

    public String getRatingStarString() {
        return new BigDecimal(this.ratingStar).setScale(1, 4).toString();
    }

    public boolean isNoReview() {
        return Math.abs(this.ratingStar) <= 0.01d;
    }

    public void setRatingStar(double d2) {
        this.ratingStar = d2;
    }

    public void setShopCovers(List<ShopCover> list) {
        this.shopCovers = list;
    }

    public List<ShopCover> getShopCovers() {
        return this.shopCovers;
    }

    public boolean hasShopCover() {
        if (af.a(this.shopCovers)) {
            return false;
        }
        if (this.shopCovers.size() > 1 || (this.shopCovers.size() == 1 && this.shopCovers.get(0).image_url.compareTo("") != 0)) {
            return true;
        }
        return false;
    }

    public void setShopeeVerifiedFlag(int i) {
        this.shopeeVerifiedFlag = i;
    }

    public boolean isShopeeVerified() {
        return this.shopeeVerifiedFlag == 1;
    }

    public void setInvisibleToContact(boolean z) {
        this.invisibleToContact = z;
    }

    public boolean isInvisibleToContact() {
        return this.invisibleToContact;
    }

    public boolean isMall() {
        return this.isMall;
    }

    public void setMall(boolean z) {
        this.isMall = z;
    }

    public boolean isOnHoliday() {
        return this.isOnHoliday;
    }

    public void setHolidayModeOn(boolean z) {
        this.isOnHoliday = z;
    }
}
