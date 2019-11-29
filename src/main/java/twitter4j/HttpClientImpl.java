package twitter4j;

import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import com.litesuits.orm.db.assit.SQLBuilder;
import com.tencent.qcloud.core.http.HttpConstants;
import java.io.IOException;
import java.io.Serializable;
import java.net.Authenticator;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.PasswordAuthentication;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;
import twitter4j.auth.Authorization;
import twitter4j.conf.ConfigurationContext;

class HttpClientImpl extends HttpClientBase implements Serializable, HttpResponseCode {
    private static final Map<HttpClientConfiguration, HttpClient> instanceMap = new HashMap(1);
    private static final Logger logger = Logger.getLogger(HttpClientImpl.class);
    private static final long serialVersionUID = -403500272719330534L;

    static {
        try {
            if (Integer.parseInt((String) Class.forName("android.os.Build$VERSION").getField("SDK").get((Object) null)) < 8) {
                System.setProperty("http.keepAlive", "false");
            }
        } catch (Exception unused) {
        }
    }

    public HttpClientImpl() {
        super(ConfigurationContext.getInstance().getHttpClientConfiguration());
    }

    public HttpClientImpl(HttpClientConfiguration httpClientConfiguration) {
        super(httpClientConfiguration);
    }

    public static HttpClient getInstance(HttpClientConfiguration httpClientConfiguration) {
        HttpClient httpClient = instanceMap.get(httpClientConfiguration);
        if (httpClient != null) {
            return httpClient;
        }
        HttpClientImpl httpClientImpl = new HttpClientImpl(httpClientConfiguration);
        instanceMap.put(httpClientConfiguration, httpClientImpl);
        return httpClientImpl;
    }

    public HttpResponse get(String str) throws TwitterException {
        return request(new HttpRequest(RequestMethod.GET, str, (HttpParameter[]) null, (Authorization) null, (Map<String, String>) null));
    }

    public HttpResponse post(String str, HttpParameter[] httpParameterArr) throws TwitterException {
        return request(new HttpRequest(RequestMethod.POST, str, httpParameterArr, (Authorization) null, (Map<String, String>) null));
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v1, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v2, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v21, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v23, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v24, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v25, resolved type: java.io.OutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v26, resolved type: java.io.OutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v28, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v29, resolved type: java.io.OutputStream} */
    /* JADX WARNING: type inference failed for: r4v11 */
    /* JADX WARNING: type inference failed for: r4v22 */
    /* JADX WARNING: Can't wrap try/catch for region: R(7:28|29|111|118|119|121|122) */
    /* JADX WARNING: Can't wrap try/catch for region: R(8:100|101|125|126|(1:129)|130|139|131) */
    /* JADX WARNING: Code restructure failed: missing block: B:120:0x02c3, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:123:0x02c6, code lost:
        r4 = r1.CONF.getHttpRetryCount();
        r4 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:124:0x02cc, code lost:
        if (r6 == r4) goto L_0x0310;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:132:?, code lost:
        r4 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:134:0x0319, code lost:
        throw new twitter4j.TwitterException(r0.getMessage(), r0, r8);
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:121:0x02c5 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:125:0x02ce */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public twitter4j.HttpResponse handleRequest(twitter4j.HttpRequest r20) throws twitter4j.TwitterException {
        /*
            r19 = this;
            r1 = r19
            twitter4j.HttpClientConfiguration r0 = r1.CONF
            int r0 = r0.getHttpRetryCount()
            r2 = 1
            int r3 = r0 + 1
            r6 = 0
            r7 = 0
        L_0x000d:
            if (r6 >= r3) goto L_0x031a
            java.lang.String r0 = r20.getURL()     // Catch:{ all -> 0x02b2 }
            java.net.HttpURLConnection r0 = r1.getConnection(r0)     // Catch:{ all -> 0x02b2 }
            r0.setDoInput(r2)     // Catch:{ all -> 0x02b2 }
            r9 = r20
            r1.setHeaders(r9, r0)     // Catch:{ all -> 0x02b0 }
            twitter4j.RequestMethod r10 = r20.getMethod()     // Catch:{ all -> 0x02b0 }
            java.lang.String r10 = r10.name()     // Catch:{ all -> 0x02b0 }
            r0.setRequestMethod(r10)     // Catch:{ all -> 0x02b0 }
            twitter4j.RequestMethod r10 = r20.getMethod()     // Catch:{ all -> 0x02b0 }
            twitter4j.RequestMethod r11 = twitter4j.RequestMethod.POST     // Catch:{ all -> 0x02b0 }
            if (r10 != r11) goto L_0x01ff
            twitter4j.HttpParameter[] r10 = r20.getParameters()     // Catch:{ all -> 0x02b0 }
            boolean r10 = twitter4j.HttpParameter.containsFile((twitter4j.HttpParameter[]) r10)     // Catch:{ all -> 0x02b0 }
            java.lang.String r11 = "UTF-8"
            java.lang.String r12 = "Content-Type"
            if (r10 == 0) goto L_0x01bf
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ all -> 0x01b4 }
            r10.<init>()     // Catch:{ all -> 0x01b4 }
            java.lang.String r13 = "----Twitter4J-upload"
            r10.append(r13)     // Catch:{ all -> 0x01b4 }
            long r13 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x01b4 }
            r10.append(r13)     // Catch:{ all -> 0x01b4 }
            java.lang.String r10 = r10.toString()     // Catch:{ all -> 0x01b4 }
            java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch:{ all -> 0x01b4 }
            r13.<init>()     // Catch:{ all -> 0x01b4 }
            java.lang.String r14 = "multipart/form-data; boundary="
            r13.append(r14)     // Catch:{ all -> 0x01b4 }
            r13.append(r10)     // Catch:{ all -> 0x01b4 }
            java.lang.String r13 = r13.toString()     // Catch:{ all -> 0x01b4 }
            r0.setRequestProperty(r12, r13)     // Catch:{ all -> 0x01b4 }
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ all -> 0x01b4 }
            r12.<init>()     // Catch:{ all -> 0x01b4 }
            java.lang.String r13 = "--"
            r12.append(r13)     // Catch:{ all -> 0x01b4 }
            r12.append(r10)     // Catch:{ all -> 0x01b4 }
            java.lang.String r10 = r12.toString()     // Catch:{ all -> 0x01b4 }
            r0.setDoOutput(r2)     // Catch:{ all -> 0x01b4 }
            java.io.OutputStream r12 = r0.getOutputStream()     // Catch:{ all -> 0x01b4 }
            java.io.DataOutputStream r13 = new java.io.DataOutputStream     // Catch:{ all -> 0x01a9 }
            r13.<init>(r12)     // Catch:{ all -> 0x01a9 }
            twitter4j.HttpParameter[] r14 = r20.getParameters()     // Catch:{ all -> 0x01a9 }
            int r15 = r14.length     // Catch:{ all -> 0x01a9 }
            r4 = 0
        L_0x008c:
            java.lang.String r2 = "\r\n"
            if (r4 >= r15) goto L_0x0188
            r16 = r14[r4]     // Catch:{ all -> 0x01a9 }
            boolean r17 = r16.isFile()     // Catch:{ all -> 0x01a9 }
            java.lang.String r5 = "\"\r\n"
            java.lang.String r8 = "Content-Disposition: form-data; name=\""
            if (r17 == 0) goto L_0x0134
            r17 = r3
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0131 }
            r3.<init>()     // Catch:{ all -> 0x0131 }
            r3.append(r10)     // Catch:{ all -> 0x0131 }
            r3.append(r2)     // Catch:{ all -> 0x0131 }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x0131 }
            r1.write(r13, r3)     // Catch:{ all -> 0x0131 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0131 }
            r3.<init>()     // Catch:{ all -> 0x0131 }
            r3.append(r8)     // Catch:{ all -> 0x0131 }
            java.lang.String r8 = r16.getName()     // Catch:{ all -> 0x0131 }
            r3.append(r8)     // Catch:{ all -> 0x0131 }
            java.lang.String r8 = "\"; filename=\""
            r3.append(r8)     // Catch:{ all -> 0x0131 }
            java.io.File r8 = r16.getFile()     // Catch:{ all -> 0x0131 }
            java.lang.String r8 = r8.getName()     // Catch:{ all -> 0x0131 }
            r3.append(r8)     // Catch:{ all -> 0x0131 }
            r3.append(r5)     // Catch:{ all -> 0x0131 }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x0131 }
            r1.write(r13, r3)     // Catch:{ all -> 0x0131 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0131 }
            r3.<init>()     // Catch:{ all -> 0x0131 }
            java.lang.String r5 = "Content-Type: "
            r3.append(r5)     // Catch:{ all -> 0x0131 }
            java.lang.String r5 = r16.getContentType()     // Catch:{ all -> 0x0131 }
            r3.append(r5)     // Catch:{ all -> 0x0131 }
            java.lang.String r5 = "\r\n\r\n"
            r3.append(r5)     // Catch:{ all -> 0x0131 }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x0131 }
            r1.write(r13, r3)     // Catch:{ all -> 0x0131 }
            java.io.BufferedInputStream r3 = new java.io.BufferedInputStream     // Catch:{ all -> 0x0131 }
            boolean r5 = r16.hasFileBody()     // Catch:{ all -> 0x0131 }
            if (r5 == 0) goto L_0x0109
            java.io.InputStream r5 = r16.getFileBody()     // Catch:{ all -> 0x0103 }
            goto L_0x0112
        L_0x0103:
            r0 = move-exception
            r2 = r7
            r3 = 1
            r7 = 0
            goto L_0x02ae
        L_0x0109:
            java.io.FileInputStream r5 = new java.io.FileInputStream     // Catch:{ all -> 0x0131 }
            java.io.File r8 = r16.getFile()     // Catch:{ all -> 0x0131 }
            r5.<init>(r8)     // Catch:{ all -> 0x0131 }
        L_0x0112:
            r3.<init>(r5)     // Catch:{ all -> 0x0131 }
            r5 = 1024(0x400, float:1.435E-42)
            byte[] r5 = new byte[r5]     // Catch:{ all -> 0x0131 }
        L_0x0119:
            int r8 = r3.read(r5)     // Catch:{ all -> 0x0131 }
            r18 = r7
            r7 = -1
            if (r8 == r7) goto L_0x0129
            r7 = 0
            r13.write(r5, r7, r8)     // Catch:{ all -> 0x01a7 }
            r7 = r18
            goto L_0x0119
        L_0x0129:
            r7 = 0
            r1.write(r13, r2)     // Catch:{ all -> 0x01a7 }
            r3.close()     // Catch:{ all -> 0x01a7 }
            goto L_0x0180
        L_0x0131:
            r0 = move-exception
            goto L_0x01ac
        L_0x0134:
            r17 = r3
            r18 = r7
            r7 = 0
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x01a7 }
            r3.<init>()     // Catch:{ all -> 0x01a7 }
            r3.append(r10)     // Catch:{ all -> 0x01a7 }
            r3.append(r2)     // Catch:{ all -> 0x01a7 }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x01a7 }
            r1.write(r13, r3)     // Catch:{ all -> 0x01a7 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x01a7 }
            r3.<init>()     // Catch:{ all -> 0x01a7 }
            r3.append(r8)     // Catch:{ all -> 0x01a7 }
            java.lang.String r8 = r16.getName()     // Catch:{ all -> 0x01a7 }
            r3.append(r8)     // Catch:{ all -> 0x01a7 }
            r3.append(r5)     // Catch:{ all -> 0x01a7 }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x01a7 }
            r1.write(r13, r3)     // Catch:{ all -> 0x01a7 }
            java.lang.String r3 = "Content-Type: text/plain; charset=UTF-8\r\n\r\n"
            r1.write(r13, r3)     // Catch:{ all -> 0x01a7 }
            twitter4j.Logger r3 = logger     // Catch:{ all -> 0x01a7 }
            java.lang.String r5 = r16.getValue()     // Catch:{ all -> 0x01a7 }
            r3.debug(r5)     // Catch:{ all -> 0x01a7 }
            java.lang.String r3 = r16.getValue()     // Catch:{ all -> 0x01a7 }
            byte[] r3 = r3.getBytes(r11)     // Catch:{ all -> 0x01a7 }
            r13.write(r3)     // Catch:{ all -> 0x01a7 }
            r1.write(r13, r2)     // Catch:{ all -> 0x01a7 }
        L_0x0180:
            int r4 = r4 + 1
            r3 = r17
            r7 = r18
            goto L_0x008c
        L_0x0188:
            r17 = r3
            r18 = r7
            r7 = 0
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x01a7 }
            r3.<init>()     // Catch:{ all -> 0x01a7 }
            r3.append(r10)     // Catch:{ all -> 0x01a7 }
            java.lang.String r4 = "--\r\n"
            r3.append(r4)     // Catch:{ all -> 0x01a7 }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x01a7 }
            r1.write(r13, r3)     // Catch:{ all -> 0x01a7 }
            r1.write(r13, r2)     // Catch:{ all -> 0x01a7 }
            r4 = r12
            r3 = 1
            goto L_0x01f1
        L_0x01a7:
            r0 = move-exception
            goto L_0x01af
        L_0x01a9:
            r0 = move-exception
            r17 = r3
        L_0x01ac:
            r18 = r7
            r7 = 0
        L_0x01af:
            r2 = r18
            r3 = 1
            goto L_0x02ae
        L_0x01b4:
            r0 = move-exception
            r17 = r3
            r18 = r7
            r7 = 0
            r2 = r18
            r3 = 1
            goto L_0x02bd
        L_0x01bf:
            r17 = r3
            r18 = r7
            r7 = 0
            java.lang.String r2 = "application/x-www-form-urlencoded"
            r0.setRequestProperty(r12, r2)     // Catch:{ all -> 0x01fb }
            twitter4j.HttpParameter[] r2 = r20.getParameters()     // Catch:{ all -> 0x01fb }
            java.lang.String r2 = twitter4j.HttpParameter.encodeParameters(r2)     // Catch:{ all -> 0x01fb }
            twitter4j.Logger r3 = logger     // Catch:{ all -> 0x01fb }
            java.lang.String r4 = "Post Params: "
            r3.debug(r4, r2)     // Catch:{ all -> 0x01fb }
            byte[] r2 = r2.getBytes(r11)     // Catch:{ all -> 0x01fb }
            java.lang.String r3 = "Content-Length"
            int r4 = r2.length     // Catch:{ all -> 0x01fb }
            java.lang.String r4 = java.lang.Integer.toString(r4)     // Catch:{ all -> 0x01fb }
            r0.setRequestProperty(r3, r4)     // Catch:{ all -> 0x01fb }
            r3 = 1
            r0.setDoOutput(r3)     // Catch:{ all -> 0x01f8 }
            java.io.OutputStream r4 = r0.getOutputStream()     // Catch:{ all -> 0x01f8 }
            r4.write(r2)     // Catch:{ all -> 0x02aa }
        L_0x01f1:
            r4.flush()     // Catch:{ all -> 0x02aa }
            r4.close()     // Catch:{ all -> 0x02aa }
            goto L_0x0206
        L_0x01f8:
            r0 = move-exception
            goto L_0x02bb
        L_0x01fb:
            r0 = move-exception
            r3 = 1
            goto L_0x02bb
        L_0x01ff:
            r17 = r3
            r18 = r7
            r3 = 1
            r7 = 0
            r4 = 0
        L_0x0206:
            twitter4j.HttpResponseImpl r2 = new twitter4j.HttpResponseImpl     // Catch:{ all -> 0x02aa }
            twitter4j.HttpClientConfiguration r5 = r1.CONF     // Catch:{ all -> 0x02aa }
            r2.<init>(r0, r5)     // Catch:{ all -> 0x02aa }
            int r8 = r0.getResponseCode()     // Catch:{ all -> 0x02a7 }
            twitter4j.Logger r5 = logger     // Catch:{ all -> 0x02a4 }
            boolean r5 = r5.isDebugEnabled()     // Catch:{ all -> 0x02a4 }
            if (r5 == 0) goto L_0x0270
            twitter4j.Logger r5 = logger     // Catch:{ all -> 0x02a4 }
            java.lang.String r10 = "Response: "
            r5.debug(r10)     // Catch:{ all -> 0x02a4 }
            java.util.Map r0 = r0.getHeaderFields()     // Catch:{ all -> 0x02a4 }
            java.util.Set r5 = r0.keySet()     // Catch:{ all -> 0x02a4 }
            java.util.Iterator r5 = r5.iterator()     // Catch:{ all -> 0x02a4 }
        L_0x022c:
            boolean r10 = r5.hasNext()     // Catch:{ all -> 0x02a4 }
            if (r10 == 0) goto L_0x0270
            java.lang.Object r10 = r5.next()     // Catch:{ all -> 0x02a4 }
            java.lang.String r10 = (java.lang.String) r10     // Catch:{ all -> 0x02a4 }
            java.lang.Object r11 = r0.get(r10)     // Catch:{ all -> 0x02a4 }
            java.util.List r11 = (java.util.List) r11     // Catch:{ all -> 0x02a4 }
            java.util.Iterator r11 = r11.iterator()     // Catch:{ all -> 0x02a4 }
        L_0x0242:
            boolean r12 = r11.hasNext()     // Catch:{ all -> 0x02a4 }
            if (r12 == 0) goto L_0x022c
            java.lang.Object r12 = r11.next()     // Catch:{ all -> 0x02a4 }
            java.lang.String r12 = (java.lang.String) r12     // Catch:{ all -> 0x02a4 }
            if (r10 == 0) goto L_0x026a
            twitter4j.Logger r13 = logger     // Catch:{ all -> 0x02a4 }
            java.lang.StringBuilder r14 = new java.lang.StringBuilder     // Catch:{ all -> 0x02a4 }
            r14.<init>()     // Catch:{ all -> 0x02a4 }
            r14.append(r10)     // Catch:{ all -> 0x02a4 }
            java.lang.String r15 = ": "
            r14.append(r15)     // Catch:{ all -> 0x02a4 }
            r14.append(r12)     // Catch:{ all -> 0x02a4 }
            java.lang.String r12 = r14.toString()     // Catch:{ all -> 0x02a4 }
            r13.debug(r12)     // Catch:{ all -> 0x02a4 }
            goto L_0x0242
        L_0x026a:
            twitter4j.Logger r13 = logger     // Catch:{ all -> 0x02a4 }
            r13.debug(r12)     // Catch:{ all -> 0x02a4 }
            goto L_0x0242
        L_0x0270:
            r0 = 200(0xc8, float:2.8E-43)
            if (r8 < r0) goto L_0x0282
            r0 = 302(0x12e, float:4.23E-43)
            if (r8 == r0) goto L_0x027d
            r0 = 300(0x12c, float:4.2E-43)
            if (r0 > r8) goto L_0x027d
            goto L_0x0282
        L_0x027d:
            r4.close()     // Catch:{ Exception -> 0x031e }
            goto L_0x031e
        L_0x0282:
            r0 = 420(0x1a4, float:5.89E-43)
            if (r8 == r0) goto L_0x029a
            r0 = 400(0x190, float:5.6E-43)
            if (r8 == r0) goto L_0x029a
            r0 = 500(0x1f4, float:7.0E-43)
            if (r8 < r0) goto L_0x029a
            twitter4j.HttpClientConfiguration r0 = r1.CONF     // Catch:{ all -> 0x02a4 }
            int r0 = r0.getHttpRetryCount()     // Catch:{ all -> 0x02a4 }
            if (r6 == r0) goto L_0x029a
            r4.close()     // Catch:{ Exception -> 0x02ce }
            goto L_0x02ce
        L_0x029a:
            twitter4j.TwitterException r0 = new twitter4j.TwitterException     // Catch:{ all -> 0x02a4 }
            java.lang.String r5 = r2.asString()     // Catch:{ all -> 0x02a4 }
            r0.<init>((java.lang.String) r5, (twitter4j.HttpResponse) r2)     // Catch:{ all -> 0x02a4 }
            throw r0     // Catch:{ all -> 0x02a4 }
        L_0x02a4:
            r0 = move-exception
            r12 = r4
            goto L_0x02bf
        L_0x02a7:
            r0 = move-exception
            r12 = r4
            goto L_0x02ae
        L_0x02aa:
            r0 = move-exception
            r12 = r4
            r2 = r18
        L_0x02ae:
            r8 = -1
            goto L_0x02bf
        L_0x02b0:
            r0 = move-exception
            goto L_0x02b5
        L_0x02b2:
            r0 = move-exception
            r9 = r20
        L_0x02b5:
            r17 = r3
            r18 = r7
            r3 = 1
            r7 = 0
        L_0x02bb:
            r2 = r18
        L_0x02bd:
            r8 = -1
            r12 = 0
        L_0x02bf:
            r12.close()     // Catch:{ Exception -> 0x02c5 }
            goto L_0x02c5
        L_0x02c3:
            r0 = move-exception
            goto L_0x02c6
        L_0x02c5:
            throw r0     // Catch:{ IOException -> 0x02c3 }
        L_0x02c6:
            twitter4j.HttpClientConfiguration r4 = r1.CONF
            int r4 = r4.getHttpRetryCount()
            if (r6 == r4) goto L_0x0310
        L_0x02ce:
            twitter4j.Logger r0 = logger     // Catch:{ InterruptedException -> 0x0308 }
            boolean r0 = r0.isDebugEnabled()     // Catch:{ InterruptedException -> 0x0308 }
            if (r0 == 0) goto L_0x02db
            if (r2 == 0) goto L_0x02db
            r2.asString()     // Catch:{ InterruptedException -> 0x0308 }
        L_0x02db:
            twitter4j.Logger r0 = logger     // Catch:{ InterruptedException -> 0x0308 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ InterruptedException -> 0x0308 }
            r4.<init>()     // Catch:{ InterruptedException -> 0x0308 }
            java.lang.String r5 = "Sleeping "
            r4.append(r5)     // Catch:{ InterruptedException -> 0x0308 }
            twitter4j.HttpClientConfiguration r5 = r1.CONF     // Catch:{ InterruptedException -> 0x0308 }
            int r5 = r5.getHttpRetryIntervalSeconds()     // Catch:{ InterruptedException -> 0x0308 }
            r4.append(r5)     // Catch:{ InterruptedException -> 0x0308 }
            java.lang.String r5 = " seconds until the next retry."
            r4.append(r5)     // Catch:{ InterruptedException -> 0x0308 }
            java.lang.String r4 = r4.toString()     // Catch:{ InterruptedException -> 0x0308 }
            r0.debug(r4)     // Catch:{ InterruptedException -> 0x0308 }
            twitter4j.HttpClientConfiguration r0 = r1.CONF     // Catch:{ InterruptedException -> 0x0308 }
            int r0 = r0.getHttpRetryIntervalSeconds()     // Catch:{ InterruptedException -> 0x0308 }
            int r0 = r0 * 1000
            long r4 = (long) r0     // Catch:{ InterruptedException -> 0x0308 }
            java.lang.Thread.sleep(r4)     // Catch:{ InterruptedException -> 0x0308 }
        L_0x0308:
            int r6 = r6 + 1
            r7 = r2
            r3 = r17
            r2 = 1
            goto L_0x000d
        L_0x0310:
            twitter4j.TwitterException r2 = new twitter4j.TwitterException
            java.lang.String r3 = r0.getMessage()
            r2.<init>(r3, r0, r8)
            throw r2
        L_0x031a:
            r18 = r7
            r2 = r18
        L_0x031e:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: twitter4j.HttpClientImpl.handleRequest(twitter4j.HttpRequest):twitter4j.HttpResponse");
    }

    private void setHeaders(HttpRequest httpRequest, HttpURLConnection httpURLConnection) {
        if (logger.isDebugEnabled()) {
            logger.debug("Request: ");
            Logger logger2 = logger;
            logger2.debug(httpRequest.getMethod().name() + SQLBuilder.BLANK, httpRequest.getURL());
        }
        if (httpRequest.getAuthorization() != null) {
            String authorizationHeader = httpRequest.getAuthorization().getAuthorizationHeader(httpRequest);
            if (authorizationHeader != null) {
                if (logger.isDebugEnabled()) {
                    logger.debug("Authorization: ", authorizationHeader.replaceAll(".", "*"));
                }
                httpURLConnection.addRequestProperty(HttpConstants.Header.AUTHORIZATION, authorizationHeader);
            }
        }
        if (httpRequest.getRequestHeaders() != null) {
            for (String next : httpRequest.getRequestHeaders().keySet()) {
                httpURLConnection.addRequestProperty(next, httpRequest.getRequestHeaders().get(next));
                Logger logger3 = logger;
                logger3.debug(next + ": " + httpRequest.getRequestHeaders().get(next));
            }
        }
    }

    /* access modifiers changed from: package-private */
    public HttpURLConnection getConnection(String str) throws IOException {
        HttpURLConnection httpURLConnection;
        if (isProxyConfigured()) {
            if (this.CONF.getHttpProxyUser() != null && !this.CONF.getHttpProxyUser().equals("")) {
                if (logger.isDebugEnabled()) {
                    Logger logger2 = logger;
                    logger2.debug("Proxy AuthUser: " + this.CONF.getHttpProxyUser());
                    Logger logger3 = logger;
                    logger3.debug("Proxy AuthPassword: " + this.CONF.getHttpProxyPassword().replaceAll(".", "*"));
                }
                Authenticator.setDefault(new Authenticator() {
                    /* access modifiers changed from: protected */
                    public PasswordAuthentication getPasswordAuthentication() {
                        if (getRequestorType().equals(Authenticator.RequestorType.PROXY)) {
                            return new PasswordAuthentication(HttpClientImpl.this.CONF.getHttpProxyUser(), HttpClientImpl.this.CONF.getHttpProxyPassword().toCharArray());
                        }
                        return null;
                    }
                });
            }
            Proxy proxy = new Proxy(Proxy.Type.HTTP, InetSocketAddress.createUnresolved(this.CONF.getHttpProxyHost(), this.CONF.getHttpProxyPort()));
            if (logger.isDebugEnabled()) {
                Logger logger4 = logger;
                logger4.debug("Opening proxied connection(" + this.CONF.getHttpProxyHost() + ":" + this.CONF.getHttpProxyPort() + SQLBuilder.PARENTHESES_RIGHT);
            }
            httpURLConnection = (HttpURLConnection) ((URLConnection) FirebasePerfUrlConnection.instrument(new URL(str).openConnection(proxy)));
        } else {
            httpURLConnection = (HttpURLConnection) ((URLConnection) FirebasePerfUrlConnection.instrument(new URL(str).openConnection()));
        }
        if (this.CONF.getHttpConnectionTimeout() > 0) {
            httpURLConnection.setConnectTimeout(this.CONF.getHttpConnectionTimeout());
        }
        if (this.CONF.getHttpReadTimeout() > 0) {
            httpURLConnection.setReadTimeout(this.CONF.getHttpReadTimeout());
        }
        httpURLConnection.setInstanceFollowRedirects(false);
        return httpURLConnection;
    }
}
