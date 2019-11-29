package com.tencent.imcore;

public enum HttpMethod {
    kPost((String) 1),
    kGet,
    kPut,
    kDelete;
    
    private final int swigValue;

    private static class aa {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public static int f30647a;

        static /* synthetic */ int a() {
            int i = f30647a;
            f30647a = i + 1;
            return i;
        }
    }

    private HttpMethod(int i) {
        this.swigValue = i;
        int unused = aa.f30647a = i + 1;
    }

    private HttpMethod(HttpMethod httpMethod) {
        this.swigValue = httpMethod.swigValue;
        int unused = aa.f30647a = this.swigValue + 1;
    }

    public static HttpMethod swigToEnum(int i) {
        HttpMethod[] httpMethodArr = (HttpMethod[]) HttpMethod.class.getEnumConstants();
        if (i < httpMethodArr.length && i >= 0 && httpMethodArr[i].swigValue == i) {
            return httpMethodArr[i];
        }
        for (HttpMethod httpMethod : httpMethodArr) {
            if (httpMethod.swigValue == i) {
                return httpMethod;
            }
        }
        throw new IllegalArgumentException("No enum " + HttpMethod.class + " with value " + i);
    }

    public final int swigValue() {
        return this.swigValue;
    }
}
