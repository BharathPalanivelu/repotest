package com.shopee.app.web.protocol;

import android.text.TextUtils;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.facebook.share.internal.ShareConstants;
import com.garena.android.appkit.tools.b;
import com.shopee.app.web.protocol.notification.ShareDataField;
import com.shopee.id.R;
import java.util.List;

public class ShareMessage {
    public static final int SHARE_COLLECTION = 2;
    public static final int SHARE_GENERIC = 4;
    public static final int SHARE_HASHTAG = 3;
    public static final int SHARE_PRODUCT = 0;
    public static final int SHARE_REFERRAL = 5;
    public static final int SHARE_SHOP = 1;
    private String avatar;
    private String collectionBanner;
    private int collectionID;
    private List<String> disabledAppIds;
    private String genericImageUrl;
    private String genericText;
    private String hashtag;
    private List<String> imageList;
    private String itemCurrency;
    private String itemDesc;
    private long itemID = -1;
    private String itemImage;
    private int itemMTime = 0;
    private String itemName;
    private String itemOriginalImage;
    private String itemPrice;
    private List<String> priceList;
    private int shareType;
    private ShareDataField sharingImages;
    private ShareDataField sharingText;
    private ShareDataField sharingUrls;
    private String shopDesc;
    private int shopFollowerCount;
    private int shopID;
    private String shopImage;
    private String shopName;
    private int shopProductCount;
    private String subTitle;
    private String title;
    private String url;
    private String username;
    private String watermarkCollectionDesc;
    private String watermarkCollectionTitle;
    private String watermarkDiscountText;
    private String watermarkHashTagDesc;
    private String watermarkHashTagTitle;
    private String watermarkProductDesc;
    private String watermarkShopDesc;
    private String watermarkShopJoinDate;

    public ShareDataField getSharingText() {
        return this.sharingText;
    }

    public ShareDataField getSharingImages() {
        return this.sharingImages;
    }

    public ShareDataField getSharingUrls() {
        return this.sharingUrls;
    }

    public void setSharingText(ShareDataField shareDataField) {
        this.sharingText = shareDataField;
    }

    public int getmTime() {
        return this.itemMTime;
    }

    public void setMTime(int i) {
        this.itemMTime = i;
    }

    public int getShopID() {
        return this.shopID;
    }

    public void setShopID(int i) {
        this.shopID = i;
    }

    public long getItemID() {
        return this.itemID;
    }

    public void setItemID(long j) {
        this.itemID = j;
    }

    public boolean isShareItem() {
        return this.itemID != -1;
    }

    public boolean isShareShop() {
        return this.shareType == 1;
    }

    public String getItemName() {
        String str = this.itemName;
        return str == null ? b.e(R.string.sp_product_name_placeholder) : str;
    }

    public void setItemName(String str) {
        this.itemName = str;
    }

    public String getItemDesc() {
        return this.itemDesc;
    }

    public void setItemDesc(String str) {
        this.itemDesc = str;
    }

    public String getItemCurrency() {
        return this.itemCurrency;
    }

    public void setItemCurrency(String str) {
        this.itemCurrency = str;
    }

    public String getItemPrice() {
        return this.itemPrice;
    }

    public void setItemPrice(String str) {
        this.itemPrice = str;
    }

    public String getItemImage() {
        return this.itemImage;
    }

    public void setItemImage(String str) {
        this.itemImage = str;
    }

    public String getShopName() {
        return this.shopName;
    }

    public void setShopName(String str) {
        this.shopName = str;
    }

    public String getShopDesc() {
        return this.shopDesc;
    }

    public void setShopDesc(String str) {
        this.shopDesc = str;
    }

    public String getShopImage() {
        return this.shopImage;
    }

    public void setShopImage(String str) {
        this.shopImage = str;
    }

    public void setUsername(String str) {
        this.username = str;
    }

    public String getUsername() {
        return this.username;
    }

    public String getAvatar() {
        return this.avatar;
    }

    public void setAvatar(String str) {
        this.avatar = str;
    }

    public List<String> getImageList() {
        return this.imageList;
    }

    public String getCollectionBanner() {
        return this.collectionBanner;
    }

    public void setCollectionBanner(String str) {
        this.collectionBanner = str;
    }

    public int getShareType() {
        return this.shareType;
    }

    public void setShareType(int i) {
        this.shareType = i;
    }

    public void setImageList(List<String> list) {
        this.imageList = list;
    }

    public String getWatermarkDiscountText() {
        return this.watermarkDiscountText;
    }

    public void setWatermarkDiscountText(String str) {
        this.watermarkDiscountText = str;
    }

    public String getWatermarkProductDesc() {
        return this.watermarkProductDesc;
    }

    public void setWatermarkProductDesc(String str) {
        this.watermarkProductDesc = str;
    }

    public String getWatermarkShopDesc() {
        return this.watermarkShopDesc;
    }

    public void setWatermarkShopDesc(String str) {
        this.watermarkShopDesc = str;
    }

    public String getWatermarkCollectionTitle() {
        return this.watermarkCollectionTitle;
    }

    public void setWatermarkCollectionTitle(String str) {
        this.watermarkCollectionTitle = str;
    }

    public String getWatermarkCollectionDesc() {
        return this.watermarkCollectionDesc;
    }

    public void setWatermarkCollectionDesc(String str) {
        this.watermarkCollectionDesc = str;
    }

    public int getCollectionID() {
        return this.collectionID;
    }

    public String getUrl() {
        return this.url;
    }

    public String getWatermarkShopJoinDate() {
        return this.watermarkShopJoinDate;
    }

    public int getShopFollowerCount() {
        return this.shopFollowerCount;
    }

    public int getShopProductCount() {
        return this.shopProductCount;
    }

    public void setUrl(String str) {
        this.url = str;
    }

    public void setShopFollowerCount(int i) {
        this.shopFollowerCount = i;
    }

    public void setShopProductCount(int i) {
        this.shopProductCount = i;
    }

    public void setWatermarkShopJoinDate(String str) {
        this.watermarkShopJoinDate = str;
    }

    public List<String> getPriceList() {
        return this.priceList;
    }

    public void setPriceList(List<String> list) {
        this.priceList = list;
    }

    public String getWatermarkHashTagTitle() {
        return this.watermarkHashTagTitle;
    }

    public void setWatermarkHashTagTitle(String str) {
        this.watermarkHashTagTitle = str;
    }

    public String getWatermarkHashTagDesc() {
        return this.watermarkHashTagDesc;
    }

    public void setWatermarkHashTagDesc(String str) {
        this.watermarkHashTagDesc = str;
    }

    public String getShareTrackerLabel() {
        int i = this.shareType;
        if (i == 0) {
            return "product";
        }
        if (i == 1) {
            return "shop";
        }
        if (i == 2) {
            return "collection";
        }
        if (i == 3) {
            return ShareConstants.WEB_DIALOG_PARAM_HASHTAG;
        }
        if (i != 4) {
            return i != 5 ? "product" : "referral";
        }
        return MessengerShareContentUtility.TEMPLATE_GENERIC_TYPE;
    }

    public String getShareTrackerId() {
        String valueOf = String.valueOf(this.itemID);
        int i = this.shareType;
        if (i == 0) {
            return String.valueOf(this.itemID);
        }
        if (i == 1) {
            return String.valueOf(this.shopID);
        }
        if (i == 2) {
            return String.valueOf(this.collectionID);
        }
        if (i == 3) {
            return this.hashtag;
        }
        if (i == 4) {
            return MessengerShareContentUtility.TEMPLATE_GENERIC_TYPE;
        }
        if (i != 5) {
            return valueOf;
        }
        return "referral";
    }

    public String getGenericImageUrl() {
        return TextUtils.isEmpty(this.genericImageUrl) ? "" : this.genericImageUrl;
    }

    public void setGenericImageUrl(String str) {
        this.genericImageUrl = str;
    }

    public String getItemOriginalImage() {
        String str = this.itemOriginalImage;
        return str == null ? this.itemImage : str;
    }

    public boolean isGeneric() {
        return this.shareType == 4;
    }

    public String getGenericText() {
        return this.genericText;
    }

    public String getTitle() {
        return this.title;
    }

    public String getSubTitle() {
        return this.subTitle;
    }

    public List<String> getDisabledAppIds() {
        return this.disabledAppIds;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public void setSubTitle(String str) {
        this.subTitle = str;
    }

    public boolean isReferral() {
        return this.shareType == 5;
    }
}
