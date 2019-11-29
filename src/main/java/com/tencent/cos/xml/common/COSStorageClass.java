package com.tencent.cos.xml.common;

public enum COSStorageClass {
    STANDARD("Standard"),
    STANDARD_IA("Standard_IA");
    
    private String cosStorageClass;

    private COSStorageClass(String str) {
        this.cosStorageClass = str;
    }

    public String getStorageClass() {
        return this.cosStorageClass;
    }

    public static COSStorageClass fromString(String str) {
        for (COSStorageClass cOSStorageClass : values()) {
            if (cOSStorageClass.cosStorageClass.equalsIgnoreCase(str)) {
                return cOSStorageClass;
            }
        }
        return null;
    }
}
