package com.tencent.cos.xml.model.tag;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class COSMetaData {
    private Map<String, String> metaData = new HashMap();

    public void put(String str, String str2) {
        if (!str.startsWith("x-cos-meta-")) {
            str = "x-cos-meta-" + str;
        }
        this.metaData.put(str, str2);
    }

    public String get(String str) {
        return this.metaData.get(str);
    }

    public Set<String> keySet() {
        return this.metaData.keySet();
    }
}
