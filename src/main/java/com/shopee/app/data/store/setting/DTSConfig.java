package com.shopee.app.data.store.setting;

public class DTSConfig {
    public DTSData cb_order;
    public DTSData cb_pre_order;
    public DTSData order;
    public DTSData pre_order;

    public static class DTSData {
        public int _default;
        public int maximum;
    }

    public static DTSConfig DEFAULT() {
        DTSConfig dTSConfig = new DTSConfig();
        DTSData dTSData = new DTSData();
        dTSData._default = 2;
        dTSData.maximum = 99;
        DTSData dTSData2 = new DTSData();
        dTSData2._default = 2;
        dTSData2.maximum = 99;
        DTSData dTSData3 = new DTSData();
        dTSData3._default = 7;
        dTSData3.maximum = 30;
        DTSData dTSData4 = new DTSData();
        dTSData4._default = 7;
        dTSData4.maximum = 30;
        dTSConfig.order = dTSData;
        dTSConfig.pre_order = dTSData3;
        dTSConfig.cb_order = dTSData;
        dTSConfig.cb_pre_order = dTSData4;
        return dTSConfig;
    }
}
