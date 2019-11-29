package org.d.d;

import com.facebook.imageutils.JfifUtil;
import com.facebook.internal.FacebookRequestErrorClassification;
import com.shopee.live.livestreaming.data.entity.DanmaKuEntity;
import com.tencent.imsdk.protocol.im_common;
import com.tencent.qalsdk.im_open.http;
import twitter4j.HttpResponseCode;

public enum a {
    OK(200, "OK"),
    CREATED(DanmaKuEntity.MESSAGE_PUBLIC, "Created"),
    ACCEPTED(202, "Accepted"),
    NON_AUTHORITATIVE_INFORMATION(203, "Non-Authoritative Information"),
    NO_CONTENT(http.No_Content, "No Content"),
    RESET_CONTENT(205, "Reset Content"),
    PARTIAL_CONTENT(http.Partial_Content, "Partial Content"),
    MULTI_STATUS(207, "Multi-Status"),
    ALREADY_REPORTED(JfifUtil.MARKER_RST0, "Already Reported"),
    IM_USED(226, "IM Used"),
    MULTIPLE_CHOICES(300, "Multiple Choices"),
    MOVED_PERMANENTLY(301, "Moved Permanently"),
    FOUND(302, "Found"),
    MOVED_TEMPORARILY(302, "Moved Temporarily"),
    SEE_OTHER(im_common.RICH_STATUS_TMP_MSG, "See Other"),
    NOT_MODIFIED(304, "Not Modified"),
    USE_PROXY(im_common.NEARBY_PEOPLE_TMP_OWN_MSG, "Use Proxy"),
    TEMPORARY_REDIRECT(307, "Temporary Redirect"),
    PERMANENT_REDIRECT(308, "Permanent Redirect"),
    BAD_REQUEST(400, "Bad Request"),
    UNAUTHORIZED(401, "Unauthorized"),
    PAYMENT_REQUIRED(402, "Payment Required"),
    FORBIDDEN(403, "Forbidden"),
    NOT_FOUND(404, "Not Found"),
    METHOD_NOT_ALLOWED(405, "Method Not Allowed"),
    NOT_ACCEPTABLE(HttpResponseCode.NOT_ACCEPTABLE, "Not Acceptable"),
    PROXY_AUTHENTICATION_REQUIRED(407, "Proxy Authentication Required"),
    REQUEST_TIMEOUT(http.Request_Timeout, "Request Timeout"),
    CONFLICT(409, "Conflict"),
    GONE(410, "Gone"),
    LENGTH_REQUIRED(411, "Length Required"),
    PRECONDITION_FAILED(FacebookRequestErrorClassification.EC_APP_NOT_INSTALLED, "Precondition Failed"),
    PAYLOAD_TOO_LARGE(http.Request_Entity_Too_Large, "Payload Too Large"),
    REQUEST_ENTITY_TOO_LARGE(http.Request_Entity_Too_Large, "Request Entity Too Large"),
    URI_TOO_LONG(http.Request_URI_Too_Long, "URI Too Long"),
    REQUEST_URI_TOO_LONG(http.Request_URI_Too_Long, "Request-URI Too Long"),
    UNSUPPORTED_MEDIA_TYPE(415, "Unsupported Media Type"),
    REQUESTED_RANGE_NOT_SATISFIABLE(http.Requested_Range_Not_Satisfiable, "Requested range not satisfiable"),
    EXPECTATION_FAILED(417, "Expectation Failed"),
    I_AM_A_TEAPOT(418, "I'm a teapot"),
    INSUFFICIENT_SPACE_ON_RESOURCE(419, "Insufficient Space On Resource"),
    METHOD_FAILURE(HttpResponseCode.ENHANCE_YOUR_CLAIM, "Method Failure"),
    DESTINATION_LOCKED(421, "Destination Locked"),
    UNPROCESSABLE_ENTITY(HttpResponseCode.UNPROCESSABLE_ENTITY, "Unprocessable Entity"),
    LOCKED(423, "Locked"),
    FAILED_DEPENDENCY(424, "Failed Dependency"),
    UPGRADE_REQUIRED(426, "Upgrade Required"),
    PRECONDITION_REQUIRED(428, "Precondition Required"),
    TOO_MANY_REQUESTS(HttpResponseCode.TOO_MANY_REQUESTS, "Too Many Requests"),
    REQUEST_HEADER_FIELDS_TOO_LARGE(431, "Request Header Fields Too Large"),
    INTERNAL_SERVER_ERROR(500, "Internal Server Error"),
    NOT_IMPLEMENTED(http.Not_Implemented, "Not Implemented"),
    BAD_GATEWAY(502, "Bad Gateway"),
    SERVICE_UNAVAILABLE(503, "Service Unavailable"),
    GATEWAY_TIMEOUT(504, "Gateway Timeout"),
    HTTP_VERSION_NOT_SUPPORTED(505, "HTTP Version not supported"),
    VARIANT_ALSO_NEGOTIATES(506, "Variant Also Negotiates"),
    INSUFFICIENT_STORAGE(507, "Insufficient Storage"),
    LOOP_DETECTED(508, "Loop Detected"),
    BANDWIDTH_LIMIT_EXCEEDED(509, "Bandwidth Limit Exceeded"),
    NOT_EXTENDED(510, "Not Extended"),
    NETWORK_AUTHENTICATION_REQUIRED(511, "Network Authentication Required");
    
    private final String reasonPhrase;
    private final int value;

    private a(int i, String str) {
        this.value = i;
        this.reasonPhrase = str;
    }

    public int value() {
        return this.value;
    }

    public String getReasonPhrase() {
        return this.reasonPhrase;
    }
}
