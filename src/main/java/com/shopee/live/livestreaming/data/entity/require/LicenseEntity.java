package com.shopee.live.livestreaming.data.entity.require;

import java.io.Serializable;

public class LicenseEntity implements Serializable {
    private String key = "";
    private String license = "";

    public LicenseEntity() {
    }

    public LicenseEntity(String str, String str2) {
        this.key = str;
        this.license = str2;
    }

    public String getLicense() {
        String str = this.license;
        return str == null ? "" : str;
    }

    public void setLicense(String str) {
        this.license = str;
    }

    public String getKey() {
        String str = this.key;
        return str == null ? "" : str;
    }

    public void setKey(String str) {
        this.key = str;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        LicenseEntity licenseEntity = (LicenseEntity) obj;
        String str = this.key;
        if (str == null ? licenseEntity.key != null : !str.equals(licenseEntity.key)) {
            return false;
        }
        String str2 = this.license;
        if (str2 != null) {
            return str2.equals(licenseEntity.license);
        }
        if (licenseEntity.license == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        String str = this.key;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.license;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode + i;
    }
}
