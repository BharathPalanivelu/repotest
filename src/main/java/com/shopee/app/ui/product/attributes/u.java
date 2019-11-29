package com.shopee.app.ui.product.attributes;

import java.io.Serializable;

public class u implements Serializable {
    private int attrId;
    private int itemSelectType;
    private int status = -1;
    private String value;

    public u(int i, String str, int i2, int i3) {
        this.attrId = i;
        this.value = str;
        this.itemSelectType = i2;
        this.status = i3;
    }

    public u(int i, String str, int i2) {
        this.attrId = i;
        this.value = str;
        this.itemSelectType = i2;
    }

    public int a() {
        return this.attrId;
    }

    public String b() {
        return this.value;
    }

    public int c() {
        return this.itemSelectType;
    }

    public void a(int i) {
        this.itemSelectType = i;
    }

    public boolean d() {
        return this.status == 0;
    }

    public String toString() {
        return "AttributeSelectData{attrId=" + this.attrId + ", value='" + this.value + '\'' + ", itemSelectType=" + this.itemSelectType + '}';
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        u uVar = (u) obj;
        if (this.attrId != uVar.attrId || this.itemSelectType != uVar.itemSelectType) {
            return false;
        }
        String str = this.value;
        if (str != null) {
            return str.equals(uVar.value);
        }
        if (uVar.value == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i = this.attrId * 31;
        String str = this.value;
        return ((i + (str != null ? str.hashCode() : 0)) * 31) + this.itemSelectType;
    }

    public boolean e() {
        return this.itemSelectType == 0;
    }

    public boolean f() {
        return this.itemSelectType == 1;
    }

    public boolean g() {
        return this.itemSelectType == 2;
    }
}
