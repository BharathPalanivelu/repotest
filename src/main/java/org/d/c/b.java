package org.d.c;

import java.io.IOException;
import java.util.Map;

public class b extends IOException {
    private static final long serialVersionUID = 942488788539151888L;
    private final String errorType;
    private final Map<String, String> headers;

    public b(String str, Map<String, String> map) {
        super(str, (Throwable) null);
        this.headers = map;
        this.errorType = null;
    }

    public b(String str, String str2, Map<String, String> map) {
        super(str2, (Throwable) null);
        this.headers = map;
        this.errorType = str;
    }

    public b(String str, Exception exc) {
        super(str, exc);
        this.headers = null;
        this.errorType = null;
    }

    public b(String str, Exception exc, Map<String, String> map) {
        super(str, exc);
        this.headers = map;
        this.errorType = null;
    }
}
