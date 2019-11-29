package com.thoughtworks.xstream.core.util;

public final class FastField {
    private final String declaringClass;
    private final String name;

    public FastField(String str, String str2) {
        this.name = str2;
        this.declaringClass = str;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public FastField(Class cls, String str) {
        this(cls == null ? null : cls.getName(), str);
    }

    public String getName() {
        return this.name;
    }

    public String getDeclaringClass() {
        return this.declaringClass;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof FastField)) {
            return false;
        }
        FastField fastField = (FastField) obj;
        if ((this.declaringClass != null || fastField.declaringClass == null) && ((this.declaringClass == null || fastField.declaringClass != null) && this.name.equals(fastField.getName()))) {
            String str = this.declaringClass;
            if (str == null || str.equals(fastField.getDeclaringClass())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int hashCode = this.name.hashCode();
        String str = this.declaringClass;
        return hashCode ^ (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        if (this.declaringClass == null) {
            str = "";
        } else {
            str = this.declaringClass + ".";
        }
        sb.append(str);
        sb.append(this.name);
        return sb.toString();
    }
}
