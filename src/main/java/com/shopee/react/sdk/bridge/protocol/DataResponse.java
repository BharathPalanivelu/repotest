package com.shopee.react.sdk.bridge.protocol;

import com.shopee.navigator.b;

public class DataResponse<T extends b> extends b {
    private static final b emptyJsonable = new b() {
    };
    private final b data;
    private final int error;
    private final String errorMessage;

    private DataResponse(int i, b bVar, String str) {
        this.error = i;
        this.data = bVar;
        this.errorMessage = str;
    }

    public static <T extends b> DataResponse<T> success() {
        return new DataResponse<>(0, emptyJsonable, "");
    }

    public static <T extends b> DataResponse<T> success(T t) {
        return new DataResponse<>(0, t, "");
    }

    public static <T extends b> DataResponse<T> error() {
        return new DataResponse<>(1, emptyJsonable, "");
    }

    public static <T extends b> DataResponse<T> error(String str) {
        return new DataResponse<>(1, emptyJsonable, str);
    }

    public static <T extends b> DataResponse<T> error(int i, String str) {
        return new DataResponse<>(i, emptyJsonable, str);
    }

    public static <T extends b> DataResponse<T> error(int i, T t) {
        return new DataResponse<>(i, t, "");
    }

    public static <T extends b> DataResponse<T> error(int i, T t, String str) {
        return new DataResponse<>(i, t, str);
    }
}
