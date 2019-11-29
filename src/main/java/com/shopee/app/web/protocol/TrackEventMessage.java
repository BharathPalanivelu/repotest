package com.shopee.app.web.protocol;

import java.util.Map;

public class TrackEventMessage {
    private String name;
    private String value;
    private Map<String, Object> valueDict;

    public String getName() {
        return this.name;
    }

    public String getValue() {
        return this.value;
    }

    public Map<String, Object> getValueDict() {
        return this.valueDict;
    }
}
