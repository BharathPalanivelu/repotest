package com.airpay.paysdk.base.bean;

import android.text.TextUtils;
import com.airpay.paysdk.core.bean.ChannelInfo;
import com.facebook.appevents.AppEventsConstants;
import com.litesuits.orm.db.assit.SQLBuilder;

public class BPThirdPartyOrderDetail {
    private String mAccountId;
    private int mAppId;
    private ChannelInfo mChannelInfo;
    private String mChannelTxnKey;
    private String mCurrency;
    private int mExpiryTime;
    private String mImageUrl;
    private int mItemAmount;
    private String mItemId;
    private String mItemName;
    private String mOrderId;
    private long mPayableAmount;
    private String mRawData;
    private String mRebateDesc;
    private CollectionQrShop mShop;
    private BPThirdPartyStoreInfo mStoreInfo;
    private String mTransferPurpose;

    protected BPThirdPartyOrderDetail(Builder builder) {
        this.mAppId = builder.app_id;
        this.mOrderId = builder.order_id;
        this.mCurrency = builder.currency;
        this.mExpiryTime = builder.expiry_time;
        this.mItemName = builder.item_name;
        this.mImageUrl = builder.image_url;
        this.mPayableAmount = builder.payable_amount;
        this.mRebateDesc = builder.rebate_desc;
        this.mRawData = builder.raw_data;
        this.mAccountId = builder.account_id;
        this.mItemAmount = builder.item_amount;
        this.mItemId = builder.item_id;
        this.mChannelTxnKey = builder.channel_txn_key;
        this.mStoreInfo = builder.store_info;
        this.mShop = builder.shop;
        this.mTransferPurpose = builder.transfer_purpose;
    }

    public int getAppId() {
        return this.mAppId;
    }

    public String getOrderId() {
        return this.mOrderId;
    }

    public String getCurrency() {
        return this.mCurrency;
    }

    public long getPayableAmount() {
        return this.mPayableAmount;
    }

    public void setPayableAmount(long j) {
        this.mPayableAmount = j;
    }

    public int getExpiryTime() {
        return this.mExpiryTime;
    }

    public String getItemName() {
        return this.mItemName;
    }

    public String getImageUrl() {
        return this.mImageUrl;
    }

    public String getRebateDesc() {
        return this.mRebateDesc;
    }

    public String getRawData() {
        return this.mRawData;
    }

    public String getAccountId() {
        return this.mAccountId;
    }

    public int getItemAmount() {
        return this.mItemAmount;
    }

    public void setItemAmount(int i) {
        this.mItemAmount = i;
    }

    public String getItemId() {
        return this.mItemId;
    }

    public String getChannelTxnKey() {
        return this.mChannelTxnKey;
    }

    public BPThirdPartyStoreInfo getStoreInfo() {
        return this.mStoreInfo;
    }

    public String getItemDisplayName() {
        if (this.mItemAmount <= 1 || TextUtils.isEmpty(this.mItemName)) {
            return this.mItemName;
        }
        return this.mItemAmount + SQLBuilder.BLANK + this.mItemName;
    }

    public String getStoreName() {
        BPThirdPartyStoreInfo bPThirdPartyStoreInfo = this.mStoreInfo;
        if (bPThirdPartyStoreInfo != null && !TextUtils.isEmpty(bPThirdPartyStoreInfo.storeName)) {
            return this.mStoreInfo.storeName;
        }
        ChannelInfo channelInfo = this.mChannelInfo;
        return channelInfo != null ? channelInfo.i() : "";
    }

    public CollectionQrShop getShop() {
        return this.mShop;
    }

    public String getProductName(String str) {
        if (TextUtils.isEmpty(this.mItemName) || TextUtils.isEmpty(this.mTransferPurpose)) {
            return str;
        }
        return TextUtils.concat(new CharSequence[]{this.mItemName, " - ", this.mTransferPurpose}).toString();
    }

    public static class Builder {
        /* access modifiers changed from: private */
        public String account_id;
        /* access modifiers changed from: private */
        public int app_id;
        /* access modifiers changed from: private */
        public String channel_txn_key;
        /* access modifiers changed from: private */
        public String currency;
        /* access modifiers changed from: private */
        public int expiry_time;
        /* access modifiers changed from: private */
        public String image_url;
        /* access modifiers changed from: private */
        public int item_amount = 1;
        /* access modifiers changed from: private */
        public String item_id = AppEventsConstants.EVENT_PARAM_VALUE_NO;
        /* access modifiers changed from: private */
        public String item_name;
        /* access modifiers changed from: private */
        public String order_id;
        /* access modifiers changed from: private */
        public long payable_amount;
        /* access modifiers changed from: private */
        public String raw_data;
        /* access modifiers changed from: private */
        public String rebate_desc;
        /* access modifiers changed from: private */
        public CollectionQrShop shop;
        /* access modifiers changed from: private */
        public BPThirdPartyStoreInfo store_info;
        /* access modifiers changed from: private */
        public String transfer_purpose;

        public Builder app_id(int i) {
            this.app_id = i;
            return this;
        }

        public Builder order_id(String str) {
            this.order_id = str;
            return this;
        }

        public Builder currency(String str) {
            this.currency = str;
            return this;
        }

        public Builder payable_amount(long j) {
            this.payable_amount = j;
            return this;
        }

        public Builder expiry_time(int i) {
            this.expiry_time = i;
            return this;
        }

        public Builder item_name(String str) {
            this.item_name = str;
            return this;
        }

        public Builder image_url(String str) {
            this.image_url = str;
            return this;
        }

        public Builder rebate_desc(String str) {
            this.rebate_desc = str;
            return this;
        }

        public Builder raw_data(String str) {
            this.raw_data = str;
            return this;
        }

        public Builder channel_txn_key(String str) {
            this.channel_txn_key = str;
            return this;
        }

        public Builder account_id(String str) {
            this.account_id = str;
            return this;
        }

        public Builder item_amount(int i) {
            this.item_amount = i;
            return this;
        }

        public Builder item_id(String str) {
            if (!TextUtils.isEmpty(str)) {
                this.item_id = str;
            }
            return this;
        }

        public Builder transfer_purpose(String str) {
            if (!TextUtils.isEmpty(str)) {
                this.transfer_purpose = str;
            }
            return this;
        }

        public Builder store(BPThirdPartyStoreInfo bPThirdPartyStoreInfo) {
            this.store_info = bPThirdPartyStoreInfo;
            return this;
        }

        public Builder shop(CollectionQrShop collectionQrShop) {
            this.shop = collectionQrShop;
            return this;
        }

        public BPThirdPartyOrderDetail build() {
            return new BPThirdPartyOrderDetail(this);
        }
    }
}
