package com.shopee.app.react.protocol;

import java.util.List;

public class ReactBundle {
    private List<ReactAsset> assets;
    private String assets_base_url;
    private String md5;
    private String name;
    private String url;
    private String zip_url;

    public String getName() {
        return this.name;
    }

    public String getMd5() {
        return this.md5;
    }

    public String getUrl() {
        return this.url;
    }

    public List<ReactAsset> getAssets() {
        return this.assets;
    }

    public String getAssets_base_url() {
        return this.assets_base_url;
    }

    public String getZip_url() {
        return this.zip_url;
    }
}
