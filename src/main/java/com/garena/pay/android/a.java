package com.garena.pay.android;

import com.tencent.liteav.TXLiteAVCode;

public enum a {
    SUCCESS(0, "No Error"),
    APP_NOT_INSTALLED(2000, "Application is not installed"),
    UNSUPPORTED_API(2001, "Unsupported API Used"),
    USER_CANCELLED(2002, "User Cancelled the request"),
    USER_DENIED_REQUEST(2003, "User Denied the request"),
    LOGIN_FAILED(2004, "Login Failed"),
    REFRESH_TOKEN_SUCCESS(2005, "Token Refreshed Successfully"),
    REFRESH_TOKEN_FAILED(2006, "Token Refreshed Failed"),
    ACCESS_TOKEN_EXPIRED(2007, "Access Token Expired"),
    NETWORK_EXCEPTION(2008, "Exception Obtained while parsing data from the server"),
    ACCESS_TOKEN_EXCHANGE_FAILED(2009, "Access Token Exchanged Failed"),
    NETWORK_CONNECTION_EXCEPTION(2010, "Server cannot be reached. Check your network connection"),
    CANNOT_GET_RESULT(2011, "Unable to retrieve the Result"),
    ERROR_IN_PARAMS(2012, "Error in parameters"),
    CANNOT_START_ACTIVITY(2013, "Cannot Start Activity"),
    REQUEST_ID_MISMATCH(2014, "Request ID Mismatch"),
    ACCESS_TOKEN_INSPECTION_FAILED(2015, "Token inspection Failed"),
    SESSION_NOT_INITIALIZED(Integer.valueOf(TXLiteAVCode.EVT_VOD_PLAY_TCP_CONNECT_SUCC), "Session not initialized"),
    BATCH_SIZE_EXCEEDED(2102, "Batch Size exceeded for the Request"),
    BIND_FAILED(2201, "Bind failed but login success"),
    GUEST_ACCOUNT_INVALID(2202, "fail to grant guest token"),
    REDEEM_NOT_AVAILABLE(2304, "error_not_available"),
    ALREADY_REDEEMED(2305, "error_already_redeemed"),
    REDEEM_LIMIT_REACHED(2306, "error_redeem_limit_reached"),
    NETWORK_RESPONSE_PARSE_FAIL(2308, "network response parse fail"),
    NETWORK_REQUEST_TIME_OUT(2309, "network request timeout"),
    GOP_ERROR_SERVER(2401, "error_server"),
    GOP_ERROR_PARAMS(2402, "error_params"),
    GOP_ERROR_TOKEN(2403, "error_token"),
    GOP_ERROR_SCOPE(2404, "error_scope"),
    ERROR(2999, "General Error"),
    PAYMENT_NO_ERROR(7000, "No Payment Error"),
    PAYMENT_CANNOT_START_ACTIVITY(7001, "Cannot Start payment Activity"),
    PAYMENT_REQUEST_ID_MISMATCH(7002, "Request ID Mismatch"),
    PAYMENT_USER_CANCELLED(7003, "User Cancelled Payment"),
    PAYMENT_INVALID_SERVER_RESPONSE(7004, "Payment Recd. Invalid Response from the Server"),
    PAYMENT_NETWORK_CONNECTION_EXCEPTION(7005, "Network Connection Exception with the server"),
    PAYMENT_BUNDLE_RESULT_INVALID(7006, "Bundle Result cannot be read, Did you call onActivityResult?"),
    PAYMENT_ERROR_IN_PARAMS(7007, "Parameter Errors"),
    PAYMENT_ERROR_IN_SCOPE(7008, "Scope does not authorize payment"),
    PAYMENT_ERROR_IN_TOKEN(7009, "Error in access token used for payment"),
    PAYMENT_GENERAL_ERROR(7999, "General Payment Error"),
    UNKNOWN_ERROR(-1, "Unknown error Occurred"),
    ACCESS_TOKEN_INVALID_GRANT(Integer.valueOf(TXLiteAVCode.EVT_VOD_PLAY_FIRST_VIDEO_PACKET), "Access Token Invalid Grant");
    
    private final Integer code;
    private final String value;

    private a(Integer num, String str) {
        this.value = str;
        this.code = num;
    }

    public String getStringValue() {
        return this.value;
    }

    public Integer getCode() {
        return this.code;
    }

    public static String getErrorStringFromCode(int i) {
        for (a aVar : values()) {
            if (i == aVar.getCode().intValue()) {
                return aVar.getStringValue();
            }
        }
        return UNKNOWN_ERROR.getStringValue();
    }

    public static a getErrorFromCode(int i) {
        for (a aVar : values()) {
            if (i == aVar.getCode().intValue()) {
                return aVar;
            }
        }
        return UNKNOWN_ERROR;
    }

    public static boolean isFatal(int i) {
        return i == ACCESS_TOKEN_EXCHANGE_FAILED.getCode().intValue() || i == ACCESS_TOKEN_EXPIRED.getCode().intValue() || i == REFRESH_TOKEN_FAILED.getCode().intValue();
    }
}
