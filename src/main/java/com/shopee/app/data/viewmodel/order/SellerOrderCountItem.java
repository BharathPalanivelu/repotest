package com.shopee.app.data.viewmodel.order;

public class SellerOrderCountItem {
    private Integer mSellerToPay;
    private Integer mSellerToReceive;
    private Integer mSellerToReturn;
    private Integer mSellerToShip;

    public Integer getSellerToPay() {
        return this.mSellerToPay;
    }

    public void setSellerToPay(Integer num) {
        this.mSellerToPay = num;
    }

    public Integer getSellerToShip() {
        return this.mSellerToShip;
    }

    public void setSellerToShip(Integer num) {
        this.mSellerToShip = num;
    }

    public Integer getSellerToReceive() {
        return this.mSellerToReceive;
    }

    public void setSellerToReceive(Integer num) {
        this.mSellerToReceive = num;
    }

    public Integer getSellerToReturn() {
        return this.mSellerToReturn;
    }

    public void setSellerToReturn(Integer num) {
        this.mSellerToReturn = num;
    }
}
