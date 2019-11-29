package com.shopee.app.network.http.data;

import java.util.List;

public class FeatureToggleResponse extends BaseResponse {
    public final List<FeatureToggle> data;

    public FeatureToggleResponse(List<FeatureToggle> list) {
        this.data = list;
    }
}
