package com.thoughtworks.xstream;

import com.thoughtworks.xstream.core.BaseException;

public class XStreamException extends BaseException {
    private Throwable cause;

    protected XStreamException() {
        this("", (Throwable) null);
    }

    public XStreamException(String str) {
        this(str, (Throwable) null);
    }

    public XStreamException(Throwable th) {
        this("", th);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public XStreamException(java.lang.String r3, java.lang.Throwable r4) {
        /*
            r2 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r3)
            if (r4 != 0) goto L_0x000d
            java.lang.String r3 = ""
            goto L_0x0022
        L_0x000d:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r1 = " : "
            r3.append(r1)
            java.lang.String r1 = r4.getMessage()
            r3.append(r1)
            java.lang.String r3 = r3.toString()
        L_0x0022:
            r0.append(r3)
            java.lang.String r3 = r0.toString()
            r2.<init>(r3)
            r2.cause = r4
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.thoughtworks.xstream.XStreamException.<init>(java.lang.String, java.lang.Throwable):void");
    }

    public Throwable getCause() {
        return this.cause;
    }
}
