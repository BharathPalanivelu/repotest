package com.shopee.app.network.http.data;

public class FeatureToggle {
    public final String name;
    public final Boolean toggle;

    public FeatureToggle(Boolean bool, String str) {
        this.toggle = bool;
        this.name = str;
    }
}
