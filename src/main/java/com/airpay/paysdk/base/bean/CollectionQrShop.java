package com.airpay.paysdk.base.bean;

import com.airpay.paysdk.base.proto.CollectionQRPaymentOptionProto;
import com.airpay.paysdk.base.proto.CollectionQRShopProto;

public class CollectionQrShop {
    private boolean acceptBankAccount;
    private boolean acceptCreditCard;
    private long bankAccountId;
    private String ownerName;
    private String qrToken;
    private CollectionQRShopProto shop;
    private String shopIcon;
    private long shopId;
    private String shopName;
    private String shopPhoto;

    public CollectionQrShop(CollectionQRShopProto collectionQRShopProto) {
        this.shop = collectionQRShopProto;
        this.shopIcon = collectionQRShopProto.shop_icon;
        this.shopName = collectionQRShopProto.shop_name;
        this.ownerName = collectionQRShopProto.owner_name;
        if (collectionQRShopProto.shop_id != null) {
            this.shopId = collectionQRShopProto.shop_id.longValue();
        }
    }

    public CollectionQRShopProto updatePaymentMethods(boolean z, boolean z2) {
        return new CollectionQRShopProto.Builder().shop_id(this.shop.shop_id).payment_options(new CollectionQRPaymentOptionProto.Builder().bank_account(Boolean.valueOf(z)).credit_card(Boolean.valueOf(z2)).build()).build();
    }

    public CollectionQRShopProto getShop() {
        return this.shop;
    }

    public void setShop(CollectionQRShopProto collectionQRShopProto) {
        this.shop = collectionQRShopProto;
    }

    public String getQrToken() {
        return this.qrToken;
    }

    public void setQrToken(String str) {
        this.qrToken = str;
    }

    public String getShopIcon() {
        return this.shopIcon;
    }

    public void setShopIcon(String str) {
        this.shopIcon = str;
    }

    public String getShopName() {
        return this.shopName;
    }

    public void setShopName(String str) {
        this.shopName = str;
    }

    public long getShopId() {
        return this.shopId;
    }

    public void setShopId(long j) {
        this.shopId = j;
    }

    public String getOwnerName() {
        return this.ownerName;
    }

    public void setOwnerName(String str) {
        this.ownerName = str;
    }

    public boolean isAcceptBankAccount() {
        return this.acceptBankAccount;
    }

    public void setAcceptBankAccount(boolean z) {
        this.acceptBankAccount = z;
    }

    public boolean isAcceptCreditCard() {
        return this.acceptCreditCard;
    }

    public void setAcceptCreditCard(boolean z) {
        this.acceptCreditCard = z;
    }

    public long getBankAccountId() {
        return this.bankAccountId;
    }

    public void setBankAccountId(long j) {
        this.bankAccountId = j;
    }

    public String getShopPhoto() {
        return this.shopPhoto;
    }

    public void setShopPhoto(String str) {
        this.shopPhoto = str;
    }
}
