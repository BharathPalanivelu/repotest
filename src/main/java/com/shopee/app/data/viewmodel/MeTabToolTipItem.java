package com.shopee.app.data.viewmodel;

public class MeTabToolTipItem {
    private boolean mShowSellerAddProductRedDot;
    private boolean mShowSellerTabPopup;
    private boolean mShowSellerTabRedDot;

    public MeTabToolTipItem(boolean z, boolean z2, boolean z3) {
        this.mShowSellerTabPopup = z;
        this.mShowSellerTabRedDot = z2;
        this.mShowSellerAddProductRedDot = z3;
    }

    public boolean isShowSellerTabPopup() {
        return this.mShowSellerTabPopup;
    }

    public boolean isShowSellerTabRedDot() {
        return this.mShowSellerTabRedDot;
    }

    public boolean isShowSellerAddProductRedDot() {
        return this.mShowSellerAddProductRedDot;
    }
}
