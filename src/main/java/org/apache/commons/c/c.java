package org.apache.commons.c;

import java.io.Serializable;

public class c {

    /* renamed from: a  reason: collision with root package name */
    public static final a f33853a = new a();

    @Deprecated
    public static String a(Object obj) {
        return obj == null ? "" : obj.toString();
    }

    public static class a implements Serializable {
        private static final long serialVersionUID = 7092611880189329093L;

        a() {
        }

        private Object readResolve() {
            return c.f33853a;
        }
    }
}
