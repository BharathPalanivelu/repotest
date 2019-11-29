package org.d.a.b;

import java.io.Serializable;

public class b implements Serializable {
    private static final long serialVersionUID = 715000866082812683L;
    private final String rawResponse;
    private final String secret;
    private final String token;

    public b(String str, String str2) {
        this(str, str2, (String) null);
    }

    public b(String str, String str2, String str3) {
        this.token = str;
        this.secret = str2;
        this.rawResponse = str3;
    }

    public String a() {
        return this.token;
    }

    public String b() {
        return this.secret;
    }

    public String toString() {
        return String.format("Token[%s , %s]", new Object[]{this.token, this.secret});
    }
}
