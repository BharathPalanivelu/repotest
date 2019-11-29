package com.shopee.app.data.store;

import java.util.HashMap;

public class RegionConfig {
    private static final String DEFAULT = "default";
    private static final String REGION_CODE = "ID";
    private HashMap<String, Boolean> hide_language_selection;
    private HashMap<String, Boolean> hide_timeline;
    private HashMap<String, Boolean> is_lite_build;
    private HashMap<String, Integer> min_non_lite_version;

    public boolean hideTimeline() {
        return readBoolean(this.hide_timeline);
    }

    public boolean hideLanguageSelection() {
        return readBoolean(this.hide_language_selection);
    }

    public boolean isFullBuild() {
        return !readBoolean(this.is_lite_build) && 297 >= readInteger(this.min_non_lite_version);
    }

    private boolean readBoolean(HashMap<String, Boolean> hashMap) {
        if (hashMap != null) {
            if (hashMap.containsKey("ID")) {
                return hashMap.get("ID").booleanValue();
            }
            if (hashMap.containsKey(DEFAULT)) {
                return hashMap.get(DEFAULT).booleanValue();
            }
        }
        return true;
    }

    private int readInteger(HashMap<String, Integer> hashMap) {
        if (hashMap != null) {
            if (hashMap.containsKey("ID")) {
                return hashMap.get("ID").intValue();
            }
            if (hashMap.containsKey(DEFAULT)) {
                return hashMap.get(DEFAULT).intValue();
            }
        }
        return 28;
    }
}
