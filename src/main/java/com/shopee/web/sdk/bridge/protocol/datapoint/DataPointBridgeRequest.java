package com.shopee.web.sdk.bridge.protocol.datapoint;

import java.util.List;

public class DataPointBridgeRequest {
    private List<String> contentTypes;

    public DataPointBridgeRequest(List<String> list) {
        this.contentTypes = list;
    }

    public List<String> getContentTypes() {
        return this.contentTypes;
    }

    public void setContentTypes(List<String> list) {
        this.contentTypes = list;
    }
}
