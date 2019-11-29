package org.b.a.a;

public class a extends b {

    /* renamed from: a  reason: collision with root package name */
    private String f33861a;

    /* renamed from: b  reason: collision with root package name */
    private String f33862b;

    /* renamed from: c  reason: collision with root package name */
    private String f33863c;

    /* renamed from: d  reason: collision with root package name */
    private String f33864d;

    public a(String str, String str2, String str3, String str4) {
        this.f33861a = str;
        this.f33862b = str2;
        this.f33863c = str3;
        this.f33864d = str4;
    }

    public String a() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("crop=");
        String str = this.f33861a;
        if (str != null) {
            stringBuffer.append(str);
            stringBuffer.append(":");
        }
        String str2 = this.f33862b;
        if (str2 != null) {
            stringBuffer.append(str2);
            stringBuffer.append(":");
        }
        String str3 = this.f33863c;
        if (str3 != null) {
            stringBuffer.append(str3);
            stringBuffer.append(":");
        }
        String str4 = this.f33864d;
        if (str4 != null) {
            stringBuffer.append(str4);
            stringBuffer.append(":");
        }
        stringBuffer.deleteCharAt(stringBuffer.length() - 1);
        return stringBuffer.toString();
    }
}
