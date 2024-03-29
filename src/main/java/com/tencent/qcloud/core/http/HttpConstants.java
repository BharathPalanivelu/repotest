package com.tencent.qcloud.core.http;

public final class HttpConstants {

    public static final class ContentType {
        public static final String JSON = "application/json";
        public static final String MULTIPART_FORM_DATA = "multipart/form-data";
        public static final String TEXT_PLAIN = "text/plain";
        public static final String XML = "application/xml";
        public static final String X_WWW_FORM_URLENCODED = "application/x-www-form-urlencoded";
    }

    public static final class Header {
        public static final String AUTHORIZATION = "Authorization";
        public static final String CONNECTION = "Connection";
        public static final String CONTENT_LENGTH = "Content-Length";
        public static final String CONTENT_RANGE = "Content-Range";
        public static final String CONTENT_TYPE = "Content-Type";
        public static final String DATE = "Date";
        public static final String EXPECT = "Expect";
        public static final String HOST = "Host";
        public static final String MD5 = "Content-MD5";
        public static final String RANGE = "Range";
        public static final String TRANSFER_ENCODING = "Transfer-Encoding";
        public static final String USER_AGENT = "User-Agent";
    }

    public static final class RequestMethod {
        public static final String DELETE = "DELETE";
        public static final String GET = "GET";
        public static final String HEAD = "HEAD";
        public static final String OPTIONS = "OPTIONS";
        public static final String POST = "POST";
        public static final String PUT = "PUT";
        public static final String TRACE = "TRACE";
    }

    public static final class Scheme {
        public static final String HTTP = "http";
        public static final String HTTPS = "https";
    }
}
