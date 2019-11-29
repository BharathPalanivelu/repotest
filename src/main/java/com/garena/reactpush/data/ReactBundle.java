package com.garena.reactpush.data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReactBundle {
    private Map<String, List<ReactAsset>> assets;
    private String assets_base_url;
    private String image_zip_url_hdpi;
    private String image_zip_url_mdpi;
    private String image_zip_url_xhdpi;
    private String image_zip_url_xxhdpi;
    private String image_zip_url_xxxhdpi;
    private String md5;
    private String name;
    private int priority = -1;
    private String url;
    private String zip_url_hdpi;
    private String zip_url_mdpi;
    private String zip_url_xhdpi;
    private String zip_url_xxhdpi;
    private String zip_url_xxxhdpi;

    public String getName() {
        return this.name;
    }

    public String getMd5() {
        return this.md5;
    }

    public String getUrl() {
        return this.url;
    }

    public List<ReactAsset> getAssetList(String str) {
        ArrayList arrayList = new ArrayList();
        Map<String, List<ReactAsset>> map = this.assets;
        return (map == null || !map.containsKey(str)) ? arrayList : this.assets.get(str);
    }

    public String getZipUrl(String str) {
        int dpiConst = dpiConst(str);
        if (dpiConst == 0) {
            return this.zip_url_mdpi;
        }
        if (dpiConst == 1) {
            return this.zip_url_hdpi;
        }
        if (dpiConst == 2) {
            return this.zip_url_xhdpi;
        }
        if (dpiConst == 3) {
            return this.zip_url_xxhdpi;
        }
        if (dpiConst != 4) {
            return null;
        }
        return this.zip_url_xxxhdpi;
    }

    public String getDrawableZip(String str) {
        int dpiConst = dpiConst(str);
        if (dpiConst == 0) {
            return this.image_zip_url_mdpi;
        }
        if (dpiConst == 1) {
            return this.image_zip_url_hdpi;
        }
        if (dpiConst == 2) {
            return this.image_zip_url_xhdpi;
        }
        if (dpiConst == 3) {
            return this.image_zip_url_xxhdpi;
        }
        if (dpiConst != 4) {
            return null;
        }
        return this.image_zip_url_xxxhdpi;
    }

    public void update(ReactBundle reactBundle) {
        this.name = reactBundle.name;
        this.md5 = reactBundle.md5;
        this.url = reactBundle.url;
        this.priority = reactBundle.priority;
        this.assets_base_url = reactBundle.assets_base_url;
        this.zip_url_mdpi = reactBundle.zip_url_mdpi;
        this.zip_url_hdpi = reactBundle.zip_url_hdpi;
        this.zip_url_xhdpi = reactBundle.zip_url_xhdpi;
        this.zip_url_xxhdpi = reactBundle.zip_url_xxhdpi;
        this.zip_url_xxxhdpi = reactBundle.zip_url_xxxhdpi;
        this.image_zip_url_mdpi = reactBundle.image_zip_url_mdpi;
        this.image_zip_url_hdpi = reactBundle.image_zip_url_hdpi;
        this.image_zip_url_xhdpi = reactBundle.image_zip_url_xhdpi;
        this.image_zip_url_xxhdpi = reactBundle.image_zip_url_xxhdpi;
        this.image_zip_url_xxxhdpi = reactBundle.image_zip_url_xxxhdpi;
    }

    public void addAsset(String str, ReactAsset reactAsset) {
        List list;
        if (this.assets == null) {
            this.assets = new HashMap();
        }
        if (this.assets.containsKey(str)) {
            list = this.assets.get(str);
        } else {
            ArrayList arrayList = new ArrayList();
            this.assets.put(str, arrayList);
            list = arrayList;
        }
        list.add(reactAsset);
    }

    public String getAssetBaseURL() {
        return this.assets_base_url;
    }

    public int getPriority() {
        return this.priority;
    }

    private static int dpiConst(String str) {
        if (str.equals("mdpi")) {
            return 0;
        }
        if (str.equals("hdpi")) {
            return 1;
        }
        if (str.equals("xhdpi")) {
            return 2;
        }
        if (str.equals("xxhdpi")) {
            return 3;
        }
        if (str.equals("xxxhdpi")) {
            return 4;
        }
        return 0;
    }
}
