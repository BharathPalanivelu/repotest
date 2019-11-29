package com.shopee.app.web.protocol;

import com.shopee.id.R;
import java.util.List;

public class RightItemMessage {
    public static final String ICON_TYPE_EDIT_PRODUCT = "editProduct";
    public static final String ICON_TYPE_FILTER = "filter";
    public static final String ICON_TYPE_FILTER_APPLIED = "filterApplied";
    private String iconText;
    private String iconType = "";
    private String iconUrl;
    private long itemID;
    List<RightItemMessage> items;
    private String key;
    private int shopID;
    private String text;
    private String textColor;
    private TrackingMessageModel trackingData;
    private String type;
    private String url;
    private int userID;

    public RightItemMessage() {
    }

    public RightItemMessage(String str, String str2, String str3) {
        this.text = str3;
        this.type = str;
        this.key = str2;
    }

    public String getText() {
        return this.text;
    }

    public void setText(String str) {
        this.text = str;
    }

    public String getIconType() {
        return this.iconType;
    }

    public void setIconType(String str) {
        this.iconType = str;
    }

    public String getType() {
        return this.type;
    }

    public int getIconDrawable() {
        if ("filter".equals(this.iconType)) {
            return R.drawable.com_garena_shopee_ic_filter;
        }
        if ("filterApplied".equals(this.iconType)) {
            return R.drawable.com_garena_shopee_ic_filtered;
        }
        return "editProduct".equals(this.iconType) ? R.drawable.com_garena_shopee_ic_edit_primary : R.drawable.action_bar_button_background;
    }

    public void setType(String str) {
        this.type = str;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String str) {
        this.url = str;
    }

    public List<RightItemMessage> getItems() {
        return this.items;
    }

    public void setItems(List<RightItemMessage> list) {
        this.items = list;
    }

    public String getKey() {
        return this.key;
    }

    public void setKey(String str) {
        this.key = str;
    }

    public long getItemID() {
        return this.itemID;
    }

    public void setItemID(long j) {
        this.itemID = j;
    }

    public int getShopID() {
        return this.shopID;
    }

    public void setShopID(int i) {
        this.shopID = i;
    }

    public int getUserID() {
        return this.userID;
    }

    public void setUserID(int i) {
        this.userID = i;
    }

    public String getIconUrl() {
        return this.iconUrl;
    }

    public String getIconText() {
        return this.iconText;
    }

    public void setIconText(String str) {
        this.iconText = str;
    }

    public void setIconUrl(String str) {
        this.iconUrl = str;
    }

    public String getTextColor() {
        return this.textColor;
    }

    public TrackingMessageModel getTrackingMessageModel() {
        return this.trackingData;
    }
}
