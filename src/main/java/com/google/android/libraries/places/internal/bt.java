package com.google.android.libraries.places.internal;

import com.google.android.libraries.places.api.model.PlusCode;

abstract class bt extends PlusCode {

    /* renamed from: a  reason: collision with root package name */
    private final String f12417a;

    /* renamed from: b  reason: collision with root package name */
    private final String f12418b;

    bt(String str, String str2) {
        this.f12417a = str;
        this.f12418b = str2;
    }

    public String getCompoundCode() {
        return this.f12417a;
    }

    public String getGlobalCode() {
        return this.f12418b;
    }

    public String toString() {
        String str = this.f12417a;
        String str2 = this.f12418b;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 36 + String.valueOf(str2).length());
        sb.append("PlusCode{compoundCode=");
        sb.append(str);
        sb.append(", globalCode=");
        sb.append(str2);
        sb.append("}");
        return sb.toString();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof PlusCode) {
            PlusCode plusCode = (PlusCode) obj;
            String str = this.f12417a;
            if (str != null ? str.equals(plusCode.getCompoundCode()) : plusCode.getCompoundCode() == null) {
                String str2 = this.f12418b;
                return str2 != null ? str2.equals(plusCode.getGlobalCode()) : plusCode.getGlobalCode() == null;
            }
        }
    }

    public int hashCode() {
        String str = this.f12417a;
        int i = 0;
        int hashCode = ((str == null ? 0 : str.hashCode()) ^ 1000003) * 1000003;
        String str2 = this.f12418b;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode ^ i;
    }
}
