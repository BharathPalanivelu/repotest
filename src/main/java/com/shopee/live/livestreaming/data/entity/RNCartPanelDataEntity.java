package com.shopee.live.livestreaming.data.entity;

import com.shopee.sdk.b.a;

public class RNCartPanelDataEntity extends a {
    public static final int ERROR_CODE_OFFLINE = -101;
    public static final int ERROR_EMPTY_STOCK = 3;
    public static final int ERROR_FE_SERVER_ERROR = -999;
    public static final int ERROR_OUT_OF_STICK = 6;
    public static final int ERROR_REQUEST_TIMEOUT = -99;
    public static final int ERROR_TRAFFIC_JAM = -100;
    public static final int NULL_VALUE = Integer.MIN_VALUE;
    public static final int TYPE_ADD_TO_CART_ERR = 3;
    public static final int TYPE_FETCH_ITEM_ERR = 0;
    public static final int TYPE_FETCH_SHOP_ERR = 1;
    public static final int TYPE_PRECONDITION_ERR = 2;
    private Data data = new Data();
    private int status = NULL_VALUE;

    public int getStatus() {
        return this.status;
    }

    public Data getData() {
        return this.data;
    }

    public static class Data {
        private int error = RNCartPanelDataEntity.NULL_VALUE;
        private String error_msg = "";
        private int type = RNCartPanelDataEntity.NULL_VALUE;

        public int getType() {
            return this.type;
        }

        public int getError() {
            return this.error;
        }

        public String getError_msg() {
            return this.error_msg;
        }
    }
}
