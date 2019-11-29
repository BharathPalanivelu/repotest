package com.shopee.app.data.viewmodel.order;

public class BuyerOrderCountItem {
    private Integer mBuyerRate = 0;
    private Integer mBuyerReturn = 0;
    private Integer mBuyerShipping = 0;
    private Integer mBuyerToShip = 0;
    private Integer mBuyerUnpaid = 0;

    public Integer getBuyerUnpaid() {
        return this.mBuyerUnpaid;
    }

    public void setBuyerUnpaid(Integer num) {
        this.mBuyerUnpaid = num;
    }

    public Integer getBuyerToShip() {
        return this.mBuyerToShip;
    }

    public void setBuyerToShip(Integer num) {
        this.mBuyerToShip = num;
    }

    public Integer getBuyerShipping() {
        return this.mBuyerShipping;
    }

    public void setBuyerShipping(Integer num) {
        this.mBuyerShipping = num;
    }

    public Integer getBuyerReturn() {
        return this.mBuyerReturn;
    }

    public void setBuyerReturn(Integer num) {
        this.mBuyerReturn = num;
    }

    public Integer getBuyerRate() {
        return this.mBuyerRate;
    }

    public void setBuyerRate(Integer num) {
        this.mBuyerRate = num;
    }
}
