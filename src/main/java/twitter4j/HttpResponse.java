package twitter4j;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;
import twitter4j.conf.ConfigurationContext;

public abstract class HttpResponse {
    private static final Logger logger = Logger.getLogger(HttpResponseImpl.class);
    protected final HttpClientConfiguration CONF;
    protected InputStream is;
    private JSONObject json;
    private JSONArray jsonArray;
    protected String responseAsString;
    protected int statusCode;
    private boolean streamConsumed;

    public abstract void disconnect() throws IOException;

    public abstract String getResponseHeader(String str);

    public abstract Map<String, List<String>> getResponseHeaderFields();

    HttpResponse() {
        this.responseAsString = null;
        this.streamConsumed = false;
        this.json = null;
        this.jsonArray = null;
        this.CONF = ConfigurationContext.getInstance().getHttpClientConfiguration();
    }

    public HttpResponse(HttpClientConfiguration httpClientConfiguration) {
        this.responseAsString = null;
        this.streamConsumed = false;
        this.json = null;
        this.jsonArray = null;
        this.CONF = httpClientConfiguration;
    }

    public int getStatusCode() {
        return this.statusCode;
    }

    public InputStream asStream() {
        if (!this.streamConsumed) {
            return this.is;
        }
        throw new IllegalStateException("Stream has already been consumed.");
    }

    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x004c */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0075 A[SYNTHETIC, Splitter:B:41:0x0075] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x007c A[SYNTHETIC, Splitter:B:45:0x007c] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String asString() throws twitter4j.TwitterException {
        /*
            r6 = this;
            java.lang.String r0 = r6.responseAsString
            if (r0 != 0) goto L_0x0083
            r0 = 0
            java.io.InputStream r1 = r6.asStream()     // Catch:{ IOException -> 0x0064, all -> 0x005f }
            if (r1 != 0) goto L_0x0014
            if (r1 == 0) goto L_0x0010
            r1.close()     // Catch:{ IOException -> 0x0010 }
        L_0x0010:
            r6.disconnectForcibly()
            return r0
        L_0x0014:
            java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch:{ IOException -> 0x005a, all -> 0x0055 }
            java.io.InputStreamReader r3 = new java.io.InputStreamReader     // Catch:{ IOException -> 0x005a, all -> 0x0055 }
            java.lang.String r4 = "UTF-8"
            r3.<init>(r1, r4)     // Catch:{ IOException -> 0x005a, all -> 0x0055 }
            r2.<init>(r3)     // Catch:{ IOException -> 0x005a, all -> 0x0055 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0053 }
            r0.<init>()     // Catch:{ IOException -> 0x0053 }
        L_0x0025:
            java.lang.String r3 = r2.readLine()     // Catch:{ IOException -> 0x0053 }
            if (r3 == 0) goto L_0x0034
            r0.append(r3)     // Catch:{ IOException -> 0x0053 }
            java.lang.String r3 = "\n"
            r0.append(r3)     // Catch:{ IOException -> 0x0053 }
            goto L_0x0025
        L_0x0034:
            java.lang.String r0 = r0.toString()     // Catch:{ IOException -> 0x0053 }
            r6.responseAsString = r0     // Catch:{ IOException -> 0x0053 }
            twitter4j.Logger r0 = logger     // Catch:{ IOException -> 0x0053 }
            java.lang.String r3 = r6.responseAsString     // Catch:{ IOException -> 0x0053 }
            r0.debug(r3)     // Catch:{ IOException -> 0x0053 }
            r1.close()     // Catch:{ IOException -> 0x0053 }
            r0 = 1
            r6.streamConsumed = r0     // Catch:{ IOException -> 0x0053 }
            if (r1 == 0) goto L_0x004c
            r1.close()     // Catch:{ IOException -> 0x004c }
        L_0x004c:
            r2.close()     // Catch:{ IOException -> 0x004f }
        L_0x004f:
            r6.disconnectForcibly()
            goto L_0x0083
        L_0x0053:
            r0 = move-exception
            goto L_0x0068
        L_0x0055:
            r2 = move-exception
            r5 = r2
            r2 = r0
            r0 = r5
            goto L_0x0073
        L_0x005a:
            r2 = move-exception
            r5 = r2
            r2 = r0
            r0 = r5
            goto L_0x0068
        L_0x005f:
            r1 = move-exception
            r2 = r0
            r0 = r1
            r1 = r2
            goto L_0x0073
        L_0x0064:
            r1 = move-exception
            r2 = r0
            r0 = r1
            r1 = r2
        L_0x0068:
            twitter4j.TwitterException r3 = new twitter4j.TwitterException     // Catch:{ all -> 0x0072 }
            java.lang.String r4 = r0.getMessage()     // Catch:{ all -> 0x0072 }
            r3.<init>((java.lang.String) r4, (java.lang.Throwable) r0)     // Catch:{ all -> 0x0072 }
            throw r3     // Catch:{ all -> 0x0072 }
        L_0x0072:
            r0 = move-exception
        L_0x0073:
            if (r1 == 0) goto L_0x007a
            r1.close()     // Catch:{ IOException -> 0x0079 }
            goto L_0x007a
        L_0x0079:
        L_0x007a:
            if (r2 == 0) goto L_0x007f
            r2.close()     // Catch:{ IOException -> 0x007f }
        L_0x007f:
            r6.disconnectForcibly()
            throw r0
        L_0x0083:
            java.lang.String r0 = r6.responseAsString
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: twitter4j.HttpResponse.asString():java.lang.String");
    }

    public JSONObject asJSONObject() throws TwitterException {
        String str;
        if (this.json == null) {
            Reader reader = null;
            try {
                if (this.responseAsString == null) {
                    reader = asReader();
                    this.json = new JSONObject(new JSONTokener(reader));
                } else {
                    this.json = new JSONObject(this.responseAsString);
                }
                if (this.CONF.isPrettyDebugEnabled()) {
                    logger.debug(this.json.toString(1));
                } else {
                    Logger logger2 = logger;
                    if (this.responseAsString != null) {
                        str = this.responseAsString;
                    } else {
                        str = this.json.toString();
                    }
                    logger2.debug(str);
                }
                if (reader != null) {
                    try {
                        reader.close();
                    } catch (IOException unused) {
                    }
                }
                disconnectForcibly();
            } catch (JSONException e2) {
                if (this.responseAsString == null) {
                    throw new TwitterException(e2.getMessage(), (Throwable) e2);
                }
                throw new TwitterException(e2.getMessage() + ":" + this.responseAsString, (Throwable) e2);
            } catch (Throwable th) {
                if (reader != null) {
                    try {
                        reader.close();
                    } catch (IOException unused2) {
                    }
                }
                disconnectForcibly();
                throw th;
            }
        }
        return this.json;
    }

    public JSONArray asJSONArray() throws TwitterException {
        String str;
        if (this.jsonArray == null) {
            Reader reader = null;
            try {
                if (this.responseAsString == null) {
                    reader = asReader();
                    this.jsonArray = new JSONArray(new JSONTokener(reader));
                } else {
                    this.jsonArray = new JSONArray(this.responseAsString);
                }
                if (this.CONF.isPrettyDebugEnabled()) {
                    logger.debug(this.jsonArray.toString(1));
                } else {
                    Logger logger2 = logger;
                    if (this.responseAsString != null) {
                        str = this.responseAsString;
                    } else {
                        str = this.jsonArray.toString();
                    }
                    logger2.debug(str);
                }
                if (reader != null) {
                    try {
                        reader.close();
                    } catch (IOException unused) {
                    }
                }
                disconnectForcibly();
            } catch (JSONException e2) {
                if (logger.isDebugEnabled()) {
                    throw new TwitterException(e2.getMessage() + ":" + this.responseAsString, (Throwable) e2);
                }
                throw new TwitterException(e2.getMessage(), (Throwable) e2);
            } catch (Throwable th) {
                if (reader != null) {
                    try {
                        reader.close();
                    } catch (IOException unused2) {
                    }
                }
                disconnectForcibly();
                throw th;
            }
        }
        return this.jsonArray;
    }

    public Reader asReader() {
        try {
            return new BufferedReader(new InputStreamReader(this.is, "UTF-8"));
        } catch (UnsupportedEncodingException unused) {
            return new InputStreamReader(this.is);
        }
    }

    private void disconnectForcibly() {
        try {
            disconnect();
        } catch (Exception unused) {
        }
    }

    public String toString() {
        return "HttpResponse{statusCode=" + this.statusCode + ", responseAsString='" + this.responseAsString + '\'' + ", is=" + this.is + ", streamConsumed=" + this.streamConsumed + '}';
    }
}
